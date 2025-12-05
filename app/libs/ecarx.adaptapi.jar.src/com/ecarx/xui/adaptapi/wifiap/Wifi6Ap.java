/*    */ package com.ecarx.xui.adaptapi.wifiap;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.List;
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
/*    */ public abstract class Wifi6Ap
/*    */   extends WifiAp
/*    */ {
/*    */   public static Wifi6Ap create(Context paramContext) {
/*    */     try {
/* 30 */       Class<?> clazz = Class.forName("com.ecarx.xui.adaptapi.wifiap.impl.Wifi6ApImpl");
/* 31 */       Constructor<?> constructor = clazz.getConstructor(new Class[] { Context.class });
/* 32 */       return (Wifi6Ap)constructor.newInstance(new Object[] { paramContext });
/* 33 */     } catch (Exception exception) {
/* 34 */       exception.printStackTrace();
/*    */       
/* 36 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract int getMaxConnections();
/*    */   
/*    */   public abstract boolean getWifi6ApEnabled();
/*    */   
/*    */   public abstract IWifiAPHost getWifiAPHost();
/*    */   
/*    */   public abstract List<IWifiApClient> getWifiApClients();
/*    */   
/*    */   public abstract FunctionStatus isWifiAPSupported();
/*    */   
/*    */   public abstract FunctionStatus isWifiSupported();
/*    */   
/*    */   public abstract boolean setMaxConnections(int paramInt);
/*    */   
/*    */   public abstract boolean setWifi6ApConfiguration(String paramString1, String paramString2, int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract boolean setWifi6ApEnabled(boolean paramBoolean);
/*    */   
/*    */   public abstract boolean setWifiApClientCallback(IWifiApClientCallback paramIWifiApClientCallback);
/*    */   
/*    */   public abstract boolean unsetWifiApClientCallback(IWifiApClientCallback paramIWifiApClientCallback);
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\wifiap\Wifi6Ap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */