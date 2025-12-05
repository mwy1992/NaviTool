package com.ecarx.xui.adaptapi.diminteraction;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface IContactsInteraction {
  public static final int ACTION_ADD_FAVORITE = 1;
  
  public static final int ACTION_RM_FAVORITE = 2;
  
  public static final int CALL_LOG_TYPE_INCOMING = 2;
  
  public static final int CALL_LOG_TYPE_MISSED = 3;
  
  public static final int CALL_LOG_TYPE_OUTGOING = 1;
  
  public static final int CALL_LOG_TYPE_UNKNOWN = 0;
  
  public static final int TYPE_CALL_LOG = 2;
  
  public static final int TYPE_CONTACT = 1;
  
  public static final int TYPE_DEFAULT = 0;
  
  public static final int TYPE_FAVORITE = 3;
  
  void registerContactsInteractionCallback(IContactsInteractionCallback paramIContactsInteractionCallback);
  
  void unregisterContactsInteractionCallback(IContactsInteractionCallback paramIContactsInteractionCallback);
  
  void updateCallLogList(List<ICallLog> paramList);
  
  void updateContacts(int paramInt, List<IContact> paramList);
  
  void updateSearchContacts(int paramInt, List<IContact> paramList, String paramString);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ActionType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface CallLogType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ContactType {}
  
  public static interface ICallLog {
    Uri getAvatar();
    
    int getCallType();
    
    String getContactName();
    
    String getContactNumber();
    
    int getCount();
    
    long getTimestamp();
  }
  
  public static interface IContact {
    Uri getAvatar();
    
    String getName();
    
    String getNumber();
    
    int getType();
  }
  
  public static interface IContactsInteractionCallback {
    void onDoContactInteractionAction(int param1Int, String param1String);
    
    void onSearchContacts(int param1Int, String param1String);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\IContactsInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */