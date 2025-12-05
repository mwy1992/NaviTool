/*    */ package com.ecarx.xui.adaptapi.wpc;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public abstract class WPC
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int CHARGING_STATUS_CHARGING = 2;
/*    */   public static final int CHARGING_STATUS_ERROR = 5;
/*    */   public static final int CHARGING_STATUS_FOD = 9;
/*    */   public static final int CHARGING_STATUS_FULLY_CHARGED = 3;
/*    */   public static final int CHARGING_STATUS_INTERRUPT_PEPS = 10;
/*    */   public static final int CHARGING_STATUS_NO_DEVICE = 1;
/*    */   public static final int CHARGING_STATUS_OFF = -2147483647;
/*    */   public static final int CHARGING_STATUS_OVERHEAT_OR_FOD = 4;
/*    */   public static final int CHARGING_STATUS_OVERHEAT_PROTECTED = 8;
/*    */   public static final int CHARGING_STATUS_STANDBY = 7;
/*    */   public static final int CHARGING_STATUS_TAKE_MOBILE_DEVICE = 6;
/*    */   public static final int WORKING_MODE_AUTO = 2;
/*    */   public static final int WORKING_MODE_NONE = 0;
/*    */   public static final int WORKING_MODE_OFF = 1;
/*    */   
/*    */   public static WPC create(Context paramContext) {
/* 34 */     return WPCImp.create(paramContext);
/*    */   }
/*    */   
/*    */   @ChargingStatus
/*    */   public abstract int getChargingStatus();
/*    */   
/*    */   @WorkingMode
/*    */   public abstract int getWorkingMode();
/*    */   
/*    */   public abstract FunctionStatus isWPCSupported();
/*    */   
/*    */   public abstract void setStateListener(StateListener paramStateListener);
/*    */   
/*    */   public abstract int setWorkingMode(@WorkingMode int paramInt);
/*    */   
/*    */   public abstract void unsetStateListener(StateListener paramStateListener);
/*    */   
/*    */   static @interface ChargingStatus {}
/*    */   
/*    */   public static interface StateListener {
/*    */     void onChargingStatus(@ChargingStatus int param1Int);
/*    */     
/*    */     void onWorkingMode(@WorkingMode int param1Int);
/*    */   }
/*    */   
/*    */   static @interface WorkingMode {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wpc\WPC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */