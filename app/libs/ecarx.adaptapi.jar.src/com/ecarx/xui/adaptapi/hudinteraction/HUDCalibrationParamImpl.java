/*    */ package com.ecarx.xui.adaptapi.hudinteraction;
/*    */ 
/*    */ public class HUDCalibrationParamImpl
/*    */   implements HUDCalibrationParam {
/*  5 */   private int[] mCoordinate = new int[8];
/*  6 */   private float[] mParameter = new float[9];
/*    */ 
/*    */   
/*    */   public float[] getFloatValue() {
/* 10 */     return this.mParameter;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] getIntegerValue() {
/* 15 */     return this.mCoordinate;
/*    */   }
/*    */   
/*    */   public void setCoordinate(int[] paramArrayOfint) {
/* 19 */     System.arraycopy(paramArrayOfint, 0, this.mCoordinate, 0, 8);
/*    */   }
/*    */   public void setParameter(float[] paramArrayOffloat) {
/* 22 */     System.arraycopy(paramArrayOffloat, 0, this.mParameter, 0, 9);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\hudinteraction\HUDCalibrationParamImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */