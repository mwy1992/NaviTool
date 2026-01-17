# Change Log

## 2026-01-17

### HUD 几何修正与编辑器优化 (HUD Geometry & Editor Alignments)

- **显示高度微调 (Height Adjustment)**:
  - `app/src/main/res/layout/presentation_cluster_hud.xml`: 将 HUD 实际显示区域高度从 190px 微调至 **189px** (约 29 行)。
  - `app/src/main/java/cn/navitool/Presentation.java`: 同步修改了 `syncHudLayout` 方法中的最大高度限制 (`maxHeight`) 至 **189px**，确保真车显示不被边界截断 (约 893 行)。

- **编辑器预览校准 (Editor Preview Calibration)**:
  - `app/src/main/res/layout/layout_tab_hud.xml`:
    - 将预览区域高度调整为 **378px**，保持与实际高度 2:1 的比例 (约 131 行)。
    - **中心辅助线修正**: 为固定辅助线添加 `translationX="-25px"`，修正了预览界面中心线与实际显示中心的偏差 (约 145 行)。

- **HUD 字体精细化控制**:
  - 将燃油组件重构为 `LinearLayout` 布局，实现了 Emoji (18px) 与数值 (24px) 的完美垂直居中对齐，彻底解决了基线对齐导致的视觉偏差。

### Bug 修复 (Bug Fixes)

- **档位显示修复**:
  - 修正手动模式 (M档) 识别错误的问题（API 值 -1 现在正确映射为 "M"）。
  - 修复档位显示卡死或不更新的问题，优化了模拟档位计算逻辑，避免状态死锁。
  - 修复 HUD 档位不跟随变化的问题（删除了 Presentation 中的逻辑阻断，使其能与奥迪仪表同步更新）。
  - **悬浮红绿灯无法拖动修复**:
    - 将悬浮红绿灯的目标屏幕从 `Display 1` (HUD) 修改为 `Display 0` (默认主屏)，使其支持触摸交互。
  - **HUD 预览时钟不更新修复**:
    - 将 HUD 编辑器中的时间组件从静态 `TextView` 替换为动态 `TextClock`，修复了预览界面时间卡在添加时刻的问题。
  - **组件边距容错逻辑修复**:
    - 修复了 `LinearLayout` 类型组件（如重构后的燃油显示）无法享受边缘容错（0.2f 字体大小）的问题，现在容器类组件也会计算内部文本的容错值，防止被强制挤开屏幕边缘。
  - **悬浮红绿灯闪烁消失修复**:
    - 重构了悬浮红绿灯的显示逻辑，弃用了不稳定的 `View.GONE` 方案，改用 `addView`/`removeView` 动态挂载机制。
    - 优化了高德前台检测逻辑，增加了对 Window 事件的过滤（忽略 FrameLayout 等非全屏 Overlay），彻底解决了后台运行时悬浮窗被误判隐藏的问题。
  - **奥迪仪表“幽灵红绿灯”修复**:
    - 修复了 Audi RS 主题在未导航状态下显示红绿灯轮廓（0.3透明度）的问题。现在当红绿灯数据为空或无效时，组件将完全隐藏（0透明度），不再保留占位残影。
  - **后台自动重启修复**:
    - 修复了 `updateRpm` 方法在传感器高频更新时无节制触发模拟档位计算（Log/MainThread Post）导致的主线程阻塞 (ANR) 和应用重启问题。
    - 实施了多级数据节流 (Throttling)：仅在转速变化超过阈值或档位/速度实质变化时才刷新 UI，极大降低了 CPU 和 Log 负载。
    - 移除了关键路径中的冗余日志输出。
  - **启动稳定性增强 (Startup Stability)**:
    - [优化] 引入了**点火状态主动轮询机制** (Active Polling)。在应用启动后的前 5 秒内，每秒主动查询一次车辆点火状态。
    - [修复] 解决了在“系统已点火但应用稍后启动”场景下，因单次查询失败或状态未变化导致 UI 无法显示的问题。

---

## 2026-01-16

### 核心架构重构 (Core Refactoring)

- **统一传感器管理**: 将所有车辆传感器交互逻辑收敛至 `VehicleSensorManager`，移除了 `ClusterHudManager` 中的冗余注册代码。
- **去缓存化**: 移除了 HUD 的磁盘缓存机制 (`loadSensorCache` / `saveSensorCache`)，启动时直接读取实时传感器数据，彻底解决“启动显示旧数据”的问题。

### Bug 修复 (Bug Fixes)

- **时间组件修复**:
  - 修复时间组件卡在 "12:27" 不走动的问题（增加了对 `TextClock` 格式字符串的校验，非法格式自动回退到 "HH:mm"）。
- **导航相关**:
  - 修复红绿灯倒计时结束时，导航信息（ETA/剩余里程）连带消失的问题。
  - 修复红绿灯左侧方向箭头丢失的问题（恢复了图片资源重置逻辑）。
  - 修复悬浮红绿灯在车机上无法拖动的问题（移除了阻挡触摸事件的隐藏按钮）。

### 新增功能 (New Features)

- **新数据支持**:
  - 新增瞬时油耗 (Instant Fuel Consumption) 监听与分发。
  - 新增平均油耗 (Average Fuel Consumption) 监听与分发。
  - 新增总里程 (Odometer) 监听与分发。

## 代码优化 (Code Improvements)

- **VehicleSensorManager**: 补全了缺失的单例模式、常量定义及回调接口。
- **ClusterHudManager**: 清理了未使用的 `ECarSensorListener` 类、冗余变量及 `registerSensors` 方法，解决了编译错误。

## 导航 UI 修复与优化 (Navigation UI Fixes & Optimizations)

- **Audi RS 布局深度优化**:
  - **智能布局重构**: 实施了 "Wrap Content + MaxWidth" 策略，实现了短文本完美居中、长文本自动向两侧屏幕边缘扩展的效果。
  - **视觉对齐**: 修复了文字基线不对齐的问题（强制底部对齐），并优化了左右间距，确保视觉重心绝对稳定。
  - **自适应字体**: 启用了 `autoSizeTextType`，确保超长文本（>125dp/侧）自动缩小字号而非截断。
  - **体验调整**: 将导航信息超时时间从 10秒缩短至 5秒，减少信息展示的滞后感。
