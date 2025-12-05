/*     */ package com.ecarx.xui.adaptapi.device;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Build;
/*     */ import android.os.SystemProperties;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import android.util.SparseArray;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import com.ecarx.xui.adaptapi.device.ads.Advertise;
/*     */ import com.ecarx.xui.adaptapi.device.ads.IAdvertise;
/*     */ import com.ecarx.xui.adaptapi.device.daynigntmode.DayNightMode;
/*     */ import com.ecarx.xui.adaptapi.device.daynigntmode.IDayNightMode;
/*     */ import com.ecarx.xui.adaptapi.device.ext.BtExtension;
/*     */ import com.ecarx.xui.adaptapi.device.ext.IBtExtension;
/*     */ import com.ecarx.xui.adaptapi.device.ext.ISystemMode;
/*     */ import com.ecarx.xui.adaptapi.device.ext.PowerManager;
/*     */ import com.ecarx.xui.adaptapi.device.log.DeviceLog;
/*     */ import com.ecarx.xui.adaptapi.device.log.IDeviceLog;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import ecarx.power.BrightnessManager;
/*     */ import ecarx.util.Utils;
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
/*     */ public class DeviceImp
/*     */   extends Device
/*     */   implements IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*     */   private static final int MAX_BRIGHTNESS = 15;
/*     */   private static final int MIN_BRIGHTNESS = 0;
/*     */   private static final String TAG = "DeviceImpl";
/*  46 */   private static final SparseArray<String> mVehicleTypeMap = new SparseArray(); private IAdvertise mAdvertise; static {
/*  47 */     mVehicleTypeMap.put(1, "L541");
/*  48 */     mVehicleTypeMap.put(2, "V542 V90");
/*  49 */     mVehicleTypeMap.put(3, "V543 V90CC");
/*  50 */     mVehicleTypeMap.put(4, "V526");
/*  51 */     mVehicleTypeMap.put(5, "V426");
/*  52 */     mVehicleTypeMap.put(6, "V541 S90");
/*  53 */     mVehicleTypeMap.put(7, "V316");
/*  54 */     mVehicleTypeMap.put(8, "V320");
/*  55 */     mVehicleTypeMap.put(9, "V323");
/*  56 */     mVehicleTypeMap.put(10, "V431");
/*  57 */     mVehicleTypeMap.put(11, "V432");
/*  58 */     mVehicleTypeMap.put(12, "L431");
/*  59 */     mVehicleTypeMap.put(13, "V433");
/*  60 */     mVehicleTypeMap.put(14, "P514");
/*  61 */     mVehicleTypeMap.put(15, "V331");
/*  62 */     mVehicleTypeMap.put(16, "V317");
/*  63 */     mVehicleTypeMap.put(128, "CX11");
/*  64 */     mVehicleTypeMap.put(129, "CS11");
/*  65 */     mVehicleTypeMap.put(130, "CH11");
/*  66 */     mVehicleTypeMap.put(131, "CC11");
/*  67 */     mVehicleTypeMap.put(132, "CS12");
/*  68 */     mVehicleTypeMap.put(133, "DCY11");
/*  69 */     mVehicleTypeMap.put(134, "DX11");
/*  70 */     mVehicleTypeMap.put(135, "FX11");
/*  71 */     mVehicleTypeMap.put(138, "LAMBDA");
/*  72 */     mVehicleTypeMap.put(139, "HX11");
/*  73 */     mVehicleTypeMap.put(140, "HC11");
/*  74 */     mVehicleTypeMap.put(161, "EX11");
/*  75 */     mVehicleTypeMap.put(162, "KX11");
/*  76 */     mVehicleTypeMap.put(163, "DC1E");
/*  77 */     mVehicleTypeMap.put(164, "FW11");
/*  78 */     mVehicleTypeMap.put(165, "ES11");
/*  79 */     mVehicleTypeMap.put(166, "BC1E");
/*  80 */     mVehicleTypeMap.put(167, "EF1E");
/*  81 */     mVehicleTypeMap.put(168, "DX1E");
/*  82 */     mVehicleTypeMap.put(169, "CF1E");
/*  83 */     mVehicleTypeMap.put(224, "HRE1");
/*  84 */     mVehicleTypeMap.put(225, "LCV1");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private BrightnessManager mBrightnessManager;
/*     */ 
/*     */ 
/*     */   
/*     */   private IBtExtension mBtExtension;
/*     */ 
/*     */ 
/*     */   
/*     */   private CarSignalManager mCarSignalManager;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Context mContext;
/*     */ 
/*     */ 
/*     */   
/*     */   private IDayNightMode mDayNightMode;
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean mDebug;
/*     */ 
/*     */ 
/*     */   
/*     */   private IDeviceLog mDeviceLog;
/*     */ 
/*     */ 
/*     */   
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */ 
/*     */ 
/*     */   
/*     */   private ECarXCarSetManager mECarXCarSetManager;
/*     */ 
/*     */ 
/*     */   
/* 127 */   private final Object mLock = new Object(); private ISystemMode mPowerManager;
/*     */   
/*     */   private DeviceImp(Context paramContext) {
/* 130 */     if (Build.IS_USER) {
/* 131 */       this.mDebug = false;
/*     */     } else {
/* 133 */       this.mDebug = SystemProperties.getBoolean("persist.adaptapi.debug", false);
/*     */     } 
/* 135 */     this.mContext = paramContext;
/* 136 */     this.mDayNightMode = DayNightMode.getInstance(paramContext);
/* 137 */     this.mDeviceLog = (IDeviceLog)new DeviceLog(paramContext);
/* 138 */     this.mAdvertise = (IAdvertise)new Advertise(paramContext);
/* 139 */     this.mPowerManager = (ISystemMode)PowerManager.getInstance(paramContext);
/* 140 */     this.mBrightnessManager = BrightnessManager.getInstance(paramContext);
/*     */     
/* 142 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/* 143 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */   
/*     */   public static Device create(Context paramContext) {
/* 147 */     Log.d("DeviceImpl", "Device create");
/* 148 */     DeviceImp deviceImp = null;
/* 149 */     if (paramContext != null) {
/* 150 */       deviceImp = new DeviceImp(paramContext);
/*     */     }
/* 152 */     return deviceImp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIhuId() {
/* 163 */     String str = SystemProperties.get("persist.pn.ihuid", "");
/* 164 */     if (this.mDebug) {
/* 165 */       str = SystemProperties.get("persist.device.ihuid", "");
/*     */     }
/* 167 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXdsn() {
/* 178 */     String str = SystemProperties.get("persist.pn.xdsn", "");
/* 179 */     if (this.mDebug) {
/* 180 */       str = SystemProperties.get("persist.device.xdsn", "");
/*     */     }
/* 182 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSerialNo() {
/* 192 */     String str2 = null; StringBuilder stringBuilder = null;
/*     */ 
/*     */     
/* 195 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 196 */       str1 = str2; PATypes.PA_Device_SN pA_Device_SN = eCarXCarSetManager.getECarXCarDeviceManager().getPA_Device_SN();
/* 197 */       str1 = str2; StringBuilder stringBuilder1 = new StringBuilder(); str1 = str2; this(); str1 = str2; stringBuilder1.append("PA_Device_SN: "); str1 = str2; stringBuilder1.append(pA_Device_SN.toString()); str1 = str2; Log.d("DeviceImpl", stringBuilder1.toString());
/* 198 */       stringBuilder1 = stringBuilder; if (pA_Device_SN != null) {
/* 199 */         str1 = str2; byte[] arrayOfByte = pA_Device_SN.getData();
/* 200 */         stringBuilder1 = stringBuilder; if (arrayOfByte != null) { stringBuilder1 = stringBuilder; str1 = str2; if (arrayOfByte.length >= 4) {
/* 201 */             str1 = str2; str = Utils.bcd2Str(new byte[] { arrayOfByte[0], arrayOfByte[1], arrayOfByte[2], arrayOfByte[3] });
/*     */           }  }
/*     */       
/*     */       } 
/*     */       
/* 206 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 207 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */       
/* 210 */       String str = str2; str1 = str2; if (this.mDebug) {
/* 211 */         str1 = str2; str = SystemProperties.get("persist.device.serialno", "");
/*     */       } 
/*     */ 
/*     */       
/* 215 */       str1 = str; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 217 */      return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPartNo() {
/* 227 */     String str = SystemProperties.get("persist.pn.du.geely", "");
/* 228 */     if (this.mDebug) {
/* 229 */       str = SystemProperties.get("persist.device.partno", "");
/*     */     }
/* 231 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVin() {
/* 241 */     String str2 = "";
/*     */ 
/*     */     
/* 244 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 245 */       str1 = str2; PATypes.PA_VIN_VinNum pA_VIN_VinNum = eCarXCarSetManager.getECarXCarVinManager().getPA_VIN_VinNum();
/* 246 */       String str = str2; if (pA_VIN_VinNum != null) {
/* 247 */         str1 = str2; str = pA_VIN_VinNum.getData();
/*     */       } 
/*     */       
/* 250 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 251 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */       
/* 254 */       str = str2; str1 = str2; if (this.mDebug) {
/* 255 */         str1 = str2; str = SystemProperties.get("persist.device.vin", "");
/*     */       } 
/*     */ 
/*     */       
/* 259 */       str1 = str; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 261 */      return str1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVSVID() {
/* 266 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getOSID() {
/* 271 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMcuSoftwareVersion() {
/* 281 */     Log.d("DeviceImpl", "getMcuSoftwareVersion");
/* 282 */     String str2 = "";
/*     */ 
/*     */     
/* 285 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 286 */       str1 = str2; PATypes.PA_VP_Version pA_VP_Version = eCarXCarSetManager.getECarXCarVpversionManager().getPA_VP_Version();
/* 287 */       String str = str2; if (pA_VP_Version != null) {
/* 288 */         str1 = str2; str = pA_VP_Version.getData();
/* 289 */         str1 = str; StringBuilder stringBuilder = new StringBuilder(); str1 = str; this(); str1 = str; stringBuilder.append("PA_VP_Version: "); str1 = str; stringBuilder.append(pA_VP_Version.toString()); str1 = str; Log.d("DeviceImpl", stringBuilder.toString());
/*     */       } 
/*     */       
/* 292 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 293 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */       
/* 296 */       str = str2; str1 = str2; if (this.mDebug) {
/* 297 */         str1 = str2; str = System.getProperty("persist.device.mcu_soft_ver", "");
/* 298 */         str1 = str; StringBuilder stringBuilder = new StringBuilder(); str1 = str; this(); str1 = str; stringBuilder.append("getMcuSoftwareVersion mDebug true version : "); str1 = str; stringBuilder.append(str); str1 = str; Log.d("DeviceImpl", stringBuilder.toString());
/*     */       } 
/*     */ 
/*     */       
/* 302 */       str1 = str; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 304 */      return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMcuSoftwareVersionInt() {
/* 315 */     byte b = 0;
/* 316 */     String str = getMcuSoftwareVersion();
/* 317 */     int i = b; if (!TextUtils.isEmpty(str)) {
/* 318 */       String[] arrayOfString = str.split("\\.");
/*     */       
/* 320 */       i = b; if (arrayOfString.length > 2) {
/*     */         try {
/* 322 */           i = Integer.parseInt(arrayOfString[2]);
/* 323 */         } catch (Exception exception) {
/* 324 */           exception.printStackTrace(); i = b;
/*     */         } 
/*     */       }
/*     */     } 
/* 328 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMcuHardwareVersion() {
/* 338 */     String str2 = "";
/*     */ 
/*     */     
/* 341 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 342 */       str1 = str2; PATypes.PA_Device_VPVersion_HD pA_Device_VPVersion_HD = eCarXCarSetManager.getECarXCarDeviceManager().getPA_Device_VPVersion_HD();
/* 343 */       String str = str2; if (pA_Device_VPVersion_HD != null) {
/* 344 */         str1 = str2; str = pA_Device_VPVersion_HD.getData();
/*     */       } 
/*     */       
/* 347 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 348 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */       
/* 351 */       str = str2; str1 = str2; if (this.mDebug) {
/* 352 */         str1 = str2; str = System.getProperty("persist.device.mcu_hard_ver", "");
/*     */       } 
/*     */ 
/*     */       
/* 356 */       str1 = str; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 358 */      return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCarType() {
/* 368 */     return -1;
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
/*     */   public String getVehicleType() {
/*     */     // Byte code:
/*     */     //   0: ldc_w ''
/*     */     //   3: astore #4
/*     */     //   5: aload #4
/*     */     //   7: astore #5
/*     */     //   9: aload_0
/*     */     //   10: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   13: invokevirtual getcarconfig1 : ()I
/*     */     //   16: istore_1
/*     */     //   17: aload #4
/*     */     //   19: astore #5
/*     */     //   21: ldc_w 'ro.build.product'
/*     */     //   24: ldc_w ''
/*     */     //   27: invokestatic get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   30: astore #7
/*     */     //   32: aload #4
/*     */     //   34: astore #5
/*     */     //   36: getstatic com/ecarx/xui/adaptapi/device/DeviceImp.mVehicleTypeMap : Landroid/util/SparseArray;
/*     */     //   39: iload_1
/*     */     //   40: ldc_w ''
/*     */     //   43: invokevirtual get : (ILjava/lang/Object;)Ljava/lang/Object;
/*     */     //   46: checkcast java/lang/String
/*     */     //   49: astore #4
/*     */     //   51: aload #4
/*     */     //   53: astore #6
/*     */     //   55: aload #4
/*     */     //   57: astore #5
/*     */     //   59: aload #4
/*     */     //   61: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
/*     */     //   64: ifeq -> 126
/*     */     //   67: aload #4
/*     */     //   69: astore #5
/*     */     //   71: aload #7
/*     */     //   73: ldc_w '_'
/*     */     //   76: invokevirtual indexOf : (Ljava/lang/String;)I
/*     */     //   79: iconst_m1
/*     */     //   80: if_icmple -> 112
/*     */     //   83: aload #4
/*     */     //   85: astore #5
/*     */     //   87: aload #7
/*     */     //   89: iconst_0
/*     */     //   90: aload #7
/*     */     //   92: ldc_w '_'
/*     */     //   95: invokevirtual indexOf : (Ljava/lang/String;)I
/*     */     //   98: invokevirtual substring : (II)Ljava/lang/String;
/*     */     //   101: getstatic java/util/Locale.US : Ljava/util/Locale;
/*     */     //   104: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
/*     */     //   107: astore #6
/*     */     //   109: goto -> 126
/*     */     //   112: aload #4
/*     */     //   114: astore #5
/*     */     //   116: aload #7
/*     */     //   118: getstatic java/util/Locale.US : Ljava/util/Locale;
/*     */     //   121: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
/*     */     //   124: astore #6
/*     */     //   126: aload #6
/*     */     //   128: astore #5
/*     */     //   130: aload #6
/*     */     //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
/*     */     //   135: ifne -> 315
/*     */     //   138: aload #6
/*     */     //   140: astore #5
/*     */     //   142: aload #6
/*     */     //   144: ldc 'KX11'
/*     */     //   146: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   149: ifeq -> 315
/*     */     //   152: aload #6
/*     */     //   154: astore #5
/*     */     //   156: aload_0
/*     */     //   157: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   160: invokevirtual getcarconfig466 : ()I
/*     */     //   163: istore_3
/*     */     //   164: aload #6
/*     */     //   166: astore #5
/*     */     //   168: aload_0
/*     */     //   169: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   172: invokevirtual getcarconfig219 : ()I
/*     */     //   175: istore_1
/*     */     //   176: aload #6
/*     */     //   178: astore #5
/*     */     //   180: aload_0
/*     */     //   181: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   184: invokevirtual getcarconfig13 : ()I
/*     */     //   187: istore_2
/*     */     //   188: iload_2
/*     */     //   189: iconst_3
/*     */     //   190: if_icmpne -> 254
/*     */     //   193: iload_3
/*     */     //   194: sipush #132
/*     */     //   197: if_icmpne -> 208
/*     */     //   200: ldc_w '02605G4'
/*     */     //   203: astore #4
/*     */     //   205: goto -> 312
/*     */     //   208: iload_3
/*     */     //   209: sipush #128
/*     */     //   212: if_icmpne -> 233
/*     */     //   215: iload_1
/*     */     //   216: iconst_3
/*     */     //   217: if_icmpeq -> 225
/*     */     //   220: iload_1
/*     */     //   221: iconst_5
/*     */     //   222: if_icmpne -> 233
/*     */     //   225: ldc_w '02605G5'
/*     */     //   228: astore #4
/*     */     //   230: goto -> 312
/*     */     //   233: iload_1
/*     */     //   234: iconst_2
/*     */     //   235: if_icmpne -> 246
/*     */     //   238: ldc_w '02605G6'
/*     */     //   241: astore #4
/*     */     //   243: goto -> 312
/*     */     //   246: ldc_w 'EAS'
/*     */     //   249: astore #4
/*     */     //   251: goto -> 312
/*     */     //   254: iload_3
/*     */     //   255: sipush #132
/*     */     //   258: if_icmpne -> 269
/*     */     //   261: ldc_w '02605G1'
/*     */     //   264: astore #4
/*     */     //   266: goto -> 312
/*     */     //   269: iload_3
/*     */     //   270: sipush #128
/*     */     //   273: if_icmpne -> 294
/*     */     //   276: iload_1
/*     */     //   277: iconst_3
/*     */     //   278: if_icmpeq -> 286
/*     */     //   281: iload_1
/*     */     //   282: iconst_5
/*     */     //   283: if_icmpne -> 294
/*     */     //   286: ldc_w '02605G2'
/*     */     //   289: astore #4
/*     */     //   291: goto -> 312
/*     */     //   294: iload_1
/*     */     //   295: iconst_2
/*     */     //   296: if_icmpne -> 307
/*     */     //   299: ldc_w '02605G3'
/*     */     //   302: astore #4
/*     */     //   304: goto -> 312
/*     */     //   307: ldc_w 'EAS'
/*     */     //   310: astore #4
/*     */     //   312: goto -> 396
/*     */     //   315: aload #6
/*     */     //   317: astore #4
/*     */     //   319: aload #6
/*     */     //   321: astore #5
/*     */     //   323: aload #6
/*     */     //   325: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
/*     */     //   328: ifne -> 396
/*     */     //   331: aload #6
/*     */     //   333: astore #4
/*     */     //   335: aload #6
/*     */     //   337: astore #5
/*     */     //   339: aload #6
/*     */     //   341: ldc 'EX11'
/*     */     //   343: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   346: ifeq -> 396
/*     */     //   349: aload #6
/*     */     //   351: astore #5
/*     */     //   353: aload_0
/*     */     //   354: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*     */     //   357: invokevirtual getcarconfig219 : ()I
/*     */     //   360: istore_1
/*     */     //   361: iload_1
/*     */     //   362: iconst_3
/*     */     //   363: if_icmpeq -> 391
/*     */     //   366: iload_1
/*     */     //   367: iconst_5
/*     */     //   368: if_icmpne -> 374
/*     */     //   371: goto -> 391
/*     */     //   374: aload #6
/*     */     //   376: astore #4
/*     */     //   378: iload_1
/*     */     //   379: iconst_2
/*     */     //   380: if_icmpne -> 396
/*     */     //   383: ldc_w '02604L2'
/*     */     //   386: astore #4
/*     */     //   388: goto -> 396
/*     */     //   391: ldc_w '02604L1'
/*     */     //   394: astore #4
/*     */     //   396: aload #4
/*     */     //   398: astore #6
/*     */     //   400: aload #4
/*     */     //   402: astore #5
/*     */     //   404: aload_0
/*     */     //   405: getfield mDebug : Z
/*     */     //   408: ifeq -> 426
/*     */     //   411: aload #4
/*     */     //   413: astore #5
/*     */     //   415: ldc_w 'persist.device.vehicle_type'
/*     */     //   418: ldc_w ''
/*     */     //   421: invokestatic get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   424: astore #6
/*     */     //   426: aload #6
/*     */     //   428: astore #5
/*     */     //   430: goto -> 440
/*     */     //   433: astore #4
/*     */     //   435: aload #4
/*     */     //   437: invokevirtual printStackTrace : ()V
/*     */     //   440: aload #5
/*     */     //   442: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #379	-> 0
/*     */     //   #381	-> 5
/*     */     //   #382	-> 17
/*     */     //   #384	-> 32
/*     */     //   #385	-> 51
/*     */     //   #386	-> 67
/*     */     //   #387	-> 83
/*     */     //   #389	-> 112
/*     */     //   #394	-> 126
/*     */     //   #395	-> 152
/*     */     //   #396	-> 164
/*     */     //   #397	-> 176
/*     */     //   #398	-> 188
/*     */     //   #399	-> 193
/*     */     //   #401	-> 200
/*     */     //   #402	-> 208
/*     */     //   #404	-> 225
/*     */     //   #405	-> 233
/*     */     //   #407	-> 238
/*     */     //   #409	-> 246
/*     */     //   #412	-> 254
/*     */     //   #414	-> 261
/*     */     //   #415	-> 269
/*     */     //   #417	-> 286
/*     */     //   #418	-> 294
/*     */     //   #420	-> 299
/*     */     //   #422	-> 307
/*     */     //   #425	-> 312
/*     */     //   #426	-> 349
/*     */     //   #427	-> 361
/*     */     //   #430	-> 374
/*     */     //   #432	-> 383
/*     */     //   #429	-> 391
/*     */     //   #436	-> 396
/*     */     //   #437	-> 411
/*     */     //   #441	-> 426
/*     */     //   #439	-> 433
/*     */     //   #440	-> 435
/*     */     //   #442	-> 440
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   9	17	433	java/lang/Exception
/*     */     //   21	32	433	java/lang/Exception
/*     */     //   36	51	433	java/lang/Exception
/*     */     //   59	67	433	java/lang/Exception
/*     */     //   71	83	433	java/lang/Exception
/*     */     //   87	109	433	java/lang/Exception
/*     */     //   116	126	433	java/lang/Exception
/*     */     //   130	138	433	java/lang/Exception
/*     */     //   142	152	433	java/lang/Exception
/*     */     //   156	164	433	java/lang/Exception
/*     */     //   168	176	433	java/lang/Exception
/*     */     //   180	188	433	java/lang/Exception
/*     */     //   323	331	433	java/lang/Exception
/*     */     //   339	349	433	java/lang/Exception
/*     */     //   353	361	433	java/lang/Exception
/*     */     //   404	411	433	java/lang/Exception
/*     */     //   415	426	433	java/lang/Exception
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
/*     */   public String getVehicleTypeConfig() {
/*     */     // Byte code:
/*     */     //   0: ldc_w 'ro.build.product'
/*     */     //   3: ldc_w ''
/*     */     //   6: invokestatic get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
/*     */     //   9: astore_3
/*     */     //   10: ldc_w ''
/*     */     //   13: astore_2
/*     */     //   14: aload_2
/*     */     //   15: astore_1
/*     */     //   16: aload_3
/*     */     //   17: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
/*     */     //   20: ifne -> 100
/*     */     //   23: getstatic java/util/Locale.US : Ljava/util/Locale;
/*     */     //   26: astore_1
/*     */     //   27: aload_3
/*     */     //   28: aload_1
/*     */     //   29: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
/*     */     //   32: ldc 'KX11'
/*     */     //   34: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   37: ifne -> 61
/*     */     //   40: aload_3
/*     */     //   41: getstatic java/util/Locale.US : Ljava/util/Locale;
/*     */     //   44: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
/*     */     //   47: astore #4
/*     */     //   49: aload_2
/*     */     //   50: astore_1
/*     */     //   51: aload #4
/*     */     //   53: ldc 'EX11'
/*     */     //   55: invokevirtual startsWith : (Ljava/lang/String;)Z
/*     */     //   58: ifeq -> 100
/*     */     //   61: aload_3
/*     */     //   62: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   65: ldc_w 'high'
/*     */     //   68: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   71: ifeq -> 81
/*     */     //   74: ldc_w '-H'
/*     */     //   77: astore_1
/*     */     //   78: goto -> 100
/*     */     //   81: aload_2
/*     */     //   82: astore_1
/*     */     //   83: aload_3
/*     */     //   84: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   87: ldc_w 'low'
/*     */     //   90: invokevirtual endsWith : (Ljava/lang/String;)Z
/*     */     //   93: ifeq -> 100
/*     */     //   96: ldc_w '-L'
/*     */     //   99: astore_1
/*     */     //   100: aload_0
/*     */     //   101: invokevirtual getVehicleType : ()Ljava/lang/String;
/*     */     //   104: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
/*     */     //   107: ifeq -> 115
/*     */     //   110: aconst_null
/*     */     //   111: astore_1
/*     */     //   112: goto -> 143
/*     */     //   115: new java/lang/StringBuilder
/*     */     //   118: dup
/*     */     //   119: invokespecial <init> : ()V
/*     */     //   122: astore_2
/*     */     //   123: aload_2
/*     */     //   124: aload_0
/*     */     //   125: invokevirtual getVehicleType : ()Ljava/lang/String;
/*     */     //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   131: pop
/*     */     //   132: aload_2
/*     */     //   133: aload_1
/*     */     //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   137: pop
/*     */     //   138: aload_2
/*     */     //   139: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   142: astore_1
/*     */     //   143: aload_1
/*     */     //   144: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #452	-> 0
/*     */     //   #453	-> 10
/*     */     //   #454	-> 14
/*     */     //   #455	-> 27
/*     */     //   #456	-> 49
/*     */     //   #457	-> 61
/*     */     //   #458	-> 74
/*     */     //   #459	-> 81
/*     */     //   #460	-> 96
/*     */     //   #463	-> 100
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
/*     */   public String getProjectCode() {
/* 473 */     String str2 = "";
/*     */ 
/*     */     
/* 476 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 477 */       str1 = str2; PATypes.PA_Device_Project_Code pA_Device_Project_Code = eCarXCarSetManager.getECarXCarDeviceManager().getPA_Device_Project_Code();
/* 478 */       String str = str2; if (pA_Device_Project_Code != null) {
/* 479 */         str1 = str2; str = pA_Device_Project_Code.getData();
/*     */       } 
/*     */       
/* 482 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 483 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */       
/* 486 */       str = str2; str1 = str2; if (this.mDebug) {
/* 487 */         str1 = str2; str = SystemProperties.get("persist.device.pcode", "");
/*     */       } 
/*     */ 
/*     */       
/* 491 */       str1 = str; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 493 */      return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSupplierCode() {
/* 503 */     String str2 = "";
/*     */ 
/*     */     
/* 506 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 507 */       str1 = str2; PATypes.PA_Device_Supplier_Code pA_Device_Supplier_Code = eCarXCarSetManager.getECarXCarDeviceManager().getPA_Device_Supplier_Code();
/* 508 */       String str = str2; if (pA_Device_Supplier_Code != null) {
/* 509 */         str1 = str2; str = pA_Device_Supplier_Code.getData();
/*     */       } 
/*     */       
/* 512 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 513 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */       
/* 516 */       str = str2; str1 = str2; if (this.mDebug) {
/* 517 */         str1 = str2; str = SystemProperties.get("persist.device.supplier_code", "");
/*     */       } 
/*     */ 
/*     */       
/* 521 */       str1 = str; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 523 */      return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMpuSoftwareVersion() {
/* 533 */     return SystemProperties.get("ro.build.system.version", "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMpuHardwareVersion() {
/* 543 */     String str2 = "";
/*     */ 
/*     */     
/* 546 */     String str1 = str2; try { ECarXCarSetManager eCarXCarSetManager = this.mECarXCarSetManager;
/* 547 */       str1 = str2; PATypes.PA_Device_VPVersion_HD pA_Device_VPVersion_HD = eCarXCarSetManager.getECarXCarDeviceManager().getPA_Device_VPVersion_HD();
/* 548 */       String str = str2; if (pA_Device_VPVersion_HD != null) {
/* 549 */         str1 = str2; str = pA_Device_VPVersion_HD.getData();
/*     */       } 
/*     */       
/* 552 */       str2 = str; str1 = str; if (!TextUtils.isEmpty(str)) {
/* 553 */         str1 = str; str2 = str.trim();
/*     */       } 
/*     */ 
/*     */       
/* 557 */       str1 = str2; }
/*     */     catch (Exception exception) { exception.printStackTrace(); }
/* 559 */      return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRolloffConfigCode() {
/* 569 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRearViewCameraConfigured() {
/* 579 */     boolean bool2 = false, bool1 = false;
/*     */     
/*     */     try {
/* 582 */       int i = this.mCarSignalManager.getcarconfig154();
/* 583 */       bool1 = bool2; if (i > 1) bool1 = true; 
/* 584 */     } catch (Exception exception) {
/* 585 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 588 */     return bool1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDVRCameraConfigured() {
/* 598 */     boolean bool2 = false, bool1 = false;
/*     */ 
/*     */     
/*     */     try {
/* 602 */       int i = this.mCarSignalManager.getcarconfig483(); bool1 = bool2; if (i == 2) bool1 = true; 
/* 603 */     } catch (Exception exception) {
/* 604 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 607 */     return bool1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVIMSConfigured() {
/* 618 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTboxConfigured() {
/* 628 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMobileNetworkConfigured() {
/* 638 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDayNightMode getDayNightMode() {
/* 646 */     return this.mDayNightMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDayNightMode(int paramInt)
/*     */   {
/*     */     StringBuilder stringBuilder;
/* 657 */     byte b = 1;
/* 658 */     switch (paramInt) {
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
/* 673 */         stringBuilder = new StringBuilder(); stringBuilder.append("setDayNightMode  app send dayNightMode: "); stringBuilder.append(paramInt); stringBuilder.append(", trans mode: "); stringBuilder.append(b); Log.d("DeviceImpl", stringBuilder.toString());
/*     */ 
/*     */         
/* 676 */         this.mBrightnessManager.setBrightnessDayNightMode(b);
/* 677 */         return true;
/*     */       case 3:
/*     */         b = 2;
/*     */       case 2:
/*     */         b = 0;
/*     */       case 1:
/*     */         b = 1;
/*     */       case 0:
/*     */         break;
/*     */     } 
/* 687 */     b = 1; } public int getMinScreenBrightness() { return 0; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxScreenBrightness() {
/* 697 */     return 15;
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
/*     */   public int getOperatorCode() {
/* 710 */     return SystemProperties.getInt("persist.device.operator.code", 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getTotalStorageSize() {
/* 717 */     return -1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAvailableStorageSize() {
/* 725 */     return -1.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOperatorName() {
/* 735 */     return SystemProperties.get("persist.device.operator.name", "GEELY");
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVehicleCountryCode() {
/* 751 */     return "CN";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDeviceLog getDeviceLog() {
/* 761 */     return this.mDeviceLog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAdvertise getAdvertise() {
/* 771 */     return this.mAdvertise;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IBtExtension getBtExtension() {
/* 779 */     if (this.mBtExtension == null) {
/* 780 */       synchronized (this.mLock) {
/* 781 */         if (this.mBtExtension == null) {
/* 782 */           BtExtension btExtension = new BtExtension(); this(this.mContext.getApplicationContext()); this.mBtExtension = (IBtExtension)btExtension;
/*     */         } 
/*     */       } 
/*     */     }
/* 786 */     return this.mBtExtension;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ISystemMode getSystemMode() {
/* 794 */     return this.mPowerManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/*     */     try {
/* 806 */       Log.i("DeviceImpl", "onECarXCarServiceConnected");
/* 807 */       this.mCarSignalManager = paramCarSignalManager;
/* 808 */       this.mECarXCarSetManager = (ECarXCarSetManager)paramECarXCar.getCarManager("car_publicattribute");
/* 809 */     } catch (Exception exception) {
/* 810 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 819 */     Log.w("DeviceImpl", "onECarXCarServiceDeath");
/* 820 */     this.mCarSignalManager = null;
/* 821 */     this.mECarXCarSetManager = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 831 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 839 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disconnect() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSteeringMode() {
/* 863 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCarVehicleType() {
/* 871 */     boolean bool = false; byte b = 0;
/*     */     try {
/* 873 */       int i = this.mCarSignalManager.getcarconfig1();
/* 874 */       int k = this.mCarSignalManager.getcarconfig9();
/* 875 */       int j = this.mCarSignalManager.getcarconfig13();
/* 876 */       if (i == 161) {
/* 877 */         if (j == 3 && (k == 139 || k == 140)) {
/*     */           
/* 879 */           b = 2;
/*     */         } else {
/*     */           
/* 882 */           b = 1;
/*     */         } 
/* 884 */       } else if (162 == i) {
/* 885 */         if (j == 3) {
/* 886 */           b = 4;
/*     */         } else {
/* 888 */           b = 3;
/*     */         } 
/*     */       } 
/* 891 */     } catch (Exception exception) {
/* 892 */       exception.printStackTrace(); b = bool;
/*     */     } 
/* 894 */     return b;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\DeviceImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */