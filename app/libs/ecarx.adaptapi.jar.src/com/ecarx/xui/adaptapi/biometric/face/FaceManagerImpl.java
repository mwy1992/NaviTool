/*     */ package com.ecarx.xui.adaptapi.biometric.face;
/*     */ 
/*     */ import android.os.CancellationSignal;
/*     */ import android.os.Handler;
/*     */ import com.ecarx.xui.adaptapi.car.userprofile.IUserProfile;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FaceManagerImpl
/*     */   implements IFaceManager
/*     */ {
/*     */   private final IUserProfile mUserProfile;
/*     */   
/*     */   public FaceManagerImpl(IUserProfile paramIUserProfile) {
/*  16 */     this.mUserProfile = paramIUserProfile;
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
/*     */   public void authenticate(CancellationSignal paramCancellationSignal, int paramInt, IFaceManager.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler) {}
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
/*     */   public void enroll(byte[] paramArrayOfbyte, CancellationSignal paramCancellationSignal, final IFaceManager.EnrollmentCallback callback) {
/*  59 */     this.mUserProfile.registerUserProfileObserver(new IUserProfile.IUserProfileObserver()
/*     */         {
/*     */           final FaceManagerImpl this$0;
/*     */           final IFaceManager.EnrollmentCallback val$callback;
/*     */           
/*     */           public void onUserProfileAdded(int param1Int) {}
/*     */           
/*     */           public void onUserProfileActionStatus(int param1Int1, int param1Int2, int param1Int3) {
/*  67 */             if (param1Int1 == 33) {
/*  68 */               if (3 == param1Int3) {
/*  69 */                 callback.onEnrollmentProgress(0);
/*  70 */                 FaceManagerImpl.this.mUserProfile.unregisterUserProfileObserver(this);
/*  71 */               } else if (4 == param1Int3) {
/*  72 */                 callback.onEnrollmentError(1, "注册人脸失败");
/*  73 */                 FaceManagerImpl.this.mUserProfile.unregisterUserProfileObserver(this);
/*     */               } 
/*     */             }
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onUserProfileActionError(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onLoadAndStoreEveMemPosnAction(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onLoadAndStoreMemPosnAction(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onFaceDetectedAndRecognizedStatus(int param1Int) {}
/*     */         });
/*  98 */     IUserProfile iUserProfile1 = this.mUserProfile, iUserProfile3 = this.mUserProfile, iUserProfile2 = this.mUserProfile;
/*  99 */     String str = iUserProfile3.getUserId(iUserProfile2.getCurrentId());
/*     */     iUserProfile1.notifyUIDInfoToProfile(33, str, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(IFace paramIFace, final IFaceManager.RemovalCallback callback) {
/* 110 */     this.mUserProfile.registerUserProfileObserver(new IUserProfile.IUserProfileObserver()
/*     */         {
/*     */           final FaceManagerImpl this$0;
/*     */           final IFaceManager.RemovalCallback val$callback;
/*     */           
/*     */           public void onUserProfileAdded(int param1Int) {}
/*     */           
/*     */           public void onUserProfileActionStatus(int param1Int1, int param1Int2, int param1Int3) {
/* 118 */             if (param1Int1 == 34) {
/* 119 */               if (3 == param1Int3) {
/* 120 */                 callback.onRemovalSucceeded(new FaceImpl(), 0);
/* 121 */                 FaceManagerImpl.this.mUserProfile.unregisterUserProfileObserver(this);
/* 122 */               } else if (4 == param1Int3) {
/* 123 */                 callback.onRemovalError(new FaceImpl(), 1, "移除人脸失败");
/* 124 */                 FaceManagerImpl.this.mUserProfile.unregisterUserProfileObserver(this);
/*     */               } 
/*     */             }
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onUserProfileActionError(int param1Int1, int param1Int2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onLoadAndStoreEveMemPosnAction(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onLoadAndStoreMemPosnAction(int param1Int) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void onFaceDetectedAndRecognizedStatus(int param1Int) {}
/*     */         });
/* 149 */     IUserProfile iUserProfile1 = this.mUserProfile, iUserProfile3 = this.mUserProfile, iUserProfile2 = this.mUserProfile;
/* 150 */     String str = iUserProfile3.getUserId(iUserProfile2.getCurrentId());
/*     */     iUserProfile1.notifyUIDInfoToProfile(34, str, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IFace> getEnrolledFaces() {
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHardwareDetected() {
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\biometric\face\FaceManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */