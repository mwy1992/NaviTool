/*     */ package android.car.user;
/*     */ 
/*     */ import android.app.ActivityManager;
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.ContentResolver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.content.pm.UserInfo;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.drawable.BitmapDrawable;
/*     */ import android.graphics.drawable.Drawable;
/*     */ import android.os.Bundle;
/*     */ import android.os.SystemProperties;
/*     */ import android.os.UserHandle;
/*     */ import android.os.UserManager;
/*     */ import android.provider.Settings;
/*     */ import android.util.Log;
/*     */ import com.android.internal.util.UserIcons;
/*     */ import com.google.android.collect.Sets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarUserManagerHelper
/*     */ {
/*     */   private static final Set<String> DEFAULT_GUEST_RESTRICTIONS;
/*  63 */   private static final Set<String> DEFAULT_NON_ADMIN_RESTRICTIONS = (Set<String>)Sets.newArraySet((Object[])new String[] { "no_factory_reset" });
/*     */   
/*     */   private static final String HEADLESS_SYSTEM_USER = "android.car.systemuser.headless";
/*     */   private static final String TAG = "CarUserManagerHelper";
/*     */   
/*     */   static {
/*  69 */     DEFAULT_GUEST_RESTRICTIONS = (Set<String>)Sets.newArraySet((Object[])new String[] { "no_factory_reset", "no_remove_user", "no_modify_accounts", "no_outgoing_calls", "no_sms", "no_install_apps", "no_uninstall_apps" });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final ActivityManager mActivityManager;
/*     */ 
/*     */   
/*     */   private final Context mContext;
/*     */ 
/*     */   
/*     */   private Bitmap mDefaultGuestUserIcon;
/*     */   
/*  82 */   private int mLastActiveUser = 0;
/*     */   
/*     */   private ArrayList<OnUsersUpdateListener> mUpdateListeners;
/*  85 */   private final BroadcastReceiver mUserChangeReceiver = new BroadcastReceiver() {
/*     */       final CarUserManagerHelper this$0;
/*     */       
/*     */       public void onReceive(Context param1Context, Intent param1Intent) {
/*  89 */         synchronized (CarUserManagerHelper.this.mUpdateListeners) {
/*  90 */           ArrayList arrayList = new ArrayList(); this((Collection)CarUserManagerHelper.this.mUpdateListeners);
/*     */ 
/*     */           
/*  93 */           for (CarUserManagerHelper.OnUsersUpdateListener onUsersUpdateListener : arrayList)
/*  94 */             onUsersUpdateListener.onUsersUpdate(); 
/*     */           return;
/*     */         } 
/*     */       }
/*     */     };
/*     */   public CarUserManagerHelper(Context paramContext) {
/* 100 */     this.mUpdateListeners = new ArrayList<>();
/* 101 */     this.mContext = paramContext.getApplicationContext();
/* 102 */     this.mUserManager = (UserManager)this.mContext.getSystemService("user");
/* 103 */     this.mActivityManager = (ActivityManager)this.mContext.getSystemService("activity");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final UserManager mUserManager;
/*     */ 
/*     */   
/*     */   public void registerOnUsersUpdateListener(OnUsersUpdateListener paramOnUsersUpdateListener) {
/* 112 */     if (paramOnUsersUpdateListener == null) {
/*     */       return;
/*     */     }
/*     */     
/* 116 */     synchronized (this.mUpdateListeners) {
/* 117 */       if (this.mUpdateListeners.isEmpty())
/*     */       {
/* 119 */         registerReceiver();
/*     */       }
/*     */       
/* 122 */       if (!this.mUpdateListeners.contains(paramOnUsersUpdateListener)) {
/* 123 */         this.mUpdateListeners.add(paramOnUsersUpdateListener);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterOnUsersUpdateListener(OnUsersUpdateListener paramOnUsersUpdateListener) {
/* 135 */     synchronized (this.mUpdateListeners) {
/* 136 */       if (this.mUpdateListeners.contains(paramOnUsersUpdateListener)) {
/* 137 */         this.mUpdateListeners.remove(paramOnUsersUpdateListener);
/*     */         
/* 139 */         if (this.mUpdateListeners.isEmpty())
/*     */         {
/* 141 */           unregisterReceiver();
/*     */         }
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultBootUser(int paramInt) {
/* 153 */     Context context = this.mContext;
/* 154 */     ContentResolver contentResolver = context.getContentResolver();
/*     */     Settings.Global.putInt(contentResolver, "android.car.DEFAULT_BOOT_INTO_USER_ID", paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastActiveUser(int paramInt, boolean paramBoolean) {
/* 165 */     this.mLastActiveUser = paramInt;
/* 166 */     if (!paramBoolean) {
/* 167 */       Context context = this.mContext;
/* 168 */       ContentResolver contentResolver = context.getContentResolver();
/*     */       Settings.Global.putInt(contentResolver, "android.car.LAST_ACTIVE_USER_ID", paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultBootUser() {
/* 179 */     Context context = this.mContext;
/* 180 */     ContentResolver contentResolver = context.getContentResolver();
/*     */     return Settings.Global.getInt(contentResolver, "android.car.DEFAULT_BOOT_INTO_USER_ID", 10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastActiveUser() {
/* 190 */     if (this.mLastActiveUser != 0) {
/* 191 */       return this.mLastActiveUser;
/*     */     }
/* 193 */     Context context = this.mContext;
/* 194 */     ContentResolver contentResolver = context.getContentResolver();
/*     */     return Settings.Global.getInt(contentResolver, "android.car.LAST_ACTIVE_USER_ID", 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInitialUser() {
/* 208 */     int j = getLastActiveUser();
/*     */     
/* 210 */     boolean bool = false;
/* 211 */     List<UserInfo> list = getAllPersistentUsers();
/* 212 */     int i = Integer.MAX_VALUE;
/* 213 */     for (UserInfo userInfo : list) {
/* 214 */       if (userInfo.id == j) {
/* 215 */         bool = true;
/*     */       }
/* 217 */       i = Math.min(userInfo.id, i);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 222 */     if (j != 0) { int k = j; if (!bool)
/* 223 */       { StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("Can't get last active user id or the user no longer exist, user id: ."); stringBuilder1.append(j); Log.e("CarUserManagerHelper", stringBuilder1.toString());
/*     */         
/* 225 */         k = i;
/*     */ 
/*     */         
/* 228 */         return k; }  return k; }
/*     */     
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("Can't get last active user id or the user no longer exist, user id: .");
/*     */     stringBuilder.append(j);
/*     */     Log.e("CarUserManagerHelper", stringBuilder.toString());
/*     */     return i;
/*     */   }
/*     */   public void initDefaultGuestRestrictions() {
/* 237 */     Bundle bundle = new Bundle();
/* 238 */     for (String str : DEFAULT_GUEST_RESTRICTIONS) {
/* 239 */       bundle.putBoolean(str, true);
/*     */     }
/* 241 */     this.mUserManager.setDefaultGuestRestrictions(bundle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHeadlessSystemUser() {
/* 250 */     return SystemProperties.getBoolean("android.car.systemuser.headless", false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UserInfo getSystemUserInfo() {
/* 259 */     return this.mUserManager.getUserInfo(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UserInfo getCurrentForegroundUserInfo() {
/* 271 */     return this.mUserManager.getUserInfo(getCurrentForegroundUserId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentForegroundUserId() {
/* 278 */     ActivityManager activityManager = this.mActivityManager; return ActivityManager.getCurrentUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UserInfo getCurrentProcessUserInfo() {
/* 294 */     return this.mUserManager.getUserInfo(getCurrentProcessUserId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentProcessUserId() {
/* 301 */     return UserHandle.myUserId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<UserInfo> getAllSwitchableUsers() {
/* 312 */     if (isHeadlessSystemUser()) {
/* 313 */       return getAllUsersExceptSystemUserAndSpecifiedUser(getCurrentForegroundUserId());
/*     */     }
/* 315 */     return getAllUsersExceptSpecifiedUser(getCurrentForegroundUserId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<UserInfo> getAllUsers() {
/* 325 */     if (isHeadlessSystemUser()) {
/* 326 */       return getAllUsersExceptSystemUserAndSpecifiedUser(0);
/*     */     }
/* 328 */     return this.mUserManager.getUsers(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<UserInfo> getAllPersistentUsers() {
/* 338 */     List<UserInfo> list = getAllUsers();
/* 339 */     for (Iterator<UserInfo> iterator = list.iterator(); iterator.hasNext(); ) {
/* 340 */       UserInfo userInfo = iterator.next();
/* 341 */       if (userInfo.isEphemeral())
/*     */       {
/* 343 */         iterator.remove();
/*     */       }
/*     */     } 
/* 346 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<UserInfo> getAllAdminUsers() {
/* 355 */     List<UserInfo> list = getAllUsers();
/*     */     
/* 357 */     for (Iterator<UserInfo> iterator = list.iterator(); iterator.hasNext(); ) {
/* 358 */       UserInfo userInfo = iterator.next();
/* 359 */       if (!userInfo.isAdmin())
/*     */       {
/* 361 */         iterator.remove();
/*     */       }
/*     */     } 
/* 364 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<UserInfo> getAllUsersExceptGuests() {
/* 373 */     List<UserInfo> list = getAllUsers();
/*     */     
/* 375 */     for (Iterator<UserInfo> iterator = list.iterator(); iterator.hasNext(); ) {
/* 376 */       UserInfo userInfo = iterator.next();
/* 377 */       if (userInfo.isGuest())
/*     */       {
/* 379 */         iterator.remove();
/*     */       }
/*     */     } 
/* 382 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<UserInfo> getAllUsersExceptSpecifiedUser(int paramInt) {
/* 392 */     List<UserInfo> list = this.mUserManager.getUsers(true);
/*     */     
/* 394 */     for (Iterator<UserInfo> iterator = list.iterator(); iterator.hasNext(); ) {
/* 395 */       UserInfo userInfo = iterator.next();
/* 396 */       if (userInfo.id == paramInt)
/*     */       {
/* 398 */         iterator.remove();
/*     */       }
/*     */     } 
/* 401 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<UserInfo> getAllUsersExceptSystemUserAndSpecifiedUser(int paramInt) {
/* 411 */     List<UserInfo> list = this.mUserManager.getUsers(true);
/*     */     
/* 413 */     for (Iterator<UserInfo> iterator = list.iterator(); iterator.hasNext(); ) {
/* 414 */       UserInfo userInfo = iterator.next();
/* 415 */       if (userInfo.id == paramInt || userInfo.id == 0)
/*     */       {
/* 417 */         iterator.remove();
/*     */       }
/*     */     } 
/* 420 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxSupportedUsers() {
/* 432 */     if (isHeadlessSystemUser()) {
/* 433 */       return UserManager.getMaxSupportedUsers() - 1;
/*     */     }
/* 435 */     return UserManager.getMaxSupportedUsers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxSupportedRealUsers() {
/* 448 */     return getMaxSupportedUsers() - getManagedProfilesCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUserLimitReached() {
/* 455 */     int j = getAllUsersExceptGuests().size();
/* 456 */     int i = getMaxSupportedUsers();
/*     */     
/* 458 */     boolean bool = true; if (j > i) {
/* 459 */       Log.e("CarUserManagerHelper", "There are more users on the device than allowed.");
/* 460 */       return true;
/*     */     } 
/*     */     
/* 463 */     if (getAllUsersExceptGuests().size() != i) bool = false;  return bool;
/*     */   }
/*     */   
/*     */   private int getManagedProfilesCount() {
/* 467 */     List<UserInfo> list = getAllUsers();
/*     */ 
/*     */     
/* 470 */     int i = 0;
/* 471 */     for (UserInfo userInfo : list) {
/* 472 */       int j = i; if (userInfo.isManagedProfile()) {
/* 473 */         j = i + 1;
/*     */       }
/* 475 */       i = j;
/* 476 */     }  return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSystemUser(UserInfo paramUserInfo) {
/*     */     boolean bool;
/* 488 */     if (paramUserInfo.id == 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultUser(UserInfo paramUserInfo) {
/*     */     boolean bool;
/* 498 */     if (paramUserInfo.id == getDefaultBootUser()) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLastActiveUser(UserInfo paramUserInfo) {
/*     */     boolean bool;
/* 508 */     if (paramUserInfo.id == getLastActiveUser()) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isForegroundUser(UserInfo paramUserInfo) {
/*     */     boolean bool;
/* 518 */     if (getCurrentForegroundUserId() == paramUserInfo.id) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessUser(UserInfo paramUserInfo) {
/*     */     boolean bool;
/* 528 */     if (getCurrentProcessUserId() == paramUserInfo.id) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isForegroundUserGuest() {
/* 537 */     return getCurrentForegroundUserInfo().isGuest();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isForegroundUserEphemeral() {
/* 544 */     return getCurrentForegroundUserInfo().isEphemeral();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPersistentUser(int paramInt) {
/* 554 */     UserInfo userInfo = this.mUserManager.getUserInfo(paramInt);
/* 555 */     return userInfo.isEphemeral() ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUserBeRemoved(UserInfo paramUserInfo) {
/* 565 */     return isSystemUser(paramUserInfo) ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean foregroundUserHasUserRestriction(String paramString) {
/* 575 */     UserManager userManager = this.mUserManager;
/* 576 */     UserHandle userHandle = getCurrentForegroundUserInfo().getUserHandle();
/*     */     return userManager.hasUserRestriction(paramString, userHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canForegroundUserAddUsers() {
/* 583 */     return foregroundUserHasUserRestriction("no_add_user") ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessSystemUser() {
/* 592 */     return this.mUserManager.isSystemUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessDemoUser() {
/* 599 */     return this.mUserManager.isDemoUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessAdminUser() {
/* 606 */     return this.mUserManager.isAdminUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessGuestUser() {
/* 613 */     return this.mUserManager.isGuestUser();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessRestrictedProfileUser() {
/* 621 */     return this.mUserManager.isRestrictedProfile();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCurrentProcessUserHasRestriction(String paramString) {
/* 633 */     return this.mUserManager.hasUserRestriction(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canCurrentProcessModifyAccounts() {
/*     */     boolean bool;
/* 641 */     if (!isCurrentProcessUserHasRestriction("no_modify_accounts") && 
/* 642 */       !isCurrentProcessDemoUser() && 
/* 643 */       !isCurrentProcessGuestUser()) { bool = true; } else { bool = false; }
/*     */     
/*     */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canCurrentProcessAddUsers() {
/* 650 */     return isCurrentProcessUserHasRestriction("no_add_user") ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canCurrentProcessRemoveUsers() {
/* 657 */     return isCurrentProcessUserHasRestriction("no_remove_user") ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canCurrentProcessSwitchUsers() {
/* 664 */     return isCurrentProcessUserHasRestriction("no_user_switch") ^ true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void assignAdminPrivileges(UserInfo paramUserInfo) {
/* 677 */     if (!isCurrentProcessAdminUser()) {
/* 678 */       Log.w("CarUserManagerHelper", "Only admin users can assign admin privileges.");
/*     */       
/*     */       return;
/*     */     } 
/* 682 */     this.mUserManager.setUserAdmin(paramUserInfo.id);
/*     */ 
/*     */     
/* 685 */     setDefaultNonAdminRestrictions(paramUserInfo, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UserInfo createNewAdminUser(String paramString) {
/* 697 */     if (!isCurrentProcessAdminUser() && !isCurrentProcessSystemUser()) {
/*     */       
/* 699 */       Log.e("CarUserManagerHelper", "Only admin users and system user can create other admins.");
/* 700 */       return null;
/*     */     } 
/*     */     
/* 703 */     UserInfo userInfo = this.mUserManager.createUser(paramString, 2);
/* 704 */     if (userInfo == null) {
/*     */       
/* 706 */       Log.w("CarUserManagerHelper", "can't create admin user.");
/* 707 */       return null;
/*     */     } 
/* 709 */     assignDefaultIcon(userInfo);
/* 710 */     return userInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UserInfo createNewNonAdminUser(String paramString) {
/* 721 */     UserInfo userInfo = this.mUserManager.createUser(paramString, 0);
/* 722 */     if (userInfo == null) {
/*     */       
/* 724 */       Log.w("CarUserManagerHelper", "can't create non-admin user.");
/* 725 */       return null;
/*     */     } 
/* 727 */     setDefaultNonAdminRestrictions(userInfo, true);
/*     */ 
/*     */ 
/*     */     
/* 731 */     setUserRestriction(userInfo, "no_sms", false);
/* 732 */     setUserRestriction(userInfo, "no_outgoing_calls", false);
/*     */     
/* 734 */     assignDefaultIcon(userInfo);
/* 735 */     return userInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setDefaultNonAdminRestrictions(UserInfo paramUserInfo, boolean paramBoolean) {
/* 745 */     for (String str : DEFAULT_NON_ADMIN_RESTRICTIONS) {
/* 746 */       setUserRestriction(paramUserInfo, str, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserRestriction(UserInfo paramUserInfo, String paramString, boolean paramBoolean) {
/* 759 */     UserHandle userHandle = UserHandle.of(paramUserInfo.id);
/* 760 */     this.mUserManager.setUserRestriction(paramString, paramBoolean, userHandle);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeUser(UserInfo paramUserInfo, String paramString) {
/*     */     StringBuilder stringBuilder;
/* 772 */     if (isSystemUser(paramUserInfo)) {
/* 773 */       stringBuilder = new StringBuilder(); stringBuilder.append("User "); stringBuilder.append(paramUserInfo.id); stringBuilder.append(" is system user, could not be removed."); Log.w("CarUserManagerHelper", stringBuilder.toString());
/* 774 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 778 */     if (paramUserInfo.isAdmin() && getAllAdminUsers().size() <= 1) {
/* 779 */       stringBuilder = new StringBuilder(); stringBuilder.append("User "); stringBuilder.append(paramUserInfo.id); stringBuilder.append(" is the last admin user on device."); Log.w("CarUserManagerHelper", stringBuilder.toString());
/* 780 */       return false;
/*     */     } 
/*     */     
/* 783 */     if (!isCurrentProcessAdminUser() && !isCurrentProcessUser(paramUserInfo)) {
/*     */       
/* 785 */       Log.e("CarUserManagerHelper", "Non-admins cannot remove other users.");
/* 786 */       return false;
/*     */     } 
/*     */     
/* 789 */     if (paramUserInfo.id == getCurrentForegroundUserId()) {
/* 790 */       startNewGuestSession((String)stringBuilder);
/*     */     }
/*     */     
/* 793 */     return this.mUserManager.removeUser(paramUserInfo.id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean switchToUserId(int paramInt) {
/* 803 */     if (paramInt == 0 && isHeadlessSystemUser())
/*     */     {
/* 805 */       return false;
/*     */     }
/* 807 */     return this.mActivityManager.switchUser(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean switchToUser(UserInfo paramUserInfo) {
/* 817 */     if (paramUserInfo.id == getCurrentForegroundUserId()) {
/* 818 */       return false;
/*     */     }
/*     */     
/* 821 */     return switchToUserId(paramUserInfo.id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean startNewGuestSession(String paramString) {
/* 831 */     UserInfo userInfo = this.mUserManager.createGuest(this.mContext, paramString);
/* 832 */     if (userInfo == null) {
/*     */ 
/*     */       
/* 835 */       Log.w("CarUserManagerHelper", "can't create user.");
/* 836 */       return false;
/*     */     } 
/* 838 */     assignDefaultIcon(userInfo);
/* 839 */     return switchToUserId(userInfo.id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Bitmap getUserDefaultIcon(UserInfo paramUserInfo) {
/* 849 */     Context context = this.mContext;
/* 850 */     Drawable drawable = UserIcons.getDefaultUserIcon(context.getResources(), paramUserInfo.id, false);
/*     */     return UserIcons.convertToBitmap(drawable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Bitmap getGuestDefaultIcon() {
/* 859 */     if (this.mDefaultGuestUserIcon == null) {
/* 860 */       Context context = this.mContext;
/* 861 */       Resources resources = context.getResources(); this.mDefaultGuestUserIcon = UserIcons.convertToBitmap(UserIcons.getDefaultUserIcon(resources, -10000, false));
/*     */     } 
/* 863 */     return this.mDefaultGuestUserIcon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Bitmap getUserIcon(UserInfo paramUserInfo) {
/* 873 */     Bitmap bitmap = this.mUserManager.getUserIcon(paramUserInfo.id);
/*     */     
/* 875 */     if (bitmap == null) {
/* 876 */       return assignDefaultIcon(paramUserInfo);
/*     */     }
/*     */     
/* 879 */     return bitmap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Drawable scaleUserIcon(Bitmap paramBitmap, int paramInt) {
/* 890 */     paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
/*     */     
/* 892 */     return (Drawable)new BitmapDrawable(this.mContext.getResources(), paramBitmap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserName(UserInfo paramUserInfo, String paramString) {
/* 902 */     this.mUserManager.setUserName(paramUserInfo.id, paramString);
/*     */   }
/*     */   
/*     */   private void registerReceiver() {
/* 906 */     IntentFilter intentFilter = new IntentFilter();
/* 907 */     intentFilter.addAction("android.intent.action.USER_REMOVED");
/* 908 */     intentFilter.addAction("android.intent.action.USER_ADDED");
/* 909 */     intentFilter.addAction("android.intent.action.USER_INFO_CHANGED");
/* 910 */     intentFilter.addAction("android.intent.action.USER_SWITCHED");
/* 911 */     intentFilter.addAction("android.intent.action.USER_STOPPED");
/* 912 */     intentFilter.addAction("android.intent.action.USER_UNLOCKED");
/* 913 */     this.mContext.registerReceiverAsUser(this.mUserChangeReceiver, UserHandle.ALL, intentFilter, null, null);
/*     */   }
/*     */   
/*     */   private Bitmap assignDefaultIcon(UserInfo paramUserInfo) {
/*     */     Bitmap bitmap;
/* 918 */     if (paramUserInfo.isGuest())
/* 919 */     { bitmap = getGuestDefaultIcon(); } else { bitmap = getUserDefaultIcon(paramUserInfo); }
/* 920 */      this.mUserManager.setUserIcon(paramUserInfo.id, bitmap);
/* 921 */     return bitmap;
/*     */   }
/*     */   
/*     */   private void unregisterReceiver() {
/* 925 */     this.mContext.unregisterReceiver(this.mUserChangeReceiver);
/*     */   }
/*     */   
/*     */   public static interface OnUsersUpdateListener {
/*     */     void onUsersUpdate();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\ca\\user\CarUserManagerHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */