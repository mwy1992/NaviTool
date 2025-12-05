/*     */ package com.ecarx.xui.adaptapi.device.daynigntmode;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.IPowerStatusListener;
/*     */ import android.util.Log;
/*     */ import ecarx.power.BrightnessManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DayNightMode
/*     */   implements IDayNightMode
/*     */ {
/*  17 */   private List<IDayNightMode.IDayNightChangeCallBack> mModeCallBackList = new ArrayList<>();
/*  18 */   private DayNightReceiver mDayNightReceiver = new DayNightReceiver(); private BrightnessManager mBrightnessManager; private static IDayNightMode instance; public static final String TAG = "DayNightMode";
/*     */   private static final int SUN_THEME = 4;
/*     */   private static final int NIGHT_THEME = 0;
/*     */   private static final int DAY_THEME = 1;
/*     */   private static final int CUSTOM_THEME = 3;
/*     */   private static final int AUTO_THEME = 2;
/*     */   
/*     */   public DayNightMode(Context paramContext) {
/*  26 */     this.mBrightnessManager = BrightnessManager.getInstance(paramContext);
/*  27 */     this.mBrightnessManager.registerCallBack((IPowerStatusListener)this.mDayNightReceiver);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IDayNightMode getInstance(Context paramContext) {
/*     */     // Byte code:
/*     */     //   0: ldc com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode
/*     */     //   2: monitorenter
/*     */     //   3: getstatic com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode.instance : Lcom/ecarx/xui/adaptapi/device/daynigntmode/IDayNightMode;
/*     */     //   6: ifnonnull -> 22
/*     */     //   9: new com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode
/*     */     //   12: astore_1
/*     */     //   13: aload_1
/*     */     //   14: aload_0
/*     */     //   15: invokespecial <init> : (Landroid/content/Context;)V
/*     */     //   18: aload_1
/*     */     //   19: putstatic com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode.instance : Lcom/ecarx/xui/adaptapi/device/daynigntmode/IDayNightMode;
/*     */     //   22: getstatic com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode.instance : Lcom/ecarx/xui/adaptapi/device/daynigntmode/IDayNightMode;
/*     */     //   25: astore_0
/*     */     //   26: ldc com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode
/*     */     //   28: monitorexit
/*     */     //   29: aload_0
/*     */     //   30: areturn
/*     */     //   31: astore_0
/*     */     //   32: ldc com/ecarx/xui/adaptapi/device/daynigntmode/DayNightMode
/*     */     //   34: monitorexit
/*     */     //   35: aload_0
/*     */     //   36: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #31	-> 3
/*     */     //   #32	-> 9
/*     */     //   #34	-> 22
/*     */     //   #30	-> 31
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   3	9	31	finally
/*     */     //   9	22	31	finally
/*     */     //   22	26	31	finally
/*     */   }
/*     */ 
/*     */   
/*     */   private class DayNightReceiver
/*     */     extends IPowerStatusListener.Stub
/*     */   {
/*     */     final DayNightMode this$0;
/*     */     
/*     */     private DayNightReceiver() {}
/*     */     
/*     */     public void onStatusChanged(int param1Int1, int param1Int2) {}
/*     */     
/*     */     public void onDayNightChanged(int param1Int) {
/*  46 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DayNightReceiver onDayNightChanged: mode="); stringBuilder.append(param1Int); Log.d("DayNightMode", stringBuilder.toString());
/*  47 */       byte b = 0;
/*     */       
/*  49 */       for (IDayNightMode.IDayNightChangeCallBack iDayNightChangeCallBack : DayNightMode.this.mModeCallBackList) {
/*     */         
/*  51 */         switch (param1Int) {
/*     */ 
/*     */ 
/*     */           
/*     */           case 1:
/*  56 */             b = 1; break;
/*     */           case 0:
/*     */             b = 2; break;
/*     */         } 
/*     */         try {
/*  61 */           iDayNightChangeCallBack.onDayNightChanged(b);
/*  62 */         } catch (Exception exception) {
/*  63 */           exception.printStackTrace();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onBrightnessModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onDayBrightnessChanged(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onNightBrightnessChanged(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onVehicleBrightnessChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onSettingManagerReady(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onManualDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onAutoDayNightModeChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onCustomDayTimeChanged(float param1Float) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onCustomNightTimeChanged(float param1Float) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onScreenSaverStyleChanged(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onScreenSaverNameChanged(String param1String) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDayNightMode() {
/* 137 */     int i = 0;
/* 138 */     if (this.mBrightnessManager != null)
/* 139 */     { i = this.mBrightnessManager.getThemeDayNightMode();
/* 140 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDayNightMode: dayNightMode="); stringBuilder.append(i); Log.d("DayNightMode", stringBuilder.toString());
/* 141 */       switch (i)
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 164 */           return i;
/*     */         case 4:
/*     */           i = 3;
/*     */         case 3:
/*     */           i = 4;
/*     */         case 2:
/*     */           i = 3;
/*     */         case 1:
/*     */           i = 1;
/*     */         case 0:
/* 174 */           break; }  i = 2; }  Log.e("DayNightMode", "getDayNightMode: mBrightnessManager is null"); } public int getDayNight() { int i = 0;
/* 175 */     if (this.mBrightnessManager != null) {
/* 176 */       i = this.mBrightnessManager.getRealDayNightMode();
/* 177 */       switch (i) {
/*     */ 
/*     */ 
/*     */         
/*     */         case 1:
/* 182 */           i = 1; break;
/*     */         case 0:
/*     */           i = 2;
/*     */           break;
/*     */       } 
/* 187 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDayNight: mode="); stringBuilder.append(i); Log.d("DayNightMode", stringBuilder.toString());
/*     */     } else {
/* 189 */       Log.e("DayNightMode", "getDayNight: mBrightnessManager is null");
/*     */     } 
/* 191 */     return i; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerDayNightModeCallBack(IDayNightMode.IDayNightChangeCallBack paramIDayNightChangeCallBack) {
/* 202 */     Log.d("DayNightMode", "registerDayNightModeCallBack");
/* 203 */     if (this.mModeCallBackList != null) {
/* 204 */       this.mModeCallBackList.add(paramIDayNightChangeCallBack);
/* 205 */       return true;
/*     */     } 
/* 207 */     Log.e("DayNightMode", "registerDayNightModeCallBack: mModeCallBackList is null");
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterDayNigntModeCallBack(IDayNightMode.IDayNightChangeCallBack paramIDayNightChangeCallBack) {
/* 219 */     Log.d("DayNightMode", "unregisterDayNigntModeCallBack");
/* 220 */     if (this.mModeCallBackList == null) {
/* 221 */       return true;
/*     */     }
/* 223 */     this.mModeCallBackList.remove(paramIDayNightChangeCallBack);
/* 224 */     if (this.mModeCallBackList.isEmpty()) {
/* 225 */       this.mBrightnessManager.unregisterCallBack((IPowerStatusListener)this.mDayNightReceiver);
/*     */     }
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\daynigntmode\DayNightMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */