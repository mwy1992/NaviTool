/*    */ package com.ecarx.xui.adaptapi.peripherals;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.AdaptAPI;
/*    */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*    */ import com.ecarx.xui.adaptapi.peripherals.wear.IIntelligentKey;
/*    */ import java.lang.annotation.Retention;
/*    */ import java.lang.annotation.RetentionPolicy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Peripherals
/*    */   extends AdaptAPI
/*    */ {
/*    */   public static Peripherals create(Context paramContext) {
/* 34 */     return PeripheralsImp.create(paramContext);
/*    */   }
/*    */   
/*    */   public abstract IIntelligentKey getIntelligentKey();
/*    */   
/*    */   public abstract boolean isIntelligentKeySupport();
/*    */   
/*    */   @VendorDefinition(author = "@ECARX", date = "2022-06-21", project = "EF1E")
/*    */   public abstract void setRemoteAction(int paramInt);
/*    */   
/*    */   @Retention(RetentionPolicy.SOURCE)
/*    */   static @interface RemoteAction {
/*    */     public static final int REMOTE_ACTION_BACK = 5;
/*    */     public static final int REMOTE_ACTION_DOWN_SHORT_PRESS = 9;
/*    */     public static final int REMOTE_ACTION_HIBOARD = 4;
/*    */     public static final int REMOTE_ACTION_HOME = 2;
/*    */     public static final int REMOTE_ACTION_HVAC_CONTROL = 23;
/*    */     public static final int REMOTE_ACTION_LEFT_LONG_PRESS = 12;
/*    */     public static final int REMOTE_ACTION_LEFT_LONG_PRESS_END = 19;
/*    */     public static final int REMOTE_ACTION_LEFT_SHORT_PRESS = 10;
/*    */     public static final int REMOTE_ACTION_MENU = 6;
/*    */     public static final int REMOTE_ACTION_MUTE = 3;
/*    */     public static final int REMOTE_ACTION_OK = 7;
/*    */     public static final int REMOTE_ACTION_RIGHT_LONG_PRESS = 13;
/*    */     public static final int REMOTE_ACTION_RIGHT_LONG_PRESS_END = 20;
/*    */     public static final int REMOTE_ACTION_RIGHT_SHORT_PRESS = 11;
/*    */     public static final int REMOTE_ACTION_SETTINGS = 18;
/*    */     public static final int REMOTE_ACTION_SWITCH = 1;
/*    */     public static final int REMOTE_ACTION_UP_SHORT_PRESS = 8;
/*    */     public static final int REMOTE_ACTION_VOLUME_PLUS_LONG_PRESS_END = 21;
/*    */     public static final int REMOTE_ACTION_VOLUME_PLUS_LONG_PRESS_START = 16;
/*    */     public static final int REMOTE_ACTION_VOLUME_PLUS_SHORT_PRESS_START = 14;
/*    */     public static final int REMOTE_ACTION_VOLUME_REDUCE_LONG_PRESS_END = 22;
/*    */     public static final int REMOTE_ACTION_VOLUME_REDUCE_LONG_PRESS_START = 17;
/*    */     public static final int REMOTE_ACTION_VOLUME_REDUCE_SHORT_PRESS_START = 15;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\peripherals\Peripherals.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */