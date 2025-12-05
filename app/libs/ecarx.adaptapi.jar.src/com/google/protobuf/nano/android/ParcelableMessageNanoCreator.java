/*    */ package com.google.protobuf.nano.android;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import android.util.Log;
/*    */ import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
/*    */ import com.google.protobuf.nano.MessageNano;
/*    */ import java.lang.reflect.Array;
/*    */ import java.lang.reflect.InvocationTargetException;
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
/*    */ public final class ParcelableMessageNanoCreator<T extends MessageNano>
/*    */   implements Parcelable.Creator<T>
/*    */ {
/*    */   private static final String TAG = "PMNCreator";
/*    */   private final Class<T> mClazz;
/*    */   
/*    */   public ParcelableMessageNanoCreator(Class<T> paramClass) {
/* 50 */     this.mClazz = paramClass;
/*    */   }
/*    */ 
/*    */   
/*    */   public T createFromParcel(Parcel paramParcel) {
/*    */     MessageNano messageNano1, messageNano2;
/* 56 */     String str = paramParcel.readString();
/* 57 */     byte[] arrayOfByte = paramParcel.createByteArray();
/*    */     
/* 59 */     MessageNano messageNano9 = null; paramParcel = null; MessageNano messageNano11 = null, messageNano8 = null, messageNano10 = null, messageNano12 = null;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 64 */     MessageNano messageNano4 = messageNano12, messageNano3 = messageNano9; Parcel parcel = paramParcel; MessageNano messageNano7 = messageNano11, messageNano5 = messageNano8, messageNano6 = messageNano10; try { Class<?> clazz = Class.forName(str, false, getClass().getClassLoader());
/* 65 */       messageNano4 = messageNano12; messageNano3 = messageNano9; parcel = paramParcel; messageNano7 = messageNano11; messageNano5 = messageNano8; messageNano6 = messageNano10; clazz = clazz.asSubclass(MessageNano.class);
/* 66 */       messageNano4 = messageNano12; messageNano3 = messageNano9; parcel = paramParcel; messageNano7 = messageNano11; messageNano5 = messageNano8; messageNano6 = messageNano10; clazz = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
/* 67 */       messageNano4 = messageNano12; messageNano3 = messageNano9; parcel = paramParcel; messageNano7 = messageNano11; messageNano5 = messageNano8; messageNano6 = messageNano10; messageNano1 = (MessageNano)clazz;
/* 68 */       messageNano4 = messageNano1; messageNano3 = messageNano1; messageNano2 = messageNano1; messageNano7 = messageNano1; messageNano5 = messageNano1; messageNano6 = messageNano1; MessageNano.mergeFrom(messageNano1, arrayOfByte); }
/* 69 */     catch (ClassNotFoundException classNotFoundException)
/* 70 */     { Log.e("PMNCreator", "Exception trying to create proto from parcel", classNotFoundException); messageNano1 = messageNano6; }
/* 71 */     catch (NoSuchMethodException noSuchMethodException)
/* 72 */     { Log.e("PMNCreator", "Exception trying to create proto from parcel", noSuchMethodException); messageNano1 = messageNano5; }
/* 73 */     catch (InvocationTargetException invocationTargetException)
/* 74 */     { Log.e("PMNCreator", "Exception trying to create proto from parcel", invocationTargetException); messageNano1 = messageNano7; }
/* 75 */     catch (IllegalAccessException illegalAccessException)
/* 76 */     { Log.e("PMNCreator", "Exception trying to create proto from parcel", illegalAccessException); messageNano1 = messageNano2; }
/* 77 */     catch (InstantiationException instantiationException)
/* 78 */     { Log.e("PMNCreator", "Exception trying to create proto from parcel", instantiationException); messageNano1 = messageNano3; }
/* 79 */     catch (InvalidProtocolBufferNanoException invalidProtocolBufferNanoException)
/* 80 */     { Log.e("PMNCreator", "Exception trying to create proto from parcel", (Throwable)invalidProtocolBufferNanoException); messageNano1 = messageNano4; }
/*    */ 
/*    */     
/* 83 */     return (T)messageNano1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public T[] newArray(int paramInt) {
/* 89 */     return (T[])Array.newInstance(this.mClazz, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   static <T extends MessageNano> void writeToParcel(Class<T> paramClass, MessageNano paramMessageNano, Parcel paramParcel) {
/* 94 */     paramParcel.writeString(paramClass.getName());
/* 95 */     paramParcel.writeByteArray(MessageNano.toByteArray(paramMessageNano));
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\android\ParcelableMessageNanoCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */