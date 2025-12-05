/*     */ package com.ecarx.xui.adaptapi.device.ads;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Advertise
/*     */   implements IAdvertise
/*     */ {
/*     */   private static String DATA_SOURCE_FILE_DIR;
/*  20 */   private static String TAG = "AdvertiseImp"; private static AdPlayParameters adPlayParameters; private static AdPlayRecords adPlayRecords; private static String desDir; private static String desFileName; private static Advertise mAdvertise; private static String parameter_fileName; private static String playRecords_fileName; Context mContext;
/*     */   static {
/*  22 */     DATA_SOURCE_FILE_DIR = "/data/data/ecarx.ads/cache/";
/*  23 */     desDir = "/data/media/ADFiles/";
/*  24 */     desFileName = "bootvideo.mp4";
/*  25 */     parameter_fileName = "ad_parameter.txt";
/*  26 */     playRecords_fileName = "ad_play_record.txt";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Advertise getInstance(Context paramContext) {
/*  32 */     if (mAdvertise == null) {
/*  33 */       mAdvertise = new Advertise(paramContext);
/*     */     }
/*  35 */     return mAdvertise;
/*     */   }
/*     */ 
/*     */   
/*     */   public Advertise(Context paramContext) {
/*  40 */     this.mContext = paramContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBootAdInfo(IBootAdInfo paramIBootAdInfo) {
/*  51 */     String str2 = paramIBootAdInfo.getAdId();
/*  52 */     final String adPath = paramIBootAdInfo.getAdPath();
/*  53 */     String str3 = paramIBootAdInfo.getMd5();
/*  54 */     long l3 = paramIBootAdInfo.getDuration();
/*  55 */     int i = paramIBootAdInfo.getMaxTimes();
/*  56 */     long l2 = paramIBootAdInfo.getEffectiveTime();
/*  57 */     long l1 = paramIBootAdInfo.getExpiredTime();
/*  58 */     String str1 = TAG; StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append(" adId = "); stringBuilder2.append(str2); stringBuilder2.append(" adPath = "); stringBuilder2.append(str4); stringBuilder2.append(" adMd5 = "); stringBuilder2.append(str3); stringBuilder2.append(" adDuration = "); stringBuilder2.append(l3); stringBuilder2.append(" adMaxTimes = "); stringBuilder2.append(i); stringBuilder2.append(" adEffectiveTime = "); stringBuilder2.append(l2); stringBuilder2.append(" adExpiredTime = "); stringBuilder2.append(l1); Log.d(str1, stringBuilder2.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     if (!TextUtils.isEmpty(str2)) { boolean bool1, bool2 = false; if (i != 0) { bool1 = true; } else { bool1 = false; }  if (l2 != 0L) bool2 = true;  if ((bool2 & bool1) != 0 && l1 != 0L) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  72 */         adPlayParameters = new AdPlayParameters(str2, str4, str3, l3, i, l2, l1);
/*  73 */         adPlayRecords = new AdPlayRecords(null, 0L, 0L, 0, false);
/*  74 */         Thread thread = new Thread() {
/*     */             final Advertise this$0; final String val$adPath;
/*  76 */             public void run() { Advertise.checkFilePermission();
/*     */               
/*  78 */               Advertise.copyFile(adPath, Advertise.desDir);
/*  79 */               Advertise advertise = Advertise.this; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(Advertise.desDir); stringBuilder.append(Advertise.parameter_fileName); advertise.writeAdPlayParameters(new File(stringBuilder.toString()));
/*  80 */               advertise = Advertise.this; stringBuilder = new StringBuilder(); stringBuilder.append(Advertise.desDir); stringBuilder.append(Advertise.playRecords_fileName); advertise.writeAdPlayRecords(new File(stringBuilder.toString())); }
/*     */           };
/*  82 */         thread.start(); return;
/*     */       }  }
/*  84 */      Log.e(TAG, "AD property is NULL or 0, rm AD media file.");
/*  85 */     StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append(desDir); stringBuilder1.append(desFileName); rmADFiles(stringBuilder1.toString());
/*  86 */     stringBuilder1 = new StringBuilder(); stringBuilder1.append(desDir); stringBuilder1.append(parameter_fileName); rmADFiles(stringBuilder1.toString());
/*  87 */     stringBuilder1 = new StringBuilder(); stringBuilder1.append(desDir); stringBuilder1.append(playRecords_fileName); rmADFiles(stringBuilder1.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void checkFilePermission() {
/*  93 */     File file3 = new File(desDir);
/*  94 */     if (!file3.exists()) {
/*  95 */       file3.mkdir();
/*  96 */       setPerm(desDir);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 101 */     StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append(desDir); stringBuilder2.append(parameter_fileName); File file2 = new File(stringBuilder2.toString());
/* 102 */     if (!file2.exists()) {
/*     */       try {
/* 104 */         file2.createNewFile();
/* 105 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append(desDir); stringBuilder.append(parameter_fileName); setPerm(stringBuilder.toString());
/* 106 */       } catch (IOException iOException) {
/* 107 */         String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("createNewFile"); stringBuilder.append(iOException); Log.e(str, stringBuilder.toString());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 113 */     StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append(desDir); stringBuilder1.append(playRecords_fileName); File file1 = new File(stringBuilder1.toString());
/* 114 */     if (!file1.exists()) {
/*     */       try {
/* 116 */         file1.createNewFile();
/* 117 */         StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append(desDir); stringBuilder.append(playRecords_fileName); setPerm(stringBuilder.toString());
/* 118 */       } catch (IOException iOException) {
/* 119 */         String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("createNewFile"); stringBuilder.append(iOException); Log.e(str, stringBuilder.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static void setPerm(String paramString) {
/*     */     try {
/* 126 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("chmod 777 "); stringBuilder.append(paramString); paramString = stringBuilder.toString();
/* 127 */       Runtime runtime = Runtime.getRuntime();
/* 128 */       runtime.exec(paramString);
/* 129 */     } catch (IOException iOException) {
/* 130 */       String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setPerm exception :"); stringBuilder.append(iOException); Log.e(str, stringBuilder.toString());
/* 131 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void rmADFiles(String paramString) {
/*     */     try {
/* 137 */       StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("rm -rf "); stringBuilder.append(paramString); paramString = stringBuilder.toString();
/* 138 */       Runtime runtime = Runtime.getRuntime();
/* 139 */       runtime.exec(paramString);
/* 140 */     } catch (IOException iOException) {
/* 141 */       String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("rmADFile exception :"); stringBuilder.append(iOException); Log.e(str, stringBuilder.toString());
/* 142 */       iOException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   private static void copyFile(String paramString1, String paramString2) {
/*     */     BufferedInputStream bufferedInputStream;
/*     */     String str2;
/* 148 */     File file1 = new File(paramString2);
/* 149 */     file1.mkdirs();
/*     */ 
/*     */     
/* 152 */     file1 = new File(paramString1);
/* 153 */     if (!file1.exists()) {
/*     */       return;
/*     */     }
/* 156 */     File[] arrayOfFile = file1.listFiles();
/* 157 */     if (arrayOfFile == null)
/*     */       return;  int i, j;
/*     */     File file2;
/* 160 */     for (j = arrayOfFile.length, file2 = null, i = 0; i < j; ) { String str; File file = arrayOfFile[i];
/* 161 */       file1 = file2; if (file.isFile()) { file1 = file2; if (file.getName() != null) { file1 = file2; if (file.getName().endsWith("mp4"))
/* 162 */             str = file.getName();  }
/*     */          }
/*     */        i++; str2 = str; }
/* 165 */      String str1 = TAG; StringBuilder stringBuilder2 = new StringBuilder(); stringBuilder2.append("src = "); stringBuilder2.append(paramString1); stringBuilder2.append(str2); Log.d(str1, stringBuilder2.toString());
/*     */ 
/*     */     
/* 168 */     String str3 = null; StringBuilder stringBuilder3 = null;
/* 169 */     BufferedOutputStream bufferedOutputStream3 = null, bufferedOutputStream4 = null;
/* 170 */     stringBuilder2 = stringBuilder3; BufferedOutputStream bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream3; try { BufferedInputStream bufferedInputStream3 = new BufferedInputStream(); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; FileInputStream fileInputStream = new FileInputStream(); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; File file4 = new File(); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; StringBuilder stringBuilder = new StringBuilder(); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; this(); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; stringBuilder.append(paramString1); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; stringBuilder.append(str2); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; this(stringBuilder.toString()); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; this(file4); stringBuilder2 = stringBuilder3; bufferedOutputStream1 = bufferedOutputStream4; str1 = str3; bufferedOutputStream2 = bufferedOutputStream3; this(fileInputStream); BufferedInputStream bufferedInputStream1 = bufferedInputStream3;
/* 171 */       BufferedInputStream bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; FileOutputStream fileOutputStream = new FileOutputStream(); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; File file3 = new File(); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; stringBuilder3 = new StringBuilder(); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; this(); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; stringBuilder3.append(paramString2); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; stringBuilder3.append(desFileName); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; this(stringBuilder3.toString()); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; this(file3); bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream4; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream3; this(fileOutputStream);
/* 172 */       bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream; byte[] arrayOfByte = new byte[64];
/*     */       while (true) {
/* 174 */         bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream; i = bufferedInputStream1.read(arrayOfByte); if (i != -1) { bufferedInputStream2 = bufferedInputStream1; bufferedOutputStream1 = bufferedOutputStream; bufferedInputStream = bufferedInputStream1; bufferedOutputStream2 = bufferedOutputStream; bufferedOutputStream.write(arrayOfByte, 0, i);
/*     */           
/*     */           continue; }
/*     */         
/*     */         break;
/*     */       } 
/*     */       try {
/* 181 */         bufferedOutputStream.flush(); bufferedOutputStream.close();
/* 182 */       } catch (IOException iOException) {
/* 183 */         iOException.printStackTrace();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 188 */       try { bufferedInputStream1.close(); }
/* 189 */       catch (IOException iOException)
/* 190 */       { iOException.printStackTrace(); }  } catch (Exception exception) { BufferedInputStream bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; String str = TAG; bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; StringBuilder stringBuilder = new StringBuilder(); bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; this(); bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; stringBuilder.append("exception "); bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; stringBuilder.append(exception); bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; Log.e(str, stringBuilder.toString()); bufferedInputStream1 = bufferedInputStream; bufferedOutputStream1 = bufferedOutputStream2; exception.printStackTrace(); if (bufferedOutputStream2 != null)
/*     */         try { bufferedOutputStream2.flush(); bufferedOutputStream2.close(); }
/*     */         catch (IOException iOException) { iOException.printStackTrace(); }
/*     */           if (bufferedInputStream != null)
/*     */         bufferedInputStream.close();  }
/* 195 */     finally {} StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append(paramString2); stringBuilder1.append(desFileName); setPerm(stringBuilder1.toString());
/*     */   }
/*     */   public void writeAdPlayParameters(File paramFile) {
/*     */     String str2;
/* 199 */     StringBuilder stringBuilder2 = null; String str3 = null;
/* 200 */     String str1 = TAG; StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("writeAdPlayParameters adId = "); stringBuilder1.append(adPlayParameters.adId); Log.d(str1, stringBuilder1.toString());
/*     */     
/* 202 */     str1 = str3; stringBuilder1 = stringBuilder2; try { FileWriter fileWriter4 = new FileWriter(); str1 = str3; stringBuilder1 = stringBuilder2; this(paramFile); FileWriter fileWriter1 = fileWriter4;
/* 203 */       FileWriter fileWriter2 = fileWriter1, fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adId="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adId); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/* 204 */       fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adPath="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adPath); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/* 205 */       fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adMd5="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adMd5); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/* 206 */       fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adDuration="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adDuration); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/* 207 */       fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adMaxTimes="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adMaxTimes); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/* 208 */       fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adEffectiveTime="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adEffectiveTime); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/* 209 */       fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2 = new StringBuilder(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; this(); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("adExpiredTime="); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append(adPlayParameters.adExpiredTime); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; stringBuilder2.append("\n"); fileWriter2 = fileWriter1; fileWriter3 = fileWriter1; fileWriter1.write(stringBuilder2.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 215 */       try { fileWriter1.close(); }
/* 216 */       catch (IOException iOException)
/* 217 */       { str2 = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("writeAdPlayParameters"); stringBuilder.append(iOException); Log.e(str2, stringBuilder.toString()); }  } catch (IOException iOException) { str1 = str2; String str = TAG; str1 = str2; StringBuilder stringBuilder = new StringBuilder(); str1 = str2; this(); str1 = str2; stringBuilder.append("writeAdPlayParameters"); str1 = str2; stringBuilder.append(iOException); str1 = str2; Log.e(str, stringBuilder.toString()); if (str2 != null) try { str2.close(); } catch (IOException iOException1) { str2 = TAG; StringBuilder stringBuilder3 = new StringBuilder(); stringBuilder3.append("writeAdPlayParameters"); stringBuilder3.append(iOException1); Log.e(str2, stringBuilder3.toString()); }
/*     */       
/*     */        }
/*     */     finally {}
/*     */   }
/*     */   
/*     */   public void writeAdPlayRecords(File paramFile) {
/*     */     String str;
/* 225 */     FileWriter fileWriter4 = null, fileWriter3 = null;
/*     */     
/* 227 */     FileWriter fileWriter1 = fileWriter3, fileWriter2 = fileWriter4; try { FileWriter fileWriter6 = new FileWriter(); fileWriter1 = fileWriter3; fileWriter2 = fileWriter4; this(paramFile); FileWriter fileWriter5 = fileWriter6;
/* 228 */       fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; StringBuilder stringBuilder = new StringBuilder(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; this(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("adId="); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append(adPlayRecords.adId); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("\n"); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; fileWriter5.write(stringBuilder.toString());
/* 229 */       fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder = new StringBuilder(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; this(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("DisplayTimestamp="); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append(adPlayRecords.DisplayTimestamp); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("\n"); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; fileWriter5.write(stringBuilder.toString());
/* 230 */       fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder = new StringBuilder(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; this(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("DisplayDuration="); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append(adPlayRecords.DisplayDuration); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("\n"); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; fileWriter5.write(stringBuilder.toString());
/* 231 */       fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder = new StringBuilder(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; this(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("ClickCount="); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append(adPlayRecords.ClickCount); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("\n"); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; fileWriter5.write(stringBuilder.toString());
/* 232 */       fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder = new StringBuilder(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; this(); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("Skiped="); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append(adPlayRecords.Skiped); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; stringBuilder.append("\n"); fileWriter1 = fileWriter5; fileWriter2 = fileWriter5; fileWriter5.write(stringBuilder.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 238 */       try { fileWriter5.close(); }
/* 239 */       catch (IOException iOException)
/* 240 */       { str = TAG; StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("writeAdPlayRecords"); stringBuilder1.append(iOException); Log.e(str, stringBuilder1.toString()); }  } catch (IOException iOException) { String str2 = str, str1 = TAG; str2 = str; StringBuilder stringBuilder = new StringBuilder(); str2 = str; this(); str2 = str; stringBuilder.append("writeAdPlayRecords"); str2 = str; stringBuilder.append(iOException); str2 = str; Log.e(str1, stringBuilder.toString()); if (str != null) try { str.close(); } catch (IOException iOException1) { str = TAG; StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("writeAdPlayRecords"); stringBuilder1.append(iOException1); Log.e(str, stringBuilder1.toString()); }
/*     */       
/*     */        }
/*     */     finally {}
/*     */   }
/*     */ 
/*     */   
/*     */   private void readAdPlayParameters(File paramFile) {
/*     */     try {
/* 249 */       BufferedReader bufferedReader = new BufferedReader(); FileReader fileReader = new FileReader(); this(paramFile); this(fileReader);
/*     */       while (true) {
/* 251 */         String str = bufferedReader.readLine(); if (str != null) {
/* 252 */           String[] arrayOfString = str.split("=");
/* 253 */           if ("adId".equals(arrayOfString[0])) {
/* 254 */             adPlayParameters.adId = arrayOfString[1]; continue;
/* 255 */           }  if ("adPath".equals(arrayOfString[0])) {
/* 256 */             adPlayParameters.adPath = arrayOfString[1]; continue;
/* 257 */           }  if ("adMd5".equals(arrayOfString[0])) {
/* 258 */             adPlayParameters.adMd5 = arrayOfString[1]; continue;
/* 259 */           }  if ("adDuration".equals(arrayOfString[0])) {
/* 260 */             adPlayParameters.adDuration = StringToLong(arrayOfString[1]); continue;
/* 261 */           }  if ("adMaxTimes".equals(arrayOfString[0])) {
/* 262 */             adPlayParameters.adMaxTimes = StringToInt(arrayOfString[1]); continue;
/* 263 */           }  if ("adEffectiveTime".equals(arrayOfString[0])) {
/* 264 */             adPlayParameters.adEffectiveTime = StringToLong(arrayOfString[1]); continue;
/* 265 */           }  if ("adExpiredTime".equals(arrayOfString[0]))
/* 266 */             adPlayParameters.adExpiredTime = StringToLong(arrayOfString[1]);  continue;
/*     */         }  break;
/*     */       } 
/* 269 */       bufferedReader.close();
/* 270 */     } catch (Exception exception) {
/* 271 */       String str = TAG; StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("readAdPlayParameters"); stringBuilder.append(exception); Log.e(str, stringBuilder.toString());
/*     */     } finally {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readAdPlayRecords(File paramFile) {
/*     */     try {
/* 279 */       BufferedReader bufferedReader = new BufferedReader(); FileReader fileReader = new FileReader(); this(paramFile); this(fileReader);
/*     */       while (true) {
/* 281 */         String str = bufferedReader.readLine(); if (str != null) {
/* 282 */           String[] arrayOfString = str.split("=");
/* 283 */           if ("adId".equals(arrayOfString[0])) {
/* 284 */             adPlayRecords.adId = arrayOfString[1]; continue;
/* 285 */           }  if ("DisplayTimestamp".equals(arrayOfString[0])) {
/* 286 */             adPlayRecords.DisplayTimestamp = StringToLong(arrayOfString[1]); continue;
/* 287 */           }  if ("DisplayDuration".equals(arrayOfString[0])) {
/* 288 */             adPlayRecords.DisplayDuration = StringToLong(arrayOfString[1]); continue;
/* 289 */           }  if ("ClickCount".equals(arrayOfString[0])) {
/* 290 */             adPlayRecords.ClickCount = StringToInt(arrayOfString[1]); continue;
/* 291 */           }  if ("Skiped".equals(arrayOfString[0])) {
/* 292 */             if ("false".equals(arrayOfString[1])) {
/* 293 */               adPlayRecords.Skiped = false; continue;
/*     */             } 
/* 295 */             adPlayRecords.Skiped = true;
/*     */           }  continue;
/*     */         }  break;
/*     */       } 
/* 299 */       bufferedReader.close();
/* 300 */     } catch (Exception exception) {
/* 301 */       String str = TAG; StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("readAdPlayRecords"); stringBuilder.append(exception); Log.e(str, stringBuilder.toString());
/*     */     } finally {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long StringToLong(String paramString) {
/*     */     try {
/* 310 */       return Long.parseLong(paramString);
/*     */     }
/* 312 */     catch (Exception exception) {
/* 313 */       String str = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("StringToLong"); stringBuilder.append(exception); Log.e(str, stringBuilder.toString());
/*     */       
/* 315 */       return 0L;
/*     */     } 
/*     */   }
/*     */   private int StringToInt(String paramString) {
/*     */     try {
/* 320 */       return Integer.parseInt(paramString);
/*     */     }
/* 322 */     catch (Exception exception) {
/* 323 */       paramString = TAG; StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("StringToInt"); stringBuilder.append(exception); Log.e(paramString, stringBuilder.toString());
/*     */       
/* 325 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAdRecordInfo getLatestAdRecord() {
/* 337 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(desDir); stringBuilder.append(playRecords_fileName); readAdPlayRecords(new File(stringBuilder.toString()));
/* 338 */     return adPlayRecords;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOnAdOperationChangedListener(IAdvertise.OnAdOperationChangedListener paramOnAdOperationChangedListener) {
/* 347 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(desDir); stringBuilder.append(playRecords_fileName); readAdPlayRecords(new File(stringBuilder.toString()));
/* 348 */     paramOnAdOperationChangedListener.onUpdateAdRecord(adPlayRecords);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeOnAdOperationChangedListener(IAdvertise.OnAdOperationChangedListener paramOnAdOperationChangedListener) {}
/*     */ 
/*     */   
/*     */   class AdPlayParameters
/*     */   {
/*     */     public long adDuration;
/*     */     
/*     */     public long adEffectiveTime;
/*     */     
/*     */     public long adExpiredTime;
/*     */     
/*     */     public String adId;
/*     */     
/*     */     public int adMaxTimes;
/*     */     
/*     */     public String adMd5;
/*     */     public String adPath;
/*     */     final Advertise this$0;
/*     */     
/*     */     public AdPlayParameters() {}
/*     */     
/*     */     public AdPlayParameters(String param1String1, String param1String2, String param1String3, long param1Long1, int param1Int, long param1Long2, long param1Long3) {
/* 374 */       this.adId = param1String1;
/* 375 */       this.adPath = param1String2;
/* 376 */       this.adMd5 = param1String3;
/* 377 */       this.adDuration = param1Long1;
/* 378 */       this.adMaxTimes = param1Int;
/* 379 */       this.adEffectiveTime = param1Long2;
/* 380 */       this.adExpiredTime = param1Long3;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class AdPlayRecords
/*     */     implements IAdRecordInfo
/*     */   {
/*     */     public int ClickCount;
/*     */ 
/*     */ 
/*     */     
/*     */     public long DisplayDuration;
/*     */ 
/*     */ 
/*     */     
/*     */     public long DisplayTimestamp;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean Skiped;
/*     */ 
/*     */     
/*     */     public String adId;
/*     */ 
/*     */     
/*     */     final Advertise this$0;
/*     */ 
/*     */ 
/*     */     
/*     */     public AdPlayRecords() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public AdPlayRecords(String param1String, long param1Long1, long param1Long2, int param1Int, boolean param1Boolean) {
/* 417 */       this.adId = param1String;
/* 418 */       this.DisplayTimestamp = param1Long1;
/* 419 */       this.DisplayDuration = param1Long2;
/* 420 */       this.ClickCount = param1Int;
/* 421 */       this.Skiped = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getAdId() {
/* 426 */       return this.adId;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getDisplayTimestamp() {
/* 431 */       return this.DisplayTimestamp;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getDisplayDuration() {
/* 436 */       return this.DisplayDuration;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getClickCount() {
/* 441 */       return this.ClickCount;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSkiped() {
/* 446 */       return this.Skiped;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ads\Advertise.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */