package com.ecarx.xui.adaptapi.device.ext;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ISystemMode {
  public static final int ENTERTAINMENT_MODE_OFF = 1049089;
  
  public static final int ENTERTAINMENT_MODE_ON = 1049090;
  
  public static final int ENTERTAINMENT_MODE_UNKNOWN = -1;
  
  public static final int INFOTAINMENT_MODE_OFF = 1052673;
  
  public static final int INFOTAINMENT_MODE_ON = 1052674;
  
  public static final int INFOTAINMENT_MODE_UNKNOWN = -1;
  
  public static final int PARTIAL_MODE_OFF = 1048833;
  
  public static final int PARTIAL_MODE_ON = 1048834;
  
  public static final int PARTIAL_MODE_UNKNOWN = -1;
  
  public static final int POWER_ES_OFF = 1056769;
  
  public static final int POWER_ES_ON = 1056770;
  
  public static final int POWER_ES_UNKNOWN = -1;
  
  public static final int SYSTEM_MODE_ENTERTAINMENT = 1049088;
  
  public static final int SYSTEM_MODE_INFOTAINMENT = 1052672;
  
  public static final int SYSTEM_MODE_PARTIAL = 1048832;
  
  public static final int SYSTEM_MODE_POWER_ES = 1056768;
  
  public static final int SYSTEM_MODE_STATE_UNKNOWN = -1;
  
  @VendorDefinition(author = "@ECARX", date = "2022-03-28", project = "kx11")
  void closeBootUpAnimation();
  
  int getSystemModeState(int paramInt);
  
  boolean registerListener(int paramInt, ISystemModeListener paramISystemModeListener);
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-23", project = "Lambda")
  void setProvisionStatus(int paramInt);
  
  boolean unregisterListener(ISystemModeListener paramISystemModeListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EntertainmentModeState {}
  
  public static interface ISystemModeListener {
    void onSystemModeStateChanged(int param1Int1, int param1Int2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InfotainmentModeState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ModeState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PartialModeState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PowerModeState {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProvisionStatus {
    public static final int END = 1;
    
    public static final int START = 0;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SystemMode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\ISystemMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */