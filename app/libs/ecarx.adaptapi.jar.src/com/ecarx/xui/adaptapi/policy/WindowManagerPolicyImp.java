/*     */ package com.ecarx.xui.adaptapi.policy;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.Log;
/*     */ import android.view.Display;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WindowManagerPolicyImp
/*     */   implements IWindowManagerPolicy
/*     */ {
/*  12 */   private static final String TAG = WindowManagerPolicyImp.class.getSimpleName();
/*     */ 
/*     */   
/*     */   private static WindowManagerPolicyImp sInstance;
/*     */ 
/*     */   
/*     */   private Context mContext;
/*     */ 
/*     */ 
/*     */   
/*     */   public static WindowManagerPolicyImp getInstance(Context paramContext) {
/*     */     // Byte code:
/*     */     //   0: getstatic com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp;
/*     */     //   3: ifnonnull -> 40
/*     */     //   6: ldc com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp
/*     */     //   8: monitorenter
/*     */     //   9: getstatic com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp;
/*     */     //   12: ifnonnull -> 28
/*     */     //   15: new com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp
/*     */     //   18: astore_1
/*     */     //   19: aload_1
/*     */     //   20: aload_0
/*     */     //   21: invokespecial <init> : (Landroid/content/Context;)V
/*     */     //   24: aload_1
/*     */     //   25: putstatic com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp;
/*     */     //   28: ldc com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp
/*     */     //   30: monitorexit
/*     */     //   31: goto -> 40
/*     */     //   34: astore_0
/*     */     //   35: ldc com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp
/*     */     //   37: monitorexit
/*     */     //   38: aload_0
/*     */     //   39: athrow
/*     */     //   40: getstatic com/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp.sInstance : Lcom/ecarx/xui/adaptapi/policy/WindowManagerPolicyImp;
/*     */     //   43: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #18	-> 0
/*     */     //   #19	-> 6
/*     */     //   #20	-> 9
/*     */     //   #21	-> 15
/*     */     //   #23	-> 28
/*     */     //   #25	-> 40
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   9	15	34	finally
/*     */     //   15	28	34	finally
/*     */     //   28	31	34	finally
/*     */     //   35	38	34	finally
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WindowManagerPolicyImp(Context paramContext) {
/*  29 */     this.mContext = paramContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWindowTypeByCode(String paramString) {
/*  43 */     short s2 = -1;
/*  44 */     switch (paramString.hashCode()) { default: s1 = -1; break;case 2127799689: if (paramString.equals("SCREENSAVER")) { s1 = 9; break; } case 1844841805: if (paramString.equals("SWIPE_FROM_LEFT_VIEW")) { s1 = 1; break; } case 1726795841: if (paramString.equals("INTELLIGENT_AVATAR")) { s1 = 22; break; } case 1332649483: if (paramString.equals("NOTIFY_CENTER")) { s1 = 8; break; } case 1251064393: if (paramString.equals("APP_TOAST")) { s1 = 7; break; } case 1123692459: if (paramString.equals("NEWCOMER_GUIDE")) { s1 = 14; break; } case 1104392617: if (paramString.equals("SWIPE_FROM_BOTTOM_VIEW")) { s1 = 4; break; } case 913039256: if (paramString.equals("SWIPE_FROM_RIGHT_VIEW")) { s1 = 3; break; } case 734374438: if (paramString.equals("STATUS_BAR")) { s1 = 27; break; } case 591425495: if (paramString.equals("LANDING_PAGE")) { s1 = 24; break; } case 522488984: if (paramString.equals("STATUS_BAR_POP")) { s1 = 28; break; } case 479358555: if (paramString.equals("ACTIVATE_PAGE")) { s1 = 23; break; } case 451437567: if (paramString.equals("SWIPE_FROM_TOP_VIEW")) { s1 = 2; break; } case 165989764: if (paramString.equals("LOCK_SCREEN_VIEW")) { s1 = 0; break; } case 82295: if (paramString.equals("SOS")) { s1 = 18; break; } case -74951327: if (paramString.equals("PARTIAL")) { s1 = 15; break; } case -223295248: if (paramString.equals("HARDWARE_TOAST")) { s1 = 16; break; } case -272958329: if (paramString.equals("APP_POP_FULLSCREEN")) { s1 = 6; break; } case -333520503: if (paramString.equals("OTA_POPUP")) { s1 = 11; break; } case -501840355: if (paramString.equals("UNLOCK_SCREEN_VIEW")) { s1 = 5; break; } case -869710199: if (paramString.equals("SPLIT_WINDOW_MENU")) { s1 = 25; break; } case -896673658: if (paramString.equals("THEME_LOADING")) { s1 = 20; break; } case -1653832372: if (paramString.equals("CAMERA_RADAR")) { s1 = 19; break; } case -1706170251: if (paramString.equals("XIAOKA")) { s1 = 10; break; } case -1708334291: if (paramString.equals("DRIVING_MODE_POP")) { s1 = 17; break; } case -1936691621: if (paramString.equals("PHONE_POPUP")) { s1 = 12; break; } case -1941568614: if (paramString.equals("STARTUP_WARNING")) { s1 = 21; break; } case -1959168835: if (paramString.equals("ONCALL")) { s1 = 13; break; } case -2008351928: if (paramString.equals("NAVIGATION_BAR")) { s1 = 26; break; }  }  switch (s1) { default: s1 = s2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 133 */         str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString());
/* 134 */         return s1;case 28: s1 = 2071; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 27: s1 = 2070; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 26: s1 = 2069; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 25: s1 = 2068; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 24: s1 = 2067; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 23: s1 = 2066; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 22: s1 = 2065; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 21: s1 = 2064; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 20: s1 = 2061; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 19: s1 = 2059; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 18: s1 = 2058; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 17: s1 = 2057; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 16: s1 = 2056; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 15: s1 = 2055; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 14: s1 = 2054; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 13: s1 = 2053; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 12: s1 = 2051; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 11: s1 = 2049; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 10: s1 = 2048; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 9: s1 = 2047; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 8: s1 = 2046; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 7: s1 = 2041; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 6: s1 = 2040; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 5: s1 = 2052; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 4: s1 = 2044; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 3: s1 = 2042; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 2: s1 = 2043; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 1: s1 = 2045; str = TAG; stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;case 0: break; }  short s1 = 2050; String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(" getWindowTypeByCode("); stringBuilder.append(paramString); stringBuilder.append(")...result ("); stringBuilder.append(s1); stringBuilder.append(")..."); Log.d(str, stringBuilder.toString()); return s1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWindowTypeByCode(String paramString, Display paramDisplay) {
/* 153 */     return getWindowTypeByCode(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\policy\WindowManagerPolicyImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */