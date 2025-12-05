/*     */ package com.ecarx.xui.adaptapi.uiinteraction;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.IInputDispatcherService;
/*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.util.Log;
/*     */ import android.view.IEcarxTouchListener;
/*     */ import android.view.MotionEvent;
/*     */ import android.view.View;
/*     */ 
/*     */ public class TouchManagerImpl
/*     */   implements ITouchManager {
/*     */   private static final int CLIENT_XCMASCOT = 0;
/*     */   private static final int MSG_MOTION_EVENT = 1;
/*     */   private static final String TAG = "TouchManagerImpl";
/*     */   private static TouchManagerImpl sTouchManagerImpl;
/*     */   private View.OnTouchListener mCallback;
/*     */   private Context mContext;
/*     */   private DispatchHandler mDispatchHandler;
/*     */   private IInputDispatcherService mService;
/*     */   private TouchListener mTouchListener;
/*     */   
/*     */   public TouchManagerImpl(Context paramContext) {
/*  30 */     this.mContext = paramContext;
/*  31 */     this.mTouchListener = new TouchListener();
/*  32 */     HandlerThread handlerThread = new HandlerThread("ecarx_monitor_touch:c");
/*  33 */     handlerThread.start();
/*  34 */     this.mDispatchHandler = new DispatchHandler(handlerThread.getLooper());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerFullScreenTouchListener(int paramInt, View.OnTouchListener paramOnTouchListener) {
/*  45 */     if (!getSplitScreenService()) {
/*  46 */       Log.i("TouchManagerImpl", "EcarxInputDispatcherService didnt start");
/*  47 */       return false;
/*     */     } 
/*  49 */     if (paramOnTouchListener == null) {
/*  50 */       Log.e("TouchManagerImpl", "listener cant be null");
/*  51 */       return false;
/*     */     } 
/*  53 */     boolean bool = false;
/*     */     try {
/*  55 */       boolean bool1 = this.mService.registerTouchEventListener((IEcarxTouchListener)this.mTouchListener, 0);
/*  56 */     } catch (RemoteException remoteException) {
/*  57 */       remoteException.printStackTrace();
/*     */     } 
/*  59 */     if (bool) {
/*  60 */       this.mCallback = paramOnTouchListener;
/*     */     }
/*  62 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterFullScreenTouchListener(View.OnTouchListener paramOnTouchListener) {
/*  71 */     if (!getSplitScreenService()) {
/*  72 */       Log.i("TouchManagerImpl", "EcarxInputDispatcherService didnt start");
/*  73 */       return false;
/*     */     } 
/*  75 */     this.mCallback = null;
/*     */     
/*     */     try {
/*  78 */       this.mService.unRegisterTouchEventListener((IEcarxTouchListener)this.mTouchListener);
/*  79 */     } catch (RemoteException remoteException) {
/*  80 */       remoteException.printStackTrace();
/*     */     } 
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   private boolean getSplitScreenService() {
/*  86 */     if (this.mService != null) {
/*  87 */       return true;
/*     */     }
/*  89 */     IBinder iBinder = ServiceManager.getService("EcarxInputDispatcherService");
/*     */     
/*  91 */     if (iBinder != null) {
/*  92 */       this.mService = IInputDispatcherService.Stub.asInterface(iBinder);
/*  93 */       return true;
/*     */     } 
/*  95 */     Log.d("TouchManagerImpl", "EcarxInputDispatcherService didnt start");
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   private final class TouchListener extends IEcarxTouchListener.Stub { final TouchManagerImpl this$0;
/*     */     
/*     */     public void onTouchEvent(MotionEvent param1MotionEvent) {
/* 102 */       TouchManagerImpl.this.mDispatchHandler.obtainMessage(1, 0, 0, param1MotionEvent.copy()).sendToTarget();
/*     */     }
/*     */     private TouchListener() {} }
/*     */   
/*     */   private final class DispatchHandler extends Handler { final TouchManagerImpl this$0;
/*     */     
/*     */     public DispatchHandler(Looper param1Looper) {
/* 109 */       super(param1Looper);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 114 */       if (param1Message.what == 1) {
/*     */         
/* 116 */         MotionEvent motionEvent = (MotionEvent)param1Message.obj;
/*     */         try {
/* 118 */           if (TouchManagerImpl.this.mCallback != null)
/*     */           {
/*     */             
/* 121 */             TouchManagerImpl.this.mCallback.onTouch(null, motionEvent); } 
/*     */           return;
/*     */         } finally {
/* 124 */           motionEvent.recycle();
/*     */         } 
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\TouchManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */