package com.ecarx.xui.adaptapi.navigation.ehp;

import android.os.Bundle;
import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.VendorDefinition;
import com.ecarx.xui.adaptapi.navigation.ehp.v2.IV2Manager;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IEHP {
  public static final int EHP_PROTOCOL_V1 = 1;
  
  public static final int EHP_PROTOCOL_V2 = 2;
  
  public static final int EHP_PROTOCOL_V3 = 3;
  
  public static final int EHP_PROTOCOL_V4 = 4;
  
  public static final int EHP_PROTOCOL_V5 = 5;
  
  IV2Manager getEHPV2Manager();
  
  int[] getSupportedEHPProtocol();
  
  FunctionStatus isEHPByteProtocolSupported(int paramInt);
  
  FunctionStatus isEHPSupported();
  
  boolean registerEHPProviderListener(int paramInt, IEHPProviderListener paramIEHPProviderListener);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void registerEhpCallback(IEHPCallBack paramIEHPCallBack);
  
  boolean unregisterEHPProviderListener(IEHPProviderListener paramIEHPProviderListener);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void unregisterEhpCallback(IEHPCallBack paramIEHPCallBack);
  
  int updadteEHPProtocolData(int paramInt, IEHPDataInfo paramIEHPDataInfo);
  
  @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
  void updateEhpDtc(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EHPProtocol {}
  
  public static interface IEHPDataInfo {
    Bundle getExtendInformation();
    
    int getProtocol();
    
    byte[] getProtocolData();
  }
  
  public static interface IEHPProviderListener {
    void onEHPProviderRequest(int param1Int, byte[] param1ArrayOfbyte);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\IEHP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */