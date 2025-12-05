/*    */ package com.android.car.internal;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Looper;
/*    */ import android.os.Message;
/*    */ import java.util.List;
/*    */ import java.util.function.Consumer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SingleMessageHandler<EventType>
/*    */   implements Handler.Callback
/*    */ {
/*    */   private final int mHandledMessageWhat;
/*    */   private final Handler mHandler;
/*    */   
/*    */   public SingleMessageHandler(Looper paramLooper, int paramInt) {
/* 36 */     this.mHandledMessageWhat = paramInt;
/* 37 */     this.mHandler = new Handler(paramLooper, this);
/*    */   }
/*    */   
/*    */   public SingleMessageHandler(Handler paramHandler, int paramInt) {
/* 41 */     this(paramHandler.getLooper(), paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean handleMessage(Message paramMessage) {
/* 48 */     if (paramMessage.what == this.mHandledMessageWhat) {
/* 49 */       List list = (List)paramMessage.obj;
/* 50 */       list.forEach(new Consumer<EventType>()
/*    */           {
/*    */             public void accept(EventType param1EventType) {
/* 53 */               SingleMessageHandler.this.handleEvent(param1EventType);
/*    */             }
/*    */             final SingleMessageHandler this$0;
/*    */           });
/*    */     } 
/* 58 */     return true;
/*    */   }
/*    */   
/*    */   public void sendEvents(List<EventType> paramList) {
/* 62 */     this.mHandler.sendMessage(this.mHandler.obtainMessage(this.mHandledMessageWhat, paramList));
/*    */   }
/*    */   
/*    */   protected abstract void handleEvent(EventType paramEventType);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\car\internal\SingleMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */