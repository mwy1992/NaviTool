package com.ecarx.xui.adaptapi.car.userprofile;

import android.os.Bundle;
import com.ecarx.xui.adaptapi.Nullable;
import com.ecarx.xui.adaptapi.VendorDefinition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IUserProfile {
  public static final int ACTION_STATUS_DETECTED_AND_RECOGNIZED = 3;
  
  public static final int ACTION_STATUS_DETECTED_BUT_UNRECOGNIZED = 2;
  
  public static final int ACTION_STATUS_NOT_DETECTED = 1;
  
  public static final int ACTION_STATUS_UNAVAILABLE = 0;
  
  public static final int ACTION_TYPE_AUTMOVMT = 4;
  
  public static final int ACTION_TYPE_CLEAR = 7;
  
  public static final int ACTION_TYPE_DOWNLOAD = 6;
  
  public static final int ACTION_TYPE_FACE_BIND = 33;
  
  public static final int ACTION_TYPE_FACE_UNBIND = 34;
  
  public static final int ACTION_TYPE_IDLE = 0;
  
  public static final int ACTION_TYPE_LOAD = 2;
  
  public static final int ACTION_TYPE_MEMBNK1 = 1;
  
  public static final int ACTION_TYPE_MEMBNK2 = 2;
  
  public static final int ACTION_TYPE_MEMBNK3 = 3;
  
  public static final int ACTION_TYPE_PROFILE_ADD = 1;
  
  public static final int ACTION_TYPE_PROFILE_APPLY = 6;
  
  public static final int ACTION_TYPE_PROFILE_BIND = 17;
  
  public static final int ACTION_TYPE_PROFILE_LOGIN = 3;
  
  public static final int ACTION_TYPE_PROFILE_LOGOUT = 4;
  
  public static final int ACTION_TYPE_PROFILE_REMOVE = 2;
  
  public static final int ACTION_TYPE_PROFILE_RESET = 7;
  
  public static final int ACTION_TYPE_PROFILE_SWITCH = 5;
  
  public static final int ACTION_TYPE_PROFILE_UNBIND = 18;
  
  public static final int ACTION_TYPE_PROFILE_UNBIND_RESET = 19;
  
  public static final int ACTION_TYPE_PROFPOSN = 0;
  
  public static final int ACTION_TYPE_STOP = 3;
  
  public static final int ACTION_TYPE_STORE = 1;
  
  public static final int ACTION_TYPE_UPLOAD = 5;
  
  public static final int ADJUST_ITEM_ELECTRONIC_REAR_MIRROR = 16;
  
  public static final int ADJUST_ITEM_HUD = 8;
  
  public static final int ADJUST_ITEM_REAR_MIRROR = 4;
  
  public static final int ADJUST_ITEM_SEAT = 2;
  
  public static final int ADJUST_ITEM_WHEEL = 1;
  
  public static final int ERROR_CODE_TIMEOUT = 1;
  
  public static final int ERROR_CODE_UNKNOWN = 0;
  
  public static final int LOGIN_TYPE_CARKEY = 5;
  
  public static final int LOGIN_TYPE_DIGITALKEY = 6;
  
  public static final int LOGIN_TYPE_FACEID = 3;
  
  public static final int LOGIN_TYPE_FINGERPRINT = 2;
  
  public static final int LOGIN_TYPE_UNKNOWN = 0;
  
  public static final int LOGIN_TYPE_USER_ACC = 1;
  
  public static final int LOGIN_TYPE_VOICE = 4;
  
  public static final int STATUS_ADJUSTED = 2;
  
  public static final int STATUS_ADJUSTING = 1;
  
  public static final int STATUS_FAILED = 4;
  
  public static final int STATUS_PREPARE = 1;
  
  public static final int STATUS_PROGRESS = 2;
  
  public static final int STATUS_SUCCEED = 3;
  
  public static final int STATUS_UNKNOWN = 0;
  
  int addUserProfile();
  
  int addUserProfileCopyFrom(int paramInt);
  
  boolean applyUserProfileData(int paramInt, IProfile paramIProfile);
  
  int getCurrentId();
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  int getPreferenceId(int paramInt);
  
  int getProfileId(String paramString);
  
  int getProfileLoginType(int paramInt);
  
  int getSupportUserProfileCount();
  
  String getUserId(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-04-19", project = "lambda")
  int[] getUserProfileAdjusted();
  
  int[] getUserProfileCreated();
  
  IProfile getUserProfileData(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean isNeedLogin();
  
  boolean loginUserProfile(int paramInt);
  
  boolean logoutUserProfile(int paramInt);
  
  boolean notifyUIDInfoToProfile(int paramInt, String paramString, @Nullable Bundle paramBundle);
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean registerPreferenceObserver(IPreferenceObserver paramIPreferenceObserver);
  
  boolean registerUserProfileObserver(IUserProfileObserver paramIUserProfileObserver);
  
  boolean removeUserProfile(int paramInt);
  
  boolean resetUserProfileDataDefault(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean restorePreference();
  
  @VendorDefinition(author = "@ECARX", date = "2022-06-15", project = "SMART")
  boolean restorePreference(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-04-19", project = "lambda")
  boolean saveCurrentUserProfile();
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean saveToPreference(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean setDefaultPreference(int paramInt);
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean stopRestorePreference();
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean switchPreference(int paramInt);
  
  boolean switchUserProfile(int paramInt1, int paramInt2);
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  boolean unregisterPreferenceObserver(IPreferenceObserver paramIPreferenceObserver);
  
  boolean unregisterUserProfileObserver(IUserProfileObserver paramIUserProfileObserver);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionType {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2022-04-19", project = "lambda")
  public static @interface AdjustItem {}
  
  @Retention(RetentionPolicy.SOURCE)
  @VendorDefinition(author = "@ECARX", date = "2022-04-19", project = "lambda")
  public static @interface AdjustStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ErrorCode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FaceDetectedAndRecognizedStatus {}
  
  @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
  public static interface IPreferenceObserver {
    @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
    void onItemAdjusted(int param1Int, int[] param1ArrayOfint);
    
    @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
    void onPreferenceStateChange(int param1Int1, int param1Int2);
    
    @VendorDefinition(author = "@ECARX", date = "2022-05-24", project = "EF1E")
    void onPreferenceSwitched(int param1Int);
  }
  
  public static interface IUserProfileObserver {
    void onFaceDetectedAndRecognizedStatus(int param1Int);
    
    void onLoadAndStoreEveMemPosnAction(int param1Int);
    
    void onLoadAndStoreMemPosnAction(int param1Int);
    
    void onUserProfileActionError(int param1Int1, int param1Int2);
    
    void onUserProfileActionStatus(int param1Int1, int param1Int2, int param1Int3);
    
    void onUserProfileAdded(int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LoadAndStoreEveMemPosnActionType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LoadAndStoreMemPosnActionType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ProfileLoginType {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\IUserProfile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */