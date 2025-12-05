/*     */ package android.car.media;public interface ICarAudio extends IInterface { CarAudioPatchHandle createAudioPatch(String paramString, int paramInt1, int paramInt2) throws RemoteException;
/*     */   int getCurrentStreamType() throws RemoteException;
/*     */   String[] getExternalSources() throws RemoteException;
/*     */   int getGroupMaxVolume(int paramInt) throws RemoteException;
/*     */   int getGroupMinVolume(int paramInt) throws RemoteException;
/*     */   int getGroupVolume(int paramInt) throws RemoteException;
/*     */   int[] getUsagesForVolumeGroupId(int paramInt) throws RemoteException;
/*     */   int getVolumeGroupCount() throws RemoteException;
/*     */   int getVolumeGroupIdForUsage(int paramInt) throws RemoteException;
/*     */   void registerVolumeCallback(IBinder paramIBinder) throws RemoteException;
/*     */   void releaseAudioPatch(CarAudioPatchHandle paramCarAudioPatchHandle) throws RemoteException;
/*     */   void setBalanceTowardRight(float paramFloat) throws RemoteException;
/*     */   void setFadeTowardFront(float paramFloat) throws RemoteException;
/*     */   void setGroupVolume(int paramInt1, int paramInt2, int paramInt3) throws RemoteException;
/*     */   void unregisterVolumeCallback(IBinder paramIBinder) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements ICarAudio { private static final String DESCRIPTOR = "android.car.media.ICarAudio"; static final int TRANSACTION_createAudioPatch = 8; static final int TRANSACTION_getCurrentStreamType = 15; static final int TRANSACTION_getExternalSources = 7; static final int TRANSACTION_getGroupMaxVolume = 2; static final int TRANSACTION_getGroupMinVolume = 3; static final int TRANSACTION_getGroupVolume = 4; static final int TRANSACTION_getUsagesForVolumeGroupId = 12; static final int TRANSACTION_getVolumeGroupCount = 10; static final int TRANSACTION_getVolumeGroupIdForUsage = 11; static final int TRANSACTION_registerVolumeCallback = 13; static final int TRANSACTION_releaseAudioPatch = 9; static final int TRANSACTION_setBalanceTowardRight = 6; static final int TRANSACTION_setFadeTowardFront = 5;
/*     */     static final int TRANSACTION_setGroupVolume = 1;
/*     */     static final int TRANSACTION_unregisterVolumeCallback = 14;
/*     */     
/*     */     public Stub() {
/*  21 */       attachInterface(this, "android.car.media.ICarAudio");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarAudio asInterface(IBinder param1IBinder) {
/*  29 */       if (param1IBinder == null) {
/*  30 */         return null;
/*     */       }
/*  32 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.media.ICarAudio");
/*  33 */       if (iInterface != null && iInterface instanceof ICarAudio) {
/*  34 */         return (ICarAudio)iInterface;
/*     */       }
/*  36 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  40 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  45 */       if (param1Int1 != 1598968902) { IBinder iBinder; int[] arrayOfInt; CarAudioPatchHandle carAudioPatchHandle; String[] arrayOfString; float f; String str; switch (param1Int1)
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
/*     */           default:
/* 211 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);case 15: param1Parcel1.enforceInterface("android.car.media.ICarAudio"); param1Int1 = getCurrentStreamType(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 14: param1Parcel1.enforceInterface("android.car.media.ICarAudio"); iBinder = param1Parcel1.readStrongBinder(); unregisterVolumeCallback(iBinder); param1Parcel2.writeNoException(); return true;case 13: iBinder.enforceInterface("android.car.media.ICarAudio"); iBinder = iBinder.readStrongBinder(); registerVolumeCallback(iBinder); param1Parcel2.writeNoException(); return true;case 12: iBinder.enforceInterface("android.car.media.ICarAudio"); param1Int1 = iBinder.readInt(); arrayOfInt = getUsagesForVolumeGroupId(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeIntArray(arrayOfInt); return true;case 11: arrayOfInt.enforceInterface("android.car.media.ICarAudio"); param1Int1 = arrayOfInt.readInt(); param1Int1 = getVolumeGroupIdForUsage(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 10: arrayOfInt.enforceInterface("android.car.media.ICarAudio"); param1Int1 = getVolumeGroupCount(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 9: arrayOfInt.enforceInterface("android.car.media.ICarAudio"); if (arrayOfInt.readInt() != 0) { CarAudioPatchHandle carAudioPatchHandle1 = (CarAudioPatchHandle)CarAudioPatchHandle.CREATOR.createFromParcel((Parcel)arrayOfInt); } else { arrayOfInt = null; }  releaseAudioPatch((CarAudioPatchHandle)arrayOfInt); param1Parcel2.writeNoException(); return true;
/*     */           case 8: arrayOfInt.enforceInterface("android.car.media.ICarAudio"); str = arrayOfInt.readString(); param1Int2 = arrayOfInt.readInt(); param1Int1 = arrayOfInt.readInt(); carAudioPatchHandle = createAudioPatch(str, param1Int2, param1Int1); param1Parcel2.writeNoException(); if (carAudioPatchHandle != null) { param1Parcel2.writeInt(1); carAudioPatchHandle.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 7: carAudioPatchHandle.enforceInterface("android.car.media.ICarAudio"); arrayOfString = getExternalSources(); param1Parcel2.writeNoException(); param1Parcel2.writeStringArray(arrayOfString); return true;
/*     */           case 6: arrayOfString.enforceInterface("android.car.media.ICarAudio"); f = arrayOfString.readFloat(); setBalanceTowardRight(f); param1Parcel2.writeNoException(); return true;
/*     */           case 5: arrayOfString.enforceInterface("android.car.media.ICarAudio"); f = arrayOfString.readFloat(); setFadeTowardFront(f); param1Parcel2.writeNoException(); return true;
/*     */           case 4: arrayOfString.enforceInterface("android.car.media.ICarAudio"); param1Int1 = arrayOfString.readInt(); param1Int1 = getGroupVolume(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 3: arrayOfString.enforceInterface("android.car.media.ICarAudio"); param1Int1 = arrayOfString.readInt(); param1Int1 = getGroupMinVolume(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 2: arrayOfString.enforceInterface("android.car.media.ICarAudio"); param1Int1 = arrayOfString.readInt(); param1Int1 = getGroupMaxVolume(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/* 220 */           case 1: break; }  arrayOfString.enforceInterface("android.car.media.ICarAudio"); int i = arrayOfString.readInt(); param1Int1 = arrayOfString.readInt(); param1Int2 = arrayOfString.readInt(); setGroupVolume(i, param1Int1, param1Int2); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.media.ICarAudio"); return true; } private static class Proxy implements ICarAudio { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 224 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 228 */         return "android.car.media.ICarAudio";
/*     */       }
/*     */       
/*     */       public void setGroupVolume(int param2Int1, int param2Int2, int param2Int3) throws RemoteException {
/* 232 */         Parcel parcel2 = Parcel.obtain();
/* 233 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 235 */           parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 236 */           parcel2.writeInt(param2Int1);
/* 237 */           parcel2.writeInt(param2Int2);
/* 238 */           parcel2.writeInt(param2Int3);
/* 239 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 240 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 243 */           parcel1.recycle();
/* 244 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getGroupMaxVolume(int param2Int) throws RemoteException {
/* 249 */         Parcel parcel2 = Parcel.obtain();
/* 250 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 253 */           parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 254 */           parcel2.writeInt(param2Int);
/* 255 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 256 */           parcel1.readException();
/* 257 */           param2Int = parcel1.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 263 */           return param2Int;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 267 */         }  } public int getGroupMinVolume(int param2Int) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 268 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 271 */           parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 272 */           parcel2.writeInt(param2Int);
/* 273 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 274 */           parcel1.readException();
/* 275 */           param2Int = parcel1.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 281 */           return param2Int;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 285 */         }  } public int getGroupVolume(int param2Int) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 286 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 289 */           parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 290 */           parcel2.writeInt(param2Int);
/* 291 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 292 */           parcel1.readException();
/* 293 */           param2Int = parcel1.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 299 */           return param2Int;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 303 */         }  } public void setFadeTowardFront(float param2Float) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 304 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 306 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 307 */           parcel1.writeFloat(param2Float);
/* 308 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 309 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 312 */           parcel2.recycle();
/* 313 */           parcel1.recycle();
/*     */         }  }
/*     */ 
/*     */       
/*     */       public void setBalanceTowardRight(float param2Float) throws RemoteException {
/* 318 */         Parcel parcel2 = Parcel.obtain();
/* 319 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 321 */           parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 322 */           parcel2.writeFloat(param2Float);
/* 323 */           this.mRemote.transact(6, parcel2, parcel1, 0);
/* 324 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 327 */           parcel1.recycle();
/* 328 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public String[] getExternalSources() throws RemoteException {
/* 333 */         Parcel parcel1 = Parcel.obtain();
/* 334 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 337 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 338 */           this.mRemote.transact(7, parcel1, parcel2, 0);
/* 339 */           parcel2.readException();
/* 340 */           return parcel2.createStringArray();
/*     */         } finally {
/*     */           
/* 343 */           parcel2.recycle();
/* 344 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public CarAudioPatchHandle createAudioPatch(String param2String, int param2Int1, int param2Int2) throws RemoteException
/*     */       {
/* 350 */         Parcel parcel1 = Parcel.obtain();
/* 351 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 354 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 355 */           parcel1.writeString(param2String);
/* 356 */           parcel1.writeInt(param2Int1);
/* 357 */           parcel1.writeInt(param2Int2);
/* 358 */           this.mRemote.transact(8, parcel1, parcel2, 0);
/* 359 */           parcel2.readException();
/* 360 */           if (parcel2.readInt() != 0) {
/* 361 */             CarAudioPatchHandle carAudioPatchHandle = (CarAudioPatchHandle)CarAudioPatchHandle.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 364 */             param2String = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 371 */           return (CarAudioPatchHandle)param2String;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 375 */         }  } public void releaseAudioPatch(CarAudioPatchHandle param2CarAudioPatchHandle) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 376 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 378 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 379 */           if (param2CarAudioPatchHandle != null) {
/* 380 */             parcel1.writeInt(1);
/* 381 */             param2CarAudioPatchHandle.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 384 */             parcel1.writeInt(0);
/*     */           } 
/* 386 */           this.mRemote.transact(9, parcel1, parcel2, 0);
/* 387 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 390 */           parcel2.recycle();
/* 391 */           parcel1.recycle();
/*     */         }  }
/*     */ 
/*     */       
/*     */       public int getVolumeGroupCount() throws RemoteException {
/* 396 */         Parcel parcel1 = Parcel.obtain();
/* 397 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 400 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 401 */           this.mRemote.transact(10, parcel1, parcel2, 0);
/* 402 */           parcel2.readException();
/* 403 */           return parcel2.readInt();
/*     */         } finally {
/*     */           
/* 406 */           parcel2.recycle();
/* 407 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getVolumeGroupIdForUsage(int param2Int) throws RemoteException
/*     */       {
/* 413 */         Parcel parcel1 = Parcel.obtain();
/* 414 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 417 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 418 */           parcel1.writeInt(param2Int);
/* 419 */           this.mRemote.transact(11, parcel1, parcel2, 0);
/* 420 */           parcel2.readException();
/* 421 */           param2Int = parcel2.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 427 */           return param2Int;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 431 */         }  } public int[] getUsagesForVolumeGroupId(int param2Int) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 432 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 435 */           parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 436 */           parcel2.writeInt(param2Int);
/* 437 */           this.mRemote.transact(12, parcel2, parcel1, 0);
/* 438 */           parcel1.readException();
/* 439 */           return parcel1.createIntArray();
/*     */         } finally {
/*     */           
/* 442 */           parcel1.recycle();
/* 443 */           parcel2.recycle();
/*     */         }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void registerVolumeCallback(IBinder param2IBinder) throws RemoteException {
/* 452 */         Parcel parcel1 = Parcel.obtain();
/* 453 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 455 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 456 */           parcel1.writeStrongBinder(param2IBinder);
/* 457 */           this.mRemote.transact(13, parcel1, parcel2, 0);
/* 458 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 461 */           parcel2.recycle();
/* 462 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterVolumeCallback(IBinder param2IBinder) throws RemoteException {
/* 467 */         Parcel parcel1 = Parcel.obtain();
/* 468 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 470 */           parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/* 471 */           parcel1.writeStrongBinder(param2IBinder);
/* 472 */           this.mRemote.transact(14, parcel1, parcel2, 0);
/* 473 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 476 */           parcel2.recycle();
/* 477 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getCurrentStreamType() throws RemoteException {
/* 482 */         Parcel parcel2 = Parcel.obtain();
/* 483 */         Parcel parcel1 = Parcel.obtain();
/*     */ 
/*     */         
/* 486 */         try { parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/* 487 */           this.mRemote.transact(15, parcel2, parcel1, 0);
/* 488 */           parcel1.readException();
/* 489 */           return parcel1.readInt(); }
/*     */         finally
/*     */         
/* 492 */         { parcel1.recycle();
/* 493 */           parcel2.recycle(); }  } } } private static class Proxy implements ICarAudio { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.media.ICarAudio"; } public void setGroupVolume(int param1Int1, int param1Int2, int param1Int3) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.media.ICarAudio"); parcel2.writeInt(param1Int1); parcel2.writeInt(param1Int2); parcel2.writeInt(param1Int3); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public int getGroupMaxVolume(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.media.ICarAudio"); parcel2.writeInt(param1Int); this.mRemote.transact(2, parcel2, parcel1, 0); parcel1.readException(); param1Int = parcel1.readInt(); return param1Int; } finally { parcel1.recycle(); parcel2.recycle(); }  } public int getGroupMinVolume(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.media.ICarAudio"); parcel2.writeInt(param1Int); this.mRemote.transact(3, parcel2, parcel1, 0); parcel1.readException(); param1Int = parcel1.readInt(); return param1Int; } finally { parcel1.recycle(); parcel2.recycle(); }  } public int getGroupVolume(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.media.ICarAudio"); parcel2.writeInt(param1Int); this.mRemote.transact(4, parcel2, parcel1, 0); parcel1.readException(); param1Int = parcel1.readInt(); return param1Int; } finally { parcel1.recycle(); parcel2.recycle(); }  } public void setFadeTowardFront(float param1Float) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.media.ICarAudio"); parcel1.writeFloat(param1Float); this.mRemote.transact(5, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }  } public int getCurrentStreamType() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.media.ICarAudio"); this.mRemote.transact(15, parcel2, parcel1, 0); parcel1.readException(); return parcel1.readInt(); } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void setBalanceTowardRight(float param1Float) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         parcel2.writeFloat(param1Float);
/*     */         this.mRemote.transact(6, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String[] getExternalSources() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         this.mRemote.transact(7, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.createStringArray();
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public CarAudioPatchHandle createAudioPatch(String param1String, int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         parcel1.writeString(param1String);
/*     */         parcel1.writeInt(param1Int1);
/*     */         parcel1.writeInt(param1Int2);
/*     */         this.mRemote.transact(8, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           CarAudioPatchHandle carAudioPatchHandle = (CarAudioPatchHandle)CarAudioPatchHandle.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           param1String = null;
/*     */         } 
/*     */         return (CarAudioPatchHandle)param1String;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void releaseAudioPatch(CarAudioPatchHandle param1CarAudioPatchHandle) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         if (param1CarAudioPatchHandle != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1CarAudioPatchHandle.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(9, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getVolumeGroupCount() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         this.mRemote.transact(10, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.readInt();
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getVolumeGroupIdForUsage(int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(11, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         param1Int = parcel2.readInt();
/*     */         return param1Int;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int[] getUsagesForVolumeGroupId(int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(12, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.createIntArray();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerVolumeCallback(IBinder param1IBinder) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         parcel1.writeStrongBinder(param1IBinder);
/*     */         this.mRemote.transact(13, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterVolumeCallback(IBinder param1IBinder) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.media.ICarAudio");
/*     */         parcel1.writeStrongBinder(param1IBinder);
/*     */         this.mRemote.transact(14, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\media\ICarAudio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */