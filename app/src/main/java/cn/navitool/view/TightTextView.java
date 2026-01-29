package cn.navitool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import android.widget.TextView;

public class TightTextView extends TextView {

    private Rect mBounds = new Rect();
    private Rect mTempBounds = new Rect();

    // Digit size ratio for subscript effect (60%)
    private static final float SUBSCRIPT_RATIO = 0.7f;
    // Spacing between letter and subscript (as ratio of letter width)
    private static final float SUBSCRIPT_SPACING_RATIO = 0.01f;

    public TightTextView(Context context) {
        super(context);
        init();
    }

    public TightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TightTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setIncludeFontPadding(false);
    }

    @Override
    public int getBaseline() {
        // Return the baseline offset from the top of the view.
        // In onMeasure/onDraw, we assume the text baseline is at -mBounds.top 
        // relative to the "tight" bounds starting at (0,0).
        if (mBounds != null) {
            return -mBounds.top;
        }
        return super.getBaseline();
    }

    @Override
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        requestLayout();
        invalidate();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        requestLayout();
        invalidate();
    }

    // Check if text is gear pattern (letter followed by optional digit)
    private boolean isGearPattern(String text) {
        if (text == null || text.isEmpty())
            return false;
        char first = text.charAt(0);
        boolean isGearLetter = (first == 'P' || first == 'R' || first == 'N' || first == 'D' || first == 'M' ||
                first == 'p' || first == 'r' || first == 'n' || first == 'd' || first == 'm');
        return isGearLetter && text.length() <= 3; // e.g., "D", "D3", "M8"
    }

    // Find where digits start in the text
    private int findDigitStart(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= '0' && c <= '9') {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        String text = getText().toString();
        Paint paint = getPaint();
        
        boolean isGear = isGearPattern(text);
        
        int textWidth = 0;
        int textHeight = 0;

        if (text.length() > 0) {
            if (isGear) {
                // [FIX] Gear Logic: Symmetric "M-Slot" Layout
                // Total Width = 2 * M + Spacing (Symmetric to center)
                
                // Measure 'M' for slot width
                float mWidth = paint.measureText("M");
                paint.getTextBounds("M", 0, 1, mBounds);
                textHeight = mBounds.height();
                
                int spacing = (int) (mWidth * SUBSCRIPT_SPACING_RATIO);
                
                // Reserve full symmetric width regardless of content (to support centering)
                textWidth = (int) Math.ceil(mWidth * 2 + spacing);
            } else {
                 // Regular text
                 textWidth = (int) Math.ceil(paint.measureText(text));
                 paint.getTextBounds(text, 0, text.length(), mBounds);
                 textHeight = mBounds.height();
            }
        } else {
             paint.getTextBounds("M", 0, 1, mBounds);
             textHeight = mBounds.height();
        }

        // Account for Compound Drawables (Start/Left only)
        android.graphics.drawable.Drawable[] drawables = getCompoundDrawablesRelative();
        android.graphics.drawable.Drawable drawableStart = drawables[0];
        if (drawableStart == null) {
            drawables = getCompoundDrawables();
            drawableStart = drawables[0];
        }

        int totalWidth = textWidth;
        int maxHeight = textHeight;

        if (drawableStart != null) {
            int iconHeight = maxHeight;
            if (iconHeight <= 0) iconHeight = (int) paint.getTextSize();

            int intrinsicH = drawableStart.getIntrinsicHeight();
            int intrinsicW = drawableStart.getIntrinsicWidth();
            int iconWidth;
            if (intrinsicH > 0 && intrinsicW > 0) {
                float ratio = (float) intrinsicW / intrinsicH;
                iconWidth = (int) (iconHeight * ratio);
            } else {
                iconWidth = iconHeight;
            }

            totalWidth += iconWidth + getCompoundDrawablePadding();
            maxHeight = Math.max(maxHeight, iconHeight);
        }

        setMeasuredDimension(resolveSize(totalWidth, widthMeasureSpec),
                resolveSize(maxHeight, heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = getText().toString();
        
        android.graphics.drawable.Drawable[] drawables = getCompoundDrawablesRelative();
        android.graphics.drawable.Drawable drawableStart = drawables[0];
        if (drawableStart == null) {
            drawables = getCompoundDrawables();
            drawableStart = drawables[0];
        }

        int saveCount = canvas.save();
        int iconWidth = 0;

        if (drawableStart != null) {
            Paint paint = getPaint();
            int refTextHeight = 0;
            // Similar logic to onMeasure for Ref Height
            if (isGearPattern(text)) {
                 paint.getTextBounds("M", 0, 1, mTempBounds);
                 refTextHeight = mTempBounds.height();
            } else {
                if (text.length() > 0) {
                    paint.getTextBounds(text, 0, text.length(), mBounds);
                    refTextHeight = mBounds.height();
                } else {
                    refTextHeight = (int) paint.getTextSize();
                }
            }
            
            int h = refTextHeight;
            if (h <= 0) h = (int) paint.getTextSize();

            int intrinsicH = drawableStart.getIntrinsicHeight();
            int intrinsicW = drawableStart.getIntrinsicWidth();
            if (intrinsicH > 0 && intrinsicW > 0) {
                float ratio = (float) intrinsicW / intrinsicH;
                iconWidth = (int) (h * ratio);
            } else {
                iconWidth = h;
            }

            int vCenter = getHeight() / 2;
            int top = vCenter - h / 2;
            drawableStart.setBounds(0, top, iconWidth, top + h);
            drawableStart.draw(canvas);

            canvas.translate(iconWidth + getCompoundDrawablePadding(), 0);
        }

        if (text.length() > 0) {
            Paint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            
            boolean isGear = isGearPattern(text);
            
            if (isGear) {
                // [FIX] Gear Drawing Logic: Symmetric Layout
                int digitStart = findDigitStart(text);
                String letterPart = digitStart > 0 ? text.substring(0, digitStart) : text;
                String digitPart = digitStart > 0 ? text.substring(digitStart) : null;
                
                // Reference M metrics
                float mWidth = paint.measureText("M");
                paint.getTextBounds("M", 0, 1, mTempBounds);
                
                float viewCenterX = getWidth() / 2f;
                // Tighten the gap: Use a small fraction of M width
                float halfGap = mWidth * 0.05f; 
                
                // 1. Draw Letter
                paint.getTextBounds(letterPart, 0, letterPart.length(), mBounds);
                float letterY = -mTempBounds.top; // Consistent Top
                
                if (digitPart != null) {
                    // "D1": Align Letter Right Edge to (Center - halfGap)
                    // Visual Right = X + mBounds.right
                    // X = Target - mBounds.right
                    float letterX = viewCenterX - halfGap - mBounds.right;
                    canvas.drawText(letterPart, letterX, letterY, paint);
                    
                    // 2. Draw Digit
                    paint.getTextBounds(digitPart, 0, digitPart.length(), mBounds);
                    // Align Digit Left Edge to (Center + halfGap)
                    // Visual Left = X + mBounds.left
                    // X = Target - mBounds.left
                    float digitX = viewCenterX + halfGap - mBounds.left;
                    canvas.drawText(digitPart, digitX, letterY, paint);
                    
                } else {
                    // "D": Center in View
                    float letterRectWidth = mBounds.width();
                    float letterX = viewCenterX - (letterRectWidth / 2f) - mBounds.left;
                    canvas.drawText(letterPart, letterX, letterY, paint);
                }
                
            } else {
                // Regular Text Logic
                // --- Truncation Logic ---
                String textToDraw = text;
                android.text.TextUtils.TruncateAt ellipsize = getEllipsize();
    
                if (ellipsize != null) {
                    int availTextWidth = getWidth() - getPaddingLeft() - getPaddingRight();
                    if (drawableStart != null) {
                        availTextWidth -= (iconWidth + getCompoundDrawablePadding());
                    }
                    if (availTextWidth < 0) availTextWidth = 0;
    
                    float currentWidth = paint.measureText(text);
    
                    if (currentWidth > availTextWidth) {
                        CharSequence truncated = android.text.TextUtils.ellipsize(text, (android.text.TextPaint) paint,
                                availTextWidth, ellipsize);
                        textToDraw = truncated.toString().replace('\u2026', '\u22EF');
                    }
                }
                // ------------------------
    
                paint.getTextBounds(textToDraw, 0, textToDraw.length(), mBounds);
    
                // Calculate X based on Gravity
                float textX = -mBounds.left; 
                int gravity = getGravity() & android.view.Gravity.HORIZONTAL_GRAVITY_MASK;
                
                int viewWidth = getWidth();
                if (drawableStart != null) {
                    viewWidth -= (iconWidth + getCompoundDrawablePadding());
                }
    
                if (gravity == android.view.Gravity.CENTER_HORIZONTAL) {
                    textX = (viewWidth - mBounds.width()) / 2f - mBounds.left;
                } else if (gravity == android.view.Gravity.END || gravity == android.view.Gravity.RIGHT) {
                    textX = viewWidth - mBounds.width() - mBounds.left;
                }
                
                float textY = -mBounds.top;
                int textHeight = mBounds.height();
                int viewHeight = getHeight(); 
                
                if (viewHeight > textHeight) {
                    textY += (viewHeight - textHeight) / 2f;
                }
    
                canvas.drawText(textToDraw, textX, textY, paint);
            }
        }

        canvas.restoreToCount(saveCount);
    }
}
