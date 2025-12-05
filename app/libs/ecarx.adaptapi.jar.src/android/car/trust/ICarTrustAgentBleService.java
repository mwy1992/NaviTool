/*     */ package android.car.trust;public interface ICarTrustAgentBleService extends IInterface { void addEscrowToken(byte[] paramArrayOfbyte, int paramInt) throws RemoteException; int getUserIdByEscrowTokenHandle(long paramLong) throws RemoteException; void isEscrowTokenActive(long paramLong, int paramInt) throws RemoteException; void onEscrowTokenActiveStateChanged(long paramLong, boolean paramBoolean) throws RemoteException; void onEscrowTokenAdded(byte[] paramArrayOfbyte, long paramLong, int paramInt) throws RemoteException;
/*     */   void onEscrowTokenRemoved(long paramLong, boolean paramBoolean) throws RemoteException;
/*     */   void registerBleCallback(ICarTrustAgentBleCallback paramICarTrustAgentBleCallback) throws RemoteException;
/*     */   void registerEnrolmentCallback(ICarTrustAgentEnrolmentCallback paramICarTrustAgentEnrolmentCallback) throws RemoteException;
/*     */   void registerUnlockCallback(ICarTrustAgentUnlockCallback paramICarTrustAgentUnlockCallback) throws RemoteException;
/*     */   void removeEscrowToken(long paramLong, int paramInt) throws RemoteException;
/*     */   void revokeTrust() throws RemoteException;
/*     */   void sendEnrolmentHandle(BluetoothDevice paramBluetoothDevice, long paramLong) throws RemoteException;
/*     */   void setTokenRequestDelegate(ICarTrustAgentTokenRequestDelegate paramICarTrustAgentTokenRequestDelegate) throws RemoteException;
/*     */   void setTokenResponseCallback(ICarTrustAgentTokenResponseCallback paramICarTrustAgentTokenResponseCallback) throws RemoteException;
/*     */   void startEnrolmentAdvertising() throws RemoteException;
/*     */   void startUnlockAdvertising() throws RemoteException;
/*     */   void stopEnrolmentAdvertising() throws RemoteException;
/*     */   void stopUnlockAdvertising() throws RemoteException;
/*     */   void unregisterBleCallback(ICarTrustAgentBleCallback paramICarTrustAgentBleCallback) throws RemoteException;
/*     */   void unregisterEnrolmentCallback(ICarTrustAgentEnrolmentCallback paramICarTrustAgentEnrolmentCallback) throws RemoteException;
/*     */   void unregisterUnlockCallback(ICarTrustAgentUnlockCallback paramICarTrustAgentUnlockCallback) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements ICarTrustAgentBleService { private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentBleService"; static final int TRANSACTION_addEscrowToken = 14; static final int TRANSACTION_getUserIdByEscrowTokenHandle = 21; static final int TRANSACTION_isEscrowTokenActive = 16; static final int TRANSACTION_onEscrowTokenActiveStateChanged = 20; static final int TRANSACTION_onEscrowTokenAdded = 18; static final int TRANSACTION_onEscrowTokenRemoved = 19; static final int TRANSACTION_registerBleCallback = 1; static final int TRANSACTION_registerEnrolmentCallback = 6; static final int TRANSACTION_registerUnlockCallback = 10; static final int TRANSACTION_removeEscrowToken = 15; static final int TRANSACTION_revokeTrust = 13; static final int TRANSACTION_sendEnrolmentHandle = 5; static final int TRANSACTION_setTokenRequestDelegate = 12; static final int TRANSACTION_setTokenResponseCallback = 17; static final int TRANSACTION_startEnrolmentAdvertising = 3; static final int TRANSACTION_startUnlockAdvertising = 8; static final int TRANSACTION_stopEnrolmentAdvertising = 4; static final int TRANSACTION_stopUnlockAdvertising = 9; static final int TRANSACTION_unregisterBleCallback = 2; static final int TRANSACTION_unregisterEnrolmentCallback = 7; static final int TRANSACTION_unregisterUnlockCallback = 11;
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.trust.ICarTrustAgentBleService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarTrustAgentBleService asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.trust.ICarTrustAgentBleService");
/*  32 */       if (iInterface != null && iInterface instanceof ICarTrustAgentBleService) {
/*  33 */         return (ICarTrustAgentBleService)iInterface;
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
/*  44 */       if (param1Int1 != 1598968902) { ICarTrustAgentTokenResponseCallback iCarTrustAgentTokenResponseCallback; ICarTrustAgentTokenRequestDelegate iCarTrustAgentTokenRequestDelegate; ICarTrustAgentUnlockCallback iCarTrustAgentUnlockCallback; ICarTrustAgentEnrolmentCallback iCarTrustAgentEnrolmentCallback; long l; byte[] arrayOfByte; boolean bool1 = false, bool2 = false; switch (param1Int1)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 254 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);case 21: param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleService"); l = param1Parcel1.readLong(); param1Int1 = getUserIdByEscrowTokenHandle(l); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 20: param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleService"); l = param1Parcel1.readLong(); bool1 = bool2; if (param1Parcel1.readInt() != 0)
/*     */               bool1 = true;  onEscrowTokenActiveStateChanged(l, bool1); param1Parcel2.writeNoException(); return true;case 19: param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleService"); l = param1Parcel1.readLong(); if (param1Parcel1.readInt() != 0)
/*     */               bool1 = true;  onEscrowTokenRemoved(l, bool1); param1Parcel2.writeNoException(); return true;case 18: param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleService"); arrayOfByte = param1Parcel1.createByteArray(); l = param1Parcel1.readLong(); param1Int1 = param1Parcel1.readInt(); onEscrowTokenAdded(arrayOfByte, l, param1Int1); param1Parcel2.writeNoException(); return true;case 17: param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentTokenResponseCallback = ICarTrustAgentTokenResponseCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); setTokenResponseCallback(iCarTrustAgentTokenResponseCallback); param1Parcel2.writeNoException(); return true;case 16: iCarTrustAgentTokenResponseCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); l = iCarTrustAgentTokenResponseCallback.readLong(); param1Int1 = iCarTrustAgentTokenResponseCallback.readInt(); isEscrowTokenActive(l, param1Int1); param1Parcel2.writeNoException(); return true;case 15: iCarTrustAgentTokenResponseCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); l = iCarTrustAgentTokenResponseCallback.readLong(); param1Int1 = iCarTrustAgentTokenResponseCallback.readInt(); removeEscrowToken(l, param1Int1); param1Parcel2.writeNoException(); return true;case 14: iCarTrustAgentTokenResponseCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); arrayOfByte = iCarTrustAgentTokenResponseCallback.createByteArray(); param1Int1 = iCarTrustAgentTokenResponseCallback.readInt(); addEscrowToken(arrayOfByte, param1Int1); param1Parcel2.writeNoException(); return true;case 13: iCarTrustAgentTokenResponseCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); revokeTrust(); param1Parcel2.writeNoException(); return true;case 12: iCarTrustAgentTokenResponseCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentTokenRequestDelegate = ICarTrustAgentTokenRequestDelegate.Stub.asInterface(iCarTrustAgentTokenResponseCallback.readStrongBinder()); setTokenRequestDelegate(iCarTrustAgentTokenRequestDelegate); param1Parcel2.writeNoException(); return true;case 11: iCarTrustAgentTokenRequestDelegate.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentUnlockCallback = ICarTrustAgentUnlockCallback.Stub.asInterface(iCarTrustAgentTokenRequestDelegate.readStrongBinder()); unregisterUnlockCallback(iCarTrustAgentUnlockCallback); param1Parcel2.writeNoException(); return true;case 10: iCarTrustAgentUnlockCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentUnlockCallback = ICarTrustAgentUnlockCallback.Stub.asInterface(iCarTrustAgentUnlockCallback.readStrongBinder()); registerUnlockCallback(iCarTrustAgentUnlockCallback); param1Parcel2.writeNoException(); return true;case 9: iCarTrustAgentUnlockCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); stopUnlockAdvertising(); param1Parcel2.writeNoException(); return true;case 8: iCarTrustAgentUnlockCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); startUnlockAdvertising(); param1Parcel2.writeNoException(); return true;
/*     */           case 7: iCarTrustAgentUnlockCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentEnrolmentCallback = ICarTrustAgentEnrolmentCallback.Stub.asInterface(iCarTrustAgentUnlockCallback.readStrongBinder()); unregisterEnrolmentCallback(iCarTrustAgentEnrolmentCallback); param1Parcel2.writeNoException(); return true;
/*     */           case 6: iCarTrustAgentEnrolmentCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentEnrolmentCallback = ICarTrustAgentEnrolmentCallback.Stub.asInterface(iCarTrustAgentEnrolmentCallback.readStrongBinder()); registerEnrolmentCallback(iCarTrustAgentEnrolmentCallback); param1Parcel2.writeNoException(); return true;
/*     */           case 5: iCarTrustAgentEnrolmentCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); if (iCarTrustAgentEnrolmentCallback.readInt() != 0) { BluetoothDevice bluetoothDevice = (BluetoothDevice)BluetoothDevice.CREATOR.createFromParcel((Parcel)iCarTrustAgentEnrolmentCallback); } else { arrayOfByte = null; }  l = iCarTrustAgentEnrolmentCallback.readLong(); sendEnrolmentHandle((BluetoothDevice)arrayOfByte, l); param1Parcel2.writeNoException(); return true;
/*     */           case 4: iCarTrustAgentEnrolmentCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); stopEnrolmentAdvertising(); param1Parcel2.writeNoException(); return true;
/*     */           case 3: iCarTrustAgentEnrolmentCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); startEnrolmentAdvertising(); param1Parcel2.writeNoException(); return true;
/*     */           case 2: iCarTrustAgentEnrolmentCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); iCarTrustAgentBleCallback = ICarTrustAgentBleCallback.Stub.asInterface(iCarTrustAgentEnrolmentCallback.readStrongBinder()); unregisterBleCallback(iCarTrustAgentBleCallback); param1Parcel2.writeNoException(); return true;
/* 263 */           case 1: break; }  iCarTrustAgentBleCallback.enforceInterface("android.car.trust.ICarTrustAgentBleService"); ICarTrustAgentBleCallback iCarTrustAgentBleCallback = ICarTrustAgentBleCallback.Stub.asInterface(iCarTrustAgentBleCallback.readStrongBinder()); registerBleCallback(iCarTrustAgentBleCallback); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.trust.ICarTrustAgentBleService"); return true; } private static class Proxy implements ICarTrustAgentBleService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 267 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 271 */         return "android.car.trust.ICarTrustAgentBleService";
/*     */       }
/*     */ 
/*     */       
/*     */       public void registerBleCallback(ICarTrustAgentBleCallback param2ICarTrustAgentBleCallback) throws RemoteException {
/* 276 */         Parcel parcel2 = Parcel.obtain();
/* 277 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 279 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 280 */           if (param2ICarTrustAgentBleCallback != null) { IBinder iBinder = param2ICarTrustAgentBleCallback.asBinder(); } else { param2ICarTrustAgentBleCallback = null; }  parcel2.writeStrongBinder((IBinder)param2ICarTrustAgentBleCallback);
/* 281 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 282 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 285 */           parcel1.recycle();
/* 286 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterBleCallback(ICarTrustAgentBleCallback param2ICarTrustAgentBleCallback) throws RemoteException {
/* 291 */         Parcel parcel2 = Parcel.obtain();
/* 292 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 294 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 295 */           if (param2ICarTrustAgentBleCallback != null) { IBinder iBinder = param2ICarTrustAgentBleCallback.asBinder(); } else { param2ICarTrustAgentBleCallback = null; }  parcel2.writeStrongBinder((IBinder)param2ICarTrustAgentBleCallback);
/* 296 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 297 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 300 */           parcel1.recycle();
/* 301 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void startEnrolmentAdvertising() throws RemoteException {
/* 307 */         Parcel parcel1 = Parcel.obtain();
/* 308 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 310 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 311 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 312 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 315 */           parcel2.recycle();
/* 316 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void stopEnrolmentAdvertising() throws RemoteException {
/* 321 */         Parcel parcel1 = Parcel.obtain();
/* 322 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 324 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 325 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 326 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 329 */           parcel2.recycle();
/* 330 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void sendEnrolmentHandle(BluetoothDevice param2BluetoothDevice, long param2Long) throws RemoteException {
/* 335 */         Parcel parcel1 = Parcel.obtain();
/* 336 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 338 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 339 */           if (param2BluetoothDevice != null) {
/* 340 */             parcel1.writeInt(1);
/* 341 */             param2BluetoothDevice.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 344 */             parcel1.writeInt(0);
/*     */           } 
/* 346 */           parcel1.writeLong(param2Long);
/* 347 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 348 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 351 */           parcel2.recycle();
/* 352 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void registerEnrolmentCallback(ICarTrustAgentEnrolmentCallback param2ICarTrustAgentEnrolmentCallback) throws RemoteException {
/* 357 */         Parcel parcel2 = Parcel.obtain();
/* 358 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 360 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 361 */           if (param2ICarTrustAgentEnrolmentCallback != null) { IBinder iBinder = param2ICarTrustAgentEnrolmentCallback.asBinder(); } else { param2ICarTrustAgentEnrolmentCallback = null; }  parcel2.writeStrongBinder((IBinder)param2ICarTrustAgentEnrolmentCallback);
/* 362 */           this.mRemote.transact(6, parcel2, parcel1, 0);
/* 363 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 366 */           parcel1.recycle();
/* 367 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterEnrolmentCallback(ICarTrustAgentEnrolmentCallback param2ICarTrustAgentEnrolmentCallback) throws RemoteException {
/* 372 */         Parcel parcel1 = Parcel.obtain();
/* 373 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 375 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 376 */           if (param2ICarTrustAgentEnrolmentCallback != null) { IBinder iBinder = param2ICarTrustAgentEnrolmentCallback.asBinder(); } else { param2ICarTrustAgentEnrolmentCallback = null; }  parcel1.writeStrongBinder((IBinder)param2ICarTrustAgentEnrolmentCallback);
/* 377 */           this.mRemote.transact(7, parcel1, parcel2, 0);
/* 378 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 381 */           parcel2.recycle();
/* 382 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void startUnlockAdvertising() throws RemoteException {
/* 388 */         Parcel parcel1 = Parcel.obtain();
/* 389 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 391 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 392 */           this.mRemote.transact(8, parcel1, parcel2, 0);
/* 393 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 396 */           parcel2.recycle();
/* 397 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void stopUnlockAdvertising() throws RemoteException {
/* 402 */         Parcel parcel2 = Parcel.obtain();
/* 403 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 405 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 406 */           this.mRemote.transact(9, parcel2, parcel1, 0);
/* 407 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 410 */           parcel1.recycle();
/* 411 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void registerUnlockCallback(ICarTrustAgentUnlockCallback param2ICarTrustAgentUnlockCallback) throws RemoteException {
/* 416 */         Parcel parcel2 = Parcel.obtain();
/* 417 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 419 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 420 */           if (param2ICarTrustAgentUnlockCallback != null) { IBinder iBinder = param2ICarTrustAgentUnlockCallback.asBinder(); } else { param2ICarTrustAgentUnlockCallback = null; }  parcel2.writeStrongBinder((IBinder)param2ICarTrustAgentUnlockCallback);
/* 421 */           this.mRemote.transact(10, parcel2, parcel1, 0);
/* 422 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 425 */           parcel1.recycle();
/* 426 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterUnlockCallback(ICarTrustAgentUnlockCallback param2ICarTrustAgentUnlockCallback) throws RemoteException {
/* 431 */         Parcel parcel1 = Parcel.obtain();
/* 432 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 434 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 435 */           if (param2ICarTrustAgentUnlockCallback != null) { IBinder iBinder = param2ICarTrustAgentUnlockCallback.asBinder(); } else { param2ICarTrustAgentUnlockCallback = null; }  parcel1.writeStrongBinder((IBinder)param2ICarTrustAgentUnlockCallback);
/* 436 */           this.mRemote.transact(11, parcel1, parcel2, 0);
/* 437 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 440 */           parcel2.recycle();
/* 441 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void setTokenRequestDelegate(ICarTrustAgentTokenRequestDelegate param2ICarTrustAgentTokenRequestDelegate) throws RemoteException {
/* 447 */         Parcel parcel2 = Parcel.obtain();
/* 448 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 450 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 451 */           if (param2ICarTrustAgentTokenRequestDelegate != null) { IBinder iBinder = param2ICarTrustAgentTokenRequestDelegate.asBinder(); } else { param2ICarTrustAgentTokenRequestDelegate = null; }  parcel2.writeStrongBinder((IBinder)param2ICarTrustAgentTokenRequestDelegate);
/* 452 */           this.mRemote.transact(12, parcel2, parcel1, 0);
/* 453 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 456 */           parcel1.recycle();
/* 457 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void revokeTrust() throws RemoteException {
/* 462 */         Parcel parcel2 = Parcel.obtain();
/* 463 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 465 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 466 */           this.mRemote.transact(13, parcel2, parcel1, 0);
/* 467 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 470 */           parcel1.recycle();
/* 471 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void addEscrowToken(byte[] param2ArrayOfbyte, int param2Int) throws RemoteException {
/* 476 */         Parcel parcel2 = Parcel.obtain();
/* 477 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 479 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 480 */           parcel2.writeByteArray(param2ArrayOfbyte);
/* 481 */           parcel2.writeInt(param2Int);
/* 482 */           this.mRemote.transact(14, parcel2, parcel1, 0);
/* 483 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 486 */           parcel1.recycle();
/* 487 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void removeEscrowToken(long param2Long, int param2Int) throws RemoteException {
/* 492 */         Parcel parcel1 = Parcel.obtain();
/* 493 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 495 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 496 */           parcel1.writeLong(param2Long);
/* 497 */           parcel1.writeInt(param2Int);
/* 498 */           this.mRemote.transact(15, parcel1, parcel2, 0);
/* 499 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 502 */           parcel2.recycle();
/* 503 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void isEscrowTokenActive(long param2Long, int param2Int) throws RemoteException {
/* 508 */         Parcel parcel1 = Parcel.obtain();
/* 509 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 511 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 512 */           parcel1.writeLong(param2Long);
/* 513 */           parcel1.writeInt(param2Int);
/* 514 */           this.mRemote.transact(16, parcel1, parcel2, 0);
/* 515 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 518 */           parcel2.recycle();
/* 519 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void setTokenResponseCallback(ICarTrustAgentTokenResponseCallback param2ICarTrustAgentTokenResponseCallback) throws RemoteException {
/* 525 */         Parcel parcel2 = Parcel.obtain();
/* 526 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 528 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 529 */           if (param2ICarTrustAgentTokenResponseCallback != null) { IBinder iBinder = param2ICarTrustAgentTokenResponseCallback.asBinder(); } else { param2ICarTrustAgentTokenResponseCallback = null; }  parcel2.writeStrongBinder((IBinder)param2ICarTrustAgentTokenResponseCallback);
/* 530 */           this.mRemote.transact(17, parcel2, parcel1, 0);
/* 531 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 534 */           parcel1.recycle();
/* 535 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onEscrowTokenAdded(byte[] param2ArrayOfbyte, long param2Long, int param2Int) throws RemoteException {
/* 540 */         Parcel parcel1 = Parcel.obtain();
/* 541 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 543 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 544 */           parcel1.writeByteArray(param2ArrayOfbyte);
/* 545 */           parcel1.writeLong(param2Long);
/* 546 */           parcel1.writeInt(param2Int);
/* 547 */           this.mRemote.transact(18, parcel1, parcel2, 0);
/* 548 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 551 */           parcel2.recycle();
/* 552 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onEscrowTokenRemoved(long param2Long, boolean param2Boolean) throws RemoteException {
/* 557 */         Parcel parcel2 = Parcel.obtain();
/* 558 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 560 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 561 */           parcel2.writeLong(param2Long);
/* 562 */           parcel2.writeInt(param2Boolean);
/* 563 */           this.mRemote.transact(19, parcel2, parcel1, 0);
/* 564 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 567 */           parcel1.recycle();
/* 568 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onEscrowTokenActiveStateChanged(long param2Long, boolean param2Boolean) throws RemoteException {
/* 573 */         Parcel parcel1 = Parcel.obtain();
/* 574 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 576 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 577 */           parcel1.writeLong(param2Long);
/* 578 */           parcel1.writeInt(param2Boolean);
/* 579 */           this.mRemote.transact(20, parcel1, parcel2, 0);
/* 580 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 583 */           parcel2.recycle();
/* 584 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getUserIdByEscrowTokenHandle(long param2Long) throws RemoteException {
/* 589 */         Parcel parcel2 = Parcel.obtain();
/* 590 */         Parcel parcel1 = Parcel.obtain();
/*     */ 
/*     */         
/* 593 */         try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/* 594 */           parcel2.writeLong(param2Long);
/* 595 */           this.mRemote.transact(21, parcel2, parcel1, 0);
/* 596 */           parcel1.readException();
/* 597 */           return parcel1.readInt(); }
/*     */         finally
/*     */         
/* 600 */         { parcel1.recycle();
/* 601 */           parcel2.recycle(); }  } } } private static class Proxy implements ICarTrustAgentBleService { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.trust.ICarTrustAgentBleService"; } public void registerBleCallback(ICarTrustAgentBleCallback param1ICarTrustAgentBleCallback) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService"); if (param1ICarTrustAgentBleCallback != null) { IBinder iBinder = param1ICarTrustAgentBleCallback.asBinder(); } else { param1ICarTrustAgentBleCallback = null; }  parcel2.writeStrongBinder((IBinder)param1ICarTrustAgentBleCallback); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public void unregisterBleCallback(ICarTrustAgentBleCallback param1ICarTrustAgentBleCallback) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService"); if (param1ICarTrustAgentBleCallback != null) { IBinder iBinder = param1ICarTrustAgentBleCallback.asBinder(); } else { param1ICarTrustAgentBleCallback = null; }  parcel2.writeStrongBinder((IBinder)param1ICarTrustAgentBleCallback); this.mRemote.transact(2, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public int getUserIdByEscrowTokenHandle(long param1Long) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService"); parcel2.writeLong(param1Long); this.mRemote.transact(21, parcel2, parcel1, 0); parcel1.readException(); return parcel1.readInt(); } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void startEnrolmentAdvertising() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void stopEnrolmentAdvertising() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void sendEnrolmentHandle(BluetoothDevice param1BluetoothDevice, long param1Long) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1BluetoothDevice != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1BluetoothDevice.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         parcel1.writeLong(param1Long);
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerEnrolmentCallback(ICarTrustAgentEnrolmentCallback param1ICarTrustAgentEnrolmentCallback) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1ICarTrustAgentEnrolmentCallback != null) {
/*     */           IBinder iBinder = param1ICarTrustAgentEnrolmentCallback.asBinder();
/*     */         } else {
/*     */           param1ICarTrustAgentEnrolmentCallback = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarTrustAgentEnrolmentCallback);
/*     */         this.mRemote.transact(6, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterEnrolmentCallback(ICarTrustAgentEnrolmentCallback param1ICarTrustAgentEnrolmentCallback) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1ICarTrustAgentEnrolmentCallback != null) {
/*     */           IBinder iBinder = param1ICarTrustAgentEnrolmentCallback.asBinder();
/*     */         } else {
/*     */           param1ICarTrustAgentEnrolmentCallback = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarTrustAgentEnrolmentCallback);
/*     */         this.mRemote.transact(7, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void startUnlockAdvertising() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         this.mRemote.transact(8, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void stopUnlockAdvertising() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         this.mRemote.transact(9, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerUnlockCallback(ICarTrustAgentUnlockCallback param1ICarTrustAgentUnlockCallback) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1ICarTrustAgentUnlockCallback != null) {
/*     */           IBinder iBinder = param1ICarTrustAgentUnlockCallback.asBinder();
/*     */         } else {
/*     */           param1ICarTrustAgentUnlockCallback = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarTrustAgentUnlockCallback);
/*     */         this.mRemote.transact(10, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterUnlockCallback(ICarTrustAgentUnlockCallback param1ICarTrustAgentUnlockCallback) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1ICarTrustAgentUnlockCallback != null) {
/*     */           IBinder iBinder = param1ICarTrustAgentUnlockCallback.asBinder();
/*     */         } else {
/*     */           param1ICarTrustAgentUnlockCallback = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarTrustAgentUnlockCallback);
/*     */         this.mRemote.transact(11, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setTokenRequestDelegate(ICarTrustAgentTokenRequestDelegate param1ICarTrustAgentTokenRequestDelegate) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1ICarTrustAgentTokenRequestDelegate != null) {
/*     */           IBinder iBinder = param1ICarTrustAgentTokenRequestDelegate.asBinder();
/*     */         } else {
/*     */           param1ICarTrustAgentTokenRequestDelegate = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarTrustAgentTokenRequestDelegate);
/*     */         this.mRemote.transact(12, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void revokeTrust() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         this.mRemote.transact(13, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void addEscrowToken(byte[] param1ArrayOfbyte, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         parcel2.writeByteArray(param1ArrayOfbyte);
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(14, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void removeEscrowToken(long param1Long, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         parcel1.writeLong(param1Long);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(15, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void isEscrowTokenActive(long param1Long, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         parcel1.writeLong(param1Long);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(16, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setTokenResponseCallback(ICarTrustAgentTokenResponseCallback param1ICarTrustAgentTokenResponseCallback) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         if (param1ICarTrustAgentTokenResponseCallback != null) {
/*     */           IBinder iBinder = param1ICarTrustAgentTokenResponseCallback.asBinder();
/*     */         } else {
/*     */           param1ICarTrustAgentTokenResponseCallback = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarTrustAgentTokenResponseCallback);
/*     */         this.mRemote.transact(17, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onEscrowTokenAdded(byte[] param1ArrayOfbyte, long param1Long, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         parcel1.writeByteArray(param1ArrayOfbyte);
/*     */         parcel1.writeLong(param1Long);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(18, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onEscrowTokenRemoved(long param1Long, boolean param1Boolean) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         parcel2.writeLong(param1Long);
/*     */         parcel2.writeInt(param1Boolean);
/*     */         this.mRemote.transact(19, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onEscrowTokenActiveStateChanged(long param1Long, boolean param1Boolean) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentBleService");
/*     */         parcel1.writeLong(param1Long);
/*     */         parcel1.writeInt(param1Boolean);
/*     */         this.mRemote.transact(20, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\trust\ICarTrustAgentBleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */