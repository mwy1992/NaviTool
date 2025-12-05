/*    */ package ecarx.car.hardware.vehicle;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Handler;
/*    */ import android.os.IBinder;
/*    */ import ecarx.car.ECarXCarManagerBase;
/*    */ import ecarx.car.hardware.property.ECarXCarPropertyManagerBase;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ECarXCarSetManager
/*    */   implements ECarXCarManagerBase
/*    */ {
/*    */   private static final boolean DBG = false;
/*    */   public static final int SetArea_Global = 1;
/*    */   public static final int SetArea_Zone = 2;
/*    */   private static final String TAG = "ECarXCarSetManager";
/*    */   private ECarXCarFuncManagerBase mBaseManager;
/*    */   private ECarXCarActivesafetyManager mECarXCarActivesafetyManager;
/*    */   private ECarXCarAirqlyandfragraManager mECarXCarAirqlyandfragraManager;
/*    */   private ECarXCarAmbliManager mECarXCarAmbliManager;
/*    */   private ECarXCarApplogManager mECarXCarApplogManager;
/*    */   private ECarXCarApversionManager mECarXCarApversionManager;
/*    */   private ECarXCarApvppulseManager mECarXCarApvppulseManager;
/*    */   private ECarXCarAudioradioManager mECarXCarAudioradioManager;
/*    */   private ECarXCarClimateManager mECarXCarClimateManager;
/*    */   private ECarXCarDeviceManager mECarXCarDeviceManager;
/*    */   private ECarXCarDiagdidManager mECarXCarDiagdidManager;
/*    */   private ECarXCarDiagmanufacturing1Manager mECarXCarDiagmanufacturing1Manager;
/*    */   private ECarXCarDiagmanufacturing2Manager mECarXCarDiagmanufacturing2Manager;
/*    */   private ECarXCarDiagotaManager mECarXCarDiagotaManager;
/*    */   private ECarXCarDiagproxyManager mECarXCarDiagproxyManager;
/*    */   private ECarXCarDrivemodeManager mECarXCarDrivemodeManager;
/*    */   private ECarXCarDspManager mECarXCarDspManager;
/*    */   private ECarXCarDtcManager mECarXCarDtcManager;
/*    */   private ECarXCarExtampctrlManager mECarXCarExtampctrlManager;
/*    */   private ECarXCarFaceidManager mECarXCarFaceidManager;
/*    */   private ECarXCarMculogpanicManager mECarXCarMculogpanicManager;
/*    */   private ECarXCarPacManager mECarXCarPacManager;
/*    */   
/*    */   public ECarXCarSetManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/* 48 */     this.mMgr = new ECarXCarPropertyManagerBase(paramIBinder, paramHandler, false, "ECarXCarSetManager");
/* 49 */     this.mgrList = new ArrayList<>();
/*    */   }
/*    */   
/*    */   private ECarXCarPassapManager mECarXCarPassapManager;
/*    */   private ECarXCarPhevManager mECarXCarPhevManager;
/*    */   private ECarXCarPowerManager mECarXCarPowerManager;
/*    */   private ECarXCarProfileManager mECarXCarProfileManager;
/*    */   private ECarXCarProfiletransferManager mECarXCarProfiletransferManager;
/*    */   private ECarXCarSaptouchManager mECarXCarSaptouchManager;
/*    */   private ECarXCarScenemodManager mECarXCarScenemodManager;
/*    */   private ECarXCarSeatclimateManager mECarXCarSeatclimateManager;
/*    */   private ECarXCarSeatctrlManager mECarXCarSeatctrlManager;
/*    */   private ECarXCarSensorManager mECarXCarSensorManager;
/*    */   private ECarXCarSteerwhlheatgManager mECarXCarSteerwhlheatgManager;
/*    */   private ECarXCarSystemsettingManager mECarXCarSystemsettingManager;
/*    */   private ECarXCarTchmodelManager mECarXCarTchmodelManager;
/*    */   private ECarXCarVehchargManager mECarXCarVehchargManager;
/*    */   private ECarXCarVfcipwakeupManager mECarXCarVfcipwakeupManager;
/*    */   private ECarXCarVfhudManager mECarXCarVfhudManager;
/*    */   private ECarXCarVfmisc2Manager mECarXCarVfmisc2Manager;
/*    */   private ECarXCarVfmiscManager mECarXCarVfmiscManager;
/*    */   private ECarXCarVfnaviManager mECarXCarVfnaviManager;
/*    */   private ECarXCarVfsmallcycleManager mECarXCarVfsmallcycleManager;
/*    */   private ECarXCarVinManager mECarXCarVinManager;
/*    */   private ECarXCarVpversionManager mECarXCarVpversionManager;
/*    */   private ECarXCarWpcmodelManager mECarXCarWpcmodelManager;
/*    */   private ECarXCarPropertyManagerBase mMgr;
/*    */   private ArrayList<ECarXCarFuncManagerBase> mgrList;
/*    */   
/*    */   public ECarXCarSetManager() {}
/*    */   
/*    */   public void onCarDisconnected() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   6: invokevirtual onCarDisconnected : ()V
/*    */     //   9: aload_0
/*    */     //   10: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   13: invokevirtual iterator : ()Ljava/util/Iterator;
/*    */     //   16: astore_2
/*    */     //   17: aload_2
/*    */     //   18: invokeinterface hasNext : ()Z
/*    */     //   23: ifeq -> 43
/*    */     //   26: aload_2
/*    */     //   27: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   32: checkcast ecarx/car/hardware/vehicle/ECarXCarFuncManagerBase
/*    */     //   35: astore_1
/*    */     //   36: aload_1
/*    */     //   37: invokevirtual onCarDisconnect : ()V
/*    */     //   40: goto -> 17
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: return
/*    */     //   46: astore_1
/*    */     //   47: aload_0
/*    */     //   48: monitorexit
/*    */     //   49: aload_1
/*    */     //   50: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #55	-> 2
/*    */     //   #56	-> 9
/*    */     //   #57	-> 36
/*    */     //   #58	-> 40
/*    */     //   #59	-> 43
/*    */     //   #54	-> 46
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	46	finally
/*    */     //   9	17	46	finally
/*    */     //   17	36	46	finally
/*    */     //   36	40	46	finally
/*    */   }
/*    */   
/*    */   public ECarXCarFuncManagerBase getECarXCarBaseManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mBaseManager : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarFuncManagerBase
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mBaseManager : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mBaseManager : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mBaseManager : Lecarx/car/hardware/vehicle/ECarXCarFuncManagerBase;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #62	-> 2
/*    */     //   #63	-> 9
/*    */     //   #64	-> 26
/*    */     //   #66	-> 38
/*    */     //   #61	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarActivesafetyManager getECarXCarActivesafetyManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarActivesafetyManager : Lecarx/car/hardware/vehicle/ECarXCarActivesafetyManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarActivesafetyManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarActivesafetyManager : Lecarx/car/hardware/vehicle/ECarXCarActivesafetyManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarActivesafetyManager : Lecarx/car/hardware/vehicle/ECarXCarActivesafetyManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarActivesafetyManager : Lecarx/car/hardware/vehicle/ECarXCarActivesafetyManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #114	-> 2
/*    */     //   #115	-> 9
/*    */     //   #116	-> 26
/*    */     //   #118	-> 38
/*    */     //   #113	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarClimateManager getECarXCarClimateManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarClimateManager : Lecarx/car/hardware/vehicle/ECarXCarClimateManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarClimateManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarClimateManager : Lecarx/car/hardware/vehicle/ECarXCarClimateManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarClimateManager : Lecarx/car/hardware/vehicle/ECarXCarClimateManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarClimateManager : Lecarx/car/hardware/vehicle/ECarXCarClimateManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #122	-> 2
/*    */     //   #123	-> 9
/*    */     //   #124	-> 26
/*    */     //   #126	-> 38
/*    */     //   #121	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarSeatclimateManager getECarXCarSeatclimateManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarSeatclimateManager : Lecarx/car/hardware/vehicle/ECarXCarSeatclimateManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarSeatclimateManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarSeatclimateManager : Lecarx/car/hardware/vehicle/ECarXCarSeatclimateManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarSeatclimateManager : Lecarx/car/hardware/vehicle/ECarXCarSeatclimateManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarSeatclimateManager : Lecarx/car/hardware/vehicle/ECarXCarSeatclimateManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #130	-> 2
/*    */     //   #131	-> 9
/*    */     //   #132	-> 26
/*    */     //   #134	-> 38
/*    */     //   #129	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarSteerwhlheatgManager getECarXCarSteerwhlheatgManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarSteerwhlheatgManager : Lecarx/car/hardware/vehicle/ECarXCarSteerwhlheatgManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarSteerwhlheatgManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarSteerwhlheatgManager : Lecarx/car/hardware/vehicle/ECarXCarSteerwhlheatgManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarSteerwhlheatgManager : Lecarx/car/hardware/vehicle/ECarXCarSteerwhlheatgManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarSteerwhlheatgManager : Lecarx/car/hardware/vehicle/ECarXCarSteerwhlheatgManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #138	-> 2
/*    */     //   #139	-> 9
/*    */     //   #140	-> 26
/*    */     //   #142	-> 38
/*    */     //   #137	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarAirqlyandfragraManager getECarXCarAirqlyandfragraManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarAirqlyandfragraManager : Lecarx/car/hardware/vehicle/ECarXCarAirqlyandfragraManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarAirqlyandfragraManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarAirqlyandfragraManager : Lecarx/car/hardware/vehicle/ECarXCarAirqlyandfragraManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarAirqlyandfragraManager : Lecarx/car/hardware/vehicle/ECarXCarAirqlyandfragraManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarAirqlyandfragraManager : Lecarx/car/hardware/vehicle/ECarXCarAirqlyandfragraManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #146	-> 2
/*    */     //   #147	-> 9
/*    */     //   #148	-> 26
/*    */     //   #150	-> 38
/*    */     //   #145	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarTchmodelManager getECarXCarTchmodelManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarTchmodelManager : Lecarx/car/hardware/vehicle/ECarXCarTchmodelManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarTchmodelManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarTchmodelManager : Lecarx/car/hardware/vehicle/ECarXCarTchmodelManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarTchmodelManager : Lecarx/car/hardware/vehicle/ECarXCarTchmodelManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarTchmodelManager : Lecarx/car/hardware/vehicle/ECarXCarTchmodelManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #154	-> 2
/*    */     //   #155	-> 9
/*    */     //   #156	-> 26
/*    */     //   #158	-> 38
/*    */     //   #153	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDrivemodeManager getECarXCarDrivemodeManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDrivemodeManager : Lecarx/car/hardware/vehicle/ECarXCarDrivemodeManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDrivemodeManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDrivemodeManager : Lecarx/car/hardware/vehicle/ECarXCarDrivemodeManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDrivemodeManager : Lecarx/car/hardware/vehicle/ECarXCarDrivemodeManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDrivemodeManager : Lecarx/car/hardware/vehicle/ECarXCarDrivemodeManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #162	-> 2
/*    */     //   #163	-> 9
/*    */     //   #164	-> 26
/*    */     //   #166	-> 38
/*    */     //   #161	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarPowerManager getECarXCarPowerManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarPowerManager : Lecarx/car/hardware/vehicle/ECarXCarPowerManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarPowerManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarPowerManager : Lecarx/car/hardware/vehicle/ECarXCarPowerManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarPowerManager : Lecarx/car/hardware/vehicle/ECarXCarPowerManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarPowerManager : Lecarx/car/hardware/vehicle/ECarXCarPowerManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #170	-> 2
/*    */     //   #171	-> 9
/*    */     //   #172	-> 26
/*    */     //   #174	-> 38
/*    */     //   #169	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarSystemsettingManager getECarXCarSystemsettingManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarSystemsettingManager : Lecarx/car/hardware/vehicle/ECarXCarSystemsettingManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarSystemsettingManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarSystemsettingManager : Lecarx/car/hardware/vehicle/ECarXCarSystemsettingManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarSystemsettingManager : Lecarx/car/hardware/vehicle/ECarXCarSystemsettingManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarSystemsettingManager : Lecarx/car/hardware/vehicle/ECarXCarSystemsettingManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #178	-> 2
/*    */     //   #179	-> 9
/*    */     //   #180	-> 26
/*    */     //   #182	-> 38
/*    */     //   #177	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarSaptouchManager getECarXCarSaptouchManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarSaptouchManager : Lecarx/car/hardware/vehicle/ECarXCarSaptouchManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarSaptouchManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarSaptouchManager : Lecarx/car/hardware/vehicle/ECarXCarSaptouchManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarSaptouchManager : Lecarx/car/hardware/vehicle/ECarXCarSaptouchManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarSaptouchManager : Lecarx/car/hardware/vehicle/ECarXCarSaptouchManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #186	-> 2
/*    */     //   #187	-> 9
/*    */     //   #188	-> 26
/*    */     //   #190	-> 38
/*    */     //   #185	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVinManager getECarXCarVinManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVinManager : Lecarx/car/hardware/vehicle/ECarXCarVinManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVinManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVinManager : Lecarx/car/hardware/vehicle/ECarXCarVinManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVinManager : Lecarx/car/hardware/vehicle/ECarXCarVinManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVinManager : Lecarx/car/hardware/vehicle/ECarXCarVinManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #194	-> 2
/*    */     //   #195	-> 9
/*    */     //   #196	-> 26
/*    */     //   #198	-> 38
/*    */     //   #193	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVpversionManager getECarXCarVpversionManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVpversionManager : Lecarx/car/hardware/vehicle/ECarXCarVpversionManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVpversionManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVpversionManager : Lecarx/car/hardware/vehicle/ECarXCarVpversionManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVpversionManager : Lecarx/car/hardware/vehicle/ECarXCarVpversionManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVpversionManager : Lecarx/car/hardware/vehicle/ECarXCarVpversionManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #202	-> 2
/*    */     //   #203	-> 9
/*    */     //   #204	-> 26
/*    */     //   #206	-> 38
/*    */     //   #201	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDeviceManager getECarXCarDeviceManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDeviceManager : Lecarx/car/hardware/vehicle/ECarXCarDeviceManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDeviceManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDeviceManager : Lecarx/car/hardware/vehicle/ECarXCarDeviceManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDeviceManager : Lecarx/car/hardware/vehicle/ECarXCarDeviceManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDeviceManager : Lecarx/car/hardware/vehicle/ECarXCarDeviceManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #210	-> 2
/*    */     //   #211	-> 9
/*    */     //   #212	-> 26
/*    */     //   #214	-> 38
/*    */     //   #209	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVfhudManager getECarXCarVfhudManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVfhudManager : Lecarx/car/hardware/vehicle/ECarXCarVfhudManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVfhudManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVfhudManager : Lecarx/car/hardware/vehicle/ECarXCarVfhudManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVfhudManager : Lecarx/car/hardware/vehicle/ECarXCarVfhudManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVfhudManager : Lecarx/car/hardware/vehicle/ECarXCarVfhudManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #218	-> 2
/*    */     //   #219	-> 9
/*    */     //   #220	-> 26
/*    */     //   #222	-> 38
/*    */     //   #217	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVfcipwakeupManager getECarXCarVfcipwakeupManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVfcipwakeupManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVfcipwakeupManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVfcipwakeupManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVfcipwakeupManager : Lecarx/car/hardware/vehicle/ECarXCarVfcipwakeupManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #226	-> 2
/*    */     //   #227	-> 9
/*    */     //   #228	-> 26
/*    */     //   #230	-> 38
/*    */     //   #225	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarAudioradioManager getECarXCarAudioradioManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarAudioradioManager : Lecarx/car/hardware/vehicle/ECarXCarAudioradioManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarAudioradioManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarAudioradioManager : Lecarx/car/hardware/vehicle/ECarXCarAudioradioManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarAudioradioManager : Lecarx/car/hardware/vehicle/ECarXCarAudioradioManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarAudioradioManager : Lecarx/car/hardware/vehicle/ECarXCarAudioradioManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #234	-> 2
/*    */     //   #235	-> 9
/*    */     //   #236	-> 26
/*    */     //   #238	-> 38
/*    */     //   #233	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarApvppulseManager getECarXCarApvppulseManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarApvppulseManager : Lecarx/car/hardware/vehicle/ECarXCarApvppulseManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarApvppulseManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarApvppulseManager : Lecarx/car/hardware/vehicle/ECarXCarApvppulseManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarApvppulseManager : Lecarx/car/hardware/vehicle/ECarXCarApvppulseManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarApvppulseManager : Lecarx/car/hardware/vehicle/ECarXCarApvppulseManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #242	-> 2
/*    */     //   #243	-> 9
/*    */     //   #244	-> 26
/*    */     //   #246	-> 38
/*    */     //   #241	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDspManager getECarXCarDspManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDspManager : Lecarx/car/hardware/vehicle/ECarXCarDspManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDspManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDspManager : Lecarx/car/hardware/vehicle/ECarXCarDspManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDspManager : Lecarx/car/hardware/vehicle/ECarXCarDspManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDspManager : Lecarx/car/hardware/vehicle/ECarXCarDspManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #250	-> 2
/*    */     //   #251	-> 9
/*    */     //   #252	-> 26
/*    */     //   #254	-> 38
/*    */     //   #249	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarPacManager getECarXCarPacManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarPacManager : Lecarx/car/hardware/vehicle/ECarXCarPacManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarPacManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarPacManager : Lecarx/car/hardware/vehicle/ECarXCarPacManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarPacManager : Lecarx/car/hardware/vehicle/ECarXCarPacManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarPacManager : Lecarx/car/hardware/vehicle/ECarXCarPacManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #258	-> 2
/*    */     //   #259	-> 9
/*    */     //   #260	-> 26
/*    */     //   #262	-> 38
/*    */     //   #257	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarPassapManager getECarXCarPassapManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarPassapManager : Lecarx/car/hardware/vehicle/ECarXCarPassapManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarPassapManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarPassapManager : Lecarx/car/hardware/vehicle/ECarXCarPassapManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarPassapManager : Lecarx/car/hardware/vehicle/ECarXCarPassapManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarPassapManager : Lecarx/car/hardware/vehicle/ECarXCarPassapManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #266	-> 2
/*    */     //   #267	-> 9
/*    */     //   #268	-> 26
/*    */     //   #270	-> 38
/*    */     //   #265	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarSeatctrlManager getECarXCarSeatctrlManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarSeatctrlManager : Lecarx/car/hardware/vehicle/ECarXCarSeatctrlManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarSeatctrlManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarSeatctrlManager : Lecarx/car/hardware/vehicle/ECarXCarSeatctrlManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarSeatctrlManager : Lecarx/car/hardware/vehicle/ECarXCarSeatctrlManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarSeatctrlManager : Lecarx/car/hardware/vehicle/ECarXCarSeatctrlManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #274	-> 2
/*    */     //   #275	-> 9
/*    */     //   #276	-> 26
/*    */     //   #278	-> 38
/*    */     //   #273	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarWpcmodelManager getECarXCarWpcmodelManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarWpcmodelManager : Lecarx/car/hardware/vehicle/ECarXCarWpcmodelManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarWpcmodelManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarWpcmodelManager : Lecarx/car/hardware/vehicle/ECarXCarWpcmodelManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarWpcmodelManager : Lecarx/car/hardware/vehicle/ECarXCarWpcmodelManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarWpcmodelManager : Lecarx/car/hardware/vehicle/ECarXCarWpcmodelManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #282	-> 2
/*    */     //   #283	-> 9
/*    */     //   #284	-> 26
/*    */     //   #286	-> 38
/*    */     //   #281	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVfmiscManager getECarXCarVfmiscManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVfmiscManager : Lecarx/car/hardware/vehicle/ECarXCarVfmiscManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVfmiscManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVfmiscManager : Lecarx/car/hardware/vehicle/ECarXCarVfmiscManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVfmiscManager : Lecarx/car/hardware/vehicle/ECarXCarVfmiscManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVfmiscManager : Lecarx/car/hardware/vehicle/ECarXCarVfmiscManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #290	-> 2
/*    */     //   #291	-> 9
/*    */     //   #292	-> 26
/*    */     //   #294	-> 38
/*    */     //   #289	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDtcManager getECarXCarDtcManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDtcManager : Lecarx/car/hardware/vehicle/ECarXCarDtcManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDtcManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDtcManager : Lecarx/car/hardware/vehicle/ECarXCarDtcManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDtcManager : Lecarx/car/hardware/vehicle/ECarXCarDtcManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDtcManager : Lecarx/car/hardware/vehicle/ECarXCarDtcManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #298	-> 2
/*    */     //   #299	-> 9
/*    */     //   #300	-> 26
/*    */     //   #302	-> 38
/*    */     //   #297	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDiagproxyManager getECarXCarDiagproxyManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDiagproxyManager : Lecarx/car/hardware/vehicle/ECarXCarDiagproxyManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDiagproxyManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDiagproxyManager : Lecarx/car/hardware/vehicle/ECarXCarDiagproxyManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDiagproxyManager : Lecarx/car/hardware/vehicle/ECarXCarDiagproxyManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDiagproxyManager : Lecarx/car/hardware/vehicle/ECarXCarDiagproxyManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #306	-> 2
/*    */     //   #307	-> 9
/*    */     //   #308	-> 26
/*    */     //   #310	-> 38
/*    */     //   #305	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDiagdidManager getECarXCarDiagdidManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDiagdidManager : Lecarx/car/hardware/vehicle/ECarXCarDiagdidManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDiagdidManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDiagdidManager : Lecarx/car/hardware/vehicle/ECarXCarDiagdidManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDiagdidManager : Lecarx/car/hardware/vehicle/ECarXCarDiagdidManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDiagdidManager : Lecarx/car/hardware/vehicle/ECarXCarDiagdidManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #314	-> 2
/*    */     //   #315	-> 9
/*    */     //   #316	-> 26
/*    */     //   #318	-> 38
/*    */     //   #313	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDiagmanufacturing1Manager getECarXCarDiagmanufacturing1Manager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDiagmanufacturing1Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing1Manager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing1Manager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDiagmanufacturing1Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing1Manager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDiagmanufacturing1Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing1Manager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDiagmanufacturing1Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing1Manager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #322	-> 2
/*    */     //   #323	-> 9
/*    */     //   #324	-> 26
/*    */     //   #326	-> 38
/*    */     //   #321	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDiagmanufacturing2Manager getECarXCarDiagmanufacturing2Manager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDiagmanufacturing2Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing2Manager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing2Manager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDiagmanufacturing2Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing2Manager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDiagmanufacturing2Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing2Manager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDiagmanufacturing2Manager : Lecarx/car/hardware/vehicle/ECarXCarDiagmanufacturing2Manager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #330	-> 2
/*    */     //   #331	-> 9
/*    */     //   #332	-> 26
/*    */     //   #334	-> 38
/*    */     //   #329	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarDiagotaManager getECarXCarDiagotaManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarDiagotaManager : Lecarx/car/hardware/vehicle/ECarXCarDiagotaManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarDiagotaManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarDiagotaManager : Lecarx/car/hardware/vehicle/ECarXCarDiagotaManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarDiagotaManager : Lecarx/car/hardware/vehicle/ECarXCarDiagotaManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarDiagotaManager : Lecarx/car/hardware/vehicle/ECarXCarDiagotaManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #338	-> 2
/*    */     //   #339	-> 9
/*    */     //   #340	-> 26
/*    */     //   #342	-> 38
/*    */     //   #337	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarPhevManager getECarXCarPhevManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarPhevManager : Lecarx/car/hardware/vehicle/ECarXCarPhevManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarPhevManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarPhevManager : Lecarx/car/hardware/vehicle/ECarXCarPhevManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarPhevManager : Lecarx/car/hardware/vehicle/ECarXCarPhevManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarPhevManager : Lecarx/car/hardware/vehicle/ECarXCarPhevManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #346	-> 2
/*    */     //   #347	-> 9
/*    */     //   #348	-> 26
/*    */     //   #350	-> 38
/*    */     //   #345	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVehchargManager getECarXCarVehchargManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVehchargManager : Lecarx/car/hardware/vehicle/ECarXCarVehchargManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVehchargManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVehchargManager : Lecarx/car/hardware/vehicle/ECarXCarVehchargManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVehchargManager : Lecarx/car/hardware/vehicle/ECarXCarVehchargManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVehchargManager : Lecarx/car/hardware/vehicle/ECarXCarVehchargManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #354	-> 2
/*    */     //   #355	-> 9
/*    */     //   #356	-> 26
/*    */     //   #358	-> 38
/*    */     //   #353	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVfmisc2Manager getECarXCarVfmisc2Manager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVfmisc2Manager : Lecarx/car/hardware/vehicle/ECarXCarVfmisc2Manager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVfmisc2Manager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVfmisc2Manager : Lecarx/car/hardware/vehicle/ECarXCarVfmisc2Manager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVfmisc2Manager : Lecarx/car/hardware/vehicle/ECarXCarVfmisc2Manager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVfmisc2Manager : Lecarx/car/hardware/vehicle/ECarXCarVfmisc2Manager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #362	-> 2
/*    */     //   #363	-> 9
/*    */     //   #364	-> 26
/*    */     //   #366	-> 38
/*    */     //   #361	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarAmbliManager getECarXCarAmbliManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarAmbliManager : Lecarx/car/hardware/vehicle/ECarXCarAmbliManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarAmbliManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarAmbliManager : Lecarx/car/hardware/vehicle/ECarXCarAmbliManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarAmbliManager : Lecarx/car/hardware/vehicle/ECarXCarAmbliManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarAmbliManager : Lecarx/car/hardware/vehicle/ECarXCarAmbliManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #370	-> 2
/*    */     //   #371	-> 9
/*    */     //   #372	-> 26
/*    */     //   #374	-> 38
/*    */     //   #369	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVfsmallcycleManager getECarXCarVfsmallcycleManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVfsmallcycleManager : Lecarx/car/hardware/vehicle/ECarXCarVfsmallcycleManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVfsmallcycleManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVfsmallcycleManager : Lecarx/car/hardware/vehicle/ECarXCarVfsmallcycleManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVfsmallcycleManager : Lecarx/car/hardware/vehicle/ECarXCarVfsmallcycleManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVfsmallcycleManager : Lecarx/car/hardware/vehicle/ECarXCarVfsmallcycleManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #378	-> 2
/*    */     //   #379	-> 9
/*    */     //   #380	-> 26
/*    */     //   #382	-> 38
/*    */     //   #377	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarProfileManager getECarXCarProfileManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarProfileManager : Lecarx/car/hardware/vehicle/ECarXCarProfileManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarProfileManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarProfileManager : Lecarx/car/hardware/vehicle/ECarXCarProfileManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarProfileManager : Lecarx/car/hardware/vehicle/ECarXCarProfileManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarProfileManager : Lecarx/car/hardware/vehicle/ECarXCarProfileManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #386	-> 2
/*    */     //   #387	-> 9
/*    */     //   #388	-> 26
/*    */     //   #390	-> 38
/*    */     //   #385	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarVfnaviManager getECarXCarVfnaviManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarVfnaviManager : Lecarx/car/hardware/vehicle/ECarXCarVfnaviManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarVfnaviManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarVfnaviManager : Lecarx/car/hardware/vehicle/ECarXCarVfnaviManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarVfnaviManager : Lecarx/car/hardware/vehicle/ECarXCarVfnaviManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarVfnaviManager : Lecarx/car/hardware/vehicle/ECarXCarVfnaviManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #394	-> 2
/*    */     //   #395	-> 9
/*    */     //   #396	-> 26
/*    */     //   #398	-> 38
/*    */     //   #393	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarScenemodManager getECarXCarScenemodManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarScenemodManager : Lecarx/car/hardware/vehicle/ECarXCarScenemodManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarScenemodManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarScenemodManager : Lecarx/car/hardware/vehicle/ECarXCarScenemodManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarScenemodManager : Lecarx/car/hardware/vehicle/ECarXCarScenemodManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarScenemodManager : Lecarx/car/hardware/vehicle/ECarXCarScenemodManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #402	-> 2
/*    */     //   #403	-> 9
/*    */     //   #404	-> 26
/*    */     //   #406	-> 38
/*    */     //   #401	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarFaceidManager getECarXCarFaceidManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarFaceidManager : Lecarx/car/hardware/vehicle/ECarXCarFaceidManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarFaceidManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarFaceidManager : Lecarx/car/hardware/vehicle/ECarXCarFaceidManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarFaceidManager : Lecarx/car/hardware/vehicle/ECarXCarFaceidManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarFaceidManager : Lecarx/car/hardware/vehicle/ECarXCarFaceidManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #410	-> 2
/*    */     //   #411	-> 9
/*    */     //   #412	-> 26
/*    */     //   #414	-> 38
/*    */     //   #409	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarSensorManager getECarXCarSensorManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarSensorManager : Lecarx/car/hardware/vehicle/ECarXCarSensorManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarSensorManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarSensorManager : Lecarx/car/hardware/vehicle/ECarXCarSensorManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarSensorManager : Lecarx/car/hardware/vehicle/ECarXCarSensorManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarSensorManager : Lecarx/car/hardware/vehicle/ECarXCarSensorManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #418	-> 2
/*    */     //   #419	-> 9
/*    */     //   #420	-> 26
/*    */     //   #422	-> 38
/*    */     //   #417	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarProfiletransferManager getECarXCarProfiletransferManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarProfiletransferManager : Lecarx/car/hardware/vehicle/ECarXCarProfiletransferManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarProfiletransferManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarProfiletransferManager : Lecarx/car/hardware/vehicle/ECarXCarProfiletransferManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarProfiletransferManager : Lecarx/car/hardware/vehicle/ECarXCarProfiletransferManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarProfiletransferManager : Lecarx/car/hardware/vehicle/ECarXCarProfiletransferManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #426	-> 2
/*    */     //   #427	-> 9
/*    */     //   #428	-> 26
/*    */     //   #430	-> 38
/*    */     //   #425	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarApplogManager getECarXCarApplogManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarApplogManager : Lecarx/car/hardware/vehicle/ECarXCarApplogManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarApplogManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarApplogManager : Lecarx/car/hardware/vehicle/ECarXCarApplogManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarApplogManager : Lecarx/car/hardware/vehicle/ECarXCarApplogManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarApplogManager : Lecarx/car/hardware/vehicle/ECarXCarApplogManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #434	-> 2
/*    */     //   #435	-> 9
/*    */     //   #436	-> 26
/*    */     //   #438	-> 38
/*    */     //   #433	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarMculogpanicManager getECarXCarMculogpanicManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarMculogpanicManager : Lecarx/car/hardware/vehicle/ECarXCarMculogpanicManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarMculogpanicManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarMculogpanicManager : Lecarx/car/hardware/vehicle/ECarXCarMculogpanicManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarMculogpanicManager : Lecarx/car/hardware/vehicle/ECarXCarMculogpanicManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarMculogpanicManager : Lecarx/car/hardware/vehicle/ECarXCarMculogpanicManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #442	-> 2
/*    */     //   #443	-> 9
/*    */     //   #444	-> 26
/*    */     //   #446	-> 38
/*    */     //   #441	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarExtampctrlManager getECarXCarExtampctrlManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarExtampctrlManager : Lecarx/car/hardware/vehicle/ECarXCarExtampctrlManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarExtampctrlManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarExtampctrlManager : Lecarx/car/hardware/vehicle/ECarXCarExtampctrlManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarExtampctrlManager : Lecarx/car/hardware/vehicle/ECarXCarExtampctrlManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarExtampctrlManager : Lecarx/car/hardware/vehicle/ECarXCarExtampctrlManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #450	-> 2
/*    */     //   #451	-> 9
/*    */     //   #452	-> 26
/*    */     //   #454	-> 38
/*    */     //   #449	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */   
/*    */   public ECarXCarApversionManager getECarXCarApversionManager() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: monitorenter
/*    */     //   2: aload_0
/*    */     //   3: getfield mECarXCarApversionManager : Lecarx/car/hardware/vehicle/ECarXCarApversionManager;
/*    */     //   6: ifnonnull -> 38
/*    */     //   9: new ecarx/car/hardware/vehicle/ECarXCarApversionManager
/*    */     //   12: astore_1
/*    */     //   13: aload_1
/*    */     //   14: aload_0
/*    */     //   15: getfield mMgr : Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;
/*    */     //   18: invokespecial <init> : (Lecarx/car/hardware/property/ECarXCarPropertyManagerBase;)V
/*    */     //   21: aload_0
/*    */     //   22: aload_1
/*    */     //   23: putfield mECarXCarApversionManager : Lecarx/car/hardware/vehicle/ECarXCarApversionManager;
/*    */     //   26: aload_0
/*    */     //   27: getfield mgrList : Ljava/util/ArrayList;
/*    */     //   30: aload_0
/*    */     //   31: getfield mECarXCarApversionManager : Lecarx/car/hardware/vehicle/ECarXCarApversionManager;
/*    */     //   34: invokevirtual add : (Ljava/lang/Object;)Z
/*    */     //   37: pop
/*    */     //   38: aload_0
/*    */     //   39: getfield mECarXCarApversionManager : Lecarx/car/hardware/vehicle/ECarXCarApversionManager;
/*    */     //   42: astore_1
/*    */     //   43: aload_0
/*    */     //   44: monitorexit
/*    */     //   45: aload_1
/*    */     //   46: areturn
/*    */     //   47: astore_1
/*    */     //   48: aload_0
/*    */     //   49: monitorexit
/*    */     //   50: aload_1
/*    */     //   51: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #458	-> 2
/*    */     //   #459	-> 9
/*    */     //   #460	-> 26
/*    */     //   #462	-> 38
/*    */     //   #457	-> 47
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	9	47	finally
/*    */     //   9	26	47	finally
/*    */     //   26	38	47	finally
/*    */     //   38	43	47	finally
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\vehicle\ECarXCarSetManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */