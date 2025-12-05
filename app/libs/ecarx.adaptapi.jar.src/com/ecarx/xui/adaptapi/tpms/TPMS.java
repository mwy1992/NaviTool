/*    */ package com.ecarx.xui.adaptapi.tpms;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
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
/*    */ 
/*    */ 
/*    */ public abstract class TPMS
/*    */   extends AdaptAPI
/*    */ {
/*    */   @Deprecated
/*    */   public static final int MODE_DTPMS = 1;
/*    */   public static final int MODE_ITPMS = 0;
/*    */   @Deprecated
/*    */   public static final int TIRE_ID_ALL = 0;
/*    */   @Deprecated
/*    */   public static final int TIRE_ID_LEFT_FRONT = 1;
/*    */   @Deprecated
/*    */   public static final int TIRE_ID_LEFT_REAR = 2;
/*    */   @Deprecated
/*    */   public static final int TIRE_ID_RIGHT_FRONT = 3;
/*    */   @Deprecated
/*    */   public static final int TIRE_ID_RIGHT_REAR = 4;
/*    */   @Deprecated
/*    */   public static final String XUI_INTENT_ACTION_TPMS_WARNING = "xui.intent.action.TPMS_WARNING";
/*    */   @Deprecated
/*    */   public static final String XUI_INTENT_EXTRA_TPMS_WARNING_TIRE = "xui.intent.extra.TPMS_WARNING_TIRE";
/*    */   
/*    */   public static TPMS create(Context paramContext) {
/* 92 */     return TPMSImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract ICalibrator getTireCalibrator();
/*    */   
/*    */   @Deprecated
/*    */   public abstract ITireState getTireState(int paramInt);
/*    */   
/*    */   public abstract FunctionStatus isTirePressureCalibrationSupported(int paramInt);
/*    */   
/*    */   @Deprecated
/*    */   public abstract boolean registerTireStateMonitor(ITireStateMonitor paramITireStateMonitor);
/*    */   
/*    */   @Deprecated
/*    */   public abstract boolean unregisterTireStateMonitor(ITireStateMonitor paramITireStateMonitor);
/*    */   
/*    */   @Deprecated
/*    */   public static interface ITireStateMonitor {
/*    */     void onTireStateChanged(int param1Int, ITireState param1ITireState);
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface TireId {}
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface TpmsMode {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tpms\TPMS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */