package cn.navitool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import cn.navitool.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵式红绿灯控件 (巡航模式专用)
 * 布局: 第一行 - 灯光+箭头, 第二行 - 数码倒计时
 * 固定3列: 左转、直行、右转, 居中对齐
 * 
 * [FIX] 样式匹配TrafficLightView: 整体胶囊边框、颜色、箭头
 * 灯本身无边框, 减小间距
 */
public class MatrixTrafficLightView extends View {
    private static final String TAG = "MatrixTrafficLightView";

    // === Status Constants (与 TrafficLightView 一致) ===
    public static final int STATUS_OFF = 0;
    public static final int STATUS_GREEN = 1;
    public static final int STATUS_RED = 2;
    public static final int STATUS_YELLOW = 3;

    public static final int DIRECTION_STRAIGHT = 0;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_UTURN = 3;

    // === Data ===
    private List<LightState> mLightStates = new ArrayList<>(); // Max 3

    // === Paint ===
    private Paint mPaintCircle;
    private Paint mPaintText;
    private Paint mPaintOutline;       // 整体边框
    private Paint mPaintBackground;    // 整体背景
    private Drawable mArrowDrawable;

    // === Dimensions (微调) ===
    private float mScale = 1.0f;
    private float mCircleDiameter = 28f;
    private float mGapHorizontal = 10f;  // [FIX] 灯间距稍微加大 (6→10)
    private float mGapVertical = 4f;     // 行间距
    private float mTextSize = 24f;       // 倒计时字号
    private float mPaddingH = 12f;       // [FIX] 左右内边距加宽 (支持3位数)
    private float mPaddingV = 6f;        // 上下内边距保持
    private float mOutlineStroke = 1.5f; // 边框宽度
    private float mBorderRadius = 8f;    // [FIX] 圆角半径减小

    // === Typeface ===
    private Typeface mDigitalTypeface;

    public MatrixTrafficLightView(Context context) {
        super(context);
        init(context);
    }

    public MatrixTrafficLightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MatrixTrafficLightView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        // Load DS-Digital font
        try {
            mDigitalTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/DS-Digital.ttf");
        } catch (Exception e) {
            mDigitalTypeface = Typeface.MONOSPACE;
        }

        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setStyle(Paint.Style.FILL);

        // [MATCH] 整体白色边框 (与TrafficLightView一致)
        mPaintOutline = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintOutline.setColor(Color.WHITE);
        mPaintOutline.setStyle(Paint.Style.STROKE);
        mPaintOutline.setStrokeCap(Paint.Cap.ROUND);

        // [MATCH] 整体背景 (与TrafficLightView一致: 0x99666666)
        mPaintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBackground.setStyle(Paint.Style.FILL);
        mPaintBackground.setColor(0x99666666);

        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTypeface(mDigitalTypeface);
        mPaintText.setFakeBoldText(true);

        // [MATCH] 使用与TrafficLightView相同的箭头drawable
        mArrowDrawable = ContextCompat.getDrawable(context, R.drawable.ic_direction_arrow);

        updateScaledDimensions();
    }

    // === Public API ===
    public void setPreviewScale(float scale) {
        if (mScale != scale) {
            mScale = scale;
            updateScaledDimensions();
            requestLayout();
            invalidate();
        }
    }
    
    // Alias for setPreviewScale for consistency with other views
    public void setScale(float scale) {
        setPreviewScale(scale);
    }

    private void updateScaledDimensions() {
        mPaintText.setTextSize(mTextSize * mScale);
        mPaintOutline.setStrokeWidth(mOutlineStroke * mScale);
    }

    // Semantically mapped slots: 0=Left, 1=Straight, 2=Right
    private LightState[] mSemanticSlots = new LightState[3]; 

    /**
     * 更新灯状态 (最多3个，分别对应 左/直/右)
     * [FIX] 使用语义映射: 方向决定位置，而不是列表顺序
     */
    public void updateLights(List<LightState> states) {
        // Reset slots
        for(int i=0; i<3; i++) mSemanticSlots[i] = null;
        mLightStates.clear(); // Keep for compatibility if needed, but we draw from slots

        if (states != null) {
            mLightStates.addAll(states); // Backup

            for (LightState state : states) {
                int slotIndex = 1; // Default to Center (Straight)

                if (state.direction == DIRECTION_LEFT || state.direction == DIRECTION_UTURN) {
                    slotIndex = 0; // Left Column
                } else if (state.direction == DIRECTION_RIGHT) {
                    slotIndex = 2; // Right Column
                } else {
                    slotIndex = 1; // Straight (0, 4, 8) -> Center Column
                }
                
                // Assign to slot
                mSemanticSlots[slotIndex] = state;
            }
        }
        
        requestLayout();
        invalidate();
    }

    /**
     * 设置预览模拟数据
     */
    public void setPreviewData() {
        List<LightState> preview = new ArrayList<>();
        preview.add(new LightState(STATUS_RED, 45, DIRECTION_LEFT));
        preview.add(new LightState(STATUS_GREEN, 32, DIRECTION_STRAIGHT));
        preview.add(new LightState(STATUS_RED, 45, DIRECTION_RIGHT));
        updateLights(preview);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Calculate desired size based on 3 circles + padding for horizontal layout
        float scaledCircle = mCircleDiameter * mScale;
        float scaledGapH = mGapHorizontal * mScale;
        float scaledGapV = mGapVertical * mScale;
        float scaledPaddingH = mPaddingH * mScale;
        float scaledPaddingV = mPaddingV * mScale;
        float scaledTextSize = mTextSize * mScale;

        // Width: 3 circles + 2 horizontal gaps + horizontal padding
        int desiredWidth = (int) ((scaledCircle * 3) + (scaledGapH * 2) + (scaledPaddingH * 2));
        
        // Height: 1 row of circles + 1 row of text + vertical gap + vertical padding
        int desiredHeight = (int) (scaledCircle + scaledGapV + scaledTextSize + (scaledPaddingV * 2));

        int measuredWidth = resolveSize(desiredWidth, widthMeasureSpec);
        int measuredHeight = resolveSize(desiredHeight, heightMeasureSpec);
        
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    // === Drawing ===
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Always draw 3 columns structure, even if empty? 
        // User asked for "placeholder" behavior if data is missing for a slot.
        // But if ALL are empty, maybe hide?
        // Let's check if we have ANY data to draw.
        boolean hasData = false;
        for(LightState s : mSemanticSlots) {
            if(s != null) { hasData = true; break; }
        }
        
        if (!hasData && mLightStates.isEmpty()) {
            return;
        }

        int viewWidth = getWidth();
        int viewHeight = getHeight();

        float scaledCircle = mCircleDiameter * mScale;
        float scaledGapH = mGapHorizontal * mScale;
        float scaledGapV = mGapVertical * mScale;
        float scaledTextSize = mTextSize * mScale;
        float scaledPaddingH = mPaddingH * mScale;
        float scaledPaddingV = mPaddingV * mScale;
        float scaledBorderRadius = mBorderRadius * mScale;
        float circleRadius = scaledCircle / 2f;

        // 总内容宽度 (不含padding)
        float contentWidth = (scaledCircle * 3) + (scaledGapH * 2);
        float startX = (viewWidth - contentWidth) / 2f;

        // [FIX] 绘制整体圆角矩形边框 (使用减小后的圆角半径)
        RectF borderRect = new RectF(
                startX - scaledPaddingH,
                0,
                startX + contentWidth + scaledPaddingH,
                viewHeight
        );
        
        // 绘制背景
        canvas.drawRoundRect(borderRect, scaledBorderRadius, scaledBorderRadius, mPaintBackground);
        // 绘制边框
        canvas.drawRoundRect(borderRect, scaledBorderRadius, scaledBorderRadius, mPaintOutline);

        // Row1 Y (圆心)
        float row1CenterY = scaledPaddingV + circleRadius;
        // Row2 Y (文字基线)
        float row2BaseY = scaledPaddingV + scaledCircle + scaledGapH + scaledTextSize * 0.85f; // [Fix] Use GapH or V? V is better. keeping V 

        // 绘制3列 (固定位置: 左/直/右)
        for (int i = 0; i < 3; i++) {
            float columnCenterX = startX + circleRadius + (i * (scaledCircle + scaledGapH));

            // Get state from Semantic Slots
            LightState state = mSemanticSlots[i];
            
            // === Row 1: 灯光圆 + 箭头 (无边框) ===
            if (state != null && state.status != STATUS_OFF) {
                int color = getStatusColor(state.status);
                
                // 绘制灯光圆 (无边框)
                mPaintCircle.setColor(color);
                canvas.drawCircle(columnCenterX, row1CenterY, circleRadius, mPaintCircle);

                // 绘制箭头
                if (mArrowDrawable != null) {
                    int direction = state.direction; // Use actual direction
                    drawRotatedArrow(canvas, columnCenterX, row1CenterY, (int) (circleRadius * 1.6f), direction);
                }
            } 
            // [CHANGE] Hide placeholders for cleaner UI
            // else { ... draw gray circle ... } -> Removed

            // === Row 2: 倒计时数字 ===
            if (state != null && state.time > 0) {
                mPaintText.setColor(getStatusColor(state.status));
                canvas.drawText(String.valueOf(state.time), columnCenterX, row2BaseY, mPaintText);
            } 
            // [CHANGE] Hide placeholder text
            // else { ... draw "--" ... } -> Removed
        }
    }

    private int getDefaultDirection(int columnIndex, int dataDirection) {
        // [FIX] Strict Semantic Mapping for placeholders
        switch (columnIndex) {
            case 0: return DIRECTION_LEFT;
            case 1: return DIRECTION_STRAIGHT;
            case 2: return DIRECTION_RIGHT;
            default: return DIRECTION_STRAIGHT;
        }
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
            case DIRECTION_LEFT: return -90f;
            case DIRECTION_RIGHT: return 90f;
            case DIRECTION_UTURN: return 180f;
            case DIRECTION_STRAIGHT:
            default: return 0f;
        }
    }

    // [MATCH] 与TrafficLightView一致的颜色
    private int getStatusColor(int status) {
        switch (status) {
            case STATUS_RED: return 0xFFFF4444;
            case STATUS_GREEN: return 0xFF44FF44;
            case STATUS_YELLOW: return 0xFFFFFF44;
            default: return Color.GRAY;
        }
    }

    // === Inner Class: Light State ===
    public static class LightState {
        public int status;
        public int time;
        public int direction;

        public LightState(int status, int time, int direction) {
            this.status = status;
            this.time = time;
            this.direction = direction;
        }
    }
}
