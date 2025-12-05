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
/*     */ public class ECarXCarDiagmanufacturing1Manager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbdiagmanufacturing1reboot = 33171;
/*     */   public static final int ManagerId_cbfd26 = 33167;
/*     */   public static final int ManagerId_cbfd27 = 33168;
/*     */   public static final int ManagerId_cbfd28 = 33169;
/*     */   public static final int ManagerId_cbfd2a = 33166;
/*     */   public static final int ManagerId_cbfd39 = 33170;
/*     */   public static final int ManagerId_pafd12 = 33746;
/*     */   public static final int ManagerId_pafd17 = 33747;
/*     */   public static final int ManagerId_pafd26 = 33741;
/*     */   public static final int ManagerId_pafd27 = 33742;
/*     */   public static final int ManagerId_pafd28 = 33743;
/*     */   public static final int ManagerId_pafd29 = 33745;
/*     */   public static final int ManagerId_pafd39 = 33744;
/*     */   public static final int ManagerId_pafd5a = 33748;
/*     */   private static final String TAG = "ECarXCarDiagmanufacturing1Manager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDiagmanufacturing1Manager() {}
/*     */   
/*     */   public ECarXCarDiagmanufacturing1Manager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  65 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void CB_FD2A(byte[] paramArrayOfbyte) {
/*  74 */     this.mMgr.setbytesProperty(33166, 1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FD26(int paramInt) {
/*  84 */     return this.mMgr.setIntProperty(33167, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FD27(int paramInt) {
/*  94 */     return this.mMgr.setIntProperty(33168, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FD28(int paramInt) {
/* 104 */     return this.mMgr.setIntProperty(33169, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_FD39(int paramInt) {
/* 114 */     return this.mMgr.setIntProperty(33170, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_DiagManufacturing1_Reboot(int paramInt) {
/* 124 */     return this.mMgr.setIntProperty(33171, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD26 getPA_FD26() throws CarNotConnectedException {
/* 135 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33741, 1);
/*     */     
/* 137 */     PATypes.PA_FD26 pA_FD26 = null;
/*     */     try {
/* 139 */       PATypes.PA_FD26 pA_FD261 = new PATypes.PA_FD26(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD26 = pA_FD261;
/* 140 */     } catch (Exception exception) {}
/*     */     
/* 142 */     return pA_FD26;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD27 getPA_FD27() throws CarNotConnectedException {
/* 151 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33742, 1);
/*     */     
/* 153 */     PATypes.PA_FD27 pA_FD27 = null;
/*     */     try {
/* 155 */       PATypes.PA_FD27 pA_FD271 = new PATypes.PA_FD27(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD27 = pA_FD271;
/* 156 */     } catch (Exception exception) {}
/*     */     
/* 158 */     return pA_FD27;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD28 getPA_FD28() throws CarNotConnectedException {
/* 167 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33743, 1);
/*     */     
/* 169 */     PATypes.PA_FD28 pA_FD28 = null;
/*     */     try {
/* 171 */       PATypes.PA_FD28 pA_FD281 = new PATypes.PA_FD28(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD28 = pA_FD281;
/* 172 */     } catch (Exception exception) {}
/*     */     
/* 174 */     return pA_FD28;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD39 getPA_FD39() throws CarNotConnectedException {
/* 183 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33744, 1);
/*     */     
/* 185 */     PATypes.PA_FD39 pA_FD39 = null;
/*     */     try {
/* 187 */       PATypes.PA_FD39 pA_FD391 = new PATypes.PA_FD39(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_FD39 = pA_FD391;
/* 188 */     } catch (Exception exception) {}
/*     */     
/* 190 */     return pA_FD39;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD29 getPA_FD29() throws CarNotConnectedException {
/* 199 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33745, 1);
/*     */     
/* 201 */     PATypes.PA_FD29 pA_FD29 = null;
/*     */     try {
/* 203 */       PATypes.PA_FD29 pA_FD291 = new PATypes.PA_FD29(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD29 = pA_FD291;
/* 204 */     } catch (Exception exception) {}
/*     */     
/* 206 */     return pA_FD29;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD12 getPA_FD12() throws CarNotConnectedException {
/* 215 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33746, 1);
/*     */     
/* 217 */     PATypes.PA_FD12 pA_FD12 = null;
/*     */     try {
/* 219 */       PATypes.PA_FD12 pA_FD121 = new PATypes.PA_FD12(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD12 = pA_FD121;
/* 220 */     } catch (Exception exception) {}
/*     */     
/* 222 */     return pA_FD12;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD17 getPA_FD17() throws CarNotConnectedException {
/* 231 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33747, 1);
/*     */     
/* 233 */     PATypes.PA_FD17 pA_FD17 = null;
/*     */     try {
/* 235 */       PATypes.PA_FD17 pA_FD171 = new PATypes.PA_FD17(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD17 = pA_FD171;
/* 236 */     } catch (Exception exception) {}
/*     */     
/* 238 */     return pA_FD17;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_FD5A getPA_FD5A() throws CarNotConnectedException {
/* 247 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33748, 1);
/*     */     
/* 249 */     PATypes.PA_FD5A pA_FD5A = null;
/*     */     try {
/* 251 */       PATypes.PA_FD5A pA_FD5A1 = new PATypes.PA_FD5A(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_FD5A = pA_FD5A1;
/* 252 */     } catch (Exception exception) {}
/*     */     
/* 254 */     return pA_FD5A;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDiagmanufacturing1Manager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */