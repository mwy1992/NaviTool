package com.ecarx.xui.adaptapi.dvr.forp;

import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IFileManager {
  public static final int OPERATION_DELETE_FILES = 8194;
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  public static final int OPERATION_LOCK_FILES = 8199;
  
  public static final int OPERATION_MOVE_FILES_TO_EMERGENCY = 8195;
  
  public static final int OPERATION_PAGE_DOWN = 8197;
  
  public static final int OPERATION_PAGE_UP = 8196;
  
  public static final int OPERATION_RESTORE_DELETED_FILES = 8198;
  
  public static final int OPERATION_SYNC_FILES = 8193;
  
  public static final int OPERATION_SYNC_FILES_NEWEST = 8200;
  
  void deleteDvrFiles(IDvrFile[] paramArrayOfIDvrFile);
  
  IDvrFile[] getAllDvrFiles();
  
  IDvrFile[] getDrvFiles(int paramInt1, int paramInt2);
  
  IDvrFile[] getDvrDeletedFiles();
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  int getDvrFileCount(int paramInt);
  
  IDvrFile[] getDvrFiles(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
  void lockDvrFiles(IDvrFile[] paramArrayOfIDvrFile);
  
  void moveFiles2EmergencyPartition(IDvrFile[] paramArrayOfIDvrFile);
  
  boolean registerOperationObserver(IFileObserver paramIFileObserver);
  
  void restoreDeletedFiles(IDvrFile[] paramArrayOfIDvrFile);
  
  boolean unegisterOperationObserver(IFileObserver paramIFileObserver);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FileOperationType {}
  
  public static interface IFileObserver {
    void onDeleteFiles(IDvrFile[] param1ArrayOfIDvrFile);
    
    void onFileOperationResults(int param1Int, IDvrFile[] param1ArrayOfIDvrFile1, IDvrFile[] param1ArrayOfIDvrFile2);
    
    void onNewFiles(IDvrFile[] param1ArrayOfIDvrFile);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\IFileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */