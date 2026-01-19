package cn.navitool.managers;

import android.util.Log;
import android.content.SharedPreferences;

import cn.navitool.utils.DebugLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final String TAG = "ConfigManager";
    private static final String EXTERNAL_PATH = "/sdcard/NaviTool/config.xml";
    // private static final String INTERNAL_FILENAME = "config.xml"; // Unused

    private static ConfigManager instance;
    private static android.content.Context sContext;
    private Properties mProperties;
    private SharedPreferences mPrefs;

    private ConfigManager() {
        mProperties = new Properties();
        // Setup mPrefs when init is called with context
    }

    public static void init(android.content.Context context) {
        DebugLogger.e(TAG, "ConfigManager.init() called");
        sContext = context.getApplicationContext();
        if (instance == null) {
            instance = new ConfigManager();
        }
        // Use DefaultSharedPreferences for maximum compatibility and standard file
        // location
        instance.mPrefs = sContext.getSharedPreferences("navitool_prefs", android.content.Context.MODE_PRIVATE);
        DebugLogger.e(TAG, "ConfigManager initialized mPrefs: " + (instance.mPrefs != null));
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    // Manual Import (Reset/Override SharedPreferences from XML)
    public void importConfig() {
        if (sContext == null)
            return;
        File externalFile = new File(EXTERNAL_PATH);
        if (externalFile.exists()) {
            try (FileInputStream fis = new FileInputStream(externalFile)) {
                mProperties.clear();
                mProperties.loadFromXML(fis);

                if (mPrefs != null) {
                    SharedPreferences.Editor editor = mPrefs.edit();
                    for (String key : mProperties.stringPropertyNames()) {
                        editor.putString(key, mProperties.getProperty(key));
                    }
                    editor.commit(); // Ensure write
                }
                DebugLogger.i(TAG, "Imported config from External Storage");
            } catch (IOException e) {
                DebugLogger.e(TAG, "Failed to import External config", e);
            }
        }
    }

    public synchronized void saveProperties() {
        // Export Current SharedPreferences to XML (Backup)
        if (mPrefs == null || sContext == null)
            return;

        mProperties.clear();
        java.util.Map<String, ?> allEntries = mPrefs.getAll();
        for (java.util.Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if (entry.getValue() != null) {
                mProperties.setProperty(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }

        // Save to External (Backup)
        try {
            File externalFile = new File(EXTERNAL_PATH);
            File parent = externalFile.getParentFile();
            if (parent != null && !parent.exists())
                parent.mkdirs();

            try (FileOutputStream fos = new FileOutputStream(externalFile)) {
                mProperties.storeToXML(fos, "NaviTool Configuration");
                DebugLogger.i(TAG, "Exported config to: " + EXTERNAL_PATH);
            }
        } catch (Exception e) {
            DebugLogger.w(TAG, "Failed to export config: " + e.getMessage());
        }
    }

    // String
    public synchronized void setString(String key, String value) {
        if (mPrefs != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(key, value);
            // Critical: Use commit() to ensure write to disk before process death
            boolean success = editor.commit();
            DebugLogger.e(TAG, "setString(" + key + ", " + value + ") success=" + success);
        } else {
            DebugLogger.e(TAG, "setString(" + key + ", " + value + ") FAILED: mPrefs is null");
        }
        // saveProperties(); // Disable auto-export on every change for performance
    }

    public String getString(String key, String defaultValue) {
        if (mPrefs != null) {
            String val = mPrefs.getString(key, defaultValue);
            DebugLogger.e(TAG, "getString(" + key + ") returned: " + val);
            return val;
        }
        DebugLogger.e(TAG, "getString(" + key + ") FAILED: mPrefs is null, returning default: " + defaultValue);
        return defaultValue;
    }

    // Boolean
    public synchronized void setBoolean(String key, boolean value) {
        if (mPrefs != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putBoolean(key, value);
            boolean success = editor.commit(); // Use commit() for sync save
            DebugLogger.e(TAG, "setBoolean(" + key + ", " + value + ") success=" + success);
        } else {
            DebugLogger.e(TAG, "setBoolean(" + key + ", " + value + ") FAILED: mPrefs is null");
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        if (mPrefs != null && mPrefs.contains(key)) {
            try {
                return mPrefs.getBoolean(key, defaultValue);
            } catch (ClassCastException e) {
                // Compatibility: Parse from String if type mismatch
                String val = mPrefs.getString(key, String.valueOf(defaultValue));
                if ("true".equalsIgnoreCase(val) || "false".equalsIgnoreCase(val)) {
                    return Boolean.parseBoolean(val);
                }
                return defaultValue;
            }
        }
        return defaultValue;
    }

    // Integer
    public synchronized void setInt(String key, int value) {
        if (mPrefs != null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putInt(key, value);
            boolean success = editor.commit(); // Use commit() for sync save
            DebugLogger.e(TAG, "setInt(" + key + ", " + value + ") success=" + success);
        } else {
            DebugLogger.e(TAG, "setInt(" + key + ", " + value + ") FAILED: mPrefs is null");
        }
    }

    public int getInt(String key, int defaultValue) {
        if (mPrefs != null && mPrefs.contains(key)) {
            try {
                return mPrefs.getInt(key, defaultValue);
            } catch (ClassCastException e) {
                // Compatibility: Parse from String if type mismatch
                String val = mPrefs.getString(key, String.valueOf(defaultValue));
                try {
                    return Integer.parseInt(val);
                } catch (NumberFormatException nfe) {
                    return defaultValue;
                }
            }
        }
        return defaultValue;
    }
}
