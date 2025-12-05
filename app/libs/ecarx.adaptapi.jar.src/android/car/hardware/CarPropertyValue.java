/*     */ package android.car.hardware;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class CarPropertyValue<T>
/*     */   implements Parcelable
/*     */ {
/*     */   public static final Parcelable.Creator<CarPropertyValue> CREATOR;
/*  40 */   private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
/*     */ 
/*     */   
/*     */   public static final int STATUS_AVAILABLE = 0;
/*     */ 
/*     */   
/*     */   public static final int STATUS_ERROR = 2;
/*     */ 
/*     */   
/*     */   public static final int STATUS_UNAVAILABLE = 1;
/*     */ 
/*     */   
/*     */   private final int mAreaId;
/*     */ 
/*     */   
/*     */   private final int mPropertyId;
/*     */ 
/*     */   
/*     */   private final int mStatus;
/*     */ 
/*     */   
/*     */   private final long mTimestamp;
/*     */   
/*     */   private final T mValue;
/*     */ 
/*     */   
/*     */   public CarPropertyValue(int paramInt1, int paramInt2, T paramT) {
/*  67 */     this(paramInt1, paramInt2, 0, 0L, paramT);
/*     */   }
/*     */   
/*     */   public CarPropertyValue(int paramInt1, int paramInt2, int paramInt3, long paramLong, T paramT) {
/*  71 */     this.mPropertyId = paramInt1;
/*  72 */     this.mAreaId = paramInt2;
/*  73 */     this.mStatus = paramInt3;
/*  74 */     this.mTimestamp = paramLong;
/*  75 */     this.mValue = paramT;
/*     */   }
/*     */ 
/*     */   
/*     */   public CarPropertyValue(Parcel paramParcel) {
/*  80 */     this.mPropertyId = paramParcel.readInt();
/*  81 */     this.mAreaId = paramParcel.readInt();
/*  82 */     this.mStatus = paramParcel.readInt();
/*  83 */     this.mTimestamp = paramParcel.readLong();
/*  84 */     String str = paramParcel.readString();
/*     */     try {
/*     */       byte[] arrayOfByte;
/*  87 */       Class<?> clazz = Class.forName(str);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  92 */       if (String.class.equals(clazz)) {
/*  93 */         arrayOfByte = paramParcel.readBlob();
/*  94 */         this.mValue = (T)new String(arrayOfByte, DEFAULT_CHARSET);
/*  95 */       } else if (byte[].class.equals(clazz)) {
/*  96 */         this.mValue = (T)arrayOfByte.readBlob();
/*     */       } else {
/*  98 */         this.mValue = (T)arrayOfByte.readValue(clazz.getClassLoader());
/*     */       }  return;
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Class not found: "); stringBuilder.append(str); throw new IllegalArgumentException(stringBuilder.toString());
/* 102 */     }  } static { CREATOR = new Parcelable.Creator<CarPropertyValue>()
/*     */       {
/*     */         public CarPropertyValue createFromParcel(Parcel param1Parcel) {
/* 105 */           return new CarPropertyValue(param1Parcel);
/*     */         }
/*     */ 
/*     */         
/*     */         public CarPropertyValue[] newArray(int param1Int) {
/* 110 */           return new CarPropertyValue[param1Int];
/*     */         }
/*     */       }; }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 116 */     return 0;
/*     */   }
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*     */     Class<?> clazz;
/* 121 */     paramParcel.writeInt(this.mPropertyId);
/* 122 */     paramParcel.writeInt(this.mAreaId);
/* 123 */     paramParcel.writeInt(this.mStatus);
/* 124 */     paramParcel.writeLong(this.mTimestamp);
/*     */     
/* 126 */     T t = this.mValue; String str = null; if (t == null) { t = null; } else { clazz = this.mValue.getClass(); }
/* 127 */      if (clazz != null) str = clazz.getName();  paramParcel.writeString(str);
/*     */ 
/*     */     
/* 130 */     if (String.class.equals(clazz)) {
/* 131 */       paramParcel.writeBlob(((String)this.mValue).getBytes(DEFAULT_CHARSET));
/* 132 */     } else if (byte[].class.equals(clazz)) {
/* 133 */       paramParcel.writeBlob((byte[])this.mValue);
/*     */     } else {
/* 135 */       paramParcel.writeValue(this.mValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPropertyId() {
/* 140 */     return this.mPropertyId;
/*     */   }
/*     */   
/*     */   public int getAreaId() {
/* 144 */     return this.mAreaId;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/* 148 */     return this.mStatus;
/*     */   }
/*     */   
/*     */   public long getTimestamp() {
/* 152 */     return this.mTimestamp;
/*     */   }
/*     */   
/*     */   public T getValue() {
/* 156 */     return this.mValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarPropertyValue{mPropertyId=0x"); int i = this.mPropertyId;
/* 162 */     stringBuilder.append(Integer.toHexString(i)); stringBuilder.append(", mAreaId=0x"); i = this.mAreaId;
/* 163 */     stringBuilder.append(Integer.toHexString(i)); stringBuilder.append(", mStatus="); stringBuilder.append(this.mStatus); stringBuilder.append(", mTimestamp="); stringBuilder.append(this.mTimestamp); stringBuilder.append(", mValue="); stringBuilder.append(this.mValue); stringBuilder.append('}'); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface PropertyStatus {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\CarPropertyValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */