package com.ecarx.xui.adaptapi.car.diagnostics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IShCommand {
  public static final int COMMAND_CAT = 2;
  
  public static final int COMMAND_TOP = 1;
  
  void executeCommand(int paramInt, String paramString, ICommandCallback paramICommandCallback);
  
  void stopCommand();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CommandType {}
  
  public static interface ICommandCallback {
    void onCommandEnd();
    
    void onCommandOutput(String param1String);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\IShCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */