/*     */ package android.car.hardware;public interface ICarSensor extends IInterface { CarSensorEvent getLatestSensorEvent(int paramInt) throws RemoteException;
/*     */   CarSensorConfig getSensorConfig(int paramInt) throws RemoteException;
/*     */   int[] getSupportedSensors() throws RemoteException;
/*     */   boolean registerOrUpdateSensorListener(int paramInt1, int paramInt2, ICarSensorEventListener paramICarSensorEventListener) throws RemoteException;
/*     */   
/*     */   void unregisterSensorListener(int paramInt, ICarSensorEventListener paramICarSensorEventListener) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarSensor { private static final String DESCRIPTOR = "android.car.hardware.ICarSensor";
/*     */     static final int TRANSACTION_getLatestSensorEvent = 3;
/*     */     static final int TRANSACTION_getSensorConfig = 5;
/*     */     static final int TRANSACTION_getSupportedSensors = 1;
/*     */     static final int TRANSACTION_registerOrUpdateSensorListener = 2;
/*     */     static final int TRANSACTION_unregisterSensorListener = 4;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.hardware.ICarSensor");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarSensor asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.hardware.ICarSensor");
/*  28 */       if (iInterface != null && iInterface instanceof ICarSensor) {
/*  29 */         return (ICarSensor)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool; CarSensorConfig carSensorConfig; ICarSensorEventListener iCarSensorEventListener2; CarSensorEvent carSensorEvent; ICarSensorEventListener iCarSensorEventListener1; switch (param1Int1)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 114 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 5: param1Parcel1.enforceInterface("android.car.hardware.ICarSensor"); param1Int1 = param1Parcel1.readInt(); carSensorConfig = getSensorConfig(param1Int1); param1Parcel2.writeNoException(); if (carSensorConfig != null) { param1Parcel2.writeInt(1); carSensorConfig.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 4:
/*     */             carSensorConfig.enforceInterface("android.car.hardware.ICarSensor"); param1Int1 = carSensorConfig.readInt(); iCarSensorEventListener2 = ICarSensorEventListener.Stub.asInterface(carSensorConfig.readStrongBinder()); unregisterSensorListener(param1Int1, iCarSensorEventListener2); param1Parcel2.writeNoException(); return true;
/*     */           case 3:
/*     */             iCarSensorEventListener2.enforceInterface("android.car.hardware.ICarSensor"); param1Int1 = iCarSensorEventListener2.readInt(); carSensorEvent = getLatestSensorEvent(param1Int1); param1Parcel2.writeNoException(); if (carSensorEvent != null) { param1Parcel2.writeInt(1); carSensorEvent.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 2:
/*     */             carSensorEvent.enforceInterface("android.car.hardware.ICarSensor"); param1Int2 = carSensorEvent.readInt(); param1Int1 = carSensorEvent.readInt(); iCarSensorEventListener1 = ICarSensorEventListener.Stub.asInterface(carSensorEvent.readStrongBinder()); bool = registerOrUpdateSensorListener(param1Int2, param1Int1, iCarSensorEventListener1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 1:
/* 123 */             break; }  iCarSensorEventListener1.enforceInterface("android.car.hardware.ICarSensor"); int[] arrayOfInt = getSupportedSensors(); param1Parcel2.writeNoException(); param1Parcel2.writeIntArray(arrayOfInt); return true; }  param1Parcel2.writeString("android.car.hardware.ICarSensor"); return true; } private static class Proxy implements ICarSensor { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 127 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 131 */         return "android.car.hardware.ICarSensor";
/*     */       }
/*     */       
/*     */       public int[] getSupportedSensors() throws RemoteException {
/* 135 */         Parcel parcel2 = Parcel.obtain();
/* 136 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 139 */           parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/* 140 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 141 */           parcel1.readException();
/* 142 */           return parcel1.createIntArray();
/*     */         } finally {
/*     */           
/* 145 */           parcel1.recycle();
/* 146 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean registerOrUpdateSensorListener(int param2Int1, int param2Int2, ICarSensorEventListener param2ICarSensorEventListener) throws RemoteException {
/* 158 */         Parcel parcel2 = Parcel.obtain();
/* 159 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 162 */           parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/* 163 */           parcel2.writeInt(param2Int1);
/* 164 */           parcel2.writeInt(param2Int2);
/* 165 */           if (param2ICarSensorEventListener != null) { IBinder iBinder1 = param2ICarSensorEventListener.asBinder(); } else { param2ICarSensorEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2ICarSensorEventListener);
/* 166 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel2, parcel1, 0);
/* 167 */           parcel1.readException();
/* 168 */           param2Int1 = parcel1.readInt(); if (param2Int1 != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 174 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public CarSensorEvent getLatestSensorEvent(int param2Int) throws RemoteException {
/* 182 */         Parcel parcel2 = Parcel.obtain();
/* 183 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/*     */           CarSensorEvent carSensorEvent;
/* 186 */           parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/* 187 */           parcel2.writeInt(param2Int);
/* 188 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 189 */           parcel1.readException();
/* 190 */           if (parcel1.readInt() != 0) {
/* 191 */             carSensorEvent = (CarSensorEvent)CarSensorEvent.CREATOR.createFromParcel(parcel1);
/*     */           } else {
/*     */             
/* 194 */             carSensorEvent = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 201 */           return carSensorEvent;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterSensorListener(int param2Int, ICarSensorEventListener param2ICarSensorEventListener) throws RemoteException {
/* 209 */         Parcel parcel2 = Parcel.obtain();
/* 210 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 212 */           parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/* 213 */           parcel2.writeInt(param2Int);
/* 214 */           if (param2ICarSensorEventListener != null) { IBinder iBinder = param2ICarSensorEventListener.asBinder(); } else { param2ICarSensorEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2ICarSensorEventListener);
/* 215 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 216 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 219 */           parcel1.recycle();
/* 220 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public CarSensorConfig getSensorConfig(int param2Int) throws RemoteException
/*     */       {
/* 228 */         Parcel parcel2 = Parcel.obtain();
/* 229 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try { CarSensorConfig carSensorConfig;
/* 232 */           parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/* 233 */           parcel2.writeInt(param2Int);
/* 234 */           this.mRemote.transact(5, parcel2, parcel1, 0);
/* 235 */           parcel1.readException();
/* 236 */           if (parcel1.readInt() != 0) {
/* 237 */             carSensorConfig = (CarSensorConfig)CarSensorConfig.CREATOR.createFromParcel(parcel1);
/*     */           } else {
/*     */             
/* 240 */             carSensorConfig = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 247 */           return carSensorConfig; } finally { parcel1.recycle(); parcel2.recycle(); }  } } } private static class Proxy implements ICarSensor { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.hardware.ICarSensor"; } public CarSensorConfig getSensorConfig(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { CarSensorConfig carSensorConfig; parcel2.writeInterfaceToken("android.car.hardware.ICarSensor"); parcel2.writeInt(param1Int); this.mRemote.transact(5, parcel2, parcel1, 0); parcel1.readException(); if (parcel1.readInt() != 0) { carSensorConfig = (CarSensorConfig)CarSensorConfig.CREATOR.createFromParcel(parcel1); } else { carSensorConfig = null; }  return carSensorConfig; }
/*     */       finally
/*     */       { parcel1.recycle();
/*     */         parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public int[] getSupportedSensors() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.createIntArray();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean registerOrUpdateSensorListener(int param1Int1, int param1Int2, ICarSensorEventListener param1ICarSensorEventListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/*     */         parcel2.writeInt(param1Int1);
/*     */         parcel2.writeInt(param1Int2);
/*     */         if (param1ICarSensorEventListener != null) {
/*     */           IBinder iBinder1 = param1ICarSensorEventListener.asBinder();
/*     */         } else {
/*     */           param1ICarSensorEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarSensorEventListener);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         param1Int1 = parcel1.readInt();
/*     */         if (param1Int1 != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public CarSensorEvent getLatestSensorEvent(int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         CarSensorEvent carSensorEvent;
/*     */         parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(3, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         if (parcel1.readInt() != 0) {
/*     */           carSensorEvent = (CarSensorEvent)CarSensorEvent.CREATOR.createFromParcel(parcel1);
/*     */         } else {
/*     */           carSensorEvent = null;
/*     */         } 
/*     */         return carSensorEvent;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterSensorListener(int param1Int, ICarSensorEventListener param1ICarSensorEventListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.hardware.ICarSensor");
/*     */         parcel2.writeInt(param1Int);
/*     */         if (param1ICarSensorEventListener != null) {
/*     */           IBinder iBinder = param1ICarSensorEventListener.asBinder();
/*     */         } else {
/*     */           param1ICarSensorEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarSensorEventListener);
/*     */         this.mRemote.transact(4, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\ICarSensor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */