package cn.navitool.controller;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.AppLaunchManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.utils.DebugLogger;

public class ButtonSettingsController {
    private final Activity mActivity;
    private final View mLayoutButtons;

    public ButtonSettingsController(Activity activity, View layoutButtons) {
        this.mActivity = activity;
        this.mLayoutButtons = layoutButtons;
    }

    public void setupButtons() {
        if (mLayoutButtons == null) return;
        setupSteeringWheelControl();
        setupWeChatButton();
    }

    private void setupSteeringWheelControl() {
        SwitchMaterial switchSteeringWheel = mLayoutButtons.findViewById(R.id.switchSteeringWheel);
        if (switchSteeringWheel == null) return;
        
        boolean isEnabled = ConfigManager.getInstance().getBoolean("steering_wheel_control_v2", false);
        switchSteeringWheel.setChecked(isEnabled);
        switchSteeringWheel.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ConfigManager.getInstance().setBoolean("steering_wheel_control_v2", isChecked);
            DebugLogger.toast(mActivity,
                    mActivity.getString(isChecked ? R.string.steering_wheel_enabled : R.string.steering_wheel_disabled));
        });
    }

    private void setupWeChatButton() {
        SwitchMaterial switchWechatButton = mLayoutButtons.findViewById(R.id.switchWechatButton);
        if (switchWechatButton == null) return;

        View layoutWechatShortPress = mLayoutButtons.findViewById(R.id.layoutWechatShortPress);
        View layoutWechatLongPress = mLayoutButtons.findViewById(R.id.layoutWechatLongPress);
        Spinner spinnerShortPressAction = mLayoutButtons.findViewById(R.id.spinnerShortPressAction);
        Spinner spinnerShortPressApp = mLayoutButtons.findViewById(R.id.spinnerShortPressApp);
        Spinner spinnerLongPressAction = mLayoutButtons.findViewById(R.id.spinnerLongPressAction);
        Spinner spinnerLongPressApp = mLayoutButtons.findViewById(R.id.spinnerLongPressApp);

        // Populate Spinners
        List<String> actionOptions = new ArrayList<>();
        actionOptions.add("- - - -");
        actionOptions.add(mActivity.getString(R.string.action_launch_app));
        actionOptions.add(mActivity.getString(R.string.action_kill_app));
        actionOptions.add(mActivity.getString(R.string.action_toggle_cluster));
        ArrayAdapter<String> actionAdapter = new ArrayAdapter<>(mActivity, android.R.layout.simple_spinner_item,
                actionOptions);
        actionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShortPressAction.setAdapter(actionAdapter);
        spinnerLongPressAction.setAdapter(actionAdapter);

        // Apps
        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(mActivity);
        List<String> appNames = new ArrayList<>();
        appNames.add("- - - -");
        for (AppLaunchManager.AppInfo app : apps) {
            appNames.add(app.name);
        }
        ArrayAdapter<String> appAdapter = new ArrayAdapter<>(mActivity, android.R.layout.simple_spinner_item, appNames);
        appAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerShortPressApp.setAdapter(appAdapter);
        spinnerLongPressApp.setAdapter(appAdapter);

        // Load Values from ConfigManager
        boolean isWechatEnabled = ConfigManager.getInstance().getBoolean("wechat_button_enabled_v2", false);
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
                if (position == 0) {
                    ConfigManager.getInstance().setString(key, "");
                } else if (position - 1 < apps.size()) {
                    ConfigManager.getInstance().setString(key, apps.get(position - 1).packageName);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
