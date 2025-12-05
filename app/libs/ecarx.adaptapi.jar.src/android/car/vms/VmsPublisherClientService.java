/*     */ package android.car.vms;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.app.Service;
/*     */ import android.content.Intent;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import java.lang.ref.WeakReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class VmsPublisherClientService
/*     */   extends Service
/*     */ {
/*  54 */   private final Object mLock = new Object();
/*     */   
/*  56 */   private Handler mHandler = new VmsEventHandler(this);
/*  57 */   private final VmsPublisherClientBinder mVmsPublisherClient = new VmsPublisherClientBinder(this);
/*  58 */   private volatile IVmsPublisherService mVmsPublisherService = null; @GuardedBy("mLock")
/*  59 */   private IBinder mToken = null;
/*     */   
/*     */   private static final boolean DBG = true;
/*     */   private static final String TAG = "VmsPublisherClient";
/*     */   
/*     */   public IBinder onBind(Intent paramIntent) {
/*  65 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onBind, intent: "); stringBuilder.append(paramIntent); Log.d("VmsPublisherClient", stringBuilder.toString());
/*     */     
/*  67 */     return this.mVmsPublisherClient.asBinder();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onUnbind(Intent paramIntent) {
/*  73 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onUnbind, intent: "); stringBuilder.append(paramIntent); Log.d("VmsPublisherClient", stringBuilder.toString());
/*     */     
/*  75 */     stopSelf();
/*  76 */     return super.onUnbind(paramIntent);
/*     */   }
/*     */   
/*     */   private void setToken(IBinder paramIBinder) {
/*  80 */     synchronized (this.mLock) {
/*  81 */       this.mToken = paramIBinder;
/*     */       return;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void publish(VmsLayer paramVmsLayer, int paramInt, byte[] paramArrayOfbyte) {
/* 108 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Publishing for layer : "); stringBuilder.append(paramVmsLayer); Log.d("VmsPublisherClient", stringBuilder.toString());
/*     */ 
/*     */     
/* 111 */     IBinder iBinder = getTokenForPublisherServiceThreadSafe();
/*     */     
/*     */     try {
/* 114 */       this.mVmsPublisherService.publish(iBinder, paramVmsLayer, paramInt, paramArrayOfbyte);
/* 115 */     } catch (RemoteException remoteException) {
/* 116 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("unable to publish message: "); stringBuilder1.append(paramArrayOfbyte); Log.e("VmsPublisherClient", stringBuilder1.toString(), (Throwable)remoteException);
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
/*     */   public final void setLayersOffering(VmsLayersOffering paramVmsLayersOffering) {
/* 128 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Setting layers offering : "); stringBuilder.append(paramVmsLayersOffering); Log.d("VmsPublisherClient", stringBuilder.toString());
/*     */ 
/*     */     
/* 131 */     IBinder iBinder = getTokenForPublisherServiceThreadSafe();
/*     */     
/*     */     try {
/* 134 */       this.mVmsPublisherService.setLayersOffering(iBinder, paramVmsLayersOffering);
/* 135 */       VmsOperationRecorder.get().setLayersOffering(paramVmsLayersOffering);
/* 136 */     } catch (RemoteException remoteException) {
/* 137 */       StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("unable to set layers offering: "); stringBuilder1.append(paramVmsLayersOffering); Log.e("VmsPublisherClient", stringBuilder1.toString(), (Throwable)remoteException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private IBinder getTokenForPublisherServiceThreadSafe() {
/* 142 */     if (this.mVmsPublisherService != null)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 147 */       synchronized (this.mLock) {
/* 148 */         IBinder iBinder = this.mToken;
/*     */         
/* 150 */         if (iBinder != null)
/*     */         {
/*     */           
/* 153 */           return iBinder; } 
/*     */         throw new IllegalStateException("VmsPublisherService does not have a valid token.");
/*     */       }  } 
/*     */     throw new IllegalStateException("VmsPublisherService not set."); } public final int getPublisherId(byte[] paramArrayOfbyte) {
/* 157 */     if (this.mVmsPublisherService != null) {
/*     */ 
/*     */       
/* 160 */       RemoteException remoteException2 = null;
/*     */       try {
/* 162 */         Log.i("VmsPublisherClient", "Getting publisher static ID");
/* 163 */         int i = this.mVmsPublisherService.getPublisherId(paramArrayOfbyte); Integer integer = Integer.valueOf(i);
/* 164 */       } catch (RemoteException remoteException1) {
/* 165 */         Log.e("VmsPublisherClient", "unable to invoke binder method.", (Throwable)remoteException1); remoteException1 = remoteException2;
/*     */       } 
/* 167 */       if (remoteException1 != null) {
/*     */ 
/*     */         
/* 170 */         VmsOperationRecorder.get().getPublisherId(remoteException1.intValue());
/*     */         
/* 172 */         return remoteException1.intValue();
/*     */       } 
/*     */       throw new IllegalStateException("VmsPublisherService cannot get a publisher static ID.");
/*     */     } 
/*     */     throw new IllegalStateException("VmsPublisherService not set.");
/*     */   }
/*     */ 
/*     */   
/*     */   public final VmsSubscriptionState getSubscriptions() {
/* 181 */     if (this.mVmsPublisherService != null)
/*     */       
/*     */       try {
/*     */         
/* 185 */         return this.mVmsPublisherService.getSubscriptions();
/* 186 */       } catch (RemoteException remoteException) {
/* 187 */         Log.e("VmsPublisherClient", "unable to invoke binder method.", (Throwable)remoteException);
/*     */         
/* 189 */         return null;
/*     */       }  
/*     */     throw new IllegalStateException("VmsPublisherService not set.");
/*     */   } private void setVmsPublisherService(IVmsPublisherService paramIVmsPublisherService) {
/* 193 */     this.mVmsPublisherService = paramIVmsPublisherService;
/* 194 */     onVmsPublisherServiceReady();
/*     */   }
/*     */   
/*     */   protected abstract void onVmsPublisherServiceReady();
/*     */   
/*     */   public abstract void onVmsSubscriptionChange(VmsSubscriptionState paramVmsSubscriptionState);
/*     */   
/*     */   private static class VmsPublisherClientBinder extends IVmsPublisherClient.Stub { @GuardedBy("mSequenceLock")
/* 202 */     private long mSequence = -1L;
/*     */     
/* 204 */     private final Object mSequenceLock = new Object(); private final WeakReference<VmsPublisherClientService> mVmsPublisherClientService;
/*     */     
/*     */     public VmsPublisherClientBinder(VmsPublisherClientService param1VmsPublisherClientService) {
/* 207 */       this.mVmsPublisherClientService = new WeakReference<>(param1VmsPublisherClientService);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void setVmsPublisherService(IBinder param1IBinder, IVmsPublisherService param1IVmsPublisherService) throws RemoteException {
/* 213 */       VmsPublisherClientService vmsPublisherClientService = this.mVmsPublisherClientService.get();
/* 214 */       if (vmsPublisherClientService == null)
/*     */         return; 
/* 216 */       Log.d("VmsPublisherClient", "setting VmsPublisherService.");
/*     */       
/* 218 */       Handler handler = vmsPublisherClientService.mHandler;
/*     */       
/* 220 */       Message message = handler.obtainMessage(1, param1IVmsPublisherService); handler.sendMessage(message);
/* 221 */       vmsPublisherClientService.setToken(param1IBinder);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void onVmsSubscriptionChange(VmsSubscriptionState param1VmsSubscriptionState) throws RemoteException {
/* 227 */       VmsPublisherClientService vmsPublisherClientService = this.mVmsPublisherClientService.get();
/* 228 */       if (vmsPublisherClientService == null)
/*     */         return; 
/* 230 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("subscription event: "); stringBuilder.append(param1VmsSubscriptionState); Log.d("VmsPublisherClient", stringBuilder.toString());
/*     */       
/* 232 */       synchronized (this.mSequenceLock) {
/* 233 */         String str; StringBuilder stringBuilder1; if (param1VmsSubscriptionState.getSequenceNumber() <= this.mSequence) {
/* 234 */           stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("Sequence out of order. Current sequence = "); stringBuilder1.append(this.mSequence); stringBuilder1.append("; expected new sequence = ");
/* 235 */           stringBuilder1.append(param1VmsSubscriptionState.getSequenceNumber()); str = stringBuilder1.toString();
/*     */           Log.w("VmsPublisherClient", str);
/*     */           return;
/*     */         } 
/* 239 */         this.mSequence = str.getSequenceNumber();
/*     */ 
/*     */         
/* 242 */         null = ((VmsPublisherClientService)stringBuilder1).mHandler;
/*     */         
/* 244 */         Message message = null.obtainMessage(0, str);
/*     */         null.sendMessage(message);
/*     */         return;
/*     */       } 
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class VmsEventHandler
/*     */     extends Handler
/*     */   {
/*     */     private static final int ON_SUBSCRIPTION_CHANGE_EVENT = 0;
/*     */     private static final int SET_SERVICE_CALLBACK = 1;
/*     */     private final WeakReference<VmsPublisherClientService> mVmsPublisherClientService;
/*     */     
/*     */     VmsEventHandler(VmsPublisherClientService param1VmsPublisherClientService) {
/* 260 */       super(Looper.getMainLooper());
/* 261 */       this.mVmsPublisherClientService = new WeakReference<>(param1VmsPublisherClientService);
/*     */     }
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/*     */       StringBuilder stringBuilder;
/* 266 */       VmsPublisherClientService vmsPublisherClientService = this.mVmsPublisherClientService.get();
/* 267 */       if (vmsPublisherClientService == null)
/* 268 */         return;  switch (param1Message.what) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 277 */           stringBuilder = new StringBuilder(); stringBuilder.append("Event type not handled:  "); stringBuilder.append(param1Message.what); Log.e("VmsPublisherClient", stringBuilder.toString());
/*     */           return;
/*     */         case 1:
/*     */           stringBuilder.setVmsPublisherService((IVmsPublisherService)param1Message.obj);
/*     */           return;
/*     */         case 0:
/*     */           break;
/*     */       } 
/*     */       VmsSubscriptionState vmsSubscriptionState = (VmsSubscriptionState)param1Message.obj;
/*     */       stringBuilder.onVmsSubscriptionChange(vmsSubscriptionState);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsPublisherClientService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */