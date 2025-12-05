/*     */ package android.car.content.pm;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarApiUtil;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
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
/*     */ public final class CarPackageManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   @SystemApi
/*     */   public static final int FLAG_SET_POLICY_ADD = 2;
/*     */   @SystemApi
/*     */   public static final int FLAG_SET_POLICY_REMOVE = 4;
/*     */   @SystemApi
/*     */   public static final int FLAG_SET_POLICY_WAIT_FOR_CHANGE = 1;
/*     */   private static final String TAG = "CarPackageManager";
/*     */   private final Context mContext;
/*     */   private final ICarPackageManager mService;
/*     */   
/*     */   public CarPackageManager(IBinder paramIBinder, Context paramContext) {
/*  80 */     this.mService = ICarPackageManager.Stub.asInterface(paramIBinder);
/*  81 */     this.mContext = paramContext;
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
/*     */   
/*     */   public void onCarDisconnected() {}
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
/*     */   @SystemApi
/*     */   public void setAppBlockingPolicy(String paramString, CarAppBlockingPolicy paramCarAppBlockingPolicy, int paramInt) throws CarNotConnectedException, SecurityException, IllegalArgumentException {
/* 114 */     if ((paramInt & 0x1) == 0 || 
/* 115 */       !Looper.getMainLooper().isCurrentThread()) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 120 */         this.mService.setAppBlockingPolicy(paramString, paramCarAppBlockingPolicy, paramInt);
/* 121 */       } catch (IllegalStateException illegalStateException) {
/* 122 */         CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 123 */       } catch (RemoteException remoteException) {}
/*     */       return;
/*     */     } 
/*     */     throw new IllegalStateException("FLAG_SET_POLICY_WAIT_FOR_CHANGE cannot be used in main thread");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void restartTask(int paramInt) {
/*     */     try {
/* 135 */       this.mService.restartTask(paramInt);
/* 136 */     } catch (RemoteException remoteException) {
/*     */       
/* 138 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Could not restart task "); stringBuilder.append(paramInt); Log.e("CarPackageManager", stringBuilder.toString(), (Throwable)remoteException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public boolean isActivityBackedBySafeActivity(ComponentName paramComponentName) throws CarNotConnectedException {
/*     */     try {
/* 160 */       return this.mService.isActivityBackedBySafeActivity(paramComponentName);
/* 161 */     } catch (IllegalStateException illegalStateException) {
/* 162 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 163 */     } catch (RemoteException remoteException) {}
/*     */ 
/*     */     
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnableActivityBlocking(boolean paramBoolean) {
/*     */     try {
/* 177 */       this.mService.setEnableActivityBlocking(paramBoolean);
/* 178 */     } catch (RemoteException remoteException) {}
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
/*     */   public boolean isActivityDistractionOptimized(String paramString1, String paramString2) throws CarNotConnectedException {
/*     */     try {
/* 194 */       return this.mService.isActivityDistractionOptimized(paramString1, paramString2);
/* 195 */     } catch (IllegalStateException illegalStateException) {
/* 196 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 197 */     } catch (RemoteException remoteException) {}
/*     */ 
/*     */     
/* 200 */     return false;
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
/*     */   public boolean isServiceDistractionOptimized(String paramString1, String paramString2) throws CarNotConnectedException {
/*     */     try {
/* 214 */       return this.mService.isServiceDistractionOptimized(paramString1, paramString2);
/* 215 */     } catch (IllegalStateException illegalStateException) {
/* 216 */       CarApiUtil.checkCarNotConnectedExceptionFromCarService(illegalStateException);
/* 217 */     } catch (RemoteException remoteException) {}
/*     */ 
/*     */     
/* 220 */     return false;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface SetPolicyFlags {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\CarPackageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */