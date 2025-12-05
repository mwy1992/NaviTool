/*    */ package com.ecarx.xui.adaptapi.oncall;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.NonNull;
/*    */ import com.ecarx.xui.adaptapi.Nullable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class OnCall
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static final String ACTION_ONCALL_STARTED = "ecarx.xui.intent.action.ONCALL_STARTED";
/*    */   public static final String ACTION_ONCALL_UNSUBSCRIBED = "ecarx.xui.intent.action.ONCALL_UNSUBSCRIBED";
/*    */   public static final String EXTRA_ONCALL_TYPE = "ecarx.xui.intent.extra.ONCALL_TYPE";
/*    */   
/*    */   @NonNull
/*    */   public static OnCall create(Context paramContext) {
/* 66 */     return OnCallImpl.create(paramContext);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public abstract Call getCurrentCall();
/*    */   
/*    */   public abstract int getECallCallbackRemainedTime();
/*    */   
/*    */   public abstract int getETARescue();
/*    */   
/*    */   public abstract FunctionStatus isOnCallSupported(int paramInt);
/*    */   
/*    */   public abstract void registerCallListener(ICallListener paramICallListener);
/*    */   
/*    */   public abstract void startCall(int paramInt);
/*    */   
/*    */   public abstract void unregisterCallListener(ICallListener paramICallListener);
/*    */   
/*    */   public static interface ICallListener {
/*    */     void onCallCreate(Call param1Call);
/*    */     
/*    */     void onCallStatusChanged(int param1Int1, int param1Int2);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\oncall\OnCall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */