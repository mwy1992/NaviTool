package cn.navitool.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch; // Import Switch for usage
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.json.JSONArray;
import org.json.JSONArray;
import org.json.JSONException;
import cn.navitool.service.MediaInfo;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.managers.ConfigManager;
import cn.navitool.model.HudComponentData;
import cn.navitool.utils.DebugLogger;
import cn.navitool.view.GridBackgroundDrawable;
import cn.navitool.view.HudComponentRenderer;
import cn.navitool.view.TrafficLightView;

public class HudSettingsController {
    private final Activity mActivity;
    private View mLayoutHud;
    
    private static final int MODE_WHUD = 0;
    private static final int MODE_AR = 1;

    private int mHudMode = MODE_WHUD;
    private boolean mIsHudComponentLocked = false;
    private boolean mIsSnowModeEnabled = false;
    
    // Editor State
    private View mHudTestComponent;
    private View mResizeHandle;
    
    public HudSettingsController(Activity activity, View layoutHud) {
        this.mActivity = activity;
        this.mLayoutHud = layoutHud;
    }

    public void setupHud() {
        if (mLayoutHud == null) return;
        
        SwitchMaterial switchHud = mLayoutHud.findViewById(R.id.switchHud);
        View controls = mLayoutHud.findViewById(R.id.layoutHudEditorControls);

        if (switchHud != null) {
            boolean isHudEnabled = ConfigManager.getInstance().getBoolean("switch_hud", false);
            switchHud.setChecked(isHudEnabled);
            ClusterHudManager.getInstance(mActivity).setHudEnabled(isHudEnabled);

            View pvContainer = mLayoutHud.findViewById(R.id.layoutHudPreviewContainer);
            View pvContent = mLayoutHud.findViewById(R.id.layoutHudPreview);
            // Initial Visibility
            if (pvContainer != null) pvContainer.setVisibility(isHudEnabled ? View.VISIBLE : View.GONE);
            if (pvContent != null) pvContent.setVisibility(View.VISIBLE);
            if (controls != null) controls.setVisibility(isHudEnabled ? View.VISIBLE : View.GONE);

            switchHud.setOnCheckedChangeListener((buttonView, isChecked) -> {
                DebugLogger.action("MainActivity", "HUD开关切换: " + isChecked);
                ClusterHudManager.getInstance(mActivity).setHudEnabled(isChecked);
                ConfigManager.getInstance().setBoolean("switch_hud", isChecked);

                // Toggle Container
                if (pvContainer != null)
                    pvContainer.setVisibility(isChecked ? View.VISIBLE : View.GONE);

                // Ensure Content is Visible if Container is Visible
                if (pvContent != null)
                    pvContent.setVisibility(View.VISIBLE);

                if (controls != null)
                    controls.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            });
        }

        setupHudEditor();

        // Restore HUD Mode
        mHudMode = ConfigManager.getInstance().getInt("hud_current_mode", MODE_WHUD);
        updateHudModeButton();
        
        // [FIX] Restore Snow Mode state from config
        mIsSnowModeEnabled = ConfigManager.getInstance().getBoolean("hud_snow_mode", false);
        updateHudSnowModeButton();

        // Load Layout
        loadHudLayout(mHudMode);

        // [FIX] Force refresh data to generic components immediately
        ClusterHudManager.getInstance(mActivity).forceNotifyListener();
    }
    
    // Field for VSM Listener
    private cn.navitool.managers.VehicleSensorManager.Listener mVsmListener;

    private void setupHudEditor() {
        if (mLayoutHud == null) return;
        mLayoutHud.findViewById(R.id.btnHudAdd).setOnClickListener(v -> showAddHudComponentDialog());
        mLayoutHud.findViewById(R.id.btnHudModify).setOnClickListener(v -> unlockHudComponent());
        mLayoutHud.findViewById(R.id.btnHudDelete).setOnClickListener(v -> deleteSelectedHudComponent());
        mLayoutHud.findViewById(R.id.btnHudSave).setOnClickListener(v -> lockHudComponent());
        mLayoutHud.findViewById(R.id.btnHudReset).setOnClickListener(v -> resetHudComponent());
        
        mLayoutHud.findViewById(R.id.btnHudSwitchMode).setOnClickListener(v -> switchHudMode());
        mLayoutHud.findViewById(R.id.btnHudSnowMode).setOnClickListener(v -> toggleSnowMode());

        // Initial Button State Update
        updateHudModeButton();
        updateHudSnowModeButton();
    }
    
    // [Methods moved to end of file to resolve duplication]

    public void onResume() {
        // Register HUD Listener for Preview Updates
        ClusterHudManager manager = ClusterHudManager.getInstance(mActivity);
        manager.setListener((type, text, image) -> {
            mActivity.runOnUiThread(() -> {
                updatePreview(type, text, image);
            });
        });
        
        // [NEW] Register VSM Listener
        if (mVsmListener == null) {
            mVsmListener = new cn.navitool.managers.VehicleSensorManager.Listener() {
                @Override
                public void onFunctionChanged(int functionId, int zone, int value) {
                    mActivity.runOnUiThread(() -> {
                         if (functionId == cn.navitool.managers.VehicleSensorManager.SETTING_FUNC_HUD_AR_ENGINE) {
                             int newMode = (value == 1) ? MODE_AR : MODE_WHUD;
                             if (mHudMode != newMode) {
                                 mHudMode = newMode;
                                 ConfigManager.getInstance().setInt("hud_current_mode", mHudMode);
                                 updateHudModeButton();
                                 // [FIX] Also reload layout when system changes mode
                                 loadHudLayout(mHudMode);
                             }
                         } else if (functionId == cn.navitool.managers.VehicleSensorManager.SETTING_FUNC_HUD_SNOW_MODE) {
                             boolean newSnowMode = (value == 1);
                             if (mIsSnowModeEnabled != newSnowMode) {
                                 mIsSnowModeEnabled = newSnowMode;
                                 ConfigManager.getInstance().setBoolean("hud_snow_mode", mIsSnowModeEnabled);
                                 updateHudSnowModeButton();
                                 // [FIX] Also refresh colors when system changes snow mode
                                 refreshHudComponentColors();
                                 syncAllHudComponents();
                             }
                         }
                    });
                }
            };
        }
        cn.navitool.managers.VehicleSensorManager.getInstance(mActivity).registerListener(mVsmListener);
        
        // [Refactor] Immediately sync current media state to Preview
        MediaInfo mediaInfo = manager.getCurrentMediaInfo();
        if (mediaInfo != null && mediaInfo.isValid()) {
            updatePreview("song_2line", mediaInfo.getFormatText(), null);
            updatePreview("song_cover", null, mediaInfo.artwork);
        }
    }

    public void onPause() {
        // Unregister HUD Listener
        ClusterHudManager.getInstance(mActivity).setListener(null);
        
        // [NEW] Unregister VSM Listener
        if (mVsmListener != null) {
            cn.navitool.managers.VehicleSensorManager.getInstance(mActivity).unregisterListener(mVsmListener);
        }
    }

    private void updatePreview(String type, String text, Bitmap image) {
        if (mLayoutHud == null) return;
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            for (int i = 0; i < preview.getChildCount(); i++) {
                View child = preview.getChildAt(i);
                Object tag = child.getTag();
                if (tag != null && tag.toString().startsWith("type_" + type)) {
                    if ("time".equals(type))
                        continue;

                    // Force Turn Signal to always show Hazard in Preview for Editing
                    if ("turn_signal".equals(type) && child instanceof ImageView) {
                        try {
                            float scale = 1.0f;
                            if (tag.toString().contains(":scale_")) {
                                String val = tag.toString().substring(tag.toString().indexOf(":scale_") + 7);
                                scale = Float.parseFloat(val);
                            }
                            
                            Bitmap forceBmp = ClusterHudManager.getInstance(mActivity).getTurnSignalBitmap(true, true, scale);

                            if (forceBmp != null) {
                                forceBmp = ClusterHudManager.getInstance(mActivity).addCenterLineOverlay(forceBmp);
                            }

                            if (forceBmp != null) {
                                ((ImageView) child).setImageBitmap(forceBmp);
                            } else {
                                ((ImageView) child).setImageResource(R.drawable.ic_turn_signal);
                            }
                            
                            // 保持布局参数不变，仅更新图片
                            // 不重置scale，因为scale已经内建在bitmap中
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        continue;
                    }

                    if (child instanceof TextView && text != null) {
                        ((TextView) child).setText(text);
                    } else if (child instanceof LinearLayout && ("song_2line".equals(type) || "song_1line".equals(type))) {
                        // [Refactored] Delegate to HudComponentRenderer for song placeholder logic
                        cn.navitool.view.HudComponentRenderer.updateComponentContent(child, type, text, null, true);
                    } else if (child instanceof ImageView) {
                        if ("song_cover".equals(type)) {
                            // [FIX] Strict Sync: Ignore 'image' param, use Data Source
                            MediaInfo info = ClusterHudManager.getInstance(mActivity).getCurrentMediaInfo();
                            Bitmap realArt = (info != null && info.isValid()) ? info.artwork : null;
                            
                            // Deep Debugging (Simplified)
                            String infoTitle = (info != null) ? info.title : "NULL";
                            String infoArtHash = (realArt != null) ? Integer.toHexString(realArt.hashCode()) : "NULL";
                            
                            DebugLogger.d("HUD_PREVIEW", String.format("song_cover sync: Title='%s', InfoArtHash=%s", infoTitle, infoArtHash));

                            if (realArt != null) {
                                ((ImageView) child).setImageBitmap(realArt);
                                ((ImageView) child).setColorFilter(null);
                                ((ImageView) child).setScaleType(ImageView.ScaleType.FIT_CENTER);
                            } else {
                                ImageView iv = (ImageView) child;
                                iv.setImageBitmap(null); // [Aggressive Clear]
                                iv.setImageDrawable(null); // [Aggressive Clear]
                                iv.setImageResource(android.R.drawable.ic_media_play);
                                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                iv.setColorFilter(Color.WHITE);
                                iv.setVisibility(View.VISIBLE);
                                iv.invalidate(); // [Force Redraw]
                            }
                        } else {
                            // Standard logic for others
                            if (image != null) {
                                ((ImageView) child).setImageBitmap(image);
                            }
                        }
                    }
                }
            }
        }
    }

    
    private void saveCurrentHudLayout(int mode) {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;

        // Save Lock State
        String lockKey = (mode == MODE_WHUD) ? "hud_locked_whud" : "hud_locked_ar";
        ConfigManager.getInstance().setBoolean(lockKey, mIsHudComponentLocked);

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);
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
                        text = (child instanceof TextClock)
                                ? ((TextClock) child).getFormat12Hour().toString()
                                : ((TextView) child).getText().toString();
                    } else if (child instanceof LinearLayout) {
                        // Extract Title and Artist for Media Info
                        LinearLayout ll = (LinearLayout) child;
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
        ClusterHudManager.getInstance(mActivity).syncHudLayout(syncList);
    }

    private void loadHudLayout(int mode) {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;

        // Clear Preview
        preview.removeAllViews();
        // [FIX] Ensure Grid Background is always visible
        preview.setBackground(new GridBackgroundDrawable());
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
                    if (preview.getChildCount() > 0) {
                        View lastChild = preview.getChildAt(preview.getChildCount() - 1);
                        
                        // [FIX] 转向灯组件不使用视图缩放，而是通过Bitmap间距实现
                        // 转向灯的scale只影响箭头之间的间距，不影响箭头图片大小
                        if ("turn_signal".equals(type)) {
                            // 不设置setScaleX/Y，保持视图1:1
                            // scale已在createAndAddHudComponent中通过tag传递
                            // 重新生成带正确间距的Bitmap
                            if (lastChild instanceof ImageView) {
                                Bitmap bmp = ClusterHudManager.getInstance(mActivity)
                                        .getTurnSignalBitmap(true, true, scale);
                                if (bmp != null) {
                                    bmp = ClusterHudManager.getInstance(mActivity).addCenterLineOverlay(bmp);
                                    ((ImageView) lastChild).setImageBitmap(bmp);
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
        
        if (mIsHudComponentLocked) {
           // DebugLogger.toast(mActivity, "布局已恢复并锁定");
        }

        // Sync to Real HUD
        ClusterHudManager.getInstance(mActivity).syncHudLayout(syncList);
    }

    private void switchHudMode() {
        // Toggle Logic
        int targetMode = (mHudMode == MODE_WHUD) ? MODE_AR : MODE_WHUD;
        int targetValue = (targetMode == MODE_AR) ? 1 : 0;
        
        // Send to System
        cn.navitool.managers.VehicleSensorManager.getInstance(mActivity).setFunctionValue(
                cn.navitool.managers.VehicleSensorManager.SETTING_FUNC_HUD_AR_ENGINE, 
                Integer.MIN_VALUE, 
                targetValue
        );
        
        // Optimistic Update
        mHudMode = targetMode;
        ConfigManager.getInstance().setInt("hud_current_mode", mHudMode);
        updateHudModeButton();
        
        // [FIX] Reload layout for new mode
        loadHudLayout(mHudMode);
        
        DebugLogger.toast(mActivity, "已切换至 " + ((mHudMode == MODE_WHUD) ? "WHUD" : "AR") + " 模式");
    }
    
    private void updateHudModeButton() {
        if (mLayoutHud == null) return;
        Button btn = mLayoutHud.findViewById(R.id.btnHudSwitchMode);
        if (btn != null) {
            btn.setText("当前为" + ((mHudMode == MODE_WHUD) ? "WHUD" : "AR") + "模式");
        }
    }

    private void toggleSnowMode() {
        mIsSnowModeEnabled = !mIsSnowModeEnabled;
        
        // [FIX] Send to System API
        int value = mIsSnowModeEnabled ? 1 : 0;
        cn.navitool.managers.VehicleSensorManager.getInstance(mActivity).setFunctionValue(
                cn.navitool.managers.VehicleSensorManager.SETTING_FUNC_HUD_SNOW_MODE,
                Integer.MIN_VALUE,
                value
        );
        
        ConfigManager.getInstance().setBoolean("hud_snow_mode", mIsSnowModeEnabled);
        updateHudSnowModeButton();
        refreshHudComponentColors();
        syncAllHudComponents();
        DebugLogger.toast(mActivity, mIsSnowModeEnabled ? "雪地模式已开启" : "雪地模式已关闭");
    }

    private void updateHudSnowModeButton() {
        Button btn = mLayoutHud.findViewById(R.id.btnHudSnowMode);
        if (btn != null) {
            btn.setText(mIsSnowModeEnabled ? "雪地模式：开" : "雪地模式：关");
        }
    }

    private void refreshHudComponentColors() {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview == null) return;
        int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF; // Cyan : White

        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);
            if (child instanceof TextView) {
                ((TextView) child).setTextColor(color);
            } else if (child instanceof LinearLayout) {
                LinearLayout ll = (LinearLayout) child;
                for (int j = 0; j < ll.getChildCount(); j++) {
                    View subChild = ll.getChildAt(j);
                    if (subChild instanceof TextView) {
                        ((TextView) subChild).setTextColor(color);
                    }
                }
            }
        }
    }
    
    private void createAndAddHudComponent(String type, String text, float x, float y) {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview == null) return;

        // Create component data
        HudComponentData data = new HudComponentData();
        data.type = type;
        data.text = text;
        data.x = x;
        data.y = y;

        // Get color based on snow mode
        int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF;

        // Use unified renderer (isPreview = true for 2x scale)
        View view = HudComponentRenderer.createComponent(mActivity, data, true, color);

        if (view == null) {
            DebugLogger.e("HudSettingsController", "Failed to create component: " + type);
            return;
        }

        // Ensure layout params exist
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
        }

        // Store type in Tag for sync
        view.setTag("type_" + type);

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP | Gravity.START;

        view.setX(x);
        view.setY(y);

        preview.addView(view, params);
        mHudTestComponent = view;
        mIsHudComponentLocked = false;

        // Setup Drag Listener
        setupHudComponentTouchListener(view);
    }

    private void setupHudComponentTouchListener(View tv) {
        tv.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (mIsHudComponentLocked)
                    return false;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        // Update current Selection tracking
                        mHudTestComponent = view;
                        highlightSelectedComponent(view);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float newX = event.getRawX() + dX;
                        float newY = event.getRawY() + dY;

                        View parent = (View) view.getParent();
                        int parentWidth = parent.getWidth();
                        int parentHeight = parent.getHeight();
                        int viewWidth = (int) (view.getWidth() * view.getScaleX());
                        int viewHeight = (int) (view.getHeight() * view.getScaleY());


                        String tagStr = (view.getTag() != null) ? view.getTag().toString() : "";
                        boolean isGuideLine = tagStr.contains("type_guide_line");
                         
                        boolean isMusicComponent = tagStr.contains("type_song_2line")
                                || tagStr.contains("type_song_cover")
                                || tagStr.contains("type_song_1line");

                        float offsetTop = 0;
                        float offsetBottom = 0;
                        // [FIX] Disabled tolerance for Preview Editor as well
                        /*
                        float FACTOR_TOP = 0.18f;
                        float FACTOR_BOTTOM = 0.2f;

                        float minX = 0;
                        float maxXLimit = parentWidth - viewWidth;

                        // [Feature] Relax bounds for guide_line (50% width tolerance)
                        if (isGuideLine) {
                            minX = -0.5f * viewWidth;
                            maxXLimit = parentWidth - (0.5f * viewWidth);
                        }
                        */
                        float minX = 0;
                        float maxXLimit = parentWidth - viewWidth;
                        // [Feature] Relax bounds for guide_line (50% width tolerance)
                        if (isGuideLine) {
                            minX = -0.5f * viewWidth;
                            maxXLimit = parentWidth - (0.5f * viewWidth);
                        }

                        if (newX < minX)
                            newX = minX;
                        if (newX > maxXLimit)
                            newX = maxXLimit;

                        // ... (rest of logic)

                        /*
                        if (isMusicComponent) {
                             offsetTop = 0;
                             offsetBottom = 0;
                        } else if (tagStr.contains("type_volume")) {
                             // [Feature] Volume component gets fixed tolerance
                             offsetTop = 10f;
                             offsetBottom = 10f;
                        } else if (isGuideLine) {
                             newY = 0; // Force Top to 0
                             // ...
                        } else if (view instanceof TextView) {
                            float scaledTextSize = ((TextView) view).getTextSize() * view.getScaleY();
                            offsetTop = scaledTextSize * FACTOR_TOP;
                            offsetBottom = scaledTextSize * FACTOR_BOTTOM;
                        } else if (view instanceof LinearLayout) {
                             // ...
                        }
                        */
                        
                        // [FIX] Simplified Logic without Tolerance
                        boolean isVerticalGuideLine = tagStr.contains("type_guide_line") && !tagStr.contains("horizontal");
                        boolean isHorizontalGuideLine = tagStr.contains("type_guide_line_horizontal");
                        
                        // Set Y tolerance for horizontal guide line (allow edge placement)
                        float minY = 0;
                        float maxYLimit = parentHeight - viewHeight;
                        if (isHorizontalGuideLine) {
                            minY = -0.5f * viewHeight;
                            maxYLimit = parentHeight - (0.5f * viewHeight);
                        }
                        
                        if (isVerticalGuideLine) {
                             newY = 0; // Force Top to 0 for vertical guide
                        } else if (isHorizontalGuideLine) {
                             newX = 0; // Force Left to 0 for horizontal guide
                        }
                        
                        // Clamp Y coordinate
                        if (newY < minY)
                            newY = minY;
                        if (newY > maxYLimit)
                            newY = maxYLimit;

                        // Default Y clamping for other components (offsetTop/offsetBottom = 0)
                        if (!isVerticalGuideLine && !isHorizontalGuideLine) {
                            if (newY < -offsetTop)
                                newY = -offsetTop;
                            if (newY + viewHeight > parentHeight + offsetBottom)
                                newY = parentHeight - viewHeight + offsetBottom;
                        }

                        // Update coordinate display AFTER clamping
                        if (isVerticalGuideLine) {
                             if (view instanceof ViewGroup) {
                                 ViewGroup vg = (ViewGroup) view;
                                 for (int k = 0; k < vg.getChildCount(); k++) {
                                     View child = vg.getChildAt(k);
                                     if (child instanceof TextView) {
                                         // Display center X in preview coordinates (clamped)
                                         int centerX = (int) (newX + view.getWidth() / 2f);
                                         ((TextView) child).setText("X:" + centerX);
                                     }
                                 }
                             }
                        } else if (isHorizontalGuideLine) {
                             if (view instanceof ViewGroup) {
                                 ViewGroup vg = (ViewGroup) view;
                                 for (int k = 0; k < vg.getChildCount(); k++) {
                                     View child = vg.getChildAt(k);
                                     if (child instanceof TextView) {
                                         // Display center Y in preview coordinates (clamped)
                                         int centerY = (int) (newY + view.getHeight() / 2f);
                                         ((TextView) child).setText("Y:" + centerY);
                                     }
                                 }
                             }
                        }

                        view.setX(newX);
                        view.setY(newY);

                        if (mResizeHandle != null && view == mHudTestComponent) {
                            updateResizeHandlePosition(mResizeHandle, view, 24);
                        }

                        syncAllHudComponents();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void highlightSelectedComponent(View selected) {
        if (selected == null)
            return;
        View parent = (View) selected.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) parent;
            for (int i = 0; i < group.getChildCount(); i++) {
                View child = group.getChildAt(i);
                child.setAlpha(1.0f); // Reset
            }
        }
        selected.setAlpha(0.6f); // Highlight
        showResizeHandle(selected);
    }
    
    private void showResizeHandle(View target) {
        removeResizeHandle();

        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview == null || target == null)
            return;

        View handle = new View(mActivity) {
            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                Paint paint = new Paint();
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(2);
                paint.setAntiAlias(true);

                int w = getWidth();
                int h = getHeight();
                canvas.drawLine(w * 0.3f, h, w, h * 0.3f, paint);
                canvas.drawLine(w * 0.6f, h, w, h * 0.6f, paint);
            }
        };

        int handleSize = 24;
        FrameLayout.LayoutParams handleParams = new FrameLayout.LayoutParams(handleSize, handleSize);
        handleParams.gravity = Gravity.TOP | Gravity.START;

        handle.setBackgroundColor(Color.TRANSPARENT);

        updateResizeHandlePosition(handle, target, handleSize);
        setupResizeHandleTouch(handle, target);

        preview.addView(handle, handleParams);
        mResizeHandle = handle;
    }
    
    private void updateResizeHandlePosition(View handle, View target, int handleSize) {
        if (handle == null || target == null)
            return;

        target.setPivotX(0);
        target.setPivotY(0);

        float handleX = target.getX() + (target.getWidth() * target.getScaleX()) - handleSize / 2f;
        float handleY = target.getY() + (target.getHeight() * target.getScaleY()) - handleSize / 2f;
        handle.setX(handleX);
        handle.setY(handleY);
    }

    private void removeResizeHandle() {
        if (mResizeHandle != null) {
            ViewGroup parent = (ViewGroup) mResizeHandle.getParent();
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
            public boolean onTouch(View v, MotionEvent event) {
                if (mIsHudComponentLocked)
                    return false;

                Object tagObj = target.getTag();
                String tagStr = (tagObj instanceof String) ? (String) tagObj : "";
                isTurnSignal = tagStr.contains("turn_signal");

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getRawX();
                        startY = event.getRawY();
                        if (isTurnSignal) {
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

                    case MotionEvent.ACTION_MOVE:
                        if (tagStr != null && (tagStr.contains("type_volume") || tagStr.contains("type_guide_line"))) {
                            return true;
                        }

                        float deltaX = event.getRawX() - startX;
                        float deltaY = event.getRawY() - startY;

                        float newScale;

                        if (isTurnSignal) {
                            newScale = startScale + (deltaX / 90f);
                            newScale = Math.max(0.3f, Math.min(15.0f, newScale));

                            String baseTag = tagStr.split(":")[0];
                            target.setTag(baseTag + ":scale_" + newScale);

                            Bitmap dynamicBmp = ClusterHudManager.getInstance(mActivity)
                                    .getTurnSignalBitmap(true, true, newScale);

                            if (dynamicBmp != null) {
                                dynamicBmp = ClusterHudManager.getInstance(mActivity)
                                        .addCenterLineOverlay(dynamicBmp);
                            }

                            if (dynamicBmp != null && target instanceof ImageView) {
                                ((ImageView) target).setImageBitmap(dynamicBmp);
                            }

                            float expectedWidth = 144 + (90 * newScale);
                            float handleX = target.getX() + expectedWidth - v.getWidth() / 2f;
                            float handleY = target.getY() + 72 - v.getHeight() / 2f;
                            v.setX(handleX);
                            v.setY(handleY);
                        } else {
                            float baseWidth = target.getWidth() > 0 ? target.getWidth() : 100f;
                            float effectiveDelta = (Math.abs(deltaX) > Math.abs(deltaY)) ? deltaX : deltaY;
                            newScale = startScale + (effectiveDelta / baseWidth);
                            newScale = Math.max(0.3f, Math.min(3.0f, newScale));

                            target.setScaleX(newScale);
                            target.setScaleY(newScale);

                            updateResizeHandlePosition(v, target, v.getWidth());
                        }

                        syncAllHudComponents();
                        return true;

                    case MotionEvent.ACTION_UP:
                        return true;
                }
                return false;
            }
        });
    }

    private void syncAllHudComponents() {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview == null)
            return;
        List<ClusterHudManager.HudComponentData> list = new ArrayList<>();
        for (int i = 0; i < preview.getChildCount(); i++) {
            View child = preview.getChildAt(i);

            if (child == mResizeHandle) continue;

            Object tagObj = child.getTag();
            if (!(tagObj instanceof String)) continue;
            String tag = (String) tagObj;
            if (tag == null || !tag.startsWith("type_")) continue;

            String rawType = tag.replace("type_", "");
            String type = rawType.contains(":") ? rawType.substring(0, rawType.indexOf(":")) : rawType;
            String text = "";

            if (child instanceof TextView) {
                if ("time".equals(type)) {
                    text = "HH:mm";
                } else {
                    text = (child instanceof TextClock)
                            ? ((TextClock) child).getFormat12Hour().toString()
                            : ((TextView) child).getText().toString();
                }
            } else if (child instanceof LinearLayout) {
                LinearLayout ll = (LinearLayout) child;
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
                text = "";
            }

            int color = mIsSnowModeEnabled ? 0xFF00FFFF : 0xFFFFFFFF;
            ClusterHudManager.HudComponentData data = new ClusterHudManager.HudComponentData(
                    type,
                    text,
                    child.getX() * 0.5f,
                    child.getY() * 0.5f,
                    color);
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
        ClusterHudManager.getInstance(mActivity).syncHudLayout(list);
    }
    
    // [Duplicate updateHudModeButton removed]
    
    private void lockHudComponent() {
        clearHudSelection();
        saveCurrentHudLayout(mHudMode);
        mIsHudComponentLocked = true;
        reloadHudConfigToManager(mHudMode);
        DebugLogger.toast(mActivity, "布局已保存");
    }

    private void unlockHudComponent() {
        mIsHudComponentLocked = false;
        DebugLogger.toast(mActivity, "组件已解锁 (可拖拽)");
    }
    
    private void deleteSelectedHudComponent() {
        if (mHudTestComponent == null) {
            DebugLogger.toast(mActivity, "请先选择要删除的组件");
            return;
        }

        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            preview.removeView(mHudTestComponent);
            mHudTestComponent = null;
            syncAllHudComponents();
            DebugLogger.toast(mActivity, "组件已删除");
        }
    }
    
    private void resetHudComponent() {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            preview.removeAllViews();
        }
        mHudTestComponent = null;
        mIsHudComponentLocked = false;

        String key = (mHudMode == MODE_WHUD) ? "hud_layout_whud" : "hud_layout_ar";
        ConfigManager.getInstance().setString(key, "[]");

        ClusterHudManager.getInstance(mActivity).clearHudComponents();

        DebugLogger.toast(mActivity, "布局已重置");
    }
    
    private void clearHudSelection() {
        mHudTestComponent = null;
        removeResizeHandle();
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
        if (preview != null) {
            for (int i = 0; i < preview.getChildCount(); i++) {
                View child = preview.getChildAt(i);
                child.setAlpha(1.0f);
            }
        }
    }

    private void showAddHudComponentDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mActivity);
        builder.setTitle("选择组件类型");

        LinearLayout root = new LinearLayout(mActivity);
        root.setOrientation(LinearLayout.HORIZONTAL);
        root.setPadding(32, 16, 32, 16);

        LinearLayout colBasic = new LinearLayout(mActivity);
        colBasic.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lpBasic = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpBasic.weight = 1;
        colBasic.setLayoutParams(lpBasic);

        LinearLayout colDrive = new LinearLayout(mActivity);
        colDrive.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lpDrive = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpDrive.weight = 1;
        colDrive.setLayoutParams(lpDrive);

        LinearLayout colNavi = new LinearLayout(mActivity);
        colNavi.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lpNavi = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpNavi.weight = 1;
        colNavi.setLayoutParams(lpNavi);

        LinearLayout colMedia = new LinearLayout(mActivity);
        colMedia.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lpMedia = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        lpMedia.weight = 1;
        colMedia.setLayoutParams(lpMedia);

        addHeader(colBasic, "基本信息");
        addHeader(colDrive, "行驶数据");
        addHeader(colNavi, "导航信息");
        addHeader(colMedia, "媒体信息");

        root.addView(colBasic);
        root.addView(colDrive);
        root.addView(colNavi);
        root.addView(colMedia);

        final android.app.AlertDialog[] dialogHolder = new android.app.AlertDialog[1];
        
        // Helper functional interface
        TriConsumer<LinearLayout, String, String> addButton = (parent, text, type) -> {
            Button btn = new Button(mActivity);
            btn.setText(text);
            btn.setTextSize(12);
            btn.setPadding(8, 8, 8, 8);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 4, 4, 4);
            btn.setLayoutParams(params);

            btn.setOnClickListener(v -> {
                if (isHudComponentAdded(type)) {
                    DebugLogger.toast(mActivity, "组件已存在");
                    return;
                }

                if ("time".equals(type))
                    addHudTimeComponent();
                else if ("fuel".equals(type)) {
                    String initialText = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentFuelText();
                    createAndAddHudComponent("fuel", initialText, 0, 0);
                }
                else if ("temp_in".equals(type)) {
                    String initialText = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentTempInText();
                    createAndAddHudComponent("temp_in", initialText, 0, 0);
                }
                else if ("temp_out".equals(type)) {
                    String initialText = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentTempOutText();
                    createAndAddHudComponent("temp_out", initialText, 0, 0);
                }
                else if ("range".equals(type)) {
                    String initialText = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentRangeText();
                    createAndAddHudComponent("range", initialText, 0, 0);
                }
                else if ("fuel_range".equals(type)) {
                    String initialText = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentTotalFuelRangeText();
                    createAndAddHudComponent("fuel_range", initialText, 0, 0);
                }
                else if ("gear".equals(type)) {
                    String gear = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentDisplayGear();
                    createAndAddHudComponent("gear", gear, 0, 0);
                }
                else if ("turn_signal".equals(type))
                    createAndAddHudComponent("turn_signal", "←      →", 0, 0);
                else if ("auto_hold".equals(type))
                    createAndAddHudComponent("auto_hold", "A", 0, 0);
                else if ("volume".equals(type))
                    createAndAddHudComponent("volume", "音量: --", 0, 0);
                else if ("song_cover".equals(type))
                    createAndAddHudComponent("song_cover", "", 0, 0);
                else if ("song_2line".equals(type)) {
                    createAndAddHudComponent("song_2line", "歌曲标题", 0, 0);
                    mActivity.sendBroadcast(new Intent(
                            cn.navitool.service.MediaNotificationListener.ACTION_REQUEST_MEDIA_REBROADCAST));
                } else if ("song_1line".equals(type)) {
                    createAndAddHudComponent("song_1line", "歌曲标题", 0, 0);
                    mActivity.sendBroadcast(new Intent(
                            cn.navitool.service.MediaNotificationListener.ACTION_REQUEST_MEDIA_REBROADCAST));
                } else if ("traffic_light".equals(type)) {
                    createAndAddHudComponent("traffic_light", "红绿灯组件", 0, 0);
                } else if ("traffic_light_cruise".equals(type)) {
                    // [Step 3] Cruise Mode Traffic Light
                    createAndAddHudComponent("traffic_light_cruise", "巡航红绿灯", 0, 0);
                } else if ("location_current".equals(type)) {
                    // [Step 3] Current Location
                    createAndAddHudComponent("location_current", "当前路名", 0, 0);
                } else if ("location_dest".equals(type)) {
                    // [Step 3] Destination
                    createAndAddHudComponent("location_dest", "目的地", 0, 0);
                } else if ("navi_arrival_time".equals(type)) {
                    createAndAddHudComponent("navi_arrival_time", "12:30", 0, 0);
                } else if ("navi_distance_remaining".equals(type)) {
                    createAndAddHudComponent("navi_distance_remaining", "9999.9KM", 0, 0);
                } else if ("guide_line".equals(type)) {
                    createAndAddHudComponent("guide_line", "X:0", 0, 0);
                } else if ("guide_line_horizontal".equals(type)) {
                    createAndAddHudComponent("guide_line_horizontal", "Y:0", 0, 0);
                } else if ("hud_rpm".equals(type)) {
                    String initialText = cn.navitool.managers.ClusterHudManager.getInstance(mActivity).getCurrentRpmText();
                    createAndAddHudComponent("hud_rpm", initialText, 0, 0);
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
        addButton.accept(colBasic, "辅助线 (横)", "guide_line_horizontal");

        // Group 2: Driving
        addButton.accept(colDrive, "剩余油量", "fuel");
        addButton.accept(colDrive, "续航里程", "range");
        addButton.accept(colDrive, "油量续航", "fuel_range");
        addButton.accept(colDrive, "档位信息", "gear");
        addButton.accept(colDrive, "转向信号", "turn_signal");
        addButton.accept(colDrive, "转速信息", "hud_rpm");

        // Group 3: Navigation
        addButton.accept(colNavi, "导航红绿灯", "traffic_light");
        addButton.accept(colNavi, "巡航红绿灯", "traffic_light_cruise");  // [Step 3] New
        addButton.accept(colNavi, "当前位置", "location_current");        // [Step 3] New
        addButton.accept(colNavi, "目的地", "location_dest");             // [Step 3] New
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
    
    private void addHeader(LinearLayout parent, String title) {
        TextView h = new TextView(mActivity);
        h.setText(title);
        h.setTypeface(null, Typeface.BOLD);
        h.setPadding(0, 0, 0, 16);
        h.setGravity(Gravity.CENTER);
        parent.addView(h);
    }

    private void addHudTimeComponent() {
        createAndAddHudComponent("time", "HH:mm", 0, 0);
        syncAllHudComponents();
    }

    private boolean isHudComponentAdded(String type) {
        FrameLayout preview = mLayoutHud.findViewById(R.id.layoutHudPreview);
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
    
    @FunctionalInterface
    interface TriConsumer<T, U, V> {
        void accept(T t, U u, V v);
    }
}
