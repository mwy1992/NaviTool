/*     */ package com.ecarx.xui.adaptapi.ota;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Build;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.os.SystemProperties;
/*     */ import android.provider.Settings;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.IECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarPowerManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarScenemodManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.ota.AssignmentFileInfoParam;
/*     */ import ecarx.ota.IOtaServiceCallback;
/*     */ import ecarx.ota.OpAssignmentkeytoTargetECUReqParam;
/*     */ import ecarx.ota.OpBSSIDDisplayedVersionSyncParam;
/*     */ import ecarx.ota.OpOTAAppInsConsentParam;
/*     */ import ecarx.ota.OpOTAAssignmentParam;
/*     */ import ecarx.ota.OpOTAConnectivityStsParam;
/*     */ import ecarx.ota.OpOTASetAssignmentFileInfoParam;
/*     */ import ecarx.ota.OpOTASyncSchInstallTimeParam;
/*     */ import ecarx.ota.OpOTATCAMAssignmentParam;
/*     */ import ecarx.ota.OpOTAURLInfoReqParam;
/*     */ import ecarx.ota.OpOTAWriteInstallationInstructionParam;
/*     */ import ecarx.ota.OtaManager;
/*     */ import ecarx.ota.OtaServiceCallbackImpl;
/*     */ import ecarx.ota.SoftwarePartInstallationInstructionParam;
/*     */ import ecarx.ota.SpecifiedurlParam;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OTAImp
/*     */   extends OTA
/*     */ {
/*     */   private static final float CAR_LIMIT_SPEAD = 3.0F;
/*     */   private static final int DEFAULT_LANGUAGE = 4;
/*     */   public static final int GRANTED = 1;
/*     */   public static final int INST_DEFE_CON_NOK = 4;
/*     */   public static final int INST_DEFE_GEAR_NOK = 5;
/*     */   public static final int INST_DEFE_SCEMOD_NOK = 7;
/*     */   public static final int INST_DEFE_SPEED_NOK = 6;
/*     */   public static final int REVOKED = 2;
/*     */   public static final int SCHEDULED = 3;
/*     */   public static final String TAG = "OTAImp";
/*     */   private static final int VERSION_CODE_START_INDEX = 15;
/*     */   private CarSignalManager mCarSignalManager;
/*     */   private ECarXCarPowerManager mCarXCarPowerManager;
/*     */   private ECarXCarScenemodManager mCarXCarScenemodManager;
/*     */   private ECarXCarSetManager mCarXCarSetManager;
/*     */   private Context mContext;
/*     */   private final boolean mDebug;
/*     */   private ECarXCar mECarXCar;
/*  74 */   private final Object mECarXCarLock = new Object();
/*     */   
/*     */   private IECarXCar mECarXCarService;
/*     */   private HandlerThread mHandlerThread;
/*  78 */   HashMap<String, Integer> mLanguageMap = new HashMap<String, Integer>()
/*     */     {
/*     */       final OTAImp this$0;
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   private OTAHandler mOTAHandler;
/*     */ 
/*     */ 
/*     */   
/*     */   private OpOTAConnectivityStsParam mOpOTAConnectivityStsParam;
/*     */ 
/*     */ 
/*     */   
/*     */   private OtaCallback mOtaCallback;
/*     */ 
/*     */ 
/*     */   
/*     */   private OtaManager mOtaManager;
/*     */ 
/*     */ 
/*     */   
/*     */   private OtaSessionImp mOtaSession;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class OtaCallback
/*     */     extends OtaServiceCallbackImpl
/*     */   {
/*     */     final OTAImp this$0;
/*     */ 
/*     */ 
/*     */     
/* 113 */     HashMap<String, Integer> mStatusMap = new HashMap<String, Integer>()
/*     */       {
/*     */         final OTAImp.OtaCallback this$1;
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     HashMap<String, Integer> mReasonMap = new HashMap<String, Integer>()
/*     */       {
/*     */         final OTAImp.OtaCallback this$1;
/*     */       };
/*     */     
/*     */     static final int POSTINSTALLATION_STARTED = 14;
/*     */     
/*     */     static final int INVALID_STATUS = -1;
/*     */     
/*     */     static final int INVALID_REASON = -1;
/*     */     
/*     */     static final int INSTALLATION_FAIL_STATUS = 5;
/*     */     
/*     */     static final int INSTALLATION_FAIL_CRITICAL_STATUS = 6;
/*     */     
/*     */     static final int INSTALLATION_FAILED_FINISHED_STATUS = 13;
/*     */     
/*     */     static final int INSTALLATION_DEFERRED_STATUS = 3;
/*     */     
/*     */     static final int INSTALLATION_COMPLETED_STATUS = 2;
/*     */     
/*     */     static final int INSTALLATION_ABORTED_STATUS = 4;
/*     */     
/*     */     static final String INSTALLATION_ABORTED_REASON = "SYSTEM";
/*     */     
/*     */     static final int DOWNLOAD_STARTED_STATUS = 7;
/*     */     static final int DOWNLOAD_RESUME = 12;
/*     */     static final int DOWNLOAD_PAUSE = 11;
/*     */     static final int DOWNLOAD_FAILED_STATUS = 9;
/*     */     static final int DOWNLOAD_DISTRIBUTE_START_STATUS = 10;
/*     */     static final int DOWNLOAD_COMPLETED_STATUS = 1;
/*     */     static final int DOWNLOAD_ABORTED_STATUS = 8;
/*     */     
/*     */     public void onOTAAssignmentSyncInfo(OpOTAAssignmentParam param1OpOTAAssignmentParam) throws RemoteException {
/* 169 */       OTAImp.this.mOtaSession.setOTAAssignmentParam(param1OpOTAAssignmentParam);
/* 170 */       if (OTAImp.this.mOtaSession == null || OTAImp.this.mOtaSession.getCallBack() == null) {
/* 171 */         Log.e("OTAImp", "IOtaSessionCallback is null");
/*     */         return;
/*     */       } 
/* 174 */       if (OTAImp.this.mOtaSession.getCallBack() instanceof IOtaSessionNotification) {
/* 175 */         IOtaSessionNotification iOtaSessionNotification = (IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack();
/* 176 */         iOtaSessionNotification.onNotificationUpdate(1);
/* 177 */         Log.i("OTAImp", "onOTAAssignmentSyncInfo() called");
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTATCAMAssignmentInfo(OpOTATCAMAssignmentParam param1OpOTATCAMAssignmentParam) throws RemoteException {
/* 184 */       OTAImp.this.mOtaSession.setOTATCAMParam(param1OpOTATCAMAssignmentParam);
/* 185 */       onOTATCAMAssignmentInfo(param1OpOTATCAMAssignmentParam.newstatus, param1OpOTATCAMAssignmentParam.reason);
/*     */     }
/*     */     public void onOTATCAMAssignmentInfo(String param1String1, String param1String2) {
/*     */       byte b1, b2;
/* 189 */       param1String1 = param1String1.trim();
/* 190 */       param1String2 = param1String2.trim();
/* 191 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onOTATCAMAssignmentInfo("); stringBuilder.append(param1String1); stringBuilder.append(","); stringBuilder.append(param1String2); stringBuilder.append(")"); Log.i("OTAImp", stringBuilder.toString());
/* 192 */       if (this.mStatusMap.get(param1String1) != null) { b1 = ((Integer)this.mStatusMap.get(param1String1)).intValue(); } else { b1 = -1; }
/* 193 */        if (this.mReasonMap.get(param1String2) != null) { b2 = ((Integer)this.mReasonMap.get(param1String2)).intValue(); } else { b2 = -1; }
/*     */       
/* 195 */       if (OTAImp.this.mOtaSession == null) {
/* 196 */         Log.e("OTAImp", "mOtaSession is null");
/*     */         
/*     */         return;
/*     */       } 
/* 200 */       if (OTAImp.this.mOtaSession.getCallBack() == null) {
/* 201 */         Log.e("OTAImp", "IOtaSessionCallback is null");
/*     */         
/*     */         return;
/*     */       } 
/* 205 */       if (b1 == -1) {
/* 206 */         Log.e("OTAImp", "onOTATCAMAssignmentInfo INVALID_STATUS");
/*     */         
/*     */         return;
/*     */       } 
/* 210 */       if (b1 == 51) {
/* 211 */         OTAImp.this.mOtaSession.setInstallTime(0);
/*     */       }
/*     */       
/* 214 */       if (b1 == 2) {
/* 215 */         OTAImp.this.mOtaSession.getCallBack().onSucceeded();
/* 216 */       } else if (b1 == 3) {
/* 217 */         if (-1 != b2) {
/* 218 */           OTAImp.this.mOtaSession.getCallBack().onFailed(b2);
/*     */         } else {
/* 220 */           OTAImp.this.mOtaSession.getCallBack().onFailed(11);
/* 221 */           Log.e("OTAImp", "onOTATCAMAssignmentInfo INVALID_REASON");
/*     */         } 
/* 223 */       } else if (b1 == 13) {
/* 224 */         Log.d("OTAImp", "onFailed UPDATE_FAILED_INSTALLATION_FINISHED");
/* 225 */         OTAImp.this.mOtaSession.getCallBack().onFailed(39);
/* 226 */       } else if (b1 == 5) {
/* 227 */         Log.d("OTAImp", "onFailed UPDATE_FAILED_REASON_DEFAULT");
/* 228 */         if (param1String2.equals("ConfigurationMismatch")) {
/* 229 */           OTAImp.this.mOtaSession.getCallBack().onFailed(b2);
/*     */         } else {
/* 231 */           OTAImp.this.mOtaSession.getCallBack().onFailed(0);
/*     */         } 
/* 233 */       } else if (b1 == 6) {
/* 234 */         Log.d("OTAImp", "onFailed UPDATE_FAILED_CRITICAL_CONFIGURATION_MISMATCH_OR_OTHER");
/* 235 */         OTAImp.this.mOtaSession.getCallBack().onFailed(14);
/* 236 */       } else if (b1 == 4 && "SYSTEM".equals(param1String2)) {
/* 237 */         Log.d("OTAImp", "onSessionCanceled ");
/* 238 */         OTAImp.this.mOtaSession.getCallBack().onSessionCanceled();
/* 239 */       } else if (b1 == 7) {
/* 240 */         Log.d("OTAImp", "onNotificationUpdate  NOTIFICATION_DOWNLOAD_START");
/* 241 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(82);
/* 242 */       } else if (b1 == 10) {
/* 243 */         Log.d("OTAImp", "onNotificationUpdate  NOTIFICATION_DOWNLOAD_DISTRIBUTE_START");
/* 244 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(87);
/* 245 */       } else if (b1 == 8) {
/* 246 */         Log.d("OTAImp", "onNotificationUpdate  NOTIFICATION_DOWNLOAD_ABORTED");
/* 247 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(97);
/* 248 */       } else if (b1 == 9) {
/* 249 */         Log.d("OTAImp", "onNotificationUpdate  NOTIFICATION_DOWNLOAD_FIALED");
/* 250 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(88);
/* 251 */       } else if (b1 == 11) {
/* 252 */         Log.d("OTAImp", "onNotificationUpdate  NOTIFICATION_DOWNLOAD_PAUSE");
/* 253 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(89);
/* 254 */       } else if (b1 == 12) {
/* 255 */         Log.d("OTAImp", "onNotificationUpdate  NOTIFICATION_DOWNLOAD_RESUME");
/* 256 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(96);
/* 257 */       } else if (b1 == 14) {
/* 258 */         Log.d("OTAImp", "onNotificationUpdate  POSTINSTALLATION_STARTED");
/* 259 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(98);
/* 260 */       } else if (OTAImp.this.mOtaSession.getCallBack() instanceof IOtaSessionNotification) {
/* 261 */         Log.d("OTAImp", "onNotificationUpdate  other");
/* 262 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(b1);
/*     */       } else {
/* 264 */         Log.e("OTAImp", "onOTATCAMAssignmentInfo call failed !!!");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void onPostInstallation(OpOTATCAMAssignmentParam param1OpOTATCAMAssignmentParam) {
/* 270 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onPostInstallation ("); stringBuilder.append(param1OpOTATCAMAssignmentParam.newstatus); stringBuilder.append(","); stringBuilder.append(param1OpOTATCAMAssignmentParam.reason); stringBuilder.append(")"); Log.d("OTAImp", stringBuilder.toString());
/* 271 */       if (param1OpOTATCAMAssignmentParam.newstatus.equals("POSTINSTALLATION-STARTED")) {
/* 272 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(98);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTAAssignmentSyncErrorInfo(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTATCAMAssignmentErrorInfo(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onServiceUnavailableError() {}
/*     */ 
/*     */     
/*     */     public void onConnectivityStsInfo(OpOTAConnectivityStsParam param1OpOTAConnectivityStsParam) {
/* 290 */       OTAImp.access$102(OTAImp.this, param1OpOTAConnectivityStsParam);
/* 291 */       OTAImp.this.mOtaSession.setOpOTAConnectivityStsParam(param1OpOTAConnectivityStsParam);
/* 292 */       ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onConnectivityStatusRes(param1OpOTAConnectivityStsParam.connectionStatus);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTAAppInsConsentInfo(OpOTAAppInsConsentParam param1OpOTAAppInsConsentParam) throws RemoteException {
/* 298 */       if (param1OpOTAAppInsConsentParam.installationconsent == 1) {
/* 299 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(99);
/*     */         
/* 301 */         Log.d("OTAImp", "onOTAAppInsConsentInfo onNotificationUpdate (1)");
/* 302 */       } else if (param1OpOTAAppInsConsentParam.installationconsent == 2) {
/* 303 */         OTAImp.this.mOtaSession.setInstallTime(0);
/* 304 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(100);
/*     */         
/* 306 */         Log.d("OTAImp", "onOTAAppInsConsentInfo onNotificationUpdate (2)");
/* 307 */       } else if (param1OpOTAAppInsConsentParam.installationconsent == 3) {
/* 308 */         OTAImp.this.mOtaSession.setInstallTime(param1OpOTAAppInsConsentParam.deltatime);
/* 309 */         Calendar calendar = Calendar.getInstance();
/* 310 */         calendar.add(13, param1OpOTAAppInsConsentParam.deltatime);
/* 311 */         Log.d("OTAImp", "onOTAAppInsConsentInfo onNotificationUpdate (3)");
/* 312 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationAppOtaUpdateTime(calendar);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTASyncSchInstallTimeInfo(OpOTASyncSchInstallTimeParam param1OpOTASyncSchInstallTimeParam) throws RemoteException {
/* 319 */       OTAImp.this.mOtaSession.setInstallTime(param1OpOTASyncSchInstallTimeParam.schInstalldeltatime);
/* 320 */       if (param1OpOTASyncSchInstallTimeParam.schInstalldeltatime > 0) {
/* 321 */         Calendar calendar = Calendar.getInstance();
/* 322 */         calendar.add(13, param1OpOTASyncSchInstallTimeParam.schInstalldeltatime);
/* 323 */         ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationOtaUpdateTime(calendar);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void onBSSIDDisplayedVersionSyncInfo(OpBSSIDDisplayedVersionSyncParam param1OpBSSIDDisplayedVersionSyncParam) throws RemoteException {
/* 329 */       OTAImp.this.mOtaSession.setOpBSSIDDisplayedVersionSyncParam(param1OpBSSIDDisplayedVersionSyncParam);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTAURLInfoReq(OpOTAURLInfoReqParam param1OpOTAURLInfoReqParam) throws RemoteException {
/* 335 */       OTAImp.this.mOtaSession.setOpOTAURLInfoReqParam(param1OpOTAURLInfoReqParam);
/* 336 */       ArrayList<String> arrayList = new ArrayList();
/* 337 */       for (byte b = 0; b < param1OpOTAURLInfoReqParam.urlList.size(); b++) {
/* 338 */         arrayList.add(((SpecifiedurlParam)param1OpOTAURLInfoReqParam.urlList.get(b)).url);
/*     */       }
/* 340 */       OTAImp.this.mOtaSession.setUrlList(arrayList);
/* 341 */       OTAImp.this.mOtaSession.setFileSize(param1OpOTAURLInfoReqParam.fileSize);
/* 342 */       ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(86);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTAURLInfoError(int param1Int1, int param1Int2) throws RemoteException {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onAssignmentkeytoTargetECUReq(OpAssignmentkeytoTargetECUReqParam param1OpAssignmentkeytoTargetECUReqParam) throws RemoteException {
/* 353 */       OTAImp.this.mOtaSession.setOOpAssignmentkeytoTargetECUReqParam(param1OpAssignmentkeytoTargetECUReqParam);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onOTADownloadProgressInfo(int param1Int) throws RemoteException {
/* 359 */       ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onDownloadProgressUpdate(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSignatureCertificateReq(String param1String) throws RemoteException {
/* 365 */       OTAImp.this.mOtaSession.setSignatureCertificate(param1String);
/* 366 */       ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(85);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onWriteInstallationInstructionReq(OpOTAWriteInstallationInstructionParam param1OpOTAWriteInstallationInstructionParam) throws RemoteException {
/* 372 */       OTAImp.this.mOtaSession.setOpOTAWriteInstallationInstructionParam(param1OpOTAWriteInstallationInstructionParam);
/* 373 */       ArrayList<Integer> arrayList = new ArrayList();
/* 374 */       for (byte b = 0; b < param1OpOTAWriteInstallationInstructionParam.list.size(); b++) {
/* 375 */         arrayList.add(Integer.valueOf(((SoftwarePartInstallationInstructionParam)param1OpOTAWriteInstallationInstructionParam.list.get(b)).estimatedinstallationtime));
/*     */       }
/* 377 */       OTAImp.this.mOtaSession.setEstimatedinstallationtimeList(arrayList);
/* 378 */       ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(83);
/*     */     }
/*     */     
/*     */     private OtaCallback() {}
/*     */     
/*     */     public void onAssignmentFileInfoReq(OpOTASetAssignmentFileInfoParam param1OpOTASetAssignmentFileInfoParam) throws RemoteException {
/* 384 */       OTAImp.this.mOtaSession.setOpOTASetAssignmentFileInfoParam(param1OpOTASetAssignmentFileInfoParam);
/* 385 */       ArrayList<String> arrayList1 = new ArrayList();
/* 386 */       ArrayList<String> arrayList2 = new ArrayList();
/* 387 */       for (byte b = 0; b < param1OpOTASetAssignmentFileInfoParam.list.size(); b++) {
/* 388 */         arrayList1.add(((AssignmentFileInfoParam)param1OpOTASetAssignmentFileInfoParam.list.get(b)).filename);
/* 389 */         arrayList2.add(((AssignmentFileInfoParam)param1OpOTASetAssignmentFileInfoParam.list.get(b)).softwarepartsignature);
/*     */       } 
/* 391 */       OTAImp.this.mOtaSession.setfilenameList(arrayList1);
/* 392 */       OTAImp.this.mOtaSession.setsoftwarepartsignatureList(arrayList2);
/* 393 */       ((IOtaSessionNotification)OTAImp.this.mOtaSession.getCallBack()).onNotificationUpdate(84);
/*     */     }
/*     */   }
/*     */   
/*     */   private OTAImp(Context paramContext) {
/* 398 */     if (Build.IS_USER) {
/* 399 */       this.mDebug = false;
/*     */     } else {
/* 401 */       this.mDebug = SystemProperties.getBoolean("persist.adaptapi.debug", false);
/*     */     } 
/* 403 */     this.mContext = paramContext;
/* 404 */     this.mOtaManager = OtaManager.getInstance(this.mContext);
/* 405 */     if (this.mOtaManager != null) {
/* 406 */       this.mOtaSession = new OtaSessionImp(this.mContext, this.mOtaManager);
/*     */     }
/* 408 */     this.mHandlerThread = new HandlerThread("OTAImplHandler");
/* 409 */     this.mHandlerThread.start();
/* 410 */     this.mOTAHandler = new OTAHandler(this.mHandlerThread.getLooper());
/* 411 */     initEcarxCar();
/*     */   }
/*     */   class null extends HashMap<String, Integer> {
/*     */     final OTAImp.OtaCallback this$1; null() {
/*     */       put("DOWNLOAD-COMPLETED", Integer.valueOf(18));
/*     */       put("INSTALLATION-PENDING", Integer.valueOf(33));
/*     */       put("INSTALLATION-COMPLETED", Integer.valueOf(2));
/*     */       put("INSTALLATION-DEFERRED", Integer.valueOf(3));
/*     */       put("INSTALLATION-FAILED", Integer.valueOf(5));
/*     */       put("INSTALLATION-FAILED-CRITICAL", Integer.valueOf(6));
/*     */       put("INSTALLATION-ABORTED", Integer.valueOf(4));
/*     */       put("INSTALLATION-FINISHED", Integer.valueOf(13));
/*     */       put("RESET-System", Integer.valueOf(81));
/*     */       put("SCHEDULE-TIME-AND-DATE-OCCURS", Integer.valueOf(51));
/*     */       put("DOWNLOAD-STARTED", Integer.valueOf(7));
/*     */       put("DOWNLOAD-DISTRIBUTE-START", Integer.valueOf(10));
/*     */       put("DOWNLOAD-ABORTED", Integer.valueOf(8));
/*     */       put("DISTRIBUTE-DOWNLOADABORTED", Integer.valueOf(8));
/*     */       put("DOWNLOAD-FAILED", Integer.valueOf(9));
/*     */       put("DOWNLOAD-DISTRIBUTE-PAUSE", Integer.valueOf(11));
/*     */       put("DOWNLOAD-DISTRIBUTE-RESUM", Integer.valueOf(12));
/*     */       put("POSTINSTALLATION-STARTED", Integer.valueOf(14));
/* 433 */     } } public void initEcarxCar() { Log.d("OTAImp", "OTAImp initEcarxCar start");
/*     */     try {
/* 435 */       synchronized (this.mECarXCarLock) {
/*     */         
/* 437 */         IBinder iBinder = ServiceManager.getService("ecarxcar_service");
/*     */         this.mECarXCarService = IECarXCar.Stub.asInterface(iBinder);
/* 439 */         if (this.mContext != null && this.mECarXCarService != null) {
/* 440 */           this.mECarXCar = ECarXCar.createCar(this.mContext, this.mECarXCarService);
/*     */         }
/*     */         
/* 443 */         if (this.mECarXCar != null) {
/* 444 */           ECarXCar eCarXCar = this.mECarXCar; ECarXCar.CarServiceDieCallback carServiceDieCallback = new ECarXCar.CarServiceDieCallback() {
/*     */               final OTAImp this$0;
/*     */               
/* 447 */               public void onServiceDeath() { OTAImp.this.callECarXCarServiceDeath(); }
/*     */             };
/*     */           super(this);
/*     */           eCarXCar.registerDieCallback(carServiceDieCallback);
/* 451 */           this.mCarSignalManager = (CarSignalManager)this.mECarXCar.getCarManager("car_signal");
/* 452 */           this.mCarXCarSetManager = (ECarXCarSetManager)this.mECarXCar.getCarManager("car_publicattribute");
/* 453 */           this.mCarXCarPowerManager = this.mCarXCarSetManager.getECarXCarPowerManager();
/* 454 */           this.mCarXCarScenemodManager = this.mCarXCarSetManager.getECarXCarScenemodManager();
/* 455 */           this.mOtaSession.setCarSignalManager(this.mCarSignalManager);
/* 456 */           this.mOtaSession.setCarPowerManager(this.mCarXCarPowerManager);
/* 457 */           this.mOtaSession.setCarScenemodManager(this.mCarXCarScenemodManager);
/*     */         } else {
/* 459 */           this.mOTAHandler.sendEmptyMessageDelayed(1, 100L);
/*     */         } 
/*     */       } 
/* 462 */     } catch (Exception exception) {
/* 463 */       exception.printStackTrace();
/*     */     }  }
/*     */   class null extends HashMap<String, Integer> {
/*     */     final OTAImp.OtaCallback this$1;
/*     */     null() { put("THEFT-PROTECTION", Integer.valueOf(13)); put("USAGEMODE-NOT-ALLOWED", Integer.valueOf(12)); put("UM-IS-NOT-EQUAL-TO-UM-START", Integer.valueOf(12)); put("ENERGY-LOW", Integer.valueOf(4)); put("CONNECTIVITY", Integer.valueOf(3)); put("TIMEOUT", Integer.valueOf(5)); put("ASSIGN-BOOT-DENIED-NOT-FOUND", Integer.valueOf(1)); put("ASSIGN-BOOT-DENIED-SERVICE-NA", Integer.valueOf(9)); put("ASSIGN-BOOT-DENIED-LOCAL-STORAGE", Integer.valueOf(10)); put("LOCKING", Integer.valueOf(8)); put("OTHER-FAILURE", Integer.valueOf(11)); put("OTHER", Integer.valueOf(11)); put("Propulsion", Integer.valueOf(37)); put("HV-System-energy-level", Integer.valueOf(24)); put("HV-System-failure", Integer.valueOf(25)); put("Regret-window-timeout", Integer.valueOf(32)); put("GEARS NOK", Integer.valueOf(33)); put("CONNECTIVITY NOK", Integer.valueOf(34)); put("SPEED NOK", Integer.valueOf(35)); put("SCENE MODE NOK", Integer.valueOf(36));
/*     */       put("ConfigurationMismatch", Integer.valueOf(38)); } } public static OTAImp create(Context paramContext) { // Byte code:
/*     */     //   0: ldc com/ecarx/xui/adaptapi/ota/OTAImp
/*     */     //   2: monitorenter
/*     */     //   3: aload_0
/*     */     //   4: ifnonnull -> 12
/*     */     //   7: ldc com/ecarx/xui/adaptapi/ota/OTAImp
/*     */     //   9: monitorexit
/*     */     //   10: aconst_null
/*     */     //   11: areturn
/*     */     //   12: new com/ecarx/xui/adaptapi/ota/OTAImp
/*     */     //   15: dup
/*     */     //   16: aload_0
/*     */     //   17: invokespecial <init> : (Landroid/content/Context;)V
/*     */     //   20: astore_0
/*     */     //   21: ldc com/ecarx/xui/adaptapi/ota/OTAImp
/*     */     //   23: monitorexit
/*     */     //   24: aload_0
/*     */     //   25: areturn
/*     */     //   26: astore_0
/*     */     //   27: ldc com/ecarx/xui/adaptapi/ota/OTAImp
/*     */     //   29: monitorexit
/*     */     //   30: aload_0
/*     */     //   31: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #426	-> 3
/*     */     //   #427	-> 7
/*     */     //   #429	-> 12
/*     */     //   #425	-> 26
/*     */     // Exception table:
/*     */     //   from	to	target	type
/* 468 */     //   12	21	26	finally } private void callECarXCarServiceDeath() { synchronized (this.mECarXCarLock) {
/* 469 */       this.mECarXCar = null;
/* 470 */       this.mECarXCarService = null;
/*     */       return;
/*     */     }  }
/*     */ 
/*     */   
/*     */   private class OTAHandler
/*     */     extends Handler {
/*     */     static final int INIT_CAR_SERVICE_MSG = 1;
/*     */     final OTAImp this$0;
/*     */     
/*     */     OTAHandler(Looper param1Looper) {
/* 481 */       super(param1Looper);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 486 */       if (param1Message.what == 1) {
/* 487 */         OTAImp.this.initEcarxCar();
/*     */       }
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
/*     */   public FunctionStatus isOtaTypeSupported(int paramInt) {
/* 500 */     return FunctionStatus.notactive;
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
/*     */   public boolean supportNoRecoveryOta() {
/* 512 */     return false;
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
/*     */   public IOtaSession requestOta(boolean paramBoolean, IOtaSessionCallback paramIOtaSessionCallback) {
/* 527 */     return requestOta(2, 0, paramBoolean, paramIOtaSessionCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   public IOtaSession requestOta(int paramInt, IOtaSessionCallback paramIOtaSessionCallback) {
/* 532 */     return requestOta(paramInt, 0, false, paramIOtaSessionCallback);
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
/*     */   public IOtaSession requestOta(int paramInt, boolean paramBoolean, IOtaSessionCallback paramIOtaSessionCallback) {
/* 546 */     return requestOta(2, paramInt, paramBoolean, paramIOtaSessionCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   private IOtaSession requestOta(int paramInt1, int paramInt2, boolean paramBoolean, IOtaSessionCallback paramIOtaSessionCallback) {
/* 551 */     if (this.mDebug) {
/* 552 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("requestOta("); stringBuilder.append(paramInt1); stringBuilder.append(","); stringBuilder.append(paramInt2); stringBuilder.append(","); stringBuilder.append(paramBoolean); stringBuilder.append(")"); Log.i("OTAImp", stringBuilder.toString());
/*     */     } 
/* 554 */     if (paramInt1 != 2) {
/* 555 */       Log.e("OTAImp", "OtaType is not OTA_TYPE_WHOLE_CAR, NOT SUPPORT!!!");
/* 556 */       return null;
/*     */     } 
/* 558 */     if (paramIOtaSessionCallback instanceof IOtaSessionNotification)
/* 559 */     { if (this.mDebug) {
/* 560 */         Log.i("OTAImp", "callback is IOtaSessionNotification");
/*     */       }
/* 562 */       this.mOtaSession.setCallBack(paramIOtaSessionCallback); }
/* 563 */     else { if (paramIOtaSessionCallback instanceof IOtaSessionCallback)
/* 564 */       { if (this.mDebug) {
/* 565 */           Log.i("OTAImp", "callback is IOtaSessionCallback");
/*     */         }
/* 567 */         this.mOtaSession.setCallBack(paramIOtaSessionCallback);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 572 */         this.mOtaSession.setPriority(paramInt2);
/* 573 */         this.mOtaSession.setIsRecovery(paramBoolean);
/* 574 */         this.mOtaSession.checkUpdate();
/* 575 */         this.mOtaManager.requestSyncSchInstallTime();
/* 576 */         this.mOtaCallback = new OtaCallback();
/* 577 */         this.mOtaManager.registerCallback(this.mContext.getPackageName(), (IOtaServiceCallback)this.mOtaCallback);
/* 578 */         return this.mOtaSession; }  Log.e("OTAImp", "callback is not IOtaSessionNotification or IOtaSessionCallback, NOT SUPPORT!!!"); return null; }  this.mOtaSession.setPriority(paramInt2); this.mOtaSession.setIsRecovery(paramBoolean); this.mOtaSession.checkUpdate(); this.mOtaManager.requestSyncSchInstallTime(); this.mOtaCallback = new OtaCallback(); this.mOtaManager.registerCallback(this.mContext.getPackageName(), (IOtaServiceCallback)this.mOtaCallback); return this.mOtaSession;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseOtaCallback(IOtaSessionCallback paramIOtaSessionCallback) {
/* 589 */     this.mOtaSession.setCallBack(null);
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
/*     */   public boolean installPackage(IOtaSession paramIOtaSession, String paramString)
/*     */   {
/* 605 */     if (this.mDebug) {
/* 606 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("installPackage("); stringBuilder.append(paramString); stringBuilder.append(")"); Log.i("OTAImp", stringBuilder.toString());
/*     */     } 
/* 608 */     paramIOtaSession = this.mOtaSession;
/* 609 */     if (needResourceGroup()) {
/* 610 */       this.mOtaManager.requestResourceGroupWithPriority();
/*     */     }
/*     */     
/*     */     try {
/* 614 */       StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("installPackage GearLvrIndcn = "); stringBuilder1.append(this.mCarSignalManager.getGearLvrIndcn()); Log.d("OTAImp", stringBuilder1.toString());
/* 615 */       if (this.mCarSignalManager.getGearLvrIndcn() != 0) {
/* 616 */         this.mOtaManager.setInstallationConsent(this.mOtaSession.getAvailableUUID(), 5, 0);
/* 617 */         return false;
/*     */       } 
/*     */       
/* 620 */       stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("installPackage speed = "); stringBuilder1.append(this.mCarSignalManager.getVehSpdLgtA() * 0.00391D * 3.6D); Log.d("OTAImp", stringBuilder1.toString());
/* 621 */       if (this.mCarSignalManager.getVehSpdLgtA() * 0.00391D * 3.6D > 3.0D) {
/* 622 */         this.mOtaManager.setInstallationConsent(this.mOtaSession.getAvailableUUID(), 6, 0);
/* 623 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 633 */       int i = Settings.Global.getInt(this.mContext.getContentResolver(), "scene_mode_state", 0);
/* 634 */       if (i != 0) {
/* 635 */         this.mOtaManager.setInstallationConsent(this.mOtaSession.getAvailableUUID(), 7, 0);
/* 636 */         return false;
/*     */       } 
/*     */       
/* 639 */       StringBuilder stringBuilder2 = new StringBuilder(); this(); stringBuilder2.append("installPackage connectionStatus = "); if (this.mOpOTAConnectivityStsParam != null)
/* 640 */       { Boolean bool = Boolean.valueOf(this.mOpOTAConnectivityStsParam.connectionStatus); } else { stringBuilder1 = null; }  stringBuilder2.append(stringBuilder1); String str = stringBuilder2.toString(); Log.d("OTAImp", str);
/* 641 */       OpOTAConnectivityStsParam opOTAConnectivityStsParam = this.mOpOTAConnectivityStsParam; i = 4; if (opOTAConnectivityStsParam != null && !this.mOpOTAConnectivityStsParam.connectionStatus) {
/*     */         
/* 643 */         this.mOtaManager.setInstallationConsent(this.mOtaSession.getAvailableUUID(), 4, 0);
/* 644 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 652 */       OtaManager otaManager = this.mOtaManager;
/* 653 */       if (this.mLanguageMap.get(Locale.getDefault().getLanguage()) != null)
/* 654 */         i = ((Integer)this.mLanguageMap.get(Locale.getDefault().getLanguage())).intValue();  otaManager.setOTAHMILanguageSettings(i);
/* 655 */       this.mOtaManager.setInstallationConsent(this.mOtaSession.getAvailableUUID(), 1, 0);
/* 656 */       return true;
/*     */     } catch (CarNotConnectedException carNotConnectedException) {
/*     */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("installPackage CarNotConnectedException : "); stringBuilder.append(carNotConnectedException.toString()); Log.e("OTAImp", stringBuilder.toString());
/*     */       return false;
/*     */     }  } private boolean needResourceGroup() { try {
/* 661 */       int i = this.mCarSignalManager.getVehModMngtGlbSafe1CarModSts1();
/* 662 */       if (i == 0 || i == 2) { CarSignalManager carSignalManager = this.mCarSignalManager;
/* 663 */         i = carSignalManager.getVehModMngtGlbSafe1UsgModSts(); if (i != 0)
/*     */         {
/* 665 */           return true; }  }
/*     */       
/* 667 */       return false;
/* 668 */     } catch (CarNotConnectedException carNotConnectedException) {
/* 669 */       Log.e("OTAImp", "needResourceGroup get carMode error!");
/* 670 */       return false;
/*     */     }  }
/*     */ 
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
/* 683 */     return 0;
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
/*     */   public String getSysVersionName() {
/* 695 */     return null;
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
/*     */   public int getOtaBaseSysVersionCode() {
/* 707 */     return 0;
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
/*     */   public String getOtaBaseSysVersionName() {
/* 719 */     return null;
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
/*     */   public String getOtaPkgRootPath() {
/* 734 */     return "/ota_download/";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setOtaUpdateTime(Calendar paramCalendar) {
/* 739 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ota\OTAImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */