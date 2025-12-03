package cn.navitool;

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

public class AppLaunchManager {
    private static final String TAG = "AppLaunchManager";
    private static final String PREFS_NAME = "navitool_prefs";
    private static final String KEY_APP_CONFIG = "app_launch_config";
    private static final String KEY_AUTO_START_APPS_ENABLED = "auto_start_apps_enabled";

    public static class AppConfig {
        public String packageName;
        public boolean background;
        public int delaySeconds;

        public AppConfig(String packageName, boolean background, int delaySeconds) {
            this.packageName = packageName;
            this.background = background;
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
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .edit().putBoolean(KEY_AUTO_START_APPS_ENABLED, enabled).apply();
    }

    public static boolean isAutoStartEnabled(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getBoolean(KEY_AUTO_START_APPS_ENABLED, false);
    }

    public static void saveConfig(Context context, List<AppConfig> configs) {
        JSONArray jsonArray = new JSONArray();
        for (AppConfig config : configs) {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pkg", config.packageName);
                jsonObject.put("bg", config.background);
                jsonObject.put("delay", config.delaySeconds);
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .edit().putString(KEY_APP_CONFIG, jsonArray.toString()).apply();
    }

    public static List<AppConfig> loadConfig(Context context) {
        List<AppConfig> configs = new ArrayList<>();
        String jsonString = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getString(KEY_APP_CONFIG, "[]");
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                configs.add(new AppConfig(
                        obj.getString("pkg"),
                        obj.getBoolean("bg"),
                        obj.getInt("delay")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return configs;
    }

    public static List<AppInfo> getInstalledApps(Context context) {
        List<AppInfo> apps = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        
        for (ApplicationInfo appInfo : packages) {
            // Filter out system apps unless updated, or just show all launchable apps?
            // Better to show only apps with launch intents
            if (pm.getLaunchIntentForPackage(appInfo.packageName) != null) {
                String label = pm.getApplicationLabel(appInfo).toString();
                apps.add(new AppInfo(label, appInfo.packageName));
            }
        }
        Collections.sort(apps, (a, b) -> a.name.compareToIgnoreCase(b.name));
        return apps;
    }

    public static void executeLaunch(Context context) {
        if (!isAutoStartEnabled(context)) {
            Log.d(TAG, "Auto start apps disabled.");
            return;
        }

        List<AppConfig> configs = loadConfig(context);
        Handler handler = new Handler(Looper.getMainLooper());

        for (AppConfig config : configs) {
            if (config.packageName == null || config.packageName.isEmpty()) continue;

            handler.postDelayed(() -> {
                try {
                    PackageManager pm = context.getPackageManager();
                    Intent intent = pm.getLaunchIntentForPackage(config.packageName);
                    if (intent != null) {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        
                        if (config.background) {
                            // Try to launch in background
                            // Check for Overlay permission which is often required for background starts
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M 
                                    && !android.provider.Settings.canDrawOverlays(context)) {
                                DebugLogger.toast(context, context.getString(R.string.background_launch_warning));
                                Log.w(TAG, "Background launch might fail without Overlay permission.");
                            }
                        }
                        
                        context.startActivity(intent);
                        DebugLogger.toast(context, String.format(context.getString(R.string.launching_app), config.packageName));
                        Log.d(TAG, "Launched " + config.packageName);
                    } else {
                        Log.e(TAG, "Could not find launch intent for " + config.packageName);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error launching " + config.packageName, e);
                }
            }, config.delaySeconds * 1000L);
        }
    }
}
