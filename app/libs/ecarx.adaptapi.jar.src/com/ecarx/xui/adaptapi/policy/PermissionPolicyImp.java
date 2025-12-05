/*     */ package com.ecarx.xui.adaptapi.policy;
/*     */ 
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.policy.bean.AuthListParam;
/*     */ import com.ecarx.xui.adaptapi.policy.bean.FuncListParam;
/*     */ import com.geely.permission.IPermissionManager;
/*     */ import com.geely.permission.IRequestResultCallback;
/*     */ import com.geely.permission.bean.QueryAuthListParam;
/*     */ import com.geely.permission.bean.QueryFuncListParam;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
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
/*     */ public class PermissionPolicyImp
/*     */   implements IPermissionPolicy
/*     */ {
/*     */   private static final String TAG = "OneOSPermissionManager-adapt";
/*     */   private static volatile PermissionPolicyImp sInstance;
/*  31 */   private IPermissionManager mService = IPermissionManager.Stub.asInterface(ServiceManager.getService("permissionservice"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PermissionPolicyImp getInstance() {
/*     */     // Byte code:
/*     */     //   0: getstatic com/ecarx/xui/adaptapi/policy/PermissionPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/PermissionPolicyImp;
/*     */     //   3: ifnonnull -> 39
/*     */     //   6: ldc com/ecarx/xui/adaptapi/policy/PermissionPolicyImp
/*     */     //   8: monitorenter
/*     */     //   9: getstatic com/ecarx/xui/adaptapi/policy/PermissionPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/PermissionPolicyImp;
/*     */     //   12: ifnonnull -> 27
/*     */     //   15: new com/ecarx/xui/adaptapi/policy/PermissionPolicyImp
/*     */     //   18: astore_0
/*     */     //   19: aload_0
/*     */     //   20: invokespecial <init> : ()V
/*     */     //   23: aload_0
/*     */     //   24: putstatic com/ecarx/xui/adaptapi/policy/PermissionPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/PermissionPolicyImp;
/*     */     //   27: ldc com/ecarx/xui/adaptapi/policy/PermissionPolicyImp
/*     */     //   29: monitorexit
/*     */     //   30: goto -> 39
/*     */     //   33: astore_0
/*     */     //   34: ldc com/ecarx/xui/adaptapi/policy/PermissionPolicyImp
/*     */     //   36: monitorexit
/*     */     //   37: aload_0
/*     */     //   38: athrow
/*     */     //   39: getstatic com/ecarx/xui/adaptapi/policy/PermissionPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/PermissionPolicyImp;
/*     */     //   42: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #35	-> 0
/*     */     //   #36	-> 6
/*     */     //   #37	-> 9
/*     */     //   #38	-> 15
/*     */     //   #40	-> 27
/*     */     //   #42	-> 39
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   9	15	33	finally
/*     */     //   15	27	33	finally
/*     */     //   27	30	33	finally
/*     */     //   34	37	33	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void resetPermissionManagerService() {
/*  47 */     this.mService = IPermissionManager.Stub.asInterface(ServiceManager.getService("permissionservice"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void enablePermissionMaster(String paramString, int paramInt) {
/*  52 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("enablePermissionMaster() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("], period = ["); stringBuilder.append(paramInt); stringBuilder.append("]."); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/*  54 */     if (this.mService != null) {
/*     */       try {
/*  56 */         this.mService.enablePermissionMaster(paramString, paramInt);
/*  57 */       } catch (RemoteException remoteException) {
/*  58 */         resetPermissionManagerService();
/*  59 */         Log.e("OneOSPermissionManager-adapt", "enablePermissionMaster() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/*  62 */       Log.e("OneOSPermissionManager-adapt", "enablePermissionMaster() mService is null, resetPermissionManagerService()");
/*  63 */       resetPermissionManagerService();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPermissionMasterPeriod(String paramString, int paramInt) {
/*  69 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setPermissionMasterPeriod() called with: period = ["); stringBuilder.append(paramInt); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/*  71 */     if (this.mService != null) {
/*     */       try {
/*  73 */         this.mService.setPermissionMasterPeriod(paramString, paramInt);
/*  74 */       } catch (RemoteException remoteException) {
/*  75 */         resetPermissionManagerService();
/*  76 */         Log.e("OneOSPermissionManager-adapt", "setPermissionMasterPeriod() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/*  79 */       Log.e("OneOSPermissionManager-adapt", "setPermissionMasterPeriod() mService is null, resetPermissionManagerService()");
/*  80 */       resetPermissionManagerService();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPermissionMasterPeriod(String paramString) {
/*  86 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getPermissionMasterPeriod() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/*  88 */     if (this.mService != null) {
/*     */       try {
/*  90 */         return this.mService.getPermissionMasterPeriod(paramString);
/*  91 */       } catch (RemoteException remoteException) {
/*  92 */         resetPermissionManagerService();
/*  93 */         Log.e("OneOSPermissionManager-adapt", "getPermissionMasterPeriod() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/*  96 */       Log.e("OneOSPermissionManager-adapt", "getPermissionMasterPeriod() mService is null, resetPermissionManagerService()");
/*  97 */       resetPermissionManagerService();
/*     */     } 
/*  99 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPermissionMasterRemainDay(String paramString) {
/* 104 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getPermissionMasterRemainDay() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 106 */     if (this.mService != null) {
/*     */       try {
/* 108 */         return this.mService.getPermissionMasterRemainDay(paramString);
/* 109 */       } catch (RemoteException remoteException) {
/* 110 */         resetPermissionManagerService();
/* 111 */         Log.e("OneOSPermissionManager-adapt", "getPermissionMasterRemainDay() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 114 */       Log.e("OneOSPermissionManager-adapt", "getPermissionMasterRemainDay() mService is null, resetPermissionManagerService()");
/* 115 */       resetPermissionManagerService();
/*     */     } 
/* 117 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void disablePermissionMaster(String paramString) {
/* 122 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("disablePermissionMaster() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 124 */     if (this.mService != null) {
/*     */       try {
/* 126 */         this.mService.disablePermissionMaster(paramString);
/* 127 */       } catch (RemoteException remoteException) {
/* 128 */         resetPermissionManagerService();
/* 129 */         Log.e("OneOSPermissionManager-adapt", "disablePermissionMaster() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 132 */       Log.e("OneOSPermissionManager-adapt", "disablePermissionMaster() mService is null, resetPermissionManagerService()");
/* 133 */       resetPermissionManagerService();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPermissionMasterEnable(String paramString) {
/* 139 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isPermissionMasterEnable() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 141 */     if (this.mService != null) {
/*     */       try {
/* 143 */         return this.mService.isPermissionMasterEnable(paramString);
/* 144 */       } catch (RemoteException remoteException) {
/* 145 */         resetPermissionManagerService();
/* 146 */         Log.e("OneOSPermissionManager-adapt", "isPermissionMasterEnable() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 149 */       Log.e("OneOSPermissionManager-adapt", "isPermissionMasterEnable() mService is null, resetPermissionManagerService()");
/* 150 */       resetPermissionManagerService();
/*     */     } 
/* 152 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void grantPermissionsForApp(String[] paramArrayOfString, String paramString) {
/* 157 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("grantPermissionsForApp() called with: perName = ["); stringBuilder.append(Arrays.toString((Object[])paramArrayOfString)); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 159 */     if (this.mService != null) {
/*     */       try {
/* 161 */         this.mService.grantPermissionsForApp(paramArrayOfString, paramString);
/* 162 */       } catch (RemoteException remoteException) {
/* 163 */         resetPermissionManagerService();
/* 164 */         Log.e("OneOSPermissionManager-adapt", "grantPermissionsForApp() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 167 */       Log.e("OneOSPermissionManager-adapt", "grantPermissionsForApp() mService is null, resetPermissionManagerService()");
/* 168 */       resetPermissionManagerService();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void revokePermissionsForApp(String[] paramArrayOfString, String paramString) {
/* 174 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("revokePermissionsForApp() called with: perName = ["); stringBuilder.append(Arrays.toString((Object[])paramArrayOfString)); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 176 */     if (this.mService != null) {
/*     */       try {
/* 178 */         this.mService.revokePermissionsForApp(paramArrayOfString, paramString);
/* 179 */       } catch (RemoteException remoteException) {
/* 180 */         resetPermissionManagerService();
/* 181 */         Log.e("OneOSPermissionManager-adapt", "revokePermissionsForApp() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 184 */       Log.e("OneOSPermissionManager-adapt", "revokePermissionsForApp() mService is null, resetPermissionManagerService()");
/* 185 */       resetPermissionManagerService();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getPackageNamesInBlacklist() {
/* 191 */     Log.d("OneOSPermissionManager-adapt", "getPackageNamesInBlacklist() called");
/* 192 */     if (this.mService != null) {
/*     */       try {
/* 194 */         return this.mService.getPackageNamesInBlacklist();
/* 195 */       } catch (RemoteException remoteException) {
/* 196 */         resetPermissionManagerService();
/* 197 */         Log.e("OneOSPermissionManager-adapt", "getPackageNamesInBlacklist() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 200 */       Log.e("OneOSPermissionManager-adapt", "getPackageNamesInBlacklist() mService is null, resetPermissionManagerService()");
/* 201 */       resetPermissionManagerService();
/*     */     } 
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getPrivacyPermissionNameList() {
/* 208 */     Log.d("OneOSPermissionManager-adapt", "getPrivacyPermissionNameList() called");
/* 209 */     if (this.mService != null) {
/*     */       try {
/* 211 */         return this.mService.getPrivacyPermissionNameList();
/* 212 */       } catch (RemoteException remoteException) {
/* 213 */         resetPermissionManagerService();
/* 214 */         Log.e("OneOSPermissionManager-adapt", "getPrivacyPermissionNameList() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 217 */       Log.e("OneOSPermissionManager-adapt", "getPrivacyPermissionNameList() mService is null, resetPermissionManagerService()");
/* 218 */       resetPermissionManagerService();
/*     */     } 
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPackageInBlacklist(String paramString) {
/* 225 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isPackageInBlacklist() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 227 */     if (this.mService != null) {
/*     */       try {
/* 229 */         return this.mService.isPackageInBlacklist(paramString);
/* 230 */       } catch (RemoteException remoteException) {
/* 231 */         resetPermissionManagerService();
/* 232 */         Log.e("OneOSPermissionManager-adapt", "isPackageInBlacklist() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 235 */       Log.e("OneOSPermissionManager-adapt", "isPackageInBlacklist() mService is null, resetPermissionManagerService()");
/* 236 */       resetPermissionManagerService();
/*     */     } 
/* 238 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrivacyPermissionInList(String paramString) {
/* 243 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isPrivacyPermissionInList() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 245 */     if (this.mService != null) {
/*     */       try {
/* 247 */         return this.mService.isPrivacyPermissionInList(paramString);
/* 248 */       } catch (RemoteException remoteException) {
/* 249 */         resetPermissionManagerService();
/* 250 */         Log.e("OneOSPermissionManager-adapt", "isPrivacyPermissionInList() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 253 */       Log.e("OneOSPermissionManager-adapt", "isPrivacyPermissionInList() mService is null, resetPermissionManagerService()");
/* 254 */       resetPermissionManagerService();
/*     */     } 
/* 256 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int checkPermission(String paramString1, String paramString2) {
/* 261 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("checkPermission() called with: pkgName = ["); stringBuilder.append(paramString1); stringBuilder.append("], perName = ["); stringBuilder.append(paramString2); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */ 
/*     */     
/* 264 */     if (this.mService != null) {
/*     */       try {
/* 266 */         return this.mService.checkPermission(paramString1, paramString2);
/* 267 */       } catch (RemoteException remoteException) {
/* 268 */         resetPermissionManagerService();
/* 269 */         Log.e("OneOSPermissionManager-adapt", "checkPermission() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 272 */       Log.e("OneOSPermissionManager-adapt", "checkPermission() mService is null, resetPermissionManagerService()");
/* 273 */       resetPermissionManagerService();
/*     */     } 
/* 275 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int checkPermissionForApps(String paramString1, String paramString2) {
/* 280 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("checkPermission() called with: pkgName = ["); stringBuilder.append(paramString1); stringBuilder.append("], perName = ["); stringBuilder.append(paramString2); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */ 
/*     */     
/* 283 */     if (this.mService != null) {
/*     */       try {
/* 285 */         return this.mService.checkPermissionForApps(paramString1, paramString2);
/* 286 */       } catch (RemoteException remoteException) {
/* 287 */         resetPermissionManagerService();
/* 288 */         Log.e("OneOSPermissionManager-adapt", "checkPermissionForApps() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 291 */       Log.e("OneOSPermissionManager-adapt", "checkPermissionForApps() mService is null, resetPermissionManagerService()");
/* 292 */       resetPermissionManagerService();
/*     */     } 
/* 294 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPermissionExpired(String paramString) {
/* 305 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isPermissionExpired() called with: perName = ["); stringBuilder.append(paramString); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 307 */     if (this.mService != null) {
/*     */       try {
/* 309 */         return this.mService.isPermissionExpired(paramString);
/* 310 */       } catch (RemoteException remoteException) {
/* 311 */         resetPermissionManagerService();
/* 312 */         Log.e("OneOSPermissionManager-adapt", "isPermissionExpired() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 315 */       Log.e("OneOSPermissionManager-adapt", "isPermissionExpired() mService is null, resetPermissionManagerService()");
/* 316 */       resetPermissionManagerService();
/*     */     } 
/* 318 */     return false;
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
/*     */   public void requestPermissions(String paramString, String[] paramArrayOfString, final IPermissionResultCallback resultCallback) {
/* 330 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("requestPermissions() called with: pkgName = ["); stringBuilder.append(paramString); stringBuilder.append("], permissions = ["); stringBuilder.append(paramArrayOfString); stringBuilder.append("], resultCallback = ["); stringBuilder.append(resultCallback); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/*     */     
/* 332 */     if (this.mService != null) {
/* 333 */       IRequestResultCallback.Stub stub = new IRequestResultCallback.Stub() { final PermissionPolicyImp this$0;
/*     */           
/*     */           public void onRequestPermissionsResult(String param1String, String[] param1ArrayOfString, int[] param1ArrayOfint) throws RemoteException {
/* 336 */             if (resultCallback != null)
/* 337 */               resultCallback.onRequestPermissionsResult(param1String, param1ArrayOfString, param1ArrayOfint); 
/*     */           }
/*     */           
/*     */           final IPermissionResultCallback val$resultCallback; }
/*     */         ;
/*     */       try {
/* 343 */         this.mService.requestPermissions(paramString, paramArrayOfString, (IRequestResultCallback)stub);
/* 344 */       } catch (RemoteException remoteException) {
/* 345 */         resetPermissionManagerService();
/* 346 */         if (this.mService != null) {
/*     */           try {
/* 348 */             this.mService.requestPermissions(paramString, paramArrayOfString, (IRequestResultCallback)stub);
/* 349 */           } catch (RemoteException remoteException1) {
/* 350 */             Log.e("OneOSPermissionManager-adapt", "requestPermissions() RemoteException", (Throwable)remoteException1);
/*     */           } 
/*     */         } else {
/* 353 */           Log.e("OneOSPermissionManager-adapt", "requestPermissions() mService is null, after RemoteException", (Throwable)remoteException);
/*     */         } 
/* 355 */         Log.e("OneOSPermissionManager-adapt", "requestPermissions() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 358 */       Log.e("OneOSPermissionManager-adapt", "requestPermissions() mService is null, resetPermissionManagerService()");
/* 359 */       resetPermissionManagerService();
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
/*     */   public void queryPermissionsState(String paramString, List<FuncListParam> paramList) {
/* 371 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("queryPermissionsState() called with: searchLevel = ["); stringBuilder.append(paramString); stringBuilder.append("], funcListParams = ["); stringBuilder.append(paramList); stringBuilder.append("]"); Log.d("OneOSPermissionManager-adapt", stringBuilder.toString());
/* 372 */     if (this.mService != null) {
/* 373 */       ArrayList<QueryFuncListParam> arrayList = new ArrayList();
/* 374 */       if (paramList != null && !paramList.isEmpty()) {
/* 375 */         for (FuncListParam funcListParam : paramList) {
/* 376 */           QueryFuncListParam queryFuncListParam = new QueryFuncListParam();
/* 377 */           queryFuncListParam.setCode(funcListParam.getCode());
/* 378 */           queryFuncListParam.setFuncName(funcListParam.getFuncName());
/* 379 */           ArrayList<QueryAuthListParam> arrayList1 = new ArrayList();
/* 380 */           if (funcListParam.getAuthListParams() != null && !funcListParam.getAuthListParams().isEmpty()) {
/* 381 */             for (AuthListParam authListParam : funcListParam.getAuthListParams()) {
/* 382 */               QueryAuthListParam queryAuthListParam = new QueryAuthListParam();
/* 383 */               queryAuthListParam.setAuthCode(authListParam.getAuthCode());
/* 384 */               arrayList1.add(queryAuthListParam);
/*     */             } 
/* 386 */             queryFuncListParam.setQueryAuthListParams(arrayList1);
/*     */           } 
/* 388 */           arrayList.add(queryFuncListParam);
/*     */         } 
/*     */       }
/*     */       try {
/* 392 */         this.mService.queryPermissionsState(paramString, arrayList);
/* 393 */       } catch (RemoteException remoteException) {
/* 394 */         resetPermissionManagerService();
/* 395 */         Log.e("OneOSPermissionManager-adapt", "queryPermissionsState() RemoteException", (Throwable)remoteException);
/*     */       } 
/*     */     } else {
/* 398 */       Log.e("OneOSPermissionManager-adapt", "queryPermissionsState() mService is null, resetPermissionManagerService()");
/* 399 */       resetPermissionManagerService();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\PermissionPolicyImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */