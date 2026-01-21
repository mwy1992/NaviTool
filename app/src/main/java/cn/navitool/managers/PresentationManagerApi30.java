package cn.navitool.managers;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.navitool.R;
import cn.navitool.utils.DebugLogger;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.view.TrafficLightView;
import cn.navitool.controller.NaviInfoController;

/**
 * Android 11+ Specific Presentation Manager
 * Implements strict isolation from legacy PresentationManager.
 * Focuses on 1:1 pixel mapping for HUD (800x480) and Cluster (1920x720).
 */
public class PresentationManagerApi30 extends android.app.Presentation {

    private static final String TAG = "PresentationManagerApi30";
    private static final String LOG_PREFIX = "[API30] ";

    public static final int THEME_DEFAULT = 1;
    public static final int THEME_AUDI_RS = 2; // Reserved for future use

    private FrameLayout mLayoutCluster;
    private FrameLayout mLayoutHud;

    // Component Lists
    private List<View> mRealHudComponents = new ArrayList<>();
    private List<View> mRealClusterComponents = new ArrayList<>();

    private int mCurrentTheme = THEME_DEFAULT;
    private boolean mIsMediaPlaying = false;
    private boolean mIsVolumeVisible = false;

    // Data Cache (for immediate display)
    private String mCachedNaviArrivalTime = null;
    private String mCachedNaviDistance = null;

    public PresentationManagerApi30(Context context, Display display) {
        super(context, display, R.style.Theme_NaviTool);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_cluster_hud_api30);

        mLayoutCluster = findViewById(R.id.layoutCluster);
        mLayoutHud = findViewById(R.id.layoutHud);

        DebugLogger.i(TAG, LOG_PREFIX + "onCreate: Presentation created on Display " 
                + getDisplay().getDisplayId() + " (" + getDisplay().getName() + ")");

        // Basic Window Flags
        if (getWindow() != null) {

            // [FIX] Z-Order Correction: Use TYPE_APPLICATION_OVERLAY (2038)
            // This ensures the HUD remains visible over Navigation Apps (Amap/Geely Map).
            // Requires Context created via createWindowContext(TYPE_APPLICATION_OVERLAY) to avoid crash.
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            } else {
                getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            }
            getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT));

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                    | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        }

        // [API30] Apply Pending Theme if any
        if (mPendingTheme != -1) {
            DebugLogger.d(TAG, LOG_PREFIX + "onCreate: Apply pending theme: " + mPendingTheme);
            setClusterTheme(mPendingTheme);
            mPendingTheme = -1;
        }
        
        // [API30] Apply Pending Visibility
        if (mPendingHudVisible != null) {
            setHudVisible(mPendingHudVisible);
            mPendingHudVisible = null;
        }
        if (mPendingClusterVisible != null) {
            setClusterVisible(mPendingClusterVisible);
            mPendingClusterVisible = null;
        }
    }

    /**
     * Set the container size explicitly.
     * Useful if the Display resolution reports something weird, though we expect standard sizes.
     */
    public void ensureContainerSize(boolean isHud) {
        if (isHud && mLayoutHud != null) {
            ViewGroup.LayoutParams params = mLayoutHud.getLayoutParams();
            if (params != null) {
                params.width = 800; // 1:1 for Api30
                params.height = 230; // [FIX] Adjusted height to 230
                mLayoutHud.setLayoutParams(params);
            }
        } else if (!isHud && mLayoutCluster != null) {
             ViewGroup.LayoutParams params = mLayoutCluster.getLayoutParams();
             if (params != null) {
                 params.width = 1920;
                 params.height = 720;
                 mLayoutCluster.setLayoutParams(params);
             }
        }
    }

    // Pending Visibility States
    private Boolean mPendingHudVisible = null;
    private Boolean mPendingClusterVisible = null;

    public void setHudVisible(boolean visible) {
        if (mLayoutHud != null) {
            mLayoutHud.setVisibility(visible ? View.VISIBLE : View.GONE);
            if (visible) ensureContainerSize(true);
            DebugLogger.d(TAG, LOG_PREFIX + "setHudVisible: " + visible);
        } else {
            mPendingHudVisible = visible;
            DebugLogger.d(TAG, LOG_PREFIX + "setHudVisible: Layout not ready, caching: " + visible);
        }
    }

    public void setClusterVisible(boolean visible) {
        if (mLayoutCluster != null) {
            mLayoutCluster.setVisibility(visible ? View.VISIBLE : View.GONE);
            if (visible) ensureContainerSize(false);
            DebugLogger.d(TAG, LOG_PREFIX + "setClusterVisible: " + visible);
        } else {
            mPendingClusterVisible = visible;
            DebugLogger.d(TAG, LOG_PREFIX + "setClusterVisible: Layout not ready, caching: " + visible);
        }
    }

    public void setHudGreenBg(boolean enabled) {
        if (mLayoutHud != null) {
            // Light Green: #90EE90 (Or similar usually used for debugging boundaries)
            // Or semi-transparent Green: #8000FF00
            mLayoutHud.setBackgroundColor(enabled ? 0x8000FF00 : android.graphics.Color.TRANSPARENT);
        }
    }


    // --- Layout Sync Logic (1:1 Mapping) ---

    public void syncHudLayout(List<ClusterHudManager.HudComponentData> components) {
        // [API30] Target 800x230 directly. No scaling factor needed if data.x/y are pixels.
        syncLayoutGeneric(mLayoutHud, mRealHudComponents, components, 800, 230);
    }

    public void syncClusterLayout(List<ClusterHudManager.HudComponentData> components) {
        syncLayoutGeneric(mLayoutCluster, mRealClusterComponents, components, 1920, 720);
    }

    /**
     * Replicates functionality of legacy syncLayoutGeneric but strictly 1:1.
     */
    private void syncLayoutGeneric(View layoutView, List<View> viewList,
                                   List<ClusterHudManager.HudComponentData> components,
                                   int targetWidth, int targetHeight) {
        if (!(layoutView instanceof FrameLayout)) return;
        FrameLayout container = (FrameLayout) layoutView;

        container.removeAllViews();
        viewList.clear();

        if (components == null) return;

        for (ClusterHudManager.HudComponentData data : components) {
            View view;
            boolean isSong = "song_2line".equals(data.type) || "song_1line".equals(data.type);
            boolean isTurnSignal = "turn_signal".equals(data.type);
            boolean isVolume = "volume".equals(data.type);
            boolean isMediaCover = "song_cover".equals(data.type);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);

            if (isSong) {
                LinearLayout ll = new LinearLayout(getContext());
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.setPadding(0, 0, 0, 0);

                String text = data.text != null ? data.text : "";
                String[] parts = text.split("\n");
                String title = parts.length > 0 ? parts[0] : "";
                String artist = parts.length > 1 ? parts[1] : "";

                TextView tvTitle = createTextView(title, 22, data.color);
                tvTitle.setSingleLine(true);
                tvTitle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                tvTitle.setMarqueeRepeatLimit(-1);
                tvTitle.setSelected(true);
                ll.addView(tvTitle);

                if (!artist.isEmpty()) {
                    TextView tvArtist = createTextView(artist, 22, data.color);
                    tvArtist.setSingleLine(true);
                    tvArtist.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                    tvArtist.setMarqueeRepeatLimit(-1);
                    tvArtist.setSelected(true);
                    
                    LinearLayout.LayoutParams artistParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    artistParams.topMargin = -4; // Sync styling
                    ll.addView(tvArtist, artistParams);
                }
                params.width = 300;
                view = ll;
            } else if (isMediaCover || isTurnSignal || isVolume) {
                ImageView iv = new ImageView(getContext());
                if (data.image != null) {
                    iv.setImageBitmap(data.image);
                    iv.clearColorFilter();
                } else {
                    // Icons not loaded here, usually handled by updateComponent
                    if (isVolume) iv.setImageResource(R.drawable.ic_volume);
                }
                iv.setBackgroundColor(android.graphics.Color.TRANSPARENT);

                if (isMediaCover) {
                    params.width = 100;
                    params.height = 100;
                } else if (isTurnSignal || isVolume) {
                    params.height = 36;
                    params.width = FrameLayout.LayoutParams.WRAP_CONTENT;
                    iv.setAdjustViewBounds(true);
                    iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                view = iv;
            } else if ("time".equals(data.type)) {
                TextClock tc = new TextClock(getContext());
                String format = (data.text != null && data.text.contains("H")) ? data.text : "HH:mm";
                tc.setFormat12Hour(format);
                tc.setFormat24Hour(format);
                tc.setTextColor(data.color);
                tc.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, 24);
                tc.setIncludeFontPadding(false);
                if (data.typeface != null) tc.setTypeface(data.typeface);
                view = tc;
            } else if ("traffic_light".equals(data.type)) {
                TrafficLightView tlv = new TrafficLightView(getContext());
                params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                view = tlv;
            } else if ("gear".equals(data.type)) {
                TextView tv = createTextView(data.text != null ? data.text : "P", 48, data.color);
                tv.setGravity(android.view.Gravity.CENTER);
                params.width = 100;
                view = tv;
            } else if ("fuel_range".equals(data.type) || "fuel".equals(data.type)) {
                LinearLayout ll = new LinearLayout(getContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setGravity(android.view.Gravity.CENTER_VERTICAL);
                
                TextView tvEmoji = createTextView("⛽", 18, data.color);
                ll.addView(tvEmoji);
                
                String valText = (data.text != null) ? data.text.replace("⛽", "").trim() : "";
                TextView tvValue = createTextView(" " + valText, 24, data.color);
                ll.addView(tvValue);
                
                view = ll;
                view = ll;
                view = ll;
                view = ll;
            } else if ("line_horizontal".equals(data.type) || "guideline_h".equals(data.type) || "guide_line_h".equals(data.type)) {
                // [FIX] Use Container to match Preview logic and fix coordinate offset (50px)
                // Preview uses a 380x100 container with a centered line.
                // This means the coordinate (X,Y) refers to the container's Top-Left.
                // The visual line is at Y + 50.
                if ("guide_line_h".equals(data.type)) {
                    android.widget.FrameLayout hGuideContainer = new android.widget.FrameLayout(getContext());
                    params.width = 380; 
                    params.height = 100;
                    
                    View line = new View(getContext());
                    line.setBackgroundColor(data.color);
                    
                    android.widget.FrameLayout.LayoutParams lp = new android.widget.FrameLayout.LayoutParams(380, 4);
                    lp.gravity = android.view.Gravity.CENTER;
                    hGuideContainer.addView(line, lp);
                    view = hGuideContainer;
                } else {
                    // Legacy simple line
                    View line = new View(getContext());
                    line.setBackgroundColor(data.color);
                    params.width = 100; 
                    params.height = 2; 
                    view = line;
                }
            } else if ("line_vertical".equals(data.type) || "guideline_v".equals(data.type) || "guide_line".equals(data.type)) {
                 // [FIX] Use Container for Vertical Guide Line too
                 if ("guide_line".equals(data.type)) {
                    android.widget.FrameLayout vGuideContainer = new android.widget.FrameLayout(getContext());
                    params.width = 100; 
                    params.height = 380;
                    
                    View line = new View(getContext());
                    line.setBackgroundColor(data.color);
                    
                    android.widget.FrameLayout.LayoutParams lp = new android.widget.FrameLayout.LayoutParams(4, 380);
                    lp.gravity = android.view.Gravity.CENTER;
                    vGuideContainer.addView(line, lp);
                    view = vGuideContainer;
                } else {
                    View line = new View(getContext());
                    line.setBackgroundColor(data.color);
                    params.width = 2; 
                    params.height = 50; 
                    view = line;
                }
            } else {
                // Generic TextView
                // Handle special alignments for temp/rpm if needed
                TextView tv = createTextView(data.text != null ? data.text : "", 24, data.color);
                if (data.typeface != null) tv.setTypeface(data.typeface);
                if ("hud_rpm".equals(data.type)) {
                    tv.setGravity(android.view.Gravity.END);
                    tv.setSingleLine(true);
                    tv.setMaxLines(1);
                    params.width = 100;
                } else if ("temp_out".equals(data.type) || "temp_in".equals(data.type)) {
                    tv.setGravity(android.view.Gravity.END);
                    tv.setSingleLine(true);
                    tv.setMaxLines(1);
                    params.width = 90;
                }
                view = tv;
            }
            
            // --- Positioning ---
            view.setTag(data);
            params.gravity = android.view.Gravity.TOP | android.view.Gravity.START;
            container.addView(view, params);

            view.setPivotX(0);
            view.setPivotY(0);
            if (!isTurnSignal) {
                view.setScaleX(data.scale);
                view.setScaleY(data.scale);
            }

            // Measure for centering/clamping logic
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED); // Simplified measurement
            
            // Visual Margin Compensation (Legacy Styling)
            float toleranceTop = 0f;
            float toleranceBottom = 0f;
            float FACTOR_TOP = 0.18f;
            float FACTOR_BOTTOM = 0.2f;

            if (!isSong && !isMediaCover && view instanceof TextView) {
                float size = ((TextView) view).getTextSize();
                toleranceTop = size * FACTOR_TOP * data.scale;
                toleranceBottom = size * FACTOR_BOTTOM * data.scale;
            }

            // Clamping
            // If data.x / data.y are plain pixels within 800x480
            // We trust the data.x as left coord.
            // Note: Legacy used relative logic implies data.x might be < 1.0??
            // If user uses new Editor, data.x will be > 1.0 (pixels).
            // If user uses old data, data.x might be relative?
            // Assumption: New Editor saves Pixels. If data < 1.0, it might layout at 0.
            // We should check if data.x is relative or absolute.
            // But strict requirement says NO SCALING. So we assume Absolute.
            
            float finalX = data.x;
            float finalY = data.y;

            // Simple Clamping logic
            // finalX = Math.max(0, Math.min(finalX, targetWidth - view.getMeasuredWidth()));
            
            // Apply coordinates directly
            view.setX(finalX);
            view.setY(finalY); // Ignoring tolerance logic for strict placement, or apply?
            // "Sync Visual Style" implies we should apply the tolerance logic (negative margins) behavior
            // But setY sets visual position. 
            // Legacy: view.setY(clampedY); where clampedY could be negative by toleranceTop.
            // We accept the raw Y which should be visual Y. Editor likely has Y at top of bounding box.
            
            // Layout Visibility
            boolean isVisible = true;
            if (isSong || isMediaCover) isVisible = mIsMediaPlaying;
            else if (isVolume) isVisible = mIsVolumeVisible;
            view.setVisibility(isVisible ? View.VISIBLE : View.GONE);

            viewList.add(view);
        }
    }

    private TextView createTextView(String text, float sizePx, int color) {
        TextView tv = new TextView(getContext());
        tv.setText(text);
        tv.setTextSize(android.util.TypedValue.COMPLEX_UNIT_PX, sizePx);
        tv.setTextColor(color);
        tv.setIncludeFontPadding(false);
        tv.setPadding(0, 0, 0, 0);
        tv.setBackgroundColor(android.graphics.Color.TRANSPARENT);
        return tv;
    }

    // --- Data Update Methods (Unified) ---

    public void updateSpeed(int speedKmh) {
        // [API30] Speed is Int
        updateComponentGeneric(mRealHudComponents, "speed", String.valueOf(speedKmh), null);
        updateComponentGeneric(mRealClusterComponents, "speed", String.valueOf(speedKmh), null);
        
        // XML Update
        if (mStandardSpeedText != null && mStandardClusterView != null && mStandardClusterView.getVisibility() == View.VISIBLE) {
            mStandardSpeedText.setText(String.valueOf(speedKmh));
        }
    }

    public void updateGear(int gear) {
        // Convert to String if needed, or pass Int if component handles it
        // Simulating legacy "updateGear"
        String gearStr = "P"; // Default
        switch(gear) {
            case 1: gearStr = "P"; break; // Example mapping, ensure matches ConfigManager
            case 2: gearStr = "R"; break;
            case 3: gearStr = "N"; break;
            case 4: gearStr = "D"; break;
            case 5: gearStr = "S"; break;
            case 6: gearStr = "M"; break;
        }
        // If "gear" component expects text:
        updateComponentGeneric(mRealHudComponents, "gear", gearStr, null);
        updateComponentGeneric(mRealClusterComponents, "gear", gearStr, null);
        
        // XML Update
        if (mStandardGearText != null && mStandardClusterView != null && mStandardClusterView.getVisibility() == View.VISIBLE) {
            mStandardGearText.setText(gearStr);
        }
    }
    
    // Generic Update Loop
    private void updateComponentGeneric(List<View> viewList, String type, String text, android.graphics.Bitmap image) {
        for (View v : viewList) {
            Object tag = v.getTag();
            if (tag instanceof ClusterHudManager.HudComponentData) {
                if (type.equals(((ClusterHudManager.HudComponentData) tag).type)) {
                    if (v instanceof TextView && text != null) {
                        ((TextView) v).setText(text);
                    } else if (v instanceof LinearLayout) {
                         // Specific logic for Song/Fuel combined views
                         LinearLayout ll = (LinearLayout) v;
                         if (("fuel_range".equals(type) || "fuel".equals(type)) && ll.getChildCount() > 1) {
                             ((TextView) ll.getChildAt(1)).setText(" " + text.replace("⛽", "").trim());
                         } else if (type.startsWith("song") && ll.getChildCount() > 0) {
                             String[] parts = text.split("\n");
                             ((TextView) ll.getChildAt(0)).setText(parts[0]);
                             if (parts.length > 1 && ll.getChildCount() > 1) {
                                 ((TextView) ll.getChildAt(1)).setText(parts[1]);
                             }
                         }
                    } else if (v instanceof ImageView && image != null) {
                        ((ImageView) v).setImageBitmap(image);
                    }
                }
            }
        }
    }

    // --- API for other updates ---
    public void setMediaPlaying(boolean playing) {
        mIsMediaPlaying = playing;
        // Update visibility loops...
        updateVisibilityGeneric(mRealHudComponents, playing, "media");
        updateVisibilityGeneric(mRealClusterComponents, playing, "media");
    }
    
    private void updateVisibilityGeneric(List<View> viewList, boolean visible, String group) {
        for (View v : viewList) {
             Object tag = v.getTag();
             String type = (tag instanceof ClusterHudManager.HudComponentData) ? ((ClusterHudManager.HudComponentData) tag).type : "";
             if ("media".equals(group) && (type.startsWith("song") || type.equals("song_cover"))) {
                 v.setVisibility(visible ? View.VISIBLE : View.GONE);
             }
        }
    }
    
    public void setVolumeVisible(boolean visible) {
        mIsVolumeVisible = visible;
        // Similar updateVisibilityGeneric for "volume"
        for (View v : mRealHudComponents) {
             Object tag = v.getTag();
             String type = (tag instanceof ClusterHudManager.HudComponentData) ? ((ClusterHudManager.HudComponentData) tag).type : "";
             if ("volume".equals(type)) v.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }
    
    public void updateComponent(String type, String text, android.graphics.Bitmap image) {
        updateComponentGeneric(mRealHudComponents, type, text, image);
        updateComponentGeneric(mRealClusterComponents, type, text, image);
    }

    // --- Missing Methods Implementation ---

    public void updateTrafficLight(NaviInfoController.TrafficLightInfo info) {
        // For now, Api30 only supports basic traffic light via HUD components?
        // Or we need to implement the floating view logic if needed.
        // Legacy Presentation.java has complex logic for this.
        // For minimal scope compliance, we will log it.
        // If specific UI is needed, it should be added here.
        // DebugLogger.d(TAG, "updateTrafficLight: " + info.status);
    }

    public void updateGuideInfo(NaviInfoController.GuideInfo info) {
        // Similar to above, minimal implementation for now.
        // DebugLogger.d(TAG, "updateGuideInfo: " + info.nextRoadName);
    }

    public void setNavigating(boolean isNavigating) {
        // DebugLogger.d(TAG, "setNavigating: " + isNavigating);
    }

    public void updateDayNightMode(boolean isDay) {
        // Implement if Day/Night specific UI elements exist in Api30 layout
        // Currently layout is static or handled by text color
    }

    // --- XML Layout Support for Cluster ---
    private View mStandardClusterView;
    private TextView mStandardSpeedText;
    private TextView mStandardGearText;
    private View mAudiRsClusterView;
    private int mPendingTheme = -1; // Cache theme if layout not ready

    public void setClusterTheme(int theme) {
        mCurrentTheme = theme;
        if (mLayoutCluster == null) {
            mPendingTheme = theme; // Cache it
            DebugLogger.d(TAG, LOG_PREFIX + "setClusterTheme: Layout not ready, caching theme: " + theme);
            return;
        }
        
        // 1. Hide existing
        if (mStandardClusterView != null) mStandardClusterView.setVisibility(View.GONE);
        if (mAudiRsClusterView != null) mAudiRsClusterView.setVisibility(View.GONE);
        
        // 2. Inflate/Show requested
        if (theme == THEME_DEFAULT) {
            if (mStandardClusterView == null) {
                mStandardClusterView = android.view.LayoutInflater.from(getContext())
                        .inflate(R.layout.layout_cluster_standard, mLayoutCluster, false);
                // Replicating Legacy: Ensure MATCH_PARENT
                mLayoutCluster.addView(mStandardClusterView, new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 
                        ViewGroup.LayoutParams.MATCH_PARENT));
                
                // Bind Views
                mStandardSpeedText = mStandardClusterView.findViewById(R.id.standardSpeedText);
                mStandardGearText = mStandardClusterView.findViewById(R.id.standardGearText);
                
                // Init Values immediately (Legacy behavior)
                if (mStandardSpeedText != null) mStandardSpeedText.setText("0");
                if (mStandardGearText != null) mStandardGearText.setText("P");
            }
            mStandardClusterView.setVisibility(View.VISIBLE);
        } else if (theme == THEME_AUDI_RS) {
             if (mAudiRsClusterView == null) {
                 mAudiRsClusterView = android.view.LayoutInflater.from(getContext())
                         .inflate(R.layout.layout_cluster_audi_rs, mLayoutCluster, false);
                 mLayoutCluster.addView(mAudiRsClusterView, new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 
                        ViewGroup.LayoutParams.MATCH_PARENT));
                 // Bind Audi RS specific views here if needed by user
             }
             mAudiRsClusterView.setVisibility(View.VISIBLE);
        }
    }

    public void updateTurnSignal(boolean leftVisible, boolean rightVisible) {
        // Updates Turn Signal views in the component list
        if (mRealHudComponents != null) {
            updateVisibilityGeneric(mRealHudComponents, leftVisible, "turn_signal_left");
            updateVisibilityGeneric(mRealHudComponents, rightVisible, "turn_signal_right");
        }
        if (mRealClusterComponents != null) {
            updateVisibilityGeneric(mRealClusterComponents, leftVisible, "turn_signal_left");
            updateVisibilityGeneric(mRealClusterComponents, rightVisible, "turn_signal_right");
        }
    }
}
