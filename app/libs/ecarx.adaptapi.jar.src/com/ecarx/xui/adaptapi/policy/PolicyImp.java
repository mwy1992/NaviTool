/*     */ package com.ecarx.xui.adaptapi.policy;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.binder.IConnectable;
/*     */ 
/*     */ public class PolicyImp
/*     */   extends Policy
/*     */   implements IConnectable {
/*  10 */   private final String TAG = "PolicyImp";
/*     */   private IAudioAttributes mAudioAttributes;
/*     */   private final IAudioPolicy mAudioPolicy;
/*     */   private IConnectable.IConnectWatcher mIConnectWatcher;
/*     */   private final IStoragePolicy mStoragePolicy;
/*     */   private final IVoiceAssistantPolicy mVoiceAssistantPolicy;
/*     */   private final IWindowManagerPolicy mWindowManagerPolicy;
/*     */   
/*     */   private PolicyImp(Context paramContext) {
/*  19 */     this.mAudioPolicy = new AudioPolicyImp(paramContext);
/*  20 */     this.mStoragePolicy = new StoragePolicyImp(paramContext);
/*  21 */     this.mVoiceAssistantPolicy = new VoiceAssistantPolicyImp(paramContext);
/*  22 */     this.mWindowManagerPolicy = new WindowManagerPolicyImp(paramContext);
/*  23 */     this.mAudioAttributes = new AudioAttributesImp(paramContext, this);
/*     */   }
/*     */   
/*     */   public static Policy create(Context paramContext) {
/*  27 */     PolicyImp policyImp = null;
/*  28 */     if (paramContext != null) {
/*  29 */       policyImp = new PolicyImp(paramContext);
/*     */     }
/*  31 */     return policyImp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAudioPolicy getAudioPolicy() {
/*  39 */     return this.mAudioPolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IStoragePolicy getStoragePolicy() {
/*  49 */     return this.mStoragePolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IVoiceAssistantPolicy getVoiceAssistantPolicy() {
/*  59 */     return this.mVoiceAssistantPolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IWindowManagerPolicy getWindowManagerPolicy() {
/*  69 */     return this.mWindowManagerPolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAudioAttributes getAudioAttributes() {
/*  78 */     return this.mAudioAttributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerConnectWatcher(IConnectable.IConnectWatcher paramIConnectWatcher) {
/*  88 */     this.mIConnectWatcher = paramIConnectWatcher;
/*  89 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("registerConnectWatcher: "); stringBuilder.append(this.mIConnectWatcher); Log.d("PolicyImp", stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterConnectWatcher() {
/*  97 */     this.mIConnectWatcher = null;
/*  98 */     Log.d("PolicyImp", "unregisterConnectWatcher");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() {
/* 106 */     if (this.mIConnectWatcher != null) {
/* 107 */       this.mIConnectWatcher.onConnected();
/* 108 */       Log.d("PolicyImp", "onConnected");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void disconnect() {
/* 117 */     if (this.mIConnectWatcher != null) {
/* 118 */       this.mIConnectWatcher.onDisConnected();
/* 119 */       Log.d("PolicyImp", "disconnect");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\PolicyImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */