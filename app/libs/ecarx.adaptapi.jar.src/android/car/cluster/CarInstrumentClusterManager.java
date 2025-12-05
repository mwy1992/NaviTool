/*     */ package android.car.cluster;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.car.CarManagerBase;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import android.util.Pair;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class CarInstrumentClusterManager
/*     */   implements CarManagerBase
/*     */ {
/*  46 */   private static final String TAG = CarInstrumentClusterManager.class.getSimpleName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private final Map<String, Set<Callback>> mCallbacksByCategory = new HashMap<>(0);
/*  65 */   private final Object mLock = new Object();
/*  66 */   private final Map<String, Bundle> mActivityStatesByCategory = new HashMap<>(0);
/*     */   
/*     */   @SystemApi
/*     */   public static final String CATEGORY_NAVIGATION = "android.car.cluster.NAVIGATION";
/*     */   
/*     */   @SystemApi
/*     */   public static final String KEY_EXTRA_ACTIVITY_STATE = "android.car.cluster.ClusterActivityState";
/*     */   private final EventHandler mHandler;
/*     */   private final IInstrumentClusterManagerService mService;
/*     */   private ClusterManagerCallback mServiceToManagerCallback;
/*     */   
/*     */   @SystemApi
/*     */   public void startActivity(Intent paramIntent) throws CarNotConnectedException {
/*     */     try {
/*  80 */       this.mService.startClusterActivity(paramIntent); return;
/*  81 */     } catch (RemoteException remoteException) {
/*  82 */       throw new CarNotConnectedException(remoteException);
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
/*     */   
/*     */   @SystemApi
/*     */   public void registerCallback(String paramString, Callback paramCallback) throws CarNotConnectedException {
/*  99 */     String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerCallback, category: "); stringBuilder.append(paramString); stringBuilder.append(", callback: "); stringBuilder.append(paramCallback); Log.i(str, stringBuilder.toString());
/* 100 */     str = null;
/* 101 */     synchronized (this.mLock) {
/* 102 */       ClusterManagerCallback clusterManagerCallback; Set<Callback> set2 = this.mCallbacksByCategory.get(paramString);
/* 103 */       Set<Callback> set1 = set2; if (set2 == null) {
/* 104 */         set1 = new HashSet(); super(1);
/* 105 */         this.mCallbacksByCategory.put(paramString, set1);
/*     */       } 
/* 107 */       if (!set1.add(paramCallback)) {
/* 108 */         Log.w(TAG, "registerCallback: already registered");
/*     */         
/*     */         return;
/*     */       } 
/* 112 */       if (this.mActivityStatesByCategory.containsKey(paramString)) {
/* 113 */         Log.i(TAG, "registerCallback: sending activity state...");
/* 114 */         Map<String, Bundle> map = this.mActivityStatesByCategory;
/* 115 */         Bundle bundle = map.get(paramString);
/*     */         paramCallback.onClusterActivityStateChanged(paramString, bundle);
/*     */       } 
/* 118 */       paramString = str; if (this.mServiceToManagerCallback == null) {
/* 119 */         Log.i(TAG, "registerCallback: registering callback with car service...");
/* 120 */         clusterManagerCallback = new ClusterManagerCallback(); this(this); this.mServiceToManagerCallback = clusterManagerCallback;
/* 121 */         clusterManagerCallback = this.mServiceToManagerCallback;
/*     */       } 
/*     */       
/*     */       try {
/* 125 */         this.mService.registerCallback(clusterManagerCallback);
/* 126 */         Log.i(TAG, "registerCallback: done"); return;
/* 127 */       } catch (RemoteException remoteException) {
/* 128 */         throw new CarNotConnectedException(remoteException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public void unregisterCallback(Callback paramCallback) throws CarNotConnectedException
/*     */   {
/* 141 */     ArrayList<String> arrayList = new ArrayList(1);
/* 142 */     synchronized (this.mLock) {
/* 143 */       for (Map.Entry<String, Set<Callback>> entry : this.mCallbacksByCategory.entrySet()) {
/* 144 */         Set set = (Set)entry.getValue();
/* 145 */         if (set.remove(paramCallback) && set.isEmpty()) {
/* 146 */           arrayList.add((String)entry.getKey());
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 151 */       for (String str : arrayList) {
/* 152 */         this.mCallbacksByCategory.remove(str);
/*     */       }
/*     */       
/* 155 */       boolean bool = this.mCallbacksByCategory.isEmpty(); if (bool)
/*     */         try {
/* 157 */           this.mService.unregisterCallback(this.mServiceToManagerCallback);
/*     */ 
/*     */ 
/*     */           
/* 161 */           this.mServiceToManagerCallback = null;
/*     */         } catch (RemoteException remoteException) {
/*     */           CarNotConnectedException carNotConnectedException = new CarNotConnectedException();
/*     */           this((Exception)remoteException);
/*     */           throw carNotConnectedException;
/*     */         }  
/*     */       return;
/* 168 */     }  } public CarInstrumentClusterManager(IBinder paramIBinder, Handler paramHandler) { this.mService = IInstrumentClusterManagerService.Stub.asInterface(paramIBinder);
/*     */     
/* 170 */     this.mHandler = new EventHandler(paramHandler.getLooper()); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class EventHandler
/*     */     extends Handler
/*     */   {
/*     */     static final int MSG_ACTIVITY_STATE = 1;
/*     */ 
/*     */ 
/*     */     
/*     */     final CarInstrumentClusterManager this$0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     EventHandler(Looper param1Looper) {
/* 196 */       super(param1Looper);
/*     */     }
/*     */     
/*     */     public void handleMessage(Message param1Message)
/*     */     {
/* 201 */       String str = CarInstrumentClusterManager.TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("handleMessage, message: "); stringBuilder.append(param1Message); Log.i(str, stringBuilder.toString());
/* 202 */       if (param1Message.what != 1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 221 */         String str1 = CarInstrumentClusterManager.TAG; StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("Unexpected message: "); stringBuilder1.append(param1Message.what); Log.e(str1, stringBuilder1.toString());
/*     */       } else {
/*     */         null = (Pair)param1Message.obj; String str1 = (String)null.first; Bundle bundle = (Bundle)null.second; null = null; synchronized (CarInstrumentClusterManager.this.mLock) {
/*     */           ArrayList arrayList; if (CarInstrumentClusterManager.this.mCallbacksByCategory.containsKey(str1)) {
/*     */             arrayList = new ArrayList(); this((Collection<? extends E>)CarInstrumentClusterManager.this.mCallbacksByCategory.get(str1));
/*     */           }  String str2 = CarInstrumentClusterManager.TAG; null = new StringBuilder(); null.append("handleMessage, callbacks: "); null.append(arrayList); Log.i(str2, null.toString()); if (arrayList != null)
/*     */             for (Object null : arrayList)
/*     */               null.onClusterActivityStateChanged(str1, bundle);  
/*     */           return;
/*     */         } 
/* 231 */       }  } } private class ClusterManagerCallback extends IInstrumentClusterManagerCallback.Stub { public void setClusterActivityState(String param1String, Bundle param1Bundle) throws RemoteException { String str = CarInstrumentClusterManager.TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setClusterActivityState, category: "); stringBuilder.append(param1String); Log.i(str, stringBuilder.toString());
/* 232 */       synchronized (CarInstrumentClusterManager.this.mLock) {
/* 233 */         CarInstrumentClusterManager.this.mActivityStatesByCategory.put(param1String, param1Bundle);
/*     */ 
/*     */         
/* 236 */         CarInstrumentClusterManager.this.mHandler.sendMessage(CarInstrumentClusterManager.this.mHandler.obtainMessage(1, new Pair(param1String, param1Bundle)));
/*     */         return;
/*     */       }  }
/*     */ 
/*     */     
/*     */     final CarInstrumentClusterManager this$0;
/*     */     
/*     */     private ClusterManagerCallback() {} }
/*     */ 
/*     */   
/*     */   @SystemApi
/*     */   public static interface Callback {
/*     */     void onClusterActivityStateChanged(String param1String, Bundle param1Bundle);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\CarInstrumentClusterManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */