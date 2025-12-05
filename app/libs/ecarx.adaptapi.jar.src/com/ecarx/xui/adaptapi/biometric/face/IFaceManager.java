package com.ecarx.xui.adaptapi.biometric.face;

import android.os.CancellationSignal;
import android.os.Handler;
import com.ecarx.xui.adaptapi.NonNull;
import com.ecarx.xui.adaptapi.Nullable;
import java.util.List;

public interface IFaceManager {
  void authenticate(@Nullable CancellationSignal paramCancellationSignal, int paramInt, @NonNull AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler);
  
  void enroll(byte[] paramArrayOfbyte, CancellationSignal paramCancellationSignal, EnrollmentCallback paramEnrollmentCallback);
  
  List<IFace> getEnrolledFaces();
  
  boolean isHardwareDetected();
  
  void remove(IFace paramIFace, RemovalCallback paramRemovalCallback);
  
  public static interface AuthenticationCallback {
    void onAuthenticationAcquired(int param1Int);
    
    void onAuthenticationError(int param1Int, CharSequence param1CharSequence);
    
    void onAuthenticationFailed();
    
    void onAuthenticationHelp(int param1Int, CharSequence param1CharSequence);
    
    void onAuthenticationSucceeded(IFaceManager.AuthenticationResult param1AuthenticationResult);
  }
  
  public static interface AuthenticationResult extends FaceResult {}
  
  public static interface EnrollmentCallback {
    void onEnrollmentError(int param1Int, CharSequence param1CharSequence);
    
    void onEnrollmentHelp(int param1Int, CharSequence param1CharSequence);
    
    void onEnrollmentProgress(int param1Int);
    
    void onEnrollmentSucceeded(IFaceManager.EnrollmentResult param1EnrollmentResult);
  }
  
  public static interface EnrollmentResult extends FaceResult {}
  
  public static interface FaceResult {
    IFace getFace();
    
    int getUserId();
    
    boolean isStrongBiometric();
  }
  
  public static interface RemovalCallback {
    void onRemovalError(IFace param1IFace, int param1Int, CharSequence param1CharSequence);
    
    void onRemovalSucceeded(IFace param1IFace, int param1Int);
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\biometric\face\IFaceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */