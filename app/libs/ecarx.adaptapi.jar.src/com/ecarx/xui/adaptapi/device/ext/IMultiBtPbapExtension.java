package com.ecarx.xui.adaptapi.device.ext;

import com.ecarx.xui.adaptapi.VendorDefinition;

public interface IMultiBtPbapExtension extends IPbapExtension {
  @VendorDefinition(author = "@ECARX", date = "2021-12-22", project = "smart", requirement = "")
  int getPhoneBookContactsCount(String paramString);
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-22", project = "smart", requirement = "")
  int getSyncPhonebookStatus(String paramString);
  
  boolean registerMultiPbapListener(IMultiPbapListener paramIMultiPbapListener);
  
  @VendorDefinition(author = "@ECARX", date = "2021-12-22", project = "smart", requirement = "")
  boolean syncPhonebook(String paramString, int paramInt);
  
  boolean unregisterMultiPbapListener(IMultiPbapListener paramIMultiPbapListener);
  
  public static interface IMultiPbapListener {
    @VendorDefinition(author = "@ECARX", date = "2021-12-22", project = "smart", requirement = "")
    void onSyncPhonebookStatusChanged(String param1String, int param1Int1, int param1Int2);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\IMultiBtPbapExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */