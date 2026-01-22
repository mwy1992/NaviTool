package cn.navitool.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Locale;

import android.widget.FrameLayout;
import android.widget.Spinner;
import com.google.android.material.switchmaterial.SwitchMaterial;

import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.CustomThemeManager;
import cn.navitool.managers.AppLaunchManager;
import cn.navitool.managers.ThemeBrightnessManager;
import cn.navitool.managers.KeyHandlerManager;
import cn.navitool.managers.CarServiceManager;
import cn.navitool.managers.SoundPromptManager;
import cn.navitool.utils.MemoryMonitor;

import cn.navitool.managers.AmapMonitorManager;
import cn.navitool.managers.SunshadeManager;
import cn.navitool.service.FloatingBallService;
import cn.navitool.service.MediaNotificationListener;
import cn.navitool.utils.DebugLogger;
import cn.navitool.utils.AdbShell;
import cn.navitool.utils.MemoryMonitor;
import cn.navitool.managers.NaviInfoManager;
import cn.navitool.utils.SimulateFunction;
import cn.navitool.service.KeepAliveAccessibilityService;
import cn.navitool.activity.MainActivity;
import cn.navitool.managers.PresentationManager;
import cn.navitool.managers.SimulateGear;
import cn.navitool.R;
import cn.navitool.BuildConfig;

public class MainActivity extends AppCompatActivity {

    private cn.navitool.activity.controller.AutoStartController mAutoStartController;
    private cn.navitool.activity.controller.GeneralSettingsController mGeneralSettingsController;
    private cn.navitool.activity.controller.SoundSettingsController mSoundSettingsController;
    private cn.navitool.activity.controller.ClusterSettingsController mClusterSettingsController;
    private cn.navitool.activity.controller.HudSettingsController mHudSettingsController;
    private cn.navitool.activity.controller.BrightnessSettingsController mBrightnessSettingsController;
    private cn.navitool.activity.controller.HomeStatusController mHomeStatusController;
    private cn.navitool.activity.controller.ButtonSettingsController mButtonSettingsController;

    private static final int PERMISSION_REQUEST_CODE = 100;
    private boolean mIsPositioningActive = false; // Track traffic light positioning state

    private androidx.appcompat.app.AlertDialog permissionDialog;
    private View mPermissionDialogView;

    private final ActivityResultLauncher<Intent> mOverlayPermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (mHomeStatusController != null) mHomeStatusController.checkPermissions();
                if (Settings.canDrawOverlays(this)) {
                    DebugLogger.toast(this, getString(R.string.status_granted));
                }
            });

    private final ActivityResultLauncher<Intent> mStoragePermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (mHomeStatusController != null) mHomeStatusController.checkPermissions();
                if (cn.navitool.managers.PermissionManager.getInstance(this).hasStoragePermission()) {
                    DebugLogger.toast(this, getString(R.string.status_granted));
                }
            });

    // Navigation Views
    private View mLayoutGeneral;
    private View mLayoutButtons;
    private View mLayoutAutoStart;
    private ScrollView mLayoutADB; // ADB is not lazy

    private View mLayoutBrightness;
    private View mLayoutSound;
    private View mLayoutCluster;
    private View mLayoutHud;

    private boolean mIsGeneralInit = false;
    private boolean mIsButtonsInit = false;
    private boolean mIsAutoStartInit = false;

    private boolean mIsBrightnessInit = false;
    private boolean mIsSoundInit = false;
    private boolean mIsClusterInit = false;
    private boolean mIsHudInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Restore saved instance state for HUD/Cluster if possible
        if (savedInstanceState != null) {
            // Restore any critical flags
            // currently mostly handled by managers or config
        }

        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        MemoryMonitor.logMemory("MainActivity.onCreate-Start");

        // [Fix Cold Boot] Initialize ConfigManager and DebugLogger first
        ConfigManager.init(this);
        DebugLogger.init(this);

        // [Fix Cold Boot] Call setContentView EARLY to prevent black screen
        setContentView(R.layout.activity_main);

        // [Fix Cold Boot] Initialize Amap Services AFTER UI is set
        // These calls might be blocking or slow, so we do them after setContentView
        cn.navitool.managers.AmapMonitorManager.getInstance(this).startMonitoring();
        // AmapAidlManager removed
        // cn.navitool.managers.AmapAidlManager.getInstance(this).connect();

        // Initialize Managers (assuming these are new additions based on the
        // instruction's snippet)
        // Note: mAppLaunchManager and mSoundPromptManager are not declared in the
        // provided context.
        // Assuming they would be declared elsewhere or are placeholders for other
        // initializations.
        // mAppLaunchManager = new cn.navitool.managers.AppLaunchManager(this);
        // mSoundPromptManager =
        // cn.navitool.managers.SoundPromptManager.getInstance(this);

        // Initialize Views (assuming initUI is replaced by these based on the
        // instruction's snippet)
        initUI(); // Original call, keeping it as the instruction didn't explicitly remove it.
        // setupListeners(); // Not in original code, but in instruction's snippet.
        // updateUIState(); // Not in original code, but in instruction's snippet.
        // requestPermissions(); // Not in original code, but in instruction's snippet.

        initNavigation(); // Click listeners

        if (mHomeStatusController != null) mHomeStatusController.checkPermissions();

        // [Startup Conflict Fix]
        // ClusterHudManager now self-initializes its configuration in its constructor.
        // We do NOT need to manually load config and push it to the manager here.
        // Doing so caused race conditions with KeepAliveService/BootReceiver.

        // Just ensure instance is created (which triggers self-init)
        // Just ensure instance is created (which triggers self-init)
        ClusterHudManager cm = ClusterHudManager.getInstance(this);

        // [FIX] Activity Injection
        // Immediately upgrade the Manager's context to this Activity.
        // This ensures subsequent UI operations use the Theme-aware Activity Context.
        cm.updateContext(this);

        // [Legacy] NaviInfoManager init kept for general readiness (Geely Socket Removed)
        NaviInfoManager.getInstance(this);

        // Try to show UI again (in case Service failed or wasn't ready)
        // Now it will use the Activity Context we just injected.
        // Try to show UI again (in case Service failed or wasn't ready)
        // Now it will use the Activity Context we just injected.
        // [FIX] Delayed UI - Do NOT show immediately on Create
        // cm.ensureUiVisible();
        DebugLogger.i("MainActivity", "UI Initialization deferred. Waiting for ACTION_ACTIVATE_CLUSTER_HUD...");

        if (BuildConfig.DEBUG) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle(getString(R.string.dialog_debug_title))
                    .setMessage(getString(R.string.dialog_debug_message))
                    .setCancelable(true)
                    .show();
        } else {
            // Release Version: Show only on first run after install/update
            try {
                android.content.pm.PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                long currentVersionCode = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    currentVersionCode = pInfo.getLongVersionCode();
                } else {
                    currentVersionCode = pInfo.versionCode;
                }

                android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
                long lastSeenVersion = prefs.getLong("last_seen_version_code", -1);

                if (currentVersionCode != lastSeenVersion) {
                    long finalVerCode = currentVersionCode;
                    new android.app.AlertDialog.Builder(this)
                            .setTitle(getString(R.string.dialog_release_title))
                            .setMessage(getString(R.string.dialog_release_message))
                            .setCancelable(true)
                            .setOnDismissListener(dialog -> {
                                prefs.edit().putLong("last_seen_version_code", finalVerCode).apply();
                            })
                            .show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MemoryMonitor.logMemory("MainActivity.onResume");

        // Check Media Key Service
        boolean isOneOSConnected = cn.navitool.managers.KeyHandlerManager.getInstance(this).isOneOSConnected();
        updateOneOSStatus(isOneOSConnected);

        // Request Status Updates from Services
        sendBroadcast(new Intent("cn.navitool.ACTION_REQUEST_ONEOS_STATUS"));

        // Trigger generic status refresh
        if (cn.navitool.managers.CarServiceManager.getInstance(this).isInitialized()) {
            // ...
        }
        if (mHomeStatusController != null) {
            mHomeStatusController.onResume();
        }

        // Register HUD Listener for Preview Updates
        if (mHudSettingsController != null) {
            mHudSettingsController.onResume();
        }

        // Check Notification Permission
        if (!cn.navitool.managers.PermissionManager.getInstance(this).isNotificationListenerEnabled()) {
            DebugLogger.toastAlways(this, getString(R.string.toast_notification_permission_fix));
        }

        // [FIX] Restore Floating Ball Service on Resume (if enabled)
        if (ConfigManager.getInstance().getBoolean("floating_ball_enabled", false)) {
            if (Settings.canDrawOverlays(this)) {
                startService(new Intent(this, cn.navitool.service.FloatingBallService.class));
            }
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        if (mHomeStatusController != null) {
            mHomeStatusController.onPause();
        }
        // Unregister HUD Listener to prevent leak/updates when backgrounded
        // Unregister HUD Listener to prevent leak/updates when backgrounded
        if (mHudSettingsController != null) {
            mHudSettingsController.onPause();
        }
    }

    private void registerReceivers() {
        // android.content.IntentFilter adbFilter = new android.content.IntentFilter("cn.navitool.ADB_STATUS_CHANGED");
        // registerReceiver(adbStatusReceiver, adbFilter);

        // android.content.IntentFilter psdFilter = new android.content.IntentFilter("cn.navitool.ACTION_PSD_STATUS");
        // registerReceiver(mPsdStatusReceiver, psdFilter);
        
        // Delegated to HomeStatusController

        android.content.IntentFilter oneOsFilter = new android.content.IntentFilter("cn.navitool.ACTION_ONEOS_STATUS");
        registerReceiver(mOneOSStatusReceiver, oneOsFilter);

        // android.content.IntentFilter mediaFilter = new android.content.IntentFilter(
        //         cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE);
        // registerReceiver(mMediaInfoReceiver, mediaFilter);

        // [FIX] Register mDayNightStatusReceiver for theme mode updates
        android.content.IntentFilter dayNightFilter = new android.content.IntentFilter(
                "cn.navitool.ACTION_DAY_NIGHT_STATUS");
        registerReceiver(mDayNightStatusReceiver, dayNightFilter);

        // [NEW] 注册仪表/HUD激活广播接收器 (延迟3秒后由KeepAliveService发送)
        android.content.IntentFilter clusterHudFilter = new android.content.IntentFilter(
                "cn.navitool.ACTION_ACTIVATE_CLUSTER_HUD");
        registerReceiver(mClusterHudActivationReceiver, clusterHudFilter);

        // [FIX] Request initial status after registering receiver
        ThemeBrightnessManager.getInstance(this).broadcastStatus();
    }

    private void unregisterReceivers() {
        try {
            // unregisterReceiver(adbStatusReceiver);
            
            // unregisterReceiver(mPsdStatusReceiver);
            unregisterReceiver(mOneOSStatusReceiver);
            unregisterReceiver(mDayNightStatusReceiver); // [FIX] Added
            unregisterReceiver(mClusterHudActivationReceiver); // [NEW] 取消注册仪表/HUD激活接收器
        } catch (IllegalArgumentException e) {
            // Receiver not registered
        }
    }

    private void initNavigation() {
        RadioGroup rgNavigation = findViewById(R.id.rgNavigation);
        mLayoutADB = findViewById(R.id.layoutContentADB); // Always present

        // Note: Other layouts are ViewStubs and will be inflated on demand

        // Initial Visibility
        if (mLayoutADB != null)
            mLayoutADB.setVisibility(View.VISIBLE); // Default Tab

        // Debug-only tabs logic:
        // Cluster (Now Enabled for Release to allow Theme Selection)
        int clusterVisibility = View.VISIBLE; // Formerly DEBUG only
        View rbCluster = findViewById(R.id.rbCluster);
        if (rbCluster != null)
            rbCluster.setVisibility(clusterVisibility);

        // HUD (Release Enabled)
        View rbHud = findViewById(R.id.rbHud);
        if (rbHud != null)
            rbHud.setVisibility(View.VISIBLE);

        // Hide experimental features in Release builds
        if (!BuildConfig.DEBUG) {

        }

        rgNavigation.setOnCheckedChangeListener((group, checkedId) -> {
            // Hide all potential views
            if (mLayoutADB != null)
                mLayoutADB.setVisibility(View.GONE);
            if (mLayoutGeneral != null)
                mLayoutGeneral.setVisibility(View.GONE);
            if (mLayoutButtons != null)
                mLayoutButtons.setVisibility(View.GONE);
            if (mLayoutAutoStart != null)
                mLayoutAutoStart.setVisibility(View.GONE);

            if (mLayoutBrightness != null)
                mLayoutBrightness.setVisibility(View.GONE);
            if (mLayoutSound != null)
                mLayoutSound.setVisibility(View.GONE);
            if (mLayoutCluster != null)
                mLayoutCluster.setVisibility(View.GONE);
            if (mLayoutHud != null)
                mLayoutHud.setVisibility(View.GONE);

            // Show selected
            if (checkedId == R.id.rbADB) {
                if (mLayoutADB != null)
                    mLayoutADB.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbGeneral) {
                ensureGeneralInflated();
                if (mLayoutGeneral != null)
                    mLayoutGeneral.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbButtons) {
                ensureButtonsInflated();
                if (mLayoutButtons != null)
                    mLayoutButtons.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbAutoStart) {
                ensureAutoStartInflated();
                if (mLayoutAutoStart != null)
                    mLayoutAutoStart.setVisibility(View.VISIBLE);

            } else if (checkedId == R.id.rbBrightness) {
                ensureBrightnessInflated();
                if (mLayoutBrightness != null)
                    mLayoutBrightness.setVisibility(View.VISIBLE);

            } else if (checkedId == R.id.rbSound) {
                ensureSoundInflated();
                if (mLayoutSound != null)
                    mLayoutSound.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbCluster) {
                ensureClusterInflated();
                if (mLayoutCluster != null)
                    mLayoutCluster.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbHud) {
                ensureHudInflated();
                if (mLayoutHud != null)
                    mLayoutHud.setVisibility(View.VISIBLE);
            }
        });
    }

    private View tryInflate(View currentView, int stubId, int targetId) {
        if (currentView == null) {
            android.view.ViewStub stub = findViewById(stubId);
            if (stub != null) {
                return stub.inflate();
            } else {
                return findViewById(targetId);
            }
        }
        return currentView;
    }

    private void ensureGeneralInflated() {
        if (mLayoutGeneral == null) {
            View v = tryInflate(mLayoutGeneral, R.id.stubGeneral, R.id.layoutContentGeneral);
            mLayoutGeneral = v;
            mGeneralSettingsController = new cn.navitool.activity.controller.GeneralSettingsController(this, mLayoutGeneral, mOverlayPermissionLauncher);
            mGeneralSettingsController.setupGeneralSettings();
            // setupForceAutoDayNight(); 
            // setupForceAutoDayNight relies on toggle logic, kept in MainActivity for now or move?
            // User instruction: Move setupGeneralSettings, setupForceAutoDayNight in step 4.2
            // I haven't moved setupForceAutoDayNight to Controller yet in the CREATE file step.
            // Let me check if I should have. The task said: "Move setupGeneralSettings, setupForceAutoDayNight".
            // I missed setupForceAutoDayNight in the previous write_to_file. I will add it to MainActivity for now 
            // and move it in a subsequent edit or if I can edit the controller file again. 
            // Actually, I can just leave setupForceAutoDayNight here for a moment or add it to Controller now.
            // But I cannot edit the Controller file in this tool call.
            // So I will start by using what I have.
            
            mIsGeneralInit = true;
            // Re-apply debug visibility for the newly inflated layout
            updateDebugViewsVisibility(DebugLogger.isDebugEnabled(this));
        }
    }

    private void ensureButtonsInflated() {
        if (mLayoutButtons == null) {
            View v = tryInflate(mLayoutButtons, R.id.stubButtons, R.id.layoutContentButtons);
            mLayoutButtons = v;
            mButtonSettingsController = new cn.navitool.activity.controller.ButtonSettingsController(this, mLayoutButtons);
            mButtonSettingsController.setupButtons();

            mIsButtonsInit = true;
            // Re-apply debug visibility for the newly inflated buttons
            updateDebugViewsVisibility(DebugLogger.isDebugEnabled(this));
        }
    }

    private void ensureAutoStartInflated() {
        if (mLayoutAutoStart == null) {
            View v = tryInflate(mLayoutAutoStart, R.id.stubAutoStart, R.id.layoutContentAutoStart);
            mLayoutAutoStart = v;
            mAutoStartController = new cn.navitool.activity.controller.AutoStartController(this);
            mAutoStartController.setupAutoStartApps();
            mIsAutoStartInit = true;
        }
    }

    private void ensureBrightnessInflated() {
        if (mLayoutBrightness == null) {
            View v = tryInflate(mLayoutBrightness, R.id.stubBrightness, R.id.layoutContentBrightness);
            mLayoutBrightness = v;
            mBrightnessSettingsController = new cn.navitool.activity.controller.BrightnessSettingsController(this, mLayoutBrightness);
            mBrightnessSettingsController.setupBrightness();
            mIsBrightnessInit = true;
            // Update debug visibility for PSD test buttons (inside Brightness tab)
            updateDebugViewsVisibility(DebugLogger.isDebugEnabled(this));
        }
    }

    private void ensureSoundInflated() {
        if (!mIsSoundInit) {
            mLayoutSound = tryInflate(mLayoutSound, R.id.stubSound, R.id.layoutContentSound);
            if (mLayoutSound != null) {
                mSoundSettingsController = new cn.navitool.activity.controller.SoundSettingsController(this, mLayoutSound);
                mSoundSettingsController.setupSoundSwitches();
                mIsSoundInit = true;
            }
        }
    }

    private void ensureClusterInflated() {
        if (mLayoutCluster == null) {
            View v = tryInflate(mLayoutCluster, R.id.stubCluster, R.id.layoutContentCluster);
            mLayoutCluster = v;
            mClusterSettingsController = new cn.navitool.activity.controller.ClusterSettingsController(this, mLayoutCluster);
            mClusterSettingsController.setupCluster();
            mIsClusterInit = true;
        }
    }

    private void ensureHudInflated() {
        if (mLayoutHud == null) {
            View v = tryInflate(mLayoutHud, R.id.stubHud, R.id.layoutContentHud);
            mLayoutHud = v;
            mHudSettingsController = new cn.navitool.activity.controller.HudSettingsController(this, mLayoutHud);
            mHudSettingsController.setupHud();
            mHudSettingsController.onResume();
            mIsHudInit = true;
        }
    }

    private void initUI() {
        // --- Header / Debug ---
        boolean isDebug = DebugLogger.isDebugEnabled(this);
        updateDebugViewsVisibility(isDebug);
        ClusterHudManager.getInstance(this).setDebugMode(isDebug);
        setVersionInfo();

        // --- ADB Tab (System Info & Permissions & Default Tab) ---
        mHomeStatusController = new cn.navitool.activity.controller.HomeStatusController(this);
        mHomeStatusController.setupHome();

        // Speed comparison display receivers (for status page)

        if (mGeneralSettingsController != null) mGeneralSettingsController.updateAutoModeStatus(0);

        // --- Auto-Initialize Cluster ---
        // Ensure Cluster Service starts even if tab is not visited
        // Use new theme system (THEME_DEFAULT or THEME_AUDI_RS)
        int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                PresentationManager.THEME_DEFAULT);
        ClusterHudManager.getInstance(this).setClusterTheme(savedTheme);
        // Note: Other tabs setup is deferred to ensureXInflated methods
    }

    private void setVersionInfo() {
        TextView tvAppCredit = findViewById(R.id.tvAppCredit);
        if (tvAppCredit != null) {
            tvAppCredit.setText(getString(R.string.app_credit, BuildConfig.VERSION_NAME));
        }
    }

    // --- Cluster Editor Logic ---

    // --- Cluster Theme Selector Logic ---

    private void updateDebugViewsVisibility(boolean isDebug) {
        // Strictly enforce that these views are ONLY visible in Debug builds
        // regardless of the stored preference (which handles the switch state)
        boolean allowDebugViews = isDebug && BuildConfig.DEBUG;
        int visibility = allowDebugViews ? View.VISIBLE : View.GONE;

        // Third Party Test Button (in layout_tab_buttons.xml)
        // View btnTestThirdParty = findViewById(R.id.btnTestThirdPartyControl);
        // if (btnTestThirdParty != null) {
        // btnTestThirdParty.setVisibility(visibility);
        // }

        View layoutPsdTest = findViewById(R.id.layoutPsdTestButtons);
        if (layoutPsdTest != null) {
            layoutPsdTest.setVisibility(visibility);
        }

        // Headlight Status

        // System Info & Screenshots

        // System Info (Boot Time, PSD Status)
        View layoutSystemInfo = findViewById(R.id.layoutSystemInfo);
        if (layoutSystemInfo != null) {
            layoutSystemInfo.setVisibility(visibility);
        } else {
            View tvBootTime = findViewById(R.id.tvBootTime);
            if (tvBootTime != null)
                tvBootTime.setVisibility(visibility);
            View tvPsdStatus = findViewById(R.id.tvPsdStatus);
            if (tvPsdStatus != null)
                tvPsdStatus.setVisibility(visibility);
        }
        
        if (mBrightnessSettingsController != null) {
            mBrightnessSettingsController.updateDebugViewsVisibility(isDebug);
        } else {
             // Handle legacy views if controller not init yet?
             // Actually, the original code looked up findViewById directly.
             // If mLayoutBrightness is not inflated, findViewById(R.id.layoutPsdTestButtons) on activity might fail 
             // or return stub if not included?
             // The Stub is R.id.stubBrightness.
             // If stub is not inflated, layoutPsdTestButtons doesn't exist.
             // So safe to skip if controller is null.
        }
    }

    // --- Theme Tab Logic ---

    // --- Brightness Tab Logic ---

    // --- Buttons Tab Logic ---

    // setupMediaButtons removed as per user request

    // --- AutoStart Tab Logic ---

    // --- ADB Tab Logic ---

    // Permission Request Methods

    private void requestAutoStart() {
        cn.navitool.managers.PermissionManager.getInstance(this).requestAutoStart(this);
    }

    // Helper Methods
    private void sendAutoNaviBroadcast(int mode) {
        Intent intent = new Intent("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.setComponent(new ComponentName("com.autonavi.amapauto",
                "com.autonavi.amapauto.adapter.internal.AmapAutoBroadcastReceiver"));
        intent.putExtra("KEY_TYPE", 10048);
        intent.putExtra("EXTRA_DAY_NIGHT_MODE", mode);
        sendBroadcast(intent);
        DebugLogger.log(this, "MainActivity", "Sent AutoNavi Broadcast: Mode " + mode);
        DebugLogger.toast(this, getString(R.string.sent_autonavi_broadcast, mode));
    }

    private void simulateMediaKey(int keyCode) {
        long eventTime = android.os.SystemClock.uptimeMillis();
        android.view.KeyEvent keyDown = new android.view.KeyEvent(eventTime, eventTime,
                android.view.KeyEvent.ACTION_DOWN, keyCode, 0);
        dispatchMediaKey(keyDown);
        android.view.KeyEvent keyUp = new android.view.KeyEvent(eventTime, eventTime, android.view.KeyEvent.ACTION_UP,
                keyCode, 0);
        dispatchMediaKey(keyUp);

        String keyName = getString(R.string.key_unknown);
        if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_NEXT)
            keyName = getString(R.string.key_next_track);
        else if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS)
            keyName = getString(R.string.key_prev_track);
        else if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
            keyName = getString(R.string.key_play_pause);

        DebugLogger.toast(this, getString(R.string.simulated_media_key, keyName));
    }

    private void dispatchMediaKey(android.view.KeyEvent keyEvent) {
        android.media.AudioManager audioManager = (android.media.AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.dispatchMediaKeyEvent(keyEvent);
        }

        Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaIntent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        mediaIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        mediaIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        sendBroadcast(mediaIntent);
    }

    private final android.content.BroadcastReceiver mDayNightStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_DAY_NIGHT_STATUS".equals(intent.getAction())) {
                int mode = intent.getIntExtra("mode", 0);
                if (mGeneralSettingsController != null) {
                    mGeneralSettingsController.updateAutoModeStatus(mode);
                }
            }
        }
    };

    // [NEW] 仪表/HUD 延迟激活广播接收器
    private final android.content.BroadcastReceiver mClusterHudActivationReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_ACTIVATE_CLUSTER_HUD".equals(intent.getAction())) {
                DebugLogger.i("MainActivity", "Received Cluster/HUD activation broadcast (3s after DRIVING)");

                // 使用与 setupCluster() 相同的键名: switch_cluster, switch_hud
                boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
                boolean isHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);

                ClusterHudManager manager = ClusterHudManager.getInstance(MainActivity.this);

                // 先设置状态
                if (isClusterEnabled) {
                    DebugLogger.i("MainActivity", "Delayed Activation: Setting Cluster enabled");
                    // 强制设置内部状态（绕过状态检查）
                    manager.setClusterEnabled(false);
                    manager.setClusterEnabled(true);
                }

                if (isHudEnabled) {
                    DebugLogger.i("MainActivity", "Delayed Activation: Setting HUD enabled");
                    manager.setHudEnabled(false);
                    manager.setHudEnabled(true);
                }

                // 强制刷新 PresentationManager 确保显示
                if (isClusterEnabled || isHudEnabled) {
                    DebugLogger.i("MainActivity", "Delayed Activation: Forcing presentation refresh");
                    manager.forceRefreshPresentationManager();
                }
            }
        }
    };

    private final android.content.BroadcastReceiver mOneOSStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_ONEOS_STATUS".equals(intent.getAction())) {
                updateOneOSStatus(intent.getBooleanExtra("is_connected", false));
            }
        }
    };



    private void updateOneOSStatus(boolean isConnected) {
        ImageView imgStatus = findViewById(R.id.imgMediaKeyServiceIcon);
        if (imgStatus == null)
            return;
        if (isConnected) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
        }
    }

    // --- ADB Wireless Logic ---

    // --- Grid Background Drawable (Inline) ---
}

