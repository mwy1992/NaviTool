/*     */ package android.car.content.pm;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.content.pm.Signature;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class AppBlockingPackageInfo
/*     */   implements Parcelable
/*     */ {
/*     */   public AppBlockingPackageInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, Signature[] paramArrayOfSignature, String[] paramArrayOfString) {
/*  87 */     if (paramString != null) {
/*     */ 
/*     */       
/*  90 */       this.packageName = paramString;
/*  91 */       this.flags = paramInt3;
/*  92 */       this.minRevisionCode = paramInt1;
/*  93 */       this.maxRevisionCode = paramInt2;
/*  94 */       this.signatures = paramArrayOfSignature;
/*  95 */       this.activities = paramArrayOfString;
/*  96 */       verify();
/*     */       return;
/*     */     } 
/*     */     throw new IllegalArgumentException("packageName cannot be null"); } public AppBlockingPackageInfo(Parcel paramParcel) {
/* 100 */     this.packageName = paramParcel.readString();
/* 101 */     this.flags = paramParcel.readInt();
/* 102 */     this.minRevisionCode = paramParcel.readInt();
/* 103 */     this.maxRevisionCode = paramParcel.readInt();
/* 104 */     this.signatures = (Signature[])paramParcel.createTypedArray(Signature.CREATOR);
/* 105 */     this.activities = paramParcel.createStringArray();
/* 106 */     verify();
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 111 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 116 */     paramParcel.writeString(this.packageName);
/* 117 */     paramParcel.writeInt(this.flags);
/* 118 */     paramParcel.writeInt(this.minRevisionCode);
/* 119 */     paramParcel.writeInt(this.maxRevisionCode);
/* 120 */     paramParcel.writeTypedArray((Parcelable[])this.signatures, 0);
/* 121 */     paramParcel.writeStringArray(this.activities);
/*     */   }
/*     */   
/* 124 */   public static final Parcelable.Creator<AppBlockingPackageInfo> CREATOR = new Parcelable.Creator<AppBlockingPackageInfo>()
/*     */     {
/*     */       public AppBlockingPackageInfo createFromParcel(Parcel param1Parcel) {
/* 127 */         return new AppBlockingPackageInfo(param1Parcel);
/*     */       }
/*     */       
/*     */       public AppBlockingPackageInfo[] newArray(int param1Int) {
/* 131 */         return new AppBlockingPackageInfo[param1Int];
/*     */       }
/*     */     };
/*     */   public static final int FLAG_SYSTEM_APP = 1; public static final int FLAG_WHOLE_ACTIVITY = 2;
/*     */   
/*     */   public void verify() throws IllegalArgumentException {
/* 137 */     if (this.signatures != null || (this.flags & 0x1) != 0)
/* 138 */       return;  throw new IllegalArgumentException("Only system package with FLAG_SYSTEM_APP can have null signatures");
/*     */   }
/*     */   public final String[] activities; public final int flags; public final int maxRevisionCode; public final int minRevisionCode;
/*     */   public final String packageName;
/*     */   public final Signature[] signatures;
/*     */   
/*     */   public boolean isActivityCovered(String paramString) {
/* 145 */     if ((this.flags & 0x2) != 0) {
/* 146 */       return true;
/*     */     }
/* 148 */     if (this.activities == null) {
/* 149 */       return false;
/*     */     }
/* 151 */     for (String str : this.activities) {
/* 152 */       if (str.equals(paramString)) {
/* 153 */         return true;
/*     */       }
/*     */     } 
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 165 */     int i, n = Arrays.hashCode((Object[])this.activities);
/* 166 */     int j = this.flags;
/* 167 */     int k = this.maxRevisionCode;
/* 168 */     int m = this.minRevisionCode;
/* 169 */     if (this.packageName == null) { i = 0; } else { i = this.packageName.hashCode(); }
/* 170 */      int i1 = Arrays.hashCode((Object[])this.signatures);
/* 171 */     return 31 * (31 * (31 * (31 * (31 * (31 * 1 + n) + j) + k) + m) + i) + i1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 176 */     if (this == paramObject) {
/* 177 */       return true;
/*     */     }
/* 179 */     if (paramObject == null) {
/* 180 */       return false;
/*     */     }
/* 182 */     if (getClass() != paramObject.getClass()) {
/* 183 */       return false;
/*     */     }
/* 185 */     paramObject = paramObject;
/* 186 */     if (!Arrays.equals((Object[])this.activities, (Object[])((AppBlockingPackageInfo)paramObject).activities)) {
/* 187 */       return false;
/*     */     }
/* 189 */     if (this.flags != ((AppBlockingPackageInfo)paramObject).flags) {
/* 190 */       return false;
/*     */     }
/* 192 */     if (this.maxRevisionCode != ((AppBlockingPackageInfo)paramObject).maxRevisionCode) {
/* 193 */       return false;
/*     */     }
/* 195 */     if (this.minRevisionCode != ((AppBlockingPackageInfo)paramObject).minRevisionCode) {
/* 196 */       return false;
/*     */     }
/* 198 */     if (this.packageName == null) {
/* 199 */       if (((AppBlockingPackageInfo)paramObject).packageName != null)
/* 200 */         return false; 
/* 201 */     } else if (!this.packageName.equals(((AppBlockingPackageInfo)paramObject).packageName)) {
/* 202 */       return false;
/* 203 */     }  if (!Arrays.equals((Object[])this.signatures, (Object[])((AppBlockingPackageInfo)paramObject).signatures)) {
/* 204 */       return false;
/*     */     }
/* 206 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 211 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("AppBlockingPackageInfo [packageName="); stringBuilder.append(this.packageName); stringBuilder.append(", flags="); stringBuilder.append(this.flags); stringBuilder.append(", minRevisionCode="); stringBuilder.append(this.minRevisionCode); stringBuilder.append(", maxRevisionCode="); stringBuilder.append(this.maxRevisionCode); stringBuilder.append(", signatures="); Signature[] arrayOfSignature = this.signatures;
/*     */     
/* 213 */     stringBuilder.append(Arrays.toString((Object[])arrayOfSignature)); stringBuilder.append(", activities="); String[] arrayOfString = this.activities;
/* 214 */     stringBuilder.append(Arrays.toString((Object[])arrayOfString)); stringBuilder.append("]"); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface ConstrcutorFlags {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\AppBlockingPackageInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */