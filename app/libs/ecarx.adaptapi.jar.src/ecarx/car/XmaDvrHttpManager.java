/*     */ package ecarx.car;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ 
/*     */ 
/*     */ public class XmaDvrHttpManager
/*     */   implements ECarXCarManagerBase
/*     */ {
/*     */   private static final String TAG = "XmaDvrHttpManager";
/*     */   private IXmaDvrHttpService mXmaDvrHttpService;
/*     */   
/*     */   public XmaDvrHttpManager(IBinder paramIBinder, Context paramContext, Handler paramHandler) {
/*  19 */     this.mXmaDvrHttpService = IXmaDvrHttpService.Stub.asInterface(paramIBinder);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onCarDisconnected() {
/*  24 */     Log.w("XmaDvrHttpManager", "onCarDisconnected");
/*     */   }
/*     */   public JSONArray getAllDvrFiles() {
/*     */     JSONException jSONException1;
/*  28 */     jSONException2 = null; JSONArray jSONArray = null;
/*     */     try {
/*  30 */       JSONArray jSONArray1 = new JSONArray(); this(this.mXmaDvrHttpService.getAllDvrFiles()); jSONArray = jSONArray1;
/*  31 */     } catch (JSONException jSONException2) {
/*  32 */       jSONException2.printStackTrace();
/*  33 */     } catch (RemoteException remoteException) {
/*  34 */       remoteException.printStackTrace(); jSONException1 = jSONException2;
/*     */     } 
/*  36 */     return (JSONArray)jSONException1;
/*     */   }
/*     */   
/*     */   public JSONArray deleteDvrFiles(JSONArray paramJSONArray) {
/*  40 */     RemoteException remoteException2 = null; JSONException jSONException = null;
/*     */     try {
/*  42 */       JSONArray jSONArray = new JSONArray(); this(this.mXmaDvrHttpService.deleteDvrFiles(paramJSONArray.toString())); paramJSONArray = jSONArray;
/*  43 */     } catch (JSONException jSONException1) {
/*  44 */       jSONException1.printStackTrace(); jSONException1 = jSONException;
/*  45 */     } catch (RemoteException remoteException1) {
/*  46 */       remoteException1.printStackTrace(); remoteException1 = remoteException2;
/*     */     } 
/*  48 */     return (JSONArray)remoteException1;
/*     */   }
/*     */   
/*     */   public JSONArray moveFiles2EmergencyPartition(JSONArray paramJSONArray) {
/*  52 */     RemoteException remoteException2 = null; JSONException jSONException = null;
/*     */     try {
/*  54 */       JSONArray jSONArray = new JSONArray(); IXmaDvrHttpService iXmaDvrHttpService = this.mXmaDvrHttpService;
/*  55 */       this(iXmaDvrHttpService.moveFiles2EmergencyPartition(paramJSONArray.toString())); paramJSONArray = jSONArray;
/*  56 */     } catch (JSONException jSONException1) {
/*  57 */       jSONException1.printStackTrace(); jSONException1 = jSONException;
/*  58 */     } catch (RemoteException remoteException1) {
/*  59 */       remoteException1.printStackTrace(); remoteException1 = remoteException2;
/*     */     } 
/*  61 */     return (JSONArray)remoteException1;
/*     */   }
/*     */   
/*     */   public boolean enterFileBrowse() {
/*  65 */     boolean bool = false;
/*     */     try {
/*  67 */       boolean bool1 = this.mXmaDvrHttpService.enterFileBrowse();
/*  68 */     } catch (RemoteException remoteException) {
/*  69 */       remoteException.printStackTrace();
/*     */     } 
/*  71 */     return bool;
/*     */   }
/*     */   
/*     */   public JSONArray refreshFileList() {
/*  75 */     JSONArray jSONArray = null; JSONException jSONException2 = null;
/*     */     try {
/*  77 */       JSONArray jSONArray1 = new JSONArray(); this(this.mXmaDvrHttpService.refreshFileList()); jSONArray = jSONArray1;
/*  78 */     } catch (JSONException jSONException1) {
/*  79 */       jSONException1.printStackTrace(); jSONException1 = jSONException2;
/*  80 */     } catch (RemoteException remoteException) {
/*  81 */       remoteException.printStackTrace();
/*     */     } 
/*  83 */     return (JSONArray)jSONException1;
/*     */   }
/*     */   public JSONArray refreshFileListNum(int paramInt) {
/*  86 */     JSONArray jSONArray = null; JSONException jSONException2 = null;
/*     */     try {
/*  88 */       JSONArray jSONArray1 = new JSONArray(); this(this.mXmaDvrHttpService.refreshFileListNum(paramInt)); jSONArray = jSONArray1;
/*  89 */     } catch (JSONException jSONException1) {
/*  90 */       jSONException1.printStackTrace(); jSONException1 = jSONException2;
/*  91 */     } catch (RemoteException remoteException) {
/*  92 */       remoteException.printStackTrace();
/*     */     } 
/*  94 */     return (JSONArray)jSONException1;
/*     */   }
/*     */   
/*     */   public boolean exitBrowseMode() {
/*  98 */     boolean bool1, bool2 = false;
/*     */     try {
/* 100 */       bool1 = this.mXmaDvrHttpService.exitBrowseMode();
/* 101 */     } catch (RemoteException remoteException) {
/* 102 */       remoteException.printStackTrace(); bool1 = bool2;
/*     */     } 
/* 104 */     return bool1;
/*     */   }
/*     */   
/*     */   public void setTestTag(boolean paramBoolean) {
/*     */     try {
/* 109 */       this.mXmaDvrHttpService.setTestTag(paramBoolean);
/* 110 */     } catch (RemoteException remoteException) {
/* 111 */       remoteException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\XmaDvrHttpManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */