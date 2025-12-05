/*     */ package android.car;
/*     */ 
/*     */ import android.bluetooth.BluetoothDevice;
/*     */ import android.content.Context;
/*     */ import android.os.IBinder;
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
/*     */ public final class CarBluetoothManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   public static final int BLUETOOTH_DEVICE_CONNECTION_PRIORITY_0 = 0;
/*     */   public static final int BLUETOOTH_DEVICE_CONNECTION_PRIORITY_1 = 1;
/*     */   public static final String BLUETOOTH_NO_PRIORITY_DEVICE = "";
/*     */   private static final String TAG = "CarBluetoothManager";
/*     */   private final Context mContext;
/*     */   private final ICarBluetooth mService;
/*     */   
/*     */   public void setBluetoothDeviceConnectionPriority(BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/*  70 */       this.mService.setBluetoothDeviceConnectionPriority(paramBluetoothDevice, paramInt1, paramInt2); return;
/*  71 */     } catch (RemoteException remoteException) {
/*  72 */       Log.e("CAR.L", "setBluetoothDeviceConnectionPriority failed", (Throwable)remoteException);
/*  73 */       throw new CarNotConnectedException(remoteException);
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
/*     */   public void clearBluetoothDeviceConnectionPriority(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/*  88 */       this.mService.clearBluetoothDeviceConnectionPriority(paramInt1, paramInt2); return;
/*  89 */     } catch (RemoteException remoteException) {
/*  90 */       Log.e("CAR.L", "clearBluetoothDeviceConnectionPriority failed", (Throwable)remoteException);
/*  91 */       throw new CarNotConnectedException(remoteException);
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
/*     */   public boolean isPriorityDevicePresent(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/* 108 */       return this.mService.isPriorityDevicePresent(paramInt1, paramInt2);
/* 109 */     } catch (RemoteException remoteException) {
/* 110 */       Log.e("CAR.L", "isPrioritySet failed", (Throwable)remoteException);
/* 111 */       throw new CarNotConnectedException(remoteException);
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
/*     */   public String getDeviceNameWithPriority(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/* 128 */       return this.mService.getDeviceNameWithPriority(paramInt1, paramInt2);
/* 129 */     } catch (RemoteException remoteException) {
/* 130 */       Log.e("CAR.L", "getDeviceNameWithPriority failed", (Throwable)remoteException);
/* 131 */       throw new CarNotConnectedException(remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CarBluetoothManager(IBinder paramIBinder, Context paramContext) {
/* 137 */     this.mContext = paramContext;
/* 138 */     this.mService = ICarBluetooth.Stub.asInterface(paramIBinder);
/*     */   }
/*     */   
/*     */   public void onCarDisconnected() {}
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface PriorityType {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\CarBluetoothManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */