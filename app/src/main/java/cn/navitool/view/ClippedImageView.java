package cn.navitool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Shader;
import android.util.AttributeSet;
// [FIX] Use standard ImageView for better compatibility (doesn't require AppCompat Theme)
import android.widget.ImageView;
import androidx.annotation.Nullable;

/**
 * 支持斜向裁剪的ImageView
 * 用于奥迪RS转速进度条效果
 */
// [FIX] Extends ImageView instead of AppCompatImageView to avoid "You need to
// use a Theme.AppCompat theme" crash
public class ClippedImageView extends ImageView {

    // 裁剪参数
    private float mClipProgress = 1.0f; // 0-1，裁剪进度
    private float mClipAngle = 33f; // 裁剪线与Y轴的夹角（度）
    private int mContentStartX = 0; // 内容起始X坐标（缩放后）
    private int mContentEndX = 0; // 内容结束X坐标（缩放后）
    private boolean mClipEnabled = false; // 是否启用裁剪

    private Path mClipPath = new Path();

    public ClippedImageView(Context context) {
        super(context);
    }

    public ClippedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClippedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置裁剪参数
     * 
     * @param progress      进度 0-1
     * @param contentStartX 内容起始X（缩放后像素）
     * @param contentEndX   内容结束X（缩放后像素）
     */
    public void setClipProgress(float progress, int contentStartX, int contentEndX) {
        mClipProgress = Math.max(0, Math.min(1, progress));
        mContentStartX = contentStartX;
        mContentEndX = contentEndX;
        mClipEnabled = true;
        invalidate();
    }

    /**
     * 设置裁剪角度
     * 
     * @param angle 裁剪线与Y轴的夹角（度），正值向左倾斜
     */
    public void setClipAngle(float angle) {
        mClipAngle = angle;
        invalidate();
    }

    /**
     * 禁用裁剪，显示完整图片
     */
    public void disableClip() {
        mClipEnabled = false;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!mClipEnabled || mClipProgress >= 1.0f) {
            // 不裁剪或完全显示
            super.onDraw(canvas);
            return;
        }

        if (mClipProgress <= 0) {
            // 完全不显示
            return;
        }

        int width = getWidth();
        int height = getHeight();

        if (width <= 0 || height <= 0) {
            super.onDraw(canvas);
            return;
        }

        // 计算裁剪边界X坐标
        int contentWidth = mContentEndX - mContentStartX;
        float clipX = mContentStartX + (contentWidth * mClipProgress);

        // 计算斜边偏移量
        // tan(angle) = 斜边水平偏移 / 高度
        // 15度角: tan(15°) ≈ 0.268
        float tanAngle = (float) Math.tan(Math.toRadians(mClipAngle));
        float topOffset = height * tanAngle; // 顶部相对于底部的X偏移

        // 构建裁剪路径（平行四边形）
        // 裁剪线从底部clipX向上延伸到顶部(clipX - topOffset)
        mClipPath.reset();
        mClipPath.moveTo(0, 0); // 左上角
        mClipPath.lineTo(clipX - topOffset, 0); // 裁剪线顶部
        mClipPath.lineTo(clipX, height); // 裁剪线底部
        mClipPath.lineTo(0, height); // 左下角
        mClipPath.close();

        // 应用裁剪
        canvas.save();
        canvas.clipPath(mClipPath);
        super.onDraw(canvas);
        canvas.restore();
    }
}
