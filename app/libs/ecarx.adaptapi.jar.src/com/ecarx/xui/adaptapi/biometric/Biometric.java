package com.ecarx.xui.adaptapi.biometric;

import android.content.Context;

public class Biometric {
  private static IBiometric mBiometric;
  
  public static IBiometric create(Context paramContext) {
    // Byte code:
    //   0: getstatic com/ecarx/xui/adaptapi/biometric/Biometric.mBiometric : Lcom/ecarx/xui/adaptapi/biometric/IBiometric;
    //   3: ifnonnull -> 40
    //   6: ldc com/ecarx/xui/adaptapi/biometric/Biometric
    //   8: monitorenter
    //   9: getstatic com/ecarx/xui/adaptapi/biometric/Biometric.mBiometric : Lcom/ecarx/xui/adaptapi/biometric/IBiometric;
    //   12: ifnonnull -> 28
    //   15: new com/ecarx/xui/adaptapi/biometric/BiometricImpl
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/ecarx/xui/adaptapi/biometric/Biometric.mBiometric : Lcom/ecarx/xui/adaptapi/biometric/IBiometric;
    //   28: ldc com/ecarx/xui/adaptapi/biometric/Biometric
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/ecarx/xui/adaptapi/biometric/Biometric
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/ecarx/xui/adaptapi/biometric/Biometric.mBiometric : Lcom/ecarx/xui/adaptapi/biometric/IBiometric;
    //   43: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #36	-> 0
    //   #37	-> 6
    //   #38	-> 9
    //   #39	-> 15
    //   #41	-> 28
    //   #43	-> 40
    // Exception table:
    //   from	to	target	type
    //   9	15	34	finally
    //   15	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
  }
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\biometric\Biometric.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */