package android.car.cluster.renderer;

import android.annotation.SystemApi;
import android.car.navigation.CarNavigationInstrumentCluster;
import android.os.Bundle;

@SystemApi
public abstract class NavigationRenderer {
  public abstract CarNavigationInstrumentCluster getNavigationProperties();
  
  public abstract void onEvent(int paramInt, Bundle paramBundle);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\NavigationRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */