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
import android.widget.TextView; // Added TextView

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import android.content.ClipData;
import android.view.DragEvent;
import android.graphics.Color;

import cn.navitool.R;
import cn.navitool.managers.AppLaunchManager;
import cn.navitool.ConfigManager;
import cn.navitool.view.AppListAdapter;

public class FloatingBallService extends Service {

    // [NEW] 静态变量追踪服务运行状态，消耗极小（1字节），读取O(1)
    private static volatile boolean sIsRunning = false;

    public static boolean isRunning() {
        return sIsRunning;
    }

    private WindowManager mWindowManager;
    private View mFloatingView;
    private View mMenuView;
    private WindowManager.LayoutParams mFloatingParams;
    private WindowManager.LayoutParams mMenuParams;

    private boolean isMenuVisible = false;
    private TextView mTvHint; // [NEW] Hint TextView

    // [NEW] Data and Adapters as fields
    private List<AppLaunchManager.AppInfo> mTopApps;
    private List<AppLaunchManager.AppInfo> mScrollApps;
    private AppListAdapter mTopAdapter;
    private AppListAdapter mScrollAdapter;

    // [NEW] Drag State Class
    private static class DragState {
        boolean isSourceTop;
        int sourcePosition;
        AppLaunchManager.AppInfo appInfo;

        DragState(boolean isSourceTop, int sourcePosition, AppLaunchManager.AppInfo appInfo) {
            this.isSourceTop = isSourceTop;
            this.sourcePosition = sourcePosition;
            this.appInfo = appInfo;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sIsRunning = true; // 标记服务已启动
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
        container.setBackgroundColor(android.graphics.Color.TRANSPARENT); // Overlay removed
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
        // Setup RecyclerViews
        // Result Lists
        mTopApps = new ArrayList<>();
        mScrollApps = new ArrayList<>();

        // 1. Get All Apps (cleaned)
        List<AppLaunchManager.AppInfo> allApps = AppLaunchManager.getInstalledApps(this);
        // Remove Placeholders and find NaviTool
        AppLaunchManager.AppInfo naviTool = null;
        Iterator<AppLaunchManager.AppInfo> it = allApps.iterator();
        while (it.hasNext()) {
            AppLaunchManager.AppInfo app = it.next();
            if (app.packageName.isEmpty()) {
                it.remove(); // Remove placeholders
            } else if ("cn.navitool".equals(app.packageName)) {
                naviTool = app;
                it.remove();
            }
        }

        // 2. Initialize Top Row with NaviTool
        if (naviTool != null) {
            mTopApps.add(naviTool);
        }

        // 3. Load Saved Favorites
        List<String> savedPackages = AppLaunchManager.loadTopApps(this);
        for (String pkg : savedPackages) {
            if (mTopApps.size() >= 6) break;
            // Find app in allApps
            Iterator<AppLaunchManager.AppInfo> appIt = allApps.iterator();
            while (appIt.hasNext()) {
                AppLaunchManager.AppInfo app = appIt.next();
                if (app.packageName.equals(pkg)) {
                    mTopApps.add(app);
                    appIt.remove(); // Remove from available pool
                    break;
                }
            }
        }

        // 4. Fill Scroll List with remaining
        mScrollApps.addAll(allApps);


        // Setup Top Row (Fixed)
        RecyclerView rvTop = mMenuView.findViewById(R.id.rvTopRow);
        mTvHint = mMenuView.findViewById(R.id.tvHint); // Find Hint View
        updateHintVisibility(); // Initial check

        rvTop.setLayoutManager(new GridLayoutManager(this, 6));
        
        AppListAdapter.OnItemLongClickListener topLongListener = (v, appInfo, position) -> {
            // [CONSTRAINT] Generic "NaviTool" cannot be moved. It is at index 0.
            if (position == 0) return; 
            
            ClipData data = ClipData.newPlainText("app", appInfo.packageName);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            // Use startDragAndDrop for API 24+, startDrag for older
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(data, shadowBuilder, new DragState(true, position, appInfo), 0);
            } else {
                v.startDrag(data, shadowBuilder, new DragState(true, position, appInfo), 0);
            }
        };

        mTopAdapter = new AppListAdapter(this, mTopApps, appInfo -> {
            AppLaunchManager.launchApp(this, appInfo.packageName);
            hideMenu();
        }, topLongListener);
        rvTop.setAdapter(mTopAdapter);
        rvTop.setOnDragListener(getDragListener()); // Accept Drops

        // Setup Scrollable List (Remaining Apps)
        RecyclerView rv = mMenuView.findViewById(R.id.rvAppList);
        // Use Grid Layout with 6 columns (4 rows visible)
        rv.setLayoutManager(new GridLayoutManager(this, 6));
        
        AppListAdapter.OnItemLongClickListener scrollLongListener = (v, appInfo, position) -> {
             ClipData data = ClipData.newPlainText("app", appInfo.packageName);
             View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                 v.startDragAndDrop(data, shadowBuilder, new DragState(false, position, appInfo), 0);
             } else {
                 v.startDrag(data, shadowBuilder, new DragState(false, position, appInfo), 0);
             }
        };

        mScrollAdapter = new AppListAdapter(this, mScrollApps, appInfo -> {
            AppLaunchManager.launchApp(this, appInfo.packageName);
            hideMenu();
        }, scrollLongListener);
        rv.setAdapter(mScrollAdapter);
        rv.setOnDragListener(getDragListener()); // Accept Drops

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

    private View.OnDragListener getDragListener() {
        return (v, event) -> {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundColor(Color.parseColor("#33FFFFFF")); // Visual feedback
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundColor(Color.TRANSPARENT);
                    return true;
                case DragEvent.ACTION_DROP:
                    v.setBackgroundColor(Color.TRANSPARENT);
                    Object stateObj = event.getLocalState();
                    if (!(stateObj instanceof DragState)) return false;
                    DragState state = (DragState) stateObj;

                    boolean targetIsTop = (v.getId() == R.id.rvTopRow);

                    // Case 1: Drag FROM Top TO List
                    if (state.isSourceTop && !targetIsTop) {
                        // Remove from Top
                        mTopApps.remove(state.appInfo);
                        
                        // Add to Scroll (at top)
                        mScrollApps.add(0, state.appInfo);

                        mTopAdapter.notifyDataSetChanged();
                        mScrollAdapter.notifyDataSetChanged();
                        saveTopConfig();
                        updateHintVisibility(); // Update on drop
                        return true;
                    }

                    // Case 2: Drag FROM List TO Top
                    if (!state.isSourceTop && targetIsTop) {
                        // Check if Top is full
                        if (mTopApps.size() >= 6) {
                            // Remove last item (ensure we don't remove NaviTool at 0)
                            // Since size >= 6, and 0 is NaviTool, we have others.
                            AppLaunchManager.AppInfo last = mTopApps.remove(mTopApps.size() - 1);
                            mScrollApps.add(0, last);
                        }

                        // Remove from Scroll
                        mScrollApps.remove(state.appInfo);
                        // Add to Top
                        mTopApps.add(state.appInfo);

                        mTopAdapter.notifyDataSetChanged();
                        mScrollAdapter.notifyDataSetChanged();
                        saveTopConfig();
                        updateHintVisibility(); // Update on drop
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundColor(Color.TRANSPARENT);
                    return true;
            }
            return false;
        };
    }

    private void saveTopConfig() {
        List<String> packages = new ArrayList<>();
        // Skip index 0 (NaviTool)
        for (int i = 1; i < mTopApps.size(); i++) {
            packages.add(mTopApps.get(i).packageName);
        }
        AppLaunchManager.saveTopApps(this, packages);
    }

    private void updateHintVisibility() {
        if (mTvHint != null) {
            // NaviTool is always at 0, so size > 1 means user added something
            if (mTopApps.size() > 1) {
                mTvHint.setVisibility(View.GONE);
            } else {
                mTvHint.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sIsRunning = false; // 标记服务已停止
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
