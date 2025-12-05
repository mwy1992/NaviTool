/*     */ package com.ecarx.xui.adaptapi.device.dock;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*     */ import com.ecarx.xui.adaptapi.NonNull;
/*     */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @VendorDefinition(author = "@ECARX", date = "2022-03-26", project = "EF1E")
/*     */ public abstract class Dock
/*     */   extends AdaptAPI
/*     */ {
/*     */   public static final int STATE_CLOSE = 2;
/*     */   public static final int STATE_NONE = 0;
/*     */   public static final int STATE_OPEN = 1;
/*     */   public static final int TYPE_APP_STORE = 8;
/*     */   public static final int TYPE_BUSINESS_CLASS = 1;
/*     */   public static final int TYPE_BUSINESS_TEMPERATURE = 6;
/*     */   public static final int TYPE_CAR_SETTING = 2;
/*     */   public static final int TYPE_COCKPIT_TEMPERATURE = 4;
/*     */   public static final int TYPE_DEFROSTING = 7;
/*     */   public static final int TYPE_HOME = 0;
/*     */   public static final int TYPE_HVAC = 5;
/*     */   public static final int TYPE_HVAC_CIRCULATE = 3;
/*     */   public static final int TYPE_MEDIA = 9;
/*     */   public static final int TYPE_VOLUME = 10;
/*     */   
/*     */   @NonNull
/*     */   public static Dock create(Context paramContext) {
/* 107 */     return null;
/*     */   }
/*     */   
/*     */   public abstract boolean isDockBarShowing();
/*     */   
/*     */   public abstract void notifyDockItemChanged(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract void registerDockListener(IDockListener paramIDockListener);
/*     */   
/*     */   public abstract void switchDockBar(boolean paramBoolean);
/*     */   
/*     */   public abstract void unregisterDockListener(IDockListener paramIDockListener);
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   static @interface ActionType {}
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   static @interface DockType {}
/*     */   
/*     */   public static interface IDockListener {
/*     */     void onDockItemClick(int param1Int);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\dock\Dock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */