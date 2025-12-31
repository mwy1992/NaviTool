package cn.navitool.managers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.navitool.ClusterHudManager;
import cn.navitool.DebugLogger;
import cn.navitool.R;

public class CustomThemeManager {
    private static final String TAG = "CustomThemeManager";
    private static CustomThemeManager instance;
    private final Context mContext;
    private final File mExternalThemesDir;
    private final File mInternalThemesDir;

    private CustomThemeManager(Context context) {
        this.mContext = context.getApplicationContext();
        // External Source: /sdcard/Monjaro/NaviTool/Themes/
        this.mExternalThemesDir = new File(android.os.Environment.getExternalStorageDirectory(),
                "Monjaro/NaviTool/Themes");
        // Internal Storage: /data/data/cn.navitool/files/Themes/
        this.mInternalThemesDir = new File(mContext.getFilesDir(), "Themes");

        if (!mInternalThemesDir.exists()) {
            mInternalThemesDir.mkdirs();
        }
    }

    public static synchronized CustomThemeManager getInstance(Context context) {
        if (instance == null) {
            instance = new CustomThemeManager(context);
        }
        return instance;
    }

    // --- Public API ---

    public List<String> getAvailableExternalThemes() {
        if (!mExternalThemesDir.exists() || !mExternalThemesDir.isDirectory()) {
            return Collections.emptyList();
        }
        List<String> themes = new ArrayList<>();
        File[] files = mExternalThemesDir.listFiles(File::isDirectory);
        if (files != null) {
            for (File f : files) {
                // Must contain theme.json to be valid
                if (new File(f, "theme.json").exists()) {
                    themes.add(f.getName());
                }
            }
        }
        return themes;
    }

    public List<String> getImportedThemes() {
        List<String> themes = new ArrayList<>();
        File[] files = mInternalThemesDir.listFiles(File::isDirectory);
        if (files != null) {
            for (File f : files) {
                themes.add(f.getName());
            }
        }
        return themes;
    }

    public boolean importTheme(String themeInfo) {
        // themeInfo refers to the folder name in external storage
        File srcDir = new File(mExternalThemesDir, themeInfo);
        File destDir = new File(mInternalThemesDir, themeInfo);

        if (!srcDir.exists())
            return false;

        DebugLogger.i(TAG, "Importing theme: " + themeInfo);

        // Recursive Copy
        return copyDirectory(srcDir, destDir);
    }

    public List<ClusterHudManager.HudComponentData> loadTheme(String themeName) {
        File themeDir = new File(mInternalThemesDir, themeName);
        File jsonFile = new File(themeDir, "theme.json");

        // Hardcoded Style 2 Support (Built-in)
        if ("Style 2".equals(themeName)) {
            // Return empty list for now, or a placeholder component to prove it works
            List<ClusterHudManager.HudComponentData> style2Data = new ArrayList<>();

            // 1. Background Rail (Original Vector Drawable)
            android.graphics.drawable.Drawable drawable = mContext.getResources()
                    .getDrawable(R.drawable.ic_style2_polyline, null);
            if (drawable != null) {
                // Tint for visibility
                drawable.setTint(android.graphics.Color.WHITE);
                drawable.setAlpha(100); // 40% Transparent

                // CRITICAL: Use fixed 300x150 px to match path gauge dimensions
                // (getIntrinsicWidth returns dp-scaled values which don't match our path
                // coordinates)
                int fixedWidth = 300;
                int fixedHeight = 150;
                Bitmap bitmap = Bitmap.createBitmap(fixedWidth, fixedHeight, Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
                drawable.setBounds(0, 0, fixedWidth, fixedHeight);
                drawable.draw(canvas);

                ClusterHudManager.HudComponentData bg = new ClusterHudManager.HudComponentData();
                bg.type = "gauge"; // Use 'gauge' type to render as ImageView
                bg.image = bitmap;
                // Center at screen position (960, 360)
                bg.x = 960 - (fixedWidth / 2f); // = 810
                bg.y = 360 - (fixedHeight / 2f); // = 285
                style2Data.add(bg);
            }

            // 2. RPM Gauge (LOWER Half, Red)
            // For 45° diagonal, perpendicular offset of 7.5 = (5.3, 5.3) down-right
            // Calculations:
            // - Diagonal start: (20+5.3, 126+5.3) = (25.3, 131.3)
            // - Diagonal line: y = -x + 156.6
            // - Horizontal at Y=27.5 intersects at X: 27.5 = -x + 156.6 → x = 129.1
            // - Path: M 25.3,131.3 L 129.1,27.5 L 276,27.5
            ClusterHudManager.HudComponentData rpmGauge = new ClusterHudManager.HudComponentData();
            rpmGauge.type = "path_gauge";
            rpmGauge.text = "rpm";
            rpmGauge.pathData = "M 25.3,131.3 L 129.1,27.5 L 276,27.5";
            rpmGauge.color = android.graphics.Color.RED;
            rpmGauge.maxValue = 8000;
            // Position SAME as background to ensure alignment
            rpmGauge.x = 960 - 150; // Background is 300px wide, centered at 960
            rpmGauge.y = 360 - 75; // Background is 150px tall, centered at 360
            // gaugeConfig: [strokeWidth, viewWidth, viewHeight, 0]
            rpmGauge.gaugeConfig = new float[] { 15f, 300f, 150f, 0 };
            style2Data.add(rpmGauge);

            // 3. Speed Gauge (UPPER Half, Cyan)
            // For 45° diagonal, perpendicular offset of 7.5 = (-5.3, -5.3) up-left
            // Calculations:
            // - Diagonal start: (20-5.3, 126-5.3) = (14.7, 120.7)
            // - Diagonal line: y = -x + 135.4
            // - Horizontal at Y=12.5 intersects at X: 12.5 = -x + 135.4 → x = 122.9
            // - Path: M 14.7,120.7 L 122.9,12.5 L 276,12.5
            ClusterHudManager.HudComponentData speedGauge = new ClusterHudManager.HudComponentData();
            speedGauge.type = "path_gauge";
            speedGauge.text = "speed";
            speedGauge.pathData = "M 14.7,120.7 L 122.9,12.5 L 276,12.5";
            speedGauge.color = android.graphics.Color.CYAN;
            speedGauge.maxValue = 240;
            speedGauge.x = 960 - 150;
            speedGauge.y = 360 - 75;
            speedGauge.gaugeConfig = new float[] { 15f, 300f, 150f, 0 };
            style2Data.add(speedGauge);

            // Debug Text
            ClusterHudManager.HudComponentData debugText = new ClusterHudManager.HudComponentData();
            debugText.type = "debug_status";
            debugText.text = "Init..."; // Initial state
            // Use a unique tag/text key so we can find it
            // Hack: Use type="text" and a recognizable starting text, or misuse the 'text'
            // field as ID?
            // HudComponentData has 'type' and 'text'.
            // Presentation uses data.text as initial text.
            // But we can identify it by position or order? No.
            // Let's use a specific type "debug_console" which behaves like text but is
            // findable.
            // But Presentation switch case needs to handle it.
            // Easier: Use type "text" but set a special property?
            // Let's use internal agreement: if type="text" and x=400, y=100.
            // Better: Add "debug_status" type to Presentation.
            debugText.type = "debug_status";
            debugText.color = android.graphics.Color.YELLOW;
            debugText.x = 400;
            debugText.y = 100;
            style2Data.add(debugText);

            return style2Data;
        }

        if (!jsonFile.exists()) {
            DebugLogger.e(TAG, "theme.json not found for: " + themeName);
            return Collections.emptyList();
        }

        try {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jsonFile)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }

            JSONObject root = new JSONObject(sb.toString());
            JSONArray components = root.optJSONArray("components");
            if (components == null)
                return Collections.emptyList();

            List<ClusterHudManager.HudComponentData> dataList = new ArrayList<>();

            // Parse Components
            for (int i = 0; i < components.length(); i++) {
                JSONObject obj = components.getJSONObject(i);
                ClusterHudManager.HudComponentData data = new ClusterHudManager.HudComponentData();

                data.type = obj.optString("type", "text");
                data.text = obj.optString("text", null); // Optional default text
                data.x = (float) obj.optDouble("x", 0);
                data.y = (float) obj.optDouble("y", 0);

                String colorStr = obj.optString("color", "#FFFFFF");
                try {
                    data.color = android.graphics.Color.parseColor(colorStr);
                } catch (Exception e) {
                    data.color = android.graphics.Color.WHITE;
                }

                // Image Loading
                String imgName = obj.optString("image", null);
                if (imgName != null) {
                    File imgFile = new File(themeDir, imgName);
                    if (imgFile.exists()) {
                        data.image = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                    }
                }

                // Font Loading
                String fontName = obj.optString("font", null);
                if (fontName != null) {
                    File fontFile = new File(themeDir, fontName);
                    if (fontFile.exists()) {
                        try {
                            data.typeface = android.graphics.Typeface.createFromFile(fontFile);
                        } catch (Exception e) {
                            DebugLogger.e(TAG, "Failed to load font: " + fontName, e);
                        }
                    }
                }

                // Gauge Config Parsing
                if ("gauge".equals(data.type)) {
                    JSONObject config = obj.optJSONObject("config");
                    if (config != null) {
                        // We need to pass this config to the View.
                        // Since HudComponentData doesn't have a generic map, and we can't easily modify
                        // it to hold a Bundle due to reflection issues in minimal setup,
                        // We will rely on tagging the View later.
                        // Wait, data object DOES NOT have extra fields.
                        // I added 'Object tag' to HudComponentData in my thought process but not in
                        // actual class file yet.
                        // I should verify HudComponentData definition.
                        // If it's a simple struct, I might need to add a field.
                        // CHECK: ClusterHudManager.java inner class.
                        // Currently it has: type, text, image, x, y, color.
                        // I need to ADD 'gaugeConfig' to HudComponentData.
                        // Let's assume I will extend it.
                        // Since I am writing this file first, I'll store it as a Bundle or Map if I can
                        // mod HudComponentData.
                        // Or, I can misuse 'text' field to store JSON string of config? generic but
                        // ugly.
                        // Or add a generic 'Object extra' field.

                        // Let's modify HudComponentData first or assumes it exists.
                        // I will add 'gaugeConfig' as a float[] array: [min, max, start, end, px, py]
                        float min = (float) config.optDouble("min_val", 0);
                        float max = (float) config.optDouble("max_val", 100);
                        float start = (float) config.optDouble("start_angle", 0);
                        float end = (float) config.optDouble("end_angle", 0);
                        float px = (float) config.optDouble("pivot_x", 0.5);
                        float py = (float) config.optDouble("pivot_y", 0.5);

                        data.gaugeConfig = new float[] { min, max, start, end, px, py };
                    }
                }

                dataList.add(data);
            }
            return dataList;

        } catch (Exception e) {
            DebugLogger.e(TAG, "Failed to parse theme: " + themeName, e);
            return Collections.emptyList();
        }
    }

    private boolean copyDirectory(File source, File destination) {
        if (!destination.exists()) {
            destination.mkdirs();
        }
        File[] files = source.listFiles();
        if (files == null)
            return false;

        boolean success = true;
        for (File f : files) {
            if (f.isDirectory()) {
                File newDest = new File(destination, f.getName());
                if (!copyDirectory(f, newDest))
                    success = false;
            } else {
                if (!copyFile(f, new File(destination, f.getName())))
                    success = false;
            }
        }
        return success;
    }

    private boolean copyFile(File source, File dest) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
                FileOutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            return true;
        } catch (Exception e) {
            DebugLogger.e(TAG, "Copy failed: " + source.getName(), e);
            return false;
        }
    }
}
