package cn.navitool;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final String TAG = "ConfigManager";
    private static final String CONFIG_FILE_PATH = "/sdcard/NaviTool/config.xml";
    private static ConfigManager instance;
    private Properties properties;

    private ConfigManager() {
        properties = new Properties();
        loadConfig();
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private void loadConfig() {
        File file = new File(CONFIG_FILE_PATH);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                properties.loadFromXML(fis);
                Log.i(TAG, "Configuration loaded from " + CONFIG_FILE_PATH);
            } catch (IOException e) {
                Log.e(TAG, "Failed to load configuration", e);
            }
        } else {
            Log.i(TAG, "Configuration file not found, creating new one.");
            saveConfig();
        }
    }

    public synchronized void saveConfig() {
        File file = new File(CONFIG_FILE_PATH);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            properties.storeToXML(fos, "NaviTool Configuration");
            Log.i(TAG, "Configuration saved to " + CONFIG_FILE_PATH);
        } catch (IOException e) {
            Log.e(TAG, "Failed to save configuration", e);
        }
    }

    // String
    public synchronized void setString(String key, String value) {
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
