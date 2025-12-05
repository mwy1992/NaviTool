/*    */ package com.ecarx.xui.adaptapi.diminteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ 
/*    */ public class VrInteraction
/*    */   extends AbsCarSignal implements IVrInteraction {
/*    */   private static final String TAG = "VrInteraction";
/*    */   
/*    */   protected VrInteraction(Context paramContext) {
/* 11 */     super(paramContext);
/*    */   }
/*    */   
/*    */   public void notifyVrStatusChanged(int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void notifyVoiceToTextCompleted(String paramString) {}
/*    */   
/*    */   public void notifyVrTTSText(String paramString) {}
/*    */   
/*    */   public void notifyVrSearchStates(int paramInt) {}
/*    */   
/*    */   public void registerVrCallback(IVrInteraction.IVrInteractionCallback paramIVrInteractionCallback) {}
/*    */   
/*    */   public void unRegisterVrCallback(IVrInteraction.IVrInteractionCallback paramIVrInteractionCallback) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\VrInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */