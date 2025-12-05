/*     */ package com.ecarx.xui.adaptapi.oncall;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.Message;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ import ecarx.tcam.ITcamServiceCallback;
/*     */ import ecarx.tcam.TcamManager;
/*     */ import ecarx.tcam.TcamServiceCallbackImpl;
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
/*     */ public class OnCallImpl
/*     */   extends OnCall
/*     */ {
/*     */   private static final String TAG = "OnCallImpl";
/*     */   private static final int UPDATE_CALL_TIME_MSG = 1;
/*     */   private static OnCallImpl mOnCallImpl;
/*     */   private CallTimeHandler mCallTimeHandler;
/*     */   private CallImpl mCurrentCall;
/*  30 */   private final List<OnCall.ICallListener> mICallListenerArrayList = new ArrayList<>(); private TcamManager mTcamManager;
/*     */   
/*     */   private OnCallImpl(Context paramContext) {
/*     */     try {
/*     */       boolean bool;
/*  35 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("OnCallImpl start create("); if (paramContext != null) { bool = true; } else { bool = false; }  stringBuilder.append(bool); stringBuilder.append(")"); Log.d("OnCallImpl", stringBuilder.toString());
/*  36 */       this.mTcamManager = TcamManager.getInstance(paramContext);
/*  37 */       CallImpl callImpl = new CallImpl(); this(this.mTcamManager); this.mCurrentCall = callImpl;
/*  38 */       OnCallTcamCallback onCallTcamCallback = new OnCallTcamCallback(); this(this);
/*  39 */       this.mTcamManager.registerCallback((ITcamServiceCallback)onCallTcamCallback);
/*  40 */       CallTimeHandler callTimeHandler = new CallTimeHandler(); this(this.mTcamManager); this.mCallTimeHandler = callTimeHandler;
/*     */       
/*  42 */       if (isCallIng()) { CallImpl callImpl1 = this.mCurrentCall;
/*  43 */         if (11 == callImpl1.getStatus()) {
/*  44 */           startUpdateCallTime();
/*  45 */           Log.d("OnCallImpl", "OnCallImpl callType = ECall, status = call connected");
/*     */         }  }
/*     */       
/*  48 */       Log.d("OnCallImpl", "OnCallImpl end create");
/*  49 */     } catch (Exception exception) {
/*  50 */       Log.d("OnCallImpl", "OnCallImpl error create", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCallIng() {
/*  61 */     boolean bool = false;
/*  62 */     if (-2147483647 != this.mCurrentCall.getType()) {
/*  63 */       bool = true;
/*     */     } else {
/*  65 */       Log.e("OnCallImpl", "CurrentCall is not call");
/*     */     } 
/*  67 */     return bool;
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
/*     */   private void notifyXCallStatusChanged(int paramInt1, int paramInt2, boolean paramBoolean, OnCall.ICallListener paramICallListener) {
/*  79 */     if (paramBoolean) { try {
/*  80 */         synchronized (this.mICallListenerArrayList) {
/*  81 */           for (OnCall.ICallListener iCallListener : this.mICallListenerArrayList) {
/*  82 */             if (iCallListener != null) {
/*  83 */               StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("notifyXCallStatusChanged("); stringBuilder.append(paramInt2); stringBuilder.append(")"); Log.i("OnCallImpl", stringBuilder.toString());
/*  84 */               if (paramInt2 == 0) {
/*  85 */                 if (this.mCurrentCall != null) {
/*  86 */                   iCallListener.onCallCreate(this.mCurrentCall);
/*  87 */                   stringBuilder = new StringBuilder(); this(); stringBuilder.append("onCallCreate CurrentCall("); stringBuilder.append(this.mCurrentCall); stringBuilder.append(")"); Log.i("OnCallImpl", stringBuilder.toString());
/*     */                 } else {
/*     */                   
/*  90 */                   Log.e("OnCallImpl", "mCurrentCall is null");
/*     */                 } 
/*     */               }
/*     */ 
/*     */               
/*  95 */               int i = Utils.tboxCallType2AdaptapiCallType(paramInt1);
/*  96 */               int j = Utils.tboxCallStatus2AdaptapiCallStatus(paramInt2); iCallListener.onCallStatusChanged(i, j); continue;
/*     */             } 
/*  98 */             Log.w("OnCallImpl", "notifyXCallStatusChanged mListener = null");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 122 */       catch (Exception exception) {
/* 123 */         exception.printStackTrace();
/*     */       }  }
/*     */     else if (exception != null)
/*     */     { StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("notifyXCallStatusChanged("); stringBuilder.append(paramInt2); stringBuilder.append(")"); Log.i("OnCallImpl", stringBuilder.toString()); paramInt1 = Utils.tboxCallType2AdaptapiCallType(paramInt1); int i = Utils.tboxCallStatus2AdaptapiCallStatus(paramInt2); exception.onCallStatusChanged(paramInt1, i); if (paramInt2 == 0)
/*     */         if (this.mCurrentCall != null) {
/*     */           exception.onCallCreate(this.mCurrentCall); StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("onCallCreate CurrentCall("); stringBuilder1.append(this.mCurrentCall); stringBuilder1.append(")"); Log.i("OnCallImpl", stringBuilder1.toString());
/*     */         } else {
/*     */           Log.e("OnCallImpl", "mCurrentCall is null");
/*     */         }   }
/*     */     else
/*     */     { Log.e("OnCallImpl", "notifyXCallStatusChanged callListener = null"); }
/* 134 */      } public static OnCallImpl create(Context paramContext) { /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/oncall/OnCallImpl}} */ if (paramContext != null)
/* 135 */       try { OnCallImpl onCallImpl1 = new OnCallImpl(); this(paramContext); mOnCallImpl = onCallImpl1; }
/*     */       finally {} 
/* 137 */     OnCallImpl onCallImpl = mOnCallImpl; /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/oncall/OnCallImpl}} */ return onCallImpl; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class OnCallTcamCallback
/*     */     extends TcamServiceCallbackImpl
/*     */   {
/*     */     final OnCallImpl this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     private OnCallTcamCallback() {}
/*     */ 
/*     */     
/*     */     public void onXCallInfoChanged(int param1Int1, int param1Int2, int param1Int3) {
/*     */       /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/ecarx/xui/adaptapi/oncall/OnCallImpl}.Lcom/ecarx/xui/adaptapi/oncall/OnCallImpl$OnCallTcamCallback;}} */
/*     */       try {
/* 155 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("onXCallInfoChanged callType = ");
/* 156 */         int i = Utils.tboxCallType2AdaptapiCallType(param1Int1); stringBuilder.append(Utils.callType2String(i)); stringBuilder.append(", status = ");
/* 157 */         stringBuilder.append(Utils.callStatus2String(param1Int2)); stringBuilder.append(", callbackMode = "); stringBuilder.append(param1Int3); String str = stringBuilder.toString();
/*     */         
/*     */         Log.i("OnCallImpl", str);
/* 160 */         if (param1Int1 != 0 && Integer.MIN_VALUE != param1Int1 && Integer.MIN_VALUE != param1Int2) {
/*     */ 
/*     */ 
/*     */           
/* 164 */           if (5 == param1Int2) {
/* 165 */             OnCallImpl.this.startUpdateCallTime();
/* 166 */           } else if (3 == param1Int2 || 7 == param1Int2) {
/*     */             
/* 168 */             OnCallImpl.this.stopUpdateCallTime();
/*     */           } 
/* 170 */           OnCallImpl.this.notifyXCallStatusChanged(param1Int1, param1Int2, true, null);
/*     */         } else {
/* 172 */           StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("onXCallInfoChanged callType error: "); stringBuilder1.append(param1Int1); Log.e("OnCallImpl", stringBuilder1.toString());
/*     */         } 
/* 174 */       } catch (Exception exception) {
/* 175 */         exception.printStackTrace();
/*     */       } finally {
/*     */         Exception exception;
/*     */       } 
/*     */       /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/ecarx/xui/adaptapi/oncall/OnCallImpl}.Lcom/ecarx/xui/adaptapi/oncall/OnCallImpl$OnCallTcamCallback;}} */
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onTcamMuteStatusChange(boolean param1Boolean) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: monitorenter
/*     */       //   2: new java/lang/StringBuilder
/*     */       //   5: astore_2
/*     */       //   6: aload_2
/*     */       //   7: invokespecial <init> : ()V
/*     */       //   10: aload_2
/*     */       //   11: ldc 'onTBoxMuteStatusChange MUTE = '
/*     */       //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   16: pop
/*     */       //   17: aload_2
/*     */       //   18: iload_1
/*     */       //   19: invokevirtual append : (Z)Ljava/lang/StringBuilder;
/*     */       //   22: pop
/*     */       //   23: aload_2
/*     */       //   24: ldc ' mCurrentCall = '
/*     */       //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   29: pop
/*     */       //   30: aload_2
/*     */       //   31: aload_0
/*     */       //   32: getfield this$0 : Lcom/ecarx/xui/adaptapi/oncall/OnCallImpl;
/*     */       //   35: invokestatic access$400 : (Lcom/ecarx/xui/adaptapi/oncall/OnCallImpl;)Lcom/ecarx/xui/adaptapi/oncall/CallImpl;
/*     */       //   38: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */       //   41: pop
/*     */       //   42: ldc 'OnCallImpl'
/*     */       //   44: aload_2
/*     */       //   45: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   48: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   51: pop
/*     */       //   52: aload_0
/*     */       //   53: monitorexit
/*     */       //   54: return
/*     */       //   55: astore_2
/*     */       //   56: aload_0
/*     */       //   57: monitorexit
/*     */       //   58: aload_2
/*     */       //   59: athrow
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #187	-> 2
/*     */       //   #188	-> 52
/*     */       //   #186	-> 55
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   2	52	55	finally
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onCallbackModeCallEvent(int param1Int) {
/*     */       /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/ecarx/xui/adaptapi/oncall/OnCallImpl}.Lcom/ecarx/xui/adaptapi/oncall/OnCallImpl$OnCallTcamCallback;}} */
/*     */       /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/ecarx/xui/adaptapi/oncall/OnCallImpl}.Lcom/ecarx/xui/adaptapi/oncall/OnCallImpl$OnCallTcamCallback;}} */
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onXcallFailedUnsubscribed(int param1Int) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: monitorenter
/*     */       //   2: new java/lang/StringBuilder
/*     */       //   5: astore_2
/*     */       //   6: aload_2
/*     */       //   7: invokespecial <init> : ()V
/*     */       //   10: aload_2
/*     */       //   11: ldc 'onXCallFailedUnsubscribed callType = '
/*     */       //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   16: pop
/*     */       //   17: iload_1
/*     */       //   18: invokestatic tboxCallType2AdaptapiCallType : (I)I
/*     */       //   21: istore_1
/*     */       //   22: aload_2
/*     */       //   23: iload_1
/*     */       //   24: invokestatic callType2String : (I)Ljava/lang/String;
/*     */       //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   30: pop
/*     */       //   31: ldc 'OnCallImpl'
/*     */       //   33: aload_2
/*     */       //   34: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   37: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
/*     */       //   40: pop
/*     */       //   41: aload_0
/*     */       //   42: monitorexit
/*     */       //   43: return
/*     */       //   44: astore_2
/*     */       //   45: aload_0
/*     */       //   46: monitorexit
/*     */       //   47: aload_2
/*     */       //   48: athrow
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #206	-> 2
/*     */       //   #207	-> 17
/*     */       //   #206	-> 22
/*     */       //   #208	-> 41
/*     */       //   #205	-> 44
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   2	17	44	finally
/*     */       //   17	22	44	finally
/*     */       //   22	41	44	finally
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void onETAInfoNotification(int param1Int1, int param1Int2, int param1Int3) {
/* 219 */       synchronized (OnCallImpl.this.mICallListenerArrayList) {
/* 220 */         for (OnCall.ICallListener iCallListener : OnCallImpl.this.mICallListenerArrayList) {
/* 221 */           if (iCallListener != null) {
/*     */             try {
/* 223 */               Log.i("OnCallImpl", "onETAInfoNotification");
/* 224 */               OnCallImpl onCallImpl = OnCallImpl.this;
/*     */               
/* 226 */               param1Int1 = onCallImpl.mTcamManager.getXCallType(); param1Int1 = Utils.tboxCallType2AdaptapiCallType(param1Int1);
/*     */               iCallListener.onCallStatusChanged(param1Int1, 22);
/* 228 */             } catch (Exception exception) {
/* 229 */               StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("onETAInfoNotification: "); stringBuilder.append(exception.fillInStackTrace()); Log.e("OnCallImpl", stringBuilder.toString());
/*     */             } 
/*     */             continue;
/*     */           } 
/* 233 */           Log.w("OnCallImpl", "onETAInfoNotification mListener = null");
/*     */         } 
/*     */         return;
/*     */       } 
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
/*     */   public Call getCurrentCall() {
/* 248 */     if (isCallIng()) {
/* 249 */       return this.mCurrentCall;
/*     */     }
/* 251 */     return null;
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
/*     */   public FunctionStatus isOnCallSupported(int paramInt) {
/*     */     FunctionStatus functionStatus;
/* 265 */     int i = this.mTcamManager.isOnCallSupported(Utils.changedCallTypeToTcamCallType(paramInt));
/* 266 */     if (FunctionStatus.active.ordinal() == i) {
/* 267 */       functionStatus = FunctionStatus.active;
/* 268 */     } else if (FunctionStatus.notactive.ordinal() == i) {
/* 269 */       functionStatus = FunctionStatus.notactive;
/* 270 */     } else if (FunctionStatus.error.ordinal() == i) {
/* 271 */       functionStatus = FunctionStatus.error;
/*     */     } else {
/* 273 */       functionStatus = FunctionStatus.notavailable;
/*     */     } 
/* 275 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("isOnCallSupported: "); stringBuilder.append(Utils.callType2String(paramInt)); stringBuilder.append(" FunctionStatus (active, notactive, notavailable, error):"); stringBuilder.append(functionStatus); Log.d("OnCallImpl", stringBuilder.toString());
/*     */     
/* 277 */     return functionStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startCall(int paramInt) {
/* 287 */     StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append("startCall ..."); stringBuilder2.append(Utils.callType2String(paramInt)); Log.i("OnCallImpl", stringBuilder2.toString());
/* 288 */     boolean bool2 = false;
/*     */     
/* 290 */     TcamManager tcamManager = this.mTcamManager;
/* 291 */     int i = tcamManager.getXCallState(); boolean bool1 = bool2; if (TcamManager.callStateToPhoneCallState(i) == 0)
/* 292 */       if (paramInt != 1) { switch (paramInt)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 303 */             Log.e("OnCallImpl", "startCall unknown type !!!"); bool1 = bool2; break;
/*     */           case 4:
/*     */             bool1 = this.mTcamManager.startBCall(); break;
/*     */           case 3:
/* 307 */             bool1 = this.mTcamManager.startICall(); break; }  } else { bool1 = this.mTcamManager.startECall(); }   StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("startCall finish("); stringBuilder1.append(bool1); stringBuilder1.append(")"); Log.i("OnCallImpl", stringBuilder1.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getECallCallbackRemainedTime() {
/* 318 */     return this.mTcamManager.getCallbackRemainTime();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getETARescue() {
/* 328 */     return this.mTcamManager.getETATimeSecond();
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
/*     */   public void registerCallListener(OnCall.ICallListener paramICallListener) {
/* 341 */     if (paramICallListener != null) {
/* 342 */       List<OnCall.ICallListener> list; TcamManager tcamManager; synchronized (this.mICallListenerArrayList) {
/* 343 */         if (this.mICallListenerArrayList.contains(paramICallListener)) {
/* 344 */           Log.d("OnCallImpl", "ICallListener is added");
/*     */         } else {
/* 346 */           this.mICallListenerArrayList.add(paramICallListener);
/* 347 */           Log.d("OnCallImpl", "ICallListener is add");
/*     */         } 
/*     */         
/* 350 */         if (isCallIng()) {
/* 351 */           if (this.mCurrentCall != null) {
/* 352 */             Log.d("OnCallImpl", "registerCallListener notifyXCallStatusChanged");
/* 353 */             tcamManager = this.mTcamManager;
/* 354 */             int i = tcamManager.getXCallState();
/*     */             notifyXCallStatusChanged(3, i, false, paramICallListener);
/*     */           } else {
/* 357 */             Log.e("OnCallImpl", "mCurrentCall is null");
/*     */           } 
/*     */         } else {
/* 360 */           Log.d("OnCallImpl", "Current call is not Call");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterCallListener(OnCall.ICallListener paramICallListener) {
/* 373 */     synchronized (this.mICallListenerArrayList) {
/* 374 */       if (this.mICallListenerArrayList.contains(paramICallListener)) {
/* 375 */         this.mICallListenerArrayList.remove(paramICallListener);
/* 376 */         Log.d("OnCallImpl", "ICallListener is remove");
/*     */       } else {
/* 378 */         Log.d("OnCallImpl", "ICallListener is removed");
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */   private void startUpdateCallTime() {
/* 384 */     this.mCallTimeHandler.removeMessages(1);
/* 385 */     this.mCallTimeHandler.sendEmptyMessage(1);
/*     */   }
/*     */   
/*     */   private void stopUpdateCallTime() {
/* 389 */     this.mCallTimeHandler.removeMessages(1);
/*     */   }
/*     */   
/*     */   private static class CallTimeHandler
/*     */     extends Handler {
/*     */     private final TcamManager mTcamManager;
/*     */     
/*     */     CallTimeHandler(TcamManager param1TcamManager) {
/* 397 */       this.mTcamManager = param1TcamManager;
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 402 */       if (param1Message.what == 1)
/*     */ 
/*     */         
/*     */         try { 
/* 406 */           int i = this.mTcamManager.getXCallState();
/*     */ 
/*     */ 
/*     */           
/* 410 */           if (i == 5)
/* 411 */           { sendEmptyMessageDelayed(1, 1000L); return; }  } catch (Exception exception) { Log.d("OnCallImpl", "OnCallImpl error updateCallTime", exception); if (Integer.MIN_VALUE == 5) { sendEmptyMessageDelayed(1, 1000L);
/*     */             return; }
/*     */            }
/*     */         finally {} 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\oncall\OnCallImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */