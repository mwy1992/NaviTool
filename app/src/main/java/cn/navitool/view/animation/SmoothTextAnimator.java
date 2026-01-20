package cn.navitool.view.animation;

import android.widget.TextView;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * Animator for TextViews to create a "Rolling Counter" effect.
 * Uses the same Dynamic Retargeting logic as SmoothValueAnimator but optimized for integers.
 */
public class SmoothTextAnimator {

    private final TextView mTargetView;
    private float mCurrentValue;
    private float mStartValue;
    private float mTargetValue;
    
    private long mStartTime;
    private long mDuration;
    private final Interpolator mInterpolator;

    // Configuration
    private static final long MIN_DURATION = 200; // Shorter min duration for text
    private static final long MAX_DURATION = 600; // Max duration for text
    private static final float SPEED_THRESHOLD = 50.0f; // Value difference for max duration

    public SmoothTextAnimator(TextView targetView) {
        mTargetView = targetView;
        mInterpolator = new DecelerateInterpolator(1.5f);
        mCurrentValue = 0;
        mTargetValue = 0;
    }

    public void setInitialValue(int value) {
        mCurrentValue = value;
        mTargetValue = value;
        mStartValue = value;
        updateText(value);
    }

    /**
     * Update target value.
     */
    public void updateTargetValue(int newTarget) {
        if (Math.abs(newTarget - mTargetValue) < 0.1f) return;

        // 1. Retargeting
        mStartValue = mCurrentValue;
        mTargetValue = (float) newTarget;
        mStartTime = System.currentTimeMillis();

        // 2. Dynamic Duration
        float diff = Math.abs(mTargetValue - mStartValue);
        float fraction = Math.min(1.0f, diff / SPEED_THRESHOLD); 
        mDuration = (long) (MIN_DURATION + (MAX_DURATION - MIN_DURATION) * fraction);
    }

    /**
     * Call this every frame to update the TextView.
     */
    public void onTick() {
        long now = System.currentTimeMillis();

        if (Math.abs(mTargetValue - mCurrentValue) < 0.1f) {
            // Stabilize
            if ((int)mCurrentValue != (int)mTargetValue) {
                mCurrentValue = mTargetValue;
                updateText((int) mCurrentValue);
            }
            return;
        }

        float timeFraction = (float) (now - mStartTime) / mDuration;
        timeFraction = Math.max(0f, Math.min(1f, timeFraction));

        float interp = mInterpolator.getInterpolation(timeFraction);

        mCurrentValue = mStartValue + (mTargetValue - mStartValue) * interp;

        updateText((int) Math.round(mCurrentValue));
    }

    private void updateText(int value) {
        try {
            CharSequence currentText = mTargetView.getText();
            if (currentText.length() > 0) {
                 // Optimization: Parse int to check if change is needed
                 // Handle potential non-numeric text gracefully?
                 // For now, assume speed text is numeric.
                 String textStr = currentText.toString();
                 if (textStr.matches("-?\\d+")) {
                     int currentInt = Integer.parseInt(textStr);
                     if (currentInt == value) return;
                 }
            }
        } catch (Exception e) {
            // Ignore parsing errors
        }
        mTargetView.setText(String.valueOf(value));
    }
    
    public boolean isRunning() {
         return Math.abs(mTargetValue - mCurrentValue) >= 0.5f;
    }
}
