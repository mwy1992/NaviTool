package com.ecarx.xui.adaptapi.ota;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.List;

public interface IOtaSession {
  public static final int DOWNLOAD_FAILED = 4;
  
  public static final int DOWNLOAD_SUCCESS = 9;
  
  public static final int DOWNLOAD_URL_INVALID = 5;
  
  public static final int FILE_VERIFICATION_FAILED = 6;
  
  public static final int NONE = 11;
  
  public static final int OCSP_FAILED = 7;
  
  public static final int OCSP_SUCCESS = 10;
  
  public static final int OCSP_VERIFICATION_FAILED = 8;
  
  public static final int OTA_MODE_DOWNLOAD_INSTALL = 2;
  
  public static final int OTA_MODE_INSTALL_DIRECTLY = 1;
  
  public static final int OTA_MODE_SELF_DOWNLOAD_INSTALL = 3;
  
  public static final int OTA_PRIORITY_HIGH = 2;
  
  public static final int OTA_PRIORITY_LOW = 0;
  
  public static final int OTA_PRIORITY_NORMAL = 1;
  
  public static final int OTA_PRIORITY_SET_TIME = 3;
  
  public static final int OTA_PRIORITY_UNKNOWN = 0;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "KX11-FY11", requirement = "XQ2020081271217")
  public static final int OTA_UPDATE_INPROGRESS_STATE_IDLE = 1;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-23", project = "ALL")
  public static final int OTA_UPDATE_INPROGRESS_STATE_IMMEDIATE = 3;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "KX11-FY11", requirement = "XQ2020081271217")
  public static final int OTA_UPDATE_INPROGRESS_STATE_UPGRADE = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-26", project = "KX11", requirement = "")
  public static final int REGRET_TERMINATE = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-26", project = "KX11", requirement = "")
  public static final int REGRET_TIMEOUT = 1;
  
  boolean cancel();
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "ALL", requirement = "XQ2020081271217")
  boolean cancelOtaUpgradeTime();
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-27", project = "Lambda")
  void changeSlot();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  void checkConnectivityStatus();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "smart", requirement = "")
  boolean checkSceneModeAlive();
  
  boolean checkUpdate();
  
  boolean couldBeginInstallRightNow();
  
  boolean download();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  boolean download(String paramString);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "EF1E")
  String getCurrentCarVersionName();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  List<String> getDownloadUrls();
  
  int getEstimatedInstallationTime();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  List<String> getFileNames();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  List<Integer> getInstallationtimes();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  boolean getOtaAutoDownload();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  boolean getOtaAutoInstallation();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  boolean getOtaAutoSync();
  
  int getOtaBaseSysVersionCode();
  
  String getOtaBaseSysVersionName();
  
  int getOtaMode();
  
  int getOtaPriority();
  
  int getOtaProgress();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  boolean getOtaSetting();
  
  int getOtaType();
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  int getOtaUpdateInProgressState();
  
  @Deprecated
  Calendar getOtaUpdateTime();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  String getSignatureCertificate();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  List<String> getSoftwareSignature();
  
  String getSysBssId();
  
  int getSysVersionCode();
  
  String getSysVersionName();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  int getTotalSize();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  String getUUID();
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "ALL", requirement = "XQ2020081271217")
  String getUpgradeInfo();
  
  boolean ifSystemWillRebootAfterOta();
  
  boolean isInstallationStarted();
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  boolean isPopupEnable();
  
  boolean isRecoveryOta();
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  void reportDownloadFailedName(String paramString);
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-06", project = "ALL", requirement = "")
  void requestOtaUpdateTime();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "lambda", requirement = "")
  void sendBSSIDDisplayedVersionInfo(String paramString1, String paramString2);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "lambda", requirement = "")
  void sendUserDownloadCancel();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "lambda", requirement = "")
  void sendUserDownloadRequest(String paramString1, String paramString2, String paramString3);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "lambda", requirement = "")
  void sendUserDownloadResume();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "lambda", requirement = "")
  void sendUserDownloadSuspend();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-28", project = "lambda", requirement = "")
  void sendVbfDecryptionKey(List<OTA.DecryptionKeyType> paramList);
  
  @VendorDefinition(author = "@ECARX", date = "2021-01-26", project = "KX11", requirement = "")
  void setInstallRegretState(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  void setOTADownloadSize(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  void setOTADownloadStatus(int paramInt1, int paramInt2);
  
  boolean setOtaUpdateTime(Calendar paramCalendar);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  void setOtaUserSettings(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "KX11-FY11", requirement = "XQ2020081271217")
  boolean setPowerState(int paramInt);
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2021-01-26", project = "KX11", requirement = "")
  public static @interface InstallRegretState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OTADownloadStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OTADownloadreason {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OtaMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OtaPriority {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "KX11-FY11", requirement = "XQ2020081271217")
  public static @interface OtaUpdateInProgressState {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ota\IOtaSession.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */