package com.ecarx.xui.adaptapi.ota;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;

public interface IOtaSessionNotification extends IOtaSessionCallback {
  @VendorDefinition(author = "@ECARX", date = "2022-08-09", project = "ALL")
  public static final int NOTIFICATION_APP_INSTALLATION_CONSENT_GRANTED = 99;
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-09", project = "ALL")
  public static final int NOTIFICATION_APP_INSTALLATION_CONSENT_REVOKED = 100;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_ASSIGNMENT_FILE_INFO = 84;
  
  public static final int NOTIFICATION_DOWNLOADING = 17;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_ABORTED = 97;
  
  public static final int NOTIFICATION_DOWNLOAD_COMPLETED = 18;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_DISTRIBUTE_START = 87;
  
  public static final int NOTIFICATION_DOWNLOAD_ERROR = 19;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_FIALED = 88;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_PAUSE = 89;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_RESUME = 96;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_START = 82;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_DOWNLOAD_URL = 86;
  
  public static final int NOTIFICATION_ESTIMATED_TIME_UPDATE = 65;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_INSTALLATION_INSTUCTION = 83;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-23", project = "ALL")
  public static final int NOTIFICATION_INSTALLATION_RESULT_CHECKING = 98;
  
  public static final int NOTIFICATION_INSTALLING = 33;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int NOTIFICATION_INSTALL_ABORTED = 34;
  
  public static final int NOTIFICATION_NEW_VERSION = 1;
  
  @VendorDefinition(author = "@ECARX", date = "2021-10-13", project = "KX11&smart")
  public static final int NOTIFICATION_OTA_CERTIFICATE = 85;
  
  @VendorDefinition(author = "@ECARX", date = "2021-02-26", project = "FY11", requirement = "")
  public static final int NOTIFICATION_REMIND_POPUP_ENABLE = 35;
  
  @VendorDefinition(author = "@ECARX", date = "2021-4-22", project = "KX11/EX11")
  public static final int NOTIFICATION_RESET = 81;
  
  public static final int NOTIFICATION_TIME_OVERDUE = 52;
  
  public static final int NOTIFICATION_TIME_REMIND = 51;
  
  public static final int NOTIFICATION_TIME_SET_FAILED = 50;
  
  public static final int NOTIFICATION_TIME_SET_SUCCEED = 49;
  
  void onConnectivityStatusRes(boolean paramBoolean);
  
  void onDownloadProgressUpdate(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-09", project = "ALL", requirement = "")
  void onNotificationAppOtaUpdateTime(Calendar paramCalendar);
  
  @VendorDefinition(author = "@ECARX", date = "2022-07-06", project = "ALL", requirement = "")
  void onNotificationOtaUpdateTime(Calendar paramCalendar);
  
  void onNotificationUpdate(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-16", project = "smart", requirement = "")
  void onOtaUserSettingsUpdate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NotificationType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ota\IOtaSessionNotification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */