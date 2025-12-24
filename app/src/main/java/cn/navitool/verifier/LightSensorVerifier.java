package cn.navitool.verifier;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.car.sensor.ISensor;
import com.ecarx.xui.adaptapi.car.sensor.ISensor.ISensorListener;
import com.ecarx.xui.adaptapi.car.sensor.Sensor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 光照传感器兼容性验证器
 * 用于探测当前车机环境支持哪种光照传感器 (DayNight vs Light)
 * 日志将输出到 /sdcard/NaviTool/light_sensor_verify.log (于 DebugLogger 目录一致)
 */
public class LightSensorVerifier {
    private static final String TAG = "LightVerifier";

    // 传感器 ID 定义
    // 官方定义的 DayNight 传感器 (但在 adaptAPI24 中可能有 Bug)
    private static final int SENSOR_TYPE_DAY_NIGHT = 2101248;

    // 我们发现的 Light 传感器 (在 adaptAPI24 中可用，但在 ecarx 中未实现)
    private static final int SENSOR_TYPE_LIGHT = 2100992;

    // 推测的 Light 传感器事件值
    public static final int LIGHT_EVENT_BRIGHT = 2100993; // 亮/白天
    public static final int LIGHT_EVENT_DARK = 2100994; // 暗/夜间

    private Context mContext;
    private ISensor mSensor;
    private ISensorListener mListener;
    private File mLogFile;
    private SimpleDateFormat mDateFormat;

    public LightSensorVerifier(Context context) {
        this.mContext = context;
        this.mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        initLogFile();
    }

    private void initLogFile() {
        try {
            // 使用与 DebugLogger 一致的路径: /sdcard/NaviTool/
            File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            mLogFile = new File(dir, "light_sensor_verify.log");
            log("==========================================");
            log("日志文件路径: " + mLogFile.getAbsolutePath());

        } catch (Exception e) {
            Log.e(TAG, "初始化日志文件失败", e);
        }
    }

    /**
     * 同时写入 Logcat 和文件
     */
    private void log(String msg) {
        Log.i(TAG, msg);
        writeFile("INFO: " + msg);
    }

    private void logError(String msg, Throwable tr) {
        Log.e(TAG, msg, tr);
        writeFile("ERROR: " + msg + "\n" + Log.getStackTraceString(tr));
    }

    private synchronized void writeFile(String content) {
        if (mLogFile == null)
            return;
        try (FileWriter writer = new FileWriter(mLogFile, true)) {
            writer.append(mDateFormat.format(new Date()))
                    .append(" ")
                    .append(content)
                    .append("\n");
        } catch (IOException e) {
            // ignore
        }
    }

    /**
     * 开始验证
     */
    public void start() {
        log("=== 开始光照传感器兼容性测试 ===");

        try {
            // 1. 获取 Sensor 实例
            if (mSensor == null) {
                mSensor = new Sensor(mContext);
            }

            if (mSensor == null) {
                log("严重错误: 无法创建 Sensor 实例！");
                return;
            }

            // 2. 创建监听器
            mListener = new ISensorListener() {
                @Override
                public void onSensorEventChanged(int sensorType, int eventValue) {
                    log(">>>>>> 收到传感器事件! Type=" + sensorType + ", Value=" + eventValue);

                    if (sensorType == SENSOR_TYPE_DAY_NIGHT) {
                        log("【成功】DayNight 传感器 (2101248) 工作正常！");
                        log("当前状态: " + (eventValue == 1 ? "夜间" : "日间") + " (参考值)");
                    } else if (sensorType == SENSOR_TYPE_LIGHT) {
                        log("【成功】Light 传感器 (2100992) 工作正常！(这是 adaptAPI24 环境)");
                        if (eventValue == LIGHT_EVENT_BRIGHT) {
                            log("环境判定: 亮 (Day)");
                        } else if (eventValue == LIGHT_EVENT_DARK) {
                            log("环境判定: 暗 (Night)");
                        } else {
                            log("未知 Light 值: " + eventValue);
                        }
                    }
                }

                @Override
                public void onSensorSupportChanged(int sensorType, FunctionStatus status) {
                    log("支持状态变更: Type=" + sensorType + ", Status=" + status);
                }

                @Override
                public void onSensorValueChanged(int sensorType, float value) {
                    log("收到浮点值: Type=" + sensorType + ", Value=" + value);
                }
            };

            // 3. 同时注册两个传感器
            log("尝试注册 SENSOR_TYPE_DAY_NIGHT (" + SENSOR_TYPE_DAY_NIGHT + ")...");
            try {
                boolean regDayNight = mSensor.registerListener(mListener, SENSOR_TYPE_DAY_NIGHT, ISensor.RATE_NORMAL);
                log("注册结果 DayNight: " + regDayNight);
            } catch (Exception e) {
                log("【警告】注册 DayNight 传感器失败 - 这可能是 AdapAPI 的内部 Bug，不影响其他功能。");
                log("异常信息: " + e.toString());
            }

            log("尝试注册 SENSOR_TYPE_LIGHT (" + SENSOR_TYPE_LIGHT + ")...");
            try {
                boolean regLight = mSensor.registerListener(mListener, SENSOR_TYPE_LIGHT, ISensor.RATE_NORMAL);
                log("注册结果 Light: " + regLight);
            } catch (Exception e) {
                log("【警告】注册 Light 传感器失败: " + e.toString());
            }

            log("验证启动完成。请静置观察...");
            log("如果只收到 Light 回调，说明是 adaptAPI24 环境；如果只收到 DayNight 回调，说明是 Ecarx 环境。");

        } catch (NoClassDefFoundError e) {
            log("==========================================");
            log("【警告】环境不兼容 (预期结果)");
            log("检测到缺少底层组件: " + e.getMessage());
            log("这说明您正在模拟器或非吉利车机上运行。这是正常现象。");
            log("请直接忽略此错误，将 APK 安装到真车上即可正常运行。");
            log("==========================================");
            // 不再打印 logError(e)，避免吓到用户
        } catch (Throwable e) {
            logError("验证过程发生异常", e);
        }
    }

    /**
     * 停止验证
     */
    public void stop() {
        if (mSensor != null && mListener != null) {
            try {
                mSensor.unregisterListener(mListener);
                log("已停止监听");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
