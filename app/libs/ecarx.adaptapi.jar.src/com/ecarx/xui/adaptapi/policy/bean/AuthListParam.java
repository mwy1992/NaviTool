/*    */ package com.ecarx.xui.adaptapi.policy.bean;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuthListParam
/*    */   implements Parcelable
/*    */ {
/*    */   public AuthListParam() {}
/*    */   
/*    */   public AuthListParam(String paramString) {
/* 14 */     this.authCode = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AuthListParam(Parcel paramParcel) {
/* 19 */     this.authCode = paramParcel.readStringNoHelper();
/*    */   }
/*    */   
/* 22 */   public static final Parcelable.Creator<AuthListParam> CREATOR = new Parcelable.Creator<AuthListParam>()
/*    */     {
/*    */       public AuthListParam createFromParcel(Parcel param1Parcel) {
/* 25 */         return new AuthListParam(param1Parcel);
/*    */       }
/*    */ 
/*    */       
/*    */       public AuthListParam[] newArray(int param1Int) {
/* 30 */         return new AuthListParam[param1Int];
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public int describeContents() {
/* 36 */     return 0;
/*    */   }
/*    */   private String authCode;
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 41 */     paramParcel.writeString(this.authCode);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAuthCode() {
/* 46 */     return this.authCode;
/*    */   }
/*    */   
/*    */   public void setAuthCode(String paramString) {
/* 50 */     this.authCode = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\bean\AuthListParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */