/*     */ package com.ecarx.xui.adaptapi.car.base;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Context;
/*     */ import android.hardware.display.DisplayManagerGlobal;
/*     */ import android.util.Log;
/*     */ import android.view.Display;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.os.LocalConfig;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarInfo
/*     */   extends AbsCarSignal
/*     */   implements ICarInfo
/*     */ {
/*  23 */   public static String TAG = "CarInfo";
/*     */   
/*     */   public CarInfo(Context paramContext) {
/*  26 */     super(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionStatus isCarInfoSupported(int paramInt) {
/*  37 */     switch (paramInt)
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
/*     */       default:
/*  65 */         return FunctionStatus.notavailable;
/*     */       case 1049088: case 1049344: case 1049600: case 1050880: case 1051664: case 1051680: case 1051904: case 1052160: case 1052163: case 1052417: case 1052418: case 2098176:
/*     */       case 8389376:
/*     */       case 8389632:
/*     */       case 8389888:
/*     */       case 8390144:
/*     */       case 8390400:
/*     */       case 8390656:
/*     */       case 8390912:
/*     */       case 8391168:
/*     */       case 8391424:
/*  76 */         break; }  return FunctionStatus.active; } public int getCarInfoInt(int paramInt) { int i; byte b = -1;
/*  77 */     if (paramInt == 1051680)
/*     */     { try {
/*  79 */         i = this.mCarSignalManager.getcarconfig162();
/*  80 */       } catch (Exception exception) {
/*  81 */         exception.printStackTrace(); i = b;
/*     */       }  }
/*  83 */     else if (paramInt == 1051664)
/*     */     { try {
/*  85 */         i = this.mCarSignalManager.getcarconfig163();
/*  86 */       } catch (Exception exception) {
/*  87 */         exception.printStackTrace(); i = b;
/*     */       }  }
/*  89 */     else if (paramInt == 1052160)
/*  90 */     { Log.d(TAG, "INT_INFO_EHP_V2_AVAILABLE");
/*     */       try {
/*  92 */         i = checkEhpV2();
/*  93 */       } catch (Exception exception) {
/*  94 */         exception.printStackTrace();
/*  95 */         i = 0;
/*     */       } 
/*  97 */       String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("ret = "); stringBuilder.append(i); Log.d(str, stringBuilder.toString()); }
/*  98 */     else if (paramInt == 1052417)
/*  99 */     { i = 0; }
/* 100 */     else if (paramInt == 1052418)
/* 101 */     { i = 0; }
/* 102 */     else if (paramInt == 1051904)
/*     */     { try {
/* 104 */         i = checkPaddleLaneChangeAssistAvailable(this.mCarSignalManager.getcarconfig100());
/* 105 */       } catch (Exception exception) {
/* 106 */         exception.printStackTrace();
/* 107 */         i = 1051905;
/*     */       }  }
/* 109 */     else if (paramInt == 1049088)
/*     */     { try {
/* 111 */         i = convertVehicleType(this.mCarSignalManager.getcarconfig13());
/* 112 */       } catch (Exception exception) {
/* 113 */         exception.printStackTrace();
/* 114 */         i = 1049343;
/*     */       }
/*     */        }
/* 117 */     else if (paramInt == 1049344)
/*     */     { try {
/* 119 */         i = convertSeatSide(this.mCarSignalManager.getcarconfig8());
/* 120 */       } catch (Exception exception) {
/* 121 */         exception.printStackTrace();
/* 122 */         i = 1049599;
/*     */       }  }
/* 124 */     else if (paramInt == 1049600)
/*     */     { try {
/* 126 */         i = convertDriveMode(this.mCarSignalManager.getcarconfig3());
/* 127 */       } catch (Exception exception) {
/* 128 */         exception.printStackTrace();
/* 129 */         i = 1049855;
/*     */       }  }
/* 131 */     else { if (paramInt == 1050880)
/* 132 */         return getARNavigationAvailability(); 
/* 133 */       if (paramInt == 1051648) { i = b;
/*     */         
/*     */          }
/*     */       
/*     */       else
/*     */       
/*     */       { 
/* 140 */         i = b; if (paramInt == 1052163)
/*     */           try {
/* 142 */             i = this.mCarSignalManager.getcarconfig466();
/* 143 */           } catch (Exception exception) {
/* 144 */             exception.printStackTrace(); i = b;
/*     */           }   }
/*     */        }
/* 147 */      return i; }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntelligentEnergyManagement() {
/* 152 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasMultiAmbience() {
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getCarInfoInts(int paramInt) {
/* 168 */     if (paramInt == 1048832)
/*     */     {
/* 170 */       return new int[] { 1049087 }; } 
/* 171 */     if (paramInt == 4194816)
/*     */     {
/* 173 */       return new int[] { 4195071 };
/*     */     }
/* 175 */     return new int[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getCarInfoFloat(int paramInt) {
/* 186 */     float f2 = 0.0F, f1 = 0.0F;
/*     */     
/* 188 */     if (paramInt == 2097408)
/*     */     { 
/* 190 */       try { f1 = convertCapacitySize(this.mCarSignalManager.getcarconfig11());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */          }
/*     */       
/* 201 */       catch (Exception exception)
/* 202 */       { exception.printStackTrace(); f1 = f2; }  } else if (paramInt == 2097664) { f1 = 0.0F; }
/*     */     else if (paramInt == 2097920) { f1 = this.mCarSignalManager.getVehMNomVehM(); }
/*     */     else if (paramInt == 2098176) { f1 = convertMaxLimitedSpeed(this.mCarSignalManager.getcarconfig43()); }
/* 205 */      return f1;
/*     */   }
/*     */   
/*     */   private float convertCapacitySize(int paramInt) {
/* 209 */     float f = 0.0F;
/* 210 */     switch (paramInt) { default: switch (paramInt)
/*     */         
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 260 */             return f;case 133: f = 52000.0F;case 132: f = 62000.0F;case 131: f = 48000.0F;case 130: f = 46000.0F;case 129: f = 42000.0F;
/*     */           case 128: break; }  f = 40000.0F;
/*     */       case 10: f = 70000.0F;
/*     */       case 9: f = 0.0F;
/*     */       case 8: f = 49000.0F;
/*     */       case 7: f = 54000.0F;
/*     */       case 6: f = 47000.0F;
/*     */       case 5: f = 36000.0F;
/*     */       case 4: f = 55000.0F;
/*     */       case 3: f = 50000.0F;
/*     */       case 2: f = 60000.0F;
/* 271 */       case 1: break; }  f = 71000.0F; } public String getCarInfoString(int paramInt) { return null; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCarInfoConfig(int paramInt) {
/* 282 */     int k, j = 8388863;
/*     */     
/* 284 */     int i = 8388610; switch (paramInt) { default: paramInt = j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 358 */         return paramInt;case 8392496: try { paramInt = this.mCarSignalManager.getcarconfig174(); if (paramInt != 130 && paramInt != 131) i = 8388609;  paramInt = i; } catch (CarNotConnectedException carNotConnectedException) { carNotConnectedException.printStackTrace(); paramInt = j; }  return paramInt;case 8391424: paramInt = 8388610; return paramInt;case 8391168: paramInt = this.mCarSignalManager.getcarconfig372(); if (paramInt != 3) i = 8388609;  paramInt = i; return paramInt;case 8390912: paramInt = this.mCarSignalManager.getcarconfig177(); if (paramInt != 2 && paramInt != 3) i = 8388609;  paramInt = i; return paramInt;case 8390656: paramInt = this.mCarSignalManager.getcarconfig366(); if (paramInt != 2 && paramInt != 3) i = 8388609;  paramInt = i; return paramInt;case 8390400: paramInt = this.mCarSignalManager.getcarconfig200(); if (paramInt != 3 && paramInt != 4) i = 8388609;  paramInt = i; return paramInt;case 8390144: k = this.mCarSignalManager.getcarconfig154(); paramInt = i; if (k != 2) { paramInt = i; if (k != 5) { paramInt = i; if (k != 129) if (k == 131) { paramInt = i; } else { paramInt = 8388609; }   }  }  return paramInt;case 8389888: k = this.mCarSignalManager.getcarconfig154(); paramInt = i; if (k != 3) { paramInt = i; if (k != 6) { paramInt = i; if (k != 129) { paramInt = i; if (k != 130) { paramInt = i; if (k != 131) if (k == 132) { paramInt = i; } else { paramInt = 8388609; }   }  }  }  }  return paramInt;case 8389632: paramInt = 8388609; return paramInt;case 8389376: paramInt = this.mCarSignalManager.getcarconfig483(); if (paramInt != 2) i = 8388609;  paramInt = i; return paramInt;case 8389120: paramInt = 8388609; return paramInt;case 8388864: break; }  paramInt = 8388609; return paramInt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map getCarInfoMap(int paramInt) {
/* 387 */     return null;
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
/*     */   public Display getPresentationDisplay(int paramInt) {
/* 405 */     DisplayManagerGlobal displayManagerGlobal = DisplayManagerGlobal.getInstance();
/* 406 */     if (paramInt != 1) { if (paramInt != 4) { switch (paramInt)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 415 */             return null;
/*     */           case -2147483647:
/*     */           case -2147483646:
/*     */             break; }  return displayManagerGlobal.getRealDisplay(2); }
/*     */        return displayManagerGlobal.getRealDisplay(3); }
/* 420 */      return displayManagerGlobal.getRealDisplay(0); } private int convertMaintenanceType(int paramInt) { int i = 1051903;
/* 421 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 431 */         return paramInt;case 2: paramInt = 1051650; return paramInt;case 1: break; }  paramInt = 1051649; return paramInt; }
/*     */ 
/*     */   
/*     */   private float convertMaxLimitedSpeed(int paramInt) {
/* 435 */     float f1, f2 = Float.MAX_VALUE;
/* 436 */     if (paramInt >= 2 && paramInt <= 42)
/*     */     
/* 438 */     { f1 = (100 + (paramInt - 2) * 5); }
/* 439 */     else { f1 = f2; if (paramInt >= 43) { f1 = f2; if (paramInt <= 69)
/*     */         {
/*     */           
/* 442 */           f1 = (60 + (paramInt - 43) * 5) * 1.609F; }  }
/*     */        }
/* 444 */      return f1;
/*     */   }
/*     */   
/*     */   private int checkPaddleLaneChangeAssistAvailable(int paramInt) {
/* 448 */     int i = 1051905;
/* 449 */     if (paramInt != 128) { paramInt = i; }
/*     */     else
/* 451 */     { paramInt = 1051904; }
/*     */ 
/*     */     
/* 454 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int checkEhpV2() {
/* 460 */     boolean bool1 = false, bool2 = false; try { int i = this.mCarSignalManager.getcarconfig149();
/* 461 */       if (i == 41) {
/* 462 */         bool1 = true;
/*     */       } else {
/* 464 */         bool1 = bool2;
/*     */       }  }
/* 466 */     catch (Exception exception)
/* 467 */     { exception.printStackTrace(); }
/*     */ 
/*     */     
/* 470 */     return bool1;
/*     */   }
/*     */   
/*     */   private int convertVehicleType(int paramInt) {
/* 474 */     int i = 1049343;
/* 475 */     if (paramInt != 128) { switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 498 */           return paramInt;case 4: paramInt = 1049096; return paramInt;case 3: paramInt = 1049091; return paramInt;case 2: paramInt = 1049090; return paramInt;case 1: break; }  paramInt = 1049089; } else { paramInt = 1049095; }  return paramInt;
/*     */   }
/*     */   
/*     */   private int convertSeatSide(int paramInt) {
/* 502 */     int i = 1049599;
/* 503 */     if (paramInt == 1) {
/* 504 */       i = 1049345;
/* 505 */     } else if (paramInt == 2) {
/* 506 */       i = 1049346;
/*     */     } 
/* 508 */     return i;
/*     */   }
/*     */   
/*     */   private int convertDriveMode(int paramInt) {
/* 512 */     int i = 1049855;
/* 513 */     if (paramInt == 1) {
/*     */       
/* 515 */       i = 1049601;
/* 516 */     } else if (paramInt == 2) {
/*     */       
/* 518 */       i = 1049603;
/* 519 */     } else if (paramInt == 129) {
/*     */       
/* 521 */       i = 1049602;
/*     */     } 
/* 523 */     return i;
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
/*     */   private int getARNavigationAvailability() {
/*     */     try {
/* 537 */       int j = this.mCarSignalManager.getcarconfig483();
/* 538 */       int i = this.mCarSignalManager.getcarconfig158();
/*     */       
/* 540 */       if (j == 2 && i != 4)
/* 541 */       { i = LocalConfig.get().getInt(LocalConfig.KEY.Lcfg_ARNavigation_Availability); switch (i)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 549 */             return 1051135;
/*     */           case 3: return 1050883;
/*     */           case 2: return 1050882;
/* 552 */           case 1: break; }  return 1050881; }  return 1051135;
/*     */     
/*     */     }
/* 555 */     catch (CarNotConnectedException carNotConnectedException) {
/*     */       
/* 557 */       carNotConnectedException.printStackTrace();
/*     */       
/* 559 */       return 1051135;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\base\CarInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */