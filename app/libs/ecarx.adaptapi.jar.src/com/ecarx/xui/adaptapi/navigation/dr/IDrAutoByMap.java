package com.ecarx.xui.adaptapi.navigation.dr;

import com.ecarx.xui.adaptapi.FunctionStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public interface IDrAutoByMap {
  public static final int DR_RATE_FAST = 1;
  
  public static final int DR_RATE_FASTEST = 0;
  
  public static final int DR_RATE_NORMAL = 3;
  
  public static final int DR_RATE_SLOW = 4;
  
  public static final int DR_RATE_SLOWEST = 5;
  
  public static final int DR_RATE_UI = 2;
  
  public static final int KEY_STRING_ACCE = 2;
  
  public static final int KEY_STRING_GYRO = 1;
  
  public static final int KEY_STRING_MOUNTANGLE = 4;
  
  public static final int KEY_STRING_PULES = 3;
  
  public static final int KEY_STRING_W4M = 5;
  
  IDrAPInfo getDrLatestInfo(int paramInt);
  
  int[] getSupportedKeyTypes();
  
  FunctionStatus isKeyTypeSupported(int paramInt);
  
  boolean registerListener(OnDrChangedListener paramOnDrChangedListener, int paramInt);
  
  boolean registerListener(OnDrChangedListener paramOnDrChangedListener, int paramInt1, int paramInt2);
  
  boolean registerListener(OnDrChangedListener paramOnDrChangedListener, int[] paramArrayOfint, int paramInt);
  
  void unregisterListener(OnDrChangedListener paramOnDrChangedListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DrRate {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface KeyType {}
  
  public static interface OnDrChangedListener {
    void onSensorChanged(int param1Int, IDrAPInfo param1IDrAPInfo);
    
    void onSensorChanged(IDrAPInfo param1IDrAPInfo);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\IDrAutoByMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */