/*     */ package android.car.drivingstate;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CarUxRestrictions
/*     */   implements Parcelable
/*     */ {
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface CarUxRestrictionsInfo {}
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private final long mTimeStamp;
/*     */     private final boolean mRequiresDistractionOptimization;
/* 173 */     private int mMaxStringLength = 120;
/* 174 */     private int mMaxCumulativeContentItems = 21;
/* 175 */     private int mMaxContentDepth = 3; private final int mActiveRestrictions;
/*     */     
/*     */     public Builder(boolean param1Boolean, int param1Int, long param1Long) {
/* 178 */       this.mRequiresDistractionOptimization = param1Boolean;
/* 179 */       this.mActiveRestrictions = param1Int;
/* 180 */       this.mTimeStamp = param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder setMaxStringLength(int param1Int) {
/* 188 */       this.mMaxStringLength = param1Int;
/* 189 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder setMaxCumulativeContentItems(int param1Int) {
/* 197 */       this.mMaxCumulativeContentItems = param1Int;
/* 198 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder setMaxContentDepth(int param1Int) {
/* 206 */       this.mMaxContentDepth = param1Int;
/* 207 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CarUxRestrictions build() {
/* 214 */       return new CarUxRestrictions(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 225 */     return this.mTimeStamp;
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
/*     */   public boolean isRequiresDistractionOptimization() {
/* 240 */     return this.mRequiresDistractionOptimization;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getActiveRestrictions() {
/* 250 */     return this.mActiveRestrictions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRestrictedStringLength() {
/* 260 */     return this.mMaxStringLength;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxCumulativeContentItems() {
/* 289 */     return this.mMaxCumulativeContentItems;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxContentDepth() {
/* 313 */     return this.mMaxContentDepth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 318 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 323 */     paramParcel.writeInt(this.mActiveRestrictions);
/* 324 */     paramParcel.writeLong(this.mTimeStamp);
/* 325 */     paramParcel.writeInt(this.mRequiresDistractionOptimization);
/* 326 */     paramParcel.writeInt(this.mMaxStringLength);
/* 327 */     paramParcel.writeInt(this.mMaxCumulativeContentItems);
/* 328 */     paramParcel.writeInt(this.mMaxContentDepth);
/*     */   }
/*     */   
/* 331 */   public static final Parcelable.Creator<CarUxRestrictions> CREATOR = new Parcelable.Creator<CarUxRestrictions>()
/*     */     {
/*     */       public CarUxRestrictions createFromParcel(Parcel param1Parcel) {
/* 334 */         return new CarUxRestrictions(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarUxRestrictions[] newArray(int param1Int) {
/* 338 */         return new CarUxRestrictions[param1Int];
/*     */       }
/*     */     };
/*     */   private static final int DEFAULT_MAX_CONTENT_DEPTH = 3; private static final int DEFAULT_MAX_CUMULATIVE_ITEMS = 21; private static final int DEFAULT_MAX_LENGTH = 120; public static final int UX_RESTRICTIONS_BASELINE = 0; public static final int UX_RESTRICTIONS_FULLY_RESTRICTED = 511; public static final int UX_RESTRICTIONS_LIMIT_CONTENT = 32; public static final int UX_RESTRICTIONS_LIMIT_STRING_LENGTH = 4; public static final int UX_RESTRICTIONS_NO_DIALPAD = 1; public static final int UX_RESTRICTIONS_NO_FILTERING = 2; public static final int UX_RESTRICTIONS_NO_KEYBOARD = 8;
/*     */   public CarUxRestrictions(CarUxRestrictions paramCarUxRestrictions) {
/* 343 */     this.mTimeStamp = paramCarUxRestrictions.getTimeStamp();
/* 344 */     this.mRequiresDistractionOptimization = paramCarUxRestrictions.isRequiresDistractionOptimization();
/* 345 */     this.mActiveRestrictions = paramCarUxRestrictions.getActiveRestrictions();
/* 346 */     this.mMaxStringLength = paramCarUxRestrictions.mMaxStringLength;
/* 347 */     this.mMaxCumulativeContentItems = paramCarUxRestrictions.mMaxCumulativeContentItems;
/* 348 */     this.mMaxContentDepth = paramCarUxRestrictions.mMaxContentDepth;
/*     */   }
/*     */   public static final int UX_RESTRICTIONS_NO_SETUP = 64; public static final int UX_RESTRICTIONS_NO_TEXT_MESSAGE = 128; public static final int UX_RESTRICTIONS_NO_VIDEO = 16; public static final int UX_RESTRICTIONS_NO_VOICE_TRANSCRIPTION = 256; private final int mActiveRestrictions; private final int mMaxContentDepth; private final int mMaxCumulativeContentItems; private final int mMaxStringLength; private final boolean mRequiresDistractionOptimization; private final long mTimeStamp;
/*     */   private CarUxRestrictions(Builder paramBuilder) {
/* 352 */     this.mTimeStamp = paramBuilder.mTimeStamp;
/* 353 */     this.mActiveRestrictions = paramBuilder.mActiveRestrictions;
/* 354 */     this.mRequiresDistractionOptimization = paramBuilder.mRequiresDistractionOptimization;
/* 355 */     this.mMaxStringLength = paramBuilder.mMaxStringLength;
/* 356 */     this.mMaxCumulativeContentItems = paramBuilder.mMaxCumulativeContentItems;
/* 357 */     this.mMaxContentDepth = paramBuilder.mMaxContentDepth;
/*     */   }
/*     */   private CarUxRestrictions(Parcel paramParcel) {
/*     */     boolean bool;
/* 361 */     this.mActiveRestrictions = paramParcel.readInt();
/* 362 */     this.mTimeStamp = paramParcel.readLong();
/* 363 */     if (paramParcel.readInt() != 0) { bool = true; } else { bool = false; }  this.mRequiresDistractionOptimization = bool;
/* 364 */     this.mMaxStringLength = paramParcel.readInt();
/* 365 */     this.mMaxCumulativeContentItems = paramParcel.readInt();
/* 366 */     this.mMaxContentDepth = paramParcel.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 371 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DO: "); stringBuilder.append(this.mRequiresDistractionOptimization); stringBuilder.append(" UxR: "); stringBuilder.append(this.mActiveRestrictions); stringBuilder.append(" time: "); stringBuilder.append(this.mTimeStamp); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSameRestrictions(CarUxRestrictions paramCarUxRestrictions) {
/* 382 */     boolean bool2 = false; if (paramCarUxRestrictions == null) {
/* 383 */       return false;
/*     */     }
/* 385 */     if (paramCarUxRestrictions == this) {
/* 386 */       return true;
/*     */     }
/* 388 */     boolean bool1 = bool2; if (paramCarUxRestrictions.mRequiresDistractionOptimization == this.mRequiresDistractionOptimization) { bool1 = bool2; if (paramCarUxRestrictions.mActiveRestrictions == this.mActiveRestrictions) bool1 = true;  }  return bool1;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\CarUxRestrictions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */