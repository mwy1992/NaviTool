package cn.navitool.theme;

import android.view.View;
import android.widget.ImageView;
import cn.navitool.R;
import cn.navitool.utils.DebugLogger;

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
    private ImageView mPointerLeft; // Speed
    private ImageView mPointerRight; // RPM

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
        updateSpeed(0);
        updateRpm(0);
        // BaseThemeController handles gear update if set, but we might want to ensure default P
        setGear(mCurrentGearIndex >= 0 ? GEARS[mCurrentGearIndex] : "P"); 
    }
    
    @Override
    public void detachViews() {
        super.detachViews();
        mPointerLeft = null;
        mPointerRight = null;
    }

    // --- Specific Logic ---

    // Override hook from BaseThemeController
    @Override
    protected void onSpeedUpdated(float speed) {
        // Clamp
        float clampedSpeed = Math.max(0, Math.min(speed, MAX_SPEED));

        // Update Pointer Rotation
        // -130 start, +260 range
        float angle = SPEED_START_ANGLE + (clampedSpeed * (MAX_SPEED_ANGLE / (float)MAX_SPEED));
        
        if (mPointerLeft != null) {
            // Ensure pivot is set (defensive)
            if (mPointerLeft.getPivotX() == 0 || mPointerLeft.getPivotY() == 0) {
                 if (mPointerLeft.getWidth() > 0) { 
                     mPointerLeft.setPivotX(mPointerLeft.getWidth());
                     mPointerLeft.setPivotY(mPointerLeft.getHeight());
                 }
            }
            mPointerLeft.setRotation(angle);
        }
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
