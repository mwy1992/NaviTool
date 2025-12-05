/*    */ package com.ecarx.xui.adaptapi.input;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.util.Log;
/*    */ import android.view.inputmethod.InputMethodManager;
/*    */ 
/*    */ public class InputMethodImpl
/*    */   extends InputMethod
/*    */ {
/*    */   private static final String TAG = "InputMethodImpl";
/*    */   public static Context mContext;
/* 12 */   private IInputMethodCallback mInputMethodCallback = null;
/* 13 */   private InputMethodManager mInputMethodManager = null;
/*    */   
/*    */   private InputMethodImpl(Context paramContext) {
/* 16 */     mContext = paramContext;
/* 17 */     Context context = mContext; paramContext = mContext; this.mInputMethodManager = (InputMethodManager)context.getSystemService("input_method");
/* 18 */     if (this.mInputMethodManager != null) {
/* 19 */       this.mInputMethodManager.registerInputMethodVisibleChangedListener(new InputMethodCallback());
/*    */     } else {
/* 21 */       Log.i("InputMethodImpl", "mInputMethodManager is null");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static InputMethodImpl create(Context paramContext) {
/*    */     // Byte code:
/*    */     //   0: ldc com/ecarx/xui/adaptapi/input/InputMethodImpl
/*    */     //   2: monitorenter
/*    */     //   3: aload_0
/*    */     //   4: ifnonnull -> 24
/*    */     //   7: ldc 'InputMethodImpl'
/*    */     //   9: ldc ' InputMethodImpl context null'
/*    */     //   11: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*    */     //   14: pop
/*    */     //   15: ldc com/ecarx/xui/adaptapi/input/InputMethodImpl
/*    */     //   17: monitorexit
/*    */     //   18: aconst_null
/*    */     //   19: areturn
/*    */     //   20: astore_0
/*    */     //   21: goto -> 46
/*    */     //   24: ldc 'InputMethodImpl'
/*    */     //   26: ldc ' InputMethodImpl create'
/*    */     //   28: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*    */     //   31: pop
/*    */     //   32: new com/ecarx/xui/adaptapi/input/InputMethodImpl
/*    */     //   35: dup
/*    */     //   36: aload_0
/*    */     //   37: invokespecial <init> : (Landroid/content/Context;)V
/*    */     //   40: astore_0
/*    */     //   41: ldc com/ecarx/xui/adaptapi/input/InputMethodImpl
/*    */     //   43: monitorexit
/*    */     //   44: aload_0
/*    */     //   45: areturn
/*    */     //   46: ldc com/ecarx/xui/adaptapi/input/InputMethodImpl
/*    */     //   48: monitorexit
/*    */     //   49: aload_0
/*    */     //   50: athrow
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #32	-> 3
/*    */     //   #33	-> 7
/*    */     //   #34	-> 15
/*    */     //   #31	-> 20
/*    */     //   #36	-> 24
/*    */     //   #37	-> 32
/*    */     //   #31	-> 46
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   7	15	20	finally
/*    */     //   24	32	20	finally
/*    */     //   32	41	20	finally
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerInputMethodVisibleChangedListener(IInputMethodCallback paramIInputMethodCallback) {
/* 42 */     Log.d("InputMethodImpl", "registerInputMethodVisibleChangedListener");
/* 43 */     this.mInputMethodCallback = paramIInputMethodCallback;
/*    */   }
/*    */ 
/*    */   
/*    */   public void unregisterInputMethodVisibleChangedListener(IInputMethodCallback paramIInputMethodCallback) {
/* 48 */     Log.d("InputMethodImpl", "unregisterInputMethodVisibleChangedListener");
/* 49 */     this.mInputMethodCallback = null;
/*    */   }
/*    */   
/*    */   private class InputMethodCallback implements InputMethodManager.InputMethodVisibleChangedListener { final InputMethodImpl this$0;
/*    */     
/*    */     public void onVisibleStateChanged(boolean param1Boolean, int param1Int) {
/* 55 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onVisibleStateChanged input = "); stringBuilder.append(param1Boolean); stringBuilder.append(" display = "); stringBuilder.append(param1Int); Log.d("InputMethodImpl", stringBuilder.toString());
/* 56 */       if (InputMethodImpl.this.mInputMethodCallback != null) {
/* 57 */         Log.d("InputMethodImpl", "onVisibleStateChanged");
/* 58 */         InputMethodImpl.this.mInputMethodCallback.onVisibleStateChanged(param1Boolean, param1Int);
/*    */       } 
/*    */     }
/*    */     
/*    */     private InputMethodCallback() {} }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\input\InputMethodImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */