package cn.navitool.view.animation;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/**
 * Implements smooth pointer movement by resetting start point on target change.
 */
public class SmoothValueAnimator {

    private float mCurrentValue;
    private float mStartValue;
    private float mTargetValue;
    
    private long mStartTime;
    private long mDuration = 400; // Base duration
    private final Interpolator mInterpolator;

    // Configuration
    private static final long MIN_DURATION = 200;
    private static final long MAX_DURATION = 800; // Allow slower movement for large sweeps
    private static final float ANGLE_THRESHOLD = 120.0f; // Degrees for max duration

    public SmoothValueAnimator(float initialValue) {
        mCurrentValue = initialValue;
        mStartValue = initialValue;
        mTargetValue = initialValue;
        mInterpolator = new DecelerateInterpolator(1.5f);
    }

    /**
     * Update the target value.
     * Triggers dynamic retargeting:
     * 1. Sets current visual position as new start.
     * 2. Sets new target.
     * 3. Resets time.
     * 4. Recalculates duration based on distance.
     */
    public void updateTarget(float newTarget) {
        if (Math.abs(newTarget - mTargetValue) < 0.01f) {
            return;
        }

        // 1. Reset start to current visual position (Retargeting)
        mStartValue = mCurrentValue;
        mTargetValue = newTarget;
        mStartTime = System.currentTimeMillis();

        // 2. Dynamic Duration Calculation
        float diff = Math.abs(mTargetValue - mStartValue);
        // Normalize distance influence
        float fraction = Math.min(1.0f, diff / ANGLE_THRESHOLD); 
        mDuration = (long) (MIN_DURATION + (MAX_DURATION - MIN_DURATION) * fraction);
    }

    /**
     * Calculate and return the current interpolated value.
     * Should be called every frame (e.g., in a Runnable loop).
     */
    public float getValue() {
        long now = System.currentTimeMillis();
        
        // Check if finished
        if (Math.abs(mTargetValue - mCurrentValue) < 0.01f && now > mStartTime + mDuration) {
            mCurrentValue = mTargetValue;
            return mCurrentValue;
        }

        float timeFraction = (float) (now - mStartTime) / mDuration;
        timeFraction = Math.max(0f, Math.min(1f, timeFraction));

        float interp = mInterpolator.getInterpolation(timeFraction);
        
        mCurrentValue = mStartValue + (mTargetValue - mStartValue) * interp;
        
        return mCurrentValue;
    }

    public boolean isRunning() {
        return Math.abs(mTargetValue - mCurrentValue) > 0.01f;
    }
}
