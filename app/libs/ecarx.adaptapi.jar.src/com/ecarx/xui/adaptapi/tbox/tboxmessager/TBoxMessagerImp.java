/*     */ package com.ecarx.xui.adaptapi.tbox.tboxmessager;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import ecarx.tcam.ITcamServiceCallback;
/*     */ import ecarx.tcam.TcamManager;
/*     */ import ecarx.tcam.TcamServiceCallbackImpl;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TBoxMessagerImp
/*     */   implements ITBoxMessager
/*     */ {
/*     */   private static final double LATITUDE_LONGITUDE_CONVERT_VALUE = 8.4E-8D;
/*     */   private static final String TAG = "TBoxMessagerImpl";
/*     */   private final NavilnfoFromTBoxImp mNaviInfoFromTBox;
/*     */   private ITBoxMessager.TBoxMessageCallback mTBoxMessageCallback;
/*  19 */   private final Object mTBoxMessageCallbackLock = new Object();
/*  20 */   private final HashMap<ITBoxMessager.TBoxMessageCallback, Integer> mTBoxMessageCallbackMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public TBoxMessagerImp(Context paramContext) {
/*  25 */     this.mNaviInfoFromTBox = new NavilnfoFromTBoxImp();
/*  26 */     TcamNaviInfo tcamNaviInfo = new TcamNaviInfo();
/*  27 */     TcamManager tcamManager = TcamManager.getInstance(paramContext);
/*  28 */     tcamManager.registerCallback((ITcamServiceCallback)tcamNaviInfo);
/*     */   }
/*     */   
/*     */   private class TcamNaviInfo
/*     */     extends TcamServiceCallbackImpl {
/*     */     final TBoxMessagerImp this$0;
/*     */     
/*     */     private TcamNaviInfo() {}
/*     */     
/*     */     public void onPOIInfo(String param1String1, long param1Long1, long param1Long2, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7) {
/*  38 */       TBoxMessagerImp.this.mNaviInfoFromTBox.setMessageTitle(param1String1);
/*  39 */       NavilnfoFromTBoxImp navilnfoFromTBoxImp = TBoxMessagerImp.this.mNaviInfoFromTBox; double d = param1Long1; navilnfoFromTBoxImp.setMessageLatitude(String.valueOf(d * 8.4E-8D));
/*     */       
/*  41 */       navilnfoFromTBoxImp = TBoxMessagerImp.this.mNaviInfoFromTBox; d = param1Long2; navilnfoFromTBoxImp.setMessageLongitude(String.valueOf(8.4E-8D * d));
/*     */       
/*  43 */       null = new StringBuilder(); null.append("onPOIInfo: poiname = "); null.append(param1String1); null.append(" latitude = "); TBoxMessagerImp tBoxMessagerImp = TBoxMessagerImp.this;
/*  44 */       null.append(tBoxMessagerImp.mNaviInfoFromTBox.getLat()); null.append(" longitude = "); tBoxMessagerImp = TBoxMessagerImp.this;
/*  45 */       null.append(tBoxMessagerImp.mNaviInfoFromTBox.getLon()); String str = null.toString(); Log.d("TBoxMessagerImpl", str);
/*  46 */       synchronized (TBoxMessagerImp.this.mTBoxMessageCallbackLock) {
/*  47 */         for (ITBoxMessager.TBoxMessageCallback tBoxMessageCallback : TBoxMessagerImp.this.mTBoxMessageCallbackMap.keySet()) {
/*  48 */           if (TBoxMessagerImp.this.getTBoxMsgType() == ((Integer)TBoxMessagerImp.this.mTBoxMessageCallbackMap.get(tBoxMessageCallback)).intValue()) {
/*  49 */             TBoxMessagerImp.access$402(TBoxMessagerImp.this, tBoxMessageCallback);
/*     */           }
/*  51 */           if (TBoxMessagerImp.this.mTBoxMessageCallback != null) {
/*  52 */             TBoxMessagerImp.this.mTBoxMessageCallback.onTBoxMessageGet(TBoxMessagerImp.this.mNaviInfoFromTBox, TBoxMessagerImp.this.getTBoxMsgType()); continue;
/*     */           } 
/*  54 */           Log.e("TBoxMessagerImpl", "mTBoxMessageCallback: null");
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
/*     */   public int getTBoxMsgType() {
/*  69 */     return 2;
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
/*     */   public INaviInfoFromTBox getNaviInfo() {
/*  81 */     return this.mNaviInfoFromTBox;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTBoxMessageCallback(ITBoxMessager.TBoxMessageCallback paramTBoxMessageCallback, int paramInt) {
/*  92 */     Object object = this.mTBoxMessageCallbackLock; /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*  93 */     if (paramTBoxMessageCallback == null) { 
/*  94 */       try { Log.e("TBoxMessagerImpl", "tBoxMessageCallback is null"); } finally {} }
/*  95 */     else if (this.mTBoxMessageCallbackMap.containsKey(paramTBoxMessageCallback))
/*  96 */     { Log.d("TBoxMessagerImpl", "tBoxMessageCallback is setted"); }
/*     */     else
/*  98 */     { this.mTBoxMessageCallbackMap.put(paramTBoxMessageCallback, Integer.valueOf(paramInt)); }
/*     */     
/*     */     /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetTBoxMessageCallback(ITBoxMessager.TBoxMessageCallback paramTBoxMessageCallback) {
/* 108 */     synchronized (this.mTBoxMessageCallbackLock) {
/* 109 */       Log.d("TBoxMessagerImpl", "unsetTBoxMessageCallback");
/* 110 */       this.mTBoxMessageCallbackMap.remove(paramTBoxMessageCallback);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\tboxmessager\TBoxMessagerImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */