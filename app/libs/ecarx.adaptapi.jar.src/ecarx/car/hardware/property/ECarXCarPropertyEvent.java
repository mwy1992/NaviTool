/*    */ package ecarx.car.hardware.property;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import ecarx.car.hardware.ECarXCarPropertyValue;
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
/*    */ public class ECarXCarPropertyEvent
/*    */   implements Parcelable
/*    */ {
/* 28 */   public static final Parcelable.Creator<ECarXCarPropertyEvent> CREATOR = new Parcelable.Creator<ECarXCarPropertyEvent>()
/*    */     {
/*    */       public ECarXCarPropertyEvent createFromParcel(Parcel param1Parcel) {
/* 31 */         return new ECarXCarPropertyEvent(param1Parcel);
/*    */       }
/*    */       
/*    */       public ECarXCarPropertyEvent[] newArray(int param1Int) {
/* 35 */         return new ECarXCarPropertyEvent[param1Int];
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public static final int PROPERTY_EVENT_ERROR = 1;
/*    */   
/*    */   public static final int PROPERTY_EVENT_PROPERTY_CHANGE = 0;
/*    */   
/*    */   private final ECarXCarPropertyValue<?> mCarPropertyValue;
/*    */   
/*    */   private final int mEventType;
/*    */ 
/*    */   
/*    */   public ECarXCarPropertyEvent(int paramInt, ECarXCarPropertyValue<?> paramECarXCarPropertyValue) {
/* 50 */     this.mEventType = paramInt;
/* 51 */     this.mCarPropertyValue = paramECarXCarPropertyValue;
/*    */   }
/*    */   
/*    */   private ECarXCarPropertyEvent(Parcel paramParcel) {
/* 55 */     this.mEventType = paramParcel.readInt();
/* 56 */     this.mCarPropertyValue = (ECarXCarPropertyValue)paramParcel.readParcelable(ECarXCarPropertyValue.class.getClassLoader());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getEventType() {
/* 63 */     return this.mEventType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ECarXCarPropertyValue<?> getCarPropertyValue() {
/* 70 */     return this.mCarPropertyValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public int describeContents() {
/* 75 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 80 */     paramParcel.writeInt(this.mEventType);
/* 81 */     paramParcel.writeParcelable((Parcelable)this.mCarPropertyValue, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("ECarXCarPropertyEvent{mEventType="); stringBuilder.append(this.mEventType); stringBuilder.append(", mCarPropertyValue="); stringBuilder.append(this.mCarPropertyValue); stringBuilder.append('}'); return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\property\ECarXCarPropertyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */