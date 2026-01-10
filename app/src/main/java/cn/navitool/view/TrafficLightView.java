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

/**
 * 自定义红绿灯控件
 * 支持：红/黄/绿灯显示，倒计时，以及方向箭头
 * 新设计：胶囊形轮廓 + 彩色圆形 + 方向箭头 + 倒计时
 */
public class TrafficLightView extends View {

    private Paint mPaintLight;
    private Paint mPaintText;
    private Paint mPaintOutline;
    private Drawable mArrowDrawable;

    // Data
    private int mStatus = 0; // 0=None, 1=Green, 2=Red, 3=Yellow
    private int mTime = 0;
    private int mDirection = 0; // 0=Straight, 1=Left, 2=Right, 4=...
    private int mDirectionOverride = -1;

    // Constants
    public static final int STATUS_NONE = 0;
    public static final int STATUS_GREEN = 1;
    public static final int STATUS_RED = 2;
    public static final int STATUS_YELLOW = 3;

    // Fixed sizes in pixels (for 星越L fixed screen density)
    // Fixed sizes in pixels (for 星越L fixed screen density)
    private static final float BASE_CIRCLE_DIAMETER = 24f;
    private static final float BASE_TEXT_SIZE = 24f;
    private static final float BASE_OUTLINE_STROKE = 1.5f;
    private static final float BASE_PADDING = 2f; // Tight wrap around text

    // Scaled dimensions
    private float mScale = 1.0f;
    private float mCircleDiameter = BASE_CIRCLE_DIAMETER;
    private float mTextSize = BASE_TEXT_SIZE;
    private float mOutlineStroke = BASE_OUTLINE_STROKE;
    private float mPadding = BASE_PADDING;

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

    public void setOverrideDirection(int direction) {
        this.mDirectionOverride = direction;
        this.mDirection = direction;
        invalidate();
    }

    /**
     * Set scale for preview mode (e.g. 2.0f for HUD preview)
     * This ensures the component is physically larger for measuring boundaries
     * correctly
     */
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
        mPadding = BASE_PADDING * mScale;

        if (mPaintText != null) {
            mPaintText.setTextSize(mTextSize);
        }
        if (mPaintOutline != null) {
            mPaintOutline.setStrokeWidth(mOutlineStroke);
        }
    }

    private void init() {
        // Light circle paint
        mPaintLight = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLight.setStyle(Paint.Style.FILL);

        // Text paint - fixed px size
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(mTextSize);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setFakeBoldText(true);

        // Outline paint for capsule
        mPaintOutline = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintOutline.setColor(Color.WHITE);
        mPaintOutline.setStyle(Paint.Style.STROKE);
        mPaintOutline.setStrokeWidth(mOutlineStroke);
        mPaintOutline.setStrokeCap(Paint.Cap.ROUND);

        // Load arrow drawable
        mArrowDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_direction_arrow);
    }

    /**
     * Update State
     */
    public void updateState(int status, int time, int direction) {
        boolean timeChanged = this.mTime != time;
        this.mStatus = status;
        this.mTime = time;
        if (mDirectionOverride != -1) {
            this.mDirection = mDirectionOverride;
        } else {
            this.mDirection = direction;
        }
        if (timeChanged) {
            requestLayout(); // Remeasure when time changes (different digit count)
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Calculate height based on text size + minimal padding for tight wrap
        // Use TEXT_SIZE directly as height basis with small padding
        // Scale the gap (8 becomes 8 * scale)
        float capsuleHeight = mTextSize + (8 * mScale);
        float radius = capsuleHeight / 2f;
        float textWidth = measureTextWidth();

        // Width = left semicircle + text area + right semicircle
        float calculatedWidth = radius + textWidth + radius;

        int w = resolveSize((int) calculatedWidth, widthMeasureSpec);
        int h = resolveSize((int) capsuleHeight, heightMeasureSpec);
        setMeasuredDimension(w, h);
    }

    private float measureTextWidth() {
        // This returns the width of CONTENT AREA after the circle
        // Layout: [left semicircle with circle] [gap] [text] [right semicircle]
        if (mTime > 0) {
            String timeStr = String.valueOf(mTime);
            float textActualWidth = mPaintText.measureText(timeStr);
            // gap (4px) + text + extra padding (4px for right side) -> Scale fixed values
            float gap = 4 * mScale;
            return gap + textActualWidth + gap;
        }
        return 0; // No text, just circle in left semicircle
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mStatus == STATUS_NONE) {
            return;
        }

        int width = getWidth();
        int height = getHeight();
        float centerY = height / 2f;
        float radius = height / 2f; // Use actual view height

        // 1. Draw Capsule Outline (mirrored half capsules)
        drawCapsuleOutline(canvas, width, height, radius);

        // 2. Get status color
        int color = getStatusColor();

        // 3. Draw circle with arrow in left semicircle area
        // 3. Draw circle with arrow in left semicircle area
        float circleCenterX = radius;
        float circleRadius = mCircleDiameter / 2f;

        // Draw colored circle
        mPaintLight.setColor(color);
        canvas.drawCircle(circleCenterX, centerY, circleRadius, mPaintLight);

        // Draw arrow on top of circle
        if (mArrowDrawable != null) {
            drawRotatedArrow(canvas, circleCenterX, centerY, (int) (circleRadius * 1.6f));
        }

        // 4. Draw countdown text - left aligned after circle with gap
        if (mTime > 0) {
            String timeStr = String.valueOf(mTime);
            mPaintText.setColor(color);
            mPaintText.setTextAlign(Paint.Align.LEFT); // Left align for proper positioning

            Paint.FontMetrics fm = mPaintText.getFontMetrics();
            float textY = centerY - (fm.top + fm.bottom) / 2f;
            // Position text after circle with gap: circle end (radius + circleRadius) + gap
            float gap = 4 * mScale;
            float textX = radius + circleRadius + gap;

            canvas.drawText(timeStr, textX, textY, mPaintText);
        }
    }

    private void drawCapsuleOutline(Canvas canvas, int width, int height, float radius) {
        // Add offset for stroke width to prevent clipping
        float offset = mOutlineStroke / 2f;
        float h = height - offset * 2;
        float r = h / 2f;

        Path capsulePath = new Path();

        // Left semicircle
        RectF leftArc = new RectF(offset, offset, r * 2 + offset, h + offset);
        capsulePath.addArc(leftArc, 90, 180);

        // Top line
        capsulePath.moveTo(r + offset, offset);
        capsulePath.lineTo(width - r - offset, offset);

        // Right semicircle
        RectF rightArc = new RectF(width - r * 2 - offset, offset, width - offset, h + offset);
        capsulePath.addArc(rightArc, -90, 180);

        // Bottom line
        capsulePath.moveTo(width - r - offset, h + offset);
        capsulePath.lineTo(r + offset, h + offset);

        canvas.drawPath(capsulePath, mPaintOutline);
    }

    private void drawRotatedArrow(Canvas canvas, float cx, float cy, int size) {
        if (mArrowDrawable == null)
            return;

        canvas.save();

        // Rotate based on direction
        float rotation = getArrowRotation();
        canvas.rotate(rotation, cx, cy);

        // Center the drawable
        int halfSize = size / 2;
        mArrowDrawable.setBounds(
                (int) (cx - halfSize),
                (int) (cy - halfSize),
                (int) (cx + halfSize),
                (int) (cy + halfSize));
        mArrowDrawable.draw(canvas);

        canvas.restore();
    }

    private float getArrowRotation() {
        switch (mDirection) {
            case 1:
                return -90f; // Left turn
            case 2:
                return 90f; // Right turn
            case 3:
                return 180f; // U-turn
            case 0:
            case 4:
            default:
                return 0f; // Straight
        }
    }

    private int getStatusColor() {
        switch (mStatus) {
            case STATUS_RED:
                return 0xFFFF4444;
            case STATUS_GREEN:
                return 0xFF44FF44;
            case STATUS_YELLOW:
                return 0xFFFFFF44;
            default:
                return Color.GRAY;
        }
    }
}
