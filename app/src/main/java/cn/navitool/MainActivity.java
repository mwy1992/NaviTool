package cn.navitool;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ImageButton;
import java.util.List;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;

    private final ActivityResultLauncher<Intent> mOverlayPermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                checkPermissions();
                if (Settings.canDrawOverlays(this)) {
                    DebugLogger.toast(this, getString(R.string.status_granted));
                }
            });

    private final ActivityResultLauncher<Intent> mStoragePermissionLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                checkPermissions();
                if (hasStoragePermission()) {
                    DebugLogger.toast(this, getString(R.string.status_granted));
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        setContentView(R.layout.activity_main);

        initUI();
        checkPermissions();

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

        setupAutoStartApps();

        // Buttons
        LinearLayout layoutDebugButtons = findViewById(R.id.layoutDebugButtons);
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
        // View layoutAutoModeStatus = findViewById(R.id.layoutAutoModeStatus); //
        // Removed unused variable
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

        // Media Buttons (Debug Only)
        View layoutMediaButtons = findViewById(R.id.layoutMediaButtons);
        findViewById(R.id.btnMediaPrev)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS));
        findViewById(R.id.btnMediaPlayPause)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE));
        findViewById(R.id.btnMediaNext)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_NEXT));

        // WeChat Button Function Switch
        SwitchMaterial switchWechatButton = findViewById(R.id.switchWechatButton);
        View layoutWechatShortPress = findViewById(R.id.layoutWechatShortPress);
        View layoutWechatLongPress = findViewById(R.id.layoutWechatLongPress);
        Spinner spinnerShortPressAction = findViewById(R.id.spinnerShortPressAction);
        Spinner spinnerShortPressApp = findViewById(R.id.spinnerShortPressApp);
        Spinner spinnerLongPressAction = findViewById(R.id.spinnerLongPressAction);
        Spinner spinnerLongPressApp = findViewById(R.id.spinnerLongPressApp);

        // Action options
        List<String> actionOptions = new ArrayList<>();
        actionOptions.add("- - - -");
        actionOptions.add("启动应用");
        ArrayAdapter<String> actionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                actionOptions);
        actionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShortPressAction.setAdapter(actionAdapter);
        spinnerLongPressAction.setAdapter(actionAdapter);

        // App options
        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(this);
        List<String> appNames = new ArrayList<>();
        appNames.add("- - - -");
        for (AppLaunchManager.AppInfo app : apps) {
            appNames.add(app.name);
        }
        ArrayAdapter<String> appAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, appNames);
        appAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShortPressApp.setAdapter(appAdapter);
        spinnerLongPressApp.setAdapter(appAdapter);

        // Load saved values
        boolean isWechatEnabled = prefs.getBoolean("wechat_button_enabled", false);
        switchWechatButton.setChecked(isWechatEnabled);

        int shortPressActionIdx = prefs.getInt("wechat_short_press_action", 0);
        int longPressActionIdx = prefs.getInt("wechat_long_press_action", 0);
        spinnerShortPressAction.setSelection(shortPressActionIdx);
        spinnerLongPressAction.setSelection(longPressActionIdx);

        // Load saved app selections
        String shortPressAppPkg = prefs.getString("wechat_short_press_app", "");
        String longPressAppPkg = prefs.getString("wechat_long_press_app", "");
        for (int i = 0; i < apps.size(); i++) {
            if (apps.get(i).packageName.equals(shortPressAppPkg)) {
                spinnerShortPressApp.setSelection(i + 1);
            }
            if (apps.get(i).packageName.equals(longPressAppPkg)) {
                spinnerLongPressApp.setSelection(i + 1);
            }
        }

        // Initial visibility
        layoutWechatShortPress.setVisibility(isWechatEnabled ? View.VISIBLE : View.GONE);
        layoutWechatLongPress.setVisibility(isWechatEnabled ? View.VISIBLE : View.GONE);
        spinnerShortPressApp.setVisibility(shortPressActionIdx == 1 ? View.VISIBLE : View.GONE);
        spinnerLongPressApp.setVisibility(longPressActionIdx == 1 ? View.VISIBLE : View.GONE);

        switchWechatButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("wechat_button_enabled", isChecked).apply();
            layoutWechatShortPress.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            layoutWechatLongPress.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        spinnerShortPressAction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs.edit().putInt("wechat_short_press_action", position).apply();
                spinnerShortPressApp.setVisibility(position == 1 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerLongPressAction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs.edit().putInt("wechat_long_press_action", position).apply();
                spinnerLongPressApp.setVisibility(position == 1 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerShortPressApp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= apps.size()) {
                    prefs.edit().putString("wechat_short_press_app", apps.get(position - 1).packageName).apply();
                } else {
                    prefs.edit().putString("wechat_short_press_app", "").apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerLongPressApp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= apps.size()) {
                    prefs.edit().putString("wechat_long_press_app", apps.get(position - 1).packageName).apply();
                } else {
                    prefs.edit().putString("wechat_long_press_app", "").apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Debug Switch
        SwitchMaterial switchDebug = findViewById(R.id.switchDebug);
        if (!BuildConfig.DEBUG) {
            switchDebug.setVisibility(View.GONE);
        }
        boolean isDebug = DebugLogger.isDebugEnabled(this);
        switchDebug.setChecked(isDebug);

        // Initial visibility
        layoutDebugButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        layoutMediaButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);

        // Update visibility in debug switch listener
        switchDebug.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DebugLogger.setDebugEnabled(this, isChecked);
            layoutDebugButtons.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            layoutMediaButtons.setVisibility(isChecked ? View.VISIBLE : View.GONE);

            if (isChecked) {
                DebugLogger.toast(this, getString(R.string.debug_mode_enabled));
            } else {
                Toast.makeText(this, R.string.debug_mode_disabled, Toast.LENGTH_SHORT).show();
            }
        });

        // Set Version Info
        TextView tvAppCredit = findViewById(R.id.tvAppCredit);
        if (tvAppCredit != null) {
            tvAppCredit.setText(getString(R.string.app_credit, BuildConfig.VERSION_NAME));
        }
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

        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean ignoringBattery = pm != null && pm.isIgnoringBatteryOptimizations(getPackageName());
        updateStatusItem(R.id.statusBattery, ignoringBattery);
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
            mOverlayPermissionLauncher.launch(intent);
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
                    mStoragePermissionLauncher.launch(intent);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    mStoragePermissionLauncher.launch(intent);
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
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        try {
            startActivity(intent);
        } catch (Exception e) {
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
        DebugLogger.toast(this, getString(R.string.sent_autonavi_broadcast, mode));
    }

    private void setupAutoStartApps() {
        SwitchMaterial switchAutoStart = findViewById(R.id.switchAutoStartApps);
        SwitchMaterial switchReturnToHome = findViewById(R.id.switchReturnToHome);
        Button btnTestLaunch = findViewById(R.id.btnTestLaunch);
        ImageButton btnAddApp = findViewById(R.id.btnAddApp);
        LinearLayout llAutoStartAppsList = findViewById(R.id.llAutoStartAppsList);

        boolean isAutoStartEnabled = AppLaunchManager.isAutoStartEnabled(this);
        List<AppLaunchManager.AppConfig> savedConfigs = AppLaunchManager.loadConfig(this);

        switchAutoStart.setChecked(isAutoStartEnabled);
        switchReturnToHome.setChecked(AppLaunchManager.isReturnToHomeEnabled(this));

        // Initialize List
        llAutoStartAppsList.removeAllViews();
        if (savedConfigs != null) {
            for (AppLaunchManager.AppConfig config : savedConfigs) {
                addAppConfigRow(llAutoStartAppsList, config);
            }
        }

        // Update visibility
        if (isAutoStartEnabled) {
            btnTestLaunch.setVisibility(View.VISIBLE);
            btnAddApp.setVisibility(View.VISIBLE);
            switchReturnToHome.setVisibility(View.VISIBLE);
            llAutoStartAppsList.setVisibility(llAutoStartAppsList.getChildCount() > 0 ? View.VISIBLE : View.GONE);
        } else {
            btnTestLaunch.setVisibility(View.GONE);
            btnAddApp.setVisibility(View.GONE);
            switchReturnToHome.setVisibility(View.GONE);
            llAutoStartAppsList.setVisibility(View.GONE);
        }

        switchAutoStart.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppLaunchManager.setAutoStartEnabled(MainActivity.this, isChecked);
            if (isChecked) {
                btnTestLaunch.setVisibility(View.VISIBLE);
                btnAddApp.setVisibility(View.VISIBLE);
                switchReturnToHome.setVisibility(View.VISIBLE);
                llAutoStartAppsList.setVisibility(llAutoStartAppsList.getChildCount() > 0 ? View.VISIBLE : View.GONE);
            } else {
                btnTestLaunch.setVisibility(View.GONE);
                btnAddApp.setVisibility(View.GONE);
                switchReturnToHome.setVisibility(View.GONE);
                llAutoStartAppsList.setVisibility(View.GONE);
            }
        });

        switchReturnToHome.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppLaunchManager.setReturnToHomeEnabled(MainActivity.this, isChecked);
        });

        btnAddApp.setOnClickListener(v -> {
            addAppConfigRow(llAutoStartAppsList, null);
            llAutoStartAppsList.setVisibility(View.VISIBLE);
        });

        btnTestLaunch.setOnClickListener(v -> {
            if (AppLaunchManager.loadConfig(MainActivity.this).isEmpty()) {
                DebugLogger.toast(MainActivity.this, "请先选择需要自动启动的应用");
            } else {
                AppLaunchManager.executeLaunch(MainActivity.this);
            }
        });
    }

    private void addAppConfigRow(LinearLayout container, AppLaunchManager.AppConfig initialConfig) {
        View itemView = getLayoutInflater().inflate(R.layout.item_app_auto_start, container, false);

        Spinner spinner = itemView.findViewById(R.id.spinnerAppSelection);
        android.widget.EditText etDelay = itemView.findViewById(R.id.etLaunchDelay);
        ImageButton btnDelete = itemView.findViewById(R.id.btnDeleteConfig);

        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(this);
        List<String> displayNames = new ArrayList<>();
        displayNames.add("- - - -");
        for (AppLaunchManager.AppInfo app : apps) {
            displayNames.add(app.name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, displayNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (initialConfig != null) {
            etDelay.setText(String.valueOf(initialConfig.delaySeconds));
            for (int i = 0; i < apps.size(); i++) {
                if (apps.get(i).packageName.equals(initialConfig.packageName)) {
                    spinner.setSelection(i + 1);
                    break;
                }
            }
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saveAllConfigs();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        etDelay.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {
                saveAllConfigs();
            }
        });

        btnDelete.setOnClickListener(v -> {
            container.removeView(itemView);
            saveAllConfigs();
            if (container.getChildCount() == 0) {
                container.setVisibility(View.GONE);
            }
        });

        container.addView(itemView);
    }

    private void saveAllConfigs() {
        LinearLayout container = findViewById(R.id.llAutoStartAppsList);
        List<AppLaunchManager.AppConfig> configs = new ArrayList<>();
        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(this);

        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);
            Spinner spinner = child.findViewById(R.id.spinnerAppSelection);
            android.widget.EditText etDelay = child.findViewById(R.id.etLaunchDelay);

            int selectedPos = spinner.getSelectedItemPosition();
            if (selectedPos > 0 && selectedPos <= apps.size()) {
                AppLaunchManager.AppInfo selectedApp = apps.get(selectedPos - 1);
                int delay = 0;
                try {
                    delay = Integer.parseInt(etDelay.getText().toString());
                } catch (NumberFormatException e) {
                    delay = 0;
                }
                configs.add(new AppLaunchManager.AppConfig(selectedApp.packageName, delay));
            }
        }
        AppLaunchManager.saveConfig(this, configs);
    }

}
