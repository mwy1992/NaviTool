/*    */ package com.google.protobuf.nano.android;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import com.google.protobuf.nano.MessageNano;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ParcelableMessageNano
/*    */   extends MessageNano
/*    */   implements Parcelable
/*    */ {
/*    */   public int describeContents() {
/* 45 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 50 */     ParcelableMessageNanoCreator.writeToParcel(getClass(), this, paramParcel);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\android\ParcelableMessageNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */