package cn.navitool.managers;

import android.os.Debug;
import android.util.Log;
import java.util.Locale;

public class MemoryMonitor {
    private static final String TAG = "NaviMemory";
    private static final long MB = 1024 * 1024;

    // Component Registry for Status Tracking
    private static final java.util.concurrent.ConcurrentHashMap<String, String> mComponentStatuses = new java.util.concurrent.ConcurrentHashMap<>();

    public static void setComponentStatus(String name, String status) {
        mComponentStatuses.put(name, status);
    }

    public static java.util.Map<String, String> getComponentStatuses() {
        return mComponentStatuses;
    }

    public static class MemoryStats {
        public long javaUsed;
        public long nativeUsed;
        public long total;

        @Override
        public String toString() {
            return String.format(Locale.US, "Total: %dMB (Java: %dMB, Native: %dMB)",
                    total / MB, javaUsed / MB, nativeUsed / MB);
        }
    }

    public static MemoryStats getCurrentMemStats() {
        MemoryStats stats = new MemoryStats();

        // Java Heap
        long javaTotal = Runtime.getRuntime().totalMemory();
        long javaFree = Runtime.getRuntime().freeMemory();
        stats.javaUsed = javaTotal - javaFree;

        // Native Heap (Bitmaps, etc.)
        stats.nativeUsed = Debug.getNativeHeapAllocatedSize();

        stats.total = stats.javaUsed + stats.nativeUsed;
        return stats;
    }

    public static void logMemory(String context) {
        MemoryStats stats = getCurrentMemStats();
        Log.i(TAG, String.format("[%s] %s", context, stats.toString()));
    }
}
