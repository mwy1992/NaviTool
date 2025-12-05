/*     */ package ecarx.car.hardware.annotation;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class VehSurrndgsVinRecCmdRespTbl
/*     */ {
/*     */   public static final int Capture = 9;
/*     */   public static final int Deletefile = 11;
/*     */   public static final int EnterAVMbrowsemode = 6;
/*     */   public static final int EnterPRSBrowseMode = 8;
/*     */   public static final int Enteremergencybrowsemode = 5;
/*     */   public static final int Enteremergencyrecord = 3;
/*     */   public static final int Entergeneralbrowsemode = 4;
/*     */   public static final int Entergeneralrecord = 1;
/*     */   public static final int Enterpauserecord = 2;
/*     */   public static final int Enterphotobrowsemode = 7;
/*     */   public static final int Exitplay = 17;
/*     */   public static final int FileEdit = 20;
/*     */   public static final int Movetoemergency = 10;
/*     */   public static final int NextPage = 18;
/*     */   public static final int NoResponse = 0;
/*     */   public static final int Pause = 14;
/*     */   public static final int Play = 13;
/*     */   public static final int Playnext = 16;
/*     */   public static final int Playprev = 15;
/*     */   public static final int PrevPage = 19;
/*     */   public static final int Reserved_12 = 12;
/*     */   
/*     */   public static String toString(int paramInt) {
/*  39 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  40 */     switch (paramInt) {
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
/*     */       default:
/* 105 */         return str;
/*     */       case 20:
/*     */         str = "FileEdit";
/*     */       case 19:
/*     */         str = "PrevPage";
/*     */       case 18:
/*     */         str = "NextPage";
/*     */       case 17:
/*     */         str = "Exitplay";
/*     */       case 16:
/*     */         str = "Playnext";
/*     */       case 15:
/*     */         str = "Playprev";
/*     */       case 14:
/*     */         str = "Pause";
/*     */       case 13:
/*     */         str = "Play";
/*     */       case 12:
/*     */         str = "Reserved_12";
/*     */       case 11:
/*     */         str = "Deletefile";
/*     */       case 10:
/*     */         str = "Movetoemergency";
/*     */       case 9:
/*     */         str = "Capture";
/*     */       case 8:
/*     */         str = "EnterPRSBrowseMode";
/*     */       case 7:
/*     */         str = "Enterphotobrowsemode";
/*     */       case 6:
/*     */         str = "EnterAVMbrowsemode";
/*     */       case 5:
/*     */         str = "Enteremergencybrowsemode";
/*     */       case 4:
/*     */         str = "Entergeneralbrowsemode";
/*     */       case 3:
/*     */         str = "Enteremergencyrecord";
/*     */       case 2:
/*     */         str = "Enterpauserecord";
/*     */       case 1:
/*     */         str = "Entergeneralrecord";
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     str = "NoResponse";
/*     */   }
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
/*     */   public static boolean isValid(int paramInt) {
/* 162 */     boolean bool = false;
/*     */     
/* 164 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20)
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
/*     */ 
/*     */ 
/*     */       
/* 185 */       bool = true;
/*     */     }
/*     */     
/* 188 */     return bool;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.SOURCE)
/*     */   public static @interface Enum {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\VehSurrndgsVinRecCmdRespTbl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */