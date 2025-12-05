/*     */ package android.car.drivingstate;
/*     */ 
/*     */ import android.annotation.SystemApi;
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
/*     */ @SystemApi
/*     */ public class CarDrivingStateEvent
/*     */   implements Parcelable
/*     */ {
/*     */   public int describeContents() {
/*  79 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  84 */     paramParcel.writeInt(this.eventValue);
/*  85 */     paramParcel.writeLong(this.timeStamp);
/*     */   }
/*     */   
/*  88 */   public static final Parcelable.Creator<CarDrivingStateEvent> CREATOR = new Parcelable.Creator<CarDrivingStateEvent>()
/*     */     {
/*     */       public CarDrivingStateEvent createFromParcel(Parcel param1Parcel) {
/*  91 */         return new CarDrivingStateEvent(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarDrivingStateEvent[] newArray(int param1Int) {
/*  95 */         return new CarDrivingStateEvent[param1Int];
/*     */       }
/*     */     };
/*     */   public static final int DRIVING_STATE_IDLING = 1; public static final int DRIVING_STATE_MOVING = 2; public static final int DRIVING_STATE_PARKED = 0;
/*     */   public CarDrivingStateEvent(int paramInt, long paramLong) {
/* 100 */     this.eventValue = paramInt;
/* 101 */     this.timeStamp = paramLong;
/*     */   }
/*     */   public static final int DRIVING_STATE_UNKNOWN = -1; public final int eventValue; public final long timeStamp;
/*     */   private CarDrivingStateEvent(Parcel paramParcel) {
/* 105 */     this.eventValue = paramParcel.readInt();
/* 106 */     this.timeStamp = paramParcel.readLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(this.eventValue); stringBuilder.append(" "); stringBuilder.append(this.timeStamp); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface CarDrivingState {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\CarDrivingStateEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */