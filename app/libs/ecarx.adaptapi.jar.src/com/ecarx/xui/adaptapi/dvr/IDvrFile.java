package com.ecarx.xui.adaptapi.dvr;

import android.graphics.Bitmap;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDvrFile {
  public static final int FILE_TYPE_EMERGENCY_VIDEO = 1;
  
  public static final int FILE_TYPE_NORMAL_VIDEO = 2;
  
  public static final int FILE_TYPE_PHOTO = 4;
  
  File getFile();
  
  String getId();
  
  Bitmap getThumbnail();
  
  int getType();
  
  boolean isFinalDvrFile();
  
  boolean isFristDvrFile();
  
  boolean isLocked();
  
  boolean isSelected();
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FileType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\IDvrFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */