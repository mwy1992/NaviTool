/*     */ package ecarx.car.hardware.vehicle;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.annotation.OnOff1;
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
/*     */ public class ECarXCarWpcmodelManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbwpcreboot = 33021;
/*     */   public static final int ManagerId_cbwpcsetting = 33020;
/*     */   public static final int ManagerId_pawpcinchargestatus = 33635;
/*     */   public static final int ManagerId_pawpcmsgend = 33922;
/*     */   public static final int ManagerId_pawpcphoneforget = 33636;
/*     */   public static final int ManagerId_pawpcsetting = 33634;
/*     */   private static final String TAG = "ECarXCarWpcmodelManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarWpcmodelManager() {}
/*     */   
/*     */   public ECarXCarWpcmodelManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  57 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_WPC_Setting(int paramInt) {
/*  67 */     ApiResult apiResult = ApiResult.FAILED;
/*  68 */     if (OnOff1.isValid(paramInt)) {
/*  69 */       apiResult = this.mMgr.setIntProperty(33020, 1, paramInt);
/*     */     } else {
/*  71 */       apiResult = ApiResult.PARAM_ERROR;
/*     */     } 
/*  73 */     return apiResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_WPC_Reboot(int paramInt) {
/*  83 */     return this.mMgr.setIntProperty(33021, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WPC_Setting getPA_WPC_Setting() throws CarNotConnectedException {
/*  94 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33634, 1);
/*     */     
/*  96 */     PATypes.PA_WPC_Setting pA_WPC_Setting = null;
/*     */     try {
/*  98 */       PATypes.PA_WPC_Setting pA_WPC_Setting1 = new PATypes.PA_WPC_Setting(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WPC_Setting = pA_WPC_Setting1;
/*  99 */     } catch (Exception exception) {}
/*     */     
/* 101 */     return pA_WPC_Setting;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WPC_InchargeStatus getPA_WPC_InchargeStatus() throws CarNotConnectedException {
/* 110 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33635, 1);
/*     */     
/* 112 */     PATypes.PA_WPC_InchargeStatus pA_WPC_InchargeStatus = null;
/*     */     try {
/* 114 */       PATypes.PA_WPC_InchargeStatus pA_WPC_InchargeStatus1 = new PATypes.PA_WPC_InchargeStatus(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WPC_InchargeStatus = pA_WPC_InchargeStatus1;
/* 115 */     } catch (Exception exception) {}
/*     */     
/* 117 */     return pA_WPC_InchargeStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WPC_PhoneForget getPA_WPC_PhoneForget() throws CarNotConnectedException {
/* 126 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33636, 1);
/*     */     
/* 128 */     PATypes.PA_WPC_PhoneForget pA_WPC_PhoneForget = null;
/*     */     try {
/* 130 */       PATypes.PA_WPC_PhoneForget pA_WPC_PhoneForget1 = new PATypes.PA_WPC_PhoneForget(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WPC_PhoneForget = pA_WPC_PhoneForget1;
/* 131 */     } catch (Exception exception) {}
/*     */     
/* 133 */     return pA_WPC_PhoneForget;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_WPC_MsgEnd getPA_WPC_MsgEnd() throws CarNotConnectedException {
/* 142 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33922, 1);
/*     */     
/* 144 */     PATypes.PA_WPC_MsgEnd pA_WPC_MsgEnd = null;
/*     */     try {
/* 146 */       PATypes.PA_WPC_MsgEnd pA_WPC_MsgEnd1 = new PATypes.PA_WPC_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_WPC_MsgEnd = pA_WPC_MsgEnd1;
/* 147 */     } catch (Exception exception) {}
/*     */     
/* 149 */     return pA_WPC_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarWpcmodelManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */