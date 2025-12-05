package com.ecarx.xui.adaptapi.car.hev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;

public interface ISuperHybrid {
  public static final int HYBRID_FUNC_AUTO_MODE_LIMITED_TIPS = 826280704;
  
  public static final int HYBRID_FUNC_BOOK_CHARGING = 826278912;
  
  public static final int HYBRID_FUNC_CHARGED_QUANTITY_INFO = 826279680;
  
  public static final int HYBRID_FUNC_CHARGE_IMMEDIATELY = 826278144;
  
  public static final int HYBRID_FUNC_CHARGING_DURATION_INFO = 826279936;
  
  public static final int HYBRID_FUNC_CHARGING_POWER_INFO = 826279424;
  
  public static final int HYBRID_FUNC_CHARGING_SPEED = 826279168;
  
  public static final int HYBRID_FUNC_DISCHARGING_DURATION_INFO = 826280448;
  
  public static final int HYBRID_FUNC_DISCHARGING_POWER_INFO = 826280192;
  
  public static final int HYBRID_FUNC_DISTANCE_PROTECTION_SWITCH = 827326720;
  
  public static final int HYBRID_FUNC_DRIVE_MODE_MENU = 825230848;
  
  public static final int HYBRID_FUNC_PARKING_POWER_GENERATION = 826278400;
  
  public static final int HYBRID_FUNC_PARKING_POWER_GENERATION_FAIL_TIPS = 826278656;
  
  public static final int HYBRID_FUNC_PT_EVMODE = 823132418;
  
  public static final int HYBRID_FUNC_PT_HEVMOD = 823132419;
  
  public static final int HYBRID_FUNC_PT_MOD = 823132416;
  
  public static final int HYBRID_FUNC_PT_MOD_LK = 823132672;
  
  public static final int HYBRID_FUNC_PT_NOREQUEST = 823132417;
  
  public static final int HYBRID_FUNC_PT_PLUSMODE = 823132420;
  
  public static final int HYBRID_FUNC_STEPLESS_BAR_POSN_SETTING = 825229568;
  
  public static final int HYBRID_FUNC_STEPLESS_BAR_POSN_SETTING_MAX = 97;
  
  public static final int HYBRID_FUNC_STEPLESS_BAR_POSN_SETTING_MIN = 3;
  
  public static final int HYBRID_FUNC_SUS_HEIGHT_HIGH_LEVEL1 = 825230080;
  
  public static final int HYBRID_FUNC_SUS_HEIGHT_HIGH_LEVEL2 = 825229824;
  
  public static final int HYBRID_FUNC_SUS_HEIGHT_LOW_LEVEL1 = 825230592;
  
  public static final int HYBRID_FUNC_SUS_HEIGHT_NORMAL = 825230336;
  
  boolean addSuperHybridListener(ISuperHybridListener paramISuperHybridListener);
  
  boolean removeSuperHybridListener(ISuperHybridListener paramISuperHybridListener);
  
  boolean requestRemoteBookChargingTime();
  
  boolean setBookChargingTime(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt1, int paramInt2, int paramInt3);
  
  public static interface ISuperHybridListener {
    void onBookChargingChanged(Calendar param1Calendar1, Calendar param1Calendar2, int param1Int1, int param1Int2, int param1Int3);
    
    void onBookChargingChangedError();
    
    void onSetBookChargingResult(int param1Int);
    
    void onSetBookChargingResultError();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PowerTrainMode {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SuperHybridFunction {}
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\hev\ISuperHybrid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */