/*     */ package com.ecarx.xui.adaptapi.oncall;
/*     */ 
/*     */ import android.util.Log;
/*     */ import ecarx.tcam.TcamManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CallImpl
/*     */   implements Call
/*     */ {
/*     */   private static final String TAG = "CallImpl";
/*     */   private final TcamManager mTcamManager;
/*     */   
/*     */   public CallImpl(TcamManager paramTcamManager) {
/*  17 */     this.mTcamManager = paramTcamManager;
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
/*     */   public int getStatus() {
/*  29 */     return Utils.tboxCallStatus2AdaptapiCallStatus(this.mTcamManager.getXCallState());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/*  40 */     return Utils.tboxCallType2AdaptapiCallType(this.mTcamManager.getXCallType());
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
/*     */   public int getDuration() {
/*  52 */     return this.mTcamManager.getCallDuration();
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
/*     */   public boolean isCallback() {
/*  64 */     return this.mTcamManager.isIncomingCall();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() {
/*  73 */     int i = getType();
/*  74 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("end("); stringBuilder.append(i); stringBuilder.append(") start..."); Log.d("CallImpl", stringBuilder.toString());
/*  75 */     if (i != 1) { switch (i) {
/*     */ 
/*     */ 
/*     */         
/*     */         case 4:
/*  80 */           this.mTcamManager.requestStopCall(2);
/*     */           break;
/*     */         case 3:
/*  83 */           this.mTcamManager.requestStopCall(4); break;
/*     */       }  }
/*     */     else { this.mTcamManager.requestStopCall(3); }
/*  86 */      Log.d("CallImpl", "end() finish...");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartCause() {
/*  95 */     return this.mTcamManager.getStartCause();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("callType: "); stringBuilder.append(Utils.callType2String(getType())); stringBuilder.append(" callStatus:: ");
/* 101 */     stringBuilder.append(Utils.AAcallStatus2String(getStatus())); stringBuilder.append(" callbackMode: ");
/* 102 */     stringBuilder.append(isCallback()); stringBuilder.append(" StartCause: ");
/* 103 */     stringBuilder.append(Utils.startCause2String(getStartCause())); stringBuilder.append(" "); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public void accept() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\oncall\CallImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */