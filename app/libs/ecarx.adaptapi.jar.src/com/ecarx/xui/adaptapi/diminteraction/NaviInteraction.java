/*     */ package com.ecarx.xui.adaptapi.diminteraction;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.graphics.Bitmap;
/*     */ import android.os.Bundle;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import ecarx.car.hardware.vehicle.ECarXCarVfhudManager;
/*     */ import ecarx.dimprotocol.DIMProtocolManager;
/*     */ import ecarx.dimprotocol.IDIMProtocolServiceCallback;
/*     */ import java.util.List;
/*     */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NaviInteraction
/*     */   extends AbsCarSignal
/*     */   implements INaviInteraction
/*     */ {
/*     */   private static final byte MSG_TYPE_ACK = 3;
/*     */   private static final byte MSG_TYPE_ERROR = 4;
/*     */   private static final byte MSG_TYPE_NOTIFY = 2;
/*     */   private static final byte MSG_TYPE_REQUEST = 0;
/*     */   private static final byte MSG_TYPE_RESPONSE = 1;
/*     */   private static final String TAG = "NaviInteraction";
/*     */   private ECarXCarVfhudManager hudManager;
/*     */   private DIMProtocolManager mDIMProtocolManager;
/*     */   private IDIMProtocolServiceCallback mDIMServiceCallback;
/*     */   public INaviInteraction.INavigationInteractionCallback mNaviCallback;
/*     */   
/*     */   public NaviInteraction(Context paramContext) {
/*  37 */     super(paramContext);
/*  38 */     this.hudManager = null;
/*  39 */     this.mDIMProtocolManager = DIMProtocolManager.getInstance(paramContext);
/*  40 */     this.mDIMServiceCallback = (IDIMProtocolServiceCallback)new DIMProtocolServiceCallbackImpl();
/*  41 */     this.mDIMProtocolManager.registerCallback(this.mDIMServiceCallback);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyTurnByTurnStarted() {
/*  50 */     Log.i("NaviInteraction", "notifyTurnByTurnStarted");
/*     */ 
/*     */     
/*  53 */     this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)17, new byte[] { 1 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyTurnByTurnStopped() {
/*  61 */     Log.i("NaviInteraction", "notifyTurnByTurnStopped");
/*     */ 
/*     */     
/*  64 */     this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)17, new byte[] { 2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyNavigationStatus(int paramInt) {
/*  72 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyNavigationStatus("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */     
/*  74 */     if (paramInt == 3) {
/*  75 */       try { this.mCarSignalManager.setDstToDestination(0);
/*     */         
/*  77 */         VendorVehicleHalPAProto.ProtoDestinationPOI protoDestinationPOI = new VendorVehicleHalPAProto.ProtoDestinationPOI(); this();
/*     */         
/*  79 */         protoDestinationPOI.destinationPOIPosnLat = 324000000;
/*  80 */         protoDestinationPOI.destinationPOIPosnLgt = 648000000;
/*  81 */         this.mCarSignalManager.setDestinationPOI(protoDestinationPOI);
/*     */         
/*  83 */         this.mCarSignalManager.setPlannedPahDe(0);
/*     */         
/*     */          }
/*     */       
/*  87 */       catch (Exception exception) {}
/*     */     }
/*     */     this.hudManager.CB_HUD_DispModSet(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateETA(int paramInt) {
/*  99 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateETA("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateDistanceToDestination(int paramInt) {
/* 110 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateDistanceToDestination("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */     
/*     */     try {
/* 113 */       this.mCarSignalManager.setDstToDestination(paramInt);
/* 114 */     } catch (Exception exception) {
/* 115 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTotalDistanceToDestination(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateDistanceToNextGuidancePoint(int paramInt) {
/* 138 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateDistanceToNextGuidancePoint("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void UpdateDistanceToNextGuidancePoint(String paramString, int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateNextGuidancePointName(String paramString) {
/* 161 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateNextGuidancePointName("); stringBuilder.append(paramString); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTurnByTurnArrow(Bitmap paramBitmap) {
/* 171 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateTurnByTurnArrow("); stringBuilder.append(paramBitmap); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTurnByTurnArrow(int paramInt) {
/* 181 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateTurnByTurnArrow("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateTurnByTurnArrow(String paramString) {
/* 191 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateTurnByTurnArrow("); stringBuilder.append(paramString); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDestinationReached(String paramString, Bitmap paramBitmap) {
/* 202 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyDestinationReached("); stringBuilder.append(paramString); stringBuilder.append(", "); stringBuilder.append(paramBitmap); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDestinationReached(String paramString, int paramInt) {
/* 213 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyDestinationReached("); stringBuilder.append(paramString); stringBuilder.append(", "); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateDriveDirection(int paramInt) {
/* 223 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateDriveDirection("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateMuteState(int paramInt) {
/* 233 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateMuteState("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateDayNightMode(int paramInt) {
/* 245 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("updateDayNightMode("); stringBuilder.append(paramInt); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateLaneInfo(INaviInteraction.ILaneInfo[] paramArrayOfILaneInfo) {
/* 255 */     Log.i("NaviInteraction", "updateLaneInfo()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateHighwayExitInfo(INaviInteraction.IHighwayExitInfo paramIHighwayExitInfo) {
/* 265 */     Log.i("NaviInteraction", "updateHighwayExitInfo()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateServiceAreaInfo(INaviInteraction.IServiceArea paramIServiceArea) {
/* 275 */     Log.i("NaviInteraction", "updateServiceAreaInfo()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateRoadCameraInfo(INaviInteraction.IRoadCamera paramIRoadCamera) {
/* 285 */     Log.i("NaviInteraction", "updateRoadCameraInfo()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateNaviInfo(NaviInfo paramNaviInfo) {
/* 296 */     Log.i("NaviInteraction", "updateNaviInfo()");
/*     */     
/* 298 */     if (paramNaviInfo != null) try { if (this.mCarSignalManager != null) {
/* 299 */           this.mCarSignalManager.setDstToDestination((int)paramNaviInfo.getRemainDistance());
/*     */           
/* 301 */           VendorVehicleHalPAProto.ProtoDestinationPOI protoDestinationPOI = new VendorVehicleHalPAProto.ProtoDestinationPOI(); this();
/*     */           
/* 303 */           protoDestinationPOI.destinationPOIPosnLat = (int)(paramNaviInfo.gatLatitude() / 2.77778E-7D);
/* 304 */           protoDestinationPOI.destinationPOIPosnLgt = (int)(paramNaviInfo.gatLongitude() / 2.77778E-7D);
/* 305 */           this.mCarSignalManager.setDestinationPOI(protoDestinationPOI);
/*     */         }  }
/* 307 */       catch (Exception exception)
/* 308 */       { exception.printStackTrace(); }
/*     */     
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateNaviStatus(NaviStatus paramNaviStatus) {
/* 320 */     Log.i("NaviInteraction", "updateNaviStatus()");
/*     */     
/* 322 */     if (paramNaviStatus.getStatus() == 0) {
/*     */       
/* 324 */       if (paramNaviStatus.isYawing()) {
/* 325 */         this.mCarSignalManager.setPlannedPahDe(1);
/*     */       } else {
/* 327 */         this.mCarSignalManager.setPlannedPahDe(2);
/*     */       } 
/*     */     } else {
/*     */       
/* 331 */       this.mCarSignalManager.setPlannedPahDe(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateLastRangeInfo(LastRangeInfo paramLastRangeInfo) {
/* 343 */     Log.i("NaviInteraction", "updateLastRangeInfo()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateExtensionInfo(Bundle paramBundle) {
/*     */     StringBuilder stringBuilder;
/* 354 */     int i = paramBundle.getInt("EXT_KEY_DIM_DISPLAY_MODE");
/*     */     
/* 356 */     switch (i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 382 */         stringBuilder = new StringBuilder(); stringBuilder.append("updateExtensionInfo   wrong mode:"); stringBuilder.append(i); Log.d("NaviInteraction", stringBuilder.toString()); return;
/*     */       case 36:
/*     */         Log.d("NaviInteraction", "updateExtensionInfo   ACTION_DIM_DISPLAY_AR"); this.mDIMProtocolManager.onChangeNaviMode(4); this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 }); return;
/*     */       case 35:
/*     */         Log.d("NaviInteraction", "updateExtensionInfo   ACTION_DIM_DISPLAY_FULL"); this.mDIMProtocolManager.onChangeNaviMode(3); this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 });
/*     */         return;
/*     */       case 34:
/*     */         Log.d("NaviInteraction", "updateExtensionInfo   ACTION_DIM_DISPLAY_SIMPLIFY");
/*     */         this.mDIMProtocolManager.onChangeNaviMode(2);
/*     */         this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 });
/*     */         return;
/*     */       case 33:
/*     */         break;
/*     */     } 
/*     */     Log.d("NaviInteraction", "updateExtensionInfo   NAVI_MODE_OFF");
/*     */     this.mDIMProtocolManager.onChangeNaviMode(1);
/* 398 */     this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 }); } public void updateNavigationInfo(INaviInteraction.INavigationInfo paramINavigationInfo) { Log.i("NaviInteraction", "updateNavigationInfo()"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAddresses(int paramInt, List<INaviInteraction.IAddress> paramList) {
/* 410 */     Log.i("NaviInteraction", "updateAddresses()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateSearchAddresses(int paramInt, List<INaviInteraction.IAddress> paramList, String paramString) {
/* 422 */     Log.i("NaviInteraction", "updateSearchAddresses()");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerNavigationInteractionCallback(INaviInteraction.INavigationInteractionCallback paramINavigationInteractionCallback) {
/* 432 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerNavigationInteractionCallback("); stringBuilder.append(paramINavigationInteractionCallback); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/* 433 */     this.mNaviCallback = paramINavigationInteractionCallback;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterNavigationInteractionCallback(INaviInteraction.INavigationInteractionCallback paramINavigationInteractionCallback) {
/* 443 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("unregisterNavigationInteractionCallback("); stringBuilder.append(paramINavigationInteractionCallback); stringBuilder.append(")"); Log.i("NaviInteraction", stringBuilder.toString());
/* 444 */     this.mNaviCallback = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onInitCarSignalManager() {
/* 449 */     this.hudManager = this.mECarXCarSetManager.getECarXCarVfhudManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class DIMProtocolServiceCallbackImpl
/*     */     extends IDIMProtocolServiceCallback.Stub
/*     */   {
/*     */     final NaviInteraction this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     public void onAck(byte param1Byte) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void onError(byte param1Byte) {}
/*     */ 
/*     */     
/*     */     public void onReceived(byte param1Byte1, byte param1Byte2) {
/* 469 */       if (param1Byte1 != 7);
/*     */       
/* 471 */       switch (param1Byte2) {
/*     */         default:
/*     */           return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 2:
/* 510 */           if (NaviInteraction.this.mNaviCallback != null) {
/* 511 */             Log.d("NaviInteraction", "DIM通知退出全屏地图，   mNaviInteraction.mNaviCallback  is not null.");
/*     */ 
/*     */             
/* 514 */             NaviInteraction.this.mNaviCallback.onDoInteractionAction(33, null);
/*     */             
/* 516 */             Log.d("NaviInteraction", "sendMessageToDIM NAVI_MODE_OFF");
/* 517 */             NaviInteraction.this.mDIMProtocolManager.onChangeNaviMode(1);
/*     */             
/* 519 */             NaviInteraction.this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 });
/*     */           } else {
/* 521 */             Log.d("NaviInteraction", "DIM通知退出全屏地图，   mNaviInteraction.mNaviCallback  is null.");
/*     */           } 
/*     */         case 1:
/*     */           break;
/*     */       } 
/*     */       if (NaviInteraction.this.mNaviCallback != null) {
/*     */         int i = NaviInteraction.this.mDIMProtocolManager.getNaviMode();
/*     */         if (i == 3) {
/*     */           Log.d("NaviInteraction", "DIM通知允许进入全屏地图，   mNaviInteraction.mNaviCallback  is not null.");
/*     */           NaviInteraction.this.mNaviCallback.onDoInteractionAction(35, null);
/*     */           Log.d("NaviInteraction", "sendMessageToDIM NAVI_MODE_FULL");
/*     */           NaviInteraction.this.mDIMProtocolManager.onChangeNaviMode(3);
/*     */           NaviInteraction.this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 });
/*     */         } 
/*     */         if (i == 4) {
/*     */           Log.d("NaviInteraction", "DIM通知允许进入AR全屏地图，   mNaviInteraction.mNaviCallback  is not null.");
/*     */           NaviInteraction.this.mNaviCallback.onDoInteractionAction(36, null);
/*     */           Log.d("NaviInteraction", "sendMessageToDIM NAVI_MODE_AR");
/*     */           NaviInteraction.this.mDIMProtocolManager.onChangeNaviMode(4);
/*     */           NaviInteraction.this.mDIMProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)8, new byte[] { 1 });
/*     */         } 
/*     */       } 
/*     */       Log.d("NaviInteraction", "DIM通知允许进入全屏地图，   mNaviInteraction.mNaviCallback  is null.");
/*     */     }
/*     */     
/*     */     public void onFestivalPaperStatusChanged() {}
/*     */     
/*     */     public void onWallPaperStatusChanged(int param1Int) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\NaviInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */