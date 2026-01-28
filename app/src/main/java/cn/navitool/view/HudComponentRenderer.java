package cn.navitool.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import cn.navitool.R;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.model.HudComponentData;

/**
 * HUD 组件渲染器。
 * 统一处理预览 (Preview) 和实际 HUD (Presentation) 的组件创建逻辑。
 * 
 * 预览模式 (isPreview=true): 尺寸为实际 HUD 的 2 倍，用于设置页面的可视化编辑。
 * 实际模式 (isPreview=false): 尺寸为 1 倍，用于 Presentation 显示。
 */
public class HudComponentRenderer {

    // 预览模式的缩放因子 (Preview is 2x real HUD)
    private static final float PREVIEW_SCALE = 2.0f;
    
    /**
     * 根据类型创建 HUD 组件视图。
     *
     * @param context   Context
     * @param data      组件数据
     * @param isPreview true 表示预览模式（2x 尺寸），false 表示实际 HUD 模式（1x 尺寸）
     * @param color     文本颜色（雪地模式为青色，否则为白色）
     * @return 创建的 View
     */
    public static View createComponent(Context context, HudComponentData data, boolean isPreview, int color) {
        if (data == null || data.type == null) {
            return createDefaultTextView(context, "Error", color);
        }

        String type = data.type;
        String text = data.text != null ? data.text : "";
        float scale = isPreview ? PREVIEW_SCALE : 1.0f;

        View view;

        switch (type) {
            case "song_2line":
            case "song_1line":
                view = createSongComponent(context, text, type, scale, color);
                break;

            case "fuel_range":
            case "fuel":
                view = createFuelComponent(context, text, type, scale, color);
                break;

            case "traffic_light":
                view = createTrafficLightComponent(context, scale);
                break;

            case "turn_signal":
                view = createTurnSignalComponent(context, scale, data.scale);
                break;

            case "song_cover":
                view = createSongCoverComponent(context, scale);
                break;

            case "volume":
                view = createVolumeComponent(context, scale, color);
                break;

            case "auto_hold":
                view = createAutoHoldComponent(context, scale);
                break;

            case "guide_line":
                view = createGuideLineComponent(context, scale);
                break;

            case "time":
                view = createTimeComponent(context, scale, color);
                break;

            case "gear":
                view = createGearComponent(context, text, scale, color, isPreview);
                break;

            case "hud_rpm":
                view = createRpmComponent(context, text, scale, color);
                break;

            case "temp_out":
            case "temp_in":
            case "range":
            case "navi_distance_remaining":
            case "navi_arrival_time":
            case "navi_current_road":
            case "navi_next_road":
                view = createGenericTextComponent(context, type, text, scale, color);
                break;

            default:
                view = createDefaultTextView(context, text, color);
                break;
        }

        // 设置通用属性
        // [FIX] 只在背景未设置时设置为透明，避免覆盖已设置的背景（如 gear 的居中定位线）
        if (view.getBackground() == null) {
            view.setBackgroundColor(Color.TRANSPARENT);
        }
        view.setPivotX(0f);
        view.setPivotY(0f);

        return view;
    }

    // ==================== 组件创建方法 ====================

    private static View createSongComponent(Context context, String text, String type, float scale, int color) {
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setBackgroundColor(Color.TRANSPARENT);
        ll.setPadding(0, 0, 0, 0);

        String[] parts = text.split("\n");
        String title = parts.length > 0 ? parts[0] : "";
        String artist = parts.length > 1 ? parts[1] : "";

        // 使用占位符（Preview 时）
        if (title.isEmpty()) title = "歌曲标题";
        if (artist.isEmpty() && "song_2line".equals(type)) artist = "歌手名";

        float textSize = 22 * scale; // Base 22px for real HUD

        // Title
        TextView tvTitle = new TextView(context);
        tvTitle.setText(title);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        tvTitle.setTextColor(color);
        tvTitle.setSingleLine(true);
        tvTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tvTitle.setMarqueeRepeatLimit(-1);
        tvTitle.setSelected(true);
        tvTitle.setIncludeFontPadding(false);
        ll.addView(tvTitle);

        // Artist (only for song_2line)
        if ("song_2line".equals(type)) {
            TextView tvArtist = new TextView(context);
            tvArtist.setText(artist);
            tvArtist.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            tvArtist.setTextColor(color);
            tvArtist.setSingleLine(true);
            tvArtist.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            tvArtist.setMarqueeRepeatLimit(-1);
            tvArtist.setSelected(true);
            tvArtist.setIncludeFontPadding(false);

            LinearLayout.LayoutParams artistParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            artistParams.topMargin = (int) (-4 * scale); // Reduce line spacing
            ll.addView(tvArtist, artistParams);
        }

        int width = (int) (300 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, FrameLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(params);

        return ll;
    }

    private static View createFuelComponent(Context context, String text, String type, float scale, int color) {
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER_VERTICAL | Gravity.END);
        ll.setBackgroundColor(Color.TRANSPARENT);

        // Emoji
        TextView tvEmoji = new TextView(context);
        tvEmoji.setText("⛽");
        tvEmoji.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18 * scale);
        tvEmoji.setTextColor(color);
        tvEmoji.setBackgroundColor(Color.TRANSPARENT);
        tvEmoji.setPadding(0, 0, (int) (4 * scale), 0);
        tvEmoji.setIncludeFontPadding(false);

        // Value
        TextView tvValue = new TextView(context);
        String valText = text.replace("⛽", "").trim();
        tvValue.setText(" " + valText);
        tvValue.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24 * scale);
        tvValue.setTextColor(color);
        tvValue.setBackgroundColor(Color.TRANSPARENT);
        tvValue.setIncludeFontPadding(false);
        tvValue.setSingleLine(true);
        tvValue.setEllipsize(TextUtils.TruncateAt.END);

        ll.addView(tvEmoji);
        ll.addView(tvValue);

        // Differentiate width: fuel=65, fuel_range=175
        int baseWidth = "fuel".equals(type) ? 75 : 175;
        int width = (int) (baseWidth * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, FrameLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(params);

        return ll;
    }

    private static View createTrafficLightComponent(Context context, float scale) {
        TrafficLightView tlv = new TrafficLightView(context);
        
        // [UPDATE] Preview state: 3 lights - Left Red, Straight Green, Right Green, all 66s
        java.util.List<TrafficLightView.LightState> previewStates = new java.util.ArrayList<>();
        previewStates.add(new TrafficLightView.LightState(TrafficLightView.STATUS_RED, 66, 1));   // Left - Red
        previewStates.add(new TrafficLightView.LightState(TrafficLightView.STATUS_GREEN, 66, 0)); // Straight - Green
        previewStates.add(new TrafficLightView.LightState(TrafficLightView.STATUS_GREEN, 66, 2)); // Right - Green
        tlv.updateMultiLights(previewStates);
        
        // HUD uses right alignment (extends left)
        tlv.setAlignment(TrafficLightView.ALIGN_RIGHT);
        tlv.setPreviewScale(scale);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        tlv.setLayoutParams(params);

        return tlv;
    }

    private static View createTurnSignalComponent(Context context, float scale, float componentScale) {
        ImageView iv = new ImageView(context);
        iv.setBackgroundColor(Color.TRANSPARENT);

        try {
            Bitmap bmp = ClusterHudManager.getInstance(context).getTurnSignalBitmap(true, true, componentScale);
            if (bmp != null) {
                iv.setImageBitmap(bmp);
            } else {
                iv.setImageResource(R.drawable.ic_turn_signal);
            }
        } catch (Exception e) {
            iv.setImageResource(R.drawable.ic_turn_signal);
        }

        int height = (int) (36 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, height);
        iv.setAdjustViewBounds(true);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(params);

        return iv;
    }

    private static View createSongCoverComponent(Context context, float scale) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(android.R.drawable.ic_media_play);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setBackgroundColor(Color.TRANSPARENT);

        int size = (int) (100 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);
        iv.setLayoutParams(params);

        return iv;
    }

    private static View createVolumeComponent(Context context, float scale, int color) {
        ImageView iv = new ImageView(context);
        iv.setBackgroundColor(Color.TRANSPARENT);

        try {
            Bitmap bmp = ClusterHudManager.getInstance(context).getVolumeBitmap(15);
            if (bmp != null) {
                iv.setImageBitmap(bmp);
            } else {
                iv.setImageResource(R.drawable.ic_volume);
                iv.setColorFilter(color);
            }
        } catch (Exception e) {
            iv.setImageResource(R.drawable.ic_volume);
            iv.setColorFilter(color);
        }

        int height = (int) (30 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, height);
        iv.setAdjustViewBounds(true);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(params);

        return iv;
    }

    private static View createAutoHoldComponent(Context context, float scale) {
        ImageView iv = new ImageView(context);
        iv.setBackgroundColor(Color.TRANSPARENT);

        try {
            Bitmap bmp = ClusterHudManager.getInstance(context).getAutoHoldBitmap(true);
            if (bmp != null) {
                iv.setImageBitmap(bmp);
            } else {
                iv.setImageResource(R.drawable.ic_auto_hold);
            }
        } catch (Exception e) {
            iv.setImageResource(R.drawable.ic_auto_hold);
        }

        int size = (int) (36 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);
        iv.setAdjustViewBounds(true);
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setLayoutParams(params);

        return iv;
    }

    private static View createGuideLineComponent(Context context, float scale) {
        // Use FrameLayout container for line + coordinate text (preview only)
        FrameLayout container = new FrameLayout(context);
        int width = (int) (50 * scale);
        int height = (int) (190 * scale);
        FrameLayout.LayoutParams containerParams = new FrameLayout.LayoutParams(width, height);
        container.setLayoutParams(containerParams);

        // 1. The vertical dashed line (custom draw)
        View lineView = new View(context) {
            private final android.graphics.Paint mPaint = new android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG);
            {
                mPaint.setColor(Color.CYAN);
                mPaint.setStyle(android.graphics.Paint.Style.STROKE);
                mPaint.setStrokeWidth(4);
                mPaint.setPathEffect(new android.graphics.DashPathEffect(new float[]{10, 10}, 0));
            }

            @Override
            protected void onDraw(android.graphics.Canvas canvas) {
                super.onDraw(canvas);
                float cx = getWidth() / 2f;
                canvas.drawLine(cx, 0, cx, getHeight(), mPaint);
            }
        };
        lineView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        FrameLayout.LayoutParams lineParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        container.addView(lineView, lineParams);

        // 2. Coordinate text (only in preview mode, scale > 1)
        if (scale > 1.0f) {
            TextView tvCoord = new TextView(context);
            tvCoord.setText("X:0");
            tvCoord.setTextSize(TypedValue.COMPLEX_UNIT_PX, 18 * scale);
            tvCoord.setTextColor(Color.CYAN);
            tvCoord.setBackgroundColor(0x80000000);
            tvCoord.setPadding(4, 2, 4, 2);
            FrameLayout.LayoutParams tvParams = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
            tvParams.gravity = Gravity.CENTER;
            container.addView(tvCoord, tvParams);
        }

        return container;
    }

    private static View createTimeComponent(Context context, float scale, int color) {
        TextClock tc = new TextClock(context);
        tc.setFormat12Hour("HH:mm");
        tc.setFormat24Hour("HH:mm");
        tc.setTimeZone(null);
        tc.setBackgroundColor(Color.TRANSPARENT);
        tc.setTextColor(color);
        tc.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24 * scale);
        tc.setIncludeFontPadding(false);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        tc.setLayoutParams(params);

        return tc;
    }

    private static View createGearComponent(Context context, String text, float scale, int color, boolean isPreview) {
        TextView tv = new TextView(context);
        tv.setText(text.isEmpty() ? "P" : text);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 48 * scale);
        tv.setTextColor(color);
        tv.setGravity(Gravity.CENTER);
        tv.setIncludeFontPadding(false);

        int width = (int) (100 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, FrameLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(params);

        // Add center line overlay in preview mode for alignment reference
        if (isPreview) {
            try {
                // Use fixed size matching original code: 200x96 for preview (2x scale)
                int bmpWidth = (int) (100 * scale);  // 200 for 2x scale
                int bmpHeight = (int) (48 * scale);  // 96 for 2x scale
                android.graphics.Bitmap bgBitmap = android.graphics.Bitmap.createBitmap(
                        bmpWidth, bmpHeight, android.graphics.Bitmap.Config.ARGB_8888);
                if (bgBitmap != null) {
                    bgBitmap = ClusterHudManager.getInstance(context).addCenterLineOverlay(bgBitmap);
                    tv.setBackground(new android.graphics.drawable.BitmapDrawable(context.getResources(), bgBitmap));
                }
            } catch (Exception e) {
                tv.setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            tv.setBackgroundColor(Color.TRANSPARENT);
        }

        return tv;
    }

    private static View createRpmComponent(Context context, String text, float scale, int color) {
        TextView tv = new TextView(context);
        tv.setText(text);
        tv.setBackgroundColor(Color.TRANSPARENT);
        tv.setSingleLine(true);
        tv.setEllipsize(null);
        tv.setGravity(Gravity.END);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24 * scale);
        tv.setTextColor(color);
        tv.setIncludeFontPadding(false);

        int width = (int) (120 * scale);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, FrameLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(params);

        return tv;
    }

    private static View createGenericTextComponent(Context context, String type, String text, float scale, int color) {
        TextView tv = new TextView(context);
        tv.setText(text);
        tv.setTextColor(color);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24 * scale);
        tv.setIncludeFontPadding(false);
        tv.setBackgroundColor(Color.TRANSPARENT);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);

        // Type-specific width for alignment
        if ("navi_distance_remaining".equals(type)) {
            tv.setGravity(Gravity.END);
            params.width = (int) (120 * scale);
        } else if ("temp_out".equals(type) || "temp_in".equals(type)) {
            tv.setGravity(Gravity.END);
            params.width = (int) (90 * scale);
        } else if ("range".equals(type)) {
            tv.setGravity(Gravity.END);
            params.width = (int) (120 * scale);
        }

        tv.setLayoutParams(params);
        return tv;
    }

    private static View createDefaultTextView(Context context, String text, int color) {
        TextView tv = new TextView(context);
        tv.setText(text);
        tv.setTextColor(color);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24);
        tv.setBackgroundColor(Color.TRANSPARENT);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(params);

        return tv;
    }

    // ==================== 内容更新方法 ====================

    /**
     * 更新组件内容（文本或图片）。
     *
     * @param view  目标视图
     * @param type  组件类型
     * @param text  新文本（可为 null）
     * @param image 新图片（可为 null）
     */
    public static void updateComponentContent(View view, String type, String text, Bitmap image) {
        updateComponentContent(view, type, text, image, false);
    }

    /**
     * 更新组件内容（文本或图片），支持预览模式。
     *
     * @param view      目标视图
     * @param type      组件类型
     * @param text      新文本（可为 null）
     * @param image     新图片（可为 null）
     * @param isPreview 是否为预览模式（为 true 时应用占位符逻辑）
     */
    public static void updateComponentContent(View view, String type, String text, Bitmap image, boolean isPreview) {
        if (view == null) return;

        if (view instanceof TextView && text != null) {
            ((TextView) view).setText(text);
        } else if (view instanceof LinearLayout) {
            LinearLayout ll = (LinearLayout) view;
            if ("song_2line".equals(type) || "song_1line".equals(type)) {
                // [FIX] Preview mode placeholder logic
                String title;
                String artist;
                boolean usePlaceholder = isPreview && (text == null || text.trim().isEmpty());
                
                if (usePlaceholder) {
                    title = "歌曲标题";
                    artist = "song_2line".equals(type) ? "歌手名" : "";
                } else {
                    String[] parts = (text != null ? text : "").split("\n");
                    title = parts.length > 0 ? parts[0] : "";
                    artist = parts.length > 1 ? parts[1] : "";
                }

                if (ll.getChildCount() > 0 && ll.getChildAt(0) instanceof TextView) {
                    ((TextView) ll.getChildAt(0)).setText(title);
                }
                if (ll.getChildCount() > 1 && ll.getChildAt(1) instanceof TextView) {
                    TextView tvArtist = (TextView) ll.getChildAt(1);
                    tvArtist.setText(artist);
                    // In 1-line mode, always hide artist; otherwise show if not empty
                    if ("song_1line".equals(type)) {
                        tvArtist.setVisibility(View.GONE);
                    } else {
                        tvArtist.setVisibility(artist.isEmpty() && !usePlaceholder ? View.GONE : View.VISIBLE);
                    }
                }
            } else if ("fuel_range".equals(type) || "fuel".equals(type)) {
                String valText = (text != null ? text : "").replace("⛽", "").trim();
                if (ll.getChildCount() > 1 && ll.getChildAt(1) instanceof TextView) {
                    ((TextView) ll.getChildAt(1)).setText(" " + valText);
                }
            }
        } else if (view instanceof ImageView && image != null) {
            ((ImageView) view).setImageBitmap(image);
            ((ImageView) view).clearColorFilter();
        }
    }
}
