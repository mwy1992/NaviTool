/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.EgyRgnLvlSet;
/*     */ import ecarx.car.hardware.annotation.LockgCenReq2;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.WinAndRoofAndCurtPosnTyp;
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
/*     */ public class ECarXCarVfsmallcycleManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbchdlockreleft = 33248;
/*     */   public static final int ManagerId_cbchdlockreleftchdmod = 33250;
/*     */   public static final int ManagerId_cbchdlockreright = 33249;
/*     */   public static final int ManagerId_cbchdlockrerightchdmod = 33251;
/*     */   public static final int ManagerId_cbegyrgnlvlset = 33243;
/*     */   public static final int ManagerId_cbsmallcyclereboot = 33252;
/*     */   public static final int ManagerId_cbvfsdps = 33254;
/*     */   public static final int ManagerId_cbvfsfaceidnreq = 33253;
/*     */   public static final int ManagerId_cbwinopendrvrreq = 33244;
/*     */   public static final int ManagerId_cbwinopenpassreq = 33245;
/*     */   public static final int ManagerId_cbwinopenrelereq = 33246;
/*     */   public static final int ManagerId_cbwinopenrerireq = 33247;
/*     */   public static final int ManagerId_pachdlockreleft = 33864;
/*     */   public static final int ManagerId_pachdlockreleftchdmod = 33866;
/*     */   public static final int ManagerId_pachdlockreright = 33865;
/*     */   public static final int ManagerId_pachdlockrerightchdmod = 33867;
/*     */   public static final int ManagerId_paegyrgnlvlset = 33855;
/*     */   public static final int ManagerId_pavfsdps = 33869;
/*     */   public static final int ManagerId_pavfsfaceidnreq = 33868;
/*     */   public static final int ManagerId_pawinopendrvrreq = 33856;
/*     */   public static final int ManagerId_pawinopenpassreq = 33857;
/*     */   public static final int ManagerId_pawinopenrelereq = 33858;
/*     */   public static final int ManagerId_pawinopenrerireq = 33859;
/*     */   public static final int ManagerId_pawinposnstsatdrvr = 33860;
/*     */   public static final int ManagerId_pawinposnstsatpass = 33861;
/*     */   public static final int ManagerId_pawinposnstsatrele = 33862;
/*     */   public static final int ManagerId_pawinposnstsatreri = 33863;
/*     */   private static final String TAG = "ECarXCarVfsmallcycleManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarVfsmallcycleManager() {}
/*     */   
/*     */   public ECarXCarVfsmallcycleManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  81 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_EgyRgnLvlSet(int paramInt) {
/*  91 */     ApiResult apiResult = ApiResult.FAILED;
/*  92 */     if (EgyRgnLvlSet.isValid(paramInt)) {
/*  93 */       apiResult = this.mMgr.setIntProperty(33243, 1, paramInt);
/*     */     } else {
/*  95 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  97 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_WinOpenDrvrReq(int paramInt) {
/* 107 */     ApiResult apiResult = ApiResult.FAILED;
/* 108 */     if (WinAndRoofAndCurtPosnTyp.isValid(paramInt)) {
/* 109 */       apiResult = this.mMgr.setIntProperty(33244, 1, paramInt);
/*     */     } else {
/* 111 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 113 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_WinOpenPassReq(int paramInt) {
/* 123 */     ApiResult apiResult = ApiResult.FAILED;
/* 124 */     if (WinAndRoofAndCurtPosnTyp.isValid(paramInt)) {
/* 125 */       apiResult = this.mMgr.setIntProperty(33245, 1, paramInt);
/*     */     } else {
/* 127 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 129 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_WinOpenReLeReq(int paramInt) {
/* 139 */     ApiResult apiResult = ApiResult.FAILED;
/* 140 */     if (WinAndRoofAndCurtPosnTyp.isValid(paramInt)) {
/* 141 */       apiResult = this.mMgr.setIntProperty(33246, 1, paramInt);
/*     */     } else {
/* 143 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 145 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_WinOpenReRiReq(int paramInt) {
/* 155 */     ApiResult apiResult = ApiResult.FAILED;
/* 156 */     if (WinAndRoofAndCurtPosnTyp.isValid(paramInt)) {
/* 157 */       apiResult = this.mMgr.setIntProperty(33247, 1, paramInt);
/*     */     } else {
/* 159 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 161 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ChdLockReLeft(int paramInt) {
/* 171 */     ApiResult apiResult = ApiResult.FAILED;
/* 172 */     if (LockgCenReq2.isValid(paramInt)) {
/* 173 */       apiResult = this.mMgr.setIntProperty(33248, 1, paramInt);
/*     */     } else {
/* 175 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 177 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ChdLockReRight(int paramInt) {
/* 187 */     ApiResult apiResult = ApiResult.FAILED;
/* 188 */     if (LockgCenReq2.isValid(paramInt)) {
/* 189 */       apiResult = this.mMgr.setIntProperty(33249, 1, paramInt);
/*     */     } else {
/* 191 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 193 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ChdLockReLeft_ChdMod(int paramInt) {
/* 203 */     ApiResult apiResult = ApiResult.FAILED;
/* 204 */     if (LockgCenReq2.isValid(paramInt)) {
/* 205 */       apiResult = this.mMgr.setIntProperty(33250, 1, paramInt);
/*     */     } else {
/* 207 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 209 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_ChdLockReRight_ChdMod(int paramInt) {
/* 219 */     ApiResult apiResult = ApiResult.FAILED;
/* 220 */     if (LockgCenReq2.isValid(paramInt)) {
/* 221 */       apiResult = this.mMgr.setIntProperty(33251, 1, paramInt);
/*     */     } else {
/* 223 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 225 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SmallCycle_Reboot(int paramInt) {
/* 235 */     return this.mMgr.setIntProperty(33252, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFS_FaceIdnReq(int paramInt) {
/* 245 */     ApiResult apiResult = ApiResult.FAILED;
/* 246 */     if (OnOff1.isValid(paramInt)) {
/* 247 */       apiResult = this.mMgr.setIntProperty(33253, 1, paramInt);
/*     */     } else {
/* 249 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 251 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_VFS_DPS(int paramInt) {
/* 261 */     ApiResult apiResult = ApiResult.FAILED;
/* 262 */     if (OnOff1.isValid(paramInt)) {
/* 263 */       apiResult = this.mMgr.setIntProperty(33254, 1, paramInt);
/*     */     } else {
/* 265 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 267 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_EgyRgnLvlSet getPA_EgyRgnLvlSet() throws CarNotConnectedException {
/* 278 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33855, 1);
/*     */     
/* 280 */     PATypes.PA_EgyRgnLvlSet pA_EgyRgnLvlSet = null;
/*     */     try {
/* 282 */       PATypes.PA_EgyRgnLvlSet pA_EgyRgnLvlSet1 = new PATypes.PA_EgyRgnLvlSet(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_EgyRgnLvlSet = pA_EgyRgnLvlSet1;
/* 283 */     } catch (Exception exception) {}
/*     */     
/* 285 */     return pA_EgyRgnLvlSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinOpenDrvrReq getPA_WinOpenDrvrReq() throws CarNotConnectedException {
/* 294 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33856, 1);
/*     */     
/* 296 */     PATypes.PA_WinOpenDrvrReq pA_WinOpenDrvrReq = null;
/*     */     try {
/* 298 */       PATypes.PA_WinOpenDrvrReq pA_WinOpenDrvrReq1 = new PATypes.PA_WinOpenDrvrReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinOpenDrvrReq = pA_WinOpenDrvrReq1;
/* 299 */     } catch (Exception exception) {}
/*     */     
/* 301 */     return pA_WinOpenDrvrReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinOpenPassReq getPA_WinOpenPassReq() throws CarNotConnectedException {
/* 310 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33857, 1);
/*     */     
/* 312 */     PATypes.PA_WinOpenPassReq pA_WinOpenPassReq = null;
/*     */     try {
/* 314 */       PATypes.PA_WinOpenPassReq pA_WinOpenPassReq1 = new PATypes.PA_WinOpenPassReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinOpenPassReq = pA_WinOpenPassReq1;
/* 315 */     } catch (Exception exception) {}
/*     */     
/* 317 */     return pA_WinOpenPassReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinOpenReLeReq getPA_WinOpenReLeReq() throws CarNotConnectedException {
/* 326 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33858, 1);
/*     */     
/* 328 */     PATypes.PA_WinOpenReLeReq pA_WinOpenReLeReq = null;
/*     */     try {
/* 330 */       PATypes.PA_WinOpenReLeReq pA_WinOpenReLeReq1 = new PATypes.PA_WinOpenReLeReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinOpenReLeReq = pA_WinOpenReLeReq1;
/* 331 */     } catch (Exception exception) {}
/*     */     
/* 333 */     return pA_WinOpenReLeReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinOpenReRiReq getPA_WinOpenReRiReq() throws CarNotConnectedException {
/* 342 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33859, 1);
/*     */     
/* 344 */     PATypes.PA_WinOpenReRiReq pA_WinOpenReRiReq = null;
/*     */     try {
/* 346 */       PATypes.PA_WinOpenReRiReq pA_WinOpenReRiReq1 = new PATypes.PA_WinOpenReRiReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinOpenReRiReq = pA_WinOpenReRiReq1;
/* 347 */     } catch (Exception exception) {}
/*     */     
/* 349 */     return pA_WinOpenReRiReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinPosnStsAtDrvr getPA_WinPosnStsAtDrvr() throws CarNotConnectedException {
/* 358 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33860, 1);
/*     */     
/* 360 */     PATypes.PA_WinPosnStsAtDrvr pA_WinPosnStsAtDrvr = null;
/*     */     try {
/* 362 */       PATypes.PA_WinPosnStsAtDrvr pA_WinPosnStsAtDrvr1 = new PATypes.PA_WinPosnStsAtDrvr(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinPosnStsAtDrvr = pA_WinPosnStsAtDrvr1;
/* 363 */     } catch (Exception exception) {}
/*     */     
/* 365 */     return pA_WinPosnStsAtDrvr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinPosnStsAtPass getPA_WinPosnStsAtPass() throws CarNotConnectedException {
/* 374 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33861, 1);
/*     */     
/* 376 */     PATypes.PA_WinPosnStsAtPass pA_WinPosnStsAtPass = null;
/*     */     try {
/* 378 */       PATypes.PA_WinPosnStsAtPass pA_WinPosnStsAtPass1 = new PATypes.PA_WinPosnStsAtPass(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinPosnStsAtPass = pA_WinPosnStsAtPass1;
/* 379 */     } catch (Exception exception) {}
/*     */     
/* 381 */     return pA_WinPosnStsAtPass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinPosnStsAtReLe getPA_WinPosnStsAtReLe() throws CarNotConnectedException {
/* 390 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33862, 1);
/*     */     
/* 392 */     PATypes.PA_WinPosnStsAtReLe pA_WinPosnStsAtReLe = null;
/*     */     try {
/* 394 */       PATypes.PA_WinPosnStsAtReLe pA_WinPosnStsAtReLe1 = new PATypes.PA_WinPosnStsAtReLe(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinPosnStsAtReLe = pA_WinPosnStsAtReLe1;
/* 395 */     } catch (Exception exception) {}
/*     */     
/* 397 */     return pA_WinPosnStsAtReLe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WinPosnStsAtReRi getPA_WinPosnStsAtReRi() throws CarNotConnectedException {
/* 406 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33863, 1);
/*     */     
/* 408 */     PATypes.PA_WinPosnStsAtReRi pA_WinPosnStsAtReRi = null;
/*     */     try {
/* 410 */       PATypes.PA_WinPosnStsAtReRi pA_WinPosnStsAtReRi1 = new PATypes.PA_WinPosnStsAtReRi(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WinPosnStsAtReRi = pA_WinPosnStsAtReRi1;
/* 411 */     } catch (Exception exception) {}
/*     */     
/* 413 */     return pA_WinPosnStsAtReRi;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_ChdLockReLeft getPA_ChdLockReLeft() throws CarNotConnectedException {
/* 422 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33864, 1);
/*     */     
/* 424 */     PATypes.PA_ChdLockReLeft pA_ChdLockReLeft = null;
/*     */     try {
/* 426 */       PATypes.PA_ChdLockReLeft pA_ChdLockReLeft1 = new PATypes.PA_ChdLockReLeft(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ChdLockReLeft = pA_ChdLockReLeft1;
/* 427 */     } catch (Exception exception) {}
/*     */     
/* 429 */     return pA_ChdLockReLeft;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_ChdLockReRight getPA_ChdLockReRight() throws CarNotConnectedException {
/* 438 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33865, 1);
/*     */     
/* 440 */     PATypes.PA_ChdLockReRight pA_ChdLockReRight = null;
/*     */     try {
/* 442 */       PATypes.PA_ChdLockReRight pA_ChdLockReRight1 = new PATypes.PA_ChdLockReRight(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ChdLockReRight = pA_ChdLockReRight1;
/* 443 */     } catch (Exception exception) {}
/*     */     
/* 445 */     return pA_ChdLockReRight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_ChdLockReLeft_ChdMod getPA_ChdLockReLeft_ChdMod() throws CarNotConnectedException {
/* 454 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33866, 1);
/*     */     
/* 456 */     PATypes.PA_ChdLockReLeft_ChdMod pA_ChdLockReLeft_ChdMod = null;
/*     */     try {
/* 458 */       PATypes.PA_ChdLockReLeft_ChdMod pA_ChdLockReLeft_ChdMod1 = new PATypes.PA_ChdLockReLeft_ChdMod(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ChdLockReLeft_ChdMod = pA_ChdLockReLeft_ChdMod1;
/* 459 */     } catch (Exception exception) {}
/*     */     
/* 461 */     return pA_ChdLockReLeft_ChdMod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_ChdLockReRight_ChdMod getPA_ChdLockReRight_ChdMod() throws CarNotConnectedException {
/* 470 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33867, 1);
/*     */     
/* 472 */     PATypes.PA_ChdLockReRight_ChdMod pA_ChdLockReRight_ChdMod = null;
/*     */     try {
/* 474 */       PATypes.PA_ChdLockReRight_ChdMod pA_ChdLockReRight_ChdMod1 = new PATypes.PA_ChdLockReRight_ChdMod(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_ChdLockReRight_ChdMod = pA_ChdLockReRight_ChdMod1;
/* 475 */     } catch (Exception exception) {}
/*     */     
/* 477 */     return pA_ChdLockReRight_ChdMod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFS_FaceIdnReq getPA_VFS_FaceIdnReq() throws CarNotConnectedException {
/* 486 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33868, 1);
/*     */     
/* 488 */     PATypes.PA_VFS_FaceIdnReq pA_VFS_FaceIdnReq = null;
/*     */     try {
/* 490 */       PATypes.PA_VFS_FaceIdnReq pA_VFS_FaceIdnReq1 = new PATypes.PA_VFS_FaceIdnReq(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFS_FaceIdnReq = pA_VFS_FaceIdnReq1;
/* 491 */     } catch (Exception exception) {}
/*     */     
/* 493 */     return pA_VFS_FaceIdnReq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_VFS_DPS getPA_VFS_DPS() throws CarNotConnectedException {
/* 502 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33869, 1);
/*     */     
/* 504 */     PATypes.PA_VFS_DPS pA_VFS_DPS = null;
/*     */     try {
/* 506 */       PATypes.PA_VFS_DPS pA_VFS_DPS1 = new PATypes.PA_VFS_DPS(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_VFS_DPS = pA_VFS_DPS1;
/* 507 */     } catch (Exception exception) {}
/*     */     
/* 509 */     return pA_VFS_DPS;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarVfsmallcycleManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */