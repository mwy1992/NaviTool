package com.ecarx.xui.adaptapi.hudinteraction;

import com.ecarx.xui.adaptapi.VendorDefinition;

@VendorDefinition(author = "@ECARX", date = "2021-02-26", project = "KXEX", requirement = "")
public interface HUDCalibrationParam {
  float[] getFloatValue();
  
  int[] getIntegerValue();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\HUDCalibrationParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */