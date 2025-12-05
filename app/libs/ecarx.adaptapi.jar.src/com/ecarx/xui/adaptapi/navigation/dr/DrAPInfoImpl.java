/*     */ package com.ecarx.xui.adaptapi.navigation.dr;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.hardware.SensorEvent;
/*     */ import ecarx.os.LocalConfig;
/*     */ 
/*     */ public class DrAPInfoImpl
/*     */   implements IDrAPInfo {
/*     */   private static final String TAG = "DrAPInfoImpl";
/*     */   private IDrAPInfo.IAcc3d mAcc3d;
/*     */   private Context mContext;
/*     */   private IDrAPInfo.IGyro mGyro;
/*     */   private IDrAPInfo.IMountAngle mMountAngle;
/*     */   private IDrAPInfo.IPulse mPulse;
/*     */   private IDrAPInfo.IW4m mW4m;
/*     */   
/*     */   DrAPInfoImpl(IDrAPInfo.IGyro paramIGyro, IDrAPInfo.IPulse paramIPulse, IDrAPInfo.IAcc3d paramIAcc3d, IDrAPInfo.IMountAngle paramIMountAngle, IDrAPInfo.IW4m paramIW4m) {
/*  18 */     this.mGyro = paramIGyro;
/*  19 */     this.mPulse = paramIPulse;
/*  20 */     this.mAcc3d = paramIAcc3d;
/*  21 */     this.mMountAngle = paramIMountAngle;
/*  22 */     this.mW4m = paramIW4m;
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
/*     */   public IDrAPInfo.IGyro getGyro() {
/*  36 */     IDrAPInfo.IGyro iGyro = null;
/*  37 */     if (this.mGyro != null) {
/*  38 */       iGyro = this.mGyro;
/*     */     }
/*  40 */     return iGyro;
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
/*     */   public IDrAPInfo.IPulse getPulse() {
/*  54 */     IDrAPInfo.IPulse iPulse = null;
/*  55 */     if (this.mPulse != null) {
/*  56 */       iPulse = this.mPulse;
/*     */     }
/*  58 */     return iPulse;
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
/*     */   public IDrAPInfo.IAcc3d getAcc3d() {
/*  72 */     IDrAPInfo.IAcc3d iAcc3d = null;
/*  73 */     if (this.mAcc3d != null) {
/*  74 */       iAcc3d = this.mAcc3d;
/*     */     }
/*  76 */     return iAcc3d;
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
/*     */   public IDrAPInfo.IW4m getW4m() {
/*  90 */     IDrAPInfo.IW4m iW4m = null;
/*  91 */     if (this.mW4m != null) {
/*  92 */       iW4m = this.mW4m;
/*     */     }
/*  94 */     return iW4m;
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
/*     */   public IDrAPInfo.IMountAngle getMountAngle() {
/* 108 */     IDrAPInfo.IMountAngle iMountAngle = null;
/* 109 */     if (this.mMountAngle != null) {
/* 110 */       iMountAngle = this.mMountAngle;
/*     */     }
/* 112 */     return iMountAngle;
/*     */   }
/*     */   
/*     */   static class Gyro implements IDrAPInfo.IGyro {
/*     */     private int mInterval;
/*     */     private SensorEvent mSensorEvent;
/*     */     private float mTemper;
/*     */     private long mTimeStamp;
/*     */     
/*     */     Gyro(SensorEvent param1SensorEvent, int param1Int, long param1Long, float param1Float) {
/* 122 */       this.mSensorEvent = param1SensorEvent;
/* 123 */       this.mInterval = param1Int;
/* 124 */       this.mTimeStamp = param1Long;
/* 125 */       this.mTemper = param1Float;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getAxis() {
/* 136 */       return 4;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueYaw() {
/* 146 */       return this.mSensorEvent.values[2];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValuePitch() {
/* 156 */       return this.mSensorEvent.values[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueRoll() {
/* 166 */       return this.mSensorEvent.values[1];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getTemperature() {
/* 176 */       return this.mTemper;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/* 186 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/* 196 */       return this.mTimeStamp;
/*     */     }
/*     */   }
/*     */   
/*     */   static class Pulse implements IDrAPInfo.IPulse {
/*     */     private int mInterval;
/*     */     private long mTimeStamp;
/*     */     private float mVehicleSpeed;
/*     */     
/*     */     Pulse(int param1Int, long param1Long, float param1Float) {
/* 206 */       this.mInterval = param1Int;
/* 207 */       this.mTimeStamp = param1Long;
/* 208 */       this.mVehicleSpeed = param1Float;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValue() {
/* 218 */       return this.mVehicleSpeed;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/* 228 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/* 238 */       return this.mTimeStamp;
/*     */     }
/*     */   }
/*     */   
/*     */   static class Acc3d implements IDrAPInfo.IAcc3d {
/*     */     private int mInterval;
/*     */     private SensorEvent mSensorEvent;
/*     */     private long mTimeStamp;
/*     */     
/*     */     Acc3d(SensorEvent param1SensorEvent, int param1Int, long param1Long) {
/* 248 */       this.mSensorEvent = param1SensorEvent;
/* 249 */       this.mInterval = param1Int;
/* 250 */       this.mTimeStamp = param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getAxis() {
/* 260 */       return 4;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueYaw() {
/* 270 */       return (float)(this.mSensorEvent.values[2] / 9.8D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValuePitch() {
/* 280 */       return (float)(this.mSensorEvent.values[0] / 9.8D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueRoll() {
/* 290 */       return (float)(this.mSensorEvent.values[1] / 9.8D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/* 300 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/* 310 */       return this.mTimeStamp;
/*     */     }
/*     */   }
/*     */   
/*     */   static class MountAngle
/*     */     implements IDrAPInfo.IMountAngle {
/*     */     private LocalConfig mLocalConfig;
/*     */     
/*     */     public MountAngle() {
/* 319 */       this.mLocalConfig = LocalConfig.get();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasMountAngle() {
/* 333 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getYawMountAngle() {
/* 343 */       return this.mLocalConfig.getFloat(LocalConfig.KEY.LCFG_NAVI_MountAngle_YAW);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getPitchMountAngle() {
/* 353 */       return this.mLocalConfig.getFloat(LocalConfig.KEY.LCFG_NAVI_MountAngle_PITCH);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getRollMountAngle() {
/* 363 */       return this.mLocalConfig.getFloat(LocalConfig.KEY.LCFG_NAVI_MountAngle_ROLL);
/*     */     }
/*     */   }
/*     */   
/*     */   static class W4m implements IDrAPInfo.IW4m {
/*     */     private int mGeerState;
/* 369 */     private int mInterval = Integer.MIN_VALUE;
/*     */     
/*     */     private float mLatAcc;
/*     */     
/*     */     private float mLonAcc;
/*     */     private float mSteerAngle;
/*     */     private long mTimeStamp;
/*     */     private float mVFL;
/*     */     private float mVFR;
/*     */     private float mVRL;
/*     */     private float mVRR;
/*     */     private float mYawRate;
/*     */     
/*     */     W4m(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, float param1Float8, int param1Int1, int param1Int2, long param1Long) {
/* 383 */       this.mInterval = param1Int2;
/* 384 */       this.mTimeStamp = param1Long;
/* 385 */       this.mVRL = param1Float1;
/* 386 */       this.mVRR = param1Float2;
/* 387 */       this.mVFL = param1Float3;
/* 388 */       this.mVFR = param1Float4;
/* 389 */       this.mSteerAngle = param1Float5;
/* 390 */       this.mYawRate = param1Float6;
/* 391 */       this.mLonAcc = param1Float7;
/* 392 */       this.mLatAcc = param1Float8;
/* 393 */       this.mGeerState = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVRL() {
/* 404 */       return this.mVRL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVRR() {
/* 415 */       return this.mVRR;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVFL() {
/* 426 */       return this.mVFL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVFR() {
/* 437 */       return this.mVFR;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getSteerAngle() {
/* 448 */       return this.mSteerAngle;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getYawRate() {
/* 459 */       return this.mYawRate;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getLonAcc() {
/* 470 */       return this.mLonAcc;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getLatAcc() {
/* 481 */       return this.mLatAcc;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getGearState() {
/* 492 */       return this.mGeerState;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/* 503 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/* 514 */       return this.mTimeStamp;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\DrAPInfoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */