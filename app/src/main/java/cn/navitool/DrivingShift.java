package cn.navitool;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DrivingShift {
    private static final String TAG = "DrivingShift";
    private static volatile DrivingShift instance;

    // Vehicle Parameters (Geely Monjaro 2021 4WD Flagship)
    private final float finalDriveRatio = 3.329f;
    private final float[] gearRatios = {
            5.25f, // 1st
            3.029f, // 2nd
            1.95f, // 3rd
            1.457f, // 4th
            1.221f, // 5th
            1.0f, // 6th
            0.809f, // 7th
            0.673f // 8th
    };

    // Drive Modes
    public static final int DRIVE_MODE_ECO = 570491137;
    public static final int DRIVE_MODE_COMFORT = 570491138;
    public static final int DRIVE_MODE_DYNAMIC = 570491139;
    public static final int DRIVE_MODE_ADAPTIVE = 570491158;
    public static final int DRIVE_MODE_SNOW = 570491145;
    public static final int DRIVE_MODE_OFFROAD = 570491155;

    private int mCurrentDriveMode = 0;

    public void setDriveMode(int mode) {
        this.mCurrentDriveMode = mode;
    }

    // Tire Specs: 245/45 R20
    private final float tireRadius;

    // State
    private List<String> gearHistory = new ArrayList<>();
    private final int maxHistorySize = 3;
    private String lastValidGear = "P";
    private String lastCalculatedGear = "P";

    // Speed/RPM Ranges (Backup Logic)
    // Using a simple list of objects or parallel arrays since Java 8 doesn't have
    // Pairs easily accessible without AndroidX or custom classes
    // We will stick to the Ratio calculation as primary.

    private DrivingShift() {
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

    private float calculateTireRadius(float widthMm, float aspectRatio, float rimDiameterInch) {
        float sidewallHeight = widthMm * aspectRatio;
        float tireDiameterMm = (rimDiameterInch * 25.4f) + (2 * sidewallHeight);
        return (tireDiameterMm / 1000f) / 2f;
    }

    /**
     * Calculates the simulated gear based on Speed and RPM.
     * 
     * @param speedKmh          Current speed in km/h
     * @param rpm               Current engine RPM
     * @param currentSensorGear The gear string from sensor (e.g., "D", "M", "P",
     *                          "R", "N")
     * @return Calculated gear string (e.g., "D1", "D2", "M3")
     */
    public String calculateGear(float speedKmh, float rpm, String currentSensorGear) {
        // 1. Basic Static Checks
        if (speedKmh <= 0.5f || rpm <= 0.1f) {
            if ("D".equals(currentSensorGear)) {
                // 感谢群友大胖提供代码
                // Idle in D: Show D1 or D2 based on Drive Mode
                if (mCurrentDriveMode == DRIVE_MODE_SNOW || mCurrentDriveMode == DRIVE_MODE_OFFROAD) {
                    return "D2"; // Snow/Offroad often starts in 2nd gear
                }
                return "D1";
            } else if ("M".equals(currentSensorGear)) {
                // Manual mode stopped - usually M1
                return "M1";
            }
            return currentSensorGear;
        }

        if (!"D".equals(currentSensorGear) && !"M".equals(currentSensorGear)) {
            return currentSensorGear; // P, R, N, etc.
        }

        // 2. Ratio Calculation
        float speedMps = speedKmh / 3.6f;
        float rpmRadPerSec = rpm * (2f * (float) Math.PI / 60f);

        // Avoid division by zero
        if (speedMps < 0.1f)
            speedMps = 0.1f;

        // Theoretical Ratio = (WheelAngularVelocity) / (EngineAngularVelocity /
        // FinalDrive) ?
        // No, Ratio = EngineRPM / WheelRPM
        // WheelRPM = Speed / Circumference * 60 ??

        // Reference Logic:
        // val calculatedRatio = (rpmRadPerSec * tireRadius) / (speedMps *
        // finalDriveRatio)
        // Wait, check formula:
        // Wheel Ang Vel (rad/s) = Speed (m/s) / Radius (m)
        // Engine Ang Vel = rpmRadPerSec
        // Total Ratio = Engine / Wheel = rpmRadPerSec / (speedMps / tireRadius)
        // Total Ratio = GearRatio * FinalDrive
        // So GearRatio = (rpmRadPerSec * tireRadius / speedMps) / finalDriveRatio
        // This matches the reference formula: (rpmRadPerSec * tireRadius) / (speedMps *
        // finalDriveRatio)

        float calculatedRatio = (rpmRadPerSec * tireRadius) / (speedMps * finalDriveRatio);

        float minDiff = Float.MAX_VALUE;
        int bestGear = 0;

        for (int i = 0; i < gearRatios.length; i++) {
            float diff = Math.abs(calculatedRatio - gearRatios[i]);
            if (diff < minDiff) {
                minDiff = diff;
                bestGear = i + 1;
            }
        }

        // 3. Error Thresholding (Static Hysteresis)
        float errorThreshold = (speedKmh < 20) ? 1.0f : (speedKmh < 60 ? 0.6f : 0.4f);

        String resultGear = currentSensorGear;
        if (minDiff < errorThreshold) {
            resultGear = currentSensorGear + bestGear;
        } else {
            // Fallback: If ratio doesn't match well (e.g. slippage or neutral-like state in
            // D)
            // Users request: If calculation fails, return raw "D".
            resultGear = currentSensorGear;
        }

        // 4. Smoothing
        return smoothGearOutput(resultGear);
    }

    private String smoothGearOutput(String newGear) {
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
