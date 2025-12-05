/*    */ package com.ecarx.xui.adaptapi.peripherals;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.peripherals.wear.IIntelligentKey;
/*    */ import com.ecarx.xui.adaptapi.peripherals.wear.IntelligentKeyImp;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PeripheralsImp
/*    */   extends Peripherals
/*    */ {
/*    */   private final Context mContext;
/*    */   private IntelligentKeyImp mIntelligentKey;
/*    */   
/*    */   private PeripheralsImp(Context paramContext) {
/* 17 */     this.mContext = paramContext;
/* 18 */     this.mIntelligentKey = new IntelligentKeyImp(paramContext);
/*    */   }
/*    */   
/*    */   public static Peripherals create(Context paramContext) {
/* 22 */     PeripheralsImp peripheralsImp = null;
/*    */     
/* 24 */     if (paramContext != null) {
/* 25 */       peripheralsImp = new PeripheralsImp(paramContext);
/*    */     }
/*    */     
/* 28 */     return peripheralsImp;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isIntelligentKeySupport() {
/* 40 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IIntelligentKey getIntelligentKey() {
/* 49 */     return (IIntelligentKey)this.mIntelligentKey;
/*    */   }
/*    */   
/*    */   public void setRemoteAction(int paramInt) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\peripherals\PeripheralsImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */