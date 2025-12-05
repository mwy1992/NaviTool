/*       */ package ecarx.car.hardware.vehicle;
/*       */ import ecarx.car.hardware.annotation.AvailabilitySts;
/*       */ import ecarx.car.hardware.annotation.BooleanType;
/*       */ import ecarx.car.hardware.annotation.DrvModReqType2;
/*       */ import ecarx.car.hardware.annotation.HmiCmptmtAirDistbnFrnt;
/*       */ import ecarx.car.hardware.annotation.HmiHvacFanLvl;
/*       */ import ecarx.car.hardware.annotation.Inact;
/*       */ import ecarx.car.hardware.annotation.OnOff1;
/*       */ import ecarx.car.hardware.annotation.OnOffNoReq;
/*       */ import ecarx.car.hardware.annotation.OnOffSafe1;
/*       */ import ecarx.car.hardware.annotation.PasSensorchecksection;
/*       */ import ecarx.car.hardware.annotation.PmSnsrSts;
/*       */ import ecarx.car.hardware.annotation.SeatClimaLvl;
/*       */ import ecarx.car.hardware.annotation.SeatClimaTmr;
/*       */ import ecarx.car.hardware.annotation.StsFd;
/*       */ import ecarx.car.hardware.annotation.SwtHozlSts1;
/*       */ import ecarx.car.hardware.annotation.SwtVertSts1;
/*       */ import ecarx.car.hardware.annotation.Warn2;
/*       */ import ecarx.car.hardware.annotation.WinAndRoofAndCurtPosnTyp;
/*       */ import java.util.Arrays;
/*       */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*       */ 
/*       */ public class PATypes {
/*       */   public static class PA_IntBase {
/*       */     protected int availability;
/*       */     protected int data;
/*       */     
/*       */     public PA_IntBase(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*    29 */       if (param1PAIntType != null) {
/*    30 */         this.availability = param1PAIntType.availability;
/*    31 */         this.data = param1PAIntType.data;
/*    32 */         this.status = param1PAIntType.status;
/*    33 */         this.format = param1PAIntType.format;
/*       */       } 
/*       */     }
/*       */     protected int format; protected int status;
/*       */     
/*       */     public int getAvailability() {
/*    39 */       return this.availability;
/*       */     }
/*       */     
/*       */     public int getData() {
/*    43 */       return this.data;
/*       */     }
/*       */     
/*       */     public int getStatus() {
/*    47 */       return this.status;
/*       */     }
/*       */     
/*       */     public int getFormat() {
/*    51 */       return this.format;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*    56 */       StringBuilder stringBuilder = new StringBuilder("PA_IntBase");
/*    57 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*    58 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Integer.toString(this.data));
/*    59 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*    60 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*    61 */       stringBuilder.append("}");
/*    62 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_StringBase
/*       */   {
/*       */     protected int availability;
/*       */     protected String data;
/*       */     protected int format;
/*       */     protected int status;
/*       */     
/*       */     public PA_StringBase(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*    74 */       if (param1PAByteType != null) {
/*       */         try {
/*    76 */           this.availability = param1PAByteType.availability;
/*    77 */           String str = new String(); this(param1PAByteType.data, "UTF-8"); this.data = str;
/*    78 */           this.status = param1PAByteType.status;
/*    79 */           this.format = param1PAByteType.format;
/*    80 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*    81 */           unsupportedEncodingException.printStackTrace();
/*       */         } 
/*       */       }
/*       */     }
/*       */ 
/*       */     
/*       */     public int getAvailability() {
/*    88 */       return this.availability;
/*       */     }
/*       */     
/*       */     public String getData() {
/*    92 */       return this.data;
/*       */     }
/*       */     
/*       */     public int getStatus() {
/*    96 */       return this.status;
/*       */     }
/*       */     
/*       */     public int getFormat() {
/*   100 */       return this.format;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   105 */       StringBuilder stringBuilder = new StringBuilder("PA_StringBase");
/*   106 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   107 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*   108 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   109 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   110 */       stringBuilder.append("}");
/*   111 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_IntArrayBase
/*       */   {
/*       */     protected int availability;
/*       */     protected int[] data;
/*       */     protected int format;
/*       */     protected int status;
/*       */     
/*       */     public PA_IntArrayBase(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/*   123 */       if (param1PAIntArrayType != null) {
/*   124 */         this.availability = param1PAIntArrayType.availability;
/*   125 */         this.data = param1PAIntArrayType.data;
/*   126 */         this.status = param1PAIntArrayType.status;
/*   127 */         this.format = param1PAIntArrayType.format;
/*       */       } 
/*       */     }
/*       */ 
/*       */     
/*       */     public int getAvailability() {
/*   133 */       return this.availability;
/*       */     }
/*       */     
/*       */     public int[] getData() {
/*   137 */       return this.data;
/*       */     }
/*       */     
/*       */     public int getStatus() {
/*   141 */       return this.status;
/*       */     }
/*       */     
/*       */     public int getFormat() {
/*   145 */       return this.format;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   150 */       StringBuilder stringBuilder = new StringBuilder("PA_IntArrayBase");
/*   151 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   152 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/*   153 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   154 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   155 */       stringBuilder.append("}");
/*   156 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ByteArrayBase
/*       */   {
/*       */     protected int availability;
/*       */     protected byte[] data;
/*       */     protected int format;
/*       */     protected int status;
/*       */     
/*       */     public PA_ByteArrayBase(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*   168 */       if (param1PAByteType != null) {
/*   169 */         this.availability = param1PAByteType.availability;
/*   170 */         this.data = new byte[param1PAByteType.data.length];
/*   171 */         System.arraycopy(param1PAByteType.data, 0, this.data, 0, param1PAByteType.data.length);
/*   172 */         this.status = param1PAByteType.status;
/*   173 */         this.format = param1PAByteType.format;
/*       */       } 
/*       */     }
/*       */ 
/*       */     
/*       */     public int getAvailability() {
/*   179 */       return this.availability;
/*       */     }
/*       */     
/*       */     public byte[] getData() {
/*   183 */       return this.data;
/*       */     }
/*       */     
/*       */     public int getStatus() {
/*   187 */       return this.status;
/*       */     }
/*       */     
/*       */     public int getFormat() {
/*   191 */       return this.format;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   196 */       StringBuilder stringBuilder1 = new StringBuilder();
/*   197 */       for (byte b = 0; b < this.data.length; b++) {
/*   198 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*   200 */       StringBuilder stringBuilder2 = new StringBuilder("PA_ByteArrayBase");
/*   201 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*   202 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*   203 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*   204 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*   205 */       stringBuilder2.append("}");
/*   206 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_ACCandTSR extends PA_IntBase {
/*       */     public PA_Asy_ACCandTSR(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   212 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   217 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   222 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_ACCandTSR");
/*   223 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   224 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   225 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   226 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   227 */       stringBuilder.append("}");
/*   228 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_HWA extends PA_IntBase {
/*       */     public PA_Asy_HWA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   234 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   239 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   244 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_HWA");
/*   245 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   246 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   247 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   248 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   249 */       stringBuilder.append("}");
/*   250 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_TSR extends PA_IntBase {
/*       */     public PA_Asy_TSR(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   256 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   261 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   266 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_TSR");
/*   267 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   268 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   269 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   270 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   271 */       stringBuilder.append("}");
/*   272 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_OtherTSR extends PA_IntBase {
/*       */     public PA_Asy_OtherTSR(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   278 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   283 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   288 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_OtherTSR");
/*   289 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   290 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   291 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   292 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   293 */       stringBuilder.append("}");
/*   294 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_TSR_Warning extends PA_IntBase {
/*       */     public PA_Asy_TSR_Warning(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   300 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   305 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   310 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_TSR_Warning");
/*   311 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   312 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DY1.toString(this.data));
/*   313 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   314 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   315 */       stringBuilder.append("}");
/*   316 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_SpeedCompensation extends PA_IntBase {
/*       */     public PA_Asy_SpeedCompensation(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   322 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   327 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   332 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_SpeedCompensation");
/*   333 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   334 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OffsForSpdWarnSetgSts.toString(this.data));
/*   335 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   336 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   337 */       stringBuilder.append("}");
/*   338 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_TLA extends PA_IntBase {
/*       */     public PA_Asy_TLA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   344 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   349 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   354 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_TLA");
/*   355 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   356 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   357 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   358 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   359 */       stringBuilder.append("}");
/*   360 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_TLA_Sound_Warning extends PA_IntBase {
/*       */     public PA_Asy_TLA_Sound_Warning(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   366 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   371 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   376 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_TLA_Sound_Warning");
/*   377 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   378 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   379 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   380 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   381 */       stringBuilder.append("}");
/*   382 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_ELOW extends PA_IntBase {
/*       */     public PA_Asy_ELOW(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   388 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   393 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   398 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_ELOW");
/*   399 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   400 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   401 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   402 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   403 */       stringBuilder.append("}");
/*   404 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_DPS extends PA_IntBase {
/*       */     public PA_Asy_DPS(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   410 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   415 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   420 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_DPS");
/*   421 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   422 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   423 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   424 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   425 */       stringBuilder.append("}");
/*   426 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_DPS_Reminder extends PA_IntBase {
/*       */     public PA_Asy_DPS_Reminder(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   432 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   437 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   442 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_DPS_Reminder");
/*   443 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   444 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   445 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   446 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   447 */       stringBuilder.append("}");
/*   448 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_CMS extends PA_IntBase {
/*       */     public PA_Asy_CMS(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   454 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   459 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   464 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_CMS");
/*   465 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   466 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   467 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   468 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   469 */       stringBuilder.append("}");
/*   470 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_CMS_Warning extends PA_IntBase {
/*       */     public PA_Asy_CMS_Warning(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   476 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   481 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   486 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_CMS_Warning");
/*   487 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   488 */       stringBuilder.append(", dataValue = "); stringBuilder.append(CllsnAidSnvtySeldSts.toString(this.data));
/*   489 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   490 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   491 */       stringBuilder.append("}");
/*   492 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_LCA extends PA_IntBase {
/*       */     public PA_Asy_LCA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   498 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   503 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   508 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_LCA");
/*   509 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   510 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   511 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   512 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   513 */       stringBuilder.append("}");
/*   514 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_LCA_Warning extends PA_IntBase {
/*       */     public PA_Asy_LCA_Warning(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   520 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   525 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   530 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_LCA_Warning");
/*   531 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   532 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   533 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   534 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   535 */       stringBuilder.append("}");
/*   536 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_RCW extends PA_IntBase {
/*       */     public PA_Asy_RCW(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   542 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   547 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   552 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_RCW");
/*   553 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   554 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   555 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   556 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   557 */       stringBuilder.append("}");
/*   558 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_RCTA extends PA_IntBase {
/*       */     public PA_Asy_RCTA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   564 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   569 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   574 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_RCTA");
/*   575 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   576 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   577 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   578 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   579 */       stringBuilder.append("}");
/*   580 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_DOW extends PA_IntBase {
/*       */     public PA_Asy_DOW(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   586 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   591 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   596 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_DOW");
/*   597 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   598 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   599 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   600 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   601 */       stringBuilder.append("}");
/*   602 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_LKA extends PA_IntBase {
/*       */     public PA_Asy_LKA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   608 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   613 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   618 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_LKA");
/*   619 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   620 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   621 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   622 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   623 */       stringBuilder.append("}");
/*   624 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_LKA_Mode extends PA_IntBase {
/*       */     public PA_Asy_LKA_Mode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   630 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   635 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   640 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_LKA_Mode");
/*   641 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   642 */       stringBuilder.append(", dataValue = "); stringBuilder.append(IntvAndWarnModForLaneKeepAidSts.toString(this.data));
/*   643 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   644 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   645 */       stringBuilder.append("}");
/*   646 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_LKA_Warning_Mode extends PA_IntBase {
/*       */     public PA_Asy_LKA_Warning_Mode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   652 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   657 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   662 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_LKA_Warning_Mode");
/*   663 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   664 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ChgWarnMod.toString(this.data));
/*   665 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   666 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   667 */       stringBuilder.append("}");
/*   668 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_ELKA extends PA_IntBase {
/*       */     public PA_Asy_ELKA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   674 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   679 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   684 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_ELKA");
/*   685 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   686 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   687 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   688 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   689 */       stringBuilder.append("}");
/*   690 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_EMA extends PA_IntBase {
/*       */     public PA_Asy_EMA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   696 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   701 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   706 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_EMA");
/*   707 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   708 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   709 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   710 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   711 */       stringBuilder.append("}");
/*   712 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_AC extends PA_IntBase {
/*       */     public PA_CL_AC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   718 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   723 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   728 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_AC");
/*   729 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   730 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   731 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   732 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   733 */       stringBuilder.append("}");
/*   734 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_Auto extends PA_IntBase {
/*       */     public PA_CL_Auto(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   740 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   745 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   750 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_Auto");
/*   751 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   752 */       stringBuilder.append(", dataValue = "); stringBuilder.append(LongPresBtn.toString(this.data));
/*   753 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   754 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   755 */       stringBuilder.append("}");
/*   756 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_Recirc extends PA_IntBase {
/*       */     public PA_CL_Recirc(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   762 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   767 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   772 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_Recirc");
/*   773 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   774 */       stringBuilder.append(", dataValue = "); stringBuilder.append(LongPresBtn.toString(this.data));
/*   775 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   776 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   777 */       stringBuilder.append("}");
/*   778 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ModeFrstLeft extends PA_IntBase {
/*       */     public PA_CL_ModeFrstLeft(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   784 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   789 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   794 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ModeFrstLeft");
/*   795 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   796 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiCmptmtAirDistbnFrnt.toString(this.data));
/*   797 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   798 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   799 */       stringBuilder.append("}");
/*   800 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ModeFrstRight extends PA_IntBase {
/*       */     public PA_CL_ModeFrstRight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   806 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   811 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   816 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ModeFrstRight");
/*   817 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   818 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiCmptmtAirDistbnFrnt.toString(this.data));
/*   819 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   820 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   821 */       stringBuilder.append("}");
/*   822 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ModeSec extends PA_IntBase {
/*       */     public PA_CL_ModeSec(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   828 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   833 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   838 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ModeSec");
/*   839 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   840 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiCmptmtAirDistbnFrnt.toString(this.data));
/*   841 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   842 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   843 */       stringBuilder.append("}");
/*   844 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_MaxAC extends PA_IntBase {
/*       */     public PA_CL_MaxAC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   850 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   855 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   860 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_MaxAC");
/*   861 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   862 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   863 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   864 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   865 */       stringBuilder.append("}");
/*   866 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_FanLevel extends PA_IntBase {
/*       */     public PA_CL_FanLevel(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   872 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   877 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/*   882 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   887 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_FanLevel");
/*   888 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   889 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiHvacFanLvl.toString(this.data));
/*   890 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   891 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   892 */       stringBuilder.append("}");
/*   893 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_LeftTemp extends PA_IntBase {
/*       */     public PA_CL_LeftTemp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   899 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   904 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_LeftTemp");
/*   905 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   906 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*   907 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   908 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   909 */       stringBuilder.append("}");
/*   910 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_RightTemp extends PA_IntBase {
/*       */     public PA_CL_RightTemp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   916 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   921 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_RightTemp");
/*   922 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   923 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*   924 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   925 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   926 */       stringBuilder.append("}");
/*   927 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_RecircSetting extends PA_IntBase {
/*       */     public PA_CL_RecircSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   933 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   938 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   943 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_RecircSetting");
/*   944 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   945 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   946 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   947 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   948 */       stringBuilder.append("}");
/*   949 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_AutoSetting extends PA_IntBase {
/*       */     public PA_CL_AutoSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   955 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   960 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   965 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_AutoSetting");
/*   966 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   967 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   968 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   969 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   970 */       stringBuilder.append("}");
/*   971 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_MaxDefrost extends PA_IntBase {
/*       */     public PA_CL_MaxDefrost(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   977 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*   982 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*   987 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_MaxDefrost");
/*   988 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*   989 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*   990 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*   991 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*   992 */       stringBuilder.append("}");
/*   993 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WDC_AutoFrontDefrost extends PA_IntBase {
/*       */     public PA_WDC_AutoFrontDefrost(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*   999 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1004 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1009 */       StringBuilder stringBuilder = new StringBuilder("PA_WDC_AutoFrontDefrost");
/*  1010 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1011 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1012 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1013 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1014 */       stringBuilder.append("}");
/*  1015 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WDC_AutoRearDefrost extends PA_IntBase {
/*       */     public PA_WDC_AutoRearDefrost(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1021 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1026 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1031 */       StringBuilder stringBuilder = new StringBuilder("PA_WDC_AutoRearDefrost");
/*  1032 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1033 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1034 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1035 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1036 */       stringBuilder.append("}");
/*  1037 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_FrontDefrost extends PA_IntBase {
/*       */     public PA_CL_FrontDefrost(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1043 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1048 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1053 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_FrontDefrost");
/*  1054 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1055 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1056 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1057 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1058 */       stringBuilder.append("}");
/*  1059 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_RearDefrost extends PA_IntBase {
/*       */     public PA_CL_RearDefrost(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1065 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1070 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1075 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_RearDefrost");
/*  1076 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1077 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1078 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1079 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1080 */       stringBuilder.append("}");
/*  1081 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_Sync extends PA_IntBase {
/*       */     public PA_CL_Sync(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1087 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1092 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1097 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_Sync");
/*  1098 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1099 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1100 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1101 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1102 */       stringBuilder.append("}");
/*  1103 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ECOClimate extends PA_IntBase {
/*       */     public PA_CL_ECOClimate(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1109 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1114 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1119 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ECOClimate");
/*  1120 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1121 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1122 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1123 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1124 */       stringBuilder.append("}");
/*  1125 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_Pre extends PA_IntBase {
/*       */     public PA_CL_Pre(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1131 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1136 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1141 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_Pre");
/*  1142 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1143 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1144 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1145 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1146 */       stringBuilder.append("}");
/*  1147 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_Post extends PA_IntBase {
/*       */     public PA_CL_Post(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1153 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1158 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1163 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_Post");
/*  1164 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1165 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1166 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1167 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1168 */       stringBuilder.append("}");
/*  1169 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_AirCtrlOff extends PA_IntBase {
/*       */     public PA_CL_AirCtrlOff(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1175 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1180 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1185 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_AirCtrlOff");
/*  1186 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1187 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1188 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1189 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1190 */       stringBuilder.append("}");
/*  1191 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_HvacReCtr extends PA_IntBase {
/*       */     public PA_CL_HvacReCtr(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1197 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1202 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1207 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_HvacReCtr");
/*  1208 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1209 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1210 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1211 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1212 */       stringBuilder.append("}");
/*  1213 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_SecLeftTemp extends PA_IntBase {
/*       */     public PA_CL_SecLeftTemp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1219 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1224 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_SecLeftTemp");
/*  1225 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1226 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  1227 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1228 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1229 */       stringBuilder.append("}");
/*  1230 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_SecRightTemp extends PA_IntBase {
/*       */     public PA_CL_SecRightTemp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1236 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1241 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_SecRightTemp");
/*  1242 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1243 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  1244 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1245 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1246 */       stringBuilder.append("}");
/*  1247 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_SecFanLevel extends PA_IntBase {
/*       */     public PA_CL_SecFanLevel(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1253 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1258 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1263 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_SecFanLevel");
/*  1264 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1265 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiHvacFanLvl.toString(this.data));
/*  1266 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1267 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1268 */       stringBuilder.append("}");
/*  1269 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_AutoDefrostSetting extends PA_IntBase {
/*       */     public PA_CL_AutoDefrostSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1275 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1280 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1285 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_AutoDefrostSetting");
/*  1286 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1287 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1288 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1289 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1290 */       stringBuilder.append("}");
/*  1291 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_AutoDefrostPopup extends PA_IntBase {
/*       */     public PA_CL_AutoDefrostPopup(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1297 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1302 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1307 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_AutoDefrostPopup");
/*  1308 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1309 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1310 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1311 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1312 */       stringBuilder.append("}");
/*  1313 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_FrntDefrostPopup extends PA_IntBase {
/*       */     public PA_CL_FrntDefrostPopup(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1319 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1324 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1329 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_FrntDefrostPopup");
/*  1330 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1331 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1332 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1333 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1334 */       stringBuilder.append("}");
/*  1335 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_RearDefrostPopup extends PA_IntBase {
/*       */     public PA_CL_RearDefrostPopup(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1341 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1346 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1351 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_RearDefrostPopup");
/*  1352 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1353 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1354 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1355 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1356 */       stringBuilder.append("}");
/*  1357 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_SecRowOnOffSwith extends PA_IntBase {
/*       */     public PA_CL_SecRowOnOffSwith(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1363 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1368 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1373 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_SecRowOnOffSwith");
/*  1374 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1375 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1376 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1377 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1378 */       stringBuilder.append("}");
/*  1379 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_PostClimaWarn extends PA_IntBase {
/*       */     public PA_CL_PostClimaWarn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1385 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1390 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1395 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_PostClimaWarn");
/*  1396 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1397 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PrkgClimaWarn.toString(this.data));
/*  1398 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1399 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1400 */       stringBuilder.append("}");
/*  1401 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_HumCtrl extends PA_IntBase {
/*       */     public PA_CL_HumCtrl(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1407 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1412 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1417 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_HumCtrl");
/*  1418 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1419 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1420 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1421 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1422 */       stringBuilder.append("}");
/*  1423 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_HumPop extends PA_IntBase {
/*       */     public PA_CL_HumPop(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1429 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1434 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1439 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_HumPop");
/*  1440 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1441 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1442 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1443 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1444 */       stringBuilder.append("}");
/*  1445 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_IntelliClimaPop extends PA_IntBase {
/*       */     public PA_CL_IntelliClimaPop(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1451 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1456 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1461 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_IntelliClimaPop");
/*  1462 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1463 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1464 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1465 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1466 */       stringBuilder.append("}");
/*  1467 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_WipReAutReq extends PA_IntBase {
/*       */     public PA_CL_WipReAutReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1473 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1478 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1483 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_WipReAutReq");
/*  1484 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1485 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1486 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1487 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1488 */       stringBuilder.append("}");
/*  1489 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_WipFrntSrvMod extends PA_IntBase {
/*       */     public PA_CL_WipFrntSrvMod(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1495 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1500 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1505 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_WipFrntSrvMod");
/*  1506 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1507 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1508 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1509 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1510 */       stringBuilder.append("}");
/*  1511 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_WipReSrvMod extends PA_IntBase {
/*       */     public PA_CL_WipReSrvMod(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1517 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1522 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1527 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_WipReSrvMod");
/*  1528 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1529 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1530 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1531 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1532 */       stringBuilder.append("}");
/*  1533 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ClmCloseWinPop extends PA_IntBase {
/*       */     public PA_CL_ClmCloseWinPop(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1539 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1544 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1549 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ClmCloseWinPop");
/*  1550 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1551 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1552 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1553 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1554 */       stringBuilder.append("}");
/*  1555 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_DrvSwt extends PA_IntBase {
/*       */     public PA_CL_DrvSwt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1561 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1566 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1571 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_DrvSwt");
/*  1572 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1573 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1574 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1575 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1576 */       stringBuilder.append("}");
/*  1577 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_PassSwt extends PA_IntBase {
/*       */     public PA_CL_PassSwt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1583 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1588 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1593 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_PassSwt");
/*  1594 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1595 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1596 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1597 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1598 */       stringBuilder.append("}");
/*  1599 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ElecAirAvlStsPop extends PA_IntBase {
/*       */     public PA_CL_ElecAirAvlStsPop(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1605 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1610 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1615 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ElecAirAvlStsPop");
/*  1616 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1617 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ElecAirVentnAvlSts.toString(this.data));
/*  1618 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1619 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1620 */       stringBuilder.append("}");
/*  1621 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_TWinRfClsdPopSw extends PA_IntBase {
/*       */     public PA_CL_TWinRfClsdPopSw(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1627 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1632 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1637 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_TWinRfClsdPopSw");
/*  1638 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1639 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1640 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1641 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1642 */       stringBuilder.append("}");
/*  1643 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_SecLockClimaSw extends PA_IntBase {
/*       */     public PA_CL_SecLockClimaSw(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1649 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1654 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1659 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_SecLockClimaSw");
/*  1660 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1661 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1662 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1663 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1664 */       stringBuilder.append("}");
/*  1665 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_SecAutoSw extends PA_IntBase {
/*       */     public PA_CL_SecAutoSw(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1671 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1676 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1681 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_SecAutoSw");
/*  1682 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1683 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1684 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1685 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1686 */       stringBuilder.append("}");
/*  1687 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_GClean extends PA_IntBase {
/*       */     public PA_CL_GClean(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1693 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1698 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1703 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_GClean");
/*  1704 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1705 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1706 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1707 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1708 */       stringBuilder.append("}");
/*  1709 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static class PA_CL_DrvElecAir
/*       */   {
/*       */     private int avoid;
/*       */     private int focus;
/*       */     private int leposx;
/*       */     private int leposy;
/*       */     private int leriswng;
/*       */     private int manuswng;
/*       */     private int riposx;
/*       */     private int riposy;
/*       */     private int uponswng;
/*       */     
/*       */     PA_CL_DrvElecAir(VendorVehicleHalPAProto.Elecairalldata param1Elecairalldata) {
/*  1727 */       this.manuswng = param1Elecairalldata.manuswng;
/*  1728 */       this.focus = param1Elecairalldata.focus;
/*  1729 */       this.avoid = param1Elecairalldata.avoid;
/*  1730 */       this.leposx = param1Elecairalldata.leposx;
/*  1731 */       this.leposy = param1Elecairalldata.leposy;
/*  1732 */       this.riposx = param1Elecairalldata.riposx;
/*  1733 */       this.riposy = param1Elecairalldata.riposy;
/*  1734 */       this.leriswng = param1Elecairalldata.leriswng;
/*  1735 */       this.uponswng = param1Elecairalldata.uponswng;
/*       */     }
/*       */     
/*       */     public int getmanuswng() {
/*  1739 */       return this.manuswng;
/*       */     }
/*       */     
/*       */     public int getfocus() {
/*  1743 */       return this.focus;
/*       */     }
/*       */     
/*       */     public int getavoid() {
/*  1747 */       return this.avoid;
/*       */     }
/*       */     
/*       */     public int getleposx() {
/*  1751 */       return this.leposx;
/*       */     }
/*       */     
/*       */     public int getleposy() {
/*  1755 */       return this.leposy;
/*       */     }
/*       */     
/*       */     public int getriposx() {
/*  1759 */       return this.riposx;
/*       */     }
/*       */     
/*       */     public int getriposy() {
/*  1763 */       return this.riposy;
/*       */     }
/*       */     
/*       */     public int getleriswng() {
/*  1767 */       return this.leriswng;
/*       */     }
/*       */     
/*       */     public int getuponswng() {
/*  1771 */       return this.uponswng;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1776 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_DrvElecAir");
/*  1777 */       stringBuilder.append(", manuswng = "); stringBuilder.append(this.manuswng);
/*  1778 */       stringBuilder.append(", focus = "); stringBuilder.append(this.focus);
/*  1779 */       stringBuilder.append(", avoid = "); stringBuilder.append(this.avoid);
/*  1780 */       stringBuilder.append(", leposx = "); stringBuilder.append(this.leposx);
/*  1781 */       stringBuilder.append(", leposy = "); stringBuilder.append(this.leposy);
/*  1782 */       stringBuilder.append(", riposx = "); stringBuilder.append(this.riposx);
/*  1783 */       stringBuilder.append(", riposy = "); stringBuilder.append(this.riposy);
/*  1784 */       stringBuilder.append(", leriswng = "); stringBuilder.append(this.leriswng);
/*  1785 */       stringBuilder.append(", uponswng = "); stringBuilder.append(this.uponswng);
/*  1786 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static class PA_CL_PassElecAir
/*       */   {
/*       */     private int avoid;
/*       */     private int focus;
/*       */     private int leposx;
/*       */     private int leposy;
/*       */     private int leriswng;
/*       */     private int manuswng;
/*       */     private int riposx;
/*       */     private int riposy;
/*       */     private int uponswng;
/*       */     
/*       */     PA_CL_PassElecAir(VendorVehicleHalPAProto.Elecairalldata param1Elecairalldata) {
/*  1804 */       this.manuswng = param1Elecairalldata.manuswng;
/*  1805 */       this.focus = param1Elecairalldata.focus;
/*  1806 */       this.avoid = param1Elecairalldata.avoid;
/*  1807 */       this.leposx = param1Elecairalldata.leposx;
/*  1808 */       this.leposy = param1Elecairalldata.leposy;
/*  1809 */       this.riposx = param1Elecairalldata.riposx;
/*  1810 */       this.riposy = param1Elecairalldata.riposy;
/*  1811 */       this.leriswng = param1Elecairalldata.leriswng;
/*  1812 */       this.uponswng = param1Elecairalldata.uponswng;
/*       */     }
/*       */     
/*       */     public int getmanuswng() {
/*  1816 */       return this.manuswng;
/*       */     }
/*       */     
/*       */     public int getfocus() {
/*  1820 */       return this.focus;
/*       */     }
/*       */     
/*       */     public int getavoid() {
/*  1824 */       return this.avoid;
/*       */     }
/*       */     
/*       */     public int getleposx() {
/*  1828 */       return this.leposx;
/*       */     }
/*       */     
/*       */     public int getleposy() {
/*  1832 */       return this.leposy;
/*       */     }
/*       */     
/*       */     public int getriposx() {
/*  1836 */       return this.riposx;
/*       */     }
/*       */     
/*       */     public int getriposy() {
/*  1840 */       return this.riposy;
/*       */     }
/*       */     
/*       */     public int getleriswng() {
/*  1844 */       return this.leriswng;
/*       */     }
/*       */     
/*       */     public int getuponswng() {
/*  1848 */       return this.uponswng;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1853 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_PassElecAir");
/*  1854 */       stringBuilder.append(", manuswng = "); stringBuilder.append(this.manuswng);
/*  1855 */       stringBuilder.append(", focus = "); stringBuilder.append(this.focus);
/*  1856 */       stringBuilder.append(", avoid = "); stringBuilder.append(this.avoid);
/*  1857 */       stringBuilder.append(", leposx = "); stringBuilder.append(this.leposx);
/*  1858 */       stringBuilder.append(", leposy = "); stringBuilder.append(this.leposy);
/*  1859 */       stringBuilder.append(", riposx = "); stringBuilder.append(this.riposx);
/*  1860 */       stringBuilder.append(", riposy = "); stringBuilder.append(this.riposy);
/*  1861 */       stringBuilder.append(", leriswng = "); stringBuilder.append(this.leriswng);
/*  1862 */       stringBuilder.append(", uponswng = "); stringBuilder.append(this.uponswng);
/*  1863 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_CCSMPopUp extends PA_IntBase {
/*       */     public PA_CL_CCSMPopUp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1869 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1874 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1879 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_CCSMPopUp");
/*  1880 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1881 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1882 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1883 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1884 */       stringBuilder.append("}");
/*  1885 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ElecDefRunErr extends PA_IntBase {
/*       */     public PA_CL_ElecDefRunErr(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1891 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1896 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1901 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ElecDefRunErr");
/*  1902 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1903 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1904 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1905 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1906 */       stringBuilder.append("}");
/*  1907 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_InteCleanUnpleSmell extends PA_IntBase {
/*       */     public PA_CL_InteCleanUnpleSmell(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1913 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1918 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1923 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_InteCleanUnpleSmell");
/*  1924 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1925 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  1926 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1927 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1928 */       stringBuilder.append("}");
/*  1929 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_FanLevel_ByHardKey extends PA_IntBase {
/*       */     public PA_CL_FanLevel_ByHardKey(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1935 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1940 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/*  1945 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1950 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_FanLevel_ByHardKey");
/*  1951 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1952 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiHvacFanLvl.toString(this.data));
/*  1953 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1954 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1955 */       stringBuilder.append("}");
/*  1956 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_LeftTemp_ByHardKey extends PA_IntBase {
/*       */     public PA_CL_LeftTemp_ByHardKey(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1962 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1967 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_LeftTemp_ByHardKey");
/*  1968 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1969 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  1970 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1971 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1972 */       stringBuilder.append("}");
/*  1973 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_ModeFrstLeft_ByHardKey extends PA_IntBase {
/*       */     public PA_CL_ModeFrstLeft_ByHardKey(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  1979 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  1984 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  1989 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_ModeFrstLeft_ByHardKey");
/*  1990 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  1991 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiCmptmtAirDistbnFrnt.toString(this.data));
/*  1992 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  1993 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  1994 */       stringBuilder.append("}");
/*  1995 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstActvn extends PA_IntBase {
/*       */     public PA_SCH_FirstActvn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2001 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2006 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstActvn");
/*  2007 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2008 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2009 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2010 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2011 */       stringBuilder.append("}");
/*  2012 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecActvn extends PA_IntBase {
/*       */     public PA_SCH_SecActvn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2018 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2023 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecActvn");
/*  2024 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2025 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2026 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2027 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2028 */       stringBuilder.append("}");
/*  2029 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstLeLvlSts extends PA_IntBase {
/*       */     public PA_SCH_FirstLeLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2035 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2040 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2045 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstLeLvlSts");
/*  2046 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2047 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaLvl.toString(this.data));
/*  2048 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2049 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2050 */       stringBuilder.append("}");
/*  2051 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstRiLvlSts extends PA_IntBase {
/*       */     public PA_SCH_FirstRiLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2057 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2062 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2067 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstRiLvlSts");
/*  2068 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2069 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaLvl.toString(this.data));
/*  2070 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2071 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2072 */       stringBuilder.append("}");
/*  2073 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecLeLvlSts extends PA_IntBase {
/*       */     public PA_SCH_SecLeLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2079 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2084 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2089 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecLeLvlSts");
/*  2090 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2091 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaLvl.toString(this.data));
/*  2092 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2093 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2094 */       stringBuilder.append("}");
/*  2095 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecRiLvlSts extends PA_IntBase {
/*       */     public PA_SCH_SecRiLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2101 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2106 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2111 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecRiLvlSts");
/*  2112 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2113 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaLvl.toString(this.data));
/*  2114 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2115 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2116 */       stringBuilder.append("}");
/*  2117 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstLeTmrSts extends PA_IntBase {
/*       */     public PA_SCH_FirstLeTmrSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2123 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2128 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2133 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstLeTmrSts");
/*  2134 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2135 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaTmr.toString(this.data));
/*  2136 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2137 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2138 */       stringBuilder.append("}");
/*  2139 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstRiTmrSts extends PA_IntBase {
/*       */     public PA_SCH_FirstRiTmrSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2145 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2150 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2155 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstRiTmrSts");
/*  2156 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2157 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaTmr.toString(this.data));
/*  2158 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2159 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2160 */       stringBuilder.append("}");
/*  2161 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecLeTmrSts extends PA_IntBase {
/*       */     public PA_SCH_SecLeTmrSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2167 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2172 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2177 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecLeTmrSts");
/*  2178 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2179 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaTmr.toString(this.data));
/*  2180 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2181 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2182 */       stringBuilder.append("}");
/*  2183 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecRiTmrSts extends PA_IntBase {
/*       */     public PA_SCH_SecRiTmrSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2189 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2194 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2199 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecRiTmrSts");
/*  2200 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2201 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaTmr.toString(this.data));
/*  2202 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2203 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2204 */       stringBuilder.append("}");
/*  2205 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstLeAvlSts extends PA_IntBase {
/*       */     public PA_SCH_FirstLeAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2211 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2216 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2221 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstLeAvlSts");
/*  2222 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2223 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2224 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2225 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2226 */       stringBuilder.append("}");
/*  2227 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_FirstRiAvlSts extends PA_IntBase {
/*       */     public PA_SCH_FirstRiAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2233 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2238 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2243 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_FirstRiAvlSts");
/*  2244 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2245 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2246 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2247 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2248 */       stringBuilder.append("}");
/*  2249 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecLeAvlSts extends PA_IntBase {
/*       */     public PA_SCH_SecLeAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2255 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2260 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2265 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecLeAvlSts");
/*  2266 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2267 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2268 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2269 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2270 */       stringBuilder.append("}");
/*  2271 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCH_SecRiAvlSts extends PA_IntBase {
/*       */     public PA_SCH_SecRiAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2277 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2282 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2287 */       StringBuilder stringBuilder = new StringBuilder("PA_SCH_SecRiAvlSts");
/*  2288 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2289 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2290 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2291 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2292 */       stringBuilder.append("}");
/*  2293 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstActvn extends PA_IntBase {
/*       */     public PA_SCV_FirstActvn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2299 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2304 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstActvn");
/*  2305 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2306 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2307 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2308 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2309 */       stringBuilder.append("}");
/*  2310 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstLeLvlSts extends PA_IntBase {
/*       */     public PA_SCV_FirstLeLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2316 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2321 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2326 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstLeLvlSts");
/*  2327 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2328 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaLvl.toString(this.data));
/*  2329 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2330 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2331 */       stringBuilder.append("}");
/*  2332 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstRiLvlSts extends PA_IntBase {
/*       */     public PA_SCV_FirstRiLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2338 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2343 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2348 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstRiLvlSts");
/*  2349 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2350 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaLvl.toString(this.data));
/*  2351 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2352 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2353 */       stringBuilder.append("}");
/*  2354 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstLeTmrSts extends PA_IntBase {
/*       */     public PA_SCV_FirstLeTmrSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2360 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2365 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2370 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstLeTmrSts");
/*  2371 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2372 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaTmr.toString(this.data));
/*  2373 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2374 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2375 */       stringBuilder.append("}");
/*  2376 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstRiTmrSts extends PA_IntBase {
/*       */     public PA_SCV_FirstRiTmrSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2382 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2387 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2392 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstRiTmrSts");
/*  2393 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2394 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatClimaTmr.toString(this.data));
/*  2395 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2396 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2397 */       stringBuilder.append("}");
/*  2398 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstLeAvlSts extends PA_IntBase {
/*       */     public PA_SCV_FirstLeAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2404 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2409 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2414 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstLeAvlSts");
/*  2415 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2416 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2417 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2418 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2419 */       stringBuilder.append("}");
/*  2420 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_FirstRiAvlSts extends PA_IntBase {
/*       */     public PA_SCV_FirstRiAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2426 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2431 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2436 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_FirstRiAvlSts");
/*  2437 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2438 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2439 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2440 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2441 */       stringBuilder.append("}");
/*  2442 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SWH_Actvn extends PA_IntBase {
/*       */     public PA_SWH_Actvn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2448 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2453 */       StringBuilder stringBuilder = new StringBuilder("PA_SWH_Actvn");
/*  2454 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2455 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2456 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2457 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2458 */       stringBuilder.append("}");
/*  2459 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SWH_AutoReqSts extends PA_IntBase {
/*       */     public PA_SWH_AutoReqSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2465 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2470 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2475 */       StringBuilder stringBuilder = new StringBuilder("PA_SWH_AutoReqSts");
/*  2476 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2477 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  2478 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2479 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2480 */       stringBuilder.append("}");
/*  2481 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SWH_ManualLvlSts extends PA_IntBase {
/*       */     public PA_SWH_ManualLvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2487 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2492 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2497 */       StringBuilder stringBuilder = new StringBuilder("PA_SWH_ManualLvlSts");
/*  2498 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2499 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SteerWhlHeatgOnCmdTyp.toString(this.data));
/*  2500 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2501 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2502 */       stringBuilder.append("}");
/*  2503 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SWH_AvlSts extends PA_IntBase {
/*       */     public PA_SWH_AvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2509 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2514 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2519 */       StringBuilder stringBuilder = new StringBuilder("PA_SWH_AvlSts");
/*  2520 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2521 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  2522 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2523 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2524 */       stringBuilder.append("}");
/*  2525 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_IAQC_ActnSts extends PA_IntBase {
/*       */     public PA_IAQC_ActnSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2531 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2536 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2541 */       StringBuilder stringBuilder = new StringBuilder("PA_IAQC_ActnSts");
/*  2542 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2543 */       stringBuilder.append(", dataValue = "); stringBuilder.append(AirQly.toString(this.data));
/*  2544 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2545 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2546 */       stringBuilder.append("}");
/*  2547 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_Actvn extends PA_IntBase {
/*       */     public PA_PM25_Actvn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2553 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2558 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2563 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_Actvn");
/*  2564 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2565 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PM25Senor.toString(this.data));
/*  2566 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2567 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2568 */       stringBuilder.append("}");
/*  2569 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_IntPm25Vlu extends PA_IntBase {
/*       */     public PA_PM25_IntPm25Vlu(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2575 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2580 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_IntPm25Vlu");
/*  2581 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2582 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2583 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2584 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2585 */       stringBuilder.append("}");
/*  2586 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_OutdPm25Vlu extends PA_IntBase {
/*       */     public PA_PM25_OutdPm25Vlu(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2592 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2597 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_OutdPm25Vlu");
/*  2598 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2599 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2600 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2601 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2602 */       stringBuilder.append("}");
/*  2603 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_IntPm25Lvl extends PA_IntBase {
/*       */     public PA_PM25_IntPm25Lvl(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2609 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2614 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2619 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_IntPm25Lvl");
/*  2620 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2621 */       stringBuilder.append(", dataValue = "); stringBuilder.append(CmpmtAirPmLvl.toString(this.data));
/*  2622 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2623 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2624 */       stringBuilder.append("}");
/*  2625 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_OutdPm25Lvl extends PA_IntBase {
/*       */     public PA_PM25_OutdPm25Lvl(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2631 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2636 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2641 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_OutdPm25Lvl");
/*  2642 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2643 */       stringBuilder.append(", dataValue = "); stringBuilder.append(CmpmtAirPmLvl.toString(this.data));
/*  2644 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2645 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2646 */       stringBuilder.append("}");
/*  2647 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_IntrPm25HiWarn extends PA_IntBase {
/*       */     public PA_PM25_IntrPm25HiWarn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2653 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2658 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2663 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_IntrPm25HiWarn");
/*  2664 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2665 */       stringBuilder.append(", dataValue = "); stringBuilder.append(IntPmHiPopUp.toString(this.data));
/*  2666 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2667 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2668 */       stringBuilder.append("}");
/*  2669 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_IntPm25Sts extends PA_IntBase {
/*       */     public PA_PM25_IntPm25Sts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2675 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2680 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2685 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_IntPm25Sts");
/*  2686 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2687 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PmSnsrSts.toString(this.data));
/*  2688 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2689 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2690 */       stringBuilder.append("}");
/*  2691 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_OutdPm25Sts extends PA_IntBase {
/*       */     public PA_PM25_OutdPm25Sts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2697 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2702 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2707 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_OutdPm25Sts");
/*  2708 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2709 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PmSnsrSts.toString(this.data));
/*  2710 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2711 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2712 */       stringBuilder.append("}");
/*  2713 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM25_IncomingAirQlyPopUpReq extends PA_IntBase {
/*       */     public PA_PM25_IncomingAirQlyPopUpReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2719 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2724 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2729 */       StringBuilder stringBuilder = new StringBuilder("PA_PM25_IncomingAirQlyPopUpReq");
/*  2730 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2731 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  2732 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2733 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2734 */       stringBuilder.append("}");
/*  2735 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Actn extends PA_IntBase {
/*       */     public PA_Fragra_Actn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2741 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2746 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Actn");
/*  2747 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2748 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2749 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2750 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2751 */       stringBuilder.append("}");
/*  2752 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_TypRatReqASts extends PA_IntBase {
/*       */     public PA_Fragra_TypRatReqASts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2758 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2763 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_TypRatReqASts");
/*  2764 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2765 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2766 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2767 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2768 */       stringBuilder.append("}");
/*  2769 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_TypRatReqBSts extends PA_IntBase {
/*       */     public PA_Fragra_TypRatReqBSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2775 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2780 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_TypRatReqBSts");
/*  2781 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2782 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2783 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2784 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2785 */       stringBuilder.append("}");
/*  2786 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_TypRatReqCSts extends PA_IntBase {
/*       */     public PA_Fragra_TypRatReqCSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2792 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2797 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_TypRatReqCSts");
/*  2798 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2799 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2800 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2801 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2802 */       stringBuilder.append("}");
/*  2803 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_TypRatReqDSts extends PA_IntBase {
/*       */     public PA_Fragra_TypRatReqDSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2809 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2814 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_TypRatReqDSts");
/*  2815 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2816 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2817 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2818 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2819 */       stringBuilder.append("}");
/*  2820 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_TypRatReqESts extends PA_IntBase {
/*       */     public PA_Fragra_TypRatReqESts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2826 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2831 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_TypRatReqESts");
/*  2832 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2833 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2834 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2835 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2836 */       stringBuilder.append("}");
/*  2837 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_TypRatReqFSts extends PA_IntBase {
/*       */     public PA_Fragra_TypRatReqFSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2843 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2848 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_TypRatReqFSts");
/*  2849 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2850 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2851 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2852 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2853 */       stringBuilder.append("}");
/*  2854 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_LvlReqSts extends PA_IntBase {
/*       */     public PA_Fragra_LvlReqSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2860 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2865 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2870 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_LvlReqSts");
/*  2871 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2872 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiFragraLvlReq.toString(this.data));
/*  2873 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2874 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2875 */       stringBuilder.append("}");
/*  2876 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_ModReqSts extends PA_IntBase {
/*       */     public PA_Fragra_ModReqSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2882 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2887 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2892 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_ModReqSts");
/*  2893 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2894 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiFrangraModReq.toString(this.data));
/*  2895 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2896 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2897 */       stringBuilder.append("}");
/*  2898 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_SceneSetSts extends PA_IntBase {
/*       */     public PA_Fragra_SceneSetSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2904 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2909 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_SceneSetSts");
/*  2910 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2911 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2912 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2913 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2914 */       stringBuilder.append("}");
/*  2915 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Sts extends PA_IntBase {
/*       */     public PA_Fragra_Sts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2921 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2926 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2931 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Sts");
/*  2932 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2933 */       stringBuilder.append(", dataValue = "); stringBuilder.append(AirFrgSts.toString(this.data));
/*  2934 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2935 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2936 */       stringBuilder.append("}");
/*  2937 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_RefrshReq extends PA_IntBase {
/*       */     public PA_Fragra_RefrshReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2943 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  2948 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2953 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_RefrshReq");
/*  2954 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2955 */       stringBuilder.append(", dataValue = "); stringBuilder.append(FragMod.toString(this.data));
/*  2956 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2957 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2958 */       stringBuilder.append("}");
/*  2959 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Taste1ID extends PA_IntBase {
/*       */     public PA_Fragra_Taste1ID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2965 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2970 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Taste1ID");
/*  2971 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2972 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2973 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2974 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2975 */       stringBuilder.append("}");
/*  2976 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Taste2ID extends PA_IntBase {
/*       */     public PA_Fragra_Taste2ID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2982 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  2987 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Taste2ID");
/*  2988 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  2989 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  2990 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  2991 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  2992 */       stringBuilder.append("}");
/*  2993 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Taste3ID extends PA_IntBase {
/*       */     public PA_Fragra_Taste3ID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  2999 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3004 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Taste3ID");
/*  3005 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3006 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3007 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3008 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3009 */       stringBuilder.append("}");
/*  3010 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Taste4ID extends PA_IntBase {
/*       */     public PA_Fragra_Taste4ID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3016 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3021 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Taste4ID");
/*  3022 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3023 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3024 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3025 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3026 */       stringBuilder.append("}");
/*  3027 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Taste5ID extends PA_IntBase {
/*       */     public PA_Fragra_Taste5ID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3033 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3038 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Taste5ID");
/*  3039 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3040 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3041 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3042 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3043 */       stringBuilder.append("}");
/*  3044 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Tast1UseUpRmd extends PA_IntBase {
/*       */     public PA_Fragra_Tast1UseUpRmd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3050 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3055 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3060 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Tast1UseUpRmd");
/*  3061 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3062 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Warn2.toString(this.data));
/*  3063 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3064 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3065 */       stringBuilder.append("}");
/*  3066 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Tast2UseUpRmd extends PA_IntBase {
/*       */     public PA_Fragra_Tast2UseUpRmd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3072 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3077 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3082 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Tast2UseUpRmd");
/*  3083 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3084 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Warn2.toString(this.data));
/*  3085 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3086 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3087 */       stringBuilder.append("}");
/*  3088 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Tast3UseUpRmd extends PA_IntBase {
/*       */     public PA_Fragra_Tast3UseUpRmd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3094 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3099 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3104 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Tast3UseUpRmd");
/*  3105 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3106 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Warn2.toString(this.data));
/*  3107 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3108 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3109 */       stringBuilder.append("}");
/*  3110 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Tast4UseUpRmd extends PA_IntBase {
/*       */     public PA_Fragra_Tast4UseUpRmd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3116 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3121 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3126 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Tast4UseUpRmd");
/*  3127 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3128 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Warn2.toString(this.data));
/*  3129 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3130 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3131 */       stringBuilder.append("}");
/*  3132 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_Tast5UseUpRmd extends PA_IntBase {
/*       */     public PA_Fragra_Tast5UseUpRmd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3138 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3143 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3148 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_Tast5UseUpRmd");
/*  3149 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3150 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Warn2.toString(this.data));
/*  3151 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3152 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3153 */       stringBuilder.append("}");
/*  3154 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_AirFragCh1RunngSts extends PA_IntBase {
/*       */     public PA_Fragra_AirFragCh1RunngSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3160 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3165 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3170 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_AirFragCh1RunngSts");
/*  3171 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3172 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3173 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3174 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3175 */       stringBuilder.append("}");
/*  3176 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_AirFragCh2RunngSts extends PA_IntBase {
/*       */     public PA_Fragra_AirFragCh2RunngSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3182 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3187 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3192 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_AirFragCh2RunngSts");
/*  3193 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3194 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3195 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3196 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3197 */       stringBuilder.append("}");
/*  3198 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_AirFragCh3RunngSts extends PA_IntBase {
/*       */     public PA_Fragra_AirFragCh3RunngSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3204 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3209 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3214 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_AirFragCh3RunngSts");
/*  3215 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3216 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3217 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3218 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3219 */       stringBuilder.append("}");
/*  3220 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_AirFragCh4RunngSts extends PA_IntBase {
/*       */     public PA_Fragra_AirFragCh4RunngSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3226 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3231 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3236 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_AirFragCh4RunngSts");
/*  3237 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3238 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3239 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3240 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3241 */       stringBuilder.append("}");
/*  3242 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_AirFragCh5RunngSts extends PA_IntBase {
/*       */     public PA_Fragra_AirFragCh5RunngSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3248 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3253 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3258 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_AirFragCh5RunngSts");
/*  3259 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3260 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3261 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3262 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3263 */       stringBuilder.append("}");
/*  3264 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_FragRefrshAutSetg extends PA_IntBase {
/*       */     public PA_Fragra_FragRefrshAutSetg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3270 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3275 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3280 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_FragRefrshAutSetg");
/*  3281 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3282 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3283 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3284 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3285 */       stringBuilder.append("}");
/*  3286 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TCH_CupHoldrStsFd extends PA_IntBase {
/*       */     public PA_TCH_CupHoldrStsFd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3292 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3297 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3302 */       StringBuilder stringBuilder = new StringBuilder("PA_TCH_CupHoldrStsFd");
/*  3303 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3304 */       stringBuilder.append(", dataValue = "); stringBuilder.append(HmiCupHldrClimaReq.toString(this.data));
/*  3305 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3306 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3307 */       stringBuilder.append("}");
/*  3308 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TCH_CupHoldrActvAllwd extends PA_IntBase {
/*       */     public PA_TCH_CupHoldrActvAllwd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3314 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3319 */       StringBuilder stringBuilder = new StringBuilder("PA_TCH_CupHoldrActvAllwd");
/*  3320 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3321 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3322 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3323 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3324 */       stringBuilder.append("}");
/*  3325 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TCH_CupHoldrVoltgErr extends PA_IntBase {
/*       */     public PA_TCH_CupHoldrVoltgErr(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3331 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3336 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3341 */       StringBuilder stringBuilder = new StringBuilder("PA_TCH_CupHoldrVoltgErr");
/*  3342 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3343 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VoltSts.toString(this.data));
/*  3344 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3345 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3346 */       stringBuilder.append("}");
/*  3347 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TCH_CupHoldrAvlSts extends PA_IntBase {
/*       */     public PA_TCH_CupHoldrAvlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3353 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3358 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3363 */       StringBuilder stringBuilder = new StringBuilder("PA_TCH_CupHoldrAvlSts");
/*  3364 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3365 */       stringBuilder.append(", dataValue = "); stringBuilder.append(StsFd.toString(this.data));
/*  3366 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3367 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3368 */       stringBuilder.append("}");
/*  3369 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TCH_CupHoldrOcpyFbSts extends PA_IntBase {
/*       */     public PA_TCH_CupHoldrOcpyFbSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3375 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3380 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3385 */       StringBuilder stringBuilder = new StringBuilder("PA_TCH_CupHoldrOcpyFbSts");
/*  3386 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3387 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VentnActr01UrgcExist.toString(this.data));
/*  3388 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3389 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3390 */       stringBuilder.append("}");
/*  3391 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Eco extends PA_IntBase {
/*       */     public PA_DriveMode_Eco(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3397 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3402 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Eco");
/*  3403 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3404 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3405 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3406 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3407 */       stringBuilder.append("}");
/*  3408 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Comfort extends PA_IntBase {
/*       */     public PA_DriveMode_Comfort(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3414 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3419 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Comfort");
/*  3420 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3421 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3422 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3423 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3424 */       stringBuilder.append("}");
/*  3425 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Dynamic extends PA_IntBase {
/*       */     public PA_DriveMode_Dynamic(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3431 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3436 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Dynamic");
/*  3437 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3438 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3439 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3440 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3441 */       stringBuilder.append("}");
/*  3442 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Individual extends PA_IntBase {
/*       */     public PA_DriveMode_Individual(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3448 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3453 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Individual");
/*  3454 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3455 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3456 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3457 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3458 */       stringBuilder.append("}");
/*  3459 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_XC extends PA_IntBase {
/*       */     public PA_DriveMode_XC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3465 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3470 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_XC");
/*  3471 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3472 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3473 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3474 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3475 */       stringBuilder.append("}");
/*  3476 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_AWD extends PA_IntBase {
/*       */     public PA_DriveMode_AWD(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3482 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3487 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_AWD");
/*  3488 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3489 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3490 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3491 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3492 */       stringBuilder.append("}");
/*  3493 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Save extends PA_IntBase {
/*       */     public PA_DriveMode_Save(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3499 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3504 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Save");
/*  3505 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3506 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3507 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3508 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3509 */       stringBuilder.append("}");
/*  3510 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Pure extends PA_IntBase {
/*       */     public PA_DriveMode_Pure(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3516 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3521 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Pure");
/*  3522 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3523 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3524 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3525 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3526 */       stringBuilder.append("}");
/*  3527 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Hybrid extends PA_IntBase {
/*       */     public PA_DriveMode_Hybrid(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3533 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3538 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Hybrid");
/*  3539 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3540 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3541 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3542 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3543 */       stringBuilder.append("}");
/*  3544 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Power extends PA_IntBase {
/*       */     public PA_DriveMode_Power(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3550 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3555 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Power");
/*  3556 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3557 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3558 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3559 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3560 */       stringBuilder.append("}");
/*  3561 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Snow extends PA_IntBase {
/*       */     public PA_DriveMode_Snow(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3567 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3572 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Snow");
/*  3573 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3574 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3575 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3576 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3577 */       stringBuilder.append("}");
/*  3578 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Sand extends PA_IntBase {
/*       */     public PA_DriveMode_Sand(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3584 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3589 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Sand");
/*  3590 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3591 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3592 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3593 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3594 */       stringBuilder.append("}");
/*  3595 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Mud extends PA_IntBase {
/*       */     public PA_DriveMode_Mud(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3601 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3606 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Mud");
/*  3607 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3608 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3609 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3610 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3611 */       stringBuilder.append("}");
/*  3612 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Rock extends PA_IntBase {
/*       */     public PA_DriveMode_Rock(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3618 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3623 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Rock");
/*  3624 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3625 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3626 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3627 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3628 */       stringBuilder.append("}");
/*  3629 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_confirmation_timeout extends PA_IntBase {
/*       */     public PA_DriveMode_confirmation_timeout(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3635 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3640 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_confirmation_timeout");
/*  3641 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3642 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3643 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3644 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3645 */       stringBuilder.append("}");
/*  3646 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_active_time extends PA_IntBase {
/*       */     public PA_DriveMode_active_time(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3652 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3657 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_active_time");
/*  3658 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3659 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3660 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3661 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3662 */       stringBuilder.append("}");
/*  3663 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Individual_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_Individual_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3669 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3674 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Individual_Settings");
/*  3675 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3676 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3677 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3678 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3679 */       stringBuilder.append("}");
/*  3680 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Brake_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_Brake_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3686 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3691 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3696 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Brake_Settings");
/*  3697 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3698 */       stringBuilder.append(", dataValue = "); stringBuilder.append(NormSptType.toString(this.data));
/*  3699 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3700 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3701 */       stringBuilder.append("}");
/*  3702 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Powertrain_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_Powertrain_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3708 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3713 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3718 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Powertrain_Settings");
/*  3719 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3720 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DrvModReqType2.toString(this.data));
/*  3721 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3722 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3723 */       stringBuilder.append("}");
/*  3724 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_AirConditioner_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_AirConditioner_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3730 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3735 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3740 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_AirConditioner_Settings");
/*  3741 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3742 */       stringBuilder.append(", dataValue = "); stringBuilder.append(AirCdnrSetg.toString(this.data));
/*  3743 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3744 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3745 */       stringBuilder.append("}");
/*  3746 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_SteeringWheelAssistLevel_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_SteeringWheelAssistLevel_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3752 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3757 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3762 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_SteeringWheelAssistLevel_Settings");
/*  3763 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3764 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SteerAsscLvl.toString(this.data));
/*  3765 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3766 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3767 */       stringBuilder.append("}");
/*  3768 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_DIMTheme_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_DIMTheme_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3774 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3779 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3784 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_DIMTheme_Settings");
/*  3785 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3786 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DrvrDispSetg.toString(this.data));
/*  3787 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3788 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3789 */       stringBuilder.append("}");
/*  3790 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Engine_StartStop extends PA_IntBase {
/*       */     public PA_DriveMode_Engine_StartStop(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3796 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3801 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3806 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Engine_StartStop");
/*  3807 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3808 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  3809 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3810 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3811 */       stringBuilder.append("}");
/*  3812 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Suspension_Settings extends PA_IntBase {
/*       */     public PA_DriveMode_Suspension_Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3818 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3823 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3828 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Suspension_Settings");
/*  3829 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3830 */       stringBuilder.append(", dataValue = "); stringBuilder.append(LvlCtrlSetgTyp.toString(this.data));
/*  3831 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3832 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3833 */       stringBuilder.append("}");
/*  3834 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Value extends PA_IntBase {
/*       */     public PA_DriveMode_Value(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3840 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3845 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3850 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Value");
/*  3851 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3852 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DrvModReqType2.toString(this.data));
/*  3853 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3854 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3855 */       stringBuilder.append("}");
/*  3856 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Animation extends PA_IntBase {
/*       */     public PA_DriveMode_Animation(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3862 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3867 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3872 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Animation");
/*  3873 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3874 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DrvModReqType2.toString(this.data));
/*  3875 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3876 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3877 */       stringBuilder.append("}");
/*  3878 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_Adaptive extends PA_IntBase {
/*       */     public PA_DriveMode_Adaptive(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3884 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3889 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_Adaptive");
/*  3890 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3891 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  3892 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3893 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  3894 */       stringBuilder.append("}");
/*  3895 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static class PA_Power_Res
/*       */   {
/*       */     private int csdstatus;
/*       */     private int em;
/*       */     private int im;
/*       */     private int iplm;
/*       */     private int modemstatus;
/*       */     private int popes;
/*       */     private int popsd;
/*       */     private int psdstatus;
/*       */     private int resetsettingsresp;
/*       */     private int vehicleenergylvl;
/*       */     
/*       */     PA_Power_Res(VendorVehicleHalPAProto.PwrctrlVptoapimpl param1PwrctrlVptoapimpl) {
/*  3914 */       this.im = param1PwrctrlVptoapimpl.im;
/*  3915 */       this.modemstatus = param1PwrctrlVptoapimpl.modemstatus;
/*  3916 */       this.popes = param1PwrctrlVptoapimpl.popes;
/*  3917 */       this.popsd = param1PwrctrlVptoapimpl.popsd;
/*  3918 */       this.em = param1PwrctrlVptoapimpl.em;
/*  3919 */       this.resetsettingsresp = param1PwrctrlVptoapimpl.resetsettingsresp;
/*  3920 */       this.csdstatus = param1PwrctrlVptoapimpl.csdstatus;
/*  3921 */       this.vehicleenergylvl = param1PwrctrlVptoapimpl.vehicleenergylvl;
/*  3922 */       this.iplm = param1PwrctrlVptoapimpl.iplm;
/*  3923 */       this.psdstatus = param1PwrctrlVptoapimpl.psdstatus;
/*       */     }
/*       */     
/*       */     public int getim() {
/*  3927 */       return this.im;
/*       */     }
/*       */     
/*       */     public int getmodemstatus() {
/*  3931 */       return this.modemstatus;
/*       */     }
/*       */     
/*       */     public int getpopes() {
/*  3935 */       return this.popes;
/*       */     }
/*       */     
/*       */     public int getpopsd() {
/*  3939 */       return this.popsd;
/*       */     }
/*       */     
/*       */     public int getem() {
/*  3943 */       return this.em;
/*       */     }
/*       */     
/*       */     public int getresetsettingsresp() {
/*  3947 */       return this.resetsettingsresp;
/*       */     }
/*       */     
/*       */     public int getcsdstatus() {
/*  3951 */       return this.csdstatus;
/*       */     }
/*       */     
/*       */     public int getvehicleenergylvl() {
/*  3955 */       return this.vehicleenergylvl;
/*       */     }
/*       */     
/*       */     public int getiplm() {
/*  3959 */       return this.iplm;
/*       */     }
/*       */     
/*       */     public int getpsdstatus() {
/*  3963 */       return this.psdstatus;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3968 */       StringBuilder stringBuilder = new StringBuilder("PA_Power_Res");
/*  3969 */       stringBuilder.append(", im = "); stringBuilder.append(this.im);
/*  3970 */       stringBuilder.append(", modemstatus = "); stringBuilder.append(this.modemstatus);
/*  3971 */       stringBuilder.append(", popes = "); stringBuilder.append(this.popes);
/*  3972 */       stringBuilder.append(", popsd = "); stringBuilder.append(this.popsd);
/*  3973 */       stringBuilder.append(", em = "); stringBuilder.append(this.em);
/*  3974 */       stringBuilder.append(", resetsettingsresp = "); stringBuilder.append(this.resetsettingsresp);
/*  3975 */       stringBuilder.append(", csdstatus = "); stringBuilder.append(this.csdstatus);
/*  3976 */       stringBuilder.append(", vehicleenergylvl = "); stringBuilder.append(this.vehicleenergylvl);
/*  3977 */       stringBuilder.append(", iplm = "); stringBuilder.append(this.iplm);
/*  3978 */       stringBuilder.append(", psdstatus = "); stringBuilder.append(this.psdstatus);
/*  3979 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetOfLang extends PA_IntBase {
/*       */     public PA_SysSetOfLang(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  3985 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  3990 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  3995 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetOfLang");
/*  3996 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  3997 */       stringBuilder.append(", dataValue = "); stringBuilder.append(LangTyp.toString(this.data));
/*  3998 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  3999 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4000 */       stringBuilder.append("}");
/*  4001 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetClkFmt extends PA_IntBase {
/*       */     public PA_SysSetClkFmt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4007 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4012 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4017 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetClkFmt");
/*  4018 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4019 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ClkFmt.toString(this.data));
/*  4020 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4021 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4022 */       stringBuilder.append("}");
/*  4023 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetDateFmt extends PA_IntBase {
/*       */     public PA_SysSetDateFmt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4029 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4034 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4039 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetDateFmt");
/*  4040 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4041 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DateFmt.toString(this.data));
/*  4042 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4043 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4044 */       stringBuilder.append("}");
/*  4045 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetTempUnit extends PA_IntBase {
/*       */     public PA_SysSetTempUnit(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4051 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4056 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4061 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetTempUnit");
/*  4062 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4063 */       stringBuilder.append(", dataValue = "); stringBuilder.append(AmbTIndcdUnit.toString(this.data));
/*  4064 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4065 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4066 */       stringBuilder.append("}");
/*  4067 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetFuCnsUnit extends PA_IntBase {
/*       */     public PA_SysSetFuCnsUnit(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4073 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4078 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4083 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetFuCnsUnit");
/*  4084 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4085 */       stringBuilder.append(", dataValue = "); stringBuilder.append(FuCnsIndcdUnit.toString(this.data));
/*  4086 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4087 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4088 */       stringBuilder.append("}");
/*  4089 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetSpdUnit extends PA_IntBase {
/*       */     public PA_SysSetSpdUnit(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4095 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4100 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4105 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetSpdUnit");
/*  4106 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4107 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VehSpdIndcdUnit.toString(this.data));
/*  4108 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4109 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4110 */       stringBuilder.append("}");
/*  4111 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetVolUnit extends PA_IntBase {
/*       */     public PA_SysSetVolUnit(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4117 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4122 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4127 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetVolUnit");
/*  4128 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4129 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VolUnit.toString(this.data));
/*  4130 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4131 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4132 */       stringBuilder.append("}");
/*  4133 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetDstLong extends PA_IntBase {
/*       */     public PA_SysSetDstLong(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4139 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4144 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4149 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetDstLong");
/*  4150 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4151 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DstLong.toString(this.data));
/*  4152 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4153 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4154 */       stringBuilder.append("}");
/*  4155 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SysSetPUnit extends PA_IntBase {
/*       */     public PA_SysSetPUnit(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4161 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4166 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4171 */       StringBuilder stringBuilder = new StringBuilder("PA_SysSetPUnit");
/*  4172 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4173 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PUnit.toString(this.data));
/*  4174 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4175 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4176 */       stringBuilder.append("}");
/*  4177 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_BackBrightness extends PA_IntBase {
/*       */     public PA_BackBrightness(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4183 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4188 */       StringBuilder stringBuilder = new StringBuilder("PA_BackBrightness");
/*  4189 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4190 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4191 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4192 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4193 */       stringBuilder.append("}");
/*  4194 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DayNightMode extends PA_IntBase {
/*       */     public PA_DayNightMode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4200 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4205 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/*  4210 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4215 */       StringBuilder stringBuilder = new StringBuilder("PA_DayNightMode");
/*  4216 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4217 */       stringBuilder.append(", dataValue = "); stringBuilder.append(TwliBriSts1.toString(this.data));
/*  4218 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4219 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4220 */       stringBuilder.append("}");
/*  4221 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CSDBrightness extends PA_IntBase {
/*       */     public PA_CSDBrightness(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4227 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4232 */       StringBuilder stringBuilder = new StringBuilder("PA_CSDBrightness");
/*  4233 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4234 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4235 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4236 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4237 */       stringBuilder.append("}");
/*  4238 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSDBrightness extends PA_IntBase {
/*       */     public PA_PSDBrightness(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4244 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4249 */       StringBuilder stringBuilder = new StringBuilder("PA_PSDBrightness");
/*  4250 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4251 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4252 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4253 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4254 */       stringBuilder.append("}");
/*  4255 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_t_dim_fast extends PA_IntBase {
/*       */     public PA_t_dim_fast(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4261 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4266 */       StringBuilder stringBuilder = new StringBuilder("PA_t_dim_fast");
/*  4267 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4268 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4269 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4270 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4271 */       stringBuilder.append("}");
/*  4272 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_t_dim_slow extends PA_IntBase {
/*       */     public PA_t_dim_slow(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4278 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4283 */       StringBuilder stringBuilder = new StringBuilder("PA_t_dim_slow");
/*  4284 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4285 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4286 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4287 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4288 */       stringBuilder.append("}");
/*  4289 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_t_dim_rheo extends PA_IntBase {
/*       */     public PA_t_dim_rheo(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4295 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4300 */       StringBuilder stringBuilder = new StringBuilder("PA_t_dim_rheo");
/*  4301 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4302 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4303 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4304 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4305 */       stringBuilder.append("}");
/*  4306 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LcfgDftBckVal extends PA_IntBase {
/*       */     public PA_LcfgDftBckVal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4312 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4317 */       StringBuilder stringBuilder = new StringBuilder("PA_LcfgDftBckVal");
/*  4318 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4319 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4320 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4321 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4322 */       stringBuilder.append("}");
/*  4323 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LcfgCsdDayVal extends PA_IntBase {
/*       */     public PA_LcfgCsdDayVal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4329 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4334 */       StringBuilder stringBuilder = new StringBuilder("PA_LcfgCsdDayVal");
/*  4335 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4336 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4337 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4338 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4339 */       stringBuilder.append("}");
/*  4340 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LcfgCsdNightVal extends PA_IntBase {
/*       */     public PA_LcfgCsdNightVal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4346 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4351 */       StringBuilder stringBuilder = new StringBuilder("PA_LcfgCsdNightVal");
/*  4352 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4353 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4354 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4355 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4356 */       stringBuilder.append("}");
/*  4357 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LcfgPsdDayVal extends PA_IntBase {
/*       */     public PA_LcfgPsdDayVal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4363 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4368 */       StringBuilder stringBuilder = new StringBuilder("PA_LcfgPsdDayVal");
/*  4369 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4370 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4371 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4372 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4373 */       stringBuilder.append("}");
/*  4374 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LcfgPsdNightVal extends PA_IntBase {
/*       */     public PA_LcfgPsdNightVal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4380 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4385 */       StringBuilder stringBuilder = new StringBuilder("PA_LcfgPsdNightVal");
/*  4386 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4387 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4388 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4389 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4390 */       stringBuilder.append("}");
/*  4391 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LinkSwitch extends PA_IntBase {
/*       */     public PA_LinkSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4397 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4402 */       StringBuilder stringBuilder = new StringBuilder("PA_LinkSwitch");
/*  4403 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4404 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4405 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4406 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4407 */       stringBuilder.append("}");
/*  4408 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PowerSoftKeySwitch extends PA_IntBase {
/*       */     public PA_PowerSoftKeySwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4414 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4419 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4424 */       StringBuilder stringBuilder = new StringBuilder("PA_PowerSoftKeySwitch");
/*  4425 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4426 */       stringBuilder.append(", dataValue = "); stringBuilder.append(BooleanType.toString(this.data));
/*  4427 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4428 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4429 */       stringBuilder.append("}");
/*  4430 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PowerSoftKeyBrightness extends PA_IntBase {
/*       */     public PA_PowerSoftKeyBrightness(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4436 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4441 */       StringBuilder stringBuilder = new StringBuilder("PA_PowerSoftKeyBrightness");
/*  4442 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4443 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4444 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4445 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4446 */       stringBuilder.append("}");
/*  4447 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static class PA_SAP_PrkgUnlck
/*       */   {
/*       */     private int coordinatex;
/*       */     private int coordinatey;
/*       */     private int coordinatez;
/*       */     private int pressst;
/*       */     private int timeday;
/*       */     private int timehour;
/*       */     private int timemill;
/*       */     private int timemin;
/*       */     private int timemonth;
/*       */     private int timesec;
/*       */     private int timeyear;
/*       */     
/*       */     PA_SAP_PrkgUnlck(VendorVehicleHalPAProto.Touchtime param1Touchtime) {
/*  4467 */       this.coordinatex = param1Touchtime.coordinatex;
/*  4468 */       this.coordinatey = param1Touchtime.coordinatey;
/*  4469 */       this.coordinatez = param1Touchtime.coordinatez;
/*  4470 */       this.pressst = param1Touchtime.pressst;
/*  4471 */       this.timeyear = param1Touchtime.timeyear;
/*  4472 */       this.timemonth = param1Touchtime.timemonth;
/*  4473 */       this.timeday = param1Touchtime.timeday;
/*  4474 */       this.timehour = param1Touchtime.timehour;
/*  4475 */       this.timemin = param1Touchtime.timemin;
/*  4476 */       this.timesec = param1Touchtime.timesec;
/*  4477 */       this.timemill = param1Touchtime.timemill;
/*       */     }
/*       */     
/*       */     public int getcoordinatex() {
/*  4481 */       return this.coordinatex;
/*       */     }
/*       */     
/*       */     public int getcoordinatey() {
/*  4485 */       return this.coordinatey;
/*       */     }
/*       */     
/*       */     public int getcoordinatez() {
/*  4489 */       return this.coordinatez;
/*       */     }
/*       */     
/*       */     public int getpressst() {
/*  4493 */       return this.pressst;
/*       */     }
/*       */     
/*       */     public int gettimeyear() {
/*  4497 */       return this.timeyear;
/*       */     }
/*       */     
/*       */     public int gettimemonth() {
/*  4501 */       return this.timemonth;
/*       */     }
/*       */     
/*       */     public int gettimeday() {
/*  4505 */       return this.timeday;
/*       */     }
/*       */     
/*       */     public int gettimehour() {
/*  4509 */       return this.timehour;
/*       */     }
/*       */     
/*       */     public int gettimemin() {
/*  4513 */       return this.timemin;
/*       */     }
/*       */     
/*       */     public int gettimesec() {
/*  4517 */       return this.timesec;
/*       */     }
/*       */     
/*       */     public int gettimemill() {
/*  4521 */       return this.timemill;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4526 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_PrkgUnlck");
/*  4527 */       stringBuilder.append(", coordinatex = "); stringBuilder.append(this.coordinatex);
/*  4528 */       stringBuilder.append(", coordinatey = "); stringBuilder.append(this.coordinatey);
/*  4529 */       stringBuilder.append(", coordinatez = "); stringBuilder.append(this.coordinatez);
/*  4530 */       stringBuilder.append(", pressst = "); stringBuilder.append(this.pressst);
/*  4531 */       stringBuilder.append(", timeyear = "); stringBuilder.append(this.timeyear);
/*  4532 */       stringBuilder.append(", timemonth = "); stringBuilder.append(this.timemonth);
/*  4533 */       stringBuilder.append(", timeday = "); stringBuilder.append(this.timeday);
/*  4534 */       stringBuilder.append(", timehour = "); stringBuilder.append(this.timehour);
/*  4535 */       stringBuilder.append(", timemin = "); stringBuilder.append(this.timemin);
/*  4536 */       stringBuilder.append(", timesec = "); stringBuilder.append(this.timesec);
/*  4537 */       stringBuilder.append(", timemill = "); stringBuilder.append(this.timemill);
/*  4538 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VIN_VinNum extends PA_StringBase {
/*       */     public PA_VIN_VinNum(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4544 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4549 */       StringBuilder stringBuilder = new StringBuilder("PA_VIN_VinNum");
/*  4550 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4551 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4552 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4553 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4554 */       stringBuilder.append("}");
/*  4555 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VP_Version extends PA_StringBase {
/*       */     public PA_VP_Version(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4561 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4566 */       StringBuilder stringBuilder = new StringBuilder("PA_VP_Version");
/*  4567 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4568 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4569 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4570 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4571 */       stringBuilder.append("}");
/*  4572 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Device_IHUID extends PA_StringBase {
/*       */     public PA_Device_IHUID(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4578 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4583 */       StringBuilder stringBuilder = new StringBuilder("PA_Device_IHUID");
/*  4584 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4585 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4586 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4587 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4588 */       stringBuilder.append("}");
/*  4589 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Device_SN extends PA_ByteArrayBase {
/*       */     public PA_Device_SN(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4595 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4600 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  4601 */       for (byte b = 0; b < this.data.length; b++) {
/*  4602 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  4604 */       StringBuilder stringBuilder1 = new StringBuilder("PA_Device_SN");
/*  4605 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  4606 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  4607 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  4608 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  4609 */       stringBuilder1.append("}");
/*  4610 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Device_VPVersion_HD extends PA_StringBase {
/*       */     public PA_Device_VPVersion_HD(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4616 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4621 */       StringBuilder stringBuilder = new StringBuilder("PA_Device_VPVersion_HD");
/*  4622 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4623 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4624 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4625 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4626 */       stringBuilder.append("}");
/*  4627 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Device_Project_Code extends PA_StringBase {
/*       */     public PA_Device_Project_Code(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4633 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4638 */       StringBuilder stringBuilder = new StringBuilder("PA_Device_Project_Code");
/*  4639 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4640 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4641 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4642 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4643 */       stringBuilder.append("}");
/*  4644 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Device_Supplier_Code extends PA_StringBase {
/*       */     public PA_Device_Supplier_Code(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4650 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4655 */       StringBuilder stringBuilder = new StringBuilder("PA_Device_Supplier_Code");
/*  4656 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4657 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  4658 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4659 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4660 */       stringBuilder.append("}");
/*  4661 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ActvSts extends PA_IntBase {
/*       */     public PA_VF_HUD_ActvSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4667 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4672 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4677 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_ActvSts");
/*  4678 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4679 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4680 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4681 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4682 */       stringBuilder.append("}");
/*  4683 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_IllmnReq extends PA_IntBase {
/*       */     public PA_VF_HUD_IllmnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4689 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4694 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4699 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_IllmnReq");
/*  4700 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4701 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Inact.toString(this.data));
/*  4702 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4703 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4704 */       stringBuilder.append("}");
/*  4705 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ErgoAdjmtReq extends PA_IntBase {
/*       */     public PA_VF_HUD_ErgoAdjmtReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4711 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4716 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4721 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_ErgoAdjmtReq");
/*  4722 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4723 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Inact.toString(this.data));
/*  4724 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4725 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4726 */       stringBuilder.append("}");
/*  4727 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ImgRotAdjmtReq extends PA_IntBase {
/*       */     public PA_VF_HUD_ImgRotAdjmtReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4733 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4738 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4743 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_ImgRotAdjmtReq");
/*  4744 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4745 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Inact.toString(this.data));
/*  4746 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4747 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4748 */       stringBuilder.append("}");
/*  4749 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_HudRstForSetgAndData extends PA_IntBase {
/*       */     public PA_VF_HUD_HudRstForSetgAndData(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4755 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4760 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4765 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_HudRstForSetgAndData");
/*  4766 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4767 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4768 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4769 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4770 */       stringBuilder.append("}");
/*  4771 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_HudSnowModeReq extends PA_IntBase {
/*       */     public PA_VF_HUD_HudSnowModeReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4777 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4782 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4787 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_HudSnowModeReq");
/*  4788 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4789 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4790 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4791 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4792 */       stringBuilder.append("}");
/*  4793 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ARActvSts extends PA_IntBase {
/*       */     public PA_VF_HUD_ARActvSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4799 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4804 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4809 */       StringBuilder stringBuilder = new StringBuilder("PA_VF_HUD_ARActvSts");
/*  4810 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4811 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4812 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4813 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4814 */       stringBuilder.append("}");
/*  4815 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ARD300Data extends PA_ByteArrayBase {
/*       */     public PA_VF_HUD_ARD300Data(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4821 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4826 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  4827 */       for (byte b = 0; b < this.data.length; b++) {
/*  4828 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  4830 */       StringBuilder stringBuilder1 = new StringBuilder("PA_VF_HUD_ARD300Data");
/*  4831 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  4832 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  4833 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  4834 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  4835 */       stringBuilder1.append("}");
/*  4836 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ARD310Data extends PA_ByteArrayBase {
/*       */     public PA_VF_HUD_ARD310Data(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4842 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4847 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  4848 */       for (byte b = 0; b < this.data.length; b++) {
/*  4849 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  4851 */       StringBuilder stringBuilder2 = new StringBuilder("PA_VF_HUD_ARD310Data");
/*  4852 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  4853 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  4854 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  4855 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  4856 */       stringBuilder2.append("}");
/*  4857 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VF_HUD_ARD311Data extends PA_ByteArrayBase {
/*       */     public PA_VF_HUD_ARD311Data(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  4863 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4868 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  4869 */       for (byte b = 0; b < this.data.length; b++) {
/*  4870 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  4872 */       StringBuilder stringBuilder2 = new StringBuilder("PA_VF_HUD_ARD311Data");
/*  4873 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  4874 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  4875 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  4876 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  4877 */       stringBuilder2.append("}");
/*  4878 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_IPWakeup extends PA_IntBase {
/*       */     public PA_VFC_IPWakeup(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4884 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4889 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4894 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_IPWakeup");
/*  4895 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4896 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4897 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4898 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4899 */       stringBuilder.append("}");
/*  4900 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_ParkAssiCtrlForHmiCen extends PA_IntBase {
/*       */     public PA_VFC_ParkAssiCtrlForHmiCen(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4906 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4911 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4916 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_ParkAssiCtrlForHmiCen");
/*  4917 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4918 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4919 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4920 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4921 */       stringBuilder.append("}");
/*  4922 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_FaceIdnForHmiCen extends PA_IntBase {
/*       */     public PA_VFC_FaceIdnForHmiCen(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4928 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4933 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4938 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_FaceIdnForHmiCen");
/*  4939 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4940 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4941 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4942 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4943 */       stringBuilder.append("}");
/*  4944 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_TelephoneManager extends PA_IntBase {
/*       */     public PA_VFC_TelephoneManager(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4950 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4955 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4960 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_TelephoneManager");
/*  4961 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4962 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4963 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4964 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4965 */       stringBuilder.append("}");
/*  4966 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehCenClkIndcnAndSetg extends PA_IntBase {
/*       */     public PA_VFC_SetVehCenClkIndcnAndSetg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4972 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4977 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  4982 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehCenClkIndcnAndSetg");
/*  4983 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  4984 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  4985 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  4986 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  4987 */       stringBuilder.append("}");
/*  4988 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehPrivateLock extends PA_IntBase {
/*       */     public PA_VFC_SetVehPrivateLock(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  4994 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  4999 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5004 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehPrivateLock");
/*  5005 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5006 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5007 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5008 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5009 */       stringBuilder.append("}");
/*  5010 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehApa extends PA_IntBase {
/*       */     public PA_VFC_SetVehApa(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5016 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5021 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5026 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehApa");
/*  5027 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5028 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5029 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5030 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5031 */       stringBuilder.append("}");
/*  5032 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehAvm extends PA_IntBase {
/*       */     public PA_VFC_SetVehAvm(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5038 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5043 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5048 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehAvm");
/*  5049 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5050 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5051 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5052 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5053 */       stringBuilder.append("}");
/*  5054 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehTcam extends PA_IntBase {
/*       */     public PA_VFC_SetVehTcam(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5060 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5065 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5070 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehTcam");
/*  5071 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5072 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5073 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5074 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5075 */       stringBuilder.append("}");
/*  5076 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehDvr extends PA_IntBase {
/*       */     public PA_VFC_SetVehDvr(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5082 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5087 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5092 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehDvr");
/*  5093 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5094 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5095 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5096 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5097 */       stringBuilder.append("}");
/*  5098 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFCSetVehCharging extends PA_IntBase {
/*       */     public PA_VFCSetVehCharging(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5104 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5109 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5114 */       StringBuilder stringBuilder = new StringBuilder("PA_VFCSetVehCharging");
/*  5115 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5116 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5117 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5118 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5119 */       stringBuilder.append("}");
/*  5120 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFCGenChaSettingsForHmiCen extends PA_IntBase {
/*       */     public PA_VFCGenChaSettingsForHmiCen(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5126 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5131 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5136 */       StringBuilder stringBuilder = new StringBuilder("PA_VFCGenChaSettingsForHmiCen");
/*  5137 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5138 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5139 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5140 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5141 */       stringBuilder.append("}");
/*  5142 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFCNavigationInfoSharing extends PA_IntBase {
/*       */     public PA_VFCNavigationInfoSharing(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5148 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5153 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5158 */       StringBuilder stringBuilder = new StringBuilder("PA_VFCNavigationInfoSharing");
/*  5159 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5160 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5161 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5162 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5163 */       stringBuilder.append("}");
/*  5164 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_ExteriorLightShowWin extends PA_IntBase {
/*       */     public PA_VFC_ExteriorLightShowWin(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5170 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5175 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5180 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_ExteriorLightShowWin");
/*  5181 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5182 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5183 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5184 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5185 */       stringBuilder.append("}");
/*  5186 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_ExteriorLightShow extends PA_IntBase {
/*       */     public PA_VFC_ExteriorLightShow(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5192 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5197 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5202 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_ExteriorLightShow");
/*  5203 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5204 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5205 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5206 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5207 */       stringBuilder.append("}");
/*  5208 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_VFCRsrv1 extends PA_IntBase {
/*       */     public PA_VFC_VFCRsrv1(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5214 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5219 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_VFCRsrv1");
/*  5220 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5221 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5222 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5223 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5224 */       stringBuilder.append("}");
/*  5225 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_VFCRsrv2 extends PA_IntBase {
/*       */     public PA_VFC_VFCRsrv2(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5231 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5236 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_VFCRsrv2");
/*  5237 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5238 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5239 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5240 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5241 */       stringBuilder.append("}");
/*  5242 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_VFCRsrv3 extends PA_IntBase {
/*       */     public PA_VFC_VFCRsrv3(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5248 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5253 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_VFCRsrv3");
/*  5254 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5255 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5256 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5257 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5258 */       stringBuilder.append("}");
/*  5259 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_VFCRsrv4 extends PA_IntBase {
/*       */     public PA_VFC_VFCRsrv4(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5265 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5270 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_VFCRsrv4");
/*  5271 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5272 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5273 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5274 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5275 */       stringBuilder.append("}");
/*  5276 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_VFCRsrv5 extends PA_IntBase {
/*       */     public PA_VFC_VFCRsrv5(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5282 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5287 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_VFCRsrv5");
/*  5288 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5289 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5290 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5291 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5292 */       stringBuilder.append("}");
/*  5293 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehFace extends PA_IntBase {
/*       */     public PA_VFC_SetVehFace(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5299 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5304 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5309 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehFace");
/*  5310 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5311 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5312 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5313 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5314 */       stringBuilder.append("}");
/*  5315 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_VFC_Reboot extends PA_IntBase {
/*       */     public PA_VFC_VFC_Reboot(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5321 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5326 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5331 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_VFC_Reboot");
/*  5332 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5333 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5334 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5335 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5336 */       stringBuilder.append("}");
/*  5337 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SceneModePDC extends PA_IntBase {
/*       */     public PA_VFC_SceneModePDC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5343 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5348 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5353 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SceneModePDC");
/*  5354 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5355 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5356 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5357 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5358 */       stringBuilder.append("}");
/*  5359 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_SetVehSceneMode extends PA_IntBase {
/*       */     public PA_VFC_SetVehSceneMode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5365 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5370 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5375 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_SetVehSceneMode");
/*  5376 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5377 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5378 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5379 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5380 */       stringBuilder.append("}");
/*  5381 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_McuLog_Panic extends PA_StringBase {
/*       */     public PA_McuLog_Panic(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  5387 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5392 */       StringBuilder stringBuilder = new StringBuilder("PA_McuLog_Panic");
/*  5393 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5394 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5395 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5396 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5397 */       stringBuilder.append("}");
/*  5398 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AR_WarningVlo extends PA_IntBase {
/*       */     public PA_AR_WarningVlo(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5404 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5409 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5414 */       StringBuilder stringBuilder = new StringBuilder("PA_AR_WarningVlo");
/*  5415 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5416 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Co2Lvl.toString(this.data));
/*  5417 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5418 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5419 */       stringBuilder.append("}");
/*  5420 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ErrorReport extends PA_IntBase {
/*       */     public PA_ErrorReport(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5426 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5431 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5436 */       StringBuilder stringBuilder = new StringBuilder("PA_ErrorReport");
/*  5437 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5438 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ComResponse.toString(this.data));
/*  5439 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5440 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5441 */       stringBuilder.append("}");
/*  5442 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DspVersion extends PA_StringBase {
/*       */     public PA_DspVersion(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  5448 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5453 */       StringBuilder stringBuilder = new StringBuilder("PA_DspVersion");
/*  5454 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5455 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5456 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5457 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5458 */       stringBuilder.append("}");
/*  5459 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_SwtDispOnAndOffStsResp extends PA_IntBase {
/*       */     public PA_PAC_SwtDispOnAndOffStsResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5465 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5470 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5475 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_SwtDispOnAndOffStsResp");
/*  5476 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5477 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtDispOnAndOffStsResp1.toString(this.data));
/*  5478 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5479 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5480 */       stringBuilder.append("}");
/*  5481 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_TxStrtVisReq extends PA_IntBase {
/*       */     public PA_PAC_TxStrtVisReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5487 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5492 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5497 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_TxStrtVisReq");
/*  5498 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5499 */       stringBuilder.append(", dataValue = "); stringBuilder.append(TxStrtVisReq1.toString(this.data));
/*  5500 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5501 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5502 */       stringBuilder.append("}");
/*  5503 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_VisnImgAgWide2DInUse extends PA_IntBase {
/*       */     public PA_PAC_VisnImgAgWide2DInUse(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5509 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5514 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5519 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_VisnImgAgWide2DInUse");
/*  5520 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5521 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VisnImgAgWide2D.toString(this.data));
/*  5522 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5523 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5524 */       stringBuilder.append("}");
/*  5525 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_VisnImgAgWide3DInUse extends PA_IntBase {
/*       */     public PA_PAC_VisnImgAgWide3DInUse(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5531 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5536 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5541 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_VisnImgAgWide3DInUse");
/*  5542 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5543 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VisnImgAgWide3D.toString(this.data));
/*  5544 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5545 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5546 */       stringBuilder.append("}");
/*  5547 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_PrkgIndcrLineResp extends PA_IntBase {
/*       */     public PA_PAC_PrkgIndcrLineResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5553 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5558 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5563 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_PrkgIndcrLineResp");
/*  5564 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5565 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5566 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5567 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5568 */       stringBuilder.append("}");
/*  5569 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_VisnAgExtnResp extends PA_IntBase {
/*       */     public PA_PAC_VisnAgExtnResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5575 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5580 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5585 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_VisnAgExtnResp");
/*  5586 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5587 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5588 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5589 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5590 */       stringBuilder.append("}");
/*  5591 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_PedDetnResp extends PA_IntBase {
/*       */     public PA_PAC_PedDetnResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5597 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5602 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5607 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_PedDetnResp");
/*  5608 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5609 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5610 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5611 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5612 */       stringBuilder.append("}");
/*  5613 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_ThrDObjDethResp extends PA_IntBase {
/*       */     public PA_PAC_ThrDObjDethResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5619 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5624 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5629 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_ThrDObjDethResp");
/*  5630 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5631 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5632 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5633 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5634 */       stringBuilder.append("}");
/*  5635 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_ThrDTouringViewResp extends PA_IntBase {
/*       */     public PA_PAC_ThrDTouringViewResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5641 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5646 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5651 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_ThrDTouringViewResp");
/*  5652 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5653 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5654 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5655 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5656 */       stringBuilder.append("}");
/*  5657 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_TurnEntryAgWideVisResp extends PA_IntBase {
/*       */     public PA_PAC_TurnEntryAgWideVisResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5663 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5668 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5673 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_TurnEntryAgWideVisResp");
/*  5674 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5675 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5676 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5677 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5678 */       stringBuilder.append("}");
/*  5679 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_VehMdlClrResp extends PA_IntBase {
/*       */     public PA_PAC_VehMdlClrResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5685 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5690 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5695 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_VehMdlClrResp");
/*  5696 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5697 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5698 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5699 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5700 */       stringBuilder.append("}");
/*  5701 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_RoadCalForVisnAgWideResp extends PA_IntBase {
/*       */     public PA_PAC_RoadCalForVisnAgWideResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5707 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5712 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5717 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_RoadCalForVisnAgWideResp");
/*  5718 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5719 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  5720 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5721 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5722 */       stringBuilder.append("}");
/*  5723 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_PlaModStsResp extends PA_IntBase {
/*       */     public PA_PAC_PlaModStsResp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5729 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5734 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5739 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_PlaModStsResp");
/*  5740 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5741 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PlaModSts.toString(this.data));
/*  5742 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5743 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5744 */       stringBuilder.append("}");
/*  5745 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_ImgSnsrClrReq extends PA_IntBase {
/*       */     public PA_PAC_ImgSnsrClrReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5751 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5756 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5761 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_ImgSnsrClrReq");
/*  5762 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5763 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ImgSnsrClrReq1.toString(this.data));
/*  5764 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5765 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5766 */       stringBuilder.append("}");
/*  5767 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_RctaIndcnLe extends PA_IntBase {
/*       */     public PA_PAC_RctaIndcnLe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5773 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5778 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5783 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_RctaIndcnLe");
/*  5784 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5785 */       stringBuilder.append(", dataValue = "); stringBuilder.append(RctaIndcn.toString(this.data));
/*  5786 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5787 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5788 */       stringBuilder.append("}");
/*  5789 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_RctaIndcnRe extends PA_IntBase {
/*       */     public PA_PAC_RctaIndcnRe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5795 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5800 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5805 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_RctaIndcnRe");
/*  5806 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5807 */       stringBuilder.append(", dataValue = "); stringBuilder.append(RctaIndcn.toString(this.data));
/*  5808 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5809 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5810 */       stringBuilder.append("}");
/*  5811 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SAP_DrvrAsscSysBtnPush extends PA_IntBase {
/*       */     public PA_SAP_DrvrAsscSysBtnPush(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5817 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5822 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5827 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_DrvrAsscSysBtnPush");
/*  5828 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5829 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SapParkingbuttonpush.toString(this.data));
/*  5830 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5831 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5832 */       stringBuilder.append("}");
/*  5833 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SAP_PrkgFctDiDisp extends PA_IntBase {
/*       */     public PA_SAP_PrkgFctDiDisp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5839 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5844 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5849 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_PrkgFctDiDisp");
/*  5850 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5851 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SapParkingbuttonfeedback.toString(this.data));
/*  5852 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5853 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5854 */       stringBuilder.append("}");
/*  5855 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SAP_DrvrAsscSysSts extends PA_IntBase {
/*       */     public PA_SAP_DrvrAsscSysSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5861 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5866 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5871 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_DrvrAsscSysSts");
/*  5872 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5873 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SapParkingexitpicturereturn.toString(this.data));
/*  5874 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5875 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5876 */       stringBuilder.append("}");
/*  5877 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SAP_DrvrAsscSysDisp extends PA_IntBase {
/*       */     public PA_SAP_DrvrAsscSysDisp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5883 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5888 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5893 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_DrvrAsscSysDisp");
/*  5894 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5895 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SapParkingprocesssts.toString(this.data));
/*  5896 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5897 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5898 */       stringBuilder.append("}");
/*  5899 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SAP_PrkgProgsDisp extends PA_IntBase {
/*       */     public PA_SAP_PrkgProgsDisp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5905 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5910 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_PrkgProgsDisp");
/*  5911 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5912 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  5913 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5914 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5915 */       stringBuilder.append("}");
/*  5916 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SAP_TouchUnlckTyp extends PA_IntBase {
/*       */     public PA_SAP_TouchUnlckTyp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5922 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5927 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5932 */       StringBuilder stringBuilder = new StringBuilder("PA_SAP_TouchUnlckTyp");
/*  5933 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5934 */       stringBuilder.append(", dataValue = "); stringBuilder.append(TouchEveTyp.toString(this.data));
/*  5935 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5936 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5937 */       stringBuilder.append("}");
/*  5938 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_PrkgDstCtrlSysSwt extends PA_IntBase {
/*       */     public PA_PAS_PrkgDstCtrlSysSwt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5944 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5949 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5954 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_PrkgDstCtrlSysSwt");
/*  5955 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5956 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasRadarswitchsts.toString(this.data));
/*  5957 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5958 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5959 */       stringBuilder.append("}");
/*  5960 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_PrkgDstCtrlSts extends PA_IntBase {
/*       */     public PA_PAS_PrkgDstCtrlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5966 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5971 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5976 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_PrkgDstCtrlSts");
/*  5977 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  5978 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasRadarworksts.toString(this.data));
/*  5979 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  5980 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  5981 */       stringBuilder.append("}");
/*  5982 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_InsdLeOfSnsrPrkgAssiRe extends PA_IntBase {
/*       */     public PA_PAS_InsdLeOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  5988 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  5993 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  5998 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_InsdLeOfSnsrPrkgAssiRe");
/*  5999 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6000 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6001 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6002 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6003 */       stringBuilder.append("}");
/*  6004 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_InsdRiOfSnsrPrkgAssiRe extends PA_IntBase {
/*       */     public PA_PAS_InsdRiOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6010 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6015 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6020 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_InsdRiOfSnsrPrkgAssiRe");
/*  6021 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6022 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6023 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6024 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6025 */       stringBuilder.append("}");
/*  6026 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_OutdLeOfSnsrPrkgAssiRe extends PA_IntBase {
/*       */     public PA_PAS_OutdLeOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6032 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6037 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6042 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_OutdLeOfSnsrPrkgAssiRe");
/*  6043 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6044 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6045 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6046 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6047 */       stringBuilder.append("}");
/*  6048 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_OutdRiOfSnsrPrkgAssiRe extends PA_IntBase {
/*       */     public PA_PAS_OutdRiOfSnsrPrkgAssiRe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6054 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6059 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6064 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_OutdRiOfSnsrPrkgAssiRe");
/*  6065 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6066 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6067 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6068 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6069 */       stringBuilder.append("}");
/*  6070 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_InsdLeOfSnsrPrkgAssiFrnt extends PA_IntBase {
/*       */     public PA_PAS_InsdLeOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6076 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6081 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6086 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_InsdLeOfSnsrPrkgAssiFrnt");
/*  6087 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6088 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6089 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6090 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6091 */       stringBuilder.append("}");
/*  6092 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_InsdRiOfSnsrPrkgAssiFrnt extends PA_IntBase {
/*       */     public PA_PAS_InsdRiOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6098 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6103 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6108 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_InsdRiOfSnsrPrkgAssiFrnt");
/*  6109 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6110 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6111 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6112 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6113 */       stringBuilder.append("}");
/*  6114 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_OutdLeOfSnsrPrkgAssiFrnt extends PA_IntBase {
/*       */     public PA_PAS_OutdLeOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6120 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6125 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6130 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_OutdLeOfSnsrPrkgAssiFrnt");
/*  6131 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6132 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6133 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6134 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6135 */       stringBuilder.append("}");
/*  6136 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_OutdRiOfSnsrPrkgAssiFrnt extends PA_IntBase {
/*       */     public PA_PAS_OutdRiOfSnsrPrkgAssiFrnt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6142 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6147 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6152 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_OutdRiOfSnsrPrkgAssiFrnt");
/*  6153 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6154 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSensorchecksection.toString(this.data));
/*  6155 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6156 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6157 */       stringBuilder.append("}");
/*  6158 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_AudWarnOfSnsrParkAssiRe extends PA_IntBase {
/*       */     public PA_PAS_AudWarnOfSnsrParkAssiRe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6164 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6169 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6174 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_AudWarnOfSnsrParkAssiRe");
/*  6175 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6176 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSpeakeralarmfeedback.toString(this.data));
/*  6177 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6178 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6179 */       stringBuilder.append("}");
/*  6180 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_AudWarnOfSnsrParkAssiFrnt extends PA_IntBase {
/*       */     public PA_PAS_AudWarnOfSnsrParkAssiFrnt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6186 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6191 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6196 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_AudWarnOfSnsrParkAssiFrnt");
/*  6197 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6198 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSpeakeralarmfeedback.toString(this.data));
/*  6199 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6200 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6201 */       stringBuilder.append("}");
/*  6202 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PEB_PrkgEmgBrkSysSwt extends PA_IntBase {
/*       */     public PA_PEB_PrkgEmgBrkSysSwt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6208 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6213 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6218 */       StringBuilder stringBuilder = new StringBuilder("PA_PEB_PrkgEmgBrkSysSwt");
/*  6219 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6220 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PebSwitchsts.toString(this.data));
/*  6221 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6222 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6223 */       stringBuilder.append("}");
/*  6224 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PEB_PrkgEmgyBrkSysSts extends PA_IntBase {
/*       */     public PA_PEB_PrkgEmgyBrkSysSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6230 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6235 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6240 */       StringBuilder stringBuilder = new StringBuilder("PA_PEB_PrkgEmgyBrkSysSts");
/*  6241 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6242 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PebWorkingstate.toString(this.data));
/*  6243 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6244 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6245 */       stringBuilder.append("}");
/*  6246 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_SnsrFltStsWarn extends PA_IntBase {
/*       */     public PA_PAS_SnsrFltStsWarn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6252 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6257 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6262 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_SnsrFltStsWarn");
/*  6263 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6264 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PasSnsrfltstswarn.toString(this.data));
/*  6265 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6266 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6267 */       stringBuilder.append("}");
/*  6268 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatExtAdjAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatExtAdjAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6274 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6279 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatExtAdjAllowd");
/*  6280 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6281 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6282 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6283 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6284 */       stringBuilder.append("}");
/*  6285 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtSldSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6291 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6296 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6301 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtSldSts");
/*  6302 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6303 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  6304 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6305 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6306 */       stringBuilder.append("}");
/*  6307 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatExtAdjAllowd extends PA_IntBase {
/*       */     public PA_PassSeatExtAdjAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6313 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6318 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatExtAdjAllowd");
/*  6319 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6320 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6321 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6322 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6323 */       stringBuilder.append("}");
/*  6324 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtSldSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6330 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6335 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6340 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtSldSts");
/*  6341 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6342 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  6343 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6344 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6345 */       stringBuilder.append("}");
/*  6346 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtHeiStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtHeiStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6352 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6357 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtHeiStsAllowd");
/*  6358 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6359 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6360 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6361 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6362 */       stringBuilder.append("}");
/*  6363 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtHeiSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtHeiSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6369 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6374 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6379 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtHeiSts");
/*  6380 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6381 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  6382 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6383 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6384 */       stringBuilder.append("}");
/*  6385 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtHeiStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatSwtHeiStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6391 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6396 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtHeiStsAllowd");
/*  6397 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6398 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6399 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6400 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6401 */       stringBuilder.append("}");
/*  6402 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtHeiSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtHeiSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6408 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6413 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6418 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtHeiSts");
/*  6419 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6420 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  6421 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6422 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6423 */       stringBuilder.append("}");
/*  6424 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtHeiFrntStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtHeiFrntStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6430 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6435 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtHeiFrntStsAllowd");
/*  6436 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6437 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6438 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6439 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6440 */       stringBuilder.append("}");
/*  6441 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtHeiFrntSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtHeiFrntSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6447 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6452 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6457 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtHeiFrntSts");
/*  6458 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6459 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  6460 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6461 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6462 */       stringBuilder.append("}");
/*  6463 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtHeiFrntStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatSwtHeiFrntStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6469 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6474 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtHeiFrntStsAllowd");
/*  6475 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6476 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6477 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6478 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6479 */       stringBuilder.append("}");
/*  6480 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtHeiFrntSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtHeiFrntSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6486 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6491 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6496 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtHeiFrntSts");
/*  6497 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6498 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  6499 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6500 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6501 */       stringBuilder.append("}");
/*  6502 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtInclStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtInclStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6508 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6513 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtInclStsAllowd");
/*  6514 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6515 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6516 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6517 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6518 */       stringBuilder.append("}");
/*  6519 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtInclSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6525 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6530 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6535 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtInclSts");
/*  6536 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6537 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  6538 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6539 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6540 */       stringBuilder.append("}");
/*  6541 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtInclStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatSwtInclStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6547 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6552 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtInclStsAllowd");
/*  6553 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6554 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6555 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6556 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6557 */       stringBuilder.append("}");
/*  6558 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtInclSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6564 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6569 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6574 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtInclSts");
/*  6575 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6576 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  6577 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6578 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6579 */       stringBuilder.append("}");
/*  6580 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_EasyInOutDrvrSeatAllowd extends PA_IntBase {
/*       */     public PA_EasyInOutDrvrSeatAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6586 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6591 */       StringBuilder stringBuilder = new StringBuilder("PA_EasyInOutDrvrSeatAllowd");
/*  6592 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6593 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6594 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6595 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6596 */       stringBuilder.append("}");
/*  6597 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_EasyInOutDrvrSeatAdjmt extends PA_IntBase {
/*       */     public PA_EasyInOutDrvrSeatAdjmt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6603 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6608 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6613 */       StringBuilder stringBuilder = new StringBuilder("PA_EasyInOutDrvrSeatAdjmt");
/*  6614 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6615 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  6616 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6617 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6618 */       stringBuilder.append("}");
/*  6619 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatActvSpplFct extends PA_IntBase {
/*       */     public PA_DrvrSeatActvSpplFct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6625 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6630 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6635 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatActvSpplFct");
/*  6636 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6637 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatActvSpplFct1.toString(this.data));
/*  6638 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6639 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6640 */       stringBuilder.append("}");
/*  6641 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatActvSpplFct extends PA_IntBase {
/*       */     public PA_PassSeatActvSpplFct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6647 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6652 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6657 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatActvSpplFct");
/*  6658 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6659 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SeatActvSpplFct1.toString(this.data));
/*  6660 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6661 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6662 */       stringBuilder.append("}");
/*  6663 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtAdjmtOfSpplFctVertSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtAdjmtOfSpplFctVertSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6669 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6674 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6679 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtAdjmtOfSpplFctVertSts");
/*  6680 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6681 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  6682 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6683 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6684 */       stringBuilder.append("}");
/*  6685 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6691 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6696 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6701 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtAdjmtOfSpplFctHozlSts");
/*  6702 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6703 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  6704 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6705 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6706 */       stringBuilder.append("}");
/*  6707 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtAdjmtOfSpplFctVertSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtAdjmtOfSpplFctVertSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6713 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6718 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6723 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtAdjmtOfSpplFctVertSts");
/*  6724 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6725 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  6726 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6727 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6728 */       stringBuilder.append("}");
/*  6729 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtAdjmtOfSpplFctHozlSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtAdjmtOfSpplFctHozlSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6735 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6740 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6745 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtAdjmtOfSpplFctHozlSts");
/*  6746 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6747 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  6748 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6749 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6750 */       stringBuilder.append("}");
/*  6751 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatLmbrFwdBackwStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatLmbrFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6757 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6762 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatLmbrFwdBackwStsAllowd");
/*  6763 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6764 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6765 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6766 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6767 */       stringBuilder.append("}");
/*  6768 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatLmbrUpDownStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatLmbrUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6774 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6779 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatLmbrUpDownStsAllowd");
/*  6780 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6781 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6782 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6783 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6784 */       stringBuilder.append("}");
/*  6785 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatLmbrFwdBackwStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatLmbrFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6791 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6796 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatLmbrFwdBackwStsAllowd");
/*  6797 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6798 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6799 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6800 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6801 */       stringBuilder.append("}");
/*  6802 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatLmbrUpDownStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatLmbrUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6808 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6813 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatLmbrUpDownStsAllowd");
/*  6814 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6815 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6816 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6817 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6818 */       stringBuilder.append("}");
/*  6819 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSideFwdBackwStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatSideFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6825 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6830 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSideFwdBackwStsAllowd");
/*  6831 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6832 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6833 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6834 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6835 */       stringBuilder.append("}");
/*  6836 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSideFwdBackwStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatSideFwdBackwStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6842 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6847 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSideFwdBackwStsAllowd");
/*  6848 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6849 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6850 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6851 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6852 */       stringBuilder.append("}");
/*  6853 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSideUpDownStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatSideUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6859 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6864 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSideUpDownStsAllowd");
/*  6865 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6866 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6867 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6868 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6869 */       stringBuilder.append("}");
/*  6870 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSideUpDownStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatSideUpDownStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6876 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6881 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSideUpDownStsAllowd");
/*  6882 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6883 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6884 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6885 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6886 */       stringBuilder.append("}");
/*  6887 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatCushExtStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatCushExtStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6893 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6898 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatCushExtStsAllowd");
/*  6899 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6900 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6901 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6902 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6903 */       stringBuilder.append("}");
/*  6904 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatCushExtStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatCushExtStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6910 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6915 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatCushExtStsAllowd");
/*  6916 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6917 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6918 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6919 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6920 */       stringBuilder.append("}");
/*  6921 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatMassageStsAllowd extends PA_IntBase {
/*       */     public PA_DrvrSeatMassageStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6927 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6932 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatMassageStsAllowd");
/*  6933 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6934 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  6935 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6936 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6937 */       stringBuilder.append("}");
/*  6938 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatDispMassgFct_OnOff extends PA_IntBase {
/*       */     public PA_DrvrSeatDispMassgFct_OnOff(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6944 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6949 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6954 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatDispMassgFct_OnOff");
/*  6955 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6956 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  6957 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6958 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6959 */       stringBuilder.append("}");
/*  6960 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatDispMassgFct_MassgProg extends PA_IntBase {
/*       */     public PA_DrvrSeatDispMassgFct_MassgProg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6966 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6971 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6976 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatDispMassgFct_MassgProg");
/*  6977 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  6978 */       stringBuilder.append(", dataValue = "); stringBuilder.append(MassgProgTyp.toString(this.data));
/*  6979 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  6980 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  6981 */       stringBuilder.append("}");
/*  6982 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatDispMassgFct_MassgInten extends PA_IntBase {
/*       */     public PA_DrvrSeatDispMassgFct_MassgInten(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  6988 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  6993 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  6998 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatDispMassgFct_MassgInten");
/*  6999 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7000 */       stringBuilder.append(", dataValue = "); stringBuilder.append(MassgIntenLvl.toString(this.data));
/*  7001 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7002 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7003 */       stringBuilder.append("}");
/*  7004 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatMassageStsAllowd extends PA_IntBase {
/*       */     public PA_PassSeatMassageStsAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7010 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7015 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatMassageStsAllowd");
/*  7016 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7017 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7018 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7019 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7020 */       stringBuilder.append("}");
/*  7021 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatDispMassgFct_OnOff extends PA_IntBase {
/*       */     public PA_PassSeatDispMassgFct_OnOff(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7027 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7032 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7037 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatDispMassgFct_OnOff");
/*  7038 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7039 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7040 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7041 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7042 */       stringBuilder.append("}");
/*  7043 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatDispMassgFct_MassgProg extends PA_IntBase {
/*       */     public PA_PassSeatDispMassgFct_MassgProg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7049 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7054 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7059 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatDispMassgFct_MassgProg");
/*  7060 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7061 */       stringBuilder.append(", dataValue = "); stringBuilder.append(MassgProgTyp.toString(this.data));
/*  7062 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7063 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7064 */       stringBuilder.append("}");
/*  7065 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatDispMassgFct_MassgInten extends PA_IntBase {
/*       */     public PA_PassSeatDispMassgFct_MassgInten(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7071 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7076 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7081 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatDispMassgFct_MassgInten");
/*  7082 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7083 */       stringBuilder.append(", dataValue = "); stringBuilder.append(MassgIntenLvl.toString(this.data));
/*  7084 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7085 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7086 */       stringBuilder.append("}");
/*  7087 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrMassgRunng extends PA_IntBase {
/*       */     public PA_DrvrMassgRunng(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7093 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7098 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7103 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrMassgRunng");
/*  7104 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7105 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7106 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7107 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7108 */       stringBuilder.append("}");
/*  7109 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassMassgRunng extends PA_IntBase {
/*       */     public PA_PassMassgRunng(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7115 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7120 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7125 */       StringBuilder stringBuilder = new StringBuilder("PA_PassMassgRunng");
/*  7126 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7127 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7128 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7129 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7130 */       stringBuilder.append("}");
/*  7131 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrMultFuncMenuExt extends PA_IntBase {
/*       */     public PA_DrvrMultFuncMenuExt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7137 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7142 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7147 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrMultFuncMenuExt");
/*  7148 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7149 */       stringBuilder.append(", dataValue = "); stringBuilder.append(BooleanType.toString(this.data));
/*  7150 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7151 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7152 */       stringBuilder.append("}");
/*  7153 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassMultFuncMenuExt extends PA_IntBase {
/*       */     public PA_PassMultFuncMenuExt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7159 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7164 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7169 */       StringBuilder stringBuilder = new StringBuilder("PA_PassMultFuncMenuExt");
/*  7170 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7171 */       stringBuilder.append(", dataValue = "); stringBuilder.append(BooleanType.toString(this.data));
/*  7172 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7173 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7174 */       stringBuilder.append("}");
/*  7175 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SeatFoldRaiseRowThrdLeAllowd extends PA_IntBase {
/*       */     public PA_SeatFoldRaiseRowThrdLeAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7181 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7186 */       StringBuilder stringBuilder = new StringBuilder("PA_SeatFoldRaiseRowThrdLeAllowd");
/*  7187 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7188 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7189 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7190 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7191 */       stringBuilder.append("}");
/*  7192 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SeatFoldRaiseRowThrdRiAllowd extends PA_IntBase {
/*       */     public PA_SeatFoldRaiseRowThrdRiAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7198 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7203 */       StringBuilder stringBuilder = new StringBuilder("PA_SeatFoldRaiseRowThrdRiAllowd");
/*  7204 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7205 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7206 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7207 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7208 */       stringBuilder.append("}");
/*  7209 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SecRowSeatLenLeFwdBackwAllowd extends PA_IntBase {
/*       */     public PA_SecRowSeatLenLeFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7215 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7220 */       StringBuilder stringBuilder = new StringBuilder("PA_SecRowSeatLenLeFwdBackwAllowd");
/*  7221 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7222 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7223 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7224 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7225 */       stringBuilder.append("}");
/*  7226 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SeatRowSecLeSwtStsPassSeatSwtSldSts extends PA_IntBase {
/*       */     public PA_SeatRowSecLeSwtStsPassSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7232 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7237 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7242 */       StringBuilder stringBuilder = new StringBuilder("PA_SeatRowSecLeSwtStsPassSeatSwtSldSts");
/*  7243 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7244 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  7245 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7246 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7247 */       stringBuilder.append("}");
/*  7248 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SecRowSeatLenRiFwdBackwAllowd extends PA_IntBase {
/*       */     public PA_SecRowSeatLenRiFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7254 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7259 */       StringBuilder stringBuilder = new StringBuilder("PA_SecRowSeatLenRiFwdBackwAllowd");
/*  7260 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7261 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7262 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7263 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7264 */       stringBuilder.append("}");
/*  7265 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SeatRowSecRiSwtStsPassSeatSwtSldSts extends PA_IntBase {
/*       */     public PA_SeatRowSecRiSwtStsPassSeatSwtSldSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7271 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7276 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7281 */       StringBuilder stringBuilder = new StringBuilder("PA_SeatRowSecRiSwtStsPassSeatSwtSldSts");
/*  7282 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7283 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  7284 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7285 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7286 */       stringBuilder.append("}");
/*  7287 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SecRowSeatInclLeFwdBackwAllowd extends PA_IntBase {
/*       */     public PA_SecRowSeatInclLeFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7293 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7298 */       StringBuilder stringBuilder = new StringBuilder("PA_SecRowSeatInclLeFwdBackwAllowd");
/*  7299 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7300 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7301 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7302 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7303 */       stringBuilder.append("}");
/*  7304 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SecRowSeatInclRiFwdBackwAllowd extends PA_IntBase {
/*       */     public PA_SecRowSeatInclRiFwdBackwAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7310 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7315 */       StringBuilder stringBuilder = new StringBuilder("PA_SecRowSeatInclRiFwdBackwAllowd");
/*  7316 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7317 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7318 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7319 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7320 */       stringBuilder.append("}");
/*  7321 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SeatRowSecLeSwtStsPassSeatSwtInclSts extends PA_IntBase {
/*       */     public PA_SeatRowSecLeSwtStsPassSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7327 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7332 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7337 */       StringBuilder stringBuilder = new StringBuilder("PA_SeatRowSecLeSwtStsPassSeatSwtInclSts");
/*  7338 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7339 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  7340 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7341 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7342 */       stringBuilder.append("}");
/*  7343 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SeatRowSecRiSwtStsPassSeatSwtInclSts extends PA_IntBase {
/*       */     public PA_SeatRowSecRiSwtStsPassSeatSwtInclSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7349 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7354 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7359 */       StringBuilder stringBuilder = new StringBuilder("PA_SeatRowSecRiSwtStsPassSeatSwtInclSts");
/*  7360 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7361 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtHozlSts1.toString(this.data));
/*  7362 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7363 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7364 */       stringBuilder.append("}");
/*  7365 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HotStoneMassageDrvrAllowd extends PA_IntBase {
/*       */     public PA_HotStoneMassageDrvrAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7371 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7376 */       StringBuilder stringBuilder = new StringBuilder("PA_HotStoneMassageDrvrAllowd");
/*  7377 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7378 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7379 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7380 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7381 */       stringBuilder.append("}");
/*  7382 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HotStoneMassagePassAllowd extends PA_IntBase {
/*       */     public PA_HotStoneMassagePassAllowd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7388 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7393 */       StringBuilder stringBuilder = new StringBuilder("PA_HotStoneMassagePassAllowd");
/*  7394 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7395 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  7396 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7397 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7398 */       stringBuilder.append("}");
/*  7399 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DrvrSeatSwtSelnOfSpplFctSts extends PA_IntBase {
/*       */     public PA_DrvrSeatSwtSelnOfSpplFctSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7405 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7410 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7415 */       StringBuilder stringBuilder = new StringBuilder("PA_DrvrSeatSwtSelnOfSpplFctSts");
/*  7416 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7417 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  7418 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7419 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7420 */       stringBuilder.append("}");
/*  7421 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PassSeatSwtSelnOfSpplFctSts extends PA_IntBase {
/*       */     public PA_PassSeatSwtSelnOfSpplFctSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7427 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7432 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7437 */       StringBuilder stringBuilder = new StringBuilder("PA_PassSeatSwtSelnOfSpplFctSts");
/*  7438 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7439 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SwtVertSts1.toString(this.data));
/*  7440 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7441 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7442 */       stringBuilder.append("}");
/*  7443 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WPC_Setting extends PA_IntBase {
/*       */     public PA_WPC_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7449 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7454 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7459 */       StringBuilder stringBuilder = new StringBuilder("PA_WPC_Setting");
/*  7460 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7461 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7462 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7463 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7464 */       stringBuilder.append("}");
/*  7465 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WPC_InchargeStatus extends PA_IntBase {
/*       */     public PA_WPC_InchargeStatus(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7471 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7476 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7481 */       StringBuilder stringBuilder = new StringBuilder("PA_WPC_InchargeStatus");
/*  7482 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7483 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WPCModuleSts.toString(this.data));
/*  7484 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7485 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7486 */       stringBuilder.append("}");
/*  7487 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WPC_PhoneForget extends PA_IntBase {
/*       */     public PA_WPC_PhoneForget(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7493 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7498 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7503 */       StringBuilder stringBuilder = new StringBuilder("PA_WPC_PhoneForget");
/*  7504 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7505 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7506 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7507 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7508 */       stringBuilder.append("}");
/*  7509 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_UUN_PasArmngSts extends PA_IntBase {
/*       */     public PA_UUN_PasArmngSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7515 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7520 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7525 */       StringBuilder stringBuilder = new StringBuilder("PA_UUN_PasArmngSts");
/*  7526 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7527 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7528 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7529 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7530 */       stringBuilder.append("}");
/*  7531 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_UUN_RedGuardSts extends PA_IntBase {
/*       */     public PA_UUN_RedGuardSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7537 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7542 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7547 */       StringBuilder stringBuilder = new StringBuilder("PA_UUN_RedGuardSts");
/*  7548 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7549 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7550 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7551 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7552 */       stringBuilder.append("}");
/*  7553 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FindCaReminder_Setting extends PA_IntBase {
/*       */     public PA_FindCaReminder_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7559 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7564 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7569 */       StringBuilder stringBuilder = new StringBuilder("PA_FindCaReminder_Setting");
/*  7570 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7571 */       stringBuilder.append(", dataValue = "); stringBuilder.append(CarFindrHornLiSetActv.toString(this.data));
/*  7572 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7573 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7574 */       stringBuilder.append("}");
/*  7575 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Steer_SteerAsscLvl extends PA_IntBase {
/*       */     public PA_Steer_SteerAsscLvl(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7581 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7586 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7591 */       StringBuilder stringBuilder = new StringBuilder("PA_Steer_SteerAsscLvl");
/*  7592 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7593 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SteerAsscLvl.toString(this.data));
/*  7594 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7595 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7596 */       stringBuilder.append("}");
/*  7597 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Steer_SteeringMod extends PA_IntBase {
/*       */     public PA_Steer_SteeringMod(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7603 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7608 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7613 */       StringBuilder stringBuilder = new StringBuilder("PA_Steer_SteeringMod");
/*  7614 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7615 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SteerMod.toString(this.data));
/*  7616 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7617 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7618 */       stringBuilder.append("}");
/*  7619 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SteeringWheelPosAdj extends PA_IntBase {
/*       */     public PA_SteeringWheelPosAdj(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7625 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7630 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7635 */       StringBuilder stringBuilder = new StringBuilder("PA_SteeringWheelPosAdj");
/*  7636 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7637 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7638 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7639 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7640 */       stringBuilder.append("}");
/*  7641 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SS_Activation extends PA_IntBase {
/*       */     public PA_SS_Activation(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7647 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7652 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7657 */       StringBuilder stringBuilder = new StringBuilder("PA_SS_Activation");
/*  7658 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7659 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7660 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7661 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7662 */       stringBuilder.append("}");
/*  7663 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PBC_ESCSportActiv extends PA_IntBase {
/*       */     public PA_PBC_ESCSportActiv(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7669 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7674 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7679 */       StringBuilder stringBuilder = new StringBuilder("PA_PBC_ESCSportActiv");
/*  7680 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7681 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7682 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7683 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7684 */       stringBuilder.append("}");
/*  7685 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AFSLight_Setting extends PA_IntBase {
/*       */     public PA_AFSLight_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7691 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7696 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7701 */       StringBuilder stringBuilder = new StringBuilder("PA_AFSLight_Setting");
/*  7702 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7703 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7704 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7705 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7706 */       stringBuilder.append("}");
/*  7707 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CornrgLi_Setting extends PA_IntBase {
/*       */     public PA_CornrgLi_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7713 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7718 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7723 */       StringBuilder stringBuilder = new StringBuilder("PA_CornrgLi_Setting");
/*  7724 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7725 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7726 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7727 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7728 */       stringBuilder.append("}");
/*  7729 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AL_HomeSafeLight extends PA_IntBase {
/*       */     public PA_AL_HomeSafeLight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7735 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7740 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7745 */       StringBuilder stringBuilder = new StringBuilder("PA_AL_HomeSafeLight");
/*  7746 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7747 */       stringBuilder.append(", dataValue = "); stringBuilder.append(LiTi2.toString(this.data));
/*  7748 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7749 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7750 */       stringBuilder.append("}");
/*  7751 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ApproachLightOnOff_Setting extends PA_IntBase {
/*       */     public PA_ApproachLightOnOff_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7757 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7762 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7767 */       StringBuilder stringBuilder = new StringBuilder("PA_ApproachLightOnOff_Setting");
/*  7768 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7769 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7770 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7771 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7772 */       stringBuilder.append("}");
/*  7773 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_BendingLight extends PA_IntBase {
/*       */     public PA_BendingLight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7779 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7784 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7789 */       StringBuilder stringBuilder = new StringBuilder("PA_BendingLight");
/*  7790 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7791 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7792 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7793 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7794 */       stringBuilder.append("}");
/*  7795 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LeftRightSetting extends PA_IntBase {
/*       */     public PA_LeftRightSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7801 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7806 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7811 */       StringBuilder stringBuilder = new StringBuilder("PA_LeftRightSetting");
/*  7812 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7813 */       stringBuilder.append(", dataValue = "); stringBuilder.append(RiLeTyp.toString(this.data));
/*  7814 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7815 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7816 */       stringBuilder.append("}");
/*  7817 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WelGoodbyeLightSwitch extends PA_IntBase {
/*       */     public PA_WelGoodbyeLightSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7823 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7828 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7833 */       StringBuilder stringBuilder = new StringBuilder("PA_WelGoodbyeLightSwitch");
/*  7834 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7835 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7836 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7837 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7838 */       stringBuilder.append("}");
/*  7839 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WelGoodbyeLightMod extends PA_IntBase {
/*       */     public PA_WelGoodbyeLightMod(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7845 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7850 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7855 */       StringBuilder stringBuilder = new StringBuilder("PA_WelGoodbyeLightMod");
/*  7856 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7857 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ModeReq.toString(this.data));
/*  7858 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7859 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7860 */       stringBuilder.append("}");
/*  7861 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_RearMirrorFold_Auto extends PA_IntBase {
/*       */     public PA_RearMirrorFold_Auto(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7867 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7872 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7877 */       StringBuilder stringBuilder = new StringBuilder("PA_RearMirrorFold_Auto");
/*  7878 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7879 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7880 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7881 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7882 */       stringBuilder.append("}");
/*  7883 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_MirrTiltSetg extends PA_IntBase {
/*       */     public PA_MirrTiltSetg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7889 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7894 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7899 */       StringBuilder stringBuilder = new StringBuilder("PA_MirrTiltSetg");
/*  7900 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7901 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VFMiscMirrTiltSetg.toString(this.data));
/*  7902 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7903 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7904 */       stringBuilder.append("}");
/*  7905 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HillDescentSetting extends PA_IntBase {
/*       */     public PA_HillDescentSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7911 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7916 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7921 */       StringBuilder stringBuilder = new StringBuilder("PA_HillDescentSetting");
/*  7922 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7923 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  7924 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7925 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7926 */       stringBuilder.append("}");
/*  7927 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_EasyEntrySetting extends PA_IntBase {
/*       */     public PA_EasyEntrySetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7933 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7938 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7943 */       StringBuilder stringBuilder = new StringBuilder("PA_EasyEntrySetting");
/*  7944 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7945 */       stringBuilder.append(", dataValue = "); stringBuilder.append(NoYes1.toString(this.data));
/*  7946 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7947 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7948 */       stringBuilder.append("}");
/*  7949 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DeacLevCtrSetting extends PA_IntBase {
/*       */     public PA_DeacLevCtrSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7955 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7960 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7965 */       StringBuilder stringBuilder = new StringBuilder("PA_DeacLevCtrSetting");
/*  7966 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7967 */       stringBuilder.append(", dataValue = "); stringBuilder.append(BooleanType.toString(this.data));
/*  7968 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7969 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7970 */       stringBuilder.append("}");
/*  7971 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SuspHeiSetting extends PA_IntBase {
/*       */     public PA_SuspHeiSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7977 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  7982 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  7987 */       StringBuilder stringBuilder = new StringBuilder("PA_SuspHeiSetting");
/*  7988 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  7989 */       stringBuilder.append(", dataValue = "); stringBuilder.append(SuspHeiLvlCtrl.toString(this.data));
/*  7990 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  7991 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  7992 */       stringBuilder.append("}");
/*  7993 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SuspMoveDirInform extends PA_IntBase {
/*       */     public PA_SuspMoveDirInform(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  7999 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8004 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8009 */       StringBuilder stringBuilder = new StringBuilder("PA_SuspMoveDirInform");
/*  8010 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8011 */       stringBuilder.append(", dataValue = "); stringBuilder.append(TriSt1.toString(this.data));
/*  8012 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8013 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8014 */       stringBuilder.append("}");
/*  8015 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_EPBAutoApply extends PA_IntBase {
/*       */     public PA_EPBAutoApply(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8021 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8026 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8031 */       StringBuilder stringBuilder = new StringBuilder("PA_EPBAutoApply");
/*  8032 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8033 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8034 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8035 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8036 */       stringBuilder.append("}");
/*  8037 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AutoHoldStatus extends PA_IntBase {
/*       */     public PA_AutoHoldStatus(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8043 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8048 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8053 */       StringBuilder stringBuilder = new StringBuilder("PA_AutoHoldStatus");
/*  8054 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8055 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8056 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8057 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8058 */       stringBuilder.append("}");
/*  8059 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Total_Traveled_Distance extends PA_IntBase {
/*       */     public PA_Total_Traveled_Distance(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8065 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8070 */       StringBuilder stringBuilder = new StringBuilder("PA_Total_Traveled_Distance");
/*  8071 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8072 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8073 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8074 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8075 */       stringBuilder.append("}");
/*  8076 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_External_Sound_Setting extends PA_IntBase {
/*       */     public PA_External_Sound_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8082 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8087 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8092 */       StringBuilder stringBuilder = new StringBuilder("PA_External_Sound_Setting");
/*  8093 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8094 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8095 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8096 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8097 */       stringBuilder.append("}");
/*  8098 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SpeedWarnSet extends PA_IntBase {
/*       */     public PA_SpeedWarnSet(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8104 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8109 */       StringBuilder stringBuilder = new StringBuilder("PA_SpeedWarnSet");
/*  8110 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8111 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8112 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8113 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8114 */       stringBuilder.append("}");
/*  8115 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LowAlarmVolSet extends PA_IntBase {
/*       */     public PA_LowAlarmVolSet(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8121 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8126 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8131 */       StringBuilder stringBuilder = new StringBuilder("PA_LowAlarmVolSet");
/*  8132 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8133 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ClassnQly.toString(this.data));
/*  8134 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8135 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8136 */       stringBuilder.append("}");
/*  8137 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SpeedWarnOnOff extends PA_IntBase {
/*       */     public PA_SpeedWarnOnOff(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8143 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8148 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8153 */       StringBuilder stringBuilder = new StringBuilder("PA_SpeedWarnOnOff");
/*  8154 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8155 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8156 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8157 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8158 */       stringBuilder.append("}");
/*  8159 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SpeedWarnSpeedLimit extends PA_IntBase {
/*       */     public PA_SpeedWarnSpeedLimit(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8165 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8170 */       StringBuilder stringBuilder = new StringBuilder("PA_SpeedWarnSpeedLimit");
/*  8171 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8172 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8173 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8174 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8175 */       stringBuilder.append("}");
/*  8176 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SailingSwitch extends PA_IntBase {
/*       */     public PA_SailingSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8182 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8187 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8192 */       StringBuilder stringBuilder = new StringBuilder("PA_SailingSwitch");
/*  8193 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8194 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ActvnAvl3.toString(this.data));
/*  8195 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8196 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8197 */       stringBuilder.append("}");
/*  8198 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PowerFlow extends PA_IntBase {
/*       */     public PA_PowerFlow(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8204 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8209 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8214 */       StringBuilder stringBuilder = new StringBuilder("PA_PowerFlow");
/*  8215 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8216 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DispOfPrpsnMod4.toString(this.data));
/*  8217 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8218 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8219 */       stringBuilder.append("}");
/*  8220 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PowerFlow_MHEV extends PA_IntBase {
/*       */     public PA_PowerFlow_MHEV(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8226 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8231 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8236 */       StringBuilder stringBuilder = new StringBuilder("PA_PowerFlow_MHEV");
/*  8237 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8238 */       stringBuilder.append(", dataValue = "); stringBuilder.append(MvIsgRBSModDisp.toString(this.data));
/*  8239 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8240 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8241 */       stringBuilder.append("}");
/*  8242 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_UnLockSetting extends PA_IntBase {
/*       */     public PA_UnLockSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8248 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8253 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8258 */       StringBuilder stringBuilder = new StringBuilder("PA_UnLockSetting");
/*  8259 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8260 */       stringBuilder.append(", dataValue = "); stringBuilder.append(UnlckKeylsCfg2.toString(this.data));
/*  8261 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8262 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8263 */       stringBuilder.append("}");
/*  8264 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PasAcsLock_Setting extends PA_IntBase {
/*       */     public PA_PasAcsLock_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8270 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8275 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8280 */       StringBuilder stringBuilder = new StringBuilder("PA_PasAcsLock_Setting");
/*  8281 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8282 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8283 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8284 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8285 */       stringBuilder.append("}");
/*  8286 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TwoStepUnlck_Setting extends PA_IntBase {
/*       */     public PA_TwoStepUnlck_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8292 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8297 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8302 */       StringBuilder stringBuilder = new StringBuilder("PA_TwoStepUnlck_Setting");
/*  8303 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8304 */       stringBuilder.append(", dataValue = "); stringBuilder.append(UnlckRemCfg1.toString(this.data));
/*  8305 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8306 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8307 */       stringBuilder.append("}");
/*  8308 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LockgFbSoundSet extends PA_IntBase {
/*       */     public PA_LockgFbSoundSet(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8314 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8319 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8324 */       StringBuilder stringBuilder = new StringBuilder("PA_LockgFbSoundSet");
/*  8325 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8326 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8327 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8328 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8329 */       stringBuilder.append("}");
/*  8330 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Individualtheme_OnOff extends PA_IntBase {
/*       */     public PA_Individualtheme_OnOff(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8336 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8341 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8346 */       StringBuilder stringBuilder = new StringBuilder("PA_Individualtheme_OnOff");
/*  8347 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8348 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8349 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8350 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8351 */       stringBuilder.append("}");
/*  8352 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DIMTheme_DrvSetting extends PA_IntBase {
/*       */     public PA_DIMTheme_DrvSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8358 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8363 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8368 */       StringBuilder stringBuilder = new StringBuilder("PA_DIMTheme_DrvSetting");
/*  8369 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8370 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DrvrDispSetg.toString(this.data));
/*  8371 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8372 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8373 */       stringBuilder.append("}");
/*  8374 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CSDTheme_Setting extends PA_IntBase {
/*       */     public PA_CSDTheme_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8380 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8385 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8390 */       StringBuilder stringBuilder = new StringBuilder("PA_CSDTheme_Setting");
/*  8391 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8392 */       stringBuilder.append(", dataValue = "); stringBuilder.append(CSDThemeColor.toString(this.data));
/*  8393 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8394 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8395 */       stringBuilder.append("}");
/*  8396 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ElecSeatbelt_Driver extends PA_IntBase {
/*       */     public PA_ElecSeatbelt_Driver(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8402 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8407 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8412 */       StringBuilder stringBuilder = new StringBuilder("PA_ElecSeatbelt_Driver");
/*  8413 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8414 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8415 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8416 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8417 */       stringBuilder.append("}");
/*  8418 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ElecSeatbelt_Passenger extends PA_IntBase {
/*       */     public PA_ElecSeatbelt_Passenger(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8424 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8429 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8434 */       StringBuilder stringBuilder = new StringBuilder("PA_ElecSeatbelt_Passenger");
/*  8435 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8436 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8437 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8438 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8439 */       stringBuilder.append("}");
/*  8440 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM_Hold extends PA_IntBase {
/*       */     public PA_PM_Hold(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8446 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8451 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8456 */       StringBuilder stringBuilder = new StringBuilder("PA_PM_Hold");
/*  8457 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8458 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8459 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8460 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8461 */       stringBuilder.append("}");
/*  8462 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PM_Charge extends PA_IntBase {
/*       */     public PA_PM_Charge(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8468 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8473 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8478 */       StringBuilder stringBuilder = new StringBuilder("PA_PM_Charge");
/*  8479 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8480 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8481 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8482 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8483 */       stringBuilder.append("}");
/*  8484 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Battery_Charge_Percent extends PA_IntBase {
/*       */     public PA_Battery_Charge_Percent(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8490 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8495 */       StringBuilder stringBuilder = new StringBuilder("PA_Battery_Charge_Percent");
/*  8496 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8497 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8498 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8499 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8500 */       stringBuilder.append("}");
/*  8501 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ChangeFailMsg extends PA_IntBase {
/*       */     public PA_ChangeFailMsg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8507 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/*  8512 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8517 */       StringBuilder stringBuilder = new StringBuilder("PA_ChangeFailMsg");
/*  8518 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8519 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8520 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8521 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8522 */       stringBuilder.append("}");
/*  8523 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ElectricTailgate_Setting extends PA_IntBase {
/*       */     public PA_ElectricTailgate_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8529 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8534 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8539 */       StringBuilder stringBuilder = new StringBuilder("PA_ElectricTailgate_Setting");
/*  8540 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8541 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DoorOpenerReq1.toString(this.data));
/*  8542 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8543 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8544 */       stringBuilder.append("}");
/*  8545 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ElectricTailgate_OpenBtn extends PA_IntBase {
/*       */     public PA_ElectricTailgate_OpenBtn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8551 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8556 */       StringBuilder stringBuilder = new StringBuilder("PA_ElectricTailgate_OpenBtn");
/*  8557 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8558 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8559 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8560 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8561 */       stringBuilder.append("}");
/*  8562 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ElectricTailgate_PosSetting extends PA_IntBase {
/*       */     public PA_ElectricTailgate_PosSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8568 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8573 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8578 */       StringBuilder stringBuilder = new StringBuilder("PA_ElectricTailgate_PosSetting");
/*  8579 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8580 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PosPerc1.toString(this.data));
/*  8581 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8582 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8583 */       stringBuilder.append("}");
/*  8584 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TailgateSts extends PA_IntBase {
/*       */     public PA_TailgateSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8590 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8595 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8600 */       StringBuilder stringBuilder = new StringBuilder("PA_TailgateSts");
/*  8601 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8602 */       stringBuilder.append(", dataValue = "); stringBuilder.append(TrOpenerSts1.toString(this.data));
/*  8603 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8604 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8605 */       stringBuilder.append("}");
/*  8606 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SelfDefineFuncReq extends PA_IntBase {
/*       */     public PA_SelfDefineFuncReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8612 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8617 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8622 */       StringBuilder stringBuilder = new StringBuilder("PA_SelfDefineFuncReq");
/*  8623 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8624 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VFMiscSelfDefineFunReq.toString(this.data));
/*  8625 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8626 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8627 */       stringBuilder.append("}");
/*  8628 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ScreenSwitch extends PA_IntBase {
/*       */     public PA_ScreenSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8634 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8639 */       StringBuilder stringBuilder = new StringBuilder("PA_ScreenSwitch");
/*  8640 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8641 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8642 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8643 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8644 */       stringBuilder.append("}");
/*  8645 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DVR extends PA_IntBase {
/*       */     public PA_DVR(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8651 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8656 */       StringBuilder stringBuilder = new StringBuilder("PA_DVR");
/*  8657 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8658 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8659 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8660 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8661 */       stringBuilder.append("}");
/*  8662 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_360Panorama extends PA_IntBase {
/*       */     public PA_360Panorama(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8668 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8673 */       StringBuilder stringBuilder = new StringBuilder("PA_360Panorama");
/*  8674 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8675 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8676 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8677 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8678 */       stringBuilder.append("}");
/*  8679 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_NaviHome extends PA_IntBase {
/*       */     public PA_NaviHome(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8685 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8690 */       StringBuilder stringBuilder = new StringBuilder("PA_NaviHome");
/*  8691 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8692 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8693 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8694 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8695 */       stringBuilder.append("}");
/*  8696 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SourceSwitch extends PA_IntBase {
/*       */     public PA_SourceSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8702 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8707 */       StringBuilder stringBuilder = new StringBuilder("PA_SourceSwitch");
/*  8708 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8709 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8710 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8711 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8712 */       stringBuilder.append("}");
/*  8713 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CollectionRadio extends PA_IntBase {
/*       */     public PA_CollectionRadio(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8719 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8724 */       StringBuilder stringBuilder = new StringBuilder("PA_CollectionRadio");
/*  8725 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8726 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8727 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8728 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8729 */       stringBuilder.append("}");
/*  8730 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VINDiffMsg extends PA_IntBase {
/*       */     public PA_VINDiffMsg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8736 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8741 */       StringBuilder stringBuilder = new StringBuilder("PA_VINDiffMsg");
/*  8742 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8743 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8744 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8745 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8746 */       stringBuilder.append("}");
/*  8747 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ParkingAutoResetSetting extends PA_IntBase {
/*       */     public PA_ParkingAutoResetSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8753 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8758 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8763 */       StringBuilder stringBuilder = new StringBuilder("PA_ParkingAutoResetSetting");
/*  8764 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8765 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8766 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8767 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8768 */       stringBuilder.append("}");
/*  8769 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_RefuleAutoResetSetting extends PA_IntBase {
/*       */     public PA_RefuleAutoResetSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8775 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8780 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8785 */       StringBuilder stringBuilder = new StringBuilder("PA_RefuleAutoResetSetting");
/*  8786 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8787 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8788 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8789 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8790 */       stringBuilder.append("}");
/*  8791 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TripCom_RetALL extends PA_IntBase {
/*       */     public PA_TripCom_RetALL(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8797 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8802 */       StringBuilder stringBuilder = new StringBuilder("PA_TripCom_RetALL");
/*  8803 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8804 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8805 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8806 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8807 */       stringBuilder.append("}");
/*  8808 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TripCom_RstTrip extends PA_IntBase {
/*       */     public PA_TripCom_RstTrip(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8814 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8819 */       StringBuilder stringBuilder = new StringBuilder("PA_TripCom_RstTrip");
/*  8820 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8821 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8822 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8823 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8824 */       stringBuilder.append("}");
/*  8825 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TripCom_RstAVS extends PA_IntBase {
/*       */     public PA_TripCom_RstAVS(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8831 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8836 */       StringBuilder stringBuilder = new StringBuilder("PA_TripCom_RstAVS");
/*  8837 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8838 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8839 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8840 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8841 */       stringBuilder.append("}");
/*  8842 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TripCom_RstEDT extends PA_IntBase {
/*       */     public PA_TripCom_RstEDT(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8848 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8853 */       StringBuilder stringBuilder = new StringBuilder("PA_TripCom_RstEDT");
/*  8854 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8855 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8856 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8857 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8858 */       stringBuilder.append("}");
/*  8859 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TripCom_RstAFC extends PA_IntBase {
/*       */     public PA_TripCom_RstAFC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8865 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8870 */       StringBuilder stringBuilder = new StringBuilder("PA_TripCom_RstAFC");
/*  8871 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8872 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8873 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8874 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8875 */       stringBuilder.append("}");
/*  8876 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TripCom_RstAEC extends PA_IntBase {
/*       */     public PA_TripCom_RstAEC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8882 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8887 */       StringBuilder stringBuilder = new StringBuilder("PA_TripCom_RstAEC");
/*  8888 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8889 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8890 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8891 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8892 */       stringBuilder.append("}");
/*  8893 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_IntelligentFuSave extends PA_IntBase {
/*       */     public PA_IntelligentFuSave(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8899 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8904 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8909 */       StringBuilder stringBuilder = new StringBuilder("PA_IntelligentFuSave");
/*  8910 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8911 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8912 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8913 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8914 */       stringBuilder.append("}");
/*  8915 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PowerFlow_HEV extends PA_IntBase {
/*       */     public PA_PowerFlow_HEV(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8921 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8926 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8931 */       StringBuilder stringBuilder = new StringBuilder("PA_PowerFlow_HEV");
/*  8932 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8933 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DispOfPrpsnMod4.toString(this.data));
/*  8934 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8935 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8936 */       stringBuilder.append("}");
/*  8937 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_LifeDetectionSwitch extends PA_IntBase {
/*       */     public PA_LifeDetectionSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8943 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8948 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8953 */       StringBuilder stringBuilder = new StringBuilder("PA_LifeDetectionSwitch");
/*  8954 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8955 */       stringBuilder.append(", dataValue = "); stringBuilder.append(LDACSoftBtnSwtSt.toString(this.data));
/*  8956 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8957 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8958 */       stringBuilder.append("}");
/*  8959 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_UnlckTrunk extends PA_IntBase {
/*       */     public PA_UnlckTrunk(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8965 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8970 */       StringBuilder stringBuilder = new StringBuilder("PA_UnlckTrunk");
/*  8971 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8972 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  8973 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8974 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8975 */       stringBuilder.append("}");
/*  8976 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_RearMirrors extends PA_IntBase {
/*       */     public PA_RearMirrors(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  8982 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  8987 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  8992 */       StringBuilder stringBuilder = new StringBuilder("PA_RearMirrors");
/*  8993 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  8994 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  8995 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  8996 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  8997 */       stringBuilder.append("}");
/*  8998 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DoubleLock extends PA_IntBase {
/*       */     public PA_DoubleLock(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9004 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  9009 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9014 */       StringBuilder stringBuilder = new StringBuilder("PA_DoubleLock");
/*  9015 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9016 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/*  9017 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9018 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9019 */       stringBuilder.append("}");
/*  9020 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Locking_ApproachToOpenTrSwt extends PA_IntBase {
/*       */     public PA_Locking_ApproachToOpenTrSwt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9026 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/*  9031 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9036 */       StringBuilder stringBuilder = new StringBuilder("PA_Locking_ApproachToOpenTrSwt");
/*  9037 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9038 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff2.toString(this.data));
/*  9039 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9040 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9041 */       stringBuilder.append("}");
/*  9042 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ServiceReminderType extends PA_IntBase {
/*       */     public PA_ServiceReminderType(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9048 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9053 */       StringBuilder stringBuilder = new StringBuilder("PA_ServiceReminderType");
/*  9054 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9055 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9056 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9057 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9058 */       stringBuilder.append("}");
/*  9059 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DstTrvldAct extends PA_IntBase {
/*       */     public PA_DstTrvldAct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9065 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9070 */       StringBuilder stringBuilder = new StringBuilder("PA_DstTrvldAct");
/*  9071 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9072 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9073 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9074 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9075 */       stringBuilder.append("}");
/*  9076 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DstTrvldOfEV extends PA_IntBase {
/*       */     public PA_DstTrvldOfEV(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9082 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9087 */       StringBuilder stringBuilder = new StringBuilder("PA_DstTrvldOfEV");
/*  9088 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9089 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9090 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9091 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9092 */       stringBuilder.append("}");
/*  9093 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DstTrvldOfEng extends PA_IntBase {
/*       */     public PA_DstTrvldOfEng(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9099 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9104 */       StringBuilder stringBuilder = new StringBuilder("PA_DstTrvldOfEng");
/*  9105 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9106 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9107 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9108 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9109 */       stringBuilder.append("}");
/*  9110 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_NatUsgDayOfOil extends PA_IntBase {
/*       */     public PA_NatUsgDayOfOil(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9116 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9121 */       StringBuilder stringBuilder = new StringBuilder("PA_NatUsgDayOfOil");
/*  9122 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9123 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9124 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9125 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9126 */       stringBuilder.append("}");
/*  9127 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HealthOfEngOil extends PA_IntBase {
/*       */     public PA_HealthOfEngOil(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9133 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9138 */       StringBuilder stringBuilder = new StringBuilder("PA_HealthOfEngOil");
/*  9139 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9140 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9141 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9142 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9143 */       stringBuilder.append("}");
/*  9144 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Status extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Status(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9150 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9155 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9156 */       for (byte b = 0; b < this.data.length; b++) {
/*  9157 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9159 */       StringBuilder stringBuilder1 = new StringBuilder("PA_DiagProxy_Status");
/*  9160 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9161 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9162 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9163 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9164 */       stringBuilder1.append("}");
/*  9165 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Csd_GW_Phy extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Csd_GW_Phy(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9171 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9176 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9177 */       for (byte b = 0; b < this.data.length; b++) {
/*  9178 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9180 */       StringBuilder stringBuilder1 = new StringBuilder("PA_DiagProxy_Csd_GW_Phy");
/*  9181 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9182 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9183 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9184 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9185 */       stringBuilder1.append("}");
/*  9186 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Csd_GW_Fun extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Csd_GW_Fun(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9192 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9197 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9198 */       for (byte b = 0; b < this.data.length; b++) {
/*  9199 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9201 */       StringBuilder stringBuilder2 = new StringBuilder("PA_DiagProxy_Csd_GW_Fun");
/*  9202 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9203 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9204 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9205 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9206 */       stringBuilder2.append("}");
/*  9207 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Csdm_GW_Phy extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Csdm_GW_Phy(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9213 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9218 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9219 */       for (byte b = 0; b < this.data.length; b++) {
/*  9220 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9222 */       StringBuilder stringBuilder1 = new StringBuilder("PA_DiagProxy_Csdm_GW_Phy");
/*  9223 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9224 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9225 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9226 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9227 */       stringBuilder1.append("}");
/*  9228 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Csdm_GW_Fun extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Csdm_GW_Fun(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9234 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9239 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9240 */       for (byte b = 0; b < this.data.length; b++) {
/*  9241 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9243 */       StringBuilder stringBuilder2 = new StringBuilder("PA_DiagProxy_Csdm_GW_Fun");
/*  9244 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9245 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9246 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9247 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9248 */       stringBuilder2.append("}");
/*  9249 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Psd_GW_Phy extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Psd_GW_Phy(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9255 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9260 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9261 */       for (byte b = 0; b < this.data.length; b++) {
/*  9262 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9264 */       StringBuilder stringBuilder2 = new StringBuilder("PA_DiagProxy_Psd_GW_Phy");
/*  9265 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9266 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9267 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9268 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9269 */       stringBuilder2.append("}");
/*  9270 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_Psd_GW_Fun extends PA_ByteArrayBase {
/*       */     public PA_DiagProxy_Psd_GW_Fun(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9276 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9281 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9282 */       for (byte b = 0; b < this.data.length; b++) {
/*  9283 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9285 */       StringBuilder stringBuilder2 = new StringBuilder("PA_DiagProxy_Psd_GW_Fun");
/*  9286 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9287 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9288 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9289 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9290 */       stringBuilder2.append("}");
/*  9291 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CSD_MONITOR_EN extends PA_IntBase {
/*       */     public PA_CSD_MONITOR_EN(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9297 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9302 */       StringBuilder stringBuilder = new StringBuilder("PA_CSD_MONITOR_EN");
/*  9303 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9304 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9305 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9306 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9307 */       stringBuilder.append("}");
/*  9308 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PASWAM_Video_in extends PA_IntBase {
/*       */     public PA_PASWAM_Video_in(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9314 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9319 */       StringBuilder stringBuilder = new StringBuilder("PA_PASWAM_Video_in");
/*  9320 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9321 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9322 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9323 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9324 */       stringBuilder.append("}");
/*  9325 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DVR_Video_IN extends PA_IntBase {
/*       */     public PA_DVR_Video_IN(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9331 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9336 */       StringBuilder stringBuilder = new StringBuilder("PA_DVR_Video_IN");
/*  9337 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9338 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9339 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9340 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9341 */       stringBuilder.append("}");
/*  9342 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Gesture_Video_IN extends PA_IntBase {
/*       */     public PA_Gesture_Video_IN(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9348 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9353 */       StringBuilder stringBuilder = new StringBuilder("PA_Gesture_Video_IN");
/*  9354 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9355 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9356 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9357 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9358 */       stringBuilder.append("}");
/*  9359 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Chat_Video_IN extends PA_IntBase {
/*       */     public PA_Chat_Video_IN(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9365 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9370 */       StringBuilder stringBuilder = new StringBuilder("PA_Chat_Video_IN");
/*  9371 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9372 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9373 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9374 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9375 */       stringBuilder.append("}");
/*  9376 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Dcm_D912_PSD_MONITOR_EN extends PA_IntBase {
/*       */     public PA_Dcm_D912_PSD_MONITOR_EN(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9382 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9387 */       StringBuilder stringBuilder = new StringBuilder("PA_Dcm_D912_PSD_MONITOR_EN");
/*  9388 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9389 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9390 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9391 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9392 */       stringBuilder.append("}");
/*  9393 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Product_Serial_Number extends PA_ByteArrayBase {
/*       */     public PA_Product_Serial_Number(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9399 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9404 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9405 */       for (byte b = 0; b < this.data.length; b++) {
/*  9406 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9408 */       StringBuilder stringBuilder1 = new StringBuilder("PA_Product_Serial_Number");
/*  9409 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9410 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9411 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9412 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9413 */       stringBuilder1.append("}");
/*  9414 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_XDSN_Reading extends PA_ByteArrayBase {
/*       */     public PA_XDSN_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9420 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9425 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9426 */       for (byte b = 0; b < this.data.length; b++) {
/*  9427 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9429 */       StringBuilder stringBuilder1 = new StringBuilder("PA_XDSN_Reading");
/*  9430 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9431 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9432 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9433 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9434 */       stringBuilder1.append("}");
/*  9435 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_IHUID_Reading extends PA_ByteArrayBase {
/*       */     public PA_IHUID_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9441 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9446 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9447 */       for (byte b = 0; b < this.data.length; b++) {
/*  9448 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9450 */       StringBuilder stringBuilder2 = new StringBuilder("PA_IHUID_Reading");
/*  9451 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9452 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9453 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9454 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9455 */       stringBuilder2.append("}");
/*  9456 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HW_Version_Reading extends PA_ByteArrayBase {
/*       */     public PA_HW_Version_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9462 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9467 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9468 */       for (byte b = 0; b < this.data.length; b++) {
/*  9469 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9471 */       StringBuilder stringBuilder1 = new StringBuilder("PA_HW_Version_Reading");
/*  9472 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9473 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9474 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9475 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9476 */       stringBuilder1.append("}");
/*  9477 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Geely_Delivery_Assemble_Reading extends PA_ByteArrayBase {
/*       */     public PA_Geely_Delivery_Assemble_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9483 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9488 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9489 */       for (byte b = 0; b < this.data.length; b++) {
/*  9490 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9492 */       StringBuilder stringBuilder2 = new StringBuilder("PA_Geely_Delivery_Assemble_Reading");
/*  9493 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9494 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9495 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9496 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9497 */       stringBuilder2.append("}");
/*  9498 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_GeelyHSWD_Reading extends PA_ByteArrayBase {
/*       */     public PA_GeelyHSWD_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9504 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9509 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9510 */       for (byte b = 0; b < this.data.length; b++) {
/*  9511 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9513 */       StringBuilder stringBuilder2 = new StringBuilder("PA_GeelyHSWD_Reading");
/*  9514 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9515 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9516 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9517 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9518 */       stringBuilder2.append("}");
/*  9519 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VolvoDelivery_Assemble_Reading extends PA_ByteArrayBase {
/*       */     public PA_VolvoDelivery_Assemble_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9525 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9530 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9531 */       for (byte b = 0; b < this.data.length; b++) {
/*  9532 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9534 */       StringBuilder stringBuilder2 = new StringBuilder("PA_VolvoDelivery_Assemble_Reading");
/*  9535 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9536 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9537 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9538 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9539 */       stringBuilder2.append("}");
/*  9540 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VolvoHWSD_Reading extends PA_ByteArrayBase {
/*       */     public PA_VolvoHWSD_Reading(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9546 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9551 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9552 */       for (byte b = 0; b < this.data.length; b++) {
/*  9553 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9555 */       StringBuilder stringBuilder2 = new StringBuilder("PA_VolvoHWSD_Reading");
/*  9556 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9557 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9558 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9559 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9560 */       stringBuilder2.append("}");
/*  9561 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Manufacturing_Signal extends PA_IntBase {
/*       */     public PA_Manufacturing_Signal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9567 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9572 */       StringBuilder stringBuilder = new StringBuilder("PA_Manufacturing_Signal");
/*  9573 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9574 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9575 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9576 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9577 */       stringBuilder.append("}");
/*  9578 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_D907 extends PA_IntBase {
/*       */     public PA_D907(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9584 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9589 */       StringBuilder stringBuilder = new StringBuilder("PA_D907");
/*  9590 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9591 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9592 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9593 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9594 */       stringBuilder.append("}");
/*  9595 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CSDM_PSD_EN extends PA_IntBase {
/*       */     public PA_CSDM_PSD_EN(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9601 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9606 */       StringBuilder stringBuilder = new StringBuilder("PA_CSDM_PSD_EN");
/*  9607 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9608 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9609 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9610 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9611 */       stringBuilder.append("}");
/*  9612 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD26 extends PA_IntBase {
/*       */     public PA_FD26(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9618 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9623 */       StringBuilder stringBuilder = new StringBuilder("PA_FD26");
/*  9624 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9625 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9626 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9627 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9628 */       stringBuilder.append("}");
/*  9629 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD27 extends PA_IntBase {
/*       */     public PA_FD27(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9635 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9640 */       StringBuilder stringBuilder = new StringBuilder("PA_FD27");
/*  9641 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9642 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9643 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9644 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9645 */       stringBuilder.append("}");
/*  9646 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD28 extends PA_IntBase {
/*       */     public PA_FD28(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9652 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9657 */       StringBuilder stringBuilder = new StringBuilder("PA_FD28");
/*  9658 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9659 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9660 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9661 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9662 */       stringBuilder.append("}");
/*  9663 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD39 extends PA_IntBase {
/*       */     public PA_FD39(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9669 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9674 */       StringBuilder stringBuilder = new StringBuilder("PA_FD39");
/*  9675 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9676 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9677 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9678 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9679 */       stringBuilder.append("}");
/*  9680 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD29 extends PA_ByteArrayBase {
/*       */     public PA_FD29(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9686 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9691 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9692 */       for (byte b = 0; b < this.data.length; b++) {
/*  9693 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9695 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD29");
/*  9696 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9697 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9698 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9699 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9700 */       stringBuilder2.append("}");
/*  9701 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD12 extends PA_ByteArrayBase {
/*       */     public PA_FD12(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9707 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9712 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9713 */       for (byte b = 0; b < this.data.length; b++) {
/*  9714 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9716 */       StringBuilder stringBuilder1 = new StringBuilder("PA_FD12");
/*  9717 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9718 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9719 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9720 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9721 */       stringBuilder1.append("}");
/*  9722 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD17 extends PA_ByteArrayBase {
/*       */     public PA_FD17(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9728 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9733 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9734 */       for (byte b = 0; b < this.data.length; b++) {
/*  9735 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9737 */       StringBuilder stringBuilder1 = new StringBuilder("PA_FD17");
/*  9738 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9739 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9740 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9741 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9742 */       stringBuilder1.append("}");
/*  9743 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD5A extends PA_ByteArrayBase {
/*       */     public PA_FD5A(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9749 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9754 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9755 */       for (byte b = 0; b < this.data.length; b++) {
/*  9756 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9758 */       StringBuilder stringBuilder1 = new StringBuilder("PA_FD5A");
/*  9759 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9760 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9761 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9762 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9763 */       stringBuilder1.append("}");
/*  9764 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD30 extends PA_ByteArrayBase {
/*       */     public PA_FD30(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9770 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9775 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9776 */       for (byte b = 0; b < this.data.length; b++) {
/*  9777 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9779 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD30");
/*  9780 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9781 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9782 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9783 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9784 */       stringBuilder2.append("}");
/*  9785 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD23 extends PA_ByteArrayBase {
/*       */     public PA_FD23(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9791 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9796 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9797 */       for (byte b = 0; b < this.data.length; b++) {
/*  9798 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9800 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD23");
/*  9801 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9802 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9803 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9804 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9805 */       stringBuilder2.append("}");
/*  9806 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD42 extends PA_ByteArrayBase {
/*       */     public PA_FD42(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9812 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9817 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9818 */       for (byte b = 0; b < this.data.length; b++) {
/*  9819 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9821 */       StringBuilder stringBuilder1 = new StringBuilder("PA_FD42");
/*  9822 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9823 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9824 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9825 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9826 */       stringBuilder1.append("}");
/*  9827 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD44 extends PA_ByteArrayBase {
/*       */     public PA_FD44(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9833 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9838 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9839 */       for (byte b = 0; b < this.data.length; b++) {
/*  9840 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9842 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD44");
/*  9843 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9844 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9845 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9846 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9847 */       stringBuilder2.append("}");
/*  9848 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD41 extends PA_ByteArrayBase {
/*       */     public PA_FD41(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9854 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9859 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9860 */       for (byte b = 0; b < this.data.length; b++) {
/*  9861 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9863 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD41");
/*  9864 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9865 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9866 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9867 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9868 */       stringBuilder2.append("}");
/*  9869 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD43 extends PA_ByteArrayBase {
/*       */     public PA_FD43(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9875 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9880 */       StringBuilder stringBuilder2 = new StringBuilder();
/*  9881 */       for (byte b = 0; b < this.data.length; b++) {
/*  9882 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9884 */       StringBuilder stringBuilder1 = new StringBuilder("PA_FD43");
/*  9885 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/*  9886 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/*  9887 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/*  9888 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/*  9889 */       stringBuilder1.append("}");
/*  9890 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD62 extends PA_ByteArrayBase {
/*       */     public PA_FD62(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9896 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9901 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9902 */       for (byte b = 0; b < this.data.length; b++) {
/*  9903 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9905 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD62");
/*  9906 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9907 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9908 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9909 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9910 */       stringBuilder2.append("}");
/*  9911 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD85 extends PA_ByteArrayBase {
/*       */     public PA_FD85(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/*  9917 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9922 */       StringBuilder stringBuilder1 = new StringBuilder();
/*  9923 */       for (byte b = 0; b < this.data.length; b++) {
/*  9924 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/*  9926 */       StringBuilder stringBuilder2 = new StringBuilder("PA_FD85");
/*  9927 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/*  9928 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/*  9929 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/*  9930 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/*  9931 */       stringBuilder2.append("}");
/*  9932 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD88 extends PA_IntBase {
/*       */     public PA_FD88(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9938 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9943 */       StringBuilder stringBuilder = new StringBuilder("PA_FD88");
/*  9944 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9945 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9946 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9947 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9948 */       stringBuilder.append("}");
/*  9949 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD86 extends PA_IntBase {
/*       */     public PA_FD86(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9955 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9960 */       StringBuilder stringBuilder = new StringBuilder("PA_FD86");
/*  9961 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9962 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9963 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9964 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9965 */       stringBuilder.append("}");
/*  9966 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD91 extends PA_IntBase {
/*       */     public PA_FD91(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9972 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9977 */       StringBuilder stringBuilder = new StringBuilder("PA_FD91");
/*  9978 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9979 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9980 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9981 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9982 */       stringBuilder.append("}");
/*  9983 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD92 extends PA_IntBase {
/*       */     public PA_FD92(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/*  9989 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/*  9994 */       StringBuilder stringBuilder = new StringBuilder("PA_FD92");
/*  9995 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/*  9996 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/*  9997 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/*  9998 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/*  9999 */       stringBuilder.append("}");
/* 10000 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AuthorityLocationSwitch extends PA_IntBase {
/*       */     public PA_AuthorityLocationSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10006 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10011 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10016 */       StringBuilder stringBuilder = new StringBuilder("PA_AuthorityLocationSwitch");
/* 10017 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10018 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 10019 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10020 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10021 */       stringBuilder.append("}");
/* 10022 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AuthorityCameraSwitch extends PA_IntBase {
/*       */     public PA_AuthorityCameraSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10028 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10033 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10038 */       StringBuilder stringBuilder = new StringBuilder("PA_AuthorityCameraSwitch");
/* 10039 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10040 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 10041 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10042 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10043 */       stringBuilder.append("}");
/* 10044 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AuthorityMicrophoneSwitch extends PA_IntBase {
/*       */     public PA_AuthorityMicrophoneSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10050 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10055 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10060 */       StringBuilder stringBuilder = new StringBuilder("PA_AuthorityMicrophoneSwitch");
/* 10061 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10062 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 10063 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10064 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10065 */       stringBuilder.append("}");
/* 10066 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Privacy_Compliance_Reset extends PA_IntBase {
/*       */     public PA_Privacy_Compliance_Reset(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10072 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10077 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10082 */       StringBuilder stringBuilder = new StringBuilder("PA_Privacy_Compliance_Reset");
/* 10083 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10084 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 10085 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10086 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10087 */       stringBuilder.append("}");
/* 10088 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_D0D2 extends PA_StringBase {
/*       */     public PA_D0D2(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 10094 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10099 */       StringBuilder stringBuilder = new StringBuilder("PA_D0D2");
/* 10100 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10101 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10102 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10103 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10104 */       stringBuilder.append("}");
/* 10105 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_D0D1 extends PA_ByteArrayBase {
/*       */     public PA_D0D1(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 10111 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10116 */       StringBuilder stringBuilder1 = new StringBuilder();
/* 10117 */       for (byte b = 0; b < this.data.length; b++) {
/* 10118 */         stringBuilder1.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/* 10120 */       StringBuilder stringBuilder2 = new StringBuilder("PA_D0D1");
/* 10121 */       stringBuilder2.append("{availability = "); stringBuilder2.append(AvailabilitySts.toString(this.availability));
/* 10122 */       stringBuilder2.append(", dataValue = "); stringBuilder2.append(stringBuilder1.toString());
/* 10123 */       stringBuilder2.append(", statusValue = "); stringBuilder2.append(this.status);
/* 10124 */       stringBuilder2.append(", formatValue = "); stringBuilder2.append(this.format);
/* 10125 */       stringBuilder2.append("}");
/* 10126 */       return stringBuilder2.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_D0D0 extends PA_ByteArrayBase {
/*       */     public PA_D0D0(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 10132 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10137 */       StringBuilder stringBuilder2 = new StringBuilder();
/* 10138 */       for (byte b = 0; b < this.data.length; b++) {
/* 10139 */         stringBuilder2.append(Integer.toHexString(this.data[b] & 0xFF));
/*       */       }
/* 10141 */       StringBuilder stringBuilder1 = new StringBuilder("PA_D0D0");
/* 10142 */       stringBuilder1.append("{availability = "); stringBuilder1.append(AvailabilitySts.toString(this.availability));
/* 10143 */       stringBuilder1.append(", dataValue = "); stringBuilder1.append(stringBuilder2.toString());
/* 10144 */       stringBuilder1.append(", statusValue = "); stringBuilder1.append(this.status);
/* 10145 */       stringBuilder1.append(", formatValue = "); stringBuilder1.append(this.format);
/* 10146 */       stringBuilder1.append("}");
/* 10147 */       return stringBuilder1.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_DTEIndicated extends PA_IntBase {
/*       */     public PA_TS_DTEIndicated(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10153 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10158 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_DTEIndicated");
/* 10159 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10160 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10161 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10162 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10163 */       stringBuilder.append("}");
/* 10164 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_DTEHVBattIndicated extends PA_IntBase {
/*       */     public PA_TS_DTEHVBattIndicated(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10170 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10175 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_DTEHVBattIndicated");
/* 10176 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10177 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10178 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10179 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10180 */       stringBuilder.append("}");
/* 10181 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_DTEHV_round extends PA_IntBase {
/*       */     public PA_TS_DTEHV_round(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10187 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10192 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_DTEHV_round");
/* 10193 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10194 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10195 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10196 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10197 */       stringBuilder.append("}");
/* 10198 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_EDT_time2 extends PA_IntBase {
/*       */     public PA_TS_EDT_time2(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10204 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10209 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_EDT_time2");
/* 10210 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10211 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10212 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10213 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10214 */       stringBuilder.append("}");
/* 10215 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_Zero_Emission extends PA_IntBase {
/*       */     public PA_TS_Zero_Emission(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10221 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10226 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_Zero_Emission");
/* 10227 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10228 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10229 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10230 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10231 */       stringBuilder.append("}");
/* 10232 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_OdometerTripMeter2 extends PA_IntBase {
/*       */     public PA_TS_OdometerTripMeter2(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10238 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10243 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_OdometerTripMeter2");
/* 10244 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10245 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10246 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10247 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10248 */       stringBuilder.append("}");
/* 10249 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_TripAverageConsumption05Km extends PA_IntBase {
/*       */     public PA_TS_TripAverageConsumption05Km(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10255 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10260 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_TripAverageConsumption05Km");
/* 10261 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10262 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10263 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10264 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10265 */       stringBuilder.append("}");
/* 10266 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_TripAverageConsumption5Km extends PA_IntBase {
/*       */     public PA_TS_TripAverageConsumption5Km(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10272 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10277 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_TripAverageConsumption5Km");
/* 10278 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10279 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10280 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10281 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10282 */       stringBuilder.append("}");
/* 10283 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_TripAverageEnConsumption05Km extends PA_IntBase {
/*       */     public PA_TS_TripAverageEnConsumption05Km(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10289 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10294 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_TripAverageEnConsumption05Km");
/* 10295 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10296 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10297 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10298 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10299 */       stringBuilder.append("}");
/* 10300 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_TripAverageEnConsumption5Km extends PA_IntBase {
/*       */     public PA_TS_TripAverageEnConsumption5Km(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10306 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10311 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_TripAverageEnConsumption5Km");
/* 10312 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10313 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10314 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10315 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10316 */       stringBuilder.append("}");
/* 10317 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_fuelStats10 extends PA_IntArrayBase {
/*       */     public PA_TS_fuelStats10(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10323 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10328 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_fuelStats10");
/* 10329 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10330 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10331 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10332 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10333 */       stringBuilder.append("}");
/* 10334 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_fuelStats100 extends PA_IntArrayBase {
/*       */     public PA_TS_fuelStats100(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10340 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10345 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_fuelStats100");
/* 10346 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10347 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10348 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10349 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10350 */       stringBuilder.append("}");
/* 10351 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_energyStats10 extends PA_IntArrayBase {
/*       */     public PA_TS_energyStats10(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10357 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10362 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_energyStats10");
/* 10363 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10364 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10365 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10366 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10367 */       stringBuilder.append("}");
/* 10368 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_energyStats100 extends PA_IntArrayBase {
/*       */     public PA_TS_energyStats100(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10374 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10379 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_energyStats100");
/* 10380 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10381 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10382 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10383 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10384 */       stringBuilder.append("}");
/* 10385 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_energyReStats10 extends PA_IntArrayBase {
/*       */     public PA_TS_energyReStats10(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10391 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10396 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_energyReStats10");
/* 10397 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10398 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10399 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10400 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10401 */       stringBuilder.append("}");
/* 10402 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_energyReStats100 extends PA_IntArrayBase {
/*       */     public PA_TS_energyReStats100(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10408 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10413 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_energyReStats100");
/* 10414 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10415 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10416 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10417 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10418 */       stringBuilder.append("}");
/* 10419 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_ChargRemind extends PA_IntBase {
/*       */     public PA_VehCharg_ChargRemind(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10425 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10430 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_ChargRemind");
/* 10431 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10432 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10433 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10434 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10435 */       stringBuilder.append("}");
/* 10436 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_SetA extends PA_IntBase {
/*       */     public PA_VehCharg_SetA(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10442 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10447 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_SetA");
/* 10448 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10449 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10450 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10451 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10452 */       stringBuilder.append("}");
/* 10453 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_SetSOC extends PA_IntBase {
/*       */     public PA_VehCharg_SetSOC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10459 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10464 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_SetSOC");
/* 10465 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10466 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10467 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10468 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10469 */       stringBuilder.append("}");
/* 10470 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_ChargSt extends PA_IntBase {
/*       */     public PA_VehCharg_ChargSt(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10476 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10481 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10486 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_ChargSt");
/* 10487 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10488 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 10489 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10490 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10491 */       stringBuilder.append("}");
/* 10492 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_ChargInfoShow extends PA_IntBase {
/*       */     public PA_VehCharg_ChargInfoShow(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10498 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10503 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_ChargInfoShow");
/* 10504 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10505 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10506 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10507 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10508 */       stringBuilder.append("}");
/* 10509 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_ChargLight extends PA_IntBase {
/*       */     public PA_VehCharg_ChargLight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10515 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10520 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10525 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_ChargLight");
/* 10526 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10527 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 10528 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10529 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10530 */       stringBuilder.append("}");
/* 10531 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_Appointment extends PA_IntBase {
/*       */     public PA_VehCharg_Appointment(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10537 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10542 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_Appointment");
/* 10543 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10544 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10545 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10546 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10547 */       stringBuilder.append("}");
/* 10548 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DisChargSOC extends PA_IntBase {
/*       */     public PA_VehCharg_DisChargSOC(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10554 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10559 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DisChargSOC");
/* 10560 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10561 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10562 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10563 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10564 */       stringBuilder.append("}");
/* 10565 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DisChargInfoShow extends PA_IntBase {
/*       */     public PA_VehCharg_DisChargInfoShow(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10571 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10576 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DisChargInfoShow");
/* 10577 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10578 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10579 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10580 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10581 */       stringBuilder.append("}");
/* 10582 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DisChargeSwitch extends PA_IntBase {
/*       */     public PA_VehCharg_DisChargeSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10588 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10593 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DisChargeSwitch");
/* 10594 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10595 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10596 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10597 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10598 */       stringBuilder.append("}");
/* 10599 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DisChargeRecord extends PA_IntArrayBase {
/*       */     public PA_VehCharg_DisChargeRecord(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 10605 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10610 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DisChargeRecord");
/* 10611 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10612 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 10613 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10614 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10615 */       stringBuilder.append("}");
/* 10616 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DchaUAct extends PA_IntBase {
/*       */     public PA_VehCharg_DchaUAct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10622 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10627 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DchaUAct");
/* 10628 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10629 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10630 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10631 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10632 */       stringBuilder.append("}");
/* 10633 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DchaIAct extends PA_IntBase {
/*       */     public PA_VehCharg_DchaIAct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10639 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10644 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DchaIAct");
/* 10645 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10646 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10647 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10648 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10649 */       stringBuilder.append("}");
/* 10650 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_HvBattDchaTiEstimd extends PA_IntBase {
/*       */     public PA_VehCharg_HvBattDchaTiEstimd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10656 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10661 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_HvBattDchaTiEstimd");
/* 10662 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10663 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10664 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10665 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10666 */       stringBuilder.append("}");
/* 10667 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DchaEgyAct extends PA_IntBase {
/*       */     public PA_VehCharg_DchaEgyAct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10673 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10678 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DchaEgyAct");
/* 10679 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10680 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10681 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10682 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10683 */       stringBuilder.append("}");
/* 10684 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_DispHvBattLvlOfChrg extends PA_IntBase {
/*       */     public PA_VehCharg_DispHvBattLvlOfChrg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10690 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10695 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_DispHvBattLvlOfChrg");
/* 10696 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10697 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10698 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10699 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10700 */       stringBuilder.append("}");
/* 10701 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_OnBdChrgrUAct extends PA_IntBase {
/*       */     public PA_VehCharg_OnBdChrgrUAct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10707 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10712 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_OnBdChrgrUAct");
/* 10713 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10714 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10715 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10716 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10717 */       stringBuilder.append("}");
/* 10718 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_OnBdChrgrIAct extends PA_IntBase {
/*       */     public PA_VehCharg_OnBdChrgrIAct(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10724 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10729 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_OnBdChrgrIAct");
/* 10730 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10731 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10732 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10733 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10734 */       stringBuilder.append("}");
/* 10735 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_HvBattChrgnTiEstimd extends PA_IntBase {
/*       */     public PA_VehCharg_HvBattChrgnTiEstimd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10741 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10746 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_HvBattChrgnTiEstimd");
/* 10747 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10748 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10749 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10750 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10751 */       stringBuilder.append("}");
/* 10752 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_ChrgnOrDisChrgnStsFb extends PA_IntBase {
/*       */     public PA_VehCharg_ChrgnOrDisChrgnStsFb(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10758 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10763 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_ChrgnOrDisChrgnStsFb");
/* 10764 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10765 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10766 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10767 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10768 */       stringBuilder.append("}");
/* 10769 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SunCurtain_Setting extends PA_IntBase {
/*       */     public PA_SunCurtain_Setting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10775 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10780 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10785 */       StringBuilder stringBuilder = new StringBuilder("PA_SunCurtain_Setting");
/* 10786 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10787 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 10788 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10789 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10790 */       stringBuilder.append("}");
/* 10791 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_OpenSunRoof_Btn extends PA_IntBase {
/*       */     public PA_OpenSunRoof_Btn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10797 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10802 */       StringBuilder stringBuilder = new StringBuilder("PA_OpenSunRoof_Btn");
/* 10803 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10804 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10805 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10806 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10807 */       stringBuilder.append("}");
/* 10808 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CloseSunRoof_Btn extends PA_IntBase {
/*       */     public PA_CloseSunRoof_Btn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10814 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10819 */       StringBuilder stringBuilder = new StringBuilder("PA_CloseSunRoof_Btn");
/* 10820 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10821 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10822 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10823 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10824 */       stringBuilder.append("}");
/* 10825 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_OpenSunCurtain_Btn extends PA_IntBase {
/*       */     public PA_OpenSunCurtain_Btn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10831 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10836 */       StringBuilder stringBuilder = new StringBuilder("PA_OpenSunCurtain_Btn");
/* 10837 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10838 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10839 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10840 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10841 */       stringBuilder.append("}");
/* 10842 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CloseSunCurtain_Btn extends PA_IntBase {
/*       */     public PA_CloseSunCurtain_Btn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10848 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10853 */       StringBuilder stringBuilder = new StringBuilder("PA_CloseSunCurtain_Btn");
/* 10854 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10855 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10856 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10857 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10858 */       stringBuilder.append("}");
/* 10859 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SunRoofPosnSts extends PA_IntBase {
/*       */     public PA_SunRoofPosnSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10865 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10870 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10875 */       StringBuilder stringBuilder = new StringBuilder("PA_SunRoofPosnSts");
/* 10876 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10877 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 10878 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10879 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10880 */       stringBuilder.append("}");
/* 10881 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SunCurtainPosnSts extends PA_IntBase {
/*       */     public PA_SunCurtainPosnSts(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10887 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10892 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10897 */       StringBuilder stringBuilder = new StringBuilder("PA_SunCurtainPosnSts");
/* 10898 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10899 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 10900 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10901 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10902 */       stringBuilder.append("}");
/* 10903 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SunRoofOpenPosnReq extends PA_IntBase {
/*       */     public PA_SunRoofOpenPosnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10909 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10914 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10919 */       StringBuilder stringBuilder = new StringBuilder("PA_SunRoofOpenPosnReq");
/* 10920 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10921 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 10922 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10923 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10924 */       stringBuilder.append("}");
/* 10925 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SunCurtOpenPosnReq extends PA_IntBase {
/*       */     public PA_SunCurtOpenPosnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10931 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10936 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10941 */       StringBuilder stringBuilder = new StringBuilder("PA_SunCurtOpenPosnReq");
/* 10942 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10943 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 10944 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10945 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10946 */       stringBuilder.append("}");
/* 10947 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SunRoofTiltReq extends PA_IntBase {
/*       */     public PA_SunRoofTiltReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10953 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10958 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10963 */       StringBuilder stringBuilder = new StringBuilder("PA_SunRoofTiltReq");
/* 10964 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10965 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 10966 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10967 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10968 */       stringBuilder.append("}");
/* 10969 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HmiCarLocatorSetReq extends PA_IntBase {
/*       */     public PA_HmiCarLocatorSetReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10975 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 10980 */       StringBuilder stringBuilder = new StringBuilder("PA_HmiCarLocatorSetReq");
/* 10981 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 10982 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 10983 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 10984 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 10985 */       stringBuilder.append("}");
/* 10986 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiAll extends PA_IntBase {
/*       */     public PA_AmbLiAll(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 10992 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 10997 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11002 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiAll");
/* 11003 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11004 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11005 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11006 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11007 */       stringBuilder.append("}");
/* 11008 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiModSetting extends PA_IntBase {
/*       */     public PA_AmbLiModSetting(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11014 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11019 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11024 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiModSetting");
/* 11025 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11026 */       stringBuilder.append(", dataValue = "); stringBuilder.append(AmbLiMod.toString(this.data));
/* 11027 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11028 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11029 */       stringBuilder.append("}");
/* 11030 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiMod_None extends PA_IntBase {
/*       */     public PA_AmbLiMod_None(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11036 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11041 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiMod_None");
/* 11042 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11043 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11044 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11045 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11046 */       stringBuilder.append("}");
/* 11047 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiMod_CustomizedMode extends PA_IntBase {
/*       */     public PA_AmbLiMod_CustomizedMode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11053 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11058 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiMod_CustomizedMode");
/* 11059 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11060 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11061 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11062 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11063 */       stringBuilder.append("}");
/* 11064 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiMod_DriveMode extends PA_IntBase {
/*       */     public PA_AmbLiMod_DriveMode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11070 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11075 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiMod_DriveMode");
/* 11076 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11077 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11078 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11079 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11080 */       stringBuilder.append("}");
/* 11081 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiMod_MusicShowMode extends PA_IntBase {
/*       */     public PA_AmbLiMod_MusicShowMode(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11087 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11092 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiMod_MusicShowMode");
/* 11093 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11094 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11095 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11096 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11097 */       stringBuilder.append("}");
/* 11098 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiMod_WeatherIndn extends PA_IntBase {
/*       */     public PA_AmbLiMod_WeatherIndn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11104 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11109 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiMod_WeatherIndn");
/* 11110 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11111 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11112 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11113 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11114 */       stringBuilder.append("}");
/* 11115 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CustomEffect extends PA_IntBase {
/*       */     public PA_CustomEffect(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11121 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11126 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11131 */       StringBuilder stringBuilder = new StringBuilder("PA_CustomEffect");
/* 11132 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11133 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VFMiscCustomEffect.toString(this.data));
/* 11134 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11135 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11136 */       stringBuilder.append("}");
/* 11137 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TransitionEffectSel extends PA_IntBase {
/*       */     public PA_TransitionEffectSel(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11143 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11148 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11153 */       StringBuilder stringBuilder = new StringBuilder("PA_TransitionEffectSel");
/* 11154 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11155 */       stringBuilder.append(", dataValue = "); stringBuilder.append(IntrLiInten.toString(this.data));
/* 11156 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11157 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11158 */       stringBuilder.append("}");
/* 11159 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TransitionColor1Settings extends PA_IntBase {
/*       */     public PA_TransitionColor1Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11165 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11170 */       StringBuilder stringBuilder = new StringBuilder("PA_TransitionColor1Settings");
/* 11171 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11172 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11173 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11174 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11175 */       stringBuilder.append("}");
/* 11176 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TransitionColor2Settings extends PA_IntBase {
/*       */     public PA_TransitionColor2Settings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11182 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11187 */       StringBuilder stringBuilder = new StringBuilder("PA_TransitionColor2Settings");
/* 11188 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11189 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11190 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11191 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11192 */       stringBuilder.append("}");
/* 11193 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ZoneAllStatusSettings extends PA_IntBase {
/*       */     public PA_ZoneAllStatusSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11199 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11204 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11209 */       StringBuilder stringBuilder = new StringBuilder("PA_ZoneAllStatusSettings");
/* 11210 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11211 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11212 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11213 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11214 */       stringBuilder.append("}");
/* 11215 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ZoneAllIntensitySettings extends PA_IntBase {
/*       */     public PA_ZoneAllIntensitySettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11221 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11226 */       StringBuilder stringBuilder = new StringBuilder("PA_ZoneAllIntensitySettings");
/* 11227 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11228 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11229 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11230 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11231 */       stringBuilder.append("}");
/* 11232 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ZoneAllColorSettings extends PA_IntBase {
/*       */     public PA_ZoneAllColorSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11238 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11243 */       StringBuilder stringBuilder = new StringBuilder("PA_ZoneAllColorSettings");
/* 11244 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11245 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11246 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11247 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11248 */       stringBuilder.append("}");
/* 11249 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone1StatusSettings extends PA_IntBase {
/*       */     public PA_Zone1StatusSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11255 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11260 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11265 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone1StatusSettings");
/* 11266 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11267 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11268 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11269 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11270 */       stringBuilder.append("}");
/* 11271 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone1IntensitySettings extends PA_IntBase {
/*       */     public PA_Zone1IntensitySettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11277 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11282 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone1IntensitySettings");
/* 11283 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11284 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11285 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11286 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11287 */       stringBuilder.append("}");
/* 11288 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone1ColorSettings extends PA_IntBase {
/*       */     public PA_Zone1ColorSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11294 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11299 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone1ColorSettings");
/* 11300 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11301 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11302 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11303 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11304 */       stringBuilder.append("}");
/* 11305 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone2StatusSettings extends PA_IntBase {
/*       */     public PA_Zone2StatusSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11311 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11316 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11321 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone2StatusSettings");
/* 11322 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11323 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11324 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11325 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11326 */       stringBuilder.append("}");
/* 11327 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone2IntensitySettings extends PA_IntBase {
/*       */     public PA_Zone2IntensitySettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11333 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11338 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone2IntensitySettings");
/* 11339 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11340 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11341 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11342 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11343 */       stringBuilder.append("}");
/* 11344 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone2ColorSettings extends PA_IntBase {
/*       */     public PA_Zone2ColorSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11350 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11355 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone2ColorSettings");
/* 11356 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11357 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11358 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11359 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11360 */       stringBuilder.append("}");
/* 11361 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone3StatusSettings extends PA_IntBase {
/*       */     public PA_Zone3StatusSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11367 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11372 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11377 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone3StatusSettings");
/* 11378 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11379 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11380 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11381 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11382 */       stringBuilder.append("}");
/* 11383 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone3IntensitySettings extends PA_IntBase {
/*       */     public PA_Zone3IntensitySettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11389 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11394 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone3IntensitySettings");
/* 11395 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11396 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11397 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11398 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11399 */       stringBuilder.append("}");
/* 11400 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Zone3ColorSettings extends PA_IntBase {
/*       */     public PA_Zone3ColorSettings(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11406 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11411 */       StringBuilder stringBuilder = new StringBuilder("PA_Zone3ColorSettings");
/* 11412 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11413 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11414 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11415 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11416 */       stringBuilder.append("}");
/* 11417 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_MoodLightSwitch extends PA_IntBase {
/*       */     public PA_MoodLightSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11423 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11428 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11433 */       StringBuilder stringBuilder = new StringBuilder("PA_MoodLightSwitch");
/* 11434 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11435 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11436 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11437 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11438 */       stringBuilder.append("}");
/* 11439 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiMilgOpenReq extends PA_IntBase {
/*       */     public PA_AmbLiMilgOpenReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11445 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11450 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11455 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiMilgOpenReq");
/* 11456 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11457 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11458 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11459 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11460 */       stringBuilder.append("}");
/* 11461 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiPhoneOpenReq extends PA_IntBase {
/*       */     public PA_AmbLiPhoneOpenReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11467 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11472 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11477 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiPhoneOpenReq");
/* 11478 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11479 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11480 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11481 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11482 */       stringBuilder.append("}");
/* 11483 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightFrontLeft extends PA_IntBase {
/*       */     public PA_ReadLightFrontLeft(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11489 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11494 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11499 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightFrontLeft");
/* 11500 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11501 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 11502 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11503 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11504 */       stringBuilder.append("}");
/* 11505 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightFrontRight extends PA_IntBase {
/*       */     public PA_ReadLightFrontRight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11511 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11516 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11521 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightFrontRight");
/* 11522 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11523 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 11524 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11525 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11526 */       stringBuilder.append("}");
/* 11527 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightSecondRowLeft extends PA_IntBase {
/*       */     public PA_ReadLightSecondRowLeft(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11533 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11538 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11543 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightSecondRowLeft");
/* 11544 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11545 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 11546 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11547 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11548 */       stringBuilder.append("}");
/* 11549 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightSecondRowRight extends PA_IntBase {
/*       */     public PA_ReadLightSecondRowRight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11555 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11560 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11565 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightSecondRowRight");
/* 11566 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11567 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 11568 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11569 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11570 */       stringBuilder.append("}");
/* 11571 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightThirdRowLeft extends PA_IntBase {
/*       */     public PA_ReadLightThirdRowLeft(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11577 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11582 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11587 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightThirdRowLeft");
/* 11588 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11589 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 11590 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11591 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11592 */       stringBuilder.append("}");
/* 11593 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightThirdRowRight extends PA_IntBase {
/*       */     public PA_ReadLightThirdRowRight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11599 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11604 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11609 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightThirdRowRight");
/* 11610 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11611 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffNoReq.toString(this.data));
/* 11612 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11613 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11614 */       stringBuilder.append("}");
/* 11615 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WeatherInfoConService extends PA_IntBase {
/*       */     public PA_WeatherInfoConService(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11621 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11626 */       StringBuilder stringBuilder = new StringBuilder("PA_WeatherInfoConService");
/* 11627 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11628 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 11629 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11630 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11631 */       stringBuilder.append("}");
/* 11632 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CourtesyLight extends PA_IntBase {
/*       */     public PA_CourtesyLight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11638 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11643 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11648 */       StringBuilder stringBuilder = new StringBuilder("PA_CourtesyLight");
/* 11649 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11650 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11651 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11652 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11653 */       stringBuilder.append("}");
/* 11654 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WelcomeLight extends PA_IntBase {
/*       */     public PA_WelcomeLight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11660 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11665 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11670 */       StringBuilder stringBuilder = new StringBuilder("PA_WelcomeLight");
/* 11671 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11672 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11673 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11674 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11675 */       stringBuilder.append("}");
/* 11676 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_GoodbyeLight extends PA_IntBase {
/*       */     public PA_GoodbyeLight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11682 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11687 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11692 */       StringBuilder stringBuilder = new StringBuilder("PA_GoodbyeLight");
/* 11693 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11694 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11695 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11696 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11697 */       stringBuilder.append("}");
/* 11698 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ReadLightAllOnSwitch extends PA_IntBase {
/*       */     public PA_ReadLightAllOnSwitch(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11704 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11709 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11714 */       StringBuilder stringBuilder = new StringBuilder("PA_ReadLightAllOnSwitch");
/* 11715 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11716 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11717 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11718 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11719 */       stringBuilder.append("}");
/* 11720 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CustomEffectBreath extends PA_IntBase {
/*       */     public PA_CustomEffectBreath(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11726 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11731 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11736 */       StringBuilder stringBuilder = new StringBuilder("PA_CustomEffectBreath");
/* 11737 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11738 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11739 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11740 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11741 */       stringBuilder.append("}");
/* 11742 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_MoodLiColorAdjReq extends PA_IntBase {
/*       */     public PA_MoodLiColorAdjReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11748 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11753 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11758 */       StringBuilder stringBuilder = new StringBuilder("PA_MoodLiColorAdjReq");
/* 11759 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11760 */       stringBuilder.append(", dataValue = "); stringBuilder.append(MoodLiColorAdjReq.toString(this.data));
/* 11761 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11762 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11763 */       stringBuilder.append("}");
/* 11764 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLiRadarCorrlnReq extends PA_IntBase {
/*       */     public PA_AmbLiRadarCorrlnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11770 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11775 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11780 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLiRadarCorrlnReq");
/* 11781 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11782 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 11783 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11784 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11785 */       stringBuilder.append("}");
/* 11786 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_EgyRgnLvlSet extends PA_IntBase {
/*       */     public PA_EgyRgnLvlSet(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11792 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11797 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11802 */       StringBuilder stringBuilder = new StringBuilder("PA_EgyRgnLvlSet");
/* 11803 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11804 */       stringBuilder.append(", dataValue = "); stringBuilder.append(EgyRgnLvlSet.toString(this.data));
/* 11805 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11806 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11807 */       stringBuilder.append("}");
/* 11808 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinOpenDrvrReq extends PA_IntBase {
/*       */     public PA_WinOpenDrvrReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11814 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11819 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11824 */       StringBuilder stringBuilder = new StringBuilder("PA_WinOpenDrvrReq");
/* 11825 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11826 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11827 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11828 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11829 */       stringBuilder.append("}");
/* 11830 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinOpenPassReq extends PA_IntBase {
/*       */     public PA_WinOpenPassReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11836 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11841 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11846 */       StringBuilder stringBuilder = new StringBuilder("PA_WinOpenPassReq");
/* 11847 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11848 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11849 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11850 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11851 */       stringBuilder.append("}");
/* 11852 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinOpenReLeReq extends PA_IntBase {
/*       */     public PA_WinOpenReLeReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11858 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11863 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11868 */       StringBuilder stringBuilder = new StringBuilder("PA_WinOpenReLeReq");
/* 11869 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11870 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11871 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11872 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11873 */       stringBuilder.append("}");
/* 11874 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinOpenReRiReq extends PA_IntBase {
/*       */     public PA_WinOpenReRiReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11880 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11885 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11890 */       StringBuilder stringBuilder = new StringBuilder("PA_WinOpenReRiReq");
/* 11891 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11892 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11893 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11894 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11895 */       stringBuilder.append("}");
/* 11896 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinPosnStsAtDrvr extends PA_IntBase {
/*       */     public PA_WinPosnStsAtDrvr(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11902 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11907 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11912 */       StringBuilder stringBuilder = new StringBuilder("PA_WinPosnStsAtDrvr");
/* 11913 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11914 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11915 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11916 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11917 */       stringBuilder.append("}");
/* 11918 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinPosnStsAtPass extends PA_IntBase {
/*       */     public PA_WinPosnStsAtPass(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11924 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11929 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11934 */       StringBuilder stringBuilder = new StringBuilder("PA_WinPosnStsAtPass");
/* 11935 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11936 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11937 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11938 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11939 */       stringBuilder.append("}");
/* 11940 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinPosnStsAtReLe extends PA_IntBase {
/*       */     public PA_WinPosnStsAtReLe(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11946 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11951 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11956 */       StringBuilder stringBuilder = new StringBuilder("PA_WinPosnStsAtReLe");
/* 11957 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11958 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11959 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11960 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11961 */       stringBuilder.append("}");
/* 11962 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WinPosnStsAtReRi extends PA_IntBase {
/*       */     public PA_WinPosnStsAtReRi(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11968 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11973 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 11978 */       StringBuilder stringBuilder = new StringBuilder("PA_WinPosnStsAtReRi");
/* 11979 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 11980 */       stringBuilder.append(", dataValue = "); stringBuilder.append(WinAndRoofAndCurtPosnTyp.toString(this.data));
/* 11981 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 11982 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 11983 */       stringBuilder.append("}");
/* 11984 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ChdLockReLeft extends PA_IntBase {
/*       */     public PA_ChdLockReLeft(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 11990 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 11995 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12000 */       StringBuilder stringBuilder = new StringBuilder("PA_ChdLockReLeft");
/* 12001 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12002 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffSafe1.toString(this.data));
/* 12003 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12004 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12005 */       stringBuilder.append("}");
/* 12006 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ChdLockReRight extends PA_IntBase {
/*       */     public PA_ChdLockReRight(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12012 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12017 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12022 */       StringBuilder stringBuilder = new StringBuilder("PA_ChdLockReRight");
/* 12023 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12024 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffSafe1.toString(this.data));
/* 12025 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12026 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12027 */       stringBuilder.append("}");
/* 12028 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ChdLockReLeft_ChdMod extends PA_IntBase {
/*       */     public PA_ChdLockReLeft_ChdMod(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12034 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12039 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12044 */       StringBuilder stringBuilder = new StringBuilder("PA_ChdLockReLeft_ChdMod");
/* 12045 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12046 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffSafe1.toString(this.data));
/* 12047 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12048 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12049 */       stringBuilder.append("}");
/* 12050 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ChdLockReRight_ChdMod extends PA_IntBase {
/*       */     public PA_ChdLockReRight_ChdMod(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12056 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12061 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12066 */       StringBuilder stringBuilder = new StringBuilder("PA_ChdLockReRight_ChdMod");
/* 12067 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12068 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOffSafe1.toString(this.data));
/* 12069 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12070 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12071 */       stringBuilder.append("}");
/* 12072 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFS_FaceIdnReq extends PA_IntBase {
/*       */     public PA_VFS_FaceIdnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12078 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12083 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12088 */       StringBuilder stringBuilder = new StringBuilder("PA_VFS_FaceIdnReq");
/* 12089 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12090 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 12091 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12092 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12093 */       stringBuilder.append("}");
/* 12094 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFS_DPS extends PA_IntBase {
/*       */     public PA_VFS_DPS(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12100 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12105 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12110 */       StringBuilder stringBuilder = new StringBuilder("PA_VFS_DPS");
/* 12111 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12112 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 12113 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12114 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12115 */       stringBuilder.append("}");
/* 12116 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_ActiveProfile extends PA_IntBase {
/*       */     public PA_PSET_ActiveProfile(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12122 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12127 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12132 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ActiveProfile");
/* 12133 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12134 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12135 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12136 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12137 */       stringBuilder.append("}");
/* 12138 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NewProfile extends PA_IntBase {
/*       */     public PA_PSET_NewProfile(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12144 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12149 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12154 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NewProfile");
/* 12155 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12156 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12157 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12158 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12159 */       stringBuilder.append("}");
/* 12160 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_DeleteProfile extends PA_IntBase {
/*       */     public PA_PSET_DeleteProfile(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12166 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12171 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12176 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_DeleteProfile");
/* 12177 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12178 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12179 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12180 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12181 */       stringBuilder.append("}");
/* 12182 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_LogOut extends PA_IntBase {
/*       */     public PA_PSET_LogOut(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12188 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12193 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12198 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_LogOut");
/* 12199 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12200 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12201 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12202 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12203 */       stringBuilder.append("}");
/* 12204 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_ProfileFactoryDefault extends PA_IntBase {
/*       */     public PA_PSET_ProfileFactoryDefault(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12210 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12215 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12220 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ProfileFactoryDefault");
/* 12221 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12222 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12223 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12224 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12225 */       stringBuilder.append("}");
/* 12226 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_ProfileFactoryDefaultResult extends PA_IntBase {
/*       */     public PA_PSET_ProfileFactoryDefaultResult(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12232 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12237 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ProfileFactoryDefaultResult");
/* 12238 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12239 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12240 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12241 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12242 */       stringBuilder.append("}");
/* 12243 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_FactoryDefault extends PA_IntBase {
/*       */     public PA_PSET_FactoryDefault(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12249 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12254 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12259 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_FactoryDefault");
/* 12260 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12261 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12262 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12263 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12264 */       stringBuilder.append("}");
/* 12265 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_FactoryDefaultResult extends PA_IntBase {
/*       */     public PA_PSET_FactoryDefaultResult(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12271 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12276 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_FactoryDefaultResult");
/* 12277 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12278 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12279 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12280 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12281 */       stringBuilder.append("}");
/* 12282 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_Key_Result extends PA_IntBase {
/*       */     public PA_PSET_Key_Result(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12288 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12293 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12298 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_Key_Result");
/* 12299 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12300 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PAPSETKeyResultData.toString(this.data));
/* 12301 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12302 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12303 */       stringBuilder.append("}");
/* 12304 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_KeyID extends PA_IntBase {
/*       */     public PA_PSET_KeyID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12310 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12315 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12320 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_KeyID");
/* 12321 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12322 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PAPSETKeyIDInUsed.toString(this.data));
/* 12323 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12324 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12325 */       stringBuilder.append("}");
/* 12326 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_PChangeAllowed extends PA_IntBase {
/*       */     public PA_PSET_PChangeAllowed(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12332 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12337 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12342 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_PChangeAllowed");
/* 12343 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12344 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PAPSETPChangeAllowedData.toString(this.data));
/* 12345 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12346 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12347 */       stringBuilder.append("}");
/* 12348 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_MaxNrProfReached extends PA_IntBase {
/*       */     public PA_PSET_MaxNrProfReached(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12354 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12359 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12364 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_MaxNrProfReached");
/* 12365 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12366 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12367 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12368 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12369 */       stringBuilder.append("}");
/* 12370 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_AutLogOutCurrent extends PA_IntBase {
/*       */     public PA_PSET_AutLogOutCurrent(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12376 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12381 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_AutLogOutCurrent");
/* 12382 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12383 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12384 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12385 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12386 */       stringBuilder.append("}");
/* 12387 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_LYNKID extends PA_IntBase {
/*       */     public PA_PSET_LYNKID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12393 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12398 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_LYNKID");
/* 12399 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12400 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12401 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12402 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12403 */       stringBuilder.append("}");
/* 12404 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_LYNKID_Result extends PA_IntBase {
/*       */     public PA_PSET_LYNKID_Result(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12410 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12415 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_LYNKID_Result");
/* 12416 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12417 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12418 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12419 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12420 */       stringBuilder.append("}");
/* 12421 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NFCID extends PA_IntBase {
/*       */     public PA_PSET_NFCID(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12427 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12432 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NFCID");
/* 12433 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12434 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12435 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12436 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12437 */       stringBuilder.append("}");
/* 12438 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NFC_Result extends PA_IntBase {
/*       */     public PA_PSET_NFC_Result(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12444 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12449 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NFC_Result");
/* 12450 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12451 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12452 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12453 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12454 */       stringBuilder.append("}");
/* 12455 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_SimplUnlockCurrent extends PA_IntBase {
/*       */     public PA_PSET_SimplUnlockCurrent(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12461 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12466 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_SimplUnlockCurrent");
/* 12467 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12468 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12469 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12470 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12471 */       stringBuilder.append("}");
/* 12472 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_User1 extends PA_IntArrayBase {
/*       */     public PA_PSET_User1(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12478 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12483 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_User1");
/* 12484 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12485 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12486 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12487 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12488 */       stringBuilder.append("}");
/* 12489 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_User2 extends PA_IntArrayBase {
/*       */     public PA_PSET_User2(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12495 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12500 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_User2");
/* 12501 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12502 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12503 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12504 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12505 */       stringBuilder.append("}");
/* 12506 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_User3 extends PA_IntArrayBase {
/*       */     public PA_PSET_User3(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12512 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12517 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_User3");
/* 12518 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12519 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12520 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12521 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12522 */       stringBuilder.append("}");
/* 12523 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_User4 extends PA_IntArrayBase {
/*       */     public PA_PSET_User4(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12529 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12534 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_User4");
/* 12535 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12536 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12537 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12538 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12539 */       stringBuilder.append("}");
/* 12540 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_User5 extends PA_IntArrayBase {
/*       */     public PA_PSET_User5(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12546 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12551 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_User5");
/* 12552 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12553 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12554 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12555 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12556 */       stringBuilder.append("}");
/* 12557 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_User6 extends PA_IntArrayBase {
/*       */     public PA_PSET_User6(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12563 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12568 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_User6");
/* 12569 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12570 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12571 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12572 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12573 */       stringBuilder.append("}");
/* 12574 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_SeatButtonOnOff extends PA_IntBase {
/*       */     public PA_PSET_SeatButtonOnOff(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12580 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12585 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12590 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_SeatButtonOnOff");
/* 12591 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12592 */       stringBuilder.append(", dataValue = "); stringBuilder.append(BooleanType.toString(this.data));
/* 12593 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12594 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12595 */       stringBuilder.append("}");
/* 12596 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_SeatLocationAdjust extends PA_IntBase {
/*       */     public PA_PSET_SeatLocationAdjust(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12602 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 12607 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12612 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_SeatLocationAdjust");
/* 12613 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12614 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ButtonLocation.toString(this.data));
/* 12615 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12616 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12617 */       stringBuilder.append("}");
/* 12618 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_GID_Result extends PA_IntBase {
/*       */     public PA_PSET_GID_Result(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 12624 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getStatus() {
/* 12629 */       return this.status;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12634 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_GID_Result");
/* 12635 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12636 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 12637 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12638 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12639 */       stringBuilder.append("}");
/* 12640 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_ProfAct extends PA_IntArrayBase {
/*       */     public PA_PSET_ProfAct(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 12646 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 12651 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ProfAct");
/* 12652 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 12653 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 12654 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 12655 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 12656 */       stringBuilder.append("}");
/* 12657 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public static class PA_PSET_ProfileCloudData
/*       */   {
/*       */     private int climatebyte0;
/*       */     private int climatebyte1;
/*       */     private int climatebyte2;
/*       */     private int climatebyte3;
/*       */     private int climatebyte4;
/*       */     private int climatebyte5;
/*       */     private int climatebyte6;
/*       */     private int climatebyte7;
/*       */     private int climatebyte8;
/*       */     private int climatebyte9;
/*       */     private int drivemodebyte0;
/*       */     private int drivemodebyte1;
/*       */     private int drivemodebyte2;
/*       */     private int drivemodebyte3;
/*       */     private int drivemodebyte4;
/*       */     private int drivemodebyte5;
/*       */     private int drivemodebyte6;
/*       */     private int drivemodebyte7;
/*       */     private int drivemodebyte8;
/*       */     private int drivemodebyte9;
/*       */     private int profiletransferbyte0;
/*       */     private int profiletransferbyte1;
/*       */     private int profiletransferbyte10;
/*       */     private int profiletransferbyte11;
/*       */     private int profiletransferbyte12;
/*       */     private int profiletransferbyte13;
/*       */     private int profiletransferbyte14;
/*       */     private int profiletransferbyte15;
/*       */     private int profiletransferbyte16;
/*       */     private int profiletransferbyte17;
/*       */     private int profiletransferbyte18;
/*       */     private int profiletransferbyte19;
/*       */     private int profiletransferbyte2;
/*       */     private int profiletransferbyte3;
/*       */     private int profiletransferbyte4;
/*       */     private int profiletransferbyte5;
/*       */     private int profiletransferbyte6;
/*       */     private int profiletransferbyte7;
/*       */     private int profiletransferbyte8;
/*       */     private int profiletransferbyte9;
/*       */     private int seatctrlbyte0;
/*       */     private int seatctrlbyte1;
/*       */     private int seatctrlbyte2;
/*       */     private int seatctrlbyte3;
/*       */     private int seatctrlbyte4;
/*       */     private int seatctrlbyte5;
/*       */     private int seatctrlbyte6;
/*       */     private int seatctrlbyte7;
/*       */     private int seatctrlbyte8;
/*       */     private int seatctrlbyte9;
/*       */     private int seatheatbyte0;
/*       */     private int seatheatbyte1;
/*       */     private int seatheatbyte2;
/*       */     private int seatheatbyte3;
/*       */     private int seatheatbyte4;
/*       */     private int seatheatbyte5;
/*       */     private int seatheatbyte6;
/*       */     private int seatheatbyte7;
/*       */     private int seatheatbyte8;
/*       */     private int seatheatbyte9;
/*       */     private int systemsettingbyte0;
/*       */     private int systemsettingbyte1;
/*       */     private int systemsettingbyte10;
/*       */     private int systemsettingbyte11;
/*       */     private int systemsettingbyte12;
/*       */     private int systemsettingbyte13;
/*       */     private int systemsettingbyte14;
/*       */     private int systemsettingbyte15;
/*       */     private int systemsettingbyte16;
/*       */     private int systemsettingbyte17;
/*       */     private int systemsettingbyte18;
/*       */     private int systemsettingbyte19;
/*       */     private int systemsettingbyte2;
/*       */     private int systemsettingbyte3;
/*       */     private int systemsettingbyte4;
/*       */     private int systemsettingbyte5;
/*       */     private int systemsettingbyte6;
/*       */     private int systemsettingbyte7;
/*       */     private int systemsettingbyte8;
/*       */     private int systemsettingbyte9;
/*       */     private int vfhudbyte0;
/*       */     private int vfhudbyte1;
/*       */     private int vfhudbyte2;
/*       */     private int vfhudbyte3;
/*       */     private int vfhudbyte4;
/*       */     private int vfhudbyte5;
/*       */     private int vfhudbyte6;
/*       */     private int vfhudbyte7;
/*       */     private int vfhudbyte8;
/*       */     private int vfhudbyte9;
/*       */     private int vfmiscbyte0;
/*       */     private int vfmiscbyte1;
/*       */     private int vfmiscbyte10;
/*       */     private int vfmiscbyte11;
/*       */     private int vfmiscbyte12;
/*       */     private int vfmiscbyte13;
/*       */     private int vfmiscbyte14;
/*       */     private int vfmiscbyte15;
/*       */     private int vfmiscbyte16;
/*       */     private int vfmiscbyte17;
/*       */     private int vfmiscbyte18;
/*       */     private int vfmiscbyte19;
/*       */     private int vfmiscbyte2;
/*       */     private int vfmiscbyte20;
/*       */     private int vfmiscbyte21;
/*       */     private int vfmiscbyte22;
/*       */     private int vfmiscbyte23;
/*       */     private int vfmiscbyte24;
/*       */     private int vfmiscbyte25;
/*       */     private int vfmiscbyte26;
/*       */     private int vfmiscbyte27;
/*       */     private int vfmiscbyte28;
/*       */     private int vfmiscbyte29;
/*       */     private int vfmiscbyte3;
/*       */     private int vfmiscbyte30;
/*       */     private int vfmiscbyte31;
/*       */     private int vfmiscbyte32;
/*       */     private int vfmiscbyte33;
/*       */     private int vfmiscbyte34;
/*       */     private int vfmiscbyte35;
/*       */     private int vfmiscbyte36;
/*       */     private int vfmiscbyte37;
/*       */     private int vfmiscbyte38;
/*       */     private int vfmiscbyte39;
/*       */     private int vfmiscbyte4;
/*       */     private int vfmiscbyte40;
/*       */     private int vfmiscbyte41;
/*       */     private int vfmiscbyte42;
/*       */     private int vfmiscbyte43;
/*       */     private int vfmiscbyte44;
/*       */     private int vfmiscbyte45;
/*       */     private int vfmiscbyte46;
/*       */     private int vfmiscbyte47;
/*       */     private int vfmiscbyte48;
/*       */     private int vfmiscbyte49;
/*       */     private int vfmiscbyte5;
/*       */     private int vfmiscbyte50;
/*       */     private int vfmiscbyte51;
/*       */     private int vfmiscbyte52;
/*       */     private int vfmiscbyte53;
/*       */     private int vfmiscbyte54;
/*       */     private int vfmiscbyte55;
/*       */     private int vfmiscbyte56;
/*       */     private int vfmiscbyte57;
/*       */     private int vfmiscbyte58;
/*       */     private int vfmiscbyte59;
/*       */     private int vfmiscbyte6;
/*       */     private int vfmiscbyte7;
/*       */     private int vfmiscbyte8;
/*       */     private int vfmiscbyte9;
/*       */     
/*       */     PA_PSET_ProfileCloudData(VendorVehicleHalPAProto.Profileclouddata param1Profileclouddata) {
/* 12816 */       this.vfmiscbyte0 = param1Profileclouddata.vfmiscbyte0;
/* 12817 */       this.vfmiscbyte1 = param1Profileclouddata.vfmiscbyte1;
/* 12818 */       this.vfmiscbyte2 = param1Profileclouddata.vfmiscbyte2;
/* 12819 */       this.vfmiscbyte3 = param1Profileclouddata.vfmiscbyte3;
/* 12820 */       this.vfmiscbyte4 = param1Profileclouddata.vfmiscbyte4;
/* 12821 */       this.vfmiscbyte5 = param1Profileclouddata.vfmiscbyte5;
/* 12822 */       this.vfmiscbyte6 = param1Profileclouddata.vfmiscbyte6;
/* 12823 */       this.vfmiscbyte7 = param1Profileclouddata.vfmiscbyte7;
/* 12824 */       this.vfmiscbyte8 = param1Profileclouddata.vfmiscbyte8;
/* 12825 */       this.vfmiscbyte9 = param1Profileclouddata.vfmiscbyte9;
/* 12826 */       this.vfmiscbyte10 = param1Profileclouddata.vfmiscbyte10;
/* 12827 */       this.vfmiscbyte11 = param1Profileclouddata.vfmiscbyte11;
/* 12828 */       this.vfmiscbyte12 = param1Profileclouddata.vfmiscbyte12;
/* 12829 */       this.vfmiscbyte13 = param1Profileclouddata.vfmiscbyte13;
/* 12830 */       this.vfmiscbyte14 = param1Profileclouddata.vfmiscbyte14;
/* 12831 */       this.vfmiscbyte15 = param1Profileclouddata.vfmiscbyte15;
/* 12832 */       this.vfmiscbyte16 = param1Profileclouddata.vfmiscbyte16;
/* 12833 */       this.vfmiscbyte17 = param1Profileclouddata.vfmiscbyte17;
/* 12834 */       this.vfmiscbyte18 = param1Profileclouddata.vfmiscbyte18;
/* 12835 */       this.vfmiscbyte19 = param1Profileclouddata.vfmiscbyte19;
/* 12836 */       this.vfmiscbyte20 = param1Profileclouddata.vfmiscbyte20;
/* 12837 */       this.vfmiscbyte21 = param1Profileclouddata.vfmiscbyte21;
/* 12838 */       this.vfmiscbyte22 = param1Profileclouddata.vfmiscbyte22;
/* 12839 */       this.vfmiscbyte23 = param1Profileclouddata.vfmiscbyte23;
/* 12840 */       this.vfmiscbyte24 = param1Profileclouddata.vfmiscbyte24;
/* 12841 */       this.vfmiscbyte25 = param1Profileclouddata.vfmiscbyte25;
/* 12842 */       this.vfmiscbyte26 = param1Profileclouddata.vfmiscbyte26;
/* 12843 */       this.vfmiscbyte27 = param1Profileclouddata.vfmiscbyte27;
/* 12844 */       this.vfmiscbyte28 = param1Profileclouddata.vfmiscbyte28;
/* 12845 */       this.vfmiscbyte29 = param1Profileclouddata.vfmiscbyte29;
/* 12846 */       this.vfmiscbyte30 = param1Profileclouddata.vfmiscbyte30;
/* 12847 */       this.vfmiscbyte31 = param1Profileclouddata.vfmiscbyte31;
/* 12848 */       this.vfmiscbyte32 = param1Profileclouddata.vfmiscbyte32;
/* 12849 */       this.vfmiscbyte33 = param1Profileclouddata.vfmiscbyte33;
/* 12850 */       this.vfmiscbyte34 = param1Profileclouddata.vfmiscbyte34;
/* 12851 */       this.vfmiscbyte35 = param1Profileclouddata.vfmiscbyte35;
/* 12852 */       this.vfmiscbyte36 = param1Profileclouddata.vfmiscbyte36;
/* 12853 */       this.vfmiscbyte37 = param1Profileclouddata.vfmiscbyte37;
/* 12854 */       this.vfmiscbyte38 = param1Profileclouddata.vfmiscbyte38;
/* 12855 */       this.vfmiscbyte39 = param1Profileclouddata.vfmiscbyte39;
/* 12856 */       this.vfmiscbyte40 = param1Profileclouddata.vfmiscbyte40;
/* 12857 */       this.vfmiscbyte41 = param1Profileclouddata.vfmiscbyte41;
/* 12858 */       this.vfmiscbyte42 = param1Profileclouddata.vfmiscbyte42;
/* 12859 */       this.vfmiscbyte43 = param1Profileclouddata.vfmiscbyte43;
/* 12860 */       this.vfmiscbyte44 = param1Profileclouddata.vfmiscbyte44;
/* 12861 */       this.vfmiscbyte45 = param1Profileclouddata.vfmiscbyte45;
/* 12862 */       this.vfmiscbyte46 = param1Profileclouddata.vfmiscbyte46;
/* 12863 */       this.vfmiscbyte47 = param1Profileclouddata.vfmiscbyte47;
/* 12864 */       this.vfmiscbyte48 = param1Profileclouddata.vfmiscbyte48;
/* 12865 */       this.vfmiscbyte49 = param1Profileclouddata.vfmiscbyte49;
/* 12866 */       this.vfmiscbyte50 = param1Profileclouddata.vfmiscbyte50;
/* 12867 */       this.vfmiscbyte51 = param1Profileclouddata.vfmiscbyte51;
/* 12868 */       this.vfmiscbyte52 = param1Profileclouddata.vfmiscbyte52;
/* 12869 */       this.vfmiscbyte53 = param1Profileclouddata.vfmiscbyte53;
/* 12870 */       this.vfmiscbyte54 = param1Profileclouddata.vfmiscbyte54;
/* 12871 */       this.vfmiscbyte55 = param1Profileclouddata.vfmiscbyte55;
/* 12872 */       this.vfmiscbyte56 = param1Profileclouddata.vfmiscbyte56;
/* 12873 */       this.vfmiscbyte57 = param1Profileclouddata.vfmiscbyte57;
/* 12874 */       this.vfmiscbyte58 = param1Profileclouddata.vfmiscbyte58;
/* 12875 */       this.vfmiscbyte59 = param1Profileclouddata.vfmiscbyte59;
/* 12876 */       this.drivemodebyte0 = param1Profileclouddata.drivemodebyte0;
/* 12877 */       this.drivemodebyte1 = param1Profileclouddata.drivemodebyte1;
/* 12878 */       this.drivemodebyte2 = param1Profileclouddata.drivemodebyte2;
/* 12879 */       this.drivemodebyte3 = param1Profileclouddata.drivemodebyte3;
/* 12880 */       this.drivemodebyte4 = param1Profileclouddata.drivemodebyte4;
/* 12881 */       this.drivemodebyte5 = param1Profileclouddata.drivemodebyte5;
/* 12882 */       this.drivemodebyte6 = param1Profileclouddata.drivemodebyte6;
/* 12883 */       this.drivemodebyte7 = param1Profileclouddata.drivemodebyte7;
/* 12884 */       this.drivemodebyte8 = param1Profileclouddata.drivemodebyte8;
/* 12885 */       this.drivemodebyte9 = param1Profileclouddata.drivemodebyte9;
/* 12886 */       this.systemsettingbyte0 = param1Profileclouddata.systemsettingbyte0;
/* 12887 */       this.systemsettingbyte1 = param1Profileclouddata.systemsettingbyte1;
/* 12888 */       this.systemsettingbyte2 = param1Profileclouddata.systemsettingbyte2;
/* 12889 */       this.systemsettingbyte3 = param1Profileclouddata.systemsettingbyte3;
/* 12890 */       this.systemsettingbyte4 = param1Profileclouddata.systemsettingbyte4;
/* 12891 */       this.systemsettingbyte5 = param1Profileclouddata.systemsettingbyte5;
/* 12892 */       this.systemsettingbyte6 = param1Profileclouddata.systemsettingbyte6;
/* 12893 */       this.systemsettingbyte7 = param1Profileclouddata.systemsettingbyte7;
/* 12894 */       this.systemsettingbyte8 = param1Profileclouddata.systemsettingbyte8;
/* 12895 */       this.systemsettingbyte9 = param1Profileclouddata.systemsettingbyte9;
/* 12896 */       this.systemsettingbyte10 = param1Profileclouddata.systemsettingbyte10;
/* 12897 */       this.systemsettingbyte11 = param1Profileclouddata.systemsettingbyte11;
/* 12898 */       this.systemsettingbyte12 = param1Profileclouddata.systemsettingbyte12;
/* 12899 */       this.systemsettingbyte13 = param1Profileclouddata.systemsettingbyte13;
/* 12900 */       this.systemsettingbyte14 = param1Profileclouddata.systemsettingbyte14;
/* 12901 */       this.systemsettingbyte15 = param1Profileclouddata.systemsettingbyte15;
/* 12902 */       this.systemsettingbyte16 = param1Profileclouddata.systemsettingbyte16;
/* 12903 */       this.systemsettingbyte17 = param1Profileclouddata.systemsettingbyte17;
/* 12904 */       this.systemsettingbyte18 = param1Profileclouddata.systemsettingbyte18;
/* 12905 */       this.systemsettingbyte19 = param1Profileclouddata.systemsettingbyte19;
/* 12906 */       this.climatebyte0 = param1Profileclouddata.climatebyte0;
/* 12907 */       this.climatebyte1 = param1Profileclouddata.climatebyte1;
/* 12908 */       this.climatebyte2 = param1Profileclouddata.climatebyte2;
/* 12909 */       this.climatebyte3 = param1Profileclouddata.climatebyte3;
/* 12910 */       this.climatebyte4 = param1Profileclouddata.climatebyte4;
/* 12911 */       this.climatebyte5 = param1Profileclouddata.climatebyte5;
/* 12912 */       this.climatebyte6 = param1Profileclouddata.climatebyte6;
/* 12913 */       this.climatebyte7 = param1Profileclouddata.climatebyte7;
/* 12914 */       this.climatebyte8 = param1Profileclouddata.climatebyte8;
/* 12915 */       this.climatebyte9 = param1Profileclouddata.climatebyte9;
/* 12916 */       this.seatctrlbyte0 = param1Profileclouddata.seatctrlbyte0;
/* 12917 */       this.seatctrlbyte1 = param1Profileclouddata.seatctrlbyte1;
/* 12918 */       this.seatctrlbyte2 = param1Profileclouddata.seatctrlbyte2;
/* 12919 */       this.seatctrlbyte3 = param1Profileclouddata.seatctrlbyte3;
/* 12920 */       this.seatctrlbyte4 = param1Profileclouddata.seatctrlbyte4;
/* 12921 */       this.seatctrlbyte5 = param1Profileclouddata.seatctrlbyte5;
/* 12922 */       this.seatctrlbyte6 = param1Profileclouddata.seatctrlbyte6;
/* 12923 */       this.seatctrlbyte7 = param1Profileclouddata.seatctrlbyte7;
/* 12924 */       this.seatctrlbyte8 = param1Profileclouddata.seatctrlbyte8;
/* 12925 */       this.seatctrlbyte9 = param1Profileclouddata.seatctrlbyte9;
/* 12926 */       this.vfhudbyte0 = param1Profileclouddata.vfhudbyte0;
/* 12927 */       this.vfhudbyte1 = param1Profileclouddata.vfhudbyte1;
/* 12928 */       this.vfhudbyte2 = param1Profileclouddata.vfhudbyte2;
/* 12929 */       this.vfhudbyte3 = param1Profileclouddata.vfhudbyte3;
/* 12930 */       this.vfhudbyte4 = param1Profileclouddata.vfhudbyte4;
/* 12931 */       this.vfhudbyte5 = param1Profileclouddata.vfhudbyte5;
/* 12932 */       this.vfhudbyte6 = param1Profileclouddata.vfhudbyte6;
/* 12933 */       this.vfhudbyte7 = param1Profileclouddata.vfhudbyte7;
/* 12934 */       this.vfhudbyte8 = param1Profileclouddata.vfhudbyte8;
/* 12935 */       this.vfhudbyte9 = param1Profileclouddata.vfhudbyte9;
/* 12936 */       this.profiletransferbyte0 = param1Profileclouddata.profiletransferbyte0;
/* 12937 */       this.profiletransferbyte1 = param1Profileclouddata.profiletransferbyte1;
/* 12938 */       this.profiletransferbyte2 = param1Profileclouddata.profiletransferbyte2;
/* 12939 */       this.profiletransferbyte3 = param1Profileclouddata.profiletransferbyte3;
/* 12940 */       this.profiletransferbyte4 = param1Profileclouddata.profiletransferbyte4;
/* 12941 */       this.profiletransferbyte5 = param1Profileclouddata.profiletransferbyte5;
/* 12942 */       this.profiletransferbyte6 = param1Profileclouddata.profiletransferbyte6;
/* 12943 */       this.profiletransferbyte7 = param1Profileclouddata.profiletransferbyte7;
/* 12944 */       this.profiletransferbyte8 = param1Profileclouddata.profiletransferbyte8;
/* 12945 */       this.profiletransferbyte9 = param1Profileclouddata.profiletransferbyte9;
/* 12946 */       this.profiletransferbyte10 = param1Profileclouddata.profiletransferbyte10;
/* 12947 */       this.profiletransferbyte11 = param1Profileclouddata.profiletransferbyte11;
/* 12948 */       this.profiletransferbyte12 = param1Profileclouddata.profiletransferbyte12;
/* 12949 */       this.profiletransferbyte13 = param1Profileclouddata.profiletransferbyte13;
/* 12950 */       this.profiletransferbyte14 = param1Profileclouddata.profiletransferbyte14;
/* 12951 */       this.profiletransferbyte15 = param1Profileclouddata.profiletransferbyte15;
/* 12952 */       this.profiletransferbyte16 = param1Profileclouddata.profiletransferbyte16;
/* 12953 */       this.profiletransferbyte17 = param1Profileclouddata.profiletransferbyte17;
/* 12954 */       this.profiletransferbyte18 = param1Profileclouddata.profiletransferbyte18;
/* 12955 */       this.profiletransferbyte19 = param1Profileclouddata.profiletransferbyte19;
/* 12956 */       this.seatheatbyte0 = param1Profileclouddata.seatheatbyte0;
/* 12957 */       this.seatheatbyte1 = param1Profileclouddata.seatheatbyte1;
/* 12958 */       this.seatheatbyte2 = param1Profileclouddata.seatheatbyte2;
/* 12959 */       this.seatheatbyte3 = param1Profileclouddata.seatheatbyte3;
/* 12960 */       this.seatheatbyte4 = param1Profileclouddata.seatheatbyte4;
/* 12961 */       this.seatheatbyte5 = param1Profileclouddata.seatheatbyte5;
/* 12962 */       this.seatheatbyte6 = param1Profileclouddata.seatheatbyte6;
/* 12963 */       this.seatheatbyte7 = param1Profileclouddata.seatheatbyte7;
/* 12964 */       this.seatheatbyte8 = param1Profileclouddata.seatheatbyte8;
/* 12965 */       this.seatheatbyte9 = param1Profileclouddata.seatheatbyte9;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte0() {
/* 12969 */       return this.vfmiscbyte0;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte1() {
/* 12973 */       return this.vfmiscbyte1;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte2() {
/* 12977 */       return this.vfmiscbyte2;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte3() {
/* 12981 */       return this.vfmiscbyte3;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte4() {
/* 12985 */       return this.vfmiscbyte4;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte5() {
/* 12989 */       return this.vfmiscbyte5;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte6() {
/* 12993 */       return this.vfmiscbyte6;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte7() {
/* 12997 */       return this.vfmiscbyte7;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte8() {
/* 13001 */       return this.vfmiscbyte8;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte9() {
/* 13005 */       return this.vfmiscbyte9;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte10() {
/* 13009 */       return this.vfmiscbyte10;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte11() {
/* 13013 */       return this.vfmiscbyte11;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte12() {
/* 13017 */       return this.vfmiscbyte12;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte13() {
/* 13021 */       return this.vfmiscbyte13;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte14() {
/* 13025 */       return this.vfmiscbyte14;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte15() {
/* 13029 */       return this.vfmiscbyte15;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte16() {
/* 13033 */       return this.vfmiscbyte16;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte17() {
/* 13037 */       return this.vfmiscbyte17;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte18() {
/* 13041 */       return this.vfmiscbyte18;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte19() {
/* 13045 */       return this.vfmiscbyte19;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte20() {
/* 13049 */       return this.vfmiscbyte20;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte21() {
/* 13053 */       return this.vfmiscbyte21;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte22() {
/* 13057 */       return this.vfmiscbyte22;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte23() {
/* 13061 */       return this.vfmiscbyte23;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte24() {
/* 13065 */       return this.vfmiscbyte24;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte25() {
/* 13069 */       return this.vfmiscbyte25;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte26() {
/* 13073 */       return this.vfmiscbyte26;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte27() {
/* 13077 */       return this.vfmiscbyte27;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte28() {
/* 13081 */       return this.vfmiscbyte28;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte29() {
/* 13085 */       return this.vfmiscbyte29;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte30() {
/* 13089 */       return this.vfmiscbyte30;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte31() {
/* 13093 */       return this.vfmiscbyte31;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte32() {
/* 13097 */       return this.vfmiscbyte32;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte33() {
/* 13101 */       return this.vfmiscbyte33;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte34() {
/* 13105 */       return this.vfmiscbyte34;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte35() {
/* 13109 */       return this.vfmiscbyte35;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte36() {
/* 13113 */       return this.vfmiscbyte36;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte37() {
/* 13117 */       return this.vfmiscbyte37;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte38() {
/* 13121 */       return this.vfmiscbyte38;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte39() {
/* 13125 */       return this.vfmiscbyte39;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte40() {
/* 13129 */       return this.vfmiscbyte40;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte41() {
/* 13133 */       return this.vfmiscbyte41;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte42() {
/* 13137 */       return this.vfmiscbyte42;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte43() {
/* 13141 */       return this.vfmiscbyte43;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte44() {
/* 13145 */       return this.vfmiscbyte44;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte45() {
/* 13149 */       return this.vfmiscbyte45;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte46() {
/* 13153 */       return this.vfmiscbyte46;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte47() {
/* 13157 */       return this.vfmiscbyte47;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte48() {
/* 13161 */       return this.vfmiscbyte48;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte49() {
/* 13165 */       return this.vfmiscbyte49;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte50() {
/* 13169 */       return this.vfmiscbyte50;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte51() {
/* 13173 */       return this.vfmiscbyte51;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte52() {
/* 13177 */       return this.vfmiscbyte52;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte53() {
/* 13181 */       return this.vfmiscbyte53;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte54() {
/* 13185 */       return this.vfmiscbyte54;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte55() {
/* 13189 */       return this.vfmiscbyte55;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte56() {
/* 13193 */       return this.vfmiscbyte56;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte57() {
/* 13197 */       return this.vfmiscbyte57;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte58() {
/* 13201 */       return this.vfmiscbyte58;
/*       */     }
/*       */     
/*       */     public int getvfmiscbyte59() {
/* 13205 */       return this.vfmiscbyte59;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte0() {
/* 13209 */       return this.drivemodebyte0;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte1() {
/* 13213 */       return this.drivemodebyte1;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte2() {
/* 13217 */       return this.drivemodebyte2;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte3() {
/* 13221 */       return this.drivemodebyte3;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte4() {
/* 13225 */       return this.drivemodebyte4;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte5() {
/* 13229 */       return this.drivemodebyte5;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte6() {
/* 13233 */       return this.drivemodebyte6;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte7() {
/* 13237 */       return this.drivemodebyte7;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte8() {
/* 13241 */       return this.drivemodebyte8;
/*       */     }
/*       */     
/*       */     public int getdrivemodebyte9() {
/* 13245 */       return this.drivemodebyte9;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte0() {
/* 13249 */       return this.systemsettingbyte0;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte1() {
/* 13253 */       return this.systemsettingbyte1;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte2() {
/* 13257 */       return this.systemsettingbyte2;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte3() {
/* 13261 */       return this.systemsettingbyte3;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte4() {
/* 13265 */       return this.systemsettingbyte4;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte5() {
/* 13269 */       return this.systemsettingbyte5;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte6() {
/* 13273 */       return this.systemsettingbyte6;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte7() {
/* 13277 */       return this.systemsettingbyte7;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte8() {
/* 13281 */       return this.systemsettingbyte8;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte9() {
/* 13285 */       return this.systemsettingbyte9;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte10() {
/* 13289 */       return this.systemsettingbyte10;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte11() {
/* 13293 */       return this.systemsettingbyte11;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte12() {
/* 13297 */       return this.systemsettingbyte12;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte13() {
/* 13301 */       return this.systemsettingbyte13;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte14() {
/* 13305 */       return this.systemsettingbyte14;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte15() {
/* 13309 */       return this.systemsettingbyte15;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte16() {
/* 13313 */       return this.systemsettingbyte16;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte17() {
/* 13317 */       return this.systemsettingbyte17;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte18() {
/* 13321 */       return this.systemsettingbyte18;
/*       */     }
/*       */     
/*       */     public int getsystemsettingbyte19() {
/* 13325 */       return this.systemsettingbyte19;
/*       */     }
/*       */     
/*       */     public int getclimatebyte0() {
/* 13329 */       return this.climatebyte0;
/*       */     }
/*       */     
/*       */     public int getclimatebyte1() {
/* 13333 */       return this.climatebyte1;
/*       */     }
/*       */     
/*       */     public int getclimatebyte2() {
/* 13337 */       return this.climatebyte2;
/*       */     }
/*       */     
/*       */     public int getclimatebyte3() {
/* 13341 */       return this.climatebyte3;
/*       */     }
/*       */     
/*       */     public int getclimatebyte4() {
/* 13345 */       return this.climatebyte4;
/*       */     }
/*       */     
/*       */     public int getclimatebyte5() {
/* 13349 */       return this.climatebyte5;
/*       */     }
/*       */     
/*       */     public int getclimatebyte6() {
/* 13353 */       return this.climatebyte6;
/*       */     }
/*       */     
/*       */     public int getclimatebyte7() {
/* 13357 */       return this.climatebyte7;
/*       */     }
/*       */     
/*       */     public int getclimatebyte8() {
/* 13361 */       return this.climatebyte8;
/*       */     }
/*       */     
/*       */     public int getclimatebyte9() {
/* 13365 */       return this.climatebyte9;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte0() {
/* 13369 */       return this.seatctrlbyte0;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte1() {
/* 13373 */       return this.seatctrlbyte1;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte2() {
/* 13377 */       return this.seatctrlbyte2;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte3() {
/* 13381 */       return this.seatctrlbyte3;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte4() {
/* 13385 */       return this.seatctrlbyte4;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte5() {
/* 13389 */       return this.seatctrlbyte5;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte6() {
/* 13393 */       return this.seatctrlbyte6;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte7() {
/* 13397 */       return this.seatctrlbyte7;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte8() {
/* 13401 */       return this.seatctrlbyte8;
/*       */     }
/*       */     
/*       */     public int getseatctrlbyte9() {
/* 13405 */       return this.seatctrlbyte9;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte0() {
/* 13409 */       return this.vfhudbyte0;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte1() {
/* 13413 */       return this.vfhudbyte1;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte2() {
/* 13417 */       return this.vfhudbyte2;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte3() {
/* 13421 */       return this.vfhudbyte3;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte4() {
/* 13425 */       return this.vfhudbyte4;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte5() {
/* 13429 */       return this.vfhudbyte5;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte6() {
/* 13433 */       return this.vfhudbyte6;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte7() {
/* 13437 */       return this.vfhudbyte7;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte8() {
/* 13441 */       return this.vfhudbyte8;
/*       */     }
/*       */     
/*       */     public int getvfhudbyte9() {
/* 13445 */       return this.vfhudbyte9;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte0() {
/* 13449 */       return this.profiletransferbyte0;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte1() {
/* 13453 */       return this.profiletransferbyte1;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte2() {
/* 13457 */       return this.profiletransferbyte2;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte3() {
/* 13461 */       return this.profiletransferbyte3;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte4() {
/* 13465 */       return this.profiletransferbyte4;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte5() {
/* 13469 */       return this.profiletransferbyte5;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte6() {
/* 13473 */       return this.profiletransferbyte6;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte7() {
/* 13477 */       return this.profiletransferbyte7;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte8() {
/* 13481 */       return this.profiletransferbyte8;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte9() {
/* 13485 */       return this.profiletransferbyte9;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte10() {
/* 13489 */       return this.profiletransferbyte10;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte11() {
/* 13493 */       return this.profiletransferbyte11;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte12() {
/* 13497 */       return this.profiletransferbyte12;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte13() {
/* 13501 */       return this.profiletransferbyte13;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte14() {
/* 13505 */       return this.profiletransferbyte14;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte15() {
/* 13509 */       return this.profiletransferbyte15;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte16() {
/* 13513 */       return this.profiletransferbyte16;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte17() {
/* 13517 */       return this.profiletransferbyte17;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte18() {
/* 13521 */       return this.profiletransferbyte18;
/*       */     }
/*       */     
/*       */     public int getprofiletransferbyte19() {
/* 13525 */       return this.profiletransferbyte19;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte0() {
/* 13529 */       return this.seatheatbyte0;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte1() {
/* 13533 */       return this.seatheatbyte1;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte2() {
/* 13537 */       return this.seatheatbyte2;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte3() {
/* 13541 */       return this.seatheatbyte3;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte4() {
/* 13545 */       return this.seatheatbyte4;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte5() {
/* 13549 */       return this.seatheatbyte5;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte6() {
/* 13553 */       return this.seatheatbyte6;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte7() {
/* 13557 */       return this.seatheatbyte7;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte8() {
/* 13561 */       return this.seatheatbyte8;
/*       */     }
/*       */     
/*       */     public int getseatheatbyte9() {
/* 13565 */       return this.seatheatbyte9;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13570 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ProfileCloudData");
/* 13571 */       stringBuilder.append(", vfmiscbyte0 = "); stringBuilder.append(this.vfmiscbyte0);
/* 13572 */       stringBuilder.append(", vfmiscbyte1 = "); stringBuilder.append(this.vfmiscbyte1);
/* 13573 */       stringBuilder.append(", vfmiscbyte2 = "); stringBuilder.append(this.vfmiscbyte2);
/* 13574 */       stringBuilder.append(", vfmiscbyte3 = "); stringBuilder.append(this.vfmiscbyte3);
/* 13575 */       stringBuilder.append(", vfmiscbyte4 = "); stringBuilder.append(this.vfmiscbyte4);
/* 13576 */       stringBuilder.append(", vfmiscbyte5 = "); stringBuilder.append(this.vfmiscbyte5);
/* 13577 */       stringBuilder.append(", vfmiscbyte6 = "); stringBuilder.append(this.vfmiscbyte6);
/* 13578 */       stringBuilder.append(", vfmiscbyte7 = "); stringBuilder.append(this.vfmiscbyte7);
/* 13579 */       stringBuilder.append(", vfmiscbyte8 = "); stringBuilder.append(this.vfmiscbyte8);
/* 13580 */       stringBuilder.append(", vfmiscbyte9 = "); stringBuilder.append(this.vfmiscbyte9);
/* 13581 */       stringBuilder.append(", vfmiscbyte10 = "); stringBuilder.append(this.vfmiscbyte10);
/* 13582 */       stringBuilder.append(", vfmiscbyte11 = "); stringBuilder.append(this.vfmiscbyte11);
/* 13583 */       stringBuilder.append(", vfmiscbyte12 = "); stringBuilder.append(this.vfmiscbyte12);
/* 13584 */       stringBuilder.append(", vfmiscbyte13 = "); stringBuilder.append(this.vfmiscbyte13);
/* 13585 */       stringBuilder.append(", vfmiscbyte14 = "); stringBuilder.append(this.vfmiscbyte14);
/* 13586 */       stringBuilder.append(", vfmiscbyte15 = "); stringBuilder.append(this.vfmiscbyte15);
/* 13587 */       stringBuilder.append(", vfmiscbyte16 = "); stringBuilder.append(this.vfmiscbyte16);
/* 13588 */       stringBuilder.append(", vfmiscbyte17 = "); stringBuilder.append(this.vfmiscbyte17);
/* 13589 */       stringBuilder.append(", vfmiscbyte18 = "); stringBuilder.append(this.vfmiscbyte18);
/* 13590 */       stringBuilder.append(", vfmiscbyte19 = "); stringBuilder.append(this.vfmiscbyte19);
/* 13591 */       stringBuilder.append(", vfmiscbyte20 = "); stringBuilder.append(this.vfmiscbyte20);
/* 13592 */       stringBuilder.append(", vfmiscbyte21 = "); stringBuilder.append(this.vfmiscbyte21);
/* 13593 */       stringBuilder.append(", vfmiscbyte22 = "); stringBuilder.append(this.vfmiscbyte22);
/* 13594 */       stringBuilder.append(", vfmiscbyte23 = "); stringBuilder.append(this.vfmiscbyte23);
/* 13595 */       stringBuilder.append(", vfmiscbyte24 = "); stringBuilder.append(this.vfmiscbyte24);
/* 13596 */       stringBuilder.append(", vfmiscbyte25 = "); stringBuilder.append(this.vfmiscbyte25);
/* 13597 */       stringBuilder.append(", vfmiscbyte26 = "); stringBuilder.append(this.vfmiscbyte26);
/* 13598 */       stringBuilder.append(", vfmiscbyte27 = "); stringBuilder.append(this.vfmiscbyte27);
/* 13599 */       stringBuilder.append(", vfmiscbyte28 = "); stringBuilder.append(this.vfmiscbyte28);
/* 13600 */       stringBuilder.append(", vfmiscbyte29 = "); stringBuilder.append(this.vfmiscbyte29);
/* 13601 */       stringBuilder.append(", vfmiscbyte30 = "); stringBuilder.append(this.vfmiscbyte30);
/* 13602 */       stringBuilder.append(", vfmiscbyte31 = "); stringBuilder.append(this.vfmiscbyte31);
/* 13603 */       stringBuilder.append(", vfmiscbyte32 = "); stringBuilder.append(this.vfmiscbyte32);
/* 13604 */       stringBuilder.append(", vfmiscbyte33 = "); stringBuilder.append(this.vfmiscbyte33);
/* 13605 */       stringBuilder.append(", vfmiscbyte34 = "); stringBuilder.append(this.vfmiscbyte34);
/* 13606 */       stringBuilder.append(", vfmiscbyte35 = "); stringBuilder.append(this.vfmiscbyte35);
/* 13607 */       stringBuilder.append(", vfmiscbyte36 = "); stringBuilder.append(this.vfmiscbyte36);
/* 13608 */       stringBuilder.append(", vfmiscbyte37 = "); stringBuilder.append(this.vfmiscbyte37);
/* 13609 */       stringBuilder.append(", vfmiscbyte38 = "); stringBuilder.append(this.vfmiscbyte38);
/* 13610 */       stringBuilder.append(", vfmiscbyte39 = "); stringBuilder.append(this.vfmiscbyte39);
/* 13611 */       stringBuilder.append(", vfmiscbyte40 = "); stringBuilder.append(this.vfmiscbyte40);
/* 13612 */       stringBuilder.append(", vfmiscbyte41 = "); stringBuilder.append(this.vfmiscbyte41);
/* 13613 */       stringBuilder.append(", vfmiscbyte42 = "); stringBuilder.append(this.vfmiscbyte42);
/* 13614 */       stringBuilder.append(", vfmiscbyte43 = "); stringBuilder.append(this.vfmiscbyte43);
/* 13615 */       stringBuilder.append(", vfmiscbyte44 = "); stringBuilder.append(this.vfmiscbyte44);
/* 13616 */       stringBuilder.append(", vfmiscbyte45 = "); stringBuilder.append(this.vfmiscbyte45);
/* 13617 */       stringBuilder.append(", vfmiscbyte46 = "); stringBuilder.append(this.vfmiscbyte46);
/* 13618 */       stringBuilder.append(", vfmiscbyte47 = "); stringBuilder.append(this.vfmiscbyte47);
/* 13619 */       stringBuilder.append(", vfmiscbyte48 = "); stringBuilder.append(this.vfmiscbyte48);
/* 13620 */       stringBuilder.append(", vfmiscbyte49 = "); stringBuilder.append(this.vfmiscbyte49);
/* 13621 */       stringBuilder.append(", vfmiscbyte50 = "); stringBuilder.append(this.vfmiscbyte50);
/* 13622 */       stringBuilder.append(", vfmiscbyte51 = "); stringBuilder.append(this.vfmiscbyte51);
/* 13623 */       stringBuilder.append(", vfmiscbyte52 = "); stringBuilder.append(this.vfmiscbyte52);
/* 13624 */       stringBuilder.append(", vfmiscbyte53 = "); stringBuilder.append(this.vfmiscbyte53);
/* 13625 */       stringBuilder.append(", vfmiscbyte54 = "); stringBuilder.append(this.vfmiscbyte54);
/* 13626 */       stringBuilder.append(", vfmiscbyte55 = "); stringBuilder.append(this.vfmiscbyte55);
/* 13627 */       stringBuilder.append(", vfmiscbyte56 = "); stringBuilder.append(this.vfmiscbyte56);
/* 13628 */       stringBuilder.append(", vfmiscbyte57 = "); stringBuilder.append(this.vfmiscbyte57);
/* 13629 */       stringBuilder.append(", vfmiscbyte58 = "); stringBuilder.append(this.vfmiscbyte58);
/* 13630 */       stringBuilder.append(", vfmiscbyte59 = "); stringBuilder.append(this.vfmiscbyte59);
/* 13631 */       stringBuilder.append(", drivemodebyte0 = "); stringBuilder.append(this.drivemodebyte0);
/* 13632 */       stringBuilder.append(", drivemodebyte1 = "); stringBuilder.append(this.drivemodebyte1);
/* 13633 */       stringBuilder.append(", drivemodebyte2 = "); stringBuilder.append(this.drivemodebyte2);
/* 13634 */       stringBuilder.append(", drivemodebyte3 = "); stringBuilder.append(this.drivemodebyte3);
/* 13635 */       stringBuilder.append(", drivemodebyte4 = "); stringBuilder.append(this.drivemodebyte4);
/* 13636 */       stringBuilder.append(", drivemodebyte5 = "); stringBuilder.append(this.drivemodebyte5);
/* 13637 */       stringBuilder.append(", drivemodebyte6 = "); stringBuilder.append(this.drivemodebyte6);
/* 13638 */       stringBuilder.append(", drivemodebyte7 = "); stringBuilder.append(this.drivemodebyte7);
/* 13639 */       stringBuilder.append(", drivemodebyte8 = "); stringBuilder.append(this.drivemodebyte8);
/* 13640 */       stringBuilder.append(", drivemodebyte9 = "); stringBuilder.append(this.drivemodebyte9);
/* 13641 */       stringBuilder.append(", systemsettingbyte0 = "); stringBuilder.append(this.systemsettingbyte0);
/* 13642 */       stringBuilder.append(", systemsettingbyte1 = "); stringBuilder.append(this.systemsettingbyte1);
/* 13643 */       stringBuilder.append(", systemsettingbyte2 = "); stringBuilder.append(this.systemsettingbyte2);
/* 13644 */       stringBuilder.append(", systemsettingbyte3 = "); stringBuilder.append(this.systemsettingbyte3);
/* 13645 */       stringBuilder.append(", systemsettingbyte4 = "); stringBuilder.append(this.systemsettingbyte4);
/* 13646 */       stringBuilder.append(", systemsettingbyte5 = "); stringBuilder.append(this.systemsettingbyte5);
/* 13647 */       stringBuilder.append(", systemsettingbyte6 = "); stringBuilder.append(this.systemsettingbyte6);
/* 13648 */       stringBuilder.append(", systemsettingbyte7 = "); stringBuilder.append(this.systemsettingbyte7);
/* 13649 */       stringBuilder.append(", systemsettingbyte8 = "); stringBuilder.append(this.systemsettingbyte8);
/* 13650 */       stringBuilder.append(", systemsettingbyte9 = "); stringBuilder.append(this.systemsettingbyte9);
/* 13651 */       stringBuilder.append(", systemsettingbyte10 = "); stringBuilder.append(this.systemsettingbyte10);
/* 13652 */       stringBuilder.append(", systemsettingbyte11 = "); stringBuilder.append(this.systemsettingbyte11);
/* 13653 */       stringBuilder.append(", systemsettingbyte12 = "); stringBuilder.append(this.systemsettingbyte12);
/* 13654 */       stringBuilder.append(", systemsettingbyte13 = "); stringBuilder.append(this.systemsettingbyte13);
/* 13655 */       stringBuilder.append(", systemsettingbyte14 = "); stringBuilder.append(this.systemsettingbyte14);
/* 13656 */       stringBuilder.append(", systemsettingbyte15 = "); stringBuilder.append(this.systemsettingbyte15);
/* 13657 */       stringBuilder.append(", systemsettingbyte16 = "); stringBuilder.append(this.systemsettingbyte16);
/* 13658 */       stringBuilder.append(", systemsettingbyte17 = "); stringBuilder.append(this.systemsettingbyte17);
/* 13659 */       stringBuilder.append(", systemsettingbyte18 = "); stringBuilder.append(this.systemsettingbyte18);
/* 13660 */       stringBuilder.append(", systemsettingbyte19 = "); stringBuilder.append(this.systemsettingbyte19);
/* 13661 */       stringBuilder.append(", climatebyte0 = "); stringBuilder.append(this.climatebyte0);
/* 13662 */       stringBuilder.append(", climatebyte1 = "); stringBuilder.append(this.climatebyte1);
/* 13663 */       stringBuilder.append(", climatebyte2 = "); stringBuilder.append(this.climatebyte2);
/* 13664 */       stringBuilder.append(", climatebyte3 = "); stringBuilder.append(this.climatebyte3);
/* 13665 */       stringBuilder.append(", climatebyte4 = "); stringBuilder.append(this.climatebyte4);
/* 13666 */       stringBuilder.append(", climatebyte5 = "); stringBuilder.append(this.climatebyte5);
/* 13667 */       stringBuilder.append(", climatebyte6 = "); stringBuilder.append(this.climatebyte6);
/* 13668 */       stringBuilder.append(", climatebyte7 = "); stringBuilder.append(this.climatebyte7);
/* 13669 */       stringBuilder.append(", climatebyte8 = "); stringBuilder.append(this.climatebyte8);
/* 13670 */       stringBuilder.append(", climatebyte9 = "); stringBuilder.append(this.climatebyte9);
/* 13671 */       stringBuilder.append(", seatctrlbyte0 = "); stringBuilder.append(this.seatctrlbyte0);
/* 13672 */       stringBuilder.append(", seatctrlbyte1 = "); stringBuilder.append(this.seatctrlbyte1);
/* 13673 */       stringBuilder.append(", seatctrlbyte2 = "); stringBuilder.append(this.seatctrlbyte2);
/* 13674 */       stringBuilder.append(", seatctrlbyte3 = "); stringBuilder.append(this.seatctrlbyte3);
/* 13675 */       stringBuilder.append(", seatctrlbyte4 = "); stringBuilder.append(this.seatctrlbyte4);
/* 13676 */       stringBuilder.append(", seatctrlbyte5 = "); stringBuilder.append(this.seatctrlbyte5);
/* 13677 */       stringBuilder.append(", seatctrlbyte6 = "); stringBuilder.append(this.seatctrlbyte6);
/* 13678 */       stringBuilder.append(", seatctrlbyte7 = "); stringBuilder.append(this.seatctrlbyte7);
/* 13679 */       stringBuilder.append(", seatctrlbyte8 = "); stringBuilder.append(this.seatctrlbyte8);
/* 13680 */       stringBuilder.append(", seatctrlbyte9 = "); stringBuilder.append(this.seatctrlbyte9);
/* 13681 */       stringBuilder.append(", vfhudbyte0 = "); stringBuilder.append(this.vfhudbyte0);
/* 13682 */       stringBuilder.append(", vfhudbyte1 = "); stringBuilder.append(this.vfhudbyte1);
/* 13683 */       stringBuilder.append(", vfhudbyte2 = "); stringBuilder.append(this.vfhudbyte2);
/* 13684 */       stringBuilder.append(", vfhudbyte3 = "); stringBuilder.append(this.vfhudbyte3);
/* 13685 */       stringBuilder.append(", vfhudbyte4 = "); stringBuilder.append(this.vfhudbyte4);
/* 13686 */       stringBuilder.append(", vfhudbyte5 = "); stringBuilder.append(this.vfhudbyte5);
/* 13687 */       stringBuilder.append(", vfhudbyte6 = "); stringBuilder.append(this.vfhudbyte6);
/* 13688 */       stringBuilder.append(", vfhudbyte7 = "); stringBuilder.append(this.vfhudbyte7);
/* 13689 */       stringBuilder.append(", vfhudbyte8 = "); stringBuilder.append(this.vfhudbyte8);
/* 13690 */       stringBuilder.append(", vfhudbyte9 = "); stringBuilder.append(this.vfhudbyte9);
/* 13691 */       stringBuilder.append(", profiletransferbyte0 = "); stringBuilder.append(this.profiletransferbyte0);
/* 13692 */       stringBuilder.append(", profiletransferbyte1 = "); stringBuilder.append(this.profiletransferbyte1);
/* 13693 */       stringBuilder.append(", profiletransferbyte2 = "); stringBuilder.append(this.profiletransferbyte2);
/* 13694 */       stringBuilder.append(", profiletransferbyte3 = "); stringBuilder.append(this.profiletransferbyte3);
/* 13695 */       stringBuilder.append(", profiletransferbyte4 = "); stringBuilder.append(this.profiletransferbyte4);
/* 13696 */       stringBuilder.append(", profiletransferbyte5 = "); stringBuilder.append(this.profiletransferbyte5);
/* 13697 */       stringBuilder.append(", profiletransferbyte6 = "); stringBuilder.append(this.profiletransferbyte6);
/* 13698 */       stringBuilder.append(", profiletransferbyte7 = "); stringBuilder.append(this.profiletransferbyte7);
/* 13699 */       stringBuilder.append(", profiletransferbyte8 = "); stringBuilder.append(this.profiletransferbyte8);
/* 13700 */       stringBuilder.append(", profiletransferbyte9 = "); stringBuilder.append(this.profiletransferbyte9);
/* 13701 */       stringBuilder.append(", profiletransferbyte10 = "); stringBuilder.append(this.profiletransferbyte10);
/* 13702 */       stringBuilder.append(", profiletransferbyte11 = "); stringBuilder.append(this.profiletransferbyte11);
/* 13703 */       stringBuilder.append(", profiletransferbyte12 = "); stringBuilder.append(this.profiletransferbyte12);
/* 13704 */       stringBuilder.append(", profiletransferbyte13 = "); stringBuilder.append(this.profiletransferbyte13);
/* 13705 */       stringBuilder.append(", profiletransferbyte14 = "); stringBuilder.append(this.profiletransferbyte14);
/* 13706 */       stringBuilder.append(", profiletransferbyte15 = "); stringBuilder.append(this.profiletransferbyte15);
/* 13707 */       stringBuilder.append(", profiletransferbyte16 = "); stringBuilder.append(this.profiletransferbyte16);
/* 13708 */       stringBuilder.append(", profiletransferbyte17 = "); stringBuilder.append(this.profiletransferbyte17);
/* 13709 */       stringBuilder.append(", profiletransferbyte18 = "); stringBuilder.append(this.profiletransferbyte18);
/* 13710 */       stringBuilder.append(", profiletransferbyte19 = "); stringBuilder.append(this.profiletransferbyte19);
/* 13711 */       stringBuilder.append(", seatheatbyte0 = "); stringBuilder.append(this.seatheatbyte0);
/* 13712 */       stringBuilder.append(", seatheatbyte1 = "); stringBuilder.append(this.seatheatbyte1);
/* 13713 */       stringBuilder.append(", seatheatbyte2 = "); stringBuilder.append(this.seatheatbyte2);
/* 13714 */       stringBuilder.append(", seatheatbyte3 = "); stringBuilder.append(this.seatheatbyte3);
/* 13715 */       stringBuilder.append(", seatheatbyte4 = "); stringBuilder.append(this.seatheatbyte4);
/* 13716 */       stringBuilder.append(", seatheatbyte5 = "); stringBuilder.append(this.seatheatbyte5);
/* 13717 */       stringBuilder.append(", seatheatbyte6 = "); stringBuilder.append(this.seatheatbyte6);
/* 13718 */       stringBuilder.append(", seatheatbyte7 = "); stringBuilder.append(this.seatheatbyte7);
/* 13719 */       stringBuilder.append(", seatheatbyte8 = "); stringBuilder.append(this.seatheatbyte8);
/* 13720 */       stringBuilder.append(", seatheatbyte9 = "); stringBuilder.append(this.seatheatbyte9);
/* 13721 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_ProfileDownloadStatus extends PA_IntBase {
/*       */     public PA_PSET_ProfileDownloadStatus(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13727 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 13732 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13737 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ProfileDownloadStatus");
/* 13738 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13739 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ProfileChangeStatus.toString(this.data));
/* 13740 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13741 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13742 */       stringBuilder.append("}");
/* 13743 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_ProfilesInuse extends PA_IntArrayBase {
/*       */     public PA_PSET_ProfilesInuse(VendorVehicleHalPAProto.PAIntArrayType param1PAIntArrayType) {
/* 13749 */       super(param1PAIntArrayType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13754 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_ProfilesInuse");
/* 13755 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13756 */       stringBuilder.append(", dataValue = "); stringBuilder.append(Arrays.toString(this.data));
/* 13757 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13758 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13759 */       stringBuilder.append("}");
/* 13760 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmpDiagResult extends PA_IntBase {
/*       */     public PA_AmpDiagResult(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13766 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 13771 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13776 */       StringBuilder stringBuilder = new StringBuilder("PA_AmpDiagResult");
/* 13777 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13778 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ResultType.toString(this.data));
/* 13779 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13780 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13781 */       stringBuilder.append("}");
/* 13782 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AP_Version extends PA_IntBase {
/*       */     public PA_AP_Version(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13788 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13793 */       StringBuilder stringBuilder = new StringBuilder("PA_AP_Version");
/* 13794 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13795 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13796 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13797 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13798 */       stringBuilder.append("}");
/* 13799 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_MsgEnd extends PA_IntBase {
/*       */     public PA_TS_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13805 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13810 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_MsgEnd");
/* 13811 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13812 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13813 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13814 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13815 */       stringBuilder.append("}");
/* 13816 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Asy_MsgEnd extends PA_IntBase {
/*       */     public PA_Asy_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13822 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13827 */       StringBuilder stringBuilder = new StringBuilder("PA_Asy_MsgEnd");
/* 13828 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13829 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13830 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13831 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13832 */       stringBuilder.append("}");
/* 13833 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DiagProxy_MsgEnd extends PA_IntBase {
/*       */     public PA_DiagProxy_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13839 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13844 */       StringBuilder stringBuilder = new StringBuilder("PA_DiagProxy_MsgEnd");
/* 13845 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13846 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13847 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13848 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13849 */       stringBuilder.append("}");
/* 13850 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DID_MsgEnd extends PA_IntBase {
/*       */     public PA_DID_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13856 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13861 */       StringBuilder stringBuilder = new StringBuilder("PA_DID_MsgEnd");
/* 13862 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13863 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13864 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13865 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13866 */       stringBuilder.append("}");
/* 13867 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CL_MsgEnd extends PA_IntBase {
/*       */     public PA_CL_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13873 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13878 */       StringBuilder stringBuilder = new StringBuilder("PA_CL_MsgEnd");
/* 13879 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13880 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13881 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13882 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13883 */       stringBuilder.append("}");
/* 13884 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCV_MsgEnd extends PA_IntBase {
/*       */     public PA_SCV_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13890 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13895 */       StringBuilder stringBuilder = new StringBuilder("PA_SCV_MsgEnd");
/* 13896 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13897 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13898 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13899 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13900 */       stringBuilder.append("}");
/* 13901 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SWH_MsgEnd extends PA_IntBase {
/*       */     public PA_SWH_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13907 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13912 */       StringBuilder stringBuilder = new StringBuilder("PA_SWH_MsgEnd");
/* 13913 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13914 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13915 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13916 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13917 */       stringBuilder.append("}");
/* 13918 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Fragra_MsgEnd extends PA_IntBase {
/*       */     public PA_Fragra_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13924 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13929 */       StringBuilder stringBuilder = new StringBuilder("PA_Fragra_MsgEnd");
/* 13930 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13931 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13932 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13933 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13934 */       stringBuilder.append("}");
/* 13935 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TCH_MsgEnd extends PA_IntBase {
/*       */     public PA_TCH_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13941 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13946 */       StringBuilder stringBuilder = new StringBuilder("PA_TCH_MsgEnd");
/* 13947 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13948 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13949 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13950 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13951 */       stringBuilder.append("}");
/* 13952 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_DriveMode_MsgEnd extends PA_IntBase {
/*       */     public PA_DriveMode_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13958 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13963 */       StringBuilder stringBuilder = new StringBuilder("PA_DriveMode_MsgEnd");
/* 13964 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13965 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13966 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13967 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13968 */       stringBuilder.append("}");
/* 13969 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_MsgEnd extends PA_IntBase {
/*       */     public PA_PSET_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13975 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13980 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_MsgEnd");
/* 13981 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13982 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 13983 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 13984 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 13985 */       stringBuilder.append("}");
/* 13986 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SS_MsgEnd extends PA_IntBase {
/*       */     public PA_SS_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 13992 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 13997 */       StringBuilder stringBuilder = new StringBuilder("PA_SS_MsgEnd");
/* 13998 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 13999 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14000 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14001 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14002 */       stringBuilder.append("}");
/* 14003 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_Device_MsgEnd extends PA_IntBase {
/*       */     public PA_Device_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14009 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14014 */       StringBuilder stringBuilder = new StringBuilder("PA_Device_MsgEnd");
/* 14015 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14016 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14017 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14018 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14019 */       stringBuilder.append("}");
/* 14020 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HUD_MsgEnd extends PA_IntBase {
/*       */     public PA_HUD_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14026 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14031 */       StringBuilder stringBuilder = new StringBuilder("PA_HUD_MsgEnd");
/* 14032 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14033 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14034 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14035 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14036 */       stringBuilder.append("}");
/* 14037 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VFC_MsgEnd extends PA_IntBase {
/*       */     public PA_VFC_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14043 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14048 */       StringBuilder stringBuilder = new StringBuilder("PA_VFC_MsgEnd");
/* 14049 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14050 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14051 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14052 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14053 */       stringBuilder.append("}");
/* 14054 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAC_MsgEnd extends PA_IntBase {
/*       */     public PA_PAC_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14060 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14065 */       StringBuilder stringBuilder = new StringBuilder("PA_PAC_MsgEnd");
/* 14066 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14067 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14068 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14069 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14070 */       stringBuilder.append("}");
/* 14071 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PAS_MsgEnd extends PA_IntBase {
/*       */     public PA_PAS_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14077 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14082 */       StringBuilder stringBuilder = new StringBuilder("PA_PAS_MsgEnd");
/* 14083 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14084 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14085 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14086 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14087 */       stringBuilder.append("}");
/* 14088 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SC_MsgEnd extends PA_IntBase {
/*       */     public PA_SC_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14094 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14099 */       StringBuilder stringBuilder = new StringBuilder("PA_SC_MsgEnd");
/* 14100 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14101 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14102 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14103 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14104 */       stringBuilder.append("}");
/* 14105 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_MsgEnd extends PA_IntBase {
/*       */     public PA_VehCharg_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14111 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14116 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_MsgEnd");
/* 14117 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14118 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14119 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14120 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14121 */       stringBuilder.append("}");
/* 14122 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_WPC_MsgEnd extends PA_IntBase {
/*       */     public PA_WPC_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14128 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14133 */       StringBuilder stringBuilder = new StringBuilder("PA_WPC_MsgEnd");
/* 14134 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14135 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14136 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14137 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14138 */       stringBuilder.append("}");
/* 14139 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VM_MsgEnd extends PA_IntBase {
/*       */     public PA_VM_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14145 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14150 */       StringBuilder stringBuilder = new StringBuilder("PA_VM_MsgEnd");
/* 14151 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14152 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14153 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14154 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14155 */       stringBuilder.append("}");
/* 14156 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VM2_MsgEnd extends PA_IntBase {
/*       */     public PA_VM2_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14162 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14167 */       StringBuilder stringBuilder = new StringBuilder("PA_VM2_MsgEnd");
/* 14168 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14169 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14170 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14171 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14172 */       stringBuilder.append("}");
/* 14173 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_AmbLi_MsgEnd extends PA_IntBase {
/*       */     public PA_AmbLi_MsgEnd(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14179 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14184 */       StringBuilder stringBuilder = new StringBuilder("PA_AmbLi_MsgEnd");
/* 14185 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14186 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14187 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14188 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14189 */       stringBuilder.append("}");
/* 14190 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NameP1 extends PA_StringBase {
/*       */     public PA_PSET_NameP1(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 14196 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14201 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NameP1");
/* 14202 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14203 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14204 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14205 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14206 */       stringBuilder.append("}");
/* 14207 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NameP2 extends PA_StringBase {
/*       */     public PA_PSET_NameP2(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 14213 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14218 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NameP2");
/* 14219 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14220 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14221 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14222 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14223 */       stringBuilder.append("}");
/* 14224 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NameP3 extends PA_StringBase {
/*       */     public PA_PSET_NameP3(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 14230 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14235 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NameP3");
/* 14236 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14237 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14238 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14239 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14240 */       stringBuilder.append("}");
/* 14241 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NameP4 extends PA_StringBase {
/*       */     public PA_PSET_NameP4(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 14247 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14252 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NameP4");
/* 14253 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14254 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14255 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14256 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14257 */       stringBuilder.append("}");
/* 14258 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PSET_NameP5 extends PA_StringBase {
/*       */     public PA_PSET_NameP5(VendorVehicleHalPAProto.PAByteType param1PAByteType) {
/* 14264 */       super(param1PAByteType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14269 */       StringBuilder stringBuilder = new StringBuilder("PA_PSET_NameP5");
/* 14270 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14271 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14272 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14273 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14274 */       stringBuilder.append("}");
/* 14275 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HUD_DispModSet extends PA_IntBase {
/*       */     public PA_HUD_DispModSet(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14281 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14286 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14291 */       StringBuilder stringBuilder = new StringBuilder("PA_HUD_DispModSet");
/* 14292 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14293 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DispModSetgReq.toString(this.data));
/* 14294 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14295 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14296 */       stringBuilder.append("}");
/* 14297 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_NAVI_VehEgyCoornOpenAndCls extends PA_IntBase {
/*       */     public PA_NAVI_VehEgyCoornOpenAndCls(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14303 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14308 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14313 */       StringBuilder stringBuilder = new StringBuilder("PA_NAVI_VehEgyCoornOpenAndCls");
/* 14314 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14315 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OpendClsd2.toString(this.data));
/* 14316 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14317 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14318 */       stringBuilder.append("}");
/* 14319 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_NAVI_VehEgyCoornFctStChg extends PA_IntBase {
/*       */     public PA_NAVI_VehEgyCoornFctStChg(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14325 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14330 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14335 */       StringBuilder stringBuilder = new StringBuilder("PA_NAVI_VehEgyCoornFctStChg");
/* 14336 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14337 */       stringBuilder.append(", dataValue = "); stringBuilder.append(VehEgyCoornFctStChg.toString(this.data));
/* 14338 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14339 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14340 */       stringBuilder.append("}");
/* 14341 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_CurTripDis extends PA_IntBase {
/*       */     public PA_TS_CurTripDis(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14347 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14352 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_CurTripDis");
/* 14353 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14354 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14355 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14356 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14357 */       stringBuilder.append("}");
/* 14358 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TS_CurTripTime extends PA_IntBase {
/*       */     public PA_TS_CurTripTime(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14364 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14369 */       StringBuilder stringBuilder = new StringBuilder("PA_TS_CurTripTime");
/* 14370 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14371 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14372 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14373 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14374 */       stringBuilder.append("}");
/* 14375 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldWakeUp extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldWakeUp(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14381 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14386 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldWakeUp");
/* 14387 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14388 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14389 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14390 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14391 */       stringBuilder.append("}");
/* 14392 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldRomantic extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldRomantic(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14398 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14403 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldRomantic");
/* 14404 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14405 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14406 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14407 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14408 */       stringBuilder.append("}");
/* 14409 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldPet extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldPet(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14415 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14420 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldPet");
/* 14421 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14422 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14423 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14424 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14425 */       stringBuilder.append("}");
/* 14426 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldCarWash extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldCarWash(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14432 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14437 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldCarWash");
/* 14438 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14439 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14440 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14441 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14442 */       stringBuilder.append("}");
/* 14443 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldStranger extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldStranger(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14449 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14454 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldStranger");
/* 14455 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14456 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14457 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14458 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14459 */       stringBuilder.append("}");
/* 14460 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldBiochal extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldBiochal(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14466 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14471 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldBiochal");
/* 14472 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14473 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14474 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14475 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14476 */       stringBuilder.append("}");
/* 14477 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldChild extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldChild(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14483 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14488 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldChild");
/* 14489 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14490 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14491 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14492 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14493 */       stringBuilder.append("}");
/* 14494 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldDriverRest extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldDriverRest(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14500 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14505 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldDriverRest");
/* 14506 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14507 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14508 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14509 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14510 */       stringBuilder.append("}");
/* 14511 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldPassengerRest extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldPassengerRest(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14517 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14522 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldPassengerRest");
/* 14523 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14524 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14525 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14526 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14527 */       stringBuilder.append("}");
/* 14528 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldSecondLeftRest extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldSecondLeftRest(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14534 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14539 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldSecondLeftRest");
/* 14540 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14541 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14542 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14543 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14544 */       stringBuilder.append("}");
/* 14545 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldSecondRightRest extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldSecondRightRest(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14551 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14556 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldSecondRightRest");
/* 14557 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14558 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14559 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14560 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14561 */       stringBuilder.append("}");
/* 14562 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldFrontRowTheater extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldFrontRowTheater(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14568 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14573 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldFrontRowTheater");
/* 14574 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14575 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14576 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14577 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14578 */       stringBuilder.append("}");
/* 14579 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldRearRowTheater extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldRearRowTheater(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14585 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14590 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldRearRowTheater");
/* 14591 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14592 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14593 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14594 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14595 */       stringBuilder.append("}");
/* 14596 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldEco extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldEco(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14602 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14607 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldEco");
/* 14608 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14609 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14610 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14611 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14612 */       stringBuilder.append("}");
/* 14613 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldKing extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldKing(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14619 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14624 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldKing");
/* 14625 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14626 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14627 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14628 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14629 */       stringBuilder.append("}");
/* 14630 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldValue extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldValue(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14636 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14641 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14646 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldValue");
/* 14647 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14648 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PatSeld.toString(this.data));
/* 14649 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14650 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14651 */       stringBuilder.append("}");
/* 14652 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldGoddess extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldGoddess(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14658 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14663 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldGoddess");
/* 14664 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14665 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14666 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14667 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14668 */       stringBuilder.append("}");
/* 14669 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_PassSceneModSeldValue extends PA_IntBase {
/*       */     public PA_SCEMOD_PassSceneModSeldValue(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14675 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14680 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14685 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_PassSceneModSeldValue");
/* 14686 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14687 */       stringBuilder.append(", dataValue = "); stringBuilder.append(PatSeld.toString(this.data));
/* 14688 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14689 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14690 */       stringBuilder.append("}");
/* 14691 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldPassengerRepose extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldPassengerRepose(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14697 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14702 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldPassengerRepose");
/* 14703 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14704 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14705 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14706 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14707 */       stringBuilder.append("}");
/* 14708 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FD_FaceIdnReq extends PA_IntBase {
/*       */     public PA_FD_FaceIdnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14714 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14719 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14724 */       StringBuilder stringBuilder = new StringBuilder("PA_FD_FaceIdnReq");
/* 14725 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14726 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 14727 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14728 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14729 */       stringBuilder.append("}");
/* 14730 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SENSOR_DstToSrvValue extends PA_IntBase {
/*       */     public PA_SENSOR_DstToSrvValue(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14736 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14741 */       StringBuilder stringBuilder = new StringBuilder("PA_SENSOR_DstToSrvValue");
/* 14742 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14743 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14744 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14745 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14746 */       stringBuilder.append("}");
/* 14747 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SENSOR_DayToSrvValue extends PA_IntBase {
/*       */     public PA_SENSOR_DayToSrvValue(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14753 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14758 */       StringBuilder stringBuilder = new StringBuilder("PA_SENSOR_DayToSrvValue");
/* 14759 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14760 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14761 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14762 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14763 */       stringBuilder.append("}");
/* 14764 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SENSOR_EngHrToSrvValue extends PA_IntBase {
/*       */     public PA_SENSOR_EngHrToSrvValue(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14770 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14775 */       StringBuilder stringBuilder = new StringBuilder("PA_SENSOR_EngHrToSrvValue");
/* 14776 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14777 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14778 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14779 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14780 */       stringBuilder.append("}");
/* 14781 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SENSOR_JoyLimitState extends PA_IntBase {
/*       */     public PA_SENSOR_JoyLimitState(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14787 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14792 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14797 */       StringBuilder stringBuilder = new StringBuilder("PA_SENSOR_JoyLimitState");
/* 14798 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14799 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 14800 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14801 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14802 */       stringBuilder.append("}");
/* 14803 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SENSOR_JoyForbidState extends PA_IntBase {
/*       */     public PA_SENSOR_JoyForbidState(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14809 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14814 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14819 */       StringBuilder stringBuilder = new StringBuilder("PA_SENSOR_JoyForbidState");
/* 14820 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14821 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 14822 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14823 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14824 */       stringBuilder.append("}");
/* 14825 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldQuitStranger extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldQuitStranger(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14831 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14836 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldQuitStranger");
/* 14837 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14838 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14839 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14840 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14841 */       stringBuilder.append("}");
/* 14842 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SCEMOD_SceneModSeldCustomization extends PA_IntBase {
/*       */     public PA_SCEMOD_SceneModSeldCustomization(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14848 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14853 */       StringBuilder stringBuilder = new StringBuilder("PA_SCEMOD_SceneModSeldCustomization");
/* 14854 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14855 */       stringBuilder.append(", dataValue = "); stringBuilder.append(this.data);
/* 14856 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14857 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14858 */       stringBuilder.append("}");
/* 14859 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehCharg_ChargingColumn extends PA_IntBase {
/*       */     public PA_VehCharg_ChargingColumn(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14865 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14870 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14875 */       StringBuilder stringBuilder = new StringBuilder("PA_VehCharg_ChargingColumn");
/* 14876 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14877 */       stringBuilder.append(", dataValue = "); stringBuilder.append(ChargColor.toString(this.data));
/* 14878 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14879 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14880 */       stringBuilder.append("}");
/* 14881 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_CnclFaceReqForProf extends PA_IntBase {
/*       */     public PA_CnclFaceReqForProf(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14887 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14892 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14897 */       StringBuilder stringBuilder = new StringBuilder("PA_CnclFaceReqForProf");
/* 14898 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14899 */       stringBuilder.append(", dataValue = "); stringBuilder.append(YesNo2.toString(this.data));
/* 14900 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14901 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14902 */       stringBuilder.append("}");
/* 14903 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FaceIdnReq extends PA_IntBase {
/*       */     public PA_FaceIdnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14909 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14914 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14919 */       StringBuilder stringBuilder = new StringBuilder("PA_FaceIdnReq");
/* 14920 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14921 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 14922 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14923 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14924 */       stringBuilder.append("}");
/* 14925 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_FaceSgnInForProf extends PA_IntBase {
/*       */     public PA_FaceSgnInForProf(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14931 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14936 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14941 */       StringBuilder stringBuilder = new StringBuilder("PA_FaceSgnInForProf");
/* 14942 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14943 */       stringBuilder.append(", dataValue = "); stringBuilder.append(YesNo2.toString(this.data));
/* 14944 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14945 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14946 */       stringBuilder.append("}");
/* 14947 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_HudDispModSetgReq extends PA_IntBase {
/*       */     public PA_HudDispModSetgReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14953 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14958 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14963 */       StringBuilder stringBuilder = new StringBuilder("PA_HudDispModSetgReq");
/* 14964 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14965 */       stringBuilder.append(", dataValue = "); stringBuilder.append(DispModSetgReq.toString(this.data));
/* 14966 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14967 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14968 */       stringBuilder.append("}");
/* 14969 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_PrkgIndcrLineReq extends PA_IntBase {
/*       */     public PA_PrkgIndcrLineReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14975 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 14980 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 14985 */       StringBuilder stringBuilder = new StringBuilder("PA_PrkgIndcrLineReq");
/* 14986 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 14987 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 14988 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 14989 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 14990 */       stringBuilder.append("}");
/* 14991 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_SurrndgsObjDetnReq extends PA_IntBase {
/*       */     public PA_SurrndgsObjDetnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 14997 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 15002 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 15007 */       StringBuilder stringBuilder = new StringBuilder("PA_SurrndgsObjDetnReq");
/* 15008 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 15009 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 15010 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 15011 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 15012 */       stringBuilder.append("}");
/* 15013 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_ThrDTouringViewReq extends PA_IntBase {
/*       */     public PA_ThrDTouringViewReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 15019 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 15024 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 15029 */       StringBuilder stringBuilder = new StringBuilder("PA_ThrDTouringViewReq");
/* 15030 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 15031 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 15032 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 15033 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 15034 */       stringBuilder.append("}");
/* 15035 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TopVisnDispExtnReq extends PA_IntBase {
/*       */     public PA_TopVisnDispExtnReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 15041 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 15046 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 15051 */       StringBuilder stringBuilder = new StringBuilder("PA_TopVisnDispExtnReq");
/* 15052 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 15053 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 15054 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 15055 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 15056 */       stringBuilder.append("}");
/* 15057 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_TurnEntryAgWideVisReq extends PA_IntBase {
/*       */     public PA_TurnEntryAgWideVisReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 15063 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 15068 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 15073 */       StringBuilder stringBuilder = new StringBuilder("PA_TurnEntryAgWideVisReq");
/* 15074 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 15075 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 15076 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 15077 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 15078 */       stringBuilder.append("}");
/* 15079 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */   
/*       */   public static class PA_VehMdlClrReq extends PA_IntBase {
/*       */     public PA_VehMdlClrReq(VendorVehicleHalPAProto.PAIntType param1PAIntType) {
/* 15085 */       super(param1PAIntType);
/*       */     }
/*       */ 
/*       */     
/*       */     public int getData() {
/* 15090 */       return this.data;
/*       */     }
/*       */ 
/*       */     
/*       */     public String toString() {
/* 15095 */       StringBuilder stringBuilder = new StringBuilder("PA_VehMdlClrReq");
/* 15096 */       stringBuilder.append("{availability = "); stringBuilder.append(AvailabilitySts.toString(this.availability));
/* 15097 */       stringBuilder.append(", dataValue = "); stringBuilder.append(OnOff1.toString(this.data));
/* 15098 */       stringBuilder.append(", statusValue = "); stringBuilder.append(this.status);
/* 15099 */       stringBuilder.append(", formatValue = "); stringBuilder.append(this.format);
/* 15100 */       stringBuilder.append("}");
/* 15101 */       return stringBuilder.toString();
/*       */     }
/*       */   }
/*       */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\PATypes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */