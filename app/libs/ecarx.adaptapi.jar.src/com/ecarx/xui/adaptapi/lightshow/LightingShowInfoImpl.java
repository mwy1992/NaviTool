/*     */ package com.ecarx.xui.adaptapi.lightshow;
/*     */ 
/*     */ import com.ecarx.xui.adaptapi.lighting.ILightingShow;
/*     */ 
/*     */ public class LightingShowInfoImpl
/*     */   implements ILightingShow.ILightingShowInfo {
/*   7 */   private String uuid = "N/A";
/*   8 */   private int showType = 0;
/*   9 */   private int showMode = 0;
/*  10 */   private int payType = 0;
/*  11 */   private String name = "N/A";
/*  12 */   private String path = "N/A";
/*  13 */   private String description = "N/A";
/*     */   
/*     */   public void clearLightShowInfo() {
/*  16 */     this.uuid = "N/A";
/*  17 */     this.showType = 0;
/*  18 */     this.showMode = 0;
/*  19 */     this.payType = 0;
/*  20 */     this.name = "N/A";
/*  21 */     this.path = "N/A";
/*  22 */     this.description = "N/A";
/*     */   }
/*     */   
/*     */   public void setUuid(String paramString) {
/*  26 */     this.uuid = paramString;
/*     */   }
/*     */   
/*     */   public void setShowType(int paramInt) {
/*  30 */     this.showType = paramInt;
/*     */   }
/*     */   
/*     */   public void setShowMode(int paramInt) {
/*  34 */     this.showMode = paramInt;
/*     */   }
/*     */   
/*     */   public void setPayType(int paramInt) {
/*  38 */     this.payType = paramInt;
/*     */   }
/*     */   
/*     */   public void setName(String paramString) {
/*  42 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public void setPath(String paramString) {
/*  46 */     this.path = paramString;
/*     */   }
/*     */   
/*     */   public void setDescription(String paramString) {
/*  50 */     this.description = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUUID() {
/*  58 */     return this.uuid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShowType() {
/*  67 */     return this.showType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShowMode() {
/*  76 */     return this.showMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPayType() {
/*  84 */     return this.payType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  92 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 100 */     return this.path;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 108 */     return this.description;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\lightshow\LightingShowInfoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */