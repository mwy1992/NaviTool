package cn.navitool.controller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;

import com.google.android.material.switchmaterial.SwitchMaterial;

import cn.navitool.R;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.NaviInfoManager;
import cn.navitool.managers.SunshadeManager;
import cn.navitool.managers.ThemeBrightnessManager;
import cn.navitool.managers.SimulateGear;
import cn.navitool.service.FloatingBallService;
import cn.navitool.utils.DebugLogger;

public class GeneralSettingsController {
    
    // --- 节日壁纸设置常量 ---
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

    private final Activity mActivity;
    private View mLayoutGeneral;
    private final ActivityResultLauncher<Intent> mOverlayPermissionLauncher;

    public GeneralSettingsController(Activity activity, View layoutGeneral, ActivityResultLauncher<Intent> overlayPermissionLauncher) {
        this.mActivity = activity;
        this.mLayoutGeneral = layoutGeneral;
        this.mOverlayPermissionLauncher = overlayPermissionLauncher;
    }

    public void setLayout(View layoutGeneral) {
        this.mLayoutGeneral = layoutGeneral;
    }

    public void setupGeneralSettings() {
        if (mLayoutGeneral == null) return;

        // Auto Theme Switch
        SwitchMaterial switchAutoTheme = mLayoutGeneral.findViewById(R.id.switchAutoTheme);
        if (switchAutoTheme != null) {
            boolean isAutoTheme = ConfigManager.getInstance().getBoolean("auto_theme_switch", false);
            switchAutoTheme.setChecked(isAutoTheme);
            switchAutoTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("auto_theme_switch", isChecked);
                if (isChecked) {
                    ThemeBrightnessManager.getInstance(mActivity).checkDayNightStatus(true);
                    DebugLogger.toast(mActivity, mActivity.getString(R.string.auto_theme_sync_enabled));
                } else {
                    DebugLogger.toast(mActivity, mActivity.getString(R.string.auto_theme_sync_disabled));
                }
            });
        }

        // Sunshade Control
        setupSunshadeControl();

        // Festival Wallpaper
        setupFestivalWallpaper();

        // Force Auto Day/Night
        setupForceAutoDayNight();

        // Floating Traffic Light
        setupFloatingTrafficLight();

        // Transmission Type Button
        setupTransmissionTypeButton();

        // Simulated Gear Switch
        setupSimulatedGearSwitch();

        // Desktop Floating Ball
        setupFloatingBall();
    }
    
    private void setupFloatingTrafficLight() {
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
                     NaviInfoManager.getInstance(mActivity).showTrafficLightFloating();
                     if (btnPosition != null)
                         btnPosition.setVisibility(View.VISIBLE);
                 } else {
                     NaviInfoManager.getInstance(mActivity).hideTrafficLightFloating();
                     if (btnPosition != null)
                         btnPosition.setVisibility(View.GONE);
                 }
             });
 
             if (btnPosition != null) {
                 btnPosition.setText(mActivity.getString(R.string.action_switch_style));
                 btnPosition.setOnClickListener(v -> {
                     NaviInfoManager.getInstance(mActivity).toggleFloatingStyle();
                     DebugLogger.toast(mActivity, "样式已切换，3秒后自动隐藏");
                 });
             }
         }
    }
    
    private void setupTransmissionTypeButton() {
        android.widget.Button btnTransmissionType = mLayoutGeneral.findViewById(R.id.btnTransmissionType);
        if (btnTransmissionType != null) {
            final int TYPE_8AT = 0;
            final int TYPE_7DCT = 1;

            int currentType = ConfigManager.getInstance().getInt("transmission_type", TYPE_8AT);
            btnTransmissionType.setText(currentType == TYPE_8AT ? "我是8AT车型" : "我是7DCT车型");

            SimulateGear.getInstance().setTransmissionType(currentType);

            btnTransmissionType.setOnClickListener(v -> {
                int type = ConfigManager.getInstance().getInt("transmission_type", TYPE_8AT);
                int newType = (type == TYPE_8AT) ? TYPE_7DCT : TYPE_8AT;

                ConfigManager.getInstance().setInt("transmission_type", newType);
                SimulateGear.getInstance().setTransmissionType(newType);

                btnTransmissionType.setText(newType == TYPE_8AT ? "我是8AT车型" : "我是7DCT车型");
                DebugLogger.toast(mActivity, newType == TYPE_8AT ? "已切换为 8AT 逻辑" : "已切换为 7DCT 逻辑");
            });
        }
    }
    
    private void setupSimulatedGearSwitch() {
        com.google.android.material.switchmaterial.SwitchMaterial switchSimGear = mLayoutGeneral
                .findViewById(R.id.switchSimulatedGear);
        if (switchSimGear != null) {
             android.widget.Button btnTransmissionType = mLayoutGeneral.findViewById(R.id.btnTransmissionType);
             
            boolean isEnabled = ConfigManager.getInstance().getBoolean("simulated_gear_enabled", false);
            switchSimGear.setChecked(isEnabled);
            ClusterHudManager.getInstance(mActivity).setSimulatedGearEnabled(isEnabled);

            // Initial button visibility
            if (btnTransmissionType != null) {
                btnTransmissionType.setVisibility(isEnabled ? View.VISIBLE : View.GONE);
            }

            switchSimGear.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("simulated_gear_enabled", isChecked);
                ClusterHudManager.getInstance(mActivity).setSimulatedGearEnabled(isChecked);
                if (isChecked) {
                    DebugLogger.toast(mActivity, mActivity.getString(R.string.toast_simulated_gear_enabled));
                }

                // Toggle button visibility
                if (btnTransmissionType != null) {
                    btnTransmissionType.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                }
            });
        }
    }

    private void setupFloatingBall() {
        SwitchMaterial switchFloatingBall = mLayoutGeneral.findViewById(R.id.switchFloatingBall);
        if (switchFloatingBall != null) {
            boolean isEnabled = ConfigManager.getInstance().getBoolean("floating_ball_enabled", false);
            switchFloatingBall.setChecked(isEnabled);

            // Restore state on init handled in switch logic mostly, checking permission
            if (isEnabled && Settings.canDrawOverlays(mActivity)) {
                 mActivity.startService(new Intent(mActivity, FloatingBallService.class));
            }

            switchFloatingBall.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("floating_ball_enabled", isChecked);
                if (isChecked) {
                    if (!Settings.canDrawOverlays(mActivity)) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:" + mActivity.getPackageName()));
                        mOverlayPermissionLauncher.launch(intent);
                        buttonView.setChecked(false);
                        ConfigManager.getInstance().setBoolean("floating_ball_enabled", false);
                        DebugLogger.toast(mActivity, "请先授予悬浮窗权限");
                    } else {
                        mActivity.startService(new Intent(mActivity, FloatingBallService.class));
                    }
                } else {
                    mActivity.stopService(new Intent(mActivity, FloatingBallService.class));
                }
            });
        }
    }

    private void setupSunshadeControl() {
        if (mLayoutGeneral == null) return;

        // Auto Open Switch
        SwitchMaterial swAutoOpen = mLayoutGeneral.findViewById(R.id.swSunshadeAutoOpen);
        if (swAutoOpen != null) {
            swAutoOpen.setChecked(SunshadeManager.getInstance(mActivity).isAutoOpenEnabled());
            swAutoOpen.setOnCheckedChangeListener((v, isChecked) -> {
                SunshadeManager.getInstance(mActivity).setAutoOpenEnabled(isChecked);
                if (isChecked)
                    DebugLogger.toast(mActivity, mActivity.getString(R.string.toast_sunshade_auto_enabled));
            });
        }

        // Night Mode Only Button
        com.google.android.material.button.MaterialButton btnNight = mLayoutGeneral
                .findViewById(R.id.btnSunshadeNightOnly);
        if (btnNight != null) {
            boolean isNightOnly = SunshadeManager.getInstance(mActivity).isNightModeOnly();
            updateSunshadeNightIcon(btnNight, isNightOnly);
            btnNight.setOnClickListener(v -> {
                boolean newState = !SunshadeManager.getInstance(mActivity).isNightModeOnly();
                SunshadeManager.getInstance(mActivity).setNightModeOnly(newState);
                updateSunshadeNightIcon(btnNight, newState);
            });
        }

        // Target Position Slider
        SeekBar sbPos = mLayoutGeneral.findViewById(R.id.sbSunshadePosition);
        if (sbPos != null) {
            sbPos.setProgress(SunshadeManager.getInstance(mActivity).getTargetPosition());
            sbPos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        SunshadeManager.getInstance(mActivity).setTargetPosition(progress);
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

    private void setupForceAutoDayNight() {
        SwitchMaterial switchForceAutoDayNight = mLayoutGeneral.findViewById(R.id.switchForceAutoDayNight);
        TextView tvAutoModeStatus = mLayoutGeneral.findViewById(R.id.tvAutoModeStatus);

        if (switchForceAutoDayNight != null) {
            boolean isForceAuto = ConfigManager.getInstance().getBoolean("force_auto_day_night", false);
            switchForceAutoDayNight.setChecked(isForceAuto);

            switchForceAutoDayNight.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("force_auto_day_night", isChecked);

                Intent intent = new Intent("cn.navitool.ACTION_FORCE_AUTO_MODE_CHANGED");
                intent.putExtra("enabled", isChecked);
                mActivity.sendBroadcast(intent);
            });
        }

        if (tvAutoModeStatus != null) {
            tvAutoModeStatus.setText(mActivity.getString(R.string.status_auto_mode, mActivity.getString(R.string.mode_unknown)));
        }

        // Always request status update on init
        Intent requestIntent = new Intent("cn.navitool.ACTION_REQUEST_DAY_NIGHT_STATUS");
        mActivity.sendBroadcast(requestIntent);
    }

    private void setupFestivalWallpaper() {
        android.widget.Spinner spinner = mLayoutGeneral.findViewById(R.id.spinnerFestivalWallpaper);
        if (spinner == null)
            return;

        android.widget.ArrayAdapter<CharSequence> adapter = android.widget.ArrayAdapter.createFromResource(
                mActivity, R.array.festival_options, android.R.layout.simple_spinner_item);
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
                        .getInstance(mActivity).getCarFunction();
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


}
