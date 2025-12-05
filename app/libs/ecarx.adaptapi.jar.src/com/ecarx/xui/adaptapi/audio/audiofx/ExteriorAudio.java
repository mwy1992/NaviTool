/*    */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*    */ 
/*    */ import android.content.Context;
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
/*    */ public abstract class ExteriorAudio
/*    */ {
/*    */   public static ExteriorAudio create(Context paramContext) {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public abstract int getStreamMaxVolume(int paramInt);
/*    */   
/*    */   public abstract int getStreamVolume(int paramInt);
/*    */   
/*    */   public abstract void setStreamVolume(int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   public abstract boolean speakerStatus(int paramInt);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\ExteriorAudio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */