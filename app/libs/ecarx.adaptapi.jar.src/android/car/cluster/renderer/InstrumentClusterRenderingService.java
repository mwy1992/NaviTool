/*     */ package android.car.cluster.renderer;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.app.ActivityOptions;
/*     */ import android.app.Service;
/*     */ import android.car.CarNotConnectedException;
/*     */ import android.car.navigation.CarNavigationInstrumentCluster;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import android.util.Pair;
/*     */ import android.view.KeyEvent;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import java.io.FileDescriptor;
/*     */ import java.io.PrintWriter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public abstract class InstrumentClusterRenderingService
/*     */   extends Service
/*     */ {
/*     */   public static final String EXTRA_KEY_CALLBACK_SERVICE = "android.car.cluster.IInstrumentClusterCallback";
/*     */   private static final String TAG = "CAR.L.CLUSTER";
/*     */   @GuardedBy("mLock")
/*     */   private IInstrumentClusterCallback mCallback;
/*  70 */   private final Object mLock = new Object();
/*     */ 
/*     */   
/*     */   private RendererBinder mRendererBinder;
/*     */ 
/*     */   
/*     */   public IBinder onBind(Intent paramIntent) {
/*  77 */     if (Log.isLoggable("CAR.L.CLUSTER", 3)) {
/*  78 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onBind, intent: "); stringBuilder.append(paramIntent); Log.d("CAR.L.CLUSTER", stringBuilder.toString());
/*     */     } 
/*     */     
/*  81 */     if (paramIntent.getExtras().containsKey("android.car.cluster.IInstrumentClusterCallback")) {
/*  82 */       null = paramIntent.getExtras().getBinder("android.car.cluster.IInstrumentClusterCallback");
/*  83 */       synchronized (this.mLock) {
/*  84 */         this.mCallback = IInstrumentClusterCallback.Stub.asInterface(null);
/*     */       } 
/*     */     } else {
/*  87 */       Log.w("CAR.L.CLUSTER", "onBind, no callback in extra!");
/*     */     } 
/*     */     
/*  90 */     if (this.mRendererBinder == null) {
/*  91 */       this.mRendererBinder = new RendererBinder(getNavigationRenderer());
/*     */     }
/*     */     
/*  94 */     return (IBinder)this.mRendererBinder;
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
/*     */   protected void onKeyEvent(KeyEvent paramKeyEvent) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClusterActivityLaunchOptions(String paramString, ActivityOptions paramActivityOptions) throws CarNotConnectedException {
/* 120 */     synchronized (this.mLock) {
/* 121 */       IInstrumentClusterCallback iInstrumentClusterCallback = this.mCallback;
/*     */       
/* 123 */       if (iInstrumentClusterCallback != null) {
/*     */         try {
/* 125 */           iInstrumentClusterCallback.setClusterActivityLaunchOptions(paramString, paramActivityOptions.toBundle()); return;
/* 126 */         } catch (RemoteException remoteException) {
/* 127 */           throw new CarNotConnectedException(remoteException);
/*     */         } 
/*     */       }
/*     */       throw new CarNotConnectedException();
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
/*     */   public void setClusterActivityState(String paramString, Bundle paramBundle) throws CarNotConnectedException {
/* 145 */     synchronized (this.mLock) {
/* 146 */       IInstrumentClusterCallback iInstrumentClusterCallback = this.mCallback;
/*     */       
/* 148 */       if (iInstrumentClusterCallback != null)
/*     */         try {
/* 150 */           iInstrumentClusterCallback.setClusterActivityState(paramString, paramBundle); return;
/* 151 */         } catch (RemoteException remoteException) {
/* 152 */           throw new CarNotConnectedException(remoteException);
/*     */         }  
/*     */       throw new CarNotConnectedException();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
/* 159 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("**"); stringBuilder.append(getClass().getSimpleName()); stringBuilder.append("**"); paramPrintWriter.println(stringBuilder.toString());
/* 160 */     stringBuilder = new StringBuilder(); stringBuilder.append("renderer binder: "); stringBuilder.append(this.mRendererBinder); paramPrintWriter.println(stringBuilder.toString());
/* 161 */     if (this.mRendererBinder != null) {
/* 162 */       stringBuilder = new StringBuilder(); stringBuilder.append("navigation renderer: "); stringBuilder.append(this.mRendererBinder.mNavigationRenderer); paramPrintWriter.println(stringBuilder.toString());
/* 163 */       null = "none";
/* 164 */       synchronized (this.mLock) {
/* 165 */         String str; if (this.mRendererBinder.mNavContextOwner != null) {
/* 166 */           StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("[uid: "); stringBuilder1.append(this.mRendererBinder.mNavContextOwner.first); stringBuilder1.append(", pid: "); RendererBinder rendererBinder = this.mRendererBinder;
/* 167 */           stringBuilder1.append(rendererBinder.mNavContextOwner.second); stringBuilder1.append("]"); str = stringBuilder1.toString();
/*     */         } 
/*     */         
/* 170 */         null = new StringBuilder(); null.append("navigation focus owner: "); null.append(str); paramPrintWriter.println(null.toString());
/*     */       } 
/*     */     } 
/* 173 */     synchronized (this.mLock) {
/* 174 */       IInstrumentClusterCallback iInstrumentClusterCallback = this.mCallback;
/*     */       
/* 176 */       null = new StringBuilder(); null.append("callback: "); null.append(iInstrumentClusterCallback); paramPrintWriter.println(null.toString());
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract NavigationRenderer getNavigationRenderer();
/*     */   
/*     */   private class RendererBinder extends IInstrumentCluster.Stub {
/*     */     @GuardedBy("mLock")
/*     */     private Pair<Integer, Integer> mNavContextOwner;
/*     */     @GuardedBy("mLock")
/*     */     private InstrumentClusterRenderingService.NavigationBinder mNavigationBinder;
/*     */     
/*     */     RendererBinder(NavigationRenderer param1NavigationRenderer) {
/* 190 */       this.mNavigationRenderer = param1NavigationRenderer;
/* 191 */       this.mUiHandler = new InstrumentClusterRenderingService.UiHandler(InstrumentClusterRenderingService.this);
/*     */     }
/*     */     private final NavigationRenderer mNavigationRenderer; private final InstrumentClusterRenderingService.UiHandler mUiHandler; final InstrumentClusterRenderingService this$0;
/*     */     
/*     */     public IInstrumentClusterNavigation getNavigationService() throws RemoteException {
/* 196 */       synchronized (InstrumentClusterRenderingService.this.mLock) {
/* 197 */         if (this.mNavigationBinder == null) {
/* 198 */           InstrumentClusterRenderingService.NavigationBinder navigationBinder = new InstrumentClusterRenderingService.NavigationBinder(); this(this.mNavigationRenderer); this.mNavigationBinder = navigationBinder;
/* 199 */           if (this.mNavContextOwner != null) {
/* 200 */             InstrumentClusterRenderingService.NavigationBinder navigationBinder1 = this.mNavigationBinder; Integer integer = (Integer)this.mNavContextOwner.first;
/* 201 */             int i = integer.intValue(), j = ((Integer)this.mNavContextOwner.second).intValue(); navigationBinder1.setNavigationContextOwner(i, j);
/*     */           } 
/*     */         } 
/* 204 */         return this.mNavigationBinder;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void setNavigationContextOwner(int param1Int1, int param1Int2) throws RemoteException {
/* 210 */       synchronized (InstrumentClusterRenderingService.this.mLock) {
/* 211 */         Pair<Integer, Integer> pair = new Pair(); this(Integer.valueOf(param1Int1), Integer.valueOf(param1Int2)); this.mNavContextOwner = pair;
/* 212 */         if (this.mNavigationBinder != null) {
/* 213 */           this.mNavigationBinder.setNavigationContextOwner(param1Int1, param1Int2);
/*     */         }
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onKeyEvent(KeyEvent param1KeyEvent) throws RemoteException {
/* 220 */       this.mUiHandler.doKeyEvent(param1KeyEvent);
/*     */     }
/*     */   }
/*     */   
/*     */   private class NavigationBinder
/*     */     extends IInstrumentClusterNavigation.Stub
/*     */   {
/*     */     private volatile Pair<Integer, Integer> mNavContextOwner;
/*     */     private final NavigationRenderer mNavigationRenderer;
/*     */     final InstrumentClusterRenderingService this$0;
/*     */     
/*     */     NavigationBinder(NavigationRenderer param1NavigationRenderer) {
/* 232 */       Looper looper = Looper.getMainLooper();
/*     */       this.mNavigationRenderer = ThreadSafeNavigationRenderer.createFor(looper, param1NavigationRenderer);
/*     */     }
/*     */     
/*     */     void setNavigationContextOwner(int param1Int1, int param1Int2) {
/* 237 */       this.mNavContextOwner = new Pair(Integer.valueOf(param1Int1), Integer.valueOf(param1Int2));
/*     */     }
/*     */ 
/*     */     
/*     */     public void onEvent(int param1Int, Bundle param1Bundle) throws RemoteException {
/* 242 */       assertContextOwnership();
/* 243 */       this.mNavigationRenderer.onEvent(param1Int, param1Bundle);
/*     */     }
/*     */ 
/*     */     
/*     */     public CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException {
/* 248 */       return this.mNavigationRenderer.getNavigationProperties();
/*     */     }
/*     */     
/*     */     private void assertContextOwnership() {
/* 252 */       int i = getCallingUid();
/* 253 */       int j = getCallingPid();
/*     */       
/* 255 */       Pair<Integer, Integer> pair = this.mNavContextOwner;
/* 256 */       if (pair != null && ((Integer)pair.first).intValue() == i && ((Integer)pair.second).intValue() == j)
/* 257 */         return;  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Client (uid:"); stringBuilder.append(i); stringBuilder.append(", pid: "); stringBuilder.append(j); stringBuilder.append(") is not an owner of APP_FOCUS_TYPE_NAVIGATION"); throw new IllegalStateException(stringBuilder.toString());
/*     */     }
/*     */   }
/*     */   
/*     */   private static class UiHandler
/*     */     extends Handler
/*     */   {
/* 264 */     private static int KEY_EVENT = 0;
/*     */     private final WeakReference<InstrumentClusterRenderingService> mRefService;
/*     */     
/*     */     UiHandler(InstrumentClusterRenderingService param1InstrumentClusterRenderingService) {
/* 268 */       this.mRefService = new WeakReference<>(param1InstrumentClusterRenderingService);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 273 */       InstrumentClusterRenderingService instrumentClusterRenderingService = this.mRefService.get();
/* 274 */       if (instrumentClusterRenderingService == null) {
/*     */         return;
/*     */       }
/*     */       
/* 278 */       if (param1Message.what == KEY_EVENT) {
/* 279 */         instrumentClusterRenderingService.onKeyEvent((KeyEvent)param1Message.obj); return;
/*     */       } 
/* 281 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Unexpected message: "); stringBuilder.append(param1Message); throw new IllegalArgumentException(stringBuilder.toString());
/*     */     }
/*     */ 
/*     */     
/*     */     void doKeyEvent(KeyEvent param1KeyEvent) {
/* 286 */       sendMessage(obtainMessage(KEY_EVENT, param1KeyEvent));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\InstrumentClusterRenderingService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */