/*     */ package com.ecarx.xui.adaptapi.dvr.ota;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ 
/*     */ public class Ota
/*     */   extends AbsCarSignal
/*     */   implements IOta
/*     */ {
/*     */   public Ota(Context paramContext) {
/*  12 */     super(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initSignalFilter() {
/*  18 */     addSignalFilter(Integer.valueOf(28958));
/*     */     
/*  20 */     addSignalFilter(Integer.valueOf(28957));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onInitCarSignalManager() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onErrorEvent(int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean supportOtaFromIhu() {
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOtaSession requestOta(IOtaCallback paramIOtaCallback) {
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseOtaCallback(IOtaCallback paramIOtaCallback) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean installPackage(IOtaSession paramIOtaSession, String paramString) {
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOtaBaseSoftwareVersionCode() {
/*  97 */     boolean bool1, bool2 = false;
/*     */     
/*     */     try {
/* 100 */       bool1 = this.mCarSignalManager.getDvrSWVer();
/* 101 */     } catch (Exception exception) {
/* 102 */       exception.printStackTrace(); bool1 = bool2;
/*     */     } 
/*     */     
/* 105 */     return bool1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOtaBaseSoftwareVersionName() {
/* 115 */     return String.valueOf(getOtaBaseSoftwareVersionCode());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDvrDspVersionName() {
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDvrMcuVersionName() {
/* 131 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\ota\Ota.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */