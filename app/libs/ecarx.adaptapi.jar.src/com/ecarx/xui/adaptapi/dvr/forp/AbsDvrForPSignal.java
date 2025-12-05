/*    */ package com.ecarx.xui.adaptapi.dvr.forp;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.util.Log;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import com.ecarx.xui.adaptapi.dvr.AbsDvrSignal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbsDvrForPSignal
/*    */   extends AbsDvrSignal
/*    */ {
/*    */   private static final String TAG = "AbsDvrForPSignal";
/*    */   
/*    */   protected AbsDvrForPSignal(Context paramContext) {
/* 21 */     super(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected FunctionStatus getDVRFunctionStatus() {
/* 30 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/*    */     
/* 32 */     FunctionStatus functionStatus1 = functionStatus2, functionStatus3 = functionStatus2; try { if (isECarXCarConnected()) { functionStatus1 = functionStatus2; functionStatus3 = functionStatus2; if (this.mCarSignalManager.getcarconfig483() == 2) {
/* 33 */           functionStatus3 = functionStatus2; int j = this.mCarSignalManager.getVehModMngtGlbSafe1CarModSts1();
/* 34 */           functionStatus3 = functionStatus2; int i = this.mCarSignalManager.getVehModMngtGlbSafe1UsgModSts();
/*    */           
/* 36 */           if ((j == 3 || j == 0) && (i == 2 || i == 13)) {
/*    */ 
/*    */             
/* 39 */             functionStatus3 = functionStatus2; functionStatus2 = FunctionStatus.active;
/*    */           } else {
/* 41 */             functionStatus3 = functionStatus2; functionStatus2 = FunctionStatus.notactive;
/*    */           } 
/*    */           
/* 44 */           functionStatus1 = functionStatus2; functionStatus3 = functionStatus2; if (this.mCarSignalManager.getVehSurrndgsVisnRecSts() == 15)
/* 45 */           { functionStatus3 = functionStatus2; functionStatus1 = FunctionStatus.error; } 
/*    */         }  }
/*    */        }
/* 48 */     catch (Exception exception)
/* 49 */     { exception.printStackTrace(); functionStatus1 = functionStatus3; }
/*    */ 
/*    */     
/* 52 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DVRFunctionStatus = "); stringBuilder.append(functionStatus1.toString()); Log.i("AbsDvrForPSignal", stringBuilder.toString());
/* 53 */     return functionStatus1;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\AbsDvrForPSignal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */