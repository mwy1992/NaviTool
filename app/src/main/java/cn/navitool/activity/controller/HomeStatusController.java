package cn.navitool.activity.controller;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cn.navitool.R;
import cn.navitool.utils.AdbShell;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.PermissionManager;
import cn.navitool.utils.DebugLogger;
import cn.navitool.utils.SimulateFunction;
import cn.navitool.activity.MainActivity;

public class HomeStatusController {
    private final Activity mActivity;
    private View mRootView; // Can be Activity root or specific tab

    // Permission Dialog
    private AlertDialog permissionDialog;
    private View mPermissionDialogView;

    // Simulation
    private SimulateFunction mSimulateFunction;
    private boolean mSimulateAmapNightMode = false;

    // Receivers
    private final BroadcastReceiver adbStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ADB_STATUS_CHANGED".equals(intent.getAction())) {
                String status = intent.getStringExtra("status");
                ImageView imgAdbStatus = mActivity.findViewById(R.id.imgAdbStatus);
                TextView tvAdbStatus = mActivity.findViewById(R.id.tvAdbStatusText);

                if (imgAdbStatus != null && status != null) {
                    if (tvAdbStatus != null) {
                        tvAdbStatus.setText(status);
                    }

                    if (status.contains("已连接")) {
                        imgAdbStatus.setImageResource(R.drawable.ic_check);
                        imgAdbStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
                        DebugLogger.toast(mActivity, status);
                        autoRepairPermissionsSilent();
                    } else if (status.contains("连接失败")) {
                        imgAdbStatus.setImageResource(R.drawable.ic_close);
                        imgAdbStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
                        DebugLogger.toast(mActivity, status);
                    } else {
                        imgAdbStatus.setImageResource(R.drawable.ic_close);
                        imgAdbStatus.setColorFilter(ContextCompat.getColor(mActivity, android.R.color.darker_gray));
                    }
                }
            }
        }
    };

    private final BroadcastReceiver mPsdStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("cn.navitool.ACTION_PSD_STATUS".equals(intent.getAction())) {
                int status = intent.getIntExtra("status", -1);
                long timestamp = intent.getLongExtra("timestamp", 0);

                TextView tvPsdStatus = mActivity.findViewById(R.id.tvPsdStatus);
                if (tvPsdStatus != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
                    String timeStr = (timestamp > 0) ? sdf.format(new Date(timestamp)) : "--";
                    String statusStr = (status == 1) ? "ON" : (status == 0 ? "OFF" : "Unknown");

                    String text = String.format("PSD Status: %s (Last Event: %s)", statusStr, timeStr);
                    tvPsdStatus.setText(text);
                }
            }
        }
    };

    public HomeStatusController(Activity activity) {
        this.mActivity = activity;
    }

    public void setupHome() {
        setupSystemInfo();
        setupPermissionStatuses();
        setupAdbWireless();
    }

    public void onResume() {
        // Register Receivers
        IntentFilter adbFilter = new IntentFilter("cn.navitool.ADB_STATUS_CHANGED");
        mActivity.registerReceiver(adbStatusReceiver, adbFilter);

        IntentFilter psdFilter = new IntentFilter("cn.navitool.ACTION_PSD_STATUS");
        mActivity.registerReceiver(mPsdStatusReceiver, psdFilter);
        
        // Request ADB Status
        AdbShell.getInstance(mActivity).broadcastStatus();
    }

    public void onPause() {
        try {
            mActivity.unregisterReceiver(adbStatusReceiver);
            mActivity.unregisterReceiver(mPsdStatusReceiver);
        } catch (IllegalArgumentException e) {
            // Ignore if not registered
        }
    }

    private void setupSystemInfo() {
        TextView tvBootTime = mActivity.findViewById(R.id.tvBootTime);
        if (tvBootTime != null) {
            long bootTime = System.currentTimeMillis() - android.os.SystemClock.elapsedRealtime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            tvBootTime.setText("Boot Time: " + sdf.format(new Date(bootTime)));
        }

        setupDeleteLogsButton();
        setupSimulateEngineStartButton();
    }

    private void setupDeleteLogsButton() {
        View btnDeleteLogs = mActivity.findViewById(R.id.btnDeleteLogs);
        if (btnDeleteLogs != null) {
            btnDeleteLogs.setOnClickListener(v -> {
                DebugLogger.deleteAllLogs();
                DebugLogger.toastAlways(mActivity, mActivity.getString(R.string.toast_logs_deleted));
            });
        }
    }

    private void setupSimulateEngineStartButton() {
        if (mSimulateFunction == null) {
            mSimulateFunction = new SimulateFunction(mActivity);
        }
        
        View btnSimulate = mActivity.findViewById(R.id.btnSimulateEngineStart);
        mSimulateFunction.setupEngineStartButton(btnSimulate);
        
        MaterialButton btnTurnSignal = mActivity.findViewById(R.id.btnSimulateTurnSignal);
        mSimulateFunction.setupTurnSignalButton(btnTurnSignal);

        MaterialButton btnAmapTheme = mActivity.findViewById(R.id.btnSimulateAmapTheme);
        if (btnAmapTheme != null) {
             btnAmapTheme.setOnClickListener(v -> {
                 mSimulateAmapNightMode = !mSimulateAmapNightMode;
                 int mode = mSimulateAmapNightMode ? 2 : 1;
                 sendAutoNaviBroadcast(mode);
                 DebugLogger.toast(mActivity, "模拟高德: " + (mode == 1 ? "白天" : "黑夜"));
             });
        }

        MaterialButton btnHudGreenBg = mActivity.findViewById(R.id.btnHudGreenBg);
        if (btnHudGreenBg != null) {
            boolean isEnabled = ConfigManager.getInstance().getBoolean("hud_green_bg_enabled", false);
            updateHudGreenBgButton(btnHudGreenBg, isEnabled);

            btnHudGreenBg.setOnClickListener(v -> {
                boolean newState = !ConfigManager.getInstance().getBoolean("hud_green_bg_enabled", false);
                ConfigManager.getInstance().setBoolean("hud_green_bg_enabled", newState);
                ClusterHudManager.getInstance(mActivity).setHudGreenBgEnabled(newState);
                updateHudGreenBgButton(btnHudGreenBg, newState);
                DebugLogger.toast(mActivity, newState ? "HUD 浅绿底色已开启" : "HUD 浅绿底色已关闭");
            });
        }
    }

    private void updateHudGreenBgButton(MaterialButton btn, boolean isEnabled) {
        btn.setIconResource(isEnabled ? R.drawable.ic_check : R.drawable.ic_close);
        btn.setText(isEnabled ? "HUD浅绿(开)" : "HUD浅绿(关)");
    }
    
    private void sendAutoNaviBroadcast(int mode) {
        Intent intent = new Intent("AUTONAVI_STANDARD_BROADCAST_RECV");
        intent.putExtra("KEY_TYPE", 10034);
        intent.putExtra("EXTRA_DAY_NIGHT_MODE", mode);
        mActivity.sendBroadcast(intent);
    }

    private void setupAdbWireless() {
        new Thread(() -> {
            AdbShell.getInstance(mActivity).connect();
        }).start();

        View layoutAdbStatus = mActivity.findViewById(R.id.layoutAdbStatus);
        if (layoutAdbStatus != null) {
            layoutAdbStatus.setOnClickListener(v -> {
                DebugLogger.toast(mActivity, "正在尝试重新连接 ADB...");
                new Thread(() -> AdbShell.getInstance(mActivity).connect()).start();
            });
        }
        
        // Initial permission check after ADB setup? 
        // Logic from MainActivity: adbStatusReceiver triggers autoRepairPermissionsSilent
    }

    private void autoRepairPermissionsSilent() {
        if (!AdbShell.getInstance(mActivity).isConnected())
            return;
        DebugLogger.i("AutoRepair", "Starting Silent Permission Repair...");
        PermissionManager.getInstance(mActivity).startAutoRepair((MainActivity) mActivity);
    }

    private void setupPermissionStatuses() {
        View view = mActivity.findViewById(R.id.statusAppPermissions);
        if (view != null) {
            TextView txtName = view.findViewById(R.id.txtPermissionName);
            if (txtName != null) txtName.setText(R.string.title_app_permissions);
            view.setOnClickListener(v -> showPermissionDialog());
        }
    }

    private void showPermissionDialog() {
        if (permissionDialog != null && permissionDialog.isShowing()) {
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        mPermissionDialogView = mActivity.getLayoutInflater().inflate(R.layout.dialog_permissions, null);
        builder.setView(mPermissionDialogView);
        builder.setCancelable(true);

        permissionDialog = builder.create();
        if (permissionDialog.getWindow() != null) {
            permissionDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        permissionDialog.show();
        
        setupPermissionDialogItems(mPermissionDialogView);
        refreshPermissionDialog(mPermissionDialogView);
    }
    
    private void setupPermissionDialogItems(View dialogView) {
        setupDialogItem(dialogView, R.id.dialogStatusAccessibility, R.string.perm_accessibility,
                () -> PermissionManager.getInstance(mActivity).requestAccessibilityPermission(mActivity, this::checkPermissions));
        setupDialogItem(dialogView, R.id.dialogStatusOverlay, R.string.perm_overlay,
                () -> PermissionManager.getInstance(mActivity).requestOverlayPermission((MainActivity) mActivity, this::checkPermissions));
        setupDialogItem(dialogView, R.id.dialogStatusStorage, R.string.perm_storage,
                () -> PermissionManager.getInstance(mActivity).requestStoragePermission((MainActivity) mActivity, this::checkPermissions));
        setupDialogItem(dialogView, R.id.dialogStatusBattery, R.string.perm_battery,
                () -> PermissionManager.getInstance(mActivity).requestBatteryOptimization(mActivity, this::checkPermissions));
        setupDialogItem(dialogView, R.id.dialogStatusAutoStart, R.string.perm_auto_start,
                () -> PermissionManager.getInstance(mActivity).requestAutoStart(mActivity));
        setupDialogItem(dialogView, R.id.dialogStatusSecureSettings, R.string.perm_secure_settings,
                () -> PermissionManager.getInstance(mActivity).requestSecureSettingsPermission(mActivity, this::checkPermissions));
        setupDialogItem(dialogView, R.id.dialogStatusNotification, R.string.perm_notification_listener,
                () -> PermissionManager.getInstance(mActivity).requestNotificationPermission(mActivity, this::checkPermissions));

        Button btnAutoRepair = dialogView.findViewById(R.id.btnAutoRepair);
        if (btnAutoRepair != null) {
             btnAutoRepair.setOnClickListener(v -> PermissionManager.getInstance(mActivity).startAutoRepair((MainActivity) mActivity));
        }
    }

    private void setupDialogItem(View dialogView, int viewId, int nameResId, Runnable onClickAction) {
        View view = dialogView.findViewById(viewId);
        if (view != null) {
            TextView txtName = view.findViewById(R.id.txtPermissionName);
            if (txtName != null) txtName.setText(nameResId);
            view.setOnClickListener(v -> onClickAction.run());
        }
    }

    private void refreshPermissionDialog(View dialogView) {
        if (dialogView == null) return;
        PermissionManager pm = PermissionManager.getInstance(mActivity);

        updateDialogStatusItem(dialogView, R.id.dialogStatusAccessibility, pm.isAccessibilityServiceEnabled());
        updateDialogStatusItem(dialogView, R.id.dialogStatusOverlay, pm.canDrawOverlays());
        updateDialogStatusItem(dialogView, R.id.dialogStatusStorage, pm.hasStoragePermission());
        updateDialogStatusItem(dialogView, R.id.dialogStatusBattery, pm.isIgnoringBatteryOptimizations());
        updateDialogStatusItem(dialogView, R.id.dialogStatusAutoStart, true);
        updateDialogStatusItem(dialogView, R.id.dialogStatusSecureSettings, pm.hasSecureSettingsPermission());
        updateDialogStatusItem(dialogView, R.id.dialogStatusNotification, pm.isNotificationListenerEnabled());
    }

    private void updateDialogStatusItem(View dialogView, int viewId, boolean granted) {
        View view = dialogView.findViewById(viewId);
        if (view != null) {
            ImageView imgStatus = view.findViewById(R.id.imgStatus);
            if (imgStatus != null) {
                if (granted) {
                    imgStatus.setImageResource(R.drawable.ic_check);
                    imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
                } else {
                    imgStatus.setImageResource(R.drawable.ic_close);
                    imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
                }
            }
        }
    }

    public void checkPermissions() {
        PermissionManager pm = PermissionManager.getInstance(mActivity);

        boolean isOverlayGranted = pm.canDrawOverlays();
        boolean isStorageGranted = pm.hasStoragePermission();
        boolean isAccessibilityGranted = pm.isAccessibilityServiceEnabled();
        boolean isBatteryGranted = pm.isIgnoringBatteryOptimizations();
        boolean isSecureSettingsGranted = pm.hasSecureSettingsPermission();
        boolean isNotificationGranted = pm.isNotificationListenerEnabled();

        boolean allGranted = isOverlayGranted && isStorageGranted && isAccessibilityGranted && isBatteryGranted
                && isSecureSettingsGranted && isNotificationGranted;

        View view = mActivity.findViewById(R.id.statusAppPermissions);
        if (view != null) {
            ImageView imgStatus = view.findViewById(R.id.imgStatus);
            if (imgStatus != null) {
                if (allGranted) {
                    imgStatus.setImageResource(R.drawable.ic_check);
                    imgStatus.setColorFilter(android.graphics.Color.parseColor("#4CAF50"));
                } else {
                    imgStatus.setImageResource(R.drawable.ic_close);
                    imgStatus.setColorFilter(android.graphics.Color.parseColor("#F44336"));
                }
            }
        }

        if (permissionDialog != null && permissionDialog.isShowing() && mPermissionDialogView != null) {
            refreshPermissionDialog(mPermissionDialogView);
        }
    }
}
