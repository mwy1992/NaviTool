/*     */ package com.ecarx.xui.adaptapi.dvr.forp;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DvrForPFunction
/*     */   extends AbsDvrForPSignal
/*     */   implements IDvrFunction
/*     */ {
/*     */   private static final String TAG = "DvrForPFunction";
/*     */   private final CopyOnWriteArrayList<IDvrFunction.IFunctionValueWatcher> mFunctionValueWatchers;
/*     */   
/*     */   protected DvrForPFunction(Context paramContext) {
/*  23 */     super(paramContext);
/*  24 */     this.mFunctionValueWatchers = new CopyOnWriteArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initSignalFilter() {
/*  30 */     addSignalFilter(Integer.valueOf(29013));
/*     */     
/*  32 */     addSignalFilter(Integer.valueOf(29007));
/*     */     
/*  34 */     addSignalFilter(Integer.valueOf(29008));
/*     */     
/*  36 */     addSignalFilter(Integer.valueOf(29022));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/*  41 */     int i = paramECarXCarPropertyValue.getPropertyId(); if (i != 29013) { if (i != 29022) { switch (i) {
/*     */           default:
/*     */             return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           case 29008:
/*  52 */             i = convertToMicMute(((Integer)paramECarXCarPropertyValue.getValue()).intValue()); callbackFunctionValue(1049344, i);
/*     */           case 29007:
/*     */             break;
/*     */         }  i = convertToRecordingDuration(((Integer)paramECarXCarPropertyValue.getValue()).intValue()); callbackFunctionValue(1049856, i); }
/*  56 */        i = ((Integer)paramECarXCarPropertyValue.getValue()).intValue();
/*     */       callbackFunctionValue(1051920, i); }
/*     */     
/*     */     i = convertToVideoResolution(((Integer)paramECarXCarPropertyValue.getValue()).intValue());
/*     */     callbackFunctionValue(1048832, i);
/*     */   } private int convertToMicMute(int paramInt) {
/*  62 */     char c = 'ÿ';
/*  63 */     switch (paramInt) { default: paramInt = c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  71 */         return paramInt;case 1: paramInt = 1; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*     */   }
/*     */   
/*     */   private int convertToRecordingDuration(int paramInt) {
/*  75 */     char c = 'ÿ';
/*  76 */     switch (paramInt) { default: paramInt = c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  87 */         return paramInt;case 3: paramInt = 1049859; return paramInt;case 2: paramInt = 1049858; return paramInt;case 1: break; }  paramInt = 1049857; return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private void callbackFunctionValue(int paramInt1, int paramInt2) {
/*  92 */     for (IDvrFunction.IFunctionValueWatcher iFunctionValueWatcher : this.mFunctionValueWatchers) {
/*     */       try {
/*  94 */         iFunctionValueWatcher.onFunctionValueChanged(paramInt1, paramInt2);
/*  95 */       } catch (Exception exception) {
/*  96 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*  99 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onFunctionValueChanged: function: "); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(",value: "); stringBuilder.append(paramInt2); Log.d("DvrForPFunction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertToVideoResolution(int paramInt) {
/* 104 */     int i = 1048832;
/* 105 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 113 */         return paramInt;case 2: paramInt = 1048833; return paramInt;case 1: break; }  paramInt = 1048834; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isFunctionSupported(int paramInt) {
/* 124 */     FunctionStatus functionStatus2 = getDVRFunctionStatus();
/* 125 */     FunctionStatus functionStatus1 = functionStatus2; if (functionStatus2 == FunctionStatus.active)
/*     */     {
/* 127 */       if (paramInt != 1049344) { functionStatus1 = functionStatus2; }
/*     */       else
/*     */       
/* 130 */       { functionStatus1 = functionStatus2; try { if (this.mCarSignalManager.getVehSurrndgsVisnRecSts() == 3)
/*     */           {
/* 132 */             functionStatus1 = FunctionStatus.notactive;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
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
/*     */ 
/*     */           
/*     */            }
/*     */         
/* 163 */         catch (Exception exception)
/* 164 */         { exception.printStackTrace(); functionStatus1 = functionStatus2; }
/*     */          }
/*     */        } 
/* 167 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isFunctionSupported: function: "); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append("status: "); stringBuilder.append(functionStatus1); Log.d("DvrForPFunction", stringBuilder.toString());
/*     */     
/* 169 */     return functionStatus1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSupportedFunctionValue(int paramInt) {
/* 180 */     if (paramInt != 1048832) { if (paramInt != 1049344) { if (paramInt != 1049856)
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
/*     */ 
/*     */ 
/*     */           
/* 194 */           return new int[0];
/*     */         }
/*     */         return new int[] { 1049857, 1049858, 1049859 }; }
/*     */       
/*     */       return new int[] { 1, 0 }; }
/*     */     
/*     */     return new int[] { 1048833, 1048834 };
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setFunctionValue(int paramInt1, int paramInt2) {
/*     */     StringBuilder stringBuilder;
/* 206 */     boolean bool = true;
/* 207 */     switch (paramInt1)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 275 */         stringBuilder = new StringBuilder(); stringBuilder.append("setFunctionValue: function: "); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", funValue: "); stringBuilder.append(paramInt2); stringBuilder.append(", result: "); stringBuilder.append(bool); Log.d("DvrForPFunction", stringBuilder.toString());
/*     */         
/* 277 */         return bool;
/*     */       case 1049856: if (paramInt2 == 1049857) { sendSignal(28701, 1); } else if (paramInt2 == 1049858) { sendSignal(28701, 2); } else if (paramInt2 == 1049859) { sendSignal(28701, 3); } else { bool = false; } 
/*     */       case 1049344: if (paramInt2 == 0) { sendSignal(28706, 0); } else if (paramInt2 == 1) { sendSignal(28706, 1); } else { bool = false; } 
/*     */       case 1049088: case 1049600: case 1050112: case 1050368: case 1050624: case 1050880: case 1051136:
/*     */       case 1051392:
/*     */       case 1051648:
/*     */       case 1051904:
/*     */         bool = false;
/*     */       case 1048832:
/*     */         break; }  if (paramInt2 == 1048833)
/*     */       sendSignal(28705, 2);  if (paramInt2 == 1048834)
/* 288 */       sendSignal(28705, 1);  bool = false; } public int getFunctionValue(int paramInt) { int i = 255;
/*     */     
/* 290 */     if (paramInt != 1048832) { if (paramInt != 1049344) { if (paramInt != 1049856) { if (paramInt == 1051920)
/*     */ 
/*     */             
/*     */             try { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 327 */               int j = this.mCarSignalManager.getTFCarCap();
/*     */                }
/*     */             
/* 330 */             catch (Exception exception)
/* 331 */             { exception.printStackTrace(); }   } else { CarSignalManager carSignalManager = this.mCarSignalManager; int j = carSignalManager.getRecCycStsOfVehSurrndgsVisnRec(); if (j == 1) { i = 1049857; } else if (j == 2) { i = 1049858; } else if (j == 3) { i = 1049859; }  }  } else { int j = this.mCarSignalManager.getRecStsOfVehSurrndgsVisnRec(); if (j == 1) { i = 1; } else if (j == 0) { i = 0; }  }  } else { CarSignalManager carSignalManager = this.mCarSignalManager; int j = carSignalManager.getSetReslStsOfVehSurrndgsVisnRec(); if (j == 1) { i = 1048834; } else if (j == 2) { i = 1048833; }
/*     */        }
/* 333 */      StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getFunctionValue: function: "); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", reslut: "); stringBuilder.append(i); Log.d("DvrForPFunction", stringBuilder.toString());
/*     */     
/* 335 */     return i; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setCustomizeFunctionValue(int paramInt, float paramFloat) {
/* 347 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getCustomizeFunctionValue(int paramInt) {
/* 358 */     return Float.MIN_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerFunctionValueWatcher(IDvrFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 369 */     boolean bool2 = false;
/* 370 */     boolean bool1 = bool2; if (paramIFunctionValueWatcher != null) { bool1 = bool2; if (!this.mFunctionValueWatchers.contains(paramIFunctionValueWatcher)) {
/* 371 */         this.mFunctionValueWatchers.add(paramIFunctionValueWatcher);
/* 372 */         bool1 = true;
/*     */       }  }
/* 374 */      return bool1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterFunctionValueWatcher(IDvrFunction.IFunctionValueWatcher paramIFunctionValueWatcher) {
/* 385 */     this.mFunctionValueWatchers.remove(paramIFunctionValueWatcher);
/* 386 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\DvrForPFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */