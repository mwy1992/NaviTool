/*    */ package com.ecarx.xui.adaptapi.tpms;
/*    */ 
/*    */ 
/*    */ public class TireState
/*    */   implements ITireState
/*    */ {
/*    */   private float pressure;
/*    */   private boolean pressureWarning;
/*    */   private boolean quickLeaking;
/*    */   private float temperature;
/*    */   private boolean temperatureWarning;
/*    */   private int tireWarning;
/*    */   
/*    */   TireState() {}
/*    */   
/*    */   public TireState(boolean paramBoolean1, float paramFloat1, float paramFloat2, boolean paramBoolean2, boolean paramBoolean3) {
/* 17 */     this.temperature = paramFloat2;
/* 18 */     this.pressure = paramFloat1;
/* 19 */     this.pressureWarning = paramBoolean2;
/* 20 */     this.quickLeaking = paramBoolean1;
/* 21 */     this.temperatureWarning = paramBoolean3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasPressureWarning() {
/* 27 */     return this.pressureWarning;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isQuickLeaking() {
/* 32 */     return this.quickLeaking;
/*    */   }
/*    */ 
/*    */   
/*    */   public float getTemperature() {
/* 37 */     return this.temperature;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getPressure() {
/* 43 */     return this.pressure;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTireWarning() {
/* 49 */     return this.tireWarning;
/*    */   }
/*    */ 
/*    */   
/*    */   void setTemperature(float paramFloat) {
/* 54 */     this.temperature = paramFloat;
/*    */   }
/*    */   
/*    */   void setPressure(float paramFloat) {
/* 58 */     this.pressure = paramFloat;
/*    */   }
/*    */   
/*    */   void setTemperatureWarning(boolean paramBoolean) {
/* 62 */     this.temperatureWarning = paramBoolean;
/* 63 */     setTireWarning();
/*    */   }
/*    */   
/*    */   private void setTireWarning() {
/* 67 */     this.tireWarning = judgeTireWarning(this.temperatureWarning, this.pressureWarning);
/*    */   }
/*    */   
/*    */   private int judgeTireWarning(boolean paramBoolean1, boolean paramBoolean2) {
/* 71 */     int i = Integer.MIN_VALUE;
/* 72 */     if (!paramBoolean1 && !paramBoolean2) {
/* 73 */       i = 0;
/* 74 */     } else if (paramBoolean1 && paramBoolean2) {
/* 75 */       i = 2;
/* 76 */     } else if (paramBoolean1 || paramBoolean2) {
/* 77 */       i = 1;
/*    */     } 
/* 79 */     return i;
/*    */   }
/*    */   
/*    */   void setPressureWarning(boolean paramBoolean) {
/* 83 */     this.pressureWarning = paramBoolean;
/* 84 */     setTireWarning();
/*    */   }
/*    */   
/*    */   void setQuickLeaking(boolean paramBoolean) {
/* 88 */     this.quickLeaking = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tpms\TireState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */