/*     */ package ecarx.car.hardware.property;
/*     */ 
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import ecarx.car.hardware.annotation.ApiResult;
/*     */ import ecarx.car.hardware.signal.SignalFilter;
/*     */ import java.io.Serializable;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
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
/*     */ public class ECarXCarPropertyManagerBase
/*     */ {
/*     */   private static final String TAG = "ECarXCarPropertyManagerBase";
/*     */   @GuardedBy("mLock")
/*     */   private ArrayList<CarPropertyEventCallback> mCallbacks;
/*     */   private final boolean mDbg;
/*     */   private final Handler mHandler;
/*     */   @GuardedBy("mLock")
/*     */   private IECarXCarPropertyEventListener mListenerToService;
/*  52 */   private final Object mLock = new Object();
/*     */ 
/*     */   
/*     */   private IECarXCarProperty mService;
/*     */ 
/*     */   
/*     */   private final String mTag;
/*     */ 
/*     */ 
/*     */   
/*     */   public ECarXCarPropertyManagerBase(IBinder paramIBinder, Handler paramHandler, boolean paramBoolean, String paramString) {
/*  63 */     this.mDbg = true;
/*  64 */     this.mTag = paramString;
/*  65 */     this.mService = IECarXCarProperty.Stub.asInterface(paramIBinder);
/*  66 */     this.mHandler = new EventCallbackHandler(this, paramHandler.getLooper());
/*  67 */     this.mCallbacks = new ArrayList<>();
/*  68 */     this.mListenerToService = new IECarXCarPropertyEventListener.Stub()
/*     */       {
/*     */         final ECarXCarPropertyManagerBase this$0;
/*     */         
/*     */         public void onEvent(List<ECarXCarPropertyEvent> param1List) {
/*  73 */           ECarXCarPropertyManagerBase.this.handleEvent(param1List);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerCallback(CarPropertyEventCallback paramCarPropertyEventCallback) throws CarNotConnectedException {
/*  82 */     synchronized (this.mLock) {
/*  83 */       if (!this.mCallbacks.contains(paramCarPropertyEventCallback)) {
/*     */ 
/*     */ 
/*     */         
/*  87 */         this.mCallbacks.add(paramCarPropertyEventCallback);
/*     */         return;
/*     */       } 
/*     */       IllegalStateException illegalStateException = new IllegalStateException();
/*     */       this("Callback is already registered.");
/*     */       throw illegalStateException;
/*     */     }  } public void registerSignals(SignalFilter paramSignalFilter) throws CarNotConnectedException {
/*     */     try {
/*  95 */       synchronized (this.mLock) {
/*  96 */         this.mService.registerListener(this.mListenerToService, paramSignalFilter); return;
/*     */       } 
/*  98 */     } catch (Exception exception) {
/*  99 */       Log.e("ECarXCarPropertyManagerBase", "Could not connect: ", exception);
/* 100 */       exception.printStackTrace();
/* 101 */       throw new CarNotConnectedException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregisterSignals(SignalFilter paramSignalFilter) throws CarNotConnectedException {
/*     */     try {
/* 108 */       synchronized (this.mLock) {
/* 109 */         this.mService.unregisterListener(this.mListenerToService, paramSignalFilter); return;
/*     */       } 
/* 111 */     } catch (Exception exception) {
/* 112 */       Log.e("ECarXCarPropertyManagerBase", "Could not connect: ", exception);
/* 113 */       exception.printStackTrace();
/* 114 */       throw new CarNotConnectedException(exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void unregisterCallback(CarPropertyEventCallback paramCarPropertyEventCallback) {
/* 119 */     synchronized (this.mLock) {
/* 120 */       if (this.mCallbacks.contains(paramCarPropertyEventCallback)) {
/* 121 */         this.mCallbacks.remove(paramCarPropertyEventCallback);
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
/*     */   public boolean getBooleanProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     boolean bool;
/* 134 */     ECarXCarPropertyValue<Boolean> eCarXCarPropertyValue = getProperty(Boolean.class, paramInt1, paramInt2);
/* 135 */     if (eCarXCarPropertyValue != null) { bool = ((Boolean)eCarXCarPropertyValue.getValue()).booleanValue(); } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getFloatProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     float f;
/* 145 */     ECarXCarPropertyValue<Float> eCarXCarPropertyValue = getProperty(Float.class, paramInt1, paramInt2);
/* 146 */     if (eCarXCarPropertyValue != null) { f = ((Float)eCarXCarPropertyValue.getValue()).floatValue(); } else { f = 0.0F; }  return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIntProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/* 156 */     ECarXCarPropertyValue<Integer> eCarXCarPropertyValue = getProperty(Integer.class, paramInt1, paramInt2);
/* 157 */     if (eCarXCarPropertyValue != null) { paramInt1 = ((Integer)eCarXCarPropertyValue.getValue()).intValue(); } else { paramInt1 = 0; }  return paramInt1;
/*     */   }
/*     */   public byte[] getBytesProperty(int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     Serializable serializable;
/* 161 */     ECarXCarPropertyValue<byte> eCarXCarPropertyValue = getProperty((Class)byte[].class, paramInt1, paramInt2);
/* 162 */     if (eCarXCarPropertyValue != null) { serializable = (Serializable)eCarXCarPropertyValue.getValue(); } else { serializable = Integer.valueOf(0); }  return (byte[])serializable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <E> ECarXCarPropertyValue<E> getProperty(Class<E> paramClass, int paramInt1, int paramInt2) throws CarNotConnectedException {
/*     */     try {
/*     */       StringBuilder stringBuilder;
/* 171 */       ECarXCarPropertyValue eCarXCarPropertyValue = this.mService.getProperty(paramInt1, paramInt2);
/* 172 */       if (eCarXCarPropertyValue != null && eCarXCarPropertyValue.getValue() != null) {
/* 173 */         Class<?> clazz = eCarXCarPropertyValue.getValue().getClass();
/* 174 */         if (clazz != paramClass) {
/* 175 */           IllegalArgumentException illegalArgumentException = new IllegalArgumentException(); stringBuilder = new StringBuilder(); this(); stringBuilder.append("Invalid property type. Expected: "); stringBuilder.append(paramClass); stringBuilder.append(", but was: "); stringBuilder.append(clazz); this(stringBuilder.toString()); throw illegalArgumentException;
/*     */         } 
/*     */       } 
/*     */       
/* 179 */       return (ECarXCarPropertyValue<E>)stringBuilder;
/* 180 */     } catch (Exception exception) {
/* 181 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getProperty failed with "); stringBuilder.append(exception.toString()); stringBuilder.append(", propId: 0x");
/* 182 */       stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x"); stringBuilder.append(Integer.toHexString(paramInt2)); String str = stringBuilder.toString(); Log.e("ECarXCarPropertyManagerBase", str, exception);
/* 183 */       exception.printStackTrace();
/* 184 */       throw new CarNotConnectedException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ECarXCarPropertyValue<?> getBaseProperty(int paramInt1, int paramInt2) {
/* 190 */     ECarXCarPropertyValue<?> eCarXCarPropertyValue = null;
/*     */     try {
/* 192 */       ECarXCarPropertyValue<?> eCarXCarPropertyValue1 = this.mService.getProperty(paramInt1, paramInt2);
/* 193 */     } catch (Exception exception) {
/* 194 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getProperty failed with "); stringBuilder.append(exception.toString()); stringBuilder.append(", propId: 0x");
/* 195 */       stringBuilder.append(Integer.toHexString(paramInt1)); stringBuilder.append(", area: 0x"); stringBuilder.append(Integer.toHexString(paramInt2)); String str = stringBuilder.toString(); Log.e("ECarXCarPropertyManagerBase", str, exception);
/* 196 */       exception.printStackTrace();
/*     */     } 
/* 198 */     return eCarXCarPropertyValue;
/*     */   }
/*     */   
/*     */   public <E> ApiResult setProperty(Class<E> paramClass, int paramInt1, int paramInt2, E paramE) {
/* 202 */     ApiResult apiResult = ApiResult.FAILED;
/*     */     try {
/* 204 */       IECarXCarProperty iECarXCarProperty = this.mService; ECarXCarPropertyValue eCarXCarPropertyValue = new ECarXCarPropertyValue(); this(paramInt1, paramInt2, paramE); iECarXCarProperty.setProperty(eCarXCarPropertyValue);
/* 205 */       ApiResult apiResult1 = ApiResult.SUCCEED;
/* 206 */     } catch (Exception exception) {
/* 207 */       exception.printStackTrace();
/* 208 */       apiResult = ApiResult.CARSIG_SERVICE_NOT_RUNNING;
/* 209 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setProperty failed with "); stringBuilder.append(exception.toString()); Log.e("ECarXCarPropertyManagerBase", stringBuilder.toString(), exception);
/*     */     } 
/* 211 */     return apiResult;
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
/*     */   public void setBooleanProperty(int paramInt1, int paramInt2, boolean paramBoolean) throws CarNotConnectedException {
/* 224 */     setProperty(Boolean.class, paramInt1, paramInt2, Boolean.valueOf(paramBoolean));
/*     */   }
/*     */   
/*     */   public void setFloatProperty(int paramInt1, int paramInt2, float paramFloat) throws CarNotConnectedException {
/* 228 */     setProperty(Float.class, paramInt1, paramInt2, Float.valueOf(paramFloat));
/*     */   }
/*     */   
/*     */   public ApiResult setIntProperty(int paramInt1, int paramInt2, int paramInt3) {
/* 232 */     return setProperty(Integer.class, paramInt1, paramInt2, Integer.valueOf(paramInt3));
/*     */   }
/*     */   
/*     */   public void setStringProperty(int paramInt1, int paramInt2, String paramString) {
/* 236 */     setProperty(String.class, paramInt1, paramInt2, paramString);
/*     */   }
/*     */   
/*     */   public void setbytesProperty(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
/* 240 */     setProperty((Class)byte[].class, paramInt1, paramInt2, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   private void dispatchEventToClient(ECarXCarPropertyEvent paramECarXCarPropertyEvent) {
/* 245 */     synchronized (this.mLock)
/*     */     { IllegalArgumentException illegalArgumentException;
/* 247 */       ArrayList<CarPropertyEventCallback> arrayList = this.mCallbacks;
/*     */       
/* 249 */       if (arrayList.isEmpty()) {
/* 250 */         Log.e("ECarXCarPropertyManagerBase", "Listener died, not dispatching event.");
/*     */         
/*     */         return;
/*     */       } 
/* 254 */       ECarXCarPropertyValue<?> eCarXCarPropertyValue = paramECarXCarPropertyEvent.getCarPropertyValue();
/* 255 */       switch (paramECarXCarPropertyEvent.getEventType())
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 267 */           illegalArgumentException = new IllegalArgumentException(); this(); throw illegalArgumentException;
/*     */         case 1:
/*     */           for (CarPropertyEventCallback carPropertyEventCallback : arrayList)
/*     */             carPropertyEventCallback.onErrorEvent(eCarXCarPropertyValue.getPropertyId(), eCarXCarPropertyValue.getAreaId());  break;
/*     */         case 0:
/*     */           for (CarPropertyEventCallback carPropertyEventCallback : arrayList)
/* 273 */             carPropertyEventCallback.onChangeEvent(eCarXCarPropertyValue);  break; }  return; }  } private void handleEvent(List<ECarXCarPropertyEvent> paramList) { this.mHandler.sendMessage(this.mHandler.obtainMessage(0, paramList)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/* 281 */     synchronized (this.mLock) {
/*     */       
/* 283 */       this.mCallbacks.clear();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface CarPropertyEventCallback
/*     */   {
/*     */     void onChangeEvent(ECarXCarPropertyValue param1ECarXCarPropertyValue);
/*     */ 
/*     */ 
/*     */     
/*     */     void onErrorEvent(int param1Int1, int param1Int2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface CarServiceDieCallback
/*     */   {
/*     */     void onServiceDied();
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class EventCallbackHandler
/*     */     extends Handler
/*     */   {
/*     */     private static final int MSG_GENERIC_EVENT = 0;
/*     */     
/*     */     private final WeakReference<ECarXCarPropertyManagerBase> mMgr;
/*     */ 
/*     */     
/*     */     EventCallbackHandler(ECarXCarPropertyManagerBase param1ECarXCarPropertyManagerBase, Looper param1Looper) {
/* 316 */       super(param1Looper);
/* 317 */       this.mMgr = new WeakReference<>(param1ECarXCarPropertyManagerBase);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 322 */       if (param1Message.what != 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 333 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Event type not handled:  "); stringBuilder.append(param1Message); Log.e("EventtCallbackHandler", stringBuilder.toString());
/*     */       } else {
/*     */         List list = (List)param1Message.obj;
/*     */         ECarXCarPropertyManagerBase eCarXCarPropertyManagerBase = this.mMgr.get();
/*     */         if (eCarXCarPropertyManagerBase != null)
/*     */           for (ECarXCarPropertyEvent eCarXCarPropertyEvent : list)
/*     */             eCarXCarPropertyManagerBase.dispatchEventToClient(eCarXCarPropertyEvent);  
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\property\ECarXCarPropertyManagerBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */