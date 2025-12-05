/*     */ package android.car;
/*     */ 
/*     */ import android.car.hardware.CarPropertyValue;
/*     */ import android.car.hardware.property.CarPropertyManager;
/*     */ import android.os.IBinder;
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
/*     */ public final class CarInfoManager
/*     */   implements CarManagerBase
/*     */ {
/*     */   public static final int BASIC_INFO_EV_BATTERY_CAPACITY = 291504390;
/*     */   public static final int BASIC_INFO_EV_CONNECTOR_TYPES = 289472775;
/*     */   public static final int BASIC_INFO_FUEL_CAPACITY = 291504388;
/*     */   public static final int BASIC_INFO_FUEL_TYPES = 289472773;
/*     */   public static final int BASIC_INFO_KEY_MANUFACTURER = 286261505;
/*     */   public static final int BASIC_INFO_KEY_MODEL = 286261506;
/*     */   public static final int BASIC_INFO_KEY_MODEL_YEAR = 289407235;
/*     */   public static final String BASIC_INFO_KEY_VEHICLE_ID = "android.car.vehicle-id";
/*     */   private static final boolean DBG = false;
/*     */   public static final String INFO_KEY_PRODUCT_CONFIGURATION = "android.car.product-config";
/*     */   private static final String TAG = "CarInfoManager";
/*     */   private final CarPropertyManager mCarPropertyMgr;
/*     */   
/*     */   public String getManufacturer() throws CarNotConnectedException {
/* 120 */     CarPropertyValue carPropertyValue = this.mCarPropertyMgr.getProperty(String.class, 286261505, 0);
/*     */     
/* 122 */     if (carPropertyValue != null) { String str = (String)carPropertyValue.getValue(); } else { carPropertyValue = null; }  return (String)carPropertyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModel() throws CarNotConnectedException {
/* 132 */     CarPropertyValue carPropertyValue = this.mCarPropertyMgr.getProperty(String.class, 286261506, 0);
/*     */     
/* 134 */     if (carPropertyValue != null) { String str = (String)carPropertyValue.getValue(); } else { carPropertyValue = null; }  return (String)carPropertyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModelYear() throws CarNotConnectedException {
/* 142 */     CarPropertyValue carPropertyValue = this.mCarPropertyMgr.getProperty(String.class, 289407235, 0);
/*     */     
/* 144 */     if (carPropertyValue != null) { String str = (String)carPropertyValue.getValue(); } else { carPropertyValue = null; }  return (String)carPropertyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVehicleId() throws CarNotConnectedException {
/* 154 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFuelCapacity() throws CarNotConnectedException {
/*     */     float f;
/* 162 */     CarPropertyValue carPropertyValue = this.mCarPropertyMgr.getProperty(Float.class, 291504388, 0);
/*     */     
/* 164 */     if (carPropertyValue != null) { f = ((Float)carPropertyValue.getValue()).floatValue(); } else { f = 0.0F; }  return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getFuelTypes() throws CarNotConnectedException {
/* 172 */     return this.mCarPropertyMgr.getIntArrayProperty(289472773, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getEvBatteryCapacity() throws CarNotConnectedException {
/*     */     float f;
/* 180 */     CarPropertyValue carPropertyValue = this.mCarPropertyMgr.getProperty(Float.class, 291504390, 0);
/*     */     
/* 182 */     if (carPropertyValue != null) { f = ((Float)carPropertyValue.getValue()).floatValue(); } else { f = 0.0F; }  return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getEvConnectorTypes() throws CarNotConnectedException {
/* 190 */     return this.mCarPropertyMgr.getIntArrayProperty(289472775, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   CarInfoManager(IBinder paramIBinder) {
/* 195 */     this.mCarPropertyMgr = new CarPropertyManager(paramIBinder, null, false, "CarInfoManager");
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 200 */     this.mCarPropertyMgr.onCarDisconnected();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\CarInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */