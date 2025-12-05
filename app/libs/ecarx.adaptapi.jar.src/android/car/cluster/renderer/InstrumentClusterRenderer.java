package android.car.cluster.renderer;

import android.annotation.SystemApi;
import android.content.Context;

@SystemApi
public abstract class InstrumentClusterRenderer {
  private NavigationRenderer mNavigationRenderer;
  
  protected abstract NavigationRenderer createNavigationRenderer();
  
  public NavigationRenderer getNavigationRenderer() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mNavigationRenderer : Landroid/car/cluster/renderer/NavigationRenderer;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Line number table:
    //   Java source line number -> byte code offset
    //   #50	-> 2
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final void initialize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: invokevirtual createNavigationRenderer : ()Landroid/car/cluster/renderer/NavigationRenderer;
    //   7: putfield mNavigationRenderer : Landroid/car/cluster/renderer/NavigationRenderer;
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Line number table:
    //   Java source line number -> byte code offset
    //   #59	-> 2
    //   #60	-> 10
    //   #58	-> 13
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\InstrumentClusterRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */