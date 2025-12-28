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

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private View mLayoutTheme;
    private View mLayoutButtons;
    private View mLayoutAutoStart;
    private ScrollView mLayoutADB; // ADB is not lazy
    private View mLayoutLights;
    private View mLayoutBrightness;
    private View mLayoutSound;
    private View mLayoutCluster;
    private View mLayoutHud;

    private boolean mIsThemeInit = false;
    private boolean mIsButtonsInit = false;
    private boolean mIsAutoStartInit = false;
    private boolean mIsLightsInit = false;
    private boolean mIsBrightnessInit = false;
    private boolean mIsSoundInit = false;
    private boolean mIsClusterInit = false;
    private boolean mIsHudInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        setContentView(R.layout.activity_main);

        DebugLogger.init(this); // Initialize Logging
        ConfigManager.init(this); // Initialize Config Persistence (Internal Storage)

        // Removed redundant DebugLogger.createDirectories() to save main thread I/O
        // time

        initUI();
        initNavigation();
        checkPermissions();

        // Optimize: Pre-initialize ClusterHudManager in background to reduce lag on
        // first tab switch
        new Thread(() -> {
            // Load saved state (IO)
            boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
            boolean isHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);
            int savedMode = ConfigManager.getInstance().getInt("hud_current_mode", 0);

            // HEAVY WORK: Initialize Manager (Reflection) in BACKGROUND thread
            ClusterHudManager manager = ClusterHudManager.getInstance(getApplicationContext());

            // Optimize: Parse JSON in background
            List<ClusterHudManager.HudComponentData> hudData = null;
            if (isHudEnabled) {
                hudData = parseHudConfig(savedMode);
            }
            final List<ClusterHudManager.HudComponentData> finalHudData = hudData;

            // Apply to UI/Manager on Main Thread
            runOnUiThread(() -> {
                if (isClusterEnabled) {
                    manager.setClusterEnabled(true);
                }
                if (isHudEnabled) {
                    manager.setHudEnabled(true);
                    // reloadHudConfigToManager(savedMode); // Legacy sync call
                    if (finalHudData != null) {
                        applyHudConfigToManager(finalHudData);
                    }
                }
            });
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceivers();
        // Request immediate status update from ADB Shell
        AdbShell.getInstance(this).broadcastStatus();

        // Register HUD Listener for Preview Updates
        ClusterHudManager.getInstance(this).setListener((type, text, image) -> {
            runOnUiThread(() -> {
                android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
                if (preview != null) {
                    for (int i = 0; i < preview.getChildCount(); i++) {
                        View child = preview.getChildAt(i);
                        Object tag = child.getTag();
                        if (tag != null && tag.equals("type_" + type)) {
                            // Fix: Do NOT update text for 'time' component, as it receives the format
                            // string "HH:mm"
                            // We want to keep the live time preview (or calculated time)
                            if ("time".equals(type)) {
                                continue;
                            }

                            if (child instanceof TextView && text != null) {
                                ((TextView) child).setText(text);
                            } else if (child instanceof ImageView && image != null) {
                                ((ImageView) child).setImageBitmap(image);
                            }
                        }
                    }
                }
            });
        });
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

        android.content.IntentFilter headlightFilter = new android.content.IntentFilter(
                "cn.navitool.ACTION_HEADLIGHT_STATUS");
        registerReceiver(mHeadlightStatusReceiver, headlightFilter);

        android.content.IntentFilter psdFilter = new android.content.IntentFilter("cn.navitool.ACTION_PSD_STATUS");
        registerReceiver(mPsdStatusReceiver, psdFilter);

        android.content.IntentFilter oneOsFilter = new android.content.IntentFilter("cn.navitool.ACTION_ONEOS_STATUS");
        registerReceiver(mOneOSStatusReceiver, oneOsFilter);
    }

    private void unregisterReceivers() {
        try {
            unregisterReceiver(adbStatusReceiver);
            unregisterReceiver(mHeadlightStatusReceiver);
            unregisterReceiver(mPsdStatusReceiver);
            unregisterReceiver(mOneOSStatusReceiver);
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
        int debugVisibility = BuildConfig.DEBUG ? View.VISIBLE : View.GONE;
        View rbCluster = findViewById(R.id.rbCluster);
        View rbHud = findViewById(R.id.rbHud);
        if (rbCluster != null)
            rbCluster.setVisibility(debugVisibility);
        if (rbHud != null)
            rbHud.setVisibility(debugVisibility);

        // Hide experimental features in Release builds
        if (!BuildConfig.DEBUG) {
            findViewById(R.id.rbLights).setVisibility(View.GONE);
        }

        rgNavigation.setOnCheckedChangeListener((group, checkedId) -> {
            // Hide all potential views
            if (mLayoutADB != null)
                mLayoutADB.setVisibility(View.GONE);
            if (mLayoutTheme != null)
                mLayoutTheme.setVisibility(View.GONE);
            if (mLayoutButtons != null)
                mLayoutButtons.setVisibility(View.GONE);
            if (mLayoutAutoStart != null)
                mLayoutAutoStart.setVisibility(View.GONE);
            if (mLayoutLights != null)
                mLayoutLights.setVisibility(View.GONE);
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
            } else if (checkedId == R.id.rbTheme) {
                ensureThemeInflated();
                if (mLayoutTheme != null)
                    mLayoutTheme.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbButtons) {
                ensureButtonsInflated();
                if (mLayoutButtons != null)
                    mLayoutButtons.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbAutoStart) {
                ensureAutoStartInflated();
                if (mLayoutAutoStart != null)
                    mLayoutAutoStart.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rbLights) {
                ensureLightsInflated();
                if (mLayoutLights != null)
                    mLayoutLights.setVisibility(View.VISIBLE);
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

    private void ensureThemeInflated() {
        if (mLayoutTheme == null) {
            View v = tryInflate(mLayoutTheme, R.id.stubTheme, R.id.layoutContentTheme);
            mLayoutTheme = v;
            setupThemeSettings();
            setupForceAutoDayNight();
            mIsThemeInit = true;
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

    private void ensureLightsInflated() {
        if (mLayoutLights == null) {
            View v = tryInflate(mLayoutLights, R.id.stubLights, R.id.layoutContentLights);
            mLayoutLights = v;
            // setupForceAutoDayNight(); // Removed: Switches are in Theme layout, not
            // Lights layout.
            mIsLightsInit = true;
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

    private void initUI() {
        // --- Header / Debug ---
        setupDebugSwitch();
        setVersionInfo();

        // --- ADB Tab (System Info & Permissions & Default Tab) ---
        setupSystemInfo();
        setupPermissionStatuses();
        setupAdbWireless();

        updateAutoModeStatus(0, -1);

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
                ClusterHudManager.getInstance(this).setClusterEnabled(isChecked);
                ConfigManager.getInstance().setBoolean("switch_cluster", isChecked);
            });
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
            if (previewContent != null)
                previewContent.setVisibility(View.VISIBLE);
            if (controls != null)
                controls.setVisibility(isHudEnabled ? View.VISIBLE : View.GONE);

            switchHud.setOnCheckedChangeListener((buttonView, isChecked) -> {
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
    }

    // --- HUD Editor Logic ---
    private View mHudTestComponent;
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
                    String type = tag.toString().replace("type_", "");
                    obj.put("type", type);

                    String text = "";
                    if (child instanceof TextView) {
                        text = (child instanceof android.widget.TextClock)
                                ? ((android.widget.TextClock) child).getFormat12Hour().toString()
                                : ((TextView) child).getText().toString();
                    }
                    obj.put("text", text);

                    obj.put("x", child.getX());
                    obj.put("y", child.getY());
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

                    syncList.add(new ClusterHudManager.HudComponentData(type, text, x * 0.5f, y * 0.5f, color));
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

                    createAndAddHudComponent(type, text, x, y);
                    int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF;
                    syncList.add(new ClusterHudManager.HudComponentData(type, text, x * 0.5f, y * 0.5f, color));
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
            }
        }
    }

    // Updated helper method signature to accept type
    // Updated helper method signature to accept type
    private void createAndAddHudComponent(String type, String text, float x, float y) {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;

        View view;
        boolean isMediaCover = "media_cover".equals(type);

        if ("time".equals(type)) {
            // User Request: Show real system time immediately in Preview
            text = new java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault()).format(new java.util.Date());
        }

        if (isMediaCover) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(android.R.drawable.ic_media_play); // Placeholder in Preview
            iv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            // Preview size 200x200 (2x of HUD 100x100)
            android.widget.FrameLayout.LayoutParams params = new android.widget.FrameLayout.LayoutParams(200, 200);
            view = iv;
            view.setLayoutParams(params);
        } else {
            TextView tv = new TextView(this);
            tv.setText(text);
            // Rule: Transparent Background
            tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
            view = tv;
        }

        view.setBackgroundColor(android.graphics.Color.TRANSPARENT); // Ensure transparent

        // Font scaling for Text Views
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            tv.setPadding(0, 0, 0, 0);
            // Rule 2: Font scaling (Preview is 2x HUD)
            if ("gear".equals(type)) {
                tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 40); // 20px * 2
            } else {
                tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 20); // 10px * 2
            }
            tv.setTextColor(mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF);

            if ("song".equals(type)) {
                // Preview width = 600px (HUD 300px * 2)
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT,
                            android.widget.FrameLayout.LayoutParams.WRAP_CONTENT));
                }
                view.getLayoutParams().width = 600;
                tv.setSingleLine(false);
                tv.setMaxLines(2);
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

                        // Bounds Check
                        View parent = (View) view.getParent();
                        int parentWidth = parent.getWidth();
                        int parentHeight = parent.getHeight();
                        int viewWidth = view.getWidth();
                        int viewHeight = view.getHeight();

                        if (newX < 0)
                            newX = 0;
                        if (newX + viewWidth > parentWidth)
                            newX = parentWidth - viewWidth;
                        if (newY < 0)
                            newY = 0;
                        if (newY + viewHeight > parentHeight)
                            newY = parentHeight - viewHeight;

                        view.setX(newX);
                        view.setY(newY);

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

    private void syncAllHudComponents() {
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;
        List<ClusterHudManager.HudComponentData> list = new ArrayList<>();
        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);
            String tag = (String) child.getTag();
            if (tag == null || !tag.startsWith("type_"))
                continue;

            String type = tag.replace("type_", "");
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
            } else if (child instanceof ImageView) {
                // Image has no text value to sync, but we need the entry
                text = "";
            }

            int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF;
            list.add(new ClusterHudManager.HudComponentData(
                    type,
                    text,
                    child.getX() * 0.5f,
                    child.getY() * 0.5f,
                    color));
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

        android.widget.GridLayout grid = new android.widget.GridLayout(this);
        grid.setColumnCount(3);
        grid.setPadding(32, 16, 32, 16);

        final android.app.AlertDialog[] dialogHolder = new android.app.AlertDialog[1];

        // Helper to add button with duplicate check
        java.util.function.BiConsumer<String, String> addButtonWithType = (text, type) -> {
            Button btn = new Button(this);
            btn.setText(text);
            btn.setTextSize(12);
            btn.setPadding(8, 8, 8, 8);
            android.widget.GridLayout.LayoutParams params = new android.widget.GridLayout.LayoutParams();
            params.width = 0;
            params.height = android.widget.GridLayout.LayoutParams.WRAP_CONTENT;
            params.columnSpec = android.widget.GridLayout.spec(android.widget.GridLayout.UNDEFINED, 1f);
            params.setMargins(8, 8, 8, 8);
            btn.setLayoutParams(params);

            btn.setOnClickListener(v -> {
                if (isHudComponentAdded(type)) {
                    DebugLogger.toast(this, "该组件已存在，请勿重复添加");
                    return;
                }

                // Logic based on type
                if ("time".equals(type))
                    addHudTimeComponent();
                else if ("song".equals(type))
                    createAndAddHudComponent("song", "暂无歌词\n歌曲名 - 歌手", 0, 0);
                else if ("fuel".equals(type))
                    createAndAddHudComponent("fuel", "油量: --L", 0, 0);
                else if ("temp_in".equals(type))
                    createAndAddHudComponent("temp_in", "内: --°C", 0, 0);
                else if ("temp_out".equals(type))
                    createAndAddHudComponent("temp_out", "外: --°C", 0, 0);
                else if ("range".equals(type))
                    createAndAddHudComponent("range", "续航: --km", 0, 0);
                else if ("gear".equals(type))
                    createAndAddHudComponent("gear", "D", 0, 0);
                else if ("turn_signal".equals(type))
                    createAndAddHudComponent("turn_signal", "←", 0, 0);
                else if ("volume".equals(type))
                    createAndAddHudComponent("volume", "音量: --", 0, 0);
                else if ("media_cover".equals(type))
                    createAndAddHudComponent("media_cover", "", 0, 0);
                else if ("test_media".equals(type)) {
                    ClusterHudManager.getInstance(this).syncTestMedia();
                    DebugLogger.toast(this, "已发送测试数据");
                }

                if (!"test_media".equals(type)) {
                    syncAllHudComponents();
                }
                if (dialogHolder[0] != null)
                    dialogHolder[0].dismiss();
            });
            grid.addView(btn);
        };

        addButtonWithType.accept("系统时间", "time");
        addButtonWithType.accept("歌曲信息", "song");
        addButtonWithType.accept("剩余油量", "fuel");
        addButtonWithType.accept("车内温度", "temp_in");
        addButtonWithType.accept("车外温度", "temp_out");
        addButtonWithType.accept("续航里程", "range");
        addButtonWithType.accept("档位信息", "gear");
        addButtonWithType.accept("转向信号", "turn_signal");
        addButtonWithType.accept("系统音量", "volume");
        addButtonWithType.accept("媒体封面", "media_cover");

        // All buttons added above

        builder.setView(grid);
        dialogHolder[0] = builder.create();
        dialogHolder[0].show();
    }

    // Check if component already exists in Preview
    private boolean isHudComponentAdded(String type) {
        if ("test_media".equals(type))
            return false; // Always allow test
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
    }

    private void clearHudSelection() {
        mHudTestComponent = null;
        android.widget.FrameLayout preview = findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            for (int i = 0; i < preview.getChildCount(); i++) {
                View child = preview.getChildAt(i);
                child.setAlpha(1.0f);
            }
        }
    }

    private void setupDebugSwitch() {
        SwitchMaterial switchDebug = findViewById(R.id.switchDebug);

        if (!BuildConfig.DEBUG) {
            if (switchDebug != null)
                switchDebug.setVisibility(View.GONE);
            return;
        }

        if (switchDebug != null) {
            boolean isDebug = DebugLogger.isDebugEnabled(this);
            switchDebug.setChecked(isDebug);
            updateDebugViewsVisibility(isDebug);

            // Init label
            switchDebug.setText(isDebug ? "Debug Mode (ON)" : "Debug Mode (OFF)");

            switchDebug.setOnCheckedChangeListener((buttonView, isChecked) -> {
                DebugLogger.setDebugEnabled(this, isChecked);
                updateDebugViewsVisibility(isChecked);
                switchDebug.setText(isChecked ? "Debug Mode (ON)" : "Debug Mode (OFF)");
                // Sync to ClusterHudManager for green background
                ClusterHudManager.getInstance(this).setDebugMode(isChecked);
                if (isChecked) {
                    DebugLogger.toast(this, getString(R.string.debug_mode_enabled));
                } else {
                    Toast.makeText(this, R.string.debug_mode_disabled, Toast.LENGTH_SHORT).show();
                }
            });
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
        View layoutHeadlight = findViewById(R.id.layoutHeadlightStatus);
        if (layoutHeadlight != null) {
            layoutHeadlight.setVisibility(visibility);
        } else {
            // Fallback for individual items if wrapper not found
            View tvDipped = findViewById(R.id.tvDippedBeamStatus);
            if (tvDipped != null)
                tvDipped.setVisibility(visibility);
            View tvMain = findViewById(R.id.tvMainBeamStatus);
            if (tvMain != null)
                tvMain.setVisibility(visibility);
        }

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

    private void setupThemeSettings() {
        android.content.SharedPreferences prefs = getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        SwitchMaterial switchAutoTheme = findViewById(R.id.switchAutoTheme);
        switchAutoTheme.setChecked(prefs.getBoolean("auto_theme_sync", true));
        switchAutoTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("auto_theme_sync", isChecked).apply();
            DebugLogger.toast(this,
                    getString(isChecked ? R.string.auto_theme_sync_enabled : R.string.auto_theme_sync_disabled));
        });

    }

    private void setupSoundSwitches() {
        // Master Switch
        SwitchMaterial switchMaster = findViewById(R.id.switchSoundMaster);
        if (switchMaster != null) {
            // Default to TRUE to maintain backward compatibility
            boolean isMaster = ConfigManager.getInstance().getBoolean("sound_master_enabled", true);
            switchMaster.setChecked(isMaster);
            switchMaster.setOnCheckedChangeListener(
                    (v, isChecked) -> ConfigManager.getInstance().setBoolean("sound_master_enabled", isChecked));
        }

        setupSoundItem(R.id.switchSoundStart, R.id.btnSelectSoundStart, R.id.btnTestSoundStart,
                R.id.tvSoundStartFile, "sound_start");
        setupSoundItem(R.id.switchSoundGearD, R.id.btnSelectSoundGearD, R.id.btnTestSoundGearD,
                R.id.tvSoundGearDFile, "sound_gear_d");
        setupSoundItem(R.id.switchSoundGearN, R.id.btnSelectSoundGearN, R.id.btnTestSoundGearN,
                R.id.tvSoundGearNFile, "sound_gear_n");
        setupSoundItem(R.id.switchSoundGearR, R.id.btnSelectSoundGearR, R.id.btnTestSoundGearR,
                R.id.tvSoundGearRFile, "sound_gear_r");
        setupSoundItem(R.id.switchSoundGearP, R.id.btnSelectSoundGearP, R.id.btnTestSoundGearP,
                R.id.tvSoundGearPFile, "sound_gear_p");
        setupSoundItem(R.id.switchSoundDoorPassenger, R.id.btnSelectSoundDoorPassenger,
                R.id.btnTestSoundDoorPassenger, R.id.tvSoundDoorPassengerFile, "sound_door_passenger");

        configureTestButtonsVisibility();
    }

    private void setupSoundItem(int switchId, int btnId, int testBtnId,
            int tvFileId, String keyPrefix) {
        SwitchMaterial switchView = findViewById(switchId);
        Button btnSelect = findViewById(btnId);
        Button btnTest = findViewById(testBtnId);
        TextView tvFile = findViewById(tvFileId);
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
        java.io.File soundDir = new java.io.File(Environment.getExternalStorageDirectory(), "NaviTool/Sound");
        if (!soundDir.exists() || !soundDir.isDirectory()) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title_select_sound)
                    .setMessage(R.string.dialog_no_files_message)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
            return;
        }

        java.io.File[] files = soundDir
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav"));
        if (files == null || files.length == 0) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title_select_sound)
                    .setMessage(R.string.dialog_no_files_message)
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
            // Request Audio Focus
            android.media.AudioManager am = (android.media.AudioManager) getSystemService(Context.AUDIO_SERVICE);
            android.media.AudioFocusRequest focusRequest = null;
            android.media.AudioManager.OnAudioFocusChangeListener focusChangeListener = focusChange -> {
            };

            final android.media.AudioManager.OnAudioFocusChangeListener finalFocusListener = focusChangeListener;

            if (am != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    android.media.AudioAttributes playbackAttributes = new android.media.AudioAttributes.Builder()
                            .setUsage(android.media.AudioAttributes.USAGE_MEDIA)
                            .setContentType(android.media.AudioAttributes.CONTENT_TYPE_SPEECH)
                            .build();
                    focusRequest = new android.media.AudioFocusRequest.Builder(
                            android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                            .setAudioAttributes(playbackAttributes)
                            .setAcceptsDelayedFocusGain(false)
                            .setOnAudioFocusChangeListener(focusChangeListener)
                            .build();
                    am.requestAudioFocus(focusRequest);
                } else {
                    am.requestAudioFocus(focusChangeListener, android.media.AudioManager.STREAM_MUSIC,
                            android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                }
            }

            android.media.MediaPlayer mp = new android.media.MediaPlayer();
            try {
                mp.setDataSource(soundFile.getAbsolutePath());
                mp.prepare();
                mp.start();
                DebugLogger.d("MainActivity", "Test playing sound: " + resolvedName);

                final android.media.AudioFocusRequest finalRequest = focusRequest;
                mp.setOnCompletionListener(mediaPlayer -> {
                    mediaPlayer.release();
                    DebugLogger.d("MainActivity", "Test playing sound completed: " + resolvedName);
                    // Abandon Focus
                    if (am != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && finalRequest != null) {
                            am.abandonAudioFocusRequest(finalRequest);
                        } else {
                            am.abandonAudioFocus(finalFocusListener);
                        }
                    }
                });
            } catch (java.io.IOException e) {
                DebugLogger.e("MainActivity", "Failed to test play sound: " + resolvedName, e);
                e.printStackTrace();
                mp.release();
                // Abandon Focus on error
                if (am != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && focusRequest != null) {
                        am.abandonAudioFocusRequest(focusRequest);
                    } else {
                        am.abandonAudioFocus(finalFocusListener);
                    }
                }
            }
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
        // [Release] Always show test buttons, decoupled from debug mode
        int visibility = View.VISIBLE;
        setViewVisibility(R.id.btnTestSoundStart, visibility);
        setViewVisibility(R.id.btnTestSoundGearD, visibility);
        setViewVisibility(R.id.btnTestSoundGearN, visibility);
        setViewVisibility(R.id.btnTestSoundGearR, visibility);
        setViewVisibility(R.id.btnTestSoundGearP, visibility);
        setViewVisibility(R.id.btnTestSoundDoorPassenger, visibility);
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
                    Intent requestIntent = new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
                    sendBroadcast(requestIntent);
                }
            });
        }

        if (tvAutoModeStatus != null) {
            tvAutoModeStatus.setText(getString(R.string.status_auto_mode, getString(R.string.mode_unknown)));
        }

        // 24-25 Model Light Sensor Switch
        SwitchMaterial switch2425LightSensor = findViewById(R.id.switch2425LightSensor);
        if (switch2425LightSensor != null) {
            boolean is2425Enabled = ConfigManager.getInstance().getBoolean("enable_24_25_light_sensor", false);
            switch2425LightSensor.setChecked(is2425Enabled);
            switch2425LightSensor.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("enable_24_25_light_sensor", isChecked);
                if (isChecked) {
                    DebugLogger.toast(this, "已开启24-25款光感切换");
                }
            });
        }
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

        // PSD Always On Switch
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

        // Day Brightness
        SeekBar seekDay = findViewById(R.id.seekBrightnessDay);
        TextView tvDay = findViewById(R.id.tvBrightnessDay);
        int dayVal = ConfigManager.getInstance().getInt("override_day_value", 5);
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
            }
        });

        // Night Brightness
        SeekBar seekNight = findViewById(R.id.seekBrightnessNight);
        TextView tvNight = findViewById(R.id.tvBrightnessNight);
        int nightVal = ConfigManager.getInstance().getInt("override_night_value", 3);
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
            }
        });
    }

    // --- Buttons Tab Logic ---

    private void setupSteeringWheelControl() {
        SwitchMaterial switchSteeringWheel = findViewById(R.id.switchSteeringWheel);
        boolean isEnabled = ConfigManager.getInstance().getBoolean("steering_wheel_control", false);
        switchSteeringWheel.setChecked(isEnabled);
        switchSteeringWheel.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ConfigManager.getInstance().setBoolean("steering_wheel_control", isChecked);
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
        boolean isWechatEnabled = ConfigManager.getInstance().getBoolean("wechat_button_enabled", false);
        switchWechatButton.setChecked(isWechatEnabled);

        int shortPressActionIdx = ConfigManager.getInstance().getInt("wechat_short_press_action", 0);
        int longPressActionIdx = ConfigManager.getInstance().getInt("wechat_long_press_action", 0);
        spinnerShortPressAction.setSelection(shortPressActionIdx);
        spinnerLongPressAction.setSelection(longPressActionIdx);

        String shortPressAppPkg = ConfigManager.getInstance().getString("wechat_short_press_app", "");
        String longPressAppPkg = ConfigManager.getInstance().getString("wechat_long_press_app", "");
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
            ConfigManager.getInstance().setBoolean("wechat_button_enabled", isChecked);
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
                    AppLaunchManager.AppInfo app = apps.get(position - 1);
                    ConfigManager.getInstance().setString(key, app.packageName);
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

        // Notification Access Check (for Media)
        boolean hasNotifAccess = isNotificationServiceEnabled();
        // You might want to add a UI element for this later.
        // For now, if missing and HUD is on, toast or prompt.
        if (!hasNotifAccess && ConfigManager.getInstance().getBoolean("switch_hud", false)) {
            // Optional: Prompt user or show button
            View btn = findViewById(R.id.btnGrantNotification);
            if (btn != null) {
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(v -> {
                    try {
                        startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                    } catch (Exception e) {
                        DebugLogger.toast(this, "无法打开通知权限设置，请手动开启");
                    }
                });
            }
        }
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

    private void processNextRepair() {
        if (!isAutoRepairing)
            return;

        // 1. Accessibility Service
        if (!isAccessibilityServiceEnabled()) {
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
        if (!Settings.canDrawOverlays(this)) {
            if (AdbShell.getInstance(this).isConnected()) {
                showRepairingToast(R.string.perm_overlay);
                AdbShell.getInstance(this).exec("appops set " + getPackageName() + " SYSTEM_ALERT_WINDOW allow");
                scheduleNextCheck(1000, this::requestOverlayPermission, () -> Settings.canDrawOverlays(this));
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
        // Default to auto-connect
        AdbShell.getInstance(this).connect();

        // Manual Reconnect
        View layoutAdbStatus = findViewById(R.id.layoutAdbStatus);
        if (layoutAdbStatus != null) {
            layoutAdbStatus.setOnClickListener(v -> {
                DebugLogger.toast(this, "正在尝试重新连接 ADB...");
                AdbShell.getInstance(this).connect();
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

    private final android.content.BroadcastReceiver mHeadlightStatusReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_HEADLIGHT_STATUS".equals(intent.getAction())) {
                String type = intent.getStringExtra("type");
                int status = intent.getIntExtra("status", -1);

                TextView tvStatus = null;
                String statusText = (status == 1) ? getString(R.string.status_on) : getString(R.string.status_off);

                if ("dipped".equals(type)) {
                    tvStatus = findViewById(R.id.tvDippedBeamStatus);
                    if (tvStatus != null) {
                        tvStatus.setText(getString(R.string.status_dipped_beam_fmt, statusText));
                    }
                } else if ("main".equals(type)) {
                    tvStatus = findViewById(R.id.tvMainBeamStatus);
                    if (tvStatus != null) {
                        tvStatus.setText(getString(R.string.status_main_beam_fmt, statusText));
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

}
