package cn.navitool.managers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;

import cn.navitool.DebugLogger;
import com.ecarx.xui.adaptapi.car.base.ICarFunction;

public class PsdManager {
    private static final String TAG = "PsdManager";
    private static volatile PsdManager instance;
    private Context mContext;

    // Constants
    private static final int FUNC_PSD_SCREEN_SWITCH = 539495936;
    private static final int ZONE_ALL = 0x80000000;

    // Timing Constants
    // 9分59秒900毫秒 = 599900ms (Trigger Point)
    private static final long CYCLE_DURATION_MS = 10 * 60 * 1000;
    private static final long TRIGGER_OFFSET_MS = 9 * 60 * 1000 + 59 * 1000 + 900;
    
    // Burst Config: 200ms duration, 1ms interval
    private static final int BURST_COUNT = 200; 
    private static final int BURST_INTERVAL_MS = 1;

    // State
    private boolean mIsPsdAlwaysOnEnabled = false;
    private PowerManager.WakeLock mWakeLock;
    private long mLoopBaseTime = 0; // 0 means aligned to Boot Time

    // Handlers
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private Handler mWorkHandler; // For burst operations
    private HandlerThread mWorkThread;

    // Receiver
    private BroadcastReceiver mPsdTestReceiver;

    private PsdManager(Context context) {
        this.mContext = context.getApplicationContext();
        initWorkThread();
    }

    public static PsdManager getInstance(Context context) {
        if (instance == null) {
            synchronized (PsdManager.class) {
                if (instance == null) {
                    instance = new PsdManager(context);
                }
            }
        }
        return instance;
    }

    private void initWorkThread() {
        mWorkThread = new HandlerThread("PsdWorker");
        mWorkThread.start();
        mWorkHandler = new Handler(mWorkThread.getLooper());
    }

    public void init() {
        registerPsdTestReceiver();
        CarServiceManager.getInstance(mContext).registerListener(() -> {
            DebugLogger.i(TAG, "Car Service Ready. Fetching Initial PSD Status...");
            fetchInitialStatus();
            registerFunctionWatcher();
        });
    }

    private ICarFunction.IFunctionValueWatcher mFunctionWatcher;

    private void registerFunctionWatcher() {
        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        if (carFunc != null) {
            if (mFunctionWatcher == null) {
                mFunctionWatcher = new ICarFunction.IFunctionValueWatcher() {
                    @Override
                    public void onFunctionValueChanged(int functionId, int zone, int value) {
                        if (functionId == FUNC_PSD_SCREEN_SWITCH) {
                            DebugLogger.i(TAG, "PSD Switch Changed: " + value);
                            onPsdStatusChanged(value);
                        }
                    }

                    @Override
                    public void onCustomizeFunctionValueChanged(int functionId, int zone, float value) {
                    }

                    @Override
                    public void onSupportedFunctionStatusChanged(int functionId, int zone,
                            com.ecarx.xui.adaptapi.FunctionStatus status) {
                    }

                    @Override
                    public void onSupportedFunctionValueChanged(int functionId, int[] value) {
                    }

                    @Override
                    public void onFunctionChanged(int functionId) {
                    }
                };
            }
            carFunc.registerFunctionValueWatcher(new int[] { FUNC_PSD_SCREEN_SWITCH }, mFunctionWatcher);
        }
    }

    private void fetchInitialStatus() {
        new Thread(() -> {
            ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
            if (carFunc != null) {
                try {
                    int status = carFunc.getFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL);
                    if (status != -1) {
                        DebugLogger.i(TAG, "Initial PSD Status: " + status);
                        
                        // [NEW Logic] Loop Alignment
                        if (status == 0) {
                             // OFF -> Turn ON immediately and Record Time
                             DebugLogger.i(TAG, "Initial OFF detected. Turning ON and aligning loop to NOW.");
                             broadcastPsdStatus(status); // Broadcast the OFF state before fixing it
                             setPsdOn();
                             mLoopBaseTime = SystemClock.elapsedRealtime(); // Loop relative to NOW
                        } else {
                             // ON -> Align to Boot Time
                             DebugLogger.i(TAG, "Initial ON detected. Aligning loop to BOOT time.");
                             mLoopBaseTime = 0;
                        }

                        // Broadcast status is done above for OFF, or here for general log?
                        // Original logic did broadcastPsdStatus(status) unconditionally. 
                        // But now we might have changed it to ON.
                        // Let's keep original broadcast for logging/UI awareness of *initial* state.
                        if (status != 0) broadcastPsdStatus(status); 
                        
                        // Also trigger keep-alive logic check
                        if (mIsPsdAlwaysOnEnabled) {
                             // If enabled, we need to restart/reschedule the loop with new BaseTime
                             mWorkHandler.removeCallbacks(mMethod1Runnable);
                             scheduleMethod1Loop();
                        }
                    }
                } catch (Exception e) {
                    DebugLogger.e(TAG, "Error fetching initial PSD status", e);
                }
            }
        }).start();
    }

    public void destroy() {
        setEnabled(false);
        if (mFunctionWatcher != null) {
            ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
            if (carFunc != null) {
                try {
                    carFunc.unregisterFunctionValueWatcher(mFunctionWatcher);
                } catch (Exception e) {
                }
            }
            mFunctionWatcher = null;
        }
        if (mPsdTestReceiver != null) {
            try {
                mContext.unregisterReceiver(mPsdTestReceiver);
            } catch (Exception e) {
            }
            mPsdTestReceiver = null;
        }
        if (mWorkThread != null) {
            mWorkThread.quitSafely();
            mWorkThread = null;
        }
    }

    private boolean mIsMethod2Enabled = false;
    private static final long METHOD2_DELAY_MS = 3 * 60 * 1000;
    private static final long METHOD2_INTERVAL_MS = 3 * 60 * 1000;

    public void setEnabled(boolean enabled) {
        if (mIsPsdAlwaysOnEnabled == enabled)
            return;
        mIsPsdAlwaysOnEnabled = enabled;

        if (mIsPsdAlwaysOnEnabled) {
            DebugLogger.i(TAG, "PSD Always On (Method 1) Enabled");
            acquireWakeLock();

            // 1. Immediate ON
            setPsdOn();

            // 2. Schedule Loop (Method 1)
            scheduleMethod1Loop();
        } else {
            DebugLogger.i(TAG, "PSD Always On (Method 1) Disabled");
            if (!mIsMethod2Enabled)
                releaseWakeLock(); // Release only if Method 2 is also off

            // Remove Method 1 specific callbacks
            mWorkHandler.removeCallbacks(mMethod1Runnable);
            mWorkHandler.removeCallbacks(this::executeBurst);

            turnOffPsd();
        }
    }

    public void setEnabledMethod2(boolean enabled) {
        if (mIsMethod2Enabled == enabled)
            return;
        mIsMethod2Enabled = enabled;

        if (mIsMethod2Enabled) {
            DebugLogger.i(TAG, "PSD Always On (Method 2) Enabled");
            acquireWakeLock();
            // Start Loop
            scheduleMethod2Loop();
        } else {
            DebugLogger.i(TAG, "PSD Always On (Method 2) Disabled");
            if (!mIsPsdAlwaysOnEnabled)
                releaseWakeLock();
            mWorkHandler.removeCallbacks(mMethod2Runnable);
        }
    }

    private final Runnable mMethod2Runnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsMethod2Enabled)
                return;
            executeMethod2Toggle();
            mWorkHandler.postDelayed(this, METHOD2_INTERVAL_MS);
        }
    };

    private void scheduleMethod2Loop() {
        // "From the 3rd minute after startup"
        // If enabling now, should we wait 3 mins from NOW or from BOOT?
        // User said "Record startup time, from 3rd minute after startup".
        // KeepAliveAccessibilityService starts at boot.
        // So we can check uptime.
        long uptime = SystemClock.elapsedRealtime();
        long targetTime = METHOD2_DELAY_MS;
        long delay = 0;

        if (uptime < targetTime) {
            delay = targetTime - uptime;
        } else {
            // Already passed 3 mins. Start immediately? Or wait for next 3 min interval?
            // "From the 3rd minute... every 3 minutes"
            // If uptime is 10min, we are in the cycle.
            // Let's just start with a 3min delay relative to enabling if boot passed long
            // ago?
            // User: "Record startup time, from 3rd minute..."
            // If we enable it at 10min, maybe we should start immediately?
            // Let's align to boot time cycles if possible, or just delay `METHOD2_DELAY_MS`
            // if logic implies "wait 3 min".
            // Since User says "Record startup time", it implies strict boot-relative
            // timing.
            // But if we enable it late, strict boot timing might mean "execute effective
            // immediately".
            // Let's simply wait 3 minutes from Enable to be safe and consistent, OR check
            // boot time.
            // Prompt: "Record startup time... from 3rd minute... every 3 mins".
            // If uptime > 3min, the first trigger time has passed.
            // For safety and strict interpretation:
            // cycle = (uptime / 3min) -> next trigger = (cycle+1)*3min.
            long cycle = uptime / METHOD2_INTERVAL_MS;
            long nextTrigger = (cycle + 1) * METHOD2_INTERVAL_MS;
            delay = nextTrigger - uptime;
        }

        DebugLogger.i(TAG, "Method 2 Loop starting in " + delay + "ms");
        mWorkHandler.postDelayed(mMethod2Runnable, delay);
    }

    private void executeMethod2Toggle() {
        if (!mIsMethod2Enabled)
            return;
        DebugLogger.d(TAG, "Method 2: Toggling PSD...");

        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        if (carFunc == null)
            return;

        try {
            // OFF
            carFunc.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 0);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            // ON
            carFunc.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 1);
            DebugLogger.i(TAG, "Method 2: Toggle Complete (OFF->1ms->ON)");
        } catch (Exception e) {
            DebugLogger.e(TAG, "Method 2 Toggle Failed", e);
        }
    }



    private final Runnable mMethod1Runnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsPsdAlwaysOnEnabled)
                return;
            executeBurst();
            scheduleMethod1Loop(); // Re-schedule next loop
        }
    };

    private void scheduleMethod1Loop() {
        long now = SystemClock.elapsedRealtime();
        
        // Calculate relative time in the cycle
        long relativeTime = now - mLoopBaseTime;
        if (relativeTime < 0) relativeTime = 0; // Integrity check
        
        long currentCycleIndex = relativeTime / CYCLE_DURATION_MS;
        long cycleStartTime = mLoopBaseTime + currentCycleIndex * CYCLE_DURATION_MS;
        
        // The trigger point for THIS cycle
        long targetTimeInThisCycle = cycleStartTime + TRIGGER_OFFSET_MS;
        
        long delay;
        if (now < targetTimeInThisCycle) {
            // We are before the trigger in current cycle
            delay = targetTimeInThisCycle - now;
        } else {
            // We missed this cycle's trigger, aim for next cycle
            long nextCycleStartTime = mLoopBaseTime + (currentCycleIndex + 1) * CYCLE_DURATION_MS;
            delay = (nextCycleStartTime + TRIGGER_OFFSET_MS) - now;
        }

        DebugLogger.i(TAG, "Method 1 Loop: mLoopBaseTime=" + mLoopBaseTime + ", Next burst in " + delay + "ms (" + (delay / 1000) + "s)");
        
        mWorkHandler.removeCallbacks(mMethod1Runnable);
        mWorkHandler.postDelayed(mMethod1Runnable, delay);
    }

    public void onPsdStatusChanged(int value) {
        // User Request: "Update only when detecting OFF"
        if (value == 0) {
            broadcastPsdStatus(value);
        } else {
            DebugLogger.d(TAG, "PSD ON detected. Suppressing broadcast as per user request.");
        }

        if (mIsPsdAlwaysOnEnabled && value == 0) { // Screen turn OFF detected
            DebugLogger.w(TAG, "PSD OFF Detected! Reacting...");

            // 1. Record OFF Time & Immediate ON
            setPsdOn();
            
            // Note: Currently we do NOT reset the loop base time on random OFF events during the drive.
            // Requirement was only "On Startup query...".
            // So we stick to the initial base time.
            
            // Trigger an immediate burst (or scheduled burst) to ensure it stays ON?
            // Existing logic scheduled a burst. We can execute immediate burst here too to force it.
            // But if we just toggled it ON, maybe that's enough?
            // User did not specify behavior for subsequent OFF events, only "Loop" logic.
            // I will keep the immediate ON logic, but remove the separate delayed burst scheduling
            // because the main loop covers the keep-alive.
            
            // If the user *wants* to re-align loop on EVERY off, then I should update mLoopBaseTime here.
            // "如果为关，则发送1次开...然后记录发送开的这个时间作为循环开始时间" - This was in context of "当软件启动后".
            // So strictly speaking, only on startup.
        }
    }

    private void executeBurst() {
        if (!mIsPsdAlwaysOnEnabled)
            return;
        DebugLogger.i(TAG, ">>> EXECUTING BURST COMMANDS (100x) <<<");

        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        if (carFunc == null)
            return;

        for (int i = 0; i < BURST_COUNT; i++) {
            if (!mIsPsdAlwaysOnEnabled)
                break;
            try {
                carFunc.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 1);
                Thread.sleep(BURST_INTERVAL_MS);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Burst Error", e);
            }
        }
        DebugLogger.d(TAG, "Burst Completed");
    }

    private void setPsdOn() {
        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        if (carFunc != null) {
            try {
                carFunc.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 1);
                DebugLogger.i(TAG, "Set PSD ON (Command Sent)");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to set PSD ON", e);
            }
        } else {
            DebugLogger.w(TAG, "CarFunction not ready, cannot set PSD ON");
        }
    }

    private void turnOffPsd() {
        ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
        if (carFunc != null) {
            try {
                carFunc.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 0);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to turn off PSD", e);
            }
        }
    }

    private void broadcastPsdStatus(int status) {
        Intent intent = new Intent("cn.navitool.ACTION_PSD_STATUS");
        intent.putExtra("status", status);
        intent.putExtra("timestamp", System.currentTimeMillis());
        mContext.sendBroadcast(intent);
    }

    private void acquireWakeLock() {
        if (mWakeLock == null) {
            PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
            if (pm != null) {
                mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "NaviTool:PSDKeeper");
                mWakeLock.setReferenceCounted(false);
            }
        }
        if (mWakeLock != null && !mWakeLock.isHeld()) {
            try {
                mWakeLock.acquire();
                DebugLogger.i(TAG, "WakeLock acquired");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error acquiring WakeLock", e);
            }
        }
    }

    private void releaseWakeLock() {
        if (mWakeLock != null && mWakeLock.isHeld()) {
            try {
                mWakeLock.release();
                DebugLogger.i(TAG, "WakeLock released");
            } catch (Exception e) {
                DebugLogger.e(TAG, "Error releasing WakeLock", e);
            }
        }
    }

    private void registerPsdTestReceiver() {
        mPsdTestReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if ("cn.navitool.ACTION_TEST_PSD_SWITCH".equals(intent.getAction())) {
                    int delayMs = intent.getIntExtra("delay", 0);
                    DebugLogger.w(TAG, "TEST: Executing PSD Switch Test");

                    ICarFunction carFunc = CarServiceManager.getInstance(mContext).getCarFunction();
                    try {
                        if (carFunc != null)
                            carFunc.setFunctionValue(FUNC_PSD_SCREEN_SWITCH, ZONE_ALL, 0);
                    } catch (Exception e) {
                    }

                    if (delayMs > 0) {
                        try {
                            Thread.sleep(delayMs);
                        } catch (Exception e) {
                        }
                    }
                    setPsdOn();
                    DebugLogger.d(TAG, "TEST: PSD Switch Test Completed.");
                }
            }
        };
        IntentFilter filter = new IntentFilter("cn.navitool.ACTION_TEST_PSD_SWITCH");
        mContext.registerReceiver(mPsdTestReceiver, filter);
    }
}
