/*    */ package com.ecarx.xui.adaptapi.navigation.dr;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrFeedbackImpl
/*    */   implements IDrFeedback
/*    */ {
/*    */   public DrFeedbackImpl(Context paramContext) {}
/*    */   
/*    */   public int getCount() {
/* 20 */     return ((Integer)ProperUtils.getPropertyValue("IDrFeedback_Count", int.class)).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getTicktime() {
/* 30 */     return ((Integer)ProperUtils.getPropertyValue("IDrFeedback_Ticktime", long.class)).intValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double toRoadStartDist() {
/* 40 */     return ((Double)ProperUtils.getPropertyValue("IDrFeedback_toRoadStartDist", double.class)).doubleValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double toRoadEndDist() {
/* 50 */     return ((Double)ProperUtils.getPropertyValue("IDrFeedback_toRoadEndDist", double.class)).doubleValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IDrFeedback.LocFeedbackNode[] getFeedbackNode() {
/* 60 */     return new IDrFeedback.LocFeedbackNode[0];
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\DrFeedbackImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */