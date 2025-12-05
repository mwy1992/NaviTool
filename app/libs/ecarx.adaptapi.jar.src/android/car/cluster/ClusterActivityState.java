/*    */ package android.car.cluster;
/*    */ 
/*    */ import android.graphics.Rect;
/*    */ import android.os.Bundle;
/*    */ import android.os.Parcelable;
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
/*    */ public class ClusterActivityState
/*    */ {
/*    */   private static final String KEY_EXTRAS = "android.car:activityState.extras";
/*    */   private static final String KEY_UNOBSCURED_BOUNDS = "android.car:activityState.unobscured";
/*    */   private static final String KEY_VISIBLE = "android.car:activityState.visible";
/*    */   private Bundle mExtras;
/*    */   private Rect mUnobscuredBounds;
/*    */   private boolean mVisible = true;
/*    */   
/*    */   public boolean isVisible() {
/* 38 */     return this.mVisible;
/*    */   }
/*    */   
/*    */   public Rect getUnobscuredBounds() {
/* 42 */     return this.mUnobscuredBounds;
/*    */   }
/*    */   
/*    */   public ClusterActivityState setVisible(boolean paramBoolean) {
/* 46 */     this.mVisible = paramBoolean;
/* 47 */     return this;
/*    */   }
/*    */   
/*    */   public ClusterActivityState setUnobscuredBounds(Rect paramRect) {
/* 51 */     this.mUnobscuredBounds = paramRect;
/* 52 */     return this;
/*    */   }
/*    */   
/*    */   public ClusterActivityState setExtras(Bundle paramBundle) {
/* 56 */     this.mExtras = paramBundle;
/* 57 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ClusterActivityState create(boolean paramBoolean, Rect paramRect) {
/* 64 */     ClusterActivityState clusterActivityState = new ClusterActivityState();
/* 65 */     clusterActivityState = clusterActivityState.setVisible(paramBoolean);
/* 66 */     return clusterActivityState.setUnobscuredBounds(paramRect);
/*    */   }
/*    */   
/*    */   public static ClusterActivityState fromBundle(Bundle paramBundle) {
/* 70 */     ClusterActivityState clusterActivityState = new ClusterActivityState();
/* 71 */     clusterActivityState = clusterActivityState.setVisible(paramBundle.getBoolean("android.car:activityState.visible", true));
/* 72 */     clusterActivityState = clusterActivityState.setUnobscuredBounds((Rect)paramBundle.getParcelable("android.car:activityState.unobscured"));
/* 73 */     return clusterActivityState.setExtras(paramBundle.getBundle("android.car:activityState.extras"));
/*    */   }
/*    */   
/*    */   public Bundle toBundle() {
/* 77 */     Bundle bundle = new Bundle();
/* 78 */     bundle.putBoolean("android.car:activityState.visible", this.mVisible);
/* 79 */     bundle.putParcelable("android.car:activityState.unobscured", (Parcelable)this.mUnobscuredBounds);
/* 80 */     bundle.putBundle("android.car:activityState.extras", this.mExtras);
/* 81 */     return bundle;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(getClass().getSimpleName()); stringBuilder.append(" {visible: "); stringBuilder.append(this.mVisible); stringBuilder.append(", unobscuredBounds: "); stringBuilder.append(this.mUnobscuredBounds); stringBuilder.append(" }"); return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\ClusterActivityState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */