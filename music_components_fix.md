# 歌曲信息组件显示异常分析与修复报告

## 1. 问题复盘

用户反馈歌曲信息组件（`song_2line` 等）在贴边放置时被裁剪，并且在预览界面也能看到超出 HUD 区域的情况。这源于一个为了移除文字上下空白而设计的由于文字 padding 产生的边界容差设置。

## 2. 根因分析

- **现象**：普通文本（如数字）因为字形原因，即使去掉了 padding，顶部仍有留白，因此系统允许它们向上偏移 `0.2f`（约 20% 字号）来达到视觉贴边。
- **冲突**：中文歌曲名因为也是方块字，几乎填满了整个行高。如果同样应用 `0.2f` 的向上偏移，就会导致实际像素被裁剪。

## 3. 修复方案实施

我们已对 **Runtime**（实际显示）和 **Preview**（编辑预览）两处代码进行了修改，实现了：

1. **歌曲组件豁免**：强制歌曲组件的修正值为 0。
2. **上下边距分离**：将原本统一的 `tolerance` 拆分为 `Top` 和 `Bottom`，允许分别设置。

### 3.1 修复 HUD 渲染 (`Presentation.java`)

我们引入了两个变量 `FACTOR_TOP` 和 `FACTOR_BOTTOM`，方便后续精细调整。

```java
// Presentation.java
// 可在此处手动修改上下边距的倍率
float FACTOR_TOP = 0.2f;    // 顶部允许出界 20%
float FACTOR_BOTTOM = 0.2f; // 底部允许出界 20%

boolean isMusicComponent = "song_2line".equals(data.type) || ... ;

if (isMusicComponent) {
    // [Fix] 歌曲组件强制为0，禁止出界
    toleranceTop = 0f;
    toleranceBottom = 0f;
} else if (view instanceof TextView) {
    // 其他组件使用全局倍率
    toleranceTop = currentSize * FACTOR_TOP * data.scale;
    toleranceBottom = currentSize * FACTOR_BOTTOM * data.scale;
}
```

### 3.2 修复 预览拖拽限制 (`MainActivity.java`)

同样在拖拽逻辑中引入了分离的倍率变量，确保编辑体验与实际显示一致。

```java
// MainActivity.java
float FACTOR_TOP = 0.2f;
float FACTOR_BOTTOM = 0.2f;

if (isMusicComponent) {
    offsetTop = 0;
    offsetBottom = 0;
} else {
    offsetTop = scaledTextSize * FACTOR_TOP;
    offsetBottom = scaledTextSize * FACTOR_BOTTOM;
}

// 边界检查：分别使用 Top 和 Bottom 限制
if (newY < -offsetTop) newY = -offsetTop;
if (newY + viewHeight > parentHeight + offsetBottom) ...
```

## 4. 自定义调整指南

如果您觉得现在的贴边效果还可以优化（例如顶部太紧或太松），可以直接在上述两个文件中搜索 `FACTOR_TOP` 或 `FACTOR_BOTTOM` 并修改数值：

- **FACTOR_TOP**: 增大此值允许组件更靠上（甚至出界），减小此值则让组件位置更保守（不容易被切）。
- **FACTOR_BOTTOM**: 同理，控制底部的出界宽容度。

## 5. 结果验证

- **歌曲组件**：严格受限在边界内，彻底杜绝裁剪。
- **其他组件**：保持原有的 0.2f 优化，视觉上依旧紧凑贴边。
