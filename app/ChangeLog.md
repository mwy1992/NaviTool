# Change Log

## 2026-01-24

### Z-Order 层级修复与启动可靠性 (Z-Order Fix & Startup Reliability)

- **显示层级修复 (Z-Order Regression Fix)**:
  - **问题**: 仪表盘 UI (如 Audi RS 主题) 偶尔被其他系统窗口遮挡，不显示在最顶层。
  - **原因**: 经 Git 追溯，`PresentationManager` 在 commit `e437c41` (0.4.6bugfix3) 中被修改为继承 `Dialog` 并手动设为 `TYPE_APPLICATION_OVERLAY`，破坏了 Android 原生副屏的层级管理。
  - **修复**: 回退 `PresentationManager` 继承自 `android.app.Presentation`，恢复使用 `(Context, Display)` 构造函数，利用系统原生机制 (System Managed Z-Order) 彻底解决层级遮挡问题。

- **冷启动可靠性增强 (Cold Boot Reliability)**:
  - **问题**: 冷启动时偶尔无法自动进入仪表模式 (需手动切换)，因系统服务初始化延迟导致首个 `switchNaviMode(3)` 指令被忽略。
  - **修复**: 优化了 `ClusterHudManager` 的双重保障机制 (Double Insurance)。
    - **强制重试**: 在启动 2秒后的重试逻辑中，强制重置去重缓存 (`mLastAppliedNaviMode = -1`)。
    - **无条件发送**: 即使系统认为当前已处于 Mode 3，也强制再次发送切换指令，确保在 AdaptAPI 服务就绪后指令能被正确执行。

### 导航逻辑重构与稳定性增强 (Navigation Logic Refactor & Stability)

- **数据驱动的导航状态 (Data-Driven Navigation State)**:
  - **启动优化**: 废弃了不可靠的状态码依赖，改为“数据驱动”模式。只要收到有效导航引导信息 (GuideInfo)，立即强制进入导航状态，彻底解决了导航开始时 UI 不显示的问题。
  - **结束判定重构**:
    - **废弃**: 移除了 `State 40` (心跳包) 和 `State 2` (无效停止码) 的判断逻辑，消除了因心跳包导致的导航误关闭。
    - **启用**: 经日志实测，确定 `State 35` 和 `State 308` 为唯一可靠的**导航结束信号**，以此作为强制重置 UI 的触发器。
  - **持久化策略**:
    - **里程/时间**: 实现了**无超时**逻辑。无论停车休息多久，只要未收到明确结束信号，导航信息将永久保留，不再自动消失。
    - **红绿灯**: 引入了 **3秒看门狗 (Watchdog)** 机制。若红绿灯数据流中断超过 3秒，自动隐藏相关组件，但不影响导航信息的显示。

- **HUD 显示修复 (HUD Display Fixes)**:
  - **启动闪烁修复 (Startup Flash Fix)**:
    - **问题**: HUD 导航组件在启动瞬间会短暂显示占位符然后消失。
    - **修复**: 优化了 `PresentationManager` 的组件初始化与同步逻辑。
      - **创建时**: 导航组件默认设为 `GONE`。
      - **同步时**: 增加了双重检查，禁止通用兜底逻辑强制显示导航组件，必须校验当前 `mIsNavigating` 状态。

### 架构与功能补全 (Architecture & Feature Completion)

- **档位模拟重构 (SimulateGear Refactor)**:
  - **独立模块**: 将原 `ClusterHudManager` 中复杂的模拟档位计算逻辑（通过车速/转速推算档位）剥离为独立的 `SimulateGear` 类。
  - **多变速箱支持**: 完整实现了 **8AT** 和 **7DCT** 两种变速箱逻辑的模拟计算，支持基于齿比 (`CalculateByRatio`) 和速度区间 (`CalculateBySpeedRpm`) 的双重校验算法。
  - **雪地模式**: 增加了雪地模式 (`DRIVE_MODE_SNOW`) 的特殊处理逻辑（强制 2 档起步）。

- **权限管理增强 (Permission Manager)**:
  - **全量检测**: 扩展了 `PermissionManager`，新增了对 `SYSTEM_ALERT_WINDOW` (悬浮窗)、`WRITE_SETTINGS` (系统设置)、`PACKAGE_USAGE_STATS` (应用使用情况) 的一键检测与申请流程。

- **主页状态控制 (HomeStatusController)**:
  - **新组件**: 新增 `HomeStatusController`，用于统一管理主页左下角状态栏信息的显示与隐藏，解耦了主页 UI 逻辑。

### 自定义提示音系统重构 (Sound System Overhaul)

- **设置页 UI 重绘**:
  - **网格化布局**: `layout_tab_sound.xml` 全面重构为 7 行 Grid 布局，极大优化了屏幕空间利用率，支持多达 20+ 种触发场景（开门/关门/档位等）的独立配置。
  - **头部控制区**: 新增了总开关 (Master Switch)、播放模式 (混音/直通) 和 声道选择 (媒体/导航) 的顶部常驻控制栏。
  - **文件选择器优化**:
    - **排序**: 文件列表现支持按字母顺序 (A-Z) 排序，便于查找。
    - **视觉**: 增大了列表项的字体大小 (24sp) 和点击热区，适配车载屏幕触控。
    - **容错**: 增加了对空目录、权限缺失等异常状态的详细弹窗提示。

- **通用设置优化 (General Settings)**:
  - **布局重构**: `layout_tab_general.xml` 同步采用了双列 Grid 布局，视觉更整洁。
  - **功能增强**: 集成了变速箱类型切换按钮 (8AT/7DCT) 和遮阳帘自动控制选项。
  - **致谢**: 档位模拟模块增加了“感谢群友大胖提供代码”的致谢标示。

- **媒体通知增强 (Media Notification)**:
  - **封面回退机制**: `MediaNotificationListener` 新增了封面获取的兜底逻辑。当 `MediaMetadata` 中无法获取专辑封面时，自动尝试从通知栏的 `LargeIcon` 提取图片，显著提高了网易云音乐等第三方 App 的封面显示成功率。
  - **延迟重试**: 针对部分 App 播放状态更新早于 Metadata 导致的标题丢失问题，增加了 1s 的延迟重试机制。

## 2026-01-23

### HUD 显示一致性与导航信息修复 (HUD Consistency & Navi Info Fixes)

- **档位默认值根除 (Gear Default Value Elimination)**:
  - **问题**: 仪表主题及 HUD 在启动时始终显示 "P" 档，即使车辆处于 D 档。
  - **原因**: `mCachedGear` 初始值为 `0` (映射 "P")；XML 中也硬编码了 `android:text="P"`。
  - **修复**:
    - 将 `ClusterHudManager.mCachedGear` 初始化为 `-999`，并在 `mapRawGearToChar` 中将 `-999` 映射为空字符串 `""`。
    - 移除了 `layout_cluster_audi_rs.xml` 和 `layout_cluster_standard.xml` 中 `audiRsGearText` 和 `standardGearText` 的硬编码默认值。
  - **效果**: 启动瞬间档位显示为空，直到传感器数据到达后才显示真实档位。

- **HUD 导航信息不更新修复 (Navi Info Update Fix)**:
  - **问题**: HUD 上的剩余里程 (`navi_distance_remaining`) 和到达时间 (`navi_arrival_time`) 组件显示占位符，不更新。
  - **原因**: `PresentationManager.updateGuideInfoGeneric` 方法为空 (仅有 TODO 注释)。
  - **修复**: 完整实现了该方法，遍历组件列表并更新对应 TextView 的文本内容，并同步更新 `mCachedNaviArrivalTime` 和 `mCachedNaviDistance` 缓存。
  - **格式化**:
    - 剩余里程: `>=1000m` 显示 `XX.XKM`，`<1000m` 显示 `XXM`。
    - 到达时间: 使用 `NaviInfoManager.parseEta` 提取纯时间 (如 "00:12")，移除"预计"和"到达"字样。

- **奥迪 RS 剩余里程格式化 (Audi RS Distance Formatting)**:
  - 将 `AudiRsThemeController.updateGuideInfo` 中的里程显示格式化逻辑与 HUD 统一。

- **HUD 辅助线支持 (Guide Line Support)**:
  - **问题**: HUD 预览中的辅助线组件无法在真实 HUD 上显示，且编辑器拖拽时无法超出屏幕边界。
  - **修复 (渲染)**: 在 `PresentationManager.syncHudLayout` 中新增对 `guide_line` 类型的支持，复刻预览界面的 `FrameLayout` 容器结构，并启用软件渲染 (`LAYER_TYPE_SOFTWARE`) 以确保虚线效果正常显示。
  - **修复 (边界)**: 在 `HudSettingsController` 和 `PresentationManager` 中放宽了 `guide_line` 的坐标钳位逻辑，允许其左右超出屏幕边缘最多 50% 的组件宽度。

- **HUD 组件字体边距修复 (Font Padding Fix)**:
  - **问题**: HUD 预览与真实 HUD 的通用文本组件（如 `navi_arrival_time`）垂直边距不一致。
  - **原因**: `HudSettingsController` 对所有 TextView 禁用了 Font Padding (`setIncludeFontPadding(false)`)，而 `PresentationManager` 漏了这一设置。
  - **修复**: 在 `PresentationManager` 的通用 TextView 创建逻辑中补充了 `tv.setIncludeFontPadding(false);`。

## 2026-01-22

### 奥迪 RS 主题同步更新 (Audi RS Theme Synchronization)

- **功能同步 (Feature Sync with KX11-A2)**:
  - **油量显示集成 (Fuel Level Integration)**: 全面替换了原有的“本次里程”显示逻辑。现在仪表盘右侧区域实时显示剩余油量 ("油量: XX L")，底层逻辑已接入 `VehicleSensorManager` 的实时油量数据。
  - **总里程整数化 (Integer Odometer)**: 调整了总里程显示格式，移除了小数位 (99999.9 -> 99999 km)，并优化了字体大小 (18sp -> 16sp) 以符合新的视觉规范。
  - **TPMS 布局校准**: 根据参考设计，精确调整了胎压监测区域的边距、字体大小 (压力值 14sp / 单位 10sp / 温度 10sp) 和布局结构。
  - **实时数据驱动**: 在 `ClusterHudManager` 中实现了完善的传感器监听接口 (`onFuelChanged`, `onOdometerChanged`, `onTemperatureChanged`, `onTireDataChanged`)，确保所有仪表数据均为毫秒级实时更新。

### 传感器与逻辑优化 (Sensor & Logic Optimization)

- **车速传感器冲突解决 (Speed Sensor Conflict Resolution)**:
  - **优先级调整**: 发现并解决了由 `KeepAliveAccessibilityService` 注册的 `DIM_CAR_SPEED` (1055232) 与 `VehicleSensorManager` 注册的通用车速 (1048832) 之间的冲突。通过移除 Service 中的冗余监听，确立了 `VehicleSensorManager` 为唯一权威车速数据源。

- **高德主题同步修复 (Amap Theme Sync Fix)**:
  - **环境光联动**: 扩展了 `ThemeBrightnessManager` 的逻辑。现在，当环境光传感器发生变化时，会自动检查并向高德地图发送正确的日夜模式广播，修复了自动模式失效的问题。
  - **模拟测试工具**: 在主界面调试区新增了“模拟高德日夜”按钮，便于开发者验证主题同步功能。

### 交互体验增强 (User Experience Enhancements)

- **落锁音效定制 (Door Closing Sounds)**:
  - **场景化反馈**: 新增了车门关闭音效功能。
    - **主驾侧**: 关闭时播放特定音效。
    - **副驾侧**: 智能识别副驾占用状态。若有人乘坐，播放“关门音效”；若无人，播放“空门音效” (需配置)。
  - **配置 UI**: 在声音设置页新增了“关门提示音”配置列，支持独立开关和文件路径配置。

## 2026-01-20 (下午工作总结 / Afternoon Session Summary)

### 仪表动画平滑与奥迪主题增强 (Cluster Animation Smoothing & Audi RS Enhancements)

- **平滑动画引擎 (Smooth Animation Engine)**:
  - **动态重定向 (Dynamic Retargeting)**: 实现了 `SmoothValueAnimator`，引入“动态重定向”算法，解决了原本仅基于 `DecelerateInterpolator` 导致的指针运动迟滞和非自然回弹问题。
  - **滚动计数器 (Rolling Counter)**: 实现了 `SmoothTextAnimator`，为数字显示提供平滑的滚动过渡效果。
  - **应用范围**:
    - **标准主题 (Standard Theme)**: 全面应用了指针平滑与速度文字滚动动画。
    - **奥迪 RS 主题 (Audi RS Theme)**: 应用了速度文字滚动动画。

- **奥迪 RS 主题调整 (Audi RS Theme Adjustments)**:
  - **RPM 剪裁调优**: 根据实车效果调整了转速条的剪裁角度 (`mClipAngle` 15° -> 33°) 和绘制范围 (`CONTENT_END_X` 1000 -> 1020)，提升了视觉贴合度。
  - **数字转速显示 (Debug)**: 新增了数字转速 (`RPM`) 显示组件代码（位于档位下方），但默认**已注释隐藏**，仅供调试使用。

- **修复 (Fixes)**:
  - 修复了 `SmoothValueAnimator` 因文件写入异常导致的编译错误。

## 2026-01-20 (上午工作总结 / Morning Session Summary)

### 严重 Bug 修复 (Critical Bug Fixes)

- **Headless 启动无显示修复 (Ghost Window & Config Logic)**:
  - **现象**: 模拟点火信号发送后，副屏 UI 不显示，必须手动进入 App 界面才出现。
  - **原因 1 (Presentation Context)**: `PresentationManager` 错误地继承了 `Presentation` 类（依赖 Activity Context），导致后台 Service 无法创建可见窗口。**修复**: 回退继承自 `Dialog` 并使用 `ContextThemeWrapper` + `createWindowContext` (API 30+ 适配)。
  - **原因 2 (Config Key Mismatch)**: `ensureUiVisible` 方法使用了错误的配置键名 (`cluster_enabled`/`hud_enabled` 默认为 false)，导致启动逻辑自杀。**修复**: 修正为 `switch_cluster`/`switch_hud`。
  - **原因 3 (Repeated Method)**: `ClusterHudManager` 中存在两个 `ensureUiVisible` 定义。**修复**: 删除了旧的、不完善的重复定义。

- **P 档无声修复 (Parking Gear Sound Fix)**:
  - **现象**: 挂入 P 档时偶发无播报。
  - **原因**: 启动时的“首个 P 档过滤逻辑”存在缺陷。如果以非 P 档（如 D 档）启动，系统未能正确标记“初始阶段结束”，导致停车时的 P 档被误判为“初始 P 档”而被拦截。
  - **修复**: 只要播放过任何档位（D/R/N）音效，立即强制结束初始过滤阶段，确保后续 P 档播报正常。

- **行车数据 API- [Fix] 修复 `VehicleSensorManager` 编译错误 (恢复缺失的 package 声明)。
- [Fix] **TripData Crash Fix**: 移除导致闪退的 `ITripData` 接口依赖，彻底解决不兼容问题。
- [Feature] **Soft Trip (软小计里程)**: 实现手动计算本通过程里程逻辑。
  - 基于总里程 (Odometer) 差值计算。
  - 支持停车 4 小时后自动重置行程。
  - 数据持久化，防止应用重启丢失。
- **行车数据 API 兼容性修复 (TripData Crash Fix)**:
  - **现象**: 在部分车型（如版本 0.4.6）上启动即闪退，日志显示 `ClassCastException: VehicleSensorManager$2 cannot be cast to ITripInfoListener`。
  - **原因**: 车辆底层 `TripData` API 存在版本差异，监听器接口定义不兼容（系统期望 `ITripInfoListener` 但编译代码使用的是 `ITripListener`）。
  - **修复**: 在 `registerTripListener` 处增加了 `try-catch` 保护。若检测到 API 不兼容，将自动降级（不启用行车数据监听），防止应用崩溃。

### 功能优化与重构 (Refactoring & Optimization)

- **主题 ID 重构 (Theme ID Refactor)**:
  - 将 Audi RS 主题的内部 ID 常量 `THEME_AUDI_RS` 从 **21** 修改为 **2**，简化了编号规则。

- **副驾传感器逻辑修正 (Passenger Sensor Logic)**:
  - 修正了副驾传感器的数据类型（Float -> Int Event）和状态码定义（2110210 有人 / 2110209 无人），并补充了启动时的状态轮询。

### 2026-01-20

### 副驾占用检测修复 (Passenger Occupancy Detection Fix)

- **核心问题**: 修复了副驾传感器 (`2110464`) 信号无法被识别，导致开关门提示音始终播放“无人”音效的严重 Bug。
- **技术细节**:
  - **回调修正**: 修正了原代码将该传感器作为 `Float` (Value) 类型监听的错误，迁移至正确的 `Int` (Event) 监听回调 (`onSensorEventChanged`)。
  - **状态定义**: 明确了传感器状态码定义：`2110210` (有人/Occupied) 与 `2110209` (无人/Empty)。
  - **启动初始化**: 在 `pollInitialSensorData` 中新增了对副驾状态的主动查询逻辑，确保服务启动瞬间即可获知当前座位状态，无需等待下一次变动事件。

### 调试日志增强 (Enhanced Debug Logging)

- **副驾传感器 (Passenger Sensor)**:
  - `Polled Passenger Seat: [数值]` (启动时查询到的原始状态值)
  - `Init: Passenger Seat is OCCUPIED` (启动初始化判定：有人)
  - `Init: Passenger Seat is EMPTY` (启动初始化判定：无人)
  - `Passenger Seat Occupation Changed (Event): [true/false] (Val: [数值])` (实时状态变更捕获)

- **门控联动 (Door Logic)**:
  - `Passenger Door Open & Occupied -> Playing 'Passenger' Sound` (判定为有人，播放对应音效)
  - `Passenger Door Open & Empty -> Playing 'Passenger Empty' Sound` (判定为无人，播放对应音效)

### 昨夜紧急修复汇总 (Late Night Urgent Fixes)

- **主题配置持久化 (Theme Reset Fix)**:
  - 修复了覆盖安装或版本更新后，用户选择的仪表主题（如 Audi RS）被错误重置为默认值的问题。
- **仪表档位冲突修复 (Cluster Gear Conflict)**:
  - 修复了 Audi RS 主题与标准主题在档位显示逻辑上的冲突，确保切换主题时档位状态能正确解耦并即时刷新 (Presentation.java)。
- **HUD 显示优化 (HUD Display Optimization)**:
  - **SingleLine 防换行**: 强制 HUD 转速 (`rpm`) 组件单行显示，防止因数值过大导致换行遮挡。
  - **宽度修正**: 修正了 HUD 转速与温度组件的宽度计算逻辑 (300px)，解决了布局错位问题。
  - **温度格式化**: 统一 HUD 温度显示为一位小数 (XX.X°C)，消除数值跳变时的闪烁感。

## 2026-01-19

### 导航模式稳定性与构建修复 (NaviMode Stability & Build Fixes)

- **NaviMode 自动重置修复 (NaviMode Auto Reset Fix)**:
  - **问题**: 修复了偶尔退出导航后，仪表盘无法自动切回“仪表模式 (Mode 3)”的问题。
  - **原因**: 系统级 Navimode 变化回调在某些场景（如高德直接退出）下可能不触发，导致应用处于错误的“地图模式 (Mode 1)”。
  - **方案**: 引入了基于高德导航广播状态 (`EXTRA_STATE == 2`) 的主动重置机制。一旦检测到导航停止，立即在后台线程强制发送 `switchNaviMode(3)` 指令，作为系统回调的双重保险。

- **构建环境修复 (Build Environment Fix)**:
  - 升级 Android Gradle Plugin 至 8.3.2，解决了因 Android SDK Build-Tools XML版本不兼容导致的编译错误。

- **吉利红绿灯数据连接优化 (Geely Socket Connection Optimization)**:
  - **主动启动**: 实现了 Socket Manager 的开机自启 (`NaviInfoController` 初始化时即启动)，不再依赖不稳定的广播唤醒，确保红绿灯数据连接的即时性与可靠性。

### 奥迪 RS 主题功能增强 (Audi RS Theme Enhancements)

- **行车数据扩展 (Extended Driving Data)**:
  - **新增传感器显示**: 在 Audi RS 主题中集成了 5 项新的实时行车数据：
    - **本次里程 (Current Trip)**: 显示自当天启动以来的行驶里程 (API: `getTripDistanceInCurrentDay`)。
    - **总里程 (Odometer)**: 显示车辆累计行驶总里程。
    - **行驶时长 (Trip Time)**: 显示当次行驶时间 (API: `getTripDuration`) (注: UI 暂时隐藏)。
    - **瞬时油耗 (Instant Fuel)**: 实时显示当前瞬时油耗 (L/100km)。
    - **车内温度 (Indoor Temp)**: 右上角显示当前车内温度。
  - **逻辑优化**:
    - 针对本次里程，弃用了不可靠的手动计算方案，通过反射调用 `ITripData` 系统级 API 获取精准的当天里程数据。
    - 实现了数据单位的自动换算 (m -> km) 和本地化文本显示 ("本次里程", "总里程", "耗时")。

### 标准仪表主题重构与优化 (Standard Cluster Theme Refactoring & Optimization)

- **全新标准主题实现 (New Standard Theme Implementation)**:
  - **架构重构**: 废弃了旧版 Style 1 (Default) 的硬编码布局，全面迁移至 `StandardThemeController` 进行统一管理。移除了冗余的 `THEME_STANDARD` 定义，将标准主题归位为 Default (ID=1)。
  - **布局扁平化**: 重写 `layout_cluster_standard.xml`，移除了多层嵌套的 `FrameLayout`，采用像素级 (`px`) 的绝对定位 (`marginStart`/`marginTop`)，实现了对每一层元素（背景、指针、文字、前景）的精确控制。
  - **资源替换与分层**:
    - 替换了原有的 Mask 和 Dial 方案，改用全新的分层渲染逻辑：底层背景 (`standard_bg`) -> 指针层 (`standard_pointer`) -> 顶层文字 -> 顶层前景 (`standard_foreground`)。
    - 解决了前景图层不合理遮挡文字的问题，将速度与档位文字提升至最顶层 (Z-order Top) 绘制。
    - 修复了背景与前景图层在 `fitXY` 模式下的拉伸变形问题，改用 `wrap_content` 配合 `layout_gravity` (Top/Bottom) 实现原比例完美显示。

- **指针与动画逻辑优化 (Pointer & Animation Logic)**:
  - **Refactor**: 全局恢复车速/转速浮点(Float)精度，彻底消除标准仪表指针抖动，提升平滑度。
  - **Feat**: 新增 HUD 转速显示组件 (`hud_rpm`)，支持右对齐布局，并采用 50rpm 取整策略优化显示效果。
  - **Fix**: 修复 Audi RS 主题在导航停止或无数据时，红绿灯/箭头组件暴露默认 XML 状态（三灯全亮、白箭头）的问题。通过设置默认可见性为 GONE 并在重置时显式隐藏解决。
  - **初始角度偏移**: 在 `StandardThemeController` 中引入了 `SPEED_START_ANGLE` (-130°) 和 `RPM_START_ANGLE` (-120°)，实现了指针逆时针偏转起始点的功能，完美适配新表盘设计。
  - **转速表适配**: 调整了转速表的最大偏转角度 (`MAX_RPM_ANGLE`) 为 240°，并同步了偏转逻辑。
  - **测试逻辑增强**: 更新了 `MainActivity` 中的速度测试逻辑，将测试范围从 0-230 km/h 扩展至 0-260 km/h，覆盖表盘全量程。

- **UI 细节打磨 (UI Polish)**:
  - **文字居中**: 对速度 (`standardSpeedText`) 和档位 (`standardGearText`) 进行了强制居中处理。固定宽度 (300px) + `gravity="center"` + 精确计算的 Pivot 偏移，确保无论数值位数如何变化，始终相对于表盘圆心绝对居中。
  - **预览图实时化**: 优化了仪表设置页的 Style 1 预览按钮。直接复用真实主题的背景与前景资源，去除了半透明效果，并添加了带阴影的“标准仪表”文字，所见即所得。
  - **致谢信息**: 在仪表设置页底部新增了致谢说明：“感谢抖音@某男仔（@mnz66666666）提供主题设计支持”。

### 档位显示修复 (Gear Display Fix)

- **状态同步修复 (State Synchronization Fix)**:
  - **问题**: 修复了在关闭“模拟档位计算”或切换仪表主题时，档位显示卡在 "P" 档的问题。
  - **原因**: 仪表控制器初始化默认为 P 档，当真实档位长期保持不变（如 D 档）时，管理器因检测到“数据无变化”而未推送更新。
  - **修复**:
    1. 在 `setClusterTheme`（切换主题）后，强制向新主题推送当前档位状态，确保 UI 初始化即同步。
    2. 在 `setSimulatedGearEnabled`（关闭模拟）时，清除历史去重记录 (`mLastSimulatedGear`) 并强制推送真实档位，即刻刷新 UI。

### 吉利红绿灯数据获取 (Geely Traffic Light Socket Integration)

- **Socket 通信实现**:
  - **`GeelySocketManager`**: 实现了本地 TCP Socket 客户端，连接 `127.0.0.1:9997` 读取吉利地图内部数据流。
  - **JSON 解析**: 针对 `cmdId: 20021` 消息进行精确解析，直接获取实时红绿灯倒计时数据 (Status, Red/Green Countdown, Direction)。
  - **智能唤醒与休眠 (Wake-up & Sleep)**:
    - **广播唤醒**: 利用 `AmapMonitorManager` 监听广播，一旦收到任何地图广播立即唤醒 Socket Client，确保地图启动时立即连接。
    - **超时休眠**: 连接断开或 5 分钟无数据交互自动进入休眠状态，释放系统资源。
  - **数据优先级**: 在 `NaviInfoController` 中集成了 Socket 数据源，优先使用 Socket 获取的精准倒计时覆盖广播数据。

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
