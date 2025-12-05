/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
/*     */ import ecarx.car.hardware.annotation.SteerWhlHeatgOnCmdTyp;
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
/*     */ public class ECarXCarSteerwhlheatgManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbswhautoreq = 32859;
/*     */   public static final int ManagerId_cbswhmanuallvlreq = 32860;
/*     */   public static final int ManagerId_cbswhreboot = 32861;
/*     */   public static final int ManagerId_paswhactvn = 33392;
/*     */   public static final int ManagerId_paswhautoreqsts = 33393;
/*     */   public static final int ManagerId_paswhavlsts = 33395;
/*     */   public static final int ManagerId_paswhmanuallvlsts = 33394;
/*     */   public static final int ManagerId_paswhmsgend = 33909;
/*     */   private static final String TAG = "ECarXCarSteerwhlheatgManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarSteerwhlheatgManager() {}
/*     */   
/*     */   public ECarXCarSteerwhlheatgManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  60 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SWH_AutoReq(int paramInt) {
/*  70 */     ApiResult apiResult = ApiResult.FAILED;
/*  71 */     if (OnOff1.isValid(paramInt)) {
/*  72 */       apiResult = this.mMgr.setIntProperty(32859, 1, paramInt);
/*     */     } else {
/*  74 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  76 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SWH_ManualLvlReq(int paramInt) {
/*  86 */     ApiResult apiResult = ApiResult.FAILED;
/*  87 */     if (SteerWhlHeatgOnCmdTyp.isValid(paramInt)) {
/*  88 */       apiResult = this.mMgr.setIntProperty(32860, 1, paramInt);
/*     */     } else {
/*  90 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  92 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_SWH_Reboot(int paramInt) {
/* 102 */     return this.mMgr.setIntProperty(32861, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SWH_Actvn getPA_SWH_Actvn() throws CarNotConnectedException {
/* 113 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33392, 1);
/*     */     
/* 115 */     PATypes.PA_SWH_Actvn pA_SWH_Actvn = null;
/*     */     try {
/* 117 */       PATypes.PA_SWH_Actvn pA_SWH_Actvn1 = new PATypes.PA_SWH_Actvn(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SWH_Actvn = pA_SWH_Actvn1;
/* 118 */     } catch (Exception exception) {}
/*     */     
/* 120 */     return pA_SWH_Actvn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SWH_AutoReqSts getPA_SWH_AutoReqSts() throws CarNotConnectedException {
/* 129 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33393, 1);
/*     */     
/* 131 */     PATypes.PA_SWH_AutoReqSts pA_SWH_AutoReqSts = null;
/*     */     try {
/* 133 */       PATypes.PA_SWH_AutoReqSts pA_SWH_AutoReqSts1 = new PATypes.PA_SWH_AutoReqSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SWH_AutoReqSts = pA_SWH_AutoReqSts1;
/* 134 */     } catch (Exception exception) {}
/*     */     
/* 136 */     return pA_SWH_AutoReqSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SWH_ManualLvlSts getPA_SWH_ManualLvlSts() throws CarNotConnectedException {
/* 145 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33394, 1);
/*     */     
/* 147 */     PATypes.PA_SWH_ManualLvlSts pA_SWH_ManualLvlSts = null;
/*     */     try {
/* 149 */       PATypes.PA_SWH_ManualLvlSts pA_SWH_ManualLvlSts1 = new PATypes.PA_SWH_ManualLvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SWH_ManualLvlSts = pA_SWH_ManualLvlSts1;
/* 150 */     } catch (Exception exception) {}
/*     */     
/* 152 */     return pA_SWH_ManualLvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SWH_AvlSts getPA_SWH_AvlSts() throws CarNotConnectedException {
/* 161 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33395, 1);
/*     */     
/* 163 */     PATypes.PA_SWH_AvlSts pA_SWH_AvlSts = null;
/*     */     try {
/* 165 */       PATypes.PA_SWH_AvlSts pA_SWH_AvlSts1 = new PATypes.PA_SWH_AvlSts(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SWH_AvlSts = pA_SWH_AvlSts1;
/* 166 */     } catch (Exception exception) {}
/*     */     
/* 168 */     return pA_SWH_AvlSts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_SWH_MsgEnd getPA_SWH_MsgEnd() throws CarNotConnectedException {
/* 177 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33909, 1);
/*     */     
/* 179 */     PATypes.PA_SWH_MsgEnd pA_SWH_MsgEnd = null;
/*     */     try {
/* 181 */       PATypes.PA_SWH_MsgEnd pA_SWH_MsgEnd1 = new PATypes.PA_SWH_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_SWH_MsgEnd = pA_SWH_MsgEnd1;
/* 182 */     } catch (Exception exception) {}
/*     */     
/* 184 */     return pA_SWH_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSteerwhlheatgManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */