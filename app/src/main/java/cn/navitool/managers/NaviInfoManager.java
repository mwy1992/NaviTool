package cn.navitool.managers;

import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import cn.navitool.utils.DebugLogger;
import cn.navitool.managers.ClusterHudManager;
import cn.navitool.view.TrafficLightView;

/**
 * 导航信息管理器 (NaviInfoManager)
 * 原 TrafficLightController 的升级版
 * 
 * 功能集成：
 * 1. 红绿灯控制 (Traffic Light Logic)
 * 2. 导航基础信息 (剩余里程、到达时间)
 */
public class NaviInfoManager {
    private static final String TAG = "NaviInfoManager";

    // --- Traffic Light Views ---
    private TrafficLightView mTrafficLightLeft;
    private TrafficLightView mTrafficLightStraight;
    private TrafficLightView mTrafficLightRight;

    // --- Navi Info Views (Optional) ---
    private TextView mDistanceView;
    private TextView mEtaView;

    // --- State ---
    private int mLastValidDirection = 0;

    // Data Cache
    private int mRouteRemainDis = -1;
    private int mRouteRemainTime = -1;

    private static volatile NaviInfoManager instance;
    private android.content.Context mContext;
    private Handler mainHandler; // Added: Declaration for mainHandler

    private NaviInfoManager(android.content.Context context) {
        mContext = context.getApplicationContext();
    }

    // Added: startManager method
    public void startManager(Context context) {
        this.mContext = context.getApplicationContext(); // Use mContext instead of this.context
        
        
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public static NaviInfoManager getInstance(android.content.Context context) {
        if (instance == null) {
            synchronized (NaviInfoManager.class) {
                if (instance == null) {
                    instance = new NaviInfoManager(context);
                    instance.startManager(context); // Call startManager here
                }
            }
        }
        return instance;
    }

    // --- Floating Window Control (Connected to ClusterHudManager) ---
    public void showTrafficLightFloating() {
        DebugLogger.i(TAG, "showTrafficLightFloating requested");
        ClusterHudManager.getInstance(mContext).setFloatingTrafficLightEnabled(true);
    }

    public void hideTrafficLightFloating() {
        DebugLogger.i(TAG, "hideTrafficLightFloating requested");
        ClusterHudManager.getInstance(mContext).setFloatingTrafficLightEnabled(false);
    }

    public void toggleFloatingStyle() {
        DebugLogger.i(TAG, "toggleFloatingStyle requested");
        ClusterHudManager.getInstance(mContext).toggleFloatingTrafficLightStyle();
    }

    /**
     * 绑定红绿灯视图
     */
    public void bindTrafficLightViews(TrafficLightView left, TrafficLightView straight, TrafficLightView right) {
        mTrafficLightLeft = left;
        mTrafficLightStraight = straight;
        mTrafficLightRight = right;

        // Initial Config
        if (mTrafficLightLeft != null) {
            mTrafficLightLeft.setOverrideDirection(1); // Left Arrow
            mTrafficLightLeft.setVisibility(View.INVISIBLE);
        }
        if (mTrafficLightStraight != null) {
            mTrafficLightStraight.setOverrideDirection(0); // Straight/Round (Draws Up Arrow)
            mTrafficLightStraight.setVisibility(View.INVISIBLE);
        }
        if (mTrafficLightRight != null) {
            mTrafficLightRight.setOverrideDirection(2); // Right Arrow
            mTrafficLightRight.setVisibility(View.INVISIBLE);
        }

        mLastValidDirection = 0;
    }

    /**
     * 绑定导航信息视图 (可选)
     */
    public void bindNaviInfoViews(TextView distanceView, TextView etaView) {
        mDistanceView = distanceView;
        mEtaView = etaView;
        // [FIX] Immediately retrieve data from internal cache if available
        updateNaviViews();
    }

    /**
     * 更新导航引导信息 (里程/时间)
     */
    public void updateGuideInfo(GuideInfo info) {
        if (info == null)
            return;

        // Update Internal Cache
        mRouteRemainDis = info.routeRemainDis;
        mRouteRemainTime = info.routeRemainTime;
        mEtaText = info.etaText; // Added: Update ETA Text

        // Update Views if bound
        updateNaviViews();
    }

    private String mEtaText = "";

    /**
     * 更新导航数值 (Internal helper for views)
     */
    /**
     * 更新导航数值 (Internal helper for views)
     */
    private void updateNaviViews() {
        if (mDistanceView != null) {
            String distText = formatDistance(mRouteRemainDis);
            mDistanceView.setText(distText);
            mDistanceView.setVisibility(distText.isEmpty() ? View.GONE : View.VISIBLE);
        }
        if (mEtaView != null) {
            // [OPTIMIZATION] Use Calculated ETA instead of parsing text
            // String eta = parseEta(mEtaText); 
            String eta = parseEta(mRouteRemainTime);
            String displayEta = eta.isEmpty() ? "" : "ETA " + eta;
            mEtaView.setText(displayEta);
            mEtaView.setVisibility(displayEta.isEmpty() ? View.GONE : View.VISIBLE);
        }
    }

    // updateNaviInfo(int, int) removed - fully replaced by updateGuideInfo

    public static String formatDistance(int dist) {
        if (dist < 0)
            return "";

        // Rule: < 1000m -> "<1km"
        if (dist < 1000) {
            return "<1km";
        }

        // Rule: >= 1000m -> "x.xkm" (1 decimal place)
        return String.format(java.util.Locale.US, "%.1fkm", dist / 1000.0f);
    }

    private String formatTime(int time) {
        // Original logic kept for backup, but now primary source is parseEta
        return "";
    }

    /**
     * Parse ETA using Time Calculation (Static Helper)
     * Optimized: System Time + Remaining Seconds
     */
    public static String calculateEta(int remainingSeconds) {
        if (remainingSeconds < 0) return "";
        
        long arrivalTime = System.currentTimeMillis() + (remainingSeconds * 1000L);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault());
        return sdf.format(new java.util.Date(arrivalTime));
    }

    // Instance wrapper for compatibility if needed, or update call sites
    public String parseEta(int remainingSeconds) {
        return calculateEta(remainingSeconds);
    }

    /**
     * Legacy Parse (Deprecated, kept for compatibility if needed or removed)
     * public static String parseEta(String rawText) { ... }
     */

    /**
     * 更新红绿灯状态
     */
    public void updateTrafficLight(TrafficLightInfo info) {
        if (info == null)
            return;

        DebugLogger.d(TAG, "TrafficLight Update: Status=" + info.status +
                ", Time=" + info.redCountdown +
                ", Dir=" + info.direction +
                ", Green=" + info.greenCountdown);

        // Route to correct view
        int effectiveDir = info.direction;
        // [Reverted] Strict Logic: dir=0 is a transition/invalid state -> Inherit last
        // valid
        if (effectiveDir != 0) {
            mLastValidDirection = effectiveDir;
        } else if (mLastValidDirection != 0) {
            effectiveDir = mLastValidDirection; // Inherit last direction
        }

        TrafficLightView targetView = null;
        if (effectiveDir == 1)
            targetView = mTrafficLightLeft;
        else if (effectiveDir == 2)
            targetView = mTrafficLightRight;
        else if (effectiveDir == 4) // Only 4 is explicitly Straight
            targetView = mTrafficLightStraight;

        if (targetView == null)
            return;

        int status = info.status;
        int time = info.redCountdown;

        int mappedStatus = mapStatus(status);

        // [FIX] Hide ALL views first to prevent stacking/overlay issues
        if (mTrafficLightLeft != null)
            mTrafficLightLeft.setVisibility(View.INVISIBLE);
        if (mTrafficLightStraight != null)
            mTrafficLightStraight.setVisibility(View.INVISIBLE);
        if (mTrafficLightRight != null)
            mTrafficLightRight.setVisibility(View.INVISIBLE);

        // Then show only the target
        if (mappedStatus != 0) {
            targetView.setVisibility(View.VISIBLE);
            targetView.updateState(mappedStatus, time, info.direction);
        }
    }

    /**
     * Map raw API status to TrafficLightView status
     * 0/-1 -> 0 (NONE)
     * 1 -> 2 (RED)
     * 2/4 -> 1 (GREEN)
     * 3 -> 3 (YELLOW)
     */
    public static int mapStatus(int status) {
        if (status == 1) {
            return 2; // STATUS_RED
        } else if (status == 2 || status == 4) {
            return 1; // STATUS_GREEN
        } else if (status == 3 || status == -1) {
            return 3; // STATUS_YELLOW
        } else {
            return 0; // STATUS_NONE (Cover 0, others)
        }
    }

    /**
     * 重置所有显示
     */
    public void reset() {
        resetTrafficLights();
        // Reset Navi Info
        mRouteRemainDis = -1;
        mRouteRemainTime = -1;
        mEtaText = ""; // [FIX] Reset ETA text
        updateNaviViews();
    }

    public void resetTrafficLights() {
        if (mTrafficLightLeft != null)
            mTrafficLightLeft.setVisibility(View.INVISIBLE);
        if (mTrafficLightStraight != null)
            mTrafficLightStraight.setVisibility(View.INVISIBLE);
        if (mTrafficLightRight != null)
            mTrafficLightRight.setVisibility(View.INVISIBLE);

        mLastValidDirection = 0; // Reset history
        DebugLogger.d(TAG, "Traffic Lights Reset (Hidden + History Cleared)");
    }

    // =================================================================================================
    // Inner Models (Consolidated from cn.navitool.models)
    // =================================================================================================

    // Compatibility Method for Legacy Calls (e.g. from ThemeControllers)
    public static String parseEta(String etaText) {
        if (etaText == null || etaText.isEmpty()) {
            return "";
        }
        return etaText; // Return raw text for compatibility
    }

    /**
     * 红绿灯信息实体类
     */
    public static class TrafficLightInfo {
        /**
         * 红绿灯状态
         * 0: 未知/灭, 1: 红灯, 2: 绿灯, 3: 黄灯
         */
        public int status;
        public int redCountdown;
        public int greenCountdown;
        /**
         * 方向: 1: 左转, 2: 右转, 4: 直行
         */
        public int direction;
        public int waitRound;

        public TrafficLightInfo() {
        }

        @Override
        public String toString() {
            return "TrafficLightInfo{status=" + status + ", red=" + redCountdown + ", dir=" + direction + "}";
        }
    }

    /**
     * 导航引导信息实体类
     */
    public static class GuideInfo {
        public String currentRoadName;
        public String nextRoadName;
        public int iconType;
        public int routeRemainDis;
        public int routeRemainTime;
        public int segRemainDis;
        public String etaText; // Added: "预计00:12到达"

        public GuideInfo() {
        }

        @Override
        public String toString() {
            return "GuideInfo{cur='" + currentRoadName + "', next='" + nextRoadName + "', dis=" + routeRemainDis
                    + ", eta='" + etaText + "'}";
        }
    }

}
