package com.ecarx.xui.adaptapi.car.hvac;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IFragrance {
  public static final int AIR_FRAGRANCE_SLOT_1 = 269157377;
  
  public static final int AIR_FRAGRANCE_SLOT_2 = 269157378;
  
  public static final int AIR_FRAGRANCE_SLOT_3 = 269157379;
  
  public static final int AIR_FRAGRANCE_SLOT_4 = 269157380;
  
  public static final int AIR_FRAGRANCE_SLOT_5 = 269157381;
  
  public static final int HVAC_FUNC_AIR_FRAGRANCE = 269156608;
  
  public static final int HVAC_FUNC_AIR_FRAGRANCE_LEVEL = 269157120;
  
  public static final int HVAC_FUNC_AIR_FRAGRANCE_LOW = 269157888;
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-01", project = "E02")
  public static final int HVAC_FUNC_AIR_FRAGRANCE_RATIO = 269158144;
  
  public static final int HVAC_FUNC_AIR_FRAGRANCE_SLOT = 269157376;
  
  public static final int HVAC_FUNC_AIR_FRAGRANCE_TYPE = 269156864;
  
  public static final int HVAC_FUNC_AIR_FRAGRANCE_TYPE_ID = 269157632;
  
  public static final int HVAC_FUNC_AUTO_REFRESHING_FRAGRANCE = 269160704;
  
  public static final int HVAC_FUNC_REFRESHING_FRAGRANCE_POP = 269160960;
  
  public static final int REFRESHING_FRAGRANCE_ACTIVED = 269160961;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AirFragrancePop {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AirFragranceSlot {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FragranceFunction {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hvac\IFragrance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */