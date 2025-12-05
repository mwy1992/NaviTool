/*     */ package com.ecarx.xui.adaptapi.utils;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ 
/*     */ public class ProperUtils {
/*     */   private static InputStream in;
/*     */   private static Properties properties;
/*     */   
/*  17 */   static { File file = new File("/lcfg/adaptapi.properties");
/*     */     try {
/*  19 */       BufferedInputStream bufferedInputStream = new BufferedInputStream(); FileInputStream fileInputStream = new FileInputStream(); this(file); this(fileInputStream); in = bufferedInputStream;
/*  20 */       Properties properties = new Properties(); this(); properties = properties;
/*  21 */       properties.load(in);
/*  22 */     } catch (IOException iOException) {
/*  23 */       iOException.printStackTrace();
/*     */     }  } public static Object getPropertyValue(String paramString, Class<int> paramClass) {
/*     */     int[] arrayOfInt;
/*     */     short[] arrayOfShort;
/*     */     HashMap<Object, Object> hashMap;
/*  28 */     String str = properties.getProperty(paramString);
/*  29 */     String[] arrayOfString = str.split(",");
/*  30 */     if (paramClass == int.class) {
/*  31 */       if (str.startsWith("0x")) {
/*  32 */         return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
/*     */       }
/*  34 */       return Integer.valueOf(Integer.parseInt(str));
/*     */     } 
/*  36 */     if (paramClass == short.class) {
/*  37 */       return Short.valueOf(Short.parseShort(str));
/*     */     }
/*  39 */     if (paramClass == boolean.class) {
/*  40 */       return Boolean.valueOf(Boolean.parseBoolean(str));
/*     */     }
/*  42 */     if (paramClass == long.class) {
/*  43 */       return Long.valueOf(Long.parseLong(str));
/*     */     }
/*  45 */     if (paramClass == double.class) {
/*  46 */       return Double.valueOf(Double.parseDouble(str));
/*     */     }
/*  48 */     int j = 0, i = 0; byte b = 0; if (paramClass == int[].class) {
/*  49 */       arrayOfInt = new int[arrayOfString.length];
/*  50 */       for (i = b; i < arrayOfString.length; i++) {
/*  51 */         if (str.startsWith("0x")) {
/*  52 */           arrayOfInt[i] = Integer.parseInt(arrayOfString[i].substring(2).trim(), 16);
/*     */         } else {
/*  54 */           arrayOfInt[i] = Integer.parseInt(arrayOfString[i].trim());
/*     */         } 
/*  56 */       }  return arrayOfInt;
/*     */     } 
/*  58 */     if (arrayOfInt == short[].class) {
/*  59 */       arrayOfShort = new short[arrayOfString.length];
/*  60 */       for (i = j; i < arrayOfString.length; i++) {
/*  61 */         arrayOfShort[i] = Short.parseShort(arrayOfString[i].trim());
/*     */       }
/*  63 */       return arrayOfShort;
/*     */     } 
/*  65 */     if (arrayOfShort == Map.class) {
/*  66 */       hashMap = new HashMap<>();
/*  67 */       for (j = arrayOfString.length, i = 0; i < j; ) { str = arrayOfString[i];
/*  68 */         String[] arrayOfString1 = str.split("=");
/*     */         
/*  70 */         arrayOfString1[0] = arrayOfString1[0].replaceAll("0x0*", "");
/*  71 */         arrayOfString1[1] = arrayOfString1[1].replaceAll("0x0*", "");
/*     */         
/*  73 */         hashMap.put(arrayOfString1[0].trim(), arrayOfString1[1]); i++; }
/*     */       
/*  75 */       return hashMap;
/*  76 */     }  if (hashMap == String.class) {
/*  77 */       StringBuilder stringBuilder = new StringBuilder();
/*  78 */       for (j = arrayOfString.length; i < j; ) { str = arrayOfString[i];
/*  79 */         stringBuilder.append(str); i++; }
/*  80 */        return stringBuilder;
/*     */     } 
/*     */     
/*  83 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean setPropertyValue(String paramString, Object paramObject) {
/*  89 */     String str = String.valueOf(paramObject); try {
/*     */       String str1;
/*  91 */       if (paramObject.getClass() == HashMap.class)
/*  92 */       { str1 = str.substring(1, str.length() - 1); }
/*  93 */       else { str1 = str; if (paramObject.getClass().isArray())
/*  94 */           str1 = Arrays.<Object>asList((Object[])paramObject).toString().substring(1, str.length() - 1);  }
/*  95 */        properties.setProperty(paramString, str1);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 100 */       return true;
/*     */     } catch (Exception exception) {
/*     */       exception.printStackTrace();
/*     */       return false;
/* 104 */     }  } public static void main(String[] paramArrayOfString) { Map map = (Map)getPropertyValue("EVS_CameraOpened", Map.class);
/*     */     
/* 106 */     System.out.print(map.get(Integer.toHexString(1))); }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptap\\utils\ProperUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */