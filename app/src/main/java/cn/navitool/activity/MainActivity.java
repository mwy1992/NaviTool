package cn.navitool.activity;

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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Locale;

import android.widget.FrameLayout;
import android.widget.Spinner;
import com.google.android.material.switchmaterial.SwitchMaterial;

import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.CustomThemeManager;
import cn.navitool.managers.AppLaunchManager;
import cn.navitool.managers.ThemeBrightnessManager;
import cn.navitool.managers.KeyHandlerManager;
import cn.navitool.managers.CarServiceManager;
import cn.navitool.managers.SoundPromptManager;
import cn.navitool.utils.MemoryMonitor;

import cn.navitool.managers.AmapMonitorManager;
import cn.navitool.managers.SunshadeManager;
import cn.navitool.service.FloatingBallService;
import cn.navitool.service.MediaNotificationListener;
import cn.navitool.utils.DebugLogger;
import cn.navitool.utils.AdbShell;
import cn.navitool.utils.MemoryMonitor;
import cn.navitool.controller.NaviInfoController;
import cn.navitool.utils.SimulateFunction;
import cn.navitool.service.KeepAliveAccessibilityService;
import cn.navitool.activity.MainActivity;
import cn.navitool.managers.PresentationManager;
import cn.navitool.managers.SimulateGear;
import cn.navitool.R;
import cn.navitool.BuildConfig;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private boolean mIsPositioningActive = false; // Track traffic light positioning state

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
    private View mLayoutGeneral;
    private View mLayoutButtons;
    private View mLayoutAutoStart;
    private ScrollView mLayoutADB; // ADB is not lazy

    private View mLayoutBrightness;
    private View mLayoutSound;
    private View mLayoutCluster;
    private View mLayoutHud;

    private boolean mIsGeneralInit = false;
    private boolean mIsButtonsInit = false;
    private boolean mIsAutoStartInit = false;

    private boolean mIsBrightnessInit = false;
    private boolean mIsSoundInit = false;
    private boolean mIsClusterInit = false;
    private boolean mIsHudInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Restore saved instance state for HUD/Cluster if possible
        if (savedInstanceState != null) {
            // Restore any critical flags
            // currently mostly handled by managers or config
        }

        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        MemoryMonitor.logMemory("MainActivity.onCreate-Start");

        // [Fix Cold Boot] Initialize ConfigManager and DebugLogger first
        ConfigManager.init(this);
        DebugLogger.init(this);

        // [Fix Cold Boot] Call setContentView EARLY to prevent black screen
        setContentView(R.layout.activity_main);

        // [Fix Cold Boot] Initialize Amap Services AFTER UI is set
        // These calls might be blocking or slow, so we do them after setContentView
        cn.navitool.managers.AmapMonitorManager.getInstance(this).startMonitoring();
        // AmapAidlManager removed
        // cn.navitool.managers.AmapAidlManager.getInstance(this).connect();

        // Initialize Managers (assuming these are new additions based on the
        // instruction's snippet)
        // Note: mAppLaunchManager and mSoundPromptManager are not declared in the
        // provided context.
        // Assuming they would be declared elsewhere or are placeholders for other
        // initializations.
        // mAppLaunchManager = new cn.navitool.managers.AppLaunchManager(this);
        // mSoundPromptManager =
        // cn.navitool.managers.SoundPromptManager.getInstance(this);

        // Initialize Views (assuming initUI is replaced by these based on the
        // instruction's snippet)
        initUI(); // Original call, keeping it as the instruction didn't explicitly remove it.
        // setupListeners(); // Not in original code, but in instruction's snippet.
        // updateUIState(); // Not in original code, but in instruction's snippet.
        // requestPermissions(); // Not in original code, but in instruction's snippet.

        initNavigation(); // Click listeners

        checkPermissions();

        // [Startup Conflict Fix]
        // ClusterHudManager now self-initializes its configuration in its constructor.
        // We do NOT need to manually load config and push it to the manager here.
        // Doing so caused race conditions with KeepAliveService/BootReceiver.

        // Just ensure instance is created (which triggers self-init)
        // Just ensure instance is created (which triggers self-init)
        ClusterHudManager cm = ClusterHudManager.getInstance(this);

        // [FIX] Activity Injection
        // Immediately upgrade the Manager's context to this Activity.
        // This ensures subsequent UI operations use the Theme-aware Activity Context.
        cm.updateContext(this);

        // [Legacy] NaviInfoController init kept for general readiness (Geely Socket Removed)
        NaviInfoController.getInstance(this);

        // Try to show UI again (in case Service failed or wasn't ready)
        // Now it will use the Activity Context we just injected.
        // Try to show UI again (in case Service failed or wasn't ready)
        // Now it will use the Activity Context we just injected.
        // [FIX] Delayed UI - Do NOT show immediately on Create
        // cm.ensureUiVisible();
        DebugLogger.i("MainActivity", "UI Initialization deferred. Waiting for ACTION_ACTIVATE_CLUSTER_HUD...");

        if (BuildConfig.DEBUG) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle(getString(R.string.dialog_debug_title))
                    .setMessage(getString(R.string.dialog_debug_message))
                    .setCancelable(true)
                    .show();
        } else {
            // Release Version: Show only on first run after install/update
            try {
                android.content.pm.PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                long currentVersionCode = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    currentVersionCode = pInfo.getLongVersionCode();
                } else {
                    currentVersionCode = pInfo.versionCode;
                }

                android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
                long lastSeenVersion = prefs.getLong("last_seen_version_code", -1);

                if (currentVersionCode != lastSeenVersion) {
                    long finalVerCode = currentVersionCode;
                    new android.app.AlertDialog.Builder(this)
                            .setTitle(getString(R.string.dialog_release_title))
                            .setMessage(getString(R.string.dialog_release_message))
                            .setCancelable(true)
                            .setOnDismissListener(dialog -> {
                                prefs.edit().putLong("last_seen_version_code", finalVerCode).apply();
                            })
                            .show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MemoryMonitor.logMemory("MainActivity.onResume");

        // Check Media Key Service
        boolean isOneOSConnected = cn.navitool.managers.KeyHandlerManager.getInstance(this).isOneOSConnected();
        updateOneOSStatus(isOneOSConnected);

        // Request Status Updates from Services
        sendBroadcast(new Intent("cn.navitool.ACTION_REQUEST_ONEOS_STATUS"));

        // Trigger generic status refresh
        if (cn.navitool.managers.CarServiceManager.getInstance(this).isInitialized()) {
            // ...
        }
        registerReceivers();
        // Request immediate status update from ADB Shell
        AdbShell.getInstance(this).broadcastStatus();

        // Register HUD Listener for Preview Updates
        ClusterHudManager.getInstance(this).setListener((type, text, image) -> {
            runOnUiThread(() -> {
                updatePreviewContainer(findViewById(R.id.layoutHudPreview), type, text, image);
                // updatePreviewContainer(findViewById(R.id.layoutClusterPreview), type, text,
                // image);
            });
        });

        // Check Notification Permission
        if (!isNotificationListenerEnabled()) {
            DebugLogger.toastAlways(this, getString(R.string.toast_notification_permission_fix));
        }

        // [FIX] Restore Floating Ball Service on Resume (if enabled)
        if (ConfigManager.getInstance().getBoolean("floating_ball_enabled", false)) {
            if (Settings.canDrawOverlays(this)) {
                startService(new Intent(this, cn.navitool.service.FloatingBallService.class));
            }
        }
    }

    private void updatePreviewContainer(android.widget.FrameLayout preview, String type, String text,
            android.graphics.Bitmap image) {
        if (preview != null) {
            for (int i = 0; i < preview.getChildCount(); i++) {
                View child = preview.getChildAt(i);
                Object tag = child.getTag();
                if (tag != null && tag.equals("type_" + type)) {
                    if ("time".equals(type))
                        continue;

                    // Force Turn Signal to always show Hazard in Preview for Editing
                    if ("turn_signal".equals(type) && child instanceof ImageView) {
                        android.graphics.Bitmap forceBmp = ClusterHudManager.getInstance(this).getTurnSignalBitmap(true,
                                true);

                        // [FIX] Apply Center Overlay Line for Preview Alignment
                        if (forceBmp != null) {
                            forceBmp = ClusterHudManager.getInstance(this).addCenterLineOverlay(forceBmp);
                        }

                        if (forceBmp != null) {
                            ((ImageView) child).setImageBitmap(forceBmp);
                        } else {
                            ((ImageView) child).setImageResource(R.drawable.ic_turn_signal);
                        }

                        // Unified Logic: Physical Sizing (2x Real HUD Size)
                        // Real HUD Height = 36px -> Preview Height = 72px
                        int h = 72;
                        int w = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;

                        child.setLayoutParams(new android.widget.FrameLayout.LayoutParams(w, h));
                        ((ImageView) child).setAdjustViewBounds(true);
                        ((ImageView) child).setScaleType(ImageView.ScaleType.FIT_CENTER);

                        // Clear old visual scaling
                        child.setScaleX(1.0f);
                        child.setScaleY(1.0f);

                        // Retrieve and persist logical scale in Tag
                        java.util.List<ClusterHudManager.HudComponentData> cached = ClusterHudManager.getInstance(this)
                                .getCachedHudComponents();
                        if (cached != null) {
                            for (ClusterHudManager.HudComponentData d : cached) {
                                if ("turn_signal".equals(d.type)) {
                                    child.setTag("type_turn_signal:scale_" + d.scale);
                                    break;
                                }
                            }
                        }
                        continue;
                    }

                    if (child instanceof TextView && text != null) {
                        ((TextView) child).setText(text);
                    } else if (child instanceof android.widget.LinearLayout
                            && ("song_2line".equals(type))) {
                        android.widget.LinearLayout ll = (android.widget.LinearLayout) child;
                        String[] parts = (text != null ? text : "").split("\n");
                        String title = parts.length > 0 ? parts[0] : "";
                        String artist = parts.length > 1 ? parts[1] : "";

                        // Update Title
                        if (ll.getChildCount() > 0 && ll.getChildAt(0) instanceof TextView) {
                            ((TextView) ll.getChildAt(0)).setText(title);
                        }

                        // Update Artist
                        if (!artist.isEmpty()) {
                            if (ll.getChildCount() > 1) {
                                ((TextView) ll.getChildAt(1)).setText(artist);
                                ll.getChildAt(1).setVisibility(View.VISIBLE);
                            } else {
                                // Add Artist View
                                android.widget.TextView tvArtist = new android.widget.TextView(this);
                                tvArtist.setText(artist);
                                tvArtist.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 44);
                                tvArtist.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);
                                tvArtist.setSingleLine(true);
                                tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                                tvArtist.setMarqueeRepeatLimit(-1);
                                tvArtist.setSelected(true);
                                tvArtist.setIncludeFontPadding(false);
                                tvArtist.setIncludeFontPadding(false);
                                
                                // [FIX] Sync negative margin for preview
                                android.widget.LinearLayout.LayoutParams artistParams = new android.widget.LinearLayout.LayoutParams(
                                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                                );
                                // Note: Preview is 2x scale (44px/44px usually, but here font is 48px?)
                                // Wait, font in PresentationManager was 22px, here 48px. 
                                // The preview is roughly 2x size logically.
                                // In PresentationManager margin was -6px (for 22px font).
                                // Here let's use -12px to keep proportion.
                                artistParams.topMargin = -8; 
                                
                                ll.addView(tvArtist, artistParams);
                            }
                        } else {
                            if (ll.getChildCount() > 1) {
                                ll.getChildAt(1).setVisibility(View.GONE);
                            }
                        }
                    } else if (child instanceof ImageView && image != null) {
                        ((ImageView) child).setImageBitmap(image);
                        // Standard logic: Preview is 2x HUD Size
                        if ("volume".equals(type)) {
                            // Real HUD Height = 36px -> Preview Height = 72px
                            int h = 72;
                            int w = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;

                            child.setLayoutParams(new android.widget.FrameLayout.LayoutParams(w, h));
                            ((ImageView) child).setAdjustViewBounds(true);
                            ((ImageView) child).setScaleType(ImageView.ScaleType.FIT_CENTER);

                            // Clear old scaling
                            child.setScaleX(1.0f);
                            child.setScaleY(1.0f);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceivers();
        // Unregister HUD Listener to prevent leak/updates when backgrounded
        ClusterHudManager.getInstance(this).setListener(null);
    }

    private void registerReceivers() {
        android.content.IntentFilter adbFilter = new android.content.IntentFilter("cn.navitool.ADB_STATUS_CHANGED");
        registerReceiver(adbStatusReceiver, adbFilter);

        android.content.IntentFilter psdFilter = new android.content.IntentFilter("cn.navitool.ACTION_PSD_STATUS");
        registerReceiver(mPsdStatusReceiver, psdFilter);

        android.content.IntentFilter oneOsFilter = new android.content.IntentFilter("cn.navitool.ACTION_ONEOS_STATUS");
        registerReceiver(mOneOSStatusReceiver, oneOsFilter);

        android.content.IntentFilter mediaFilter = new android.content.IntentFilter(
                cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE);
        registerReceiver(mMediaInfoReceiver, mediaFilter);

        // [FIX] Register mDayNightStatusReceiver for theme mode updates
        android.content.IntentFilter dayNightFilter = new android.content.IntentFilter(
                "cn.navitool.ACTION_DAY_NIGHT_STATUS");
        registerReceiver(mDayNightStatusReceiver, dayNightFilter);

        // [NEW] 注册仪表/HUD激活广播接收器 (延迟3秒后由KeepAliveService发送)
        android.content.IntentFilter clusterHudFilter = new android.content.IntentFilter(
                "cn.navitool.ACTION_ACTIVATE_CLUSTER_HUD");
        registerReceiver(mClusterHudActivationReceiver, clusterHudFilter);

        // [FIX] Request initial status after registering receiver
        ThemeBrightnessManager.getInstance(this).broadcastStatus();
    }

    private void unregisterReceivers() {
        try {
            unregisterReceiver(adbStatusReceiver);

            unregisterReceiver(mPsdStatusReceiver);
            unregisterReceiver(mOneOSStatusReceiver);
            unregisterReceiver(mDayNightStatusReceiver); // [FIX] Added
            unregisterReceiver(mClusterHudActivationReceiver); // [NEW] 取消注册仪表/HUD激活接收器
        } catch (IllegalArgumentException e) {
            // Receiver not registered
        }
    }

    private void initNavigation() {
        RadioGroup rgNavigation = findViewById(R.id.rgNavigation);
        mLayoutADB = findViewById(R.id.layoutContentADB); // Always present

        // Note: Other layouts are ViewStubs and will be inflated on demand

        // Initial Visibility
        if (mLayoutADB != null)
            mLayoutADB.setVisibility(View.VISIBLE); // Default Tab

        // Debug-only tabs logic:
        // Cluster (Now Enabled for Release to allow Theme Selection)
        int clusterVisibility = View.VISIBLE; // Formerly DEBUG only
        View rbCluster = findViewById(R.id.rbCluster);
        if (rbCluster != null)
            rbCluster.setVisibility(clusterVisibility);

        // HUD (Release Enabled)
        View rbHud = findViewById(R.id.rbHud);
        if (rbHud != null)
            rbHud.setVisibility(View.VISIBLE);

        // Hide experimental features in Release builds
        if (!BuildConfig.DEBUG) {

        }

        rgNavigation.setOnCheckedChangeListener((group, checkedId) -> {
            // Hide all potential views
            if (mLayoutADB != null)
                mLayoutADB.setVisibility(View.GONE);
            if (mLayoutGeneral != null)
                mLayoutGeneral.setVisibility(View.GONE);
            if (mLayoutButtons != null)
                mLayoutButtons.setVisibility(View.GONE);
            if (mLayoutAutoStart != null)
                mLayoutAutoStart.setVisibility(View.GONE);

            if (mLayoutBrightness != null)
                mLayoutBrightness.setVisibility(View.GONE);
            if (mLayoutSound != null)
                mLayoutSound.setVisibility(View.GONE);
            if (mLayoutCluster != null)
                mLayoutCluster.setVisibility(View.GONE);
            if (mLayoutHud != null)
                mLayoutHud.setVisibility(View.GONE);

            // Show selected
            if (checkedId == R.id.rbADB) {
                if (mLayoutADB != null)
                    mLayoutADB.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbGeneral) {
                ensureGeneralInflated();
                if (mLayoutGeneral != null)
                    mLayoutGeneral.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbButtons) {
                ensureButtonsInflated();
                if (mLayoutButtons != null)
                    mLayoutButtons.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbAutoStart) {
                ensureAutoStartInflated();
                if (mLayoutAutoStart != null)
                    mLayoutAutoStart.setVisibility(View.VISIBLE);

            } else if (checkedId == R.id.rbBrightness) {
                ensureBrightnessInflated();
                if (mLayoutBrightness != null)
                    mLayoutBrightness.setVisibility(View.VISIBLE);

            } else if (checkedId == R.id.rbSound) {
                ensureSoundInflated();
                if (mLayoutSound != null)
                    mLayoutSound.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbCluster) {
                ensureClusterInflated();
                if (mLayoutCluster != null)
                    mLayoutCluster.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbHud) {
                ensureHudInflated();
                if (mLayoutHud != null)
                    mLayoutHud.setVisibility(View.VISIBLE);
            }
        });
    }

    private View tryInflate(View currentView, int stubId, int targetId) {
        if (currentView == null) {
            android.view.ViewStub stub = findViewById(stubId);
            if (stub != null) {
                return stub.inflate();
            } else {
                return findViewById(targetId);
            }
        }
        return currentView;
    }

    private void ensureGeneralInflated() {
        if (mLayoutGeneral == null) {
            View v = tryInflate(mLayoutGeneral, R.id.stubGeneral, R.id.layoutContentGeneral);
            mLayoutGeneral = v;
            setupGeneralSettings();
            setupForceAutoDayNight();
            mIsGeneralInit = true;
            // Re-apply debug visibility for the newly inflated layout
            updateDebugViewsVisibility(DebugLogger.isDebugEnabled(this));
        }
    }

    private void ensureButtonsInflated() {
        if (mLayoutButtons == null) {
            View v = tryInflate(mLayoutButtons, R.id.stubButtons, R.id.layoutContentButtons);
            mLayoutButtons = v;
            setupSteeringWheelControl();
            setupWeChatButton();

            mIsButtonsInit = true;
            // Re-apply debug visibility for the newly inflated buttons
            updateDebugViewsVisibility(DebugLogger.isDebugEnabled(this));
        }
    }

    private void ensureAutoStartInflated() {
        if (mLayoutAutoStart == null) {
            View v = tryInflate(mLayoutAutoStart, R.id.stubAutoStart, R.id.layoutContentAutoStart);
            mLayoutAutoStart = v;
            setupAutoStartApps();
            mIsAutoStartInit = true;
        }
    }

    private void ensureBrightnessInflated() {
        if (mLayoutBrightness == null) {
            View v = tryInflate(mLayoutBrightness, R.id.stubBrightness, R.id.layoutContentBrightness);
            mLayoutBrightness = v;
            setupBrightnessSettings();
            setupPsdTestButtons();
            mIsBrightnessInit = true;
            // Update debug visibility for PSD test buttons (inside Brightness tab)
            updateDebugViewsVisibility(DebugLogger.isDebugEnabled(this));
        }
    }

    private void ensureSoundInflated() {
        if (!mIsSoundInit) {
            mLayoutSound = tryInflate(mLayoutSound, R.id.stubSound, R.id.layoutContentSound);
            if (mLayoutSound != null) {
                setupSoundSwitches();
                mIsSoundInit = true;
            }
        }
    }

    private void ensureClusterInflated() {
        if (mLayoutCluster == null) {
            View v = tryInflate(mLayoutCluster, R.id.stubCluster, R.id.layoutContentCluster);
            mLayoutCluster = v;
            setupCluster();
            setupClusterThemeSelector();
            mIsClusterInit = true;
        }
    }

    private void ensureHudInflated() {
        if (mLayoutHud == null) {
            View v = tryInflate(mLayoutHud, R.id.stubHud, R.id.layoutContentHud);
            mLayoutHud = v;
            setupHud();
            // Load saved HUD layout immediately to prevent reset
            loadHudLayout(mHudMode);
            mIsHudInit = true;
        }
    }

    private void setupGeneralSettings() {
        if (mLayoutGeneral == null)
            return;

        // Auto Theme Switch
        SwitchMaterial switchAutoTheme = mLayoutGeneral.findViewById(R.id.switchAutoTheme);
        if (switchAutoTheme != null) {
            boolean isAutoTheme = ConfigManager.getInstance().getBoolean("auto_theme_switch", false);
            switchAutoTheme.setChecked(isAutoTheme);
            switchAutoTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("auto_theme_switch", isChecked);
                if (isChecked) {
                    ThemeBrightnessManager.getInstance(this).checkDayNightStatus(true);
                    DebugLogger.toast(this, getString(R.string.auto_theme_sync_enabled));
                } else {
                    DebugLogger.toast(this, getString(R.string.auto_theme_sync_disabled));
                }
            });
        }

        // Sunshade Control
        setupSunshadeControl();



        // Festival Wallpaper
        android.widget.Spinner spinnerFestival = mLayoutGeneral.findViewById(R.id.spinnerFestivalWallpaper);
        if (spinnerFestival != null) {
            android.widget.ArrayAdapter<CharSequence> adapter = android.widget.ArrayAdapter.createFromResource(this,
                    R.array.festival_options, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerFestival.setAdapter(adapter);
            spinnerFestival.setEnabled(false); // Placeholder
        }

        // Floating Traffic Light
        SwitchMaterial switchFloatingTraffic = mLayoutGeneral.findViewById(R.id.switchFloatingTrafficLight);
        if (switchFloatingTraffic != null) {
            boolean isEnabled = ConfigManager.getInstance().getBoolean("floating_traffic_light_enabled", false);
            switchFloatingTraffic.setChecked(isEnabled);

            Button btnPosition = mLayoutGeneral.findViewById(R.id.btnPositionTrafficLight);
            if (btnPosition != null)
                btnPosition.setVisibility(isEnabled ? View.VISIBLE : View.GONE);

            switchFloatingTraffic.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("floating_traffic_light_enabled", isChecked);
                if (isChecked) {
                    NaviInfoController.getInstance(this).showTrafficLightFloating();
                    if (btnPosition != null)
                        btnPosition.setVisibility(View.VISIBLE);
                } else {
                    NaviInfoController.getInstance(this).hideTrafficLightFloating();
                    if (btnPosition != null)
                        btnPosition.setVisibility(View.GONE);
                }
            });

            if (btnPosition != null) {
                // [FIX] Feature Change: Button now toggles style and shows temporarily
                btnPosition.setText(getString(R.string.action_switch_style));
                btnPosition.setOnClickListener(v -> {
                    NaviInfoController.getInstance(this).toggleFloatingStyle();
                    DebugLogger.toast(this, "样式已切换，3秒后自动隐藏");
                });
            }
        }

        // Transmission Type Button
        android.widget.Button btnTransmissionType = mLayoutGeneral.findViewById(R.id.btnTransmissionType);
        if (btnTransmissionType != null) {
            final int TYPE_8AT = 0;
            final int TYPE_7DCT = 1;

            // Initial State
            int currentType = ConfigManager.getInstance().getInt("transmission_type", TYPE_8AT);
            btnTransmissionType.setText(currentType == TYPE_8AT ? "我是8AT车型" : "我是7DCT车型");

            // Apply initial setting to DrivingShift
            SimulateGear.getInstance().setTransmissionType(currentType);

            btnTransmissionType.setOnClickListener(v -> {
                int type = ConfigManager.getInstance().getInt("transmission_type", TYPE_8AT);
                int newType = (type == TYPE_8AT) ? TYPE_7DCT : TYPE_8AT;

                ConfigManager.getInstance().setInt("transmission_type", newType);
                SimulateGear.getInstance().setTransmissionType(newType);

                btnTransmissionType.setText(newType == TYPE_8AT ? "我是8AT车型" : "我是7DCT车型");
                DebugLogger.toast(this, newType == TYPE_8AT ? "已切换为 8AT 逻辑" : "已切换为 7DCT 逻辑");
            });
        }

        // Simulated Gear Switch
        com.google.android.material.switchmaterial.SwitchMaterial switchSimGear = mLayoutGeneral
                .findViewById(R.id.switchSimulatedGear);
        if (switchSimGear != null) {
            boolean isEnabled = ConfigManager.getInstance().getBoolean("simulated_gear_enabled", false);
            switchSimGear.setChecked(isEnabled);
            ClusterHudManager.getInstance(this).setSimulatedGearEnabled(isEnabled);

            // Initial button visibility
            if (btnTransmissionType != null) {
                btnTransmissionType.setVisibility(isEnabled ? android.view.View.VISIBLE : android.view.View.GONE);
            }

            switchSimGear.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("simulated_gear_enabled", isChecked);
                ClusterHudManager.getInstance(this).setSimulatedGearEnabled(isChecked);
                if (isChecked) {
                    DebugLogger.toast(this, getString(R.string.toast_simulated_gear_enabled));
                }

                // Toggle button visibility
                if (btnTransmissionType != null) {
                    btnTransmissionType.setVisibility(isChecked ? android.view.View.VISIBLE : android.view.View.GONE);
                }
            });
        }

        // Desktop Floating Ball
        SwitchMaterial switchFloatingBall = mLayoutGeneral
                .findViewById(R.id.switchFloatingBall);
        if (switchFloatingBall != null) {
            boolean isEnabled = ConfigManager.getInstance().getBoolean("floating_ball_enabled", false);
            switchFloatingBall.setChecked(isEnabled);

            // Restore state on init
            if (isEnabled) {
                if (Settings.canDrawOverlays(this)) {
                    startService(new Intent(this, cn.navitool.service.FloatingBallService.class));
                } else {
                    // If enabled but permission lost (rare), turn off switch or ask permission?
                    // Just leave it, user will toggle and trigger permission check.
                }
            }

            switchFloatingBall.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("floating_ball_enabled", isChecked);
                if (isChecked) {
                    if (!Settings.canDrawOverlays(this)) {
                        // Request Permission
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:" + getPackageName()));
                        mOverlayPermissionLauncher.launch(intent);
                        // Reset switch until granted (optional, or let onResume handle it)
                        buttonView.setChecked(false);
                        ConfigManager.getInstance().setBoolean("floating_ball_enabled", false);
                        DebugLogger.toast(this, "请先授予悬浮窗权限");
                    } else {
                        startService(new Intent(this, cn.navitool.service.FloatingBallService.class));
                    }
                } else {
                    stopService(new Intent(this, cn.navitool.service.FloatingBallService.class));
                }
            });
        }
    }

    private void setupSunshadeControl() {
        if (mLayoutGeneral == null)
            return;

        // Auto Open Switch
        SwitchMaterial swAutoOpen = mLayoutGeneral.findViewById(R.id.swSunshadeAutoOpen);
        if (swAutoOpen != null) {
            swAutoOpen.setChecked(cn.navitool.managers.SunshadeManager.getInstance(this).isAutoOpenEnabled());
            swAutoOpen.setOnCheckedChangeListener((v, isChecked) -> {
                cn.navitool.managers.SunshadeManager.getInstance(this).setAutoOpenEnabled(isChecked);
                if (isChecked)
                    DebugLogger.toast(this, getString(R.string.toast_sunshade_auto_enabled));
            });
        }

        // Night Mode Only Button
        com.google.android.material.button.MaterialButton btnNight = mLayoutGeneral
                .findViewById(R.id.btnSunshadeNightOnly);
        if (btnNight != null) {
            boolean isNightOnly = cn.navitool.managers.SunshadeManager.getInstance(this).isNightModeOnly();
            updateSunshadeNightIcon(btnNight, isNightOnly);
            btnNight.setOnClickListener(v -> {
                boolean newState = !cn.navitool.managers.SunshadeManager.getInstance(this).isNightModeOnly();
                cn.navitool.managers.SunshadeManager.getInstance(this).setNightModeOnly(newState);
                updateSunshadeNightIcon(btnNight, newState);
            });
        }

        // Target Position Slider
        SeekBar sbPos = mLayoutGeneral.findViewById(R.id.sbSunshadePosition);
        if (sbPos != null) {
            sbPos.setProgress(cn.navitool.managers.SunshadeManager.getInstance(this).getTargetPosition());
            sbPos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        cn.navitool.managers.SunshadeManager.getInstance(MainActivity.this).setTargetPosition(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
    }

    private void updateSunshadeNightIcon(com.google.android.material.button.MaterialButton btn, boolean isNightOnly) {
        if (isNightOnly) {
            btn.setIconResource(R.drawable.ic_check);
            btn.setIconTint(android.content.res.ColorStateList.valueOf(android.graphics.Color.GREEN));
        } else {
            btn.setIconResource(R.drawable.ic_close);
            btn.setIconTint(android.content.res.ColorStateList.valueOf(android.graphics.Color.RED));
        }
    }

    private void initUI() {
        // --- Header / Debug ---
        boolean isDebug = DebugLogger.isDebugEnabled(this);
        updateDebugViewsVisibility(isDebug);
        ClusterHudManager.getInstance(this).setDebugMode(isDebug);
        setVersionInfo();

        // --- ADB Tab (System Info & Permissions & Default Tab) ---
        setupSystemInfo();
        setupPermissionStatuses();
        setupAdbWireless();

        // Speed comparison display receivers (for status page)

        updateAutoModeStatus(0, -1);

        // --- Auto-Initialize Cluster ---
        // Ensure Cluster Service starts even if tab is not visited
        // Use new theme system (THEME_DEFAULT or THEME_AUDI_RS)
        int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                PresentationManager.THEME_DEFAULT);
        ClusterHudManager.getInstance(this).setClusterTheme(savedTheme);
        // Note: Other tabs setup is deferred to ensureXInflated methods
    }

    private void setVersionInfo() {
        TextView tvAppCredit = findViewById(R.id.tvAppCredit);
        if (tvAppCredit != null) {
            tvAppCredit.setText(getString(R.string.app_credit, BuildConfig.VERSION_NAME));
        }
    }

    private int mHudMode = 0; // 0=WHUD, 1=AR
    private static final int MODE_WHUD = 0;
    private static final int MODE_AR = 1;

    private void setupCluster() {
        com.google.android.material.switchmaterial.SwitchMaterial switchCluster = findViewById(R.id.switchCluster);
        if (switchCluster != null) {
            // Load Saved State
            boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
            switchCluster.setChecked(isClusterEnabled);
            ClusterHudManager.getInstance(this).setClusterEnabled(isClusterEnabled);

            switchCluster.setOnCheckedChangeListener((buttonView, isChecked) -> {
                DebugLogger.action("MainActivity", "Cluster开关切换: " + isChecked);
                ClusterHudManager.getInstance(this).setClusterEnabled(isChecked);
                ConfigManager.getInstance().setBoolean("switch_cluster", isChecked);
            });
        }

        // Theme Selection - Audi RS handler is in the main setupClusterThemeSelector
        // setupClusterThemeSelector() is called from there
    }

    // Called from setupClusterThemeSelector() to setup Audi RS specific handlers
    private void setupAudiRsThemeHandlers() {
        View themeDefault = findViewById(R.id.layoutClusterTheme1);
        View themeAudiRs = findViewById(R.id.layoutClusterThemeAudiRs);
        View checkDefault = findViewById(R.id.ivClusterCheck1);
        View checkAudiRs = findViewById(R.id.ivClusterCheckAudiRs);

        // Load saved Audi RS theme state
        int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                PresentationManager.THEME_DEFAULT);
        updateAudiRsThemeCheckmarks(savedTheme, checkDefault, checkAudiRs, themeDefault, themeAudiRs);

        // Apply saved theme on startup
        ClusterHudManager.getInstance(this).setClusterTheme(savedTheme);

        // Audi RS theme click handler
        if (themeAudiRs != null) {
            themeAudiRs.setOnClickListener(v -> {
                DebugLogger.action("MainActivity", "切换仪表主题: 奥迪RS");
                ClusterHudManager.getInstance(this).setClusterTheme(PresentationManager.THEME_AUDI_RS);
                ConfigManager.getInstance().setInt("cluster_theme_builtin", PresentationManager.THEME_AUDI_RS);
                updateAudiRsThemeCheckmarks(PresentationManager.THEME_AUDI_RS, checkDefault, checkAudiRs,
                        themeDefault, themeAudiRs);
            });
        }

        // Default theme click handler (to switch back from Audi RS)
        if (themeDefault != null) {
            final View.OnClickListener existingListener = null; // May need to chain
            themeDefault.setOnClickListener(v -> {
                DebugLogger.action("MainActivity", "切换仪表主题: 默认");
                ClusterHudManager.getInstance(this).setClusterTheme(PresentationManager.THEME_DEFAULT);
                ConfigManager.getInstance().setInt("cluster_theme_builtin", PresentationManager.THEME_DEFAULT);
                updateAudiRsThemeCheckmarks(PresentationManager.THEME_DEFAULT, checkDefault, checkAudiRs,
                        themeDefault, themeAudiRs);
            });
        }
    }

    private void updateAudiRsThemeCheckmarks(int selectedTheme, View checkDefault, View checkAudiRs,
            View themeDefault, View themeAudiRs) {
        boolean isDefault = (selectedTheme == PresentationManager.THEME_DEFAULT);
        boolean isAudi = (selectedTheme == PresentationManager.THEME_AUDI_RS);
        
        if (checkDefault != null)
            checkDefault.setVisibility(isDefault ? View.VISIBLE : View.GONE);
        if (checkAudiRs != null)
            checkAudiRs.setVisibility(isAudi ? View.VISIBLE : View.GONE);

        // Update backgrounds
        if (themeDefault != null)
            themeDefault
                    .setBackgroundResource(isDefault ? R.drawable.bg_cluster_selected : R.drawable.bg_cluster_normal);
        if (themeAudiRs != null)
            themeAudiRs
                    .setBackgroundResource(isAudi ? R.drawable.bg_cluster_selected : R.drawable.bg_cluster_normal);
                    
        // Update Dynamic Items (Imported)
        LinearLayout container = findViewById(R.id.layoutThemeContainer);
        if (container != null) {
            for (int i = 2; i < container.getChildCount(); i++) {
                View child = container.getChildAt(i);
                Object tag = child.getTag();
                boolean isSelected = false;
                
                // Only handle external/imported themes if necessary
                if (tag instanceof String && !"audi_rs".equals(tag)) {
                    // isSelected = check against imported name
                }
                
                child.setBackgroundResource(isSelected ? R.drawable.bg_cluster_selected : R.drawable.bg_cluster_normal);
                 if (child instanceof android.view.ViewGroup) {
                     android.view.ViewGroup vg = (android.view.ViewGroup) child;
                     // ImageView is at index 1
                     if (vg.getChildCount() > 1 && vg.getChildAt(1) instanceof ImageView) {
                         vg.getChildAt(1).setVisibility(isSelected ? View.VISIBLE : View.GONE);
                     }
                 }
            }
        }
    }

    private void setupHud() {
        com.google.android.material.switchmaterial.SwitchMaterial switchHud = findViewById(R.id.switchHud);
        if (switchHud != null) {
            // Load Saved State
            boolean isHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);
            switchHud.setChecked(isHudEnabled);
            // Initial Visibility Set
            ClusterHudManager.getInstance(this).setHudEnabled(isHudEnabled);
            View previewContainer = findViewById(R.id.layoutHudPreviewContainer);
            View previewContent = findViewById(R.id.layoutHudPreview);
            View controls = findViewById(R.id.layoutHudEditorControls);

            if (previewContainer != null)
                previewContainer.setVisibility(isHudEnabled ? View.VISIBLE : View.GONE);
            if (previewContent != null) {
                previewContent.setVisibility(View.VISIBLE);
                // [FIX] 初始化时就设置网格背景，而不是等到添加组件时
                if (previewContent instanceof android.widget.FrameLayout) {
                    ((android.widget.FrameLayout) previewContent).setBackground(new GridBackgroundDrawable());
                }
            }
            if (controls != null)
                controls.setVisibility(isHudEnabled ? View.VISIBLE : View.GONE);

            switchHud.setOnCheckedChangeListener((buttonView, isChecked) -> {
                DebugLogger.action("MainActivity", "HUD开关切换: " + isChecked);
                ClusterHudManager.getInstance(this).setHudEnabled(isChecked);
                ConfigManager.getInstance().setBoolean("switch_hud", isChecked);

                View pvContainer = findViewById(R.id.layoutHudPreviewContainer);
                View pvContent = findViewById(R.id.layoutHudPreview);
                View ctrl = findViewById(R.id.layoutHudEditorControls);

                // Toggle Container
                if (pvContainer != null)
                    pvContainer.setVisibility(isChecked ? View.VISIBLE : View.GONE);

                // Ensure Content is Visible if Container is Visible
                if (pvContent != null)
                    pvContent.setVisibility(View.VISIBLE);

                if (ctrl != null)
                    ctrl.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            });
        }

        setupHudEditor();
        setupHudEditor();
        // Corrected ID reference

        // Restore HUD Mode

        // Restore HUD Mode
        mHudMode = ConfigManager.getInstance().getInt("hud_current_mode", MODE_WHUD);
        updateHudModeButton();

        // Load Layout
        loadHudLayout(mHudMode);

        // [FIX] Force refresh data to generic components immediately
        ClusterHudManager.getInstance(this).forceNotifyListener();
    }

    // --- HUD Editor Logic ---
    private View mHudTestComponent;
    private View mResizeHandle; // 右下角缩放手柄
    private boolean mIsHudComponentLocked = false;
    private boolean mIsSnowModeEnabled = false;
    private float dX, dY;

    private void setupHudEditor() {
        findViewById(R.id.btnHudAdd).setOnClickListener(v -> showAddHudComponentDialog());
        findViewById(R.id.btnHudModify).setOnClickListener(v -> unlockHudComponent());
        findViewById(R.id.btnHudDelete).setOnClickListener(v -> deleteSelectedHudComponent());
        findViewById(R.id.btnHudSave).setOnClickListener(v -> lockHudComponent());
        findViewById(R.id.btnHudReset).setOnClickListener(v -> resetHudComponent());
        findViewById(R.id.btnHudSwitchMode).setOnClickListener(v -> switchHudMode());
        findViewById(R.id.btnHudSnowMode).setOnClickListener(v -> toggleSnowMode());

        // Restore Snow Mode
        mIsSnowModeEnabled = ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
        updateHudSnowModeButton();
    }

    private void switchHudMode() {
        // 1. Save current layout
        saveCurrentHudLayout(mHudMode);

        // 2. Toggle Mode
        mHudMode = (mHudMode == MODE_WHUD) ? MODE_AR : MODE_WHUD;
        ConfigManager.getInstance().setInt("hud_current_mode", mHudMode);

        // 3. Update UI
        updateHudModeButton();
        DebugLogger.toast(this, "已切换至 " + ((mHudMode == MODE_WHUD) ? "WHUD" : "AR") + " 模式");

        // 4. Load Layout
        loadHudLayout(mHudMode);
    }

    private void saveCurrentHudLayout(int mode) {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;

        // Save Lock State
        String lockKey = (mode == MODE_WHUD) ? "hud_locked_whud" : "hud_locked_ar";
        ConfigManager.getInstance().setBoolean(lockKey, mIsHudComponentLocked);

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);
            // Filter: Only save views that are explicitly HUD components (have a tag)
            // Filter: Only save views that are explicitly HUD components (have a tag)
            Object tag = child.getTag();
            if (tag != null && tag.toString().startsWith("type_")) {
                try {
                    JSONObject obj = new JSONObject();
                    // Determine Type
                    // [FIX] 处理包含":scale_"后缀的tag，只提取基础类型名称
                    String rawType = tag.toString().replace("type_", "");
                    String type = rawType.contains(":") ? rawType.substring(0, rawType.indexOf(":")) : rawType;
                    obj.put("type", type);

                    String text = "";
                    if (child instanceof TextView) {
                        text = (child instanceof android.widget.TextClock)
                                ? ((android.widget.TextClock) child).getFormat12Hour().toString()
                                : ((TextView) child).getText().toString();
                    } else if (child instanceof android.widget.LinearLayout) {
                        // Extract Title and Artist for Media Info
                        android.widget.LinearLayout ll = (android.widget.LinearLayout) child;
                        String title = "";
                        String artist = "";
                        if (ll.getChildCount() > 0 && ll.getChildAt(0) instanceof TextView)
                            title = ((TextView) ll.getChildAt(0)).getText().toString();
                        if (ll.getChildCount() > 1 && ll.getChildAt(1) instanceof TextView)
                            artist = ((TextView) ll.getChildAt(1)).getText().toString();
                        if (!artist.isEmpty()) {
                            text = title + "\n" + artist;
                        } else {
                            text = title;
                        }
                    }
                    obj.put("text", text);

                    obj.put("x", child.getX());
                    obj.put("y", child.getY());
                    // [FIX Bug 5] Save scale
                    // [FIX] 对于转向灯等特殊组件，缩放值存储在tag后缀中，需要从tag提取
                    float scale = child.getScaleX();
                    if (rawType.contains(":scale_")) {
                        try {
                            String scaleStr = rawType.substring(rawType.indexOf(":scale_") + 7);
                            scale = Float.parseFloat(scaleStr);
                        } catch (NumberFormatException e) {
                            // 解析失败则使用默认值
                            scale = 1.0f;
                        }
                    }
                    obj.put("scale", scale);
                    jsonArray.put(obj);
                } catch (JSONException e) {
                    DebugLogger.e("HUD", "Failed to serialize component", e);
                }
            }
        }
        String key = (mode == MODE_WHUD) ? "hud_layout_whud" : "hud_layout_ar";
        ConfigManager.getInstance().setString(key, jsonArray.toString());
        DebugLogger.d("HUD", "Saved layout for " + key + ": " + jsonArray.toString());
    }

    private void reloadHudConfigToManager(int mode) {
        // Sync version for UI usage
        List<ClusterHudManager.HudComponentData> data = parseHudConfig(mode);
        applyHudConfigToManager(data);
    }

    private List<ClusterHudManager.HudComponentData> parseClusterConfig() {
        String key = "cluster_layout";
        String jsonStr = ConfigManager.getInstance().getString(key, "[]");
        List<ClusterHudManager.HudComponentData> syncList = new ArrayList<>();

        if (jsonStr != null && !jsonStr.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String type = obj.optString("type", "text");
                    String text = obj.optString("text", "Text");
                    float x = (float) obj.optDouble("x", 0);
                    float y = (float) obj.optDouble("y", 0);
                    syncList.add(new ClusterHudManager.HudComponentData(type, text, x, y));
                }
            } catch (JSONException e) {
                DebugLogger.e("Cluster", "Failed to parse layout config for sync", e);
            }
        }
        return syncList;
    }

    private List<ClusterHudManager.HudComponentData> parseHudConfig(int mode) {
        String key = (mode == MODE_WHUD) ? "hud_layout_whud" : "hud_layout_ar";
        String jsonStr = ConfigManager.getInstance().getString(key, "[]");
        List<ClusterHudManager.HudComponentData> syncList = new ArrayList<>();

        if (jsonStr != null && !jsonStr.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                boolean isSnowMode = ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
                int color = isSnowMode ? 0xFF00FFFF : 0xFFFFFFFF;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String type = obj.optString("type", "text");
                    String text = obj.optString("text", "Text");
                    float x = (float) obj.optDouble("x", 0);
                    float y = (float) obj.optDouble("y", 0);

                    float scale = (float) obj.optDouble("scale", 1.0f);

                    ClusterHudManager.HudComponentData data = new ClusterHudManager.HudComponentData(type, text,
                            x * 0.5f, y * 0.5f, color);
                    data.scale = scale;
                    syncList.add(data);
                }
            } catch (JSONException e) {
                DebugLogger.e("HUD", "Failed to parse layout config for sync", e);
            }
        }
        return syncList;
    }

    private void applyHudConfigToManager(List<ClusterHudManager.HudComponentData> syncList) {
        ClusterHudManager.getInstance(this).syncHudLayout(syncList);
    }

    private void loadHudLayout(int mode) {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;

        // Clear Preview
        preview.removeAllViews();
        mHudTestComponent = null;

        String key = (mode == MODE_WHUD) ? "hud_layout_whud" : "hud_layout_ar";
        String jsonStr = ConfigManager.getInstance().getString(key, "[]");
        List<ClusterHudManager.HudComponentData> syncList = new ArrayList<>();

        if (jsonStr != null && !jsonStr.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    String type = obj.optString("type", "text");
                    String text = obj.optString("text", "Text");
                    float x = (float) obj.optDouble("x", 0);
                    float y = (float) obj.optDouble("y", 0);
                    float scale = (float) obj.optDouble("scale", 1.0f);

                    createAndAddHudComponent(type, text, x, y);

                    // Apply scale to the newly created view (last child)
                    if (preview != null && preview.getChildCount() > 0) {
                        View lastChild = preview.getChildAt(preview.getChildCount() - 1);
                        
                        // [FIX] 转向灯组件不使用视图缩放，而是通过Bitmap间距实现
                        // 转向灯的scale只影响箭头之间的间距，不影响箭头图片大小
                        if ("turn_signal".equals(type)) {
                            // 不设置setScaleX/Y，保持视图1:1
                            // scale已在createAndAddHudComponent中通过tag传递
                            // 重新生成带正确间距的Bitmap
                            if (lastChild instanceof android.widget.ImageView) {
                                android.graphics.Bitmap bmp = ClusterHudManager.getInstance(this)
                                        .getTurnSignalBitmap(true, true, scale);
                                if (bmp != null) {
                                    bmp = ClusterHudManager.getInstance(this).addCenterLineOverlay(bmp);
                                    ((android.widget.ImageView) lastChild).setImageBitmap(bmp);
                                }
                            }
                            // 更新tag以包含scale信息
                            lastChild.setTag("type_turn_signal:scale_" + scale);
                        } else {
                            lastChild.setScaleX(scale);
                            lastChild.setScaleY(scale);
                        }
                    }

                    int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF;
                    // [FIX] Scale coordinates for Real HUD (728x190 = 0.5x of Preview 1456x380)
                    ClusterHudManager.HudComponentData data = new ClusterHudManager.HudComponentData(type, text,
                            x * 0.5f, y * 0.5f, color);
                    data.scale = scale;
                    syncList.add(data);
                }
            } catch (JSONException e) {
                DebugLogger.e("HUD", "Failed to parse layout config", e);
            }
        }

        // Restore Lock State
        String lockKey = (mode == MODE_WHUD) ? "hud_locked_whud" : "hud_locked_ar";
        // User Request: Always start in Locked Mode (Non-Editable)
        mIsHudComponentLocked = true;
        // mIsHudComponentLocked = ConfigManager.getInstance().getBoolean(lockKey,
        // true); // Legacy

        // updateHudLockButton(); // Removed: Using separate buttons for Lock/Unlock

        if (mIsHudComponentLocked) {
            // DebugLogger.toast(this, "布局已恢复并锁定");
        }

        // Sync to Real HUD
        ClusterHudManager.getInstance(this).syncHudLayout(syncList);
    }

    private void toggleSnowMode() {
        mIsSnowModeEnabled = !mIsSnowModeEnabled;
        ConfigManager.getInstance().setBoolean("hud_snow_mode", mIsSnowModeEnabled);
        updateHudSnowModeButton();
        refreshHudComponentColors();
        syncAllHudComponents();
        DebugLogger.toast(this, mIsSnowModeEnabled ? "雪地模式已开启" : "雪地模式已关闭");
    }

    private void updateHudSnowModeButton() {
        Button btn = findViewById(R.id.btnHudSnowMode);
        if (btn != null) {
            btn.setText(mIsSnowModeEnabled ? "关闭雪地模式" : "开启雪地模式");
        }
    }

    private void refreshHudComponentColors() {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;
        int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF; // Cyan : White

        // Update Preview
        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);
            if (child instanceof TextView) {
                ((TextView) child).setTextColor(color);
            } else if (child instanceof android.widget.LinearLayout) {
                // [FIX] Support Song Component (LinearLayout)
                android.widget.LinearLayout ll = (android.widget.LinearLayout) child;
                for (int j = 0; j < ll.getChildCount(); j++) {
                    View subChild = ll.getChildAt(j);
                    if (subChild instanceof TextView) {
                        ((TextView) subChild).setTextColor(color);
                    }
                }
            }
        }
    }

    // Updated helper method signature to accept type
    // Updated helper method signature to accept type
    private void createAndAddHudComponent(String type, String text, float x, float y) {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;

        // Apply Grid Background (20px Grid)
        preview.setBackground(new GridBackgroundDrawable());

        // Clear Preview - REMOVED to allow multiple components
        // preview.removeAllViews();
        // mHudTestComponent = null;

        View view;
        boolean isMediaCover = "song_cover".equals(type);
        boolean isTurnSignal = "turn_signal".equals(type);
        boolean isVolume = "volume".equals(type);
        boolean isAutoHold = "auto_hold".equals(type);



        if ("song_2line".equals(type) || "song_1line".equals(type)) {
            android.widget.LinearLayout ll = new android.widget.LinearLayout(this);
            ll.setOrientation(android.widget.LinearLayout.VERTICAL);
            ll.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            ll.setPadding(0, 0, 0, 0);

            String[] parts = (text != null ? text : "").split("\n");
            String title = parts.length > 0 ? parts[0] : "";
            String artist = parts.length > 1 ? parts[1] : "";

            // Title
            android.widget.TextView tvTitle = new android.widget.TextView(this);
            tvTitle.setText(title);
            tvTitle.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 44);
            tvTitle.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);
            tvTitle.setSingleLine(true);
            tvTitle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
            tvTitle.setMarqueeRepeatLimit(-1);
            tvTitle.setSelected(true);
            tvTitle.setIncludeFontPadding(false);
            ll.addView(tvTitle);

            // Artist
            if (!artist.isEmpty()) {
                android.widget.TextView tvArtist = new android.widget.TextView(this);
                tvArtist.setText(artist);
                tvArtist.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 44);
                tvArtist.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);
                tvArtist.setSingleLine(true);
                tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                tvArtist.setMarqueeRepeatLimit(-1);
                tvArtist.setSelected(true);
                tvArtist.setIncludeFontPadding(false);
                ll.addView(tvArtist);
            }

            android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(600,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);
            view = ll;
            view.setLayoutParams(params);
        } else if ("fuel_range".equals(type) || "fuel".equals(type)) {
            // [Preview Sync] Fuel & Fuel Range using LinearLayout
            // Preview is 2x scale of HUD
            // HUD: Emoji 18px, Value 24px
            // Preview: Emoji 36px, Value 48px

            android.widget.LinearLayout ll = new android.widget.LinearLayout(this);
            ll.setOrientation(android.widget.LinearLayout.HORIZONTAL);
            ll.setGravity(android.view.Gravity.CENTER_VERTICAL);
            ll.setBackgroundColor(android.graphics.Color.TRANSPARENT);

            // 1. Emoji View "⛽" (Preview Size 36px)
            android.widget.TextView tvEmoji = new android.widget.TextView(this);
            tvEmoji.setText("⛽");
            tvEmoji.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 36f); // 2x 18px
            tvEmoji.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);
            tvEmoji.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            tvEmoji.setPadding(0, 0, 8, 0); // Preview Padding 8px (2x 4px)
            tvEmoji.setIncludeFontPadding(false);

            // 2. Value View (Preview Size 48px)
            android.widget.TextView tvValue = new android.widget.TextView(this);
            String valText = text != null ? text.replace("⛽", "").trim() : "";
            tvValue.setText(valText);
            tvValue.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 48f); // 2x 24px
            tvValue.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);
            tvValue.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            tvValue.setIncludeFontPadding(false);

            ll.addView(tvEmoji);
            ll.addView(tvValue);

            android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);
            view = ll;
            view.setLayoutParams(params);
        } else if ("traffic_light".equals(type)) {
            // Traffic Light Preview
            cn.navitool.view.TrafficLightView tlv = new cn.navitool.view.TrafficLightView(this);
            // Set Preview State: Red Light, 66s, Straight
            tlv.updateState(cn.navitool.view.TrafficLightView.STATUS_RED, 66, 0);

            android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);
            view = tlv;
            view.setLayoutParams(params);

            // [FIX] Scale 2x for Preview (matching other components)
            // Real HUD: 1x (24px fonts), Preview: 2x (should appear as 48px)
            // Use internal scaling method to ensure correct boundary detection
            tlv.setPreviewScale(2.0f);
        } else if (isMediaCover || isTurnSignal || isVolume || isAutoHold) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundColor(android.graphics.Color.TRANSPARENT);

            if (isTurnSignal) {
                // Use Manager to get Standard Bitmap (32px or 48px)
                android.graphics.Bitmap bmp = ClusterHudManager.getInstance(this).getTurnSignalBitmap(true, true);
                if (bmp != null) {
                    iv.setImageBitmap(bmp);
                } else {
                    iv.setImageResource(R.drawable.ic_turn_signal);
                }
                // Unified Logic: Physical Sizing (2x Real HUD Size)
                // Real HUD Turn Signal Height = 36px -> Preview Height = 72px
                int h = 72; // Fixed 72px height
                int w = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;

                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(w, h);
                iv.setAdjustViewBounds(true);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view = iv;
                view.setLayoutParams(params);
            } else if (isAutoHold) {
                // Use Manager to get Bitmap
                android.graphics.Bitmap bmp = ClusterHudManager.getInstance(this).getAutoHoldBitmap(true); // Default ON
                                                                                                           // for
                                                                                                           // preview
                if (bmp != null) {
                    iv.setImageBitmap(bmp);
                } else {
                    iv.setImageResource(R.drawable.ic_auto_hold);
                }

                // Real HUD Size 36px -> Preview 72px
                int size = 72;
                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(size,
                        size);
                iv.setAdjustViewBounds(true);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view = iv;
                view.setLayoutParams(params);

            } else if (isVolume) {
                // Use Manager to get Standard Bitmap (24px)
                android.graphics.Bitmap bmp = ClusterHudManager.getInstance(this).getVolumeBitmap(15);
                if (bmp != null) {
                    iv.setImageBitmap(bmp);
                } else {
                    iv.setImageResource(R.drawable.ic_volume);
                }

                // Real HUD Volume Height = 36px -> Preview Height = 72px
                int h = 72;
                int w = android.widget.FrameLayout.LayoutParams.WRAP_CONTENT;

                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(w, h);
                iv.setAdjustViewBounds(true);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view = iv;
                view.setLayoutParams(params);
            } else {
                // Media Cover
                iv.setImageResource(android.R.drawable.ic_media_play);
                // Preview size 200x200 (2x of HUD 100x100)
                android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(200, 200);
                view = iv;
                view.setLayoutParams(params);
            }
        } else if ("guide_line".equals(type)) {
            // [Feature] Moveable Guide Line Component
            android.widget.FrameLayout container = new android.widget.FrameLayout(this);
            // Full Height (380px), Width distinct enough to drag (e.g. 100px)
            android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                    100, 380);
            container.setLayoutParams(params);

            // 1. The Vertical Line (Centered)
            View line = new View(this);
            // Use 380px width (rotated to be height) and 4dp thickness
            android.widget.FrameLayout.LayoutParams lineParams = new android.widget.FrameLayout.LayoutParams(
                    380, 4);
            lineParams.gravity = android.view.Gravity.CENTER;
            line.setBackgroundResource(R.drawable.line_dashed_cyan);
            line.setRotation(90);
            line.setLayoutParams(lineParams);
            line.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            container.addView(line);

            // 2. The Coordinate Text (Centered)
            TextView tvCoord = new TextView(this);
            tvCoord.setText("X:0");
            tvCoord.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 36); // Readable size
            tvCoord.setTextColor(android.graphics.Color.CYAN);
            tvCoord.setBackgroundColor(0x80000000); // Semi-transparent black bg
            tvCoord.setPadding(8, 4, 8, 4);
            android.widget.FrameLayout.LayoutParams tvParams = new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);
            tvParams.gravity = android.view.Gravity.CENTER;
            container.addView(tvCoord, tvParams);

            view = container;
        } else if ("time".equals(type)) {
            // [FIX] Use TextClock for dynamic time in Preview
            android.widget.TextClock tc = new android.widget.TextClock(this);
            tc.setFormat12Hour("HH:mm");
            tc.setFormat24Hour("HH:mm");
            tc.setTimeZone(null);
            tc.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            view = tc;
        } else if ("hud_rpm".equals(type)) {
            TextView tv = new TextView(this);
            tv.setText(text);
            tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            tv.setSingleLine(true); // [FIX] Force single line to prevent wrapping at high RPM
            tv.setEllipsize(null);
            // [FIX] Fixed Width 300px (Real HUD 150px * 2) + Right Alignment
            tv.setGravity(android.view.Gravity.END);
            view = tv;
            
            // Set LayoutParams immediately to ensure width is applied
            android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(
                    200, 
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
        } else {
            TextView tv = new TextView(this);
            tv.setText(text);
            // Rule: Transparent Background
            tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            view = tv;
        }

        view.setBackgroundColor(android.graphics.Color.TRANSPARENT); // Ensure transparent

        // [FIX Bug 5] Force Pivot to Top-Left (0,0) to match editing logic and prevent
        // drift
        view.setPivotX(0f);
        view.setPivotY(0f);

        // Font scaling for Text Views
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            tv.setPadding(0, 0, 0, 0);
            tv.setIncludeFontPadding(false); // Minimized vertical spacing
            // Rule 2: Font scaling (Preview is 2x HUD)
            // Real HUD Gear = 48px -> Preview = 96px
            // Real HUD Other = 24px -> Preview = 48px
            if ("gear".equals(type)) {
                // [Sync Issue 4] Gear: 48px * 2 = 96px
                tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 96);

                // [UI Fix] Add Center Line Overlay && Remove Border
                // Create background with center line (Fixed Width 200px)
                android.graphics.Bitmap bgCb = android.graphics.Bitmap.createBitmap(200, 96,
                        android.graphics.Bitmap.Config.ARGB_8888);
                if (bgCb != null) {
                    bgCb = ClusterHudManager.getInstance(this).addCenterLineOverlay(bgCb);
                    tv.setBackground(new android.graphics.drawable.BitmapDrawable(getResources(), bgCb));
                }

                // [Sync Issue 4] Fixed Width 100px * 2 = 200px, Center
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));
                }
                view.getLayoutParams().width = 200;
                tv.setGravity(android.view.Gravity.CENTER);
            } else if ("temp_out".equals(type) || "temp_in".equals(type)) {
                // [Sync Issue 10] Temp: Standard Font 48px
                tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 48);
                // [Sync Issue 10] Fixed Width 90px * 2 = 180px, Right Align
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));
                }
                view.getLayoutParams().width = 180;
                tv.setGravity(android.view.Gravity.END);
            } else {
                tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 48);
            }
            tv.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);

            // [Sync Issue 10] Apply Dynamic Negative Margin to Preview for WYSIWYG
            // REMOVED: Causing clipping issues. Preview should match PresentationManager logic
            // (which now wraps views).
            // Logic: -20% of Text Size -> REMOVED
            // float currentTextSize = tv.getTextSize();
            // int margin = (int) (-currentTextSize * 0.2f);
            int margin = 0;

            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                        android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));
            }
            android.widget.FrameLayout.LayoutParams tvParams = (android.widget.FrameLayout.LayoutParams) view
                    .getLayoutParams();
            tvParams.topMargin = margin;
            tvParams.bottomMargin = margin;

            if ("song_2line".equals(type)) {
                // Preview width = 600px (HUD 300px * 2)
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));
                }
                view.getLayoutParams().width = 600;
                tv.setSingleLine(true);
                tv.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                tv.setMarqueeRepeatLimit(-1);
                tv.setSelected(true);
            }
        }

        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                    android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));
        }

        // Store specific type in Tag for Sync
        view.setTag("type_" + type);

        android.widget.FrameLayout.LayoutParams params = (android.widget.FrameLayout.LayoutParams) view
                .getLayoutParams();
        params.gravity = android.view.Gravity.TOP | android.view.Gravity.START;

        view.setX(x);
        view.setY(y);

        preview.addView(view, params);
        mHudTestComponent = view; // Only track last added for now
        mIsHudComponentLocked = false;

        // Setup Drag Listener
        setupHudComponentTouchListener(view);
    }

    private void setupHudComponentTouchListener(View tv) {
        tv.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, android.view.MotionEvent event) {
                if (mIsHudComponentLocked)
                    return false;

                switch (event.getAction()) {
                    case android.view.MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        // Update current Selection tracking
                        mHudTestComponent = view;
                        highlightSelectedComponent(view);
                        break;
                    case android.view.MotionEvent.ACTION_MOVE:
                        float newX = event.getRawX() + dX;
                        float newY = event.getRawY() + dY;

                        // Bounds Check - 使用缩放后的尺寸
                        View parent = (View) view.getParent();
                        int parentWidth = parent.getWidth();
                        int parentHeight = parent.getHeight();
                        int viewWidth = (int) (view.getWidth() * view.getScaleX());
                        int viewHeight = (int) (view.getHeight() * view.getScaleY());

                        if (newX < 0)
                            newX = 0;
                        if (newX + viewWidth > parentWidth)
                            newX = parentWidth - viewWidth;

                            // [FIX] Consistently apply negative margin logic to Boundary Check
                        // Allow dragging "out of bounds" by the same amount as the visual negative
                        // margin
                        // Split into Top and Bottom offsets
                        float offsetTop = 0;
                        float offsetBottom = 0;
                        
                        // 可在此处手动修改预览拖拽的边距倍率
                        // You can manually modify the preview drag margin factors here
                        float FACTOR_TOP = 0.18f;
                        float FACTOR_BOTTOM = 0.2f;

                        // [Feature] Guide Line: Lock Y Axis & Update Text
                        String tagStr = (view.getTag() != null) ? view.getTag().toString() : "";
                        
                        // [FIX] Separate settings for Music Components to prevent clipping
                        boolean isMusicComponent = tagStr.contains("type_song_2line")
                                || tagStr.contains("type_song_cover")
                                || tagStr.contains("type_song_1line");

                        if (isMusicComponent) {
                            // 单独设置：歌曲组件强制 margin 为 0，防止贴边裁剪
                             offsetTop = 0;
                             offsetBottom = 0;
                        } else if (tagStr.contains("type_guide_line")) {
                            newY = 0; // Force Top to 0

                            // Update Coordinate Text
                            if (view instanceof android.view.ViewGroup) {
                                android.view.ViewGroup vg = (android.view.ViewGroup) view;
                                for (int k = 0; k < vg.getChildCount(); k++) {
                                    View child = vg.getChildAt(k);
                                    if (child instanceof TextView) {
                                        // Center of the line is newX + width/2.
                                        // The container is 100px wide. Center is +50.
                                        int centerX = (int) (newX + view.getWidth() / 2f);
                                        ((TextView) child).setText("" + centerX);
                                    }
                                }
                            }
                        } else if (view instanceof TextView) {
                            float scaledTextSize = ((TextView) view).getTextSize() * view.getScaleY();
                            offsetTop = scaledTextSize * FACTOR_TOP;
                            offsetBottom = scaledTextSize * FACTOR_BOTTOM;
                        } else if (view instanceof android.widget.LinearLayout) {
                            // [FIX] Handle LinearLayout (e.g., Fuel, Song)
                            android.widget.LinearLayout ll = (android.widget.LinearLayout) view;
                            if (ll.getChildCount() > 0) {
                                // Default to first child
                                View child = ll.getChildAt(0);
                                // For Fuel/FuelRange, value is at index 1 (48px), Emoji at 0 (36px).
                                // We want the larger one (Value) or just be consistent.
                                if (ll.getChildCount() > 1 && ll.getChildAt(1) instanceof TextView) {
                                    child = ll.getChildAt(1);
                                }

                                if (child instanceof TextView) {
                                    float scaledTextSize = ((TextView) child).getTextSize() * view.getScaleY();
                                    offsetTop = scaledTextSize * FACTOR_TOP;
                                    offsetBottom = scaledTextSize * FACTOR_BOTTOM;
                                }
                            }
                        }

                        if (newY < -offsetTop)
                            newY = -offsetTop;
                        // Bottom Bound: Parent Height + Offset (so bottom of view can go below parent)
                        if (newY + viewHeight > parentHeight + offsetBottom)
                            newY = parentHeight - viewHeight + offsetBottom;

                        // [REMOVED] Collision Detection - Now allowing overlapping
                        // if (wouldOverlap(view, newX, newY, viewWidth, viewHeight)) {
                        // return true;
                        // }

                        view.setX(newX);
                        view.setY(newY);

                        // 更新缩放手柄位置
                        if (mResizeHandle != null && view == mHudTestComponent) {
                            updateResizeHandlePosition(mResizeHandle, view, 24);
                        }

                        // Real-time Sync
                        syncAllHudComponents();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    // [NEW] Check if moving view to newX,newY would overlap with any other
    // component
    private boolean wouldOverlap(View movingView, float newX, float newY, int width, int height) {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return false;

        android.graphics.RectF movingRect = new android.graphics.RectF(
                newX, newY, newX + width, newY + height);

        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);
            if (child == movingView)
                continue; // Skip self
            if (child == mResizeHandle)
                continue; // 跳过缩放手柄
            if (child.getTag() == null)
                continue; // Skip non-components

            // 使用缩放后的尺寸
            float childW = child.getWidth() * child.getScaleX();
            float childH = child.getHeight() * child.getScaleY();
            android.graphics.RectF childRect = new android.graphics.RectF(
                    child.getX(), child.getY(),
                    child.getX() + childW,
                    child.getY() + childH);

            if (android.graphics.RectF.intersects(movingRect, childRect)) {
                return true; // Would overlap
            }
        }
        return false;
    }

    private void syncAllHudComponents() {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;
        List<ClusterHudManager.HudComponentData> list = new ArrayList<>();
        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);

            // 跳过缩放手柄
            if (child == mResizeHandle)
                continue;

            Object tagObj = child.getTag();
            if (!(tagObj instanceof String))
                continue;
            String tag = (String) tagObj;
            if (tag == null || !tag.startsWith("type_"))
                continue;

            String rawType = tag.replace("type_", "");
            String type = rawType.contains(":") ? rawType.substring(0, rawType.indexOf(":")) : rawType;
            String text = "";

            if (child instanceof TextView) {
                if ("time".equals(type)) {
                    // For time component, always save the format string, regardless of preview text
                    text = "HH:mm";
                } else {
                    text = (child instanceof android.widget.TextClock)
                            ? ((android.widget.TextClock) child).getFormat12Hour().toString()
                            : ((TextView) child).getText().toString();
                }
            } else if (child instanceof android.widget.LinearLayout) {
                // Extract Title and Artist for Media Info
                android.widget.LinearLayout ll = (android.widget.LinearLayout) child;
                String title = "";
                String artist = "";
                if (ll.getChildCount() > 0 && ll.getChildAt(0) instanceof TextView)
                    title = ((TextView) ll.getChildAt(0)).getText().toString();
                if (ll.getChildCount() > 1 && ll.getChildAt(1) instanceof TextView)
                    artist = ((TextView) ll.getChildAt(1)).getText().toString();
                if (!artist.isEmpty()) {
                    text = title + "\n" + artist;
                } else {
                    text = title;
                }
            } else if (child instanceof ImageView) {
                // Image has no text value to sync, but we need the entry
                text = "";
            }

            int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF;
            ClusterHudManager.HudComponentData data = new ClusterHudManager.HudComponentData(
                    type,
                    text,
                    child.getX() * 0.5f,
                    child.getY() * 0.5f,
                    color);
            // 同步缩放值
            if (tag.contains(":scale_")) {
                try {
                    String val = tag.substring(tag.indexOf(":scale_") + 7);
                    data.scale = Float.parseFloat(val);
                } catch (Exception e) {
                    data.scale = child.getScaleX();
                }
            } else {
                data.scale = child.getScaleX();
            }
            list.add(data);
        }
        ClusterHudManager.getInstance(this).syncHudLayout(list);
    }

    private void updateHudModeButton() {
        Button btn = findViewById(R.id.btnHudSwitchMode);
        if (btn != null) {
            // Button shows text for the OTHER mode (action to switch TO)
            // Or just current status? User request:
            // "Default: 'Switch AR Mode' (meaning currently WHUD)"
            // "When clicked: 'Switch WHUD Mode' (meaning currently AR)"
            if (mHudMode == MODE_WHUD) {
                btn.setText("切换AR模式");
            } else {
                btn.setText("切换WHUD模式");
            }
        }
    }

    private void showAddHudComponentDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("选择组件类型");

        // Root Container: Horizontal
        android.widget.LinearLayout root = new android.widget.LinearLayout(this);
        root.setOrientation(android.widget.LinearLayout.HORIZONTAL);
        root.setPadding(32, 16, 32, 16);

        // Sub-containers (Columns)
        android.widget.LinearLayout colBasic = new android.widget.LinearLayout(this);
        colBasic.setOrientation(android.widget.LinearLayout.VERTICAL);
        android.widget.LinearLayout.LayoutParams lpBasic = new android.widget.LinearLayout.LayoutParams(0,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
        lpBasic.weight = 1;
        colBasic.setLayoutParams(lpBasic);

        android.widget.LinearLayout colDrive = new android.widget.LinearLayout(this);
        colDrive.setOrientation(android.widget.LinearLayout.VERTICAL);
        android.widget.LinearLayout.LayoutParams lpDrive = new android.widget.LinearLayout.LayoutParams(0,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
        lpDrive.weight = 1;
        colDrive.setLayoutParams(lpDrive);

        // New Column: Navigation
        android.widget.LinearLayout colNavi = new android.widget.LinearLayout(this);
        colNavi.setOrientation(android.widget.LinearLayout.VERTICAL);
        android.widget.LinearLayout.LayoutParams lpNavi = new android.widget.LinearLayout.LayoutParams(0,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
        lpNavi.weight = 1;
        colNavi.setLayoutParams(lpNavi);

        android.widget.LinearLayout colMedia = new android.widget.LinearLayout(this);
        colMedia.setOrientation(android.widget.LinearLayout.VERTICAL);
        android.widget.LinearLayout.LayoutParams lpMedia = new android.widget.LinearLayout.LayoutParams(0,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
        lpMedia.weight = 1;
        colMedia.setLayoutParams(lpMedia);

        // Add Headers (Center-aligned to match buttons)
        android.widget.TextView h1 = new android.widget.TextView(this);
        h1.setText("基本信息");
        h1.setTypeface(null, android.graphics.Typeface.BOLD);
        h1.setPadding(0, 0, 0, 16);
        h1.setGravity(android.view.Gravity.CENTER);
        colBasic.addView(h1);
        android.widget.TextView h2 = new android.widget.TextView(this);
        h2.setText("行驶数据");
        h2.setTypeface(null, android.graphics.Typeface.BOLD);
        h2.setPadding(0, 0, 0, 16);
        h2.setGravity(android.view.Gravity.CENTER);
        colDrive.addView(h2);
        android.widget.TextView h4 = new android.widget.TextView(this);
        h4.setText("导航信息");
        h4.setTypeface(null, android.graphics.Typeface.BOLD);
        h4.setPadding(0, 0, 0, 16);
        h4.setGravity(android.view.Gravity.CENTER);
        colNavi.addView(h4);
        android.widget.TextView h3 = new android.widget.TextView(this);
        h3.setText("媒体信息");
        h3.setTypeface(null, android.graphics.Typeface.BOLD);
        h3.setPadding(0, 0, 0, 16);
        h3.setGravity(android.view.Gravity.CENTER);
        colMedia.addView(h3);

        root.addView(colBasic);
        root.addView(colDrive);
        root.addView(colNavi);
        root.addView(colMedia);

        final android.app.AlertDialog[] dialogHolder = new android.app.AlertDialog[1];

        // Helper to add button
        TriConsumer<android.widget.LinearLayout, String, String> addButton = (parent, text, type) -> {
            Button btn = new Button(this);
            btn.setText(text);
            btn.setTextSize(12);
            btn.setPadding(8, 8, 8, 8);
            android.widget.LinearLayout.LayoutParams params = new android.widget.LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 4, 4, 4);
            btn.setLayoutParams(params);

            btn.setOnClickListener(v -> {
                // [FIX] Prevent duplicate components
                if (isHudComponentAdded(type)) {
                    DebugLogger.toast(this, "组件已存在");
                    return;
                }

                // Logic based on type
                if ("time".equals(type))
                    addHudTimeComponent();
                else if ("fuel".equals(type))
                    createAndAddHudComponent("fuel", "⛽ --L", 0, 0);
                else if ("temp_in".equals(type))
                    createAndAddHudComponent("temp_in", "--.0°C", 0, 0); // [FIX] Decimal format to match real HUD
                else if ("temp_out".equals(type))
                    createAndAddHudComponent("temp_out", "--.0°C", 0, 0); // [FIX] Decimal format to match real HUD
                else if ("range".equals(type))
                    createAndAddHudComponent("range", "--km", 0, 0);
                else if ("fuel_range".equals(type))
                    createAndAddHudComponent("fuel_range", "⛽ --L|--km", 0, 0);
                else if ("gear".equals(type))
                    createAndAddHudComponent("gear", "-", 0, 0); // [FIX] Use placeholder, real data comes from sensor
                else if ("turn_signal".equals(type))
                    createAndAddHudComponent("turn_signal", "←      →", 0, 0);
                else if ("auto_hold".equals(type))
                    createAndAddHudComponent("auto_hold", "A", 0, 0);
                else if ("volume".equals(type))
                    createAndAddHudComponent("volume", "音量: --", 0, 0);
                else if ("song_cover".equals(type))
                    createAndAddHudComponent("song_cover", "", 0, 0);
                else if ("song_2line".equals(type)) {
                    createAndAddHudComponent("song_2line", "等待通知数据...", 0, 0);
                    sendBroadcast(new android.content.Intent(
                            cn.navitool.service.MediaNotificationListener.ACTION_REQUEST_MEDIA_REBROADCAST));
                } else if ("song_1line".equals(type)) {
                    createAndAddHudComponent("song_1line", "歌曲标题", 0, 0);
                    // Trigger update
                    sendBroadcast(new android.content.Intent(
                            cn.navitool.service.MediaNotificationListener.ACTION_REQUEST_MEDIA_REBROADCAST));
                } else if ("traffic_light".equals(type)) {
                    createAndAddHudComponent("traffic_light", "红绿灯组件", 0, 0);
                } else if ("navi_arrival_time".equals(type)) {
                    createAndAddHudComponent("navi_arrival_time", "12:30", 0, 0);
                } else if ("navi_distance_remaining".equals(type)) {
                    createAndAddHudComponent("navi_distance_remaining", "8.5km", 0, 0);
                } else if ("guide_line".equals(type)) {
                    createAndAddHudComponent("guide_line", "X:0", 0, 0);
                } else if ("hud_rpm".equals(type)) {
                    createAndAddHudComponent("hud_rpm", "0rpm", 0, 0);
                }

                syncAllHudComponents();
                if (dialogHolder[0] != null)
                    dialogHolder[0].dismiss();
            });
            parent.addView(btn);
        };

        // Group 1: Basic
        addButton.accept(colBasic, "系统时间", "time");
        addButton.accept(colBasic, "车内温度", "temp_in");
        addButton.accept(colBasic, "车外温度", "temp_out");
        addButton.accept(colBasic, "辅助线", "guide_line");

        // Group 2: Driving
        addButton.accept(colDrive, "剩余油量", "fuel");
        addButton.accept(colDrive, "续航里程", "range");
        addButton.accept(colDrive, "油量续航", "fuel_range");
        addButton.accept(colDrive, "档位信息", "gear");
        addButton.accept(colDrive, "转向信号", "turn_signal");
        addButton.accept(colDrive, "转速信息", "hud_rpm");
        // [DISABLED] Auto Hold 功能由于系统限制暂无法实现，后期如找到方法可取消注释
        // addButton.accept(colDrive, "Auto Hold", "auto_hold");

        // Group 3: Navigation (New)
        addButton.accept(colNavi, "导航红绿灯", "traffic_light");
        addButton.accept(colNavi, "到达时间", "navi_arrival_time");
        addButton.accept(colNavi, "剩余里程", "navi_distance_remaining");

        // Group 4: Media
        addButton.accept(colMedia, "歌曲信息（2行）", "song_2line");
        addButton.accept(colMedia, "歌曲信息（1行）", "song_1line");
        addButton.accept(colMedia, "歌曲封面", "song_cover");
        addButton.accept(colMedia, "系统音量", "volume");

        builder.setView(root);
        dialogHolder[0] = builder.create();
        dialogHolder[0].show();
    }

    // Helper Interface for TriConsumer (since Java 8 doesn't have it standard, and
    // I can't easily rely on external libs)
    // Actually, I can just define a functional interface here or use a class.
    // Or just use a local class.
    @FunctionalInterface
    interface TriConsumer<T, U, V> {
        void accept(T t, U u, V v);
    }

    // Check if component already exists in Preview
    private boolean isHudComponentAdded(String type) {
        // if ("test_media".equals(type)) return false; // Removed to prevent duplicates
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            for (int i = 0; i < preview.getChildCount(); i++) {
                View child = preview.getChildAt(i);
                Object tag = child.getTag();
                if (tag != null && tag.toString().equals("type_" + type)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Removed addHudTestComponent()

    private void addHudTimeComponent() {
        createAndAddHudComponent("time", "HH:mm", 0, 0);
        syncAllHudComponents();
    }

    private void lockHudComponent() {
        // Clear selection visual
        clearHudSelection();
        // Save current layout to Config
        saveCurrentHudLayout(mHudMode);
        mIsHudComponentLocked = true;
        // [FIX] Sync to real HUD after save
        reloadHudConfigToManager(mHudMode);
        DebugLogger.toast(this, "布局已保存");
    }

    private void unlockHudComponent() {
        mIsHudComponentLocked = false;
        DebugLogger.toast(this, "组件已解锁 (可拖拽)");
    }

    private void resetHudComponent() {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            preview.removeAllViews();
        }
        mHudTestComponent = null;
        mIsHudComponentLocked = false;

        // Clear in Config
        String key = (mHudMode == MODE_WHUD) ? "hud_layout_whud" : "hud_layout_ar";
        ConfigManager.getInstance().setString(key, "[]");

        // Clear Real HUD
        ClusterHudManager.getInstance(this).clearHudComponents();

        DebugLogger.toast(this, "布局已重置");
    }

    private void deleteSelectedHudComponent() {
        if (mHudTestComponent == null) {
            DebugLogger.toast(this, "请先选择要删除的组件");
            return;
        }

        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            preview.removeView(mHudTestComponent);
            mHudTestComponent = null;
            syncAllHudComponents();
            DebugLogger.toast(this, "组件已删除");
        }
    }

    private void highlightSelectedComponent(View selected) {
        if (selected == null)
            return;
        View parent = (View) selected.getParent();
        if (parent instanceof android.view.ViewGroup) {
            android.view.ViewGroup group = (android.view.ViewGroup) parent;
            for (int i = 0; i < group.getChildCount(); i++) {
                View child = group.getChildAt(i);
                child.setAlpha(1.0f); // Reset
            }
        }
        selected.setAlpha(0.6f); // Highlight

        // 显示缩放手柄
        showResizeHandle(selected);
    }

    private void showResizeHandle(View target) {
        // 移除旧的缩放手柄
        removeResizeHandle();

        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null || target == null)
            return;

        // 创建带斜线的缩放手柄
        View handle = new View(this) {
            @Override
            protected void onDraw(android.graphics.Canvas canvas) {
                super.onDraw(canvas);
                android.graphics.Paint paint = new android.graphics.Paint();
                paint.setColor(android.graphics.Color.WHITE);
                paint.setStrokeWidth(2);
                paint.setAntiAlias(true);

                int w = getWidth();
                int h = getHeight();
                // 绘制两条斜线
                canvas.drawLine(w * 0.3f, h, w, h * 0.3f, paint);
                canvas.drawLine(w * 0.6f, h, w, h * 0.6f, paint);
            }
        };

        int handleSize = 24;
        android.widget.FrameLayout.LayoutParams handleParams = new android.widget.FrameLayout.LayoutParams(handleSize,
                handleSize);
        handleParams.gravity = android.view.Gravity.TOP | android.view.Gravity.START;

        // 透明背景
        handle.setBackgroundColor(android.graphics.Color.TRANSPARENT);

        // 定位到目标组件的右下角
        updateResizeHandlePosition(handle, target, handleSize);

        // 设置缩放手势
        setupResizeHandleTouch(handle, target);

        preview.addView(handle, handleParams);
        mResizeHandle = handle;
    }

    // 更新缩放手柄位置到目标组件右下角
    private void updateResizeHandlePosition(View handle, View target, int handleSize) {
        if (handle == null || target == null)
            return;

        // 设置缩放中心点为左上角 (0, 0)，这样缩放时组件位置不变
        target.setPivotX(0);
        target.setPivotY(0);

        // 计算组件右下角位置
        float handleX = target.getX() + (target.getWidth() * target.getScaleX()) - handleSize / 2f;
        float handleY = target.getY() + (target.getHeight() * target.getScaleY()) - handleSize / 2f;
        handle.setX(handleX);
        handle.setY(handleY);
    }

    private void removeResizeHandle() {
        if (mResizeHandle != null) {
            android.view.ViewGroup parent = (android.view.ViewGroup) mResizeHandle.getParent();
            if (parent != null) {
                parent.removeView(mResizeHandle);
            }
            mResizeHandle = null;
        }
    }

    private void setupResizeHandleTouch(View handle, View target) {
        handle.setOnTouchListener(new View.OnTouchListener() {
            float startX, startY;
            float startScale;
            boolean isTurnSignal;

            @Override
            public boolean onTouch(View v, android.view.MotionEvent event) {
                if (mIsHudComponentLocked)
                    return false;

                Object tagObj = target.getTag();
                String tagStr = (tagObj instanceof String) ? (String) tagObj : "";
                isTurnSignal = tagStr.contains("turn_signal");

                switch (event.getAction()) {
                    case android.view.MotionEvent.ACTION_DOWN:
                        startX = event.getRawX();
                        startY = event.getRawY();
                        if (isTurnSignal) {
                            // Extract logical scale from Tag
                            startScale = 1.0f;
                            if (tagStr.contains(":scale_")) {
                                try {
                                    String val = tagStr.substring(tagStr.indexOf(":scale_") + 7);
                                    startScale = Float.parseFloat(val);
                                } catch (Exception e) {
                                }
                            }
                        } else {
                            startScale = target.getScaleX();
                        }
                        return true;

                    case android.view.MotionEvent.ACTION_MOVE:
                        // [FIX] Disable Scaling for Volume AND Guide Line
                        if (tagStr != null && (tagStr.contains("type_volume") || tagStr.contains("type_guide_line"))) {
                            return true;
                        }

                        float deltaX = event.getRawX() - startX;
                        float deltaY = event.getRawY() - startY;

                        float newScale;

                        if (isTurnSignal) {
                            // [FIX] 1:1 Sensitivity for Turn Signal (Horizontal Only)
                            // Width = 144 + 90 * scale => DeltaWidth = 90 * deltaScale
                            // We want DeltaWidth == deltaX, so deltaScale = deltaX / 90
                            newScale = startScale + (deltaX / 90f);

                            // [FIX] Specific Limit for Turn Signal (User requested 15.0)
                            newScale = Math.max(0.3f, Math.min(15.0f, newScale));

                            // Update Tag
                            String baseTag = tagStr.split(":")[0];
                            target.setTag(baseTag + ":scale_" + newScale);

                            // [FIX] Immediate Visual Feedback
                            android.graphics.Bitmap dynamicBmp = ClusterHudManager.getInstance(MainActivity.this)
                                    .getTurnSignalBitmap(true, true, newScale);

                            // [FIX] Apply Center Overlay Line for Preview Alignment
                            if (dynamicBmp != null) {
                                dynamicBmp = ClusterHudManager.getInstance(MainActivity.this)
                                        .addCenterLineOverlay(dynamicBmp);
                            }

                            if (dynamicBmp != null && target instanceof android.widget.ImageView) {
                                ((android.widget.ImageView) target).setImageBitmap(dynamicBmp);
                            }

                            // [FIX] Calculate Expected Width for Handle Position
                            float expectedWidth = 144 + (90 * newScale);
                            float handleX = target.getX() + expectedWidth - v.getWidth() / 2f;
                            float handleY = target.getY() + 72 - v.getHeight() / 2f;
                            v.setX(handleX);
                            v.setY(handleY);
                        } else {
                            // Standard Scaling Logic for other components

                            // [FIX] Visual Edge 1:1 Strategy (Option D)
                            // Goal: 1:1 Finger Tracking for the Edge
                            // Logic: NewScale = StartScale + (EffectiveDelta / BaseWidth)
                            float baseWidth = target.getWidth() > 0 ? target.getWidth() : 100f;

                            // Use the larger movement direction to determine the effective change
                            float effectiveDelta = (Math.abs(deltaX) > Math.abs(deltaY)) ? deltaX : deltaY;

                            newScale = startScale + (effectiveDelta / baseWidth);

                            // [FIX] Standard Limit 3.0
                            newScale = Math.max(0.3f, Math.min(3.0f, newScale));

                            // Standard Scaling
                            View parent = (View) target.getParent();
                            if (parent != null) {
                                // ... (Boundary checks omitted for brevity in logic change, reliance on visual
                                // feedback) ...
                            }
                            target.setScaleX(newScale);
                            target.setScaleY(newScale);

                            // 更新手柄位置 - 使用统一方法
                            updateResizeHandlePosition(v, target, v.getWidth());
                        }

                        // 实时同步
                        syncAllHudComponents();
                        return true;

                    case android.view.MotionEvent.ACTION_UP:
                        return true;
                }
                return false;
            }
        });
    }

    private void clearHudSelection() {
        mHudTestComponent = null;
        removeResizeHandle(); // 清除缩放手柄
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            for (int i = 0; i < preview.getChildCount(); i++) {
                View child = preview.getChildAt(i);
                child.setAlpha(1.0f);
            }
        }
    }

    // --- Cluster Editor Logic ---

    // --- Cluster Theme Selector Logic ---

    private String mSelectedClusterTheme = "1";

    private void setupClusterThemeSelector() {
        // Setup Import Button
        Button btnImport = findViewById(R.id.btnImportTheme);
        if (btnImport != null) {
            btnImport.setOnClickListener(v -> importThemes());
        }

        // Load saved theme
        mSelectedClusterTheme = ConfigManager.getInstance().getString("cluster_theme_id", "1");

        // Initial Theme List Refresh
        refreshClusterThemeList();

        // Setup Audi RS built-in theme handlers
        // This also applies the saved theme on startup
        setupAudiRsThemeHandlers();

        // Note: applyClusterTheme removed - now using setClusterTheme in
        // setupAudiRsThemeHandlers

        // Ensure cluster is shown if previously enabled
        boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("is_cluster_enabled", false);

        // [FIX] Setup Toggle Switch Logic
        com.google.android.material.switchmaterial.SwitchMaterial switchCluster = findViewById(R.id.switchCluster);
        View layoutContent = findViewById(R.id.layoutClusterContent);

        if (switchCluster != null) {
            switchCluster.setChecked(isClusterEnabled);
            if (layoutContent != null) {
                layoutContent.setVisibility(isClusterEnabled ? View.VISIBLE : View.GONE);
            }

            switchCluster.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("is_cluster_enabled", isChecked);
                if (layoutContent != null) {
                    layoutContent.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                }

                // Toggle Actual Cluster
                ClusterHudManager.getInstance(this).setClusterEnabled(isChecked);
                if (isChecked) {
                    DebugLogger.toast(this, "仪表已开启");
                } else {
                    DebugLogger.toast(this, "仪表已关闭");
                }
            });
        } else {
            // Fallback for logic if switch not found (shouldn't happen with correct layout)
            if (isClusterEnabled) {
                ClusterHudManager.getInstance(this).setClusterEnabled(false);
                ClusterHudManager.getInstance(this).setClusterEnabled(true);
            }
        }

        // Test Button Logic (Preserved)
        if (findViewById(R.id.btnClusterTestSpeed) != null) {
            findViewById(R.id.btnClusterTestSpeed).setOnClickListener(v -> {
                DebugLogger.toast(this, "Simulating Speed...");
                new Thread(() -> {
                    DebugLogger.d("MN_Tag", "Starting Speed Simulation");
                    for (int i = 0; i <= 270; i += 1) {
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                        final int speed = i;
                        runOnUiThread(() -> ClusterHudManager.getInstance(this).updateSpeed(speed));
                    }
                    for (int i = 260; i >= 0; i -= 1) {
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                        final int speed = i;
                        runOnUiThread(() -> ClusterHudManager.getInstance(this).updateSpeed(speed));
                    }
                    DebugLogger.d("MN_Tag", "Speed Simulation Complete");
                }).start();
            });
        }

        if (findViewById(R.id.btnClusterTestRpm) != null) {
            findViewById(R.id.btnClusterTestRpm).setOnClickListener(v -> {
                new Thread(() -> {
                    for (int i = 0; i <= 8000; i += 50) {
                        final int rpm = i;
                        runOnUiThread(() -> ClusterHudManager.getInstance(this).updateRpm(rpm));
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                    }
                    for (int i = 8000; i >= 0; i -= 50) {
                        final int rpm = i;
                        runOnUiThread(() -> ClusterHudManager.getInstance(this).updateRpm(rpm));
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                    }
                }).start();
            });
        }

        // 档位切换按钮
        if (findViewById(R.id.btnClusterTestGear) != null) {
            findViewById(R.id.btnClusterTestGear).setOnClickListener(v -> {
                ClusterHudManager.getInstance(this).cycleGear();
            });
        }
    }

    private void refreshClusterThemeList() {
        LinearLayout container = findViewById(R.id.layoutThemeContainer);
        if (container == null)
            return;

        // Keep the first 2 children (Default Style 1 and Audi RS)
        int childCount = container.getChildCount();
        if (childCount > 2) {
            container.removeViews(2, childCount - 2);
        }

        // Setup Default Item (index 0)
        View defaultItem = container.getChildAt(0);
        if (defaultItem != null) {
            defaultItem.setTag("1"); // Tag with ID
            defaultItem.setOnClickListener(v -> selectClusterTheme("1"));
        }

        // Audi RS Item (index 1) - click handler is set in setupAudiRsThemeHandlers()
        // Tag it for identification
        View audiRsItem = container.getChildAt(1);
        if (audiRsItem != null) {
            audiRsItem.setTag("audi_rs");
            // [UI Fix] Use specific preview image for Audi RS to resolve visibility issues

            // Optional: If it's a ViewGroup, try to hide the text if the image contains it?
            // User only asked to use the image.

            // Adjust transparency/scaling if needed, but resource is usually scaled to fit.
        }

        // Style 2 removed - replaced by Audi RS theme

        // Add Imported Themes only
        List<String> importedThemes = CustomThemeManager.getInstance(this).getImportedThemes();
        for (String themeName : importedThemes) {
            View itemView = createThemeItemView(themeName);
            container.addView(itemView);
        }

        updateClusterThemeUI();
    }

    private View createThemeItemView(String themeName) {
        // Programmatically create similar structure to XML
        FrameLayout layout = new FrameLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(480, 180); // px dimensions from XML
        params.setMarginEnd(32); // 16dp roughly
        layout.setLayoutParams(params);
        layout.setBackgroundResource(R.drawable.bg_cluster_normal);
        layout.setClickable(true);
        layout.setFocusable(true);
        layout.setTag(themeName);
        layout.setOnClickListener(v -> selectClusterTheme(themeName));

        TextView tv = new TextView(this);
        tv.setText(themeName);
        tv.setTextColor(android.graphics.Color.parseColor("#CCCCCC"));
        FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        tvParams.gravity = android.view.Gravity.CENTER;
        layout.addView(tv, tvParams);

        ImageView ivCheck = new ImageView(this);
        ivCheck.setImageResource(R.drawable.ic_check);
        ivCheck.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
        ivCheck.setVisibility(View.GONE);
        FrameLayout.LayoutParams ivParams = new FrameLayout.LayoutParams(48, 48); // 24dp
        ivParams.gravity = android.view.Gravity.TOP | android.view.Gravity.END;
        ivParams.setMargins(16, 16, 16, 16); // 8dp
        layout.addView(ivCheck, ivParams);

        return layout;
    }

    private void importThemes() {
        List<String> available = CustomThemeManager.getInstance(this).getAvailableExternalThemes();
        if (available.isEmpty()) {
            DebugLogger.toast(this, "未找到可用主题 (SD/Monjaro/NaviTool/Themes)");
            return;
        }

        String[] themes = available.toArray(new String[0]);
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("选择要导入的主题")
                .setItems(themes, (dialog, which) -> {
                    String selected = themes[which];
                    boolean success = CustomThemeManager.getInstance(this).importTheme(selected);
                    if (success) {
                        DebugLogger.toast(this, "导入成功: " + selected);
                        refreshClusterThemeList();
                    } else {
                        DebugLogger.toast(this, "导入失败");
                    }
                })
                .show();
    }

    private void selectClusterTheme(String themeId) {
        mSelectedClusterTheme = themeId;
        ConfigManager.getInstance().setString("cluster_theme_id", themeId);
        updateClusterThemeUI();

        // Notify Manager
        ClusterHudManager.getInstance(this).applyClusterTheme(themeId);
        DebugLogger.toast(this, "已切换至: " + themeId);
    }

    private void updateClusterThemeUI() {
        LinearLayout container = findViewById(R.id.layoutThemeContainer);
        if (container == null)
            return;

        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);

            // Skip Audi RS theme (index 1) - it has separate checkmark handling
            if (i == 1) {
                continue;
            }

            Object tag = child.getTag();
            String id = tag != null ? tag.toString() : "";

            // Find checkmark (last child ImageView in our views)
            ImageView checkmark = null;
            if (child instanceof FrameLayout) {
                FrameLayout frame = (FrameLayout) child;
                // Try to find the checkmark by checking all children
                for (int j = 0; j < frame.getChildCount(); j++) {
                    View v = frame.getChildAt(j);
                    if (v instanceof ImageView && v.getId() == R.id.ivClusterCheck1) {
                        checkmark = (ImageView) v;
                        break;
                    }
                }
                // Fallback for programmatic views (checkmark is usually last)
                if (checkmark == null && frame.getChildCount() > 1) {
                    View lastChild = frame.getChildAt(frame.getChildCount() - 1);
                    if (lastChild instanceof ImageView) {
                        checkmark = (ImageView) lastChild;
                    }
                }
            }

            updateThemeItem(child, checkmark, mSelectedClusterTheme.equals(id));
        }
    }

    private void updateThemeItem(View container, View checkmark, boolean isSelected) {
        if (container == null)
            return;
        if (isSelected) {
            container.setBackgroundResource(R.drawable.bg_cluster_selected);
            if (checkmark != null)
                checkmark.setVisibility(View.VISIBLE);
        } else {
            container.setBackgroundResource(R.drawable.bg_cluster_normal);
            if (checkmark != null)
                checkmark.setVisibility(View.GONE);
        }
    }

    private void updateDebugViewsVisibility(boolean isDebug) {
        // Strictly enforce that these views are ONLY visible in Debug builds
        // regardless of the stored preference (which handles the switch state)
        boolean allowDebugViews = isDebug && BuildConfig.DEBUG;
        int visibility = allowDebugViews ? View.VISIBLE : View.GONE;

        // Third Party Test Button (in layout_tab_buttons.xml)
        // View btnTestThirdParty = findViewById(R.id.btnTestThirdPartyControl);
        // if (btnTestThirdParty != null) {
        // btnTestThirdParty.setVisibility(visibility);
        // }

        View layoutPsdTest = findViewById(R.id.layoutPsdTestButtons);
        if (layoutPsdTest != null) {
            layoutPsdTest.setVisibility(visibility);
        }

        // Headlight Status

        // System Info & Screenshots

        // System Info (Boot Time, PSD Status)
        View layoutSystemInfo = findViewById(R.id.layoutSystemInfo);
        if (layoutSystemInfo != null) {
            layoutSystemInfo.setVisibility(visibility);
        } else {
            View tvBootTime = findViewById(R.id.tvBootTime);
            if (tvBootTime != null)
                tvBootTime.setVisibility(visibility);
            View tvPsdStatus = findViewById(R.id.tvPsdStatus);
            if (tvPsdStatus != null)
                tvPsdStatus.setVisibility(visibility);
        }
    }

    // --- Theme Tab Logic ---

    private void setupSoundSwitches() {
        // Master Switch
        SwitchMaterial switchMaster = findViewById(R.id.switchSoundMaster);
        View layoutSoundContent = findViewById(R.id.layoutSoundContent);

        if (switchMaster != null) {
            // Default to TRUE to maintain backward compatibility
            boolean isMaster = ConfigManager.getInstance().getBoolean("sound_master_enabled", true);
            switchMaster.setChecked(isMaster);

            // [FIX] Initial Visibility
            View layoutSoundHeaderOptions = findViewById(R.id.layoutSoundHeaderOptions);
            int v = isMaster ? View.VISIBLE : View.GONE;
            
            if (layoutSoundContent != null) {
                layoutSoundContent.setVisibility(v);
            }
            if (layoutSoundHeaderOptions != null) {
                layoutSoundHeaderOptions.setVisibility(v);
            }

            switchMaster.setOnCheckedChangeListener((vSwitch, isChecked) -> {
                ConfigManager.getInstance().setBoolean("sound_master_enabled", isChecked);
                // [FIX] Toggle Visibility
                int newVisibility = isChecked ? View.VISIBLE : View.GONE;
                if (layoutSoundContent != null) {
                    layoutSoundContent.setVisibility(newVisibility);
                }
                if (layoutSoundHeaderOptions != null) {
                    layoutSoundHeaderOptions.setVisibility(newVisibility);
                }
            });
        }

        // Playback Mode Selection
        android.widget.RadioGroup rgMode = findViewById(R.id.rgSoundPlaybackMode);
        if (rgMode != null) {
            boolean isDirect = ConfigManager.getInstance().getBoolean("sound_playback_mode_direct", false);
            rgMode.check(isDirect ? R.id.rbSoundModeDirect : R.id.rbSoundModeMix);

            // Sync initial state to Manager
            cn.navitool.managers.SoundPromptManager.getInstance(this).setPlaybackMode(isDirect);

            rgMode.setOnCheckedChangeListener((group, checkedId) -> {
                boolean direct = (checkedId == R.id.rbSoundModeDirect);
                ConfigManager.getInstance().setBoolean("sound_playback_mode_direct", direct);
                cn.navitool.managers.SoundPromptManager.getInstance(this).setPlaybackMode(direct);
            });
        }

        // Sound Channel Selection
        // [ECARX] 使用 ECARX 定义的通道值: CHANNEL_ENT=0 (媒体), CHANNEL_NAVI=1 (导航)
        android.widget.RadioGroup rgChannel = findViewById(R.id.rgSoundChannel);
        if (rgChannel != null) {
            // 默认使用导航通道 (CHANNEL_NAVI = 1)
            int savedChannel = ConfigManager.getInstance().getInt("sound_ecarx_channel",
                    cn.navitool.managers.SoundPromptManager.ECARX_CHANNEL_NAVI);
            rgChannel.check(savedChannel == cn.navitool.managers.SoundPromptManager.ECARX_CHANNEL_ENT
                    ? R.id.rbSoundChannelMedia
                    : R.id.rbSoundChannelNavi);

            // Sync initial state
            cn.navitool.managers.SoundPromptManager.getInstance(this).setEcarxChannel(savedChannel);

            rgChannel.setOnCheckedChangeListener((group, checkedId) -> {
                int channel = (checkedId == R.id.rbSoundChannelMedia)
                        ? cn.navitool.managers.SoundPromptManager.ECARX_CHANNEL_ENT
                        : cn.navitool.managers.SoundPromptManager.ECARX_CHANNEL_NAVI;
                ConfigManager.getInstance().setInt("sound_ecarx_channel", channel);
                cn.navitool.managers.SoundPromptManager.getInstance(this).setEcarxChannel(channel);
            });
        }

        // Sound Items (Refactored to use Card IDs)
        setupSoundItem(R.id.cardSoundStart, R.string.switch_sound_start, "sound_start");
        setupSoundItem(R.id.cardSoundGearD, R.string.switch_sound_gear_d, "sound_gear_d");
        setupSoundItem(R.id.cardSoundGearN, R.string.switch_sound_gear_n, "sound_gear_n");
        setupSoundItem(R.id.cardSoundGearR, R.string.switch_sound_gear_r, "sound_gear_r");
        setupSoundItem(R.id.cardSoundGearP, R.string.switch_sound_gear_p, "sound_gear_p");
        
        setupSoundItem(R.id.cardSoundDoorDriver, R.string.switch_sound_door_driver, "sound_door_driver");
        setupSoundItem(R.id.cardSoundDoorDriverClose, R.string.switch_sound_door_driver_close, "sound_door_driver_close");

        setupSoundItem(R.id.cardSoundDoorPassenger, R.string.switch_sound_door_passenger, "sound_door_passenger");
        setupSoundItem(R.id.cardSoundDoorPassengerClose, R.string.switch_sound_door_passenger_close, "sound_door_passenger_close");
        
        setupSoundItem(R.id.cardSoundDoorPassengerEmpty, R.string.switch_sound_door_passenger_empty, "sound_door_passenger_empty");
        setupSoundItem(R.id.cardSoundDoorPassengerEmptyClose, R.string.switch_sound_door_passenger_empty_close, "sound_door_passenger_empty_close");
        
        setupSoundItem(R.id.cardSoundDoorRearLeft, R.string.switch_sound_door_rear_left, "sound_door_rear_left");
        setupSoundItem(R.id.cardSoundDoorRearLeftClose, R.string.switch_sound_door_rear_left_close, "sound_door_rear_left_close");
        
        setupSoundItem(R.id.cardSoundDoorRearRight, R.string.switch_sound_door_rear_right, "sound_door_rear_right");
        setupSoundItem(R.id.cardSoundDoorRearRightClose, R.string.switch_sound_door_rear_right_close, "sound_door_rear_right_close");
        
        setupSoundItem(R.id.cardSoundDoorHood, R.string.switch_sound_door_hood, "sound_door_hood");
        setupSoundItem(R.id.cardSoundDoorHoodClose, R.string.switch_sound_door_hood_close, "sound_door_hood_close");
        
        setupSoundItem(R.id.cardSoundDoorTrunk, R.string.switch_sound_door_trunk, "sound_door_trunk");
        setupSoundItem(R.id.cardSoundDoorTrunkClose, R.string.switch_sound_door_trunk_close, "sound_door_trunk_close");

        configureTestButtonsVisibility();
    }

    private void setupSoundItem(int cardId, int titleResId, String keyPrefix) {
        android.view.View card = findViewById(cardId);
        if (card == null) return;

        TextView tvTitle = card.findViewById(R.id.tvSoundTitle);
        if (tvTitle != null) {
            tvTitle.setText(titleResId);
        }

        SwitchMaterial switchView = card.findViewById(R.id.switchSound);
        Button btnSelect = card.findViewById(R.id.btnSelectSound);
        Button btnTest = card.findViewById(R.id.btnTestSound);
        TextView tvFile = card.findViewById(R.id.tvSoundFile);
        
        String enabledKey = keyPrefix + "_enabled";
        String fileKey = keyPrefix + "_file";

        if (switchView != null) {
            switchView.setChecked(ConfigManager.getInstance().getBoolean(enabledKey, false));
            switchView.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean(enabledKey, isChecked);
            });
        }

        if (tvFile != null) {
            String selectedFile = ConfigManager.getInstance().getString(fileKey, null);
            tvFile.setText(selectedFile != null ? selectedFile : getString(R.string.text_default_sound));
        }

        if (btnSelect != null) {
            btnSelect.setOnClickListener(v -> showSoundFileSelector(fileKey, tvFile));
        }

        if (btnTest != null) {
            btnTest.setOnClickListener(
                    v -> testPlaySound(ConfigManager.getInstance().getString(fileKey, null), keyPrefix));
        }
    }

    private void showSoundFileSelector(String fileKey, TextView tvFile) {
        // Check and request storage permission at runtime
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            boolean hasRead = checkSelfPermission(
                    Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
            boolean hasWrite = checkSelfPermission(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
            if (!hasRead || !hasWrite) {
                requestPermissions(new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 200);
                android.widget.Toast.makeText(this, "权限申请中，同意后请重启APP生效", android.widget.Toast.LENGTH_LONG).show();
                return;
            }
        }

        // Standard path logic
        java.io.File soundDir = new java.io.File(Environment.getExternalStorageDirectory(), "NaviTool/Sound");

        DebugLogger.d("SoundSelector", "Path: " + soundDir.getAbsolutePath());

        // Initial check
        if (!soundDir.exists() || !soundDir.isDirectory()) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title_select_sound)
                    .setMessage(getString(R.string.dialog_no_files_message) + "\n\n路径: " + soundDir.getAbsolutePath())
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
            return;
        }

        // Try to list files
        java.io.File[] files = soundDir
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav"));

        // Debug
        DebugLogger.d("SoundSelector", "canRead: " + soundDir.canRead());
        DebugLogger.d("SoundSelector", "listFiles: " + (files != null ? files.length : "null"));

        if (files == null || files.length == 0) {
            String msg = getString(R.string.dialog_no_files_message) + "\n\n路径: " + soundDir.getAbsolutePath();

            if (!soundDir.canRead() || files == null) {
                msg += "\n\n【权限错误】无法读取文件列表。\n请尝试 >>彻底重启APP<< (关闭后台进程) 以刷新权限组。";
                msg += "\n(可读: " + soundDir.canRead() + ")";
            }

            // Also list ALL files in directory for debugging if it was just empty filter
            if (files != null && files.length == 0) {
                java.io.File[] allFiles = soundDir.listFiles();
                if (allFiles != null && allFiles.length > 0) {
                    msg += "\n\n检测到 " + allFiles.length + " 个非音频文件。";
                } else {
                    msg += "\n\n目录为空。";
                }
            }

            new android.app.AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title_select_sound)
                    .setMessage(msg)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
            return;
        }

        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }

        new android.app.AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title_select_sound)
                .setItems(fileNames, (dialog, which) -> {
                    String selectedFile = fileNames[which];
                    ConfigManager.getInstance().setString(fileKey, selectedFile);
                    if (tvFile != null) {
                        tvFile.setText(selectedFile);
                    }
                    android.widget.Toast.makeText(this, getString(R.string.toast_sound_selected, selectedFile),
                            android.widget.Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void testPlaySound(String filename, String keyPrefix) {
        String finalName = filename;
        if (finalName == null) {
            // Map default filenames based on keys
            if (keyPrefix.equals("sound_start"))
                finalName = "start.mp3";
            else if (keyPrefix.equals("sound_gear_d"))
                finalName = "gear_d.mp3";
            else if (keyPrefix.equals("sound_gear_n"))
                finalName = "gear_n.mp3";
            else if (keyPrefix.equals("sound_gear_r"))
                finalName = "gear_r.mp3";
            else if (keyPrefix.equals("sound_gear_p"))
                finalName = "gear_p.mp3";
            else if (keyPrefix.equals("sound_door_passenger"))
                finalName = "door_passenger.mp3";
        }

        final String resolvedName = finalName;
        java.io.File soundFile = new java.io.File(Environment.getExternalStorageDirectory(),
                "NaviTool/Sound/" + resolvedName);
        if (soundFile.exists()) {
            // [FIX] Use SoundPromptManager to ensure selected audio channel is respected
            cn.navitool.managers.SoundPromptManager.getInstance(this)
                    .playCustomSound(soundFile.getAbsolutePath());
            DebugLogger.d("MainActivity", "Test playing sound via SoundPromptManager: " + resolvedName);
        } else {
            DebugLogger.w("MainActivity", "Sound file not found for test: " + resolvedName);
            android.widget.Toast.makeText(this, "文件不存在: " + resolvedName, android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private void configureTestButtonsVisibility() {
        // Redundant method, logic moved to setupDebugSwitch and updateTestButtons
        // Calling updateTestButtons initial state here just in case
        updateTestButtons(DebugLogger.isDebugEnabled(this));
    }

    private void updateTestButtons(boolean isVisible) {
        // [Release] Always show test buttons per user feedback/testing
        // Or if we want to respect the debug flag:
        // int visibility = isVisible ? View.VISIBLE : View.GONE;
        int visibility = View.VISIBLE;
        
        int[] cardIds = {
            R.id.cardSoundStart,
            R.id.cardSoundGearD,
            R.id.cardSoundGearN,
            R.id.cardSoundGearR,
            R.id.cardSoundGearP,
            R.id.cardSoundDoorDriver,
            R.id.cardSoundDoorDriverClose,
            R.id.cardSoundDoorPassenger,
            R.id.cardSoundDoorPassengerClose,
            R.id.cardSoundDoorPassengerEmpty,
            R.id.cardSoundDoorPassengerEmptyClose,
            R.id.cardSoundDoorRearLeft,
            R.id.cardSoundDoorRearLeftClose,
            R.id.cardSoundDoorRearRight,
            R.id.cardSoundDoorRearRightClose,
            R.id.cardSoundDoorHood,
            R.id.cardSoundDoorHoodClose,
            R.id.cardSoundDoorTrunk,
            R.id.cardSoundDoorTrunkClose
        };

        for (int cardId : cardIds) {
            View card = findViewById(cardId);
            if (card != null) {
                View btnTest = card.findViewById(R.id.btnTestSound);
                if (btnTest != null) {
                    btnTest.setVisibility(visibility);
                }
            }
        }
    }

    private void setViewVisibility(int id, int visibility) {
        View v = findViewById(id);
        if (v != null)
            v.setVisibility(visibility);
    }

    private void setupForceAutoDayNight() {
        SwitchMaterial switchForceAutoDayNight = findViewById(R.id.switchForceAutoDayNight);
        TextView tvAutoModeStatus = findViewById(R.id.tvAutoModeStatus);

        if (switchForceAutoDayNight != null) {
            boolean isForceAuto = ConfigManager.getInstance().getBoolean("force_auto_day_night", false);
            switchForceAutoDayNight.setChecked(isForceAuto);

            switchForceAutoDayNight.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("force_auto_day_night", isChecked);

                Intent intent = new Intent("cn.navitool.ACTION_FORCE_AUTO_MODE_CHANGED");
                intent.putExtra("enabled", isChecked);
                sendBroadcast(intent);

                if (isChecked) {
                    // Status request moved to end of method
                }
            });
        }

        if (tvAutoModeStatus != null) {
            tvAutoModeStatus.setText(getString(R.string.status_auto_mode, getString(R.string.mode_unknown)));
        }

        // Always request status update on init
        Intent requestIntent = new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
        sendBroadcast(requestIntent);



        // 节日壁纸 Spinner
        setupFestivalWallpaper();
    }

    // --- 节日壁纸设置 ---
    private static final int SETTING_FUNC_WALLPAPER_FESTIVAL_TYPE = 539496192;
    private static final int[] FESTIVAL_VALUES = {
            539496192, // 关 (NULL)
            539496193, // 元旦
            539496194, // 春节
            539496195, // 情人节
            539496196, // 劳动节
            539496197, // 端午节
            539496198, // 七夕
            539496199, // 中秋节
            539496200, // 国庆节
            539496201 // 圣诞节
    };

    private void setupFestivalWallpaper() {
        android.widget.Spinner spinner = findViewById(R.id.spinnerFestivalWallpaper);
        if (spinner == null)
            return;

        android.widget.ArrayAdapter<CharSequence> adapter = android.widget.ArrayAdapter.createFromResource(
                this, R.array.festival_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // 读取保存的选项
        int savedIndex = ConfigManager.getInstance().getInt("festival_wallpaper_index", 0);
        spinner.setSelection(savedIndex);

        spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                int festivalType = FESTIVAL_VALUES[position];
                ConfigManager.getInstance().setInt("festival_wallpaper_index", position);
                DebugLogger.action("MainActivity", "节日壁纸选择: " + position);

                // 调用车机 API 设置节日壁纸
                com.ecarx.xui.adaptapi.car.base.ICarFunction carFunction = cn.navitool.managers.CarServiceManager
                        .getInstance(MainActivity.this).getCarFunction();
                if (carFunction != null) {
                    try {
                        carFunction.setFunctionValue(SETTING_FUNC_WALLPAPER_FESTIVAL_TYPE, -2147483648, festivalType);
                        DebugLogger.i("MainActivity", "设置节日壁纸: " + festivalType);
                    } catch (Exception e) {
                        DebugLogger.e("MainActivity", "设置节日壁纸失败", e);
                    }
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });
    }

    // --- Brightness Tab Logic ---

    private void setupBrightnessSettings() {
        // Brightness Override Controls
        final View layoutBrightnessSliders = findViewById(R.id.layoutBrightnessSliders);

        com.google.android.material.switchmaterial.SwitchMaterial switchOverride = findViewById(
                R.id.switchBrightnessOverride);
        if (switchOverride != null) {
            boolean isOverrideEnabled = ConfigManager.getInstance().getBoolean("override_brightness_enabled", false);
            switchOverride.setChecked(isOverrideEnabled);

            // Set initial visibility for both Sliders and Sync Switch
            if (layoutBrightnessSliders != null) {
                layoutBrightnessSliders.setVisibility(isOverrideEnabled ? View.VISIBLE : View.GONE);
            }

            switchOverride.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("override_brightness_enabled", isChecked);
                if (layoutBrightnessSliders != null) {
                    layoutBrightnessSliders.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                }
            });
        }

        // PSD Always On Switch (Method 1)
        com.google.android.material.switchmaterial.SwitchMaterial switchPsd = findViewById(R.id.switchPsdAlwaysOn);
        if (switchPsd != null) {
            boolean isPsdEnabled = ConfigManager.getInstance().getBoolean("psd_always_on_enabled", false);
            switchPsd.setChecked(isPsdEnabled);
            switchPsd.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("psd_always_on_enabled", isChecked);
                // Trigger Immediate Service Update via Broadcast
                Intent intent = new Intent("cn.navitool.ACTION_PSD_STATUS_CHANGED");
                intent.putExtra("enabled", isChecked);
                sendBroadcast(intent);
            });
        }

        // PSD Always On Switch (Method 2)
        com.google.android.material.switchmaterial.SwitchMaterial switchPsd2 = findViewById(
                R.id.switchPsdAlwaysOnMethod2);
        if (switchPsd2 != null) {
            boolean isPsd2Enabled = ConfigManager.getInstance().getBoolean("psd_always_on_method2_enabled", false);
            switchPsd2.setChecked(isPsd2Enabled);
            switchPsd2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("psd_always_on_method2_enabled", isChecked);
                // Trigger Immediate Service Update via Broadcast
                Intent intent = new Intent("cn.navitool.ACTION_PSD_METHOD2_STATUS_CHANGED");
                intent.putExtra("enabled", isChecked);
                sendBroadcast(intent);
            });
        }

        // Day Brightness
        SeekBar seekDay = findViewById(R.id.seekBrightnessDay);
        TextView tvDay = findViewById(R.id.tvBrightnessDay);
        int dayVal = ConfigManager.getInstance().getInt("override_day_value", 12);
        seekDay.setProgress(dayVal);
        tvDay.setText(getString(R.string.format_brightness_value, dayVal));
        seekDay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 1) {
                    seekBar.setProgress(1);
                    return;
                }
                tvDay.setText(getString(R.string.format_brightness_value, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ConfigManager.getInstance().setInt("override_day_value", seekBar.getProgress());
                DebugLogger.log(MainActivity.this, "Brightness", "Saved Day: " + seekBar.getProgress());
                ThemeBrightnessManager.getInstance(MainActivity.this).setTargetBrightness(
                        seekBar.getProgress(),
                        ConfigManager.getInstance().getInt("override_night_value", 5),
                        ConfigManager.getInstance().getInt("override_avm_value", 15));
            }
        });

        // Night Brightness
        SeekBar seekNight = findViewById(R.id.seekBrightnessNight);
        TextView tvNight = findViewById(R.id.tvBrightnessNight);
        int nightVal = ConfigManager.getInstance().getInt("override_night_value", 5);
        seekNight.setProgress(nightVal);
        tvNight.setText(getString(R.string.format_brightness_value, nightVal));
        seekNight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 1) {
                    seekBar.setProgress(1);
                    return;
                }
                tvNight.setText(getString(R.string.format_brightness_value, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ConfigManager.getInstance().setInt("override_night_value", seekBar.getProgress());
                DebugLogger.log(MainActivity.this, "Brightness", "Saved Night: " + seekBar.getProgress());
                ThemeBrightnessManager.getInstance(MainActivity.this).setTargetBrightness(
                        ConfigManager.getInstance().getInt("override_day_value", 12),
                        seekBar.getProgress(),
                        ConfigManager.getInstance().getInt("override_avm_value", 15));
            }
        });

        // AVM Brightness
        SeekBar seekAvm = findViewById(R.id.seekBrightnessAvm);
        TextView tvAvm = findViewById(R.id.tvBrightnessAvm);
        int avmVal = ConfigManager.getInstance().getInt("override_avm_value", 15);
        seekAvm.setProgress(avmVal);
        tvAvm.setText(getString(R.string.format_brightness_value, avmVal));
        seekAvm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 1) {
                    seekBar.setProgress(1);
                    return;
                }
                tvAvm.setText(getString(R.string.format_brightness_value, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ConfigManager.getInstance().setInt("override_avm_value", seekBar.getProgress());
                DebugLogger.log(MainActivity.this, "Brightness", "Saved AVM: " + seekBar.getProgress());
                ThemeBrightnessManager.getInstance(MainActivity.this).setTargetBrightness(
                        ConfigManager.getInstance().getInt("override_day_value", 12),
                        ConfigManager.getInstance().getInt("override_night_value", 5),
                        seekBar.getProgress());
            }
        });
    }

    // --- Buttons Tab Logic ---

    private void setupSteeringWheelControl() {
        SwitchMaterial switchSteeringWheel = findViewById(R.id.switchSteeringWheel);
        boolean isEnabled = ConfigManager.getInstance().getBoolean("steering_wheel_control_v2", true);
        switchSteeringWheel.setChecked(isEnabled);
        switchSteeringWheel.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ConfigManager.getInstance().setBoolean("steering_wheel_control_v2", isChecked);
            DebugLogger.toast(this,
                    getString(isChecked ? R.string.steering_wheel_enabled : R.string.steering_wheel_disabled));
        });
    }

    private void setupWeChatButton() {
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
        actionOptions.add(getString(R.string.action_launch_app));
        actionOptions.add(getString(R.string.action_kill_app));
        actionOptions.add(getString(R.string.action_toggle_cluster));
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

        // Load Values from ConfigManager
        boolean isWechatEnabled = ConfigManager.getInstance().getBoolean("wechat_button_enabled_v2", true);
        switchWechatButton.setChecked(isWechatEnabled);

        int shortPressActionIdx = ConfigManager.getInstance().getInt("wechat_short_press_action", 0);
        int longPressActionIdx = ConfigManager.getInstance().getInt("wechat_long_press_action", 0);
        spinnerShortPressAction.setSelection(shortPressActionIdx);
        spinnerLongPressAction.setSelection(longPressActionIdx);

        String shortPressAppPkg = ConfigManager.getInstance().getString("wechat_short_press_app", "");
        String longPressAppPkg = ConfigManager.getInstance().getString("wechat_long_press_app", "");

        // Restore App Selection
        for (int i = 0; i < apps.size(); i++) {
            if (apps.get(i).packageName.equals(shortPressAppPkg))
                spinnerShortPressApp.setSelection(i + 1);
            if (apps.get(i).packageName.equals(longPressAppPkg))
                spinnerLongPressApp.setSelection(i + 1);
        }

        // Visibility
        layoutWechatShortPress.setVisibility(isWechatEnabled ? View.VISIBLE : View.GONE);
        layoutWechatLongPress.setVisibility(isWechatEnabled ? View.VISIBLE : View.GONE);
        spinnerShortPressApp
                .setVisibility((shortPressActionIdx == 1 || shortPressActionIdx == 2) ? View.VISIBLE : View.GONE);
        spinnerLongPressApp
                .setVisibility((longPressActionIdx == 1 || longPressActionIdx == 2) ? View.VISIBLE : View.GONE);

        // Listeners
        switchWechatButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ConfigManager.getInstance().setBoolean("wechat_button_enabled_v2", isChecked);
            layoutWechatShortPress.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            layoutWechatLongPress.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });

        setupSpinnerListener(spinnerShortPressAction, spinnerShortPressApp, "wechat_short_press_action");
        setupSpinnerListener(spinnerLongPressAction, spinnerLongPressApp, "wechat_long_press_action");
        setupAppSpinnerListener(spinnerShortPressApp, apps, "wechat_short_press_app");
        setupAppSpinnerListener(spinnerLongPressApp, apps, "wechat_long_press_app");
    }

    private void setupSpinnerListener(Spinner actionSpinner, Spinner appSpinner, String key) {
        actionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ConfigManager.getInstance().setInt(key, position);
                if (appSpinner != null) {
                    appSpinner.setVisibility((position == 1 || position == 2) ? View.VISIBLE : View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupAppSpinnerListener(Spinner appSpinner, List<AppLaunchManager.AppInfo> apps, String key) {
        appSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 && position <= apps.size()) {
                    // Position 0 is "- - - -", so app is at position-1
                    String pkg = apps.get(position - 1).packageName;
                    ConfigManager.getInstance().setString(key, pkg);
                } else {
                    ConfigManager.getInstance().setString(key, "");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    // setupMediaButtons removed as per user request

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
            AppLaunchManager.executeLaunch(this);
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
        displayNames.add("- - - -"); // Changed from default to dashes
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
        if (view != null) {
            TextView txtName = view.findViewById(R.id.txtPermissionName);
            txtName.setText(R.string.title_app_permissions);
            view.setOnClickListener(v -> showPermissionDialog());
        }

        // Notification Access Check (for Media) -> Button removed as per user request
        // boolean hasNotifAccess = isNotificationServiceEnabled();

    }

    private boolean isNotificationServiceEnabled() {
        String pkgName = getPackageName();
        final String flat = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        if (flat != null && !flat.isEmpty()) {
            final String[] names = flat.split(":");
            for (String name : names) {
                final ComponentName cn = ComponentName.unflattenFromString(name);
                if (cn != null) {
                    if (android.text.TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
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
        if (permissionDialog.getWindow() != null) {
            permissionDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
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
                null);
        setupDialogItem(mPermissionDialogView, R.id.dialogStatusNotification, R.string.perm_notification_listener,
                this::requestNotificationPermission);

        Button btnAutoRepair = mPermissionDialogView.findViewById(R.id.btnAutoRepair);
        btnAutoRepair.setOnClickListener(v -> startAutoRepair());
    }

    private void setupDialogItem(View dialogView, int viewId, int nameResId, Runnable onClickAction) {
        View view = dialogView.findViewById(viewId);
        TextView txtName = view.findViewById(R.id.txtPermissionName);
        txtName.setText(nameResId);
        // Remove individual fix button logic
    }

    private boolean isAutoRepairing = false;

    // Auto Repair Logic
    private void startAutoRepair() {
        isAutoRepairing = true;
        processNextRepair();
    }

    // [NEW] Helper to check AppOps directly (fixes Android 9 sync issues)
    private boolean checkOpPermission(String op) {
        android.app.AppOpsManager appOps = (android.app.AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(op, android.os.Process.myUid(), getPackageName());
        return mode == android.app.AppOpsManager.MODE_ALLOWED;
    }

    private void processNextRepair() {
        if (!isAutoRepairing)
            return;

        // 1. Accessibility Service
        if (!isAccessibilityServiceEnabled()) {
            // Android 11+ Limitation Check (ADB disabled to prevent crash)
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                DebugLogger.toast(this, "Android 11+ 系统限制，请手动开启无障碍服务");
                requestAccessibilityPermission();
                return;
            }

            if (AdbShell.getInstance(this).isConnected()) {
                String serviceName = new ComponentName(this, KeepAliveAccessibilityService.class).flattenToString();
                String enabledServices = Settings.Secure.getString(getContentResolver(),
                        Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
                if (enabledServices == null)
                    enabledServices = "";

                if (!enabledServices.contains(serviceName)) {
                    if (enabledServices.isEmpty())
                        enabledServices = serviceName;
                    else
                        enabledServices += ":" + serviceName;

                    String cmd = "settings put secure enabled_accessibility_services '" + enabledServices + "'" +
                            "; settings put secure accessibility_enabled 1";

                    showRepairingToast(R.string.perm_accessibility);
                    AdbShell.getInstance(this).exec(cmd);

                    scheduleNextCheck(1500, this::requestAccessibilityPermission, this::isAccessibilityServiceEnabled);
                    return;
                }
            }

            showRepairingToast(R.string.perm_accessibility);
            requestAccessibilityPermission(); // Manual jump
            return;
        }

        // 2. Overlay Permission
        if (!android.provider.Settings.canDrawOverlays(this)) {
            // [Fix] Android 9 Sync Issue: System API says false, but AppOps says allowed
            if (checkOpPermission(android.app.AppOpsManager.OPSTR_SYSTEM_ALERT_WINDOW)) {
                DebugLogger.toast(this, "检测到系统缓存不同步，请手动【关闭再开启】一次");
                requestOverlayPermission();
                return;
            }

            // Android 11+ Limitation Check
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                DebugLogger.toast(this, "Android 11+ 系统限制，请手动授予悬浮窗权限");
                requestOverlayPermission();
                return;
            }

            if (AdbShell.getInstance(this).isConnected()) {
                showRepairingToast(R.string.perm_overlay);
                AdbShell.getInstance(this).exec("appops set " + getPackageName() + " SYSTEM_ALERT_WINDOW allow");
                scheduleNextCheck(1000, this::requestOverlayPermission,
                        () -> android.provider.Settings.canDrawOverlays(this));
                return;
            }
            showRepairingToast(R.string.perm_overlay);
            requestOverlayPermission();
            return;
        }

        // 3. Storage Permission
        if (!hasStoragePermission()) {
            // Android 11+ cannot be granted via ADB pm grant usually
            // (MANAGE_EXTERNAL_STORAGE)
            // But legacy might work.
            if (AdbShell.getInstance(this).isConnected() && Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
                showRepairingToast(R.string.perm_storage);
                AdbShell.getInstance(this)
                        .exec("pm grant " + getPackageName() + " android.permission.READ_EXTERNAL_STORAGE");
                AdbShell.getInstance(this)
                        .exec("pm grant " + getPackageName() + " android.permission.WRITE_EXTERNAL_STORAGE");
                scheduleNextCheck(1000, this::requestStoragePermission, this::hasStoragePermission);
                return;
            }

            showRepairingToast(R.string.perm_storage);
            requestStoragePermission();
            return;
        }

        // 4. Battery Optimization
        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean ignoringBattery = pm != null && pm.isIgnoringBatteryOptimizations(getPackageName());
        if (!ignoringBattery) {
            if (AdbShell.getInstance(this).isConnected()) {
                showRepairingToast(R.string.perm_battery);
                AdbShell.getInstance(this).exec("dumpsys deviceidle whitelist +" + getPackageName());
                scheduleNextCheck(1000, this::requestBatteryOptimization, () -> {
                    android.os.PowerManager currentPm = (android.os.PowerManager) getSystemService(
                            Context.POWER_SERVICE);
                    return currentPm != null && currentPm.isIgnoringBatteryOptimizations(getPackageName());
                });
                return;
            }
            showRepairingToast(R.string.perm_battery);
            requestBatteryOptimization();
            return;
        }

        // 5. Secure Settings
        if (!hasSecureSettingsPermission()) {
            if (AdbShell.getInstance(this).isConnected()) {
                showRepairingToast(R.string.perm_secure_settings);
                AdbShell.getInstance(this)
                        .exec("pm grant " + getPackageName() + " android.permission.WRITE_SECURE_SETTINGS");
                scheduleNextCheck(1000, this::showSecureSettingsGuide, this::hasSecureSettingsPermission);
                return;
            }
            showRepairingToast(R.string.perm_secure_settings);
            showSecureSettingsGuide();
            return;
        }

        // 6. Notification Listener Permission
        if (!isNotificationListenerEnabled()) {
            if (AdbShell.getInstance(this).isConnected()) {
                showRepairingToast(R.string.perm_notification_listener);
                // "cmd notification allow_listener" available on Android 7+
                String componentName = new ComponentName(this, cn.navitool.service.MediaNotificationListener.class)
                        .flattenToString();
                AdbShell.getInstance(this).exec("cmd notification allow_listener " + componentName);
                scheduleNextCheck(1000, this::requestNotificationPermission, this::isNotificationListenerEnabled);
                return;
            }
            showRepairingToast(R.string.perm_notification_listener);
            requestNotificationPermission();
            return;
        }

        // All Done
        isAutoRepairing = false;
        refreshPermissionDialog(mPermissionDialogView); // Final refresh dialog
        checkPermissions(); // Refresh Main Activity UI
        android.widget.Toast.makeText(this, R.string.repair_complete, android.widget.Toast.LENGTH_SHORT).show();
        if (permissionDialog != null && permissionDialog.isShowing()) {
            permissionDialog.dismiss();
        }
    }

    private void scheduleNextCheck(long delayMs, Runnable manualFallback,
            java.util.function.BooleanSupplier permissionChecker) {
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
            if (!isAutoRepairing)
                return;

            if (permissionChecker.getAsBoolean()) {
                // Permission is now granted, proceed to the next repair step
                processNextRepair();
            } else {
                // Permission still not granted after ADB attempt, fall back to manual
                manualFallback.run();
                // Stop auto-repairing here, user needs to manually grant and then resume
                isAutoRepairing = false;
            }
        }, delayMs);
    }

    private void showRepairingToast(int resId) {
        String name = getString(resId);
        android.widget.Toast
                .makeText(this, getString(R.string.repairing_permission, name), android.widget.Toast.LENGTH_SHORT)
                .show();
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
        updateDialogStatusItem(dialogView, R.id.dialogStatusNotification, isNotificationListenerEnabled());
    }

    private boolean hasSecureSettingsPermission() {
        return androidx.core.content.ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_SECURE_SETTINGS) == android.content.pm.PackageManager.PERMISSION_GRANTED;
    }

    private void updateDialogStatusItem(View dialogView, int viewId, boolean granted) {
        View view = dialogView.findViewById(viewId);
        ImageView imgStatus = view.findViewById(R.id.imgStatus);
        if (granted) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
        } else {
            imgStatus.setImageResource(R.drawable.ic_close);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
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
        if (allGranted) {
            imgStatus.setImageResource(R.drawable.ic_check);
            imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
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
            DebugLogger.toast(this, getString(R.string.msg_adb_granting));
            // Poll for status update
            android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
            int[] delays = { 200, 500, 1000, 1500, 2000, 3000 };
            for (int delay : delays) {
                handler.postDelayed(this::checkPermissions, delay);
            }
        } else {
            fallbackAction.run();
        }
    }

    private boolean hasStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            return ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        }
    }

    private void showSecureSettingsGuide() {
        tryAdbGrant("pm grant " + getPackageName() + " android.permission.WRITE_SECURE_SETTINGS",
                getString(R.string.msg_granting_secure),
                () -> DebugLogger.toast(this,
                        String.format(getString(R.string.perm_secure_settings_guide), getPackageName())));
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
            Runnable launchIntent = () -> {
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    mOverlayPermissionLauncher.launch(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    mOverlayPermissionLauncher.launch(intent);
                }
            };

            if (AdbShell.getInstance(this).isConnected()) {
                AdbShell.getInstance(this).exec("appops set " + getPackageName() + " SYSTEM_ALERT_WINDOW allow");
                DebugLogger.toast(this, getString(R.string.msg_adb_granting));

                // Optimized Polling for Overlay
                android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
                int[] delays = { 200, 500, 1000, 2000, 3000 };

                for (int i = 0; i < delays.length; i++) {
                    final int delay = delays[i];
                    final boolean isLast = (i == delays.length - 1);
                    handler.postDelayed(() -> {
                        if (Settings.canDrawOverlays(this)) {
                            checkPermissions();
                        } else if (isLast) {
                            // Only launch intent if still failed after final attempt
                            launchIntent.run();
                        }
                    }, delay);
                }
            } else {
                launchIntent.run();
            }
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
                    getString(R.string.msg_granting_battery),
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
            // Priority 1: ADB Automation
            if (AdbShell.getInstance(this).isConnected()) {
                String serviceName = new ComponentName(this, KeepAliveAccessibilityService.class).flattenToString();
                // Strategy: Use the local Read - Modify - Write pattern via ADB 'settings put'
                // We know the current enabled services from Settings.Secure.getString logic
                // locally!

                String enabledServices = Settings.Secure.getString(getContentResolver(),
                        Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);

                if (enabledServices == null || enabledServices.isEmpty()) {
                    enabledServices = serviceName;
                } else if (!enabledServices.contains(serviceName)) {
                    enabledServices += ":" + serviceName;
                }

                // 2. Enable Service (Chained & Quoted)
                // Use single quotes ('') around the service list to prevent shell parsing
                // errors.
                // Chain with ';' to ensure the list is updated BEFORE the master switch is
                // enabled.
                // 2. Enable Service (Chained & Quoted)
                // Use single quotes ('') around the service list to prevent shell parsing
                // errors.
                // Chain with ';' to ensure the list is updated BEFORE the master switch is
                // enabled.
                // Removed 'pm enable' as it kills the app process on some systems.
                String combinedCommand = "settings put secure enabled_accessibility_services '" + enabledServices + "'"
                        +
                        "; settings put secure accessibility_enabled 1";

                AdbShell.getInstance(this).exec(combinedCommand);
                // DebugLogger.toast(this, getString(R.string.msg_adb_granting)); // Duplicate
                // toast?

                // Optimized Polling: Check immediately and frequently
                android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
                int[] delays = { 200, 500, 1000, 2000 };
                for (int delay : delays) {
                    handler.postDelayed(this::checkPermissions, delay);
                }
                return;
            }

            // Priority 2: Write Secure Settings (if already held)
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
                } catch (Exception e) {
                    DebugLogger.log(this, "MainActivity", "Failed to auto-enable accessibility: " + e.getMessage());
                    openAccessibilitySettings();
                }
            } else {
                // Priority 3: Manual Setting
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
                int mode = intent.getIntExtra("mode", 0);
                int sensorDayNight = intent.getIntExtra("sensor_day_night", -1);
                updateAutoModeStatus(mode, sensorDayNight);
            }
        }
    };

    // [NEW] 仪表/HUD 延迟激活广播接收器
    private final android.content.BroadcastReceiver mClusterHudActivationReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_ACTIVATE_CLUSTER_HUD".equals(intent.getAction())) {
                DebugLogger.i("MainActivity", "Received Cluster/HUD activation broadcast (3s after DRIVING)");

                // 使用与 setupCluster() 相同的键名: switch_cluster, switch_hud
                boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
                boolean isHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);

                ClusterHudManager manager = ClusterHudManager.getInstance(MainActivity.this);

                // 先设置状态
                if (isClusterEnabled) {
                    DebugLogger.i("MainActivity", "Delayed Activation: Setting Cluster enabled");
                    // 强制设置内部状态（绕过状态检查）
                    manager.setClusterEnabled(false);
                    manager.setClusterEnabled(true);
                }

                if (isHudEnabled) {
                    DebugLogger.i("MainActivity", "Delayed Activation: Setting HUD enabled");
                    manager.setHudEnabled(false);
                    manager.setHudEnabled(true);
                }

                // 强制刷新 PresentationManager 确保显示
                if (isClusterEnabled || isHudEnabled) {
                    DebugLogger.i("MainActivity", "Delayed Activation: Forcing presentation refresh");
                    manager.forceRefreshPresentationManager();
                }
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

    private void updateAutoModeStatus(int mode, int sensorDayNight) {
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
            if (iconRes == R.drawable.ic_close) {
                // Error state -> Red
                imgAutoModeIcon.setColorFilter(android.graphics.Color.parseColor("#F44336"));
            } else {
                // Valid state -> Remove tint (Keep original color)
                imgAutoModeIcon.clearColorFilter();
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
        // Default to auto-connect in background to avoid blocking Main Thread startup
        new Thread(() -> {
            AdbShell.getInstance(this).connect();
        }).start();

        // Manual Reconnect
        View layoutAdbStatus = findViewById(R.id.layoutAdbStatus);
        if (layoutAdbStatus != null) {
            layoutAdbStatus.setOnClickListener(v -> {
                DebugLogger.toast(this, "正在尝试重新连接 ADB...");
                // Manual click can also be async, but usually user expects response.
                // However, connect logic likely handles internal threading or blocking.
                // Better safe to keep manual click async too if it blocks.
                new Thread(() -> AdbShell.getInstance(this).connect()).start();
            });
        }
    }

    private final android.content.BroadcastReceiver adbStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ADB_STATUS_CHANGED".equals(intent.getAction())) {
                String status = intent.getStringExtra("status");
                android.widget.ImageView imgAdbStatus = findViewById(R.id.imgAdbStatus);
                android.widget.TextView tvAdbStatus = findViewById(R.id.tvAdbStatusText);

                if (imgAdbStatus != null && status != null) {
                    if (tvAdbStatus != null) {
                        tvAdbStatus.setText(status);
                    }

                    if (status.contains("已连接")) {
                        imgAdbStatus.setImageResource(R.drawable.ic_check);
                        imgAdbStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
                        DebugLogger.toast(MainActivity.this, status);
                        autoRepairPermissionsSilent(); // Trigger
                                                       // Auto
                                                       // Repair
                    } else if (status.contains("连接失败")) {
                        imgAdbStatus.setImageResource(R.drawable.ic_close);
                        imgAdbStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
                        DebugLogger.toast(MainActivity.this, status);
                    } else { // connecting
                             // or
                             // other
                        imgAdbStatus.setImageResource(R.drawable.ic_close);
                        imgAdbStatus.setColorFilter(androidx.core.content.ContextCompat.getColor(MainActivity.this,
                                android.R.color.darker_gray));
                    }
                }
            }
        }
    };

    private final android.content.BroadcastReceiver mPsdStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_PSD_STATUS".equals(intent.getAction())) {
                int status = intent.getIntExtra("status", -1);
                long timestamp = intent.getLongExtra("timestamp", 0);

                TextView tvPsdStatus = findViewById(R.id.tvPsdStatus);
                if (tvPsdStatus != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS", java.util.Locale.getDefault());
                    String timeStr = (timestamp > 0) ? sdf.format(new java.util.Date(timestamp)) : "--";
                    String statusStr = (status == 1) ? "ON" : (status == 0 ? "OFF" : "Unknown");

                    String text = String.format("PSD Status: %s (Last Event: %s)", statusStr, timeStr);
                    tvPsdStatus.setText(text);
                }
            }
        }
    };

    private void setupSystemInfo() {
        TextView tvBootTime = findViewById(R.id.tvBootTime);
        if (tvBootTime != null) {
            long bootTime = System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
            tvBootTime.setText("Boot Time: " + sdf.format(new java.util.Date(bootTime)));
        }

        // Setup delete logs button
        setupDeleteLogsButton();

        // Setup engine start simulation button
        setupSimulateEngineStartButton();

    }

    private void setupDeleteLogsButton() {
        View btnDeleteLogs = findViewById(R.id.btnDeleteLogs);
        if (btnDeleteLogs != null) {
            btnDeleteLogs.setOnClickListener(v -> {
                DebugLogger.deleteAllLogs();
                DebugLogger.toastAlways(this, getString(R.string.toast_logs_deleted));
            });
        }
    }

    private SimulateFunction mSimulateFunction;
    private boolean mSimulateAmapNightMode = false;

    private void setupSimulateEngineStartButton() {
        // 初始化模拟功能管理器
        if (mSimulateFunction == null) {
            mSimulateFunction = new SimulateFunction(this);
        }
        
        // 设置模拟发动机启动按钮
        View btnSimulate = findViewById(R.id.btnSimulateEngineStart);
        mSimulateFunction.setupEngineStartButton(btnSimulate);
        
        // 设置模拟转向灯按钮
        com.google.android.material.button.MaterialButton btnTurnSignal = findViewById(R.id.btnSimulateTurnSignal);
        mSimulateFunction.setupTurnSignalButton(btnTurnSignal);

        // [NEW] 模拟高德日夜切换
        com.google.android.material.button.MaterialButton btnAmapTheme = findViewById(R.id.btnSimulateAmapTheme);
        if (btnAmapTheme != null) {
             btnAmapTheme.setOnClickListener(v -> {
                 mSimulateAmapNightMode = !mSimulateAmapNightMode;
                 int mode = mSimulateAmapNightMode ? 2 : 1;
                 sendAutoNaviBroadcast(mode);
                 DebugLogger.toast(MainActivity.this, "模拟高德: " + (mode == 1 ? "白天" : "黑夜"));
             });
        }

        // [NEW] HUD 浅绿底色调试按钮 (Toggle Button)
        com.google.android.material.button.MaterialButton btnHudGreenBg = findViewById(R.id.btnHudGreenBg);
        if (btnHudGreenBg != null) {
            // 初始化按钮状态
            boolean isEnabled = ConfigManager.getInstance().getBoolean("hud_green_bg_enabled", false);
            updateHudGreenBgButton(btnHudGreenBg, isEnabled);

            btnHudGreenBg.setOnClickListener(v -> {
                // Toggle 状态
                boolean newState = !ConfigManager.getInstance().getBoolean("hud_green_bg_enabled", false);
                ConfigManager.getInstance().setBoolean("hud_green_bg_enabled", newState);
                ClusterHudManager.getInstance(this).setHudGreenBgEnabled(newState);
                updateHudGreenBgButton(btnHudGreenBg, newState);
                DebugLogger.toast(this, newState ? "HUD 浅绿底色已开启" : "HUD 浅绿底色已关闭");
            });
        }
    }

    // 更新 HUD 浅绿底色按钮的图标和文字状态
    private void updateHudGreenBgButton(com.google.android.material.button.MaterialButton btn, boolean isEnabled) {
        btn.setIconResource(isEnabled ? R.drawable.ic_check : R.drawable.ic_close);
        btn.setText(isEnabled ? "HUD浅绿(开)" : "HUD浅绿(关)");
    }

    private void setupPsdTestButtons() {
        // Find wrapper layout to control visibility based on Debug mode
        View layoutTestButtons = findViewById(R.id.layoutPsdTestButtons);

        // Note: The visibility of this layout depends on Debug Mode switch logic.
        // We need to ensure it's added to the toggle list in
        // 'updateDebugViewsVisibility'
        // OR we can just check debug pref here.
        // However, layoutPsdTestButtons is inside Brightness tab.
        // For simplicity, let's just leave it GONE by default (XML) and show if debug
        // enabled?
        // User didn't ask for toggle linkage, but implied it's a debug feature.
        // Let's rely on 'config_debug_mode_enabled' pref if we want, or just hook it
        // up.
        // Wait, 'updateDebugViewsVisibility' handles RB Sound/etc.
        // I should update 'updateDebugViewsVisibility' eventually, but for now I will
        // manual check.

        SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean isDebug = prefs.getBoolean("config_debug_mode_enabled", false);
        if (layoutTestButtons != null) {
            layoutTestButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        }

        findViewById(R.id.btnTestPsd0ms).setOnClickListener(v -> {
            Intent intent = new Intent("cn.navitool.ACTION_TEST_PSD_SWITCH");
            intent.putExtra("delay", 0);
            sendBroadcast(intent);
            DebugLogger.toast(this, "Sent 0ms PSD Switch Test");
        });

        findViewById(R.id.btnTestPsd1ms).setOnClickListener(v -> {
            Intent intent = new Intent("cn.navitool.ACTION_TEST_PSD_SWITCH");
            intent.putExtra("delay", 1);
            sendBroadcast(intent);
            DebugLogger.toast(this, "Sent 1ms PSD Switch Test");
        });
    }

    // --- New Notification Listener logic ---
    private boolean isNotificationListenerEnabled() {
        String enabledListeners = android.provider.Settings.Secure.getString(getContentResolver(),
                "enabled_notification_listeners");
        String myComponent = new ComponentName(this, cn.navitool.service.MediaNotificationListener.class)
                .flattenToString();
        return enabledListeners != null && enabledListeners.contains(myComponent);
    }

    private void requestNotificationPermission() {
        try {
            startActivity(new android.content.Intent(android.provider.Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS));
        } catch (Exception e) {
            DebugLogger.e("MainActivity", "Failed to open notif listener settings", e);
            DebugLogger.toast(this, "无法打开通知权限设置，请手动前往设置开启");
        }
    }

    private final android.content.BroadcastReceiver mMediaInfoReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (cn.navitool.service.MediaNotificationListener.ACTION_MEDIA_INFO_UPDATE.equals(intent.getAction())) {
                String title = intent.getStringExtra("title");
                String artist = intent.getStringExtra("artist");
                // String album = intent.getStringExtra("album");
                boolean isPlaying = intent.getBooleanExtra("is_playing", false);

                String display = title;
                if (artist != null && !artist.isEmpty()) {
                    display = title + "\n" + artist;
                }

                // Update HUD
                ClusterHudManager.getInstance(MainActivity.this).updateComponentText("song_2line", display);

                // Optional: Update Album Art if passed (byte array)
                byte[] artwork = intent.getByteArrayExtra("artwork");
                if (artwork != null) {
                    android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(artwork, 0,
                            artwork.length);
                    ClusterHudManager.getInstance(MainActivity.this).updateComponentImage("song_cover", bmp);
                }
            }
        }
    };

    private void autoRepairPermissionsSilent() {
        if (!AdbShell.getInstance(this).isConnected())
            return;
        DebugLogger.i("AutoRepair", "Starting Silent Permission Repair...");

        // 1. Notification Listener
        if (!isNotificationListenerEnabled()) {
            String componentName = new ComponentName(this, cn.navitool.service.MediaNotificationListener.class)
                    .flattenToString();
            AdbShell.getInstance(this).exec("cmd notification allow_listener " + componentName);
            DebugLogger.i("AutoRepair", "Repaired Notification Listener");
        }

        // 2. Accessibility Service
        if (!isAccessibilityServiceEnabled()) {
            String serviceName = new ComponentName(this, KeepAliveAccessibilityService.class).flattenToString();
            String enabledServices = Settings.Secure.getString(getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (enabledServices == null)
                enabledServices = "";

            if (!enabledServices.contains(serviceName)) {
                if (enabledServices.isEmpty())
                    enabledServices = serviceName;
                else
                    enabledServices += ":" + serviceName;

                String cmd = "settings put secure enabled_accessibility_services '" + enabledServices
                        + "'; settings put secure accessibility_enabled 1";
                AdbShell.getInstance(this).exec(cmd);
                DebugLogger.i("AutoRepair", "Repaired Accessibility Service");
            }
        }

        // 3. Overlay (System Alert Window)
        if (!Settings.canDrawOverlays(this)) {
            AdbShell.getInstance(this).exec("appops set " + getPackageName() + " SYSTEM_ALERT_WINDOW allow");
            DebugLogger.i("AutoRepair", "Repaired Overlay Permission");
        }

        // 4. Secure Settings
        if (!hasSecureSettingsPermission()) {
            AdbShell.getInstance(this)
                    .exec("pm grant " + getPackageName() + " android.permission.WRITE_SECURE_SETTINGS");
            DebugLogger.i("AutoRepair", "Repaired Secure Settings");
        }

        // 5. Battery Optimization (Allow WhiteList)
        android.os.PowerManager pm = (android.os.PowerManager) getSystemService(Context.POWER_SERVICE);
        boolean ignoringBattery = pm != null && pm.isIgnoringBatteryOptimizations(getPackageName());
        if (!ignoringBattery) {
            AdbShell.getInstance(this).exec("dumpsys deviceidle whitelist +" + getPackageName());
            DebugLogger.i("AutoRepair", "Repaired Battery Opt");
        }

        // Refresh Main UI Status after a short delay to allow system to apply changes
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(this::checkPermissions, 1500);
    }

    // --- Grid Background Drawable (Inline) ---
    private static class GridBackgroundDrawable extends android.graphics.drawable.Drawable {
        private final android.graphics.Paint mPaint;
        private final android.graphics.Paint mBgPaint;
        private static final int GRID_SIZE = 50;

        public GridBackgroundDrawable() {
            mPaint = new android.graphics.Paint();
            mPaint.setColor(android.graphics.Color.WHITE);
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setStrokeWidth(1);
            // Dashed: 5px line, 5px gap
            mPaint.setPathEffect(new android.graphics.DashPathEffect(new float[] { 5, 5 }, 0));
            mPaint.setAlpha(128); // 50% Opacity
            // Disable AntiAlias for performance and sharpness on vertical/horizontal lines
            mPaint.setAntiAlias(false);

            mBgPaint = new android.graphics.Paint();
            mBgPaint.setColor(android.graphics.Color.BLACK);
            mBgPaint.setStyle(android.graphics.Paint.Style.FILL);
        }

        @Override
        public void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
            // 1. Draw Black Background (Bottom Layer)
            canvas.drawRect(getBounds(), mBgPaint);

            // 2. Draw Grid Lines
            int width = getBounds().width();
            int height = getBounds().height();
            int centerX = width / 2;
            int centerY = height / 2;

            // Vertical Lines
            for (int x = centerX; x < width; x += GRID_SIZE) {
                canvas.drawLine(x, 0, x, height, mPaint);
            }
            for (int x = centerX - GRID_SIZE; x >= 0; x -= GRID_SIZE) {
                canvas.drawLine(x, 0, x, height, mPaint);
            }

            // Horizontal Lines
            for (int y = centerY; y < height; y += GRID_SIZE) {
                canvas.drawLine(0, y, width, y, mPaint);
            }
            for (int y = centerY - GRID_SIZE; y >= 0; y -= GRID_SIZE) {
                canvas.drawLine(0, y, width, y, mPaint);
            }
        }

        @Override
        public void setAlpha(int alpha) {
            mPaint.setAlpha(alpha);
        }

        @Override
        public void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
            mPaint.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return android.graphics.PixelFormat.OPAQUE;
        }
    }
}
