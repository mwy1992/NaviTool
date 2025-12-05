/*     */ package android.car.content.pm;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class CarAppBlockingPolicy
/*     */   implements Parcelable
/*     */ {
/*     */   public static final Parcelable.Creator<CarAppBlockingPolicy> CREATOR;
/*  34 */   private static final String TAG = CarAppBlockingPolicy.class.getSimpleName();
/*     */   private static final Method sReadBlobMethod;
/*     */   private static final Method sWriteBlobMethod;
/*     */   public final AppBlockingPackageInfo[] blacklists;
/*     */   public final AppBlockingPackageInfo[] whitelists;
/*     */   
/*     */   static {
/*     */     Method method;
/*     */   }
/*     */   
/*     */   static
/*     */   {
/*     */     try {
/*  47 */       method = Parcel.class.getMethod("readBlob", new Class[0]);
/*  48 */       Method method1 = Parcel.class.getMethod("writeBlob", new Class[] { byte[].class });
/*  49 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */       
/*  51 */       method = null;
/*  52 */       noSuchMethodException = null;
/*     */     } 
/*  54 */     sReadBlobMethod = method;
/*  55 */     sWriteBlobMethod = (Method)noSuchMethodException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     CREATOR = new Parcelable.Creator<CarAppBlockingPolicy>()
/*     */       {
/*     */         public CarAppBlockingPolicy createFromParcel(Parcel param1Parcel) {
/*  93 */           return new CarAppBlockingPolicy(param1Parcel);
/*     */         }
/*     */         
/*     */         public CarAppBlockingPolicy[] newArray(int param1Int) {
/*  97 */           return new CarAppBlockingPolicy[param1Int];
/*     */         }
/*     */       };
/*     */   }
/*     */   public CarAppBlockingPolicy(AppBlockingPackageInfo[] paramArrayOfAppBlockingPackageInfo1, AppBlockingPackageInfo[] paramArrayOfAppBlockingPackageInfo2) {
/*     */     this.whitelists = paramArrayOfAppBlockingPackageInfo1;
/*     */     this.blacklists = paramArrayOfAppBlockingPackageInfo2;
/*     */   }
/* 105 */   public int hashCode() { int j = Arrays.hashCode((Object[])this.blacklists);
/* 106 */     int i = Arrays.hashCode((Object[])this.whitelists);
/* 107 */     return 31 * (31 * 1 + j) + i; }
/*     */   public CarAppBlockingPolicy(Parcel paramParcel) { byte[] arrayOfByte = paramParcel.readBlob(); Parcel parcel = Parcel.obtain(); parcel.unmarshall(arrayOfByte, 0, arrayOfByte.length); parcel.setDataPosition(0); this.whitelists = (AppBlockingPackageInfo[])parcel.createTypedArray(AppBlockingPackageInfo.CREATOR); this.blacklists = (AppBlockingPackageInfo[])parcel.createTypedArray(AppBlockingPackageInfo.CREATOR); parcel.recycle(); }
/*     */   public int describeContents() { return 0; }
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) { Parcel parcel = Parcel.obtain(); parcel.writeTypedArray((Parcelable[])this.whitelists, 0); parcel.writeTypedArray((Parcelable[])this.blacklists, 0); byte[] arrayOfByte = parcel.marshall();
/*     */     paramParcel.writeBlob(arrayOfByte);
/* 112 */     parcel.recycle(); } public boolean equals(Object paramObject) { if (this == paramObject) {
/* 113 */       return true;
/*     */     }
/* 115 */     if (paramObject == null) {
/* 116 */       return false;
/*     */     }
/* 118 */     if (getClass() != paramObject.getClass()) {
/* 119 */       return false;
/*     */     }
/* 121 */     paramObject = paramObject;
/* 122 */     if (!Arrays.equals((Object[])this.blacklists, (Object[])((CarAppBlockingPolicy)paramObject).blacklists)) {
/* 123 */       return false;
/*     */     }
/* 125 */     if (!Arrays.equals((Object[])this.whitelists, (Object[])((CarAppBlockingPolicy)paramObject).whitelists)) {
/* 126 */       return false;
/*     */     }
/* 128 */     return true; }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarAppBlockingPolicy [whitelists="); stringBuilder.append(Arrays.toString((Object[])this.whitelists)); stringBuilder.append(", blacklists="); AppBlockingPackageInfo[] arrayOfAppBlockingPackageInfo = this.blacklists;
/* 134 */     stringBuilder.append(Arrays.toString((Object[])arrayOfAppBlockingPackageInfo)); stringBuilder.append("]"); return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\CarAppBlockingPolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */