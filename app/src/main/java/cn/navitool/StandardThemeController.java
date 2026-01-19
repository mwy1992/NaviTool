package cn.navitool;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Standard Theme Controller (New Dial 22)
 * Left: Speed (0-260km/h, 0-260 deg)
 * Right: RPM (0-8000rpm, 0-240 deg)
 */
public class StandardThemeController {
    private static final String TAG = "StandardThemeController";

    // Speed constants
    private static final int MAX_SPEED = 260;
    private static final float MAX_SPEED_ANGLE = 260f;
    // [MOD] Initial Angle offset (Negative = Left/Counter-Clockwise)
    // Adjust this value to set the zero-position angle
    private static final float SPEED_START_ANGLE = -130f; 

    // RPM constants
    private static final int MAX_RPM = 8000;
    private static final float MAX_RPM_ANGLE = 240f; // [FIX] Match standard dial range if needed, usually 240 or 260
    // [MOD] Initial Angle offset for RPM
    private static final float RPM_START_ANGLE = -120f; 

    // Views
    private ImageView mPointerLeft; // Speed
    private ImageView mPointerRight; // RPM
    private TextView mSpeedText;
    private TextView mGearText;

    private boolean mPivotsSet = false;

    // Gear Logic
    private static final String[] GEARS = { "P", "R", "N", "D" };
    private int mCurrentGearIndex = 0;

    public StandardThemeController() {
    }

    public void bindViews(View rootView) {
        if (rootView == null) return;

        mPointerLeft = rootView.findViewById(R.id.standardLeftPointer);
        mPointerRight = rootView.findViewById(R.id.standardRightPointer);
        mSpeedText = rootView.findViewById(R.id.standardSpeedText);
        mGearText = rootView.findViewById(R.id.standardGearText);

        // Ensure pivots are set correctly (Bottom Right)
        if (mPointerLeft != null) {
            mPointerLeft.post(() -> {
                // Pivot X = Width (Right), Pivot Y = Height (Bottom)
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
        
        mPivotsSet = true;
        
        // Initial Reset
        updateSpeed(0);
        updateRpm(0);
        updateGearDisplay();
    }
    
    public void release() {
        // Cleanup if needed
    }

    // [FIX] Float precision for smooth pointer
    public void updateSpeed(float speed) {
        // Clamp
        if (speed < 0) speed = 0;
        if (speed > MAX_SPEED) speed = MAX_SPEED;

        // Update Text (Int)
        if (mSpeedText != null) {
            mSpeedText.setText(String.valueOf((int) speed));
        }

        // Update Pointer Rotation (Float for smoothness)
        // 0-260km/h -> 0-260 degrees
        // Linear mapping: angle = Start + speed * (Range / MaxSpeed)
        float angle = SPEED_START_ANGLE + (speed * (MAX_SPEED_ANGLE / (float)MAX_SPEED));
        
        if (mPointerLeft != null) {
            // Ensure pivot is set (in case post hasn't run yet or view size changed)
            if (mPointerLeft.getPivotX() == 0 || mPointerLeft.getPivotY() == 0) {
                 if (mPointerLeft.getWidth() > 0) { // Check real width
                     mPointerLeft.setPivotX(mPointerLeft.getWidth());
                     mPointerLeft.setPivotY(mPointerLeft.getHeight());
                 }
            }
            mPointerLeft.setRotation(angle);
        }
    }

    // [FIX] Float precision for smooth pointer
    public void updateRpm(float rpm) {
        // Clamp
        if (rpm < 0) rpm = 0;
        if (rpm > MAX_RPM) rpm = MAX_RPM;

        // Update Text (Int) - [FIX] No RPM Text in Standard Theme
        // if (mRpmText != null) {
        //    mRpmText.setText(String.valueOf((int) rpm));
        // }

        // Update Pointer Rotation (Float)
        // 0-8000rpm -> 0-260 degrees 
        // Metric: Positive rotation (CW)
        float angle = RPM_START_ANGLE + (rpm * (MAX_RPM_ANGLE / (float)MAX_RPM));

        if (mPointerRight != null) {
             if (mPointerRight.getPivotX() == 0 || mPointerRight.getPivotY() == 0) {
                 // Restore Pivot to Bottom-Right (Width, Height) to match original
                  if (mPointerRight.getWidth() > 0) {
                     mPointerRight.setPivotX(mPointerRight.getWidth());
                     mPointerRight.setPivotY(mPointerRight.getHeight());
                  }
             }
            mPointerRight.setRotation(angle);
        }
    }

    // --- Gear Logic (Borrowed from AudiRs) ---

    // 档位传感器常量
    private static final int GEAR_PARK = 2097712;
    private static final int GEAR_REVERSE = 2097728;
    private static final int GEAR_NEUTRAL = 2097680;
    private static final int GEAR_DRIVE = 2097696;
    private static final int TRSM_GEAR_PARK = 15;
    private static final int TRSM_GEAR_DRIVE = 13;
    private static final int TRSM_GEAR_NEUT = 14;
    private static final int TRSM_GEAR_RVS = 11;

    public void setGear(int gearValue) {
        String gearStr = "P";
        if (gearValue == -1) {
            gearStr = "M";
        } else if (gearValue == GEAR_DRIVE || gearValue == TRSM_GEAR_DRIVE) {
            gearStr = "D";
        } else if (gearValue == GEAR_REVERSE || gearValue == TRSM_GEAR_RVS) {
            gearStr = "R";
        } else if (gearValue == GEAR_NEUTRAL || gearValue == TRSM_GEAR_NEUT) {
            gearStr = "N";
        } else if (gearValue == GEAR_PARK || gearValue == TRSM_GEAR_PARK) {
            gearStr = "P";
        }
        setGear(gearStr);
    }

    public void setGear(String gearCode) {
        if (mGearText != null && gearCode != null) {
            mGearText.setText(gearCode);

            int color = android.graphics.Color.WHITE;
            if (gearCode.startsWith("D")) {
                color = android.graphics.Color.GREEN;
                mCurrentGearIndex = 3;
            } else if (gearCode.startsWith("R")) {
                color = android.graphics.Color.RED;
                mCurrentGearIndex = 1;
            } else if (gearCode.startsWith("N")) {
                color = android.graphics.Color.YELLOW;
                mCurrentGearIndex = 2;
            } else if (gearCode.startsWith("P")) {
                color = android.graphics.Color.WHITE;
                mCurrentGearIndex = 0;
            } else if (gearCode.startsWith("M") || gearCode.startsWith("S")) {
                color = android.graphics.Color.CYAN;
                mCurrentGearIndex = 3;
            }
            mGearText.setTextColor(color);
            DebugLogger.d(TAG, "StandardTheme setGear: " + gearCode + " (Color index: " + mCurrentGearIndex + ")");
        }
    }

    public void cycleGear() {
        mCurrentGearIndex = (mCurrentGearIndex + 1) % GEARS.length;
        updateGearDisplay();
    }

    private void updateGearDisplay() {
        if (mCurrentGearIndex >= 0 && mCurrentGearIndex < GEARS.length) {
            setGear(GEARS[mCurrentGearIndex]);
        }
    }
    
    // Day/Night stub
    public void setDayMode(boolean isDay) {
        // TODO: Implement day/night background switch if needed
    }
}
