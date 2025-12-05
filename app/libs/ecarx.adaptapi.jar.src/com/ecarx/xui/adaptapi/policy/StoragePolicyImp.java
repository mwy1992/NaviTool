/*     */ package com.ecarx.xui.adaptapi.policy;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.SystemProperties;
/*     */ import android.os.storage.DiskInfo;
/*     */ import android.os.storage.StorageEventListener;
/*     */ import android.os.storage.StorageManager;
/*     */ import android.os.storage.VolumeInfo;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarPowerManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.os.Environment;
/*     */ import java.io.File;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StoragePolicyImp
/*     */   implements IStoragePolicy, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*  30 */   private final Object mCarManagerLock = new Object();
/*     */ 
/*     */ 
/*     */   
/*  34 */   private static final File EXTERNAL_UDISK_1_DIRECTORY = Environment.getExternalUDisk1Directory();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private static final File EXTERNAL_UDISK_2_DIRECTORY = Environment.getExternalUDisk2Directory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   private ECarXCarPowerManager mPowerManager = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String TAG = "StoragePolicyImp";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CopyOnWriteArrayList<IStoragePolicy.IUsbDeviceListener> mDeviceListenerList;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final StorageEventListener mStorageEventListener;
/*     */ 
/*     */ 
/*     */   
/*     */   private StorageManager mStorageManager;
/*     */ 
/*     */ 
/*     */   
/*     */   private final UsbVolumeInfo[] mUsb1VolumeInfos;
/*     */ 
/*     */ 
/*     */   
/*     */   private final UsbVolumeInfo[] mUsb2VolumeInfos;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVolumeName(int paramInt) {
/* 103 */     String str = null;
/*     */     
/* 105 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 120 */         return str;
/*     */       case 2:
/*     */         if (EXTERNAL_UDISK_2_DIRECTORY != null) {
/*     */           str = EXTERNAL_UDISK_2_DIRECTORY.getName();
/*     */         }
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     if (EXTERNAL_UDISK_1_DIRECTORY != null) {
/*     */       str = EXTERNAL_UDISK_1_DIRECTORY.getName();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVolumeFullPath(int paramInt) {
/* 137 */     String str = null;
/*     */     
/* 139 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 166 */         return str;
/*     */       case 5: str = Environment.getPrivateGKUIDirectory().getPath();
/*     */       case 4:
/*     */         str = null;
/*     */       case 3:
/*     */         str = Environment.getVrResourceDirectory().getPath();
/*     */       case 2:
/*     */         if (EXTERNAL_UDISK_2_DIRECTORY != null)
/*     */           str = EXTERNAL_UDISK_2_DIRECTORY.getPath(); 
/*     */       case 1:
/*     */         break; }  if (EXTERNAL_UDISK_1_DIRECTORY != null)
/* 177 */       str = EXTERNAL_UDISK_1_DIRECTORY.getPath();  } public int getUsbHostCount() { int i = 2;
/*     */     
/* 179 */     if (SystemProperties.getBoolean("persist.vold.udisk1.disable", false)) {
/* 180 */       i = 2 - 1;
/*     */     }
/*     */     
/* 183 */     int j = i; if (SystemProperties.getBoolean("persist.vold.udisk2.disable", false)) {
/* 184 */       j = i - 1;
/*     */     }
/*     */     
/* 187 */     return j; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IStoragePolicy.IUsbVolumeInfo[] getUsbHostVolumeInfos(@UsbHostId int paramInt) {
/* 197 */     IStoragePolicy.IUsbVolumeInfo[] arrayOfIUsbVolumeInfo = null;
/* 198 */     switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 207 */         return arrayOfIUsbVolumeInfo;
/*     */       case 11:
/*     */         arrayOfUsbVolumeInfo = this.mUsb2VolumeInfos;
/*     */       case 10:
/*     */         break;
/*     */     } 
/*     */     UsbVolumeInfo[] arrayOfUsbVolumeInfo = this.mUsb1VolumeInfos;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registerUsbDeviceListener(IStoragePolicy.IUsbDeviceListener paramIUsbDeviceListener) {
/* 218 */     boolean bool2 = false;
/*     */     
/* 220 */     boolean bool1 = bool2; if (paramIUsbDeviceListener != null) { bool1 = bool2; if (!this.mDeviceListenerList.contains(paramIUsbDeviceListener)) {
/* 221 */         bool1 = this.mDeviceListenerList.add(paramIUsbDeviceListener);
/*     */       } }
/*     */     
/* 224 */     if (this.mDeviceListenerList.size() == 1) {
/* 225 */       this.mStorageManager.registerListener(this.mStorageEventListener);
/*     */     }
/*     */     
/* 228 */     return bool1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterUsbDeviceListener(IStoragePolicy.IUsbDeviceListener paramIUsbDeviceListener) {
/* 239 */     this.mDeviceListenerList.remove(paramIUsbDeviceListener);
/*     */     
/* 241 */     if (paramIUsbDeviceListener != null && this.mDeviceListenerList.size() == 0) {
/* 242 */       this.mStorageManager.unregisterListener(this.mStorageEventListener);
/*     */     }
/* 244 */     return true;
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
/*     */   public boolean setUsbPowerState(String paramString, boolean paramBoolean) {
/* 260 */     synchronized (this.mCarManagerLock) {
/* 261 */       if (this.mPowerManager != null) {
/* 262 */         Log.d("StoragePolicyImp", "resetUsbPowerState");
/* 263 */         ECarXCarPowerManager eCarXCarPowerManager = this.mPowerManager; paramBoolean = true; ApiResult apiResult = eCarXCarPowerManager.CB_Power_ResetUSB(1);
/* 264 */         if (apiResult != ApiResult.SUCCEED) paramBoolean = false; 
/*     */       } else {
/* 266 */         paramBoolean = false;
/*     */       } 
/*     */       
/* 269 */       return paramBoolean;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static class UsbVolumeInfo
/*     */     implements IStoragePolicy.IUsbVolumeInfo
/*     */   {
/*     */     private String mFullPath;
/*     */     @UsbHostId
/*     */     private int mUsbHostId;
/*     */     private String mVolumeId;
/*     */     
/*     */     public UsbVolumeInfo(String param1String1, @UsbHostId int param1Int, String param1String2) {
/* 283 */       this.mVolumeId = param1String1;
/* 284 */       this.mUsbHostId = param1Int;
/* 285 */       this.mFullPath = param1String2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getVolumeId() {
/* 293 */       return this.mVolumeId;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @UsbHostId
/*     */     public int getUsbHostId() {
/* 302 */       return this.mUsbHostId;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @MountType
/*     */     public int getMountTypes() {
/* 311 */       return 2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getFullPath() {
/* 319 */       return this.mFullPath;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StoragePolicyImp(Context paramContext) {
/* 326 */     this.mStorageEventListener = new StorageEventListener() { final StoragePolicyImp this$0;
/*     */         
/*     */         public void onStorageStateChanged(String param1String1, String param1String2, String param1String3) {
/* 329 */           if (StoragePolicyImp.EXTERNAL_UDISK_1_DIRECTORY == null || !StoragePolicyImp.EXTERNAL_UDISK_1_DIRECTORY.getPath().equals(param1String1))
/*     */           {
/*     */             
/* 332 */             if (StoragePolicyImp.EXTERNAL_UDISK_2_DIRECTORY != null) {
/* 333 */               StoragePolicyImp.EXTERNAL_UDISK_1_DIRECTORY.getPath().equals(param1String1);
/*     */             }
/*     */           }
/*     */           
/* 337 */           for (StoragePolicyImp.UsbVolumeInfo usbVolumeInfo : StoragePolicyImp.this.mUsb1VolumeInfos) {
/* 338 */             if (usbVolumeInfo.getFullPath().equals(param1String1))
/*     */             {
/* 340 */               notifyStorageStateChanged(param1String3, usbVolumeInfo);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void onVolumeStateChanged(VolumeInfo param1VolumeInfo, int param1Int1, int param1Int2) {
/* 347 */           super.onVolumeStateChanged(param1VolumeInfo, param1Int1, param1Int2);
/*     */         }
/*     */ 
/*     */         
/*     */         public void onDiskScanned(DiskInfo param1DiskInfo, int param1Int) {
/* 352 */           super.onDiskScanned(param1DiskInfo, param1Int);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private void notifyStorageStateChanged(String param1String, IStoragePolicy.IUsbVolumeInfo param1IUsbVolumeInfo) {
/* 361 */           for (IStoragePolicy.IUsbDeviceListener iUsbDeviceListener : StoragePolicyImp.this.mDeviceListenerList) {
/*     */             try {
/* 363 */               iUsbDeviceListener.onReceiveUsbDeviceAction(convertToUsbActions(param1String), param1IUsbVolumeInfo);
/* 364 */             } catch (Exception exception) {
/* 365 */               exception.printStackTrace();
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         @UsbActions
/*     */         private String convertToUsbActions(String param1String) {
/* 372 */           String str = "android.intent.action.MEDIA_UNMOUNTED";
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 377 */           if ("mounted".equals(param1String)) {
/* 378 */             str = "android.intent.action.MEDIA_MOUNTED";
/* 379 */           } else if ("unknown".equals(param1String)) {
/* 380 */             str = "android.intent.action.MEDIA_UNMOUNTED";
/* 381 */           } else if ("checking".equals(param1String)) {
/* 382 */             str = "android.intent.action.MEDIA_CHECKING";
/* 383 */           } else if ("removed".equals(param1String)) {
/* 384 */             str = "android.intent.action.MEDIA_REMOVED";
/* 385 */           } else if ("ejecting".equals(param1String)) {
/* 386 */             str = "android.intent.action.MEDIA_EJECT";
/* 387 */           } else if ("nofs".equals(param1String)) {
/* 388 */             str = "android.intent.action.MEDIA_NOFS";
/* 389 */           } else if ("unmountable".equals(param1String)) {
/* 390 */             str = "android.intent.action.MEDIA_UNMOUNTABLE";
/* 391 */           } else if ("bad_removal".equals(param1String)) {
/* 392 */             str = "android.intent.action.MEDIA_BAD_REMOVAL";
/*     */           } 
/*     */           
/* 395 */           return str; } }; this.mDeviceListenerList = new CopyOnWriteArrayList<>(); this.mUsb1VolumeInfos = new UsbVolumeInfo[1]; this.mUsb2VolumeInfos = new UsbVolumeInfo[1]; if (EXTERNAL_UDISK_1_DIRECTORY != null) {
/*     */       UsbVolumeInfo[] arrayOfUsbVolumeInfo = this.mUsb1VolumeInfos; String str = EXTERNAL_UDISK_1_DIRECTORY.getName(); File file = EXTERNAL_UDISK_1_DIRECTORY;
/*     */       arrayOfUsbVolumeInfo[0] = new UsbVolumeInfo(str, 10, file.getPath());
/*     */     } 
/*     */     if (EXTERNAL_UDISK_2_DIRECTORY != null) {
/*     */       UsbVolumeInfo[] arrayOfUsbVolumeInfo = this.mUsb2VolumeInfos;
/*     */       String str = EXTERNAL_UDISK_2_DIRECTORY.getName();
/*     */       File file = EXTERNAL_UDISK_2_DIRECTORY;
/*     */       arrayOfUsbVolumeInfo[0] = new UsbVolumeInfo(str, 11, file.getPath());
/*     */     } 
/*     */     this.mStorageManager = (StorageManager)paramContext.getSystemService("storage");
/*     */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*     */     this.mECarXCarProxy.initECarXCar(); } public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) { try {
/* 408 */       Log.d("StoragePolicyImp", "onECarXCarServiceConnected");
/* 409 */       synchronized (this.mCarManagerLock) {
/*     */         
/* 411 */         ECarXCarSetManager eCarXCarSetManager = (ECarXCarSetManager)paramECarXCar.getCarManager("car_publicattribute");
/* 412 */         this.mPowerManager = eCarXCarSetManager.getECarXCarPowerManager();
/*     */       } 
/* 414 */     } catch (Exception exception) {
/* 415 */       exception.printStackTrace();
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 424 */     synchronized (this.mCarManagerLock) {
/* 425 */       this.mPowerManager = null;
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\StoragePolicyImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */