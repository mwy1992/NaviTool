package cn.navitool;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrivingShift {
    private static final String TAG = "DrivingShift";
    private static volatile DrivingShift instance;

    // Transmission Types
    public static final int TRANSMISSION_TYPE_8AT = 0;
    public static final int TRANSMISSION_TYPE_7DCT = 1;
    private int mTransmissionType = TRANSMISSION_TYPE_8AT; // Default to 8AT

    // Drive Modes (Sync with other classes if needed)
    public static final int DRIVE_MODE_SNOW = 570491145; // IdNames.DRIVE_MODE_SELECTION_SNOW
    private int mCurrentDriveMode = -1;

    // --- 8AT Constants (Geely Xingyue L 4WD Flagship) ---
    private static final float RATIO_FINAL_DRIVE_8AT = 3.329f;
    private static final float[] GEAR_RATIOS_8AT = {
            5.25f, // 1st
            3.029f, // 2nd
            1.95f, // 3rd
            1.457f, // 4th
            1.221f, // 5th
            1.0f, // 6th
            0.809f, // 7th
            0.673f // 8th
    };

    // --- 7DCT Constants (Geely Xingyue L 7DCT) ---
    private static final float RATIO_FINAL_DRIVE_7DCT_ODD = 4.647f; // 1, 3, 5, 7
    private static final float RATIO_FINAL_DRIVE_7DCT_EVEN = 3.435f; // 2, 4, 6
    private static final float[] GEAR_RATIOS_7DCT = {
            3.529f, // 1st
            2.81f, // 2nd
            1.395f, // 3rd
            1.043f, // 4th
            1.105f, // 5th
            0.851f, // 6th
            0.725f // 7th
    };

    // Tire Specs: 245/45 R20 (Used for calculation)
    private final float tireRadius;

    // State
    private List<String> gearHistory = new ArrayList<>();
    private final int maxHistorySize = 3;
    private String lastValidGear = "P";

    // Snow mode state
    private boolean wasSnowModeInMotion = false;

    private DrivingShift() {
        // Default Tire Radius (can be made configurable if needed)
        tireRadius = calculateTireRadius(245f, 0.45f, 20f);
    }

    public static DrivingShift getInstance() {
        if (instance == null) {
            synchronized (DrivingShift.class) {
                if (instance == null) {
                    instance = new DrivingShift();
                }
            }
        }
        return instance;
    }

    public void setTransmissionType(int type) {
        if (type == TRANSMISSION_TYPE_8AT || type == TRANSMISSION_TYPE_7DCT) {
            this.mTransmissionType = type;
            Log.d(TAG, "Transmission Type set to: " + (type == TRANSMISSION_TYPE_8AT ? "8AT" : "7DCT"));
        }
    }

    public void setDriveMode(int mode) {
        this.mCurrentDriveMode = mode;
    }

    private float calculateTireRadius(float widthMm, float aspectRatio, float rimDiameterInch) {
        float sidewallHeight = widthMm * aspectRatio;
        float tireDiameterMm = (rimDiameterInch * 25.4f) + (2 * sidewallHeight);
        return (tireDiameterMm / 1000f) / 2f;
    }

    /**
     * Main calculation method.
     * Tries Ratio-based first, falls back to Speed/RPM backup if needed.
     */
    public String calculateGear(float speedKmh, float rpm, String currentSensorGear, boolean forceImmediate) {
        // 1. Static / Low Speed Handling
        if (speedKmh <= 0.5f || rpm <= 0.1f) {
            if ("D".equals(currentSensorGear)) {
                if (mCurrentDriveMode == DRIVE_MODE_SNOW) {
                    return "D2";
                }
                return mTransmissionType == TRANSMISSION_TYPE_7DCT ? "D1" : "D1"; // Usually D1 unless snow
            } else if ("M".equals(currentSensorGear)) {
                return "M1";
            }
            return currentSensorGear;
        }

        // Snow mode motion detection
        if (mCurrentDriveMode == DRIVE_MODE_SNOW && "D".equals(currentSensorGear)) {
            if (speedKmh < 10.0f && rpm < 1500f) {
                return "D2";
            }
            wasSnowModeInMotion = true;
        }

        // 2. Primary: Ratio Calculation
        String mainResult = calculateGearByRatio(speedKmh, rpm, currentSensorGear);

        // 3. Backup: Speed/RPM Table
        String backupResult = calculateGearBySpeedRpm(speedKmh, rpm, currentSensorGear);

        // 4. Decision Logic
        String finalGear = mainResult;

        // If main result is generic "D" (failed) but backup found a specific gear, use
        // backup.
        // Also helps stabilize if main result is flickering between gears but backup is
        // solid (though backup is range based).
        // Primarily fixes the "D" fallback issue.
        if (!mainResult.equals(backupResult)) {
            if ("D".equals(mainResult) && !backupResult.equals("D")) {
                finalGear = backupResult;
            }
            // If main result is specific (e.g. D3) and backup is different (e.g. D4),
            // usually Ratio is more precise if connected, but fallback is for when clutch
            // slips.
            // We trust Ratio if it found a match, trust Backup if Ratio failed.
        }

        // 5. Snow Mode Override (Static Safety)
        if ("D".equals(currentSensorGear) && speedKmh <= 0.5f) {
            if (mCurrentDriveMode == DRIVE_MODE_SNOW) {
                if (!finalGear.endsWith("2"))
                    finalGear = "D2";
            } else {
                if ("N".equals(finalGear) || "P".equals(finalGear) || "R".equals(finalGear)) {
                    finalGear = "D"; // Should not happen but safety
                }
            }
        }

        // 6. Smoothing / Immediate
        if (forceImmediate) {
            // Update history to keep it consistent but return immediate result
            gearHistory.add(finalGear);
            if (gearHistory.size() > maxHistorySize) {
                gearHistory.remove(0);
            }
            lastValidGear = finalGear;
            return finalGear;
        }

        return smoothGearOutput(finalGear);
    }

    public String calculateGear(float speedKmh, float rpm, String currentSensorGear) {
        return calculateGear(speedKmh, rpm, currentSensorGear, false);
    }

    private String calculateGearByRatio(float speedKmh, float rpm, String currentSensorGear) {
        if (!"D".equals(currentSensorGear) && !"M".equals(currentSensorGear)) {
            return currentSensorGear;
        }

        float speedMps = speedKmh / 3.6f;
        float rpmRadPerSec = rpm * (2f * (float) Math.PI / 60f);

        if (speedMps < 0.1f)
            speedMps = 0.1f;

        // Calculate Ratio
        // GearRatio = (EngineRPM * Radius) / (Speed * FinalDrive)
        // Note: For 7DCT, FinalDrive depends on the gear (Odd/Even).
        // We will iterate through all possible gears and reverse check the ratio match.

        float minDiff = Float.MAX_VALUE;
        int bestGear = 0;

        int maxGear = (mTransmissionType == TRANSMISSION_TYPE_8AT) ? 8 : 7;

        for (int i = 1; i <= maxGear; i++) {
            float gearRatioEntry;
            float finalDrive;

            if (mTransmissionType == TRANSMISSION_TYPE_8AT) {
                gearRatioEntry = GEAR_RATIOS_8AT[i - 1];
                finalDrive = RATIO_FINAL_DRIVE_8AT;
            } else {
                gearRatioEntry = GEAR_RATIOS_7DCT[i - 1];
                finalDrive = (i % 2 != 0) ? RATIO_FINAL_DRIVE_7DCT_ODD : RATIO_FINAL_DRIVE_7DCT_EVEN;
            }

            // Calculated Ratio from physical Input
            // Ratio = EngineAng / WheelAng = (rpm * 2pi/60) / (speed / radius)
            // Combined Ratio = Gear * Final
            float combinedRatioTarget = (rpmRadPerSec * tireRadius) / speedMps;
            float combinedRatioSpec = gearRatioEntry * finalDrive;

            float diff = Math.abs(combinedRatioTarget - combinedRatioSpec);

            if (diff < minDiff) {
                minDiff = diff;
                bestGear = i;
            }
        }

        // Snow Mode Limit
        if (mCurrentDriveMode == DRIVE_MODE_SNOW && bestGear < 2) {
            bestGear = 2;
        }

        // Threshold
        float errorThreshold = (speedKmh < 20) ? 1.0f : (speedKmh < 60 ? 0.6f : 0.4f);

        if (minDiff < errorThreshold) {
            return currentSensorGear + bestGear;
        }

        return currentSensorGear; // Fallback to "D" or "M"
    }

    private String calculateGearBySpeedRpm(float speedKmh, float rpm, String currentSensorGear) {
        if (!"D".equals(currentSensorGear) && !"M".equals(currentSensorGear)) {
            return currentSensorGear;
        }

        int foundGear = 0;

        if (mTransmissionType == TRANSMISSION_TYPE_8AT) {
            foundGear = checkRanges8AT(speedKmh, rpm);
        } else {
            foundGear = checkRanges7DCT(speedKmh, rpm);
        }

        if (foundGear > 0) {
            // Snow Mode Limit
            if (mCurrentDriveMode == DRIVE_MODE_SNOW && foundGear < 2) {
                foundGear = 2;
            }
            return currentSensorGear + foundGear;
        }

        return currentSensorGear;
    }

    // Manual Range Checks (Hardcoded from kotlin maps for performance and safety)
    private int checkRanges8AT(float s, float r) {
        // 1: 0-30, 800-3500
        if (s >= 0 && s <= 30 && r >= 800 && r <= 3500)
            return 1;
        // 2: 15-50, 1000-3500
        if (s >= 15 && s <= 50 && r >= 1000 && r <= 3500)
            return 2;
        // 3: 25-70, 1200-3500
        if (s >= 25 && s <= 70 && r >= 1200 && r <= 3500)
            return 3;
        // 4: 40-90, 1300-3500
        if (s >= 40 && s <= 90 && r >= 1300 && r <= 3500)
            return 4;
        // 5: 50-110, 1400-3500
        if (s >= 50 && s <= 110 && r >= 1400 && r <= 3500)
            return 5;
        // 6: 60-130, 1500-3500
        if (s >= 60 && s <= 130 && r >= 1500 && r <= 3500)
            return 6;
        // 7: 70-150, 1600-3500
        if (s >= 70 && s <= 150 && r >= 1600 && r <= 3500)
            return 7;
        // 8: 80-200, 1700-3500
        if (s >= 80 && s <= 200 && r >= 1700 && r <= 3500)
            return 8;
        return 0;
    }

    private int checkRanges7DCT(float s, float r) {
        // 1: 0-25, 800-3500
        if (s >= 0 && s <= 25 && r >= 800 && r <= 3500)
            return 1;
        // 2: 15-45, 1000-3500
        if (s >= 15 && s <= 45 && r >= 1000 && r <= 3500)
            return 2;
        // 3: 25-70, 1200-3500
        if (s >= 25 && s <= 70 && r >= 1200 && r <= 3500)
            return 3;
        // 4: 40-90, 1300-3500
        if (s >= 40 && s <= 90 && r >= 1300 && r <= 3500)
            return 4;
        // 5: 50-110, 1400-3500
        if (s >= 50 && s <= 110 && r >= 1400 && r <= 3500)
            return 5;
        // 6: 65-130, 1500-3500 (Different from 8AT)
        if (s >= 65 && s <= 130 && r >= 1500 && r <= 3500)
            return 6;
        // 7: 75-180, 1600-3500
        if (s >= 75 && s <= 180 && r >= 1600 && r <= 3500)
            return 7;
        return 0;
    }

    private String smoothGearOutput(String newGear) {
        // [DEBUG] Smoothing Input
        Log.d(TAG, "Smoothing Logic: Input=" + newGear + ", History=" + gearHistory + ", LastValid=" + lastValidGear);
        gearHistory.add(newGear);
        if (gearHistory.size() > maxHistorySize) {
            gearHistory.remove(0);
        }

        if (gearHistory.size() < 2) {
            lastValidGear = newGear;
            return newGear;
        }

        // Find mode (most frequent)
        Map<String, Integer> counts = new HashMap<>();
        for (String g : gearHistory) {
            counts.put(g, counts.getOrDefault(g, 0) + 1);
        }

        String mode = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        if (mode != null && maxCount >= 2) {
            lastValidGear = mode;
            return mode;
        }

        return lastValidGear;
    }
}
