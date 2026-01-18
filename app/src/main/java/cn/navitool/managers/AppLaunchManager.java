package cn.navitool.managers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.navitool.ConfigManager;
import cn.navitool.DebugLogger;
import cn.navitool.R;

public class AppLaunchManager {
    private static final String TAG = "AppLaunchManager";
    private static final String PREFS_NAME = "navitool_prefs";
    private static final String KEY_APP_CONFIG = "app_launch_config";
    private static final String KEY_AUTO_START_APPS_ENABLED = "auto_start_apps_enabled";
    private static final String KEY_RETURN_TO_HOME = "return_to_home_after_launch";
    private static final String KEY_TOP_APPS = "top_row_apps_config"; // [NEW] Key for top row apps

    public static class AppConfig {
        public String packageName;
        public int delaySeconds;

        public AppConfig(String packageName, int delaySeconds) {
            this.packageName = packageName;
            this.delaySeconds = delaySeconds;
        }
    }

    public static class AppInfo {
        public String name;
        public String packageName;

        public AppInfo(String name, String packageName) {
            this.name = name;
            this.packageName = packageName;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void setAutoStartEnabled(Context context, boolean enabled) {
        ConfigManager.getInstance().setBoolean(KEY_AUTO_START_APPS_ENABLED, enabled);
    }

    public static boolean isAutoStartEnabled(Context context) {
        return ConfigManager.getInstance().getBoolean(KEY_AUTO_START_APPS_ENABLED, false);
    }

    public static void setReturnToHomeEnabled(Context context, boolean enabled) {
        ConfigManager.getInstance().setBoolean(KEY_RETURN_TO_HOME, enabled);
    }

    public static boolean isReturnToHomeEnabled(Context context) {
        return ConfigManager.getInstance().getBoolean(KEY_RETURN_TO_HOME, false);
    }

    public static void saveConfig(Context context, List<AppConfig> configs) {
        JSONArray jsonArray = new JSONArray();
        for (AppConfig config : configs) {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pkg", config.packageName);
                jsonObject.put("delay", config.delaySeconds);
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ConfigManager.getInstance().setString(KEY_APP_CONFIG, jsonArray.toString());
    }

    public static List<AppConfig> loadConfig(Context context) {
        List<AppConfig> configs = new ArrayList<>();
        String jsonString = ConfigManager.getInstance().getString(KEY_APP_CONFIG, "[]");
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                configs.add(new AppConfig(
                        obj.getString("pkg"),
                        obj.getInt("delay")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return configs;
    }

    // [NEW] Save Top Row Apps
    public static void saveTopApps(Context context, List<String> packageNames) {
        JSONArray jsonArray = new JSONArray();
        for (String pkg : packageNames) {
            jsonArray.put(pkg);
        }
        ConfigManager.getInstance().setString(KEY_TOP_APPS, jsonArray.toString());
    }

    // [NEW] Load Top Row Apps
    public static List<String> loadTopApps(Context context) {
        List<String> packages = new ArrayList<>();
        String jsonString = ConfigManager.getInstance().getString(KEY_TOP_APPS, "[]");
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                packages.add(jsonArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return packages;
    }

    public static List<AppInfo> getInstalledApps(Context context) {
        List<AppInfo> apps = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<android.content.pm.ResolveInfo> activities = pm.queryIntentActivities(intent, 0);

        for (android.content.pm.ResolveInfo resolveInfo : activities) {
            String packageName = resolveInfo.activityInfo.packageName;
            String label = resolveInfo.loadLabel(pm).toString();
            // Avoid duplicates if multiple activities point to same package?
            // Usually we want the main one. We can check if package is already in list or
            // allow multiple entries?
            // For simplicity, let's keep it simple unique by package name if desired, or
            // just allow all entry points.
            // But AppConfig logic uses packageName, so we only need one entry per package.
            boolean exists = false;
            for (AppInfo info : apps) {
                if (info.packageName.equals(packageName)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                apps.add(new AppInfo(label, packageName));
            }
        }
        java.text.Collator collator = java.text.Collator.getInstance(java.util.Locale.CHINA);
        Collections.sort(apps, (a, b) -> collator.compare(a.name, b.name));

        // [FIX] Move "cn.navitool" to first position
        AppInfo naviTool = null;
        java.util.Iterator<AppInfo> it = apps.iterator();
        while (it.hasNext()) {
            AppInfo info = it.next();
            if ("cn.navitool".equals(info.packageName)) {
                naviTool = info;
                it.remove();
                break;
            }
        }

        // Add Placeholders (5 if NaviTool found, 6 otherwise)
        int placeholders = (naviTool != null) ? 5 : 6;
        for (int i = 0; i < placeholders; i++) {
            apps.add(0, new AppInfo("", ""));
        }

        // Add NaviTool at very top (Index 0)
        if (naviTool != null) {
            apps.add(0, naviTool);
        }
        return apps;
    }

    public static void executeLaunch(Context context) {
        if (!isAutoStartEnabled(context)) {
            Log.d(TAG, "Auto start apps disabled.");
            return;
        }

        List<AppConfig> configs = loadConfig(context);
        Handler handler = new Handler(Looper.getMainLooper());
        boolean returnToHome = isReturnToHomeEnabled(context);

        long accumulatedDelayMs = 0;

        for (AppConfig config : configs) {
            if (config.packageName == null || config.packageName.isEmpty())
                continue;

            // Cumulative delay: wait for previous launches + this app's specific delay
            accumulatedDelayMs += config.delaySeconds * 1000L;

            handler.postDelayed(() -> {
                try {
                    PackageManager pm = context.getPackageManager();
                    Intent intent = pm.getLaunchIntentForPackage(config.packageName);
                    if (intent != null) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

                        context.startActivity(intent);
                        DebugLogger.toast(context,
                                String.format(context.getString(R.string.launching_app), config.packageName));
                        Log.d(TAG, "Launched " + config.packageName);
                    } else {
                        Log.e(TAG, "Could not find launch intent for " + config.packageName);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error launching " + config.packageName, e);
                }
            }, accumulatedDelayMs);
        }

        // Return to home screen after all launches complete
        if (returnToHome) {
            // Add a fixed buffer (e.g., 5 seconds) after the last app launch
            handler.postDelayed(() -> {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(homeIntent);
                Log.d(TAG, "Returned to home screen");
            }, accumulatedDelayMs + 5000L);
        }
    }

    public static void launchApp(Context context, String packageName) {
        try {
            PackageManager pm = context.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                context.startActivity(intent);
                DebugLogger.toast(context,
                        String.format(context.getString(R.string.launching_app), packageName));
            } else {
                DebugLogger.toast(context, String.format(context.getString(R.string.error_launch_failed), packageName));
                Log.e(TAG, "No launch intent for " + packageName);
            }
        } catch (Exception e) {
            DebugLogger.toast(context,
                    String.format(context.getString(R.string.error_launch_exception), e.getMessage()));
            Log.e(TAG, "Error launching " + packageName, e);
        }
    }
}
