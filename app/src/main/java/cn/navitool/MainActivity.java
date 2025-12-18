package cn.navitool;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;

    private androidx.appcompat.app.AlertDialog permissionDialog;
    private View mPermissionDialogView;

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

    // Navigation Views
    private ScrollView mLayoutBasic;
    private ScrollView mLayoutButtons;
    private ScrollView mLayoutAutoStart;
    private ScrollView mLayoutADB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        setContentView(R.layout.activity_main);

        initUI();
        initNavigation();
        checkPermissions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermissions(); // Refresh status on resume

        android.content.IntentFilter filter = new android.content.IntentFilter();
        filter.addAction("cn.navitool.ACTION_DAY_NIGHT_STATUS");
        registerReceiver(mDayNightStatusReceiver, filter);

        android.content.IntentFilter adbFilter = new android.content.IntentFilter("cn.navitool.ADB_STATUS_CHANGED");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(adbStatusReceiver, adbFilter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            registerReceiver(adbStatusReceiver, adbFilter);
        }

        // Refresh ADB Status
        AdbShell.getInstance(this).broadcastStatus();

        android.content.IntentFilter oneOSFilter = new android.content.IntentFilter();
        oneOSFilter.addAction("cn.navitool.ACTION_ONEOS_STATUS");
        registerReceiver(mOneOSStatusReceiver, oneOSFilter);

        // Request status update
        sendBroadcast(new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS"));
        sendBroadcast(new Intent("cn.navitool.ACTION_REQUEST_ONEOS_STATUS"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mDayNightStatusReceiver);
        unregisterReceiver(mOneOSStatusReceiver);
        unregisterReceiver(adbStatusReceiver);
    }

    private void initNavigation() {
        RadioGroup rgNavigation = findViewById(R.id.rgNavigation);
        mLayoutBasic = findViewById(R.id.layoutContentBasic);
        mLayoutButtons = findViewById(R.id.layoutContentButtons);
        mLayoutAutoStart = findViewById(R.id.layoutContentAutoStart);
        mLayoutADB = findViewById(R.id.layoutContentADB);

        rgNavigation.setOnCheckedChangeListener((group, checkedId) -> {
            mLayoutBasic.setVisibility(View.GONE);
            mLayoutButtons.setVisibility(View.GONE);
            mLayoutAutoStart.setVisibility(View.GONE);
            mLayoutADB.setVisibility(View.GONE);

            if (checkedId == R.id.rbBasic) {
                mLayoutBasic.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbButtons) {
                mLayoutButtons.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbAutoStart) {
                mLayoutAutoStart.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbADB) {
                mLayoutADB.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initUI() {
        // --- Header / Debug ---
        setupDebugSwitch();
        setVersionInfo();

        // --- Basic Tab ---
        setupThemeSettings();
        setupForceAutoDayNight();

        // --- Buttons Tab ---
        setupSteeringWheelControl();
        setupWeChatButton();
        setupMediaButtons(); // Debug only

        // --- AutoStart Tab ---
        setupAutoStartApps();

        // --- ADB Tab (Permissions) ---
        setupPermissionStatuses();
        setupAdbWireless();
    }

    private void setVersionInfo() {
        TextView tvAppCredit = findViewById(R.id.tvAppCredit);
        if (tvAppCredit != null) {
            tvAppCredit.setText(getString(R.string.app_credit, BuildConfig.VERSION_NAME));
        }
    }

    private void setupDebugSwitch() {
        SwitchMaterial switchDebug = findViewById(R.id.switchDebug);
        if (!BuildConfig.DEBUG) {
            switchDebug.setVisibility(View.GONE);
        }

        // Layouts controlled by debug switch
        View layoutDebugButtons = findViewById(R.id.layoutDebugButtons); // In Basic
        View layoutMediaButtons = findViewById(R.id.layoutMediaButtons); // In Buttons

        boolean isDebug = DebugLogger.isDebugEnabled(this);
        switchDebug.setChecked(isDebug);
        updateDebugViewsVisibility(isDebug, layoutDebugButtons, layoutMediaButtons);

        switchDebug.setOnCheckedChangeListener((buttonView, isChecked) -> {
            DebugLogger.setDebugEnabled(this, isChecked);
            updateDebugViewsVisibility(isChecked, layoutDebugButtons, layoutMediaButtons);
            if (isChecked) {
                DebugLogger.toast(this, getString(R.string.debug_mode_enabled));
            } else {
                Toast.makeText(this, R.string.debug_mode_disabled, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateDebugViewsVisibility(boolean isDebug, View debugButtons, View mediaButtons) {
        if (debugButtons != null) {
            debugButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        }
        if (mediaButtons != null) {
            mediaButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        }
    }

    // --- Basic Tab Logic ---

    private void setupThemeSettings() {
        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        SwitchMaterial switchAutoTheme = findViewById(R.id.switchAutoTheme);
        switchAutoTheme.setChecked(prefs.getBoolean("auto_theme_sync", true));
        switchAutoTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("auto_theme_sync", isChecked).apply();
            DebugLogger.toast(this,
                    getString(isChecked ? R.string.auto_theme_sync_enabled : R.string.auto_theme_sync_disabled));
        });

        findViewById(R.id.btnForceLight).setOnClickListener(v -> sendAutoNaviBroadcast(1));
        findViewById(R.id.btnForceDark).setOnClickListener(v -> sendAutoNaviBroadcast(2));
    }

    private void setupForceAutoDayNight() {
        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        SwitchMaterial switchForceAutoDayNight = findViewById(R.id.switchForceAutoDayNight);
        TextView tvAutoModeStatus = findViewById(R.id.tvAutoModeStatus);

        boolean isForceAuto = prefs.getBoolean("force_auto_day_night", false);
        switchForceAutoDayNight.setChecked(isForceAuto);

        if (tvAutoModeStatus != null) {
            tvAutoModeStatus.setText(getString(R.string.status_auto_mode, getString(R.string.mode_unknown)));
        }

        switchForceAutoDayNight.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("force_auto_day_night", isChecked).apply();

            Intent intent = new Intent("cn.navitool.ACTION_FORCE_AUTO_MODE_CHANGED");
            intent.putExtra("enabled", isChecked);
            sendBroadcast(intent);

            if (isChecked) {
                Intent requestIntent = new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
                sendBroadcast(requestIntent);
            }
        });
    }

    // --- Buttons Tab Logic ---

    private void setupSteeringWheelControl() {
        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        SwitchMaterial switchSteeringWheel = findViewById(R.id.switchSteeringWheel);
        switchSteeringWheel.setChecked(prefs.getBoolean("steering_wheel_control", false));
        switchSteeringWheel.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("steering_wheel_control", isChecked).apply();
            DebugLogger.toast(this,
                    getString(isChecked ? R.string.steering_wheel_enabled : R.string.steering_wheel_disabled));
        });
    }

    private void setupWeChatButton() {
        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        SwitchMaterial switchWechatButton = findViewById(R.id.switchWechatButton);
        View layoutWechatShortPress = findViewById(R.id.layoutWechatShortPress);
        View layoutWechatLongPress = findViewById(R.id.layoutWechatLongPress);
        Spinner spinnerShortPressAction = findViewById(R.id.spinnerShortPressAction);
        Spinner spinnerShortPressApp = findViewById(R.id.spinnerShortPressApp);
        Spinner spinnerLongPressAction = findViewById(R.id.spinnerLongPressAction);
        Spinner spinnerLongPressApp = findViewById(R.id.spinnerLongPressApp);

        // Populate Spinners
        List<String> actionOptions = new ArrayList<>();
        actionOptions.add("- - - -");
        actionOptions.add("启动应用");
        ArrayAdapter<String> actionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                actionOptions);
        actionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShortPressAction.setAdapter(actionAdapter);
        spinnerLongPressAction.setAdapter(actionAdapter);

        // Apps
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

        // Load Values
        boolean isWechatEnabled = prefs.getBoolean("wechat_button_enabled", false);
        switchWechatButton.setChecked(isWechatEnabled);

        int shortPressActionIdx = prefs.getInt("wechat_short_press_action", 0);
        int longPressActionIdx = prefs.getInt("wechat_long_press_action", 0);
        spinnerShortPressAction.setSelection(shortPressActionIdx);
        spinnerLongPressAction.setSelection(longPressActionIdx);

        String shortPressAppPkg = prefs.getString("wechat_short_press_app", "");
        String longPressAppPkg = prefs.getString("wechat_long_press_app", "");
        for (int i = 0; i < apps.size(); i++) {
            if (apps.get(i).packageName.equals(shortPressAppPkg))
                spinnerShortPressApp.setSelection(i + 1);
            if (apps.get(i).packageName.equals(longPressAppPkg))
                spinnerLongPressApp.setSelection(i + 1);
        }

        // Visibility
        layoutWechatShortPress.setVisibility(isWechatEnabled ? View.VISIBLE : View.GONE);
        layoutWechatLongPress.setVisibility(isWechatEnabled ? View.VISIBLE : View.GONE);
        spinnerShortPressApp.setVisibility(shortPressActionIdx == 1 ? View.VISIBLE : View.GONE);
        spinnerLongPressApp.setVisibility(longPressActionIdx == 1 ? View.VISIBLE : View.GONE);

        // Listeners
        switchWechatButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("wechat_button_enabled", isChecked).apply();
            layoutWechatShortPress.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            layoutWechatLongPress.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        setupSpinnerListener(spinnerShortPressAction, spinnerShortPressApp, "wechat_short_press_action", prefs);
        setupSpinnerListener(spinnerLongPressAction, spinnerLongPressApp, "wechat_long_press_action", prefs);
        setupAppSpinnerListener(spinnerShortPressApp, apps, "wechat_short_press_app", prefs);
        setupAppSpinnerListener(spinnerLongPressApp, apps, "wechat_long_press_app", prefs);
    }

    private void setupSpinnerListener(Spinner actionSpinner, Spinner appSpinner, String prefKey,
            android.content.SharedPreferences prefs) {
        actionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prefs.edit().putInt(prefKey, position).apply();
                appSpinner.setVisibility(position == 1 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupAppSpinnerListener(Spinner appSpinner, List<AppLaunchManager.AppInfo> apps, String prefKey,
            android.content.SharedPreferences prefs) {
        appSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= apps.size()) {
                    prefs.edit().putString(prefKey, apps.get(position - 1).packageName).apply();
                } else {
                    prefs.edit().putString(prefKey, "").apply();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupMediaButtons() {
        findViewById(R.id.btnMediaPrev)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PREVIOUS));
        findViewById(R.id.btnMediaPlayPause)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE));
        findViewById(R.id.btnMediaNext)
                .setOnClickListener(v -> simulateMediaKey(android.view.KeyEvent.KEYCODE_MEDIA_NEXT));
    }

    // --- AutoStart Tab Logic ---

    private void setupAutoStartApps() {
        SwitchMaterial switchAutoStart = findViewById(R.id.switchAutoStartApps);
        SwitchMaterial switchReturnToHome = findViewById(R.id.switchReturnToHome);
        ImageButton btnAddApp = findViewById(R.id.btnAddApp);
        Button btnTestLaunch = findViewById(R.id.btnTestLaunch);
        LinearLayout llAutoStartAppsList = findViewById(R.id.llAutoStartAppsList);

        boolean isAutoStartEnabled = AppLaunchManager.isAutoStartEnabled(this);
        boolean isReturnToHomeEnabled = AppLaunchManager.isReturnToHomeEnabled(this);
        List<AppLaunchManager.AppConfig> savedConfigs = AppLaunchManager.loadConfig(this);

        switchAutoStart.setChecked(isAutoStartEnabled);
        switchReturnToHome.setChecked(isReturnToHomeEnabled);

        llAutoStartAppsList.removeAllViews();
        if (savedConfigs != null) {
            for (AppLaunchManager.AppConfig config : savedConfigs) {
                addAppConfigRow(llAutoStartAppsList, config);
            }
        }

        updateAutoStartUI(isAutoStartEnabled, btnAddApp, llAutoStartAppsList, switchReturnToHome, btnTestLaunch);

        switchAutoStart.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppLaunchManager.setAutoStartEnabled(MainActivity.this, isChecked);
            updateAutoStartUI(isChecked, btnAddApp, llAutoStartAppsList, switchReturnToHome, btnTestLaunch);
        });

        switchReturnToHome.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppLaunchManager.setReturnToHomeEnabled(MainActivity.this, isChecked);
            DebugLogger.toast(this, isChecked ? getString(R.string.toast_return_home_enabled)
                    : getString(R.string.toast_return_home_disabled));
        });

        btnAddApp.setOnClickListener(v -> {
            addAppConfigRow(llAutoStartAppsList, null);
            llAutoStartAppsList.setVisibility(View.VISIBLE);
        });

        btnTestLaunch.setOnClickListener(v -> {
            DebugLogger.toast(this, getString(R.string.toast_test_start));
            List<AppLaunchManager.AppConfig> configs = AppLaunchManager.loadConfig(this);
            if (configs == null || configs.isEmpty()) {
                DebugLogger.toast(this, getString(R.string.toast_no_auto_start_config));
                return;
            }
            // Simple sequential launch for test
            for (AppLaunchManager.AppConfig config : configs) {
                if (!android.text.TextUtils.isEmpty(config.packageName)) {
                    AppLaunchManager.launchApp(this, config.packageName);
                }
            }
            if (switchReturnToHome.isChecked()) {
                new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(homeIntent);
                }, 5000); // 5s delay for home return test
            }
        });
    }

    private void updateAutoStartUI(boolean enabled, View btnAdd, View list, View switchReturn, View btnTest) {
        int visibility = enabled ? View.VISIBLE : View.GONE;
        btnAdd.setVisibility(visibility);
        switchReturn.setVisibility(visibility);
        btnTest.setVisibility(visibility); // Hide Test button too
        // switchReturn is the switchReturnToHome

        if (enabled && ((LinearLayout) list).getChildCount() > 0) {
            list.setVisibility(View.VISIBLE);
        } else {
            list.setVisibility(View.GONE);
        }
    }

    private void addAppConfigRow(LinearLayout container, AppLaunchManager.AppConfig initialConfig) {
        View itemView = getLayoutInflater().inflate(R.layout.item_app_auto_start, container, false);

        Spinner spinner = itemView.findViewById(R.id.spinnerAppSelection);
        EditText etDelay = itemView.findViewById(R.id.etLaunchDelay);
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

        AdapterView.OnItemSelectedListener saveListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saveAllConfigs();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(saveListener);

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
            EditText etDelay = child.findViewById(R.id.etLaunchDelay);

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

    // --- ADB Tab Logic ---

    private void setupPermissionStatuses() {
        View view = findViewById(R.id.statusAppPermissions);
        if (view == null)
            return;

        TextView txtName = view.findViewById(R.id.txtPermissionName);
        txtName.setText("应用必要权限");

        view.setOnClickListener(v -> showPermissionDialog());
        Button btnFix = view.findViewById(R.id.btnFix);
        btnFix.setText("详情");
        btnFix.setOnClickListener(v -> showPermissionDialog());
    }

    private void showPermissionDialog() {
        if (permissionDialog != null && permissionDialog.isShowing()) {
            return;
        }

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        mPermissionDialogView = getLayoutInflater().inflate(R.layout.dialog_permissions, null);
        builder.setView(mPermissionDialogView);
        builder.setCancelable(true);

        permissionDialog = builder.create();
        permissionDialog.show();

        // Initial Refresh
        refreshPermissionDialog(mPermissionDialogView);

        // Setup Clicks for Items inside Dialog
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusAccessibility, R.string.perm_accessibility,
                this::requestAccessibilityPermission);
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusOverlay, R.string.perm_overlay,
                this::requestOverlayPermission);
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusStorage, R.string.perm_storage,
                this::requestStoragePermission);
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusBattery, R.string.perm_battery,
                this::requestBatteryOptimization);
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusAutoStart, R.string.perm_auto_start,
                this::requestAutoStart);
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusSecureSettings, R.string.perm_secure_settings,
                this::showSecureSettingsGuide);
    }

    private void setupDialogItem(View dialogView, int viewId, int nameResId, Runnable onClickAction) {
        View view = dialogView.findViewById(viewId);
        TextView txtName = view.findViewById(R.id.txtPermissionName);
        txtName.setText(nameResId);

        view.setOnClickListener(v -> onClickAction.run());
        Button btnFix = view.findViewById(R.id.btnFix);
        btnFix.setText("修复");
        btnFix.setOnClickListener(v -> onClickAction.run());
    }

    private void refreshPermissionDialog(View dialogView) {
        if (dialogView == null)
            return;

        updateDialogStatusItem(dialogView, R.id.dialogStatusAccessibility, isAccessibilityServiceEnabled());
        updateDialogStatusItem(dialogView, R.id.dialogStatusOverlay, Settings.canDrawOverlays(this));
        updateDialogStatusItem(dialogView, R.id.dialogStatusStorage, hasStoragePermission());

        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean ignoringBattery = pm != null && pm.isIgnoringBatteryOptimizations(getPackageName());
        updateDialogStatusItem(dialogView, R.id.dialogStatusBattery, ignoringBattery);

        updateDialogStatusItem(dialogView, R.id.dialogStatusAutoStart, true);
        updateDialogStatusItem(dialogView, R.id.dialogStatusSecureSettings, hasSecureSettingsPermission());
    }

    private boolean hasSecureSettingsPermission() {
        return androidx.core.content.ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_SECURE_SETTINGS) == android.content.pm.PackageManager.PERMISSION_GRANTED;
    }

    private void updateDialogStatusItem(View dialogView, int viewId, boolean granted) {
        View view = dialogView.findViewById(viewId);
        ImageView imgStatus = view.findViewById(R.id.imgStatus);
        Button btnFix = view.findViewById(R.id.btnFix);

        if (granted) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
            btnFix.setVisibility(View.GONE);
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
            btnFix.setVisibility(View.VISIBLE);
        }
    }

    private void checkPermissions() {
        boolean isAutoStartGranted = true;
        boolean isOverlayGranted = Settings.canDrawOverlays(this);
        boolean isStorageGranted = hasStoragePermission();
        boolean isAccessibilityGranted = isAccessibilityServiceEnabled();

        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean isBatteryGranted = pm != null && pm.isIgnoringBatteryOptimizations(getPackageName());
        boolean isSecureSettingsGranted = hasSecureSettingsPermission();

        boolean allGranted = isOverlayGranted && isStorageGranted && isAccessibilityGranted && isBatteryGranted
                && isSecureSettingsGranted;

        View view = findViewById(R.id.statusAppPermissions);
        if (view == null)
            return;

        ImageView imgStatus = view.findViewById(R.id.imgStatus);
        Button btnFix = view.findViewById(R.id.btnFix);

        if (allGranted) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
            btnFix.setVisibility(View.GONE);
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
        }

        if (permissionDialog != null && permissionDialog.isShowing() && mPermissionDialogView != null) {
            refreshPermissionDialog(mPermissionDialogView);
        }
    }

    private void tryAdbGrant(String command, String successToast, Runnable fallbackAction) {
        if (AdbShell.getInstance(this).isConnected()) {
            AdbShell.getInstance(this).exec(command);
            DebugLogger.toast(this, "正在尝试通过 ADB 授权...");
            // Poll for status update
            android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
            int[] delays = { 500, 1000, 1500, 2000, 3000, 5000 };
            for (int delay : delays) {
                handler.postDelayed(this::checkPermissions, delay);
            }
        } else {
            fallbackAction.run();
        }
    }

    private void showSecureSettingsGuide() {
        tryAdbGrant("pm grant " + getPackageName() + " android.permission.WRITE_SECURE_SETTINGS",
                "正在授权 Secure Settings...",
                () -> DebugLogger.toast(this,
                        String.format(getString(R.string.perm_secure_settings_guide), getPackageName())));
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
            tryAdbGrant("appops set " + getPackageName() + " SYSTEM_ALERT_WINDOW allow",
                    "正在通过 ADB 授权悬浮窗...",
                    () -> {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:" + getPackageName()));
                        mOverlayPermissionLauncher.launch(intent);
                    });
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
            tryAdbGrant("dumpsys deviceidle whitelist +" + packageName,
                    "正在通过 ADB 添加电池白名单...",
                    () -> {
                        intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                        intent.setData(Uri.parse("package:" + packageName));
                        startActivity(intent);
                    });
        } else {
            DebugLogger.toast(this, getString(R.string.status_granted));
        }
    }

    private void requestAccessibilityPermission() {
        if (!isAccessibilityServiceEnabled()) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                // Auto-enable
                try {
                    String enabledServices = Settings.Secure.getString(getContentResolver(),
                            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
                    String serviceName = new ComponentName(this, KeepAliveAccessibilityService.class).flattenToString();

                    if (enabledServices == null || enabledServices.isEmpty()) {
                        enabledServices = serviceName;
                    } else {
                        enabledServices += ":" + serviceName;
                    }

                    Settings.Secure.putString(getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES,
                            enabledServices);
                    Settings.Secure.putString(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, "1");

                    DebugLogger.toast(this, "已自动开启无障碍服务");
                    checkPermissions(); // Refresh UI
                } catch (Exception e) {
                    DebugLogger.toast(this, "自动开启失败: " + e.getMessage());
                    openAccessibilitySettings();
                }
            } else {
                // Manual enable
                Toast.makeText(this, "请授予应用 ADB WRITE_SECURE_SETTINGS 权限以自动开启，或手动开启。", Toast.LENGTH_LONG).show();
                openAccessibilitySettings();
            }
        } else {
            DebugLogger.toast(this, getString(R.string.status_granted));
        }
    }

    private void openAccessibilitySettings() {
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
        Toast.makeText(this, R.string.enable_accessibility_toast, Toast.LENGTH_LONG).show();
    }

    private void requestAutoStart() {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, R.string.failed_open_auto_start, Toast.LENGTH_LONG).show();
        }
    }

    // Helper Methods
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
        android.media.AudioManager audioManager = (android.media.AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.dispatchMediaKeyEvent(keyEvent);
        }

        Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaIntent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
        mediaIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        mediaIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        sendBroadcast(mediaIntent);
    }

    private final android.content.BroadcastReceiver mDayNightStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_DAY_NIGHT_STATUS".equals(intent.getAction())) {
                updateAutoModeStatus(intent.getIntExtra("mode", 0));
            }
        }
    };

    private final android.content.BroadcastReceiver mOneOSStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_ONEOS_STATUS".equals(intent.getAction())) {
                updateOneOSStatus(intent.getBooleanExtra("is_connected", false));
            }
        }
    };

    private void updateAutoModeStatus(int mode) {
        TextView tvAutoModeStatus = findViewById(R.id.tvAutoModeStatus);
        ImageView imgAutoModeIcon = findViewById(R.id.imgAutoModeIcon);
        if (tvAutoModeStatus == null)
            return;

        String modeStr;
        int iconRes;
        switch (mode) {
            case 0x20150103:
                modeStr = getString(R.string.mode_auto);
                iconRes = R.drawable.ic_daymode_auto;
                break;
            case 0x20150101:
                modeStr = getString(R.string.mode_day);
                iconRes = R.drawable.ic_daymode_light;
                break;
            case 0x20150102:
                modeStr = getString(R.string.mode_night);
                iconRes = R.drawable.ic_daymode_dark;
                break;
            case 0x20150104:
                modeStr = getString(R.string.mode_custom);
                iconRes = R.drawable.ic_daymode_auto;
                break;
            case 0x20150105:
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
            if (mode == 0x20150103) { // Auto
                imgAutoModeIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_green_dark));
            } else if (mode == 0) { // Unknown/Init
                imgAutoModeIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            } else {
                // Other valid modes (Day/Night etc) - maybe just use primary text color or keep
                // original if they are colored icons
                // For consistency, let's say "Auto" is the goal, so Auto=Green. Others=Standard
                // color?
                // Let's stick to: Valid Mode = Green? No, Day/Night are valid too.
                // Let's just create a consistent style.
                // If the user says "cross mark" (ic_close) is inconsistent, it means the
                // FAILURE state.
                // In AutoMode, default is ic_close.
                if (iconRes == R.drawable.ic_close) {
                    imgAutoModeIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_red_dark));
                } else {
                    imgAutoModeIcon.setColorFilter(ContextCompat.getColor(this, android.R.color.holo_green_dark));
                }
            }
        }
    }

    private void updateOneOSStatus(boolean isConnected) {
        ImageView imgStatus = findViewById(R.id.imgMediaKeyServiceIcon);
        if (imgStatus == null)
            return;
        if (isConnected) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
        }
    }

    // --- ADB Wireless Logic ---

    private void setupAdbWireless() {
        com.google.android.material.switchmaterial.SwitchMaterial switchAdbWireless = findViewById(
                R.id.switchAdbWireless);
        if (switchAdbWireless == null)
            return;

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", MODE_PRIVATE);
        boolean isEnabled = prefs.getBoolean("adb_wireless_enabled", false);
        switchAdbWireless.setChecked(isEnabled);

        switchAdbWireless.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("adb_wireless_enabled", isChecked).apply();

            // Only trigger connection logic if user clicked (or we want to enforce state)
            // But since we want auto-connect on resume if enabled, we should let it flow,
            // but we must avoid race with AdbShell internal check.

            if (isChecked) {
                if (buttonView.isPressed()) {
                    DebugLogger.toast(this, "正在尝试连接本地 ADB...");
                }
                AdbShell.getInstance(this).connect();
            } else {
                AdbShell.getInstance(this).close();
            }
        });

        // Trigger initial connection if enabled
        if (isEnabled) {
            AdbShell.getInstance(this).connect();
        }
    }

    private final android.content.BroadcastReceiver adbStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ADB_STATUS_CHANGED".equals(intent.getAction())) {
                String status = intent.getStringExtra("status");
                android.widget.TextView tvAdbStatus = findViewById(R.id.tvAdbStatus);
                if (tvAdbStatus != null && status != null) {
                    tvAdbStatus.setText(status);
                    if (status.contains("已连接")) {
                        tvAdbStatus.setTextColor(androidx.core.content.ContextCompat.getColor(MainActivity.this,
                                android.R.color.holo_green_dark));
                        DebugLogger.toastAlways(MainActivity.this, status);
                    } else if (status.contains("连接失败")) {
                        tvAdbStatus.setTextColor(androidx.core.content.ContextCompat.getColor(MainActivity.this,
                                android.R.color.holo_red_dark));
                        DebugLogger.toastAlways(MainActivity.this, status);
                    } else if (status.contains("正在连接")) {
                        tvAdbStatus.setTextColor(androidx.core.content.ContextCompat.getColor(MainActivity.this,
                                android.R.color.darker_gray));
                    } else {
                        tvAdbStatus.setTextColor(androidx.core.content.ContextCompat.getColor(MainActivity.this,
                                android.R.color.holo_red_dark));
                    }
                }
            }
        }
    };
}
