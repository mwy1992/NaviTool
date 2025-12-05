/*     */ package com.ecarx.xui.adaptapi.dvr.forp;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.os.Looper;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
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
/*     */ public class DvrForPManager
/*     */   extends AbsDvrForPSignal
/*     */   implements IDvrManager
/*     */ {
/*     */   private static final String TAG = "DvrForPManager";
/*     */   private volatile int mCurrentOpt;
/*     */   private volatile int mCurrentSDSatus;
/*     */   private DvrForPFileManager mDvrForPFileManager;
/*     */   private final CopyOnWriteArrayList<IDvrManager.IDvrObserver> mDvrObservers;
/*     */   private volatile int mDvrStatus;
/*     */   private volatile int mDvrStatusBeforPic;
/*     */   private final CopyOnWriteArrayList<Integer> mRecording;
/*     */   private volatile int mVehSurrndgsVisnRecStsStatus;
/*     */   
/*     */   protected DvrForPManager(Context paramContext) {
/*  40 */     super(paramContext);
/*  41 */     this.mDvrObservers = new CopyOnWriteArrayList<>();
/*  42 */     this.mRecording = new CopyOnWriteArrayList<>();
/*  43 */     this.mDvrForPFileManager = new DvrForPFileManager(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/*  54 */     super.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*  55 */     this.mDvrForPFileManager.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initSignalFilter() {
/*  61 */     addSignalFilter(Integer.valueOf(29040));
/*     */     
/*  63 */     addSignalFilter(Integer.valueOf(29020));
/*     */ 
/*     */ 
/*     */     
/*  67 */     addSignalFilter(Integer.valueOf(29036));
/*     */     
/*  69 */     addSignalFilter(Integer.valueOf(29041));
/*     */     
/*  71 */     addSignalFilter(Integer.valueOf(29038));
/*     */     
/*  73 */     addSignalFilter(Integer.valueOf(28956));
/*     */     
/*  75 */     addSignalFilter(Integer.valueOf(29039));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/*  86 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onChangeEvent: "); stringBuilder.append(paramECarXCarPropertyValue.toString()); Log.d("DvrForPManager", stringBuilder.toString());
/*  87 */     int i = paramECarXCarPropertyValue.getPropertyId(); if (i != 28956) { if (i != 29008) { if (i != 29020) { if (i != 29036) { switch (i) {
/*     */               default:
/*     */                 return;
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               case 29041:
/*  95 */                 i = convertToSDCardFormatStates(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */                 callbackeDvrOperation(4101, i);
/*     */               
/*     */               case 29040:
/*  99 */                 if (this.mVehSurrndgsVisnRecStsStatus == 3 && (
/* 100 */                   (Integer)getValue(paramECarXCarPropertyValue)).intValue() != 3) {
/* 101 */                   callbackDvrStatus(9);
/*     */                 }
/* 103 */                 this.mVehSurrndgsVisnRecStsStatus = ((Integer)getValue(paramECarXCarPropertyValue)).intValue();
/* 104 */                 callbackDvrStatus(convertToDvrStates(((Integer)getValue(paramECarXCarPropertyValue)).intValue()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               case 29039:
/* 127 */                 if (((Integer)getValue(paramECarXCarPropertyValue)).intValue() == 1)
/* 128 */                 { this.mDvrStatusBeforPic = this.mDvrStatus;
/* 129 */                   callbackDvrStatus(6); }
/* 130 */                 else if (((Integer)getValue(paramECarXCarPropertyValue)).intValue() == 0 && 
/* 131 */                   this.mDvrStatus == 6)
/*     */                 
/*     */                 { 
/* 134 */                   this.mDvrStatus = this.mDvrStatusBeforPic; } 
/*     */               case 29038:
/*     */                 break;
/*     */             }  i = convertToDvrRestoreStates(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); callbackeDvrOperation(4104, i); }
/*     */            onDvrOperationStatus(); }
/*     */          callbackSDCardStatus(convertToSDCardStates(((Integer)getValue(paramECarXCarPropertyValue)).intValue())); }
/* 140 */        if (this.mRecording.size() != 0) {
/* 141 */         if (((Integer)this.mRecording.get(this.mRecording.size() - 1)).intValue() == 1) {
/*     */ 
/*     */           
/* 144 */           i = convertToDvrRecordStatus(((Integer)getValue(paramECarXCarPropertyValue)).intValue())[0];
/*     */           
/*     */           callbackeDvrOperation(4103, i);
/*     */         } else {
/* 148 */           i = convertToDvrRecordStatus(((Integer)getValue(paramECarXCarPropertyValue)).intValue())[1]; callbackeDvrOperation(4102, i);
/*     */         } 
/* 150 */         this.mRecording.clear();
/*     */       }  }
/*     */     
/*     */     callbackSDCardStatus(convertToSDCardErrStates(((Integer)getValue(paramECarXCarPropertyValue)).intValue()));
/*     */     callbackDvrStatus(convertToDvrErrStates(((Integer)getValue(paramECarXCarPropertyValue)).intValue()));
/*     */   }
/*     */   private int[] convertToDvrRecordStatus(int paramInt) {
/* 157 */     boolean bool = false;
/* 158 */     byte b = 0;
/* 159 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 169 */         return new int[] { paramInt, b };case 1: paramInt = 3; b = 4; return new int[] { paramInt, b };case 0: break; }  paramInt = 4; b = 3; return new int[] { paramInt, b };
/*     */   }
/*     */ 
/*     */   
/*     */   private void callbackeDvrOperation(int paramInt1, int paramInt2) {
/* 174 */     for (IDvrManager.IDvrObserver iDvrObserver : this.mDvrObservers) {
/*     */       try {
/* 176 */         iDvrObserver.onOperationStatus(paramInt1, paramInt2);
/* 177 */       } catch (Exception exception) {
/* 178 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/* 181 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onOperationStatus: operation: "); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", status: "); stringBuilder.append(paramInt2); Log.d("DvrForPManager", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   private int convertToSDCardErrStates(int paramInt) {
/* 186 */     if (paramInt == 12 || paramInt == 13) {
/* 187 */       return 11;
/*     */     }
/* 189 */     return this.mCurrentSDSatus;
/*     */   }
/*     */   
/*     */   private void callbackDvrStatus(int paramInt) {
/* 193 */     if (this.mDvrStatus != paramInt) {
/* 194 */       this.mDvrStatus = paramInt;
/* 195 */       for (IDvrManager.IDvrObserver iDvrObserver : this.mDvrObservers) {
/*     */         try {
/* 197 */           iDvrObserver.onDvrStateChanged(paramInt);
/* 198 */         } catch (Exception exception) {
/* 199 */           exception.printStackTrace();
/*     */         } 
/*     */       } 
/* 202 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onDvrStateChanged: "); stringBuilder.append(Integer.toHexString(paramInt)); Log.d("DvrForPManager", stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   private int convertToDvrErrStates(int paramInt) {
/* 207 */     int i = this.mDvrStatus;
/* 208 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 254 */         return paramInt;case 14: paramInt = 20; return paramInt;case 11: paramInt = 21; return paramInt;case 10: paramInt = 19; return paramInt;case 8: paramInt = 28; return paramInt;case 7: case 15: paramInt = 18; return paramInt;case 6: paramInt = 25; return paramInt;case 5: paramInt = 26; return paramInt;case 4: paramInt = 22; return paramInt;case 3: paramInt = 29; return paramInt;case 2: paramInt = 27; return paramInt;case 1: paramInt = 24; return paramInt;case 0: case 9: break; }  try { paramInt = convertToDvrStates(this.mCarSignalManager.getSignalValue(29040)); } catch (Exception exception) { exception.printStackTrace(); paramInt = i; }  return paramInt;
/*     */   }
/*     */   
/*     */   private int convertToDvrRestoreStates(int paramInt) {
/* 258 */     boolean bool = false;
/* 259 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 267 */         return paramInt;case 2: paramInt = 4; return paramInt;case 1: break; }  paramInt = 3; return paramInt;
/*     */   }
/*     */   
/*     */   private int convertToSDCardFormatStates(int paramInt) {
/* 271 */     boolean bool = false;
/* 272 */     switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 283 */         return paramInt;case 3: paramInt = 4; return paramInt;case 2: paramInt = 3; return paramInt;case 1: break; }  paramInt = 2; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 291 */     super.onECarXCarServiceDeath();
/* 292 */     this.mDvrForPFileManager.onECarXCarServiceDeath();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IFileManager getFileManager() {
/* 302 */     return this.mDvrForPFileManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isDvrOperationSupported(int paramInt) {
/*     */     String str2;
/* 313 */     FunctionStatus functionStatus1 = getDVRFunctionStatus();
/* 314 */     FunctionStatus functionStatus2 = functionStatus1; if (functionStatus1 == FunctionStatus.active)
/*     */     { StringBuilder stringBuilder1; String str; FunctionStatus functionStatus;
/* 316 */       switch (paramInt) { case 4098:
/*     */         case 4100:
/*     */         case 4102:
/*     */         case 4103:
/*     */           try {
/* 321 */             if (this.mCarSignalManager.getVehSurrndgsVisnRecSts() == 3) {
/*     */               
/* 323 */               functionStatus1 = functionStatus2 = FunctionStatus.notactive; break;
/*     */             } 
/* 325 */             functionStatus1 = functionStatus2 = FunctionStatus.active;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/* 338 */           } catch (Exception exception) {
/* 339 */             exception.printStackTrace(); functionStatus = functionStatus1;
/*     */           } 
/*     */           
/* 342 */           stringBuilder1 = new StringBuilder(); stringBuilder1.append("isDvrOperationSupported: operation: "); stringBuilder1.append(Integer.toHexString(paramInt)); stringBuilder1.append(", status: ");
/* 343 */           stringBuilder1.append(functionStatus.name()); str = stringBuilder1.toString(); Log.d("DvrForPManager", str);
/* 344 */           return functionStatus; }  str2 = str; }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isDvrOperationSupported: operation: "); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", status: "); stringBuilder.append(str2.name()); String str1 = stringBuilder.toString(); Log.d("DvrForPManager", str1); return (FunctionStatus)str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isDvrCameraSupported(int paramInt) {
/* 355 */     FunctionStatus functionStatus2 = getDVRFunctionStatus();
/*     */ 
/*     */     
/* 358 */     FunctionStatus functionStatus1 = functionStatus2; if (paramInt == 2)
/* 359 */       try { int i = this.mCarSignalManager.getVehModMngtGlbSafe1CarModSts1();
/* 360 */         if (this.mCarSignalManager.getcarconfig497() == 2) {
/* 361 */           if (this.mCarSignalManager.getVehModMngtGlbSafe1UsgModSts() != 0 && (i == 0 || i == 2 || i == 5)) {
/*     */ 
/*     */             
/* 364 */             functionStatus1 = FunctionStatus.active;
/*     */           } else {
/* 366 */             functionStatus1 = FunctionStatus.notactive;
/*     */           } 
/*     */         } else {
/* 369 */           functionStatus1 = FunctionStatus.notavailable;
/*     */         }
/*     */          }
/* 372 */       catch (CarNotConnectedException carNotConnectedException)
/* 373 */       { carNotConnectedException.printStackTrace(); functionStatus1 = functionStatus2; }
/*     */        
/* 375 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isDvrCameraSupported: camera: "); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", status:");
/* 376 */     stringBuilder.append(functionStatus1.name()); String str = stringBuilder.toString(); Log.d("DvrForPManager", str);
/* 377 */     return functionStatus1;
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
/*     */   public FunctionStatus isDvrCameraOperationSupported(int paramInt1, int paramInt2) {
/* 389 */     FunctionStatus functionStatus1 = FunctionStatus.notavailable;
/* 390 */     FunctionStatus functionStatus2 = functionStatus1; if (paramInt2 == 1) {
/*     */       
/* 392 */       FunctionStatus functionStatus = functionStatus1; functionStatus2 = functionStatus1; try { if (isDvrCameraSupported(1) == FunctionStatus.active) {
/* 393 */           if (paramInt1 == 4098) {
/*     */             
/* 395 */             functionStatus2 = functionStatus1; if (this.mCarSignalManager.getVehSurrndgsVisnRecSts() == 3) {
/*     */               
/* 397 */               functionStatus2 = functionStatus1; functionStatus1 = FunctionStatus.notactive;
/*     */             } else {
/* 399 */               functionStatus2 = functionStatus1; functionStatus1 = FunctionStatus.active;
/*     */             } 
/*     */           } 
/* 402 */           functionStatus2 = functionStatus1; functionStatus = FunctionStatus.active;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 407 */         functionStatus2 = functionStatus; } catch (Exception exception) { exception.printStackTrace(); }
/*     */     
/* 409 */     }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isDvrCameraOperationSupported: operation: "); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", camera: ");
/* 410 */     stringBuilder.append(Integer.toHexString(paramInt2)); stringBuilder.append(", status: "); stringBuilder.append(functionStatus2); String str = stringBuilder.toString(); Log.d("DvrForPManager", str);
/* 411 */     return functionStatus2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doDvrOperation(int paramInt) {
/*     */     try {
/* 422 */       if (isDvrOperationSupported(paramInt) == FunctionStatus.active) {
/* 423 */         if (paramInt != 8200) { int i; DvrForPFileManager dvrForPFileManager; switch (paramInt) { default: switch (paramInt) {
/*     */                 default:
/*     */                   break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 case 8196:
/*     */                 case 8195:
/*     */                 case 8194:
/*     */                 case 8193:
/*     */                   break;
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 441 */               dvrForPFileManager = this.mDvrForPFileManager;
/* 442 */               i = convertResults(dvrForPFileManager.refreshFileList()); callbackeDvrOperation(8193, i); break;case 4104: sendSignal(28710, 1); break;
/*     */             case 4103: sendSignal(28706, 1); this.mRecording.add(Integer.valueOf(1)); break;
/*     */             case 4102: sendSignal(28706, 0); this.mRecording.add(Integer.valueOf(0)); break;
/* 445 */             case 4101: sendSignal(28711, 1); break; }  } else { DvrForPFileManager dvrForPFileManager = this.mDvrForPFileManager;
/* 446 */           int i = convertResults(dvrForPFileManager.refreshFileListNum(3));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           callbackeDvrOperation(8193, i); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 461 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("doDvrOperation: operation: "); stringBuilder.append(Integer.toHexString(paramInt)); Log.d("DvrForPManager", stringBuilder.toString());
/*     */       } 
/* 463 */     } catch (Exception exception) {
/* 464 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private int convertResults(boolean paramBoolean) {
/* 469 */     if (paramBoolean) {
/* 470 */       return 3;
/*     */     }
/* 472 */     return 4;
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
/*     */   public void doDvrCameraOperation(int paramInt1, int paramInt2) {
/* 485 */     doDvrCameraOperation(paramInt1, paramInt2, 0);
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
/*     */   public void doDvrCameraOperation(int paramInt1, int paramInt2, int paramInt3) {
/*     */     try {
/* 501 */       if (isDvrCameraOperationSupported(paramInt1, paramInt2) == FunctionStatus.active && paramInt3 == 0)
/*     */       {
/*     */         
/* 504 */         if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
/*     */           
/* 506 */           Thread thread = new Thread(); Runnable runnable = new Runnable() {
/*     */               final DvrForPManager this$0; final int val$camera; final int val$operation;
/*     */               
/* 509 */               public void run() { DvrForPManager.this.doSpecificOperations(operation, camera); } }; super(this, paramInt1, paramInt2);
/*     */           this(runnable);
/* 511 */           thread.start();
/*     */         } else {
/* 513 */           doSpecificOperations(paramInt1, paramInt2);
/*     */         } 
/*     */       }
/* 516 */     } catch (Exception exception) {
/* 517 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void doSpecificOperations(int paramInt1, int paramInt2) {
/* 522 */     if (this.mDvrForPFileManager.exitBrowseMode()) {
/* 523 */       switch (paramInt1)
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
/*     */         case 4100:
/* 540 */           sendSignal(28709, 9);
/*     */           
/* 542 */           this.mCurrentOpt = 9; break;
/*     */         case 4099: sendSignal(28709, 3); this.mCurrentOpt = 3; break;
/*     */         case 4098:
/*     */           sendSignal(28709, 2); this.mCurrentOpt = 2; break;
/*     */         case 4097:
/* 547 */           sendSignal(28709, 1); this.mCurrentOpt = 1; break; }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("doDvrCameraOperation: operation: "); stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", camera: ");
/* 548 */       stringBuilder.append(Integer.toHexString(paramInt2)); String str = stringBuilder.toString();
/*     */       Log.d("DvrForPManager", str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentDvrStates() {
/* 560 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getCurrentDvrStates: "); stringBuilder.append(Integer.toHexString(this.mDvrStatus)); Log.d("DvrForPManager", stringBuilder.toString());
/* 561 */     return this.mDvrStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSDCardStates() {
/* 571 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getSDCardStates: "); stringBuilder.append(Integer.toHexString(this.mCurrentSDSatus)); Log.d("DvrForPManager", stringBuilder.toString());
/* 572 */     return this.mCurrentSDSatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerOperationObserver(IDvrManager.IDvrObserver paramIDvrObserver) {
/* 583 */     if (!this.mDvrObservers.contains(paramIDvrObserver)) {
/* 584 */       this.mDvrObservers.add(paramIDvrObserver);
/*     */     }
/* 586 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unegisterOperationObserver(IDvrManager.IDvrObserver paramIDvrObserver) {
/* 597 */     this.mDvrObservers.remove(paramIDvrObserver);
/* 598 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerDvrEMMCStateObserver(IDvrManager.IDvrEMMCStateObserver paramIDvrEMMCStateObserver) {
/* 608 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unRegisterDvrEMMCStateObserver(IDvrManager.IDvrEMMCStateObserver paramIDvrEMMCStateObserver) {
/* 618 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int convertToSDCardStates(int paramInt) {
/* 628 */     int i = this.mCurrentSDSatus;
/* 629 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 662 */         return paramInt;case 9: paramInt = 8; return paramInt;case 8: paramInt = 7; return paramInt;case 7: paramInt = 14; return paramInt;case 6: paramInt = 13; return paramInt;case 5: paramInt = 9; return paramInt;case 4: paramInt = 12; return paramInt;case 3: paramInt = 4; return paramInt;case 2: paramInt = 10; return paramInt;case 1: paramInt = 2; return paramInt;case 0: break; }  paramInt = 1; return paramInt;
/*     */   }
/*     */   
/*     */   private int convertToDvrStates(int paramInt) {
/* 666 */     int i = this.mDvrStatus;
/* 667 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 688 */         return paramInt;case 3: paramInt = 4; return paramInt;case 2: case 5: case 6: case 7: case 8: case 9: case 10: case 11: paramInt = 3; return paramInt;case 1: paramInt = 2; return paramInt;case 0: break; }  paramInt = 1; return paramInt;
/*     */   }
/*     */   
/*     */   private int convertOperationStatus(int paramInt) {
/* 692 */     boolean bool = false;
/* 693 */     if (paramInt != 4) { switch (paramInt) { default: paramInt = bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 704 */           return paramInt;case 2: paramInt = 4; return paramInt;case 1: break; }  paramInt = 3; } else { paramInt = 2; }  return paramInt;
/*     */   }
/*     */   
/*     */   private void callbackSDCardStatus(int paramInt) {
/* 708 */     if (paramInt != this.mCurrentSDSatus) {
/* 709 */       this.mCurrentSDSatus = paramInt;
/* 710 */       for (IDvrManager.IDvrObserver iDvrObserver : this.mDvrObservers) {
/*     */         try {
/* 712 */           iDvrObserver.onSDCardStateChanged(paramInt);
/* 713 */         } catch (Exception exception) {
/* 714 */           exception.printStackTrace();
/*     */         } 
/*     */       } 
/* 717 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onSDCardStateChanged: "); stringBuilder.append(Integer.toHexString(paramInt)); Log.d("DvrForPManager", stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void onDvrOperationStatus() {
/*     */     try {
/* 724 */       CarSignalManager carSignalManager = this.mCarSignalManager;
/* 725 */       int i = carSignalManager.getVehSurrndgsVinRecCmdRes();
/*     */       
/*     */       int j = convertOperationStatus(i);
/* 728 */       if (j == 4) {
/*     */         
/* 730 */         i = this.mCurrentOpt;
/*     */       } else {
/* 732 */         i = this.mCarSignalManager.getVehSurrndgsVinRecCmdRespTbl();
/*     */       } 
/* 734 */       if (i != 0 && j != 0)
/*     */       
/* 736 */       { if (i != 9) { switch (i)
/*     */           { default:
/*     */               return;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 3:
/* 744 */               if (j == 3) {
/* 745 */                 callbackDvrStatus(4);
/*     */               }
/* 747 */               callbackeDvrOperation(4099, j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 2:
/* 756 */               if (j == 3) {
/* 757 */                 callbackDvrStatus(3);
/*     */               }
/* 759 */               callbackeDvrOperation(4098, j);
/*     */             case 1:
/*     */               break; }  if (j == 3)
/*     */             callbackDvrStatus(2);  callbackeDvrOperation(4097, j); }  callbackeDvrOperation(4100, j); } 
/* 763 */     } catch (Exception exception) {
/* 764 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\DvrForPManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */