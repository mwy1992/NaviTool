/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.HmiCupHldrClimaReq;
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
/*     */ public class ECarXCarTchmodelManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbtchcupholdractn = 32875;
/*     */   public static final int ManagerId_cbtchreboot = 32876;
/*     */   public static final int ManagerId_patchcupholdractvallwd = 33435;
/*     */   public static final int ManagerId_patchcupholdravlsts = 33437;
/*     */   public static final int ManagerId_patchcupholdrocpyfbsts = 33438;
/*     */   public static final int ManagerId_patchcupholdrstsfd = 33434;
/*     */   public static final int ManagerId_patchcupholdrvoltgerr = 33436;
/*     */   public static final int ManagerId_patchmsgend = 33911;
/*     */   private static final String TAG = "ECarXCarTchmodelManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarTchmodelManager() {}
/*     */   
/*     */   public ECarXCarTchmodelManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  59 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_TCH_CupHoldrActn(int paramInt) {
/*  69 */     ApiResult apiResult = ApiResult.FAILED;
/*  70 */     if (HmiCupHldrClimaReq.isValid(paramInt)) {
/*  71 */       apiResult = this.mMgr.setIntProperty(32875, 1, paramInt);
/*     */     } else {
/*  73 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  75 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_TCH_Reboot(int paramInt) {
/*  85 */     return this.mMgr.setIntProperty(32876, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TCH_CupHoldrStsFd getPA_TCH_CupHoldrStsFd() throws CarNotConnectedException {
/*  96 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33434, 1);
/*     */     
/*  98 */     PATypes.PA_TCH_CupHoldrStsFd pA_TCH_CupHoldrStsFd = null;
/*     */     try {
/* 100 */       PATypes.PA_TCH_CupHoldrStsFd pA_TCH_CupHoldrStsFd1 = new PATypes.PA_TCH_CupHoldrStsFd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TCH_CupHoldrStsFd = pA_TCH_CupHoldrStsFd1;
/* 101 */     } catch (Exception exception) {}
/*     */     
/* 103 */     return pA_TCH_CupHoldrStsFd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TCH_CupHoldrActvAllwd getPA_TCH_CupHoldrActvAllwd() throws CarNotConnectedException {
/* 112 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33435, 1);
/*     */     
/* 114 */     PATypes.PA_TCH_CupHoldrActvAllwd pA_TCH_CupHoldrActvAllwd = null;
/*     */     try {
/* 116 */       PATypes.PA_TCH_CupHoldrActvAllwd pA_TCH_CupHoldrActvAllwd1 = new PATypes.PA_TCH_CupHoldrActvAllwd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TCH_CupHoldrActvAllwd = pA_TCH_CupHoldrActvAllwd1;
/* 117 */     } catch (Exception exception) {}
/*     */     
/* 119 */     return pA_TCH_CupHoldrActvAllwd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TCH_CupHoldrVoltgErr getPA_TCH_CupHoldrVoltgErr() throws CarNotConnectedException {
/* 128 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33436, 1);
/*     */     
/* 130 */     PATypes.PA_TCH_CupHoldrVoltgErr pA_TCH_CupHoldrVoltgErr = null;
/*     */     try {
/* 132 */       PATypes.PA_TCH_CupHoldrVoltgErr pA_TCH_CupHoldrVoltgErr1 = new PATypes.PA_TCH_CupHoldrVoltgErr(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TCH_CupHoldrVoltgErr = pA_TCH_CupHoldrVoltgErr1;
/* 133 */     } catch (Exception exception) {}
/*     */     
/* 135 */     return pA_TCH_CupHoldrVoltgErr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TCH_CupHoldrAvlSts getPA_TCH_CupHoldrAvlSts() throws CarNotConnectedException {
/* 144 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33437, 1);
/*     */     
/* 146 */     PATypes.PA_TCH_CupHoldrAvlSts pA_TCH_CupHoldrAvlSts = null;
/*     */     try {
/* 148 */       PATypes.PA_TCH_CupHoldrAvlSts pA_TCH_CupHoldrAvlSts1 = new PATypes.PA_TCH_CupHoldrAvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TCH_CupHoldrAvlSts = pA_TCH_CupHoldrAvlSts1;
/* 149 */     } catch (Exception exception) {}
/*     */     
/* 151 */     return pA_TCH_CupHoldrAvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TCH_CupHoldrOcpyFbSts getPA_TCH_CupHoldrOcpyFbSts() throws CarNotConnectedException {
/* 160 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33438, 1);
/*     */     
/* 162 */     PATypes.PA_TCH_CupHoldrOcpyFbSts pA_TCH_CupHoldrOcpyFbSts = null;
/*     */     try {
/* 164 */       PATypes.PA_TCH_CupHoldrOcpyFbSts pA_TCH_CupHoldrOcpyFbSts1 = new PATypes.PA_TCH_CupHoldrOcpyFbSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TCH_CupHoldrOcpyFbSts = pA_TCH_CupHoldrOcpyFbSts1;
/* 165 */     } catch (Exception exception) {}
/*     */     
/* 167 */     return pA_TCH_CupHoldrOcpyFbSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_TCH_MsgEnd getPA_TCH_MsgEnd() throws CarNotConnectedException {
/* 176 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33911, 1);
/*     */     
/* 178 */     PATypes.PA_TCH_MsgEnd pA_TCH_MsgEnd = null;
/*     */     try {
/* 180 */       PATypes.PA_TCH_MsgEnd pA_TCH_MsgEnd1 = new PATypes.PA_TCH_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_TCH_MsgEnd = pA_TCH_MsgEnd1;
/* 181 */     } catch (Exception exception) {}
/*     */     
/* 183 */     return pA_TCH_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarTchmodelManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */