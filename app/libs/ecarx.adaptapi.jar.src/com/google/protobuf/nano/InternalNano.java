/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
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
/*     */ public final class InternalNano
/*     */ {
/*     */   protected static final Charset ISO_8859_1;
/*     */   public static final Object LAZY_INIT_LOCK;
/*     */   public static final int TYPE_BOOL = 8;
/*     */   public static final int TYPE_BYTES = 12;
/*     */   public static final int TYPE_DOUBLE = 1;
/*     */   public static final int TYPE_ENUM = 14;
/*     */   public static final int TYPE_FIXED32 = 7;
/*     */   public static final int TYPE_FIXED64 = 6;
/*     */   public static final int TYPE_FLOAT = 2;
/*     */   public static final int TYPE_GROUP = 10;
/*     */   public static final int TYPE_INT32 = 5;
/*     */   public static final int TYPE_INT64 = 3;
/*     */   public static final int TYPE_MESSAGE = 11;
/*     */   public static final int TYPE_SFIXED32 = 15;
/*     */   public static final int TYPE_SFIXED64 = 16;
/*     */   public static final int TYPE_SINT32 = 17;
/*     */   public static final int TYPE_SINT64 = 18;
/*     */   public static final int TYPE_STRING = 9;
/*     */   public static final int TYPE_UINT32 = 13;
/*     */   public static final int TYPE_UINT64 = 4;
/*  70 */   protected static final Charset UTF_8 = Charset.forName("UTF-8"); static {
/*  71 */     ISO_8859_1 = Charset.forName("ISO-8859-1");
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
/*  85 */     LAZY_INIT_LOCK = new Object();
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
/*     */   public static String stringDefaultValue(String paramString) {
/* 116 */     return new String(paramString.getBytes(ISO_8859_1), UTF_8);
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
/*     */   public static byte[] bytesDefaultValue(String paramString) {
/* 128 */     return paramString.getBytes(ISO_8859_1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] copyFromUtf8(String paramString) {
/* 136 */     return paramString.getBytes(UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/* 144 */     if (paramArrayOfint1 == null || paramArrayOfint1.length == 0) {
/* 145 */       return (paramArrayOfint2 == null || paramArrayOfint2.length == 0);
/*     */     }
/* 147 */     return Arrays.equals(paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/* 156 */     if (paramArrayOflong1 == null || paramArrayOflong1.length == 0) {
/* 157 */       return (paramArrayOflong2 == null || paramArrayOflong2.length == 0);
/*     */     }
/* 159 */     return Arrays.equals(paramArrayOflong1, paramArrayOflong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
/* 168 */     if (paramArrayOffloat1 == null || paramArrayOffloat1.length == 0) {
/* 169 */       return (paramArrayOffloat2 == null || paramArrayOffloat2.length == 0);
/*     */     }
/* 171 */     return Arrays.equals(paramArrayOffloat1, paramArrayOffloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/* 180 */     if (paramArrayOfdouble1 == null || paramArrayOfdouble1.length == 0) {
/* 181 */       return (paramArrayOfdouble2 == null || paramArrayOfdouble2.length == 0);
/*     */     }
/* 183 */     return Arrays.equals(paramArrayOfdouble1, paramArrayOfdouble2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/* 192 */     if (paramArrayOfboolean1 == null || paramArrayOfboolean1.length == 0) {
/* 193 */       return (paramArrayOfboolean2 == null || paramArrayOfboolean2.length == 0);
/*     */     }
/* 195 */     return Arrays.equals(paramArrayOfboolean1, paramArrayOfboolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(byte[][] paramArrayOfbyte1, byte[][] paramArrayOfbyte2) {
/*     */     int j, k;
/* 206 */     byte b = 0;
/* 207 */     if (paramArrayOfbyte1 == null) { j = 0; } else { j = paramArrayOfbyte1.length; }
/* 208 */      int i = 0;
/* 209 */     if (paramArrayOfbyte2 == null) { k = 0; } else { k = paramArrayOfbyte2.length; }
/*     */      while (true) {
/* 211 */       byte b1; int m = i; if (b < j) { m = i; if (paramArrayOfbyte1[b] == null) {
/* 212 */           b++; continue;
/*     */         }  }
/* 214 */        while (m < k && paramArrayOfbyte2[m] == null) {
/* 215 */         m++;
/*     */       }
/* 217 */       if (b >= j) { i = 1; } else { i = 0; }
/* 218 */        if (m >= k) { b1 = 1; } else { b1 = 0; }
/* 219 */        if (i != 0 && b1)
/*     */       {
/* 221 */         return true; } 
/* 222 */       if (i != b1)
/*     */       {
/* 224 */         return false; } 
/* 225 */       if (!Arrays.equals(paramArrayOfbyte1[b], paramArrayOfbyte2[m]))
/*     */       {
/* 227 */         return false;
/*     */       }
/* 229 */       b++;
/* 230 */       i = m + 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*     */     int j, k;
/* 241 */     byte b = 0;
/* 242 */     if (paramArrayOfObject1 == null) { j = 0; } else { j = paramArrayOfObject1.length; }
/* 243 */      int i = 0;
/* 244 */     if (paramArrayOfObject2 == null) { k = 0; } else { k = paramArrayOfObject2.length; }
/*     */      while (true) {
/* 246 */       byte b1; int m = i; if (b < j) { m = i; if (paramArrayOfObject1[b] == null) {
/* 247 */           b++; continue;
/*     */         }  }
/* 249 */        while (m < k && paramArrayOfObject2[m] == null) {
/* 250 */         m++;
/*     */       }
/* 252 */       if (b >= j) { i = 1; } else { i = 0; }
/* 253 */        if (m >= k) { b1 = 1; } else { b1 = 0; }
/* 254 */        if (i != 0 && b1)
/*     */       {
/* 256 */         return true; } 
/* 257 */       if (i != b1)
/*     */       {
/* 259 */         return false; } 
/* 260 */       if (!paramArrayOfObject1[b].equals(paramArrayOfObject2[m]))
/*     */       {
/* 262 */         return false;
/*     */       }
/* 264 */       b++;
/* 265 */       i = m + 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(int[] paramArrayOfint) {
/* 274 */     return (paramArrayOfint == null || paramArrayOfint.length == 0) ? 0 : Arrays.hashCode(paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(long[] paramArrayOflong) {
/* 282 */     return (paramArrayOflong == null || paramArrayOflong.length == 0) ? 0 : Arrays.hashCode(paramArrayOflong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(float[] paramArrayOffloat) {
/* 290 */     return (paramArrayOffloat == null || paramArrayOffloat.length == 0) ? 0 : Arrays.hashCode(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(double[] paramArrayOfdouble) {
/* 298 */     return (paramArrayOfdouble == null || paramArrayOfdouble.length == 0) ? 0 : Arrays.hashCode(paramArrayOfdouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(boolean[] paramArrayOfboolean) {
/* 306 */     return (paramArrayOfboolean == null || paramArrayOfboolean.length == 0) ? 0 : Arrays.hashCode(paramArrayOfboolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(byte[][] paramArrayOfbyte) {
/*     */     int i;
/* 315 */     boolean bool = false;
/* 316 */     byte b = 0; if (paramArrayOfbyte == null) { i = 0; } else { i = paramArrayOfbyte.length; }  Object object; for (; b < i; b++, object = SYNTHETIC_LOCAL_VARIABLE_4) {
/* 317 */       byte[] arrayOfByte = paramArrayOfbyte[b];
/* 318 */       Object object1 = object; if (arrayOfByte != null) {
/* 319 */         int j = Arrays.hashCode(arrayOfByte); j = 31 * object + j;
/*     */       }  continue;
/*     */     } 
/* 322 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int hashCode(Object[] paramArrayOfObject) {
/*     */     int i;
/* 332 */     boolean bool = false;
/* 333 */     byte b = 0; if (paramArrayOfObject == null) { i = 0; } else { i = paramArrayOfObject.length; }  Object object; for (; b < i; b++, object = SYNTHETIC_LOCAL_VARIABLE_4) {
/* 334 */       Object object2 = paramArrayOfObject[b];
/* 335 */       Object object1 = object; if (object2 != null) {
/* 336 */         int j = object2.hashCode(); j = 31 * object + j;
/*     */       }  continue;
/*     */     } 
/* 339 */     return object;
/*     */   } private static Object primitiveDefaultValue(int paramInt) {
/*     */     StringBuilder stringBuilder;
/* 342 */     switch (paramInt) {
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
/*     */       default:
/* 369 */         stringBuilder = new StringBuilder(); stringBuilder.append("Type: "); stringBuilder.append(paramInt); stringBuilder.append(" is not a primitive type."); throw new IllegalArgumentException(stringBuilder.toString());
/*     */       case 12:
/*     */         return WireFormatNano.EMPTY_BYTES;
/*     */       case 9:
/*     */         return "";
/*     */       case 8:
/*     */         return Boolean.FALSE;
/*     */       case 5:
/*     */       case 7:
/*     */       case 13:
/*     */       case 14:
/*     */       case 15:
/*     */       case 17:
/*     */         return Integer.valueOf(0);
/*     */       case 3:
/*     */       case 4:
/*     */       case 6:
/*     */       case 16:
/*     */       case 18:
/*     */         return Long.valueOf(0L);
/*     */       case 2:
/*     */         return Float.valueOf(0.0F);
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     return Double.valueOf(0.0D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final <K, V> Map<K, V> mergeMapEntry(CodedInputByteBufferNano paramCodedInputByteBufferNano, Map<K, V> paramMap, MapFactories.MapFactory paramMapFactory, int paramInt1, int paramInt2, V paramV, int paramInt3, int paramInt4) throws IOException {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: aload_1
/*     */     //   2: invokeinterface forMap : (Ljava/util/Map;)Ljava/util/Map;
/*     */     //   7: astore #11
/*     */     //   9: aload_0
/*     */     //   10: invokevirtual readRawVarint32 : ()I
/*     */     //   13: istore #8
/*     */     //   15: aload_0
/*     */     //   16: iload #8
/*     */     //   18: invokevirtual pushLimit : (I)I
/*     */     //   21: istore #9
/*     */     //   23: aconst_null
/*     */     //   24: astore_1
/*     */     //   25: aload_0
/*     */     //   26: invokevirtual readTag : ()I
/*     */     //   29: istore #8
/*     */     //   31: iload #8
/*     */     //   33: ifne -> 39
/*     */     //   36: goto -> 119
/*     */     //   39: iload #8
/*     */     //   41: iload #6
/*     */     //   43: if_icmpne -> 59
/*     */     //   46: aload_0
/*     */     //   47: iload_3
/*     */     //   48: invokevirtual readPrimitiveField : (I)Ljava/lang/Object;
/*     */     //   51: astore_2
/*     */     //   52: aload #5
/*     */     //   54: astore #10
/*     */     //   56: goto -> 168
/*     */     //   59: iload #8
/*     */     //   61: iload #7
/*     */     //   63: if_icmpne -> 104
/*     */     //   66: iload #4
/*     */     //   68: bipush #11
/*     */     //   70: if_icmpne -> 91
/*     */     //   73: aload_0
/*     */     //   74: aload #5
/*     */     //   76: checkcast com/google/protobuf/nano/MessageNano
/*     */     //   79: invokevirtual readMessage : (Lcom/google/protobuf/nano/MessageNano;)V
/*     */     //   82: aload_1
/*     */     //   83: astore_2
/*     */     //   84: aload #5
/*     */     //   86: astore #10
/*     */     //   88: goto -> 168
/*     */     //   91: aload_0
/*     */     //   92: iload #4
/*     */     //   94: invokevirtual readPrimitiveField : (I)Ljava/lang/Object;
/*     */     //   97: astore #10
/*     */     //   99: aload_1
/*     */     //   100: astore_2
/*     */     //   101: goto -> 168
/*     */     //   104: aload_1
/*     */     //   105: astore_2
/*     */     //   106: aload #5
/*     */     //   108: astore #10
/*     */     //   110: aload_0
/*     */     //   111: iload #8
/*     */     //   113: invokevirtual skipField : (I)Z
/*     */     //   116: ifne -> 168
/*     */     //   119: aload_0
/*     */     //   120: iconst_0
/*     */     //   121: invokevirtual checkLastTagWas : (I)V
/*     */     //   124: aload_0
/*     */     //   125: iload #9
/*     */     //   127: invokevirtual popLimit : (I)V
/*     */     //   130: aload_1
/*     */     //   131: astore_0
/*     */     //   132: aload_1
/*     */     //   133: ifnonnull -> 141
/*     */     //   136: iload_3
/*     */     //   137: invokestatic primitiveDefaultValue : (I)Ljava/lang/Object;
/*     */     //   140: astore_0
/*     */     //   141: aload #5
/*     */     //   143: astore_1
/*     */     //   144: aload #5
/*     */     //   146: ifnonnull -> 155
/*     */     //   149: iload #4
/*     */     //   151: invokestatic primitiveDefaultValue : (I)Ljava/lang/Object;
/*     */     //   154: astore_1
/*     */     //   155: aload #11
/*     */     //   157: aload_0
/*     */     //   158: aload_1
/*     */     //   159: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   164: pop
/*     */     //   165: aload #11
/*     */     //   167: areturn
/*     */     //   168: aload_2
/*     */     //   169: astore_1
/*     */     //   170: aload #10
/*     */     //   172: astore #5
/*     */     //   174: goto -> 25
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #400	-> 0
/*     */     //   #401	-> 9
/*     */     //   #402	-> 15
/*     */     //   #403	-> 23
/*     */     //   #405	-> 25
/*     */     //   #406	-> 31
/*     */     //   #407	-> 36
/*     */     //   #409	-> 39
/*     */     //   #410	-> 46
/*     */     //   #411	-> 59
/*     */     //   #412	-> 66
/*     */     //   #413	-> 73
/*     */     //   #415	-> 91
/*     */     //   #418	-> 104
/*     */     //   #419	-> 119
/*     */     //   #423	-> 119
/*     */     //   #424	-> 124
/*     */     //   #426	-> 130
/*     */     //   #428	-> 136
/*     */     //   #431	-> 141
/*     */     //   #433	-> 149
/*     */     //   #436	-> 155
/*     */     //   #437	-> 165
/*     */     //   #422	-> 168
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> void serializeMapField(CodedOutputByteBufferNano paramCodedOutputByteBufferNano, Map<K, V> paramMap, int paramInt1, int paramInt2, int paramInt3) throws IOException {
/* 444 */     for (Map.Entry<K, V> entry : paramMap.entrySet()) {
/* 445 */       paramMap = (Map<K, V>)entry.getKey();
/* 446 */       entry = (Map.Entry<K, V>)entry.getValue();
/* 447 */       if (paramMap != null && entry != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 452 */         int i = CodedOutputByteBufferNano.computeFieldSize(1, paramInt2, paramMap);
/* 453 */         int j = CodedOutputByteBufferNano.computeFieldSize(2, paramInt3, entry);
/* 454 */         paramCodedOutputByteBufferNano.writeTag(paramInt1, 2);
/* 455 */         paramCodedOutputByteBufferNano.writeRawVarint32(i + j);
/* 456 */         paramCodedOutputByteBufferNano.writeField(1, paramInt2, paramMap);
/* 457 */         paramCodedOutputByteBufferNano.writeField(2, paramInt3, entry);
/*     */         continue;
/*     */       } 
/*     */       throw new IllegalStateException("keys and values in maps cannot be null");
/*     */     } 
/*     */   } public static <K, V> int computeMapFieldSize(Map<K, V> paramMap, int paramInt1, int paramInt2, int paramInt3) {
/* 463 */     int i = 0;
/* 464 */     int j = CodedOutputByteBufferNano.computeTagSize(paramInt1);
/* 465 */     for (Iterator<Map.Entry> iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) { Map.Entry entry = iterator.next();
/* 466 */       Object object = entry.getKey();
/* 467 */       entry = (Map.Entry)entry.getValue();
/* 468 */       if (object != null && entry != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 473 */         i = CodedOutputByteBufferNano.computeFieldSize(1, paramInt2, object);
/* 474 */         i += CodedOutputByteBufferNano.computeFieldSize(2, paramInt3, entry);
/*     */         
/* 476 */         paramInt1 += j + i + CodedOutputByteBufferNano.computeRawVarint32Size(i); continue;
/*     */       }  throw new IllegalStateException("keys and values in maps cannot be null"); }
/* 478 */      return paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2) {
/* 487 */     boolean bool2 = true, bool1 = true; if (paramMap1 == paramMap2) {
/* 488 */       return true;
/*     */     }
/* 490 */     if (paramMap1 == null) {
/* 491 */       if (paramMap2.size() != 0) bool1 = false;  return bool1;
/*     */     } 
/* 493 */     if (paramMap2 == null) {
/* 494 */       if (paramMap1.size() == 0) { bool1 = bool2; } else { bool1 = false; }  return bool1;
/*     */     } 
/* 496 */     if (paramMap1.size() != paramMap2.size()) {
/* 497 */       return false;
/*     */     }
/* 499 */     for (Map.Entry<K, V> entry : paramMap1.entrySet()) {
/* 500 */       if (!paramMap2.containsKey(entry.getKey())) {
/* 501 */         return false;
/*     */       }
/* 503 */       if (!equalsMapValue(entry.getValue(), paramMap2.get(entry.getKey()))) {
/* 504 */         return false;
/*     */       }
/*     */     } 
/* 507 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean equalsMapValue(Object paramObject1, Object paramObject2) {
/* 511 */     if (paramObject1 != null && paramObject2 != null) {
/*     */ 
/*     */ 
/*     */       
/* 515 */       if (paramObject1 instanceof byte[] && paramObject2 instanceof byte[]) {
/* 516 */         return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
/*     */       }
/* 518 */       return paramObject1.equals(paramObject2);
/*     */     } 
/*     */     throw new IllegalStateException("keys and values in maps cannot be null");
/*     */   } public static <K, V> int hashCode(Map<K, V> paramMap) {
/* 522 */     if (paramMap == null) {
/* 523 */       return 0;
/*     */     }
/* 525 */     int i = 0;
/* 526 */     for (Map.Entry<K, V> entry : paramMap.entrySet()) {
/* 527 */       int j = hashCodeForMap(entry.getKey());
/* 528 */       i += j ^ hashCodeForMap(entry.getValue());
/*     */     } 
/* 530 */     return i;
/*     */   }
/*     */   
/*     */   private static int hashCodeForMap(Object paramObject) {
/* 534 */     if (paramObject instanceof byte[]) {
/* 535 */       return Arrays.hashCode((byte[])paramObject);
/*     */     }
/* 537 */     return paramObject.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cloneUnknownFieldData(ExtendableMessageNano paramExtendableMessageNano1, ExtendableMessageNano paramExtendableMessageNano2) {
/* 543 */     if (paramExtendableMessageNano1.unknownFieldData != null)
/* 544 */       paramExtendableMessageNano2.unknownFieldData = paramExtendableMessageNano1.unknownFieldData.clone(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\InternalNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */