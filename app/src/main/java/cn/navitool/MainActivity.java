package cn.navitool;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private LinearLayout layoutAppList;
    private ImageButton btnAddApp;
    private List<AppLaunchManager.AppInfo> installedApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        setContentView(R.layout.activity_main);

        initUI();
        checkPermissions();

        // Try to start service if permissions are granted
        if (hasStoragePermission()) {
            startService(new Intent(this, BootLogService.class));
        }

        // Load installed apps async
        new Thread(() -> {
            installedApps = AppLaunchManager.getInstalledApps(this);
            runOnUiThread(() -> {
                // Restore saved config
                restoreAppConfig();
            });
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermissions(); // Refresh status on resume

        android.content.IntentFilter filter = new android.content.IntentFilter();
        filter.addAction("cn.navitool.ACTION_DAY_NIGHT_STATUS");
        registerReceiver(mDayNightStatusReceiver, filter);

        android.content.IntentFilter oneOSFilter = new android.content.IntentFilter();
        oneOSFilter.addAction("cn.navitool.ACTION_ONEOS_STATUS");
        registerReceiver(mOneOSStatusReceiver, oneOSFilter);

        // Request status update
        sendBroadcast(new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS"));
        sendBroadcast(new Intent("cn.navitool.ACTION_REQUEST_ONEOS_STATUS"));
    }

    private void initUI() {
        // Setup Permission Status Items
        setupStatusItem(R.id.statusAutoStart, R.string.perm_auto_start, this::requestAutoStart);
        setupStatusItem(R.id.statusOverlay, R.string.perm_overlay, this::requestOverlayPermission);
        setupStatusItem(R.id.statusStorage, R.string.perm_storage, this::requestStoragePermission);
        setupStatusItem(R.id.statusAccessibility, R.string.perm_accessibility, this::requestAccessibilityPermission);
        setupStatusItem(R.id.statusBattery, R.string.perm_battery, this::requestBatteryOptimization);

        // Buttons
        View layoutDebugButtons = findViewById(R.id.layoutDebugButtons);
        findViewById(R.id.btnForceLight).setOnClickListener(v -> sendAutoNaviBroadcast(1));
        findViewById(R.id.btnForceDark).setOnClickListener(v -> sendAutoNaviBroadcast(2));

        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);

        // Auto Switch Toggle
        SwitchMaterial switchAutoTheme = findViewById(R.id.switchAutoTheme);
        switchAutoTheme.setChecked(prefs.getBoolean("auto_theme_sync", true));
        switchAutoTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("auto_theme_sync", isChecked).apply();
            if (isChecked) {
                DebugLogger.toast(this, getString(R.string.auto_theme_sync_enabled));
            } else {
                DebugLogger.toast(this, getString(R.string.auto_theme_sync_disabled));
            }
        });

        // Force Auto Day/Night Toggle
        SwitchMaterial switchForceAutoDayNight = findViewById(R.id.switchForceAutoDayNight);
        View layoutAutoModeStatus = findViewById(R.id.layoutAutoModeStatus);
        TextView tvAutoModeStatus = findViewById(R.id.tvAutoModeStatus);

        boolean isForceAuto = prefs.getBoolean("force_auto_day_night", false);
        switchForceAutoDayNight.setChecked(isForceAuto);
        // layoutAutoModeStatus.setVisibility(isForceAuto ? View.VISIBLE : View.GONE);
        // // Always visible

        // Set initial text to avoid showing placeholder
        if (tvAutoModeStatus != null) {
            tvAutoModeStatus.setText(getString(R.string.status_auto_mode, getString(R.string.mode_unknown)));
        }

        switchForceAutoDayNight.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("force_auto_day_night", isChecked).apply();
            // layoutAutoModeStatus.setVisibility(isChecked ? View.VISIBLE : View.GONE); //
            // Always visible

            // Notify service immediately about the change
            Intent intent = new Intent("cn.navitool.ACTION_FORCE_AUTO_MODE_CHANGED");
            intent.putExtra("enabled", isChecked);
            sendBroadcast(intent);

            // Request immediate status update if enabling
            if (isChecked) {
                Intent requestIntent = new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
                sendBroadcast(requestIntent);
            }
        });

        // Steering Wheel Toggle
        SwitchMaterial switchSteeringWheel = findViewById(R.id.switchSteeringWheel);
        switchSteeringWheel.setChecked(prefs.getBoolean("steering_wheel_control", false));
        switchSteeringWheel.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("steering_wheel_control", isChecked).apply();
            if (isChecked) {
                DebugLogger.toast(this, getString(R.string.steering_wheel_enabled));
            } else {
                DebugLogger.toast(this, getString(R.string.steering_wheel_disabled));
            }
        });

        // Auto Start Apps UI
        SwitchMaterial switchAutoStartApps = findViewById(R.id.switchAutoStartApps);
        btnAddApp = findViewById(R.id.btnAddApp);
        Button btnTestLaunch = findViewById(R.id.btnTestLaunch);
        layoutAppList = findViewById(R.id.layoutAppList);

        switchAutoStartApps.setChecked(AppLaunchManager.isAutoStartEnabled(this));
        btnAddApp.setVisibility(switchAutoStartApps.isChecked() ? View.VISIBLE : View.GONE);
        layoutAppList.setVisibility(switchAutoStartApps.isChecked() ? View.VISIBLE : View.GONE);

        switchAutoStartApps.setOnCheckedChangeListener((v, isChecked) -> {
            AppLaunchManager.setAutoStartEnabled(this, isChecked);
            btnAddApp.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            layoutAppList.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            if (DebugLogger.isDebugEnabled(this) && isChecked) {
                btnTestLaunch.setVisibility(View.VISIBLE);
            } else {
                btnTestLaunch.setVisibility(View.GONE);
            }
        });

        btnAddApp.setOnClickListener(v -> addAppRow(null));
        btnTestLaunch.setOnClickListener(v -> AppLaunchManager.executeLaunch(this));

        // Media Buttons (Debug Only)
        View layoutMediaButtons = findViewById(R.id.layoutMediaButtons);
        findViewById(R.id.btnMediaPrev)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS));
        findViewById(R.id.btnMediaPlayPause)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE));
        findViewById(R.id.btnMediaNext)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_NEXT));

        // Debug Switch
        SwitchMaterial switchDebug = findViewById(R.id.switchDebug);
        boolean isDebug = DebugLogger.isDebugEnabled(this);
        switchDebug.setChecked(isDebug);

        // Initial visibility
        layoutDebugButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        layoutMediaButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        btnTestLaunch.setVisibility(isDebug && switchAutoStartApps.isChecked() ? View.VISIBLE : View.GONE);

        switchDebug.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DebugLogger.setDebugEnabled(this, isChecked);
            layoutDebugButtons.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            layoutMediaButtons.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            btnTestLaunch.setVisibility(isChecked && switchAutoStartApps.isChecked() ? View.VISIBLE : View.GONE);

            if (isChecked) {
                DebugLogger.toast(this, getString(R.string.debug_mode_enabled));
            } else {
                Toast.makeText(this, R.string.debug_mode_disabled, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final android.content.BroadcastReceiver mDayNightStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("cn.navitool.ACTION_DAY_NIGHT_STATUS".equals(action)) {
                int mode = intent.getIntExtra("mode", 0);
                updateAutoModeStatus(mode);
            }
        }
    };

    private final android.content.BroadcastReceiver mOneOSStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("cn.navitool.ACTION_ONEOS_STATUS".equals(action)) {
                boolean isConnected = intent.getBooleanExtra("is_connected", false);
                updateOneOSStatus(isConnected);
            }
        }
    };

    private void updateAutoModeStatus(int mode) {
        TextView tvAutoModeStatus = findViewById(R.id.tvAutoModeStatus);
        ImageView imgAutoModeIcon = findViewById(R.id.imgAutoModeIcon); // Need to add ID to layout first
        if (tvAutoModeStatus == null)
            return;

        String modeStr;
        int iconRes;

        switch (mode) {
            case 0x20150103: // DAYMODE_SETTING_AUTO
                modeStr = getString(R.string.mode_auto);
                iconRes = R.drawable.ic_daymode_auto;
                break;
            case 0x20150101: // DAYMODE_SETTING_DAY
                modeStr = getString(R.string.mode_day);
                iconRes = R.drawable.ic_daymode_light;
                break;
            case 0x20150102: // DAYMODE_SETTING_NIGHT
                modeStr = getString(R.string.mode_night);
                iconRes = R.drawable.ic_daymode_dark;
                break;
            case 0x20150104: // VALUE_DAYMODE_CUSTOM
                modeStr = getString(R.string.mode_custom);
                iconRes = R.drawable.ic_daymode_auto; // Use auto icon for now
                break;
            case 0x20150105: // VALUE_DAYMODE_SUNRISE_AND_SUNSET
                modeStr = getString(R.string.mode_sunrise_sunset);
                iconRes = R.drawable.ic_daymode_time;
                break;
            default:
                modeStr = getString(R.string.mode_unknown);
                iconRes = R.drawable.ic_close;
                break;
        }
        tvAutoModeStatus.setText(getString(R.string.status_auto_mode, modeStr));
        if (imgAutoModeIcon != null) {
            imgAutoModeIcon.setImageResource(iconRes);
        }
    }

    private void updateOneOSStatus(boolean isConnected) {
        ImageView imgStatus = findViewById(R.id.imgMediaKeyServiceIcon);
        if (imgStatus == null)
            return;

        if (isConnected) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mDayNightStatusReceiver);
        unregisterReceiver(mOneOSStatusReceiver);
    }

    private void simulateMediaKey(int keyCode) {
        long eventTime = android.os.SystemClock.uptimeMillis();
        android.view.KeyEvent keyDown = new android.view.KeyEvent(eventTime, eventTime,
                android.view.KeyEvent.ACTION_DOWN, keyCode, 0);
        dispatchMediaKey(keyDown);

        android.view.KeyEvent keyUp = new android.view.KeyEvent(eventTime, eventTime, android.view.KeyEvent.ACTION_UP,
                keyCode, 0);
        dispatchMediaKey(keyUp);

        String keyName = getString(R.string.key_unknown);
        if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_NEXT)
            keyName = getString(R.string.key_next_track);
        else if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS)
            keyName = getString(R.string.key_prev_track);
        else if (keyCode == android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)
            keyName = getString(R.string.key_play_pause);

        DebugLogger.toast(this, getString(R.string.simulated_media_key, keyName));
    }

    private void dispatchMediaKey(android.view.KeyEvent keyEvent) {
        // Method 1: Dispatch via AudioManager
        android.media.AudioManager audioManager = (android.media.AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.dispatchMediaKeyEvent(keyEvent);
        }

        // Method 2: Send as broadcast (backup)
        Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaIntent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        mediaIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        mediaIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        sendBroadcast(mediaIntent);
    }

    private void setupStatusItem(int viewId, int nameResId, Runnable onClickAction) {
        View view = findViewById(viewId);
        TextView txtName = view.findViewById(R.id.txtPermissionName);
        txtName.setText(nameResId);

        // Set click listener on the whole view AND the fix button
        view.setOnClickListener(v -> onClickAction.run());
        Button btnFix = view.findViewById(R.id.btnFix);
        btnFix.setOnClickListener(v -> onClickAction.run());
    }

    private void updateStatusItem(int viewId, boolean granted) {
        View view = findViewById(viewId);
        ImageView imgStatus = view.findViewById(R.id.imgStatus);
        Button btnFix = view.findViewById(R.id.btnFix);

        if (granted) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_green_dark));
            btnFix.setVisibility(View.GONE);
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            btnFix.setVisibility(View.VISIBLE);
        }
    }

    private void checkPermissions() {
        updateStatusItem(R.id.statusAutoStart, true); // Can't easily check, assume true or user manual check
        updateStatusItem(R.id.statusOverlay, Settings.canDrawOverlays(this));
        updateStatusItem(R.id.statusStorage, hasStoragePermission());
        updateStatusItem(R.id.statusAccessibility, isAccessibilityServiceEnabled());

        boolean ignoringBattery = android.os.PowerManager.class.cast(getSystemService(Context.POWER_SERVICE))
                .isIgnoringBatteryOptimizations(getPackageName());
        updateStatusItem(R.id.statusBattery, ignoringBattery);

        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
    }

    private boolean hasStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            return ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }
    }

    private boolean isAccessibilityServiceEnabled() {
        ComponentName expectedComponentName = new ComponentName(this, KeepAliveAccessibilityService.class);
        String enabledServicesSetting = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
        if (enabledServicesSetting == null)
            return false;

        android.text.TextUtils.SimpleStringSplitter colonSplitter = new android.text.TextUtils.SimpleStringSplitter(
                ':');
        colonSplitter.setString(enabledServicesSetting);

        while (colonSplitter.hasNext()) {
            String componentNameString = colonSplitter.next();
            ComponentName enabledComponent = ComponentName.unflattenFromString(componentNameString);
            if (enabledComponent != null && enabledComponent.equals(expectedComponentName))
                return true;
        }
        return false;
    }

    // Permission Request Methods

    private void requestOverlayPermission() {
        if (!Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, PERMISSION_REQUEST_CODE);
        } else {
            DebugLogger.toast(this, getString(R.string.status_granted));
        }
    }

    private void requestStoragePermission() {
        if (!hasStoragePermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", getApplicationContext().getPackageName())));
                    startActivityForResult(intent, PERMISSION_REQUEST_CODE);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivityForResult(intent, PERMISSION_REQUEST_CODE);
                }
            } else {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE },
                        PERMISSION_REQUEST_CODE);
            }
        } else {
            DebugLogger.toast(this, getString(R.string.status_granted));
        }
    }

    private void requestBatteryOptimization() {
        Intent intent = new Intent();
        String packageName = getPackageName();
        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        if (!pm.isIgnoringBatteryOptimizations(packageName)) {
            intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.setData(Uri.parse("package:" + packageName));
            startActivity(intent);
        } else {
            DebugLogger.toast(this, getString(R.string.status_granted));
        }
    }

    private void requestAccessibilityPermission() {
        if (!isAccessibilityServiceEnabled()) {
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, R.string.enable_accessibility_toast, Toast.LENGTH_LONG).show();
        } else {
            DebugLogger.toast(this, getString(R.string.status_granted));
        }
    }

    private void requestAutoStart() {
        String manufacturer = Build.MANUFACTURER.toLowerCase();
        Intent intent = new Intent();
        try {
            if (manufacturer.contains("xiaomi")) {
                intent.setComponent(new ComponentName("com.miui.securitycenter",
                        "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            } else if (manufacturer.contains("oppo")) {
                intent.setComponent(new ComponentName("com.coloros.safecenter",
                        "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            } else if (manufacturer.contains("vivo")) {
                intent.setComponent(new ComponentName("com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
            } else if (manufacturer.contains("letv")) {
                intent.setComponent(new ComponentName("com.letv.android.letvsafe",
                        "com.letv.android.letvsafe.AutobootManageActivity"));
            } else if (manufacturer.contains("honor")) {
                intent.setComponent(new ComponentName("com.huawei.systemmanager",
                        "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            } else {
                intent.setAction(Settings.ACTION_SETTINGS);
                Toast.makeText(this, R.string.auto_start_settings_not_found, Toast.LENGTH_LONG).show();
            }
            startActivity(intent);
        } catch (Exception e) {
            intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, R.string.failed_open_auto_start, Toast.LENGTH_LONG).show();
        }
    }

    private void sendAutoNaviBroadcast(int mode) {
        Intent intent = new Intent("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.setComponent(new ComponentName("com.autonavi.amapauto",
                "com.autonavi.amapauto.adapter.internal.AmapAutoBroadcastReceiver"));
        intent.putExtra("KEY_TYPE", 10048);
        intent.putExtra("EXTRA_DAY_NIGHT_MODE", mode);
        sendBroadcast(intent);
        DebugLogger.log(this, "MainActivity", "Sent AutoNavi Broadcast: Mode " + mode);
        DebugLogger.log(this, "MainActivity", "Sent AutoNavi Broadcast: Mode " + mode);
        DebugLogger.toast(this, getString(R.string.sent_autonavi_broadcast, mode));
    }

    private void restoreAppConfig() {
        List<AppLaunchManager.AppConfig> configs = AppLaunchManager.loadConfig(this);
        layoutAppList.removeAllViews();
        for (AppLaunchManager.AppConfig config : configs) {
            addAppRow(config);
        }
    }

    private void addAppRow(AppLaunchManager.AppConfig config) {
        if (installedApps == null)
            return;

        View row = getLayoutInflater().inflate(R.layout.item_app_launch_config, layoutAppList, false);

        Spinner spinnerApp = row.findViewById(R.id.spinnerApp);
        Spinner spinnerDelay = row.findViewById(R.id.spinnerDelay);
        SwitchMaterial switchBackground = row.findViewById(R.id.switchBackground);
        ImageButton btnDelete = row.findViewById(R.id.btnDelete);

        // Setup App Spinner
        ArrayAdapter<AppLaunchManager.AppInfo> appAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, installedApps);
        appAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerApp.setAdapter(appAdapter);

        // Setup Delay Spinner (3s - 10s)
        List<String> delays = new ArrayList<>();
        for (int i = 3; i <= 10; i++) {
            delays.add(i + getString(R.string.seconds_suffix));
        }
        ArrayAdapter<String> delayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, delays);
        delayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDelay.setAdapter(delayAdapter);

        // Set values if config exists
        if (config != null) {
            // Find app index
            for (int i = 0; i < installedApps.size(); i++) {
                if (installedApps.get(i).packageName.equals(config.packageName)) {
                    spinnerApp.setSelection(i);
                    break;
                }
            }
            switchBackground.setChecked(config.background);
            int delayIndex = config.delaySeconds - 3;
            if (delayIndex >= 0 && delayIndex < delays.size()) {
                spinnerDelay.setSelection(delayIndex);
            }
        }

        // Listeners to save config on change
        AdapterView.OnItemSelectedListener saveListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saveCurrentAppConfig();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerApp.setOnItemSelectedListener(saveListener);
        spinnerDelay.setOnItemSelectedListener(saveListener);
        switchBackground.setOnCheckedChangeListener((v, isChecked) -> saveCurrentAppConfig());

        btnDelete.setOnClickListener(v -> {
            layoutAppList.removeView(row);
            saveCurrentAppConfig();
        });

        layoutAppList.addView(row);
        // Save immediately if adding new row
        if (config == null)
            saveCurrentAppConfig();
    }

    private void saveCurrentAppConfig() {
        List<AppLaunchManager.AppConfig> configs = new ArrayList<>();
        for (int i = 0; i < layoutAppList.getChildCount(); i++) {
            View row = layoutAppList.getChildAt(i);
            Spinner spinnerApp = row.findViewById(R.id.spinnerApp);
            Spinner spinnerDelay = row.findViewById(R.id.spinnerDelay);
            SwitchMaterial switchBackground = row.findViewById(R.id.switchBackground);

            AppLaunchManager.AppInfo selectedApp = (AppLaunchManager.AppInfo) spinnerApp.getSelectedItem();
            if (selectedApp != null) {
                int delay = spinnerDelay.getSelectedItemPosition() + 3; // Index 0 is 3s
                configs.add(
                        new AppLaunchManager.AppConfig(selectedApp.packageName, switchBackground.isChecked(), delay));
            }
        }
        AppLaunchManager.saveConfig(this, configs);
    }

}
