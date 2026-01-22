package cn.navitool.activity.controller;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.CustomThemeManager;
import cn.navitool.managers.PresentationManager;
import cn.navitool.utils.DebugLogger;

public class ClusterSettingsController {
    private final Activity mActivity;
    private View mLayoutCluster;
    private String mSelectedClusterTheme = "1";

    public ClusterSettingsController(Activity activity, View layoutCluster) {
        this.mActivity = activity;
        this.mLayoutCluster = layoutCluster;
    }

    public void setupCluster() {
        if (mLayoutCluster == null) return;

        SwitchMaterial switchCluster = mLayoutCluster.findViewById(R.id.switchCluster);
        if (switchCluster != null) {
            // Load Saved State
            boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("switch_cluster", false);
            switchCluster.setChecked(isClusterEnabled);
            ClusterHudManager.getInstance(mActivity).setClusterEnabled(isClusterEnabled);

            switchCluster.setOnCheckedChangeListener((buttonView, isChecked) -> {
                DebugLogger.action("MainActivity", "Cluster开关切换: " + isChecked);
                ClusterHudManager.getInstance(mActivity).setClusterEnabled(isChecked);
                ConfigManager.getInstance().setBoolean("switch_cluster", isChecked);
            });
        }
        setupClusterThemeSelector();
    }

    public void setupClusterThemeSelector() {
        if (mLayoutCluster == null) return;

        // Setup Import Button
        Button btnImport = mLayoutCluster.findViewById(R.id.btnImportTheme);
        if (btnImport != null) {
            btnImport.setOnClickListener(v -> importThemes());
        }

        // Load saved theme
        mSelectedClusterTheme = ConfigManager.getInstance().getString("cluster_theme_id", "1");

        // Initial Theme List Refresh
        refreshClusterThemeList();

        // Setup Audi RS built-in theme handlers
        setupAudiRsThemeHandlers();

        // Ensure cluster is shown if previously enabled
        boolean isClusterEnabled = ConfigManager.getInstance().getBoolean("is_cluster_enabled", false);

        SwitchMaterial switchCluster = mLayoutCluster.findViewById(R.id.switchCluster);
        View layoutContent = mLayoutCluster.findViewById(R.id.layoutClusterContent);

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
                ClusterHudManager.getInstance(mActivity).setClusterEnabled(isChecked);
                if (isChecked) {
                    DebugLogger.toast(mActivity, "仪表已开启");
                } else {
                    DebugLogger.toast(mActivity, "仪表已关闭");
                }
            });
        } else {
             // Fallback logic
             if (isClusterEnabled) {
                 ClusterHudManager.getInstance(mActivity).setClusterEnabled(false);
                 ClusterHudManager.getInstance(mActivity).setClusterEnabled(true);
             }
        }

         // Test Button Logic
        if (mLayoutCluster.findViewById(R.id.btnClusterTestSpeed) != null) {
            mLayoutCluster.findViewById(R.id.btnClusterTestSpeed).setOnClickListener(v -> {
                DebugLogger.toast(mActivity, "Simulating Speed...");
                new Thread(() -> {
                    DebugLogger.d("MN_Tag", "Starting Speed Simulation");
                    for (int i = 0; i <= 270; i += 1) {
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                        final int speed = i;
                        mActivity.runOnUiThread(() -> ClusterHudManager.getInstance(mActivity).updateSpeed(speed));
                    }
                    for (int i = 260; i >= 0; i -= 1) {
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                        final int speed = i;
                        mActivity.runOnUiThread(() -> ClusterHudManager.getInstance(mActivity).updateSpeed(speed));
                    }
                    DebugLogger.d("MN_Tag", "Speed Simulation Complete");
                }).start();
            });
        }

        if (mLayoutCluster.findViewById(R.id.btnClusterTestRpm) != null) {
            mLayoutCluster.findViewById(R.id.btnClusterTestRpm).setOnClickListener(v -> {
                new Thread(() -> {
                    for (int i = 0; i <= 8000; i += 50) {
                        final int rpm = i;
                        mActivity.runOnUiThread(() -> ClusterHudManager.getInstance(mActivity).updateRpm(rpm));
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                    }
                    for (int i = 8000; i >= 0; i -= 50) {
                        final int rpm = i;
                        mActivity.runOnUiThread(() -> ClusterHudManager.getInstance(mActivity).updateRpm(rpm));
                        try {
                            Thread.sleep(30); // 慢速动画
                        } catch (InterruptedException e) {
                        }
                    }
                }).start();
            });
        }

        if (mLayoutCluster.findViewById(R.id.btnClusterTestGear) != null) {
            mLayoutCluster.findViewById(R.id.btnClusterTestGear).setOnClickListener(v -> {
                ClusterHudManager.getInstance(mActivity).cycleGear();
            });
        }
    }

    private void importThemes() {
        List<String> available = CustomThemeManager.getInstance(mActivity).getAvailableExternalThemes();
        if (available.isEmpty()) {
            DebugLogger.toast(mActivity, "未找到可用主题 (SD/Monjaro/NaviTool/Themes)");
            return;
        }

        String[] themes = available.toArray(new String[0]);
        new androidx.appcompat.app.AlertDialog.Builder(mActivity)
                .setTitle("选择要导入的主题")
                .setItems(themes, (dialog, which) -> {
                    String selected = themes[which];
                    boolean success = CustomThemeManager.getInstance(mActivity).importTheme(selected);
                    if (success) {
                        DebugLogger.toast(mActivity, "导入成功: " + selected);
                        refreshClusterThemeList();
                    } else {
                        DebugLogger.toast(mActivity, "导入失败");
                    }
                })
                .show();
    }

    private void refreshClusterThemeList() {
        LinearLayout container = mLayoutCluster.findViewById(R.id.layoutThemeContainer);
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
        View audiRsItem = container.getChildAt(1);
        if (audiRsItem != null) {
            audiRsItem.setTag("audi_rs");
        }

        // Add Imported Themes only
        List<String> importedThemes = CustomThemeManager.getInstance(mActivity).getImportedThemes();
        for (String themeName : importedThemes) {
            View itemView = createThemeItemView(themeName);
            container.addView(itemView);
        }

        updateClusterThemeUI();
    }

    private View createThemeItemView(String themeName) {
        FrameLayout layout = new FrameLayout(mActivity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(480, 180);
        params.setMarginEnd(32);
        layout.setLayoutParams(params);
        layout.setBackgroundResource(R.drawable.bg_cluster_normal);
        layout.setClickable(true);
        layout.setFocusable(true);
        layout.setTag(themeName);
        layout.setOnClickListener(v -> selectClusterTheme(themeName));

        TextView tv = new TextView(mActivity);
        tv.setText(themeName);
        tv.setTextColor(Color.parseColor("#CCCCCC"));
        FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        tvParams.gravity = Gravity.CENTER;
        layout.addView(tv, tvParams);

        ImageView ivCheck = new ImageView(mActivity);
        ivCheck.setImageResource(R.drawable.ic_check);
        ivCheck.setColorFilter(Color.parseColor("#4CAF50"));
        ivCheck.setVisibility(View.GONE);
        FrameLayout.LayoutParams ivParams = new FrameLayout.LayoutParams(48, 48);
        ivParams.gravity = Gravity.TOP | Gravity.END;
        ivParams.setMargins(16, 16, 16, 16);
        layout.addView(ivCheck, ivParams);

        return layout;
    }

    private void selectClusterTheme(String themeId) {
        mSelectedClusterTheme = themeId;
        ConfigManager.getInstance().setString("cluster_theme_id", themeId);
        updateClusterThemeUI();

        // Notify Manager
        ClusterHudManager.getInstance(mActivity).applyClusterTheme(themeId);
        DebugLogger.toast(mActivity, "已切换至: " + themeId);
    }

    private void updateClusterThemeUI() {
        LinearLayout container = mLayoutCluster.findViewById(R.id.layoutThemeContainer);
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
                // Fallback for programmatic views
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

    private void setupAudiRsThemeHandlers() {
        View themeDefault = mLayoutCluster.findViewById(R.id.layoutClusterTheme1);
        View themeAudiRs = mLayoutCluster.findViewById(R.id.layoutClusterThemeAudiRs);
        View checkDefault = mLayoutCluster.findViewById(R.id.ivClusterCheck1);
        View checkAudiRs = mLayoutCluster.findViewById(R.id.ivClusterCheckAudiRs);

        // Load saved Audi RS theme state
        int savedTheme = ConfigManager.getInstance().getInt("cluster_theme_builtin",
                PresentationManager.THEME_DEFAULT);
        updateAudiRsThemeCheckmarks(savedTheme, checkDefault, checkAudiRs, themeDefault, themeAudiRs);

        // Apply saved theme on startup
        ClusterHudManager.getInstance(mActivity).setClusterTheme(savedTheme);

        // Audi RS theme click handler
        if (themeAudiRs != null) {
            themeAudiRs.setOnClickListener(v -> {
                DebugLogger.action("MainActivity", "切换仪表主题: 奥迪RS");
                ClusterHudManager.getInstance(mActivity).setClusterTheme(PresentationManager.THEME_AUDI_RS);
                ConfigManager.getInstance().setInt("cluster_theme_builtin", PresentationManager.THEME_AUDI_RS);
                updateAudiRsThemeCheckmarks(PresentationManager.THEME_AUDI_RS, checkDefault, checkAudiRs,
                        themeDefault, themeAudiRs);
            });
        }

        // Default theme click handler
        if (themeDefault != null) {
            themeDefault.setOnClickListener(v -> {
                DebugLogger.action("MainActivity", "切换仪表主题: 默认");
                ClusterHudManager.getInstance(mActivity).setClusterTheme(PresentationManager.THEME_DEFAULT);
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

        if (themeDefault != null)
            themeDefault
                    .setBackgroundResource(isDefault ? R.drawable.bg_cluster_selected : R.drawable.bg_cluster_normal);
        if (themeAudiRs != null)
            themeAudiRs
                    .setBackgroundResource(isAudi ? R.drawable.bg_cluster_selected : R.drawable.bg_cluster_normal);
                    
        // Update Dynamic Items (Imported)
        LinearLayout container = mLayoutCluster.findViewById(R.id.layoutThemeContainer);
        if (container != null) {
            for (int i = 2; i < container.getChildCount(); i++) {
                View child = container.getChildAt(i);
                // logic for resetting external themes visual selection if internal one is picked could go here
                // if (isAudi) unselectOthers();
            }
        }
    }
}
