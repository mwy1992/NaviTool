/*     */ package android.car.navigation;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class CarNavigationInstrumentCluster
/*     */   implements Parcelable
/*     */ {
/*     */   public static final int CLUSTER_TYPE_CUSTOM_IMAGES_SUPPORTED = 1;
/*     */   public static final int CLUSTER_TYPE_IMAGE_CODES_ONLY = 2;
/*     */   
/*  59 */   public static final Parcelable.Creator<CarNavigationInstrumentCluster> CREATOR = new Parcelable.Creator<CarNavigationInstrumentCluster>()
/*     */     {
/*     */       public CarNavigationInstrumentCluster createFromParcel(Parcel param1Parcel) {
/*  62 */         return new CarNavigationInstrumentCluster(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarNavigationInstrumentCluster[] newArray(int param1Int) {
/*  66 */         return new CarNavigationInstrumentCluster[param1Int];
/*     */       }
/*     */     };
/*     */   private final Bundle mExtra;
/*     */   public static CarNavigationInstrumentCluster createCluster(int paramInt) {
/*  71 */     return new CarNavigationInstrumentCluster(paramInt, 2, 0, 0, 0);
/*     */   }
/*     */   private final int mImageColorDepthBits; private final int mImageHeight; private final int mImageWidth; private int mMinIntervalMillis;
/*     */   private final int mType;
/*     */   
/*     */   public static CarNavigationInstrumentCluster createCustomImageCluster(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  77 */     return new CarNavigationInstrumentCluster(paramInt1, 1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinIntervalMillis() {
/*  84 */     return this.mMinIntervalMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/*  93 */     return this.mType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getImageWidth() {
/*  98 */     return this.mImageWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getImageHeight() {
/* 103 */     return this.mImageHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Bundle getExtra() {
/* 110 */     return this.mExtra;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getImageColorDepthBits() {
/* 116 */     return this.mImageColorDepthBits;
/*     */   }
/*     */   
/*     */   public CarNavigationInstrumentCluster(CarNavigationInstrumentCluster paramCarNavigationInstrumentCluster) {
/* 120 */     this(paramCarNavigationInstrumentCluster.mMinIntervalMillis, paramCarNavigationInstrumentCluster.mType, paramCarNavigationInstrumentCluster.mImageWidth, paramCarNavigationInstrumentCluster.mImageHeight, paramCarNavigationInstrumentCluster.mImageColorDepthBits);
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
/*     */   public boolean supportsCustomImages() {
/* 132 */     int i = this.mType; boolean bool = true; if (i != 1) bool = false;  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CarNavigationInstrumentCluster(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 141 */     this.mMinIntervalMillis = paramInt1;
/* 142 */     this.mType = paramInt2;
/* 143 */     this.mImageWidth = paramInt3;
/* 144 */     this.mImageHeight = paramInt4;
/* 145 */     this.mImageColorDepthBits = paramInt5;
/* 146 */     this.mExtra = new Bundle();
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 151 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 156 */     paramParcel.writeInt(this.mMinIntervalMillis);
/* 157 */     paramParcel.writeInt(this.mType);
/* 158 */     paramParcel.writeInt(this.mImageWidth);
/* 159 */     paramParcel.writeInt(this.mImageHeight);
/* 160 */     paramParcel.writeInt(this.mImageColorDepthBits);
/* 161 */     paramParcel.writeBundle(this.mExtra);
/*     */   }
/*     */   
/*     */   private CarNavigationInstrumentCluster(Parcel paramParcel) {
/* 165 */     this.mMinIntervalMillis = paramParcel.readInt();
/* 166 */     this.mType = paramParcel.readInt();
/* 167 */     this.mImageWidth = paramParcel.readInt();
/* 168 */     this.mImageHeight = paramParcel.readInt();
/* 169 */     this.mImageColorDepthBits = paramParcel.readInt();
/* 170 */     this.mExtra = paramParcel.readBundle(getClass().getClassLoader());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(CarNavigationInstrumentCluster.class.getSimpleName()); stringBuilder.append("{ minIntervalMillis: "); stringBuilder.append(this.mMinIntervalMillis); stringBuilder.append(", type: "); stringBuilder.append(this.mType); stringBuilder.append(", imageWidth: "); stringBuilder.append(this.mImageWidth); stringBuilder.append(", imageHeight: "); stringBuilder.append(this.mImageHeight); stringBuilder.append(", imageColourDepthBits: "); stringBuilder.append(this.mImageColorDepthBits); stringBuilder.append("extra: "); stringBuilder.append(this.mExtra); stringBuilder.append(" }"); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface ClusterType {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\navigation\CarNavigationInstrumentCluster.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */