package com.ecarx.xui.adaptapi.dvr.forp;

import android.net.Uri;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDvrFile {
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int FILE_TYPE_AVM_VIDEO = 6;
  
  public static final int FILE_TYPE_CAMERA_PHOTO = 4;
  
  public static final int FILE_TYPE_DRIVING_PHOTO = 3;
  
  public static final int FILE_TYPE_EMERGENCY_VIDEO = 1;
  
  public static final int FILE_TYPE_GENERAL_VIDEO = 2;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int FILE_TYPE_PARKING_VIDEO = 5;
  
  int getApplicationType();
  
  long getDeleteTime();
  
  long getDuration();
  
  Uri getFileUri();
  
  int getHeight();
  
  double getLatitude();
  
  double getLongitude();
  
  String getMd5();
  
  String getName();
  
  long getSize();
  
  Uri getThumbnail();
  
  long getTicktime();
  
  int getType();
  
  int getWidth();
  
  boolean isDeleted();
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  boolean isDvrFileLocked();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FileType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\IDvrFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */