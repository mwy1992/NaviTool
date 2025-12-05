package com.ecarx.xui.adaptapi.uiinteraction;

import android.view.Display;
import com.ecarx.xui.adaptapi.CallStatus;
import com.ecarx.xui.adaptapi.NonNull;
import com.ecarx.xui.adaptapi.Nullable;

public interface IUiInteraction {
  IFreeFormWindow getFreeFormWindowManager();
  
  IMultiWindow getMultiWindowManager();
  
  ITouchManager getTouchManager();
  
  IWindowManager getWindowManager();
  
  CallStatus startApplicationToDisplay(@Nullable String paramString, @NonNull Display paramDisplay1, @NonNull Display paramDisplay2);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\IUiInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */