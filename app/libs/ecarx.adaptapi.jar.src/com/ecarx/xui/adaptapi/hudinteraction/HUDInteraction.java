/*    */ package com.ecarx.xui.adaptapi.hudinteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*    */ import java.lang.annotation.Documented;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "ALL", requirement = "XQ2020081841652")
/*    */ public abstract class HUDInteraction
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int HUD_MODE_AR_DISPLAY = 4;
/*    */   public static final int HUD_MODE_SIMPLE_DISPLAY = 1;
/*    */   public static final int HUD_MODE_SMART_DRIVING_DISPLAY = 2;
/*    */   public static final int HUD_MODE_SMART_GUIDE_DISPLAY = 3;
/*    */   public static final int TI_GAP_SET_FOR_LGT_CTRL_NONE = 0;
/*    */   public static final int TI_GAP_SET_FOR_LGT_CTRL_TIME_GAP_1 = 1;
/*    */   public static final int TI_GAP_SET_FOR_LGT_CTRL_TIME_GAP_2 = 2;
/*    */   public static final int TI_GAP_SET_FOR_LGT_CTRL_TIME_GAP_3 = 3;
/*    */   
/*    */   public static HUDInteraction create(Context paramContext) {
/* 29 */     return HUDInteractionImpl.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract HUDCalibrationParam getHUDCalibrationParam();
/*    */   
/*    */   public abstract boolean registerCallback(IInteractionCallback paramIInteractionCallback);
/*    */   
/*    */   public abstract int requestADASOpenStatus();
/*    */   
/*    */   public abstract void requestADASSyncInfo();
/*    */   
/*    */   public abstract int requestCalibrationMode();
/*    */   
/*    */   public abstract int requestCarFollowingGAPLevel();
/*    */   
/*    */   public abstract void requestHUDHeight();
/*    */   
/*    */   public abstract int requestHUDMode();
/*    */   
/*    */   public abstract void requestVehicleSyncInfo();
/*    */   
/*    */   public abstract boolean unregisterCallback(IInteractionCallback paramIInteractionCallback);
/*    */   
/*    */   @Documented
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface HUDMode {}
/*    */   
/*    */   public static interface IInteractionCallback {
/*    */     void onADASLaneAidSyncInfo(IADASLaneSyncInfo param1IADASLaneSyncInfo, IADASDrivingAidSyncInfo param1IADASDrivingAidSyncInfo);
/*    */     
/*    */     void onADASOpenStatusChanged(int param1Int);
/*    */     
/*    */     void onCalibrationMode(int param1Int);
/*    */     
/*    */     void onCarFollowingGAPChanged(int param1Int);
/*    */     
/*    */     void onHUDHeightChanged(int param1Int);
/*    */     
/*    */     void onHUDModeChanged(int param1Int);
/*    */     
/*    */     void onVehicleSyncInfo(IVehicleSyncInfo param1IVehicleSyncInfo);
/*    */   }
/*    */   
/*    */   @Documented
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface TiGapSetForLgtCtrl {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\HUDInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */