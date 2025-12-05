/*     */ package com.ecarx.xui.adaptapi.device.ext;
/*     */ 
/*     */ import android.bluetooth.BluetoothContact;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Bundle;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.os.UserHandle;
/*     */ import android.util.Log;
/*     */ import ecarx.bluetooth.IEcarxBluetoothServiceExtension;
/*     */ import ecarx.bluetooth.IRemotePbapListener;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PbapExtension
/*     */   implements IPbapExtension
/*     */ {
/*     */   private static final String TAG = "PbapExtension";
/*  36 */   private static PbapExtension instance = null;
/*     */   private final ServiceConnection mBluetoothServiceConnection;
/*  38 */   private IPbapExtension.IPbapListener mIPbapListener = null; public Context mContext; public IEcarxBluetoothServiceExtension mIEcarxBluetoothServiceExtension;
/*  39 */   private ArrayList<IPbapExtension.IPbapListener> mIPbapListenerList = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IRemotePbapListener mIRemotePbapListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static PbapExtension getInstance(Context paramContext) {
/*     */     // Byte code:
/*     */     //   0: ldc com/ecarx/xui/adaptapi/device/ext/PbapExtension
/*     */     //   2: monitorenter
/*     */     //   3: new java/lang/StringBuilder
/*     */     //   6: astore_1
/*     */     //   7: aload_1
/*     */     //   8: invokespecial <init> : ()V
/*     */     //   11: aload_1
/*     */     //   12: ldc 'getInstance() instance is '
/*     */     //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   17: pop
/*     */     //   18: aload_1
/*     */     //   19: getstatic com/ecarx/xui/adaptapi/device/ext/PbapExtension.instance : Lcom/ecarx/xui/adaptapi/device/ext/PbapExtension;
/*     */     //   22: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   25: pop
/*     */     //   26: ldc 'PbapExtension'
/*     */     //   28: aload_1
/*     */     //   29: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   32: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   35: pop
/*     */     //   36: getstatic com/ecarx/xui/adaptapi/device/ext/PbapExtension.instance : Lcom/ecarx/xui/adaptapi/device/ext/PbapExtension;
/*     */     //   39: astore_1
/*     */     //   40: aload_1
/*     */     //   41: ifnonnull -> 98
/*     */     //   44: new com/ecarx/xui/adaptapi/device/ext/PbapExtension
/*     */     //   47: astore_1
/*     */     //   48: aload_1
/*     */     //   49: aload_0
/*     */     //   50: invokespecial <init> : (Landroid/content/Context;)V
/*     */     //   53: aload_1
/*     */     //   54: putstatic com/ecarx/xui/adaptapi/device/ext/PbapExtension.instance : Lcom/ecarx/xui/adaptapi/device/ext/PbapExtension;
/*     */     //   57: new java/lang/StringBuilder
/*     */     //   60: astore_0
/*     */     //   61: aload_0
/*     */     //   62: invokespecial <init> : ()V
/*     */     //   65: aload_0
/*     */     //   66: ldc 'getInstance() instance is '
/*     */     //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   71: pop
/*     */     //   72: aload_0
/*     */     //   73: getstatic com/ecarx/xui/adaptapi/device/ext/PbapExtension.instance : Lcom/ecarx/xui/adaptapi/device/ext/PbapExtension;
/*     */     //   76: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   79: pop
/*     */     //   80: ldc 'PbapExtension'
/*     */     //   82: aload_0
/*     */     //   83: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   86: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   89: pop
/*     */     //   90: goto -> 98
/*     */     //   93: astore_0
/*     */     //   94: aload_0
/*     */     //   95: invokevirtual printStackTrace : ()V
/*     */     //   98: getstatic com/ecarx/xui/adaptapi/device/ext/PbapExtension.instance : Lcom/ecarx/xui/adaptapi/device/ext/PbapExtension;
/*     */     //   101: astore_0
/*     */     //   102: ldc com/ecarx/xui/adaptapi/device/ext/PbapExtension
/*     */     //   104: monitorexit
/*     */     //   105: aload_0
/*     */     //   106: areturn
/*     */     //   107: astore_0
/*     */     //   108: ldc com/ecarx/xui/adaptapi/device/ext/PbapExtension
/*     */     //   110: monitorexit
/*     */     //   111: aload_0
/*     */     //   112: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #43	-> 3
/*     */     //   #44	-> 36
/*     */     //   #46	-> 44
/*     */     //   #47	-> 57
/*     */     //   #50	-> 90
/*     */     //   #48	-> 93
/*     */     //   #49	-> 94
/*     */     //   #52	-> 98
/*     */     //   #42	-> 107
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   3	36	107	finally
/*     */     //   36	40	107	finally
/*     */     //   44	57	93	android/os/RemoteException
/*     */     //   44	57	107	finally
/*     */     //   57	90	93	android/os/RemoteException
/*     */     //   57	90	107	finally
/*     */     //   94	98	107	finally
/*     */     //   98	102	107	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PbapExtension(Context paramContext) throws RemoteException {
/*  61 */     this.mBluetoothServiceConnection = new ServiceConnection() {
/*     */         final PbapExtension this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  65 */           Log.d("PbapExtension", "onServiceConnected");
/*     */           
/*  67 */           PbapExtension.this.mIEcarxBluetoothServiceExtension = IEcarxBluetoothServiceExtension.Stub.asInterface(param1IBinder);
/*     */ 
/*     */           
/*  70 */           if (PbapExtension.this.mIEcarxBluetoothServiceExtension == null) {
/*  71 */             Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */           } else {
/*  73 */             Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is not null.");
/*     */             try {
/*  75 */               PbapExtension.this.mIEcarxBluetoothServiceExtension.registerPbapListener(PbapExtension.this.mIRemotePbapListener);
/*  76 */             } catch (RemoteException remoteException) {
/*  77 */               remoteException.printStackTrace();
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName) {
/*  84 */           Log.d("PbapExtension", "onServiceDisconnected()");
/*  85 */           PbapExtension.this.mIEcarxBluetoothServiceExtension = null;
/*     */         }
/*     */       };
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
/* 269 */     this.mIRemotePbapListener = (IRemotePbapListener)new IRemotePbapListener.Stub()
/*     */       {
/*     */         final PbapExtension this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void onRemoteSyncPhonebookStatusChanged(int param1Int1, int param1Int2) {
/* 279 */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onRemoteSyncPhonebookStatusChanged() type: "); stringBuilder.append(param1Int1); stringBuilder.append(" status: "); stringBuilder.append(param1Int2); Log.d("PbapExtension", stringBuilder.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 288 */           if (PbapExtension.this.mIPbapListenerList != null)
/* 289 */             for (IPbapExtension.IPbapListener iPbapListener : PbapExtension.this.mIPbapListenerList) {
/*     */               
/* 291 */               if (iPbapListener != null) { try {
/* 292 */                   iPbapListener.onSyncPhonebookStatusChanged(param1Int1, param1Int2);
/*     */ 
/*     */                 
/*     */                 }
/* 296 */                 catch (Exception exception) {
/* 297 */                   exception.printStackTrace();
/*     */                 } 
/*     */                 continue; }
/*     */               
/*     */               Log.d("PbapExtension", "mIPbapListener is null");
/*     */             }  
/*     */         }
/*     */       };
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("PbapExtension() context is ");
/*     */     stringBuilder.append(paramContext);
/*     */     Log.d("PbapExtension", stringBuilder.toString());
/*     */     this.mContext = paramContext;
/*     */     bindService();
/*     */   }
/*     */   
/*     */   private void bindService() {
/*     */     Intent intent = new Intent();
/*     */     intent.setPackage("ecarx.bluetooth.service.extension");
/*     */     intent.setAction("android.intent.action.START_ECARX_BLUETOOTH_SERVICE_EXTENSION");
/*     */     boolean bool = this.mContext.bindServiceAsUser(intent, this.mBluetoothServiceConnection, 1, UserHandle.SYSTEM);
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("bindService: ");
/*     */     stringBuilder.append(bool);
/*     */     Log.d("PbapExtension", stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public int getPhoneBookContactsCount() {
/*     */     Log.d("PbapExtension", "getPhoneBookContactsCount()");
/*     */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/*     */         return this.mIEcarxBluetoothServiceExtension.getPhoneBookContactsCount();
/*     */       } catch (RemoteException remoteException) {
/*     */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public boolean syncPhonebook(int paramInt) {
/*     */     Log.d("PbapExtension", "syncPhonebook()");
/*     */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/*     */         return this.mIEcarxBluetoothServiceExtension.syncPhonebook(paramInt);
/*     */       } catch (RemoteException remoteException) {
/*     */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public int getSyncPhonebookStatus() {
/*     */     Log.d("PbapExtension", "getSyncPhonebookStatus()");
/*     */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/*     */         return this.mIEcarxBluetoothServiceExtension.getSyncPhonebookStatus();
/*     */       } catch (RemoteException remoteException) {
/*     */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public boolean registerPbapListener(IPbapExtension.IPbapListener paramIPbapListener) {
/*     */     Log.d("PbapExtension", "registerPbapListener()");
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("mIEcarxBluetoothServiceExtension: ");
/*     */     stringBuilder.append(this.mIEcarxBluetoothServiceExtension);
/*     */     Log.d("PbapExtension", stringBuilder.toString());
/*     */     stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("mIPbapListener: ");
/*     */     stringBuilder.append(this.mIPbapListener);
/*     */     Log.d("PbapExtension", stringBuilder.toString());
/*     */     stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("listener: ");
/*     */     stringBuilder.append(paramIPbapListener);
/*     */     Log.d("PbapExtension", stringBuilder.toString());
/*     */     this.mIPbapListener = paramIPbapListener;
/*     */     if (this.mIPbapListenerList != null && !this.mIPbapListenerList.contains(paramIPbapListener))
/*     */       this.mIPbapListenerList.add(paramIPbapListener); 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean unregisterPbapListener(IPbapExtension.IPbapListener paramIPbapListener) {
/*     */     Log.d("PbapExtension", "unregisterPbapListener()");
/*     */     this.mIPbapListener = null;
/*     */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/*     */         return this.mIEcarxBluetoothServiceExtension.unregisterPbapListener(this.mIRemotePbapListener);
/*     */       } catch (RemoteException remoteException) {
/*     */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public String getDecryptContactName(String paramString1, String paramString2, Bundle paramBundle) {
/*     */     return null;
/*     */   }
/*     */   
/*     */   public List<BluetoothContact> getContactParcelFile(String paramString) {
/*     */     Log.d("PbapExtension", "getContactParcelFile()");
/*     */     if (this.mIEcarxBluetoothServiceExtension != null) {
/*     */       try {
/*     */         return this.mIEcarxBluetoothServiceExtension.getContactParcelFile(paramString);
/*     */       } catch (RemoteException remoteException) {
/*     */         remoteException.printStackTrace();
/*     */       } 
/*     */     } else {
/*     */       Log.d("PbapExtension", "mIEcarxBluetoothServiceExtension is null");
/*     */     } 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\PbapExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */