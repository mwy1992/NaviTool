package com.ecarx.xui.adaptapi.navigation.dr;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IDrAutoByFwk {
  public static final int EDR_STATUS_EDR = 1;
  
  public static final int EDR_STATUS_EDRGNSS = 2;
  
  public static final int EDR_STATUS_EGNSS = 0;
  
  public static final int EMOVE_STATUS_BACK = 2;
  
  public static final int EMOVE_STATUS_INVALID = 0;
  
  public static final int EMOVE_STATUS_NORMAL = 1;
  
  public static final int EMOVE_STATUS_STILL = 6;
  
  public static final int EMOVE_STATUS_TURN_LEFT = 3;
  
  public static final int EMOVE_STATUS_TURN_RIGHR = 4;
  
  public static final int EMOVE_STATUS_UTURN = 5;
  
  void registerListener(IDrPosListener paramIDrPosListener);
  
  void unregisterListener(IDrPosListener paramIDrPosListener);
  
  void updateFeedback(IDrPos paramIDrPos, IDrFeedback paramIDrFeedback);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EDrStatus {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EMoveStatus {}
  
  public static interface IDrPos {
    float getCourse();
    
    float getCourseAcc();
    
    int getDRStatus();
    
    float getDeltaAlt();
    
    float getDeltaAltAcc();
    
    String getEW();
    
    String getGPSStatus();
    
    float getHdop();
    
    double getLat();
    
    double getLon();
    
    double getMoveDist();
    
    int getMoveStatus();
    
    String getNS();
    
    float getPosAcc();
    
    int getSatNum();
    
    float getSlopeAcc();
    
    float getSlopeValue();
    
    float getSpeed();
    
    float getSpeedAcc();
    
    long getTicktime();
    
    long getTime();
    
    boolean isDeltaAltAccValid();
    
    boolean isDeltaAltValid();
    
    boolean isMoveDistValid();
    
    boolean isSlopeAccValid();
    
    boolean isSlopeValueValid();
  }
  
  public static interface IDrPosListener {
    void onDrPosChanged(IDrAutoByFwk.IDrPos param1IDrPos);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\navigation\dr\IDrAutoByFwk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */