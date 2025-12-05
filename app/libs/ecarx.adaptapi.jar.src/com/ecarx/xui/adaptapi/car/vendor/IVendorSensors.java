package com.ecarx.xui.adaptapi.car.vendor;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VendorDefinition(author = "@ECARX", date = "2020-07-02", project = "ALL")
public interface IVendorSensors {
  public static final int VENDOR_SENSOR_TYPE = 10485760;
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorContinuousSensor {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorEventSensor {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorSensorEvents {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorSensorGroup {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorSensorRate {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vendor\IVendorSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */