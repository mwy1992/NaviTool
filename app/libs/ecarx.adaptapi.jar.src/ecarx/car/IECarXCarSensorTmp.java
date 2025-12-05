/*     */ package ecarx.car;
/*     */ 
/*     */ public interface IECarXCarSensorTmp extends IInterface {
/*     */   float getSensorTmp() throws RemoteException;
/*     */   
/*     */   void registerListener(ISensorTmperListener paramISensorTmperListener) throws RemoteException;
/*     */   
/*     */   void unregisterListener(ISensorTmperListener paramISensorTmperListener) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IECarXCarSensorTmp { private static final String DESCRIPTOR = "ecarx.car.IECarXCarSensorTmp";
/*     */     static final int TRANSACTION_getSensorTmp = 1;
/*     */     static final int TRANSACTION_registerListener = 2;
/*     */     static final int TRANSACTION_unregisterListener = 3;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "ecarx.car.IECarXCarSensorTmp");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IECarXCarSensorTmp asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IECarXCarSensorTmp");
/*  28 */       if (iInterface != null && iInterface instanceof IECarXCarSensorTmp) {
/*  29 */         return (IECarXCarSensorTmp)iInterface;
/*     */       }
/*  31 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  35 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  40 */       if (param1Int1 != 1598968902) { ISensorTmperListener iSensorTmperListener; switch (param1Int1) {
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
/*     */ 
/*     */           
/*     */           default:
/*  75 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IECarXCarSensorTmp"); iSensorTmperListener = ISensorTmperListener.Stub.asInterface(param1Parcel1.readStrongBinder()); unregisterListener(iSensorTmperListener); param1Parcel2.writeNoException(); return true;
/*     */           case 2:
/*     */             iSensorTmperListener.enforceInterface("ecarx.car.IECarXCarSensorTmp"); iSensorTmperListener = ISensorTmperListener.Stub.asInterface(iSensorTmperListener.readStrongBinder()); registerListener(iSensorTmperListener); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  iSensorTmperListener.enforceInterface("ecarx.car.IECarXCarSensorTmp"); float f = getSensorTmp(); param1Parcel2.writeNoException(); param1Parcel2.writeFloat(f); return true; }
/*     */        param1Parcel2.writeString("ecarx.car.IECarXCarSensorTmp");
/*  84 */       return true; } private static class Proxy implements IECarXCarSensorTmp { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  88 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  92 */         return "ecarx.car.IECarXCarSensorTmp";
/*     */       }
/*     */       
/*     */       public float getSensorTmp() throws RemoteException {
/*  96 */         Parcel parcel1 = Parcel.obtain();
/*  97 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 100 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarSensorTmp");
/* 101 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 102 */           parcel2.readException();
/* 103 */           return parcel2.readFloat();
/*     */         } finally {
/*     */           
/* 106 */           parcel2.recycle();
/* 107 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void registerListener(ISensorTmperListener param2ISensorTmperListener) throws RemoteException {
/* 113 */         Parcel parcel1 = Parcel.obtain();
/* 114 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 116 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarSensorTmp");
/* 117 */           if (param2ISensorTmperListener != null) { IBinder iBinder = param2ISensorTmperListener.asBinder(); } else { param2ISensorTmperListener = null; }  parcel1.writeStrongBinder((IBinder)param2ISensorTmperListener);
/* 118 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 119 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 122 */           parcel2.recycle();
/* 123 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterListener(ISensorTmperListener param2ISensorTmperListener) throws RemoteException {
/* 128 */         Parcel parcel2 = Parcel.obtain();
/* 129 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/* 131 */         try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarSensorTmp");
/* 132 */           if (param2ISensorTmperListener != null) { IBinder iBinder = param2ISensorTmperListener.asBinder(); } else { param2ISensorTmperListener = null; }  parcel2.writeStrongBinder((IBinder)param2ISensorTmperListener);
/* 133 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 134 */           parcel1.readException();
/*     */           return; }
/*     */         finally
/* 137 */         { parcel1.recycle();
/* 138 */           parcel2.recycle(); }  } } } private static class Proxy implements IECarXCarSensorTmp { public void unregisterListener(ISensorTmperListener param1ISensorTmperListener) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarSensorTmp"); if (param1ISensorTmperListener != null) { IBinder iBinder = param1ISensorTmperListener.asBinder(); } else { param1ISensorTmperListener = null; }  parcel2.writeStrongBinder((IBinder)param1ISensorTmperListener); this.mRemote.transact(3, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     private IBinder mRemote;
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
/*     */       return "ecarx.car.IECarXCarSensorTmp";
/*     */     }
/*     */     
/*     */     public float getSensorTmp() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarSensorTmp");
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.readFloat();
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerListener(ISensorTmperListener param1ISensorTmperListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarSensorTmp");
/*     */         if (param1ISensorTmperListener != null) {
/*     */           IBinder iBinder = param1ISensorTmperListener.asBinder();
/*     */         } else {
/*     */           param1ISensorTmperListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ISensorTmperListener);
/*     */         this.mRemote.transact(2, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IECarXCarSensorTmp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */