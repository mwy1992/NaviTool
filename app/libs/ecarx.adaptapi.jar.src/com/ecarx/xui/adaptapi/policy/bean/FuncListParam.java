/*    */ package com.ecarx.xui.adaptapi.policy.bean;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FuncListParam
/*    */   implements Parcelable
/*    */ {
/*    */   public FuncListParam() {}
/*    */   
/*    */   public FuncListParam(String paramString1, String paramString2, List<AuthListParam> paramList) {
/* 16 */     this.code = paramString1;
/* 17 */     this.funcName = paramString2;
/* 18 */     this.authListParams = paramList;
/*    */   }
/*    */   
/*    */   protected FuncListParam(Parcel paramParcel) {
/* 22 */     this.code = paramParcel.readStringNoHelper();
/* 23 */     this.funcName = paramParcel.readStringNoHelper();
/* 24 */     this.authListParams = paramParcel.createTypedArrayList(AuthListParam.CREATOR);
/*    */   }
/*    */ 
/*    */   
/* 28 */   public static final Parcelable.Creator<FuncListParam> CREATOR = new Parcelable.Creator<FuncListParam>()
/*    */     {
/*    */       public FuncListParam createFromParcel(Parcel param1Parcel) {
/* 31 */         return new FuncListParam(param1Parcel);
/*    */       }
/*    */ 
/*    */       
/*    */       public FuncListParam[] newArray(int param1Int) {
/* 36 */         return new FuncListParam[param1Int];
/*    */       }
/*    */     };
/*    */   private List<AuthListParam> authListParams;
/*    */   
/*    */   public int describeContents() {
/* 42 */     return 0;
/*    */   }
/*    */   private String code; private String funcName;
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 47 */     paramParcel.writeStringNoHelper(this.code);
/* 48 */     paramParcel.writeStringNoHelper(this.funcName);
/* 49 */     paramParcel.writeTypedList(this.authListParams);
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 53 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String paramString) {
/* 57 */     this.code = paramString;
/*    */   }
/*    */   
/*    */   public String getFuncName() {
/* 61 */     return this.funcName;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setFuncName(String paramString) {
/* 66 */     this.funcName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<AuthListParam> getAuthListParams() {
/* 71 */     return this.authListParams;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAuthListParams(List<AuthListParam> paramList) {
/* 76 */     this.authListParams = paramList;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\bean\FuncListParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */