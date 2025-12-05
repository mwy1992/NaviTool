/*     */ package android.car.media;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.database.ContentObserver;
/*     */ import android.net.Uri;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.provider.Settings;
/*     */ import android.util.Log;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CarAudioManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   private static final String VOLUME_SETTINGS_KEY_FOR_GROUP_PREFIX = "android.car.VOLUME_GROUP/";
/*     */   public static final String VOLUME_SETTINGS_KEY_MASTER_MUTE = "android.car.MASTER_MUTE";
/*     */   private final ContentResolver mContentResolver;
/*     */   private final ICarAudio mService;
/*     */   
/*     */   public static String getVolumeSettingsKeyForGroup(int paramInt) {
/*  47 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("android.car.VOLUME_GROUP/"); stringBuilder.append(paramInt); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void registerVolumeChangeObserver(ContentObserver paramContentObserver) {
/*  70 */     ContentResolver contentResolver = this.mContentResolver;
/*  71 */     Uri uri = Settings.Global.getUriFor("android.car.VOLUME_GROUP/");
/*     */     contentResolver.registerContentObserver(uri, true, paramContentObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void unregisterVolumeChangeObserver(ContentObserver paramContentObserver) {
/*  82 */     this.mContentResolver.unregisterContentObserver(paramContentObserver);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void setGroupVolume(int paramInt1, int paramInt2, int paramInt3) throws CarNotConnectedException {
/*     */     try {
/*  99 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("setGroupVolume groupId="); stringBuilder.append(paramInt1); stringBuilder.append(", index="); stringBuilder.append(paramInt2); stringBuilder.append(", flags="); stringBuilder.append(paramInt3); Log.e("CAR.L", stringBuilder.toString());
/* 100 */       this.mService.setGroupVolume(paramInt1, paramInt2, paramInt3); return;
/* 101 */     } catch (RemoteException remoteException) {
/* 102 */       Log.e("CAR.L", "setGroupVolume failed", (Throwable)remoteException);
/* 103 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int getGroupMaxVolume(int paramInt) throws CarNotConnectedException {
/*     */     try {
/* 118 */       return this.mService.getGroupMaxVolume(paramInt);
/* 119 */     } catch (RemoteException remoteException) {
/* 120 */       Log.e("CAR.L", "getUsageMaxVolume failed", (Throwable)remoteException);
/* 121 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int getGroupMinVolume(int paramInt) throws CarNotConnectedException {
/*     */     try {
/* 136 */       return this.mService.getGroupMinVolume(paramInt);
/* 137 */     } catch (RemoteException remoteException) {
/* 138 */       Log.e("CAR.L", "getUsageMinVolume failed", (Throwable)remoteException);
/* 139 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int getGroupVolume(int paramInt) throws CarNotConnectedException {
/*     */     try {
/* 157 */       return this.mService.getGroupVolume(paramInt);
/* 158 */     } catch (RemoteException remoteException) {
/* 159 */       Log.e("CAR.L", "getUsageVolume failed", (Throwable)remoteException);
/* 160 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void setFadeTowardFront(float paramFloat) throws CarNotConnectedException {
/*     */     try {
/* 177 */       this.mService.setFadeTowardFront(paramFloat); return;
/* 178 */     } catch (RemoteException remoteException) {
/* 179 */       Log.e("CAR.L", "setFadeTowardFront failed", (Throwable)remoteException);
/* 180 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void setBalanceTowardRight(float paramFloat) throws CarNotConnectedException {
/*     */     try {
/* 197 */       this.mService.setBalanceTowardRight(paramFloat); return;
/* 198 */     } catch (RemoteException remoteException) {
/* 199 */       Log.e("CAR.L", "setBalanceTowardRight failed", (Throwable)remoteException);
/* 200 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public String[] getExternalSources() throws CarNotConnectedException {
/*     */     try {
/* 220 */       return this.mService.getExternalSources();
/* 221 */     } catch (RemoteException remoteException) {
/* 222 */       Log.e("CAR.L", "getExternalSources failed", (Throwable)remoteException);
/* 223 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public CarAudioPatchHandle createAudioPatch(String paramString, int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/* 252 */       return this.mService.createAudioPatch(paramString, paramInt1, paramInt2);
/* 253 */     } catch (RemoteException remoteException) {
/* 254 */       Log.e("CAR.L", "createAudioPatch failed", (Throwable)remoteException);
/* 255 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void releaseAudioPatch(CarAudioPatchHandle paramCarAudioPatchHandle) throws CarNotConnectedException {
/*     */     try {
/* 273 */       this.mService.releaseAudioPatch(paramCarAudioPatchHandle); return;
/* 274 */     } catch (RemoteException remoteException) {
/* 275 */       Log.e("CAR.L", "releaseAudioPatch failed", (Throwable)remoteException);
/* 276 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int getVolumeGroupCount() throws CarNotConnectedException {
/*     */     try {
/* 290 */       return this.mService.getVolumeGroupCount();
/* 291 */     } catch (RemoteException remoteException) {
/* 292 */       Log.e("CAR.L", "getVolumeGroupCount failed", (Throwable)remoteException);
/* 293 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int getVolumeGroupIdForUsage(int paramInt) throws CarNotConnectedException {
/*     */     try {
/* 309 */       return this.mService.getVolumeGroupIdForUsage(paramInt);
/* 310 */     } catch (RemoteException remoteException) {
/* 311 */       Log.e("CAR.L", "getVolumeGroupIdForUsage failed", (Throwable)remoteException);
/* 312 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int[] getUsagesForVolumeGroupId(int paramInt) throws CarNotConnectedException {
/*     */     try {
/* 327 */       return this.mService.getUsagesForVolumeGroupId(paramInt);
/* 328 */     } catch (RemoteException remoteException) {
/* 329 */       Log.e("CAR.L", "getUsagesForVolumeGroupId failed", (Throwable)remoteException);
/* 330 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void registerVolumeCallback(IBinder paramIBinder) throws CarNotConnectedException {
/*     */     try {
/* 347 */       this.mService.registerVolumeCallback(paramIBinder); return;
/* 348 */     } catch (RemoteException remoteException) {
/* 349 */       Log.e("CAR.L", "registerVolumeCallback failed", (Throwable)remoteException);
/* 350 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void unregisterVolumeCallback(IBinder paramIBinder) throws CarNotConnectedException {
/*     */     try {
/* 367 */       this.mService.unregisterVolumeCallback(paramIBinder); return;
/* 368 */     } catch (RemoteException remoteException) {
/* 369 */       Log.e("CAR.L", "unregisterVolumeCallback failed", (Throwable)remoteException);
/* 370 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public int getCurrentStreamType() throws CarNotConnectedException {
/*     */     try {
/* 386 */       return this.mService.getCurrentStreamType();
/* 387 */     } catch (RemoteException remoteException) {
/* 388 */       Log.e("CAR.L", "getCurrentStreamType failed", (Throwable)remoteException);
/* 389 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public CarAudioManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 400 */     this.mContentResolver = paramContext.getContentResolver();
/* 401 */     this.mService = ICarAudio.Stub.asInterface(paramIBinder);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\media\CarAudioManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */