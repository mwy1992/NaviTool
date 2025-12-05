/*     */ package android.car.hardware.power;public interface ICarPower extends IInterface { void finished(ICarPowerStateListener paramICarPowerStateListener, int paramInt) throws RemoteException;
/*     */   int getBootReason() throws RemoteException;
/*     */   void registerListener(ICarPowerStateListener paramICarPowerStateListener) throws RemoteException;
/*     */   void requestShutdownOnNextSuspend() throws RemoteException;
/*     */   
/*     */   void unregisterListener(ICarPowerStateListener paramICarPowerStateListener) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarPower { private static final String DESCRIPTOR = "android.car.hardware.power.ICarPower";
/*     */     static final int TRANSACTION_finished = 5;
/*     */     static final int TRANSACTION_getBootReason = 4;
/*     */     static final int TRANSACTION_registerListener = 1;
/*     */     static final int TRANSACTION_requestShutdownOnNextSuspend = 3;
/*     */     static final int TRANSACTION_unregisterListener = 2;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.hardware.power.ICarPower");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarPower asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.hardware.power.ICarPower");
/*  28 */       if (iInterface != null && iInterface instanceof ICarPower) {
/*  29 */         return (ICarPower)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { ICarPowerStateListener iCarPowerStateListener2; switch (param1Int1)
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
/*  93 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 5: param1Parcel1.enforceInterface("android.car.hardware.power.ICarPower"); iCarPowerStateListener2 = ICarPowerStateListener.Stub.asInterface(param1Parcel1.readStrongBinder()); param1Int1 = param1Parcel1.readInt(); finished(iCarPowerStateListener2, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.hardware.power.ICarPower"); param1Int1 = getBootReason(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.hardware.power.ICarPower"); requestShutdownOnNextSuspend(); param1Parcel2.writeNoException(); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.hardware.power.ICarPower"); iCarPowerStateListener1 = ICarPowerStateListener.Stub.asInterface(param1Parcel1.readStrongBinder()); unregisterListener(iCarPowerStateListener1); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/* 102 */             break; }  iCarPowerStateListener1.enforceInterface("android.car.hardware.power.ICarPower"); ICarPowerStateListener iCarPowerStateListener1 = ICarPowerStateListener.Stub.asInterface(iCarPowerStateListener1.readStrongBinder()); registerListener(iCarPowerStateListener1); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.hardware.power.ICarPower"); return true; } private static class Proxy implements ICarPower { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 106 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 110 */         return "android.car.hardware.power.ICarPower";
/*     */       }
/*     */       
/*     */       public void registerListener(ICarPowerStateListener param2ICarPowerStateListener) throws RemoteException {
/* 114 */         Parcel parcel1 = Parcel.obtain();
/* 115 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 117 */           parcel1.writeInterfaceToken("android.car.hardware.power.ICarPower");
/* 118 */           if (param2ICarPowerStateListener != null) { IBinder iBinder = param2ICarPowerStateListener.asBinder(); } else { param2ICarPowerStateListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarPowerStateListener);
/* 119 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 120 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 123 */           parcel2.recycle();
/* 124 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterListener(ICarPowerStateListener param2ICarPowerStateListener) throws RemoteException {
/* 129 */         Parcel parcel1 = Parcel.obtain();
/* 130 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 132 */           parcel1.writeInterfaceToken("android.car.hardware.power.ICarPower");
/* 133 */           if (param2ICarPowerStateListener != null) { IBinder iBinder = param2ICarPowerStateListener.asBinder(); } else { param2ICarPowerStateListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarPowerStateListener);
/* 134 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 135 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 138 */           parcel2.recycle();
/* 139 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void requestShutdownOnNextSuspend() throws RemoteException {
/* 144 */         Parcel parcel2 = Parcel.obtain();
/* 145 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 147 */           parcel2.writeInterfaceToken("android.car.hardware.power.ICarPower");
/* 148 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 149 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 152 */           parcel1.recycle();
/* 153 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getBootReason() throws RemoteException {
/* 158 */         Parcel parcel2 = Parcel.obtain();
/* 159 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 162 */           parcel2.writeInterfaceToken("android.car.hardware.power.ICarPower");
/* 163 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 164 */           parcel1.readException();
/* 165 */           return parcel1.readInt();
/*     */         } finally {
/*     */           
/* 168 */           parcel1.recycle();
/* 169 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void finished(ICarPowerStateListener param2ICarPowerStateListener, int param2Int) throws RemoteException
/*     */       {
/* 175 */         Parcel parcel1 = Parcel.obtain();
/* 176 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/* 178 */         try { parcel1.writeInterfaceToken("android.car.hardware.power.ICarPower");
/* 179 */           if (param2ICarPowerStateListener != null) { IBinder iBinder = param2ICarPowerStateListener.asBinder(); } else { param2ICarPowerStateListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarPowerStateListener);
/* 180 */           parcel1.writeInt(param2Int);
/* 181 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 182 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 185 */         { parcel2.recycle();
/* 186 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarPower { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public void finished(ICarPowerStateListener param1ICarPowerStateListener, int param1Int) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.hardware.power.ICarPower"); if (param1ICarPowerStateListener != null) { IBinder iBinder = param1ICarPowerStateListener.asBinder(); } else { param1ICarPowerStateListener = null; }  parcel1.writeStrongBinder((IBinder)param1ICarPowerStateListener); parcel1.writeInt(param1Int); this.mRemote.transact(5, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public IBinder asBinder() {
/*     */       return this.mRemote;
/*     */     }
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.hardware.power.ICarPower";
/*     */     }
/*     */     
/*     */     public void registerListener(ICarPowerStateListener param1ICarPowerStateListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.hardware.power.ICarPower");
/*     */         if (param1ICarPowerStateListener != null) {
/*     */           IBinder iBinder = param1ICarPowerStateListener.asBinder();
/*     */         } else {
/*     */           param1ICarPowerStateListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarPowerStateListener);
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterListener(ICarPowerStateListener param1ICarPowerStateListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.hardware.power.ICarPower");
/*     */         if (param1ICarPowerStateListener != null) {
/*     */           IBinder iBinder = param1ICarPowerStateListener.asBinder();
/*     */         } else {
/*     */           param1ICarPowerStateListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarPowerStateListener);
/*     */         this.mRemote.transact(2, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void requestShutdownOnNextSuspend() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.hardware.power.ICarPower");
/*     */         this.mRemote.transact(3, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getBootReason() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.hardware.power.ICarPower");
/*     */         this.mRemote.transact(4, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.readInt();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\power\ICarPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */