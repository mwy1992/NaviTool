/*     */ package android.car.vms;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.util.Log;
/*     */ import com.android.internal.annotations.VisibleForTesting;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
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
/*     */ @SystemApi
/*     */ public final class VmsOperationRecorder
/*     */ {
/*  30 */   private static final VmsOperationRecorder INSTANCE = new VmsOperationRecorder(new Writer());
/*     */   private static final String TAG = "VmsOperationRecorder";
/*     */   
/*     */   @VisibleForTesting
/*     */   public VmsOperationRecorder(Writer paramWriter) {
/*  35 */     this.mWriter = paramWriter;
/*     */   }
/*     */   private final Writer mWriter;
/*     */   
/*     */   public static VmsOperationRecorder get() {
/*  40 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void subscribe(VmsLayer paramVmsLayer) {
/*  46 */     recordOp("subscribe", paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void unsubscribe(VmsLayer paramVmsLayer) {
/*  50 */     recordOp("unsubscribe", paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void subscribe(VmsLayer paramVmsLayer, int paramInt) {
/*  54 */     recordOp("subscribe", "publisherId", paramInt, paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void unsubscribe(VmsLayer paramVmsLayer, int paramInt) {
/*  58 */     recordOp("unsubscribe", "publisherId", paramInt, paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void startMonitoring() {
/*  62 */     recordOp("startMonitoring");
/*     */   }
/*     */   
/*     */   public void stopMonitoring() {
/*  66 */     recordOp("stopMonitoring");
/*     */   }
/*     */   
/*     */   public void setLayersOffering(VmsLayersOffering paramVmsLayersOffering) {
/*  70 */     recordOp("setLayersOffering", paramVmsLayersOffering);
/*     */   }
/*     */   
/*     */   public void getPublisherId(int paramInt) {
/*  74 */     recordOp("getPublisherId", "publisherId", paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSubscription(int paramInt, VmsLayer paramVmsLayer) {
/*  80 */     recordOp("addSubscription", "sequenceNumber", paramInt, paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void removeSubscription(int paramInt, VmsLayer paramVmsLayer) {
/*  84 */     recordOp("removeSubscription", "sequenceNumber", paramInt, paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void addPromiscuousSubscription(int paramInt) {
/*  88 */     recordOp("addPromiscuousSubscription", "sequenceNumber", paramInt);
/*     */   }
/*     */   
/*     */   public void removePromiscuousSubscription(int paramInt) {
/*  92 */     recordOp("removePromiscuousSubscription", "sequenceNumber", paramInt);
/*     */   }
/*     */   
/*     */   public void addHalSubscription(int paramInt, VmsLayer paramVmsLayer) {
/*  96 */     recordOp("addHalSubscription", "sequenceNumber", paramInt, paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void removeHalSubscription(int paramInt, VmsLayer paramVmsLayer) {
/* 100 */     recordOp("removeHalSubscription", "sequenceNumber", paramInt, paramVmsLayer);
/*     */   }
/*     */   
/*     */   public void setPublisherLayersOffering(VmsLayersOffering paramVmsLayersOffering) {
/* 104 */     recordOp("setPublisherLayersOffering", paramVmsLayersOffering);
/*     */   }
/*     */   
/*     */   public void setHalPublisherLayersOffering(VmsLayersOffering paramVmsLayersOffering) {
/* 108 */     recordOp("setHalPublisherLayersOffering", paramVmsLayersOffering);
/*     */   }
/*     */   
/*     */   private void recordOp(String paramString) {
/* 112 */     if (isEnabled()) {
/*     */       try {
/* 114 */         JSONObject jSONObject1 = new JSONObject(); this(); JSONObject jSONObject2 = new JSONObject(); this(); write(jSONObject1.put(paramString, jSONObject2));
/* 115 */       } catch (JSONException jSONException) {
/* 116 */         Log.e("VmsOperationRecorder", jSONException.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void recordOp(String paramString, VmsLayer paramVmsLayer) {
/* 122 */     if (isEnabled()) {
/*     */       try {
/* 124 */         JSONObject jSONObject = new JSONObject(); this(); recordOp(paramString, jSONObject.put("layer", toJson(paramVmsLayer)));
/* 125 */       } catch (JSONException jSONException) {
/* 126 */         Log.e("VmsOperationRecorder", jSONException.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void recordOp(String paramString, VmsLayersOffering paramVmsLayersOffering) {
/* 132 */     if (isEnabled()) {
/*     */       try {
/* 134 */         JSONObject jSONObject = new JSONObject(); this();
/* 135 */         JSONArray jSONArray = toJson(paramVmsLayersOffering);
/* 136 */         if (jSONArray.length() > 0) {
/* 137 */           jSONObject.put("layerDependency", jSONArray);
/*     */         }
/* 139 */         recordOp(paramString, jSONObject);
/* 140 */       } catch (JSONException jSONException) {
/* 141 */         Log.e("VmsOperationRecorder", jSONException.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void recordOp(String paramString1, String paramString2, int paramInt) {
/* 147 */     if (isEnabled()) {
/*     */       try {
/* 149 */         JSONObject jSONObject = new JSONObject(); this(); recordOp(paramString1, jSONObject.put(paramString2, paramInt));
/* 150 */       } catch (JSONException jSONException) {
/* 151 */         Log.e("VmsOperationRecorder", jSONException.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void recordOp(String paramString1, String paramString2, int paramInt, VmsLayer paramVmsLayer) {
/* 157 */     if (isEnabled()) {
/*     */       try {
/* 159 */         JSONObject jSONObject2 = new JSONObject(); this();
/* 160 */         JSONObject jSONObject1 = jSONObject2.put(paramString2, paramInt).put("layer", toJson(paramVmsLayer)); recordOp(paramString1, jSONObject1);
/* 161 */       } catch (JSONException jSONException) {
/* 162 */         Log.e("VmsOperationRecorder", jSONException.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void recordOp(String paramString, JSONObject paramJSONObject) {
/* 168 */     if (isEnabled()) {
/*     */       try {
/* 170 */         JSONObject jSONObject = new JSONObject(); this(); write(jSONObject.put(paramString, paramJSONObject));
/* 171 */       } catch (JSONException jSONException) {
/* 172 */         Log.e("VmsOperationRecorder", jSONException.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static JSONObject toJson(VmsLayer paramVmsLayer) throws JSONException {
/* 178 */     JSONObject jSONObject = new JSONObject();
/* 179 */     jSONObject = jSONObject.put("type", paramVmsLayer.getType());
/* 180 */     jSONObject = jSONObject.put("subtype", paramVmsLayer.getSubtype());
/* 181 */     return jSONObject.put("version", paramVmsLayer.getVersion());
/*     */   }
/*     */   
/*     */   private static JSONObject toJson(VmsLayerDependency paramVmsLayerDependency) throws JSONException {
/* 185 */     JSONObject jSONObject = new JSONObject();
/* 186 */     jSONObject.put("layer", toJson(paramVmsLayerDependency.getLayer()));
/* 187 */     if (!paramVmsLayerDependency.getDependencies().isEmpty()) {
/* 188 */       JSONArray jSONArray = new JSONArray();
/* 189 */       for (VmsLayer vmsLayer : paramVmsLayerDependency.getDependencies()) {
/* 190 */         jSONArray.put(toJson(vmsLayer));
/*     */       }
/* 192 */       jSONObject.put("dependency", jSONArray);
/*     */     } 
/* 194 */     return jSONObject;
/*     */   }
/*     */   
/*     */   private static JSONArray toJson(VmsLayersOffering paramVmsLayersOffering) throws JSONException {
/* 198 */     JSONArray jSONArray = new JSONArray();
/* 199 */     for (VmsLayerDependency vmsLayerDependency : paramVmsLayersOffering.getDependencies()) {
/* 200 */       jSONArray.put(toJson(vmsLayerDependency));
/*     */     }
/* 202 */     return jSONArray;
/*     */   }
/*     */   
/*     */   private boolean isEnabled() {
/* 206 */     return this.mWriter.isEnabled();
/*     */   }
/*     */   
/*     */   private void write(JSONObject paramJSONObject) {
/* 210 */     this.mWriter.write(paramJSONObject.toString());
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   public static class Writer
/*     */   {
/*     */     private static final int LEVEL = 3;
/*     */     private static final String TAG = "VMS.RECORD.EVENT";
/*     */     
/*     */     public boolean isEnabled() {
/* 220 */       return Log.isLoggable("VMS.RECORD.EVENT", 3);
/*     */     }
/*     */     
/*     */     public void write(String param1String) {
/* 224 */       Log.println(3, "VMS.RECORD.EVENT", param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsOperationRecorder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */