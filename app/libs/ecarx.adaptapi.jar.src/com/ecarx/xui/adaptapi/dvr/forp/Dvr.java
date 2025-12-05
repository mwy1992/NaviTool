/*    */ package com.ecarx.xui.adaptapi.dvr.forp;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.dvr.ota.IOta;
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
/*    */ public abstract class Dvr
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static Dvr create(Context paramContext) {
/* 30 */     return DvrForPImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract IDvrFunction getDvrFunction();
/*    */   
/*    */   public abstract IDvrInfo getDvrInfos();
/*    */   
/*    */   public abstract IDvrManager getDvrManager();
/*    */   
/*    */   public abstract IOta getOta();
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\Dvr.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */