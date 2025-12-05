/*    */ package com.ecarx.xui.adaptapi.car.diagnostics;
/*    */ 
/*    */ import android.os.SystemProperties;
/*    */ import ecarx.os.LocalConfig;
/*    */ 
/*    */ public class PartInfos
/*    */   implements IPartInfos {
/*    */   public String getPartInfoString(int paramInt) {
/*    */     String str2;
/*    */     StringBuilder stringBuilder1;
/*    */     String str1, str4;
/*    */     StringBuilder stringBuilder3;
/*    */     String str3;
/* 14 */     StringBuilder stringBuilder2 = null;
/*    */     
/* 16 */     switch (paramInt) {
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
/*    */       case 6:
/* 30 */         str4 = (String)LocalConfig.get().getValue(LocalConfig.KEY.LC_PartNumber_Geely, "");
/* 31 */         stringBuilder2 = new StringBuilder(); stringBuilder2.append(str4); stringBuilder2.append("\n"); str2 = stringBuilder2.toString();
/* 32 */         stringBuilder3 = new StringBuilder(); stringBuilder3.append(str2); stringBuilder3.append((String)LocalConfig.get().getValue(LocalConfig.KEY.LC_PartNumber_Volvo, "")); str2 = stringBuilder3.toString(); break;
/*    */       case 4:
/*    */         str3 = SystemProperties.get("ro.pn.swl2.geely", ""); stringBuilder1 = new StringBuilder(); stringBuilder1.append(str3); stringBuilder1.append("\n");
/*    */         stringBuilder1.append(SystemProperties.get("ro.pn.swl2.volvo", ""));
/*    */         str1 = stringBuilder1.toString();
/*    */         break;
/*    */     } 
/* 39 */     return str1;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\PartInfos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */