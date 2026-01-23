package cn.navitool.controller;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.AppLaunchManager;
import cn.navitool.utils.DebugLogger;

public class AutoStartController {
    private final Activity mActivity;

    public AutoStartController(Activity activity) {
        this.mActivity = activity;
    }

    public void setupAutoStartApps() {
        SwitchMaterial switchAutoStart = mActivity.findViewById(R.id.switchAutoStartApps);
        SwitchMaterial switchReturnToHome = mActivity.findViewById(R.id.switchReturnToHome);
        ImageButton btnAddApp = mActivity.findViewById(R.id.btnAddApp);
        Button btnTestLaunch = mActivity.findViewById(R.id.btnTestLaunch);
        LinearLayout llAutoStartAppsList = mActivity.findViewById(R.id.llAutoStartAppsList);

        if (switchAutoStart == null || llAutoStartAppsList == null) return;

        boolean isAutoStartEnabled = AppLaunchManager.isAutoStartEnabled(mActivity);
        boolean isReturnToHomeEnabled = AppLaunchManager.isReturnToHomeEnabled(mActivity);
        List<AppLaunchManager.AppConfig> savedConfigs = AppLaunchManager.loadConfig(mActivity);

        switchAutoStart.setChecked(isAutoStartEnabled);
        if (switchReturnToHome != null) switchReturnToHome.setChecked(isReturnToHomeEnabled);

        llAutoStartAppsList.removeAllViews();
        if (savedConfigs != null) {
            for (AppLaunchManager.AppConfig config : savedConfigs) {
                addAppConfigRow(llAutoStartAppsList, config);
            }
        }

        updateAutoStartUI(isAutoStartEnabled, btnAddApp, llAutoStartAppsList, switchReturnToHome, btnTestLaunch);

        switchAutoStart.setOnCheckedChangeListener((buttonView, isChecked) -> {
            AppLaunchManager.setAutoStartEnabled(mActivity, isChecked);
            updateAutoStartUI(isChecked, btnAddApp, llAutoStartAppsList, switchReturnToHome, btnTestLaunch);
        });

        if (switchReturnToHome != null) {
            switchReturnToHome.setOnCheckedChangeListener((buttonView, isChecked) -> {
                AppLaunchManager.setReturnToHomeEnabled(mActivity, isChecked);
                DebugLogger.toast(mActivity, isChecked ? mActivity.getString(R.string.toast_return_home_enabled)
                        : mActivity.getString(R.string.toast_return_home_disabled));
            });
        }

        if (btnAddApp != null) {
            btnAddApp.setOnClickListener(v -> {
                addAppConfigRow(llAutoStartAppsList, null);
                llAutoStartAppsList.setVisibility(View.VISIBLE);
            });
        }

        if (btnTestLaunch != null) {
            btnTestLaunch.setOnClickListener(v -> {
                DebugLogger.toast(mActivity, mActivity.getString(R.string.toast_test_start));
                AppLaunchManager.executeLaunch(mActivity);
            });
        }
    }

    private void updateAutoStartUI(boolean enabled, View btnAdd, View list, View switchReturn, View btnTest) {
        int visibility = enabled ? View.VISIBLE : View.GONE;
        if (btnAdd != null) btnAdd.setVisibility(visibility);
        if (switchReturn != null) switchReturn.setVisibility(visibility);
        if (btnTest != null) btnTest.setVisibility(visibility);

        if (list != null) {
            if (enabled && ((LinearLayout) list).getChildCount() > 0) {
                list.setVisibility(View.VISIBLE);
            } else {
                list.setVisibility(View.GONE);
            }
        }
    }

    private void addAppConfigRow(LinearLayout container, AppLaunchManager.AppConfig initialConfig) {
        View itemView = mActivity.getLayoutInflater().inflate(R.layout.item_app_auto_start, container, false);

        Spinner spinner = itemView.findViewById(R.id.spinnerAppSelection);
        EditText etDelay = itemView.findViewById(R.id.etLaunchDelay);
        ImageButton btnDelete = itemView.findViewById(R.id.btnDeleteConfig);

        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(mActivity);
        List<String> displayNames = new ArrayList<>();
        displayNames.add("- - - -");
        for (AppLaunchManager.AppInfo app : apps) {
            displayNames.add(app.name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mActivity, android.R.layout.simple_spinner_item, displayNames);
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

        etDelay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
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
        LinearLayout container = mActivity.findViewById(R.id.llAutoStartAppsList);
        if (container == null) return;
        
        List<AppLaunchManager.AppConfig> configs = new ArrayList<>();
        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(mActivity);

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
        AppLaunchManager.saveConfig(mActivity, configs);
    }
}
