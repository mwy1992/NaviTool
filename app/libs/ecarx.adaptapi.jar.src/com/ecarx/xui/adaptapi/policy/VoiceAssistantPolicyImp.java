/*    */ package com.ecarx.xui.adaptapi.policy;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
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
/*    */ public class VoiceAssistantPolicyImp
/*    */   implements IVoiceAssistantPolicy
/*    */ {
/*    */   public VoiceAssistantPolicyImp(Context paramContext) {}
/*    */   
/*    */   public int setWorkMode(int paramInt) {
/* 21 */     if (ProperUtils.setPropertyValue("IVoiceAssistantPolicy_WorkMode", Integer.valueOf(paramInt))) {
/* 22 */       return 0;
/*    */     }
/* 24 */     return -1;
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
/*    */   
/*    */   public int getTTSPCMVolume() {
/* 37 */     return ((Integer)ProperUtils.getPropertyValue("IVoiceAssistantPolicy_TTSPCMVolume", int.class)).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getWakeID() {
/* 46 */     return 12;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\VoiceAssistantPolicyImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */