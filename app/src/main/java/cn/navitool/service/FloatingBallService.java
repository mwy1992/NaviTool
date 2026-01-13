package cn.navitool.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.AppLaunchManager;
import cn.navitool.ConfigManager;
import cn.navitool.view.AppListAdapter;

public class FloatingBallService extends Service {

    private WindowManager mWindowManager;
    private View mFloatingView;
    private View mMenuView;
    private WindowManager.LayoutParams mFloatingParams;
    private WindowManager.LayoutParams mMenuParams;

    private boolean isMenuVisible = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        createFloatingView();
        createMenuView();
    }

    private void createFloatingView() {
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.service_floating_ball, null);

        int layoutType;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutType = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutType = WindowManager.LayoutParams.TYPE_PHONE;
        }

        mFloatingParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                layoutType,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        mFloatingParams.gravity = Gravity.TOP | Gravity.START;
        // [FIX] Load saved position
        mFloatingParams.x = cn.navitool.ConfigManager.getInstance().getInt("floating_ball_x", 100);
        mFloatingParams.y = cn.navitool.ConfigManager.getInstance().getInt("floating_ball_y", 100);

        // Implement Drag and Click
        ImageView ivBall = mFloatingView.findViewById(R.id.ivFloatingBall);
        ivBall.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;
            private long touchStartTime;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = mFloatingParams.x;
                        initialY = mFloatingParams.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        touchStartTime = System.currentTimeMillis();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        mFloatingParams.x = initialX + (int) (event.getRawX() - initialTouchX);
                        mFloatingParams.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(mFloatingView, mFloatingParams);
                        return true;

                    case MotionEvent.ACTION_UP:
                        long duration = System.currentTimeMillis() - touchStartTime;
                        float dx = event.getRawX() - initialTouchX;
                        float dy = event.getRawY() - initialTouchY;

                        // [FIX] Always save position on drag end
                        if (Math.abs(dx) > 10 || Math.abs(dy) > 10) {
                            ConfigManager.getInstance().setInt("floating_ball_x", mFloatingParams.x);
                            ConfigManager.getInstance().setInt("floating_ball_y", mFloatingParams.y);
                            ConfigManager.getInstance().saveProperties(); // Force write
                        }

                        if (duration < 200 && Math.abs(dx) < 10 && Math.abs(dy) < 10) {
                            toggleMenu();
                        }
                        return true;
                }
                return false;
            }
        });

        mWindowManager.addView(mFloatingView, mFloatingParams);
    }

    private void createMenuView() {
        // Create a root container to handle "outside click"
        FrameLayout container = new FrameLayout(this);
        container.setBackgroundColor(0x80000000); // Overlay dim
        container.setOnClickListener(v -> hideMenu());

        // Inflate the actual menu dialog
        View menuContent = LayoutInflater.from(this).inflate(R.layout.dialog_app_list, container, false);

        // Center the menu in the container
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) menuContent.getLayoutParams();
        if (params == null) {
            params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT);
        }
        params.gravity = Gravity.CENTER;
        menuContent.setLayoutParams(params);

        // Prevent clicks on menu content from closing the menu
        menuContent.setOnClickListener(v -> {
        }); // Consume click

        container.addView(menuContent);
        mMenuView = container;

        // Setup RecyclerView
        RecyclerView rv = mMenuView.findViewById(R.id.rvAppList);
        // Use Grid Layout with 4 columns
        rv.setLayoutManager(new GridLayoutManager(this, 4));

        List<AppLaunchManager.AppInfo> apps = AppLaunchManager.getInstalledApps(this);
        AppListAdapter adapter = new AppListAdapter(this, apps, appInfo -> {
            AppLaunchManager.launchApp(this, appInfo.packageName);
            hideMenu();
        });
        rv.setAdapter(adapter);

        // Setup Close Button
        View btnClose = mMenuView.findViewById(R.id.ivClose);
        if (btnClose != null) {
            btnClose.setOnClickListener(v -> hideMenu());
        }

        int layoutType;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutType = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutType = WindowManager.LayoutParams.TYPE_PHONE;
        }

        mMenuParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                layoutType,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, // Allow interaction
                PixelFormat.TRANSLUCENT);
    }

    private void toggleMenu() {
        if (isMenuVisible) {
            hideMenu();
        } else {
            showMenu();
        }
    }

    private void showMenu() {
        if (!isMenuVisible) {
            // Re-load apps just in case (optional, maybe overkill for every show)
            // For now keep static list from onCreate for performance
            try {
                mWindowManager.addView(mMenuView, mMenuParams);
                isMenuVisible = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void hideMenu() {
        if (isMenuVisible) {
            try {
                mWindowManager.removeView(mMenuView);
                isMenuVisible = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // [FIX] Save current position before destroying
        if (mFloatingParams != null) {
            cn.navitool.ConfigManager.getInstance().setInt("floating_ball_x", mFloatingParams.x);
            cn.navitool.ConfigManager.getInstance().setInt("floating_ball_y", mFloatingParams.y);
            cn.navitool.ConfigManager.getInstance().saveProperties(); // Force write to disk
        }

        if (mFloatingView != null) {
            try {
                mWindowManager.removeView(mFloatingView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (isMenuVisible && mMenuView != null) {
            try {
                mWindowManager.removeView(mMenuView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
