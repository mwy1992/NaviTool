/*     */ package com.ecarx.xui.adaptapi.car.diagnostics;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.SparseArray;
/*     */ import com.android.internal.annotations.GuardedBy;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DiagnosticMonitor
/*     */   extends AbsCarSignal
/*     */   implements IDiagnosticMonitor
/*     */ {
/*     */   private static final String TAG = "DiagnosticMonitor";
/*  17 */   private final Object mListenerLock = new Object();
/*     */   
/*     */   @GuardedBy("mListenerLock")
/*     */   private final SparseArray<ArrayList<IDiagnosticMonitor.IMonitorListener>> mListeners;
/*     */   
/*     */   protected DiagnosticMonitor(Context paramContext) {
/*  23 */     super(paramContext);
/*  24 */     this.mListeners = new SparseArray();
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
/*     */   public boolean setMonitorEnable(int paramInt, boolean paramBoolean) {
/*  38 */     return false;
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
/*     */   public boolean registerListener(IDiagnosticMonitor.IMonitorListener paramIMonitorListener, int paramInt) {
/*  51 */     synchronized (this.mListenerLock) {
/*  52 */       if (this.mListeners.indexOfKey(paramInt) < 0) {
/*  53 */         SparseArray<ArrayList<IDiagnosticMonitor.IMonitorListener>> sparseArray = this.mListeners; ArrayList arrayList1 = new ArrayList(); this(); sparseArray.put(paramInt, arrayList1);
/*     */       } 
/*     */       
/*  56 */       ArrayList<IDiagnosticMonitor.IMonitorListener> arrayList = (ArrayList)this.mListeners.get(paramInt);
/*  57 */       if (!arrayList.contains(paramIMonitorListener)) {
/*  58 */         arrayList.add(paramIMonitorListener);
/*     */       }
/*     */ 
/*     */       
/*  62 */       return true;
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
/*     */   public boolean registerListener(IDiagnosticMonitor.IMonitorListener paramIMonitorListener, int[] paramArrayOfint) {
/*  75 */     synchronized (this.mListenerLock) {
/*  76 */       byte b; int i; for (i = paramArrayOfint.length, b = 0; b < i; ) { int j = paramArrayOfint[b];
/*  77 */         if (this.mListeners.indexOfKey(j) < 0) {
/*  78 */           SparseArray<ArrayList<IDiagnosticMonitor.IMonitorListener>> sparseArray = this.mListeners; ArrayList arrayList1 = new ArrayList(); this(); sparseArray.put(j, arrayList1);
/*     */         } 
/*     */         
/*  81 */         ArrayList<IDiagnosticMonitor.IMonitorListener> arrayList = (ArrayList)this.mListeners.get(j);
/*  82 */         if (!arrayList.contains(paramIMonitorListener)) {
/*  83 */           arrayList.add(paramIMonitorListener);
/*     */         }
/*     */         
/*     */         b++; }
/*     */       
/*  88 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterListener(IDiagnosticMonitor.IMonitorListener paramIMonitorListener) {
/*  98 */     synchronized (this.mListenerLock) {
/*  99 */       int i = this.mListeners.size();
/* 100 */       for (byte b = 0; b < i; b++) {
/* 101 */         ArrayList arrayList = (ArrayList)this.mListeners.valueAt(b);
/* 102 */         arrayList.remove(paramIMonitorListener);
/*     */       } 
/*     */ 
/*     */       
/* 106 */       return true;
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
/*     */   private void onMonitorStatusChanged(int paramInt1, int paramInt2) {
/* 133 */     synchronized (this.mListenerLock) {
/* 134 */       ArrayList arrayList = (ArrayList)this.mListeners.get(paramInt1, null);
/* 135 */       if (arrayList != null) {
/* 136 */         for (IDiagnosticMonitor.IMonitorListener iMonitorListener : arrayList) {
/*     */           try {
/* 138 */             iMonitorListener.onMonitorStatusChanged(paramInt1, paramInt2);
/* 139 */           } catch (Exception exception) {
/* 140 */             exception.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       }
/*     */       return;
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
/*     */   
/*     */   private void onMonitorValueChanged(int paramInt, float paramFloat) {
/* 160 */     synchronized (this.mListenerLock) {
/* 161 */       ArrayList arrayList = (ArrayList)this.mListeners.get(paramInt, null);
/* 162 */       if (arrayList != null)
/* 163 */         for (IDiagnosticMonitor.IMonitorListener iMonitorListener : arrayList) {
/*     */           try {
/* 165 */             iMonitorListener.onMonitorValueChanged(paramInt, paramFloat);
/* 166 */           } catch (Exception exception) {
/* 167 */             exception.printStackTrace();
/*     */           } 
/*     */         }  
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\DiagnosticMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */