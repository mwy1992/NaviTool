/*    */ package android.car;
/*    */ 
/*    */ import android.car.settings.CarSettings;
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
/*    */ public final class CarApiUtil
/*    */ {
/*    */   public static final String CAR_NOT_CONNECTED_EXCEPTION_MSG = "CarNotConnected";
/*    */   
/*    */   public static void checkCarNotConnectedExceptionFromCarService(IllegalStateException paramIllegalStateException) throws CarNotConnectedException {
/* 46 */     if (paramIllegalStateException.getMessage().equals("CarNotConnected")) {
/* 47 */       throw new CarNotConnectedException();
/*    */     }
/* 49 */     throw paramIllegalStateException;
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
/*    */   
/*    */   public static int[] decodeGarageTimeSetting(String paramString) {
/* 63 */     int[] arrayOfInt = CarSettings.DEFAULT_GARAGE_MODE_WAKE_UP_TIME;
/* 64 */     if (paramString == null) {
/* 65 */       return arrayOfInt;
/*    */     }
/*    */     
/* 68 */     String[] arrayOfString = paramString.split(":");
/* 69 */     if (arrayOfString.length != 2) {
/* 70 */       return arrayOfInt;
/*    */     }
/*    */     try {
/* 73 */       arrayOfInt[0] = Integer.valueOf(arrayOfString[0]).intValue();
/* 74 */       arrayOfInt[1] = Integer.valueOf(arrayOfString[1]).intValue();
/*    */ 
/*    */ 
/*    */       
/* 78 */       if (arrayOfInt[0] >= 0 && arrayOfInt[0] <= 23 && arrayOfInt[1] >= 0 && arrayOfInt[1] <= 59) {
/* 79 */         return arrayOfInt;
/*    */       }
/* 81 */       return CarSettings.DEFAULT_GARAGE_MODE_WAKE_UP_TIME;
/*    */     } catch (NumberFormatException numberFormatException) {
/*    */       return CarSettings.DEFAULT_GARAGE_MODE_WAKE_UP_TIME;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String encodeGarageTimeSetting(int paramInt1, int paramInt2) {
/* 91 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramInt1); stringBuilder.append(":"); stringBuilder.append(paramInt2); return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\CarApiUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */