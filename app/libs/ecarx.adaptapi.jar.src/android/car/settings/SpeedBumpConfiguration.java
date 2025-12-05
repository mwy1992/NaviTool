/*     */ package android.car.settings;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
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
/*     */ public final class SpeedBumpConfiguration
/*     */   implements Parcelable
/*     */ {
/*     */   public SpeedBumpConfiguration(double paramDouble1, double paramDouble2, long paramLong) {
/*  36 */     this.mAcquiredPermitsPerSecond = paramDouble1;
/*  37 */     this.mMaxPermitPool = paramDouble2;
/*  38 */     this.mPermitFillDelay = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getAcquiredPermitsPerSecond() {
/*  46 */     return this.mAcquiredPermitsPerSecond;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaxPermitPool() {
/*  53 */     return this.mMaxPermitPool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPermitFillDelay() {
/*  61 */     return this.mPermitFillDelay;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  66 */     double d1 = this.mAcquiredPermitsPerSecond;
/*     */     
/*  68 */     double d2 = this.mMaxPermitPool;
/*  69 */     long l = this.mPermitFillDelay;
/*     */     return String.format("[acquired_permits_per_second: %f, max_permit_pool: %f, permit_fill_delay: %d]", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Long.valueOf(l) });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  75 */     null = true; if (paramObject == this) {
/*  76 */       return true;
/*     */     }
/*     */     
/*  79 */     if (!(paramObject instanceof SpeedBumpConfiguration)) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     paramObject = paramObject;
/*  84 */     if (this.mAcquiredPermitsPerSecond == paramObject.getAcquiredPermitsPerSecond()) { double d = this.mMaxPermitPool;
/*  85 */       if (d == paramObject.getMaxPermitPool()) { long l = this.mPermitFillDelay;
/*  86 */         if (l == paramObject.getPermitFillDelay())
/*     */           return null;  }
/*     */        }
/*     */     
/*     */     return false; } public int hashCode() {
/*  91 */     return Objects.hash(new Object[] { Double.valueOf(this.mAcquiredPermitsPerSecond), Double.valueOf(this.mMaxPermitPool), Long.valueOf(this.mPermitFillDelay) });
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  96 */     paramParcel.writeDouble(this.mAcquiredPermitsPerSecond);
/*  97 */     paramParcel.writeDouble(this.mMaxPermitPool);
/*  98 */     paramParcel.writeLong(this.mPermitFillDelay);
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */   private SpeedBumpConfiguration(Parcel paramParcel) {
/* 107 */     this.mAcquiredPermitsPerSecond = paramParcel.readDouble();
/* 108 */     this.mMaxPermitPool = paramParcel.readDouble();
/* 109 */     this.mPermitFillDelay = paramParcel.readLong();
/*     */   }
/*     */   
/* 112 */   public static final Parcelable.Creator<SpeedBumpConfiguration> CREATOR = new Parcelable.Creator<SpeedBumpConfiguration>()
/*     */     {
/*     */       public SpeedBumpConfiguration createFromParcel(Parcel param1Parcel) {
/* 115 */         return new SpeedBumpConfiguration(param1Parcel);
/*     */       }
/*     */       
/*     */       public SpeedBumpConfiguration[] newArray(int param1Int) {
/* 119 */         return new SpeedBumpConfiguration[param1Int];
/*     */       }
/*     */     };
/*     */   
/*     */   private final double mAcquiredPermitsPerSecond;
/*     */   private final double mMaxPermitPool;
/*     */   private final long mPermitFillDelay;
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\settings\SpeedBumpConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */