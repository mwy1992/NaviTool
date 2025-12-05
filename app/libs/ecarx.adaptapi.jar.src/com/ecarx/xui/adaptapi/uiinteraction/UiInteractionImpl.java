/*    */ package com.ecarx.xui.adaptapi.uiinteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.view.Display;
/*    */ import com.ecarx.xui.adaptapi.CallStatus;
/*    */ import com.ecarx.xui.adaptapi.NonNull;
/*    */ import com.ecarx.xui.adaptapi.Nullable;
/*    */ 
/*    */ public class UiInteractionImpl
/*    */   extends UiInteraction
/*    */   implements IUiInteraction {
/*    */   private Context mContext;
/*    */   private IFreeFormWindow mIFreeFormWindow;
/*    */   private IMultiWindow mIMultiWindow;
/*    */   private ITouchManager mITouchManager;
/*    */   private IWindowManager mIWindowManager;
/*    */   
/*    */   private UiInteractionImpl(Context paramContext) {
/* 19 */     this.mContext = paramContext;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IUiInteraction create(Context paramContext) {
/*    */     // Byte code:
/*    */     //   0: ldc com/ecarx/xui/adaptapi/uiinteraction/UiInteractionImpl
/*    */     //   2: monitorenter
/*    */     //   3: aconst_null
/*    */     //   4: astore_1
/*    */     //   5: aload_0
/*    */     //   6: ifnull -> 27
/*    */     //   9: new com/ecarx/xui/adaptapi/uiinteraction/UiInteractionImpl
/*    */     //   12: dup
/*    */     //   13: aload_0
/*    */     //   14: invokespecial <init> : (Landroid/content/Context;)V
/*    */     //   17: astore_1
/*    */     //   18: goto -> 27
/*    */     //   21: astore_0
/*    */     //   22: ldc com/ecarx/xui/adaptapi/uiinteraction/UiInteractionImpl
/*    */     //   24: monitorexit
/*    */     //   25: aload_0
/*    */     //   26: athrow
/*    */     //   27: ldc com/ecarx/xui/adaptapi/uiinteraction/UiInteractionImpl
/*    */     //   29: monitorexit
/*    */     //   30: aload_1
/*    */     //   31: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #23	-> 3
/*    */     //   #24	-> 5
/*    */     //   #25	-> 9
/*    */     //   #22	-> 21
/*    */     //   #27	-> 27
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   9	18	21	finally
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IMultiWindow getMultiWindowManager() {
/* 32 */     if (this.mIMultiWindow == null) {
/* 33 */       this.mIMultiWindow = new MultiWindowImpl(this.mContext);
/*    */     }
/* 35 */     return this.mIMultiWindow;
/*    */   }
/*    */ 
/*    */   
/*    */   public IFreeFormWindow getFreeFormWindowManager() {
/* 40 */     if (this.mIFreeFormWindow == null) {
/* 41 */       this.mIFreeFormWindow = new FreeFormWindowImpl(this.mContext);
/*    */     }
/* 43 */     return this.mIFreeFormWindow;
/*    */   }
/*    */ 
/*    */   
/*    */   public ITouchManager getTouchManager() {
/* 48 */     if (this.mITouchManager == null) {
/* 49 */       this.mITouchManager = new TouchManagerImpl(this.mContext);
/*    */     }
/* 51 */     return this.mITouchManager;
/*    */   }
/*    */ 
/*    */   
/*    */   public IWindowManager getWindowManager() {
/* 56 */     if (this.mIWindowManager == null) {
/* 57 */       this.mIWindowManager = new WindowManagerImpl(this.mContext);
/*    */     }
/* 59 */     return this.mIWindowManager;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CallStatus startApplicationToDisplay(@NonNull String paramString, @Nullable Display paramDisplay1, @NonNull Display paramDisplay2) {
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\UiInteractionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */