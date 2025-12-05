/*     */ package com.ecarx.xui.adaptapi.dvr;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.Tribool;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Settings
/*     */   extends AbsDvrSignal
/*     */   implements ISettings
/*     */ {
/*  27 */   private static final int[] SUPPORTED_RECORDING_DURATION = new int[] { 1, 3, 5 };
/*     */   private static final String TAG = "DVR_Settings";
/*     */   private final CopyOnWriteArrayList<ISettings.IDvrSettingsCallback> mDvrSettingsCallbacks;
/*     */   
/*     */   public Settings(Context paramContext) {
/*  32 */     super(paramContext);
/*  33 */     this.mDvrSettingsCallbacks = new CopyOnWriteArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initSignalFilter() {
/*  39 */     addSignalFilter(Integer.valueOf(29008));
/*     */     
/*  41 */     addSignalFilter(Integer.valueOf(29038));
/*     */     
/*  43 */     addSignalFilter(Integer.valueOf(29013));
/*     */     
/*  45 */     addSignalFilter(Integer.valueOf(29007));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onInitCarSignalManager() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue)
/*     */   {
/*  60 */     int i = paramECarXCarPropertyValue.getPropertyId(); if (i != 29013) { if (i != 29038) { boolean bool; switch (i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 106 */             Log.w("DVR_Settings", "onChangeEvent Unrecognized signal!"); return;
/*     */           case 29008:
/*     */             if (convertRecordAudio(((Integer)getValue(paramECarXCarPropertyValue)).intValue()) == Tribool.yes) { bool = true; }
/*     */             else { bool = false; }
/*     */              for (ISettings.IDvrSettingsCallback iDvrSettingsCallback : this.mDvrSettingsCallbacks) { try { iDvrSettingsCallback.onRecordAudioCfg(bool); }
/*     */               catch (Exception exception) { exception.printStackTrace(); }
/*     */                }
/*     */              return;
/*     */           case 29007:
/*     */             break;
/*     */         }  i = convertRecordingDuration(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); for (ISettings.IDvrSettingsCallback iDvrSettingsCallback : this.mDvrSettingsCallbacks) { try { iDvrSettingsCallback.onRecordingDurationChange(i); }
/*     */           catch (Exception exception) { exception.printStackTrace(); }
/*     */            }
/*     */          }
/*     */       else { i = convertOperationStatus(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); for (ISettings.IDvrSettingsCallback iDvrSettingsCallback : this.mDvrSettingsCallbacks) { try { iDvrSettingsCallback.onFactoryResetStatus(i); }
/*     */           catch (Exception exception) { exception.printStackTrace(); }
/*     */            }
/*     */          }
/*     */        }
/*     */     else { i = convertResolutionType(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); for (ISettings.IDvrSettingsCallback iDvrSettingsCallback : this.mDvrSettingsCallbacks) { try {
/*     */           iDvrSettingsCallback.onResolutionTypeChange(i);
/*     */         } catch (Exception exception) {
/*     */           exception.printStackTrace();
/*     */         }  }
/*     */        }
/* 131 */      } public int[] getSupportedRecordingDuration() { return SUPPORTED_RECORDING_DURATION; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onErrorEvent(int paramInt1, int paramInt2) {}
/*     */ 
/*     */   
/*     */   public int getRecordingDuration() {
/* 140 */     int i = SUPPORTED_RECORDING_DURATION[2];
/*     */     try {
/* 142 */       int j = this.mCarSignalManager.getRecCycStsOfVehSurrndgsVisnRec();
/* 143 */       i = j = convertRecordingDuration(j);
/* 144 */     } catch (Exception exception) {
/* 145 */       exception.printStackTrace();
/*     */     } 
/* 147 */     return i;
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
/*     */   public void setRecordingDuration(int paramInt) {
/* 159 */     byte b = 3;
/*     */     try {
/* 161 */       if (paramInt == SUPPORTED_RECORDING_DURATION[0]) {
/* 162 */         b = 1;
/* 163 */       } else if (paramInt == SUPPORTED_RECORDING_DURATION[1]) {
/* 164 */         b = 2;
/*     */       } 
/*     */ 
/*     */       
/* 168 */       sendSignal(28701, b);
/* 169 */     } catch (Exception exception) {
/* 170 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tribool ifRecordAudio() {
/* 180 */     Tribool tribool = Tribool.indeterminate;
/*     */     try {
/* 182 */       int i = this.mCarSignalManager.getRecStsOfVehSurrndgsVisnRec();
/* 183 */       Tribool tribool1 = convertRecordAudio(i);
/* 184 */     } catch (Exception exception) {
/* 185 */       exception.printStackTrace();
/*     */     } 
/* 187 */     return tribool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAudioRecordingCfg(boolean paramBoolean) {
/*     */     try {
/* 198 */       sendSignal(28706, paramBoolean);
/* 199 */     } catch (Exception exception) {
/* 200 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getResolutionType() {
/* 210 */     int i = 2;
/*     */     
/*     */     try {
/* 213 */       int j = this.mCarSignalManager.getSetReslStsOfVehSurrndgsVisnRec();
/* 214 */       i = j = convertResolutionType(j);
/* 215 */     } catch (Exception exception) {
/* 216 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 219 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setResolutionType(int paramInt) {
/* 228 */     byte b = 1;
/*     */     
/* 230 */     if (paramInt == 1) {
/* 231 */       b = 2;
/*     */     }
/*     */     
/*     */     try {
/* 235 */       sendSignal(28705, b);
/* 236 */     } catch (Exception exception) {
/* 237 */       exception.printStackTrace();
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
/*     */   public boolean factoryReset() {
/* 251 */     boolean bool = true;
/*     */     
/*     */     try {
/* 254 */       sendSignal(28710, 1);
/* 255 */     } catch (Exception exception) {
/* 256 */       bool = false;
/* 257 */       exception.printStackTrace();
/*     */     } 
/* 259 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setParkMonitor(boolean paramBoolean) {
/* 269 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCrashSensitivityLevel(int paramInt) {
/* 277 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCallback(ISettings.IDvrSettingsCallback paramIDvrSettingsCallback) {
/* 286 */     if (!this.mDvrSettingsCallbacks.contains(paramIDvrSettingsCallback)) {
/* 287 */       this.mDvrSettingsCallbacks.add(paramIDvrSettingsCallback);
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
/*     */   public void unsetCallback(ISettings.IDvrSettingsCallback paramIDvrSettingsCallback) {
/* 299 */     this.mDvrSettingsCallbacks.remove(paramIDvrSettingsCallback);
/*     */   }
/*     */   
/*     */   private int convertRecordingDuration(int paramInt) {
/* 303 */     int i = SUPPORTED_RECORDING_DURATION[2];
/*     */     
/* 305 */     if (paramInt == 1) {
/* 306 */       i = SUPPORTED_RECORDING_DURATION[0];
/* 307 */     } else if (paramInt == 2) {
/* 308 */       i = SUPPORTED_RECORDING_DURATION[1];
/*     */     } 
/*     */     
/* 311 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertResolutionType(int paramInt) {
/* 316 */     byte b = 2;
/*     */     
/* 318 */     if (paramInt == 2) {
/* 319 */       b = 1;
/*     */     }
/*     */     
/* 322 */     return b;
/*     */   }
/*     */   private Tribool convertRecordAudio(int paramInt) {
/*     */     Tribool tribool;
/* 326 */     if (paramInt == 1) { tribool = Tribool.yes; } else { tribool = Tribool.no; }  return tribool;
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertOperationStatus(int paramInt) {
/* 331 */     byte b = 6;
/*     */     
/* 333 */     switch (paramInt) { default: paramInt = b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 345 */         return paramInt;case 2: paramInt = 2; return paramInt;case 1: paramInt = 1; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\Settings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */