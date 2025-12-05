/*    */ package com.google.protobuf.nano;
/*    */ 
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
/*    */ public final class MapFactories
/*    */ {
/*    */   static void setMapFactory(MapFactory paramMapFactory) {
/* 49 */     mapFactory = paramMapFactory;
/*    */   }
/*    */   
/*    */   public static MapFactory getMapFactory() {
/* 53 */     return mapFactory;
/*    */   }
/*    */   
/*    */   private static class DefaultMapFactory implements MapFactory {
/*    */     public <K, V> Map<K, V> forMap(Map<K, V> param1Map) {
/* 58 */       if (param1Map == null) {
/* 59 */         return new HashMap<>();
/*    */       }
/* 61 */       return param1Map;
/*    */     }
/*    */     private DefaultMapFactory() {} }
/* 64 */   private static volatile MapFactory mapFactory = new DefaultMapFactory();
/*    */   
/*    */   public static interface MapFactory {
/*    */     <K, V> Map<K, V> forMap(Map<K, V> param1Map);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\MapFactories.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */