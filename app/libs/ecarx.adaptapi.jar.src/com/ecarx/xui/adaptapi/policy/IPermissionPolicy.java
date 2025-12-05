package com.ecarx.xui.adaptapi.policy;

import com.ecarx.xui.adaptapi.policy.bean.FuncListParam;
import java.util.List;

public interface IPermissionPolicy {
  public static final int PERMISSION_PERIOD_12_MONTHS = 3;
  
  public static final int PERMISSION_PERIOD_3_MONTHS = 1;
  
  public static final int PERMISSION_PERIOD_6_MONTHS = 2;
  
  public static final int PERMISSION_PERIOD_INVALID = 0;
  
  int checkPermission(String paramString1, String paramString2);
  
  int checkPermissionForApps(String paramString1, String paramString2);
  
  void disablePermissionMaster(String paramString);
  
  void enablePermissionMaster(String paramString, int paramInt);
  
  List<String> getPackageNamesInBlacklist();
  
  int getPermissionMasterPeriod(String paramString);
  
  int getPermissionMasterRemainDay(String paramString);
  
  List<String> getPrivacyPermissionNameList();
  
  void grantPermissionsForApp(String[] paramArrayOfString, String paramString);
  
  boolean isPackageInBlacklist(String paramString);
  
  boolean isPermissionExpired(String paramString);
  
  boolean isPermissionMasterEnable(String paramString);
  
  boolean isPrivacyPermissionInList(String paramString);
  
  void queryPermissionsState(String paramString, List<FuncListParam> paramList);
  
  void requestPermissions(String paramString, String[] paramArrayOfString, IPermissionResultCallback paramIPermissionResultCallback);
  
  void revokePermissionsForApp(String[] paramArrayOfString, String paramString);
  
  void setPermissionMasterPeriod(String paramString, int paramInt);
  
  public static @interface PeriodType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\IPermissionPolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */