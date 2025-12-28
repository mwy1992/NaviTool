package cn.navitool;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final String TAG = "ConfigManager";
    private static final String EXTERNAL_PATH = "/sdcard/NaviTool/config.xml";
    private static final String INTERNAL_FILENAME = "config.xml";

    private static ConfigManager instance;
    private static android.content.Context sContext;
    private Properties properties;

    private ConfigManager() {
        properties = new Properties();
        loadConfig();
    }

    public static void init(android.content.Context context) {
        boolean wasNull = (sContext == null);
        sContext = context.getApplicationContext();

        // If instance already exists but was initialized without context
        // (Headless/Service start),
        // we must reload now that we have FilesDir access.
        if (instance != null && wasNull) {
            Log.i(TAG, "Context injected after initialization. Reloading config from Internal Storage...");
            instance.loadConfig();
        }
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadConfig() {
        // Priority 1: Internal Storage (Reliable)
        boolean loaded = false;
        if (sContext != null) {
            File internalFile = new File(sContext.getFilesDir(), INTERNAL_FILENAME);
            if (internalFile.exists()) {
                try (FileInputStream fis = new FileInputStream(internalFile)) {
                    properties.loadFromXML(fis);
                    Log.i(TAG, "Loaded config from Internal Storage: " + internalFile.getAbsolutePath());
                    loaded = true;
                } catch (IOException e) {
                    Log.e(TAG, "Failed to load Internal config", e);
                }
            }
        }

        // Priority 2: External Storage (User/Legacy)
        if (!loaded) {
            File externalFile = new File(EXTERNAL_PATH);
            if (externalFile.exists()) {
                try (FileInputStream fis = new FileInputStream(externalFile)) {
                    properties.loadFromXML(fis);
                    Log.i(TAG, "Loaded config from External Storage: " + EXTERNAL_PATH);
                    loaded = true;
                    // Migrate to Internal immediately
                    saveConfig();
                } catch (IOException e) {
                    Log.e(TAG, "Failed to load External config", e);
                }
            }
        }

        if (!loaded) {
            Log.i(TAG, "No config found. Creating new default.");
            saveConfig();
        }
    }

    public synchronized void saveConfig() {
        // Prio 1: Save to Internal
        if (sContext != null) {
            try {
                File internalFile = new File(sContext.getFilesDir(), INTERNAL_FILENAME);
                try (FileOutputStream fos = new FileOutputStream(internalFile)) {
                    properties.storeToXML(fos, "NaviTool Configuration");
                    Log.i(TAG, "Saved to Internal: " + internalFile.getAbsolutePath());
                }
            } catch (Exception e) {
                Log.e(TAG, "Failed to save Internal config", e);
            }
        }

        // Prio 2: Save to External (Best Effort)
        try {
            File externalFile = new File(EXTERNAL_PATH);
            File parent = externalFile.getParentFile();
            if (parent != null && !parent.exists())
                parent.mkdirs();

            try (FileOutputStream fos = new FileOutputStream(externalFile)) {
                properties.storeToXML(fos, "NaviTool Configuration");
                Log.i(TAG, "Saved to External: " + EXTERNAL_PATH);
            }
        } catch (Exception e) {
            // Log but don't crash, external might be restricted
            Log.w(TAG, "Failed to save External config (Permission?): " + e.getMessage());
        }
    }

    // String
    public synchronized void setString(String key, String value) {
        if (value == null)
            value = "";
        properties.setProperty(key, value);
        saveConfig();
    }

    public String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    // Boolean
    public synchronized void setBoolean(String key, boolean value) {
        setString(key, String.valueOf(value));
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String val = properties.getProperty(key);
        if (val != null) {
            return Boolean.parseBoolean(val);
        }
        return defaultValue;
    }

    // Integer
    public synchronized void setInt(String key, int value) {
        setString(key, String.valueOf(value));
    }

    public int getInt(String key, int defaultValue) {
        String val = properties.getProperty(key);
        if (val != null) {
            try {
                return Integer.parseInt(val);
            } catch (NumberFormatException e) {
                Log.e(TAG, "Error parsing int for key: " + key, e);
            }
        }
        return defaultValue;
    }
}
