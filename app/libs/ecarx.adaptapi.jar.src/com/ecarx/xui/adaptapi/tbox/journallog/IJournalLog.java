package com.ecarx.xui.adaptapi.tbox.journallog;

import com.ecarx.xui.adaptapi.FunctionStatus;

@Deprecated
public interface IJournalLog {
  boolean isJournalLogServiceOn();
  
  FunctionStatus isJournalLogSupported();
  
  boolean setJournalLogServiceOn(boolean paramBoolean);
  
  void setJournalLogStatusCallback(JournalLogStatusCallback paramJournalLogStatusCallback);
  
  void unsetJournalLogStatusCallback(JournalLogStatusCallback paramJournalLogStatusCallback);
  
  public static interface JournalLogStatusCallback {
    void onJournalLogServiceOnOff(boolean param1Boolean);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\journallog\IJournalLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */