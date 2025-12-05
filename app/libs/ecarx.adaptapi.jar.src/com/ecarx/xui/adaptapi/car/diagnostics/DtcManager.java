/*     */ package com.ecarx.xui.adaptapi.car.diagnostics;
/*     */ 
/*     */ import android.content.Context;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import ecarx.car.hardware.vehicle.CarPAEventCallback;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarWpcmodelManager;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DtcManager
/*     */   extends AbsCarSignal
/*     */   implements IDtcManager
/*     */ {
/*     */   private static final int Active = 1;
/*     */   private static final int Inactive = 0;
/*     */   private static final String TAG = "DtcManager_API";
/*     */   private DtcInfo mAudDtcInfo;
/*     */   private final CarPAEventCallback mCarPAEventCallback;
/*     */   private DtcInfo mCcsmDtcInfo;
/*     */   private DtcInfo mCsdDtcInfo;
/*     */   private final CopyOnWriteArrayList<IDtcManager.IDtcInfoWatcher> mDtcInfoWatchers;
/*     */   private ECarXCarWpcmodelManager mECarXCarWpcmodelManager;
/*     */   private final ArrayList<IDtcManager.IDtcInfo> mIDtcInfos;
/*     */   private DtcInfo mIhuDtcInfo;
/*     */   private final PA mPA;
/*     */   private DtcInfo mPacDtcInfo;
/*     */   private DtcInfo mTem2DtcInfo;
/*     */   private DtcInfo mVcmDtcInfo;
/*     */   private DtcInfo mWpcDtcInfo;
/*     */   
/*     */   private static class PA
/*     */   {
/*     */     private PA() {}
/*     */     
/*  42 */     Object objLock = new Object();
/*     */ 
/*     */     
/*     */     @GuardedBy("objLock")
/*     */     PATypes.PA_WPC_Setting paWpcSetting;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected DtcManager(Context paramContext) {
/*  52 */     super(paramContext);
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
/* 256 */     this.mCarPAEventCallback = new CarPAEventCallback()
/*     */       {
/*     */         final DtcManager this$0;
/*     */         
/*     */         public void onPA_WPC_Setting(PATypes.PA_WPC_Setting param1PA_WPC_Setting) {
/* 261 */           synchronized (DtcManager.this.mPA.objLock) {
/* 262 */             DtcManager.this.mPA.paWpcSetting = param1PA_WPC_Setting;
/*     */ 
/*     */             
/* 265 */             DtcManager.this.checkWpcDtc();
/*     */             return;
/*     */           } 
/*     */         }
/*     */       };
/*     */     this.mDtcInfoWatchers = new CopyOnWriteArrayList<>();
/*     */     this.mIDtcInfos = new ArrayList<>();
/*     */     this.mPA = new PA();
/*     */     initDtcInfos();
/*     */   }
/*     */   
/*     */   private void initDtcInfos() {
/*     */     long l = System.currentTimeMillis();
/*     */     this.mIhuDtcInfo = new DtcInfo(1, 1, l);
/*     */     this.mIDtcInfos.add(this.mIhuDtcInfo);
/*     */     this.mCsdDtcInfo = new DtcInfo(2, 1, l);
/*     */     this.mIDtcInfos.add(this.mCsdDtcInfo);
/*     */     this.mWpcDtcInfo = new DtcInfo(3, 1, l);
/*     */     this.mIDtcInfos.add(this.mWpcDtcInfo);
/*     */     this.mCcsmDtcInfo = new DtcInfo(4, 1, l);
/*     */     this.mIDtcInfos.add(this.mCcsmDtcInfo);
/*     */     this.mAudDtcInfo = new DtcInfo(5, 1, l);
/*     */     this.mIDtcInfos.add(this.mAudDtcInfo);
/*     */     this.mTem2DtcInfo = new DtcInfo(6, 1, l);
/*     */     this.mIDtcInfos.add(this.mTem2DtcInfo);
/*     */     this.mVcmDtcInfo = new DtcInfo(7, 1, l);
/*     */     this.mIDtcInfos.add(this.mVcmDtcInfo);
/*     */     this.mPacDtcInfo = new DtcInfo(8, 0, l);
/*     */     this.mIDtcInfos.add(this.mPacDtcInfo);
/*     */   }
/*     */   
/*     */   protected void onInitCarSignalManager() {
/*     */     try {
/*     */       this.mECarXCarWpcmodelManager = this.mECarXCarSetManager.getECarXCarWpcmodelManager();
/*     */       SignalFilter signalFilter = new SignalFilter();
/*     */       this();
/*     */       signalFilter.add(Integer.valueOf(33634));
/*     */       this.mECarXCarWpcmodelManager.registerCallback(this.mCarPAEventCallback, signalFilter);
/*     */       synchronized (this.mPA.objLock) {
/*     */         this.mPA.paWpcSetting = this.mECarXCarWpcmodelManager.getPA_WPC_Setting();
/*     */       } 
/*     */     } catch (Exception exception) {
/*     */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<IDtcManager.IDtcInfo> getDtcInfos() {
/*     */     return this.mIDtcInfos;
/*     */   }
/*     */   
/*     */   public boolean registerWatcher(IDtcManager.IDtcInfoWatcher paramIDtcInfoWatcher) {
/*     */     boolean bool = true;
/*     */     if (!this.mDtcInfoWatchers.contains(paramIDtcInfoWatcher))
/*     */       bool = this.mDtcInfoWatchers.add(paramIDtcInfoWatcher); 
/*     */     return bool;
/*     */   }
/*     */   
/*     */   public void unregisterWatcher(IDtcManager.IDtcInfoWatcher paramIDtcInfoWatcher) {
/*     */     this.mDtcInfoWatchers.remove(paramIDtcInfoWatcher);
/*     */   }
/*     */   
/*     */   private void onDtcInfosChanged(List<IDtcManager.IDtcInfo> paramList) {
/*     */     for (IDtcManager.IDtcInfoWatcher iDtcInfoWatcher : this.mDtcInfoWatchers) {
/*     */       try {
/*     */         iDtcInfoWatcher.onDtcInfosChanged(paramList);
/*     */       } catch (Exception exception) {
/*     */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void onDtcInfosChanged(IDtcManager.IDtcInfo paramIDtcInfo) {
/*     */     ArrayList<IDtcManager.IDtcInfo> arrayList = new ArrayList();
/*     */     arrayList.add(paramIDtcInfo);
/*     */     onDtcInfosChanged(arrayList);
/*     */   }
/*     */   
/*     */   private void checkWpcDtc() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield mPA : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$PA;
/*     */     //   4: getfield objLock : Ljava/lang/Object;
/*     */     //   7: astore_3
/*     */     //   8: aload_3
/*     */     //   9: monitorenter
/*     */     //   10: aload_0
/*     */     //   11: getfield mPA : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$PA;
/*     */     //   14: getfield paWpcSetting : Lecarx/car/hardware/vehicle/PATypes$PA_WPC_Setting;
/*     */     //   17: astore #4
/*     */     //   19: aload #4
/*     */     //   21: invokevirtual getAvailability : ()I
/*     */     //   24: istore_2
/*     */     //   25: iconst_1
/*     */     //   26: istore_1
/*     */     //   27: iload_2
/*     */     //   28: iconst_1
/*     */     //   29: if_icmpne -> 53
/*     */     //   32: aload_0
/*     */     //   33: getfield mPA : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$PA;
/*     */     //   36: getfield paWpcSetting : Lecarx/car/hardware/vehicle/PATypes$PA_WPC_Setting;
/*     */     //   39: astore #4
/*     */     //   41: aload #4
/*     */     //   43: invokevirtual getData : ()I
/*     */     //   46: iconst_1
/*     */     //   47: if_icmpne -> 53
/*     */     //   50: goto -> 55
/*     */     //   53: iconst_0
/*     */     //   54: istore_1
/*     */     //   55: aload_3
/*     */     //   56: monitorexit
/*     */     //   57: aload_0
/*     */     //   58: getfield mWpcDtcInfo : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$DtcInfo;
/*     */     //   61: invokevirtual getStatus : ()I
/*     */     //   64: iload_1
/*     */     //   65: if_icmpeq -> 94
/*     */     //   68: aload_0
/*     */     //   69: getfield mWpcDtcInfo : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$DtcInfo;
/*     */     //   72: iload_1
/*     */     //   73: invokevirtual setStatus : (I)V
/*     */     //   76: aload_0
/*     */     //   77: getfield mWpcDtcInfo : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$DtcInfo;
/*     */     //   80: invokestatic currentTimeMillis : ()J
/*     */     //   83: invokevirtual setTicktime : (J)V
/*     */     //   86: aload_0
/*     */     //   87: aload_0
/*     */     //   88: getfield mWpcDtcInfo : Lcom/ecarx/xui/adaptapi/car/diagnostics/DtcManager$DtcInfo;
/*     */     //   91: invokespecial onDtcInfosChanged : (Lcom/ecarx/xui/adaptapi/car/diagnostics/IDtcManager$IDtcInfo;)V
/*     */     //   94: return
/*     */     //   95: astore #4
/*     */     //   97: aload_3
/*     */     //   98: monitorexit
/*     */     //   99: aload #4
/*     */     //   101: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #171	-> 0
/*     */     //   #173	-> 10
/*     */     //   #172	-> 19
/*     */     //   #173	-> 41
/*     */     //   #174	-> 50
/*     */     //   #175	-> 55
/*     */     //   #177	-> 57
/*     */     //   #178	-> 68
/*     */     //   #179	-> 76
/*     */     //   #180	-> 86
/*     */     //   #182	-> 94
/*     */     //   #175	-> 95
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   10	19	95	finally
/*     */     //   19	25	95	finally
/*     */     //   32	41	95	finally
/*     */     //   41	50	95	finally
/*     */     //   55	57	95	finally
/*     */     //   97	99	95	finally
/*     */   }
/*     */   
/*     */   private static class DtcInfo implements IDtcManager.IDtcInfo {
/*     */     private String mDtcCode;
/*     */     private int mEcuType;
/*     */     private int mStatus;
/*     */     private long mTicktime;
/*     */     
/*     */     public DtcInfo(int param1Int1, int param1Int2, long param1Long) {
/*     */       this.mEcuType = param1Int1;
/*     */       this.mStatus = param1Int2;
/*     */       this.mTicktime = param1Long;
/*     */     }
/*     */     
/*     */     public String getDtcId() {
/*     */       return String.valueOf(this.mEcuType);
/*     */     }
/*     */     
/*     */     public int getEcuType() {
/*     */       return this.mEcuType;
/*     */     }
/*     */     
/*     */     public int getStatus() {
/*     */       return this.mStatus;
/*     */     }
/*     */     
/*     */     public long getTicktime() {
/*     */       return this.mTicktime;
/*     */     }
/*     */     
/*     */     public String getDtcCode() {
/*     */       return this.mDtcCode;
/*     */     }
/*     */     
/*     */     public void setStatus(int param1Int) {
/*     */       this.mStatus = param1Int;
/*     */     }
/*     */     
/*     */     public void setTicktime(long param1Long) {
/*     */       this.mTicktime = param1Long;
/*     */     }
/*     */     
/*     */     public void setDtcCode(String param1String) {
/*     */       this.mDtcCode = param1String;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\DtcManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */