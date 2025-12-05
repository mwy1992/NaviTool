/*    */ package com.ecarx.xui.adaptapi.dvr.forp;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.util.Log;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ 
/*    */ public class DvrForPInfo
/*    */   extends AbsCarSignal implements IDvrInfo {
/*    */   private static final String TAG = "DvrForPInfo";
/*    */   
/*    */   protected DvrForPInfo(Context paramContext) {
/* 12 */     super(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDvrInfoString(int paramInt) {
/* 23 */     Exception exception2 = null; String str2 = null;
/*    */     
/* 25 */     String str1 = str2; try { if (isECarXCarConnected())
/* 26 */         if (paramInt == 1)
/*    */         
/*    */         { 
/* 29 */           str1 = String.valueOf(this.mCarSignalManager.getDvrPartNum()); }
/* 30 */         else { str1 = str2; if (paramInt == 2) {
/*    */             
/* 32 */             int i = this.mCarSignalManager.getDvrSWVer(); str1 = String.valueOf(i);
/*    */           }  }
/*    */           }
/* 35 */     catch (Exception exception1)
/* 36 */     { exception1.printStackTrace(); exception1 = exception2; }
/*    */     
/* 38 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDvrInfoString: infoId: "); stringBuilder.append(paramInt); stringBuilder.append("value: "); stringBuilder.append((String)exception1); Log.d("DvrForPInfo", stringBuilder.toString());
/* 39 */     return (String)exception1;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\DvrForPInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */