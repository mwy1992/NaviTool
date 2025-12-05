/*     */ package android.car.trust;
/*     */ 
/*     */ 
/*     */ public interface ICarTrustAgentBleCallback extends IInterface {
/*     */   void onBleDeviceConnected(BluetoothDevice paramBluetoothDevice) throws RemoteException;
/*     */   
/*     */   void onBleDeviceDisconnected(BluetoothDevice paramBluetoothDevice) throws RemoteException;
/*     */   
/*     */   void onBleServerStartFailure(int paramInt) throws RemoteException;
/*     */   
/*     */   void onBleServerStartSuccess() throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarTrustAgentBleCallback { private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentBleCallback";
/*     */     static final int TRANSACTION_onBleDeviceConnected = 3;
/*     */     static final int TRANSACTION_onBleDeviceDisconnected = 4;
/*     */     static final int TRANSACTION_onBleServerStartFailure = 2;
/*     */     static final int TRANSACTION_onBleServerStartSuccess = 1;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.trust.ICarTrustAgentBleCallback");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarTrustAgentBleCallback asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.trust.ICarTrustAgentBleCallback");
/*  32 */       if (iInterface != null && iInterface instanceof ICarTrustAgentBleCallback) {
/*  33 */         return (ICarTrustAgentBleCallback)iInterface;
/*     */       }
/*  35 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  39 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  44 */       if (param1Int1 != 1598968902) { Parcel parcel1 = null, parcel2 = null; switch (param1Int1)
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
/*     */           default:
/*  93 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleCallback"); if (param1Parcel1.readInt() != 0) { BluetoothDevice bluetoothDevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel2; }  onBleDeviceDisconnected((BluetoothDevice)param1Parcel1); return true;
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleCallback"); if (param1Parcel1.readInt() != 0) { BluetoothDevice bluetoothDevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel1; }  onBleDeviceConnected((BluetoothDevice)param1Parcel1); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleCallback"); param1Int1 = param1Parcel1.readInt(); onBleServerStartFailure(param1Int1); return true;
/*     */           case 1:
/*     */             break; }  param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleCallback"); onBleServerStartSuccess(); return true; }
/* 102 */        param1Parcel2.writeString("android.car.trust.ICarTrustAgentBleCallback"); return true; } private static class Proxy implements ICarTrustAgentBleCallback { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 106 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 110 */         return "android.car.trust.ICarTrustAgentBleCallback";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onBleServerStartSuccess() throws RemoteException {
/* 117 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 119 */           parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/* 120 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 123 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onBleServerStartFailure(int param2Int) throws RemoteException {
/* 132 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 134 */           parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/* 135 */           parcel.writeInt(param2Int);
/* 136 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 139 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onBleDeviceConnected(BluetoothDevice param2BluetoothDevice) throws RemoteException {
/* 147 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 149 */           parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/* 150 */           if (param2BluetoothDevice != null) {
/* 151 */             parcel.writeInt(1);
/* 152 */             param2BluetoothDevice.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 155 */             parcel.writeInt(0);
/*     */           } 
/* 157 */           this.mRemote.transact(3, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 160 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onBleDeviceDisconnected(BluetoothDevice param2BluetoothDevice) throws RemoteException
/*     */       {
/* 168 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 170 */         try { parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/* 171 */           if (param2BluetoothDevice != null) {
/* 172 */             parcel.writeInt(1);
/* 173 */             param2BluetoothDevice.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 176 */             parcel.writeInt(0);
/*     */           } 
/* 178 */           this.mRemote.transact(4, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 181 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarTrustAgentBleCallback { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public void onBleDeviceDisconnected(BluetoothDevice param1BluetoothDevice) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback"); if (param1BluetoothDevice != null) { parcel.writeInt(1); param1BluetoothDevice.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(4, parcel, null, 1); return; } finally { parcel.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.trust.ICarTrustAgentBleCallback";
/*     */     }
/*     */     
/*     */     public void onBleServerStartSuccess() throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onBleServerStartFailure(int param1Int) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/*     */         parcel.writeInt(param1Int);
/*     */         this.mRemote.transact(2, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onBleDeviceConnected(BluetoothDevice param1BluetoothDevice) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentBleCallback");
/*     */         if (param1BluetoothDevice != null) {
/*     */           parcel.writeInt(1);
/*     */           param1BluetoothDevice.writeToParcel(parcel, 0);
/*     */         } else {
/*     */           parcel.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(3, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\trust\ICarTrustAgentBleCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */