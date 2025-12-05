/*    */ package com.ecarx.xui.adaptapi;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FunctionStatus
/*    */ {
/* 12 */   active, error, notactive, notavailable; static { error = new FunctionStatus("error", 3);
/*    */     $VALUES = new FunctionStatus[] { active, notactive, notavailable, error }; }
/*    */ 
/*    */   
/*    */   private static final FunctionStatus[] $VALUES;
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\FunctionStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */