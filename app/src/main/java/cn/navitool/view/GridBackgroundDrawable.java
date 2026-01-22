package cn.navitool.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GridBackgroundDrawable extends Drawable {
    private final Paint mPaint;
    private final Paint mBgPaint;
    private static final int GRID_SIZE = 50;

    public GridBackgroundDrawable() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        // Dashed: 5px line, 5px gap
        mPaint.setPathEffect(new DashPathEffect(new float[] { 5, 5 }, 0));
        mPaint.setAlpha(128); // 50% Opacity
        // Disable AntiAlias for performance and sharpness on vertical/horizontal lines
        mPaint.setAntiAlias(false);

        mBgPaint = new Paint();
        mBgPaint.setColor(Color.BLACK);
        mBgPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        // 1. Draw Black Background (Bottom Layer)
        canvas.drawRect(getBounds(), mBgPaint);

        // 2. Draw Grid Lines
        int width = getBounds().width();
        int height = getBounds().height();
        int centerX = width / 2;
        int centerY = height / 2;

        // Vertical Lines
        for (int x = centerX; x < width; x += GRID_SIZE) {
            canvas.drawLine(x, 0, x, height, mPaint);
        }
        for (int x = centerX - GRID_SIZE; x >= 0; x -= GRID_SIZE) {
            canvas.drawLine(x, 0, x, height, mPaint);
        }

        // Horizontal Lines
        for (int y = centerY; y < height; y += GRID_SIZE) {
            canvas.drawLine(0, y, width, y, mPaint);
        }
        for (int y = centerY - GRID_SIZE; y >= 0; y -= GRID_SIZE) {
            canvas.drawLine(0, y, width, y, mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable android.graphics.ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
