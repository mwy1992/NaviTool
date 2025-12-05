/*     */ package android.car.hardware;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.SparseArray;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class CarPropertyConfig<T>
/*     */   implements Parcelable
/*     */ {
/*     */   private CarPropertyConfig(int paramInt1, int paramInt2, int paramInt3, ArrayList<Integer> paramArrayList, String paramString, float paramFloat1, float paramFloat2, int paramInt4, SparseArray<AreaConfig<T>> paramSparseArray, Class<T> paramClass) {
/*  59 */     this.mAccess = paramInt1;
/*  60 */     this.mAreaType = paramInt2;
/*  61 */     this.mChangeMode = paramInt3;
/*  62 */     this.mConfigArray = paramArrayList;
/*  63 */     this.mConfigString = paramString;
/*  64 */     this.mMaxSampleRate = paramFloat1;
/*  65 */     this.mMinSampleRate = paramFloat2;
/*  66 */     this.mPropertyId = paramInt4;
/*  67 */     this.mSupportedAreas = paramSparseArray;
/*  68 */     this.mType = paramClass;
/*     */   }
/*     */   
/*     */   public int getAccess() {
/*  72 */     return this.mAccess;
/*     */   }
/*     */   public int getAreaType() {
/*  75 */     return this.mAreaType;
/*     */   }
/*     */   public int getChangeMode() {
/*  78 */     return this.mChangeMode;
/*     */   }
/*     */   public List<Integer> getConfigArray() {
/*  81 */     return Collections.unmodifiableList(this.mConfigArray);
/*     */   }
/*     */   public String getConfigString() {
/*  84 */     return this.mConfigString;
/*     */   }
/*     */   public float getMaxSampleRate() {
/*  87 */     return this.mMaxSampleRate;
/*     */   }
/*     */   public float getMinSampleRate() {
/*  90 */     return this.mMinSampleRate;
/*     */   }
/*     */   public int getPropertyId() {
/*  93 */     return this.mPropertyId;
/*     */   }
/*     */   public Class<T> getPropertyType() {
/*  96 */     return this.mType;
/*     */   }
/*     */   
/*     */   public boolean isGlobalProperty() {
/*     */     boolean bool;
/* 101 */     if (this.mAreaType == 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */   
/*     */   public int getAreaCount() {
/* 105 */     return this.mSupportedAreas.size();
/*     */   }
/*     */   
/*     */   public int[] getAreaIds() {
/* 109 */     int[] arrayOfInt = new int[this.mSupportedAreas.size()];
/* 110 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 111 */       arrayOfInt[b] = this.mSupportedAreas.keyAt(b);
/*     */     }
/* 113 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstAndOnlyAreaId()
/*     */   {
/* 121 */     if (this.mSupportedAreas.size() == 1)
/*     */     {
/*     */ 
/*     */       
/* 125 */       return this.mSupportedAreas.keyAt(0); }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Expected one and only area in this property. Prop: 0x");
/*     */     int i = this.mPropertyId;
/*     */     stringBuilder.append(Integer.toHexString(i));
/*     */     throw new IllegalStateException(stringBuilder.toString()); } public boolean hasArea(int paramInt) { boolean bool;
/* 129 */     if (this.mSupportedAreas.indexOfKey(paramInt) >= 0) { bool = true; } else { bool = false; }  return bool; }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMinValue(int paramInt) {
/* 134 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.get(paramInt);
/* 135 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMinValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getMaxValue(int paramInt) {
/* 140 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.get(paramInt);
/* 141 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMaxValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getMinValue() {
/* 146 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.valueAt(0);
/* 147 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMinValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public T getMaxValue() {
/* 152 */     AreaConfig<AreaConfig> areaConfig = (AreaConfig)this.mSupportedAreas.valueAt(0);
/* 153 */     if (areaConfig == null) { areaConfig = null; } else { areaConfig = areaConfig.getMaxValue(); }  return (T)areaConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 158 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 163 */     paramParcel.writeInt(this.mAccess);
/* 164 */     paramParcel.writeInt(this.mAreaType);
/* 165 */     paramParcel.writeInt(this.mChangeMode);
/* 166 */     paramParcel.writeInt(this.mConfigArray.size()); byte b; boolean bool;
/* 167 */     for (bool = false, b = 0; b < this.mConfigArray.size(); b++) {
/* 168 */       paramParcel.writeInt(((Integer)this.mConfigArray.get(b)).intValue());
/*     */     }
/* 170 */     paramParcel.writeString(this.mConfigString);
/* 171 */     paramParcel.writeFloat(this.mMaxSampleRate);
/* 172 */     paramParcel.writeFloat(this.mMinSampleRate);
/* 173 */     paramParcel.writeInt(this.mPropertyId);
/* 174 */     paramParcel.writeInt(this.mSupportedAreas.size());
/* 175 */     for (b = bool; b < this.mSupportedAreas.size(); b++) {
/* 176 */       paramParcel.writeInt(this.mSupportedAreas.keyAt(b));
/* 177 */       paramParcel.writeParcelable((Parcelable)this.mSupportedAreas.valueAt(b), paramInt);
/*     */     } 
/* 179 */     paramParcel.writeString(this.mType.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   private CarPropertyConfig(Parcel paramParcel) {
/* 184 */     this.mAccess = paramParcel.readInt();
/* 185 */     this.mAreaType = paramParcel.readInt();
/* 186 */     this.mChangeMode = paramParcel.readInt();
/* 187 */     int k = paramParcel.readInt();
/* 188 */     this.mConfigArray = new ArrayList<>(k); int i, j;
/* 189 */     for (j = 0, i = 0; i < k; i++) {
/* 190 */       this.mConfigArray.add(Integer.valueOf(paramParcel.readInt()));
/*     */     }
/* 192 */     this.mConfigString = paramParcel.readString();
/* 193 */     this.mMaxSampleRate = paramParcel.readFloat();
/* 194 */     this.mMinSampleRate = paramParcel.readFloat();
/* 195 */     this.mPropertyId = paramParcel.readInt();
/* 196 */     k = paramParcel.readInt();
/* 197 */     this.mSupportedAreas = new SparseArray(k);
/* 198 */     for (i = j; i < k; i++) {
/* 199 */       j = paramParcel.readInt();
/* 200 */       AreaConfig areaConfig = (AreaConfig)paramParcel.readParcelable(getClass().getClassLoader());
/* 201 */       this.mSupportedAreas.put(j, areaConfig);
/*     */     } 
/* 203 */     String str = paramParcel.readString();
/*     */     try {
/* 205 */       this.mType = (Class)Class.forName(str); return;
/* 206 */     } catch (ClassNotFoundException classNotFoundException) {
/* 207 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Class not found: "); stringBuilder.append(str); throw new IllegalArgumentException(stringBuilder.toString());
/*     */     } 
/*     */   }
/*     */   
/* 211 */   public static final Parcelable.Creator<CarPropertyConfig> CREATOR = new Parcelable.Creator<CarPropertyConfig>()
/*     */     {
/*     */       public CarPropertyConfig createFromParcel(Parcel param1Parcel) {
/* 214 */         return new CarPropertyConfig(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public CarPropertyConfig[] newArray(int param1Int) {
/* 219 */         return new CarPropertyConfig[param1Int];
/*     */       }
/*     */     };
/*     */   private final int mAccess; private final int mAreaType; private final int mChangeMode; private final ArrayList<Integer> mConfigArray; private final String mConfigString;
/*     */   
/*     */   public String toString() {
/* 225 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarPropertyConfig{mPropertyId="); stringBuilder.append(this.mPropertyId); stringBuilder.append(", mAccess="); stringBuilder.append(this.mAccess); stringBuilder.append(", mAreaType="); stringBuilder.append(this.mAreaType); stringBuilder.append(", mChangeMode="); stringBuilder.append(this.mChangeMode); stringBuilder.append(", mConfigArray="); stringBuilder.append(this.mConfigArray); stringBuilder.append(", mConfigString="); stringBuilder.append(this.mConfigString); stringBuilder.append(", mMaxSampleRate="); stringBuilder.append(this.mMaxSampleRate); stringBuilder.append(", mMinSampleRate="); stringBuilder.append(this.mMinSampleRate); stringBuilder.append(", mSupportedAreas="); stringBuilder.append(this.mSupportedAreas); stringBuilder.append(", mType="); stringBuilder.append(this.mType); stringBuilder.append('}'); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private final float mMaxSampleRate;
/*     */   
/*     */   private final float mMinSampleRate;
/*     */   
/*     */   private final int mPropertyId;
/*     */   
/*     */   private final SparseArray<AreaConfig<T>> mSupportedAreas;
/*     */   
/*     */   private final Class<T> mType;
/*     */ 
/*     */   
/*     */   public static class AreaConfig<T>
/*     */     implements Parcelable
/*     */   {
/*     */     private AreaConfig(T param1T1, T param1T2) {
/* 244 */       this.mMinValue = param1T1;
/* 245 */       this.mMaxValue = param1T2;
/*     */     }
/*     */ 
/*     */     
/* 249 */     public static final Parcelable.Creator<AreaConfig<Object>> CREATOR = getCreator(Object.class); private final T mMaxValue; private final T mMinValue;
/*     */     
/*     */     private static <E> Parcelable.Creator<AreaConfig<E>> getCreator(final Class<E> clazz) {
/* 252 */       return new Parcelable.Creator<AreaConfig<E>>() { final Class val$clazz;
/*     */           
/*     */           public CarPropertyConfig.AreaConfig<E> createFromParcel(Parcel param2Parcel) {
/* 255 */             return new CarPropertyConfig.AreaConfig<>(param2Parcel);
/*     */           }
/*     */ 
/*     */           
/*     */           public CarPropertyConfig.AreaConfig<E>[] newArray(int param2Int) {
/* 260 */             return (CarPropertyConfig.AreaConfig<E>[])Array.newInstance(clazz, param2Int);
/*     */           } }
/*     */         ;
/*     */     }
/*     */ 
/*     */     
/*     */     private AreaConfig(Parcel param1Parcel) {
/* 267 */       this.mMinValue = (T)param1Parcel.readValue(getClass().getClassLoader());
/* 268 */       this.mMaxValue = (T)param1Parcel.readValue(getClass().getClassLoader());
/*     */     }
/*     */     
/* 271 */     public T getMinValue() { return this.mMinValue; } public T getMaxValue() {
/* 272 */       return this.mMaxValue;
/*     */     }
/*     */     
/*     */     public int describeContents() {
/* 276 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeToParcel(Parcel param1Parcel, int param1Int) {
/* 281 */       param1Parcel.writeValue(this.mMinValue);
/* 282 */       param1Parcel.writeValue(this.mMaxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 287 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarAreaConfig{mMinValue="); stringBuilder.append(this.mMinValue); stringBuilder.append(", mMaxValue="); stringBuilder.append(this.mMaxValue); stringBuilder.append('}'); return stringBuilder.toString();
/*     */     } }
/*     */   
/*     */   class null implements Parcelable.Creator<AreaConfig<E>> { final Class val$clazz;
/*     */     
/*     */     public CarPropertyConfig.AreaConfig<E> createFromParcel(Parcel param1Parcel) {
/*     */       return new CarPropertyConfig.AreaConfig<>(param1Parcel);
/*     */     }
/*     */     
/*     */     public CarPropertyConfig.AreaConfig<E>[] newArray(int param1Int) {
/*     */       return (CarPropertyConfig.AreaConfig<E>[])Array.newInstance(clazz, param1Int);
/*     */     } }
/*     */   
/*     */   public static <T> Builder<T> newBuilder(Class<T> paramClass, int paramInt1, int paramInt2, int paramInt3) {
/* 301 */     return new Builder<>(paramInt3, paramInt2, paramInt1, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Builder<T> newBuilder(Class<T> paramClass, int paramInt1, int paramInt2) {
/* 311 */     return new Builder<>(0, paramInt2, paramInt1, paramClass);
/*     */   }
/*     */   
/*     */   public static class Builder<T> {
/*     */     private int mAccess;
/*     */     private final int mAreaType;
/*     */     private int mChangeMode;
/*     */     private final ArrayList<Integer> mConfigArray;
/*     */     private String mConfigString;
/*     */     private float mMaxSampleRate;
/*     */     private float mMinSampleRate;
/*     */     private final int mPropertyId;
/*     */     private final SparseArray<CarPropertyConfig.AreaConfig<T>> mSupportedAreas;
/*     */     private final Class<T> mType;
/*     */     
/*     */     private Builder(int param1Int1, int param1Int2, int param1Int3, Class<T> param1Class) {
/* 327 */       this.mAreaType = param1Int2;
/* 328 */       this.mConfigArray = new ArrayList<>();
/* 329 */       this.mPropertyId = param1Int3;
/* 330 */       if (param1Int1 != 0) {
/* 331 */         this.mSupportedAreas = new SparseArray(param1Int1);
/*     */       } else {
/* 333 */         this.mSupportedAreas = new SparseArray();
/*     */       } 
/* 335 */       this.mType = param1Class;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> addAreas(int[] param1ArrayOfint) {
/*     */       byte b;
/*     */       int i;
/* 344 */       for (i = param1ArrayOfint.length, b = 0; b < i; ) { int j = param1ArrayOfint[b];
/* 345 */         this.mSupportedAreas.put(j, null); b++; }
/*     */       
/* 347 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> addArea(int param1Int) {
/* 356 */       return addAreaConfig(param1Int, null, null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> addAreaConfig(int param1Int, T param1T1, T param1T2) {
/* 365 */       if (param1T1 == null && param1T2 == null) {
/* 366 */         this.mSupportedAreas.put(param1Int, null);
/*     */       } else {
/* 368 */         this.mSupportedAreas.put(param1Int, new CarPropertyConfig.AreaConfig(param1T1, param1T2));
/*     */       } 
/* 370 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> setAccess(int param1Int) {
/* 379 */       this.mAccess = param1Int;
/* 380 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> setChangeMode(int param1Int) {
/* 389 */       this.mChangeMode = param1Int;
/* 390 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> setConfigArray(ArrayList<Integer> param1ArrayList) {
/* 399 */       this.mConfigArray.clear();
/* 400 */       this.mConfigArray.addAll(param1ArrayList);
/* 401 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> setConfigString(String param1String) {
/* 410 */       this.mConfigString = param1String;
/* 411 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> setMaxSampleRate(float param1Float) {
/* 420 */       this.mMaxSampleRate = param1Float;
/* 421 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<T> setMinSampleRate(float param1Float) {
/* 430 */       this.mMinSampleRate = param1Float;
/* 431 */       return this;
/*     */     }
/*     */     
/*     */     public CarPropertyConfig<T> build() {
/* 435 */       return new CarPropertyConfig<>(this.mAccess, this.mAreaType, this.mChangeMode, this.mConfigArray, this.mConfigString, this.mMaxSampleRate, this.mMinSampleRate, this.mPropertyId, this.mSupportedAreas, this.mType);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\CarPropertyConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */