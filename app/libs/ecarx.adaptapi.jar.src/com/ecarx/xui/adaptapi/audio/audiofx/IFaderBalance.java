package com.ecarx.xui.adaptapi.audio.audiofx;

import com.ecarx.xui.adaptapi.FunctionStatus;
import com.ecarx.xui.adaptapi.VendorDefinition;

public interface IFaderBalance {
  short getBalanceLevel();
  
  short[] getBalanceLevelRange();
  
  short getFaderLevel();
  
  short[] getFaderLevelRange();
  
  FunctionStatus isBalanceSupported();
  
  FunctionStatus isFaderSupported();
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "EF1E", requirement = "")
  boolean registerFaderBalanceStateListener(IFaderBalanceStateListener paramIFaderBalanceStateListener);
  
  void setBalanceLevel(short paramShort);
  
  void setFaderLevel(short paramShort);
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "EF1E", requirement = "")
  boolean unregisterFaderBalanceStateListener(IFaderBalanceStateListener paramIFaderBalanceStateListener);
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "EF1E", requirement = "")
  public static interface IFaderBalanceStateListener {
    void onBalanceChanged(int param1Int);
    
    @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "EF1E", requirement = "")
    void onFaderBalanceStateChanger(FunctionStatus param1FunctionStatus);
    
    void onFaderChanged(int param1Int);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\IFaderBalance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */