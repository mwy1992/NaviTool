package com.ecarx.xui.adaptapi.car.diagnostics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDiagnosticMonitor {
  public static final int MONITOR_STATUS_FAULT = 2;
  
  public static final int MONITOR_STATUS_RUNNING = 1;
  
  public static final int MONITOR_STATUS_UNKNOWN = 0;
  
  public static final int MONITOR_TYPE_AUD_STATUS = 8195;
  
  public static final int MONITOR_TYPE_BT_LINK_QUALITY = 4116;
  
  public static final int MONITOR_TYPE_CAN_STATUS = 12290;
  
  public static final int MONITOR_TYPE_CCSM_STATUS = 8199;
  
  public static final int MONITOR_TYPE_CPU_USAGE = 4113;
  
  public static final int MONITOR_TYPE_CSD_STATUS = 8194;
  
  public static final int MONITOR_TYPE_CSD_TEMP = 4098;
  
  public static final int MONITOR_TYPE_ETHERNET_VCM_STATUS = 12295;
  
  public static final int MONITOR_TYPE_FLEXRAY_STATUS = 12289;
  
  public static final int MONITOR_TYPE_FRAME_RATE = 4115;
  
  public static final int MONITOR_TYPE_IHU_STATUS = 8193;
  
  public static final int MONITOR_TYPE_IHU_TEMP = 4097;
  
  public static final int MONITOR_TYPE_LIN_CCSM_STATUS = 12297;
  
  public static final int MONITOR_TYPE_LIN_WPC_STATUS = 12298;
  
  public static final int MONITOR_TYPE_LVDS_CSD_STATUS = 12292;
  
  public static final int MONITOR_TYPE_LVDS_PAC_STATUS = 12293;
  
  public static final int MONITOR_TYPE_LVDS_WAM_STATUS = 12294;
  
  public static final int MONITOR_TYPE_MEMORY_USAGE = 4114;
  
  public static final int MONITOR_TYPE_PAC_STATUS = 8200;
  
  public static final int MONITOR_TYPE_TEM2_STATUS = 8197;
  
  public static final int MONITOR_TYPE_USB_TEM_STATUS = 12296;
  
  public static final int MONITOR_TYPE_VCM_STATUS = 8198;
  
  public static final int MONITOR_TYPE_WPC_STATUS = 8196;
  
  boolean registerListener(IMonitorListener paramIMonitorListener, int paramInt);
  
  boolean registerListener(IMonitorListener paramIMonitorListener, int[] paramArrayOfint);
  
  boolean setMonitorEnable(int paramInt, boolean paramBoolean);
  
  boolean unregisterListener(IMonitorListener paramIMonitorListener);
  
  public static interface IMonitorListener {
    void onMonitorStatusChanged(int param1Int1, int param1Int2);
    
    void onMonitorValueChanged(int param1Int, float param1Float);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MonitorStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface MonitorType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\IDiagnosticMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */