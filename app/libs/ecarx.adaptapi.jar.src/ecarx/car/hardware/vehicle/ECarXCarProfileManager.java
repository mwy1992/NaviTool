/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import com.google.protobuf.nano.MessageNano;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.BooleanType;
/*     */ import ecarx.car.hardware.annotation.ButtonLocation;
/*     */ import ecarx.car.hardware.annotation.ProfileId;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ECarXCarProfileManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbprofilereboot = 33262;
/*     */   public static final int ManagerId_cbpsetautlogout = 33263;
/*     */   public static final int ManagerId_cbpsetconnectkey = 33261;
/*     */   public static final int ManagerId_cbpsetconnectlynkid = 33264;
/*     */   public static final int ManagerId_cbpsetconnectnfc = 33265;
/*     */   public static final int ManagerId_cbpsetdeleteprofile = 33257;
/*     */   public static final int ManagerId_cbpsetfactorydefault = 33260;
/*     */   public static final int ManagerId_cbpsetgidbindprofile = 33270;
/*     */   public static final int ManagerId_cbpsetlogout = 33258;
/*     */   public static final int ManagerId_cbpsetname = 33273;
/*     */   public static final int ManagerId_cbpsetnewprofile = 33256;
/*     */   public static final int ManagerId_cbpsetprofileclouddata = 33271;
/*     */   public static final int ManagerId_cbpsetprofilefactorydefault = 33259;
/*     */   public static final int ManagerId_cbpsetrearrangeconford2 = 33267;
/*     */   public static final int ManagerId_cbpsetrequestactiveprofile = 33255;
/*     */   public static final int ManagerId_cbpsetseatbuttononoff = 33268;
/*     */   public static final int ManagerId_cbpsetseatlocationadjust = 33269;
/*     */   public static final int ManagerId_cbpsetsimplunlockp = 33266;
/*     */   public static final int ManagerId_papsetactiveprofile = 33870;
/*     */   public static final int ManagerId_papsetautlogoutcurrent = 33882;
/*     */   public static final int ManagerId_papsetdeleteprofile = 33872;
/*     */   public static final int ManagerId_papsetfactorydefault = 33876;
/*     */   public static final int ManagerId_papsetfactorydefaultresult = 33877;
/*     */   public static final int ManagerId_papsetgidresult = 33896;
/*     */   public static final int ManagerId_papsetkeyid = 33879;
/*     */   public static final int ManagerId_papsetkeyresult = 33878;
/*     */   public static final int ManagerId_papsetlogout = 33873;
/*     */   public static final int ManagerId_papsetlynkid = 33883;
/*     */   public static final int ManagerId_papsetlynkidresult = 33884;
/*     */   public static final int ManagerId_papsetmaxnrprofreached = 33881;
/*     */   public static final int ManagerId_papsetmsgend = 33913;
/*     */   public static final int ManagerId_papsetnamep1 = 33926;
/*     */   public static final int ManagerId_papsetnamep2 = 33927;
/*     */   public static final int ManagerId_papsetnamep3 = 33928;
/*     */   public static final int ManagerId_papsetnamep4 = 33929;
/*     */   public static final int ManagerId_papsetnamep5 = 33930;
/*     */   public static final int ManagerId_papsetnewprofile = 33871;
/*     */   public static final int ManagerId_papsetnfcid = 33885;
/*     */   public static final int ManagerId_papsetnfcresult = 33886;
/*     */   public static final int ManagerId_papsetpchangeallowed = 33880;
/*     */   public static final int ManagerId_papsetprofact = 33897;
/*     */   public static final int ManagerId_papsetprofileclouddata = 33898;
/*     */   public static final int ManagerId_papsetprofiledownloadstatus = 33899;
/*     */   public static final int ManagerId_papsetprofilefactorydefault = 33874;
/*     */   public static final int ManagerId_papsetprofilefactorydefaultresult = 33875;
/*     */   public static final int ManagerId_papsetprofilesinuse = 33900;
/*     */   public static final int ManagerId_papsetseatbuttononoff = 33894;
/*     */   public static final int ManagerId_papsetseatlocationadjust = 33895;
/*     */   public static final int ManagerId_papsetsimplunlockcurrent = 33887;
/*     */   public static final int ManagerId_papsetuser1 = 33888;
/*     */   public static final int ManagerId_papsetuser2 = 33889;
/*     */   public static final int ManagerId_papsetuser3 = 33890;
/*     */   public static final int ManagerId_papsetuser4 = 33891;
/*     */   public static final int ManagerId_papsetuser5 = 33892;
/*     */   public static final int ManagerId_papsetuser6 = 33893;
/*     */   private static final String TAG = "ECarXCarProfileManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarProfileManager() {}
/*     */   
/*     */   public ECarXCarProfileManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/* 113 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_RequestActiveProfile(int paramInt) {
/* 123 */     ApiResult apiResult = ApiResult.FAILED;
/* 124 */     if (ProfileId.isValid(paramInt)) {
/* 125 */       apiResult = this.mMgr.setIntProperty(33255, 1, paramInt);
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
/*     */   public ApiResult CB_PSET_NewProfile(int paramInt) {
/* 139 */     return this.mMgr.setIntProperty(33256, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_DeleteProfile(int paramInt) {
/* 149 */     return this.mMgr.setIntProperty(33257, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_Logout(int paramInt) {
/* 159 */     return this.mMgr.setIntProperty(33258, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_ProfileFactoryDefault(int paramInt) {
/* 169 */     return this.mMgr.setIntProperty(33259, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_FactoryDefault(int paramInt) {
/* 179 */     return this.mMgr.setIntProperty(33260, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_ConnectKey(int paramInt) {
/* 189 */     return this.mMgr.setIntProperty(33261, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Profile_Reboot(int paramInt) {
/* 199 */     return this.mMgr.setIntProperty(33262, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_AutLogOut(int paramInt) {
/* 209 */     return this.mMgr.setIntProperty(33263, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_ConnectLYNKID(int paramInt) {
/* 219 */     return this.mMgr.setIntProperty(33264, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_ConnectNFC(int paramInt) {
/* 229 */     return this.mMgr.setIntProperty(33265, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_SimplUnlockP(int paramInt) {
/* 239 */     return this.mMgr.setIntProperty(33266, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_PSET_RearrangeConfOrd_2(VendorVehicleHalPAProto.Reaconfordtype paramReaconfordtype) {
/* 247 */     this.mMgr.setbytesProperty(33267, 1, VendorVehicleHalPAProto.Reaconfordtype.toByteArray((MessageNano)paramReaconfordtype));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_SeatButtonOnOff(int paramInt) {
/* 257 */     ApiResult apiResult = ApiResult.FAILED;
/* 258 */     if (BooleanType.isValid(paramInt)) {
/* 259 */       apiResult = this.mMgr.setIntProperty(33268, 1, paramInt);
/*     */     } else {
/* 261 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 263 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_PSET_SeatLocationAdjust(int paramInt) {
/* 273 */     ApiResult apiResult = ApiResult.FAILED;
/* 274 */     if (ButtonLocation.isValid(paramInt)) {
/* 275 */       apiResult = this.mMgr.setIntProperty(33269, 1, paramInt);
/*     */     } else {
/* 277 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/* 279 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_PSET_GIDBindProfile(VendorVehicleHalPAProto.CbPsetGidbindprofile paramCbPsetGidbindprofile) {
/* 287 */     this.mMgr.setbytesProperty(33270, 1, VendorVehicleHalPAProto.CbPsetGidbindprofile.toByteArray((MessageNano)paramCbPsetGidbindprofile));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_PSET_ProfileCloudData(VendorVehicleHalPAProto.Profileclouddata paramProfileclouddata) {
/* 295 */     this.mMgr.setbytesProperty(33271, 1, VendorVehicleHalPAProto.Profileclouddata.toByteArray((MessageNano)paramProfileclouddata));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_PSET_Name(String paramString) {
/* 304 */     this.mMgr.setStringProperty(33273, 1, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ActiveProfile getPA_PSET_ActiveProfile() throws CarNotConnectedException {
/* 315 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33870, 1);
/*     */     
/* 317 */     PATypes.PA_PSET_ActiveProfile pA_PSET_ActiveProfile = null;
/*     */     try {
/* 319 */       PATypes.PA_PSET_ActiveProfile pA_PSET_ActiveProfile1 = new PATypes.PA_PSET_ActiveProfile(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_ActiveProfile = pA_PSET_ActiveProfile1;
/* 320 */     } catch (Exception exception) {}
/*     */     
/* 322 */     return pA_PSET_ActiveProfile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NewProfile getPA_PSET_NewProfile() throws CarNotConnectedException {
/* 331 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33871, 1);
/*     */     
/* 333 */     PATypes.PA_PSET_NewProfile pA_PSET_NewProfile = null;
/*     */     try {
/* 335 */       PATypes.PA_PSET_NewProfile pA_PSET_NewProfile1 = new PATypes.PA_PSET_NewProfile(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_NewProfile = pA_PSET_NewProfile1;
/* 336 */     } catch (Exception exception) {}
/*     */     
/* 338 */     return pA_PSET_NewProfile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_DeleteProfile getPA_PSET_DeleteProfile() throws CarNotConnectedException {
/* 347 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33872, 1);
/*     */     
/* 349 */     PATypes.PA_PSET_DeleteProfile pA_PSET_DeleteProfile = null;
/*     */     try {
/* 351 */       PATypes.PA_PSET_DeleteProfile pA_PSET_DeleteProfile1 = new PATypes.PA_PSET_DeleteProfile(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_DeleteProfile = pA_PSET_DeleteProfile1;
/* 352 */     } catch (Exception exception) {}
/*     */     
/* 354 */     return pA_PSET_DeleteProfile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_LogOut getPA_PSET_LogOut() throws CarNotConnectedException {
/* 363 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33873, 1);
/*     */     
/* 365 */     PATypes.PA_PSET_LogOut pA_PSET_LogOut = null;
/*     */     try {
/* 367 */       PATypes.PA_PSET_LogOut pA_PSET_LogOut1 = new PATypes.PA_PSET_LogOut(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_LogOut = pA_PSET_LogOut1;
/* 368 */     } catch (Exception exception) {}
/*     */     
/* 370 */     return pA_PSET_LogOut;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ProfileFactoryDefault getPA_PSET_ProfileFactoryDefault() throws CarNotConnectedException {
/* 379 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33874, 1);
/*     */     
/* 381 */     PATypes.PA_PSET_ProfileFactoryDefault pA_PSET_ProfileFactoryDefault = null;
/*     */     try {
/* 383 */       PATypes.PA_PSET_ProfileFactoryDefault pA_PSET_ProfileFactoryDefault1 = new PATypes.PA_PSET_ProfileFactoryDefault(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_ProfileFactoryDefault = pA_PSET_ProfileFactoryDefault1;
/* 384 */     } catch (Exception exception) {}
/*     */     
/* 386 */     return pA_PSET_ProfileFactoryDefault;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ProfileFactoryDefaultResult getPA_PSET_ProfileFactoryDefaultResult() throws CarNotConnectedException {
/* 395 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33875, 1);
/*     */     
/* 397 */     PATypes.PA_PSET_ProfileFactoryDefaultResult pA_PSET_ProfileFactoryDefaultResult = null;
/*     */     try {
/* 399 */       PATypes.PA_PSET_ProfileFactoryDefaultResult pA_PSET_ProfileFactoryDefaultResult1 = new PATypes.PA_PSET_ProfileFactoryDefaultResult(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_ProfileFactoryDefaultResult = pA_PSET_ProfileFactoryDefaultResult1;
/* 400 */     } catch (Exception exception) {}
/*     */     
/* 402 */     return pA_PSET_ProfileFactoryDefaultResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_FactoryDefault getPA_PSET_FactoryDefault() throws CarNotConnectedException {
/* 411 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33876, 1);
/*     */     
/* 413 */     PATypes.PA_PSET_FactoryDefault pA_PSET_FactoryDefault = null;
/*     */     try {
/* 415 */       PATypes.PA_PSET_FactoryDefault pA_PSET_FactoryDefault1 = new PATypes.PA_PSET_FactoryDefault(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_FactoryDefault = pA_PSET_FactoryDefault1;
/* 416 */     } catch (Exception exception) {}
/*     */     
/* 418 */     return pA_PSET_FactoryDefault;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_FactoryDefaultResult getPA_PSET_FactoryDefaultResult() throws CarNotConnectedException {
/* 427 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33877, 1);
/*     */     
/* 429 */     PATypes.PA_PSET_FactoryDefaultResult pA_PSET_FactoryDefaultResult = null;
/*     */     try {
/* 431 */       PATypes.PA_PSET_FactoryDefaultResult pA_PSET_FactoryDefaultResult1 = new PATypes.PA_PSET_FactoryDefaultResult(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_FactoryDefaultResult = pA_PSET_FactoryDefaultResult1;
/* 432 */     } catch (Exception exception) {}
/*     */     
/* 434 */     return pA_PSET_FactoryDefaultResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_Key_Result getPA_PSET_Key_Result() throws CarNotConnectedException {
/* 443 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33878, 1);
/*     */     
/* 445 */     PATypes.PA_PSET_Key_Result pA_PSET_Key_Result = null;
/*     */     try {
/* 447 */       PATypes.PA_PSET_Key_Result pA_PSET_Key_Result1 = new PATypes.PA_PSET_Key_Result(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_Key_Result = pA_PSET_Key_Result1;
/* 448 */     } catch (Exception exception) {}
/*     */     
/* 450 */     return pA_PSET_Key_Result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_KeyID getPA_PSET_KeyID() throws CarNotConnectedException {
/* 459 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33879, 1);
/*     */     
/* 461 */     PATypes.PA_PSET_KeyID pA_PSET_KeyID = null;
/*     */     try {
/* 463 */       PATypes.PA_PSET_KeyID pA_PSET_KeyID1 = new PATypes.PA_PSET_KeyID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_KeyID = pA_PSET_KeyID1;
/* 464 */     } catch (Exception exception) {}
/*     */     
/* 466 */     return pA_PSET_KeyID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_PChangeAllowed getPA_PSET_PChangeAllowed() throws CarNotConnectedException {
/* 475 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33880, 1);
/*     */     
/* 477 */     PATypes.PA_PSET_PChangeAllowed pA_PSET_PChangeAllowed = null;
/*     */     try {
/* 479 */       PATypes.PA_PSET_PChangeAllowed pA_PSET_PChangeAllowed1 = new PATypes.PA_PSET_PChangeAllowed(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_PChangeAllowed = pA_PSET_PChangeAllowed1;
/* 480 */     } catch (Exception exception) {}
/*     */     
/* 482 */     return pA_PSET_PChangeAllowed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_MaxNrProfReached getPA_PSET_MaxNrProfReached() throws CarNotConnectedException {
/* 491 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33881, 1);
/*     */     
/* 493 */     PATypes.PA_PSET_MaxNrProfReached pA_PSET_MaxNrProfReached = null;
/*     */     try {
/* 495 */       PATypes.PA_PSET_MaxNrProfReached pA_PSET_MaxNrProfReached1 = new PATypes.PA_PSET_MaxNrProfReached(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_MaxNrProfReached = pA_PSET_MaxNrProfReached1;
/* 496 */     } catch (Exception exception) {}
/*     */     
/* 498 */     return pA_PSET_MaxNrProfReached;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_AutLogOutCurrent getPA_PSET_AutLogOutCurrent() throws CarNotConnectedException {
/* 507 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33882, 1);
/*     */     
/* 509 */     PATypes.PA_PSET_AutLogOutCurrent pA_PSET_AutLogOutCurrent = null;
/*     */     try {
/* 511 */       PATypes.PA_PSET_AutLogOutCurrent pA_PSET_AutLogOutCurrent1 = new PATypes.PA_PSET_AutLogOutCurrent(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_AutLogOutCurrent = pA_PSET_AutLogOutCurrent1;
/* 512 */     } catch (Exception exception) {}
/*     */     
/* 514 */     return pA_PSET_AutLogOutCurrent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_LYNKID getPA_PSET_LYNKID() throws CarNotConnectedException {
/* 523 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33883, 1);
/*     */     
/* 525 */     PATypes.PA_PSET_LYNKID pA_PSET_LYNKID = null;
/*     */     try {
/* 527 */       PATypes.PA_PSET_LYNKID pA_PSET_LYNKID1 = new PATypes.PA_PSET_LYNKID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_LYNKID = pA_PSET_LYNKID1;
/* 528 */     } catch (Exception exception) {}
/*     */     
/* 530 */     return pA_PSET_LYNKID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_LYNKID_Result getPA_PSET_LYNKID_Result() throws CarNotConnectedException {
/* 539 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33884, 1);
/*     */     
/* 541 */     PATypes.PA_PSET_LYNKID_Result pA_PSET_LYNKID_Result = null;
/*     */     try {
/* 543 */       PATypes.PA_PSET_LYNKID_Result pA_PSET_LYNKID_Result1 = new PATypes.PA_PSET_LYNKID_Result(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_LYNKID_Result = pA_PSET_LYNKID_Result1;
/* 544 */     } catch (Exception exception) {}
/*     */     
/* 546 */     return pA_PSET_LYNKID_Result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NFCID getPA_PSET_NFCID() throws CarNotConnectedException {
/* 555 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33885, 1);
/*     */     
/* 557 */     PATypes.PA_PSET_NFCID pA_PSET_NFCID = null;
/*     */     try {
/* 559 */       PATypes.PA_PSET_NFCID pA_PSET_NFCID1 = new PATypes.PA_PSET_NFCID(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_NFCID = pA_PSET_NFCID1;
/* 560 */     } catch (Exception exception) {}
/*     */     
/* 562 */     return pA_PSET_NFCID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NFC_Result getPA_PSET_NFC_Result() throws CarNotConnectedException {
/* 571 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33886, 1);
/*     */     
/* 573 */     PATypes.PA_PSET_NFC_Result pA_PSET_NFC_Result = null;
/*     */     try {
/* 575 */       PATypes.PA_PSET_NFC_Result pA_PSET_NFC_Result1 = new PATypes.PA_PSET_NFC_Result(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_NFC_Result = pA_PSET_NFC_Result1;
/* 576 */     } catch (Exception exception) {}
/*     */     
/* 578 */     return pA_PSET_NFC_Result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_SimplUnlockCurrent getPA_PSET_SimplUnlockCurrent() throws CarNotConnectedException {
/* 587 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33887, 1);
/*     */     
/* 589 */     PATypes.PA_PSET_SimplUnlockCurrent pA_PSET_SimplUnlockCurrent = null;
/*     */     try {
/* 591 */       PATypes.PA_PSET_SimplUnlockCurrent pA_PSET_SimplUnlockCurrent1 = new PATypes.PA_PSET_SimplUnlockCurrent(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_SimplUnlockCurrent = pA_PSET_SimplUnlockCurrent1;
/* 592 */     } catch (Exception exception) {}
/*     */     
/* 594 */     return pA_PSET_SimplUnlockCurrent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_User1 getPA_PSET_User1() throws CarNotConnectedException {
/* 603 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33888, 1);
/*     */     
/* 605 */     PATypes.PA_PSET_User1 pA_PSET_User1 = null;
/*     */     try {
/* 607 */       PATypes.PA_PSET_User1 pA_PSET_User11 = new PATypes.PA_PSET_User1(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_User1 = pA_PSET_User11;
/* 608 */     } catch (Exception exception) {}
/*     */     
/* 610 */     return pA_PSET_User1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_User2 getPA_PSET_User2() throws CarNotConnectedException {
/* 619 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33889, 1);
/*     */     
/* 621 */     PATypes.PA_PSET_User2 pA_PSET_User2 = null;
/*     */     try {
/* 623 */       PATypes.PA_PSET_User2 pA_PSET_User21 = new PATypes.PA_PSET_User2(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_User2 = pA_PSET_User21;
/* 624 */     } catch (Exception exception) {}
/*     */     
/* 626 */     return pA_PSET_User2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_User3 getPA_PSET_User3() throws CarNotConnectedException {
/* 635 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33890, 1);
/*     */     
/* 637 */     PATypes.PA_PSET_User3 pA_PSET_User3 = null;
/*     */     try {
/* 639 */       PATypes.PA_PSET_User3 pA_PSET_User31 = new PATypes.PA_PSET_User3(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_User3 = pA_PSET_User31;
/* 640 */     } catch (Exception exception) {}
/*     */     
/* 642 */     return pA_PSET_User3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_User4 getPA_PSET_User4() throws CarNotConnectedException {
/* 651 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33891, 1);
/*     */     
/* 653 */     PATypes.PA_PSET_User4 pA_PSET_User4 = null;
/*     */     try {
/* 655 */       PATypes.PA_PSET_User4 pA_PSET_User41 = new PATypes.PA_PSET_User4(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_User4 = pA_PSET_User41;
/* 656 */     } catch (Exception exception) {}
/*     */     
/* 658 */     return pA_PSET_User4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_User5 getPA_PSET_User5() throws CarNotConnectedException {
/* 667 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33892, 1);
/*     */     
/* 669 */     PATypes.PA_PSET_User5 pA_PSET_User5 = null;
/*     */     try {
/* 671 */       PATypes.PA_PSET_User5 pA_PSET_User51 = new PATypes.PA_PSET_User5(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_User5 = pA_PSET_User51;
/* 672 */     } catch (Exception exception) {}
/*     */     
/* 674 */     return pA_PSET_User5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_User6 getPA_PSET_User6() throws CarNotConnectedException {
/* 683 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33893, 1);
/*     */     
/* 685 */     PATypes.PA_PSET_User6 pA_PSET_User6 = null;
/*     */     try {
/* 687 */       PATypes.PA_PSET_User6 pA_PSET_User61 = new PATypes.PA_PSET_User6(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_User6 = pA_PSET_User61;
/* 688 */     } catch (Exception exception) {}
/*     */     
/* 690 */     return pA_PSET_User6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_SeatButtonOnOff getPA_PSET_SeatButtonOnOff() throws CarNotConnectedException {
/* 699 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33894, 1);
/*     */     
/* 701 */     PATypes.PA_PSET_SeatButtonOnOff pA_PSET_SeatButtonOnOff = null;
/*     */     try {
/* 703 */       PATypes.PA_PSET_SeatButtonOnOff pA_PSET_SeatButtonOnOff1 = new PATypes.PA_PSET_SeatButtonOnOff(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_SeatButtonOnOff = pA_PSET_SeatButtonOnOff1;
/* 704 */     } catch (Exception exception) {}
/*     */     
/* 706 */     return pA_PSET_SeatButtonOnOff;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_SeatLocationAdjust getPA_PSET_SeatLocationAdjust() throws CarNotConnectedException {
/* 715 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33895, 1);
/*     */     
/* 717 */     PATypes.PA_PSET_SeatLocationAdjust pA_PSET_SeatLocationAdjust = null;
/*     */     try {
/* 719 */       PATypes.PA_PSET_SeatLocationAdjust pA_PSET_SeatLocationAdjust1 = new PATypes.PA_PSET_SeatLocationAdjust(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_SeatLocationAdjust = pA_PSET_SeatLocationAdjust1;
/* 720 */     } catch (Exception exception) {}
/*     */     
/* 722 */     return pA_PSET_SeatLocationAdjust;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_GID_Result getPA_PSET_GID_Result() throws CarNotConnectedException {
/* 731 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33896, 1);
/*     */     
/* 733 */     PATypes.PA_PSET_GID_Result pA_PSET_GID_Result = null;
/*     */     try {
/* 735 */       PATypes.PA_PSET_GID_Result pA_PSET_GID_Result1 = new PATypes.PA_PSET_GID_Result(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_GID_Result = pA_PSET_GID_Result1;
/* 736 */     } catch (Exception exception) {}
/*     */     
/* 738 */     return pA_PSET_GID_Result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ProfAct getPA_PSET_ProfAct() throws CarNotConnectedException {
/* 747 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33897, 1);
/*     */     
/* 749 */     PATypes.PA_PSET_ProfAct pA_PSET_ProfAct = null;
/*     */     try {
/* 751 */       PATypes.PA_PSET_ProfAct pA_PSET_ProfAct1 = new PATypes.PA_PSET_ProfAct(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_ProfAct = pA_PSET_ProfAct1;
/* 752 */     } catch (Exception exception) {}
/*     */     
/* 754 */     return pA_PSET_ProfAct;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ProfileCloudData getPA_PSET_ProfileCloudData() throws CarNotConnectedException {
/* 763 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33898, 1);
/*     */     
/* 765 */     PATypes.PA_PSET_ProfileCloudData pA_PSET_ProfileCloudData = null;
/*     */     try {
/* 767 */       PATypes.PA_PSET_ProfileCloudData pA_PSET_ProfileCloudData1 = new PATypes.PA_PSET_ProfileCloudData(); this(VendorVehicleHalPAProto.Profileclouddata.parseFrom(arrayOfByte)); pA_PSET_ProfileCloudData = pA_PSET_ProfileCloudData1;
/* 768 */     } catch (Exception exception) {}
/*     */     
/* 770 */     return pA_PSET_ProfileCloudData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ProfileDownloadStatus getPA_PSET_ProfileDownloadStatus() throws CarNotConnectedException {
/* 779 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33899, 1);
/*     */     
/* 781 */     PATypes.PA_PSET_ProfileDownloadStatus pA_PSET_ProfileDownloadStatus = null;
/*     */     try {
/* 783 */       PATypes.PA_PSET_ProfileDownloadStatus pA_PSET_ProfileDownloadStatus1 = new PATypes.PA_PSET_ProfileDownloadStatus(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_ProfileDownloadStatus = pA_PSET_ProfileDownloadStatus1;
/* 784 */     } catch (Exception exception) {}
/*     */     
/* 786 */     return pA_PSET_ProfileDownloadStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_ProfilesInuse getPA_PSET_ProfilesInuse() throws CarNotConnectedException {
/* 795 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33900, 1);
/*     */     
/* 797 */     PATypes.PA_PSET_ProfilesInuse pA_PSET_ProfilesInuse = null;
/*     */     try {
/* 799 */       PATypes.PA_PSET_ProfilesInuse pA_PSET_ProfilesInuse1 = new PATypes.PA_PSET_ProfilesInuse(); this(VendorVehicleHalPAProto.PAIntArrayType.parseFrom(arrayOfByte)); pA_PSET_ProfilesInuse = pA_PSET_ProfilesInuse1;
/* 800 */     } catch (Exception exception) {}
/*     */     
/* 802 */     return pA_PSET_ProfilesInuse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_MsgEnd getPA_PSET_MsgEnd() throws CarNotConnectedException {
/* 811 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33913, 1);
/*     */     
/* 813 */     PATypes.PA_PSET_MsgEnd pA_PSET_MsgEnd = null;
/*     */     try {
/* 815 */       PATypes.PA_PSET_MsgEnd pA_PSET_MsgEnd1 = new PATypes.PA_PSET_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_PSET_MsgEnd = pA_PSET_MsgEnd1;
/* 816 */     } catch (Exception exception) {}
/*     */     
/* 818 */     return pA_PSET_MsgEnd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NameP1 getPA_PSET_NameP1() throws CarNotConnectedException {
/* 827 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33926, 1);
/*     */     
/* 829 */     PATypes.PA_PSET_NameP1 pA_PSET_NameP1 = null;
/*     */     try {
/* 831 */       PATypes.PA_PSET_NameP1 pA_PSET_NameP11 = new PATypes.PA_PSET_NameP1(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_PSET_NameP1 = pA_PSET_NameP11;
/* 832 */     } catch (Exception exception) {}
/*     */     
/* 834 */     return pA_PSET_NameP1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NameP2 getPA_PSET_NameP2() throws CarNotConnectedException {
/* 843 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33927, 1);
/*     */     
/* 845 */     PATypes.PA_PSET_NameP2 pA_PSET_NameP2 = null;
/*     */     try {
/* 847 */       PATypes.PA_PSET_NameP2 pA_PSET_NameP21 = new PATypes.PA_PSET_NameP2(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_PSET_NameP2 = pA_PSET_NameP21;
/* 848 */     } catch (Exception exception) {}
/*     */     
/* 850 */     return pA_PSET_NameP2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NameP3 getPA_PSET_NameP3() throws CarNotConnectedException {
/* 859 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33928, 1);
/*     */     
/* 861 */     PATypes.PA_PSET_NameP3 pA_PSET_NameP3 = null;
/*     */     try {
/* 863 */       PATypes.PA_PSET_NameP3 pA_PSET_NameP31 = new PATypes.PA_PSET_NameP3(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_PSET_NameP3 = pA_PSET_NameP31;
/* 864 */     } catch (Exception exception) {}
/*     */     
/* 866 */     return pA_PSET_NameP3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NameP4 getPA_PSET_NameP4() throws CarNotConnectedException {
/* 875 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33929, 1);
/*     */     
/* 877 */     PATypes.PA_PSET_NameP4 pA_PSET_NameP4 = null;
/*     */     try {
/* 879 */       PATypes.PA_PSET_NameP4 pA_PSET_NameP41 = new PATypes.PA_PSET_NameP4(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_PSET_NameP4 = pA_PSET_NameP41;
/* 880 */     } catch (Exception exception) {}
/*     */     
/* 882 */     return pA_PSET_NameP4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_PSET_NameP5 getPA_PSET_NameP5() throws CarNotConnectedException {
/* 891 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33930, 1);
/*     */     
/* 893 */     PATypes.PA_PSET_NameP5 pA_PSET_NameP5 = null;
/*     */     try {
/* 895 */       PATypes.PA_PSET_NameP5 pA_PSET_NameP51 = new PATypes.PA_PSET_NameP5(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_PSET_NameP5 = pA_PSET_NameP51;
/* 896 */     } catch (Exception exception) {}
/*     */     
/* 898 */     return pA_PSET_NameP5;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarProfileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */