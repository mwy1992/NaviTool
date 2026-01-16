# Change Log - 2026-01-16

## 核心架构重构 (Core Refactoring)

- **统一传感器管理**: 将所有车辆传感器交互逻辑收敛至 `VehicleSensorManager`，移除了 `ClusterHudManager` 中的冗余注册代码。
- **去缓存化**: 移除了 HUD 的磁盘缓存机制 (`loadSensorCache` / `saveSensorCache`)，启动时直接读取实时传感器数据，彻底解决“启动显示旧数据”的问题。

## Bug 修复 (Bug Fixes)

- **档位显示修复**:
  - 修正手动模式 (M档) 识别错误的问题（API 值 -1 现在正确映射为 "M"）。
  - 修复档位显示卡死或不更新的问题，优化了模拟档位计算逻辑，避免状态死锁。
- **时间组件修复**:
  - 修复时间组件卡在 "12:27" 不走动的问题（增加了对 `TextClock` 格式字符串的校验，非法格式自动回退到 "HH:mm"）。

## 新增功能 (New Features)

- **新数据支持**:
  - 新增瞬时油耗 (Instant Fuel Consumption) 监听与分发。
  - 新增平均油耗 (Average Fuel Consumption) 监听与分发。
  - 新增总里程 (Odometer) 监听与分发。

## 代码优化 (Code Improvements)

- **VehicleSensorManager**: 补全了缺失的单例模式、常量定义及回调接口。
- **ClusterHudManager**: 清理了未使用的 `ECarSensorListener` 类、冗余变量及 `registerSensors` 方法，解决了编译错误。

## 导航 UI 修复与优化 (Navigation UI Fixes & Optimizations)

- **Bug 修复**:
  - 修复红绿灯倒计时结束时，导航信息（ETA/剩余里程）连带消失的问题。
  - 修复红绿灯左侧方向箭头丢失的问题（恢复了图片资源重置逻辑）。
  - 修复悬浮红绿灯在车机上无法拖动的问题（移除了阻挡触摸事件的隐藏按钮）。

- **Audi RS 布局深度优化**:
  - **智能布局重构**: 实施了 "Wrap Content + MaxWidth" 策略，实现了短文本完美居中、长文本自动向两侧屏幕边缘扩展的效果。
  - **视觉对齐**: 修复了文字基线不对齐的问题（强制底部对齐），并优化了左右间距，确保视觉重心绝对稳定。
  - **自适应字体**: 启用了 `autoSizeTextType`，确保超长文本（>125dp/侧）自动缩小字号而非截断。
  - **体验调整**: 将导航信息超时时间从 10秒缩短至 5秒，减少信息展示的滞后感。
