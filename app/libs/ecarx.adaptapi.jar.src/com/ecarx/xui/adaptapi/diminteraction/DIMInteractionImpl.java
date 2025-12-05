/*     */ package com.ecarx.xui.adaptapi.diminteraction;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.ECarXCarProxy;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import ecarx.dimprotocol.DIMProtocolManager;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DIMInteractionImpl
/*     */   extends DimInteraction
/*     */   implements IConnectable, ECarXCarProxy.ECarXCarProxyMethod
/*     */ {
/*  19 */   private static String TAG = "DIMInteractionImpl";
/*     */   
/*     */   private final ClimateInteraction mClimateInteraction;
/*     */   
/*     */   private final ContactsInteraction mContactsInteraction;
/*     */   
/*     */   private Context mContext;
/*     */   
/*     */   private final DimMenuInteraction mDimMenuInteraction;
/*     */   
/*     */   private DIMProtocolManager mDimProtocolManager;
/*     */   
/*     */   private final ECarXCarProxy mECarXCarProxy;
/*     */   
/*     */   private final CopyOnWriteArrayList<DimInteraction.IInteractionCallback> mInteractionCallbacks;
/*     */   
/*     */   private final MediaInteraction mMediaInteraction;
/*     */   private final NaviInteraction mNaviInteraction;
/*     */   private final PhoneCallInteraction mPhoneCallInteraction;
/*     */   private final VrInteraction mVrInteraction;
/*     */   
/*     */   public DIMInteractionImpl(Context paramContext) {
/*  41 */     this.mContext = paramContext;
/*  42 */     this.mDimProtocolManager = DIMProtocolManager.getInstance(paramContext);
/*  43 */     this.mClimateInteraction = new ClimateInteraction(paramContext);
/*  44 */     this.mContactsInteraction = new ContactsInteraction(paramContext);
/*  45 */     this.mMediaInteraction = new MediaInteraction(paramContext);
/*  46 */     this.mNaviInteraction = new NaviInteraction(paramContext);
/*  47 */     this.mDimMenuInteraction = new DimMenuInteraction(paramContext);
/*  48 */     this.mPhoneCallInteraction = new PhoneCallInteraction(paramContext);
/*  49 */     this.mVrInteraction = new VrInteraction(paramContext);
/*     */     
/*  51 */     this.mInteractionCallbacks = new CopyOnWriteArrayList<>();
/*     */     
/*  53 */     this.mECarXCarProxy = new ECarXCarProxy(paramContext, this);
/*  54 */     this.mECarXCarProxy.initECarXCar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IPhoneCallInteraction getPhoneCallInteraction() {
/*  63 */     return this.mPhoneCallInteraction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IContactsInteraction getContactsInteraction() {
/*  72 */     return this.mContactsInteraction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IMediaInteraction getMediaInteraction() {
/*  81 */     return this.mMediaInteraction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INaviInteraction getNaviInteraction() {
/*  90 */     return this.mNaviInteraction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IVrInteraction getVrInteraction() {
/*  99 */     return this.mVrInteraction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IClimateInteraction getClimateInteraction() {
/* 110 */     return this.mClimateInteraction;
/*     */   }
/*     */ 
/*     */   
/*     */   public IDimMenuInteraction getDimMenuInteraction() {
/* 115 */     return this.mDimMenuInteraction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSupportedRankingType() {
/* 126 */     return 0;
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
/*     */   public void updateAvgFuleRanking(int paramInt, String paramString) {
/*     */     try {
/*     */       StringBuilder stringBuilder;
/*     */       String str;
/* 142 */       CarSignalManager carSignalManager = this.mECarXCarProxy.getCarSignalManager();
/* 143 */       if (paramInt != 0) {
/* 144 */         str = TAG; stringBuilder = new StringBuilder(); this(); stringBuilder.append("updateAvgFuleRanking error type "); stringBuilder.append(paramInt); Log.e(str, stringBuilder.toString());
/*     */         return;
/*     */       } 
/* 147 */       paramInt = Integer.parseInt((String)stringBuilder);
/* 148 */       if (str != null) {
/* 149 */         str.setFuelCnsRanking(paramInt);
/*     */       }
/* 151 */     } catch (Exception exception) {
/* 152 */       exception.printStackTrace();
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
/*     */ 
/*     */   
/*     */   public void setPresentationToDimSwitch(int paramInt, String paramString1, String paramString2, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShowPresentationOption() {
/* 178 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerInteractionCallback(DimInteraction.IInteractionCallback paramIInteractionCallback) {
/* 189 */     if (!this.mInteractionCallbacks.contains(paramIInteractionCallback)) {
/* 190 */       this.mInteractionCallbacks.add(paramIInteractionCallback);
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
/*     */   public IVendorInteraction getVendorInteraction() {
/* 202 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterInteractionCallback(DimInteraction.IInteractionCallback paramIInteractionCallback) {
/* 212 */     this.mInteractionCallbacks.remove(paramIInteractionCallback);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceConnected(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/* 223 */     Log.i(TAG, "onECarXCarServiceConnected start ...");
/* 224 */     this.mClimateInteraction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 225 */     this.mContactsInteraction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 226 */     this.mMediaInteraction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 227 */     this.mNaviInteraction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 228 */     this.mPhoneCallInteraction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 229 */     this.mVrInteraction.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/* 230 */     Log.i(TAG, "onECarXCarServiceConnected done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onECarXCarServiceDeath() {
/* 238 */     Log.w(TAG, "onECarXCarServiceDeath start ...");
/* 239 */     this.mClimateInteraction.onECarXCarServiceDeath();
/* 240 */     this.mContactsInteraction.onECarXCarServiceDeath();
/* 241 */     this.mMediaInteraction.onECarXCarServiceDeath();
/* 242 */     this.mNaviInteraction.onECarXCarServiceDeath();
/* 243 */     this.mPhoneCallInteraction.onECarXCarServiceDeath();
/* 244 */     this.mVrInteraction.onECarXCarServiceDeath();
/* 245 */     Log.w(TAG, "onECarXCarServiceDeath done.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/* 255 */     this.mECarXCarProxy.registerConnectWatcher(paramIConnectWatcher);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/* 263 */     this.mECarXCarProxy.unregisterConnectWatcher();
/*     */   }
/*     */   
/*     */   public void connect() {}
/*     */   
/*     */   public void disconnect() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\DIMInteractionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */