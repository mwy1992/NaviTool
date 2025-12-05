package com.ecarx.xui.adaptapi.navigation.ehp.v2;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IV2Manager {
  public static final int V2_REQUEST_LONG_MSG_START = 1;
  
  public static final int V2_REQUEST_LONG_MSG_STOP = 2;
  
  FunctionStatus isV2ProviderAvailable();
  
  boolean registerV2ProviderListener(IV2ProviderListener paramIV2ProviderListener);
  
  boolean unregisterV2ProviderListener(IV2ProviderListener paramIV2ProviderListener);
  
  int updadteHznMessage(IV2Message paramIV2Message);
  
  public static interface IV2ProviderListener {
    void onEHPProviderAvailable(FunctionStatus param1FunctionStatus);
    
    void onProviderRequested(int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface V2Request {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\v2\IV2Manager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */