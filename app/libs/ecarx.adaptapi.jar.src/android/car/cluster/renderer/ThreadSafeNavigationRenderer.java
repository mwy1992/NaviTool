/*     */ package android.car.cluster.renderer;
/*     */ 
/*     */ import android.car.navigation.CarNavigationInstrumentCluster;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ThreadSafeNavigationRenderer
/*     */   extends NavigationRenderer
/*     */ {
/*     */   private static final int MSG_EVENT = 1;
/*     */   private final Handler mHandler;
/*     */   private final NavigationRenderer mRenderer;
/*     */   
/*     */   static NavigationRenderer createFor(Looper paramLooper, NavigationRenderer paramNavigationRenderer) {
/*     */     ThreadSafeNavigationRenderer threadSafeNavigationRenderer;
/*  44 */     if (paramNavigationRenderer == null) { paramLooper = null; } else { threadSafeNavigationRenderer = new ThreadSafeNavigationRenderer(paramLooper, paramNavigationRenderer); }  return threadSafeNavigationRenderer;
/*     */   }
/*     */   
/*     */   private ThreadSafeNavigationRenderer(Looper paramLooper, NavigationRenderer paramNavigationRenderer) {
/*  48 */     this.mRenderer = paramNavigationRenderer;
/*  49 */     this.mHandler = new NavigationRendererHandler(paramLooper, paramNavigationRenderer);
/*     */   }
/*     */ 
/*     */   
/*     */   public CarNavigationInstrumentCluster getNavigationProperties() {
/*  54 */     if (this.mHandler.getLooper() == Looper.myLooper()) {
/*  55 */       return this.mRenderer.getNavigationProperties();
/*     */     }
/*  57 */     return runAndWaitResult(this.mHandler, new RunnableWithResult<CarNavigationInstrumentCluster>() {
/*     */           final ThreadSafeNavigationRenderer this$0;
/*     */           
/*     */           protected CarNavigationInstrumentCluster createResult() {
/*  61 */             return ThreadSafeNavigationRenderer.this.mRenderer.getNavigationProperties();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEvent(int paramInt, Bundle paramBundle) {
/*  69 */     this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt, 0, paramBundle));
/*     */   }
/*     */   
/*     */   private static class NavigationRendererHandler
/*     */     extends RendererHandler<NavigationRenderer> {
/*     */     NavigationRendererHandler(Looper param1Looper, NavigationRenderer param1NavigationRenderer) {
/*  75 */       super(param1Looper, param1NavigationRenderer);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message, NavigationRenderer param1NavigationRenderer) {
/*  80 */       if (param1Message.what == 1) {
/*     */         
/*  82 */         Bundle bundle = (Bundle)param1Message.obj;
/*  83 */         param1NavigationRenderer.onEvent(param1Message.arg1, bundle);
/*     */         return;
/*     */       } 
/*  86 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Msg: "); stringBuilder.append(param1Message.what); throw new IllegalArgumentException(stringBuilder.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static <E> E runAndWaitResult(Handler paramHandler, final RunnableWithResult<E> runnable) {
/*  92 */     final CountDownLatch latch = new CountDownLatch(1);
/*     */     
/*  94 */     Runnable runnable = new Runnable() { final CountDownLatch val$latch; final ThreadSafeNavigationRenderer.RunnableWithResult val$runnable;
/*     */         
/*     */         public void run() {
/*  97 */           runnable.run();
/*  98 */           latch.countDown();
/*     */         } }
/*     */       ;
/*     */     
/* 102 */     paramHandler.post(runnable);
/*     */     
/*     */     try {
/* 105 */       countDownLatch.await();
/*     */ 
/*     */ 
/*     */       
/* 109 */       return runnable.getResult();
/*     */     } catch (InterruptedException interruptedException) {
/*     */       throw new RuntimeException(interruptedException);
/*     */     } 
/*     */   }
/*     */   private static abstract class RunnableWithResult<T> implements Runnable { private volatile T result;
/*     */     
/*     */     private RunnableWithResult() {}
/*     */     
/*     */     public void run() {
/* 119 */       this.result = createResult();
/*     */     }
/*     */     
/*     */     public T getResult() {
/* 123 */       return this.result;
/*     */     }
/*     */     
/*     */     protected abstract T createResult(); }
/*     */   
/*     */   private static abstract class RendererHandler<T> extends Handler {
/*     */     private final WeakReference<T> mRendererRef;
/*     */     
/*     */     RendererHandler(Looper param1Looper, T param1T) {
/* 132 */       super(param1Looper);
/* 133 */       this.mRendererRef = new WeakReference<>(param1T);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 138 */       T t = this.mRendererRef.get();
/* 139 */       if (t != null)
/* 140 */         handleMessage(param1Message, t); 
/*     */     }
/*     */     
/*     */     public abstract void handleMessage(Message param1Message, T param1T);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\ThreadSafeNavigationRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */