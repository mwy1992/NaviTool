package com.ecarx.xui.adaptapi;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Operator {
  public static final int DEFAULT = 0;
  
  public static final int GESTURE = 4;
  
  public static final int QUICK_SETTING = 8;
  
  public static final int SETTING = 16;
  
  public static final int VR = 2;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Type {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\Operator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */