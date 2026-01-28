package cn.navitool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import cn.navitool.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义红绿灯控件 - 多灯版
 * 支持：1-3 个灯水平排列显示 (长胶囊样式)
 * 绘制顺序：统一胶囊背景 -> 多个 (圆形 + 箭头 + 倒计时)
 * 对齐方式：ALIGN_LEFT (左对齐), ALIGN_RIGHT (右对齐), ALIGN_CENTER (居中对齐)
 */
public class TrafficLightView extends View {

    // --- Paint Objects ---
    private Paint mPaintLight;
    private Paint mPaintText;
    private Paint mPaintOutline;
    private Paint mPaintBackground;
    private Drawable mArrowDrawable;

    // --- Multi-Light Data ---
    private List<LightState> mLightStates = new ArrayList<>();

    // --- Alignment ---
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 1;
    public static final int ALIGN_CENTER = 2;
    private int mAlignment = ALIGN_LEFT;

    // --- Status Constants ---
    public static final int STATUS_NONE = 0;
    public static final int STATUS_GREEN = 1;
    public static final int STATUS_RED = 2;
    public static final int STATUS_YELLOW = 3;

    // --- Single Light Backward Compatibility ---
    private int mStatus = 0;
    private int mTime = 0;
    private int mDirection = 0;
    private int mDirectionOverride = -1;

    // --- Fixed sizes in pixels (for 星越L fixed screen density) ---
    private static final float BASE_CIRCLE_DIAMETER = 24f;
    private static final float BASE_TEXT_SIZE = 24f;
    private static final float BASE_OUTLINE_STROKE = 1.5f;
    private static final float BASE_GAP = 4f;
    private static final float BASE_LIGHT_SPACING = 8f; // 灯与灯之间的间距

    // --- Scaled dimensions ---
    private float mScale = 1.0f;
    private float mCircleDiameter = BASE_CIRCLE_DIAMETER;
    private float mTextSize = BASE_TEXT_SIZE;
    private float mOutlineStroke = BASE_OUTLINE_STROKE;
    private float mGap = BASE_GAP;
    private float mLightSpacing = BASE_LIGHT_SPACING;

    // --- 内部类：单个灯的状态 ---
    public static class LightState {
        public int status;    // 0=None, 1=Green, 2=Red, 3=Yellow
        public int time;      // Countdown seconds
        public int direction; // 0=Straight, 1=Left, 2=Right, 3=U-turn

        public LightState(int status, int time, int direction) {
            this.status = status;
            this.time = time;
            this.direction = direction;
        }

        // For Diff check
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LightState that = (LightState) o;
            return status == that.status && time == that.time && direction == that.direction;
        }
    }

    // --- Constructors ---
    public TrafficLightView(Context context) {
        super(context);
        init();
    }

    public TrafficLightView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TrafficLightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaintLight = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLight.setStyle(Paint.Style.FILL);

        mPaintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBackground.setColor(0x99666666);
        mPaintBackground.setStyle(Paint.Style.FILL);

        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(mTextSize);
        mPaintText.setTextAlign(Paint.Align.LEFT);
        mPaintText.setFakeBoldText(true);

        mPaintOutline = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintOutline.setColor(Color.WHITE);
        mPaintOutline.setStyle(Paint.Style.STROKE);
        mPaintOutline.setStrokeWidth(mOutlineStroke);
        mPaintOutline.setStrokeCap(Paint.Cap.ROUND);

        mArrowDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_direction_arrow);
    }

    // --- Public API: Alignment ---
    public void setAlignment(int alignment) {
        this.mAlignment = alignment;
        invalidate();
    }

    // --- Public API: Scale ---
    public void setPreviewScale(float scale) {
        this.mScale = scale;
        updateScaledDimensions();
        requestLayout();
        invalidate();
    }

    private void updateScaledDimensions() {
        mCircleDiameter = BASE_CIRCLE_DIAMETER * mScale;
        mTextSize = BASE_TEXT_SIZE * mScale;
        mOutlineStroke = BASE_OUTLINE_STROKE * mScale;
        mGap = BASE_GAP * mScale;
        mLightSpacing = BASE_LIGHT_SPACING * mScale;

        if (mPaintText != null) {
            mPaintText.setTextSize(mTextSize);
        }
        if (mPaintOutline != null) {
            mPaintOutline.setStrokeWidth(mOutlineStroke);
        }
    }

    // --- Public API: Multi-Light Update (New) ---
    /**
     * 更新多灯状态。使用 Diff 检查，仅当数据变化时才重绘。
     * @param states 灯状态列表 (1-3 个)
     */
    public void updateMultiLights(List<LightState> states) {
        if (states == null) {
            states = new ArrayList<>();
        }

        // Diff Check: Only redraw if data changed
        boolean changed = false;
        if (states.size() != mLightStates.size()) {
            changed = true;
        } else {
            for (int i = 0; i < states.size(); i++) {
                if (!states.get(i).equals(mLightStates.get(i))) {
                    changed = true;
                    break;
                }
            }
        }

        if (changed) {
            mLightStates = new ArrayList<>(states);
            requestLayout();
            invalidate();
        }
    }

    // --- Public API: Single Light Update (Backward Compatible) ---
    public void updateState(int status, int time, int direction) {
        boolean hasChange = (this.mStatus != status || this.mTime != time || this.mDirection != direction);
        
        this.mStatus = status;
        this.mTime = time;
        if (mDirectionOverride != -1) {
            this.mDirection = mDirectionOverride;
        } else {
            this.mDirection = direction;
        }

        // Convert to single-item list for unified drawing
        mLightStates.clear();
        if (status != STATUS_NONE) {
            mLightStates.add(new LightState(status, time, this.mDirection));
        }
        
        if (hasChange) {
            requestLayout();
            invalidate();
        }
    }

    public void setOverrideDirection(int direction) {
        this.mDirectionOverride = direction;
        this.mDirection = direction;
        invalidate();
    }

    // --- Virtual Slots (for HUD alignment) ---
    private int mMaxSlots = 0;

    public void setMaxSlots(int maxSlots) {
        this.mMaxSlots = maxSlots;
        requestLayout();
        invalidate();
    }

    // --- Measurement ---
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float capsuleHeight = mTextSize + (8 * mScale);
        
        // 如果设置了最大槽位数，则按照最大槽位数计算宽度（强制扩展 View 宽度）
        // 否则按照实际灯数量计算
        float measuredContentWidth;
        if (mMaxSlots > 0) {
            measuredContentWidth = calculateTotalContentWidth(mMaxSlots);
        } else {
            measuredContentWidth = calculateTotalContentWidth(mLightStates.size());
        }

        int w = resolveSize((int) measuredContentWidth, widthMeasureSpec);
        int h = resolveSize((int) capsuleHeight, heightMeasureSpec);
        setMeasuredDimension(w, h);
    }

    private float calculateTotalContentWidth() {
        return calculateTotalContentWidth(mLightStates.size());
    }

    private float calculateTotalContentWidth(int count) {
        if (count == 0) {
            return 0;
        }

        float totalWidth = 0;
        float circleRadius = mCircleDiameter / 2f;
        float capsuleRadius = (mTextSize + (8 * mScale)) / 2f; // 半圆端盖的 radius
        
        // [FIX] 使用固定的三位数占位宽度 (如 "888")，支持到 999 秒的倒计时
        float placeholderTextWidth = mPaintText.measureText("888");

        for (int i = 0; i < count; i++) {
            if (i == 0) {
                // 第一个灯：圆形中心在 capsuleRadius 位置，所以只算右半部分
                totalWidth += capsuleRadius + circleRadius;
            } else {
                // 后续灯：完整的圆直径
                totalWidth += mCircleDiameter;
            }
            
            // [FIX] 始终为每个灯预留文字宽度（使用占位宽度），即使 time = 0
            totalWidth += mGap + placeholderTextWidth;
            
            // Spacing between lights
            if (i < count - 1) {
                totalWidth += mLightSpacing;
            }
        }
        
        // 最后加上右半圆端盖的空间 (约 4dp)
        totalWidth += mGap;
        
        return totalWidth;
    }

    // --- Drawing ---
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mLightStates.isEmpty()) {
            return;
        }

        int viewWidth = getWidth();
        int viewHeight = getHeight();
        float centerY = viewHeight / 2f;
        float capsuleRadius = viewHeight / 2f;



        // 2. Calculate content start based on alignment (relative to the full view width)
        float contentWidth = calculateTotalContentWidth(); // This calculates ACTUAL content width (based on mLightStates.size())
        
        // 1. Draw Capsule Background (Only around actual content)
        // Background start/end depends on alignment
        float bgStart = 0;
        float bgEnd = 0;

        float circleRadius = mCircleDiameter / 2f;
        
        // 第一个圆的中心 X 位置（原来设计：圆心在 capsuleRadius）
        float firstCircleCenterX;
        switch (mAlignment) {
            case ALIGN_RIGHT:
                // 右对齐：最后内容靠右，第一个圆心 = viewWidth - (contentWidth - capsuleRadius)
                // bgStart = viewWidth - contentWidth
                bgStart = viewWidth - contentWidth;
                bgEnd = viewWidth;
                firstCircleCenterX = viewWidth - contentWidth + capsuleRadius;
                break;
            case ALIGN_CENTER:
                // 居中对齐：内容居中
                bgStart = (viewWidth - contentWidth) / 2f;
                bgEnd = bgStart + contentWidth;
                firstCircleCenterX = bgStart + capsuleRadius;
                break;
            case ALIGN_LEFT:
            default:
                // 左对齐：第一个圆心在 capsuleRadius 位置
                bgStart = 0;
                bgEnd = contentWidth;
                firstCircleCenterX = capsuleRadius;
                break;
        }
        
        // Draw the background capsule ONLY for the actual content area
        drawCapsuleOutline(canvas, bgStart, bgEnd, viewHeight, capsuleRadius);

        // 3. Draw each light
        float currentCircleCenterX = firstCircleCenterX;

        for (int i = 0; i < mLightStates.size(); i++) {
            LightState light = mLightStates.get(i);
            if (light.status == STATUS_NONE) continue;

            int color = getStatusColor(light.status);

            // Draw Circle
            mPaintLight.setColor(color);
            canvas.drawCircle(currentCircleCenterX, centerY, circleRadius, mPaintLight);

            // Draw Arrow inside circle
            if (mArrowDrawable != null) {
                drawRotatedArrow(canvas, currentCircleCenterX, centerY, (int) (circleRadius * 1.6f), light.direction);
            }

            // Draw Countdown Text (在固定占位宽度区域内居中)
            float placeholderTextWidth = mPaintText.measureText("888"); // 与 calculateTotalContentWidth 保持一致
            float textAreaStartX = currentCircleCenterX + circleRadius + mGap;
            
            if (light.time > 0) {
                String timeStr = String.valueOf(light.time);
                float actualTextWidth = mPaintText.measureText(timeStr);
                
                // [FIX] 文字在占位区域内居中
                float centeredTextX = textAreaStartX + (placeholderTextWidth - actualTextWidth) / 2f;
                
                mPaintText.setColor(color);
                Paint.FontMetrics fm = mPaintText.getFontMetrics();
                float textY = centerY - (fm.top + fm.bottom) / 2f;
                canvas.drawText(timeStr, centeredTextX, textY, mPaintText);
            }
            
            // 始终按照固定占位宽度移动到下一个位置
            currentCircleCenterX = textAreaStartX + placeholderTextWidth + mLightSpacing + circleRadius;
        }
    }

    private void drawCapsuleOutline(Canvas canvas, float startX, float endX, int height, float radius) {
        float offset = mOutlineStroke / 2f;
        float h = height - offset * 2;
        float r = h / 2f;

        Path capsulePath = new Path();
        // RectF(left, top, right, bottom)
        RectF rect = new RectF(startX + offset, offset, endX - offset, height - offset);
        capsulePath.addRoundRect(rect, r, r, Path.Direction.CW);

        canvas.drawPath(capsulePath, mPaintBackground);
        canvas.drawPath(capsulePath, mPaintOutline);
    }

    private void drawRotatedArrow(Canvas canvas, float cx, float cy, int size, int direction) {
        if (mArrowDrawable == null) return;

        canvas.save();
        float rotation = getArrowRotation(direction);
        canvas.rotate(rotation, cx, cy);

        int halfSize = size / 2;
        mArrowDrawable.setBounds(
                (int) (cx - halfSize),
                (int) (cy - halfSize),
                (int) (cx + halfSize),
                (int) (cy + halfSize));
        mArrowDrawable.draw(canvas);
        canvas.restore();
    }

    private float getArrowRotation(int direction) {
        switch (direction) {
            case 1: return -90f;  // Left
            case 2: return 90f;   // Right
            case 3: return 180f;  // U-turn
            case 0:
            case 4:
            default: return 0f;   // Straight
        }
    }

    private int getStatusColor(int status) {
        switch (status) {
            case STATUS_RED: return 0xFFFF4444;
            case STATUS_GREEN: return 0xFF44FF44;
            case STATUS_YELLOW: return 0xFFFFFF44;
            default: return Color.GRAY;
        }
    }

    // --- Legacy method for backward compatibility ---
    private float getArrowRotation() {
        return getArrowRotation(mDirection);
    }

    private int getStatusColor() {
        return getStatusColor(mStatus);
    }
}
