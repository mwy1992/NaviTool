package cn.navitool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 自定义红绿灯控件
 * 支持：红/黄/绿灯显示，倒计时，以及方向箭头
 */
public class TrafficLightView extends android.view.View {

    private Paint mPaintLight;
    private Paint mPaintText;
    private Paint mPaintBg;

    // Data
    private int mStatus = 0; // 0=None, 1=Green, 2=Red, 3=Yellow
    private int mTime = 0;
    private int mDirection = 0; // 0=Straight, 1=Left, 2=Right
    private int mDirectionOverride = -1; // -1=None, 0=Straight, 1=Left, 2=Right

    // Constants
    public static final int STATUS_NONE = 0;
    public static final int STATUS_GREEN = 1;
    public static final int STATUS_RED = 2;
    public static final int STATUS_YELLOW = 3;

    public TrafficLightView(Context context) {
        super(context);
        init();
    }

    // ... Constructors ...

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

    private void init() {
        // ...
        mPaintLight = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLight.setStyle(Paint.Style.FILL);
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(48f);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setFakeBoldText(true);
        mPaintBg = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBg.setColor(0x40000000); // 黑色半透明背景
        mPaintBg.setStyle(Paint.Style.FILL);
    }

    /**
     * Update State
     */
    public void updateState(int status, int time, int direction) {
        this.mStatus = status;
        this.mTime = time;
        if (mDirectionOverride != -1) {
            this.mDirection = mDirectionOverride;
        } else {
            this.mDirection = direction;
        }
        invalidate(); // Request redraw
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Default size 120x60 dp approx
        int w = resolveSize(200, widthMeasureSpec);
        int h = resolveSize(100, heightMeasureSpec);
        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Debug Log
        // android.util.Log.d("TrafficLightView", "onDraw: status=" + mStatus + " time="
        // + mTime);

        if (mStatus == STATUS_NONE)
            return;

        int width = getWidth();
        int height = getHeight();

        // Layout: [Arrow] [Light] [Text]
        // Section widths: 25% | 35% | 40%
        int arrowWidth = width / 4;
        int lightWidth = width * 35 / 100;
        int textWidth = width - arrowWidth - lightWidth;

        int arrowCenterX = arrowWidth / 2;
        int lightCenterX = arrowWidth + lightWidth / 2;
        int textCenterX = arrowWidth + lightWidth + textWidth / 2;

        int centerY = height / 2;

        // 1. Draw Direction Arrow
        // constants based on Amap: 0=Straight, 1=Left, 2=Right
        // Color: Same as light or White? White is better for visibility.
        mPaintBg.setColor(Color.WHITE);
        mPaintBg.setStyle(Paint.Style.STROKE);
        mPaintBg.setStrokeWidth(8f); // Thicker line
        mPaintBg.setStrokeCap(Paint.Cap.ROUND);
        mPaintBg.setStrokeJoin(Paint.Join.ROUND);

        Path arrowPath = new Path();
        float arrowSize = height * 0.4f;
        float ax = arrowCenterX;
        float ay = centerY;

        if (mDirection == 1) { // Left
            // <-- (Turn Left Shape)
            // Vertical part
            arrowPath.moveTo(ax + arrowSize / 2, ay + arrowSize / 2);
            arrowPath.lineTo(ax + arrowSize / 2, ay);
            // Curve or sharp turn? Sharp for now
            arrowPath.lineTo(ax - arrowSize / 2, ay);
            // Arrowhead
            arrowPath.lineTo(ax - arrowSize / 2 + 10, ay - 10);
            arrowPath.moveTo(ax - arrowSize / 2, ay);
            arrowPath.lineTo(ax - arrowSize / 2 + 10, ay + 10);
        } else if (mDirection == 2) { // Right
            // --> (Turn Right Shape)
            arrowPath.moveTo(ax - arrowSize / 2, ay + arrowSize / 2);
            arrowPath.lineTo(ax - arrowSize / 2, ay);
            arrowPath.lineTo(ax + arrowSize / 2, ay);
            arrowPath.lineTo(ax + arrowSize / 2 - 10, ay - 10);
            arrowPath.moveTo(ax + arrowSize / 2, ay);
            arrowPath.lineTo(ax + arrowSize / 2 - 10, ay + 10);
        } else if (mDirection == 0) { // Straight / Generic
            // [CHANGE] Do NOT draw arrow for 0.
            // 0 often means "Round Light" or "Main Light" which applies to multiple
            // directions.
        }

        if (!arrowPath.isEmpty()) {
            canvas.drawPath(arrowPath, mPaintBg);
        }

        // 2. Draw Light Circle
        int color = Color.GRAY;
        if (mStatus == STATUS_RED)
            color = 0xFFFF4444; // Red
        else if (mStatus == STATUS_GREEN)
            color = 0xFF44FF44; // Green
        else if (mStatus == STATUS_YELLOW)
            color = 0xFFFFFF44; // Yellow

        mPaintLight.setColor(color);
        // Radius based on available height, keep alignment
        float r = (Math.min(lightWidth, height) * 0.8f) / 2f;
        canvas.drawCircle(lightCenterX, centerY, r, mPaintLight);

        // 3. Draw Countdown Text
        if (mTime > 0) {
            String timeStr = String.valueOf(mTime);
            mPaintText.setColor(color); // Match light color
            mPaintText.setTextSize(height * 0.6f);

            Paint.FontMetrics fontMetrics = mPaintText.getFontMetrics();
            float baseLineY = centerY - (fontMetrics.top + fontMetrics.bottom) / 2;

            // Draw centered in text area
            canvas.drawText(timeStr, textCenterX, baseLineY, mPaintText);
        }
    }
}
