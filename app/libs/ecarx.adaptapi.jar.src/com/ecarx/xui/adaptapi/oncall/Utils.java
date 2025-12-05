/*     */ package com.ecarx.xui.adaptapi.oncall;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Utils
/*     */ {
/*     */   public static String AAcallStatus2String(int paramInt) {
/*  11 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/*  31 */         return "unknown call status";case 15: return "CALL_STATUS_END";case 12: return "CALL_STATUS_IN_COMING_CALL";case 11: return "CALL_STATUS_OFFHOOK";case 8: return "CALL_STATUS_RINGING";
/*     */       case 7: return "CALL_STATUS_DIAL_FAILED";
/*     */       case 6: return "CALL_STATUS_DIALING";
/*     */       case 4: return "CALL_STATUS_DATA_UPLOADING";
/*     */       case 3: return "QiDong TIMEOUT";
/*  36 */       case 2: break; }  return "QiDong ing..."; } public static String callStatus2String(int paramInt) { switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/*  54 */         return "unknown call status";case 7: return "call ended";case 6: return "call data sending";
/*     */       case 5: return "call connected";
/*     */       case 4: return "call connecting";
/*     */       case 3: return "call failed";
/*     */       case 2: return "call failed reconnecting";
/*     */       case 1: return "call incoming";
/*  60 */       case 0: break; }  return "call start"; } public static String callType2String(int paramInt) { if (paramInt != -2147483647) { switch (paramInt)
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/*  72 */           return "UNKNOW CALL TYPE";
/*     */         case 4: return "BCALL";
/*     */         case 3: return "ICALL";
/*     */         case 2: return "ONCALL";
/*     */         case 1:
/*  77 */           break; }  return "ECALL"; }  return "IDLE"; } public static int tboxCallType2AdaptapiCallType(int paramInt) { int i = -2147483647;
/*  78 */     switch (paramInt) { default: paramInt = i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  89 */         return paramInt;case 4: paramInt = 3; return paramInt;case 3: paramInt = 1; return paramInt;case 2: break; }  paramInt = 4; return paramInt; }
/*     */ 
/*     */   
/*     */   public static int tboxCallStatus2AdaptapiCallStatus(int paramInt) {
/*  93 */     byte b = 15;
/*  94 */     switch (paramInt) { default: paramInt = b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 133 */         return paramInt;case 7: paramInt = 15; return paramInt;case 6: paramInt = 4; return paramInt;case 5: paramInt = 11; return paramInt;case 4: paramInt = 8; return paramInt;case 3: paramInt = 3; return paramInt;case 2: paramInt = 21; return paramInt;case 1: paramInt = 12; return paramInt;case 0: break; }  paramInt = 6; return paramInt;
/*     */   }
/*     */   
/*     */   public static String startCause2String(int paramInt) {
/* 137 */     switch (paramInt)
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 147 */         return "UNKNOW START CAUSE";
/*     */       case 4: return "CALLBACK";
/*     */       case 3: return "EMERGENCY_SITUATIONS";
/*     */       case 2: return "USER_START_FROM_IHU";
/*     */       case 1:
/* 152 */         break; }  return "USER_START_FROM_HARD_KEY"; } public static int changedCallTypeToTcamCallType(int paramInt) { if (paramInt != 1) { switch (paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 160 */           return Integer.MIN_VALUE;
/*     */         case 4:
/*     */           return 2;
/*     */         case 3:
/*     */           break;
/*     */       } 
/*     */       return 4; }
/*     */     
/*     */     return 3; }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\oncall\Utils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */