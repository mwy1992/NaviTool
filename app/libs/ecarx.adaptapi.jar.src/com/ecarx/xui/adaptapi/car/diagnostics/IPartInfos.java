package com.ecarx.xui.adaptapi.car.diagnostics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IPartInfos {
  public static final int PART_INFO_ECU_CORE_ASSEMBLY_NO = 1;
  
  public static final int PART_INFO_ECU_DELIVERY_ASSEMBLY_NO = 2;
  
  public static final int PART_INFO_IHU_AP_LOAD_MODULE_NO = 4;
  
  public static final int PART_INFO_IHU_AP_LOCAL_CONFIG_NO = 6;
  
  public static final int PART_INFO_IHU_POST_BUILD_NO = 7;
  
  public static final int PART_INFO_IHU_VP_LOAD_MODULE_NO = 3;
  
  public static final int PART_INFO_IHU_VP_LOCAL_CONFIG_NO = 5;
  
  String getPartInfoString(int paramInt);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PartId {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\IPartInfos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */