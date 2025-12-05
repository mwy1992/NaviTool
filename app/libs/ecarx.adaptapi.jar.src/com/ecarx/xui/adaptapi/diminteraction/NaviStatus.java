/*    */ package com.ecarx.xui.adaptapi.diminteraction;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
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
/*    */ @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
/*    */ public class NaviStatus
/*    */   implements Parcelable
/*    */ {
/*    */   public NaviStatus(int paramInt, boolean paramBoolean) {
/* 29 */     this.status = paramInt;
/* 30 */     this.isYawing = paramBoolean;
/*    */   }
/*    */   protected NaviStatus(Parcel paramParcel) {
/* 33 */     this.status = paramParcel.readInt();
/* 34 */     int i = paramParcel.readInt(); boolean bool = true; if (i != 1) bool = false;  this.isYawing = bool;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 39 */     paramParcel.writeInt(this.status);
/* 40 */     paramParcel.writeInt(this.isYawing);
/*    */   }
/*    */ 
/*    */   
/*    */   public int describeContents() {
/* 45 */     return 0;
/*    */   }
/*    */   
/* 48 */   public static final Parcelable.Creator<NaviStatus> CREATOR = new Parcelable.Creator<NaviStatus>()
/*    */     {
/*    */       public NaviStatus createFromParcel(Parcel param1Parcel) {
/* 51 */         return new NaviStatus(param1Parcel);
/*    */       }
/*    */ 
/*    */       
/*    */       public NaviStatus[] newArray(int param1Int) {
/* 56 */         return new NaviStatus[param1Int];
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   private boolean isYawing;
/*    */   
/*    */   private int status;
/*    */   
/*    */   public int getStatus() {
/* 66 */     return this.status;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isYawing() {
/* 73 */     return this.isYawing;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\NaviStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */