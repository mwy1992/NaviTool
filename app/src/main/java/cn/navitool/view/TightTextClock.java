package cn.navitool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextClock;

public class TightTextClock extends TextClock {

    private Rect mBounds = new Rect();

    public TightTextClock(Context context) {
        super(context);
        init();
    }

    public TightTextClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TightTextClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setIncludeFontPadding(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        String text = getText().toString();
        Paint paint = getPaint();

        if (text.length() > 0) {
            paint.getTextBounds(text, 0, text.length(), mBounds);
        } else {
            // Measure dummy text if empty to establish height?
            paint.getTextBounds("00:00", 0, 5, mBounds);
        }

        int width = mBounds.width();
        int height = mBounds.height();

        setMeasuredDimension(resolveSize(width, widthMeasureSpec),
                resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = getText().toString();
        if (text.length() > 0) {
            Paint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            
            // Recalculate bounds to be safe or reuse mBounds if valid?
            // Safer to recalc for draw position
            paint.getTextBounds(text, 0, text.length(), mBounds);

            // Tight drawing at (0,0) relative to bounds
            // This aligns Top-Left
            canvas.drawText(text, -mBounds.left, -mBounds.top, paint);
        }
    }
}
