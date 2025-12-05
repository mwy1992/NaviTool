/*     */ package android.car.storagemonitoring;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.time.Instant;
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
/*     */ @SystemApi
/*     */ public class WearEstimateChange
/*     */   implements Parcelable
/*     */ {
/*  37 */   public static final Parcelable.Creator<WearEstimateChange> CREATOR = new Parcelable.Creator<WearEstimateChange>()
/*     */     {
/*     */       public WearEstimateChange createFromParcel(Parcel param1Parcel) {
/*  40 */         return new WearEstimateChange(param1Parcel);
/*     */       }
/*     */       
/*     */       public WearEstimateChange[] newArray(int param1Int) {
/*  44 */         return new WearEstimateChange[param1Int];
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Instant dateAtChange;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isAcceptableDegradation;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final WearEstimate newEstimate;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final WearEstimate oldEstimate;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long uptimeAtChange;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WearEstimateChange(WearEstimate paramWearEstimate1, WearEstimate paramWearEstimate2, long paramLong, Instant paramInstant, boolean paramBoolean) {
/*  78 */     if (paramLong >= 0L) {
/*     */ 
/*     */       
/*  81 */       this.oldEstimate = Objects.<WearEstimate>requireNonNull(paramWearEstimate1);
/*  82 */       this.newEstimate = Objects.<WearEstimate>requireNonNull(paramWearEstimate2);
/*  83 */       this.uptimeAtChange = paramLong;
/*  84 */       this.dateAtChange = Objects.<Instant>requireNonNull(paramInstant);
/*  85 */       this.isAcceptableDegradation = paramBoolean;
/*     */       return;
/*     */     } 
/*     */     throw new IllegalArgumentException("uptimeAtChange must be >= 0"); } public WearEstimateChange(Parcel paramParcel) {
/*  89 */     this.oldEstimate = (WearEstimate)paramParcel.readParcelable(WearEstimate.class.getClassLoader());
/*  90 */     this.newEstimate = (WearEstimate)paramParcel.readParcelable(WearEstimate.class.getClassLoader());
/*  91 */     this.uptimeAtChange = paramParcel.readLong();
/*  92 */     this.dateAtChange = Instant.ofEpochMilli(paramParcel.readLong());
/*  93 */     int i = paramParcel.readInt(); boolean bool = true; if (i != 1) bool = false;  this.isAcceptableDegradation = bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  98 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 103 */     paramParcel.writeParcelable(this.oldEstimate, paramInt);
/* 104 */     paramParcel.writeParcelable(this.newEstimate, paramInt);
/* 105 */     paramParcel.writeLong(this.uptimeAtChange);
/* 106 */     paramParcel.writeLong(this.dateAtChange.toEpochMilli());
/* 107 */     paramParcel.writeInt(this.isAcceptableDegradation);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 112 */     boolean bool = paramObject instanceof WearEstimateChange; boolean bool1 = false; if (bool) {
/* 113 */       paramObject = paramObject;
/* 114 */       bool = bool1; if (((WearEstimateChange)paramObject).isAcceptableDegradation == this.isAcceptableDegradation) { bool = bool1; if (((WearEstimateChange)paramObject).uptimeAtChange == this.uptimeAtChange) { Instant instant2 = ((WearEstimateChange)paramObject).dateAtChange, instant1 = this.dateAtChange;
/*     */           
/* 116 */           bool = bool1; if (instant2.equals(instant1)) { WearEstimate wearEstimate2 = ((WearEstimateChange)paramObject).oldEstimate, wearEstimate1 = this.oldEstimate;
/* 117 */             bool = bool1; if (wearEstimate2.equals(wearEstimate1)) { wearEstimate1 = ((WearEstimateChange)paramObject).newEstimate; paramObject = this.newEstimate;
/* 118 */               bool = bool1; if (wearEstimate1.equals(paramObject)) bool = true;  }  }  }  }
/*     */        return bool;
/* 120 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     WearEstimate wearEstimate2 = this.oldEstimate, wearEstimate1 = this.newEstimate; long l = this.uptimeAtChange;
/*     */     
/* 127 */     Instant instant = this.dateAtChange; boolean bool = this.isAcceptableDegradation;
/*     */     return Objects.hash(new Object[] { wearEstimate2, wearEstimate1, Long.valueOf(l), instant, Boolean.valueOf(bool) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     String str;
/* 134 */     WearEstimate wearEstimate2 = this.oldEstimate, wearEstimate1 = this.newEstimate; long l = this.uptimeAtChange;
/*     */ 
/*     */ 
/*     */     
/* 138 */     Instant instant = this.dateAtChange;
/*     */     
/* 140 */     if (this.isAcceptableDegradation) { str = "yes"; } else { str = "no"; }
/*     */     
/*     */     return String.format("wear change{old level=%s, new level=%s, uptime=%d, date=%s, acceptable=%s}", new Object[] { wearEstimate2, wearEstimate1, Long.valueOf(l), instant, str });
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\WearEstimateChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */