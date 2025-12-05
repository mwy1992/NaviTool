/*     */ package ecarx.car.hardware;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import ecarx.car.hardware.property.PropertyIdString;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ECarXCarPropertyValue<T>
/*     */   implements Parcelable
/*     */ {
/*  38 */   public static final Parcelable.Creator<ECarXCarPropertyValue> CREATOR = new Parcelable.Creator<ECarXCarPropertyValue>()
/*     */     {
/*     */       public ECarXCarPropertyValue createFromParcel(Parcel param1Parcel)
/*     */       {
/*  42 */         return new ECarXCarPropertyValue(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public ECarXCarPropertyValue[] newArray(int param1Int) {
/*  47 */         return new ECarXCarPropertyValue[param1Int];
/*     */       }
/*     */     };
/*  50 */   private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
/*     */   private final int mAreaId;
/*     */   private final int mPropertyId;
/*     */   private final T mValue;
/*     */   
/*     */   public ECarXCarPropertyValue(int paramInt, T paramT) {
/*  56 */     this(paramInt, 0, paramT);
/*     */   }
/*     */   
/*     */   public ECarXCarPropertyValue(int paramInt1, int paramInt2, T paramT) {
/*  60 */     this.mPropertyId = paramInt1;
/*  61 */     this.mAreaId = paramInt2;
/*  62 */     this.mValue = paramT;
/*     */   }
/*     */ 
/*     */   
/*     */   public ECarXCarPropertyValue(Parcel paramParcel) {
/*  67 */     this.mPropertyId = paramParcel.readInt();
/*  68 */     this.mAreaId = paramParcel.readInt();
/*  69 */     String str = paramParcel.readString();
/*     */     try {
/*     */       byte[] arrayOfByte;
/*  72 */       Class<?> clazz = Class.forName(str);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       if (String.class.equals(clazz)) {
/*  78 */         arrayOfByte = paramParcel.readBlob();
/*  79 */         this.mValue = (T)new String(arrayOfByte, DEFAULT_CHARSET);
/*  80 */       } else if (byte[].class.equals(clazz)) {
/*  81 */         this.mValue = (T)arrayOfByte.readBlob();
/*     */       } else {
/*  83 */         this.mValue = (T)arrayOfByte.readValue(clazz.getClassLoader());
/*     */       }  return;
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Class not found: ");
/*     */       stringBuilder.append(str);
/*     */       throw new IllegalArgumentException(stringBuilder.toString());
/*  89 */     }  } public int describeContents() { return 0; }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*     */     Class<?> clazz;
/*  94 */     paramParcel.writeInt(this.mPropertyId);
/*  95 */     paramParcel.writeInt(this.mAreaId);
/*     */     
/*  97 */     T t = this.mValue; String str = null; if (t == null) { t = null; } else { clazz = this.mValue.getClass(); }
/*  98 */      if (clazz != null) str = clazz.getName();  paramParcel.writeString(str);
/*     */ 
/*     */     
/* 101 */     if (String.class.equals(clazz)) {
/* 102 */       paramParcel.writeBlob(((String)this.mValue).getBytes(DEFAULT_CHARSET));
/* 103 */     } else if (byte[].class.equals(clazz)) {
/* 104 */       paramParcel.writeBlob((byte[])this.mValue);
/*     */     } else {
/* 106 */       paramParcel.writeValue(this.mValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPropertyId() {
/* 111 */     return this.mPropertyId;
/*     */   }
/*     */   
/*     */   public int getAreaId() {
/* 115 */     return this.mAreaId;
/*     */   }
/*     */   
/*     */   public T getValue() {
/* 119 */     return this.mValue;
/*     */   }
/*     */   
/*     */   public String toString() {
/*     */     Class<?> clazz;
/* 124 */     StringBuilder stringBuilder2 = new StringBuilder();
/* 125 */     if (this.mValue == null) { clazz = null; } else { clazz = this.mValue.getClass(); }
/*     */ 
/*     */     
/* 128 */     if (String.class.equals(clazz)) {
/* 129 */       stringBuilder2.append(this.mValue);
/* 130 */     } else if (byte[].class.equals(clazz)) {
/*     */ 
/*     */ 
/*     */       
/* 134 */       stringBuilder2.append("byte[] data");
/* 135 */     } else if (Integer.class.equals(clazz)) {
/* 136 */       stringBuilder2.append(Integer.toHexString(((Integer)this.mValue).intValue()));
/*     */     } 
/*     */     
/* 139 */     StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("ECarXCarPropertyValue{mPropertyId=0x"); int i = this.mPropertyId;
/* 140 */     stringBuilder1.append(Integer.toHexString(i)); stringBuilder1.append(" propertyName "); HashMap hashMap = PropertyIdString.idToStringMap; i = this.mPropertyId;
/* 141 */     stringBuilder1.append((String)hashMap.get(Integer.valueOf(i))); stringBuilder1.append(", mValue=");
/* 142 */     stringBuilder1.append(stringBuilder2.toString()); stringBuilder1.append('}'); return stringBuilder1.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\ECarXCarPropertyValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */