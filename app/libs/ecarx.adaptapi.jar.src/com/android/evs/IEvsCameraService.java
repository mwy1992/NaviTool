/*     */ package com.android.evs;public interface IEvsCameraService extends IInterface { public static final String SERVICE_NAME = "EvsCameraService";
/*     */   void registerEvsCameraServiceCallback(IEvsCameraServiceCallback paramIEvsCameraServiceCallback) throws RemoteException;
/*     */   void setAPAPropertyOn() throws RemoteException;
/*     */   void setAVMPropertyOn() throws RemoteException;
/*     */   
/*     */   void setAVPPropertyOn() throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IEvsCameraService { private static final String DESCRIPTOR = "com.android.evs.IEvsCameraService";
/*     */     static final int TRANSACTION_registerEvsCameraServiceCallback = 1;
/*     */     static final int TRANSACTION_setAPAPropertyOn = 3;
/*     */     static final int TRANSACTION_setAVMPropertyOn = 2;
/*     */     static final int TRANSACTION_setAVPPropertyOn = 4;
/*     */     
/*     */     public Stub() {
/*  15 */       attachInterface(this, "com.android.evs.IEvsCameraService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IEvsCameraService asInterface(IBinder param1IBinder) {
/*  23 */       if (param1IBinder == null) {
/*  24 */         return null;
/*     */       }
/*  26 */       IInterface iInterface = param1IBinder.queryLocalInterface("com.android.evs.IEvsCameraService");
/*  27 */       if (iInterface != null && iInterface instanceof IEvsCameraService) {
/*  28 */         return (IEvsCameraService)iInterface;
/*     */       }
/*  30 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  34 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  39 */       if (param1Int1 != 1598968902) { switch (param1Int1)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/*  74 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("com.android.evs.IEvsCameraService"); setAVPPropertyOn(); return true;
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("com.android.evs.IEvsCameraService"); setAPAPropertyOn(); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("com.android.evs.IEvsCameraService"); setAVMPropertyOn(); return true;
/*     */           case 1:
/*     */             break; }  param1Parcel1.enforceInterface("com.android.evs.IEvsCameraService"); IEvsCameraServiceCallback iEvsCameraServiceCallback = IEvsCameraServiceCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); registerEvsCameraServiceCallback(iEvsCameraServiceCallback); return true; }
/*  83 */        param1Parcel2.writeString("com.android.evs.IEvsCameraService"); return true; } private static class Proxy implements IEvsCameraService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  87 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  91 */         return "com.android.evs.IEvsCameraService";
/*     */       }
/*     */       
/*     */       public void registerEvsCameraServiceCallback(IEvsCameraServiceCallback param2IEvsCameraServiceCallback) throws RemoteException {
/*  95 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/*  97 */           parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/*  98 */           if (param2IEvsCameraServiceCallback != null) { IBinder iBinder = param2IEvsCameraServiceCallback.asBinder(); } else { param2IEvsCameraServiceCallback = null; }  parcel.writeStrongBinder((IBinder)param2IEvsCameraServiceCallback);
/*  99 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 102 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void setAVMPropertyOn() throws RemoteException {
/* 107 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 109 */           parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/* 110 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 113 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void setAPAPropertyOn() throws RemoteException {
/* 118 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 120 */           parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/* 121 */           this.mRemote.transact(3, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 124 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void setAVPPropertyOn() throws RemoteException {
/* 129 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 131 */         try { parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/* 132 */           this.mRemote.transact(4, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 135 */         { parcel.recycle(); }  } } } private static class Proxy implements IEvsCameraService { private IBinder mRemote; public void setAVPPropertyOn() throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("com.android.evs.IEvsCameraService"); this.mRemote.transact(4, parcel, null, 1); return; } finally { parcel.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     Proxy(IBinder param1IBinder) {
/*     */       this.mRemote = param1IBinder;
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*     */       return this.mRemote;
/*     */     }
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "com.android.evs.IEvsCameraService";
/*     */     }
/*     */     
/*     */     public void registerEvsCameraServiceCallback(IEvsCameraServiceCallback param1IEvsCameraServiceCallback) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/*     */         if (param1IEvsCameraServiceCallback != null) {
/*     */           IBinder iBinder = param1IEvsCameraServiceCallback.asBinder();
/*     */         } else {
/*     */           param1IEvsCameraServiceCallback = null;
/*     */         } 
/*     */         parcel.writeStrongBinder((IBinder)param1IEvsCameraServiceCallback);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setAVMPropertyOn() throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/*     */         this.mRemote.transact(2, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setAPAPropertyOn() throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("com.android.evs.IEvsCameraService");
/*     */         this.mRemote.transact(3, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\evs\IEvsCameraService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */