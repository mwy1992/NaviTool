package cn.navitool;

import android.app.Presentation;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * 这是一个透明的 Presentation，用于在副驾屏 (PSD) 上保活。
 * 通过设置 FLAG_KEEP_SCREEN_ON，告诉系统该屏幕正在被使用，从而禁止自动熄屏。
 * 同时设置 FLAG_NOT_TOUCHABLE 和 FLAG_NOT_FOCUSABLE，使其对用户操作完全透明。
 */
public class KeepAlivePresentation extends Presentation {

    private static final String TAG = "KeepAlivePresentation";

    public KeepAlivePresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置一个透明背景的 View
        View view = new View(getContext());
        // DEBUG: 设置为蓝色半透明 (#330000FF)，方便车上调试确认
        view.setBackgroundColor(Color.parseColor("#330000FF"));
        setContentView(view);

        // 配置 Window 属性
        // 1. FLAG_KEEP_SCREEN_ON: 核心！保持屏幕常亮
        // 2. FLAG_NOT_TOUCHABLE: 不接收触摸事件，事件穿透到底层
        // 3. FLAG_NOT_FOCUSABLE: 不获取焦点，不影响键盘
        // 4. FLAG_LAYOUT_NO_LIMITS: 全屏铺满
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // 核心修正：清除“背景变暗”的 Flag，防止屏幕蒙上一层灰色
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        // 确保背景也是透明的
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        DebugLogger.i(TAG, "KeepAlivePresentation Created on Display: " + getDisplay().getName() + " (ID: "
                + getDisplay().getDisplayId() + ")");
    }
}
