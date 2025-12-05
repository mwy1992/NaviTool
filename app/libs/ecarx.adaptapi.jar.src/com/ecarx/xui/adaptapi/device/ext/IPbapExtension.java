package com.ecarx.xui.adaptapi.device.ext;

import android.bluetooth.BluetoothContact;
import android.os.Bundle;
import com.ecarx.xui.adaptapi.NonNull;
import com.ecarx.xui.adaptapi.Nullable;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface IPbapExtension {
  public static final int STATUS_COMPLETED = 3;
  
  public static final int STATUS_FAILED = 4;
  
  public static final int STATUS_IN_SYNC = 2;
  
  public static final int STATUS_MEMORY_COMPLETED = 6;
  
  public static final int STATUS_NOT_SUPPORT = 5;
  
  public static final int STATUS_START = 1;
  
  public static final int STATUS_UNKNOWN = 0;
  
  public static final int TYPE_CALL_LOG = 2;
  
  public static final int TYPE_CONTACT = 1;
  
  public static final int TYPE_DEFAULT = 0;
  
  public static final int TYPE_FAVORITE = 3;
  
  List<BluetoothContact> getContactParcelFile(String paramString);
  
  @VendorDefinition(author = "@ECARX", date = "2021-11-24", project = "smart")
  String getDecryptContactName(@NonNull String paramString1, @NonNull String paramString2, @Nullable Bundle paramBundle);
  
  int getPhoneBookContactsCount();
  
  int getSyncPhonebookStatus();
  
  boolean registerPbapListener(IPbapListener paramIPbapListener);
  
  boolean syncPhonebook(int paramInt);
  
  boolean unregisterPbapListener(IPbapListener paramIPbapListener);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ContactType {}
  
  public static interface IPbapListener {
    void onSyncPhonebookStatusChanged(int param1Int1, int param1Int2);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SyncStatus {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\IPbapExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */