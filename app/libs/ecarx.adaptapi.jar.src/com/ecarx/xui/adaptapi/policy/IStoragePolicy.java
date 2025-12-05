package com.ecarx.xui.adaptapi.policy;

import com.ecarx.xui.adaptapi.VendorDefinition;

public interface IStoragePolicy {
  public static final int MOUNT_TYPE_DISK = 1;
  
  public static final int MOUNT_TYPE_MTP = 3;
  
  public static final int MOUNT_TYPE_UNKNOWN = 0;
  
  public static final int MOUNT_TYPE_USB = 2;
  
  @Deprecated
  public static final int VOLUME_GKUI_PRIVATE_COMMON = 5;
  
  @Deprecated
  public static final int VOLUME_GKUI_PRIVATE_MAP = 4;
  
  @Deprecated
  public static final int VOLUME_GKUI_PRIVATE_VR_RES = 3;
  
  public static final int VOLUME_PRIVATE_COMMON = 5;
  
  public static final int VOLUME_PRIVATE_MAP = 4;
  
  public static final int VOLUME_PRIVATE_VR_RES = 3;
  
  public static final int VOLUME_USB_FLASH_DISK_1 = 1;
  
  public static final int VOLUME_USB_FLASH_DISK_2 = 2;
  
  public static final int VOLUME_USB_HOST_1 = 10;
  
  public static final int VOLUME_USB_HOST_2 = 11;
  
  public static final int VOLUME_USB_HOST_3 = 12;
  
  public static final int VOLUME_USB_HOST_4 = 13;
  
  int getUsbHostCount();
  
  IUsbVolumeInfo[] getUsbHostVolumeInfos(@UsbHostId int paramInt);
  
  String getVolumeFullPath(@VolumeType int paramInt);
  
  String getVolumeName(@VolumeType int paramInt);
  
  boolean registerUsbDeviceListener(IUsbDeviceListener paramIUsbDeviceListener);
  
  @VendorDefinition(author = "@ECARX", date = "2022-01-17", project = "smart")
  boolean setUsbPowerState(String paramString, boolean paramBoolean);
  
  boolean unregisterUsbDeviceListener(IUsbDeviceListener paramIUsbDeviceListener);
  
  public static interface IUsbDeviceListener {
    void onReceiveUsbDeviceAction(@UsbActions String param1String, IStoragePolicy.IUsbVolumeInfo param1IUsbVolumeInfo);
  }
  
  public static interface IUsbVolumeInfo {
    String getFullPath();
    
    @MountType
    int getMountTypes();
    
    @UsbHostId
    int getUsbHostId();
    
    String getVolumeId();
  }
  
  public static @interface MountType {}
  
  public static @interface UsbActions {}
  
  public static @interface UsbHostId {}
  
  public static @interface VolumeType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\IStoragePolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */