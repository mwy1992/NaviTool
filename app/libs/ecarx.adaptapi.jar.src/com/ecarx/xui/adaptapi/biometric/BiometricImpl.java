/*    */ package com.ecarx.xui.adaptapi.biometric;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*    */ import com.ecarx.xui.adaptapi.biometric.face.IFaceManager;
/*    */ import com.ecarx.xui.adaptapi.car.Car;
/*    */ import com.ecarx.xui.adaptapi.car.ICar;
/*    */ 
/*    */ 
/*    */ public class BiometricImpl
/*    */   implements IBiometric, IConnectable
/*    */ {
/*    */   private IFaceManager mFaceManager;
/*    */   private final ICar mICar;
/*    */   
/*    */   public BiometricImpl(Context paramContext) {
/* 17 */     this.mICar = Car.create(paramContext.getApplicationContext());
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
/*    */   public IFaceManager getFaceManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield mFaceManager : Lcom/ecarx/xui/adaptapi/biometric/face/IFaceManager;
/*    */     //   4: ifnonnull -> 48
/*    */     //   7: aload_0
/*    */     //   8: monitorenter
/*    */     //   9: aload_0
/*    */     //   10: getfield mFaceManager : Lcom/ecarx/xui/adaptapi/biometric/face/IFaceManager;
/*    */     //   13: ifnonnull -> 38
/*    */     //   16: new com/ecarx/xui/adaptapi/biometric/face/FaceManagerImpl
/*    */     //   19: astore_1
/*    */     //   20: aload_1
/*    */     //   21: aload_0
/*    */     //   22: getfield mICar : Lcom/ecarx/xui/adaptapi/car/ICar;
/*    */     //   25: invokeinterface getUserProfileManager : ()Lcom/ecarx/xui/adaptapi/car/userprofile/IUserProfile;
/*    */     //   30: invokespecial <init> : (Lcom/ecarx/xui/adaptapi/car/userprofile/IUserProfile;)V
/*    */     //   33: aload_0
/*    */     //   34: aload_1
/*    */     //   35: putfield mFaceManager : Lcom/ecarx/xui/adaptapi/biometric/face/IFaceManager;
/*    */     //   38: aload_0
/*    */     //   39: monitorexit
/*    */     //   40: goto -> 48
/*    */     //   43: astore_1
/*    */     //   44: aload_0
/*    */     //   45: monitorexit
/*    */     //   46: aload_1
/*    */     //   47: athrow
/*    */     //   48: aload_0
/*    */     //   49: getfield mFaceManager : Lcom/ecarx/xui/adaptapi/biometric/face/IFaceManager;
/*    */     //   52: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #25	-> 0
/*    */     //   #26	-> 7
/*    */     //   #27	-> 9
/*    */     //   #28	-> 16
/*    */     //   #30	-> 38
/*    */     //   #32	-> 48
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   9	16	43	finally
/*    */     //   16	38	43	finally
/*    */     //   38	40	43	finally
/*    */     //   44	46	43	finally
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
/*    */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 42 */     if (this.mICar != null && this.mICar instanceof IConnectable) {
/* 43 */       ((IConnectable)this.mICar).registerConnectWatcher(paramIConnectWatcher);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void unregisterConnectWatcher() {
/* 52 */     if (this.mICar != null && this.mICar instanceof IConnectable)
/* 53 */       ((IConnectable)this.mICar).unregisterConnectWatcher(); 
/*    */   }
/*    */   
/*    */   public void connect() {}
/*    */   
/*    */   public void disconnect() {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\biometric\BiometricImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */