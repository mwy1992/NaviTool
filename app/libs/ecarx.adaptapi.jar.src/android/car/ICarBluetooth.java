/*     */ package android.car;public interface ICarBluetooth extends IInterface { void clearBluetoothDeviceConnectionPriority(int paramInt1, int paramInt2) throws RemoteException;
/*     */   
/*     */   String getDeviceNameWithPriority(int paramInt1, int paramInt2) throws RemoteException;
/*     */   
/*     */   boolean isPriorityDevicePresent(int paramInt1, int paramInt2) throws RemoteException;
/*     */   
/*     */   void setBluetoothDeviceConnectionPriority(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarBluetooth { private static final String DESCRIPTOR = "android.car.ICarBluetooth";
/*     */     static final int TRANSACTION_clearBluetoothDeviceConnectionPriority = 2;
/*     */     static final int TRANSACTION_getDeviceNameWithPriority = 4;
/*     */     static final int TRANSACTION_isPriorityDevicePresent = 3;
/*     */     static final int TRANSACTION_setBluetoothDeviceConnectionPriority = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.ICarBluetooth");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarBluetooth asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.ICarBluetooth");
/*  28 */       if (iInterface != null && iInterface instanceof ICarBluetooth) {
/*  29 */         return (ICarBluetooth)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool; String str; BluetoothDevice bluetoothDevice; switch (param1Int1)
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
/*     */           default:
/* 102 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.ICarBluetooth"); param1Int2 = param1Parcel1.readInt(); param1Int1 = param1Parcel1.readInt(); str = getDeviceNameWithPriority(param1Int2, param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 3:
/*     */             str.enforceInterface("android.car.ICarBluetooth"); param1Int1 = str.readInt(); param1Int2 = str.readInt(); bool = isPriorityDevicePresent(param1Int1, param1Int2); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 2:
/*     */             str.enforceInterface("android.car.ICarBluetooth"); param1Int2 = str.readInt(); i = str.readInt(); clearBluetoothDeviceConnectionPriority(param1Int2, i); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break; }  str.enforceInterface("android.car.ICarBluetooth"); if (str.readInt() != 0) { bluetoothDevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel((Parcel)str); } else { bluetoothDevice = null; }  int i = str.readInt(); param1Int2 = str.readInt(); setBluetoothDeviceConnectionPriority(bluetoothDevice, i, param1Int2); param1Parcel2.writeNoException(); return true; }
/* 111 */        param1Parcel2.writeString("android.car.ICarBluetooth"); return true; } private static class Proxy implements ICarBluetooth { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 115 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 119 */         return "android.car.ICarBluetooth";
/*     */       }
/*     */       
/*     */       public void setBluetoothDeviceConnectionPriority(BluetoothDevice param2BluetoothDevice, int param2Int1, int param2Int2) throws RemoteException {
/* 123 */         Parcel parcel2 = Parcel.obtain();
/* 124 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 126 */           parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/* 127 */           if (param2BluetoothDevice != null) {
/* 128 */             parcel2.writeInt(1);
/* 129 */             param2BluetoothDevice.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 132 */             parcel2.writeInt(0);
/*     */           } 
/* 134 */           parcel2.writeInt(param2Int1);
/* 135 */           parcel2.writeInt(param2Int2);
/* 136 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 137 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 140 */           parcel1.recycle();
/* 141 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void clearBluetoothDeviceConnectionPriority(int param2Int1, int param2Int2) throws RemoteException {
/* 146 */         Parcel parcel2 = Parcel.obtain();
/* 147 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 149 */           parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/* 150 */           parcel2.writeInt(param2Int1);
/* 151 */           parcel2.writeInt(param2Int2);
/* 152 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 153 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 156 */           parcel1.recycle();
/* 157 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean isPriorityDevicePresent(int param2Int1, int param2Int2) throws RemoteException {
/* 162 */         Parcel parcel2 = Parcel.obtain();
/* 163 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 166 */           parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/* 167 */           parcel2.writeInt(param2Int1);
/* 168 */           parcel2.writeInt(param2Int2);
/* 169 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(3, parcel2, parcel1, 0);
/* 170 */           parcel1.readException();
/* 171 */           param2Int1 = parcel1.readInt(); if (param2Int1 != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 177 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 181 */         }  } public String getDeviceNameWithPriority(int param2Int1, int param2Int2) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 182 */         Parcel parcel1 = Parcel.obtain();
/*     */ 
/*     */         
/* 185 */         try { parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/* 186 */           parcel2.writeInt(param2Int1);
/* 187 */           parcel2.writeInt(param2Int2);
/* 188 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 189 */           parcel1.readException();
/* 190 */           return parcel1.readString(); }
/*     */         finally
/*     */         
/* 193 */         { parcel1.recycle();
/* 194 */           parcel2.recycle(); }  } } } private static class Proxy implements ICarBluetooth { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getDeviceNameWithPriority(int param1Int1, int param1Int2) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.ICarBluetooth"); parcel2.writeInt(param1Int1); parcel2.writeInt(param1Int2); this.mRemote.transact(4, parcel2, parcel1, 0); parcel1.readException(); return parcel1.readString(); } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.ICarBluetooth";
/*     */     }
/*     */     
/*     */     public void setBluetoothDeviceConnectionPriority(BluetoothDevice param1BluetoothDevice, int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/*     */         if (param1BluetoothDevice != null) {
/*     */           parcel2.writeInt(1);
/*     */           param1BluetoothDevice.writeToParcel(parcel2, 0);
/*     */         } else {
/*     */           parcel2.writeInt(0);
/*     */         } 
/*     */         parcel2.writeInt(param1Int1);
/*     */         parcel2.writeInt(param1Int2);
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void clearBluetoothDeviceConnectionPriority(int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/*     */         parcel2.writeInt(param1Int1);
/*     */         parcel2.writeInt(param1Int2);
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isPriorityDevicePresent(int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarBluetooth");
/*     */         parcel2.writeInt(param1Int1);
/*     */         parcel2.writeInt(param1Int2);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(3, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         param1Int1 = parcel1.readInt();
/*     */         if (param1Int1 != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\ICarBluetooth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */