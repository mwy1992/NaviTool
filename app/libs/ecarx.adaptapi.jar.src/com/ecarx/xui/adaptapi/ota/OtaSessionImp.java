/*     */ package com.ecarx.xui.adaptapi.ota;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.SystemProperties;
/*     */ import android.provider.Settings;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarPowerManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarScenemodManager;
/*     */ import ecarx.ota.OpAssignmentkeytoTargetECUReqParam;
/*     */ import ecarx.ota.OpBSSIDDisplayedVersionSyncParam;
/*     */ import ecarx.ota.OpOTAAssignmentParam;
/*     */ import ecarx.ota.OpOTAConnectivityStsParam;
/*     */ import ecarx.ota.OpOTADownloadStatusParam;
/*     */ import ecarx.ota.OpOTAInstallationRegretTimeOutParam;
/*     */ import ecarx.ota.OpOTASetAssignmentFileInfoParam;
/*     */ import ecarx.ota.OpOTATCAMAssignmentParam;
/*     */ import ecarx.ota.OpOTAURLInfoReqParam;
/*     */ import ecarx.ota.OpOTAWriteInstallationInstructionParam;
/*     */ import ecarx.ota.OtaManager;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OtaSessionImp
/*     */   implements IOtaSession
/*     */ {
/*     */   private static final int CAR_LIMIT_SPEAD = 3;
/*     */   private static final String TAG = "OTAImpSession";
/*  43 */   private static final boolean mDebug = SystemProperties.getBoolean("persist.adaptapi.debug", false);
/*     */   
/*     */   List<Integer> estimatedinstallationtimeList;
/*     */   
/*     */   int fileSize;
/*     */   List<String> filenameList;
/*     */   private ECarXCarPowerManager mCarPowerManager;
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private ECarXCarScenemodManager mCarXCarScenemodManager;
/*     */   private Context mContext;
/*     */   int mDownloadProgress;
/*     */   private int mInstallTime;
/*     */   public boolean mIsRecovery;
/*     */   OpAssignmentkeytoTargetECUReqParam mOpAssignmentkeytoTargetECUReqParam;
/*     */   OpBSSIDDisplayedVersionSyncParam mOpBSSIDDisplayedVersionSyncParam;
/*     */   OpOTAAssignmentParam mOpOTAAssignmentParam;
/*     */   OpOTAConnectivityStsParam mOpOTAConnectivityStsParam;
/*     */   OpOTASetAssignmentFileInfoParam mOpOTASetAssignmentFileInfoParam;
/*     */   OpOTATCAMAssignmentParam mOpOTATCAMAssignmentParam;
/*     */   OpOTAURLInfoReqParam mOpOTAURLInfoReqParam;
/*     */   OpOTAWriteInstallationInstructionParam mOpOTAWriteInstallationInstructionParam;
/*     */   private OtaManager mOtaManager;
/*     */   public IOtaSessionCallback mOtaSessionCallback;
/*     */   public int mPriority;
/*     */   String mSignatureCertificate;
/*     */   List<String> softwarepartsignatureList;
/*     */   List<String> urlList;
/*     */   
/*     */   public OtaSessionImp(Context paramContext, OtaManager paramOtaManager) {
/*  72 */     if (mDebug) {
/*  73 */       Log.i("OTAImpSession", "OtaSessionImp()");
/*     */     }
/*  75 */     this.mContext = paramContext;
/*  76 */     this.mOtaManager = paramOtaManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOtaMode() {
/*  81 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOtaType() {
/*  86 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInstallationStarted() {
/*  95 */     return false;
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
/*     */   public boolean couldBeginInstallRightNow() {
/* 107 */     Log.d("OTAImpSession", "------------couldBeginInstallRightNow start------------");
/*     */     try {
/* 109 */       if (this.mCarSignalManager != null && this.mOpOTAConnectivityStsParam != null) {
/* 110 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("couldBeginInstallRightNow: GearLvrIndcn = "); stringBuilder.append(this.mCarSignalManager.getGearLvrIndcn()); Log.d("OTAImpSession", stringBuilder.toString());
/* 111 */         stringBuilder = new StringBuilder(); this(); stringBuilder.append("couldBeginInstallRightNow: VehSpdLgtA = "); stringBuilder.append(this.mCarSignalManager.getVehSpdLgtA()); Log.d("OTAImpSession", stringBuilder.toString());
/* 112 */         stringBuilder = new StringBuilder(); this(); stringBuilder.append("couldBeginInstallRightNow: connectionStatus = "); stringBuilder.append(this.mOpOTAConnectivityStsParam.connectionStatus); Log.d("OTAImpSession", stringBuilder.toString());
/* 113 */         if (this.mCarSignalManager.getGearLvrIndcn() == 0 && this.mCarSignalManager.getVehSpdLgtA() * 0.00391D * 3.6D <= 3.0D && this.mOpOTAConnectivityStsParam.connectionStatus)
/*     */         {
/* 115 */           return true;
/*     */         }
/* 117 */         return false;
/*     */       } 
/* 119 */       Log.d("OTAImpSession", "mOpOTAConnectivityStsParam or mCarSignalManager is null");
/* 120 */       return false;
/* 121 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 122 */       Log.e("OTAImpSession", "couldBeginInstallRightNow: get conditions from CarSignalManager error");
/* 123 */       return false;
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
/*     */   public boolean isRecoveryOta() {
/* 137 */     return this.mIsRecovery;
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
/*     */   public int getOtaProgress() {
/* 149 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOtaPriority() {
/* 159 */     return this.mPriority;
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
/*     */   public boolean ifSystemWillRebootAfterOta() {
/* 171 */     return false;
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
/*     */   public boolean cancel() {
/* 183 */     if (mDebug) {
/* 184 */       Log.i("OTAImpSession", "cancel()");
/*     */     }
/* 186 */     this.mOtaManager.setInstallationConsent(getAvailableUUID(), 2, 0);
/* 187 */     this.mInstallTime = 0;
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean download() {
/* 199 */     if (mDebug) {
/* 200 */       Log.i("OTAImpSession", "download()");
/*     */     }
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkUpdate() {
/* 212 */     if (mDebug) {
/* 213 */       Log.i("OTAImpSession", "checkUpdate()");
/*     */     }
/* 215 */     this.mOtaManager.requestBSSIDDisplayedVersionSync();
/* 216 */     return false;
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
/*     */   public String getCurrentCarVersionName() {
/* 229 */     if (this.mOpBSSIDDisplayedVersionSyncParam != null) {
/* 230 */       return this.mOpBSSIDDisplayedVersionSyncParam.displayedversion.trim();
/*     */     }
/* 232 */     return null;
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
/*     */   public int getSysVersionCode() {
/* 249 */     return 0;
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
/*     */   public String getSysVersionName() {
/* 262 */     if (mDebug) {
/* 263 */       Log.i("OTAImpSession", "getSysVersionName()");
/*     */     }
/* 265 */     if (this.mOpOTAAssignmentParam != null) {
/* 266 */       return this.mOpOTAAssignmentParam.displayedversion.trim();
/*     */     }
/* 268 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSysBssId() {
/* 273 */     if (mDebug) {
/* 274 */       Log.i("OTAImpSession", "getSysBssId()");
/* 275 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("mOpBSSIDDisplayedVersionSyncParam = "); stringBuilder.append(this.mOpBSSIDDisplayedVersionSyncParam); Log.i("OTAImpSession", stringBuilder.toString());
/*     */     } 
/* 277 */     if (this.mOpBSSIDDisplayedVersionSyncParam != null) {
/* 278 */       if (mDebug) {
/* 279 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSysBssId = "); stringBuilder.append(this.mOpBSSIDDisplayedVersionSyncParam.bssid); Log.i("OTAImpSession", stringBuilder.toString());
/*     */       } 
/* 281 */       return this.mOpBSSIDDisplayedVersionSyncParam.bssid.trim();
/*     */     } 
/* 283 */     return null;
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
/*     */   public int getOtaBaseSysVersionCode() {
/* 300 */     String str = SystemProperties.get("ro.build.system.version", "");
/* 301 */     str = str.substring(str.lastIndexOf('.') + 1).trim();
/* 302 */     return Integer.parseInt(str);
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
/*     */   public String getOtaBaseSysVersionName() {
/* 315 */     return SystemProperties.get("ro.build.system.version", "");
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
/*     */   public boolean setOtaUpdateTime(Calendar paramCalendar) {
/* 328 */     int i = (int)(paramCalendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) / 1000 + 2;
/* 329 */     if (i > 2) {
/* 330 */       this.mOtaManager.setInstallationConsent(getAvailableUUID(), 3, i);
/*     */     }
/* 332 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Calendar getOtaUpdateTime() {
/* 337 */     if (this.mInstallTime == 0) {
/* 338 */       return null;
/*     */     }
/* 340 */     Calendar calendar = Calendar.getInstance();
/* 341 */     calendar.add(13, this.mInstallTime);
/* 342 */     return calendar;
/*     */   }
/*     */ 
/*     */   
/*     */   public void requestOtaUpdateTime() {
/* 347 */     this.mOtaManager.requestSyncSchInstallTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEstimatedInstallationTime() {
/*     */     boolean bool;
/* 357 */     if (this.mOpOTAAssignmentParam != null) { bool = this.mOpOTAAssignmentParam.totalinstallation_time; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean cancelOtaUpgradeTime() {
/* 366 */     this.mOtaManager.setInstallationConsent(getAvailableUUID(), 2, 0);
/* 367 */     this.mInstallTime = 0;
/* 368 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUpgradeInfo() {
/*     */     String str;
/* 377 */     if (this.mOpOTAAssignmentParam != null) { str = this.mOpOTAAssignmentParam.description; } else { str = null; }  return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setPowerState(int paramInt) {
/* 387 */     byte b = 0;
/* 388 */     if (1 == paramInt) {
/* 389 */       b = 0;
/* 390 */     } else if (2 == paramInt) {
/* 391 */       b = 1;
/* 392 */     } else if (3 == paramInt) {
/* 393 */       b = 2;
/*     */     } 
/*     */     
/* 396 */     if (this.mCarPowerManager != null) {
/* 397 */       this.mCarPowerManager.CB_Power_OTAUpdate(b);
/*     */     } else {
/* 399 */       Log.e("OTAImpSession", "Get ECarXCarSetManager failed!");
/*     */     } 
/* 401 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
/*     */   public int getOtaUpdateInProgressState() {
/* 413 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
/*     */   public boolean isPopupEnable() {
/* 425 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInstallRegretState(int paramInt) {
/* 430 */     if (mDebug) {
/* 431 */       Log.i("OTAImpSession", "setInstallRegretState()");
/*     */     }
/*     */     
/* 434 */     if (paramInt != 1 && paramInt != 2) {
/* 435 */       Log.e("OTAImpSession", "setInstallRegretState: state illegal!!");
/*     */       return;
/*     */     } 
/* 438 */     OpOTAInstallationRegretTimeOutParam opOTAInstallationRegretTimeOutParam = new OpOTAInstallationRegretTimeOutParam();
/* 439 */     opOTAInstallationRegretTimeOutParam.installationorder = getAvailableUUID();
/* 440 */     opOTAInstallationRegretTimeOutParam.isotimestamp = getNowTime();
/* 441 */     if (1 == paramInt) {
/* 442 */       opOTAInstallationRegretTimeOutParam.newstatus = "0";
/* 443 */     } else if (2 == paramInt) {
/* 444 */       opOTAInstallationRegretTimeOutParam.newstatus = "1";
/*     */     } 
/* 446 */     opOTAInstallationRegretTimeOutParam.reason = "";
/* 447 */     this.mOtaManager.setOTAInstallationRegretTimeOut(opOTAInstallationRegretTimeOutParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Integer> getInstallationtimes() {
/* 458 */     return this.estimatedinstallationtimeList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUUID() {
/* 469 */     return getAvailableUUID();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getFileNames() {
/* 480 */     return this.filenameList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getSoftwareSignature() {
/* 491 */     return this.softwarepartsignatureList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSignatureCertificate() {
/* 502 */     return this.mSignatureCertificate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getDownloadUrls() {
/* 513 */     return this.urlList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalSize() {
/* 524 */     return this.fileSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkConnectivityStatus() {
/* 535 */     this.mOtaManager.requestOTAConnectivitySts();
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
/*     */   public void setOTADownloadStatus(int paramInt1, int paramInt2) {
/* 548 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setOTADownloadStatus get status: "); stringBuilder.append(paramInt1); Log.d("OTAImpSession", stringBuilder.toString());
/* 549 */     stringBuilder = new StringBuilder(); stringBuilder.append("setOTADownloadStatus get reason: "); stringBuilder.append(paramInt2); Log.d("OTAImpSession", stringBuilder.toString());
/* 550 */     OpOTADownloadStatusParam opOTADownloadStatusParam = new OpOTADownloadStatusParam();
/* 551 */     opOTADownloadStatusParam.installationorder = getAvailableUUID();
/* 552 */     opOTADownloadStatusParam.isotimestamp = getNowTime();
/*     */     
/* 554 */     if (paramInt1 == 4 && paramInt2 == 5) {
/* 555 */       opOTADownloadStatusParam.newstatus = "DOWNLOAD-FAILED";
/* 556 */       opOTADownloadStatusParam.reason = "Invalid URL";
/* 557 */     } else if (paramInt1 == 4 && paramInt2 == 6) {
/* 558 */       opOTADownloadStatusParam.newstatus = "DOWNLOAD-FAILED";
/* 559 */       opOTADownloadStatusParam.reason = "OTASignature validation failed";
/* 560 */     } else if (paramInt1 == 7 && paramInt2 == 8) {
/* 561 */       opOTADownloadStatusParam.newstatus = "DOWNLOAD-FAILED";
/* 562 */       opOTADownloadStatusParam.reason = "OCSPfailed";
/* 563 */     } else if (paramInt1 == 9) {
/* 564 */       opOTADownloadStatusParam.newstatus = "DOWNLOAD-COMPLETED";
/* 565 */       opOTADownloadStatusParam.reason = "Distribute";
/* 566 */     } else if (paramInt1 == 10) {
/* 567 */       opOTADownloadStatusParam.newstatus = "OCSPsuccess";
/* 568 */       opOTADownloadStatusParam.reason = "Distribute";
/*     */     } else {
/* 570 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("setOTADownloadStatus get invalid status: "); stringBuilder1.append(paramInt1); Log.e("OTAImpSession", stringBuilder1.toString());
/* 571 */       opOTADownloadStatusParam.newstatus = "";
/* 572 */       opOTADownloadStatusParam.reason = "";
/*     */     } 
/*     */     
/* 575 */     this.mOtaManager.setOTADownloadStatus(opOTADownloadStatusParam);
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
/*     */   public void setOTADownloadSize(int paramInt) {
/* 587 */     OpOTADownloadStatusParam opOTADownloadStatusParam = new OpOTADownloadStatusParam();
/* 588 */     opOTADownloadStatusParam.installationorder = getAvailableUUID();
/* 589 */     opOTADownloadStatusParam.isotimestamp = getNowTime();
/* 590 */     opOTADownloadStatusParam.downloadsize = paramInt;
/* 591 */     opOTADownloadStatusParam.newstatus = "";
/* 592 */     opOTADownloadStatusParam.reason = "";
/* 593 */     this.mOtaManager.setOTADownloadStatus(opOTADownloadStatusParam);
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
/*     */   public void reportDownloadFailedName(String paramString) {
/* 605 */     this.mOtaManager.setDownloadFailedFileName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkSceneModeAlive() {
/* 616 */     if (Settings.Global.getInt(this.mContext.getContentResolver(), "scene_mode_state", 0) != 0) {
/* 617 */       return true;
/*     */     }
/* 619 */     return false;
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
/*     */   public void setOtaUserSettings(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOtaSetting() {
/* 662 */     return false;
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
/*     */   public boolean getOtaAutoSync() {
/* 674 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOtaAutoDownload() {
/* 685 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getOtaAutoInstallation() {
/* 695 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean download(String paramString) {
/* 705 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendUserDownloadRequest(String paramString1, String paramString2, String paramString3) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendUserDownloadCancel() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendUserDownloadSuspend() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendUserDownloadResume() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendVbfDecryptionKey(List<OTA.DecryptionKeyType> paramList) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendBSSIDDisplayedVersionInfo(String paramString1, String paramString2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeSlot() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNowTime() {
/* 744 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.sss'Z'");
/* 745 */     return simpleDateFormat.format(Calendar.getInstance().getTime());
/*     */   }
/*     */   
/*     */   public void setCallBack(IOtaSessionCallback paramIOtaSessionCallback) {
/* 749 */     this.mOtaSessionCallback = paramIOtaSessionCallback;
/*     */   }
/*     */   
/*     */   public IOtaSessionCallback getCallBack() {
/* 753 */     return this.mOtaSessionCallback;
/*     */   }
/*     */   
/*     */   public void setPriority(int paramInt) {
/* 757 */     this.mPriority = paramInt;
/*     */   }
/*     */   
/*     */   public void setIsRecovery(boolean paramBoolean) {
/* 761 */     this.mIsRecovery = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setOTATCAMParam(OpOTATCAMAssignmentParam paramOpOTATCAMAssignmentParam) {
/* 765 */     this.mOpOTATCAMAssignmentParam = paramOpOTATCAMAssignmentParam;
/*     */   }
/*     */   
/*     */   public OpOTATCAMAssignmentParam getOTATCAMParam() {
/* 769 */     return this.mOpOTATCAMAssignmentParam;
/*     */   }
/*     */   
/*     */   public void setOTAAssignmentParam(OpOTAAssignmentParam paramOpOTAAssignmentParam) {
/* 773 */     this.mOpOTAAssignmentParam = paramOpOTAAssignmentParam;
/*     */   }
/*     */   
/*     */   public void setInstallTime(int paramInt) {
/* 777 */     this.mInstallTime = paramInt;
/*     */   }
/*     */   
/*     */   public void setCarSignalManager(CarSignalManager paramCarSignalManager) {
/* 781 */     this.mCarSignalManager = paramCarSignalManager;
/*     */   }
/*     */   
/*     */   public void setCarScenemodManager(ECarXCarScenemodManager paramECarXCarScenemodManager) {
/* 785 */     this.mCarXCarScenemodManager = paramECarXCarScenemodManager;
/*     */   }
/*     */   
/*     */   public void setCarPowerManager(ECarXCarPowerManager paramECarXCarPowerManager) {
/* 789 */     this.mCarPowerManager = paramECarXCarPowerManager;
/*     */   }
/*     */   
/*     */   public void setOpOTAConnectivityStsParam(OpOTAConnectivityStsParam paramOpOTAConnectivityStsParam) {
/* 793 */     this.mOpOTAConnectivityStsParam = paramOpOTAConnectivityStsParam;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOpBSSIDDisplayedVersionSyncParam(OpBSSIDDisplayedVersionSyncParam paramOpBSSIDDisplayedVersionSyncParam) {
/* 798 */     this.mOpBSSIDDisplayedVersionSyncParam = paramOpBSSIDDisplayedVersionSyncParam;
/*     */   }
/*     */   
/*     */   public void setOpOTAWriteInstallationInstructionParam(OpOTAWriteInstallationInstructionParam paramOpOTAWriteInstallationInstructionParam) {
/* 802 */     this.mOpOTAWriteInstallationInstructionParam = paramOpOTAWriteInstallationInstructionParam;
/*     */   }
/*     */   
/*     */   public void setOpOTASetAssignmentFileInfoParam(OpOTASetAssignmentFileInfoParam paramOpOTASetAssignmentFileInfoParam) {
/* 806 */     this.mOpOTASetAssignmentFileInfoParam = paramOpOTASetAssignmentFileInfoParam;
/*     */   }
/*     */   
/*     */   public void setOOpAssignmentkeytoTargetECUReqParam(OpAssignmentkeytoTargetECUReqParam paramOpAssignmentkeytoTargetECUReqParam) {
/* 810 */     this.mOpAssignmentkeytoTargetECUReqParam = paramOpAssignmentkeytoTargetECUReqParam;
/*     */   }
/*     */   
/*     */   public void setOpOTAURLInfoReqParam(OpOTAURLInfoReqParam paramOpOTAURLInfoReqParam) {
/* 814 */     this.mOpOTAURLInfoReqParam = paramOpOTAURLInfoReqParam;
/*     */   }
/*     */   
/*     */   public void setSignatureCertificate(String paramString) {
/* 818 */     this.mSignatureCertificate = paramString;
/*     */   }
/*     */   
/*     */   public void setEstimatedinstallationtimeList(List<Integer> paramList) {
/* 822 */     this.estimatedinstallationtimeList = paramList;
/*     */   }
/*     */   
/*     */   public void setfilenameList(List<String> paramList) {
/* 826 */     this.filenameList = paramList;
/*     */   }
/*     */   
/*     */   public void setsoftwarepartsignatureList(List<String> paramList) {
/* 830 */     this.softwarepartsignatureList = paramList;
/*     */   }
/*     */   
/*     */   public void setUrlList(List<String> paramList) {
/* 834 */     this.urlList = paramList;
/*     */   }
/*     */   
/*     */   public void setFileSize(int paramInt) {
/* 838 */     this.fileSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAvailableUUID() {
/* 844 */     if (this.mOpOTAAssignmentParam != null) {
/* 845 */       return this.mOpOTAAssignmentParam.installationorder;
/*     */     }
/* 847 */     return SystemProperties.get("persist.ota.upgrade.uuid");
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ota\OtaSessionImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */