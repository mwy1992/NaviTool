/*     */ package com.ecarx.xui.adaptapi.hudinteraction;
/*     */ 
/*     */ 
/*     */ public class ADASDrivingAidSyncInfo
/*     */   implements IADASDrivingAidSyncInfo
/*     */ {
/*   7 */   private InfoData mData = new InfoData();
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
/*     */   public int getACCStatus() {
/*  20 */     return this.mData.AsyALgtIndcr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLateralXDistance() {
/*  28 */     return this.mData.ObjFrnt1DstLatOfObjFrnt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLateralZDistance() {
/*  36 */     return this.mData.ObjFrnt1DstLgtOfObjFrnt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFrontObjectDirection() {
/*  47 */     return this.mData.ObjFrnt1HdDirOfObjFrnt1;
/*     */   }
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
/*     */   public int getFrontObjectType() {
/*  63 */     return this.mData.ObjFrnt1TypOfObjFrnt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWarningStatus() {
/*  74 */     return this.mData.CllsnFwdWarn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAebStatus() {
/*  85 */     return this.mData.CllsnAidPost;
/*     */   }
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
/*     */   public int getFrontType() {
/* 103 */     return this.mData.frontType;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class InfoData
/*     */   {
/*     */     int AsyALgtIndcr;
/*     */     int CllsnAidPost;
/*     */     int CllsnFwdWarn;
/*     */     double ObjFrnt1DstLatOfObjFrnt1;
/*     */     double ObjFrnt1DstLgtOfObjFrnt1;
/*     */     int ObjFrnt1HdDirOfObjFrnt1;
/*     */     int ObjFrnt1TypOfObjFrnt1;
/*     */     int frontType;
/*     */   }
/*     */   
/*     */   public void setInfoData(InfoData paramInfoData) {
/* 120 */     this.mData.AsyALgtIndcr = paramInfoData.AsyALgtIndcr;
/* 121 */     this.mData.ObjFrnt1DstLatOfObjFrnt1 = paramInfoData.ObjFrnt1DstLatOfObjFrnt1;
/* 122 */     this.mData.ObjFrnt1DstLgtOfObjFrnt1 = paramInfoData.ObjFrnt1DstLgtOfObjFrnt1;
/* 123 */     this.mData.ObjFrnt1HdDirOfObjFrnt1 = paramInfoData.ObjFrnt1HdDirOfObjFrnt1;
/* 124 */     this.mData.ObjFrnt1TypOfObjFrnt1 = paramInfoData.ObjFrnt1TypOfObjFrnt1;
/* 125 */     this.mData.CllsnFwdWarn = paramInfoData.CllsnFwdWarn;
/* 126 */     this.mData.CllsnAidPost = paramInfoData.CllsnAidPost;
/* 127 */     this.mData.frontType = paramInfoData.frontType;
/*     */   }
/*     */   
/*     */   public InfoData getmData() {
/* 131 */     return this.mData;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\ADASDrivingAidSyncInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */