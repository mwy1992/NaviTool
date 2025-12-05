/*    */ package com.ecarx.xui.adaptapi.car;
/*    */ 
/*    */ import android.util.Log;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Pairs<F, S>
/*    */ {
/*    */   private static final String TAG = "Pairs";
/*    */   private S mDefaultValue;
/* 13 */   private final Map<F, S> mValues = new HashMap<>();
/*    */ 
/*    */   
/*    */   private Pairs(F paramF, S paramS) {
/* 17 */     this();
/* 18 */     add(paramF, paramS);
/*    */   }
/*    */   
/*    */   public static <F, S> Pairs<F, S> of(F paramF, S paramS) {
/* 22 */     return new Pairs<>(paramF, paramS);
/*    */   }
/*    */   
/*    */   public Pairs<F, S> add(F paramF, S paramS) {
/* 26 */     if (this.mValues.containsKey(paramF)) {
/* 27 */       if (paramF instanceof Integer) {
/* 28 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("The key [0X"); Integer integer = (Integer)paramF;
/* 29 */         stringBuilder.append(Integer.toHexString(integer.intValue())); stringBuilder.append("::"); stringBuilder.append(paramF); stringBuilder.append("] is exist."); String str = stringBuilder.toString();
/*    */         Log.w("Pairs", str);
/*    */       } else {
/* 32 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("The key "); stringBuilder.append(paramF); stringBuilder.append(" is exist."); Log.w("Pairs", stringBuilder.toString());
/*    */       } 
/*    */     }
/* 35 */     this.mValues.put(paramF, paramS);
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public Pairs<F, S> orDefault(S paramS) {
/* 40 */     this.mDefaultValue = paramS;
/* 41 */     return this;
/*    */   }
/*    */   
/*    */   public S getValue(F paramF) {
/* 45 */     return this.mValues.getOrDefault(paramF, this.mDefaultValue);
/*    */   }
/*    */   
/*    */   public Pairs<S, F> reverse() {
/* 49 */     Pairs<S, F> pairs = new Pairs();
/* 50 */     for (F f : this.mValues.keySet()) {
/* 51 */       pairs.add(this.mValues.get(f), f);
/*    */     }
/* 53 */     return pairs;
/*    */   }
/*    */   
/*    */   private Pairs() {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\Pairs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */