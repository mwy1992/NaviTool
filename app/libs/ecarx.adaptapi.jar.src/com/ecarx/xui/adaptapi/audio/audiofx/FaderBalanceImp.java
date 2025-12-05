/*     */ package com.ecarx.xui.adaptapi.audio.audiofx;
/*     */ 
/*     */ import android.content.ComponentName;
/*     */ import android.content.Context;
/*     */ import android.content.ServiceConnection;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Looper;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.ecarx.car.audio.manager.EcarxAudioManager;
/*     */ import com.ecarx.car.audio.manager.IFaderBalanceCallback;
/*     */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*     */ 
/*     */ 
/*     */ public class FaderBalanceImp
/*     */   implements IFaderBalance
/*     */ {
/*  19 */   private IFaderBalance.IFaderBalanceStateListener mFaderBalanceStateListener = null;
/*  20 */   private short[] mFaderLevelRange = new short[] { -10, 10 };
/*  21 */   private short[] mBalanceLevelRange = new short[] { -10, 10 };
/*     */   
/*  23 */   private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient()
/*     */     {
/*     */       public void binderDied() {
/*  26 */         Log.e("FaderBalanceImp", "binderDied");
/*  27 */         if (FaderBalanceImp.this.mEcarxAudioManager != null)
/*  28 */           FaderBalanceImp.this.mEcarxAudioManager.connect(); 
/*     */       }
/*     */       final FaderBalanceImp this$0;
/*     */     };
/*     */   private static final String TAG = "FaderBalanceImp"; private EcarxAudioManager mEcarxAudioManager;
/*     */   public FaderBalanceImp(Context paramContext) {
/*  34 */     ServiceConnection serviceConnection = new ServiceConnection() { final FaderBalanceImp this$0;
/*     */         
/*     */         public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
/*  37 */           if (FaderBalanceImp.this.mEcarxAudioManager == null) {
/*  38 */             Log.e("FaderBalanceImp", "onServiceConnected mEcarxAudioManager is null");
/*     */           }
/*     */           try {
/*  41 */             param1IBinder.linkToDeath(FaderBalanceImp.this.mDeathRecipient, 0);
/*  42 */           } catch (RemoteException remoteException) {
/*  43 */             remoteException.printStackTrace();
/*     */           } 
/*  45 */           Log.d("FaderBalanceImp", "onServiceConnected");
/*     */         }
/*     */         
/*     */         public void onServiceDisconnected(ComponentName param1ComponentName)
/*     */         {
/*  50 */           Log.d("FaderBalanceImp", "onServiceDisconnected");
/*  51 */           if (FaderBalanceImp.this.mEcarxAudioManager != null) {
/*  52 */             FaderBalanceImp.this.mEcarxAudioManager.connect();
/*  53 */             Log.d("FaderBalanceImp", "onServiceDisconnected mEcarxAudioManager.connect()");
/*     */           }  } }
/*     */       ;
/*  56 */     Handler handler = new Handler(Looper.getMainLooper()); this.mEcarxAudioManager = EcarxAudioManager.createEcarxAudioManager(paramContext, serviceConnection, handler);
/*  57 */     this.mEcarxAudioManager.connect();
/*  58 */     this.mEcarxAudioManager.registerFaderBalanceCallback((IFaderBalanceCallback)new FaderBalanceCallback());
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
/*     */   public short[] getFaderLevelRange() {
/*  70 */     return this.mFaderLevelRange;
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
/*     */   public void setFaderLevel(short paramShort) {
/*  82 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setFaderLevel:"); stringBuilder.append(paramShort); Log.d("FaderBalanceImp", stringBuilder.toString());
/*  83 */     if (paramShort < this.mFaderLevelRange[0] || paramShort > this.mFaderLevelRange[1]) {
/*  84 */       stringBuilder = new StringBuilder(); stringBuilder.append("setFaderLevel: bad level value: "); stringBuilder.append(paramShort); Log.e("FaderBalanceImp", stringBuilder.toString());
/*     */       return;
/*     */     } 
/*  87 */     this.mEcarxAudioManager.setFader(paramShort);
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
/*     */   public short[] getBalanceLevelRange() {
/* 100 */     return this.mBalanceLevelRange;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBalanceLevel() {
/* 110 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getBalanceLevel:"); stringBuilder.append((short)this.mEcarxAudioManager.getBalance()); Log.d("FaderBalanceImp", stringBuilder.toString());
/*     */     
/* 112 */     return (short)this.mEcarxAudioManager.getBalance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFaderLevel() {
/* 123 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getFaderLevel:"); stringBuilder.append((short)this.mEcarxAudioManager.getFade()); Log.d("FaderBalanceImp", stringBuilder.toString());
/* 124 */     return (short)this.mEcarxAudioManager.getFade();
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
/*     */   public void setBalanceLevel(short paramShort) {
/* 136 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setBalanceLevel:"); stringBuilder.append(paramShort); Log.d("FaderBalanceImp", stringBuilder.toString());
/* 137 */     if (paramShort < this.mBalanceLevelRange[0] || paramShort > this.mBalanceLevelRange[1]) {
/* 138 */       stringBuilder = new StringBuilder(); stringBuilder.append("setBalanceLevel: bad level value: "); stringBuilder.append(paramShort); Log.e("FaderBalanceImp", stringBuilder.toString());
/*     */       return;
/*     */     } 
/* 141 */     this.mEcarxAudioManager.setBalance(paramShort);
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
/*     */   public FunctionStatus isFaderSupported() {
/* 153 */     return FunctionStatus.active;
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
/*     */   public FunctionStatus isBalanceSupported() {
/* 165 */     return FunctionStatus.active;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registerFaderBalanceStateListener(IFaderBalance.IFaderBalanceStateListener paramIFaderBalanceStateListener) {
/* 170 */     Log.d("FaderBalanceImp", "registerFaderBalanceStateListener");
/* 171 */     this.mFaderBalanceStateListener = paramIFaderBalanceStateListener;
/* 172 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean unregisterFaderBalanceStateListener(IFaderBalance.IFaderBalanceStateListener paramIFaderBalanceStateListener) {
/* 177 */     Log.d("FaderBalanceImp", "unregisterFaderBalanceStateListener");
/* 178 */     this.mFaderBalanceStateListener = null;
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   class FaderBalanceCallback extends IFaderBalanceCallback.Stub { final FaderBalanceImp this$0;
/*     */     
/*     */     public void onFaderChanged(int param1Int) throws RemoteException {
/* 185 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onFaderChanged level: "); stringBuilder.append(param1Int); Log.d("FaderBalanceImp", stringBuilder.toString());
/* 186 */       if (FaderBalanceImp.this.mFaderBalanceStateListener != null) {
/* 187 */         FaderBalanceImp.this.mFaderBalanceStateListener.onFaderChanged(param1Int);
/*     */       } else {
/* 189 */         Log.e("FaderBalanceImp", "onFaderChanged mFaderBalanceStateListener is null");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void onBalanceChanged(int param1Int) throws RemoteException {
/* 195 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onBalanceChanged level: "); stringBuilder.append(param1Int); Log.d("FaderBalanceImp", stringBuilder.toString());
/* 196 */       if (FaderBalanceImp.this.mFaderBalanceStateListener != null) {
/* 197 */         FaderBalanceImp.this.mFaderBalanceStateListener.onBalanceChanged(param1Int);
/*     */       } else {
/* 199 */         Log.e("FaderBalanceImp", "onBalanceChanged mFaderBalanceStateListener is null");
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\audio\audiofx\FaderBalanceImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */