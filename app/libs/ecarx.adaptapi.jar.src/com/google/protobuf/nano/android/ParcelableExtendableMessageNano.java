/*    */ package com.google.protobuf.nano.android;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import com.google.protobuf.nano.ExtendableMessageNano;
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
/*    */ 
/*    */ public abstract class ParcelableExtendableMessageNano<M extends ExtendableMessageNano<M>>
/*    */   extends ExtendableMessageNano<M>
/*    */   implements Parcelable
/*    */ {
/*    */   public int describeContents() {
/* 47 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 52 */     ParcelableMessageNanoCreator.writeToParcel(getClass(), (MessageNano)this, paramParcel);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\android\ParcelableExtendableMessageNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */