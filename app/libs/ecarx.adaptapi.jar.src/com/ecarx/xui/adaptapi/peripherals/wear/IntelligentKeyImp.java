/*    */ package com.ecarx.xui.adaptapi.peripherals.wear;
/*    */ 
/*    */ import android.content.Context;
/*    */ import java.util.concurrent.CopyOnWriteArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IntelligentKeyImp
/*    */   implements IIntelligentKey
/*    */ {
/*    */   private final Context mContext;
/*    */   private final CopyOnWriteArrayList<IIntelligentKey.IIntelligentKeyConnectionStateCallback> mStateCallbacks;
/*    */   
/*    */   public IntelligentKeyImp(Context paramContext) {
/* 17 */     this.mContext = paramContext;
/* 18 */     this.mStateCallbacks = new CopyOnWriteArrayList<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getConnectionState() {
/* 29 */     return 0;
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
/*    */   public void registerIntelligentKeyConnectionStateCallback(IIntelligentKey.IIntelligentKeyConnectionStateCallback paramIIntelligentKeyConnectionStateCallback) {
/* 41 */     if (!this.mStateCallbacks.contains(this.mStateCallbacks)) {
/* 42 */       this.mStateCallbacks.add(paramIIntelligentKeyConnectionStateCallback);
/*    */     }
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
/*    */   public void unRegisterIntelligentKeyConnectionStateCallback(IIntelligentKey.IIntelligentKeyConnectionStateCallback paramIIntelligentKeyConnectionStateCallback) {
/* 55 */     this.mStateCallbacks.remove(paramIIntelligentKeyConnectionStateCallback);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\peripherals\wear\IntelligentKeyImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */