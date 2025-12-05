/*     */ package com.ecarx.xui.adaptapi.car.sensor;
/*     */ 
/*     */ import android.hardware.SensorEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SensorGroupValue
/*     */   implements ISensorGroupValue
/*     */ {
/*     */   public int getSensorGroupType() {
/*  12 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInterval() {
/*  20 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTickTime() {
/*  28 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   static class GyroValue
/*     */     implements ISensorGroupValue.IGyroValue
/*     */   {
/*     */     private int mInterval;
/*     */     
/*     */     private SensorEvent mSensorEvent;
/*     */     
/*     */     private float mTemper;
/*     */     
/*     */     private long mTimeStamp;
/*     */     
/*     */     GyroValue(SensorEvent param1SensorEvent, int param1Int, long param1Long, float param1Float) {
/*  44 */       this.mSensorEvent = param1SensorEvent;
/*  45 */       this.mInterval = param1Int;
/*  46 */       this.mTimeStamp = param1Long;
/*  47 */       this.mTemper = param1Float;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSensorGroupType() {
/*  52 */       return 8388864;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/*  60 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/*  68 */       return this.mTimeStamp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getAxis() {
/*  77 */       return 4;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueYaw() {
/*  85 */       return this.mSensorEvent.values[2];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValuePitch() {
/*  93 */       return this.mSensorEvent.values[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueRoll() {
/* 102 */       return this.mSensorEvent.values[1];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getTemperature() {
/* 110 */       return this.mTemper;
/*     */     }
/*     */   }
/*     */   
/*     */   static class SpeedPulseValue
/*     */     implements ISensorGroupValue.ISpeedPulseValue {
/*     */     private int mInterval;
/*     */     private float mSpeedValue;
/*     */     private long mTimeStamp;
/*     */     
/*     */     SpeedPulseValue(int param1Int, long param1Long, float param1Float) {
/* 121 */       this.mInterval = param1Int;
/* 122 */       this.mTimeStamp = param1Long;
/* 123 */       this.mSpeedValue = param1Float;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSensorGroupType() {
/* 132 */       return 8389376;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/* 140 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/* 148 */       return this.mTimeStamp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getSpeedValue() {
/* 156 */       return this.mSpeedValue;
/*     */     }
/*     */   }
/*     */   
/*     */   static class Acc3dValue
/*     */     implements ISensorGroupValue.IAcc3dValue {
/*     */     private int mInterval;
/*     */     private SensorEvent mSensorEvent;
/*     */     private long mTimeStamp;
/*     */     
/*     */     Acc3dValue(SensorEvent param1SensorEvent, int param1Int, long param1Long) {
/* 167 */       this.mSensorEvent = param1SensorEvent;
/* 168 */       this.mInterval = param1Int;
/* 169 */       this.mTimeStamp = param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSensorGroupType() {
/* 178 */       return 8389120;
/*     */     }
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
/*     */     public long getTickTime() {
/* 194 */       return this.mTimeStamp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getAxis() {
/* 203 */       return 4;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueYaw() {
/* 211 */       return this.mSensorEvent.values[2];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValuePitch() {
/* 219 */       return this.mSensorEvent.values[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValueRoll() {
/* 227 */       return this.mSensorEvent.values[1];
/*     */     }
/*     */   }
/*     */   
/*     */   static class W4mValue implements ISensorGroupValue.IW4mValue {
/*     */     private int mGeerState;
/* 233 */     private int mInterval = Integer.MIN_VALUE;
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
/*     */     W4mValue(float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, float param1Float8, int param1Int1, int param1Int2, long param1Long) {
/* 247 */       this.mInterval = param1Int2;
/* 248 */       this.mTimeStamp = param1Long;
/* 249 */       this.mVRL = param1Float1;
/* 250 */       this.mVRR = param1Float2;
/* 251 */       this.mVFL = param1Float3;
/* 252 */       this.mVFR = param1Float4;
/* 253 */       this.mSteerAngle = param1Float5;
/* 254 */       this.mYawRate = param1Float6;
/* 255 */       this.mLonAcc = param1Float7;
/* 256 */       this.mLatAcc = param1Float8;
/* 257 */       this.mGeerState = param1Int1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVRLSpeed() {
/* 266 */       return this.mVRL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVRRSpeed() {
/* 274 */       return this.mVRR;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVFLSpeed() {
/* 282 */       return this.mVFL;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getVFRSpeed() {
/* 290 */       return this.mVFR;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getSteerAngle() {
/* 298 */       return this.mSteerAngle;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getYawRate() {
/* 306 */       return this.mYawRate;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getLonAcc() {
/* 314 */       return this.mLonAcc;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getLatAcc() {
/* 322 */       return this.mLatAcc;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getGearState() {
/* 330 */       return this.mGeerState;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSensorGroupType() {
/* 340 */       return 8389632;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInterval() {
/* 348 */       return this.mInterval;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getTickTime() {
/* 356 */       return this.mTimeStamp;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\sensor\SensorGroupValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */