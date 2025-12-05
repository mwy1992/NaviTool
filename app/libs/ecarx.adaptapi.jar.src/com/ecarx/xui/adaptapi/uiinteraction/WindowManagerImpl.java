/*     */ package com.ecarx.xui.adaptapi.uiinteraction;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.graphics.Rect;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.util.Log;
/*     */ import android.view.IWindowChangeEcarXListener;
/*     */ import android.view.IWindowManager;
/*     */ import android.view.WindowInfoEcarx;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WindowManagerImpl
/*     */   implements IWindowManager
/*     */ {
/*  20 */   private final CopyOnWriteArrayList<IWindowManager.IWindowObserver> mEcarXListeners = new CopyOnWriteArrayList<>();
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isRegister = false;
/*     */ 
/*     */ 
/*     */   
/*  28 */   private IWindowChangeEcarXListener mIWindowChangeEcarXListener = (IWindowChangeEcarXListener)new IWindowChangeEcarXListener.Stub() {
/*     */       final WindowManagerImpl this$0;
/*     */       
/*     */       public void onWindowAdded(WindowInfoEcarx param1WindowInfoEcarx) throws RemoteException {
/*  32 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onWindowAdded: "); stringBuilder.append(param1WindowInfoEcarx.toString()); Log.d("WindowManagerImpl", stringBuilder.toString());
/*  33 */         WindowManagerImpl.this.notifyWindowChange(0, param1WindowInfoEcarx, 0);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onWindowRemoved(WindowInfoEcarx param1WindowInfoEcarx) throws RemoteException {
/*  39 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onWindowRemoved: "); stringBuilder.append(param1WindowInfoEcarx.toString()); Log.d("WindowManagerImpl", stringBuilder.toString());
/*  40 */         WindowManagerImpl.this.notifyWindowChange(1, param1WindowInfoEcarx, 0);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void onWindowVisibilityChanged(WindowInfoEcarx param1WindowInfoEcarx, int param1Int) throws RemoteException {
/*  46 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onWindowVisibilityChanged: "); stringBuilder.append(param1WindowInfoEcarx.toString()); Log.d("WindowManagerImpl", stringBuilder.toString());
/*  47 */         WindowManagerImpl.this.notifyWindowChange(2, param1WindowInfoEcarx, param1Int);
/*     */       }
/*     */     }; private static final int MSG_CALLBACK_WINDOW_ADD = 0; private static final int MSG_CALLBACK_WINDOW_REMOVE = 1; private static final int MSG_CALLBACK_WINDOW_VIS = 2;
/*     */   
/*     */   public WindowManagerImpl(Context paramContext) {
/*  52 */     this.mContext = paramContext;
/*     */     
/*  54 */     IBinder iBinder = ServiceManager.getService("window"); this.sWindowManager = IWindowManager.Stub.asInterface(iBinder);
/*     */     try {
/*  56 */       this.sWindowManager.registerWindowChangeListener(this.mIWindowChangeEcarXListener);
/*  57 */       this.isRegister = true;
/*  58 */     } catch (RemoteException remoteException) {
/*  59 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static final String TAG = "WindowManagerImpl";
/*     */   private Context mContext;
/*     */   private IWindowManager sWindowManager;
/*     */   
/*     */   public IWindowManager.IWindow[] getWindowList() {
/*  69 */     List<WindowInfoEcarx> list1, list2 = null; windowImpl[] arrayOfWindowImpl2 = null, arrayOfWindowImpl3 = null;
/*     */     
/*  71 */     windowImpl[] arrayOfWindowImpl1 = arrayOfWindowImpl2; try { if (this.sWindowManager != null)
/*  72 */       { arrayOfWindowImpl1 = arrayOfWindowImpl2; list2 = this.sWindowManager.getWindowInfo();
/*  73 */         arrayOfWindowImpl1 = arrayOfWindowImpl3; if (list2 != null) {
/*  74 */           arrayOfWindowImpl1 = arrayOfWindowImpl2; int i = list2.size();
/*  75 */           arrayOfWindowImpl1 = arrayOfWindowImpl2; arrayOfWindowImpl2 = new windowImpl[i];
/*  76 */           byte b = 0; while (true) { arrayOfWindowImpl1 = arrayOfWindowImpl2; if (b < i) {
/*  77 */               arrayOfWindowImpl1 = arrayOfWindowImpl2; windowImpl windowImpl = new windowImpl(); arrayOfWindowImpl1 = arrayOfWindowImpl2; this(this); arrayOfWindowImpl2[b] = windowImpl;
/*  78 */               arrayOfWindowImpl1 = arrayOfWindowImpl2; arrayOfWindowImpl2[b].castFromWindowInfo(list2.get(b)); b++; continue;
/*     */             }  break; }
/*     */         
/*     */         }  }
/*  82 */       else { arrayOfWindowImpl1 = arrayOfWindowImpl2; Log.e("WindowManagerImpl", "getWindowList null"); list1 = list2; }
/*     */       
/*     */        }
/*  85 */     catch (Exception exception)
/*  86 */     { exception.printStackTrace(); }
/*     */     
/*  88 */     return (IWindowManager.IWindow[])list1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerWindowObserver(IWindowManager.IWindowObserver paramIWindowObserver) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: ldc 'WindowManagerImpl'
/*     */     //   4: ldc 'registerWindowObserver: '
/*     */     //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   9: pop
/*     */     //   10: aload_0
/*     */     //   11: getfield isRegister : Z
/*     */     //   14: ifne -> 52
/*     */     //   17: aload_0
/*     */     //   18: getfield sWindowManager : Landroid/view/IWindowManager;
/*     */     //   21: astore_3
/*     */     //   22: aload_3
/*     */     //   23: ifnull -> 52
/*     */     //   26: aload_0
/*     */     //   27: getfield sWindowManager : Landroid/view/IWindowManager;
/*     */     //   30: aload_0
/*     */     //   31: getfield mIWindowChangeEcarXListener : Landroid/view/IWindowChangeEcarXListener;
/*     */     //   34: invokeinterface registerWindowChangeListener : (Landroid/view/IWindowChangeEcarXListener;)V
/*     */     //   39: aload_0
/*     */     //   40: iconst_1
/*     */     //   41: putfield isRegister : Z
/*     */     //   44: goto -> 52
/*     */     //   47: astore_3
/*     */     //   48: aload_3
/*     */     //   49: invokevirtual printStackTrace : ()V
/*     */     //   52: aload_0
/*     */     //   53: getfield mEcarXListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   56: aload_1
/*     */     //   57: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   60: istore_2
/*     */     //   61: aload_0
/*     */     //   62: monitorexit
/*     */     //   63: iload_2
/*     */     //   64: ireturn
/*     */     //   65: astore_1
/*     */     //   66: aload_0
/*     */     //   67: monitorexit
/*     */     //   68: aload_1
/*     */     //   69: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #100	-> 0
/*     */     //   #101	-> 2
/*     */     //   #102	-> 10
/*     */     //   #104	-> 26
/*     */     //   #105	-> 39
/*     */     //   #108	-> 44
/*     */     //   #106	-> 47
/*     */     //   #107	-> 48
/*     */     //   #110	-> 52
/*     */     //   #111	-> 65
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	10	65	finally
/*     */     //   10	22	65	finally
/*     */     //   26	39	47	android/os/RemoteException
/*     */     //   26	39	65	finally
/*     */     //   39	44	47	android/os/RemoteException
/*     */     //   39	44	65	finally
/*     */     //   48	52	65	finally
/*     */     //   52	63	65	finally
/*     */     //   66	68	65	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregisterWindowObserver(IWindowManager.IWindowObserver paramIWindowObserver) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: ldc 'WindowManagerImpl'
/*     */     //   4: ldc 'unregisterWindowObserver: '
/*     */     //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   9: pop
/*     */     //   10: aload_0
/*     */     //   11: getfield mEcarXListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   14: aload_1
/*     */     //   15: invokevirtual remove : (Ljava/lang/Object;)Z
/*     */     //   18: istore_2
/*     */     //   19: aload_0
/*     */     //   20: getfield mEcarXListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   23: invokevirtual size : ()I
/*     */     //   26: ifne -> 64
/*     */     //   29: aload_0
/*     */     //   30: getfield sWindowManager : Landroid/view/IWindowManager;
/*     */     //   33: astore_1
/*     */     //   34: aload_1
/*     */     //   35: ifnull -> 64
/*     */     //   38: aload_0
/*     */     //   39: getfield sWindowManager : Landroid/view/IWindowManager;
/*     */     //   42: aload_0
/*     */     //   43: getfield mIWindowChangeEcarXListener : Landroid/view/IWindowChangeEcarXListener;
/*     */     //   46: invokeinterface unregisterWindowChangeListener : (Landroid/view/IWindowChangeEcarXListener;)V
/*     */     //   51: aload_0
/*     */     //   52: iconst_0
/*     */     //   53: putfield isRegister : Z
/*     */     //   56: goto -> 64
/*     */     //   59: astore_1
/*     */     //   60: aload_1
/*     */     //   61: invokevirtual printStackTrace : ()V
/*     */     //   64: aload_0
/*     */     //   65: monitorexit
/*     */     //   66: iload_2
/*     */     //   67: ireturn
/*     */     //   68: astore_1
/*     */     //   69: aload_0
/*     */     //   70: monitorexit
/*     */     //   71: aload_1
/*     */     //   72: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #123	-> 0
/*     */     //   #124	-> 2
/*     */     //   #125	-> 10
/*     */     //   #126	-> 19
/*     */     //   #128	-> 38
/*     */     //   #129	-> 51
/*     */     //   #132	-> 56
/*     */     //   #130	-> 59
/*     */     //   #131	-> 60
/*     */     //   #134	-> 64
/*     */     //   #135	-> 68
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	10	68	finally
/*     */     //   10	19	68	finally
/*     */     //   19	34	68	finally
/*     */     //   38	51	59	android/os/RemoteException
/*     */     //   38	51	68	finally
/*     */     //   51	56	59	android/os/RemoteException
/*     */     //   51	56	68	finally
/*     */     //   60	64	68	finally
/*     */     //   64	66	68	finally
/*     */     //   69	71	68	finally
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class windowImpl
/*     */     implements IWindowManager.IWindow
/*     */   {
/*     */     private int displayid;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String identity;
/*     */ 
/*     */ 
/*     */     
/*     */     private String packageName;
/*     */ 
/*     */ 
/*     */     
/*     */     final WindowManagerImpl this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     private int type;
/*     */ 
/*     */ 
/*     */     
/*     */     private int uid;
/*     */ 
/*     */ 
/*     */     
/*     */     private int visiblity;
/*     */ 
/*     */ 
/*     */     
/*     */     private String windowTag;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getDisplayId() {
/* 149 */       return this.displayid;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPackage() {
/* 157 */       return this.packageName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getUID() {
/* 165 */       return this.uid;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getType() {
/* 172 */       return this.type;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getViewVisibility() {
/* 184 */       return this.visiblity;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getWindowIdentity() {
/* 193 */       return this.identity;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getWindowTag() {
/* 202 */       return this.windowTag;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Rect getWindowFrame() {
/* 213 */       return null;
/*     */     }
/*     */     
/*     */     public void castFromWindowInfo(WindowInfoEcarx param1WindowInfoEcarx) {
/* 217 */       this.displayid = param1WindowInfoEcarx.displayId;
/* 218 */       this.uid = param1WindowInfoEcarx.uid;
/* 219 */       this.type = param1WindowInfoEcarx.type;
/* 220 */       this.visiblity = param1WindowInfoEcarx.visibility;
/* 221 */       this.packageName = param1WindowInfoEcarx.packageName;
/* 222 */       this.windowTag = param1WindowInfoEcarx.windowTag;
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyWindowChange(int paramInt1, WindowInfoEcarx paramWindowInfoEcarx, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: new com/ecarx/xui/adaptapi/uiinteraction/WindowManagerImpl$windowImpl
/*     */     //   3: dup
/*     */     //   4: aload_0
/*     */     //   5: invokespecial <init> : (Lcom/ecarx/xui/adaptapi/uiinteraction/WindowManagerImpl;)V
/*     */     //   8: astore #4
/*     */     //   10: aload #4
/*     */     //   12: aload_2
/*     */     //   13: invokevirtual castFromWindowInfo : (Landroid/view/WindowInfoEcarx;)V
/*     */     //   16: aload_0
/*     */     //   17: getfield mEcarXListeners : Ljava/util/concurrent/CopyOnWriteArrayList;
/*     */     //   20: invokevirtual iterator : ()Ljava/util/Iterator;
/*     */     //   23: astore_2
/*     */     //   24: aload_2
/*     */     //   25: invokeinterface hasNext : ()Z
/*     */     //   30: ifeq -> 136
/*     */     //   33: aload_2
/*     */     //   34: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   39: checkcast com/ecarx/xui/adaptapi/uiinteraction/IWindowManager$IWindowObserver
/*     */     //   42: astore #5
/*     */     //   44: iload_1
/*     */     //   45: tableswitch default -> 72, 0 -> 111, 1 -> 99, 2 -> 75
/*     */     //   72: goto -> 133
/*     */     //   75: aload #5
/*     */     //   77: instanceof com/ecarx/xui/adaptapi/uiinteraction/IWindowManager$IWindowViewObserver
/*     */     //   80: ifeq -> 133
/*     */     //   83: aload #5
/*     */     //   85: checkcast com/ecarx/xui/adaptapi/uiinteraction/IWindowManager$IWindowViewObserver
/*     */     //   88: aload #4
/*     */     //   90: iload_3
/*     */     //   91: invokeinterface onWindowVisibilityChanged : (Lcom/ecarx/xui/adaptapi/uiinteraction/IWindowManager$IWindow;I)V
/*     */     //   96: goto -> 133
/*     */     //   99: aload #5
/*     */     //   101: aload #4
/*     */     //   103: invokeinterface onWindowRemoved : (Lcom/ecarx/xui/adaptapi/uiinteraction/IWindowManager$IWindow;)V
/*     */     //   108: goto -> 133
/*     */     //   111: aload #5
/*     */     //   113: aload #4
/*     */     //   115: invokeinterface onWindowAdded : (Lcom/ecarx/xui/adaptapi/uiinteraction/IWindowManager$IWindow;)V
/*     */     //   120: goto -> 133
/*     */     //   123: astore #5
/*     */     //   125: aload #5
/*     */     //   127: invokevirtual printStackTrace : ()V
/*     */     //   130: goto -> 133
/*     */     //   133: goto -> 24
/*     */     //   136: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #227	-> 0
/*     */     //   #228	-> 10
/*     */     //   #229	-> 16
/*     */     //   #231	-> 44
/*     */     //   #239	-> 75
/*     */     //   #240	-> 83
/*     */     //   #236	-> 99
/*     */     //   #237	-> 108
/*     */     //   #233	-> 111
/*     */     //   #234	-> 120
/*     */     //   #245	-> 123
/*     */     //   #246	-> 125
/*     */     //   #247	-> 133
/*     */     //   #248	-> 133
/*     */     //   #249	-> 136
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   75	83	123	java/lang/Exception
/*     */     //   83	96	123	java/lang/Exception
/*     */     //   99	108	123	java/lang/Exception
/*     */     //   111	120	123	java/lang/Exception
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\uiinteraction\WindowManagerImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */