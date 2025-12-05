/*    */ package com.ecarx.xui.adaptapi.wifiap;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WifiApClientImp
/*    */   implements IWifiApClient, Parcelable
/*    */ {
/*    */   public WifiApClientImp(Context paramContext) {}
/*    */   
/*    */   public WifiApClientImp(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 19 */     this.devName = paramString1;
/* 20 */     this.macAddr = paramString2;
/* 21 */     this.devIpAddr = paramString3;
/* 22 */     this.status = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMac() {
/* 32 */     return this.macAddr;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getIP() {
/* 43 */     return this.devIpAddr;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 54 */     return this.devName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int describeContents() {
/* 60 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 65 */     paramParcel.writeString(this.devName);
/* 66 */     paramParcel.writeString(this.macAddr);
/* 67 */     paramParcel.writeString(this.devIpAddr);
/* 68 */     paramParcel.writeInt(this.status);
/*    */   }
/*    */   
/*    */   protected WifiApClientImp(Parcel paramParcel) {
/* 72 */     this.devName = paramParcel.readString();
/* 73 */     this.macAddr = paramParcel.readString();
/* 74 */     this.devIpAddr = paramParcel.readString();
/* 75 */     this.status = paramParcel.readInt();
/*    */   }
/*    */   
/* 78 */   public static final Parcelable.Creator<WifiApClientImp> CREATOR = new Parcelable.Creator<WifiApClientImp>()
/*    */     {
/*    */       public WifiApClientImp createFromParcel(Parcel param1Parcel) {
/* 81 */         return new WifiApClientImp(param1Parcel);
/*    */       }
/*    */ 
/*    */       
/*    */       public WifiApClientImp[] newArray(int param1Int) {
/* 86 */         return new WifiApClientImp[param1Int];
/*    */       }
/*    */     };
/*    */   
/*    */   public String devIpAddr;
/*    */   public String devName;
/*    */   public String macAddr;
/*    */   public int status;
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\WifiApClientImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */