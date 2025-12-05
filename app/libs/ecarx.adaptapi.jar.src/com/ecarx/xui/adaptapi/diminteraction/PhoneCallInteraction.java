/*    */ package com.ecarx.xui.adaptapi.diminteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ 
/*    */ 
/*    */ public class PhoneCallInteraction
/*    */   extends AbsCarSignal
/*    */   implements IPhoneCallInteraction
/*    */ {
/*    */   private static final String TAG = "PhoneCallInteraction";
/*    */   
/*    */   protected PhoneCallInteraction(Context paramContext) {
/* 14 */     super(paramContext);
/*    */   }
/*    */   
/*    */   public void updateCallInfo(IPhoneCallInteraction.ICallInfo paramICallInfo) {}
/*    */   
/*    */   public void updateConnectedMobileDeviceState(String paramString, int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void writeContact2DBCompleted() {}
/*    */   
/*    */   public void writeCallLog2DBCompleted() {}
/*    */   
/*    */   public void registerPhoneCallback(IPhoneCallInteraction.IPhoneCallInteractionCallback paramIPhoneCallInteractionCallback) {}
/*    */   
/*    */   public void unRegisterPhoneCallback(IPhoneCallInteraction.IPhoneCallInteractionCallback paramIPhoneCallInteractionCallback) {}
/*    */   
/*    */   public void updateSecondCallInfo(IPhoneCallInteraction.ICallInfo paramICallInfo) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\PhoneCallInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */