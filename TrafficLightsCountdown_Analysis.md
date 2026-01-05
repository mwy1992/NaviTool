# 高德地图车机版 红绿灯倒计时代码分析 report

经过对 `app\libs\gd` 文件夹的分析，找到了红绿灯倒计时 (`TrafficLightsCountdown`) 相关的核心代码逻辑。以下是详细分析结果。

## 1. 核心类与文件

| 文件名 | 完整路径 (相对 app\libs\gd) | 作用描述 |
| :--- | :--- | :--- |
| `RspTrafficLightsCountdownInfoModel.java` | `com\autonavi\amapauto\protocol\model\service\` | **数据模型类**。定义了红绿灯倒计时的数据结构（方向、秒数、状态等）。 |
| `StandardProtocolKey.java` | `com\autonavi\amapauto\protocol\constant\` | **常量定义类**。包含了 Intent 传递数据时使用的 Key 常量。 |
| `c80.java` | `c80.java` | **模型映射类**。将字符串形式的模型名称映射到内部 ID (Value)。 |
| `q60.java` | `q60.java` | **反射与分发辅助类**。根据协议 ID (如 80189) 映射到具体的 Model Class。 |
| `vu.java` | `vu.java` | **协议分发管理器 (ProtocolDistributeManager)**。接收 JSON 数据，根据 Protocol ID 分发给对应的处理 Action。 |
| `vy.java` | `vy.java` | **具体业务逻辑类 (TrafficLightsCountdownInfoDisAction)**。封装 Model，将其转化为 Android Intent 广播发送出去。 |

## 2. 数据模型分析 (RspTrafficLightsCountdownInfoModel)

该类定义了红绿灯的具体信息。
*   **Protocol ID**: `80189`
*   **字段**:
    *   `dir` (int): 方向。
    *   `redLightCountDownSeconds` (int): 红灯倒计时秒数。
    *   `greenLightLastSecond` (int): 绿灯最后几秒（可能）。
    *   `trafficLightStatus` (int): 红绿灯状态。
    *   `waitRound` (int): 等待轮次。

## 3. 协议 ID 与 映射关系

*   **c80.java**:
    *   映射关系: `"RspTrafficLightsCountdownInfoModel"` -> `1` (Value)

*   **q60.java**:
    *   `case 80189`: 映射到 `RspTrafficLightsCountdownInfoModel.class`。

## 4. 业务处理流程

### 接收与分发 (vu.java)
在 `vu.java` 的 `a(JsonHeader, String)` 方法中，通过 switch case 处理协议：

```java
case 80189: {
    // 1. 解析 JSON 为 Model 对象
    final vy vy = new vy(gd.a(JsonHeader.parseJsonToJsonObj(string), RspTrafficLightsCountdownInfoModel.class));
    vy.a(string);
    // 2. 设置 RequestCode
    vy.c = i90.a(jsonHeader.requestCode, 0);
    // 3. 提交给 tu.e() 执行 (通常是发送广播或回调)
    tu.e().a(vy);
    break;
}
```

### 转换与广播 (vy.java)
`vy.java` 负责将 Model 数据转换为 Intent 数据，用于系统广播或其他组件通信。

*   **Intent Key Type**: `60073`
*   **Key 映射**:
    *   `trafficLightStatus`: 对应 `this.d.getTrafficLightStatus()`
    *   `dir`: 对应 `this.d.getDir()`
    *   `redLightCountDownSeconds`: 对应 `this.d.getRedLightCountDownSeconds()`
    *   `waitRound`: 对应 `this.d.getWaitRound()`
    *   `greenLightLastSecond`: 对应 `this.d.getGreenLightLastSecond()` (注意：此字段的放入依赖于 `vd.t()` 的返回值，可能是一个功能开关)。

## 5. 关键常量 (StandardProtocolKey.java)

虽然代码中直接使用了字符串字面量（在 `vy.java` 中），但在 `StandardProtocolKey` 中也定义了对应的标准常量，可能用于其他模块或接收端：

*   `EXTRA_TRAFFICLIGHTSTATUS = "trafficLightStatus"`
*   `EXTRA_REDLIGHTCOUNTDOWNSECONDS = "redLightCountDownSeconds"`
*   `EXTRA_GREENLIGHTLASTSECOND = "greenLightLastSecond"`
*   `EXTRA_WAITROUND = "waitRound"`

## 总结
红绿灯倒计时功能主要通过 **协议 ID 80189** 进行通信。数据包含方向、倒计时秒数、状态等。底层逻辑由 `vu` 接收分发，交由 `vy` 封装成 Intent，Intent 的 `KEY_TYPE` 为 `60073`。如果您需要拦截或模拟该数据，应关注 Protocol ID `80189` 的 JSON 数据包，或监听/发送 Type 为 `60073` 的广播。
