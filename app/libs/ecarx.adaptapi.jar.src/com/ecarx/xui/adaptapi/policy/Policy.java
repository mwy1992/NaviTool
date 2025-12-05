/*    */ package com.ecarx.xui.adaptapi.policy;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
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
/*    */ public abstract class Policy
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static Policy create(Context paramContext) {
/* 29 */     return PolicyImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract IAudioAttributes getAudioAttributes();
/*    */   
/*    */   @Deprecated
/*    */   public abstract IAudioPolicy getAudioPolicy();
/*    */   
/*    */   public abstract IStoragePolicy getStoragePolicy();
/*    */   
/*    */   public abstract IVoiceAssistantPolicy getVoiceAssistantPolicy();
/*    */   
/*    */   public abstract IWindowManagerPolicy getWindowManagerPolicy();
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\Policy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */