package cn.navitool.theme;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import cn.navitool.R;
import cn.navitool.view.TrafficLightView;
import cn.navitool.managers.NaviInfoManager;
import cn.navitool.managers.NaviInfoManager.TrafficLightInfo;
import cn.navitool.managers.NaviInfoManager.GuideInfo;
import cn.navitool.utils.DebugLogger;
import cn.navitool.view.ClippedImageView;
import cn.navitool.view.animation.SmoothTextAnimator;

/**
 * 奥迪RS转速表主题控制器
 * 继承自 BaseThemeController，仅保留特有逻辑
 */
public class AudiRsThemeController extends BaseThemeController {

    // RPM阈值
    private static final int RPM_LIGHT1 = 2000; // 彩灯1显示阈值
    private static final int RPM_LIGHT2 = 2200; // 彩灯2显示阈值
    private static final int RPM_LIGHT3 = 2400; // 彩灯3显示阈值
    private static final int RPM_LIGHT4 = 2600; // 彩灯4显示阈值
    private static final int RPM_LIGHT5 = 2800; // 彩灯5显示阈值
    private static final int RPM_FLASH = 3000; // 红色闪烁条显示阈值

    // 闪烁频率范围 (毫秒)
    private static final int FLASH_INTERVAL_MAX = 250; // 最慢闪烁间隔 (3000转) - 加快初始频率
    private static final int FLASH_INTERVAL_MIN = 80; // 最快闪烁间隔 (8000转)
    private static final int RPM_MAX = 8000;

    // 指针校准区域
    private static final int ORIGINAL_WIDTH = 810; // 图片基准宽度
    private static final int CONTENT_START_X = 40; // 进度条起始X (像素)
    private static final int CONTENT_END_X = 1020; // 进度条结束X (像素)

    // Views (Specific to Audi RS)
    private ClippedImageView mPointer;
    // private TextView mRpmText; // Re-added RPM Text (Debug)
    private ImageView mLight1, mLight2, mLight3, mLight4, mLight5;
    private ImageView mFlashBar;
    private ImageView mBackground; 
    
    // New Sensor Data Views
    private TextView mFuelRemainText;
    private TextView mOdometerText;
    private TextView mFuelConsText;
    private TextView mTempInText;

    // Traffic Light & Navi - New Capsule Layout (3 TrafficLightViews)
    private View mNaviTrafficContainer;
    // [FIX] Added missing declaration for Navigation Info Row
    private View mNaviInfoRow;
    
    // 3 Capsule TrafficLightViews for multi-direction support
    private TrafficLightView mTrafficLightLeft;
    private TrafficLightView mTrafficLightStraight;
    private TrafficLightView mTrafficLightRight;
    
    private TextView mNaviDistance;
    private TextView mNaviEta;

    // TPMS Views
    private TextView mPresFL_Val, mPresFL_Unit, mTempFL;
    private TextView mPresFR_Val, mPresFR_Unit, mTempFR;
    private TextView mPresRL_Val, mPresRL_Unit, mTempRL;
    private TextView mPresRR_Val, mPresRR_Unit, mTempRR;

    // Day/Night State
    private boolean mIsDayMode = true;
    private boolean mIsNavigating = false;

    // 闪烁动画
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsFlashing = false;
    private boolean mFlashVisible = false;
    private int mCurrentRpm = 0;

    private Runnable mFlashRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsFlashing || mFlashBar == null)
                return;

            // 切换可见性
            mFlashVisible = !mFlashVisible;
            mFlashBar.setVisibility(mFlashVisible ? View.VISIBLE : View.INVISIBLE);

            // 根据转速计算下次闪烁间隔
            int interval = calculateFlashInterval(mCurrentRpm);
            mHandler.postDelayed(this, interval);
        }
    };

    // [DEPRECATED] Flash is now handled by TrafficLightView internally
    // private boolean mIsTrafficLightFlashing = false;
    // private boolean mTrafficLightFlashOn = true; 
    // private int mCurrentRawStatus = 0; 
    
    // Animation Animator
    private SmoothTextAnimator mSpeedTextAnimator;

    // Animation Loop
    // Reuse mHandler for animation loop
    private boolean mIsAnimating = false;
    private Runnable mAnimationRunnable = new Runnable() {
        @Override
        public void run() {
            boolean needsUpdate = false;

            // Speed Text
            if (mSpeedTextAnimator != null) {
                 mSpeedTextAnimator.onTick();
                 if (mSpeedTextAnimator.isRunning()) {
                     needsUpdate = true;
                 }
            }

            if (needsUpdate) {
                mHandler.postDelayed(this, 16); // ~60FPS
            } else {
                mIsAnimating = false;
            }
        }
    }; 

    // [DEPRECATED] Flash runnable removed - TrafficLightView handles internally
    // private Runnable mTrafficLightFlashRunnable = new Runnable() { ... };

    public AudiRsThemeController() {
    }

    @Override
    protected void onBindViews(View rootView) {
        // Bind Base Views
        mSpeedText = rootView.findViewById(R.id.audiRsSpeedText);
        mGearText = rootView.findViewById(R.id.audiRsGearText);

        // Bind Specific Views
        mBackground = rootView.findViewById(R.id.audiRsBg);
        mPointer = rootView.findViewById(R.id.audiRsPointer);
        // mRpmText = rootView.findViewById(R.id.audiRsRpmText); // Debug RPM Text
        mLight1 = rootView.findViewById(R.id.audiRsLight1);
        mLight2 = rootView.findViewById(R.id.audiRsLight2);
        mLight3 = rootView.findViewById(R.id.audiRsLight3);
        mLight4 = rootView.findViewById(R.id.audiRsLight4);
        mLight5 = rootView.findViewById(R.id.audiRsLight5);
        mFlashBar = rootView.findViewById(R.id.audiRsFlashBar);

        // Traffic Light & Navi (3 Capsule TrafficLightViews)
        mNaviTrafficContainer = rootView.findViewById(R.id.audiRsNaviTrafficContainer);
        mNaviInfoRow = rootView.findViewById(R.id.audiRsNaviInfoRow);
        
        // Bind 3 TrafficLightView capsules
        mTrafficLightLeft = rootView.findViewById(R.id.audiRsTrafficLightLeft);
        mTrafficLightStraight = rootView.findViewById(R.id.audiRsTrafficLightStraight);
        mTrafficLightRight = rootView.findViewById(R.id.audiRsTrafficLightRight);
        
        mNaviDistance = rootView.findViewById(R.id.audiRsNaviDistance);
        mNaviEta = rootView.findViewById(R.id.audiRsNaviEta);

        // Initial state: Hide until data arrives
        if (mNaviTrafficContainer != null) {
            mNaviTrafficContainer.setVisibility(View.GONE);
        }
        if (mNaviInfoRow != null) {
            mNaviInfoRow.setVisibility(View.GONE);
        }

        // TPMS
        bindTpmsViews(rootView);
        
        // Sensor Data
        mFuelRemainText = rootView.findViewById(R.id.audiRsFuelRemain);
        mOdometerText = rootView.findViewById(R.id.audiRsOdometer);
        mFuelConsText = rootView.findViewById(R.id.audiRsFuelCons);
        mTempInText = rootView.findViewById(R.id.audiRsTempIn);

        DebugLogger.d(TAG, "Audi RS Views bound successfully");

        // Initial sync
        String currentGear = cn.navitool.managers.ClusterHudManager.getInstance(rootView.getContext()).getCurrentDisplayGear();
        DebugLogger.d(TAG, "AudiRS Init Gear: " + currentGear);
        setGear(currentGear);
        
        updateDayMode();
        
        // Init Animators
        if (mSpeedText != null) {
            mSpeedTextAnimator = new SmoothTextAnimator(mSpeedText);
            mSpeedTextAnimator.setInitialValue(0);
        }
    }
    
    private void bindTpmsViews(View rootView) {
        mPresFL_Val = rootView.findViewById(R.id.audiRsPresFL_val);
        mPresFL_Unit = rootView.findViewById(R.id.audiRsPresFL_unit);
        mTempFL = rootView.findViewById(R.id.audiRsTempFL);

        mPresFR_Val = rootView.findViewById(R.id.audiRsPresFR_val);
        mPresFR_Unit = rootView.findViewById(R.id.audiRsPresFR_unit);
        mTempFR = rootView.findViewById(R.id.audiRsTempFR);

        mPresRL_Val = rootView.findViewById(R.id.audiRsPresRL_val);
        mPresRL_Unit = rootView.findViewById(R.id.audiRsPresRL_unit);
        mTempRL = rootView.findViewById(R.id.audiRsTempRL);

        mPresRR_Val = rootView.findViewById(R.id.audiRsPresRR_val);
        mPresRR_Unit = rootView.findViewById(R.id.audiRsPresRR_unit);
        mTempRR = rootView.findViewById(R.id.audiRsTempRR);
    }
    
    @Override
    public void detachViews() {
        super.detachViews();
        // Stop animation
        mHandler.removeCallbacks(mAnimationRunnable);
        mIsAnimating = false;
        mSpeedTextAnimator = null;

        // Release specific references
        mPointer = null;
        // mRpmText = null;
        mLight1 = null; mLight2 = null; mLight3 = null; mLight4 = null; mLight5 = null;
        mFlashBar = null;
        mBackground = null;
        mNaviTrafficContainer = null;
        mNaviInfoRow = null; // [FIX] Clear reference
        stopTrafficLightFlash();
        stopRpmFlash();
    }
    
    private void stopRpmFlash() {
        mIsFlashing = false;
        mHandler.removeCallbacks(mFlashRunnable);
        if (mFlashBar != null) mFlashBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void updateTrafficLight(TrafficLightInfo info) {
        if (info == null) {
            resetTrafficLights();
            return;
        }

        int mappedStatus = NaviInfoManager.mapStatus(info.status);
        
        // Valid status check
        boolean isValidStatus = (mappedStatus == TrafficLightView.STATUS_RED || 
                               mappedStatus == TrafficLightView.STATUS_YELLOW || 
                               mappedStatus == TrafficLightView.STATUS_GREEN);

        if (!isValidStatus && info.redCountdown <= 0) {
            if (mNaviTrafficContainer != null) mNaviTrafficContainer.setVisibility(View.GONE);
            return;
        }

        // Show container
        if (mNaviTrafficContainer != null) {
            mNaviTrafficContainer.setVisibility(View.VISIBLE);
        }

        // Determine which TrafficLightView to use based on direction
        // 1=Left, 2=Right, 3=TurnBack(Left), 4=Straight, 8=Straight, 0=Unknown(Straight)
        TrafficLightView targetView = null;
        
        if (info.direction == 1 || info.direction == 3) {
            targetView = mTrafficLightLeft;
        } else if (info.direction == 2) {
            targetView = mTrafficLightRight;
        } else {
            // Default to straight (0, 4, 8, or any other)
            targetView = mTrafficLightStraight;
        }
        
        if (targetView != null && isValidStatus) {
            targetView.setVisibility(View.VISIBLE);
            targetView.updateState(mappedStatus, info.redCountdown, info.direction);
        }
    }

    // [DEPRECATED] No longer needed with TrafficLightView capsules
    // private void updateTrafficLightImages(int rawStatus, float activeAlpha) { }

    // [DEPRECATED] Flash is now handled by TrafficLightView itself
    private void startTrafficLightFlash() {
        // TrafficLightView handles flash internally
    }

    private void stopTrafficLightFlash() {
        // TrafficLightView handles flash internally
    }
    
    @Override
    public void resetTrafficLights() {
        // Hide all 3 TrafficLightViews
        if (mTrafficLightLeft != null) mTrafficLightLeft.setVisibility(View.GONE);
        if (mTrafficLightStraight != null) mTrafficLightStraight.setVisibility(View.GONE);
        if (mTrafficLightRight != null) mTrafficLightRight.setVisibility(View.GONE);
        
        if (mNaviTrafficContainer != null) mNaviTrafficContainer.setVisibility(View.GONE);
    }

    @Override
    public void resetNaviInfo() {
        resetTrafficLights();
        
        if (mNaviDistance != null) mNaviDistance.setText("");
        if (mNaviEta != null) mNaviEta.setText("");
        
        if (mNaviInfoRow != null) mNaviInfoRow.setVisibility(View.GONE);
    }

    @Override
    public void updateGuideInfo(GuideInfo info) {
        if (info == null) {
            if (mNaviInfoRow != null) mNaviInfoRow.setVisibility(View.GONE);
            return;
        }

        if (info == null) return;
        
        // [FIX] If distance is negative (Navi End), hide the row and return immediately
        // This solves the persistence issue where empty/reset calls kept showing it.
        if (info.routeRemainDis < 0) {
            if (mNaviInfoRow != null) mNaviInfoRow.setVisibility(View.GONE);
            return;
        }
        
        if (mNaviInfoRow != null && mNaviInfoRow.getVisibility() != View.VISIBLE) {
            mNaviInfoRow.setVisibility(View.VISIBLE);
        }

        if (mNaviDistance != null) {
            String distText = "";
            if (info.routeRemainDis >= 1000) {
                 distText = String.format(java.util.Locale.US, "%.1fKM", info.routeRemainDis / 1000f);
            } else {
                 distText = info.routeRemainDis + "M";
            }
            mNaviDistance.setText(distText);
        }

        if (mNaviEta != null) {
            // [FIX] Use calculated ETA for standard "HH:mm" format
            String eta = NaviInfoManager.calculateEta(info.routeRemainTime);
            String displayEta = eta.isEmpty() ? "" : "ETA " + eta;
            mNaviEta.setText(displayEta);
        }
    }
    
    @Override
    public void updateTirePressure(int index, float pressure) {
        TextView valView = null;
        TextView unitView = null;
        switch (index) {
            case 0: valView = mPresFL_Val; unitView = mPresFL_Unit; break;
            case 1: valView = mPresFR_Val; unitView = mPresFR_Unit; break;
            case 2: valView = mPresRL_Val; unitView = mPresRL_Unit; break;
            case 3: valView = mPresRR_Val; unitView = mPresRR_Unit; break;
        }

        if (valView == null || unitView == null) return;

        String valueStr;
        String unitStr;
        boolean isNormal;

        if (pressure < 10.0f) {
            valueStr = String.format(java.util.Locale.US, "%.1f", pressure);
            unitStr = " bar";
            isNormal = (pressure >= 2.0f && pressure <= 2.8f);
        } else {
            valueStr = String.format(java.util.Locale.US, "%.0f", pressure);
            unitStr = " kPa";
            isNormal = (pressure >= 200.0f && pressure <= 290.0f);
        }

        valView.setText(valueStr);
        unitView.setText(unitStr);
        int color = isNormal ? 0xFF00FF00 : 0xFFFF0000;
        valView.setTextColor(color);
        unitView.setTextColor(color);
    }
    
    @Override
    public void updateTireTemp(int index, float temp) {
        TextView tempView = null;
        switch (index) {
            case 0: tempView = mTempFL; break;
            case 1: tempView = mTempFR; break;
            case 2: tempView = mTempRL; break;
            case 3: tempView = mTempRR; break;
        }
        if (tempView == null) return;
        tempView.setText(String.format(java.util.Locale.US, "%.0f°C", temp));
    }

    @Override
    public void setDayMode(boolean isDay) {
        if (mIsDayMode != isDay) {
            mIsDayMode = isDay;
            updateDayMode();
        } else {
            updateDayMode();
        }
    }

    @Override
    public void setNavigating(boolean isNavigating) {
        if (mIsNavigating != isNavigating) {
            mIsNavigating = isNavigating;
            DebugLogger.d(TAG, "Navigation State Changed: " + isNavigating);
            updateDayMode();
        }
    }

    private void updateDayMode() {
        if (mBackground != null) {
            // [Modified] Logic simplified: Only depend on system Day/Night mode
            // No longer distinguishing "Navigating" vs "Idle" background variants
            int resId = mIsDayMode ? R.drawable.audi_rs_bg_day : R.drawable.audi_rs_bg_night;
            mBackground.setImageResource(resId);
        }
    }

    // Override Base updateSpeed to utilize SmoothTextAnimator
    @Override
    public void updateSpeed(float speed) {
        // Jitter Filter
        if (Math.abs(speed - mLastSpeed) < 0.1f) {
            return;
        }
        mLastSpeed = speed;

        // Update Text Animator
        if (mSpeedTextAnimator != null) {
            mSpeedTextAnimator.updateTargetValue((int) speed);
             // Ensure Animation Loop is running
            if (!mIsAnimating) {
                mIsAnimating = true;
                mHandler.post(mAnimationRunnable);
            }
        } else {
            // Fallback if animator failed
             if (mSpeedText != null) {
                mSpeedText.setText(String.valueOf((int) speed));
            }
        }
        
        // Not calling onSpeedUpdated as it's empty in base and replaced here for text.
        // But if there were other speed logic we would call it.
        onSpeedUpdated(speed);
    }

    @Override
    public void updateRpm(float rpm) {
        int rpmInt = (int) rpm;
        mCurrentRpm = rpmInt;
        
        mCurrentRpm = rpmInt;
        
        // Update Text (Debug - Commented Out)
        /*if (mRpmText != null) {
            mRpmText.setText(String.valueOf(rpmInt));
        }*/

        // 1. Update Pointer
        updatePointer(rpmInt);

        // 2. Update Flash Bar
        updateFlashBar(rpmInt);

        // 3. Update Lights
        updateLights(rpmInt);
    }

    @Override
    public void updateFuelRemain(float fuelLiters) {
        if (mFuelRemainText != null) {
             mFuelRemainText.setText(String.format(java.util.Locale.US, "剩余油量: %.0fL", fuelLiters));
        }
    }
    
    @Override
    public void updateOdometer(float odometer) {
        if (mOdometerText != null) {
            mOdometerText.setText(String.format(java.util.Locale.US, "总里程: %.0fkm", odometer));
        }
    }
    
    @Override
    public void updateInstantFuel(float fuel) {
        if (mFuelConsText != null) {
            mFuelConsText.setText(String.format(java.util.Locale.US, "%.1f L/100km", fuel));
        }
    }
    
    @Override
    public void updateIndoorTemp(float temp) {
        if (mTempInText != null) {
            mTempInText.setText(String.format(java.util.Locale.US, "In: %.0f°C", temp));
        }
    }

    // --- Private Helper Methods (Specific to Audi RS) ---

    private void updatePointer(int rpm) {
        if (mPointer == null) return;

        int clampedRpm = Math.max(0, Math.min(rpm, RPM_MAX));
        float progress = (float) clampedRpm / RPM_MAX;

        int viewWidth = mPointer.getWidth();
        int viewHeight = mPointer.getHeight();

        if (viewWidth <= 0 || viewHeight <= 0) {
            mPointer.setVisibility(View.VISIBLE);
            mPointer.disableClip();
            return;
        }

        // Restore Original Scaling Logic
        float scaleX = (float) viewWidth / ORIGINAL_WIDTH;
        int scaledStartX = (int) (CONTENT_START_X * scaleX);
        int scaledEndX = (int) (CONTENT_END_X * scaleX);
        int contentWidth = scaledEndX - scaledStartX;
        
        int offset = (int) (contentWidth * progress);
        int clipX = scaledStartX + offset;

        mPointer.setClipProgress(progress, scaledStartX, scaledEndX);
        mPointer.setVisibility(View.VISIBLE);
    }

    private void updateFlashBar(int rpm) {
        if (mFlashBar == null) return;
        if (rpm >= RPM_FLASH) {
            if (!mIsFlashing) {
                mIsFlashing = true;
                mFlashVisible = true;
                mFlashBar.setVisibility(View.VISIBLE);
                scheduleFirstFlash();
            }
        } else {
            if (mIsFlashing) {
                mIsFlashing = false;
                mHandler.removeCallbacks(mFlashRunnable);
                mFlashBar.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void scheduleFirstFlash() {
        int interval = calculateFlashInterval(mCurrentRpm);
        mHandler.postDelayed(mFlashRunnable, interval);
    }

    private int calculateFlashInterval(int rpm) {
        if (rpm <= RPM_FLASH) return FLASH_INTERVAL_MAX;
        if (rpm >= RPM_MAX) return FLASH_INTERVAL_MIN;
        float percent = (float) (rpm - RPM_FLASH) / (RPM_MAX - RPM_FLASH);
        return (int) (FLASH_INTERVAL_MAX - percent * (FLASH_INTERVAL_MAX - FLASH_INTERVAL_MIN));
    }

    private void updateLights(int rpm) {
        if (mIsFlashing) {
            setLightsVisibility(View.INVISIBLE);
            return;
        }
        if (mLight1 != null) mLight1.setVisibility(rpm >= RPM_LIGHT1 ? View.VISIBLE : View.INVISIBLE);
        if (mLight2 != null) mLight2.setVisibility(rpm >= RPM_LIGHT2 ? View.VISIBLE : View.INVISIBLE);
        if (mLight3 != null) mLight3.setVisibility(rpm >= RPM_LIGHT3 ? View.VISIBLE : View.INVISIBLE);
        if (mLight4 != null) mLight4.setVisibility(rpm >= RPM_LIGHT4 ? View.VISIBLE : View.INVISIBLE);
        if (mLight5 != null) mLight5.setVisibility(rpm >= RPM_LIGHT5 ? View.VISIBLE : View.INVISIBLE);
    }

    private void setLightsVisibility(int visibility) {
        if (mLight1 != null) mLight1.setVisibility(visibility);
        if (mLight2 != null) mLight2.setVisibility(visibility);
        if (mLight3 != null) mLight3.setVisibility(visibility);
        if (mLight4 != null) mLight4.setVisibility(visibility);
        if (mLight5 != null) mLight5.setVisibility(visibility);
    }
}
