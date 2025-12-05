package com.ecarx.xui.adaptapi.evs;

import android.view.SurfaceHolder;

@Deprecated
public interface IEvsCamera {
  boolean doTouchDown(int paramInt1, int paramInt2);
  
  boolean doTouchMove(int paramInt1, int paramInt2);
  
  boolean doTouchUp(int paramInt1, int paramInt2);
  
  boolean open(int paramInt);
  
  boolean release();
  
  boolean setPreviewDisplay(SurfaceHolder paramSurfaceHolder);
  
  boolean startPreview();
  
  boolean stopPreview();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\evs\IEvsCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */