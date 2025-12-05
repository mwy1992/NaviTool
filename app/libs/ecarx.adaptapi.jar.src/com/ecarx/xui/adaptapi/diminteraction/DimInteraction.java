/*    */ package com.ecarx.xui.adaptapi.diminteraction;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DimInteraction
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final int APP_TYPE_AMAP = 1;
/*    */   public static final int APP_TYPE_DEFAULT = 0;
/*    */   public static final int PARAMS_TYPE_FLT = 1;
/*    */   public static final int PARAMS_TYPE_INT = 0;
/*    */   public static final int PARAMS_TYPE_STR = 2;
/*    */   public static final int SHOW_PRESENTATION_ALWAYS = 2;
/*    */   public static final int SHOW_PRESENTATION_NAVI_ROUTE = 1;
/*    */   public static final int SHOW_PRESENTATION_NEVER = 3;
/*    */   
/*    */   public static DimInteraction create(Context paramContext) {
/* 35 */     return new DIMInteractionImpl(paramContext);
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public abstract IClimateInteraction getClimateInteraction();
/*    */   
/*    */   public abstract IContactsInteraction getContactsInteraction();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2020-07-24", project = "ALL", requirement = "XQ2020072339282")
/*    */   public abstract IDimMenuInteraction getDimMenuInteraction();
/*    */   
/*    */   public abstract IMediaInteraction getMediaInteraction();
/*    */   
/*    */   public abstract INaviInteraction getNaviInteraction();
/*    */   
/*    */   public abstract IPhoneCallInteraction getPhoneCallInteraction();
/*    */   
/*    */   public abstract int getShowPresentationOption();
/*    */   
/*    */   public abstract int getSupportedRankingType();
/*    */   
/*    */   public abstract IVendorInteraction getVendorInteraction();
/*    */   
/*    */   public abstract IVrInteraction getVrInteraction();
/*    */   
/*    */   public abstract void registerInteractionCallback(IInteractionCallback paramIInteractionCallback);
/*    */   
/*    */   public abstract void setPresentationToDimSwitch(int paramInt, String paramString1, String paramString2, boolean paramBoolean);
/*    */   
/*    */   public abstract void unregisterInteractionCallback(IInteractionCallback paramIInteractionCallback);
/*    */   
/*    */   public abstract void updateAvgFuleRanking(int paramInt, String paramString);
/*    */   
/*    */   @Documented
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface AppType {}
/*    */   
/*    */   public static interface IInteractionCallback {
/*    */     void onShowPresentationOptionChanged(int param1Int);
/*    */   }
/*    */   
/*    */   @Documented
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface ParamsType {}
/*    */   
/*    */   @Documented
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface ShowPresentationOption {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\DimInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */