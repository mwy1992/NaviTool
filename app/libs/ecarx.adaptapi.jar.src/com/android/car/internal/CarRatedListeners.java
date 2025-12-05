/*    */ package com.android.car.internal;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class CarRatedListeners<EventListenerType>
/*    */ {
/*    */   private int mUpdateRate;
/* 29 */   private final Map<EventListenerType, Integer> mListenersToRate = new HashMap<>(4);
/*    */ 
/*    */ 
/*    */   
/* 33 */   protected long mLastUpdateTime = -1L;
/*    */   
/*    */   protected CarRatedListeners(int paramInt) {
/* 36 */     this.mUpdateRate = paramInt;
/*    */   }
/*    */   
/*    */   public boolean contains(EventListenerType paramEventListenerType) {
/* 40 */     return this.mListenersToRate.containsKey(paramEventListenerType);
/*    */   }
/*    */   
/*    */   public int getRate() {
/* 44 */     return this.mUpdateRate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean remove(EventListenerType paramEventListenerType) {
/* 54 */     this.mListenersToRate.remove(paramEventListenerType);
/* 55 */     if (this.mListenersToRate.isEmpty()) {
/* 56 */       return false;
/*    */     }
/* 58 */     Integer integer = Collections.<Integer>min(this.mListenersToRate.values());
/* 59 */     if (integer.intValue() != this.mUpdateRate) {
/* 60 */       this.mUpdateRate = integer.intValue();
/* 61 */       return true;
/*    */     } 
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 67 */     return this.mListenersToRate.isEmpty();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean addAndUpdateRate(EventListenerType paramEventListenerType, int paramInt) {
/* 78 */     Integer integer = this.mListenersToRate.put(paramEventListenerType, Integer.valueOf(paramInt));
/* 79 */     if (this.mUpdateRate > paramInt) {
/* 80 */       this.mUpdateRate = paramInt;
/* 81 */       return true;
/* 82 */     }  if (integer != null && integer.intValue() == this.mUpdateRate) {
/* 83 */       this.mUpdateRate = ((Integer)Collections.<Integer>min(this.mListenersToRate.values())).intValue();
/*    */     }
/* 85 */     return false;
/*    */   }
/*    */   
/*    */   public Collection<EventListenerType> getListeners() {
/* 89 */     return this.mListenersToRate.keySet();
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\car\internal\CarRatedListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */