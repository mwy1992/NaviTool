package cn.navitool.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;

/**
 * 统一的 HUD 组件数据模型。
 * 用于在预览 (HudSettingsController) 和实际 HUD (PresentationManager) 之间传递组件数据。
 */
public class HudComponentData {
    /**
     * 组件类型。
     * 支持: "text", "time", "song_2line", "song_1line", "fuel", "fuel_range", "temp_out", "temp_in",
     * "range", "gear", "song_cover", "turn_signal", "volume", "auto_hold", "gauge", "path_gauge",
     * "traffic_light", "guide_line", "hud_rpm", "navi_arrival_time", "navi_distance_remaining", etc.
     */
    public String type;
    
    /** 文本内容 */
    public String text;
    
    /** 图片内容 (用于 song_cover, turn_signal, volume, gauge 等) */
    public Bitmap image;
    
    /** X坐标 (相对于容器) */
    public float x;
    
    /** Y坐标 (相对于容器) */
    public float y;
    
    /** 颜色 (默认白色) */
    public int color = Color.WHITE;
    
    /** 仪表盘配置 [min, max, startAngle, endAngle, pivotX, pivotY] */
    public float[] gaugeConfig;
    
    /** 自定义字体 */
    public Typeface typeface;
    
    /** 路径数据 (用于 path_gauge) */
    public String pathData;
    
    /** 最大值 (用于 path_gauge 进度计算) */
    public float maxValue;
    
    /** 组件缩放比例，默认1.0（不缩放） */
    public float scale = 1.0f;

    public HudComponentData() {
    }

    public HudComponentData(String type, String text, float x, float y, int color) {
        this.type = type;
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public HudComponentData(String type, String text, float x, float y) {
        this(type, text, x, y, Color.WHITE);
    }
}
