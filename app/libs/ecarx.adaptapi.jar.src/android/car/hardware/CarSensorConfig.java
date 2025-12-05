/*     */ package android.car.hardware;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarSensorConfig
/*     */   implements Parcelable
/*     */ {
/*     */   public CarSensorConfig(Parcel paramParcel) {
/*  52 */     this.mType = paramParcel.readInt();
/*  53 */     this.mConfig = paramParcel.readBundle();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  59 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  65 */     paramParcel.writeInt(this.mType);
/*  66 */     paramParcel.writeBundle(this.mConfig);
/*     */   }
/*     */ 
/*     */   
/*  70 */   public static final Parcelable.Creator<CarSensorConfig> CREATOR = new Parcelable.Creator<CarSensorConfig>()
/*     */     {
/*     */       public CarSensorConfig createFromParcel(Parcel param1Parcel) {
/*  73 */         return new CarSensorConfig(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarSensorConfig[] newArray(int param1Int) {
/*  77 */         return new CarSensorConfig[param1Int];
/*     */       }
/*     */     };
/*     */   public static final String WHEEL_TICK_DISTANCE_FRONT_LEFT_UM_PER_TICK = "android.car.wheelTickDistanceFrontLeftUmPerTick"; public static final String WHEEL_TICK_DISTANCE_FRONT_RIGHT_UM_PER_TICK = "android.car.wheelTickDistanceFrontRightUmPerTick"; public static final String WHEEL_TICK_DISTANCE_REAR_LEFT_UM_PER_TICK = "android.car.wheelTickDistanceRearLeftUmPerTick";
/*     */   
/*     */   public CarSensorConfig(int paramInt, Bundle paramBundle) {
/*  83 */     this.mType = paramInt;
/*  84 */     this.mConfig = paramBundle.deepCopy();
/*     */   }
/*     */   public static final String WHEEL_TICK_DISTANCE_REAR_RIGHT_UM_PER_TICK = "android.car.wheelTickDistanceRearRightUmPerTick"; public static final String WHEEL_TICK_DISTANCE_SUPPORTED_WHEELS = "android.car.wheelTickDistanceSupportedWheels"; private final Bundle mConfig; private final int mType;
/*     */   private void checkType(int paramInt) {
/*  88 */     if (this.mType == paramInt) {
/*     */       return;
/*     */     }
/*     */     
/*  92 */     int i = this.mType;
/*     */     throw new UnsupportedOperationException(String.format("Invalid sensor type: expected %d, got %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
/*     */   }
/*     */   
/*     */   public Bundle getBundle() {
/*  97 */     return this.mConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getInt(String paramString) {
/* 102 */     if (this.mConfig.containsKey(paramString)) {
/* 103 */       return this.mConfig.getInt(paramString);
/*     */     }
/* 105 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("SensorType "); stringBuilder.append(this.mType); stringBuilder.append(" does not contain key: "); stringBuilder.append(paramString); throw new IllegalArgumentException(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/* 112 */     return this.mType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 119 */     StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append(getClass().getName()); stringBuilder2.append("["); stringBuilder1.append(stringBuilder2.toString());
/* 120 */     stringBuilder2 = new StringBuilder(); stringBuilder2.append("mType: "); stringBuilder2.append(this.mType); stringBuilder1.append(stringBuilder2.toString());
/* 121 */     stringBuilder2 = new StringBuilder(); stringBuilder2.append("mConfig: "); stringBuilder2.append(this.mConfig.toString()); stringBuilder1.append(stringBuilder2.toString());
/* 122 */     stringBuilder1.append("]");
/* 123 */     return stringBuilder1.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\CarSensorConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */