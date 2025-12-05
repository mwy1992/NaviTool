/*     */ package com.ecarx.xui.adaptapi.device.ext;
/*     */ 
/*     */ import ecarx.psd.Device;
/*     */ import ecarx.psd.IPsdServiceCallback;
/*     */ import ecarx.psd.PSDBluetoothManager;
/*     */ import ecarx.psd.PsdServiceCallbackImp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class A2dpExtension
/*     */   implements IA2dpExtension
/*     */ {
/*  19 */   private final PsdServiceCallbackImp btConnectedCallback = new PsdServiceCallbackImp() { final A2dpExtension this$0;
/*     */       
/*     */       public void onProfileConnectionChanged(String param1String, int param1Int) {
/*  22 */         for (IA2dpCallback iA2dpCallback : A2dpExtension.this.mIA2dpCallbacks) {
/*  23 */           if (param1Int == 1) {
/*  24 */             iA2dpCallback.onA2dpStateChanged(param1String, 100, 120); continue;
/*     */           } 
/*  26 */           if (param1Int == 2) {
/*  27 */             iA2dpCallback.onA2dpStateChanged(param1String, 120, 140);
/*     */ 
/*     */             
/*  30 */             iA2dpCallback.onA2dpServiceReady(); continue;
/*  31 */           }  if (param1Int == 3) {
/*  32 */             iA2dpCallback.onA2dpStateChanged(param1String, 140, 125); continue;
/*     */           } 
/*  34 */           if (param1Int == 4) {
/*  35 */             iA2dpCallback.onA2dpStateChanged(param1String, 125, 100);
/*     */           }
/*     */         } 
/*     */       } }
/*     */   ;
/*     */   private final PSDBluetoothManager mBluetoothManager;
/*     */   private final List<IA2dpCallback> mIA2dpCallbacks;
/*     */   
/*     */   public A2dpExtension(PSDBluetoothManager paramPSDBluetoothManager) {
/*  44 */     this.mBluetoothManager = paramPSDBluetoothManager;
/*  45 */     this.mBluetoothManager.registerCallback((IPsdServiceCallback)this.btConnectedCallback);
/*  46 */     this.mIA2dpCallbacks = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isA2dpServiceReady() {
/*  54 */     return isA2dpConnected();
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
/*     */   public boolean registerA2dpCallback(IA2dpCallback paramIA2dpCallback) {
/*     */     // Byte code:
/*     */     //   0: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   2: monitorenter
/*     */     //   3: aload_0
/*     */     //   4: getfield mIA2dpCallbacks : Ljava/util/List;
/*     */     //   7: aload_1
/*     */     //   8: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   13: ifne -> 32
/*     */     //   16: aload_0
/*     */     //   17: getfield mIA2dpCallbacks : Ljava/util/List;
/*     */     //   20: aload_1
/*     */     //   21: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   26: pop
/*     */     //   27: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   29: monitorexit
/*     */     //   30: iconst_1
/*     */     //   31: ireturn
/*     */     //   32: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   34: monitorexit
/*     */     //   35: iconst_0
/*     */     //   36: ireturn
/*     */     //   37: astore_1
/*     */     //   38: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   40: monitorexit
/*     */     //   41: aload_1
/*     */     //   42: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #68	-> 0
/*     */     //   #69	-> 3
/*     */     //   #70	-> 16
/*     */     //   #71	-> 27
/*     */     //   #73	-> 32
/*     */     //   #74	-> 35
/*     */     //   #73	-> 37
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   3	16	37	finally
/*     */     //   16	27	37	finally
/*     */     //   27	30	37	finally
/*     */     //   32	35	37	finally
/*     */     //   38	41	37	finally
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
/*     */   public boolean unregisterA2dpCallback(IA2dpCallback paramIA2dpCallback) {
/*     */     // Byte code:
/*     */     //   0: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   2: monitorenter
/*     */     //   3: aload_0
/*     */     //   4: getfield mIA2dpCallbacks : Ljava/util/List;
/*     */     //   7: aload_1
/*     */     //   8: invokeinterface remove : (Ljava/lang/Object;)Z
/*     */     //   13: istore_2
/*     */     //   14: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   16: monitorexit
/*     */     //   17: iload_2
/*     */     //   18: ireturn
/*     */     //   19: astore_1
/*     */     //   20: ldc com/ecarx/xui/adaptapi/device/ext/A2dpExtension
/*     */     //   22: monitorexit
/*     */     //   23: aload_1
/*     */     //   24: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #86	-> 0
/*     */     //   #87	-> 3
/*     */     //   #88	-> 19
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   3	17	19	finally
/*     */     //   20	23	19	finally
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
/*     */   public int getA2dpConnectionState() {
/*  98 */     Device device = this.mBluetoothManager.getBtInfoConnecting();
/*  99 */     if (device != null && device.isConnected()) {
/* 100 */       return 4;
/*     */     }
/* 102 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isA2dpConnected() {
/* 112 */     Device device = this.mBluetoothManager.getBtInfoConnecting();
/* 113 */     if (device == null) {
/* 114 */       return false;
/*     */     }
/* 116 */     return device.isConnected();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getA2dpConnectedAddress() {
/* 127 */     Device device = this.mBluetoothManager.getBtInfoConnecting();
/* 128 */     if (device == null) {
/* 129 */       return "00:00:00:00:00:00";
/*     */     }
/* 131 */     return device.getMacAddress();
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
/*     */   
/*     */   public boolean reqA2dpConnect(String paramString) {
/* 151 */     return this.mBluetoothManager.requestConnect(paramString);
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
/*     */   public boolean reqA2dpDisconnect(String paramString) {
/* 170 */     return this.mBluetoothManager.requestDisConnect(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pauseA2dpRender() {
/* 178 */     this.mBluetoothManager.pause();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startA2dpRender() {
/* 186 */     this.mBluetoothManager.play();
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
/*     */   public boolean setA2dpLocalVolume(int paramInt) {
/* 198 */     return this.mBluetoothManager.setVolume(paramInt);
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
/*     */   public int getA2dpLocalVolume(String paramString) {
/* 210 */     Device device = this.mBluetoothManager.getBtInfoConnecting();
/* 211 */     if (device != null && device.isSameMacAddress(paramString)) {
/* 212 */       return device.getVolume();
/*     */     }
/* 214 */     return 0;
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
/*     */   public int getA2dpThresholdVolume(String paramString) {
/* 226 */     return this.mBluetoothManager.getVolumeThreshold();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void muteA2dpAudio(boolean paramBoolean, String paramString) {
/* 236 */     if (paramBoolean) {
/* 237 */       this.mBluetoothManager.mute();
/*     */     } else {
/* 239 */       this.mBluetoothManager.unmute();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\A2dpExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */