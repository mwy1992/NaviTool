# 车机助手红绿灯信息获取指南

本指南说明如何在车机助手 (NaviTool) 中获取高德地图车机版广播的红绿灯倒计时信息。

## 1. 原理说明

高德地图车机版通过 **Android 广播 (Broadcast)** 的方式对外发送红绿灯数据。
- **广播 Action**: `AUTONAVI_STANDARD_BROADCAST_SEND`
- **关键标识 (Key Type)**: `60073` (通过 `KEY_TYPE` 字段透传)
- **数据字段**: 包含在 Intent 的 Extras 中。

## 2. 核心数据字段

| 字段名 (Key) | 类型 (Type) | 含义 | 备注 |
| :--- | :--- | :--- | :--- |
| `KEY_TYPE` | int | 消息类型 | 必须判断是否为 `60073` |
| `trafficLightStatus` | int | 红绿灯状态 | 1:红灯, 2:绿灯, 3:黄灯 (推测，需实测验证) |
| `redLightCountDownSeconds` | int | 红灯倒计时秒数 | |
| `greenLightLastSecond` | int | 绿灯剩余秒数 | 可能依赖配置开启 |
| `dir` | int | 方向 | 如直行、左转等 |
| `waitRound` | int | 等待轮次 | |

## 3. 实现步骤

### 步骤 1: 创建 BroadcastReceiver

创建一个继承自 `BroadcastReceiver` 的类，用于接收和解析广播。

```java
package cn.navitool.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TrafficLightReceiver extends BroadcastReceiver {
    private static final String TAG = "TrafficLightReceiver";
    public static final String ACTION_AMAP_BROADCAST = "AUTONAVI_STANDARD_BROADCAST_SEND";
    public static final int KEY_TYPE_TRAFFIC_LIGHT = 60073;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }

        if (ACTION_AMAP_BROADCAST.equals(intent.getAction())) {
            int keyType = intent.getIntExtra("KEY_TYPE", -1);
            
            // 过滤特定的红绿灯消息类型
            if (keyType == KEY_TYPE_TRAFFIC_LIGHT) {
                parseTrafficLightInfo(intent);
            }
        }
    }

    private void parseTrafficLightInfo(Intent intent) {
        int status = intent.getIntExtra("trafficLightStatus", -1);
        int redCountDown = intent.getIntExtra("redLightCountDownSeconds", -1);
        int greenLast = intent.getIntExtra("greenLightLastSecond", -1);
        int dir = intent.getIntExtra("dir", -1);
        int waitRound = intent.getIntExtra("waitRound", -1);

        Log.d(TAG, "收到红绿灯信息: " +
                "状态=" + status + 
                ", 红灯倒计时=" + redCountDown + 
                ", 绿灯剩余=" + greenLast + 
                ", 方向=" + dir + 
                ", 轮次=" + waitRound);
        
        // TODO: 在此处添加您的业务逻辑，例如更新 UI 或发送通知
    }
}
```

### 步骤 2: 注册 Receiver

您可以选择在 `AndroidManifest.xml` 中静态注册，或在 Activity/Service 中动态注册。建议使用动态注册以跟随应用生命周期。

**方式 A: 动态注册 (推荐在 Service 或 Activity 中)**

```java
// 在 onCreate 或 onStart 中
TrafficLightReceiver receiver = new TrafficLightReceiver();
IntentFilter filter = new IntentFilter();
filter.addAction("AUTONAVI_STANDARD_BROADCAST_SEND");
registerReceiver(receiver, filter);

// 别忘了在 onDestroy 中 unregisterReceiver(receiver);
```

**方式 B: 静态注册 (AndroidManifest.xml)**

```xml
<receiver android:name=".receiver.TrafficLightReceiver">
    <intent-filter>
        <action android:name="AUTONAVI_STANDARD_BROADCAST_SEND" />
    </intent-filter>
</receiver>
```

## 4. 注意事项

1.  **Action 验证**: 虽然代码分析指向 `AUTONAVI_STANDARD_BROADCAST_SEND`，但不同版本的车机版高德地图可能存在差异。如果收不到消息，请尝试监听 `com.autonavi.bbs.action.SEND` 或抓取所有广播进行分析。
2.  **权限**: 通常不需要特殊权限接收此广播，但请确保应用未被系统后台冻结。
3.  **数据有效性**: 实际开发中，请先打印所有接收到的 Extras，以确认字段名称和值的准确含义。
