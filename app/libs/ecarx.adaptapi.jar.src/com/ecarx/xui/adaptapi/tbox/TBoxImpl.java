/*     */ package com.ecarx.xui.adaptapi.tbox;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.wifi.TcamInfo;
/*     */ import android.net.wifi.WifiManager;
/*     */ import android.os.Build;
/*     */ import android.os.SystemProperties;
/*     */ import android.telephony.CellInfo;
/*     */ import android.telephony.SignalStrength;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.tbox.TBoxSetting.TBoxSettingsImpl;
/*     */ import com.ecarx.xui.adaptapi.tbox.journallog.IJournalLog;
/*     */ import com.ecarx.xui.adaptapi.tbox.journallog.JournalLogImpl;
/*     */ import com.ecarx.xui.adaptapi.tbox.ota.IOta;
/*     */ import com.ecarx.xui.adaptapi.tbox.ota.OtaImp;
/*     */ import com.ecarx.xui.adaptapi.tbox.tboxmessager.ITBoxMessager;
/*     */ import com.ecarx.xui.adaptapi.tbox.tboxmessager.TBoxMessagerImp;
/*     */ import com.ecarx.xui.adaptapi.utils.ProperUtils;
/*     */ import ecarx.tcam.TcamManager;
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
/*     */ public class TBoxImpl
/*     */   extends TBox
/*     */ {
/*     */   public static final String NETWORK_NAME = "unknow";
/*     */   public static final String NETWORK_TYPE_UNKNOWN = "0";
/*     */   private static final String TAG = "TCAMImpl";
/*     */   private static TBoxImpl mTBoxImpl;
/*     */   private final boolean mDebug;
/*     */   private final IJournalLog mJournalLog;
/*     */   private final IOta mOta;
/*     */   private final ITBoxMessager mTBoxMessage;
/*     */   private final ITBoxSettings mTBoxSettingsImpl;
/*     */   private final TcamInfo mTcamInfo;
/*     */   private final TcamManager mTcamManager;
/*     */   private final WifiManager mWifiManager;
/*     */   
/*     */   private TBoxImpl(Context paramContext) {
/*  58 */     if (Build.IS_USER) {
/*  59 */       this.mDebug = false;
/*     */     } else {
/*  61 */       this.mDebug = SystemProperties.getBoolean("persist.adaptapi.debug", false);
/*     */     } 
/*     */     
/*  64 */     this.mOta = (IOta)new OtaImp(paramContext);
/*  65 */     this.mTBoxMessage = (ITBoxMessager)new TBoxMessagerImp(paramContext);
/*  66 */     this.mJournalLog = (IJournalLog)new JournalLogImpl(paramContext);
/*  67 */     this.mTBoxSettingsImpl = (ITBoxSettings)new TBoxSettingsImpl(paramContext);
/*  68 */     this.mTcamManager = TcamManager.getInstance(paramContext);
/*  69 */     this.mWifiManager = (WifiManager)paramContext.getSystemService("wifi");
/*  70 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("TBoxImpl: request tcam info: "); stringBuilder.append(this.mWifiManager.queryTcamSyncInformation()); Log.d("TCAMImpl", stringBuilder.toString());
/*  71 */     this.mTcamInfo = this.mWifiManager.getTcamInfo();
/*     */   }
/*     */   public static TBoxImpl create(Context paramContext) {
/*     */     /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/tbox/TBoxImpl}} */
/*  75 */     if (paramContext != null)
/*  76 */       try { TBoxImpl tBoxImpl1 = new TBoxImpl(); this(paramContext); mTBoxImpl = tBoxImpl1; }
/*     */       finally {} 
/*  78 */     TBoxImpl tBoxImpl = mTBoxImpl; /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/ecarx/xui/adaptapi/tbox/TBoxImpl}} */ return tBoxImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIMEI() {
/*  88 */     String str = null;
/*  89 */     if (this.mTcamInfo != null) {
/*  90 */       str = this.mTcamInfo.iMEI;
/*     */     } else {
/*  92 */       Log.e("TCAMImpl", "getIMEI mTcamInfo is null");
/*     */     } 
/*  94 */     if (this.mDebug) {
/*  95 */       str = SystemProperties.get("persist.tbox.imei", "unknow");
/*     */     }
/*  97 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getIMEI: "); stringBuilder.append(str); Log.d("TCAMImpl", stringBuilder.toString());
/*  98 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIMSI() {
/* 108 */     String str = null;
/* 109 */     if (this.mTcamInfo != null) {
/* 110 */       str = this.mTcamInfo.iMSI;
/*     */     } else {
/* 112 */       Log.e("TCAMImpl", "getIMSI mTcamInfo is null");
/*     */     } 
/* 114 */     if (this.mDebug) {
/* 115 */       str = SystemProperties.get("persist.tbox.imsi", "unknow");
/*     */     }
/* 117 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getIMSI: "); stringBuilder.append(str); Log.d("TCAMImpl", stringBuilder.toString());
/* 118 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTBoxID() {
/* 128 */     String str = null;
/* 129 */     if (this.mTcamInfo != null) {
/* 130 */       str = this.mTcamInfo.tCAMID;
/*     */     } else {
/* 132 */       Log.e("TCAMImpl", "getTBoxID mTcamInfo is null");
/*     */     } 
/* 134 */     if (this.mDebug) {
/* 135 */       str = SystemProperties.get("persist.tbox.tboxid", "unknow");
/*     */     }
/* 137 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getTBoxID: "); stringBuilder.append(str); Log.d("TCAMImpl", stringBuilder.toString());
/* 138 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTBoxSupplierCode() {
/* 146 */     return "unknow";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getICCID() {
/* 156 */     String str = null;
/* 157 */     if (this.mTcamInfo != null) {
/* 158 */       str = this.mTcamInfo.iCCID;
/*     */     } else {
/* 160 */       Log.e("TCAMImpl", "getICCID mTcamInfo is null");
/*     */     } 
/* 162 */     if (this.mDebug) {
/* 163 */       str = SystemProperties.get("persist.tbox.iccid", "unknow");
/*     */     }
/* 165 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getICCID: "); stringBuilder.append(str); Log.d("TCAMImpl", stringBuilder.toString());
/* 166 */     return str;
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
/*     */   public String getMSISDN() {
/* 178 */     String str = null;
/* 179 */     if (this.mTcamInfo != null) {
/* 180 */       str = this.mTcamInfo.mSISDN;
/*     */     } else {
/* 182 */       Log.e("TCAMImpl", "getMSISDN mTcamInfo is null");
/*     */     } 
/* 184 */     if (this.mDebug) {
/* 185 */       str = SystemProperties.get("persist.tbox.msisdn", "unknow");
/*     */     }
/* 187 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getMSISDN: "); stringBuilder.append(str); Log.d("TCAMImpl", stringBuilder.toString());
/* 188 */     return str;
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
/*     */   public String getLineNumber() {
/* 202 */     String str = null;
/* 203 */     if (this.mTcamInfo != null) {
/* 204 */       str = this.mTcamInfo.mSISDN;
/*     */     } else {
/* 206 */       Log.e("TCAMImpl", "getMSISDN mTcamInfo is null");
/*     */     } 
/* 208 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNetworkType() {
/* 219 */     return "0";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNetworkOperator() {
/* 229 */     return "unknow";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNetworkOperatorName() {
/* 239 */     return "unknow";
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
/*     */   public SignalStrength getSignalStrength() {
/* 252 */     return null;
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
/*     */   public CellInfo getCellInfo() {
/* 268 */     return null;
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
/*     */   public String getSoftwareVersion() {
/* 280 */     return ProperUtils.getPropertyValue("TBox_SoftwareVersion", String.class).toString();
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
/*     */   public int getSoftwareVersionCode() {
/* 292 */     return ((Integer)ProperUtils.getPropertyValue("TBox_SoftwareVersionCode", int.class)).intValue();
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
/*     */   public String getHardwareVersion() {
/* 304 */     return ProperUtils.getPropertyValue("TBox_HardwareVersion", String.class).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSubscribed() {
/* 310 */     return false;
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
/*     */   public IOta getOta() {
/* 322 */     return this.mOta;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setTBoxReset() {
/* 332 */     return this.mTcamManager.setTcamResetReq();
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
/*     */   public ITBoxMessager getTBoxMessager() {
/* 344 */     return this.mTBoxMessage;
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
/*     */   public IJournalLog getIJournalLog() {
/* 356 */     return this.mJournalLog;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ITBoxSettings getTBoxSettings() {
/* 366 */     return this.mTBoxSettingsImpl;
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
/*     */   public boolean setGIDProfIDLnk(String paramString, int paramInt) {
/* 378 */     boolean bool = false;
/* 379 */     if (this.mTcamManager != null) {
/* 380 */       bool = this.mTcamManager.setGIDProfIDLnk(paramString, paramInt);
/*     */     } else {
/* 382 */       Log.e("TCAMImpl", "setGIDProfIDLnk mTcamManager is null");
/*     */     } 
/* 384 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setGIDProfIDLnk gidInfo = "); stringBuilder.append(paramString); stringBuilder.append(" profId = "); stringBuilder.append(paramInt); stringBuilder.append(" isOk = "); stringBuilder.append(bool); Log.d("TCAMImpl", stringBuilder.toString());
/* 385 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\tbox\TBoxImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */