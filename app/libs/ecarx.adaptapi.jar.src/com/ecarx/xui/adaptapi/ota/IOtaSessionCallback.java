package com.ecarx.xui.adaptapi.ota;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IOtaSessionCallback {
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_DOWNLOADING_EXCEPTION = 101;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_HASH_CHECK_FAILED = 102;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_KEY_AUTH_FAILED = 98;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_KEY_AUTH_SUCCEED = 97;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_REQUEST_ACCEPT = 96;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_REQUEST_VBF_DECRYPTION_KEY = 103;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_RESTORE_KEY_FAILED = 104;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_SSOC_FTP_TRANSMISSION_FAILED = 106;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_TCAM_NETWORK_ACCESS_FAILED = 99;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_URL_INVALID = 52;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_VBF_DECRYPTION_FAILED = 105;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int DOWNLOAD_RESPONSE_VBF_EXTRACTION_FAILED = 107;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int INSTALLATION_RESPONSE_BLOCK_VERIFICATION_FAILED_MSOC = 108;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int INSTALLATION_RESPONSE_BLOCK_VERIFICATION_FAILED_SSOC = 111;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int INSTALLATION_RESPONSE_DIFF_REDUCE_FAILED_MSOC = 109;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int INSTALLATION_RESPONSE_DIFF_REDUCE_FAILED_SSOC = 112;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int INSTALLATION_RESPONSE_FLASH_PARTITION_FAILED_MSOC = 110;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  public static final int INSTALLATION_RESPONSE_FLASH_PARTITION_FAILED_SSOC = 113;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_CHARGE_CONNECTED = 15;
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-10", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_CONFIGURATION_MISMATCH = 38;
  
  public static final int UPDATE_FAILED_CONFIG_ERROR = 6;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_CONNECTIVITY_NOK = 34;
  
  @VendorDefinition(author = "@ECARX", date = "2020-10-12", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_CRITICAL_CONFIGURATION_MISMATCH_OR_OTHER = 14;
  
  public static final int UPDATE_FAILED_DOOR_LOCKING = 8;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_GEARS_NOK = 33;
  
  @VendorDefinition(author = "@ECARX", date = "2021-3-8", project = "FY11", requirement = "")
  public static final int UPDATE_FAILED_GEAR_POSITION = 22;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_HV_SYSTEM_FAILURE = 25;
  
  @VendorDefinition(author = "@ECARX", date = "2022-02-11", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_INSTALLATION_FINISHED = 39;
  
  public static final int UPDATE_FAILED_LOW_BATTERY = 4;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_LOW_HV_SYSTEM_ENERGY_LEVEL = 24;
  
  public static final int UPDATE_FAILED_MEMORY_ERROR = 10;
  
  public static final int UPDATE_FAILED_NETWORK_ERROR = 3;
  
  @VendorDefinition(author = "@ECARX", date = "2021-3-8", project = "FY11", requirement = "")
  public static final int UPDATE_FAILED_POWER_ON_FAILED = 19;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-03", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_PROPULSION = 37;
  
  public static final int UPDATE_FAILED_REASON_DEFAULT = 0;
  
  public static final int UPDATE_FAILED_REASON_INSUFFICIENT_STORAGE = 2;
  
  public static final int UPDATE_FAILED_REASON_INVALID_PACKAGE = 1;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_REGRET_WINDOW_TIMEOUT = 32;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_SCENE_MODE_NOK = 36;
  
  public static final int UPDATE_FAILED_SERVICE_ERROR = 9;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart", requirement = "")
  public static final int UPDATE_FAILED_SPEED_NOK = 35;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_SYSTEM = 18;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_TEMPERATURE_LOW = 16;
  
  @VendorDefinition(author = "@ECARX", date = "2021-3-8", project = "FY11", requirement = "")
  public static final int UPDATE_FAILED_THEFT_DOOR = 23;
  
  @VendorDefinition(author = "@ECARX", date = "2021-3-8", project = "FY11", requirement = "")
  public static final int UPDATE_FAILED_THEFT_HOOD = 20;
  
  @VendorDefinition(author = "@ECARX", date = "2021-3-8", project = "FY11", requirement = "")
  public static final int UPDATE_FAILED_THEFT_TRUNK = 21;
  
  public static final int UPDATE_FAILED_TIME_OUT = 5;
  
  public static final int UPDATE_FAILED_UPDATING_ERROR = 11;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "ALL", requirement = "XQ2020081271217")
  public static final int UPDATE_FAILED_VEHICLE_IN_USE = 12;
  
  @VendorDefinition(author = "@ECARX", date = "2020-08-24", project = "ALL", requirement = "XQ2020081271217")
  public static final int UPDATE_FAILED_VEHICLE_NOT_SECURED = 13;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int UPDATE_FAILED_WINDOW = 17;
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  void onDownloadProgressReport(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  void onDownloadResponse(int paramInt);
  
  void onFailed(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  void onInstallProgressReport(int paramInt1, int paramInt2, int paramInt3);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  void onInstallationResponse(int paramInt);
  
  void onProgressUpdate(int paramInt);
  
  void onRebootingAfterOta();
  
  void onSessionCanceled();
  
  void onShouldBeginInstall();
  
  void onSucceeded();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-27", project = "lambda", requirement = "")
  void requestBSSIDDisplayedVersionInfo();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DownloadResponse {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InstallationResponse {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface UpdateFailedReason {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ota\IOtaSessionCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */