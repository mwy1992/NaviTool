package com.ecarx.xui.adaptapi.car.diagnostics;

public interface IDiagnostics {
  IBtDebug getBtDebug();
  
  IDiagnosticMonitor getDiagMonitor();
  
  IDtcManager getDtcManager();
  
  IPartInfos getPartInfoManager();
  
  IShCommand getShCommandManager();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\IDiagnostics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */