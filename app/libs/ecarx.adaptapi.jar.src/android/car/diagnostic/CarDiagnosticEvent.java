/*     */ package android.car.diagnostic;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.JsonWriter;
/*     */ import android.util.SparseArray;
/*     */ import android.util.SparseIntArray;
/*     */ import java.io.IOException;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public class CarDiagnosticEvent
/*     */   implements Parcelable
/*     */ {
/*     */   public CarDiagnosticEvent(Parcel paramParcel) {
/*  67 */     this.frameType = paramParcel.readInt();
/*  68 */     this.timestamp = paramParcel.readLong();
/*  69 */     int k = paramParcel.readInt();
/*  70 */     this.floatValues = new SparseArray(k); int i, j;
/*  71 */     for (j = 0, i = 0; i < k; i++) {
/*  72 */       int m = paramParcel.readInt();
/*  73 */       float f = paramParcel.readFloat();
/*  74 */       this.floatValues.put(m, Float.valueOf(f));
/*     */     } 
/*  76 */     k = paramParcel.readInt();
/*  77 */     this.intValues = new SparseIntArray(k);
/*  78 */     for (i = j; i < k; i++) {
/*  79 */       j = paramParcel.readInt();
/*  80 */       int m = paramParcel.readInt();
/*  81 */       this.intValues.put(j, m);
/*     */     } 
/*  83 */     this.dtc = (String)paramParcel.readValue(String.class.getClassLoader());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  89 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  94 */     paramParcel.writeInt(this.frameType);
/*  95 */     paramParcel.writeLong(this.timestamp);
/*  96 */     paramParcel.writeInt(this.floatValues.size()); int i;
/*  97 */     for (i = 0, paramInt = 0; paramInt < this.floatValues.size(); paramInt++) {
/*  98 */       int j = this.floatValues.keyAt(paramInt);
/*  99 */       paramParcel.writeInt(j);
/* 100 */       paramParcel.writeFloat(((Float)this.floatValues.get(j)).floatValue());
/*     */     } 
/* 102 */     paramParcel.writeInt(this.intValues.size());
/* 103 */     for (paramInt = i; paramInt < this.intValues.size(); paramInt++) {
/* 104 */       i = this.intValues.keyAt(paramInt);
/* 105 */       paramParcel.writeInt(i);
/* 106 */       paramParcel.writeInt(this.intValues.get(i));
/*     */     } 
/* 108 */     paramParcel.writeValue(this.dtc);
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
/*     */   public void writeToJson(JsonWriter paramJsonWriter) throws IOException {
/*     */     StringBuilder stringBuilder;
/* 126 */     paramJsonWriter.beginObject();
/*     */     
/* 128 */     paramJsonWriter.name("type");
/* 129 */     switch (this.frameType)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 137 */         stringBuilder = new StringBuilder(); stringBuilder.append("unknown frameType "); stringBuilder.append(this.frameType); throw new IllegalStateException(stringBuilder.toString());
/*     */       case 1: stringBuilder.value("freeze"); break;
/*     */       case 0:
/* 140 */         stringBuilder.value("live"); break; }  stringBuilder.name("timestamp").value(this.timestamp);
/*     */     
/* 142 */     stringBuilder.name("intValues").beginArray(); byte b; boolean bool;
/* 143 */     for (bool = false, b = 0; b < this.intValues.size(); b++) {
/* 144 */       stringBuilder.beginObject();
/* 145 */       stringBuilder.name("id").value(this.intValues.keyAt(b));
/* 146 */       stringBuilder.name("value").value(this.intValues.valueAt(b));
/* 147 */       stringBuilder.endObject();
/*     */     } 
/* 149 */     stringBuilder.endArray();
/*     */     
/* 151 */     stringBuilder.name("floatValues").beginArray();
/* 152 */     for (b = bool; b < this.floatValues.size(); b++) {
/* 153 */       stringBuilder.beginObject();
/* 154 */       stringBuilder.name("id").value(this.floatValues.keyAt(b));
/* 155 */       stringBuilder.name("value").value((Number)this.floatValues.valueAt(b));
/* 156 */       stringBuilder.endObject();
/*     */     } 
/* 158 */     stringBuilder.endArray();
/*     */     
/* 160 */     if (this.dtc != null) {
/* 161 */       stringBuilder.name("stringValue").value(this.dtc);
/*     */     }
/*     */     
/* 164 */     stringBuilder.endObject();
/*     */   }
/*     */   
/* 167 */   public static final Parcelable.Creator<CarDiagnosticEvent> CREATOR = new Parcelable.Creator<CarDiagnosticEvent>()
/*     */     {
/*     */       public CarDiagnosticEvent createFromParcel(Parcel param1Parcel) {
/* 170 */         return new CarDiagnosticEvent(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarDiagnosticEvent[] newArray(int param1Int) {
/* 174 */         return new CarDiagnosticEvent[param1Int];
/*     */       }
/*     */     };
/*     */   public final String dtc;
/*     */   private final SparseArray<Float> floatValues;
/*     */   public final int frameType;
/*     */   private final SparseIntArray intValues;
/*     */   public final long timestamp;
/*     */   
/*     */   private CarDiagnosticEvent(int paramInt, long paramLong, SparseArray<Float> paramSparseArray, SparseIntArray paramSparseIntArray, String paramString) {
/* 184 */     this.frameType = paramInt;
/* 185 */     this.timestamp = paramLong;
/* 186 */     this.floatValues = paramSparseArray;
/* 187 */     this.intValues = paramSparseIntArray;
/* 188 */     this.dtc = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/* 196 */     private int mType = 0;
/* 197 */     private long mTimestamp = 0L;
/* 198 */     private SparseArray<Float> mFloatValues = new SparseArray();
/* 199 */     private SparseIntArray mIntValues = new SparseIntArray();
/* 200 */     private String mDtc = null;
/*     */     
/*     */     private Builder(int param1Int) {
/* 203 */       this.mType = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public static Builder newLiveFrameBuilder() {
/* 208 */       return new Builder(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Builder newFreezeFrameBuilder() {
/* 213 */       return new Builder(1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder atTimestamp(long param1Long) {
/* 218 */       this.mTimestamp = param1Long;
/* 219 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder withIntValue(int param1Int1, int param1Int2) {
/* 224 */       this.mIntValues.put(param1Int1, param1Int2);
/* 225 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder withFloatValue(int param1Int, float param1Float) {
/* 230 */       this.mFloatValues.put(param1Int, Float.valueOf(param1Float));
/* 231 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Builder withDtc(String param1String) {
/* 236 */       this.mDtc = param1String;
/* 237 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public CarDiagnosticEvent build() {
/* 242 */       return new CarDiagnosticEvent(this.mType, this.mTimestamp, this.mFloatValues, this.mIntValues, this.mDtc);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarDiagnosticEvent withVendorSensorsRemoved() {
/* 252 */     SparseIntArray sparseIntArray = this.intValues.clone();
/* 253 */     SparseArray<Float> sparseArray = this.floatValues.clone(); int i, j;
/* 254 */     for (j = 0, i = 0; i < this.intValues.size(); i++) {
/* 255 */       int k = this.intValues.keyAt(i);
/* 256 */       if (k >= 31) {
/* 257 */         sparseIntArray.delete(k);
/*     */       }
/*     */     } 
/* 260 */     for (i = j; i < this.floatValues.size(); i++) {
/* 261 */       j = this.floatValues.keyAt(i);
/* 262 */       if (j >= 70) {
/* 263 */         sparseArray.delete(j);
/*     */       }
/*     */     } 
/* 266 */     return new CarDiagnosticEvent(this.frameType, this.timestamp, sparseArray, sparseIntArray, this.dtc);
/*     */   }
/*     */   
/*     */   public boolean isLiveFrame() {
/*     */     boolean bool;
/* 271 */     if (this.frameType == 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFreezeFrame() {
/* 276 */     int i = this.frameType; boolean bool = true; if (1 != i) bool = false;  return bool;
/*     */   }
/*     */   
/*     */   public boolean isEmptyFrame() {
/*     */     boolean bool;
/* 281 */     int i = this.intValues.size(); byte b = 0; if (i == 0) { i = 1; } else { i = 0; }
/* 282 */      if (this.floatValues.size() == 0) b = 1;  int k = i & b;
/* 283 */     int j = k; if (isFreezeFrame()) bool = k & this.dtc.isEmpty(); 
/* 284 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public CarDiagnosticEvent checkLiveFrame() {
/* 289 */     if (isLiveFrame())
/* 290 */       return this; 
/*     */     throw new IllegalStateException("frame is not a live frame");
/*     */   }
/*     */   
/*     */   public CarDiagnosticEvent checkFreezeFrame() {
/* 295 */     if (isFreezeFrame())
/* 296 */       return this; 
/*     */     throw new IllegalStateException("frame is not a freeze frame");
/*     */   }
/*     */   public boolean isEarlierThan(CarDiagnosticEvent paramCarDiagnosticEvent) {
/*     */     boolean bool;
/* 301 */     Objects.requireNonNull(paramCarDiagnosticEvent);
/* 302 */     if (this.timestamp < paramCarDiagnosticEvent.timestamp) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 307 */     if (this == paramObject) {
/* 308 */       return true;
/*     */     }
/* 310 */     if (paramObject == null) {
/* 311 */       return false;
/*     */     }
/* 313 */     if (!(paramObject instanceof CarDiagnosticEvent)) {
/* 314 */       return false;
/*     */     }
/* 316 */     paramObject = paramObject;
/* 317 */     if (((CarDiagnosticEvent)paramObject).frameType != this.frameType)
/* 318 */       return false; 
/* 319 */     if (((CarDiagnosticEvent)paramObject).timestamp != this.timestamp)
/* 320 */       return false; 
/* 321 */     if (((CarDiagnosticEvent)paramObject).intValues.size() != this.intValues.size())
/* 322 */       return false; 
/* 323 */     if (((CarDiagnosticEvent)paramObject).floatValues.size() != this.floatValues.size())
/* 324 */       return false; 
/* 325 */     if (!Objects.equals(this.dtc, ((CarDiagnosticEvent)paramObject).dtc))
/* 326 */       return false;  byte b;
/* 327 */     for (b = 0; b < this.intValues.size(); b++) {
/* 328 */       int j = this.intValues.keyAt(b);
/* 329 */       int i = ((CarDiagnosticEvent)paramObject).intValues.keyAt(b);
/* 330 */       if (j != i) {
/* 331 */         return false;
/*     */       }
/* 333 */       i = this.intValues.valueAt(b);
/* 334 */       j = ((CarDiagnosticEvent)paramObject).intValues.valueAt(b);
/* 335 */       if (i != j) {
/* 336 */         return false;
/*     */       }
/*     */     } 
/* 339 */     for (b = 0; b < this.floatValues.size(); b++) {
/* 340 */       int i = this.floatValues.keyAt(b);
/* 341 */       int j = ((CarDiagnosticEvent)paramObject).floatValues.keyAt(b);
/* 342 */       if (i != j) {
/* 343 */         return false;
/*     */       }
/* 345 */       float f1 = ((Float)this.floatValues.valueAt(b)).floatValue();
/* 346 */       float f2 = ((Float)((CarDiagnosticEvent)paramObject).floatValues.valueAt(b)).floatValue();
/* 347 */       if (f1 != f2) {
/* 348 */         return false;
/*     */       }
/*     */     } 
/* 351 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 356 */     Integer[] arrayOfInteger1 = new Integer[this.intValues.size()];
/* 357 */     Integer[] arrayOfInteger2 = new Integer[this.floatValues.size()];
/* 358 */     Integer[] arrayOfInteger3 = new Integer[arrayOfInteger1.length];
/* 359 */     Float[] arrayOfFloat = new Float[arrayOfInteger2.length]; int i;
/* 360 */     for (i = 0; i < arrayOfInteger1.length; i++) {
/* 361 */       arrayOfInteger1[i] = Integer.valueOf(this.intValues.keyAt(i));
/* 362 */       arrayOfInteger3[i] = Integer.valueOf(this.intValues.valueAt(i));
/*     */     } 
/* 364 */     for (i = 0; i < arrayOfInteger2.length; i++) {
/* 365 */       arrayOfInteger2[i] = Integer.valueOf(this.floatValues.keyAt(i));
/* 366 */       arrayOfFloat[i] = (Float)this.floatValues.valueAt(i);
/*     */     } 
/* 368 */     int j = Objects.hash((Object[])arrayOfInteger1);
/* 369 */     int k = Objects.hash((Object[])arrayOfInteger3);
/* 370 */     i = Objects.hash((Object[])arrayOfInteger2);
/* 371 */     int m = Objects.hash((Object[])arrayOfFloat);
/* 372 */     int n = this.frameType; long l = this.timestamp;
/* 373 */     String str = this.dtc;
/*     */     return Objects.hash(new Object[] { Integer.valueOf(n), Long.valueOf(l), str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
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
/*     */   public String toString() {
/*     */     String str1;
/* 389 */     if (isLiveFrame()) { str1 = "live"; } else { str1 = "freeze"; }  long l = this.timestamp;
/* 390 */     String str2 = this.dtc; SparseIntArray sparseIntArray = this.intValues;
/*     */     
/* 392 */     String str3 = sparseIntArray.toString(); SparseArray<Float> sparseArray = this.floatValues;
/* 393 */     String str4 = sparseArray.toString();
/*     */     return String.format("%s diagnostic frame {\n\ttimestamp: %d, DTC: %s\n\tintValues: %s\n\tfloatValues: %s\n}", new Object[] { str1, Long.valueOf(l), str2, str3, str4 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSystemIntegerSensor(int paramInt1, int paramInt2) {
/* 402 */     return this.intValues.get(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSystemFloatSensor(int paramInt, float paramFloat) {
/* 411 */     return ((Float)this.floatValues.get(paramInt, Float.valueOf(paramFloat))).floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVendorIntegerSensor(int paramInt1, int paramInt2) {
/* 419 */     return this.intValues.get(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getVendorFloatSensor(int paramInt, float paramFloat) {
/* 427 */     return ((Float)this.floatValues.get(paramInt, Float.valueOf(paramFloat))).floatValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSystemIntegerSensor(int paramInt) {
/* 436 */     paramInt = this.intValues.indexOfKey(paramInt);
/* 437 */     if (paramInt < 0) return null; 
/* 438 */     return Integer.valueOf(this.intValues.valueAt(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Float getSystemFloatSensor(int paramInt) {
/* 447 */     paramInt = this.floatValues.indexOfKey(paramInt);
/* 448 */     if (paramInt < 0) return null; 
/* 449 */     return (Float)this.floatValues.valueAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getVendorIntegerSensor(int paramInt) {
/* 457 */     paramInt = this.intValues.indexOfKey(paramInt);
/* 458 */     if (paramInt < 0) return null; 
/* 459 */     return Integer.valueOf(this.intValues.valueAt(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Float getVendorFloatSensor(int paramInt) {
/* 467 */     paramInt = this.floatValues.indexOfKey(paramInt);
/* 468 */     if (paramInt < 0) return null; 
/* 469 */     return (Float)this.floatValues.valueAt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class FuelSystemStatus
/*     */   {
/*     */     public static final int CLOSED_LOOP = 2;
/*     */ 
/*     */     
/*     */     public static final int CLOSED_LOOP_BUT_FEEDBACK_FAULT = 16;
/*     */ 
/*     */     
/*     */     public static final int OPEN_ENGINE_LOAD_OR_DECELERATION = 4;
/*     */ 
/*     */     
/*     */     public static final int OPEN_INSUFFICIENT_ENGINE_TEMPERATURE = 1;
/*     */ 
/*     */     
/*     */     public static final int OPEN_SYSTEM_FAILURE = 8;
/*     */ 
/*     */ 
/*     */     
/*     */     @Retention(RetentionPolicy.SOURCE)
/*     */     public static @interface Status {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class SecondaryAirStatus
/*     */   {
/*     */     public static final int DOWNSTREAM_OF_CATALYCIC_CONVERTER = 2;
/*     */ 
/*     */     
/*     */     public static final int FROM_OUTSIDE_OR_OFF = 4;
/*     */ 
/*     */     
/*     */     public static final int PUMP_ON_FOR_DIAGNOSTICS = 8;
/*     */ 
/*     */     
/*     */     public static final int UPSTREAM = 1;
/*     */ 
/*     */ 
/*     */     
/*     */     @Retention(RetentionPolicy.SOURCE)
/*     */     public static @interface Status {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class FuelType
/*     */   {
/*     */     public static final int BIFUEL_RUNNING_CNG = 13;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_DIESEL = 23;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_ELECTRIC = 15;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_ELECTRIC_AND_COMBUSTION = 16;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_ETHANOL = 11;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_GASOLINE = 9;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_LPG = 12;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_METHANOL = 10;
/*     */ 
/*     */     
/*     */     public static final int BIFUEL_RUNNING_PROPANE = 14;
/*     */     
/*     */     public static final int CNG = 6;
/*     */     
/*     */     public static final int DIESEL = 4;
/*     */     
/*     */     public static final int ELECTRIC = 8;
/*     */     
/*     */     public static final int ETHANOL = 3;
/*     */     
/*     */     public static final int GASOLINE = 1;
/*     */     
/*     */     public static final int HYBRID_DIESEL = 19;
/*     */     
/*     */     public static final int HYBRID_ELECTRIC = 20;
/*     */     
/*     */     public static final int HYBRID_ETHANOL = 18;
/*     */     
/*     */     public static final int HYBRID_GASOLINE = 17;
/*     */     
/*     */     public static final int HYBRID_REGENERATIVE = 22;
/*     */     
/*     */     public static final int HYBRID_RUNNING_ELECTRIC_AND_COMBUSTION = 21;
/*     */     
/*     */     public static final int LPG = 5;
/*     */     
/*     */     public static final int METHANOL = 2;
/*     */     
/*     */     public static final int NOT_AVAILABLE = 0;
/*     */     
/*     */     public static final int PROPANE = 7;
/*     */ 
/*     */     
/*     */     @Retention(RetentionPolicy.SOURCE)
/*     */     public static @interface Type {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class IgnitionMonitor
/*     */   {
/*     */     public final boolean available;
/*     */     
/*     */     public final boolean incomplete;
/*     */ 
/*     */     
/*     */     IgnitionMonitor(boolean param1Boolean1, boolean param1Boolean2) {
/* 591 */       this.available = param1Boolean1;
/* 592 */       this.incomplete = param1Boolean2;
/*     */     }
/*     */     
/*     */     public static final class Decoder
/*     */     {
/*     */       private final int mAvailableBitmask;
/*     */       private final int mIncompleteBitmask;
/*     */       
/*     */       Decoder(int param2Int1, int param2Int2) {
/* 601 */         this.mAvailableBitmask = param2Int1;
/* 602 */         this.mIncompleteBitmask = param2Int2;
/*     */       }
/*     */       
/*     */       public CarDiagnosticEvent.IgnitionMonitor fromValue(int param2Int) { boolean bool1;
/* 606 */         int i = this.mAvailableBitmask; boolean bool2 = false; if ((i & param2Int) != 0) { bool1 = true; } else { bool1 = false; }
/* 607 */          if ((this.mIncompleteBitmask & param2Int) != 0) bool2 = true;
/*     */         
/* 609 */         return new CarDiagnosticEvent.IgnitionMonitor(bool1, bool2); } } } public static final class Decoder { public CarDiagnosticEvent.IgnitionMonitor fromValue(int param1Int) { boolean bool1; int i = this.mAvailableBitmask; boolean bool2 = false; if ((i & param1Int) != 0) { bool1 = true; } else { bool1 = false; }  if ((this.mIncompleteBitmask & param1Int) != 0) bool2 = true;  return new CarDiagnosticEvent.IgnitionMonitor(bool1, bool2); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int mAvailableBitmask;
/*     */ 
/*     */ 
/*     */     
/*     */     private final int mIncompleteBitmask;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Decoder(int param1Int1, int param1Int2) {
/*     */       this.mAvailableBitmask = param1Int1;
/*     */       this.mIncompleteBitmask = param1Int2;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CommonIgnitionMonitors
/*     */   {
/*     */     public static final int COMPONENTS_AVAILABLE = 1;
/*     */ 
/*     */     
/* 637 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder COMPONENTS_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(1, 2);
/*     */     public static final int COMPONENTS_INCOMPLETE = 2;
/*     */     public static final int FUEL_SYSTEM_AVAILABLE = 4;
/* 640 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder FUEL_SYSTEM_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(4, 8);
/*     */     public static final int FUEL_SYSTEM_INCOMPLETE = 8;
/*     */     public static final int MISFIRE_AVAILABLE = 16;
/* 643 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder MISFIRE_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(16, 32); public static final int MISFIRE_INCOMPLETE = 32; public final CarDiagnosticEvent.IgnitionMonitor components; public final CarDiagnosticEvent.IgnitionMonitor fuelSystem;
/*     */     public final CarDiagnosticEvent.IgnitionMonitor misfire;
/*     */     
/*     */     CommonIgnitionMonitors(int param1Int) {
/* 647 */       this.components = COMPONENTS_DECODER.fromValue(param1Int);
/* 648 */       this.fuelSystem = FUEL_SYSTEM_DECODER.fromValue(param1Int);
/* 649 */       this.misfire = MISFIRE_DECODER.fromValue(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CarDiagnosticEvent.SparkIgnitionMonitors asSparkIgnitionMonitors() {
/* 658 */       if (this instanceof CarDiagnosticEvent.SparkIgnitionMonitors) return (CarDiagnosticEvent.SparkIgnitionMonitors)this; 
/* 659 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CarDiagnosticEvent.CompressionIgnitionMonitors asCompressionIgnitionMonitors() {
/* 668 */       if (this instanceof CarDiagnosticEvent.CompressionIgnitionMonitors)
/* 669 */         return (CarDiagnosticEvent.CompressionIgnitionMonitors)this; 
/* 670 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class SparkIgnitionMonitors
/*     */     extends CommonIgnitionMonitors
/*     */   {
/*     */     public static final int AC_REFRIGERANT_AVAILABLE = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder AC_REFRIGERANT_DECODER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int AC_REFRIGERANT_INCOMPLETE = 8192;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int CATALYST_AVAILABLE = 1048576;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder CATALYST_DECODER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int CATALYST_INCOMPLETE = 2097152;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int EGR_AVAILABLE = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 727 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder EGR_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(64, 128); public static final int EGR_INCOMPLETE = 128; public static final int EVAPORATIVE_SYSTEM_AVAILABLE = 65536;
/*     */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder EVAPORATIVE_SYSTEM_DECODER;
/*     */     public static final int EVAPORATIVE_SYSTEM_INCOMPLETE = 131072;
/*     */     public static final int HEATED_CATALYST_AVAILABLE = 262144;
/*     */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder HEATED_CATALYST_DECODER;
/*     */     public static final int HEATED_CATALYST_INCOMPLETE = 524288;
/*     */     public static final int OXYGEN_SENSOR_AVAILABLE = 1024;
/* 734 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder OXYGEN_SENSOR_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(1024, 2048); public static final int OXYGEN_SENSOR_HEATER_AVAILABLE = 256; static final CarDiagnosticEvent.IgnitionMonitor.Decoder OXYGEN_SENSOR_HEATER_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(256, 512); public static final int OXYGEN_SENSOR_HEATER_INCOMPLETE = 512; public static final int OXYGEN_SENSOR_INCOMPLETE = 2048; public static final int SECONDARY_AIR_SYSTEM_AVAILABLE = 16384; static final CarDiagnosticEvent.IgnitionMonitor.Decoder SECONDARY_AIR_SYSTEM_DECODER; public static final int SECONDARY_AIR_SYSTEM_INCOMPLETE = 32768; public final CarDiagnosticEvent.IgnitionMonitor ACRefrigerant; public final CarDiagnosticEvent.IgnitionMonitor EGR; public final CarDiagnosticEvent.IgnitionMonitor catalyst; public final CarDiagnosticEvent.IgnitionMonitor evaporativeSystem; public final CarDiagnosticEvent.IgnitionMonitor heatedCatalyst; public final CarDiagnosticEvent.IgnitionMonitor oxygenSensor; public final CarDiagnosticEvent.IgnitionMonitor oxygenSensorHeater; public final CarDiagnosticEvent.IgnitionMonitor secondaryAirSystem;
/*     */     
/*     */     static {
/* 737 */       AC_REFRIGERANT_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(4096, 8192);
/*     */ 
/*     */ 
/*     */       
/* 741 */       SECONDARY_AIR_SYSTEM_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(16384, 32768);
/*     */ 
/*     */ 
/*     */       
/* 745 */       EVAPORATIVE_SYSTEM_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(65536, 131072);
/*     */ 
/*     */ 
/*     */       
/* 749 */       HEATED_CATALYST_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(262144, 524288);
/*     */ 
/*     */ 
/*     */       
/* 753 */       CATALYST_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(1048576, 2097152);
/*     */     }
/*     */     
/*     */     SparkIgnitionMonitors(int param1Int) {
/* 757 */       super(param1Int);
/* 758 */       this.EGR = EGR_DECODER.fromValue(param1Int);
/* 759 */       this.oxygenSensorHeater = OXYGEN_SENSOR_HEATER_DECODER.fromValue(param1Int);
/* 760 */       this.oxygenSensor = OXYGEN_SENSOR_DECODER.fromValue(param1Int);
/* 761 */       this.ACRefrigerant = AC_REFRIGERANT_DECODER.fromValue(param1Int);
/* 762 */       this.secondaryAirSystem = SECONDARY_AIR_SYSTEM_DECODER.fromValue(param1Int);
/* 763 */       this.evaporativeSystem = EVAPORATIVE_SYSTEM_DECODER.fromValue(param1Int);
/* 764 */       this.heatedCatalyst = HEATED_CATALYST_DECODER.fromValue(param1Int);
/* 765 */       this.catalyst = CATALYST_DECODER.fromValue(param1Int);
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
/*     */   public static final class CompressionIgnitionMonitors
/*     */     extends CommonIgnitionMonitors
/*     */   {
/*     */     public static final int BOOST_PRESSURE_AVAILABLE = 4096;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder BOOST_PRESSURE_DECODER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int BOOST_PRESSURE_INCOMPLETE = 8192;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int EGR_OR_VVT_AVAILABLE = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 810 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder EGR_OR_VVT_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(64, 128);
/*     */     
/*     */     public static final int EGR_OR_VVT_INCOMPLETE = 128;
/*     */     
/*     */     public static final int EXHAUST_GAS_SENSOR_AVAILABLE = 1024;
/*     */     
/* 816 */     static final CarDiagnosticEvent.IgnitionMonitor.Decoder EXHAUST_GAS_SENSOR_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(1024, 2048); public static final int EXHAUST_GAS_SENSOR_INCOMPLETE = 2048; public static final int NMHC_CATALYST_AVAILABLE = 65536; static final CarDiagnosticEvent.IgnitionMonitor.Decoder NMHC_CATALYST_DECODER; public static final int NMHC_CATALYST_INCOMPLETE = 131072; public static final int NOx_SCR_AVAILABLE = 16384; static final CarDiagnosticEvent.IgnitionMonitor.Decoder NOx_SCR_DECODER; public static final int NOx_SCR_INCOMPLETE = 32768; public static final int PM_FILTER_AVAILABLE = 256; static final CarDiagnosticEvent.IgnitionMonitor.Decoder PM_FILTER_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(256, 512); public static final int PM_FILTER_INCOMPLETE = 512; public final CarDiagnosticEvent.IgnitionMonitor EGROrVVT; public final CarDiagnosticEvent.IgnitionMonitor NMHCCatalyst; public final CarDiagnosticEvent.IgnitionMonitor NOxSCR; public final CarDiagnosticEvent.IgnitionMonitor PMFilter; public final CarDiagnosticEvent.IgnitionMonitor boostPressure;
/*     */     public final CarDiagnosticEvent.IgnitionMonitor exhaustGasSensor;
/*     */     
/*     */     static {
/* 820 */       BOOST_PRESSURE_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(4096, 8192);
/*     */ 
/*     */ 
/*     */       
/* 824 */       NOx_SCR_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(16384, 32768);
/*     */ 
/*     */       
/* 827 */       NMHC_CATALYST_DECODER = new CarDiagnosticEvent.IgnitionMonitor.Decoder(65536, 131072);
/*     */     }
/*     */     
/*     */     CompressionIgnitionMonitors(int param1Int) {
/* 831 */       super(param1Int);
/* 832 */       this.EGROrVVT = EGR_OR_VVT_DECODER.fromValue(param1Int);
/* 833 */       this.PMFilter = PM_FILTER_DECODER.fromValue(param1Int);
/* 834 */       this.exhaustGasSensor = EXHAUST_GAS_SENSOR_DECODER.fromValue(param1Int);
/* 835 */       this.boostPressure = BOOST_PRESSURE_DECODER.fromValue(param1Int);
/* 836 */       this.NOxSCR = NOx_SCR_DECODER.fromValue(param1Int);
/* 837 */       this.NMHCCatalyst = NMHC_CATALYST_DECODER.fromValue(param1Int);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getFuelSystemStatus() {
/* 846 */     return getSystemIntegerSensor(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSecondaryAirStatus() {
/* 854 */     return getSystemIntegerSensor(5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CommonIgnitionMonitors getIgnitionMonitors() {
/* 863 */     Integer integer2 = getSystemIntegerSensor(2);
/*     */     
/* 865 */     Integer integer1 = getSystemIntegerSensor(3);
/* 866 */     if (integer2 == null) return null; 
/* 867 */     if (integer1 == null) return null; 
/* 868 */     switch (integer2.intValue()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 874 */         return null;
/*     */       case 1:
/*     */         return new CompressionIgnitionMonitors(integer1.intValue());
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     return new SparkIgnitionMonitors(integer1.intValue());
/*     */   }
/*     */   public Integer getFuelType() {
/* 883 */     return getSystemIntegerSensor(21);
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Status {}
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Type {}
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Status {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\diagnostic\CarDiagnosticEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */