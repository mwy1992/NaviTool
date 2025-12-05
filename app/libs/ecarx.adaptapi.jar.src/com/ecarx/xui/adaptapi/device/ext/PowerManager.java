/*     */ package com.ecarx.xui.adaptapi.device.ext;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.IPowerStatusListener;
/*     */ import android.os.RemoteException;
/*     */ import android.util.ArraySet;
/*     */ import android.util.Log;
/*     */ import android.util.SparseIntArray;
/*     */ import ecarx.car.IECarXCarPower;
/*     */ import ecarx.power.BrightnessManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PowerManager
/*     */   extends IPowerStatusListener.Stub
/*     */   implements ISystemMode
/*     */ {
/*  37 */   private int mPartial = 1048833;
/*  38 */   private final SparseIntArray mIMList = new SparseIntArray();
/*  39 */   private final SparseIntArray mEMList = new SparseIntArray();
/*  40 */   private final Object mLock = new Object(); private static final String TAG = "PowerManager--AdaptApi"; private static PowerManager mPowerManagerAPI; private BrightnessManager mBrightnessManager; private android.os.PowerManager mPowerManager; private final ArraySet<ISystemMode.ISystemModeListener> mSystemModeListener;
/*     */   
/*     */   public PowerManager(Context paramContext) {
/*  43 */     this.mSystemModeListener = new ArraySet(10);
/*  44 */     this.mPowerManager = (android.os.PowerManager)paramContext.getSystemService("power");
/*  45 */     putIMList();
/*  46 */     putEMList();
/*  47 */     this.mBrightnessManager = BrightnessManager.getInstance(paramContext);
/*  48 */     this.mBrightnessManager.registerCallBack((IPowerStatusListener)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PowerManager getInstance(Context paramContext) {
/*     */     // Byte code:
/*     */     //   0: ldc com/ecarx/xui/adaptapi/device/ext/PowerManager
/*     */     //   2: monitorenter
/*     */     //   3: getstatic com/ecarx/xui/adaptapi/device/ext/PowerManager.mPowerManagerAPI : Lcom/ecarx/xui/adaptapi/device/ext/PowerManager;
/*     */     //   6: astore_1
/*     */     //   7: aload_1
/*     */     //   8: ifnonnull -> 45
/*     */     //   11: ldc 'PowerManager--AdaptApi'
/*     */     //   13: ldc 'new adapterAPI powerManager'
/*     */     //   15: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   18: pop
/*     */     //   19: new com/ecarx/xui/adaptapi/device/ext/PowerManager
/*     */     //   22: astore_1
/*     */     //   23: aload_1
/*     */     //   24: aload_0
/*     */     //   25: invokespecial <init> : (Landroid/content/Context;)V
/*     */     //   28: aload_1
/*     */     //   29: putstatic com/ecarx/xui/adaptapi/device/ext/PowerManager.mPowerManagerAPI : Lcom/ecarx/xui/adaptapi/device/ext/PowerManager;
/*     */     //   32: goto -> 45
/*     */     //   35: astore_0
/*     */     //   36: ldc 'PowerManager--AdaptApi'
/*     */     //   38: ldc 'getInstance: '
/*     */     //   40: aload_0
/*     */     //   41: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
/*     */     //   44: pop
/*     */     //   45: getstatic com/ecarx/xui/adaptapi/device/ext/PowerManager.mPowerManagerAPI : Lcom/ecarx/xui/adaptapi/device/ext/PowerManager;
/*     */     //   48: astore_0
/*     */     //   49: ldc com/ecarx/xui/adaptapi/device/ext/PowerManager
/*     */     //   51: monitorexit
/*     */     //   52: aload_0
/*     */     //   53: areturn
/*     */     //   54: astore_0
/*     */     //   55: ldc com/ecarx/xui/adaptapi/device/ext/PowerManager
/*     */     //   57: monitorexit
/*     */     //   58: aload_0
/*     */     //   59: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #52	-> 3
/*     */     //   #54	-> 11
/*     */     //   #55	-> 19
/*     */     //   #58	-> 32
/*     */     //   #56	-> 35
/*     */     //   #57	-> 36
/*     */     //   #60	-> 45
/*     */     //   #51	-> 54
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   3	7	54	finally
/*     */     //   11	19	35	java/lang/Exception
/*     */     //   11	19	54	finally
/*     */     //   19	32	35	java/lang/Exception
/*     */     //   19	32	54	finally
/*     */     //   36	45	54	finally
/*     */     //   45	49	54	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void putIMList() {
/*  64 */     this.mIMList.put(1, 1052674);
/*  65 */     this.mIMList.put(0, 1052673);
/*     */   }
/*     */   
/*     */   private void putEMList() {
/*  69 */     this.mEMList.put(1, 1049090);
/*  70 */     this.mEMList.put(0, 1049089);
/*     */   }
/*     */   
/*     */   public void onStatusChanged(int paramInt1, int paramInt2)
/*     */   {
/*  75 */     for (ISystemMode.ISystemModeListener iSystemModeListener : this.mSystemModeListener) {
/*     */       
/*  77 */       if (paramInt1 != 0) { if (paramInt1 != 2) { if (paramInt1 != 4) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           try {
/*  92 */             StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("adaptapi  EM change   id = "); stringBuilder1.append(paramInt1); stringBuilder1.append(" status = "); stringBuilder1.append(paramInt2); Log.d("PowerManager--AdaptApi", stringBuilder1.toString());
/*  93 */             SparseIntArray sparseIntArray1 = this.mEMList;
/*  94 */             int j = sparseIntArray1.get(paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             iSystemModeListener.onSystemModeStateChanged(1049088, j);
/* 108 */           } catch (Exception exception) {
/* 109 */             Log.e("PowerManager--AdaptApi", "", exception);
/*     */           }  continue; }
/*     */          if (paramInt2 == 1) {
/*     */           exception.onSystemModeStateChanged(1056768, 1056770); continue;
/*     */         }  if (paramInt2 == 0) {
/*     */           exception.onSystemModeStateChanged(1056768, 1056769); continue;
/*     */         }  exception.onSystemModeStateChanged(1056768, -1); continue; }
/*     */        StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("adaptapi  IM change   id = "); stringBuilder.append(paramInt1); stringBuilder.append(" status = "); stringBuilder.append(paramInt2); Log.d("PowerManager--AdaptApi", stringBuilder.toString()); if (paramInt2 == 2) {
/*     */         this.mPartial = 1048834; exception.onSystemModeStateChanged(1048832, 1048834); continue;
/*     */       } 
/*     */       this.mPartial = 1048833;
/*     */       exception.onSystemModeStateChanged(1048832, 1048833);
/*     */       SparseIntArray sparseIntArray = this.mIMList;
/*     */       int i = sparseIntArray.get(paramInt2);
/*     */       exception.onSystemModeStateChanged(1052672, i);
/*     */     }  } public void onDayNightChanged(int paramInt) {} public void setResetSettingsRequest(int paramInt) { try {
/* 125 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 126 */       if (iECarXCarPower != null) {
/* 127 */         iECarXCarPower.setResetSettingsRequest(2);
/*     */       } else {
/* 129 */         Log.e("PowerManager--AdaptApi", "setResetSettingsRequest: power is null");
/*     */       } 
/* 131 */     } catch (RemoteException remoteException) {
/* 132 */       remoteException.printStackTrace();
/*     */     }  }
/*     */   
/*     */   public void onDayNightModeChanged(int paramInt) {}
/*     */   public int getInfotainmentMode() {
/*     */     try {
/* 138 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 139 */       if (iECarXCarPower != null) {
/* 140 */         return iECarXCarPower.getInfotainmentMode();
/*     */       }
/* 142 */       Log.e("PowerManager--AdaptApi", "getInfotainmentMode: power is null");
/*     */     }
/* 144 */     catch (RemoteException remoteException) {
/* 145 */       remoteException.printStackTrace();
/*     */     } 
/* 147 */     return -1;
/*     */   }
/*     */   
/*     */   public int getModemStatus() {
/*     */     try {
/* 152 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 153 */       if (iECarXCarPower != null) {
/* 154 */         return iECarXCarPower.getModemStatus();
/*     */       }
/* 156 */       Log.e("PowerManager--AdaptApi", "getModemStatus: power is null");
/*     */     }
/* 158 */     catch (RemoteException remoteException) {
/* 159 */       remoteException.printStackTrace();
/*     */     } 
/* 161 */     return -1;
/*     */   }
/*     */   
/*     */   public int getPopES() {
/*     */     try {
/* 166 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 167 */       if (iECarXCarPower != null) {
/* 168 */         return iECarXCarPower.getPopES();
/*     */       }
/* 170 */       Log.e("PowerManager--AdaptApi", "getPopES: power is null");
/*     */     }
/* 172 */     catch (RemoteException remoteException) {
/* 173 */       remoteException.printStackTrace();
/*     */     } 
/* 175 */     return -1;
/*     */   }
/*     */   
/*     */   public int getPopSD() {
/*     */     try {
/* 180 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 181 */       if (iECarXCarPower != null) {
/* 182 */         return iECarXCarPower.getPopSD();
/*     */       }
/* 184 */       Log.e("PowerManager--AdaptApi", "getPopSD: power is null");
/*     */     }
/* 186 */     catch (RemoteException remoteException) {
/* 187 */       remoteException.printStackTrace();
/*     */     } 
/* 189 */     return -1;
/*     */   }
/*     */   
/*     */   public int getEntertainmentMode() {
/*     */     try {
/* 194 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 195 */       if (iECarXCarPower != null) {
/* 196 */         return iECarXCarPower.getEntertainmentMode();
/*     */       }
/* 198 */       Log.e("PowerManager--AdaptApi", "getEntertainmentMode: power is null");
/*     */     }
/* 200 */     catch (RemoteException remoteException) {
/* 201 */       remoteException.printStackTrace();
/*     */     } 
/* 203 */     return -1;
/*     */   }
/*     */   
/*     */   public int getResetSettingsResponse() {
/*     */     try {
/* 208 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 209 */       if (iECarXCarPower != null) {
/* 210 */         return iECarXCarPower.getResetSettingsResponse();
/*     */       }
/* 212 */       Log.e("PowerManager--AdaptApi", "getResetSettingsResponse: power is null");
/*     */     }
/* 214 */     catch (RemoteException remoteException) {
/* 215 */       remoteException.printStackTrace();
/*     */     } 
/* 217 */     return -1;
/*     */   }
/*     */   
/*     */   public int getCSDstatus() {
/*     */     try {
/* 222 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 223 */       if (iECarXCarPower != null) {
/* 224 */         return iECarXCarPower.getCSDstatus();
/*     */       }
/* 226 */       Log.e("PowerManager--AdaptApi", "getCSDstatus: power is null");
/*     */     }
/* 228 */     catch (RemoteException remoteException) {
/* 229 */       remoteException.printStackTrace();
/*     */     } 
/* 231 */     return -1;
/*     */   }
/*     */   
/*     */   public void fristScreenShow() {
/* 235 */     this.mPowerManager.firstScreenShow();
/*     */   }
/*     */   
/*     */   public int getSystemModeState(int paramInt)
/*     */   {
/* 240 */     if (paramInt != 1048832) { if (paramInt != 1049088) { if (paramInt != 1052672)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 251 */           return 0; }  if (getInfotainmentMode() != 2) {
/*     */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSystemModeState: not partial mode:"); stringBuilder.append(paramInt); Log.d("PowerManager--AdaptApi", stringBuilder.toString());
/*     */           return this.mIMList.get(getInfotainmentMode());
/*     */         }  }
/*     */       
/*     */       return this.mEMList.get(getEntertainmentMode()); }
/*     */     
/* 258 */     return this.mPartial; } public boolean registerListener(int paramInt, ISystemMode.ISystemModeListener paramISystemModeListener) { Log.d("PowerManager--AdaptApi", "registerListener====================");
/* 259 */     synchronized (this.mSystemModeListener) {
/* 260 */       this.mSystemModeListener.add(paramISystemModeListener);
/*     */       
/* 262 */       Object object = this.mLock; /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*     */       try {
/* 264 */         IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 265 */         if (iECarXCarPower != null) {
/* 266 */           iECarXCarPower.registerCallBack(0, (IPowerStatusListener)this);
/* 267 */           iECarXCarPower.registerCallBack(4, (IPowerStatusListener)this);
/*     */         } else {
/* 269 */           Log.e("PowerManager--AdaptApi", "registerCallBack: power is null");
/*     */         } 
/* 271 */       } catch (RemoteException remoteException) {
/* 272 */         remoteException.printStackTrace();
/*     */       } finally {}
/*     */       /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/* 275 */       return true;
/*     */     }  }
/*     */ 
/*     */   
/*     */   public boolean unregisterListener(ISystemMode.ISystemModeListener paramISystemModeListener) {
/* 280 */     synchronized (this.mSystemModeListener) {
/* 281 */       this.mSystemModeListener.remove(paramISystemModeListener);
/*     */       
/* 283 */       if (this.mSystemModeListener.isEmpty()) {
/* 284 */         Object object = this.mLock; /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*     */         try {
/* 286 */           IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 287 */           if (iECarXCarPower != null) {
/* 288 */             iECarXCarPower.unregisterCallBack(0, (IPowerStatusListener)this);
/* 289 */             iECarXCarPower.unregisterCallBack(4, (IPowerStatusListener)this);
/*     */           } else {
/* 291 */             Log.e("PowerManager--AdaptApi", "unregisterCallBack: power is null");
/*     */           } 
/* 293 */         } catch (RemoteException remoteException) {
/* 294 */           remoteException.printStackTrace();
/*     */         } finally {}
/*     */         /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*     */       } 
/* 298 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeBootUpAnimation() {
/*     */     try {
/* 307 */       Log.d("PowerManager--AdaptApi", "closeBootUpAnimation: close bootup animation to ecarx power");
/* 308 */       IECarXCarPower iECarXCarPower = this.mBrightnessManager.getService();
/* 309 */       if (iECarXCarPower != null) {
/* 310 */         iECarXCarPower.closeBootUpAnimation();
/*     */       } else {
/* 312 */         Log.e("PowerManager--AdaptApi", "closeBootUpAnimation: power is null");
/*     */       } 
/* 314 */     } catch (RemoteException remoteException) {
/* 315 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("closeBootUpAnimation: "); stringBuilder.append(remoteException); Log.e("PowerManager--AdaptApi", stringBuilder.toString());
/* 316 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setProvisionStatus(int paramInt) {}
/*     */   
/*     */   public void onBrightnessModeChanged(int paramInt) {}
/*     */   
/*     */   public void onDayBrightnessChanged(int paramInt1, int paramInt2) {}
/*     */   
/*     */   public void onNightBrightnessChanged(int paramInt1, int paramInt2) {}
/*     */   
/*     */   public void onVehicleBrightnessChanged(int paramInt) {}
/*     */   
/*     */   public void onSettingManagerReady(int paramInt) {}
/*     */   
/*     */   public void onManualDayNightModeChanged(int paramInt) {}
/*     */   
/*     */   public void onAutoDayNightModeChanged(int paramInt) {}
/*     */   
/*     */   public void onCustomDayTimeChanged(float paramFloat) {}
/*     */   
/*     */   public void onCustomNightTimeChanged(float paramFloat) {}
/*     */   
/*     */   public void onScreenSaverStyleChanged(int paramInt) {}
/*     */   
/*     */   public void onScreenSaverNameChanged(String paramString) {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\PowerManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */