/*     */ package ecarx.car.hardware;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.SparseArray;
/*     */ import java.lang.reflect.Array;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarPropertyConfig<T>
/*     */   implements Parcelable
/*     */ {
/*  40 */   public static final Parcelable.Creator<CarPropertyConfig> CREATOR = new Parcelable.Creator<CarPropertyConfig>()
/*     */     {
/*     */       public CarPropertyConfig createFromParcel(Parcel param1Parcel) {
/*  43 */         return new CarPropertyConfig(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public CarPropertyConfig[] newArray(int param1Int) {
/*  48 */         return new CarPropertyConfig[param1Int];
/*     */       }
/*     */     };
/*     */   
/*     */   private final int mAreaType;
/*     */   private final int mPropertyId;
/*     */   private final SparseArray<AreaConfig<T>> mSupportedAreas;
/*     */   private final Class<T> mType;
/*     */   
/*     */   private CarPropertyConfig(Class<T> paramClass, int paramInt1, int paramInt2, SparseArray<AreaConfig<T>> paramSparseArray) {
/*  58 */     this.mPropertyId = paramInt1;
/*  59 */     this.mType = paramClass;
/*  60 */     this.mAreaType = paramInt2;
/*  61 */     this.mSupportedAreas = paramSparseArray;
/*     */   }
/*     */   
/*     */   private CarPropertyConfig(Parcel paramParcel) {
/*     */     AreaConfig areaConfig;
/*  66 */     this.mPropertyId = paramParcel.readInt();
/*  67 */     String str = paramParcel.readString();
/*     */     try {
/*  69 */       this.mType = (Class)Class.forName(str);
/*     */ 
/*     */ 
/*     */       
/*  73 */       this.mAreaType = paramParcel.readInt();
/*  74 */       int i = paramParcel.readInt();
/*  75 */       this.mSupportedAreas = new SparseArray(i);
/*  76 */       for (byte b = 0; b < i; b++) {
/*  77 */         int j = paramParcel.readInt();
/*  78 */         areaConfig = (AreaConfig)paramParcel.readParcelable(getClass().getClassLoader());
/*  79 */         this.mSupportedAreas.put(j, areaConfig);
/*     */       }  return;
/*     */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Class not found: ");
/*     */       stringBuilder.append((String)areaConfig);
/*     */       throw new IllegalArgumentException(stringBuilder.toString());
/*  85 */     }  } public static <T> Builder<T> newBuilder(Class<T> paramClass, int paramInt1, int paramInt2, int paramInt3) { return new Builder<>(paramClass, paramInt1, paramInt2, paramInt3); }
/*     */ 
/*     */   
/*     */   public static <T> Builder<T> newBuilder(Class<T> paramClass, int paramInt1, int paramInt2) {
/*  89 */     return newBuilder(paramClass, paramInt1, paramInt2, 0);
/*     */   }
/*     */   
/*     */   public int getPropertyId() {
/*  93 */     return this.mPropertyId;
/*     */   }
/*     */   
/*     */   public Class<T> getPropertyType() {
/*  97 */     return this.mType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAreaType() {
/* 102 */     return this.mAreaType;
/*     */   }
/*     */   
/*     */   public boolean isGlobalProperty() {
/*     */     boolean bool;
/* 107 */     if (this.mAreaType == 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */   
/*     */   public int getAreaCount() {
/* 111 */     return this.mSupportedAreas.size();
/*     */   }
/*     */   
/*     */   public int[] getAreaIds() {
/* 115 */     int[] arrayOfInt = new int[this.mSupportedAreas.size()];
/* 116 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 117 */       arrayOfInt[b] = this.mSupportedAreas.keyAt(b);
/*     */     }
/* 119 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstAndOnlyAreaId()
/*     */   {
/* 127 */     if (this.mSupportedAreas.size() == 1)
/*     */     {
/*     */ 
/*     */       
/* 131 */       return this.mSupportedAreas.keyAt(0); }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Expected one and only area in this property. Prop: 0x");
/*     */     int i = this.mPropertyId;
/*     */     stringBuilder.append(Integer.toHexString(i));
/*     */     throw new IllegalStateException(stringBuilder.toString()); } public boolean hasArea(int paramInt) { boolean bool;
/* 135 */     if (this.mSupportedAreas.indexOfKey(paramInt) >= 0) { bool = true; } else { bool = false; }  return bool; }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMinValue(int paramInt) {
/* 140 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.get(paramInt);
/* 141 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMinValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getMaxValue(int paramInt) {
/* 146 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.get(paramInt);
/* 147 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMaxValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getMinValue() {
/* 152 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.valueAt(0);
/* 153 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMinValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getMaxValue() {
/* 158 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.valueAt(0);
/* 159 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMaxValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 164 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 169 */     paramParcel.writeInt(this.mPropertyId);
/* 170 */     paramParcel.writeString(this.mType.getName());
/* 171 */     paramParcel.writeInt(this.mAreaType);
/* 172 */     paramParcel.writeInt(this.mSupportedAreas.size());
/* 173 */     for (byte b = 0; b < this.mSupportedAreas.size(); b++) {
/* 174 */       paramParcel.writeInt(this.mSupportedAreas.keyAt(b));
/* 175 */       paramParcel.writeParcelable((Parcelable)this.mSupportedAreas.valueAt(b), paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 181 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarPropertyConfig{mPropertyId="); stringBuilder.append(this.mPropertyId); stringBuilder.append(", mType="); stringBuilder.append(this.mType); stringBuilder.append(", mAreaType="); stringBuilder.append(this.mAreaType); stringBuilder.append(", mSupportedAreas="); stringBuilder.append(this.mSupportedAreas); stringBuilder.append('}'); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AreaConfig<T>
/*     */     implements Parcelable
/*     */   {
/* 191 */     public static final Parcelable.Creator<AreaConfig<Object>> CREATOR = getCreator(Object.class);
/*     */     
/*     */     private final T mMaxValue;
/*     */     
/*     */     private final T mMinValue;
/*     */     
/*     */     private AreaConfig(T param1T1, T param1T2) {
/* 198 */       this.mMinValue = param1T1;
/* 199 */       this.mMaxValue = param1T2;
/*     */     }
/*     */ 
/*     */     
/*     */     private AreaConfig(Parcel param1Parcel) {
/* 204 */       this.mMinValue = (T)param1Parcel.readValue(getClass().getClassLoader());
/* 205 */       this.mMaxValue = (T)param1Parcel.readValue(getClass().getClassLoader());
/*     */     }
/*     */     
/*     */     private static <E> Parcelable.Creator<AreaConfig<E>> getCreator(final Class<E> clazz) {
/* 209 */       return new Parcelable.Creator<AreaConfig<E>>() { final Class val$clazz;
/*     */           
/*     */           public CarPropertyConfig.AreaConfig<E> createFromParcel(Parcel param2Parcel) {
/* 212 */             return new CarPropertyConfig.AreaConfig<>(param2Parcel);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CarPropertyConfig.AreaConfig<E>[] newArray(int param2Int) {
/* 218 */             return (CarPropertyConfig.AreaConfig<E>[])Array.newInstance(clazz, param2Int);
/*     */           } }
/*     */         ;
/*     */     }
/*     */ 
/*     */     
/*     */     public T getMinValue() {
/* 225 */       return this.mMinValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public T getMaxValue() {
/* 230 */       return this.mMaxValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public int describeContents() {
/* 235 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeToParcel(Parcel param1Parcel, int param1Int) {
/* 240 */       param1Parcel.writeValue(this.mMinValue);
/* 241 */       param1Parcel.writeValue(this.mMaxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 246 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarAreaConfig{mMinValue="); stringBuilder.append(this.mMinValue); stringBuilder.append(", mMaxValue="); stringBuilder.append(this.mMaxValue); stringBuilder.append('}'); return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */   class null implements Parcelable.Creator<AreaConfig<E>> { final Class val$clazz;
/*     */     public CarPropertyConfig.AreaConfig<E> createFromParcel(Parcel param1Parcel) {
/*     */       return new CarPropertyConfig.AreaConfig<>(param1Parcel);
/*     */     }
/*     */     public CarPropertyConfig.AreaConfig<E>[] newArray(int param1Int) {
/*     */       return (CarPropertyConfig.AreaConfig<E>[])Array.newInstance(clazz, param1Int);
/*     */     } }
/*     */   public static class Builder<T> { private final int mAreaType;
/*     */     private final SparseArray<CarPropertyConfig.AreaConfig<T>> mAreas;
/*     */     
/*     */     private Builder(Class<T> param1Class, int param1Int1, int param1Int2, int param1Int3) {
/* 260 */       this.mType = param1Class;
/* 261 */       this.mPropertyId = param1Int1;
/* 262 */       this.mAreaType = param1Int2;
/* 263 */       if (param1Int3 != 0) {
/* 264 */         this.mAreas = new SparseArray(param1Int3);
/*     */       } else {
/* 266 */         this.mAreas = new SparseArray();
/*     */       } 
/*     */     } private final int mPropertyId; private final Class<T> mType; public Builder<T> addAreas(int[] param1ArrayOfint) {
/*     */       byte b;
/*     */       int i;
/* 271 */       for (i = param1ArrayOfint.length, b = 0; b < i; ) { int j = param1ArrayOfint[b];
/* 272 */         this.mAreas.put(j, null); b++; }
/*     */       
/* 274 */       return this;
/*     */     }
/*     */     
/*     */     public Builder<T> addArea(int param1Int) {
/* 278 */       return addAreaConfig(param1Int, null, null);
/*     */     }
/*     */     
/*     */     public Builder<T> addAreaConfig(int param1Int, T param1T1, T param1T2) {
/* 282 */       if (param1T1 == null && param1T2 == null) {
/* 283 */         this.mAreas.put(param1Int, null);
/*     */       } else {
/* 285 */         this.mAreas.put(param1Int, new CarPropertyConfig.AreaConfig(param1T1, param1T2));
/*     */       } 
/* 287 */       return this;
/*     */     }
/*     */     
/*     */     public CarPropertyConfig<T> build() {
/* 291 */       return new CarPropertyConfig<>(this.mType, this.mPropertyId, this.mAreaType, this.mAreas);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\CarPropertyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */