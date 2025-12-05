/*     */ package com.ecarx.xui.adaptapi.car;
/*     */ 
/*     */ import android.util.SparseArray;
/*     */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.function.Supplier;
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
/*     */ public class VehicleSignalStore2
/*     */ {
/*  21 */   private final SparseArray<Object> keyMap = new SparseArray();
/*     */   
/*     */   private final Concurrent mCacheDataLock;
/*     */   
/*     */   public VehicleSignalStore2() {
/*  26 */     this.mCacheDataLock = new Concurrent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void recordPAData(int paramInt, Object paramObject) {
/*  37 */     this.mCacheDataLock.writeLock();
/*  38 */     this.keyMap.put(paramInt, paramObject);
/*  39 */     this.mCacheDataLock.writeUnlock();
/*     */   }
/*     */   
/*     */   public void recordSignalData(ECarXCarPropertyValue paramECarXCarPropertyValue) {
/*  43 */     this.mCacheDataLock.writeLock();
/*  44 */     this.keyMap.put(paramECarXCarPropertyValue.getPropertyId(), paramECarXCarPropertyValue.getValue());
/*  45 */     this.mCacheDataLock.writeUnlock();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getPAData(int paramInt, Supplier<Object> paramSupplier) {
/*  56 */     this.mCacheDataLock.readLock();
/*  57 */     Object object2 = this.keyMap.get(paramInt);
/*  58 */     this.mCacheDataLock.readUnlock();
/*  59 */     Object object1 = object2; if (object2 == null) { object1 = object2; if (paramSupplier != null) {
/*  60 */         object1 = paramSupplier.get();
/*  61 */         this.mCacheDataLock.writeLock();
/*  62 */         this.keyMap.put(paramInt, object1);
/*  63 */         this.mCacheDataLock.writeUnlock();
/*     */       }  }
/*  65 */      return object1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSignalData(int paramInt, Supplier<Integer> paramSupplier) {
/*  75 */     this.mCacheDataLock.readLock();
/*  76 */     Object object2 = this.keyMap.get(paramInt);
/*  77 */     this.mCacheDataLock.readUnlock();
/*  78 */     Object object1 = object2; if (object2 == null) { object1 = object2; if (paramSupplier != null) {
/*  79 */         object1 = paramSupplier.get();
/*  80 */         this.mCacheDataLock.writeLock();
/*  81 */         this.keyMap.put(paramInt, object1);
/*  82 */         this.mCacheDataLock.writeUnlock();
/*     */       }  }
/*  84 */      if (object1 == null) { paramInt = 0; } else { paramInt = ((Integer)object1).intValue(); }  return paramInt;
/*     */   }
/*     */   
/*     */   private static class Concurrent {
/*     */     private final Lock mReadLock;
/*     */     private final Lock mWriteLock;
/*     */     
/*     */     public Concurrent() {
/*  92 */       ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
/*  93 */       this.mReadLock = reentrantReadWriteLock.readLock();
/*  94 */       this.mWriteLock = reentrantReadWriteLock.writeLock();
/*     */     }
/*     */     
/*     */     private void readLock() {
/*  98 */       this.mReadLock.lock();
/*     */     }
/*     */     
/*     */     private void readUnlock() {
/* 102 */       this.mReadLock.unlock();
/*     */     }
/*     */     
/*     */     private void writeLock() {
/* 106 */       this.mWriteLock.lock();
/*     */     }
/*     */     
/*     */     private void writeUnlock() {
/* 110 */       this.mWriteLock.unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\VehicleSignalStore2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */