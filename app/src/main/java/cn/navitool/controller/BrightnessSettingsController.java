package cn.navitool.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import cn.navitool.R;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.ThemeBrightnessManager;
import cn.navitool.utils.DebugLogger;

public class BrightnessSettingsController {
    private final Activity mActivity;
    private final View mLayoutBrightness;

    public BrightnessSettingsController(Activity activity, View layoutBrightness) {
        this.mActivity = activity;
        this.mLayoutBrightness = layoutBrightness;
    }

    public void setupBrightness() {
        if (mLayoutBrightness == null) return;
        setupBrightnessSettings();
        setupPsdTestButtons();
    }

    private void setupBrightnessSettings() {
        // Brightness Override Controls
        final View layoutBrightnessSliders = mLayoutBrightness.findViewById(R.id.layoutBrightnessSliders);

        SwitchMaterial switchOverride = mLayoutBrightness.findViewById(R.id.switchBrightnessOverride);
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
        SwitchMaterial switchPsd = mLayoutBrightness.findViewById(R.id.switchPsdAlwaysOn);
        if (switchPsd != null) {
            boolean isPsdEnabled = ConfigManager.getInstance().getBoolean("psd_always_on_enabled", false);
            switchPsd.setChecked(isPsdEnabled);
            switchPsd.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("psd_always_on_enabled", isChecked);
                // Trigger Immediate Service Update via Broadcast
                Intent intent = new Intent("cn.navitool.ACTION_PSD_STATUS_CHANGED");
                intent.putExtra("enabled", isChecked);
                mActivity.sendBroadcast(intent);
            });
        }

        // PSD Always On Switch (Method 2)
        SwitchMaterial switchPsd2 = mLayoutBrightness.findViewById(R.id.switchPsdAlwaysOnMethod2);
        if (switchPsd2 != null) {
            boolean isPsd2Enabled = ConfigManager.getInstance().getBoolean("psd_always_on_method2_enabled", false);
            switchPsd2.setChecked(isPsd2Enabled);
            switchPsd2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean("psd_always_on_method2_enabled", isChecked);
                // Trigger Immediate Service Update via Broadcast
                Intent intent = new Intent("cn.navitool.ACTION_PSD_METHOD2_STATUS_CHANGED");
                intent.putExtra("enabled", isChecked);
                mActivity.sendBroadcast(intent);
            });
        }

        // Day Brightness
        SeekBar seekDay = mLayoutBrightness.findViewById(R.id.seekBrightnessDay);
        TextView tvDay = mLayoutBrightness.findViewById(R.id.tvBrightnessDay);
        if (seekDay != null && tvDay != null) {
            int dayVal = ConfigManager.getInstance().getInt("override_day_value", 12);
            seekDay.setProgress(dayVal);
            tvDay.setText(mActivity.getString(R.string.format_brightness_value, dayVal));
            seekDay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (progress < 1) {
                        seekBar.setProgress(1);
                        return;
                    }
                    tvDay.setText(mActivity.getString(R.string.format_brightness_value, progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    ConfigManager.getInstance().setInt("override_day_value", seekBar.getProgress());
                    DebugLogger.log(mActivity, "Brightness", "Saved Day: " + seekBar.getProgress());
                    ThemeBrightnessManager.getInstance(mActivity).setTargetBrightness(
                            seekBar.getProgress(),
                            ConfigManager.getInstance().getInt("override_night_value", 5),
                            ConfigManager.getInstance().getInt("override_avm_value", 15));
                }
            });
        }

        // Night Brightness
        SeekBar seekNight = mLayoutBrightness.findViewById(R.id.seekBrightnessNight);
        TextView tvNight = mLayoutBrightness.findViewById(R.id.tvBrightnessNight);
        if (seekNight != null && tvNight != null) {
            int nightVal = ConfigManager.getInstance().getInt("override_night_value", 5);
            seekNight.setProgress(nightVal);
            tvNight.setText(mActivity.getString(R.string.format_brightness_value, nightVal));
            seekNight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (progress < 1) {
                        seekBar.setProgress(1);
                        return;
                    }
                    tvNight.setText(mActivity.getString(R.string.format_brightness_value, progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    ConfigManager.getInstance().setInt("override_night_value", seekBar.getProgress());
                    DebugLogger.log(mActivity, "Brightness", "Saved Night: " + seekBar.getProgress());
                    ThemeBrightnessManager.getInstance(mActivity).setTargetBrightness(
                            ConfigManager.getInstance().getInt("override_day_value", 12),
                            seekBar.getProgress(),
                            ConfigManager.getInstance().getInt("override_avm_value", 15));
                }
            });
        }

        // AVM Brightness
        SeekBar seekAvm = mLayoutBrightness.findViewById(R.id.seekBrightnessAvm);
        TextView tvAvm = mLayoutBrightness.findViewById(R.id.tvBrightnessAvm);
        if (seekAvm != null && tvAvm != null) {
            int avmVal = ConfigManager.getInstance().getInt("override_avm_value", 15);
            seekAvm.setProgress(avmVal);
            tvAvm.setText(mActivity.getString(R.string.format_brightness_value, avmVal));
            seekAvm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (progress < 1) {
                        seekBar.setProgress(1);
                        return;
                    }
                    tvAvm.setText(mActivity.getString(R.string.format_brightness_value, progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    ConfigManager.getInstance().setInt("override_avm_value", seekBar.getProgress());
                    DebugLogger.log(mActivity, "Brightness", "Saved AVM: " + seekBar.getProgress());
                    ThemeBrightnessManager.getInstance(mActivity).setTargetBrightness(
                            ConfigManager.getInstance().getInt("override_day_value", 12),
                            ConfigManager.getInstance().getInt("override_night_value", 5),
                            seekBar.getProgress());
                }
            });
        }
    }

    private void setupPsdTestButtons() {
        // Find wrapper layout to control visibility based on Debug mode
        View layoutTestButtons = mLayoutBrightness.findViewById(R.id.layoutPsdTestButtons);

        SharedPreferences prefs = mActivity.getSharedPreferences("navitool_prefs", Context.MODE_PRIVATE);
        boolean isDebug = prefs.getBoolean("config_debug_mode_enabled", false);
        if (layoutTestButtons != null) {
            layoutTestButtons.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        }

        if (mLayoutBrightness.findViewById(R.id.btnTestPsd0ms) != null) {
            mLayoutBrightness.findViewById(R.id.btnTestPsd0ms).setOnClickListener(v -> {
                Intent intent = new Intent("cn.navitool.ACTION_TEST_PSD_SWITCH");
                intent.putExtra("delay", 0);
                mActivity.sendBroadcast(intent);
                DebugLogger.toast(mActivity, "Sent 0ms PSD Switch Test");
            });
        }

        if (mLayoutBrightness.findViewById(R.id.btnTestPsd1ms) != null) {
            mLayoutBrightness.findViewById(R.id.btnTestPsd1ms).setOnClickListener(v -> {
                Intent intent = new Intent("cn.navitool.ACTION_TEST_PSD_SWITCH");
                intent.putExtra("delay", 1);
                mActivity.sendBroadcast(intent);
                DebugLogger.toast(mActivity, "Sent 1ms PSD Switch Test");
            });
        }
    }

    public void updateDebugViewsVisibility(boolean isDebug) {
        View layoutPsdTest = mLayoutBrightness.findViewById(R.id.layoutPsdTestButtons);
        if (layoutPsdTest != null) {
            layoutPsdTest.setVisibility(isDebug ? View.VISIBLE : View.GONE);
        }
    }
}
