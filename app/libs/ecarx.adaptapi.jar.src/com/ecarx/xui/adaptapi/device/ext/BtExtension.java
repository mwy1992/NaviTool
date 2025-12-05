/*     */ package com.ecarx.xui.adaptapi.device.ext;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.os.UserHandle;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.device.ext.common.BtDevice;
/*     */ import ecarx.bluetooth.IEcarxBluetoothServiceExtension;
/*     */ import ecarx.psd.Device;
/*     */ import ecarx.psd.IPsdServiceCallback;
/*     */ import ecarx.psd.PSDBluetooth;
/*     */ import ecarx.psd.PSDBluetoothManager;
/*     */ import ecarx.psd.PsdServiceCallbackImp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
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
/*     */ public class BtExtension
/*     */   implements IBtExtension
/*     */ {
/*     */   private PbapExtension mPbapExtension;
/*     */   private PSDBluetoothManager mPSDBluetoothManager;
/*  47 */   private final Object mLock = new Object(); public IEcarxBluetoothServiceExtension mIEcarxBluetoothServiceExtension; public Context mContext;
/*     */   private final List<IBtExtensionCallback> mBtExtensionCallbacks;
/*  49 */   private final ServiceConnection mBluetoothServiceConnection = new ServiceConnection() {
/*     */       final BtExtension this$0;
/*     */       
/*     */       public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  53 */         Log.d("BtExtension", "onServiceConnected");
/*     */         
/*  55 */         BtExtension.this.mIEcarxBluetoothServiceExtension = IEcarxBluetoothServiceExtension.Stub.asInterface(param1IBinder);
/*     */ 
/*     */         
/*  58 */         if (BtExtension.this.mIEcarxBluetoothServiceExtension == null) {
/*  59 */           Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */         } else {
/*  61 */           Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is not null");
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  68 */         Log.d("BtExtension", "onServiceDisconnected()");
/*  69 */         BtExtension.this.mIEcarxBluetoothServiceExtension = null;
/*     */       }
/*     */     };
/*     */   
/*  73 */   private final PsdServiceCallbackImp mBTCallback = new PsdServiceCallbackImp()
/*     */     {
/*     */       final BtExtension this$0;
/*     */       
/*     */       public void onPsdBtStateChanged(int param1Int) throws RemoteException {
/*  78 */         for (IBtExtensionCallback iBtExtensionCallback : BtExtension.this.mBtExtensionCallbacks) {
/*  79 */           switch (param1Int) {
/*     */             default:
/*     */               continue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 4:
/*  90 */               iBtExtensionCallback.onAdapterStateChanged(303, 300); continue;
/*     */             case 3:
/*     */               iBtExtensionCallback.onAdapterStateChanged(302, 303); continue;
/*     */             case 2:
/*     */               iBtExtensionCallback.onAdapterStateChanged(300, 301); continue;
/*     */             case 1:
/*     */               break;
/*     */           } 
/*     */           iBtExtensionCallback.onAdapterStateChanged(301, 302);
/*  99 */         }  } public void onScanOver(int param1Int) { for (IBtExtensionCallback iBtExtensionCallback : BtExtension.this.mBtExtensionCallbacks) {
/* 100 */           if (param1Int == 2) {
/*     */             
/* 102 */             iBtExtensionCallback.onDeviceFoundChanged(321, null);
/*     */             continue;
/*     */           } 
/* 105 */           iBtExtensionCallback.onDeviceFoundChanged(320, null);
/*     */         }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onFoundNearBtDeviceInfo(Device param1Device) {
/* 113 */         BtDevice btDevice = BtExtension.this.convertBtDevice(param1Device);
/* 114 */         btDevice.setConnectState(100);
/* 115 */         btDevice.setBondState(330);
/* 116 */         for (IBtExtensionCallback iBtExtensionCallback : BtExtension.this.mBtExtensionCallbacks) {
/* 117 */           iBtExtensionCallback.onDeviceFoundChanged(322, btDevice);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onLocalBtInfoCallback(PSDBluetooth param1PSDBluetooth) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onPairedDevices(List<Device> param1List) {
/* 128 */         Stream<Device> stream1 = param1List.stream(); -$$Lambda$BtExtension$2$iYigp1Y2S3TgDMpKJl6N6iMfbCs -$$Lambda$BtExtension$2$iYigp1Y2S3TgDMpKJl6N6iMfbCs = new -$$Lambda$BtExtension$2$iYigp1Y2S3TgDMpKJl6N6iMfbCs(BtExtension.this);
/* 129 */         Stream<?> stream = stream1.map(-$$Lambda$BtExtension$2$iYigp1Y2S3TgDMpKJl6N6iMfbCs); -$$Lambda$BtExtension$2$Pm-Inp8xdPe0zFxkQQ3biDJgyqw -$$Lambda$BtExtension$2$Pm-Inp8xdPe0zFxkQQ3biDJgyqw = -$$Lambda$BtExtension$2$Pm-Inp8xdPe0zFxkQQ3biDJgyqw.INSTANCE;
/* 130 */         stream = stream.peek(-$$Lambda$BtExtension$2$Pm-Inp8xdPe0zFxkQQ3biDJgyqw);
/* 131 */         List<BtDevice> list = stream.collect((Collector)Collectors.toList());
/* 132 */         for (IBtExtensionCallback iBtExtensionCallback : BtExtension.this.mBtExtensionCallbacks) {
/* 133 */           iBtExtensionCallback.onPairedDevicesChanged(list);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onBtOperateCallback(int param1Int) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void onHeadsetPowerChanged(Device param1Device, int param1Int) {
/* 145 */         BtDevice btDevice = BtExtension.this.convertBtDevice(param1Device);
/* 146 */         btDevice.setConnectState(140);
/* 147 */         for (IBtExtensionCallback iBtExtensionCallback : BtExtension.this.mBtExtensionCallbacks) {
/* 148 */           iBtExtensionCallback.onDevicePowerUpdated(btDevice, param1Int);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onPsdBtNameChanged(String param1String) throws RemoteException {}
/*     */ 
/*     */       
/*     */       public void onBtBondedStatusUpdate(Device param1Device, boolean param1Boolean) {
/*     */         char c;
/* 159 */         BtDevice btDevice = BtExtension.this.convertBtDevice(param1Device);
/* 160 */         if (param1Boolean) { c = 'Ō'; } else { c = 'Ŋ'; }  btDevice.setBondState(c);
/* 161 */         for (IBtExtensionCallback iBtExtensionCallback : BtExtension.this.mBtExtensionCallbacks) {
/* 162 */           if (param1Boolean) { c = 'Ō'; } else { c = 'Ŋ'; }  iBtExtensionCallback.onDeviceBondStateChanged(btDevice, 331, c);
/*     */         } 
/*     */       }
/*     */     }; private A2dpExtension mA2dpExtension;
/*     */   private static final String TAG = "BtExtension";
/*     */   
/*     */   public BtExtension(Context paramContext) {
/* 169 */     this.mContext = paramContext;
/* 170 */     bindService();
/* 171 */     this.mBtExtensionCallbacks = new ArrayList<>();
/* 172 */     this.mPbapExtension = PbapExtension.getInstance(this.mContext);
/* 173 */     if (paramContext.getPackageManager().hasSystemFeature("vendor.ecarx.hardware.type.psd")) {
/* 174 */       this.mPSDBluetoothManager = PSDBluetoothManager.getInstance(paramContext);
/* 175 */       this.mPSDBluetoothManager.registerCallback((IPsdServiceCallback)this.mBTCallback);
/* 176 */       this.mA2dpExtension = new A2dpExtension(this.mPSDBluetoothManager);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPbapExtension getPbapExtension() {
/* 185 */     Log.d("BtExtension", "getPbapExtension()");
/* 186 */     if (this.mPbapExtension == null) {
/* 187 */       this.mPbapExtension = PbapExtension.getInstance(this.mContext);
/*     */     }
/* 189 */     return this.mPbapExtension;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMultiBtPbapExtension getMultiBtPbapExtension() {
/* 197 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getConnectedPhoneNumber() {
/* 207 */     Log.i("BtExtension", "getConnectedPhoneNumber()");
/* 208 */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/* 210 */         return this.mIEcarxBluetoothServiceExtension.getConnectedPhoneNumber();
/* 211 */       } catch (RemoteException remoteException) {
/* 212 */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/* 215 */       Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/* 217 */     return " ";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IA2dpExtension getA2dpExtension() {
/* 228 */     return this.mA2dpExtension;
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
/*     */   public boolean registerBtCallback(IBtExtensionCallback paramIBtExtensionCallback) {
/* 242 */     synchronized (this.mLock) {
/* 243 */       if (!this.mBtExtensionCallbacks.contains(paramIBtExtensionCallback)) {
/* 244 */         this.mBtExtensionCallbacks.add(paramIBtExtensionCallback);
/* 245 */         return true;
/*     */       } 
/*     */       
/* 248 */       return false;
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
/*     */   public boolean unregisterBtCallback(IBtExtensionCallback paramIBtExtensionCallback) {
/* 261 */     synchronized (this.mLock) {
/* 262 */       this.mBtExtensionCallbacks.remove(paramIBtExtensionCallback);
/*     */       
/* 264 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBtEnabled() {
/*     */     boolean bool;
/* 274 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.isPsdBluetoothEnable()) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public int getBtState() {
/* 289 */     if (this.mPSDBluetoothManager != null) {
/* 290 */       int i = this.mPSDBluetoothManager.getPsdBluetoothStatus();
/* 291 */       if (i == 1)
/* 292 */         return 302; 
/* 293 */       if (i == 2)
/* 294 */         return 301; 
/* 295 */       if (i == 3)
/* 296 */         return 303; 
/* 297 */       if (i == 4) {
/* 298 */         return 300;
/*     */       }
/*     */     } 
/* 301 */     return -1;
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
/*     */   public boolean setBtEnable(boolean paramBoolean) {
/* 316 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.setBtEnable(paramBoolean)) { paramBoolean = true; } else { paramBoolean = false; }  return paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBtDiscovering() {
/*     */     boolean bool;
/* 326 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.isDiscovery()) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public boolean startBtDiscovery() {
/*     */     boolean bool;
/* 341 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.startDiscovery()) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public boolean cancelBtDiscovery() {
/*     */     boolean bool;
/* 355 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.cancelDiscovery()) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public boolean reqBtPair(String paramString) {
/*     */     boolean bool;
/* 374 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.requestConnect(paramString)) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public boolean reqBtUnpair(String paramString) {
/*     */     boolean bool;
/* 392 */     if (this.mPSDBluetoothManager != null && this.mPSDBluetoothManager.requestUnboundPair(paramString)) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public int getHeadsetPower(BtDevice paramBtDevice) {
/* 406 */     if (this.mPSDBluetoothManager != null) {
/* 407 */       Device device = this.mPSDBluetoothManager.getBtInfoConnecting();
/* 408 */       if (device != null) {
/* 409 */         return device.getBtPower();
/*     */       }
/*     */     } 
/* 412 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BtDevice> reqBtPairedDevices() {
/* 423 */     if (this.mPSDBluetoothManager != null) {
/* 424 */       List list = this.mPSDBluetoothManager.getBondedInfoList();
/* 425 */       Stream stream = list.stream(); -$$Lambda$BtExtension$7JQxbQWsdf7VNJQxVs6raRdHAOk -$$Lambda$BtExtension$7JQxbQWsdf7VNJQxVs6raRdHAOk = new -$$Lambda$BtExtension$7JQxbQWsdf7VNJQxVs6raRdHAOk(this);
/* 426 */       stream = stream.map(-$$Lambda$BtExtension$7JQxbQWsdf7VNJQxVs6raRdHAOk);
/* 427 */       return (List)stream.collect(Collectors.toList());
/*     */     } 
/* 429 */     return null;
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
/*     */   public String getPSDBluetoothMacAddress() {
/* 441 */     if (this.mPSDBluetoothManager != null) {
/* 442 */       PSDBluetooth pSDBluetooth = this.mPSDBluetoothManager.getLocalBtInfo();
/* 443 */       if (pSDBluetooth != null) {
/* 444 */         return pSDBluetooth.getMacAddress();
/*     */       }
/*     */     } 
/* 447 */     return null;
/*     */   }
/*     */   
/*     */   private BtDevice convertBtDevice(Device paramDevice) {
/* 451 */     BtDevice btDevice = new BtDevice();
/* 452 */     btDevice.setAddress(paramDevice.getMacAddress());
/* 453 */     btDevice.setName(paramDevice.getName());
/* 454 */     btDevice.setSupportProfile(36);
/* 455 */     return btDevice;
/*     */   }
/*     */   
/*     */   private void bindService() {
/* 459 */     Intent intent = new Intent();
/* 460 */     intent.setPackage("ecarx.bluetooth.service.extension");
/* 461 */     intent.setAction("android.intent.action.START_ECARX_BLUETOOTH_SERVICE_EXTENSION");
/*     */     
/* 463 */     boolean bool = this.mContext.bindServiceAsUser(intent, this.mBluetoothServiceConnection, 1, UserHandle.SYSTEM);
/*     */     
/* 465 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("bindService: "); stringBuilder.append(bool); Log.d("BtExtension", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBluetoothPassiveConnect(String paramString, boolean paramBoolean, int paramInt) {
/* 476 */     Log.i("BtExtension", "setBluetoothPassiveConnect()");
/* 477 */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/* 479 */         return this.mIEcarxBluetoothServiceExtension.setBluetoothPassiveConnect(paramString, paramBoolean, paramInt);
/* 480 */       } catch (RemoteException remoteException) {
/* 481 */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/* 484 */       Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/* 486 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBluetoothAutoConnect(String paramString, boolean paramBoolean) {
/* 496 */     Log.i("BtExtension", "setBluetoothAcceptConnect()");
/* 497 */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/* 499 */         return this.mIEcarxBluetoothServiceExtension.setBluetoothAutoConnect(paramString, paramBoolean);
/* 500 */       } catch (RemoteException remoteException) {
/* 501 */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/* 504 */       Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/* 506 */     return false;
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
/*     */   public boolean setBluetoothAutoConnect(String paramString, int paramInt, boolean paramBoolean) {
/* 520 */     return false;
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
/*     */   public boolean setA2dpAutoRejectConnStatus(boolean paramBoolean) {
/* 532 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getA2dpAutoRejectConnStatus() {
/* 543 */     return false;
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
/*     */   public boolean setHfpAutoRejectConnStatus(boolean paramBoolean) {
/* 555 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getHfpAutoRejectConnStatus() {
/* 566 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean startDiscoveryOnlyClassic() {
/* 576 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBLEScanEnable() {
/* 586 */     Log.i("BtExtension", "isBLEScanEnable");
/* 587 */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/* 589 */         return this.mIEcarxBluetoothServiceExtension.isBLEScanEnable();
/* 590 */       } catch (RemoteException remoteException) {
/* 591 */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/* 594 */       Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/* 596 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setBLEScanEnable(boolean paramBoolean) {
/* 607 */     Log.i("BtExtension", "setBLEScanEnable");
/* 608 */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/* 610 */         return this.mIEcarxBluetoothServiceExtension.setBLEScanEnable(paramBoolean);
/* 611 */       } catch (RemoteException remoteException) {
/* 612 */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/* 615 */       Log.d("BtExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/* 617 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\BtExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */