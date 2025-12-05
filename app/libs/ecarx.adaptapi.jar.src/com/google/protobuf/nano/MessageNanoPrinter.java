/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
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
/*     */ public final class MessageNanoPrinter
/*     */ {
/*     */   private static final String INDENT = "  ";
/*     */   private static final int MAX_STRING_LEN = 200;
/*     */   
/*     */   public static <T extends MessageNano> String print(T paramT) {
/*  62 */     if (paramT == null) {
/*  63 */       return "";
/*     */     }
/*     */     
/*  66 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     try {
/*  68 */       StringBuffer stringBuffer1 = new StringBuffer(); this(); print(null, paramT, stringBuffer1, stringBuffer);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  74 */       return stringBuffer.toString();
/*     */     } catch (IllegalAccessException illegalAccessException) {
/*     */       StringBuilder stringBuilder = new StringBuilder();
/*     */       stringBuilder.append("Error printing proto: ");
/*     */       stringBuilder.append(illegalAccessException.getMessage());
/*     */       return stringBuilder.toString();
/*     */     } catch (InvocationTargetException invocationTargetException) {
/*     */       StringBuilder stringBuilder = new StringBuilder();
/*     */       stringBuilder.append("Error printing proto: ");
/*     */       stringBuilder.append(invocationTargetException.getMessage());
/*     */       return stringBuilder.toString();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void print(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2) throws IllegalAccessException, InvocationTargetException {
/*  91 */     if (paramObject != null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  97 */       if (paramObject instanceof MessageNano) {
/*  98 */         int i = paramStringBuffer1.length();
/*  99 */         if (paramString != null) {
/* 100 */           paramStringBuffer2.append(paramStringBuffer1); paramStringBuffer2.append(deCamelCaseify(paramString)); paramStringBuffer2.append(" <\n");
/* 101 */           paramStringBuffer1.append("  ");
/*     */         } 
/* 103 */         Class<?> clazz = paramObject.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 109 */         for (Field field : clazz.getFields()) {
/* 110 */           int j = field.getModifiers();
/* 111 */           String str = field.getName();
/* 112 */           if (!"cachedSize".equals(str))
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 117 */             if ((j & 0x1) == 1 && (j & 0x8) != 8)
/*     */             {
/* 119 */               if (!str.startsWith("_") && 
/* 120 */                 !str.endsWith("_")) {
/* 121 */                 Class<?> clazz1 = field.getType();
/* 122 */                 Object object = field.get(paramObject);
/*     */                 
/* 124 */                 if (clazz1.isArray())
/* 125 */                 { int k; clazz1 = clazz1.getComponentType();
/*     */ 
/*     */                   
/* 128 */                   if (clazz1 == byte.class)
/* 129 */                   { print(str, object, paramStringBuffer1, paramStringBuffer2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/* 137 */                     Field[] arrayOfField = null; j = null; continue; }  if (object == null) { k = 0; } else { k = Array.getLength(object); }  byte b = 0; while (true) { j = null; Object object2 = null; if (b < k) { object2 = Array.get(object, b); print(str, object2, paramStringBuffer1, paramStringBuffer2); b++; continue; }  null = j; Object object1 = object2; break; }  }
/* 138 */                 else { print(str, object, paramStringBuffer1, paramStringBuffer2); }
/*     */               
/*     */               } 
/*     */             }
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 146 */         for (Method method : clazz.getMethods()) {
/* 147 */           String str = method.getName();
/*     */ 
/*     */           
/* 150 */           if (str.startsWith("set")) {
/* 151 */             str = str.substring(3);
/*     */ 
/*     */             
/*     */             try {
/* 155 */               StringBuilder stringBuilder = new StringBuilder(); this(); stringBuilder.append("has"); stringBuilder.append(str); String str1 = stringBuilder.toString(); try { Method method1 = clazz.getMethod(str1, new Class[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 160 */                 if (((Boolean)method1.invoke(paramObject, new Object[0])).booleanValue())
/*     */ 
/*     */                   
/*     */                   try { 
/*     */ 
/*     */                     
/* 166 */                     StringBuilder stringBuilder1 = new StringBuilder(); this(); stringBuilder1.append("get"); stringBuilder1.append(str); String str2 = stringBuilder1.toString(); try { Method method2 = clazz.getMethod(str2, new Class[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */                       
/* 171 */                       print(str, method2.invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2); } catch (NoSuchMethodException noSuchMethodException) {} } catch (NoSuchMethodException noSuchMethodException) {}  } catch (NoSuchMethodException noSuchMethodException) {}
/*     */             } catch (NoSuchMethodException noSuchMethodException) {}
/*     */           } 
/* 174 */         }  if (paramString != null) {
/* 175 */           paramStringBuffer1.setLength(i);
/* 176 */           paramStringBuffer2.append(paramStringBuffer1); paramStringBuffer2.append(">\n");
/*     */         } 
/* 178 */       } else if (paramObject instanceof java.util.Map) {
/* 179 */         paramObject = paramObject;
/* 180 */         paramString = deCamelCaseify(paramString);
/*     */         
/* 182 */         for (Object paramObject : paramObject.entrySet()) {
/* 183 */           paramStringBuffer2.append(paramStringBuffer1); paramStringBuffer2.append(paramString); paramStringBuffer2.append(" <\n");
/* 184 */           int i = paramStringBuffer1.length();
/* 185 */           paramStringBuffer1.append("  ");
/* 186 */           print("key", paramObject.getKey(), paramStringBuffer1, paramStringBuffer2);
/* 187 */           print("value", paramObject.getValue(), paramStringBuffer1, paramStringBuffer2);
/* 188 */           paramStringBuffer1.setLength(i);
/* 189 */           paramStringBuffer2.append(paramStringBuffer1); paramStringBuffer2.append(">\n");
/*     */         } 
/*     */       } else {
/*     */         
/* 193 */         paramString = deCamelCaseify(paramString);
/* 194 */         paramStringBuffer2.append(paramStringBuffer1); paramStringBuffer2.append(paramString); paramStringBuffer2.append(": ");
/* 195 */         if (paramObject instanceof String) {
/* 196 */           paramString = sanitizeString((String)paramObject);
/* 197 */           paramStringBuffer2.append("\""); paramStringBuffer2.append(paramString); paramStringBuffer2.append("\"");
/* 198 */         } else if (paramObject instanceof byte[]) {
/* 199 */           appendQuotedBytes((byte[])paramObject, paramStringBuffer2);
/*     */         } else {
/* 201 */           paramStringBuffer2.append(paramObject);
/*     */         } 
/* 203 */         paramStringBuffer2.append("\n");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String deCamelCaseify(String paramString) {
/* 211 */     StringBuffer stringBuffer = new StringBuffer();
/* 212 */     for (byte b = 0; b < paramString.length(); b++) {
/* 213 */       char c = paramString.charAt(b);
/* 214 */       if (b == 0) {
/* 215 */         stringBuffer.append(Character.toLowerCase(c));
/* 216 */       } else if (Character.isUpperCase(c)) {
/* 217 */         stringBuffer.append('_'); stringBuffer.append(Character.toLowerCase(c));
/*     */       } else {
/* 219 */         stringBuffer.append(c);
/*     */       } 
/*     */     } 
/* 222 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String sanitizeString(String paramString) {
/* 229 */     String str = paramString; if (!paramString.startsWith("http")) { str = paramString; if (paramString.length() > 200) {
/*     */         
/* 231 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramString.substring(0, 200)); stringBuilder.append("[...]"); str = stringBuilder.toString();
/*     */       }  }
/* 233 */      return escapeString(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String escapeString(String paramString) {
/* 240 */     int i = paramString.length();
/* 241 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 242 */     for (byte b = 0; b < i; b++) {
/* 243 */       char c = paramString.charAt(b);
/* 244 */       if (c >= ' ' && c <= '~' && c != '"' && c != '\'') {
/* 245 */         stringBuilder.append(c);
/*     */       } else {
/* 247 */         stringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
/*     */       } 
/*     */     } 
/* 250 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendQuotedBytes(byte[] paramArrayOfbyte, StringBuffer paramStringBuffer) {
/* 257 */     if (paramArrayOfbyte == null) {
/* 258 */       paramStringBuffer.append("\"\"");
/*     */       
/*     */       return;
/*     */     } 
/* 262 */     paramStringBuffer.append('"');
/* 263 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 264 */       int i = paramArrayOfbyte[b] & 0xFF;
/* 265 */       if (i == 92 || i == 34) {
/* 266 */         paramStringBuffer.append('\\'); paramStringBuffer.append((char)i);
/* 267 */       } else if (i >= 32 && i < 127) {
/* 268 */         paramStringBuffer.append((char)i);
/*     */       } else {
/* 270 */         paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(i) }));
/*     */       } 
/*     */     } 
/* 273 */     paramStringBuffer.append('"');
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\MessageNanoPrinter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */