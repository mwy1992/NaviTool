package android.car.app.menu;

import android.os.Bundle;

public abstract class CarMenuCallbacks {
  public abstract RootMenu getRootMenu(Bundle paramBundle);
  
  public abstract void onCarMenuClosed();
  
  public abstract void onCarMenuClosing();
  
  public abstract void onCarMenuOpened();
  
  public abstract void onCarMenuOpening();
  
  public abstract void onItemClicked(String paramString);
  
  public abstract boolean onItemLongClicked(String paramString);
  
  public abstract boolean onMenuClicked();
  
  public abstract void subscribe(String paramString, SubscriptionCallbacks paramSubscriptionCallbacks);
  
  public abstract void unsubscribe(String paramString, SubscriptionCallbacks paramSubscriptionCallbacks);
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\app\menu\CarMenuCallbacks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */