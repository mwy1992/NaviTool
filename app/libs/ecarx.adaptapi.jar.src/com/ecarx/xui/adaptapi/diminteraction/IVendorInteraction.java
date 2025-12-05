package com.ecarx.xui.adaptapi.diminteraction;

import android.os.Bundle;
import com.ecarx.xui.adaptapi.NonNull;
import com.ecarx.xui.adaptapi.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IVendorInteraction {
  public static final String EXT_KEY_APP_PACKAGE_NAME = "EXT_KEY_APP_PACKAGE_NAME";
  
  public static final int VENDOR_ACTION_TYPE_NONE = 0;
  
  public static final int VENDOR_DATA_TYPE_DEFAULT = 0;
  
  public static final int VENDOR_DATA_TYPE_ILLEGAL = -2147483648;
  
  boolean registerVendorInteractionCallback(IVendorInteractionCallback paramIVendorInteractionCallback);
  
  boolean unRegisterVendorInteractionCallback(IVendorInteractionCallback paramIVendorInteractionCallback);
  
  boolean updateVendorInformation(@NonNull IVendorInformation paramIVendorInformation);
  
  public static interface IVendorInformation {
    int getType();
    
    Bundle getVendorExtras();
  }
  
  public static interface IVendorInteractionCallback {
    void onInteractionAction(int param1Int, @Nullable IVendorInteraction.IVendorInformation param1IVendorInformation);
  }
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorActionType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorDataType {}
  
  @Documented
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VendorExtrasKey {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\IVendorInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */