/*    */ package com.android.evs;
/*    */ 
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface IEvsCameraServiceCallback extends IInterface {
/*    */   void updateAVMState(int paramInt) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements IEvsCameraServiceCallback { private static final String DESCRIPTOR = "com.android.evs.IEvsCameraServiceCallback";
/*    */     static final int TRANSACTION_updateAVMState = 1;
/*    */     
/*    */     public Stub() {
/* 15 */       attachInterface(this, "com.android.evs.IEvsCameraServiceCallback");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static IEvsCameraServiceCallback asInterface(IBinder param1IBinder) {
/* 23 */       if (param1IBinder == null) {
/* 24 */         return null;
/*    */       }
/* 26 */       IInterface iInterface = param1IBinder.queryLocalInterface("com.android.evs.IEvsCameraServiceCallback");
/* 27 */       if (iInterface != null && iInterface instanceof IEvsCameraServiceCallback) {
/* 28 */         return (IEvsCameraServiceCallback)iInterface;
/*    */       }
/* 30 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 34 */       return (IBinder)this;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/* 39 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
/*    */         {
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
/* 56 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("com.android.evs.IEvsCameraServiceCallback");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("com.android.evs.IEvsCameraServiceCallback");
/*    */       param1Int1 = param1Parcel1.readInt();
/*    */       updateAVMState(param1Int1);
/*    */       return true;
/*    */     } private static class Proxy implements IEvsCameraServiceCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 65 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 69 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 73 */         return "com.android.evs.IEvsCameraServiceCallback";
/*    */       }
/*    */       
/*    */       public void updateAVMState(int param2Int) throws RemoteException {
/* 77 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 79 */         try { parcel.writeInterfaceToken("com.android.evs.IEvsCameraServiceCallback");
/* 80 */           parcel.writeInt(param2Int);
/* 81 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 84 */         { parcel.recycle(); }  } } } private static class Proxy implements IEvsCameraServiceCallback { public void updateAVMState(int param1Int) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("com.android.evs.IEvsCameraServiceCallback"); parcel.writeInt(param1Int); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
/*    */        }
/*    */ 
/*    */     
/*    */     private IBinder mRemote;
/*    */     
/*    */     Proxy(IBinder param1IBinder) {
/*    */       this.mRemote = param1IBinder;
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/*    */       return this.mRemote;
/*    */     }
/*    */     
/*    */     public String getInterfaceDescriptor() {
/*    */       return "com.android.evs.IEvsCameraServiceCallback";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\evs\IEvsCameraServiceCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */