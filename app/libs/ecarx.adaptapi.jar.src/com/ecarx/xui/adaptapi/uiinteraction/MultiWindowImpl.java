/*     */ package com.ecarx.xui.adaptapi.uiinteraction;
/*     */ 
/*     */ import android.app.ActivityManager;
/*     */ import android.app.IActivityManager;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.pm.ActivityInfo;
/*     */ import android.content.pm.ApplicationInfo;
/*     */ import android.content.pm.PackageManager;
/*     */ import android.os.Build;
/*     */ import android.os.RemoteException;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiWindowImpl
/*     */   implements IMultiWindow
/*     */ {
/*     */   private static final String TAG = "MultiWindowImpl";
/*     */   private static MultiWindowImpl sMultiWindowImpl;
/*     */   private IActivityManager mAm;
/*     */   private Context mContext;
/*     */   
/*     */   public MultiWindowImpl(Context paramContext) {
/*  25 */     this.mContext = paramContext;
/*  26 */     this.mAm = ActivityManager.getService();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isSplitScreenModeSupported() {
/*  35 */     if (Build.isSplitScreenSupport()) {
/*  36 */       return FunctionStatus.active;
/*     */     }
/*  38 */     return FunctionStatus.notavailable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeSplitScreenMode() {
/*  47 */     if (this.mAm == null) {
/*  48 */       this.mAm = ActivityManager.getService();
/*     */     }
/*     */     try {
/*  51 */       this.mAm.dismissSplitScreenModeUncheckPermission(true);
/*  52 */     } catch (RemoteException remoteException) {
/*  53 */       remoteException.printStackTrace();
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
/*     */   public void closeSplitScreenMode(int paramInt) {
/*  66 */     boolean bool2 = true, bool1 = bool2; if (paramInt != 1) if (paramInt == 3) { bool1 = bool2; }
/*  67 */       else { bool1 = false; }
/*  68 */         if (this.mAm == null) {
/*  69 */       this.mAm = ActivityManager.getService();
/*     */     }
/*     */     try {
/*  72 */       this.mAm.dismissSplitScreenModeUncheckPermission(bool1);
/*  73 */     } catch (RemoteException remoteException) {
/*  74 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInSplitScreenWindowingMode() {
/*  85 */     if (this.mAm == null) {
/*  86 */       this.mAm = ActivityManager.getService();
/*     */     }
/*     */     try {
/*  89 */       return this.mAm.isInSplitScreenWindowingMode();
/*  90 */     } catch (RemoteException remoteException) {
/*  91 */       remoteException.printStackTrace();
/*     */       
/*  93 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void swapDockedAndFullscreenStack() {
/* 102 */     if (this.mAm == null) {
/* 103 */       this.mAm = ActivityManager.getService();
/*     */     }
/*     */     try {
/* 106 */       this.mAm.swapDockedAndFullscreenStack();
/* 107 */     } catch (RemoteException remoteException) {
/* 108 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getScreenStackPackageName(int paramInt) {
/* 119 */     boolean bool2 = true, bool1 = bool2; if (paramInt != 1) if (paramInt == 3) { bool1 = bool2; }
/* 120 */       else { bool1 = false; }
/* 121 */         if (this.mAm == null) {
/* 122 */       this.mAm = ActivityManager.getService();
/*     */     }
/* 124 */     String str = null;
/*     */     try {
/* 126 */       String str1 = this.mAm.getTopScreenPackageName(bool1);
/* 127 */     } catch (RemoteException remoteException) {
/* 128 */       remoteException.printStackTrace();
/*     */     } 
/* 130 */     return str;
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
/*     */   public boolean isPackageSupportedSplitScreen(String paramString) {
/* 143 */     boolean bool = false; try { ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(paramString, 0);
/* 144 */       if (applicationInfo != null) {
/* 145 */         int i = applicationInfo.privateFlags; if ((i & 0x400) != 0) bool = true;  return bool;
/*     */       }
/*     */        }
/* 148 */     catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException)
/* 149 */     { nameNotFoundException.printStackTrace(); }
/*     */     
/* 151 */     return false;
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
/*     */   public boolean isActivitySupportedSplitScreen(String paramString1, String paramString2) {
/* 166 */     boolean bool = false; try { ComponentName componentName = new ComponentName(); this(paramString1, paramString2);
/* 167 */       ActivityInfo activityInfo = this.mContext.getPackageManager().getActivityInfo(componentName, 0);
/* 168 */       if (activityInfo != null) {
/* 169 */         int i = activityInfo.resizeMode; if (i == 2) bool = true;  return bool;
/*     */       }  }
/* 171 */     catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException)
/* 172 */     { nameNotFoundException.printStackTrace(); }
/*     */     
/* 174 */     return false;
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
/*     */   public int moveActivityBetweenDisplay(int paramInt) {
/* 186 */     if (this.mAm == null) {
/* 187 */       this.mAm = ActivityManager.getService();
/*     */     }
/*     */     try {
/* 190 */       return this.mAm.moveActivityBetweenDisplay(paramInt);
/* 191 */     } catch (RemoteException remoteException) {
/* 192 */       remoteException.printStackTrace();
/*     */       
/* 194 */       return 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\MultiWindowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */