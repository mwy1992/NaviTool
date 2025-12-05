/*     */ package android.car.diagnostic;public interface ICarDiagnostic extends IInterface { boolean clearFreezeFrames(long[] paramArrayOflong) throws RemoteException;
/*     */   CarDiagnosticEvent getFreezeFrame(long paramLong) throws RemoteException;
/*     */   long[] getFreezeFrameTimestamps() throws RemoteException;
/*     */   CarDiagnosticEvent getLatestLiveFrame() throws RemoteException;
/*     */   boolean isClearFreezeFramesSupported() throws RemoteException;
/*     */   boolean isFreezeFrameNotificationSupported() throws RemoteException;
/*     */   boolean isGetFreezeFrameSupported() throws RemoteException;
/*     */   boolean isLiveFrameSupported() throws RemoteException;
/*     */   boolean isSelectiveClearFreezeFramesSupported() throws RemoteException;
/*     */   boolean registerOrUpdateDiagnosticListener(int paramInt1, int paramInt2, ICarDiagnosticEventListener paramICarDiagnosticEventListener) throws RemoteException;
/*     */   void unregisterDiagnosticListener(int paramInt, ICarDiagnosticEventListener paramICarDiagnosticEventListener) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements ICarDiagnostic { private static final String DESCRIPTOR = "android.car.diagnostic.ICarDiagnostic"; static final int TRANSACTION_clearFreezeFrames = 6; static final int TRANSACTION_getFreezeFrame = 5; static final int TRANSACTION_getFreezeFrameTimestamps = 4; static final int TRANSACTION_getLatestLiveFrame = 3; static final int TRANSACTION_isClearFreezeFramesSupported = 11; static final int TRANSACTION_isFreezeFrameNotificationSupported = 9; static final int TRANSACTION_isGetFreezeFrameSupported = 10; static final int TRANSACTION_isLiveFrameSupported = 8; static final int TRANSACTION_isSelectiveClearFreezeFramesSupported = 12; static final int TRANSACTION_registerOrUpdateDiagnosticListener = 2;
/*     */     static final int TRANSACTION_unregisterDiagnosticListener = 7;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.diagnostic.ICarDiagnostic");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarDiagnostic asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.diagnostic.ICarDiagnostic");
/*  28 */       if (iInterface != null && iInterface instanceof ICarDiagnostic) {
/*  29 */         return (ICarDiagnostic)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool3; int j; boolean bool2; ICarDiagnosticEventListener iCarDiagnosticEventListener2; long[] arrayOfLong2; CarDiagnosticEvent carDiagnosticEvent2; long[] arrayOfLong1; CarDiagnosticEvent carDiagnosticEvent1; long l; switch (param1Int1)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 162 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);case 12: param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); bool3 = isSelectiveClearFreezeFramesSupported(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool3); return true;case 11: param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); bool3 = isClearFreezeFramesSupported(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool3); return true;
/*     */           case 10: param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); bool3 = isGetFreezeFrameSupported(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool3); return true;
/*     */           case 9: param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); bool3 = isFreezeFrameNotificationSupported(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool3); return true;
/*     */           case 8: param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); bool3 = isLiveFrameSupported(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool3); return true;
/*     */           case 7: param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); j = param1Parcel1.readInt(); iCarDiagnosticEventListener2 = ICarDiagnosticEventListener.Stub.asInterface(param1Parcel1.readStrongBinder()); unregisterDiagnosticListener(j, iCarDiagnosticEventListener2); param1Parcel2.writeNoException(); return true;
/*     */           case 6: iCarDiagnosticEventListener2.enforceInterface("android.car.diagnostic.ICarDiagnostic"); arrayOfLong2 = iCarDiagnosticEventListener2.createLongArray(); bool2 = clearFreezeFrames(arrayOfLong2); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool2); return true;
/*     */           case 5: arrayOfLong2.enforceInterface("android.car.diagnostic.ICarDiagnostic"); l = arrayOfLong2.readLong(); carDiagnosticEvent2 = getFreezeFrame(l); param1Parcel2.writeNoException(); if (carDiagnosticEvent2 != null) { param1Parcel2.writeInt(1); carDiagnosticEvent2.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 4: carDiagnosticEvent2.enforceInterface("android.car.diagnostic.ICarDiagnostic"); arrayOfLong1 = getFreezeFrameTimestamps(); param1Parcel2.writeNoException(); param1Parcel2.writeLongArray(arrayOfLong1); return true;
/*     */           case 3: arrayOfLong1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); carDiagnosticEvent1 = getLatestLiveFrame(); param1Parcel2.writeNoException(); if (carDiagnosticEvent1 != null) { param1Parcel2.writeInt(1); carDiagnosticEvent1.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/* 171 */           case 2: break; }  carDiagnosticEvent1.enforceInterface("android.car.diagnostic.ICarDiagnostic"); param1Int2 = carDiagnosticEvent1.readInt(); int i = carDiagnosticEvent1.readInt(); ICarDiagnosticEventListener iCarDiagnosticEventListener1 = ICarDiagnosticEventListener.Stub.asInterface(carDiagnosticEvent1.readStrongBinder()); boolean bool1 = registerOrUpdateDiagnosticListener(param1Int2, i, iCarDiagnosticEventListener1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool1); return true; }  param1Parcel2.writeString("android.car.diagnostic.ICarDiagnostic"); return true; } private static class Proxy implements ICarDiagnostic { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 175 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 179 */         return "android.car.diagnostic.ICarDiagnostic";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean registerOrUpdateDiagnosticListener(int param2Int1, int param2Int2, ICarDiagnosticEventListener param2ICarDiagnosticEventListener) throws RemoteException {
/* 186 */         Parcel parcel2 = Parcel.obtain();
/* 187 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 190 */           parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 191 */           parcel2.writeInt(param2Int1);
/* 192 */           parcel2.writeInt(param2Int2);
/* 193 */           if (param2ICarDiagnosticEventListener != null) { IBinder iBinder1 = param2ICarDiagnosticEventListener.asBinder(); } else { param2ICarDiagnosticEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2ICarDiagnosticEventListener);
/* 194 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel2, parcel1, 0);
/* 195 */           parcel1.readException();
/* 196 */           param2Int1 = parcel1.readInt(); if (param2Int1 != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 202 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       public CarDiagnosticEvent getLatestLiveFrame() throws RemoteException {
/* 209 */         Parcel parcel1 = Parcel.obtain();
/* 210 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/*     */           CarDiagnosticEvent carDiagnosticEvent;
/* 213 */           parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 214 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 215 */           parcel2.readException();
/* 216 */           if (parcel2.readInt() != 0) {
/* 217 */             carDiagnosticEvent = (CarDiagnosticEvent)CarDiagnosticEvent.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 220 */             carDiagnosticEvent = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 227 */           return carDiagnosticEvent;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       public long[] getFreezeFrameTimestamps() throws RemoteException {
/* 234 */         Parcel parcel2 = Parcel.obtain();
/* 235 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 238 */           parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 239 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 240 */           parcel1.readException();
/* 241 */           return parcel1.createLongArray();
/*     */         } finally {
/*     */           
/* 244 */           parcel1.recycle();
/* 245 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public CarDiagnosticEvent getFreezeFrame(long param2Long) throws RemoteException {
/* 254 */         Parcel parcel1 = Parcel.obtain();
/* 255 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/*     */           CarDiagnosticEvent carDiagnosticEvent;
/* 258 */           parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 259 */           parcel1.writeLong(param2Long);
/* 260 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 261 */           parcel2.readException();
/* 262 */           if (parcel2.readInt() != 0) {
/* 263 */             carDiagnosticEvent = (CarDiagnosticEvent)CarDiagnosticEvent.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 266 */             carDiagnosticEvent = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 273 */           return carDiagnosticEvent;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       public boolean clearFreezeFrames(long[] param2ArrayOflong) throws RemoteException {
/* 280 */         Parcel parcel2 = Parcel.obtain();
/* 281 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 284 */           parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 285 */           parcel2.writeLongArray(param2ArrayOflong);
/* 286 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(6, parcel2, parcel1, 0);
/* 287 */           parcel1.readException();
/* 288 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 294 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       public void unregisterDiagnosticListener(int param2Int, ICarDiagnosticEventListener param2ICarDiagnosticEventListener) throws RemoteException {
/* 301 */         Parcel parcel1 = Parcel.obtain();
/* 302 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 304 */           parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 305 */           parcel1.writeInt(param2Int);
/* 306 */           if (param2ICarDiagnosticEventListener != null) { IBinder iBinder = param2ICarDiagnosticEventListener.asBinder(); } else { param2ICarDiagnosticEventListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarDiagnosticEventListener);
/* 307 */           this.mRemote.transact(7, parcel1, parcel2, 0);
/* 308 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 311 */           parcel2.recycle();
/* 312 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isLiveFrameSupported() throws RemoteException {
/* 320 */         Parcel parcel1 = Parcel.obtain();
/* 321 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 324 */           parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 325 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(8, parcel1, parcel2, 0);
/* 326 */           parcel2.readException();
/* 327 */           int i = parcel2.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 333 */           return bool;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean isFreezeFrameNotificationSupported() throws RemoteException {
/* 341 */         Parcel parcel2 = Parcel.obtain();
/* 342 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 345 */           parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 346 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(9, parcel2, parcel1, 0);
/* 347 */           parcel1.readException();
/* 348 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 354 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean isGetFreezeFrameSupported() throws RemoteException {
/* 362 */         Parcel parcel2 = Parcel.obtain();
/* 363 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 366 */           parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 367 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(10, parcel2, parcel1, 0);
/* 368 */           parcel1.readException();
/* 369 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 375 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       public boolean isClearFreezeFramesSupported() throws RemoteException {
/* 382 */         Parcel parcel1 = Parcel.obtain();
/* 383 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 386 */           parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 387 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(11, parcel1, parcel2, 0);
/* 388 */           parcel2.readException();
/* 389 */           int i = parcel2.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 395 */           return bool;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean isSelectiveClearFreezeFramesSupported() throws RemoteException {
/* 403 */         Parcel parcel2 = Parcel.obtain();
/* 404 */         Parcel parcel1 = Parcel.obtain();
/*     */ 
/*     */         
/* 407 */         try { parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/* 408 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(12, parcel2, parcel1, 0);
/* 409 */           parcel1.readException();
/* 410 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 416 */           return bool; } finally { parcel1.recycle(); parcel2.recycle(); }  } } } private static class Proxy implements ICarDiagnostic { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public boolean isSelectiveClearFreezeFramesSupported() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic"); IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(12, parcel2, parcel1, 0); parcel1.readException(); int i = parcel1.readInt(); if (i != 0) bool = true;  return bool; }
/*     */       finally
/*     */       { parcel1.recycle();
/*     */         parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.diagnostic.ICarDiagnostic";
/*     */     }
/*     */     
/*     */     public boolean registerOrUpdateDiagnosticListener(int param1Int1, int param1Int2, ICarDiagnosticEventListener param1ICarDiagnosticEventListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         parcel2.writeInt(param1Int1);
/*     */         parcel2.writeInt(param1Int2);
/*     */         if (param1ICarDiagnosticEventListener != null) {
/*     */           IBinder iBinder1 = param1ICarDiagnosticEventListener.asBinder();
/*     */         } else {
/*     */           param1ICarDiagnosticEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarDiagnosticEventListener);
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
/*     */     public CarDiagnosticEvent getLatestLiveFrame() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         CarDiagnosticEvent carDiagnosticEvent;
/*     */         parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           carDiagnosticEvent = (CarDiagnosticEvent)CarDiagnosticEvent.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           carDiagnosticEvent = null;
/*     */         } 
/*     */         return carDiagnosticEvent;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public long[] getFreezeFrameTimestamps() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         this.mRemote.transact(4, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.createLongArray();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public CarDiagnosticEvent getFreezeFrame(long param1Long) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         CarDiagnosticEvent carDiagnosticEvent;
/*     */         parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         parcel1.writeLong(param1Long);
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           carDiagnosticEvent = (CarDiagnosticEvent)CarDiagnosticEvent.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           carDiagnosticEvent = null;
/*     */         } 
/*     */         return carDiagnosticEvent;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean clearFreezeFrames(long[] param1ArrayOflong) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         parcel2.writeLongArray(param1ArrayOflong);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(6, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         int i = parcel1.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterDiagnosticListener(int param1Int, ICarDiagnosticEventListener param1ICarDiagnosticEventListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         parcel1.writeInt(param1Int);
/*     */         if (param1ICarDiagnosticEventListener != null) {
/*     */           IBinder iBinder = param1ICarDiagnosticEventListener.asBinder();
/*     */         } else {
/*     */           param1ICarDiagnosticEventListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarDiagnosticEventListener);
/*     */         this.mRemote.transact(7, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isLiveFrameSupported() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(8, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         int i = parcel2.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isFreezeFrameNotificationSupported() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(9, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         int i = parcel1.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isGetFreezeFrameSupported() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(10, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         int i = parcel1.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isClearFreezeFramesSupported() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.diagnostic.ICarDiagnostic");
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(11, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         int i = parcel2.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\diagnostic\ICarDiagnostic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */