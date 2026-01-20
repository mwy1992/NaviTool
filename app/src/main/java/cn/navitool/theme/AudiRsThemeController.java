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
import cn.navitool.controller.NaviInfoController;
import cn.navitool.controller.NaviInfoController.TrafficLightInfo;
import cn.navitool.controller.NaviInfoController.GuideInfo;
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
    private TextView mTripDistText;
    private TextView mTripTimeText;
    private TextView mOdometerText;
    private TextView mFuelConsText;
    private TextView mTempInText;

    // Traffic Light & Navi - New Layout
    private View mNaviTrafficContainer;
    private ImageView mDirectionArrow;
    private TextView mCountdownText;
    private ImageView mLightRed;
    private ImageView mLightYellow;
    private ImageView mLightGreen;
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

    // Traffic Light Flashing
    private boolean mIsTrafficLightFlashing = false;
    private boolean mTrafficLightFlashOn = true; 
    private int mCurrentRawStatus = 0; 
    
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

    private Runnable mTrafficLightFlashRunnable = new Runnable() {
        @Override
        public void run() {
            if (!mIsTrafficLightFlashing)
                return;

            mTrafficLightFlashOn = !mTrafficLightFlashOn;
            float alpha = mTrafficLightFlashOn ? 1.0f : 0.3f;
            updateTrafficLightImages(mCurrentRawStatus, alpha);
            mHandler.postDelayed(this, 500);
        }
    };

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

        // Traffic Light & Navi
        mNaviTrafficContainer = rootView.findViewById(R.id.audiRsNaviTrafficContainer);
        mDirectionArrow = rootView.findViewById(R.id.audiRsDirectionArrow);
        mCountdownText = rootView.findViewById(R.id.audiRsCountdown);
        if (mCountdownText != null) {
            try {
                android.graphics.Typeface ledFont = android.graphics.Typeface.createFromAsset(
                        rootView.getContext().getAssets(), "fonts/DS-Digital.ttf");
                mCountdownText.setTypeface(ledFont);
            } catch (Exception e) {
                DebugLogger.e(TAG, "Failed to load LED font", e);
            }
        }

        mLightRed = rootView.findViewById(R.id.audiRsLightRed);
        mLightYellow = rootView.findViewById(R.id.audiRsLightYellow);
        mLightGreen = rootView.findViewById(R.id.audiRsLightGreen);
        mNaviDistance = rootView.findViewById(R.id.audiRsNaviDistance);
        mNaviEta = rootView.findViewById(R.id.audiRsNaviEta);

        // Initial state: Hide until data arrives
        if (mNaviTrafficContainer != null) {
            mNaviTrafficContainer.setVisibility(View.GONE);
        }

        // TPMS
        bindTpmsViews(rootView);
        
        // Sensor Data
        mTripDistText = rootView.findViewById(R.id.audiRsTripDist);
        mOdometerText = rootView.findViewById(R.id.audiRsOdometer);
        mFuelConsText = rootView.findViewById(R.id.audiRsFuelCons);
        mTempInText = rootView.findViewById(R.id.audiRsTempIn);

        DebugLogger.d(TAG, "Audi RS Views bound successfully");

        // Initial sync
        updateDayMode();
        
        // Init Animator
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
            if (mNaviTrafficContainer != null)
                mNaviTrafficContainer.setVisibility(View.GONE);
            return;
        }

        if (mNaviTrafficContainer != null)
            mNaviTrafficContainer.setVisibility(View.VISIBLE);

        mCurrentRawStatus = info.status;
        int mappedStatus = NaviInfoController.mapStatus(info.status);

        boolean shouldFlash = false;
        if (mCountdownText != null) {
            int time = info.redCountdown;
            if (time > 0) {
                mCountdownText.setText(String.valueOf(time));
                mCountdownText.setVisibility(View.VISIBLE);
                if (time <= 3 && (mappedStatus == TrafficLightView.STATUS_RED
                        || mappedStatus == TrafficLightView.STATUS_GREEN)) {
                    shouldFlash = true;
                }
            } else {
                mCountdownText.setVisibility(View.INVISIBLE);
            }
        }

        if (shouldFlash) {
            startTrafficLightFlash();
        } else {
            stopTrafficLightFlash();
            updateTrafficLightImages(info.status, 1.0f);
        }

        // Arrow Rotation
        if (mDirectionArrow != null) {
            mDirectionArrow.setImageResource(R.drawable.ic_direction_arrow);
            float rotation = 0;
            switch (info.direction) {
                case 1: rotation = -90f; break; // Left
                case 2: rotation = 90f; break; // Right
                case 3: rotation = 180f; break; // U-Turn
                default: rotation = 0f; break; // Straight
            }
            mDirectionArrow.setRotation(rotation);
        }
    }

    private void updateTrafficLightImages(int rawStatus, float activeAlpha) {
        final float ALPHA_DIM = 0.3f;
        int mappedStatus = NaviInfoController.mapStatus(rawStatus);
        float inactiveAlpha = (mappedStatus == 0) ? 0f : ALPHA_DIM;

        if (mLightRed != null) mLightRed.setAlpha(mappedStatus == TrafficLightView.STATUS_RED ? activeAlpha : inactiveAlpha);
        if (mLightYellow != null) mLightYellow.setAlpha(mappedStatus == TrafficLightView.STATUS_YELLOW ? activeAlpha : inactiveAlpha);
        if (mLightGreen != null) mLightGreen.setAlpha(mappedStatus == TrafficLightView.STATUS_GREEN ? activeAlpha : inactiveAlpha);

        int color = 0xFFFFFFFF; // White
        if (mappedStatus == TrafficLightView.STATUS_RED) color = 0xFFFF0000;
        else if (mappedStatus == TrafficLightView.STATUS_YELLOW) color = 0xFFFFFF00;
        else if (mappedStatus == TrafficLightView.STATUS_GREEN) color = 0xFF00FF00;

        if (mCountdownText != null) mCountdownText.setTextColor(color);
        if (mDirectionArrow != null) mDirectionArrow.setColorFilter(color);
    }

    private void startTrafficLightFlash() {
        if (mIsTrafficLightFlashing) return;
        mIsTrafficLightFlashing = true;
        mTrafficLightFlashOn = true;
        mHandler.post(mTrafficLightFlashRunnable);
    }

    private void stopTrafficLightFlash() {
        if (!mIsTrafficLightFlashing) return;
        mIsTrafficLightFlashing = false;
        mHandler.removeCallbacks(mTrafficLightFlashRunnable);
    }
    
    @Override
    public void resetTrafficLights() {
        stopTrafficLightFlash();
        updateTrafficLightImages(0, 0f); // Reset to inactive
    }

    @Override
    public void resetNaviInfo() {
        stopTrafficLightFlash();
        if (mLightRed != null) mLightRed.setVisibility(View.GONE);
        if (mLightYellow != null) mLightYellow.setVisibility(View.GONE);
        if (mLightGreen != null) mLightGreen.setVisibility(View.GONE);
        if (mCountdownText != null) { mCountdownText.setText(""); mCountdownText.setVisibility(View.GONE); }
        if (mDirectionArrow != null) { mDirectionArrow.setImageDrawable(null); mDirectionArrow.setVisibility(View.GONE); }
        
        if (mNaviDistance != null) mNaviDistance.setText("");
        if (mNaviEta != null) mNaviEta.setText("");
        
        if (mNaviTrafficContainer != null) mNaviTrafficContainer.setVisibility(View.GONE);
    }

    @Override
    public void updateGuideInfo(GuideInfo info) {
        if (info == null) return;
        
        if (mNaviTrafficContainer != null && mNaviTrafficContainer.getVisibility() != View.VISIBLE) {
            mNaviTrafficContainer.setVisibility(View.VISIBLE);
        }

        if (mNaviDistance != null) {
            String distText = NaviInfoController.formatDistance(info.routeRemainDis);
            mNaviDistance.setText(distText);
        }

        if (mNaviEta != null) {
            String eta = NaviInfoController.parseEta(info.etaText);
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
            int resId;
            if (mIsNavigating) {
                resId = mIsDayMode ? R.drawable.audi_rs_bg_day : R.drawable.audi_rs_bg_night;
            } else {
                resId = mIsDayMode ? R.drawable.audi_rs_bg_day_idle : R.drawable.audi_rs_bg_night_idle;
            }
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
    public void updateTripInfo(float distanceKm, long duration) {
        if (mTripDistText != null) {
             mTripDistText.setText(String.format(java.util.Locale.US, "本次里程: %.1fkm", distanceKm));
        }
        if (mTripTimeText != null) {
            long hours = duration / 3600;
            long minutes = (duration % 3600) / 60;
            mTripTimeText.setText(String.format(java.util.Locale.US, "耗时: %02d:%02d", hours, minutes));
        }
    }
    
    @Override
    public void updateOdometer(float odometer) {
        if (mOdometerText != null) {
            mOdometerText.setText(String.format(java.util.Locale.US, "总里程: %.1fkm", odometer));
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
