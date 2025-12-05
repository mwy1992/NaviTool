/*     */ package android.car.hardware;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.car.hardware.property.CarPropertyManager;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.util.ArraySet;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public final class CarVendorExtensionManager
/*     */   implements CarManagerBase
/*     */ {
/*  46 */   private static final String TAG = CarVendorExtensionManager.class.getSimpleName();
/*     */   
/*     */   @GuardedBy("mLock")
/*  49 */   private final ArraySet<CarVendorExtensionCallback> mCallbacks = new ArraySet();
/*     */   
/*  51 */   private final Object mLock = new Object();
/*     */   @GuardedBy("mLock")
/*  53 */   private CarPropertyEventListenerToBase mListenerToBase = null;
/*     */   private static final boolean DBG = false;
/*     */   private final CarPropertyManager mPropertyManager;
/*     */   
/*     */   private void handleOnChangeEvent(CarPropertyValue paramCarPropertyValue) {
/*  58 */     synchronized (this.mLock) {
/*  59 */       ArrayList arrayList = new ArrayList(); this((Collection)this.mCallbacks);
/*     */       
/*  61 */       for (Object null : arrayList)
/*  62 */         null.onChangeEvent(paramCarPropertyValue); 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void handleOnErrorEvent(int paramInt1, int paramInt2) {
/*  68 */     synchronized (this.mLock) {
/*  69 */       ArrayList arrayList = new ArrayList(); this((Collection)this.mCallbacks);
/*     */       
/*  71 */       for (Object null : arrayList) {
/*  72 */         null.onErrorEvent(paramInt1, paramInt2);
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CarVendorExtensionManager(IBinder paramIBinder, Handler paramHandler) {
/*  84 */     this.mPropertyManager = new CarPropertyManager(paramIBinder, paramHandler, false, TAG);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerCallback(CarVendorExtensionCallback paramCarVendorExtensionCallback) throws CarNotConnectedException {
/* 105 */     synchronized (this.mLock) {
/* 106 */       if (this.mCallbacks.isEmpty()) {
/* 107 */         CarPropertyEventListenerToBase carPropertyEventListenerToBase = new CarPropertyEventListenerToBase(); this(this); this.mListenerToBase = carPropertyEventListenerToBase;
/*     */       } 
/*     */       
/* 110 */       List list = this.mPropertyManager.getPropertyList();
/* 111 */       for (CarPropertyConfig carPropertyConfig : list)
/*     */       {
/* 113 */         this.mPropertyManager.registerListener(this.mListenerToBase, carPropertyConfig.getPropertyId(), 0.0F);
/*     */       }
/* 115 */       this.mCallbacks.add(paramCarVendorExtensionCallback);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregisterCallback(CarVendorExtensionCallback paramCarVendorExtensionCallback) throws CarNotConnectedException {
/* 122 */     synchronized (this.mLock) {
/* 123 */       this.mCallbacks.remove(paramCarVendorExtensionCallback);
/* 124 */       List list = this.mPropertyManager.getPropertyList();
/* 125 */       for (CarPropertyConfig carPropertyConfig : list)
/*     */       {
/* 127 */         this.mPropertyManager.unregisterListener(this.mListenerToBase, carPropertyConfig.getPropertyId());
/*     */       }
/* 129 */       if (this.mCallbacks.isEmpty()) {
/* 130 */         this.mListenerToBase = null;
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<CarPropertyConfig> getProperties() throws CarNotConnectedException {
/* 137 */     return this.mPropertyManager.getPropertyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPropertyAvailable(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 146 */     return this.mPropertyManager.isPropertyAvailable(paramInt1, paramInt2);
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
/*     */   
/*     */   public <E> E getGlobalProperty(Class<E> paramClass, int paramInt) throws CarNotConnectedException {
/* 161 */     return getProperty(paramClass, paramInt, 0);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> E getProperty(Class<E> paramClass, int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 178 */     return this.mPropertyManager.getProperty(paramClass, paramInt1, paramInt2).getValue();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> void setGlobalProperty(Class<E> paramClass, int paramInt, E paramE) throws CarNotConnectedException {
/* 195 */     this.mPropertyManager.setProperty(paramClass, paramInt, 0, paramE);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> void setProperty(Class<E> paramClass, int paramInt1, int paramInt2, E paramE) throws CarNotConnectedException {
/* 214 */     this.mPropertyManager.setProperty(paramClass, paramInt1, paramInt2, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 220 */     this.mPropertyManager.onCarDisconnected();
/*     */   }
/*     */   
/*     */   private static class CarPropertyEventListenerToBase implements CarPropertyManager.CarPropertyEventListener {
/*     */     private final WeakReference<CarVendorExtensionManager> mManager;
/*     */     
/*     */     CarPropertyEventListenerToBase(CarVendorExtensionManager param1CarVendorExtensionManager) {
/* 227 */       this.mManager = new WeakReference<>(param1CarVendorExtensionManager);
/*     */     }
/*     */ 
/*     */     
/*     */     public void onChangeEvent(CarPropertyValue param1CarPropertyValue) {
/* 232 */       CarVendorExtensionManager carVendorExtensionManager = this.mManager.get();
/* 233 */       if (carVendorExtensionManager != null) {
/* 234 */         carVendorExtensionManager.handleOnChangeEvent(param1CarPropertyValue);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void onErrorEvent(int param1Int1, int param1Int2) {
/* 240 */       CarVendorExtensionManager carVendorExtensionManager = this.mManager.get();
/* 241 */       if (carVendorExtensionManager != null)
/* 242 */         carVendorExtensionManager.handleOnErrorEvent(param1Int1, param1Int2); 
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface CarVendorExtensionCallback {
/*     */     void onChangeEvent(CarPropertyValue param1CarPropertyValue);
/*     */     
/*     */     void onErrorEvent(int param1Int1, int param1Int2);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\CarVendorExtensionManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */