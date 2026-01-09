package cn.navitool;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import cn.navitool.view.TrafficLightView;

/**
 * 奥迪RS转速表主题控制器
 * 控制彩灯显示和红色闪烁条效果
 */
public class AudiRsThemeController {
    private static final String TAG = "AudiRsThemeController";

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

    // 指针旋转参数
    private static final float POINTER_MIN_ANGLE = 0f; // 0转时的角度
    private static final float POINTER_MAX_ANGLE = 270f; // 8000转时的角度

    // Views
    private ClippedImageView mPointer;
    private ImageView mLight1, mLight2, mLight3, mLight4, mLight5;
    private ImageView mFlashBar;
    private TextView mSpeedText;
    private TextView mGearText;
    private ImageView mBackground; // New Background View

    // Traffic Light
    private TrafficLightView mTrafficLightLeft;
    private TrafficLightView mTrafficLightStraight;
    private TrafficLightView mTrafficLightRight;

    // 档位状态
    private static final String[] GEARS = { "P", "R", "N", "D" };
    private int mCurrentGearIndex = 0;

    // Day/Night State
    private boolean mIsDayMode = true;

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

    // 第一次闪烁延迟后才开始切换
    private void scheduleFirstFlash() {
        int interval = calculateFlashInterval(mCurrentRpm);
        mHandler.postDelayed(mFlashRunnable, interval);
    }

    public AudiRsThemeController() {
    }

    /**
     * 绑定Views
     */
    // TPMS Views
    private TextView mPresFL_Val, mPresFL_Unit, mTempFL;
    private TextView mPresFR_Val, mPresFR_Unit, mTempFR;
    private TextView mPresRL_Val, mPresRL_Unit, mTempRL;
    private TextView mPresRR_Val, mPresRR_Unit, mTempRR;

    public void bindViews(View rootView) {
        if (rootView == null)
            return;

        mBackground = rootView.findViewById(R.id.audiRsBg);
        mPointer = rootView.findViewById(R.id.audiRsPointer);
        mLight1 = rootView.findViewById(R.id.audiRsLight1);
        mLight2 = rootView.findViewById(R.id.audiRsLight2);
        mLight3 = rootView.findViewById(R.id.audiRsLight3);
        mLight4 = rootView.findViewById(R.id.audiRsLight4);
        mLight5 = rootView.findViewById(R.id.audiRsLight5);
        mFlashBar = rootView.findViewById(R.id.audiRsFlashBar);
        mSpeedText = rootView.findViewById(R.id.audiRsSpeedText);
        mGearText = rootView.findViewById(R.id.audiRsGearText);

        // Traffic Lights - Bind 3 views
        mTrafficLightLeft = rootView.findViewById(R.id.audiRsTrafficLightLeft);
        mTrafficLightStraight = rootView.findViewById(R.id.audiRsTrafficLightStraight);
        mTrafficLightRight = rootView.findViewById(R.id.audiRsTrafficLightRight);

        // Navi Info Controller (Evolution of TrafficLightController)
        if (mNaviInfoController == null) {
            mNaviInfoController = new NaviInfoController();
        }
        mNaviInfoController.bindTrafficLightViews(mTrafficLightLeft, mTrafficLightStraight, mTrafficLightRight);

        // Bind Navi Info Views (Distance & ETA)
        TextView distView = rootView.findViewById(R.id.audiRsNaviDistance);
        TextView etaView = rootView.findViewById(R.id.audiRsNaviEta);
        mNaviInfoController.bindNaviInfoViews(distView, etaView);

        // TPMS Binding
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

        DebugLogger.d(TAG, "Views bound successfully");

        // Initial sync
        updateDayMode();
    }

    /**
     * Update Traffic Light Status
     */
    /**
     * Update Turn Signal (Legacy/Unused for filtering now)
     */
    public void updateTurnSignal(boolean isLeft, boolean isOn) {
        // Logic removed as user requested SIMULTANEOUS display of all lights
    }

    /**
     * Update Traffic Light Status
     */
    public void updateTrafficLight(cn.navitool.NaviInfoController.TrafficLightInfo info) {
        if (mNaviInfoController != null) {
            mNaviInfoController.updateTrafficLight(info);
        }
    }

    // Navi Info Controller (Delegate)
    private NaviInfoController mNaviInfoController;

    public void resetTrafficLights() {
        if (mNaviInfoController != null) {
            mNaviInfoController.resetTrafficLights();
        }
    }

    // [FIX] Reset navigation info (distance/ETA)
    public void resetNaviInfo() {
        if (mNaviInfoController != null) {
            mNaviInfoController.reset(); // Resets navi info including ETA
        }
    }

    private int mCurrentManeuverIcon = -1;

    public void updateGuideInfo(cn.navitool.NaviInfoController.GuideInfo info) {
        if (info == null)
            return;
        mCurrentManeuverIcon = info.iconType;
        DebugLogger.d(TAG, "GuideInfo Updated: Icon=" + info.iconType + " Road=" + info.currentRoadName + " Next="
                + info.nextRoadName);

        // Use NaviInfoController
        if (mNaviInfoController != null) {
            mNaviInfoController.updateGuideInfo(info);
        }
    }

    // Explicit Navi Info (Kept for compatibility if called, but uses GuideInfo now
    // mostly)
    // Actually, I can remove it if ClusterHudPresentation is updated to not call
    // it.
    // I updated ClusterHudPresentation to NOT call it.
    // So I can remove it here too.
    // But NaviInfoController still has it.
    // I will remove it to be clean.

    public void updateTirePressure(int index, float pressure) {
        TextView valView = null;
        TextView unitView = null;

        switch (index) {
            case 0:
                valView = mPresFL_Val;
                unitView = mPresFL_Unit;
                break;
            case 1:
                valView = mPresFR_Val;
                unitView = mPresFR_Unit;
                break;
            case 2:
                valView = mPresRL_Val;
                unitView = mPresRL_Unit;
                break;
            case 3:
                valView = mPresRR_Val;
                unitView = mPresRR_Unit;
                break;
        }

        if (valView == null || unitView == null)
            return;

        // Color Logic: 2.0-2.8 Bar = 200-280 kPa is Green.
        String valueStr;
        String unitStr;
        boolean isNormal;

        if (pressure < 10.0f) {
            // Still Bar?
            valueStr = String.format(java.util.Locale.US, "%.1f", pressure);
            unitStr = " bar";
            isNormal = (pressure >= 2.0f && pressure <= 2.8f);
        } else {
            valueStr = String.format(java.util.Locale.US, "%.0f", pressure);
            unitStr = " kPa";
            isNormal = (pressure >= 200.0f && pressure <= 290.0f);
        }

        // Set Text Separately
        valView.setText(valueStr);
        unitView.setText(unitStr);

        // Apply Color to BOTH
        int color = isNormal ? 0xFF00FF00 : 0xFFFF0000;
        valView.setTextColor(color);
        unitView.setTextColor(color);
    }

    public void updateTireTemp(int index, float temp) {
        TextView tempView = null;
        switch (index) {
            case 0:
                tempView = mTempFL;
                break;
            case 1:
                tempView = mTempFR;
                break;
            case 2:
                tempView = mTempRL;
                break;
            case 3:
                tempView = mTempRR;
                break;
        }

        if (tempView == null)
            return;

        // Temp Unit: °C
        tempView.setText(String.format(java.util.Locale.US, "%.0f°C", temp));
    }

    public void setDayMode(boolean isDay) {
        DebugLogger.d(TAG, "setDayMode calling: " + isDay + " (Current: " + mIsDayMode + ")");
        if (mIsDayMode != isDay) {
            mIsDayMode = isDay;
            updateDayMode();
        } else {
            // Force update just in case view state is out of sync
            updateDayMode();
        }
    }

    private void updateDayMode() {
        if (mBackground != null) {
            DebugLogger.d(TAG, "Updating Background Image to: " + (mIsDayMode ? "DAY" : "NIGHT"));
            // Day: audi_rs_bg_day, Night: audi_rs_bg_night
            mBackground.setImageResource(mIsDayMode ? R.drawable.audi_rs_bg_day : R.drawable.audi_rs_bg_night);
        } else {
            DebugLogger.w(TAG, "mBackground is null during updateDayMode");
        }
    }

    /**
     * 更新转速显示
     * 
     * @param rpm 当前转速
     */
    public void updateRpm(int rpm) {
        mCurrentRpm = rpm;

        // 1. 更新进度条（从0转开始显示）
        updatePointer(rpm);

        // 2. 更新红色闪烁条（3000转以上）- 先于彩灯，避免空白
        updateFlashBar(rpm);

        // 3. 更新彩灯显示（2000转以上，闪烁条出现时隐藏）
        updateLights(rpm);
    }

    /**
     * 更新车速显示
     */
    public void updateSpeed(int speed) {
        if (mSpeedText != null) {
            mSpeedText.setText(String.valueOf(speed));
        }
    }

    /**
     * 循环切换档位 P -> R -> N -> D -> P
     */
    public void cycleGear() {
        mCurrentGearIndex = (mCurrentGearIndex + 1) % GEARS.length;
        updateGearDisplay();
    }

    // 档位传感器常量 (来自 SoundPromptManager)
    private static final int GEAR_PARK = 2097712;
    private static final int GEAR_REVERSE = 2097728;
    private static final int GEAR_NEUTRAL = 2097680;
    private static final int GEAR_DRIVE = 2097696;
    private static final int TRSM_GEAR_PARK = 15;
    private static final int TRSM_GEAR_DRIVE = 13;
    private static final int TRSM_GEAR_NEUT = 14;
    private static final int TRSM_GEAR_RVS = 11;

    /**
     * 根据传感器档位值设置显示
     */
    public void setGear(int gearValue) {
        String gearStr = "P"; // 默认P档

        if (gearValue == GEAR_DRIVE || gearValue == TRSM_GEAR_DRIVE) {
            gearStr = "D";
            mCurrentGearIndex = 3; // D在数组中的索引
        } else if (gearValue == GEAR_REVERSE || gearValue == TRSM_GEAR_RVS) {
            gearStr = "R";
            mCurrentGearIndex = 1;
        } else if (gearValue == GEAR_NEUTRAL || gearValue == TRSM_GEAR_NEUT) {
            gearStr = "N";
            mCurrentGearIndex = 2;
        } else if (gearValue == GEAR_PARK || gearValue == TRSM_GEAR_PARK) {
            gearStr = "P";
            mCurrentGearIndex = 0;
        }

        updateGearDisplay();
    }

    /**
     * 更新档位显示
     */
    private void updateGearDisplay() {
        if (mGearText != null) {
            String gear = GEARS[mCurrentGearIndex];
            mGearText.setText(gear);

            // 根据档位设置颜色
            int color;
            switch (gear) {
                case "R":
                    color = android.graphics.Color.RED;
                    break;
                case "N":
                    color = android.graphics.Color.YELLOW;
                    break;
                case "D":
                    color = android.graphics.Color.GREEN;
                    break;
                default: // P
                    color = android.graphics.Color.WHITE;
                    break;
            }
            mGearText.setTextColor(color);
        }
    }

    /**
     * 更新进度条显示（斜向裁剪）
     * 进度条内容区域：X轴 556px - 1363px（原始图片尺寸）
     * 裁剪角度：15°（与Y轴夹角，向左倾斜）
     */
    private void updatePointer(int rpm) {
        if (mPointer == null)
            return;

        // 限制范围
        int clampedRpm = Math.max(0, Math.min(rpm, RPM_MAX));

        // 计算进度比例: 0-8000转 映射到 0-1
        float progress = (float) clampedRpm / RPM_MAX;

        int viewWidth = mPointer.getWidth();
        int viewHeight = mPointer.getHeight();

        if (viewWidth <= 0 || viewHeight <= 0) {
            // View还没测量完成，先设置可见
            mPointer.setVisibility(View.VISIBLE);
            mPointer.disableClip();
            return;
        }

        // 原始图片参数（像素值）
        final int ORIGINAL_WIDTH = 1920; // 原始图片宽度
        final int CONTENT_START_X = 686; // 进度条内容起始X坐标（右移120px）
        final int CONTENT_END_X = 1660; // 进度条内容结束X坐标（右移120px）

        // 计算缩放比例（View尺寸 / 原始图片尺寸）
        float scaleX = (float) viewWidth / ORIGINAL_WIDTH;

        // 转换为View坐标
        int scaledStartX = (int) (CONTENT_START_X * scaleX);
        int scaledEndX = (int) (CONTENT_END_X * scaleX);

        if (progress <= 0) {
            // 0转时不显示
            mPointer.setVisibility(View.INVISIBLE);
        } else {
            mPointer.setVisibility(View.VISIBLE);
            mPointer.setAlpha(1.0f);

            // 设置裁剪角度（25°向左倾斜）
            mPointer.setClipAngle(32f);

            // 设置裁剪进度
            mPointer.setClipProgress(progress, scaledStartX, scaledEndX);

            android.util.Log.d("AudiRS", "RPM=" + clampedRpm + " progress=" + progress +
                    " viewWidth=" + viewWidth + " scaledStartX=" + scaledStartX +
                    " scaledEndX=" + scaledEndX);
        }
    }

    /**
     * 更新彩灯显示
     * 当红色闪烁条正在闪烁时隐藏彩灯
     */
    private void updateLights(int rpm) {
        if (mIsFlashing) {
            // 闪烁条正在闪烁，隐藏所有彩灯
            setLightVisibility(mLight1, false);
            setLightVisibility(mLight2, false);
            setLightVisibility(mLight3, false);
            setLightVisibility(mLight4, false);
            setLightVisibility(mLight5, false);
        } else {
            // 正常显示彩灯（根据转速阈值）
            setLightVisibility(mLight1, rpm >= RPM_LIGHT1);
            setLightVisibility(mLight2, rpm >= RPM_LIGHT2);
            setLightVisibility(mLight3, rpm >= RPM_LIGHT3);
            setLightVisibility(mLight4, rpm >= RPM_LIGHT4);
            setLightVisibility(mLight5, rpm >= RPM_LIGHT5);
        }
    }

    private void setLightVisibility(ImageView light, boolean visible) {
        if (light != null) {
            light.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 更新红色闪烁条
     */
    private void updateFlashBar(int rpm) {
        if (mFlashBar == null)
            return;

        if (rpm >= RPM_FLASH) {
            // 开始闪烁
            if (!mIsFlashing) {
                startFlashing();
            }
        } else {
            // 停止闪烁
            if (mIsFlashing) {
                stopFlashing();
            }
        }
    }

    /**
     * 开始闪烁动画
     */
    private void startFlashing() {
        mIsFlashing = true;
        mFlashVisible = true;
        mFlashBar.setVisibility(View.VISIBLE);
        // 使用延迟调度，确保闪烁条先保持可见一段时间再开始切换
        scheduleFirstFlash();
        DebugLogger.d(TAG, "Flash bar started");
    }

    /**
     * 停止闪烁动画
     */
    private void stopFlashing() {
        mIsFlashing = false;
        mHandler.removeCallbacks(mFlashRunnable);
        if (mFlashBar != null) {
            mFlashBar.setVisibility(View.GONE);
        }
        DebugLogger.d(TAG, "Flash bar stopped");
    }

    /**
     * 根据转速计算闪烁间隔
     * 
     * @param rpm 当前转速
     * @return 闪烁间隔 (毫秒)
     */
    private int calculateFlashInterval(int rpm) {
        // 线性插值: 3000转=500ms, 8000转=100ms
        if (rpm <= RPM_FLASH)
            return FLASH_INTERVAL_MAX;
        if (rpm >= RPM_MAX)
            return FLASH_INTERVAL_MIN;

        float ratio = (float) (rpm - RPM_FLASH) / (RPM_MAX - RPM_FLASH);
        int interval = (int) (FLASH_INTERVAL_MAX - (ratio * (FLASH_INTERVAL_MAX - FLASH_INTERVAL_MIN)));
        return interval;
    }

    /**
     * 释放资源
     */
    public void release() {
        stopFlashing();
        mHandler.removeCallbacksAndMessages(null);
        mPointer = null;
        mLight1 = mLight2 = mLight3 = mLight4 = mLight5 = null;
        mFlashBar = null;
        mSpeedText = null;
        mGearText = null;
    }
}
