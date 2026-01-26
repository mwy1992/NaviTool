package cn.navitool.theme;

import android.view.View;
import android.widget.ImageView;
import android.os.Handler;
import android.os.Looper;
import cn.navitool.R;
import cn.navitool.utils.DebugLogger;
import cn.navitool.view.animation.SmoothValueAnimator;
import cn.navitool.view.animation.SmoothTextAnimator;

/**
 * Standard Theme Controller (New Dial 22)
 * Left: Speed (0-260km/h, 0-260 deg)
 * Right: RPM (0-8000rpm, 0-240 deg)
 * Extends BaseThemeController for common logic.
 */
public class StandardThemeController extends BaseThemeController {

    // Speed constants
    private static final int MAX_SPEED = 260;
    private static final float MAX_SPEED_ANGLE = 260f;
    private static final float SPEED_START_ANGLE = -130f; 

    // RPM constants
    private static final int MAX_RPM = 8000;
    private static final float MAX_RPM_ANGLE = 240f; 
    private static final float RPM_START_ANGLE = -120f; 

    // Views (Specific to Standard Theme)
    // Views (Specific to Standard Theme)
    private ImageView mPointerLeft; // Speed
    private ImageView mPointerRight; // RPM

    // Animators
    private SmoothValueAnimator mSpeedPointerAnimator;
    private SmoothTextAnimator mSpeedTextAnimator;

    // Animation Loop
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsAnimating = false;
    private Runnable mAnimationRunnable = new Runnable() {
        @Override
        public void run() {
            boolean needsUpdate = false;

            // Speed Pointer
            if (mSpeedPointerAnimator != null && mPointerLeft != null) {
                float val = mSpeedPointerAnimator.getValue();
                // Map 0-260 speed to -130 to +130 degrees
                // angle = start + (speed * ratio)
                float angle = SPEED_START_ANGLE + (val * (MAX_SPEED_ANGLE / (float)MAX_SPEED));
                mPointerLeft.setRotation(angle);

                if (mSpeedPointerAnimator.isRunning()) {
                    needsUpdate = true;
                }
            }

            // Speed Text
            if (mSpeedTextAnimator != null) {
                mSpeedTextAnimator.onTick();
                if (mSpeedTextAnimator.isRunning()) {
                    needsUpdate = true;
                }
            }

            if (needsUpdate) {
                mHandler.postDelayed(this, 16); // ~60FPS
            } else {
                mIsAnimating = false;
            }
        }
    };

    public StandardThemeController() {
    }

    @Override
    protected void onBindViews(View rootView) {
        // Bind Base Views
        mSpeedText = rootView.findViewById(R.id.standardSpeedText);
        mGearText = rootView.findViewById(R.id.standardGearText);

        // Bind Specific Views
        mPointerLeft = rootView.findViewById(R.id.standardLeftPointer);
        mPointerRight = rootView.findViewById(R.id.standardRightPointer);

        // Ensure pivots are set correctly (Bottom Right)
        if (mPointerLeft != null) {
            mPointerLeft.post(() -> {
                mPointerLeft.setPivotX(mPointerLeft.getWidth());
                mPointerLeft.setPivotY(mPointerLeft.getHeight());
                DebugLogger.d(TAG, "Left Pointer Pivot set to: " + mPointerLeft.getWidth() + ", " + mPointerLeft.getHeight());
            });
        }

        if (mPointerRight != null) {
            mPointerRight.post(() -> {
                mPointerRight.setPivotX(mPointerRight.getWidth());
                mPointerRight.setPivotY(mPointerRight.getHeight());
                DebugLogger.d(TAG, "Right Pointer Pivot set to: " + mPointerRight.getWidth() + ", " + mPointerRight.getHeight());
            });
        }
        
        // Initial Reset
        // [FIX] Do NOT set text to "0" or "P" by default (User Request).
        // Using explicit rotation init instead of updateXXX(0) which sets text.
        if (mPointerLeft != null) mPointerLeft.setRotation(SPEED_START_ANGLE);
        if (mPointerRight != null) mPointerRight.setRotation(RPM_START_ANGLE);

        // updateSpeed(0);
        // updateRpm(0);
        
        // [FIX] Restore Gear Sync: Fetch latest gear from Manager so we don't show stale "P"
        String currentGear = cn.navitool.managers.ClusterHudManager.getInstance(rootView.getContext()).getCurrentDisplayGear();
        setGear(currentGear);

        // Init Animators
        mSpeedPointerAnimator = new SmoothValueAnimator(0);
        if (mSpeedText != null) {
            mSpeedTextAnimator = new SmoothTextAnimator(mSpeedText);
            mSpeedTextAnimator.setInitialValue(0);
        } 
    }
    
    @Override
    public void detachViews() {
        super.detachViews();
        mHandler.removeCallbacks(mAnimationRunnable);
        mIsAnimating = false;
        mPointerLeft = null;
        mPointerRight = null;
        mSpeedPointerAnimator = null;
        mSpeedTextAnimator = null;
    }

    // --- Specific Logic ---

    // Override hook from BaseThemeController
    @Override
    public void updateSpeed(float speed) {
        // Clamp
        float clampedSpeed = Math.max(0, Math.min(speed, MAX_SPEED));

        // Jitter Filter (Use Base logic or custom)
        if (Math.abs(clampedSpeed - mLastSpeed) < 0.1f) {
             return;
        }
        mLastSpeed = clampedSpeed;

        // [CONFLICT FIX] Bypass Smooth Animator, use direct set
        // 1. Update Pointer Target
        if (mSpeedPointerAnimator != null) {
            mSpeedPointerAnimator.updateTarget(clampedSpeed);
        }
        // Direct set:
        // if (mPointerLeft != null) {
        //     float angle = SPEED_START_ANGLE + (clampedSpeed * (MAX_SPEED_ANGLE / (float)MAX_SPEED));
        //     mPointerLeft.setRotation(angle);
        // }

        // 2. Update Text Target
        if (mSpeedTextAnimator != null) {
            mSpeedTextAnimator.updateTargetValue((int) clampedSpeed);
        }
        // Direct set:
        // if (mSpeedText != null) {
        //     mSpeedText.setText(String.valueOf((int) clampedSpeed));
        // }

        // 3. Ensure Animation Loop is running
        if (!mIsAnimating) {
            mIsAnimating = true;
            mHandler.post(mAnimationRunnable);
        }
    }

    @Override
    protected void onSpeedUpdated(float speed) {
        // Deprecated usage in this class, logic moved to updateSpeed to handle animation
    }

    @Override
    public void updateRpm(float rpm) {
        // Clamp
        float clampedRpm = Math.max(0, Math.min(rpm, MAX_RPM));

        // Note: No RPM Text in Standard Theme, so we only handle pointer here.
        // BaseThemeController's default updateRpm does nothing, so we fully implement logic here.

        // Update Pointer Rotation
        // -120 start, +240 range
        float angle = RPM_START_ANGLE + (clampedRpm * (MAX_RPM_ANGLE / (float)MAX_RPM));

        if (mPointerRight != null) {
             if (mPointerRight.getPivotX() == 0 || mPointerRight.getPivotY() == 0) {
                  if (mPointerRight.getWidth() > 0) {
                     mPointerRight.setPivotX(mPointerRight.getWidth());
                     mPointerRight.setPivotY(mPointerRight.getHeight());
                  }
             }
            mPointerRight.setRotation(angle);
        }
    }

    // Gear Logic: Completely handled by BaseThemeController (setGear, cycleGear)

    // Day/Night stub - Use Base (Empty) or override if needed in future
}
