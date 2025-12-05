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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CarRatedFloatListeners<T>
/*    */ {
/*    */   private float mUpdateRate;
/* 32 */   private final Map<T, Float> mListenersToRate = new HashMap<>(4);
/*    */ 
/*    */ 
/*    */   
/* 36 */   protected long mLastUpdateTime = -1L;
/*    */   
/*    */   protected CarRatedFloatListeners(float paramFloat) {
/* 39 */     this.mUpdateRate = paramFloat;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(T paramT) {
/* 44 */     return this.mListenersToRate.containsKey(paramT);
/*    */   }
/*    */   
/*    */   public float getRate() {
/* 48 */     return this.mUpdateRate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean remove(T paramT) {
/* 58 */     this.mListenersToRate.remove(paramT);
/* 59 */     if (this.mListenersToRate.isEmpty()) {
/* 60 */       return false;
/*    */     }
/* 62 */     Float float_ = Collections.<Float>max(this.mListenersToRate.values());
/* 63 */     if (float_.floatValue() != this.mUpdateRate) {
/* 64 */       this.mUpdateRate = float_.floatValue();
/* 65 */       return true;
/*    */     } 
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 71 */     return this.mListenersToRate.isEmpty();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean addAndUpdateRate(T paramT, float paramFloat) {
/* 82 */     Float float_ = this.mListenersToRate.put(paramT, Float.valueOf(paramFloat));
/* 83 */     if (this.mUpdateRate < paramFloat) {
/* 84 */       this.mUpdateRate = paramFloat;
/* 85 */       return true;
/* 86 */     }  if (float_ != null && float_.floatValue() == this.mUpdateRate) {
/* 87 */       this.mUpdateRate = ((Float)Collections.<Float>max(this.mListenersToRate.values())).floatValue();
/*    */     }
/* 89 */     return false;
/*    */   }
/*    */   
/*    */   public Collection<T> getListeners() {
/* 93 */     return this.mListenersToRate.keySet();
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\android\car\internal\CarRatedFloatListeners.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */