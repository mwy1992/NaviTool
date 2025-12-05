/*     */ package android.car;public interface ICarBluetoothUserService extends IInterface { void bluetoothConnectToProfile(int paramInt, BluetoothDevice paramBluetoothDevice) throws RemoteException;
/*     */   void closeBluetoothConnectionProxy() throws RemoteException;
/*     */   boolean isBluetoothConnectionProxyAvailable(int paramInt) throws RemoteException;
/*     */   void setProfilePriority(int paramInt1, BluetoothDevice paramBluetoothDevice, int paramInt2) throws RemoteException;
/*     */   
/*     */   void setupBluetoothConnectionProxy() throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarBluetoothUserService { private static final String DESCRIPTOR = "android.car.ICarBluetoothUserService";
/*     */     static final int TRANSACTION_bluetoothConnectToProfile = 4;
/*     */     static final int TRANSACTION_closeBluetoothConnectionProxy = 2;
/*     */     static final int TRANSACTION_isBluetoothConnectionProxyAvailable = 3;
/*     */     static final int TRANSACTION_setProfilePriority = 5;
/*     */     static final int TRANSACTION_setupBluetoothConnectionProxy = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.ICarBluetoothUserService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarBluetoothUserService asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.ICarBluetoothUserService");
/*  28 */       if (iInterface != null && iInterface instanceof ICarBluetoothUserService) {
/*  29 */         return (ICarBluetoothUserService)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool; BluetoothDevice bluetoothDevice1, bluetoothDevice2 = null, bluetoothDevice3 = null; switch (param1Int1)
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
/* 107 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 5: param1Parcel1.enforceInterface("android.car.ICarBluetoothUserService"); param1Int2 = param1Parcel1.readInt(); if (param1Parcel1.readInt() != 0) { bluetoothDevice2 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(param1Parcel1); } else { bluetoothDevice2 = bluetoothDevice3; }  param1Int1 = param1Parcel1.readInt(); setProfilePriority(param1Int2, bluetoothDevice2, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.ICarBluetoothUserService"); param1Int1 = param1Parcel1.readInt(); if (param1Parcel1.readInt() != 0) { bluetoothDevice1 = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel(param1Parcel1); } else { bluetoothDevice1 = bluetoothDevice2; }  bluetoothConnectToProfile(param1Int1, bluetoothDevice1); param1Parcel2.writeNoException(); return true;
/*     */           case 3:
/*     */             bluetoothDevice1.enforceInterface("android.car.ICarBluetoothUserService"); param1Int1 = bluetoothDevice1.readInt(); bool = isBluetoothConnectionProxyAvailable(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 2:
/*     */             bluetoothDevice1.enforceInterface("android.car.ICarBluetoothUserService"); closeBluetoothConnectionProxy(); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/* 116 */             break; }  bluetoothDevice1.enforceInterface("android.car.ICarBluetoothUserService"); setupBluetoothConnectionProxy(); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.ICarBluetoothUserService"); return true; } private static class Proxy implements ICarBluetoothUserService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 120 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 124 */         return "android.car.ICarBluetoothUserService";
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void setupBluetoothConnectionProxy() throws RemoteException {
/* 130 */         Parcel parcel2 = Parcel.obtain();
/* 131 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 133 */           parcel2.writeInterfaceToken("android.car.ICarBluetoothUserService");
/* 134 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 135 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 138 */           parcel1.recycle();
/* 139 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void closeBluetoothConnectionProxy() throws RemoteException {
/* 144 */         Parcel parcel2 = Parcel.obtain();
/* 145 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 147 */           parcel2.writeInterfaceToken("android.car.ICarBluetoothUserService");
/* 148 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 149 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 152 */           parcel1.recycle();
/* 153 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean isBluetoothConnectionProxyAvailable(int param2Int) throws RemoteException {
/* 158 */         Parcel parcel2 = Parcel.obtain();
/* 159 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 162 */           parcel2.writeInterfaceToken("android.car.ICarBluetoothUserService");
/* 163 */           parcel2.writeInt(param2Int);
/* 164 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(3, parcel2, parcel1, 0);
/* 165 */           parcel1.readException();
/* 166 */           param2Int = parcel1.readInt(); if (param2Int != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 172 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 176 */         }  } public void bluetoothConnectToProfile(int param2Int, BluetoothDevice param2BluetoothDevice) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 177 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 179 */           parcel1.writeInterfaceToken("android.car.ICarBluetoothUserService");
/* 180 */           parcel1.writeInt(param2Int);
/* 181 */           if (param2BluetoothDevice != null) {
/* 182 */             parcel1.writeInt(1);
/* 183 */             param2BluetoothDevice.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 186 */             parcel1.writeInt(0);
/*     */           } 
/* 188 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 189 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 192 */           parcel2.recycle();
/* 193 */           parcel1.recycle();
/*     */         }  }
/*     */ 
/*     */       
/*     */       public void setProfilePriority(int param2Int1, BluetoothDevice param2BluetoothDevice, int param2Int2) throws RemoteException {
/* 198 */         Parcel parcel1 = Parcel.obtain();
/* 199 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/* 201 */         try { parcel1.writeInterfaceToken("android.car.ICarBluetoothUserService");
/* 202 */           parcel1.writeInt(param2Int1);
/* 203 */           if (param2BluetoothDevice != null) {
/* 204 */             parcel1.writeInt(1);
/* 205 */             param2BluetoothDevice.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 208 */             parcel1.writeInt(0);
/*     */           } 
/* 210 */           parcel1.writeInt(param2Int2);
/* 211 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 212 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 215 */         { parcel2.recycle();
/* 216 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarBluetoothUserService { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.ICarBluetoothUserService"; } public void setProfilePriority(int param1Int1, BluetoothDevice param1BluetoothDevice, int param1Int2) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.ICarBluetoothUserService"); parcel1.writeInt(param1Int1); if (param1BluetoothDevice != null) { parcel1.writeInt(1); param1BluetoothDevice.writeToParcel(parcel1, 0); } else { parcel1.writeInt(0); }  parcel1.writeInt(param1Int2); this.mRemote.transact(5, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void setupBluetoothConnectionProxy() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarBluetoothUserService");
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void closeBluetoothConnectionProxy() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarBluetoothUserService");
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isBluetoothConnectionProxyAvailable(int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarBluetoothUserService");
/*     */         parcel2.writeInt(param1Int);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(3, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         param1Int = parcel1.readInt();
/*     */         if (param1Int != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void bluetoothConnectToProfile(int param1Int, BluetoothDevice param1BluetoothDevice) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.ICarBluetoothUserService");
/*     */         parcel1.writeInt(param1Int);
/*     */         if (param1BluetoothDevice != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1BluetoothDevice.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\ICarBluetoothUserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */