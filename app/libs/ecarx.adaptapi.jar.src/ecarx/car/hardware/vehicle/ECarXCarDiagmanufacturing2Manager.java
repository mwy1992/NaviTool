/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
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
/*     */ public class ECarXCarDiagmanufacturing2Manager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbauthoritycameraswitch = 33181;
/*     */   public static final int ManagerId_cbauthoritylocationswitch = 33180;
/*     */   public static final int ManagerId_cbauthoritymicrophoneswitch = 33182;
/*     */   public static final int ManagerId_cbdiagmanufacturing2reboot = 33183;
/*     */   public static final int ManagerId_cbfd23 = 33172;
/*     */   public static final int ManagerId_cbfd43 = 33173;
/*     */   public static final int ManagerId_cbfd62 = 33174;
/*     */   public static final int ManagerId_cbfd84 = 33175;
/*     */   public static final int ManagerId_cbfd85 = 33176;
/*     */   public static final int ManagerId_cbfd88 = 33177;
/*     */   public static final int ManagerId_cbfd93 = 33178;
/*     */   public static final int ManagerId_cbfd94 = 33179;
/*     */   public static final int ManagerId_paauthoritycameraswitch = 33762;
/*     */   public static final int ManagerId_paauthoritylocationswitch = 33761;
/*     */   public static final int ManagerId_paauthoritymicrophoneswitch = 33763;
/*     */   public static final int ManagerId_pafd23 = 33750;
/*     */   public static final int ManagerId_pafd30 = 33749;
/*     */   public static final int ManagerId_pafd41 = 33753;
/*     */   public static final int ManagerId_pafd42 = 33751;
/*     */   public static final int ManagerId_pafd43 = 33754;
/*     */   public static final int ManagerId_pafd44 = 33752;
/*     */   public static final int ManagerId_pafd62 = 33755;
/*     */   public static final int ManagerId_pafd85 = 33756;
/*     */   public static final int ManagerId_pafd86 = 33758;
/*     */   public static final int ManagerId_pafd88 = 33757;
/*     */   public static final int ManagerId_pafd91 = 33759;
/*     */   public static final int ManagerId_pafd92 = 33760;
/*     */   public static final int ManagerId_paprivacycompliancereset = 33764;
/*     */   private static final String TAG = "ECarXCarDiagmanufacturing2Manager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDiagmanufacturing2Manager() {}
/*     */   
/*     */   public ECarXCarDiagmanufacturing2Manager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  79 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD23(byte[] paramArrayOfbyte) {
/*  88 */     this.mMgr.setbytesProperty(33172, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD43(byte[] paramArrayOfbyte) {
/*  97 */     this.mMgr.setbytesProperty(33173, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD62(byte[] paramArrayOfbyte) {
/* 106 */     this.mMgr.setbytesProperty(33174, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD84(byte[] paramArrayOfbyte) {
/* 115 */     this.mMgr.setbytesProperty(33175, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FD85(int paramInt) {
/* 125 */     return this.mMgr.setIntProperty(33176, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FD88(int paramInt) {
/* 135 */     return this.mMgr.setIntProperty(33177, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD93(byte[] paramArrayOfbyte) {
/* 144 */     this.mMgr.setbytesProperty(33178, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD94(byte[] paramArrayOfbyte) {
/* 153 */     this.mMgr.setbytesProperty(33179, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AuthorityLocationSwitch(int paramInt) {
/* 163 */     return this.mMgr.setIntProperty(33180, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AuthorityCameraSwitch(int paramInt) {
/* 173 */     return this.mMgr.setIntProperty(33181, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_AuthorityMicrophoneSwitch(int paramInt) {
/* 183 */     return this.mMgr.setIntProperty(33182, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DiagManufacturing2_Reboot(int paramInt) {
/* 193 */     return this.mMgr.setIntProperty(33183, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD30 getPA_FD30() throws CarNotConnectedException {
/* 204 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33749, 1);
/*     */     
/* 206 */     PATypes.PA_FD30 pA_FD30 = null;
/*     */     try {
/* 208 */       PATypes.PA_FD30 pA_FD301 = new PATypes.PA_FD30(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD30 = pA_FD301;
/* 209 */     } catch (Exception exception) {}
/*     */     
/* 211 */     return pA_FD30;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD23 getPA_FD23() throws CarNotConnectedException {
/* 220 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33750, 1);
/*     */     
/* 222 */     PATypes.PA_FD23 pA_FD23 = null;
/*     */     try {
/* 224 */       PATypes.PA_FD23 pA_FD231 = new PATypes.PA_FD23(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD23 = pA_FD231;
/* 225 */     } catch (Exception exception) {}
/*     */     
/* 227 */     return pA_FD23;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD42 getPA_FD42() throws CarNotConnectedException {
/* 236 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33751, 1);
/*     */     
/* 238 */     PATypes.PA_FD42 pA_FD42 = null;
/*     */     try {
/* 240 */       PATypes.PA_FD42 pA_FD421 = new PATypes.PA_FD42(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD42 = pA_FD421;
/* 241 */     } catch (Exception exception) {}
/*     */     
/* 243 */     return pA_FD42;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD44 getPA_FD44() throws CarNotConnectedException {
/* 252 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33752, 1);
/*     */     
/* 254 */     PATypes.PA_FD44 pA_FD44 = null;
/*     */     try {
/* 256 */       PATypes.PA_FD44 pA_FD441 = new PATypes.PA_FD44(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD44 = pA_FD441;
/* 257 */     } catch (Exception exception) {}
/*     */     
/* 259 */     return pA_FD44;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD41 getPA_FD41() throws CarNotConnectedException {
/* 268 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33753, 1);
/*     */     
/* 270 */     PATypes.PA_FD41 pA_FD41 = null;
/*     */     try {
/* 272 */       PATypes.PA_FD41 pA_FD411 = new PATypes.PA_FD41(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD41 = pA_FD411;
/* 273 */     } catch (Exception exception) {}
/*     */     
/* 275 */     return pA_FD41;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD43 getPA_FD43() throws CarNotConnectedException {
/* 284 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33754, 1);
/*     */     
/* 286 */     PATypes.PA_FD43 pA_FD43 = null;
/*     */     try {
/* 288 */       PATypes.PA_FD43 pA_FD431 = new PATypes.PA_FD43(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD43 = pA_FD431;
/* 289 */     } catch (Exception exception) {}
/*     */     
/* 291 */     return pA_FD43;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD62 getPA_FD62() throws CarNotConnectedException {
/* 300 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33755, 1);
/*     */     
/* 302 */     PATypes.PA_FD62 pA_FD62 = null;
/*     */     try {
/* 304 */       PATypes.PA_FD62 pA_FD621 = new PATypes.PA_FD62(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD62 = pA_FD621;
/* 305 */     } catch (Exception exception) {}
/*     */     
/* 307 */     return pA_FD62;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD85 getPA_FD85() throws CarNotConnectedException {
/* 316 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33756, 1);
/*     */     
/* 318 */     PATypes.PA_FD85 pA_FD85 = null;
/*     */     try {
/* 320 */       PATypes.PA_FD85 pA_FD851 = new PATypes.PA_FD85(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD85 = pA_FD851;
/* 321 */     } catch (Exception exception) {}
/*     */     
/* 323 */     return pA_FD85;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD88 getPA_FD88() throws CarNotConnectedException {
/* 332 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33757, 1);
/*     */     
/* 334 */     PATypes.PA_FD88 pA_FD88 = null;
/*     */     try {
/* 336 */       PATypes.PA_FD88 pA_FD881 = new PATypes.PA_FD88(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD88 = pA_FD881;
/* 337 */     } catch (Exception exception) {}
/*     */     
/* 339 */     return pA_FD88;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD86 getPA_FD86() throws CarNotConnectedException {
/* 348 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33758, 1);
/*     */     
/* 350 */     PATypes.PA_FD86 pA_FD86 = null;
/*     */     try {
/* 352 */       PATypes.PA_FD86 pA_FD861 = new PATypes.PA_FD86(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD86 = pA_FD861;
/* 353 */     } catch (Exception exception) {}
/*     */     
/* 355 */     return pA_FD86;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD91 getPA_FD91() throws CarNotConnectedException {
/* 364 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33759, 1);
/*     */     
/* 366 */     PATypes.PA_FD91 pA_FD91 = null;
/*     */     try {
/* 368 */       PATypes.PA_FD91 pA_FD911 = new PATypes.PA_FD91(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD91 = pA_FD911;
/* 369 */     } catch (Exception exception) {}
/*     */     
/* 371 */     return pA_FD91;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD92 getPA_FD92() throws CarNotConnectedException {
/* 380 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33760, 1);
/*     */     
/* 382 */     PATypes.PA_FD92 pA_FD92 = null;
/*     */     try {
/* 384 */       PATypes.PA_FD92 pA_FD921 = new PATypes.PA_FD92(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD92 = pA_FD921;
/* 385 */     } catch (Exception exception) {}
/*     */     
/* 387 */     return pA_FD92;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_AuthorityLocationSwitch getPA_AuthorityLocationSwitch() throws CarNotConnectedException {
/* 396 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33761, 1);
/*     */     
/* 398 */     PATypes.PA_AuthorityLocationSwitch pA_AuthorityLocationSwitch = null;
/*     */     try {
/* 400 */       PATypes.PA_AuthorityLocationSwitch pA_AuthorityLocationSwitch1 = new PATypes.PA_AuthorityLocationSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AuthorityLocationSwitch = pA_AuthorityLocationSwitch1;
/* 401 */     } catch (Exception exception) {}
/*     */     
/* 403 */     return pA_AuthorityLocationSwitch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_AuthorityCameraSwitch getPA_AuthorityCameraSwitch() throws CarNotConnectedException {
/* 412 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33762, 1);
/*     */     
/* 414 */     PATypes.PA_AuthorityCameraSwitch pA_AuthorityCameraSwitch = null;
/*     */     try {
/* 416 */       PATypes.PA_AuthorityCameraSwitch pA_AuthorityCameraSwitch1 = new PATypes.PA_AuthorityCameraSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AuthorityCameraSwitch = pA_AuthorityCameraSwitch1;
/* 417 */     } catch (Exception exception) {}
/*     */     
/* 419 */     return pA_AuthorityCameraSwitch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_AuthorityMicrophoneSwitch getPA_AuthorityMicrophoneSwitch() throws CarNotConnectedException {
/* 428 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33763, 1);
/*     */     
/* 430 */     PATypes.PA_AuthorityMicrophoneSwitch pA_AuthorityMicrophoneSwitch = null;
/*     */     try {
/* 432 */       PATypes.PA_AuthorityMicrophoneSwitch pA_AuthorityMicrophoneSwitch1 = new PATypes.PA_AuthorityMicrophoneSwitch(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_AuthorityMicrophoneSwitch = pA_AuthorityMicrophoneSwitch1;
/* 433 */     } catch (Exception exception) {}
/*     */     
/* 435 */     return pA_AuthorityMicrophoneSwitch;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Privacy_Compliance_Reset getPA_Privacy_Compliance_Reset() throws CarNotConnectedException {
/* 444 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33764, 1);
/*     */     
/* 446 */     PATypes.PA_Privacy_Compliance_Reset pA_Privacy_Compliance_Reset = null;
/*     */     try {
/* 448 */       PATypes.PA_Privacy_Compliance_Reset pA_Privacy_Compliance_Reset1 = new PATypes.PA_Privacy_Compliance_Reset(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Privacy_Compliance_Reset = pA_Privacy_Compliance_Reset1;
/* 449 */     } catch (Exception exception) {}
/*     */     
/* 451 */     return pA_Privacy_Compliance_Reset;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDiagmanufacturing2Manager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */