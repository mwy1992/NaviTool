/*    */ package com.ecarx.xui.adaptapi.evs;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
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
/*    */ public abstract class EVS
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int EVS_CAMERA_AVM = 2;
/*    */   public static final int EVS_CAMERA_DVR = 3;
/*    */   public static final int EVS_CAMERA_REAR = 1;
/*    */   
/*    */   public static EVS create(Context paramContext) {
/* 59 */     return EVSImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract boolean attachEvsCameraStatusObserver(IEvsCameraStatusObserver paramIEvsCameraStatusObserver);
/*    */   
/*    */   public abstract boolean detachEvsCameraStatusObserver(IEvsCameraStatusObserver paramIEvsCameraStatusObserver);
/*    */   
/*    */   public abstract boolean evsCameraCloseNotify(int paramInt);
/*    */   
/*    */   @Deprecated
/*    */   public abstract IEvsCamera getEvsCamera();
/*    */   
/*    */   public abstract boolean isCameraOpened(int paramInt);
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface EvsCameraId {}
/*    */   
/*    */   public static interface IEvsCameraStatusObserver {
/*    */     void onEvsCameraClosed(int param1Int);
/*    */     
/*    */     void onEvsCameraOpened(int param1Int);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\evs\EVS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */