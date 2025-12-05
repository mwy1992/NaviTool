package com.ecarx.xui.adaptapi.device.ads;

import com.ecarx.xui.adaptapi.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IAdvertise {
  public static final int OPERATION_CLICKED = 2;
  
  public static final int OPERATION_DISPLAY = 1;
  
  public static final int OPERATION_END = 4;
  
  public static final int OPERATION_SKIPPED = 3;
  
  void addOnAdOperationChangedListener(@NonNull OnAdOperationChangedListener paramOnAdOperationChangedListener);
  
  IAdRecordInfo getLatestAdRecord();
  
  void removeOnAdOperationChangedListener(@NonNull OnAdOperationChangedListener paramOnAdOperationChangedListener);
  
  void setBootAdInfo(IBootAdInfo paramIBootAdInfo);
  
  public static interface OnAdOperationChangedListener {
    void onOperationChanged(@NonNull String param1String, int param1Int);
    
    void onUpdateAdRecord(IAdRecordInfo param1IAdRecordInfo);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface OperationCode {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ads\IAdvertise.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */