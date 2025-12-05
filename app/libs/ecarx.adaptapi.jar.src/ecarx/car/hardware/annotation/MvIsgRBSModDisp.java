/*    */ package ecarx.car.hardware.annotation;
/*    */ 
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MvIsgRBSModDisp
/*    */ {
/*    */   public static final int EMDrivingAndICEDriving = 2;
/*    */   public static final int EMGenerating = 4;
/*    */   public static final int EMGeneratingAndICEDrivingAndClutchOpen = 6;
/*    */   public static final int EMGeneratingAndICEDrivingClutchClose = 3;
/*    */   public static final int EMOffAndOnlyICEDriving = 1;
/*    */   public static final int NoDisplay = 0;
/*    */   public static final int OnlyEMDriving = 5;
/*    */   public static final int Sailing = 7;
/*    */   
/*    */   public static String toString(int paramInt) {
/* 26 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/* 27 */     switch (paramInt) {
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 53 */         return str;
/*    */       case 7:
/*    */         str = "Sailing";
/*    */       case 6:
/*    */         str = "EMGeneratingAndICEDrivingAndClutchOpen";
/*    */       case 5:
/*    */         str = "OnlyEMDriving";
/*    */       case 4:
/*    */         str = "EMGenerating";
/*    */       case 3:
/*    */         str = "EMGeneratingAndICEDrivingClutchClose";
/*    */       case 2:
/*    */         str = "EMDrivingAndICEDriving";
/*    */       case 1:
/*    */         str = "EMOffAndOnlyICEDriving";
/*    */       case 0:
/*    */         break;
/*    */     } 
/*    */     str = "NoDisplay";
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
/*    */   
/*    */   public static boolean isValid(int paramInt) {
/* 84 */     boolean bool = false;
/*    */     
/* 86 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 94 */       bool = true;
/*    */     }
/*    */     
/* 97 */     return bool;
/*    */   }
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   public static @interface Enum {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\MvIsgRBSModDisp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */