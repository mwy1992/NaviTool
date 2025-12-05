/*     */ package android.car.hardware;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarSensorEvent
/*     */   implements Parcelable
/*     */ {
/*     */   public CarSensorEvent(Parcel paramParcel) {
/* 133 */     this.sensorType = paramParcel.readInt();
/* 134 */     this.timestamp = paramParcel.readLong();
/* 135 */     int i = paramParcel.readInt();
/* 136 */     this.floatValues = new float[i];
/* 137 */     paramParcel.readFloatArray(this.floatValues);
/* 138 */     i = paramParcel.readInt();
/* 139 */     this.intValues = new int[i];
/* 140 */     paramParcel.readIntArray(this.intValues);
/*     */     
/* 142 */     i = paramParcel.readInt();
/* 143 */     this.longValues = new long[i];
/* 144 */     paramParcel.readLongArray(this.longValues);
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 149 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 154 */     paramParcel.writeInt(this.sensorType);
/* 155 */     paramParcel.writeLong(this.timestamp);
/* 156 */     paramParcel.writeInt(this.floatValues.length);
/* 157 */     paramParcel.writeFloatArray(this.floatValues);
/* 158 */     paramParcel.writeInt(this.intValues.length);
/* 159 */     paramParcel.writeIntArray(this.intValues);
/* 160 */     paramParcel.writeInt(this.longValues.length);
/* 161 */     paramParcel.writeLongArray(this.longValues);
/*     */   }
/*     */   
/* 164 */   public static final Parcelable.Creator<CarSensorEvent> CREATOR = new Parcelable.Creator<CarSensorEvent>()
/*     */     {
/*     */       public CarSensorEvent createFromParcel(Parcel param1Parcel) {
/* 167 */         return new CarSensorEvent(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarSensorEvent[] newArray(int param1Int) {
/* 171 */         return new CarSensorEvent[param1Int];
/*     */       }
/*     */     };
/*     */   public static final int GEAR_DRIVE = 8; public static final int GEAR_EIGHTH = 2048; public static final int GEAR_FIFTH = 256; public static final int GEAR_FIRST = 16; public static final int GEAR_FOURTH = 128; public static final int GEAR_NEUTRAL = 1; public static final int GEAR_NINTH = 4096;
/*     */   public static final int GEAR_PARK = 4;
/*     */   
/*     */   public CarSensorEvent(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4) {
/* 178 */     this.sensorType = paramInt1;
/* 179 */     this.timestamp = paramLong;
/* 180 */     this.floatValues = new float[paramInt2];
/* 181 */     this.intValues = new int[paramInt3];
/* 182 */     this.longValues = new long[paramInt4];
/*     */   }
/*     */   public static final int GEAR_REVERSE = 2; public static final int GEAR_SECOND = 32; public static final int GEAR_SEVENTH = 1024; public static final int GEAR_SIXTH = 512; public static final int GEAR_TENTH = 8192; public static final int GEAR_THIRD = 64; public static final int IGNITION_STATE_ACC = 3; public static final int IGNITION_STATE_LOCK = 1; public static final int IGNITION_STATE_OFF = 2; public static final int IGNITION_STATE_ON = 4; public static final int IGNITION_STATE_START = 5; public static final int IGNITION_STATE_UNDEFINED = 0; public static final int INDEX_ENVIRONMENT_TEMPERATURE = 0; public static final int INDEX_WHEEL_DISTANCE_FRONT_LEFT = 1; public static final int INDEX_WHEEL_DISTANCE_FRONT_RIGHT = 2; public static final int INDEX_WHEEL_DISTANCE_REAR_LEFT = 4; public static final int INDEX_WHEEL_DISTANCE_REAR_RIGHT = 3; public static final int INDEX_WHEEL_DISTANCE_RESET_COUNT = 0; private static final long MILLI_IN_NANOS = 1000000L; public final float[] floatValues; public final int[] intValues; public final long[] longValues; public int sensorType;
/*     */   public long timestamp;
/*     */   
/*     */   CarSensorEvent(int paramInt, long paramLong, float[] paramArrayOffloat, int[] paramArrayOfint, long[] paramArrayOflong) {
/* 188 */     this.sensorType = paramInt;
/* 189 */     this.timestamp = paramLong;
/* 190 */     this.floatValues = paramArrayOffloat;
/* 191 */     this.intValues = paramArrayOfint;
/* 192 */     this.longValues = paramArrayOflong;
/*     */   }
/*     */   
/*     */   private void checkType(int paramInt) {
/* 196 */     if (this.sensorType == paramInt) {
/*     */       return;
/*     */     }
/*     */     
/* 200 */     int i = this.sensorType;
/*     */     throw new UnsupportedOperationException(String.format("Invalid sensor type: expected %d, got %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class EnvironmentData
/*     */   {
/*     */     public float temperature;
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private EnvironmentData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnvironmentData getEnvironmentData(EnvironmentData paramEnvironmentData) {
/* 222 */     checkType(291505923);
/* 223 */     EnvironmentData environmentData = paramEnvironmentData; if (paramEnvironmentData == null) {
/* 224 */       environmentData = new EnvironmentData();
/*     */     }
/* 226 */     environmentData.timestamp = this.timestamp;
/* 227 */     environmentData.temperature = this.floatValues[0];
/* 228 */     return environmentData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IgnitionStateData
/*     */   {
/*     */     public int ignitionState;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private IgnitionStateData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IgnitionStateData getIgnitionStateData(IgnitionStateData paramIgnitionStateData) {
/* 250 */     checkType(289408009);
/* 251 */     IgnitionStateData ignitionStateData = paramIgnitionStateData; if (paramIgnitionStateData == null) {
/* 252 */       ignitionStateData = new IgnitionStateData();
/*     */     }
/* 254 */     ignitionStateData.timestamp = this.timestamp;
/* 255 */     ignitionStateData.ignitionState = this.intValues[0];
/* 256 */     return ignitionStateData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NightData
/*     */   {
/*     */     public boolean isNightMode;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private NightData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NightData getNightData(NightData paramNightData) {
/* 278 */     checkType(287310855);
/* 279 */     NightData nightData = paramNightData; if (paramNightData == null) {
/* 280 */       nightData = new NightData();
/*     */     }
/* 282 */     nightData.timestamp = this.timestamp;
/* 283 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  nightData.isNightMode = bool;
/* 284 */     return nightData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GearData
/*     */   {
/*     */     public int gear;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private GearData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GearData getGearData(GearData paramGearData) {
/* 306 */     checkType(289408000);
/* 307 */     GearData gearData = paramGearData; if (paramGearData == null) {
/* 308 */       gearData = new GearData();
/*     */     }
/* 310 */     gearData.timestamp = this.timestamp;
/* 311 */     gearData.gear = this.intValues[0];
/* 312 */     return gearData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ParkingBrakeData
/*     */   {
/*     */     public boolean isEngaged;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private ParkingBrakeData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ParkingBrakeData getParkingBrakeData(ParkingBrakeData paramParkingBrakeData) {
/* 334 */     checkType(287310850);
/* 335 */     ParkingBrakeData parkingBrakeData = paramParkingBrakeData; if (paramParkingBrakeData == null) {
/* 336 */       parkingBrakeData = new ParkingBrakeData();
/*     */     }
/* 338 */     parkingBrakeData.timestamp = this.timestamp;
/* 339 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  parkingBrakeData.isEngaged = bool;
/* 340 */     return parkingBrakeData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FuelLevelData
/*     */   {
/*     */     public float level;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private FuelLevelData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FuelLevelData getFuelLevelData(FuelLevelData paramFuelLevelData) {
/* 363 */     checkType(291504903);
/* 364 */     FuelLevelData fuelLevelData = paramFuelLevelData; if (paramFuelLevelData == null) {
/* 365 */       fuelLevelData = new FuelLevelData();
/*     */     }
/* 367 */     fuelLevelData.timestamp = this.timestamp;
/* 368 */     if (this.floatValues == null) {
/* 369 */       fuelLevelData.level = -1.0F;
/*     */     }
/* 371 */     else if (this.floatValues[0] < 0.0F) {
/* 372 */       fuelLevelData.level = -1.0F;
/*     */     } else {
/* 374 */       fuelLevelData.level = this.floatValues[0];
/*     */     } 
/*     */     
/* 377 */     return fuelLevelData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class OdometerData
/*     */   {
/*     */     public float kms;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private OdometerData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OdometerData getOdometerData(OdometerData paramOdometerData) {
/* 399 */     checkType(291504644);
/* 400 */     OdometerData odometerData = paramOdometerData; if (paramOdometerData == null) {
/* 401 */       odometerData = new OdometerData();
/*     */     }
/* 403 */     odometerData.timestamp = this.timestamp;
/* 404 */     odometerData.kms = this.floatValues[0];
/* 405 */     return odometerData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RpmData
/*     */   {
/*     */     public float rpm;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private RpmData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RpmData getRpmData(RpmData paramRpmData) {
/* 427 */     checkType(291504901);
/* 428 */     RpmData rpmData = paramRpmData; if (paramRpmData == null) {
/* 429 */       rpmData = new RpmData();
/*     */     }
/* 431 */     rpmData.timestamp = this.timestamp;
/* 432 */     rpmData.rpm = this.floatValues[0];
/* 433 */     return rpmData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarSpeedData
/*     */   {
/*     */     public float carSpeed;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private CarSpeedData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CarSpeedData getCarSpeedData(CarSpeedData paramCarSpeedData) {
/* 455 */     checkType(291504647);
/* 456 */     CarSpeedData carSpeedData = paramCarSpeedData; if (paramCarSpeedData == null) {
/* 457 */       carSpeedData = new CarSpeedData();
/*     */     }
/* 459 */     carSpeedData.timestamp = this.timestamp;
/* 460 */     carSpeedData.carSpeed = this.floatValues[0];
/* 461 */     return carSpeedData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarWheelTickDistanceData
/*     */   {
/*     */     public long frontLeftWheelDistanceMm;
/*     */ 
/*     */     
/*     */     public long frontRightWheelDistanceMm;
/*     */     
/*     */     public long rearLeftWheelDistanceMm;
/*     */     
/*     */     public long rearRightWheelDistanceMm;
/*     */     
/*     */     public long sensorResetCount;
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */     
/*     */     private CarWheelTickDistanceData() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public CarWheelTickDistanceData getCarWheelTickDistanceData(CarWheelTickDistanceData paramCarWheelTickDistanceData) {
/* 487 */     checkType(290521862);
/* 488 */     CarWheelTickDistanceData carWheelTickDistanceData = paramCarWheelTickDistanceData; if (paramCarWheelTickDistanceData == null) {
/* 489 */       carWheelTickDistanceData = new CarWheelTickDistanceData();
/*     */     }
/* 491 */     carWheelTickDistanceData.timestamp = this.timestamp;
/* 492 */     carWheelTickDistanceData.sensorResetCount = this.longValues[0];
/* 493 */     carWheelTickDistanceData.frontLeftWheelDistanceMm = this.longValues[1];
/* 494 */     carWheelTickDistanceData.frontRightWheelDistanceMm = this.longValues[2];
/* 495 */     carWheelTickDistanceData.rearRightWheelDistanceMm = this.longValues[3];
/* 496 */     carWheelTickDistanceData.rearLeftWheelDistanceMm = this.longValues[4];
/* 497 */     return carWheelTickDistanceData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarAbsActiveData
/*     */   {
/*     */     public boolean absIsActive;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private CarAbsActiveData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CarAbsActiveData getCarAbsActiveData(CarAbsActiveData paramCarAbsActiveData) {
/* 519 */     checkType(287310858);
/* 520 */     CarAbsActiveData carAbsActiveData = paramCarAbsActiveData; if (paramCarAbsActiveData == null) {
/* 521 */       carAbsActiveData = new CarAbsActiveData();
/*     */     }
/* 523 */     carAbsActiveData.timestamp = this.timestamp;
/* 524 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  carAbsActiveData.absIsActive = bool;
/* 525 */     return carAbsActiveData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarTractionControlActiveData
/*     */   {
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean tractionControlIsActive;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CarTractionControlActiveData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarTractionControlActiveData getCarTractionControlActiveData(CarTractionControlActiveData paramCarTractionControlActiveData) {
/* 549 */     checkType(287310859);
/* 550 */     CarTractionControlActiveData carTractionControlActiveData = paramCarTractionControlActiveData; if (paramCarTractionControlActiveData == null) {
/* 551 */       carTractionControlActiveData = new CarTractionControlActiveData();
/*     */     }
/* 553 */     carTractionControlActiveData.timestamp = this.timestamp;
/* 554 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  carTractionControlActiveData.tractionControlIsActive = bool;
/* 555 */     return carTractionControlActiveData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarFuelDoorOpenData
/*     */   {
/*     */     public boolean fuelDoorIsOpen;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CarFuelDoorOpenData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarFuelDoorOpenData getCarFuelDoorOpenData(CarFuelDoorOpenData paramCarFuelDoorOpenData) {
/* 579 */     checkType(287310600);
/* 580 */     CarFuelDoorOpenData carFuelDoorOpenData = paramCarFuelDoorOpenData; if (paramCarFuelDoorOpenData == null) {
/* 581 */       carFuelDoorOpenData = new CarFuelDoorOpenData();
/*     */     }
/* 583 */     carFuelDoorOpenData.timestamp = this.timestamp;
/* 584 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  carFuelDoorOpenData.fuelDoorIsOpen = bool;
/* 585 */     return carFuelDoorOpenData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarEvBatteryLevelData
/*     */   {
/*     */     public float evBatteryLevel;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CarEvBatteryLevelData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarEvBatteryLevelData getCarEvBatteryLevelData(CarEvBatteryLevelData paramCarEvBatteryLevelData) {
/* 610 */     checkType(291504905);
/* 611 */     CarEvBatteryLevelData carEvBatteryLevelData = paramCarEvBatteryLevelData; if (paramCarEvBatteryLevelData == null) {
/* 612 */       carEvBatteryLevelData = new CarEvBatteryLevelData();
/*     */     }
/* 614 */     carEvBatteryLevelData.timestamp = this.timestamp;
/* 615 */     if (this.floatValues == null) {
/* 616 */       carEvBatteryLevelData.evBatteryLevel = -1.0F;
/*     */     }
/* 618 */     else if (this.floatValues[0] < 0.0F) {
/* 619 */       carEvBatteryLevelData.evBatteryLevel = -1.0F;
/*     */     } else {
/* 621 */       carEvBatteryLevelData.evBatteryLevel = this.floatValues[0];
/*     */     } 
/*     */     
/* 624 */     return carEvBatteryLevelData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarEvChargePortOpenData
/*     */   {
/*     */     public boolean evChargePortIsOpen;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CarEvChargePortOpenData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarEvChargePortOpenData getCarEvChargePortOpenData(CarEvChargePortOpenData paramCarEvChargePortOpenData) {
/* 648 */     checkType(287310602);
/* 649 */     CarEvChargePortOpenData carEvChargePortOpenData = paramCarEvChargePortOpenData; if (paramCarEvChargePortOpenData == null) {
/* 650 */       carEvChargePortOpenData = new CarEvChargePortOpenData();
/*     */     }
/* 652 */     carEvChargePortOpenData.timestamp = this.timestamp;
/* 653 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  carEvChargePortOpenData.evChargePortIsOpen = bool;
/* 654 */     return carEvChargePortOpenData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarEvChargePortConnectedData
/*     */   {
/*     */     public boolean evChargePortIsConnected;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CarEvChargePortConnectedData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarEvChargePortConnectedData getCarEvChargePortConnectedData(CarEvChargePortConnectedData paramCarEvChargePortConnectedData) {
/* 678 */     checkType(287310603);
/* 679 */     CarEvChargePortConnectedData carEvChargePortConnectedData = paramCarEvChargePortConnectedData; if (paramCarEvChargePortConnectedData == null) {
/* 680 */       carEvChargePortConnectedData = new CarEvChargePortConnectedData();
/*     */     }
/* 682 */     carEvChargePortConnectedData.timestamp = this.timestamp;
/* 683 */     int[] arrayOfInt = this.intValues; boolean bool = false; if (arrayOfInt[0] == 1) bool = true;  carEvChargePortConnectedData.evChargePortIsConnected = bool;
/* 684 */     return carEvChargePortConnectedData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarEvBatteryChargeRateData
/*     */   {
/*     */     public float evChargeRate;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private CarEvBatteryChargeRateData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarEvBatteryChargeRateData getCarEvBatteryChargeRateData(CarEvBatteryChargeRateData paramCarEvBatteryChargeRateData) {
/* 710 */     checkType(291504908);
/* 711 */     CarEvBatteryChargeRateData carEvBatteryChargeRateData = paramCarEvBatteryChargeRateData; if (paramCarEvBatteryChargeRateData == null) {
/* 712 */       carEvBatteryChargeRateData = new CarEvBatteryChargeRateData();
/*     */     }
/* 714 */     carEvBatteryChargeRateData.timestamp = this.timestamp;
/* 715 */     carEvBatteryChargeRateData.evChargeRate = this.floatValues[0];
/* 716 */     return carEvBatteryChargeRateData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CarEngineOilLevelData
/*     */   {
/*     */     public int engineOilLevel;
/*     */ 
/*     */ 
/*     */     
/*     */     public long timestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     private CarEngineOilLevelData() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CarEngineOilLevelData getCarEngineOilLevelData(CarEngineOilLevelData paramCarEngineOilLevelData) {
/* 738 */     checkType(289407747);
/* 739 */     CarEngineOilLevelData carEngineOilLevelData = paramCarEngineOilLevelData; if (paramCarEngineOilLevelData == null) {
/* 740 */       carEngineOilLevelData = new CarEngineOilLevelData();
/*     */     }
/* 742 */     carEngineOilLevelData.timestamp = this.timestamp;
/* 743 */     carEngineOilLevelData.engineOilLevel = this.intValues[0];
/* 744 */     return carEngineOilLevelData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 750 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 751 */     StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append(getClass().getName()); stringBuilder2.append("["); stringBuilder1.append(stringBuilder2.toString());
/* 752 */     stringBuilder2 = new StringBuilder(); stringBuilder2.append("type:"); stringBuilder2.append(Integer.toHexString(this.sensorType)); stringBuilder1.append(stringBuilder2.toString());
/* 753 */     float[] arrayOfFloat = this.floatValues; byte b = 0; if (arrayOfFloat != null && this.floatValues.length > 0) {
/* 754 */       stringBuilder1.append(" float values:");
/* 755 */       for (float f : this.floatValues) {
/* 756 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(" "); stringBuilder.append(f); stringBuilder1.append(stringBuilder.toString());
/*     */       } 
/*     */     } 
/* 759 */     if (this.intValues != null && this.intValues.length > 0) {
/* 760 */       stringBuilder1.append(" int values:");
/* 761 */       for (int i : this.intValues) {
/* 762 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(" "); stringBuilder.append(i); stringBuilder1.append(stringBuilder.toString());
/*     */       } 
/*     */     } 
/* 765 */     if (this.longValues != null && this.longValues.length > 0) {
/* 766 */       stringBuilder1.append(" long values:"); byte b1; int i; long[] arrayOfLong;
/* 767 */       for (arrayOfLong = this.longValues, i = arrayOfLong.length, b1 = b; b1 < i; ) { long l = arrayOfLong[b1];
/* 768 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(" "); stringBuilder.append(l); stringBuilder1.append(stringBuilder.toString()); b1++; }
/*     */     
/*     */     } 
/* 771 */     stringBuilder1.append("]");
/* 772 */     return stringBuilder1.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\CarSensorEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */