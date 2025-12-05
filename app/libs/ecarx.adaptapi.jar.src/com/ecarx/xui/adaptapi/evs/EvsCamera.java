/*    */ package com.ecarx.xui.adaptapi.evs;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.view.SurfaceHolder;
/*    */ 
/*    */ public class EvsCamera
/*    */   implements IEvsCamera {
/*    */   private Context mContext;
/*    */   
/*    */   public EvsCamera(Context paramContext) {
/* 11 */     this.mContext = paramContext;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean setPreviewDisplay(SurfaceHolder paramSurfaceHolder) {
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean open(int paramInt) {
/* 33 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean startPreview() {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean stopPreview() {
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean release() {
/* 63 */     return false;
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
/*    */   public boolean doTouchDown(int paramInt1, int paramInt2) {
/* 75 */     return false;
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
/*    */   public boolean doTouchMove(int paramInt1, int paramInt2) {
/* 87 */     return false;
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
/*    */   public boolean doTouchUp(int paramInt1, int paramInt2) {
/* 99 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\evs\EvsCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */