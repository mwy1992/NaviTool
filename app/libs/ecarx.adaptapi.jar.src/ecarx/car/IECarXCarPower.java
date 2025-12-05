/*      */ package ecarx.car;public interface IECarXCarPower extends IInterface { void closeBootUpAnimation() throws RemoteException; int getAutoDayNightMode() throws RemoteException; int getBrightnessDayNightMode() throws RemoteException; int getBrightnessMode() throws RemoteException; int getCSDBrightness() throws RemoteException; int getCSDDayBrightness() throws RemoteException; int getCSDNightBrightness() throws RemoteException; int getCSDstatus() throws RemoteException; float getCustomDayTime() throws RemoteException; float getCustomNightTime() throws RemoteException; int getEntertainmentMode() throws RemoteException; int getInfotainmentMode() throws RemoteException; int getModemStatus() throws RemoteException; int getPSDBrightness() throws RemoteException; int getPSDDayBrightness() throws RemoteException; int getPSDNightBrightness() throws RemoteException; int getPopES() throws RemoteException; int getPopSD() throws RemoteException; int getRealDayNightMode() throws RemoteException; int getRealDayNightTheme() throws RemoteException; int getResetSettingsResponse() throws RemoteException; String getScreenSaverName() throws RemoteException; int getScreenSaverStyle() throws RemoteException; int getThemeDayNightMode() throws RemoteException; int getVehicleBrightness() throws RemoteException; void onPowerSoftKeyEvent(int paramInt) throws RemoteException; void registerCallBack(int paramInt, IPowerStatusListener paramIPowerStatusListener) throws RemoteException; void registerPowerCallBack(IPowerStatusListener paramIPowerStatusListener) throws RemoteException; void setAPUpdate(int paramInt) throws RemoteException; void setBrightnessDayNightMode(int paramInt) throws RemoteException;
/*      */   void setBrightnessMode(int paramInt) throws RemoteException;
/*      */   void setCSDBrightness(int paramInt1, int paramInt2) throws RemoteException;
/*      */   void setCustomDayTime(float paramFloat) throws RemoteException;
/*      */   void setCustomNightTime(float paramFloat) throws RemoteException;
/*      */   void setPSDBrightness(int paramInt1, int paramInt2) throws RemoteException;
/*      */   void setResetSettingsRequest(int paramInt) throws RemoteException;
/*      */   void setScreenSaverName(String paramString) throws RemoteException;
/*      */   void setScreenSaverStyle(int paramInt) throws RemoteException;
/*      */   void setThemeDayNightMode(int paramInt) throws RemoteException;
/*      */   void setVehicleBrightness(int paramInt) throws RemoteException;
/*      */   void unregisterCallBack(int paramInt, IPowerStatusListener paramIPowerStatusListener) throws RemoteException;
/*      */   void unregisterPowerCallBack(IPowerStatusListener paramIPowerStatusListener) throws RemoteException;
/*      */   public static abstract class Stub extends Binder implements IECarXCarPower { private static final String DESCRIPTOR = "ecarx.car.IECarXCarPower"; static final int TRANSACTION_closeBootUpAnimation = 3; static final int TRANSACTION_getAutoDayNightMode = 29; static final int TRANSACTION_getBrightnessDayNightMode = 19; static final int TRANSACTION_getBrightnessMode = 23; static final int TRANSACTION_getCSDBrightness = 25; static final int TRANSACTION_getCSDDayBrightness = 30; static final int TRANSACTION_getCSDNightBrightness = 31; static final int TRANSACTION_getCSDstatus = 10; static final int TRANSACTION_getCustomDayTime = 36; static final int TRANSACTION_getCustomNightTime = 38; static final int TRANSACTION_getEntertainmentMode = 8; static final int TRANSACTION_getInfotainmentMode = 4; static final int TRANSACTION_getModemStatus = 5; static final int TRANSACTION_getPSDBrightness = 27; static final int TRANSACTION_getPSDDayBrightness = 32; static final int TRANSACTION_getPSDNightBrightness = 33; static final int TRANSACTION_getPopES = 6; static final int TRANSACTION_getPopSD = 7; static final int TRANSACTION_getRealDayNightMode = 28; static final int TRANSACTION_getRealDayNightTheme = 34; static final int TRANSACTION_getResetSettingsResponse = 9; static final int TRANSACTION_getScreenSaverName = 42; static final int TRANSACTION_getScreenSaverStyle = 40; static final int TRANSACTION_getThemeDayNightMode = 17; static final int TRANSACTION_getVehicleBrightness = 21; static final int TRANSACTION_onPowerSoftKeyEvent = 13; static final int TRANSACTION_registerCallBack = 11; static final int TRANSACTION_registerPowerCallBack = 14; static final int TRANSACTION_setAPUpdate = 2; static final int TRANSACTION_setBrightnessDayNightMode = 18; static final int TRANSACTION_setBrightnessMode = 22; static final int TRANSACTION_setCSDBrightness = 24; static final int TRANSACTION_setCustomDayTime = 35; static final int TRANSACTION_setCustomNightTime = 37; static final int TRANSACTION_setPSDBrightness = 26; static final int TRANSACTION_setResetSettingsRequest = 1; static final int TRANSACTION_setScreenSaverName = 41; static final int TRANSACTION_setScreenSaverStyle = 39; static final int TRANSACTION_setThemeDayNightMode = 16; static final int TRANSACTION_setVehicleBrightness = 20; static final int TRANSACTION_unregisterCallBack = 12; static final int TRANSACTION_unregisterPowerCallBack = 15;
/*      */     public Stub() {
/*   16 */       attachInterface(this, "ecarx.car.IECarXCarPower");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static IECarXCarPower asInterface(IBinder param1IBinder) {
/*   24 */       if (param1IBinder == null) {
/*   25 */         return null;
/*      */       }
/*   27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IECarXCarPower");
/*   28 */       if (iInterface != null && iInterface instanceof IECarXCarPower) {
/*   29 */         return (IECarXCarPower)iInterface;
/*      */       }
/*   31 */       return new Proxy(param1IBinder);
/*      */     }
/*      */     
/*      */     public IBinder asBinder() {
/*   35 */       return (IBinder)this;
/*      */     }
/*      */     
/*      */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*      */     {
/*   40 */       if (param1Int1 != 1598968902) { String str; IPowerStatusListener iPowerStatusListener; float f; switch (param1Int1)
/*      */         
/*      */         { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           default:
/*  409 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);case 42: param1Parcel1.enforceInterface("ecarx.car.IECarXCarPower"); str = getScreenSaverName(); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;case 41: str.enforceInterface("ecarx.car.IECarXCarPower"); str = str.readString(); setScreenSaverName(str); param1Parcel2.writeNoException(); return true;case 40: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getScreenSaverStyle(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 39: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = str.readInt(); setScreenSaverStyle(param1Int1); param1Parcel2.writeNoException(); return true;case 38: str.enforceInterface("ecarx.car.IECarXCarPower"); f = getCustomNightTime(); param1Parcel2.writeNoException(); param1Parcel2.writeFloat(f); return true;case 37: str.enforceInterface("ecarx.car.IECarXCarPower"); f = str.readFloat(); setCustomNightTime(f); param1Parcel2.writeNoException(); return true;case 36: str.enforceInterface("ecarx.car.IECarXCarPower"); f = getCustomDayTime(); param1Parcel2.writeNoException(); param1Parcel2.writeFloat(f); return true;case 35: str.enforceInterface("ecarx.car.IECarXCarPower"); f = str.readFloat(); setCustomDayTime(f); param1Parcel2.writeNoException(); return true;case 34: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getRealDayNightTheme(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 33: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getPSDNightBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 32: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getPSDDayBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 31: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getCSDNightBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 30: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getCSDDayBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 29: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getAutoDayNightMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 28: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getRealDayNightMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 27: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getPSDBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 26: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = str.readInt(); param1Int2 = str.readInt(); setPSDBrightness(param1Int1, param1Int2); param1Parcel2.writeNoException(); return true;case 25: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getCSDBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 24: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int2 = str.readInt(); param1Int1 = str.readInt(); setCSDBrightness(param1Int2, param1Int1); param1Parcel2.writeNoException(); return true;case 23: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getBrightnessMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 22: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = str.readInt(); setBrightnessMode(param1Int1); param1Parcel2.writeNoException(); return true;case 21: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getVehicleBrightness(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 20: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = str.readInt(); setVehicleBrightness(param1Int1); param1Parcel2.writeNoException(); return true;case 19: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getBrightnessDayNightMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 18: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = str.readInt(); setBrightnessDayNightMode(param1Int1); param1Parcel2.writeNoException(); return true;case 17: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getThemeDayNightMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;case 16: str.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = str.readInt(); setThemeDayNightMode(param1Int1); param1Parcel2.writeNoException(); return true;case 15: str.enforceInterface("ecarx.car.IECarXCarPower"); iPowerStatusListener = IPowerStatusListener.Stub.asInterface(str.readStrongBinder()); unregisterPowerCallBack(iPowerStatusListener); param1Parcel2.writeNoException(); return true;case 14: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); iPowerStatusListener = IPowerStatusListener.Stub.asInterface(iPowerStatusListener.readStrongBinder()); registerPowerCallBack(iPowerStatusListener); param1Parcel2.writeNoException(); return true;case 13: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = iPowerStatusListener.readInt(); onPowerSoftKeyEvent(param1Int1); param1Parcel2.writeNoException(); return true;case 12: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = iPowerStatusListener.readInt(); iPowerStatusListener = IPowerStatusListener.Stub.asInterface(iPowerStatusListener.readStrongBinder()); unregisterCallBack(param1Int1, iPowerStatusListener); param1Parcel2.writeNoException(); return true;case 11: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = iPowerStatusListener.readInt(); iPowerStatusListener = IPowerStatusListener.Stub.asInterface(iPowerStatusListener.readStrongBinder()); registerCallBack(param1Int1, iPowerStatusListener); param1Parcel2.writeNoException(); return true;case 10: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getCSDstatus(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 9: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getResetSettingsResponse(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 8: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getEntertainmentMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 7: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getPopSD(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 6: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getPopES(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 5: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getModemStatus(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 4: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = getInfotainmentMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*      */           case 3: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); closeBootUpAnimation(); param1Parcel2.writeNoException(); return true;
/*      */           case 2: iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = iPowerStatusListener.readInt(); setAPUpdate(param1Int1); param1Parcel2.writeNoException(); return true;
/*  418 */           case 1: break; }  iPowerStatusListener.enforceInterface("ecarx.car.IECarXCarPower"); param1Int1 = iPowerStatusListener.readInt(); setResetSettingsRequest(param1Int1); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("ecarx.car.IECarXCarPower"); return true; } private static class Proxy implements IECarXCarPower { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*      */       
/*      */       private IBinder mRemote;
/*      */       public IBinder asBinder() {
/*  422 */         return this.mRemote;
/*      */       }
/*      */       
/*      */       public String getInterfaceDescriptor() {
/*  426 */         return "ecarx.car.IECarXCarPower";
/*      */       }
/*      */       
/*      */       public void setResetSettingsRequest(int param2Int) throws RemoteException {
/*  430 */         Parcel parcel2 = Parcel.obtain();
/*  431 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/*  433 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  434 */           parcel2.writeInt(param2Int);
/*  435 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/*  436 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/*  439 */           parcel1.recycle();
/*  440 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public void setAPUpdate(int param2Int) throws RemoteException {
/*  445 */         Parcel parcel2 = Parcel.obtain();
/*  446 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/*  448 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  449 */           parcel2.writeInt(param2Int);
/*  450 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/*  451 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/*  454 */           parcel1.recycle();
/*  455 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public void closeBootUpAnimation() throws RemoteException {
/*  460 */         Parcel parcel1 = Parcel.obtain();
/*  461 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  463 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  464 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/*  465 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  468 */           parcel2.recycle();
/*  469 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getInfotainmentMode() throws RemoteException {
/*  474 */         Parcel parcel2 = Parcel.obtain();
/*  475 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  478 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  479 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/*  480 */           parcel1.readException();
/*  481 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  484 */           parcel1.recycle();
/*  485 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getModemStatus() throws RemoteException {
/*  491 */         Parcel parcel2 = Parcel.obtain();
/*  492 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  495 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  496 */           this.mRemote.transact(5, parcel2, parcel1, 0);
/*  497 */           parcel1.readException();
/*  498 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  501 */           parcel1.recycle();
/*  502 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getPopES() throws RemoteException {
/*  508 */         Parcel parcel1 = Parcel.obtain();
/*  509 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  512 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  513 */           this.mRemote.transact(6, parcel1, parcel2, 0);
/*  514 */           parcel2.readException();
/*  515 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  518 */           parcel2.recycle();
/*  519 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getPopSD() throws RemoteException {
/*  525 */         Parcel parcel2 = Parcel.obtain();
/*  526 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  529 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  530 */           this.mRemote.transact(7, parcel2, parcel1, 0);
/*  531 */           parcel1.readException();
/*  532 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  535 */           parcel1.recycle();
/*  536 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getEntertainmentMode() throws RemoteException {
/*  542 */         Parcel parcel1 = Parcel.obtain();
/*  543 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  546 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  547 */           this.mRemote.transact(8, parcel1, parcel2, 0);
/*  548 */           parcel2.readException();
/*  549 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  552 */           parcel2.recycle();
/*  553 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getResetSettingsResponse() throws RemoteException {
/*  559 */         Parcel parcel2 = Parcel.obtain();
/*  560 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  563 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  564 */           this.mRemote.transact(9, parcel2, parcel1, 0);
/*  565 */           parcel1.readException();
/*  566 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  569 */           parcel1.recycle();
/*  570 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getCSDstatus() throws RemoteException {
/*  576 */         Parcel parcel1 = Parcel.obtain();
/*  577 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  580 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  581 */           this.mRemote.transact(10, parcel1, parcel2, 0);
/*  582 */           parcel2.readException();
/*  583 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  586 */           parcel2.recycle();
/*  587 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public void registerCallBack(int param2Int, IPowerStatusListener param2IPowerStatusListener) throws RemoteException {
/*  593 */         Parcel parcel1 = Parcel.obtain();
/*  594 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  596 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  597 */           parcel1.writeInt(param2Int);
/*  598 */           if (param2IPowerStatusListener != null) { IBinder iBinder = param2IPowerStatusListener.asBinder(); } else { param2IPowerStatusListener = null; }  parcel1.writeStrongBinder((IBinder)param2IPowerStatusListener);
/*  599 */           this.mRemote.transact(11, parcel1, parcel2, 0);
/*  600 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  603 */           parcel2.recycle();
/*  604 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public void unregisterCallBack(int param2Int, IPowerStatusListener param2IPowerStatusListener) throws RemoteException {
/*  609 */         Parcel parcel1 = Parcel.obtain();
/*  610 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  612 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  613 */           parcel1.writeInt(param2Int);
/*  614 */           if (param2IPowerStatusListener != null) { IBinder iBinder = param2IPowerStatusListener.asBinder(); } else { param2IPowerStatusListener = null; }  parcel1.writeStrongBinder((IBinder)param2IPowerStatusListener);
/*  615 */           this.mRemote.transact(12, parcel1, parcel2, 0);
/*  616 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  619 */           parcel2.recycle();
/*  620 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public void onPowerSoftKeyEvent(int param2Int) throws RemoteException {
/*  625 */         Parcel parcel1 = Parcel.obtain();
/*  626 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  628 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  629 */           parcel1.writeInt(param2Int);
/*  630 */           this.mRemote.transact(13, parcel1, parcel2, 0);
/*  631 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  634 */           parcel2.recycle();
/*  635 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public void registerPowerCallBack(IPowerStatusListener param2IPowerStatusListener) throws RemoteException {
/*  640 */         Parcel parcel2 = Parcel.obtain();
/*  641 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/*  643 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  644 */           if (param2IPowerStatusListener != null) { IBinder iBinder = param2IPowerStatusListener.asBinder(); } else { param2IPowerStatusListener = null; }  parcel2.writeStrongBinder((IBinder)param2IPowerStatusListener);
/*  645 */           this.mRemote.transact(14, parcel2, parcel1, 0);
/*  646 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/*  649 */           parcel1.recycle();
/*  650 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public void unregisterPowerCallBack(IPowerStatusListener param2IPowerStatusListener) throws RemoteException {
/*  655 */         Parcel parcel1 = Parcel.obtain();
/*  656 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  658 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  659 */           if (param2IPowerStatusListener != null) { IBinder iBinder = param2IPowerStatusListener.asBinder(); } else { param2IPowerStatusListener = null; }  parcel1.writeStrongBinder((IBinder)param2IPowerStatusListener);
/*  660 */           this.mRemote.transact(15, parcel1, parcel2, 0);
/*  661 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  664 */           parcel2.recycle();
/*  665 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void setThemeDayNightMode(int param2Int) throws RemoteException {
/*  672 */         Parcel parcel1 = Parcel.obtain();
/*  673 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  675 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  676 */           parcel1.writeInt(param2Int);
/*  677 */           this.mRemote.transact(16, parcel1, parcel2, 0);
/*  678 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  681 */           parcel2.recycle();
/*  682 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getThemeDayNightMode() throws RemoteException {
/*  687 */         Parcel parcel1 = Parcel.obtain();
/*  688 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  691 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  692 */           this.mRemote.transact(17, parcel1, parcel2, 0);
/*  693 */           parcel2.readException();
/*  694 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  697 */           parcel2.recycle();
/*  698 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void setBrightnessDayNightMode(int param2Int) throws RemoteException {
/*  706 */         Parcel parcel1 = Parcel.obtain();
/*  707 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  709 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  710 */           parcel1.writeInt(param2Int);
/*  711 */           this.mRemote.transact(18, parcel1, parcel2, 0);
/*  712 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  715 */           parcel2.recycle();
/*  716 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getBrightnessDayNightMode() throws RemoteException {
/*  721 */         Parcel parcel1 = Parcel.obtain();
/*  722 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  725 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  726 */           this.mRemote.transact(19, parcel1, parcel2, 0);
/*  727 */           parcel2.readException();
/*  728 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  731 */           parcel2.recycle();
/*  732 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public void setVehicleBrightness(int param2Int) throws RemoteException {
/*  738 */         Parcel parcel1 = Parcel.obtain();
/*  739 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  741 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  742 */           parcel1.writeInt(param2Int);
/*  743 */           this.mRemote.transact(20, parcel1, parcel2, 0);
/*  744 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  747 */           parcel2.recycle();
/*  748 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getVehicleBrightness() throws RemoteException {
/*  753 */         Parcel parcel1 = Parcel.obtain();
/*  754 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  757 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  758 */           this.mRemote.transact(21, parcel1, parcel2, 0);
/*  759 */           parcel2.readException();
/*  760 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  763 */           parcel2.recycle();
/*  764 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public void setBrightnessMode(int param2Int) throws RemoteException {
/*  770 */         Parcel parcel1 = Parcel.obtain();
/*  771 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/*  773 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  774 */           parcel1.writeInt(param2Int);
/*  775 */           this.mRemote.transact(22, parcel1, parcel2, 0);
/*  776 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/*  779 */           parcel2.recycle();
/*  780 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getBrightnessMode() throws RemoteException {
/*  785 */         Parcel parcel2 = Parcel.obtain();
/*  786 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  789 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  790 */           this.mRemote.transact(23, parcel2, parcel1, 0);
/*  791 */           parcel1.readException();
/*  792 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  795 */           parcel1.recycle();
/*  796 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public void setCSDBrightness(int param2Int1, int param2Int2) throws RemoteException {
/*  802 */         Parcel parcel2 = Parcel.obtain();
/*  803 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/*  805 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  806 */           parcel2.writeInt(param2Int1);
/*  807 */           parcel2.writeInt(param2Int2);
/*  808 */           this.mRemote.transact(24, parcel2, parcel1, 0);
/*  809 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/*  812 */           parcel1.recycle();
/*  813 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getCSDBrightness() throws RemoteException {
/*  818 */         Parcel parcel2 = Parcel.obtain();
/*  819 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  822 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  823 */           this.mRemote.transact(25, parcel2, parcel1, 0);
/*  824 */           parcel1.readException();
/*  825 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  828 */           parcel1.recycle();
/*  829 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public void setPSDBrightness(int param2Int1, int param2Int2) throws RemoteException {
/*  835 */         Parcel parcel2 = Parcel.obtain();
/*  836 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/*  838 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  839 */           parcel2.writeInt(param2Int1);
/*  840 */           parcel2.writeInt(param2Int2);
/*  841 */           this.mRemote.transact(26, parcel2, parcel1, 0);
/*  842 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/*  845 */           parcel1.recycle();
/*  846 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getPSDBrightness() throws RemoteException {
/*  851 */         Parcel parcel2 = Parcel.obtain();
/*  852 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  855 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  856 */           this.mRemote.transact(27, parcel2, parcel1, 0);
/*  857 */           parcel1.readException();
/*  858 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  861 */           parcel1.recycle();
/*  862 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getRealDayNightMode() throws RemoteException {
/*  868 */         Parcel parcel1 = Parcel.obtain();
/*  869 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  872 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  873 */           this.mRemote.transact(28, parcel1, parcel2, 0);
/*  874 */           parcel2.readException();
/*  875 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  878 */           parcel2.recycle();
/*  879 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getAutoDayNightMode() throws RemoteException {
/*  885 */         Parcel parcel1 = Parcel.obtain();
/*  886 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  889 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  890 */           this.mRemote.transact(29, parcel1, parcel2, 0);
/*  891 */           parcel2.readException();
/*  892 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  895 */           parcel2.recycle();
/*  896 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getCSDDayBrightness() throws RemoteException {
/*  902 */         Parcel parcel1 = Parcel.obtain();
/*  903 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  906 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  907 */           this.mRemote.transact(30, parcel1, parcel2, 0);
/*  908 */           parcel2.readException();
/*  909 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  912 */           parcel2.recycle();
/*  913 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getCSDNightBrightness() throws RemoteException {
/*  919 */         Parcel parcel2 = Parcel.obtain();
/*  920 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  923 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  924 */           this.mRemote.transact(31, parcel2, parcel1, 0);
/*  925 */           parcel1.readException();
/*  926 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  929 */           parcel1.recycle();
/*  930 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getPSDDayBrightness() throws RemoteException {
/*  936 */         Parcel parcel1 = Parcel.obtain();
/*  937 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  940 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  941 */           this.mRemote.transact(32, parcel1, parcel2, 0);
/*  942 */           parcel2.readException();
/*  943 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  946 */           parcel2.recycle();
/*  947 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getPSDNightBrightness() throws RemoteException {
/*  953 */         Parcel parcel2 = Parcel.obtain();
/*  954 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/*  957 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  958 */           this.mRemote.transact(33, parcel2, parcel1, 0);
/*  959 */           parcel1.readException();
/*  960 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/*  963 */           parcel1.recycle();
/*  964 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public int getRealDayNightTheme() throws RemoteException {
/*  970 */         Parcel parcel1 = Parcel.obtain();
/*  971 */         Parcel parcel2 = Parcel.obtain();
/*      */         
/*      */         try {
/*  974 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  975 */           this.mRemote.transact(34, parcel1, parcel2, 0);
/*  976 */           parcel2.readException();
/*  977 */           return parcel2.readInt();
/*      */         } finally {
/*      */           
/*  980 */           parcel2.recycle();
/*  981 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void setCustomDayTime(float param2Float) throws RemoteException {
/*  989 */         Parcel parcel2 = Parcel.obtain();
/*  990 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/*  992 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*  993 */           parcel2.writeFloat(param2Float);
/*  994 */           this.mRemote.transact(35, parcel2, parcel1, 0);
/*  995 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/*  998 */           parcel1.recycle();
/*  999 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public float getCustomDayTime() throws RemoteException {
/* 1004 */         Parcel parcel2 = Parcel.obtain();
/* 1005 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/* 1008 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1009 */           this.mRemote.transact(36, parcel2, parcel1, 0);
/* 1010 */           parcel1.readException();
/* 1011 */           return parcel1.readFloat();
/*      */         } finally {
/*      */           
/* 1014 */           parcel1.recycle();
/* 1015 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void setCustomNightTime(float param2Float) throws RemoteException {
/* 1023 */         Parcel parcel2 = Parcel.obtain();
/* 1024 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/* 1026 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1027 */           parcel2.writeFloat(param2Float);
/* 1028 */           this.mRemote.transact(37, parcel2, parcel1, 0);
/* 1029 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/* 1032 */           parcel1.recycle();
/* 1033 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public float getCustomNightTime() throws RemoteException {
/* 1038 */         Parcel parcel2 = Parcel.obtain();
/* 1039 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/* 1042 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1043 */           this.mRemote.transact(38, parcel2, parcel1, 0);
/* 1044 */           parcel1.readException();
/* 1045 */           return parcel1.readFloat();
/*      */         } finally {
/*      */           
/* 1048 */           parcel1.recycle();
/* 1049 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void setScreenSaverStyle(int param2Int) throws RemoteException {
/* 1057 */         Parcel parcel2 = Parcel.obtain();
/* 1058 */         Parcel parcel1 = Parcel.obtain();
/*      */         try {
/* 1060 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1061 */           parcel2.writeInt(param2Int);
/* 1062 */           this.mRemote.transact(39, parcel2, parcel1, 0);
/* 1063 */           parcel1.readException();
/*      */           return;
/*      */         } finally {
/* 1066 */           parcel1.recycle();
/* 1067 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public int getScreenSaverStyle() throws RemoteException {
/* 1072 */         Parcel parcel2 = Parcel.obtain();
/* 1073 */         Parcel parcel1 = Parcel.obtain();
/*      */         
/*      */         try {
/* 1076 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1077 */           this.mRemote.transact(40, parcel2, parcel1, 0);
/* 1078 */           parcel1.readException();
/* 1079 */           return parcel1.readInt();
/*      */         } finally {
/*      */           
/* 1082 */           parcel1.recycle();
/* 1083 */           parcel2.recycle();
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void setScreenSaverName(String param2String) throws RemoteException {
/* 1091 */         Parcel parcel1 = Parcel.obtain();
/* 1092 */         Parcel parcel2 = Parcel.obtain();
/*      */         try {
/* 1094 */           parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1095 */           parcel1.writeString(param2String);
/* 1096 */           this.mRemote.transact(41, parcel1, parcel2, 0);
/* 1097 */           parcel2.readException();
/*      */           return;
/*      */         } finally {
/* 1100 */           parcel2.recycle();
/* 1101 */           parcel1.recycle();
/*      */         } 
/*      */       }
/*      */       
/*      */       public String getScreenSaverName() throws RemoteException {
/* 1106 */         Parcel parcel1 = Parcel.obtain();
/* 1107 */         Parcel parcel2 = Parcel.obtain();
/*      */ 
/*      */         
/* 1110 */         try { parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/* 1111 */           this.mRemote.transact(42, parcel1, parcel2, 0);
/* 1112 */           parcel2.readException();
/* 1113 */           return parcel2.readString(); }
/*      */         finally
/*      */         
/* 1116 */         { parcel2.recycle();
/* 1117 */           parcel1.recycle(); }  } } } private static class Proxy implements IECarXCarPower { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "ecarx.car.IECarXCarPower"; } public void setResetSettingsRequest(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower"); parcel2.writeInt(param1Int); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public void setAPUpdate(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower"); parcel2.writeInt(param1Int); this.mRemote.transact(2, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public void closeBootUpAnimation() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower"); this.mRemote.transact(3, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }  } public int getInfotainmentMode() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower"); this.mRemote.transact(4, parcel2, parcel1, 0); parcel1.readException(); return parcel1.readInt(); } finally { parcel1.recycle(); parcel2.recycle(); }  } public int getModemStatus() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower"); this.mRemote.transact(5, parcel2, parcel1, 0); parcel1.readException(); return parcel1.readInt(); } finally { parcel1.recycle(); parcel2.recycle(); }  } public int getPopES() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower"); this.mRemote.transact(6, parcel1, parcel2, 0); parcel2.readException(); return parcel2.readInt(); } finally { parcel2.recycle(); parcel1.recycle(); }  } public int getPopSD() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower"); this.mRemote.transact(7, parcel2, parcel1, 0); parcel1.readException(); return parcel1.readInt(); } finally { parcel1.recycle(); parcel2.recycle(); }  } public String getScreenSaverName() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower"); this.mRemote.transact(42, parcel1, parcel2, 0); parcel2.readException(); return parcel2.readString(); } finally { parcel2.recycle(); parcel1.recycle(); }
/*      */        }
/*      */ 
/*      */     
/*      */     public int getEntertainmentMode() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(8, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getResetSettingsResponse() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(9, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getCSDstatus() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(10, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void registerCallBack(int param1Int, IPowerStatusListener param1IPowerStatusListener) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         if (param1IPowerStatusListener != null) {
/*      */           IBinder iBinder = param1IPowerStatusListener.asBinder();
/*      */         } else {
/*      */           param1IPowerStatusListener = null;
/*      */         } 
/*      */         parcel1.writeStrongBinder((IBinder)param1IPowerStatusListener);
/*      */         this.mRemote.transact(11, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void unregisterCallBack(int param1Int, IPowerStatusListener param1IPowerStatusListener) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         if (param1IPowerStatusListener != null) {
/*      */           IBinder iBinder = param1IPowerStatusListener.asBinder();
/*      */         } else {
/*      */           param1IPowerStatusListener = null;
/*      */         } 
/*      */         parcel1.writeStrongBinder((IBinder)param1IPowerStatusListener);
/*      */         this.mRemote.transact(12, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void onPowerSoftKeyEvent(int param1Int) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         this.mRemote.transact(13, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void registerPowerCallBack(IPowerStatusListener param1IPowerStatusListener) throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         if (param1IPowerStatusListener != null) {
/*      */           IBinder iBinder = param1IPowerStatusListener.asBinder();
/*      */         } else {
/*      */           param1IPowerStatusListener = null;
/*      */         } 
/*      */         parcel2.writeStrongBinder((IBinder)param1IPowerStatusListener);
/*      */         this.mRemote.transact(14, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void unregisterPowerCallBack(IPowerStatusListener param1IPowerStatusListener) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         if (param1IPowerStatusListener != null) {
/*      */           IBinder iBinder = param1IPowerStatusListener.asBinder();
/*      */         } else {
/*      */           param1IPowerStatusListener = null;
/*      */         } 
/*      */         parcel1.writeStrongBinder((IBinder)param1IPowerStatusListener);
/*      */         this.mRemote.transact(15, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setThemeDayNightMode(int param1Int) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         this.mRemote.transact(16, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getThemeDayNightMode() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(17, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setBrightnessDayNightMode(int param1Int) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         this.mRemote.transact(18, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getBrightnessDayNightMode() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(19, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setVehicleBrightness(int param1Int) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         this.mRemote.transact(20, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getVehicleBrightness() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(21, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setBrightnessMode(int param1Int) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeInt(param1Int);
/*      */         this.mRemote.transact(22, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getBrightnessMode() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(23, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setCSDBrightness(int param1Int1, int param1Int2) throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel2.writeInt(param1Int1);
/*      */         parcel2.writeInt(param1Int2);
/*      */         this.mRemote.transact(24, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getCSDBrightness() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(25, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setPSDBrightness(int param1Int1, int param1Int2) throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel2.writeInt(param1Int1);
/*      */         parcel2.writeInt(param1Int2);
/*      */         this.mRemote.transact(26, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getPSDBrightness() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(27, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getRealDayNightMode() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(28, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getAutoDayNightMode() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(29, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getCSDDayBrightness() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(30, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getCSDNightBrightness() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(31, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getPSDDayBrightness() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(32, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getPSDNightBrightness() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(33, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getRealDayNightTheme() throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(34, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return parcel2.readInt();
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setCustomDayTime(float param1Float) throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel2.writeFloat(param1Float);
/*      */         this.mRemote.transact(35, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public float getCustomDayTime() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(36, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readFloat();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setCustomNightTime(float param1Float) throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel2.writeFloat(param1Float);
/*      */         this.mRemote.transact(37, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public float getCustomNightTime() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(38, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readFloat();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setScreenSaverStyle(int param1Int) throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel2.writeInt(param1Int);
/*      */         this.mRemote.transact(39, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getScreenSaverStyle() throws RemoteException {
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       try {
/*      */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         this.mRemote.transact(40, parcel2, parcel1, 0);
/*      */         parcel1.readException();
/*      */         return parcel1.readInt();
/*      */       } finally {
/*      */         parcel1.recycle();
/*      */         parcel2.recycle();
/*      */       } 
/*      */     }
/*      */     
/*      */     public void setScreenSaverName(String param1String) throws RemoteException {
/*      */       Parcel parcel1 = Parcel.obtain();
/*      */       Parcel parcel2 = Parcel.obtain();
/*      */       try {
/*      */         parcel1.writeInterfaceToken("ecarx.car.IECarXCarPower");
/*      */         parcel1.writeString(param1String);
/*      */         this.mRemote.transact(41, parcel1, parcel2, 0);
/*      */         parcel2.readException();
/*      */         return;
/*      */       } finally {
/*      */         parcel2.recycle();
/*      */         parcel1.recycle();
/*      */       } 
/*      */     } }
/*      */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IECarXCarPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */