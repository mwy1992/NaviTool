package com.ecarx.xui.adaptapi.wifiap;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IWifiAPHost {
  public static final int WIFIAP_FREQUENCY_2 = 1;
  
  public static final int WIFIAP_FREQUENCY_5 = 2;
  
  int getCurrentFrequencyMode();
  
  int[] getSupportedWifiAPFrequency();
  
  boolean registerWifiAPFrequencyCallBack(IWifiAPFrequencyChangeCallBack paramIWifiAPFrequencyChangeCallBack);
  
  void setFrequencyMode(int paramInt);
  
  boolean unregisterWifiAPFrequencyCallBack(IWifiAPFrequencyChangeCallBack paramIWifiAPFrequencyChangeCallBack);
  
  public static interface IWifiAPFrequencyChangeCallBack {
    void onWifiAPFrequencyChange(int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface WifiAPFrequency {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\IWifiAPHost.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */