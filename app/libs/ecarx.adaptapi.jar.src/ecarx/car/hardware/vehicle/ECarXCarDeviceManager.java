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
/*     */ public class ECarXCarDeviceManager
/*     */   extends ECarXCarFuncManagerBase
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int ManagerId_cbdevicereboot = 32924;
/*     */   public static final int ManagerId_padeviceihuid = 33494;
/*     */   public static final int ManagerId_padevicemsgend = 33915;
/*     */   public static final int ManagerId_padeviceprojectcode = 33497;
/*     */   public static final int ManagerId_padevicesn = 33495;
/*     */   public static final int ManagerId_padevicesuppliercode = 33498;
/*     */   public static final int ManagerId_padevicevpversionhd = 33496;
/*     */   private static final String TAG = "ECarXCarDeviceManager";
/*     */   public static final int VehicleArea_Global = 1;
/*     */   public static final int VehicleArea_Zone = 2;
/*     */   
/*     */   public ECarXCarDeviceManager() {}
/*     */   
/*     */   public ECarXCarDeviceManager(ECarXCarPropertyManagerBase paramECarXCarPropertyManagerBase) {
/*  58 */     super(paramECarXCarPropertyManagerBase);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ApiResult CB_Device_Reboot(int paramInt) {
/*  68 */     return this.mMgr.setIntProperty(32924, 1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Device_IHUID getPA_Device_IHUID() throws CarNotConnectedException {
/*  79 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33494, 1);
/*     */     
/*  81 */     PATypes.PA_Device_IHUID pA_Device_IHUID = null;
/*     */     try {
/*  83 */       PATypes.PA_Device_IHUID pA_Device_IHUID1 = new PATypes.PA_Device_IHUID(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Device_IHUID = pA_Device_IHUID1;
/*  84 */     } catch (Exception exception) {}
/*     */     
/*  86 */     return pA_Device_IHUID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Device_SN getPA_Device_SN() throws CarNotConnectedException {
/*  95 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33495, 1);
/*     */     
/*  97 */     PATypes.PA_Device_SN pA_Device_SN = null;
/*     */     try {
/*  99 */       PATypes.PA_Device_SN pA_Device_SN1 = new PATypes.PA_Device_SN(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Device_SN = pA_Device_SN1;
/* 100 */     } catch (Exception exception) {}
/*     */     
/* 102 */     return pA_Device_SN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Device_VPVersion_HD getPA_Device_VPVersion_HD() throws CarNotConnectedException {
/* 111 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33496, 1);
/*     */     
/* 113 */     PATypes.PA_Device_VPVersion_HD pA_Device_VPVersion_HD = null;
/*     */     try {
/* 115 */       PATypes.PA_Device_VPVersion_HD pA_Device_VPVersion_HD1 = new PATypes.PA_Device_VPVersion_HD(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Device_VPVersion_HD = pA_Device_VPVersion_HD1;
/* 116 */     } catch (Exception exception) {}
/*     */     
/* 118 */     return pA_Device_VPVersion_HD;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Device_Project_Code getPA_Device_Project_Code() throws CarNotConnectedException {
/* 127 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33497, 1);
/*     */     
/* 129 */     PATypes.PA_Device_Project_Code pA_Device_Project_Code = null;
/*     */     try {
/* 131 */       PATypes.PA_Device_Project_Code pA_Device_Project_Code1 = new PATypes.PA_Device_Project_Code(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Device_Project_Code = pA_Device_Project_Code1;
/* 132 */     } catch (Exception exception) {}
/*     */     
/* 134 */     return pA_Device_Project_Code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Device_Supplier_Code getPA_Device_Supplier_Code() throws CarNotConnectedException {
/* 143 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33498, 1);
/*     */     
/* 145 */     PATypes.PA_Device_Supplier_Code pA_Device_Supplier_Code = null;
/*     */     try {
/* 147 */       PATypes.PA_Device_Supplier_Code pA_Device_Supplier_Code1 = new PATypes.PA_Device_Supplier_Code(); this(VendorVehicleHalPAProto.PAByteType.parseFrom(arrayOfByte)); pA_Device_Supplier_Code = pA_Device_Supplier_Code1;
/* 148 */     } catch (Exception exception) {}
/*     */     
/* 150 */     return pA_Device_Supplier_Code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PATypes.PA_Device_MsgEnd getPA_Device_MsgEnd() throws CarNotConnectedException {
/* 159 */     byte[] arrayOfByte = this.mMgr.getBytesProperty(33915, 1);
/*     */     
/* 161 */     PATypes.PA_Device_MsgEnd pA_Device_MsgEnd = null;
/*     */     try {
/* 163 */       PATypes.PA_Device_MsgEnd pA_Device_MsgEnd1 = new PATypes.PA_Device_MsgEnd(); this(VendorVehicleHalPAProto.PAIntType.parseFrom(arrayOfByte)); pA_Device_MsgEnd = pA_Device_MsgEnd1;
/* 164 */     } catch (Exception exception) {}
/*     */     
/* 166 */     return pA_Device_MsgEnd;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarDeviceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */