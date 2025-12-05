/*    */ package android.car.hardware.property;
/*    */ 
/*    */ import android.car.hardware.CarPropertyValue;
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CarPropertyEvent
/*    */   implements Parcelable
/*    */ {
/*    */   public int getEventType() {
/* 39 */     return this.mEventType;
/*    */   }
/*    */ 
/*    */   
/*    */   public CarPropertyValue<?> getCarPropertyValue() {
/* 44 */     return this.mCarPropertyValue;
/*    */   }
/*    */   
/*    */   public int describeContents() {
/* 48 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 53 */     paramParcel.writeInt(this.mEventType);
/* 54 */     paramParcel.writeParcelable((Parcelable)this.mCarPropertyValue, paramInt);
/*    */   }
/*    */   
/* 57 */   public static final Parcelable.Creator<CarPropertyEvent> CREATOR = new Parcelable.Creator<CarPropertyEvent>()
/*    */     {
/*    */       public CarPropertyEvent createFromParcel(Parcel param1Parcel) {
/* 60 */         return new CarPropertyEvent(param1Parcel);
/*    */       }
/*    */       
/*    */       public CarPropertyEvent[] newArray(int param1Int) {
/* 64 */         return new CarPropertyEvent[param1Int];
/*    */       }
/*    */     };
/*    */   
/*    */   public static final int PROPERTY_EVENT_ERROR = 1;
/*    */   public static final int PROPERTY_EVENT_PROPERTY_CHANGE = 0;
/*    */   
/*    */   public CarPropertyEvent(int paramInt, CarPropertyValue<?> paramCarPropertyValue) {
/* 72 */     this.mEventType = paramInt;
/* 73 */     this.mCarPropertyValue = paramCarPropertyValue;
/*    */   }
/*    */   private final CarPropertyValue<?> mCarPropertyValue; private final int mEventType;
/*    */   private CarPropertyEvent(Parcel paramParcel) {
/* 77 */     this.mEventType = paramParcel.readInt();
/* 78 */     this.mCarPropertyValue = (CarPropertyValue)paramParcel.readParcelable(CarPropertyValue.class.getClassLoader());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("CarPropertyEvent{mEventType="); stringBuilder.append(this.mEventType); stringBuilder.append(", mCarPropertyValue="); stringBuilder.append(this.mCarPropertyValue); stringBuilder.append('}'); return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\property\CarPropertyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */