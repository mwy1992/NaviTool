/*    */ package com.ecarx.xui.adaptapi.device.log;
/*    */ 
/*    */ import android.content.Context;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeviceLog
/*    */   implements IDeviceLog
/*    */ {
/*    */   public static final String LOG_ANR = "/data/anr";
/*    */   public static final String LOG_BLUETOOTH = "/data/misc/bluetooth/logs";
/*    */   public static final String LOG_DLT = "/mnt/userdata/DLT";
/*    */   public static final String LOG_DROPBOX = "/data/system/dropbox";
/*    */   public static final String LOG_KERNEL = "/data/kernellog";
/*    */   public static final String LOG_LOGCAT = "/data/log";
/*    */   public static final String LOG_NET = "/data/tcpdump";
/*    */   public static final String LOG_RECOVERY = "/cache/recovery";
/*    */   public static final String LOG_TOP = "/data/log";
/*    */   public static final String TAG = "DevicesLogImpl";
/*    */   private Context mContext;
/* 25 */   private HashMap<String, String[]> mLogPathsMap = (HashMap)new HashMap<>();
/*    */ 
/*    */   
/*    */   public DeviceLog(Context paramContext) {
/* 29 */     this.mContext = paramContext;
/*    */     
/* 31 */     this.mLogPathsMap.put(String.valueOf(1), new String[] { "/data/log" });
/* 32 */     this.mLogPathsMap.put(String.valueOf(2), new String[] { "/data/kernellog", "/mnt/userdata/DLT" });
/* 33 */     this.mLogPathsMap.put(String.valueOf(3), new String[] { "/data/log" });
/* 34 */     this.mLogPathsMap.put(String.valueOf(4), new String[0]);
/* 35 */     this.mLogPathsMap.put(String.valueOf(5), new String[] { "/data/tcpdump", "/data/misc/bluetooth/logs" });
/* 36 */     this.mLogPathsMap.put(String.valueOf(6), new String[] { "/data/log" });
/* 37 */     this.mLogPathsMap.put(String.valueOf(7), new String[] { "/data/anr" });
/* 38 */     this.mLogPathsMap.put(String.valueOf(8), new String[] { "/data/system/dropbox" });
/* 39 */     this.mLogPathsMap.put(String.valueOf(9), new String[] { "/data/system/dropbox" });
/* 40 */     this.mLogPathsMap.put(String.valueOf(16), new String[] { "/data/log" });
/* 41 */     this.mLogPathsMap.put(String.valueOf(17), new String[0]);
/* 42 */     this.mLogPathsMap.put(String.valueOf(18), new String[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getLogRootFolders() {
/* 53 */     return new String[] { "/data/kernellog", "/mnt/userdata/DLT", "/data/tcpdump", "/data/log", "/data/anr", "/data/misc/bluetooth/logs", "/data/system/dropbox", "/cache/recovery" };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getLogRootFolders(int paramInt) {
/* 66 */     if (paramInt == 0) {
/* 67 */       return getLogRootFolders();
/*    */     }
/* 69 */     return this.mLogPathsMap.get(String.valueOf(paramInt));
/*    */   }
/*    */   
/*    */   public void setLogcatLogLevel(int[] paramArrayOfint) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\log\DeviceLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */