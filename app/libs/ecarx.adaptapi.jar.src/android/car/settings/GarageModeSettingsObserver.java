/*    */ package android.car.settings;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.database.ContentObserver;
/*    */ import android.net.Uri;
/*    */ import android.os.Handler;
/*    */ import android.provider.Settings;
/*    */ import java.lang.ref.WeakReference;
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
/*    */ public abstract class GarageModeSettingsObserver
/*    */   extends ContentObserver
/*    */ {
/* 34 */   public static final Uri GARAGE_MODE_ENABLED_URI = Settings.Global.getUriFor("android.car.GARAGE_MODE_ENABLED");
/*    */   public static final Uri GARAGE_MODE_MAINTENANCE_WINDOW_URI;
/* 36 */   public static final Uri GARAGE_MODE_WAKE_UP_TIME_URI = Settings.Global.getUriFor("android.car.GARAGE_MODE_WAKE_UP_TIME");
/*    */   static {
/* 38 */     GARAGE_MODE_MAINTENANCE_WINDOW_URI = Settings.Global.getUriFor("android.car.GARAGE_MODE_MAINTENANCE_WINDOW");
/*    */     
/* 40 */     GARAGE_SETTING_URIS = new Uri[] { GARAGE_MODE_ENABLED_URI, GARAGE_MODE_WAKE_UP_TIME_URI, GARAGE_MODE_MAINTENANCE_WINDOW_URI };
/*    */   }
/*    */   public static final Uri[] GARAGE_SETTING_URIS;
/*    */   private final WeakReference<Context> mContext;
/*    */   
/*    */   public GarageModeSettingsObserver(Context paramContext, Handler paramHandler) {
/* 46 */     super(paramHandler);
/* 47 */     this.mContext = new WeakReference<>(paramContext);
/*    */   }
/*    */   
/*    */   public void register() {
/* 51 */     if (this.mContext.get() == null) {
/*    */       return;
/*    */     }
/* 54 */     for (Uri uri : GARAGE_SETTING_URIS) {
/* 55 */       ((Context)this.mContext.get()).getContentResolver().registerContentObserver(uri, false, this);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void unregister() {
/* 61 */     if (this.mContext.get() == null) {
/*    */       return;
/*    */     }
/* 64 */     ((Context)this.mContext.get()).getContentResolver().unregisterContentObserver(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\settings\GarageModeSettingsObserver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */