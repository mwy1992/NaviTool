/*    */ package ecarx.car;
/*    */ 
/*    */ import android.os.IPowerStatusListener;
/*    */ import android.os.RemoteException;
/*    */ import android.util.Log;
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
/*    */ public class PowerStatus
/*    */   extends IPowerStatusListener.Stub
/*    */ {
/*    */   public static final int AP_FOTA_UPDATE_END = 0;
/*    */   public static final int AP_FOTA_UPDATE_START = 1;
/*    */   public static final int BG_END = 4;
/*    */   public static final int BG_OFF = 0;
/*    */   public static final int BG_ON = 1;
/*    */   public static final int BG_START = 3;
/*    */   public static final int CALLBACK_ID_CSD_STATUS = 6;
/*    */   public static final int CALLBACK_ID_ENTERTAINMENT_MODE = 4;
/*    */   public static final int CALLBACK_ID_INFOTAINMENT_MODE = 0;
/*    */   public static final int CALLBACK_ID_IPLM_STATUS = 7;
/*    */   public static final int CALLBACK_ID_MODEM_STATUS = 1;
/*    */   public static final int CALLBACK_ID_POP_ES = 2;
/*    */   public static final int CALLBACK_ID_POP_REBOOT = 8;
/*    */   public static final int CALLBACK_ID_POP_SD = 3;
/*    */   public static final int CALLBACK_ID_RESET_SETTINGS_RESPONSE = 5;
/*    */   public static final int CSD_STATUS_OFF = 0;
/*    */   public static final int CSD_STATUS_ON = 1;
/*    */   public static final int ENTERTAINMENT_MODE_OFF = 0;
/*    */   public static final int ENTERTAINMENT_MODE_ON = 1;
/*    */   public static final int FG1_END = 1;
/*    */   public static final int FG1_START = 0;
/*    */   public static final int INFOTAINMENT_MODE_OFF = 0;
/*    */   public static final int INFOTAINMENT_MODE_ON = 1;
/*    */   public static final int INFOTAINMENT_MODE_PARTIAL = 2;
/*    */   public static final int INFOTAINMENT_MODE_WELCOME = 3;
/*    */   public static final int INSTALL_APP_STATUS_END = 0;
/*    */   public static final int INSTALL_APP_STATUS_START = 1;
/*    */   public static final int IPLM_STATUS_HIGH = 2;
/*    */   public static final int IPLM_STATUS_LOW = 1;
/*    */   public static final int IPLM_STATUS_NOTHING = 0;
/*    */   public static final int MODEM_STATUS_SLEEP = 0;
/*    */   public static final int MODEM_STATUS_STANDBY = 1;
/*    */   public static final int MODEM_STATUS_WORKING = 2;
/*    */   public static final int POP_ES_HIDE = 0;
/*    */   public static final int POP_ES_SHOW = 1;
/*    */   public static final int POP_SD_HIDE = 0;
/*    */   public static final int POP_SD_SHOW = 1;
/*    */   public static final int RESET_NOTHING = 0;
/*    */   public static final int RESET_SETTINGS_RESPONSE_FACTORY = 1;
/*    */   public static final int RESET_SETTINGS_RESPONSE_FACTORY_AND_VEHICLE = 3;
/*    */   public static final int RESET_SETTINGS_RESPONSE_NORESPONSE = 0;
/*    */   public static final int RESET_SETTINGS_RESPONSE_VEHICLE = 2;
/*    */   public static final int RESET_SETTING_FACTORY = 1;
/*    */   public static final int RESET_SETTING_VEHICLE = 2;
/*    */   public static final int RESTART_COLD = 1;
/*    */   public static final int RESTART_NOTHING = 0;
/*    */   public static final int RESTART_WARM = 2;
/*    */   public static final int STATUS_NG = -1;
/*    */   private static final String TAG = "PowerStatus";
/*    */   
/*    */   public void onStatusChanged(int paramInt1, int paramInt2) throws RemoteException {
/* 89 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onStatusChanged id = "); stringBuilder.append(paramInt1); stringBuilder.append(" status = "); stringBuilder.append(paramInt2); Log.d("PowerStatus", stringBuilder.toString());
/*    */   }
/*    */   
/*    */   public void onDayNightChanged(int paramInt) {}
/*    */   
/*    */   public void onBrightnessModeChanged(int paramInt) {}
/*    */   
/*    */   public void onDayBrightnessChanged(int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void onNightBrightnessChanged(int paramInt1, int paramInt2) {}
/*    */   
/*    */   public void onVehicleBrightnessChanged(int paramInt) {}
/*    */   
/*    */   public void onSettingManagerReady(int paramInt) {}
/*    */   
/*    */   public void onDayNightModeChanged(int paramInt) {}
/*    */   
/*    */   public void onManualDayNightModeChanged(int paramInt) {}
/*    */   
/*    */   public void onAutoDayNightModeChanged(int paramInt) {}
/*    */   
/*    */   public void onCustomDayTimeChanged(float paramFloat) {}
/*    */   
/*    */   public void onCustomNightTimeChanged(float paramFloat) {}
/*    */   
/*    */   public void onScreenSaverStyleChanged(int paramInt) {}
/*    */   
/*    */   public void onScreenSaverNameChanged(String paramString) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\PowerStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */