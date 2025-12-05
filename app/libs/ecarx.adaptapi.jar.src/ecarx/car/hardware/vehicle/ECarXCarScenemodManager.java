/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.PatSeld;
/*     */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*     */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ECarXCarScenemodManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbscemodpassscenemodseld = 33276;
/*     */   public static final int ManagerId_cbscemodscenemodseld = 33277;
/*     */   public static final int ManagerId_pascemodpassscenemodseldvalue = 33953;
/*     */   public static final int ManagerId_pascemodscenemodseldbiochal = 33941;
/*     */   public static final int ManagerId_pascemodscenemodseldcarwash = 33939;
/*     */   public static final int ManagerId_pascemodscenemodseldchild = 33942;
/*     */   public static final int ManagerId_pascemodscenemodseldcustomization = 33962;
/*     */   public static final int ManagerId_pascemodscenemodselddriverrest = 33943;
/*     */   public static final int ManagerId_pascemodscenemodseldeco = 33949;
/*     */   public static final int ManagerId_pascemodscenemodseldfrontrowtheater = 33947;
/*     */   public static final int ManagerId_pascemodscenemodseldgoddess = 33952;
/*     */   public static final int ManagerId_pascemodscenemodseldking = 33950;
/*     */   public static final int ManagerId_pascemodscenemodseldpassengerrepose = 33954;
/*     */   public static final int ManagerId_pascemodscenemodseldpassengerrest = 33944;
/*     */   public static final int ManagerId_pascemodscenemodseldpet = 33938;
/*     */   public static final int ManagerId_pascemodscenemodseldquitstranger = 33961;
/*     */   public static final int ManagerId_pascemodscenemodseldrearrowtheater = 33948;
/*     */   public static final int ManagerId_pascemodscenemodseldromantic = 33937;
/*     */   public static final int ManagerId_pascemodscenemodseldsecondleftrest = 33945;
/*     */   public static final int ManagerId_pascemodscenemodseldsecondrightrest = 33946;
/*     */   public static final int ManagerId_pascemodscenemodseldstranger = 33940;
/*     */   public static final int ManagerId_pascemodscenemodseldvalue = 33951;
/*     */   public static final int ManagerId_pascemodscenemodseldwakeup = 33936;
/*     */   private static final String TAG = "ECarXCarScenemodManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarScenemodManager() {}
/*     */   
/*     */   public ECarXCarScenemodManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  74 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCEMOD_PassSceneModSeld(int paramInt) {
/*  84 */     ApiResult apiResult = ApiResult.FAILED;
/*  85 */     if (PatSeld.isValid(paramInt)) {
/*  86 */       apiResult = this.mMgr.setIntProperty(33276, 1, paramInt);
/*     */     } else {
/*  88 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  90 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SCEMOD_SceneModSeld(int paramInt) {
/* 100 */     ApiResult apiResult = ApiResult.FAILED;
/* 101 */     if (PatSeld.isValid(paramInt)) {
/* 102 */       apiResult = this.mMgr.setIntProperty(33277, 1, paramInt);
/*     */     } else {
/* 104 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 106 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldWakeUp getPA_SCEMOD_SceneModSeldWakeUp() throws CarNotConnectedException {
/* 117 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33936, 1);
/*     */     
/* 119 */     PATypes.PA_SCEMOD_SceneModSeldWakeUp pA_SCEMOD_SceneModSeldWakeUp = null;
/*     */     try {
/* 121 */       PATypes.PA_SCEMOD_SceneModSeldWakeUp pA_SCEMOD_SceneModSeldWakeUp1 = new PATypes.PA_SCEMOD_SceneModSeldWakeUp(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldWakeUp = pA_SCEMOD_SceneModSeldWakeUp1;
/* 122 */     } catch (Exception exception) {}
/*     */     
/* 124 */     return pA_SCEMOD_SceneModSeldWakeUp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldRomantic getPA_SCEMOD_SceneModSeldRomantic() throws CarNotConnectedException {
/* 133 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33937, 1);
/*     */     
/* 135 */     PATypes.PA_SCEMOD_SceneModSeldRomantic pA_SCEMOD_SceneModSeldRomantic = null;
/*     */     try {
/* 137 */       PATypes.PA_SCEMOD_SceneModSeldRomantic pA_SCEMOD_SceneModSeldRomantic1 = new PATypes.PA_SCEMOD_SceneModSeldRomantic(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldRomantic = pA_SCEMOD_SceneModSeldRomantic1;
/* 138 */     } catch (Exception exception) {}
/*     */     
/* 140 */     return pA_SCEMOD_SceneModSeldRomantic;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldPet getPA_SCEMOD_SceneModSeldPet() throws CarNotConnectedException {
/* 149 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33938, 1);
/*     */     
/* 151 */     PATypes.PA_SCEMOD_SceneModSeldPet pA_SCEMOD_SceneModSeldPet = null;
/*     */     try {
/* 153 */       PATypes.PA_SCEMOD_SceneModSeldPet pA_SCEMOD_SceneModSeldPet1 = new PATypes.PA_SCEMOD_SceneModSeldPet(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldPet = pA_SCEMOD_SceneModSeldPet1;
/* 154 */     } catch (Exception exception) {}
/*     */     
/* 156 */     return pA_SCEMOD_SceneModSeldPet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldCarWash getPA_SCEMOD_SceneModSeldCarWash() throws CarNotConnectedException {
/* 165 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33939, 1);
/*     */     
/* 167 */     PATypes.PA_SCEMOD_SceneModSeldCarWash pA_SCEMOD_SceneModSeldCarWash = null;
/*     */     try {
/* 169 */       PATypes.PA_SCEMOD_SceneModSeldCarWash pA_SCEMOD_SceneModSeldCarWash1 = new PATypes.PA_SCEMOD_SceneModSeldCarWash(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldCarWash = pA_SCEMOD_SceneModSeldCarWash1;
/* 170 */     } catch (Exception exception) {}
/*     */     
/* 172 */     return pA_SCEMOD_SceneModSeldCarWash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldStranger getPA_SCEMOD_SceneModSeldStranger() throws CarNotConnectedException {
/* 181 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33940, 1);
/*     */     
/* 183 */     PATypes.PA_SCEMOD_SceneModSeldStranger pA_SCEMOD_SceneModSeldStranger = null;
/*     */     try {
/* 185 */       PATypes.PA_SCEMOD_SceneModSeldStranger pA_SCEMOD_SceneModSeldStranger1 = new PATypes.PA_SCEMOD_SceneModSeldStranger(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldStranger = pA_SCEMOD_SceneModSeldStranger1;
/* 186 */     } catch (Exception exception) {}
/*     */     
/* 188 */     return pA_SCEMOD_SceneModSeldStranger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldBiochal getPA_SCEMOD_SceneModSeldBiochal() throws CarNotConnectedException {
/* 197 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33941, 1);
/*     */     
/* 199 */     PATypes.PA_SCEMOD_SceneModSeldBiochal pA_SCEMOD_SceneModSeldBiochal = null;
/*     */     try {
/* 201 */       PATypes.PA_SCEMOD_SceneModSeldBiochal pA_SCEMOD_SceneModSeldBiochal1 = new PATypes.PA_SCEMOD_SceneModSeldBiochal(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldBiochal = pA_SCEMOD_SceneModSeldBiochal1;
/* 202 */     } catch (Exception exception) {}
/*     */     
/* 204 */     return pA_SCEMOD_SceneModSeldBiochal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldChild getPA_SCEMOD_SceneModSeldChild() throws CarNotConnectedException {
/* 213 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33942, 1);
/*     */     
/* 215 */     PATypes.PA_SCEMOD_SceneModSeldChild pA_SCEMOD_SceneModSeldChild = null;
/*     */     try {
/* 217 */       PATypes.PA_SCEMOD_SceneModSeldChild pA_SCEMOD_SceneModSeldChild1 = new PATypes.PA_SCEMOD_SceneModSeldChild(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldChild = pA_SCEMOD_SceneModSeldChild1;
/* 218 */     } catch (Exception exception) {}
/*     */     
/* 220 */     return pA_SCEMOD_SceneModSeldChild;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldDriverRest getPA_SCEMOD_SceneModSeldDriverRest() throws CarNotConnectedException {
/* 229 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33943, 1);
/*     */     
/* 231 */     PATypes.PA_SCEMOD_SceneModSeldDriverRest pA_SCEMOD_SceneModSeldDriverRest = null;
/*     */     try {
/* 233 */       PATypes.PA_SCEMOD_SceneModSeldDriverRest pA_SCEMOD_SceneModSeldDriverRest1 = new PATypes.PA_SCEMOD_SceneModSeldDriverRest(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldDriverRest = pA_SCEMOD_SceneModSeldDriverRest1;
/* 234 */     } catch (Exception exception) {}
/*     */     
/* 236 */     return pA_SCEMOD_SceneModSeldDriverRest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldPassengerRest getPA_SCEMOD_SceneModSeldPassengerRest() throws CarNotConnectedException {
/* 245 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33944, 1);
/*     */     
/* 247 */     PATypes.PA_SCEMOD_SceneModSeldPassengerRest pA_SCEMOD_SceneModSeldPassengerRest = null;
/*     */     try {
/* 249 */       PATypes.PA_SCEMOD_SceneModSeldPassengerRest pA_SCEMOD_SceneModSeldPassengerRest1 = new PATypes.PA_SCEMOD_SceneModSeldPassengerRest(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldPassengerRest = pA_SCEMOD_SceneModSeldPassengerRest1;
/* 250 */     } catch (Exception exception) {}
/*     */     
/* 252 */     return pA_SCEMOD_SceneModSeldPassengerRest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest getPA_SCEMOD_SceneModSeldSecondLeftRest() throws CarNotConnectedException {
/* 261 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33945, 1);
/*     */     
/* 263 */     PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest pA_SCEMOD_SceneModSeldSecondLeftRest = null;
/*     */     try {
/* 265 */       PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest pA_SCEMOD_SceneModSeldSecondLeftRest1 = new PATypes.PA_SCEMOD_SceneModSeldSecondLeftRest(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldSecondLeftRest = pA_SCEMOD_SceneModSeldSecondLeftRest1;
/* 266 */     } catch (Exception exception) {}
/*     */     
/* 268 */     return pA_SCEMOD_SceneModSeldSecondLeftRest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldSecondRightRest getPA_SCEMOD_SceneModSeldSecondRightRest() throws CarNotConnectedException {
/* 277 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33946, 1);
/*     */     
/* 279 */     PATypes.PA_SCEMOD_SceneModSeldSecondRightRest pA_SCEMOD_SceneModSeldSecondRightRest = null;
/*     */     try {
/* 281 */       PATypes.PA_SCEMOD_SceneModSeldSecondRightRest pA_SCEMOD_SceneModSeldSecondRightRest1 = new PATypes.PA_SCEMOD_SceneModSeldSecondRightRest(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldSecondRightRest = pA_SCEMOD_SceneModSeldSecondRightRest1;
/* 282 */     } catch (Exception exception) {}
/*     */     
/* 284 */     return pA_SCEMOD_SceneModSeldSecondRightRest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater getPA_SCEMOD_SceneModSeldFrontRowTheater() throws CarNotConnectedException {
/* 293 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33947, 1);
/*     */     
/* 295 */     PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater pA_SCEMOD_SceneModSeldFrontRowTheater = null;
/*     */     try {
/* 297 */       PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater pA_SCEMOD_SceneModSeldFrontRowTheater1 = new PATypes.PA_SCEMOD_SceneModSeldFrontRowTheater(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldFrontRowTheater = pA_SCEMOD_SceneModSeldFrontRowTheater1;
/* 298 */     } catch (Exception exception) {}
/*     */     
/* 300 */     return pA_SCEMOD_SceneModSeldFrontRowTheater;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldRearRowTheater getPA_SCEMOD_SceneModSeldRearRowTheater() throws CarNotConnectedException {
/* 309 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33948, 1);
/*     */     
/* 311 */     PATypes.PA_SCEMOD_SceneModSeldRearRowTheater pA_SCEMOD_SceneModSeldRearRowTheater = null;
/*     */     try {
/* 313 */       PATypes.PA_SCEMOD_SceneModSeldRearRowTheater pA_SCEMOD_SceneModSeldRearRowTheater1 = new PATypes.PA_SCEMOD_SceneModSeldRearRowTheater(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldRearRowTheater = pA_SCEMOD_SceneModSeldRearRowTheater1;
/* 314 */     } catch (Exception exception) {}
/*     */     
/* 316 */     return pA_SCEMOD_SceneModSeldRearRowTheater;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldEco getPA_SCEMOD_SceneModSeldEco() throws CarNotConnectedException {
/* 325 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33949, 1);
/*     */     
/* 327 */     PATypes.PA_SCEMOD_SceneModSeldEco pA_SCEMOD_SceneModSeldEco = null;
/*     */     try {
/* 329 */       PATypes.PA_SCEMOD_SceneModSeldEco pA_SCEMOD_SceneModSeldEco1 = new PATypes.PA_SCEMOD_SceneModSeldEco(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldEco = pA_SCEMOD_SceneModSeldEco1;
/* 330 */     } catch (Exception exception) {}
/*     */     
/* 332 */     return pA_SCEMOD_SceneModSeldEco;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldKing getPA_SCEMOD_SceneModSeldKing() throws CarNotConnectedException {
/* 341 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33950, 1);
/*     */     
/* 343 */     PATypes.PA_SCEMOD_SceneModSeldKing pA_SCEMOD_SceneModSeldKing = null;
/*     */     try {
/* 345 */       PATypes.PA_SCEMOD_SceneModSeldKing pA_SCEMOD_SceneModSeldKing1 = new PATypes.PA_SCEMOD_SceneModSeldKing(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldKing = pA_SCEMOD_SceneModSeldKing1;
/* 346 */     } catch (Exception exception) {}
/*     */     
/* 348 */     return pA_SCEMOD_SceneModSeldKing;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldValue getPA_SCEMOD_SceneModSeldValue() throws CarNotConnectedException {
/* 357 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33951, 1);
/*     */     
/* 359 */     PATypes.PA_SCEMOD_SceneModSeldValue pA_SCEMOD_SceneModSeldValue = null;
/*     */     try {
/* 361 */       PATypes.PA_SCEMOD_SceneModSeldValue pA_SCEMOD_SceneModSeldValue1 = new PATypes.PA_SCEMOD_SceneModSeldValue(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldValue = pA_SCEMOD_SceneModSeldValue1;
/* 362 */     } catch (Exception exception) {}
/*     */     
/* 364 */     return pA_SCEMOD_SceneModSeldValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldGoddess getPA_SCEMOD_SceneModSeldGoddess() throws CarNotConnectedException {
/* 373 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33952, 1);
/*     */     
/* 375 */     PATypes.PA_SCEMOD_SceneModSeldGoddess pA_SCEMOD_SceneModSeldGoddess = null;
/*     */     try {
/* 377 */       PATypes.PA_SCEMOD_SceneModSeldGoddess pA_SCEMOD_SceneModSeldGoddess1 = new PATypes.PA_SCEMOD_SceneModSeldGoddess(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldGoddess = pA_SCEMOD_SceneModSeldGoddess1;
/* 378 */     } catch (Exception exception) {}
/*     */     
/* 380 */     return pA_SCEMOD_SceneModSeldGoddess;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_PassSceneModSeldValue getPA_SCEMOD_PassSceneModSeldValue() throws CarNotConnectedException {
/* 389 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33953, 1);
/*     */     
/* 391 */     PATypes.PA_SCEMOD_PassSceneModSeldValue pA_SCEMOD_PassSceneModSeldValue = null;
/*     */     try {
/* 393 */       PATypes.PA_SCEMOD_PassSceneModSeldValue pA_SCEMOD_PassSceneModSeldValue1 = new PATypes.PA_SCEMOD_PassSceneModSeldValue(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_PassSceneModSeldValue = pA_SCEMOD_PassSceneModSeldValue1;
/* 394 */     } catch (Exception exception) {}
/*     */     
/* 396 */     return pA_SCEMOD_PassSceneModSeldValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldPassengerRepose getPA_SCEMOD_SceneModSeldPassengerRepose() throws CarNotConnectedException {
/* 405 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33954, 1);
/*     */     
/* 407 */     PATypes.PA_SCEMOD_SceneModSeldPassengerRepose pA_SCEMOD_SceneModSeldPassengerRepose = null;
/*     */     try {
/* 409 */       PATypes.PA_SCEMOD_SceneModSeldPassengerRepose pA_SCEMOD_SceneModSeldPassengerRepose1 = new PATypes.PA_SCEMOD_SceneModSeldPassengerRepose(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldPassengerRepose = pA_SCEMOD_SceneModSeldPassengerRepose1;
/* 410 */     } catch (Exception exception) {}
/*     */     
/* 412 */     return pA_SCEMOD_SceneModSeldPassengerRepose;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldQuitStranger getPA_SCEMOD_SceneModSeldQuitStranger() throws CarNotConnectedException {
/* 421 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33961, 1);
/*     */     
/* 423 */     PATypes.PA_SCEMOD_SceneModSeldQuitStranger pA_SCEMOD_SceneModSeldQuitStranger = null;
/*     */     try {
/* 425 */       PATypes.PA_SCEMOD_SceneModSeldQuitStranger pA_SCEMOD_SceneModSeldQuitStranger1 = new PATypes.PA_SCEMOD_SceneModSeldQuitStranger(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldQuitStranger = pA_SCEMOD_SceneModSeldQuitStranger1;
/* 426 */     } catch (Exception exception) {}
/*     */     
/* 428 */     return pA_SCEMOD_SceneModSeldQuitStranger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SCEMOD_SceneModSeldCustomization getPA_SCEMOD_SceneModSeldCustomization() throws CarNotConnectedException {
/* 437 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33962, 1);
/*     */     
/* 439 */     PATypes.PA_SCEMOD_SceneModSeldCustomization pA_SCEMOD_SceneModSeldCustomization = null;
/*     */     try {
/* 441 */       PATypes.PA_SCEMOD_SceneModSeldCustomization pA_SCEMOD_SceneModSeldCustomization1 = new PATypes.PA_SCEMOD_SceneModSeldCustomization(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SCEMOD_SceneModSeldCustomization = pA_SCEMOD_SceneModSeldCustomization1;
/* 442 */     } catch (Exception exception) {}
/*     */     
/* 444 */     return pA_SCEMOD_SceneModSeldCustomization;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarScenemodManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */