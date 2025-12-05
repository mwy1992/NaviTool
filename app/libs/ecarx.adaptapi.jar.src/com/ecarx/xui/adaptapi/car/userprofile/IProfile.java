package com.ecarx.xui.adaptapi.car.userprofile;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IProfile {
  boolean containsProfileFuncId(int paramInt1, int paramInt2);
  
  int[] getContainsProfileFuncIds();
  
  int getProfileFuncValue(int paramInt1, int paramInt2);
  
  float getProfileFuncValueFloat(int paramInt1, int paramInt2);
  
  int[] getProfileSupportedZones(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-14", project = "SMART")
  int[] getUserPreferenceIdCreated(int paramInt);
  
  String toJOSNString();
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FloatProfileFuncId {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IntProfileFuncId {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\IProfile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */