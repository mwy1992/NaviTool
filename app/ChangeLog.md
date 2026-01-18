# Change Log

## 2026-01-19

### 标准仪表主题重构与优化 (Standard Cluster Theme Refactoring & Optimization)

- **全新标准主题实现 (New Standard Theme Implementation)**:
  - **架构重构**: 废弃了旧版 Style 1 (Default) 的硬编码布局，全面迁移至 `StandardThemeController` 进行统一管理。移除了冗余的 `THEME_STANDARD` 定义，将标准主题归位为 Default (ID=1)。
  - **布局扁平化**: 重写 `layout_cluster_standard.xml`，移除了多层嵌套的 `FrameLayout`，采用像素级 (`px`) 的绝对定位 (`marginStart`/`marginTop`)，实现了对每一层元素（背景、指针、文字、前景）的精确控制。
  - **资源替换与分层**:
    - 替换了原有的 Mask 和 Dial 方案，改用全新的分层渲染逻辑：底层背景 (`standard_bg`) -> 指针层 (`standard_pointer`) -> 顶层文字 -> 顶层前景 (`standard_foreground`)。
    - 解决了前景图层不合理遮挡文字的问题，将速度与档位文字提升至最顶层 (Z-order Top) 绘制。
    - 修复了背景与前景图层在 `fitXY` 模式下的拉伸变形问题，改用 `wrap_content` 配合 `layout_gravity` (Top/Bottom) 实现原比例完美显示。

- **指针与动画逻辑优化 (Pointer & Animation Logic)**:
  - **初始角度偏移**: 在 `StandardThemeController` 中引入了 `SPEED_START_ANGLE` (-130°) 和 `RPM_START_ANGLE` (-120°)，实现了指针逆时针偏转起始点的功能，完美适配新表盘设计。
  - **转速表适配**: 调整了转速表的最大偏转角度 (`MAX_RPM_ANGLE`) 为 240°，并同步了偏转逻辑。
  - **测试逻辑增强**: 更新了 `MainActivity` 中的速度测试逻辑，将测试范围从 0-230 km/h 扩展至 0-260 km/h，覆盖表盘全量程。

- **UI 细节打磨 (UI Polish)**:
  - **文字居中**: 对速度 (`standardSpeedText`) 和档位 (`standardGearText`) 进行了强制居中处理。固定宽度 (300px) + `gravity="center"` + 精确计算的 Pivot 偏移，确保无论数值位数如何变化，始终相对于表盘圆心绝对居中。
  - **预览图实时化**: 优化了仪表设置页的 Style 1 预览按钮。直接复用真实主题的背景与前景资源，去除了半透明效果，并添加了带阴影的“标准仪表”文字，所见即所得。
  - **致谢信息**: 在仪表设置页底部新增了致谢说明：“感谢抖音@某男仔（@mnz66666666）提供主题设计支持”。

### 热启动问题修复 (Warm Restart Fixes)

- **完整生命周期管理重构**:
  - `app/src/main/java/cn/navitool/KeepAliveAccessibilityService.java`:
    - **监听器重构**: 将 `heavyListener` 提升为成员变量，实现了 `unregisterHeavySensors` 方法，使其支持显式反注册，杜绝了多次热启动导致的监听器堆叠问题。
    - **状态复位**: 新增了对 IGNITION OFF/ACC/LOCK 状态的精准监听。一旦检测到熄火信号，立即触发 `resetIgnitionState`，重置启动标志位并主动释放重型传感器资源。
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - **待机模式**: 新增 `enterStandbyMode` 接口。熄火时自动销毁 Presentation 窗口 (Release Window/Surface)，并将所有缓存数据（速度、转速、油量等）归零，将缓存档位重置为 `0` (Park)，彻底消除了热启动瞬间显示上次熄火前残留数据（或错误 "M" 档）的隐患。
    - **数据秒开**: 在 `ensureUiVisible` (UI重建) 流程中强制植入 `loadInitialSensorData` 调用。确保在热启动 UI 亮起的瞬间，立即从底层拉取最新的油量、温度与档位数据，实现了“启动即最新”的无缝体验。
    - **效果**: 彻底解决了热启动后 HUD 主题不显示、音乐信息不更新以及启动流程被错误阻塞的问题。
    - **[安全性优化] 线程调度**: 将熄火复位逻辑 (`resetIgnitionState`) 封装至 `MainHandler` 执行，彻底杜绝了传感器 Binder 线程因等待 UI 销毁而发生的阻塞或死锁风险，确保了底层通信的极致流畅。

### 奥迪仪表主题视觉微调 (Audi Cluster Visual Refinements)

- **方向箭头优化**:
  - `app/src/main/res/drawable/ic_direction_arrow.xml`:
    - 线条加粗 (`strokeWidth` 4 -> 5) 以提升可视性。
    - 缩放归一化 (`scale` 1.3 -> 1.1) 以适配新版布局尺寸。
- **红绿灯区域布局调整**:
  - `app/src/main/res/layout/layout_cluster_audi_rs.xml`:
    - **尺寸缩减**: 将红绿灯方向箭头尺寸从 32dp 缩小至 24dp，使视觉更加精致。
    - **倒计时优化**: 增大倒计时字号 (28sp -> 30sp) 并增加底部间距 (17dp -> 25dp)，优化与箭头的垂直对齐关系。
    - **布局约束**: 将导航信息（距离/时间）的最大宽度约束从 125dp 收紧至 70dp，防止超长文本遮挡其他元素。
    - **代码清理**: 移除了 XML 中的硬编码占位文本 ("66", "1250.5km" 等)，规范了预览逻辑。

### HUD 档位显示修复与优化 (HUD Gear Display Fixes & Optimization)

- **模拟档位显示逻辑修复 (Simulated Gear Toggle Logic Fix)**:
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - **逻辑补充**: 修复了关闭“模拟计算档位”功能时，界面不更新的问题。
    - **实现**: 在 `setSimulatedGearEnabled` 中增加了 `else` 分支，当功能关闭时，立即使用缓存的真实档位 (`mCachedGear`) 强制刷新 UI，不再等待下一次传感器事件。
    - **效果**: 解决了功能关闭后，仪表/HUD 仍长时间卡在旧模拟档位（如 "D3"）上的问题，现在能秒切回真实的 "D" 档显示。

- **模拟档位跳变修复 (Simulated Gear Fluctuation Fix)**:
  - `app/src/main/java/cn/navitool/DrivingShift.java`:
    - 引入了 `calculateGearPeek` 方法，专门用于无副作用的档位计算。
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - 修改了 `getGearString` 逻辑，在 HUD 预览刷新时优先复用上次稳定的计算结果 (`mLastSimulatedGear`)，或使用 Peek 模式计算。
    - **效果**: 彻底解决了在 HUD 编辑器拖拽组件时，因高频触发刷新导致后台平滑算法历史记录被污染，进而引发档位显示（如 D1/D2）异常跳变的问题。确保了预览操作完全不影响实际 HUD 的显示稳定性。

- **实时档位更新修复 (Real-time Gear Updates)**:
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - 重构了 `updateGear` 和 `calculateAndPushSimulatedGear` 方法，将档位更新统一路由至 `updateComponentText` 通道。
    - **效果**: 彻底解决了 HUD 预览界面档位始终显示静态 "D" 的问题，现在预览界面能实时反映真实档位和模拟档位的变化。

- **编辑器状态回填逻辑 (Editor State Backfill Logic)**:
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - 在 `syncHudLayout` 中新增了 **档位 (`gear`)**、**燃油 (`fuel`)**、**续航 (`range`)**、**温度 (`temp_out`/`temp_in`)** 的“回填机制”。
    - **效果**: 修复了打开 HUD 编辑页面时，默认的占位符（如 "D", "Text"）覆盖当前真实数据的问题。现在编辑器启动时会自动同步并显示所有组件的当前实时数值，实现“所见即所得”。

- **音乐组件显示一致性修复 (Music Component Consistency Fix)**:
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - 新增了 `Title`, `Artist`, `CoverArt` 的内存缓存变量。
    - 在媒体监听器 (`initMediaListener`) 中实现了缓存更新逻辑。
    - 在 `syncHudLayout` 中新增了音乐组件的回填逻辑。
    - **效果**: 修复了添加或拖动音乐组件时内容丢失的问题，现在音乐信息能持久化显示。

- **歌曲信息行间距优化 (Song Info Line Spacing Optimization)**:
  - `app/src/main/java/cn/navitool/Presentation.java`: 实际 HUD 显示减少行间距 (调整 topMargin 为 -4px)。
  - `app/src/main/java/cn/navitool/MainActivity.java`: 预览界面同步减少行间距 (调整 topMargin 为 -8px)，保持视觉比例一致 (2x)。
  - **效果**: 优化了双行歌曲信息（歌名/歌手）的视觉紧凑度，消除了过大的垂直空隙。

- **悬浮红绿灯视觉调整 (Floating Traffic Light Visual Adjustments)**:
  - `app/src/main/res/drawable/ic_direction_arrow.xml`: 增加方向箭头线条粗细 (strokeWidth 3 -> 4) 以提升辨识度。
  - `app/src/main/res/layout/layout_floating_traffic_light.xml`: 增大仪表样式下的倒计时文字大小 (24sp -> 30sp)。
  - `app/src/main/java/cn/navitool/Presentation.java`: 增大 HUD 胶囊样式的整体显示比例 (Scale 1.0 -> 1.5)，优化桌面悬浮显示的易读性。

- **转向灯“幽灵显示”修复 (Ghost Turn Signal Fix)**:
  - `app/src/main/java/cn/navitool/ClusterHudManager.java`:
    - 重构了 `updateTurnSignal(boolean, boolean)` 方法。
    - **逻辑变更**: 移除了 `synchronized` 关键字，并将所有状态更新逻辑强制调度至主线程 (`mMainHandler`) 执行。
    - **效果**: 彻底消除了后台 Binder 线程更新状态与主线程 `mBlinkRunnable` 读取状态之间的多线程竞态条件 (Race Condition)，解决了转向灯关闭后偶发不消失的问题。

### HUD 组件显示修复 (HUD Component Visibility Fixes)

- **组件边界消失问题修复 (Component Disappearance at Edge Fix)**:
  - `app/src/main/java/cn/navitool/Presentation.java`:
    - **问题定位**: 发现续航里程 (`range`) 及其他通用文本组件在初始化时未设置初始文本，导致首次测量宽度为 0。在进行边界限制 (Clamping) 计算时，0宽度的组件被系统允许放置在屏幕绝对边缘（例如 X=700），后续数据更新变宽后（如 150px）会向屏幕外延伸导致不可见。
    - **修复逻辑**: 在通用文本组件 (`tvGeneric`) 初始化逻辑中，显式调用 `setText`（使用默认空字符或初始文本），确保视图在测量阶段拥有非零的有效宽度，从而使边界限制逻辑能预留出正确的显示空间。
    - **效果**: 彻底修复了续航里程、温度等组件在拖动至屏幕边缘后“消失”的问题，确保所有组件始终在可视区域内。

### 设置页 UI 统一与优化 (Settings UI Standardization & Optimization)

- **内边距统一 (Padding Standardization)**:
  - 将 **提示音效**、**亮度设置**、**按键设置** 页面的内边距统一调整为 `12dp`，与 **HUD** 和 **仪表** 页面保持一致，消除了视觉割裂感。

- **提示音效页重构 (Sound Settings Redesign)**:
  - **选项整合**: 将“播放模式”和“播放声道”选项整合至顶部 Title 区域，并使用 `RelativeLayout` 重构布局，确保无论标题文本多长，选项始终保持**绝对居中**。
  - **布局平衡**: 移动“后备箱提示音”至左列，平衡左右两列的高度，优化视觉重心。
  - **文案优化**: 将标题更新为“自定义提示音效”，并增加了详细的路径提示“将mp3格式的文件放入/NaviTool/Sound/文件夹下即可使用”。

- **安全警示增加 (Safety Warnings)**:
  - 在 **按键设置** 页面的“激活第三方播放器方控功能”选项下方，新增了醒目的**红色**警示语：“使用白名单播放器（如酷狗、酷我等）请勿开启！”，防止用户误操作导致冲突。

### 悬浮球功能增强 (Floating Ball Enhancements)

- **应用列表拖拽排序 (App List Drag & Drop)**:
  - `app/src/main/java/cn/navitool/service/FloatingBallService.java`: 实现了 `OnDragListener`， 支持第一行应用的拖放管理。
  - `app/src/main/java/cn/navitool/view/AppListAdapter.java`: 新增 `OnItemLongClickListener` 支持长按启动拖拽。
  - `app/src/main/java/cn/navitool/managers/AppLaunchManager.java`: 新增 `saveTopApps`/`loadTopApps` 接口，实现首行应用列表的持久化存储。
  - **功能**:
    - 支持长按下方应用列表及第一行图标进行拖拽互换。
    - **逻辑约束**: 第一行首个位置固定为“车机助手”，不可移动。
    - **体验优化**: 移除了应用启动时的自动填充逻辑，仅保留用户手动添加的应用。
    - **UI 优化**: 在第一行空白背景增加“长按下方图标拖放到此以固定显示”的动态提示文字，仅在无自定义应用时显示。

## 2026-01-17

### HUD 几何修正与编辑器优化 (HUD Geometry & Editor Alignments)

- **显示高度微调 (Height Adjustment)**:
  - `app/src/main/res/layout/presentation_cluster_hud.xml`: 将 HUD 实际显示区域高度从 190px 微调至 **189px** (约 29 行)。
  - `app/src/main/java/cn/navitool/Presentation.java`: 同步修改了 `syncHudLayout` 方法中的最大高度限制 (`maxHeight`) 至 **189px**，确保真车显示不被边界截断 (约 893 行)。

- **编辑器预览校准 (Editor Preview Calibration)**:
  - `app/src/main/res/layout/layout_tab_hud.xml`:
    - 将预览区域高度调整为 **378px**，保持与实际高度 2:1 的比例 (约 131 行)。

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

  - **歌曲组件显示修复 (Music Component Fix)**:
    - **裁剪问题修复**: 彻底解决了歌曲信息（歌名/歌手/封面）在贴边放置时被裁剪的问题。
    - **独立边距控制**: 将原本全局统一的文字边缘容差 (`0.2f`) 重构为独立的 `FACTOR_TOP` 和 `FACTOR_BOTTOM`，并强制歌曲组件的容差与其物理边界对齐 (0f)，在保证其他组件视觉紧凑的同时，确保汉字不被切头。
    - **文档更新**: 新增了 `music_logic_workflow.md`，详细说明了歌曲信息的全链路工作原理及缓存机制。

  - **副驾屏常亮逻辑优化 (PSD Always On Refinement)**:
    - **动态循环对齐 (Dynamic Loop)**: 实现了基于启动状态的循环对齐机制。若启动时副屏为关，立即开启并以当前时间为循环基准；若启动时副屏为开，以系统开机时间为基准。
    - **爆发参数调整 (Burst Tuning)**: 将防止休眠的指令爆发逻辑优化为“每周期 9分59秒900毫秒 触发”，持续 200ms（间隔 1ms），确保在系统自动休眠前精准“保活”。
    - **文档更新**: 更新了 `psd_logic_documentation.md`，详细记录了最新的双模式工作逻辑。

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
