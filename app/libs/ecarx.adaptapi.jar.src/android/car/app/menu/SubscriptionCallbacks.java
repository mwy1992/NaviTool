package android.car.app.menu;

import android.os.Bundle;
import java.util.List;

public abstract class SubscriptionCallbacks {
  public abstract void onChildChanged(String paramString, Bundle paramBundle);
  
  public abstract void onChildrenLoaded(String paramString, List<Bundle> paramList);
  
  public abstract void onError(String paramString);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\app\menu\SubscriptionCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */