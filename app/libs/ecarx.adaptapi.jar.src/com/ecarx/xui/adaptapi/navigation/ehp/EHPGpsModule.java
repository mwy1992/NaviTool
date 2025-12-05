/*     */ package com.ecarx.xui.adaptapi.navigation.ehp;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarDtcManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EHPGpsModule
/*     */   extends AbsCarSignal
/*     */ {
/*     */   private static final String TAG = "EHPGpsModule";
/*     */   private ECarXCarDtcManager mECarXCarDtcManager;
/*     */   private EHPGpsInfo mEHPGpsInfo;
/*     */   private final CopyOnWriteArrayList<IEHPCallBack> mIEHPCallBacks;
/*     */   private boolean mLngLatChanged = false;
/*     */   
/*     */   protected EHPGpsModule(Context paramContext) {
/*  26 */     super(paramContext);
/*  27 */     this.mIEHPCallBacks = new CopyOnWriteArrayList<>();
/*  28 */     this.mEHPGpsInfo = new EHPGpsInfo();
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
/*  39 */     super.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */     
/*     */     try {
/*  42 */       ECarXCarSetManager eCarXCarSetManager = (ECarXCarSetManager)paramECarXCar.getCarManager("car_publicattribute");
/*     */ 
/*     */       
/*  45 */       this.mECarXCarDtcManager = eCarXCarSetManager.getECarXCarDtcManager();
/*  46 */     } catch (Exception exception) {
/*  47 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initSignalFilter() {
/*  56 */     super.initSignalFilter();
/*     */     
/*  58 */     addSignalFilter(Integer.valueOf(31625));
/*     */     
/*  60 */     addSignalFilter(Integer.valueOf(31626));
/*  61 */     addSignalFilter(Integer.valueOf(31713));
/*  62 */     addSignalFilter(Integer.valueOf(31711));
/*  63 */     addSignalFilter(Integer.valueOf(31708));
/*  64 */     addSignalFilter(Integer.valueOf(31709));
/*  65 */     addSignalFilter(Integer.valueOf(31710));
/*  66 */     addSignalFilter(Integer.valueOf(31712));
/*  67 */     addSignalFilter(Integer.valueOf(31627));
/*  68 */     addSignalFilter(Integer.valueOf(31628));
/*  69 */     addSignalFilter(Integer.valueOf(31629));
/*  70 */     addSignalFilter(Integer.valueOf(31705));
/*  71 */     addSignalFilter(Integer.valueOf(31706));
/*  72 */     addSignalFilter(Integer.valueOf(31707));
/*  73 */     addSignalFilter(Integer.valueOf(31715));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/*  83 */     int i = paramECarXCarPropertyValue.getPropertyId(); if (i != 31715) { switch (i) { default: switch (i)
/*     */           { default:
/*     */               return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 31713:
/*  93 */               this.mLngLatChanged = true;
/*  94 */               this.mEHPGpsInfo.setUTCForYr(((Integer)getValue(paramECarXCarPropertyValue)).intValue() + 2000);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             case 31712:
/* 113 */               this.mLngLatChanged = true;
/* 114 */               this.mEHPGpsInfo.setUTCForSec(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */ 
/*     */             
/*     */             case 31711:
/*     */               this.mLngLatChanged = true;
/*     */               this.mEHPGpsInfo.setUTCForMth(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */ 
/*     */             
/*     */             case 31710:
/*     */               this.mLngLatChanged = true;
/*     */               this.mEHPGpsInfo.setUTCForMins(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */ 
/*     */             
/*     */             case 31709:
/*     */               this.mLngLatChanged = true;
/*     */               this.mEHPGpsInfo.setUTCForHr(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */ 
/*     */             
/*     */             case 31708:
/*     */               this.mLngLatChanged = true;
/*     */               this.mEHPGpsInfo.setUTCForDay(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */             
/*     */             case 31707:
/* 137 */               this.mLngLatChanged = true;
/* 138 */               this.mEHPGpsInfo.setOriTiForSec(((Integer)getValue(paramECarXCarPropertyValue)).intValue());case 31706: this.mLngLatChanged = true; this.mEHPGpsInfo.setOriTiForMsec(((Integer)getValue(paramECarXCarPropertyValue)).intValue());case 31705: break; }  this.mLngLatChanged = true; this.mEHPGpsInfo.setOriTiForMins(((Integer)getValue(paramECarXCarPropertyValue)).intValue());case 31629: this.mLngLatChanged = true; this.mEHPGpsInfo.setBiasTiForSec(((Integer)getValue(paramECarXCarPropertyValue)).intValue());case 31628: this.mLngLatChanged = true; this.mEHPGpsInfo.setBiasTiForMsec(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */         case 31627: this.mLngLatChanged = true; this.mEHPGpsInfo.setBiasTiForMins(((Integer)getValue(paramECarXCarPropertyValue)).intValue());
/*     */         case 31626: this.mLngLatChanged = true; this.mEHPGpsInfo.setLatitude(((Integer)getValue(paramECarXCarPropertyValue)).intValue() * 2.77778E-7D);
/* 141 */         case 31625: break; }  this.mLngLatChanged = true; this.mEHPGpsInfo.setLongitude(((Integer)getValue(paramECarXCarPropertyValue)).intValue() * 2.77778E-7D); }  if (this.mLngLatChanged) {
/* 142 */       onGpsInfoChange(this.mEHPGpsInfo);
/* 143 */       this.mLngLatChanged = false;
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
/*     */   public void registerEhpCallback(IEHPCallBack paramIEHPCallBack) {
/* 158 */     if (paramIEHPCallBack != null && !this.mIEHPCallBacks.contains(paramIEHPCallBack)) {
/* 159 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerEhpCallback() "); stringBuilder.append(paramIEHPCallBack.toString()); Log.i("EHPGpsModule", stringBuilder.toString());
/* 160 */       this.mIEHPCallBacks.add(paramIEHPCallBack);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterEhpCallback(IEHPCallBack paramIEHPCallBack) {
/* 171 */     if (paramIEHPCallBack != null) {
/* 172 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unregisterEhpCallback() "); stringBuilder.append(paramIEHPCallBack.toString()); Log.i("EHPGpsModule", stringBuilder.toString());
/* 173 */       this.mIEHPCallBacks.remove(paramIEHPCallBack);
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
/*     */   public void updateEhpDtc(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/*     */     try {
/* 189 */       if (this.mECarXCarDtcManager != null) {
/* 190 */         this.mECarXCarDtcManager.CB_Dem_System_Failure_Detected_by_HDMap(paramBoolean1);
/* 191 */         this.mECarXCarDtcManager.CB_Dem_HD_Map_Internal_Failure(paramBoolean2);
/*     */       }
/*     */     
/* 194 */     } catch (Exception exception) {
/* 195 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void onGpsInfoChange(EHPGpsInfo paramEHPGpsInfo) {
/* 206 */     EHPGpsInfo eHPGpsInfo = new EHPGpsInfo(paramEHPGpsInfo);
/* 207 */     for (IEHPCallBack iEHPCallBack : this.mIEHPCallBacks) {
/*     */       try {
/* 209 */         iEHPCallBack.onGpsInfoChange(eHPGpsInfo);
/* 210 */       } catch (Exception exception) {
/* 211 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static class EHPGpsInfo
/*     */     implements IEHPCallBack.GpsInfo
/*     */   {
/*     */     private int mBiasTiForMins;
/*     */     
/*     */     private int mBiasTiForMsec;
/*     */     
/*     */     private int mBiasTiForSec;
/*     */     private double mLatitude;
/*     */     private double mLongitude;
/*     */     private int mOriTiForMins;
/*     */     private int mOriTiForMsec;
/*     */     private int mOriTiForSec;
/*     */     private int mUTCForDay;
/*     */     private int mUTCForHr;
/*     */     private int mUTCForMins;
/*     */     private int mUTCForMth;
/*     */     private int mUTCForSec;
/*     */     private int mUTCForYr;
/*     */     
/*     */     public EHPGpsInfo() {}
/*     */     
/*     */     public EHPGpsInfo(EHPGpsInfo param1EHPGpsInfo) {
/* 240 */       this.mLongitude = param1EHPGpsInfo.getLongitude();
/* 241 */       this.mLatitude = param1EHPGpsInfo.getLatitude();
/* 242 */       this.mUTCForYr = param1EHPGpsInfo.getUTCForYr();
/* 243 */       this.mUTCForMth = param1EHPGpsInfo.getUTCForMth();
/* 244 */       this.mUTCForDay = param1EHPGpsInfo.getUTCForDay();
/* 245 */       this.mUTCForHr = param1EHPGpsInfo.getUTCForHr();
/* 246 */       this.mUTCForMins = param1EHPGpsInfo.getUTCForMins();
/* 247 */       this.mUTCForSec = param1EHPGpsInfo.getUTCForSec();
/* 248 */       this.mBiasTiForMins = param1EHPGpsInfo.getBiasTiForMins();
/* 249 */       this.mBiasTiForMsec = param1EHPGpsInfo.getBiasTiForMsec();
/* 250 */       this.mBiasTiForSec = param1EHPGpsInfo.getBiasTiForSec();
/* 251 */       this.mOriTiForMins = param1EHPGpsInfo.getBiasTiForMins();
/* 252 */       this.mOriTiForMsec = param1EHPGpsInfo.getOriTiForMsec();
/* 253 */       this.mOriTiForSec = param1EHPGpsInfo.getOriTiForSec();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double getLongitude() {
/* 261 */       return this.mLongitude;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double getLatitude() {
/* 269 */       return this.mLatitude;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUTCForYr() {
/* 277 */       return this.mUTCForYr;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUTCForMth() {
/* 285 */       return this.mUTCForMth;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUTCForDay() {
/* 293 */       return this.mUTCForDay;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUTCForHr() {
/* 301 */       return this.mUTCForHr;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUTCForMins() {
/* 309 */       return this.mUTCForMins;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUTCForSec() {
/* 317 */       return this.mUTCForSec;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBiasTiForMins() {
/* 326 */       return this.mBiasTiForMins;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBiasTiForMsec() {
/* 335 */       return this.mBiasTiForMsec;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBiasTiForSec() {
/* 344 */       return this.mBiasTiForSec;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getOriTiForMins() {
/* 353 */       return this.mOriTiForMins;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getOriTiForMsec() {
/* 362 */       return this.mOriTiForMsec;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getOriTiForSec() {
/* 371 */       return this.mOriTiForSec;
/*     */     }
/*     */     
/*     */     public void setLongitude(double param1Double) {
/* 375 */       this.mLongitude = param1Double;
/*     */     }
/*     */     
/*     */     public void setLatitude(double param1Double) {
/* 379 */       this.mLatitude = param1Double;
/*     */     }
/*     */     
/*     */     public void setUTCForYr(int param1Int) {
/* 383 */       this.mUTCForYr = param1Int;
/*     */     }
/*     */     
/*     */     public void setUTCForMth(int param1Int) {
/* 387 */       this.mUTCForMth = param1Int;
/*     */     }
/*     */     
/*     */     public void setUTCForDay(int param1Int) {
/* 391 */       this.mUTCForDay = param1Int;
/*     */     }
/*     */     
/*     */     public void setUTCForHr(int param1Int) {
/* 395 */       this.mUTCForHr = param1Int;
/*     */     }
/*     */     
/*     */     public void setUTCForMins(int param1Int) {
/* 399 */       this.mUTCForMins = param1Int;
/*     */     }
/*     */     
/*     */     public void setUTCForSec(int param1Int) {
/* 403 */       this.mUTCForSec = param1Int;
/*     */     }
/*     */     
/*     */     public void setBiasTiForMins(int param1Int) {
/* 407 */       this.mBiasTiForMins = param1Int;
/*     */     }
/*     */     
/*     */     public void setBiasTiForMsec(int param1Int) {
/* 411 */       this.mBiasTiForMsec = param1Int;
/*     */     }
/*     */     
/*     */     public void setBiasTiForSec(int param1Int) {
/* 415 */       this.mBiasTiForSec = param1Int;
/*     */     }
/*     */     
/*     */     public void setOriTiForMins(int param1Int) {
/* 419 */       this.mOriTiForMins = param1Int;
/*     */     }
/*     */     
/*     */     public void setOriTiForMsec(int param1Int) {
/* 423 */       this.mOriTiForMsec = param1Int;
/*     */     }
/*     */     
/*     */     public void setOriTiForSec(int param1Int) {
/* 427 */       this.mOriTiForSec = param1Int;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\ehp\EHPGpsModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */