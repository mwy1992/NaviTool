/*    */ package com.ecarx.xui.adaptapi.lighting;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.lightshow.LightShowImpl;
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
/*    */ public class LightingShow
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static ILightingShow create(Context paramContext) {
/* 31 */     return (ILightingShow)LightShowImpl.create(paramContext);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\lighting\LightingShow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */