/*    */ package com.ecarx.xui.adaptapi.tbox.tboxmessager;
/*    */ 
/*    */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
/*    */ 
/*    */ public class NavilnfoFromTBoxImp
/*    */   implements INaviInfoFromTBox {
/*  7 */   private String messageTitle = "N/A";
/*  8 */   private String messageLatitude = "N/A";
/*  9 */   private String messageLongitude = "N/A";
/*    */ 
/*    */   
/*    */   public void setMessageTitle(String paramString) {
/* 13 */     this.messageTitle = paramString;
/*    */   }
/*    */   
/*    */   public void setMessageLatitude(String paramString) {
/* 17 */     this.messageLatitude = paramString;
/*    */   }
/*    */   
/*    */   public void setMessageLongitude(String paramString) {
/* 21 */     this.messageLongitude = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessageTitle() {
/* 31 */     return this.messageTitle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessageId() {
/* 41 */     return ProperUtils.getPropertyValue("INavilnfoFromTBox_MessageId", String.class).toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSender() {
/* 51 */     return ProperUtils.getPropertyValue("INavilnfoFromTBox_Sender", String.class).toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLat() {
/* 61 */     return this.messageLatitude;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLon() {
/* 71 */     return this.messageLongitude;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\tboxmessager\NavilnfoFromTBoxImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */