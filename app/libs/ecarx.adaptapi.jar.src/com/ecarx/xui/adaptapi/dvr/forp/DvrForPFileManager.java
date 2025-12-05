/*     */ package com.ecarx.xui.adaptapi.dvr.forp;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.os.SystemClock;
/*     */ import android.util.Log;
/*     */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*     */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*     */ import ecarx.car.ECarXCar;
/*     */ import ecarx.car.XmaDvrHttpManager;
/*     */ import ecarx.car.hardware.signal.CarSignalManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.stream.Stream;
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
/*     */ public class DvrForPFileManager
/*     */   extends AbsCarSignal
/*     */   implements IFileManager
/*     */ {
/*     */   private static final String TAG = "DvrForPFileManager";
/*  35 */   private Map<String, IDvrFile> mDvrFileMap = new HashMap<>(); private final CopyOnWriteArrayList<IFileManager.IFileObserver> mFileObservers; private XmaDvrHttpManager mXmaDvrHttpManager;
/*     */   
/*     */   protected DvrForPFileManager(Context paramContext) {
/*  38 */     super(paramContext);
/*  39 */     this.mFileObservers = new CopyOnWriteArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initCarSignalManager(ECarXCar paramECarXCar, CarSignalManager paramCarSignalManager) {
/*  50 */     super.initCarSignalManager(paramECarXCar, paramCarSignalManager);
/*     */     try {
/*  52 */       this.mXmaDvrHttpManager = (XmaDvrHttpManager)paramECarXCar.getCarManager("xma_dvr_http_service");
/*     */     }
/*  54 */     catch (Exception exception) {
/*  55 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTestTag(boolean paramBoolean) {
/*  60 */     this.mXmaDvrHttpManager.setTestTag(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean refreshFileList() {
/*  64 */     if (this.mXmaDvrHttpManager.enterFileBrowse()) {
/*  65 */       XmaDvrHttpManager xmaDvrHttpManager = this.mXmaDvrHttpManager;
/*  66 */       JSONArray jSONArray = xmaDvrHttpManager.refreshFileList(); ArrayList<IDvrFile> arrayList = refreshFileList(jSONArray);
/*  67 */       for (IFileManager.IFileObserver iFileObserver : this.mFileObservers) {
/*     */         try {
/*  69 */           iFileObserver.onNewFiles(arrayList.<IDvrFile>toArray(new IDvrFile[0]));
/*  70 */         } catch (Exception exception) {
/*  71 */           exception.printStackTrace();
/*     */         } 
/*     */       } 
/*  74 */       return true;
/*     */     } 
/*  76 */     Log.e("DvrForPFileManager", "Dvr is not in file broswer mode");
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean refreshFileListNum(int paramInt) {
/*  82 */     if (this.mXmaDvrHttpManager.enterFileBrowse()) {
/*  83 */       XmaDvrHttpManager xmaDvrHttpManager = this.mXmaDvrHttpManager;
/*  84 */       JSONArray jSONArray = xmaDvrHttpManager.refreshFileListNum(paramInt); ArrayList<IDvrFile> arrayList = refreshFileList(jSONArray);
/*  85 */       for (IFileManager.IFileObserver iFileObserver : this.mFileObservers) {
/*     */         try {
/*  87 */           iFileObserver.onNewFiles(arrayList.<IDvrFile>toArray(new IDvrFile[0]));
/*  88 */         } catch (Exception exception) {
/*  89 */           exception.printStackTrace();
/*     */         } 
/*     */       } 
/*  92 */       return true;
/*     */     } 
/*  94 */     Log.e("DvrForPFileManager", "Dvr is not in file broswer mode");
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean exitBrowseMode() {
/* 102 */     return this.mXmaDvrHttpManager.exitBrowseMode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDvrFile[] getAllDvrFiles() {
/* 112 */     Collection<IDvrFile> collection = this.mDvrFileMap.values();
/* 113 */     IDvrFile[] arrayOfIDvrFile = new IDvrFile[collection.size()];
/* 114 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getAllDvrFiles: "); stringBuilder.append(Arrays.toString(this.mDvrFileMap.values().toArray((Object[])arrayOfIDvrFile))); Log.d("DvrForPFileManager", stringBuilder.toString());
/* 115 */     return (IDvrFile[])this.mDvrFileMap.values().toArray((Object[])arrayOfIDvrFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDvrFile[] getDvrFiles(int paramInt) {
/* 125 */     Collection<IDvrFile> collection = this.mDvrFileMap.values();
/* 126 */     Stream<?> stream1 = (new ArrayList(collection)).stream(); -$$Lambda$DvrForPFileManager$wEEUe_amWRl1KJ1Z8HMDbSJMITo -$$Lambda$DvrForPFileManager$wEEUe_amWRl1KJ1Z8HMDbSJMITo = new -$$Lambda$DvrForPFileManager$wEEUe_amWRl1KJ1Z8HMDbSJMITo(paramInt);
/* 127 */     Stream<?> stream2 = stream1.filter(-$$Lambda$DvrForPFileManager$wEEUe_amWRl1KJ1Z8HMDbSJMITo); -$$Lambda$DvrForPFileManager$HmvLZqydYjfbCZSkjqRhhqBcoI0 -$$Lambda$DvrForPFileManager$HmvLZqydYjfbCZSkjqRhhqBcoI0 = -$$Lambda$DvrForPFileManager$HmvLZqydYjfbCZSkjqRhhqBcoI0.INSTANCE;
/* 128 */     IDvrFile[] arrayOfIDvrFile = stream2.<IDvrFile>toArray(-$$Lambda$DvrForPFileManager$HmvLZqydYjfbCZSkjqRhhqBcoI0);
/* 129 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDvrFiles: "); stringBuilder.append(Arrays.toString((Object[])arrayOfIDvrFile)); Log.d("DvrForPFileManager", stringBuilder.toString());
/* 130 */     return arrayOfIDvrFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDvrFileCount(int paramInt) {
/* 141 */     int i = 0;
/* 142 */     for (IDvrFile iDvrFile : this.mDvrFileMap.values()) {
/* 143 */       int j = i; if (iDvrFile.getType() == paramInt) {
/* 144 */         j = i + 1;
/*     */       }
/* 146 */       i = j;
/* 147 */     }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDvrFileCount: "); stringBuilder.append(i); Log.d("DvrForPFileManager", stringBuilder.toString());
/* 148 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IDvrFile[] getDvrDeletedFiles() {
/* 159 */     Collection<IDvrFile> collection = this.mDvrFileMap.values();
/* 160 */     Stream stream = (new ArrayList(collection)).stream().filter(-$$Lambda$5Y0KLheeYReK7RvSO43vXMpCBoY.INSTANCE); -$$Lambda$DvrForPFileManager$Ba19BluhV5CSYyhMsh3LiO-OR7I -$$Lambda$DvrForPFileManager$Ba19BluhV5CSYyhMsh3LiO-OR7I = -$$Lambda$DvrForPFileManager$Ba19BluhV5CSYyhMsh3LiO-OR7I.INSTANCE;
/* 161 */     IDvrFile[] arrayOfIDvrFile = (IDvrFile[])stream.toArray(-$$Lambda$DvrForPFileManager$Ba19BluhV5CSYyhMsh3LiO-OR7I);
/* 162 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDvrDeletedFiles: "); stringBuilder.append(Arrays.toString((Object[])arrayOfIDvrFile)); Log.d("DvrForPFileManager", stringBuilder.toString());
/* 163 */     return arrayOfIDvrFile;
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
/*     */   public IDvrFile[] getDrvFiles(int paramInt1, int paramInt2) {
/*     */     IDvrFile[] arrayOfIDvrFile;
/* 177 */     if (paramInt1 == 0 && paramInt2 == -1) {
/* 178 */       arrayOfIDvrFile = getAllDvrFiles();
/* 179 */     } else if (paramInt2 > paramInt1 && paramInt2 < this.mDvrFileMap.size()) {
/* 180 */       Collection<IDvrFile> collection = this.mDvrFileMap.values();
/* 181 */       arrayOfIDvrFile = (IDvrFile[])(new ArrayList(collection)).subList(paramInt1, paramInt2).toArray((Object[])new IDvrFile[0]);
/*     */     } else {
/*     */       
/* 184 */       arrayOfIDvrFile = new IDvrFile[0];
/*     */     } 
/* 186 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getDrvFiles: "); stringBuilder.append(Arrays.toString((Object[])arrayOfIDvrFile)); Log.d("DvrForPFileManager", stringBuilder.toString());
/* 187 */     return arrayOfIDvrFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteDvrFiles(IDvrFile[] paramArrayOfIDvrFile) {
/* 197 */     JSONArray jSONArray = this.mXmaDvrHttpManager.deleteDvrFiles(convertFileInfo2JSON(paramArrayOfIDvrFile));
/* 198 */     ArrayList<DvrForPFile> arrayList = new ArrayList();
/* 199 */     for (byte b = 0; b < jSONArray.length(); b++) {
/*     */       try {
/* 201 */         Map<String, IDvrFile> map = this.mDvrFileMap;
/*     */         
/* 203 */         String str1 = jSONArray.getJSONObject(b).getString("id"); DvrForPFile dvrForPFile = (DvrForPFile)map.get(str1);
/* 204 */         dvrForPFile.setIsDeleted(true);
/* 205 */         dvrForPFile.setDeleteTime(SystemClock.elapsedRealtime());
/* 206 */         arrayList.add(dvrForPFile);
/* 207 */       } catch (JSONException jSONException) {
/* 208 */         jSONException.printStackTrace();
/*     */       } 
/*     */     } 
/* 211 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("deleteDvrFiles: input: "); stringBuilder.append(Arrays.toString((Object[])paramArrayOfIDvrFile)); stringBuilder.append(", out: ");
/* 212 */     stringBuilder.append(arrayList.toString()); String str = stringBuilder.toString();
/*     */     Log.d("DvrForPFileManager", str);
/* 214 */     callbackOperationResult(8194, paramArrayOfIDvrFile, (ArrayList)arrayList);
/*     */   }
/*     */ 
/*     */   
/*     */   private void callbackOperationResult(int paramInt, IDvrFile[] paramArrayOfIDvrFile, ArrayList<IDvrFile> paramArrayList) {
/* 219 */     for (IFileManager.IFileObserver iFileObserver : this.mFileObservers) {
/*     */       try {
/* 221 */         if (paramArrayList.size() != 0) {
/* 222 */           if (paramInt == 8194) {
/* 223 */             iFileObserver.onDeleteFiles(paramArrayList.<IDvrFile>toArray(new IDvrFile[0]));
/*     */           }
/* 225 */           if (paramArrayList.size() == paramArrayOfIDvrFile.length) {
/*     */             
/* 227 */             iFileObserver.onFileOperationResults(paramInt, paramArrayOfIDvrFile, null);
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 232 */           IDvrFile[] arrayOfIDvrFile1 = paramArrayList.<IDvrFile>toArray(new IDvrFile[0]);
/* 233 */           IDvrFile[] arrayOfIDvrFile2 = getFailFiles(paramArrayList, paramArrayOfIDvrFile);
/*     */           iFileObserver.onFileOperationResults(paramInt, arrayOfIDvrFile1, arrayOfIDvrFile2);
/*     */           continue;
/*     */         } 
/* 237 */         iFileObserver.onFileOperationResults(paramInt, null, paramArrayOfIDvrFile);
/*     */       
/*     */       }
/* 240 */       catch (Exception exception) {
/* 241 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/* 244 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onFileOperationResults: operation: "); stringBuilder.append(Integer.toHexString(paramInt)); stringBuilder.append(", input: ");
/* 245 */     stringBuilder.append(Arrays.toString((Object[])paramArrayOfIDvrFile)); stringBuilder.append(", successFile: ");
/* 246 */     stringBuilder.append(paramArrayList.toString()); String str = stringBuilder.toString();
/*     */     Log.d("DvrForPFileManager", str);
/*     */   }
/*     */   
/*     */   private IDvrFile[] getFailFiles(ArrayList<IDvrFile> paramArrayList, IDvrFile[] paramArrayOfIDvrFile) {
/* 251 */     ArrayList arrayList = new ArrayList(Arrays.asList((Object[])paramArrayOfIDvrFile));
/* 252 */     arrayList.removeAll(paramArrayList);
/* 253 */     return (IDvrFile[])arrayList.toArray((Object[])new IDvrFile[0]);
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
/*     */   public void restoreDeletedFiles(IDvrFile[] paramArrayOfIDvrFile) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveFiles2EmergencyPartition(IDvrFile[] paramArrayOfIDvrFile) {
/* 276 */     XmaDvrHttpManager xmaDvrHttpManager = this.mXmaDvrHttpManager;
/* 277 */     JSONArray jSONArray1 = convertFileInfo2JSON(paramArrayOfIDvrFile); JSONArray jSONArray2 = xmaDvrHttpManager.moveFiles2EmergencyPartition(jSONArray1);
/* 278 */     ArrayList<DvrForPFile> arrayList = new ArrayList();
/* 279 */     for (byte b = 0; b < jSONArray2.length(); b++) {
/*     */       try {
/* 281 */         Map<String, IDvrFile> map = this.mDvrFileMap;
/* 282 */         String str1 = jSONArray2.getJSONObject(b).getString("id"); DvrForPFile dvrForPFile = (DvrForPFile)map.get(str1);
/* 283 */         dvrForPFile.setFileType(1);
/* 284 */         arrayList.add(dvrForPFile);
/* 285 */       } catch (JSONException jSONException) {
/* 286 */         jSONException.printStackTrace();
/*     */       } 
/*     */     } 
/* 289 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("moveFiles2EmergencyPartition: input: "); stringBuilder.append(Arrays.toString((Object[])paramArrayOfIDvrFile)); stringBuilder.append(", out: ");
/* 290 */     stringBuilder.append(arrayList.toString()); String str = stringBuilder.toString();
/*     */     Log.d("DvrForPFileManager", str);
/* 292 */     callbackOperationResult(8195, paramArrayOfIDvrFile, (ArrayList)arrayList);
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
/*     */   @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
/*     */   public void lockDvrFiles(IDvrFile[] paramArrayOfIDvrFile) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerOperationObserver(IFileManager.IFileObserver paramIFileObserver) {
/* 315 */     if (!this.mFileObservers.contains(paramIFileObserver)) {
/* 316 */       this.mFileObservers.add(paramIFileObserver);
/*     */     }
/* 318 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unegisterOperationObserver(IFileManager.IFileObserver paramIFileObserver) {
/* 329 */     this.mFileObservers.remove(paramIFileObserver);
/* 330 */     return true;
/*     */   }
/*     */   
/*     */   private ArrayList<IDvrFile> refreshFileList(JSONArray paramJSONArray) {
/* 334 */     ArrayList<IDvrFile> arrayList = new ArrayList();
/*     */     
/* 336 */     byte b = 0; try { for (; b < paramJSONArray.length(); b++) {
/* 337 */         JSONObject jSONObject = paramJSONArray.getJSONObject(b);
/*     */         
/* 339 */         String str = jSONObject.getString("id");
/* 340 */         if (this.mDvrFileMap.get(str) == null) {
/* 341 */           IDvrFile iDvrFile = convertJSON2FileInfo(jSONObject);
/* 342 */           this.mDvrFileMap.put(str, iDvrFile);
/* 343 */           arrayList.add(iDvrFile);
/*     */         } 
/*     */       }  }
/* 346 */     catch (JSONException jSONException)
/* 347 */     { jSONException.printStackTrace(); }
/*     */     
/* 349 */     return arrayList;
/*     */   }
/*     */   
/*     */   private JSONArray convertFileInfo2JSON(IDvrFile[] paramArrayOfIDvrFile) {
/* 353 */     JSONArray jSONArray = new JSONArray(); try {
/*     */       byte b; int i;
/* 355 */       for (i = paramArrayOfIDvrFile.length, b = 0; b < i; ) { IDvrFile iDvrFile = paramArrayOfIDvrFile[b];
/* 356 */         JSONObject jSONObject1 = new JSONObject(); this();
/* 357 */         JSONObject jSONObject2 = jSONObject1.put("app", "gallery");
/* 358 */         jSONObject2 = jSONObject2.put("mediaType", convertMediaType(iDvrFile.getType())); iDvrFile = iDvrFile;
/* 359 */         jSONObject2.put("id", iDvrFile.getId());
/* 360 */         jSONArray.put(jSONObject1); b++; }
/*     */     
/* 362 */     } catch (JSONException jSONException) {
/* 363 */       jSONException.printStackTrace();
/*     */     } 
/* 365 */     return jSONArray;
/*     */   }
/*     */   
/*     */   private IDvrFile convertJSON2FileInfo(JSONObject paramJSONObject) {
/* 369 */     JSONException jSONException2 = null;
/*     */ 
/*     */     
/* 372 */     String str2 = "null";
/* 373 */     String str1 = "null"; try {
/* 374 */       double d1; long l3; if (paramJSONObject.has("location")) {
/* 375 */         str1 = paramJSONObject.getString("location");
/* 376 */         str2 = str1.split(",")[1].trim();
/* 377 */         str1 = str1.split(",")[0].trim();
/*     */       } 
/* 379 */       boolean bool = str2.equals("null"); double d2 = 0.0D; if (bool) { d1 = 0.0D; } else { d1 = Double.valueOf(str2).doubleValue(); }
/* 380 */        if (!str1.equals("null")) d2 = Double.valueOf(str1).doubleValue(); 
/* 381 */       str2 = paramJSONObject.getString("mediaType");
/* 382 */       str1 = paramJSONObject.getString("name"); str2 = convertFileUri(str2, str1);
/* 383 */       String str4 = paramJSONObject.getString("mediaType");
/* 384 */       str1 = paramJSONObject.getString("id"); str4 = convertThumbnailUri(str4, str1);
/* 385 */       long l1 = 0L;
/* 386 */       long l2 = 0L;
/*     */       
/* 388 */       if (paramJSONObject.has("location")) {
/* 389 */         l1 = paramJSONObject.getLong("size") / 1000L;
/*     */       }
/* 391 */       if (paramJSONObject.has("duration")) {
/* 392 */         l2 = paramJSONObject.getLong("duration");
/*     */       }
/* 394 */       if (paramJSONObject.has("dateTime"))
/* 395 */       { l3 = paramJSONObject.getLong("dateTime"); }
/*     */       else
/* 397 */       { l3 = 0L; }  DvrForPFile dvrForPFile2 = new DvrForPFile();
/* 398 */       String str5 = paramJSONObject.getString("id");
/* 399 */       int i = convertFileType(paramJSONObject.getString("mediaType"));
/*     */       
/* 401 */       String str3 = paramJSONObject.getString("name");
/*     */       
/* 403 */       this(str5, i, 0, str3, l1, 0, 0, null, d1, d2, l3, Uri.parse(str2), Uri.parse(str4), l2, false, 0L); DvrForPFile dvrForPFile1 = dvrForPFile2;
/*     */     }
/* 405 */     catch (JSONException jSONException1) {
/* 406 */       jSONException1.printStackTrace(); jSONException1 = jSONException2;
/*     */     } 
/* 408 */     return (IDvrFile)jSONException1;
/*     */   }
/*     */   
/*     */   private String convertFileUri(String paramString1, String paramString2) { String str;
/* 412 */     StringBuffer stringBuffer = new StringBuffer("http://198.18.37.20/");
/* 413 */     if ("photo".equals(paramString1)) {
/* 414 */       str = paramString2; if (!paramString2.contains(".JPG")) {
/* 415 */         StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append(paramString2); stringBuilder1.append(".JPG"); String str1 = stringBuilder1.toString();
/*     */       } 
/*     */     } else {
/* 418 */       str = paramString2; if (!paramString2.contains(".MP4")) {
/* 419 */         StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append(paramString2); stringBuilder1.append(".MP4"); str = stringBuilder1.toString();
/*     */       } 
/*     */     } 
/* 422 */     byte b = -1; switch (paramString1.hashCode()) { case 1629013393: if (paramString1.equals("emergency")) b = 1;  break;case 1497468138: if (paramString1.equals("avm_emergency")) b = 2;  break;case 106642994: if (paramString1.equals("photo")) b = 4;  break;case -793201736: if (paramString1.equals("parking")) b = 3;  break;case -1039745817: if (paramString1.equals("normal")) b = 0;  break; }  switch (b) {
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
/*     */       default:
/* 437 */         return stringBuffer.toString();
/*     */       case 4:
/*     */         stringBuilder = new StringBuilder(); stringBuilder.append("DCIM/PHOTO/"); stringBuilder.append(str); stringBuffer.append(stringBuilder.toString());
/*     */       case 3:
/*     */         stringBuilder = new StringBuilder(); stringBuilder.append("DCIM/APARK/"); stringBuilder.append(str); stringBuffer.append(stringBuilder.toString());
/*     */       case 1:
/*     */       case 2:
/*     */         stringBuilder = new StringBuilder(); stringBuilder.append("DCIM/EVENT/");
/*     */         stringBuilder.append(str);
/*     */         stringBuffer.append(stringBuilder.toString());
/*     */       case 0:
/*     */         break;
/*     */     } 
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("DCIM/UNSVD/");
/*     */     stringBuilder.append(str);
/* 453 */     stringBuffer.append(stringBuilder.toString()); } private int convertFileType(String paramString) { byte b1 = 2;
/* 454 */     switch (paramString.hashCode()) { default: b = -1; break;case 1629013393: if (paramString.equals("emergency")) { b = 0; break; } case 1497468138: if (paramString.equals("avm_emergency")) { b = 2; break; } case 106642994: if (paramString.equals("photo")) { b = 4; break; } case -793201736: if (paramString.equals("parking")) { b = 3; break; } case -1039745817: if (paramString.equals("normal")) { b = 1; break; }  }  switch (b) { default: b = b1;
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
/* 471 */         return b;case 4: b = 3; return b;case 3: b = 5; return b;case 2: b = 6; return b;case 1: b = 2; return b;case 0: break; }  byte b = 1; return b; }
/*     */    private String convertThumbnailUri(String paramString1, String paramString2) {
/*     */     // Byte code:
/*     */     //   0: new java/lang/StringBuffer
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore #5
/*     */     //   9: aload_1
/*     */     //   10: invokevirtual hashCode : ()I
/*     */     //   13: istore_3
/*     */     //   14: iload_3
/*     */     //   15: ldc_w -1039745817
/*     */     //   18: if_icmpeq -> 66
/*     */     //   21: iload_3
/*     */     //   22: ldc_w 106642994
/*     */     //   25: if_icmpeq -> 52
/*     */     //   28: iload_3
/*     */     //   29: ldc_w 1629013393
/*     */     //   32: if_icmpeq -> 38
/*     */     //   35: goto -> 80
/*     */     //   38: aload_1
/*     */     //   39: ldc 'emergency'
/*     */     //   41: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   44: ifeq -> 80
/*     */     //   47: iconst_1
/*     */     //   48: istore_3
/*     */     //   49: goto -> 82
/*     */     //   52: aload_1
/*     */     //   53: ldc 'photo'
/*     */     //   55: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   58: ifeq -> 80
/*     */     //   61: iconst_2
/*     */     //   62: istore_3
/*     */     //   63: goto -> 82
/*     */     //   66: aload_1
/*     */     //   67: ldc 'normal'
/*     */     //   69: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   72: ifeq -> 80
/*     */     //   75: iconst_0
/*     */     //   76: istore_3
/*     */     //   77: goto -> 82
/*     */     //   80: iconst_m1
/*     */     //   81: istore_3
/*     */     //   82: iload_3
/*     */     //   83: tableswitch default -> 108, 0 -> 114, 1 -> 114, 2 -> 114
/*     */     //   108: aload #5
/*     */     //   110: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   113: areturn
/*     */     //   114: new java/lang/StringBuilder
/*     */     //   117: dup
/*     */     //   118: invokespecial <init> : ()V
/*     */     //   121: astore #4
/*     */     //   123: aload #4
/*     */     //   125: ldc_w 'http://198.18.37.20/thumbnail?app=gallery&mediaType='
/*     */     //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   131: pop
/*     */     //   132: aload #4
/*     */     //   134: aload_1
/*     */     //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   138: pop
/*     */     //   139: aload #4
/*     */     //   141: ldc_w '&id='
/*     */     //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   147: pop
/*     */     //   148: aload #4
/*     */     //   150: aload_2
/*     */     //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   154: pop
/*     */     //   155: aload #5
/*     */     //   157: aload #4
/*     */     //   159: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
/*     */     //   165: pop
/*     */     //   166: aload #5
/*     */     //   168: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   171: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #440	-> 0
/*     */     //   #441	-> 9
/*     */     //   #449	-> 108
/*     */     //   #445	-> 114
/*     */     //   #447	-> 166
/*     */   } private String convertMediaType(int paramInt) {
/* 475 */     String str = null;
/* 476 */     switch (paramInt)
/*     */     
/*     */     { 
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
/*     */       default:
/* 494 */         Log.d("DvrForPFileManager", "(FileType)Parameter passing error");
/*     */         
/* 496 */         return str;case 6: str = "avm_emergency"; return str;case 5: str = "parking"; return str;case 3: case 4: str = "photo"; return str;case 2: str = "normal"; return str;case 1: break; }  str = "emergency"; return str;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\DvrForPFileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */