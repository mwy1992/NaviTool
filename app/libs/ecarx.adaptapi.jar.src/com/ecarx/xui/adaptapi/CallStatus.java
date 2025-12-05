/*    */ package com.ecarx.xui.adaptapi;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CallStatus
/*    */ {
/* 20 */   ERROR, FAILURE, NOT_IMPLEMENT, NOT_SUPPORTED, PARAM_ERROR, SUCCEED, TIMEOUT;
/*    */   
/*    */   private static final CallStatus[] $VALUES;
/*    */   
/*    */   static {
/* 25 */     FAILURE = new CallStatus("FAILURE", 1);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     ERROR = new CallStatus("ERROR", 2);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     TIMEOUT = new CallStatus("TIMEOUT", 3);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     NOT_SUPPORTED = new CallStatus("NOT_SUPPORTED", 4);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 45 */     NOT_IMPLEMENT = new CallStatus("NOT_IMPLEMENT", 5);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 50 */     PARAM_ERROR = new CallStatus("PARAM_ERROR", 6);
/*    */     $VALUES = new CallStatus[] { SUCCEED, FAILURE, ERROR, TIMEOUT, NOT_SUPPORTED, NOT_IMPLEMENT, PARAM_ERROR };
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\CallStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */