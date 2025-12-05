/*     */ package com.ecarx.xui.adaptapi.hudinteraction;
/*     */ 
/*     */ public class ADASLaneSyncInfo
/*     */   implements IADASLaneSyncInfo
/*     */ {
/*   6 */   private LaneInfoData infoData = new LaneInfoData();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getLeftUpperLaneCoordinate() {
/*  14 */     return new double[] { this.infoData.AsyLineLePah2PrmA, this.infoData.AsyLineLePah2PrmB, this.infoData.AsyLineLePah2PrmC, this.infoData.AsyLineLePah2PrmD };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getLeftLowerLaneCoordinate() {
/*  25 */     return new double[] { this.infoData.AsyLineLePahPrmA, this.infoData.AsyLineLePahPrmB, this.infoData.AsyLineLePahPrmC, this.infoData.AsyLineLePahPrmD };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getRightUpperLaneCoordinate() {
/*  36 */     return new double[] { this.infoData.AsyLineRiPah2PrmA, this.infoData.AsyLineRiPah2PrmB, this.infoData.AsyLineRiPah2PrmC, this.infoData.AsyLineRiPah2PrmD };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getRightLowerLaneCoordinate() {
/*  47 */     return new double[] { this.infoData.AsyLineRiPahPrmA, this.infoData.AsyLineRiPahPrmB, this.infoData.AsyLineRiPahPrmC, this.infoData.AsyLineRiPahPrmD };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVehiclePressureLineStatus() {
/*  58 */     return this.infoData.LaneChgWarnSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWarningRightStatus() {
/*  68 */     return this.infoData.AsyLineRiColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWarningLeftStatus() {
/*  79 */     return this.infoData.AsyLineLeColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getLeftLaneLeftDetectStartEnd() {
/*  87 */     return new double[] { this.infoData.AsyLeFirstStrt, this.infoData.AsyLeFirstEnd };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getLeftLaneRightDetectStartEnd() {
/*  95 */     return new double[] { this.infoData.AsyLeSecStrt, this.infoData.AsyLeSecEnd };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getRightLaneLeftDetectStartEnd() {
/* 103 */     return new double[] { this.infoData.AsyRiFirstStrt, this.infoData.AsyRiFirstEnd };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getRightLaneRightDetectStartEnd() {
/* 111 */     return new double[] { this.infoData.AsyRiSecStrt, this.infoData.AsyRiSecEnd };
/*     */   }
/*     */ 
/*     */   
/*     */   public static class LaneInfoData
/*     */   {
/*     */     double AsyLeFirstEnd;
/*     */     
/*     */     double AsyLeFirstStrt;
/*     */     
/*     */     double AsyLeSecEnd;
/*     */     
/*     */     double AsyLeSecStrt;
/*     */     
/*     */     int AsyLineLeColor;
/*     */     
/*     */     double AsyLineLePah2PrmA;
/*     */     
/*     */     double AsyLineLePah2PrmB;
/*     */     
/*     */     double AsyLineLePah2PrmC;
/*     */     
/*     */     double AsyLineLePah2PrmD;
/*     */     
/*     */     double AsyLineLePahPrmA;
/*     */     double AsyLineLePahPrmB;
/*     */     double AsyLineLePahPrmC;
/*     */     double AsyLineLePahPrmD;
/*     */     int AsyLineRiColor;
/*     */     double AsyLineRiPah2PrmA;
/*     */     double AsyLineRiPah2PrmB;
/*     */     double AsyLineRiPah2PrmC;
/*     */     double AsyLineRiPah2PrmD;
/*     */     double AsyLineRiPahPrmA;
/*     */     double AsyLineRiPahPrmB;
/*     */     double AsyLineRiPahPrmC;
/*     */     double AsyLineRiPahPrmD;
/*     */     double AsyRiFirstEnd;
/*     */     double AsyRiFirstStrt;
/*     */     double AsyRiSecEnd;
/*     */     double AsyRiSecStrt;
/*     */     int LaneChgWarnSts;
/*     */   }
/*     */   
/*     */   public void setInfoData(LaneInfoData paramLaneInfoData) {
/* 156 */     this.infoData.AsyLineLePahPrmA = paramLaneInfoData.AsyLineLePahPrmA;
/* 157 */     this.infoData.AsyLineLePahPrmB = paramLaneInfoData.AsyLineLePahPrmB;
/* 158 */     this.infoData.AsyLineLePahPrmC = paramLaneInfoData.AsyLineLePahPrmC;
/* 159 */     this.infoData.AsyLineLePahPrmD = paramLaneInfoData.AsyLineLePahPrmD;
/* 160 */     this.infoData.AsyLineLePah2PrmA = paramLaneInfoData.AsyLineLePah2PrmA;
/* 161 */     this.infoData.AsyLineLePah2PrmB = paramLaneInfoData.AsyLineLePah2PrmB;
/* 162 */     this.infoData.AsyLineLePah2PrmC = paramLaneInfoData.AsyLineLePah2PrmC;
/* 163 */     this.infoData.AsyLineLePah2PrmD = paramLaneInfoData.AsyLineLePah2PrmD;
/* 164 */     this.infoData.AsyLineRiPahPrmA = paramLaneInfoData.AsyLineRiPahPrmA;
/* 165 */     this.infoData.AsyLineRiPahPrmB = paramLaneInfoData.AsyLineRiPahPrmB;
/* 166 */     this.infoData.AsyLineRiPahPrmC = paramLaneInfoData.AsyLineRiPahPrmC;
/* 167 */     this.infoData.AsyLineRiPahPrmD = paramLaneInfoData.AsyLineRiPahPrmD;
/* 168 */     this.infoData.AsyLineRiPah2PrmA = paramLaneInfoData.AsyLineRiPah2PrmA;
/* 169 */     this.infoData.AsyLineRiPah2PrmB = paramLaneInfoData.AsyLineRiPah2PrmB;
/* 170 */     this.infoData.AsyLineRiPah2PrmC = paramLaneInfoData.AsyLineRiPah2PrmC;
/* 171 */     this.infoData.AsyLineRiPah2PrmD = paramLaneInfoData.AsyLineRiPah2PrmD;
/* 172 */     this.infoData.AsyLineRiColor = paramLaneInfoData.AsyLineRiColor;
/* 173 */     this.infoData.AsyLineLeColor = paramLaneInfoData.AsyLineLeColor;
/* 174 */     this.infoData.AsyLeFirstEnd = paramLaneInfoData.AsyLeFirstEnd;
/* 175 */     this.infoData.AsyLeFirstStrt = paramLaneInfoData.AsyLeFirstStrt;
/* 176 */     this.infoData.AsyLeSecEnd = paramLaneInfoData.AsyLeSecEnd;
/* 177 */     this.infoData.AsyLeSecStrt = paramLaneInfoData.AsyLeSecStrt;
/* 178 */     this.infoData.AsyRiFirstEnd = paramLaneInfoData.AsyRiFirstEnd;
/* 179 */     this.infoData.AsyRiFirstStrt = paramLaneInfoData.AsyRiFirstStrt;
/* 180 */     this.infoData.AsyRiSecEnd = paramLaneInfoData.AsyRiSecEnd;
/* 181 */     this.infoData.AsyRiSecStrt = paramLaneInfoData.AsyRiSecStrt;
/*     */   }
/*     */   
/*     */   public LaneInfoData getData() {
/* 185 */     return this.infoData;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\ADASLaneSyncInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */