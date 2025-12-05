package com.ecarx.xui.adaptapi.car.userprofile;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ICarKey {
  public static final int DIGITAL_KEY_TYPE_OWNER = 0;
  
  public static final int DIGITAL_KEY_TYPE_SHARED = 1;
  
  void cancelDiscovery();
  
  boolean createDigitalKey(int paramInt);
  
  boolean delAllDigitalKey();
  
  boolean delDigitalKeyItem(int paramInt);
  
  DigitalKeyInfo[] getDigitalKeys();
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "Lambda", requirement = "")
  int[] getHangupIds();
  
  @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "Lambda", requirement = "")
  int[] getRecoverIds();
  
  void readRealKey();
  
  boolean registerCarKeyObserver(ICarKeyObserver paramICarKeyObserver);
  
  boolean registerDigitalKeyCallback(IDigitalKeyCallback paramIDigitalKeyCallback);
  
  void startDiscovery();
  
  void unbindCarKey(int paramInt);
  
  boolean unregisterCarKeyObserver(ICarKeyObserver paramICarKeyObserver);
  
  boolean unregisterDigitalKeyCallback(IDigitalKeyCallback paramIDigitalKeyCallback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DigitalKeyType {}
  
  public static interface ICarKeyObserver {
    void multipleKeyFound(boolean param1Boolean);
    
    void onKeyReadResult(int param1Int);
    
    void timeout();
  }
  
  public static interface IDigitalKeyCallback {
    void onDigitalKeyResponse(int param1Int, DigitalKeyInfo param1DigitalKeyInfo);
    
    @VendorDefinition(author = "@ECARX", date = "2022-08-01", project = "Lambda", requirement = "")
    void onDigitalResResponse(int param1Int, int[] param1ArrayOfint);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\ICarKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */