/*      */ package com.google.protobuf.nano;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.nio.BufferOverflowException;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.nio.ReadOnlyBufferException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class CodedOutputByteBufferNano
/*      */ {
/*      */   public static final int LITTLE_ENDIAN_32_SIZE = 4;
/*      */   public static final int LITTLE_ENDIAN_64_SIZE = 8;
/*      */   private static final int MAX_UTF8_EXPANSION = 3;
/*      */   private final ByteBuffer buffer;
/*      */   
/*      */   private CodedOutputByteBufferNano(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*   60 */     this(ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2));
/*      */   }
/*      */   
/*      */   private CodedOutputByteBufferNano(ByteBuffer paramByteBuffer) {
/*   64 */     this.buffer = paramByteBuffer;
/*   65 */     this.buffer.order(ByteOrder.LITTLE_ENDIAN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CodedOutputByteBufferNano newInstance(byte[] paramArrayOfbyte) {
/*   75 */     return newInstance(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CodedOutputByteBufferNano newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*   87 */     return new CodedOutputByteBufferNano(paramArrayOfbyte, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeDouble(int paramInt, double paramDouble) throws IOException {
/*   95 */     writeTag(paramInt, 1);
/*   96 */     writeDoubleNoTag(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeFloat(int paramInt, float paramFloat) throws IOException {
/*  102 */     writeTag(paramInt, 5);
/*  103 */     writeFloatNoTag(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeUInt64(int paramInt, long paramLong) throws IOException {
/*  109 */     writeTag(paramInt, 0);
/*  110 */     writeUInt64NoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeInt64(int paramInt, long paramLong) throws IOException {
/*  116 */     writeTag(paramInt, 0);
/*  117 */     writeInt64NoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeInt32(int paramInt1, int paramInt2) throws IOException {
/*  123 */     writeTag(paramInt1, 0);
/*  124 */     writeInt32NoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeFixed64(int paramInt, long paramLong) throws IOException {
/*  130 */     writeTag(paramInt, 1);
/*  131 */     writeFixed64NoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeFixed32(int paramInt1, int paramInt2) throws IOException {
/*  137 */     writeTag(paramInt1, 5);
/*  138 */     writeFixed32NoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeBool(int paramInt, boolean paramBoolean) throws IOException {
/*  144 */     writeTag(paramInt, 0);
/*  145 */     writeBoolNoTag(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeString(int paramInt, String paramString) throws IOException {
/*  151 */     writeTag(paramInt, 2);
/*  152 */     writeStringNoTag(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeGroup(int paramInt, MessageNano paramMessageNano) throws IOException {
/*  158 */     writeTag(paramInt, 3);
/*  159 */     writeGroupNoTag(paramMessageNano);
/*  160 */     writeTag(paramInt, 4);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeMessage(int paramInt, MessageNano paramMessageNano) throws IOException {
/*  166 */     writeTag(paramInt, 2);
/*  167 */     writeMessageNoTag(paramMessageNano);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeBytes(int paramInt, byte[] paramArrayOfbyte) throws IOException {
/*  173 */     writeTag(paramInt, 2);
/*  174 */     writeBytesNoTag(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeBytes(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) throws IOException {
/*  181 */     writeTag(paramInt1, 2);
/*  182 */     writeBytesNoTag(paramArrayOfbyte, paramInt2, paramInt3);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeUInt32(int paramInt1, int paramInt2) throws IOException {
/*  188 */     writeTag(paramInt1, 0);
/*  189 */     writeUInt32NoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEnum(int paramInt1, int paramInt2) throws IOException {
/*  198 */     writeTag(paramInt1, 0);
/*  199 */     writeEnumNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeSFixed32(int paramInt1, int paramInt2) throws IOException {
/*  205 */     writeTag(paramInt1, 5);
/*  206 */     writeSFixed32NoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeSFixed64(int paramInt, long paramLong) throws IOException {
/*  212 */     writeTag(paramInt, 1);
/*  213 */     writeSFixed64NoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeSInt32(int paramInt1, int paramInt2) throws IOException {
/*  219 */     writeTag(paramInt1, 0);
/*  220 */     writeSInt32NoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeSInt64(int paramInt, long paramLong) throws IOException {
/*  226 */     writeTag(paramInt, 0);
/*  227 */     writeSInt64NoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeDoubleNoTag(double paramDouble) throws IOException {
/*  260 */     writeRawLittleEndian64(Double.doubleToLongBits(paramDouble));
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeFloatNoTag(float paramFloat) throws IOException {
/*  265 */     writeRawLittleEndian32(Float.floatToIntBits(paramFloat));
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeUInt64NoTag(long paramLong) throws IOException {
/*  270 */     writeRawVarint64(paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeInt64NoTag(long paramLong) throws IOException {
/*  275 */     writeRawVarint64(paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeInt32NoTag(int paramInt) throws IOException {
/*  280 */     if (paramInt >= 0) {
/*  281 */       writeRawVarint32(paramInt);
/*      */     } else {
/*      */       
/*  284 */       writeRawVarint64(paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeFixed64NoTag(long paramLong) throws IOException {
/*  290 */     writeRawLittleEndian64(paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeFixed32NoTag(int paramInt) throws IOException {
/*  295 */     writeRawLittleEndian32(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeBoolNoTag(boolean paramBoolean) throws IOException {
/*  300 */     writeRawByte(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeStringNoTag(String paramString) throws IOException {
/*      */     try {
/*      */       OutOfSpaceException outOfSpaceException;
/*  309 */       int i = computeRawVarint32Size(paramString.length());
/*  310 */       int j = computeRawVarint32Size(paramString.length() * 3);
/*  311 */       if (i == j)
/*  312 */       { int k = this.buffer.position();
/*      */ 
/*      */ 
/*      */         
/*  316 */         if (this.buffer.remaining() >= i)
/*      */         
/*      */         { 
/*  319 */           this.buffer.position(k + i);
/*  320 */           encode(paramString, this.buffer);
/*  321 */           j = this.buffer.position();
/*  322 */           this.buffer.position(k);
/*  323 */           writeRawVarint32(j - k - i);
/*  324 */           this.buffer.position(j); } else { outOfSpaceException = new OutOfSpaceException(); this(k + i, this.buffer.limit()); throw outOfSpaceException; }
/*      */          }
/*  326 */       else { writeRawVarint32(encodedLength((CharSequence)outOfSpaceException));
/*  327 */         encode((CharSequence)outOfSpaceException, this.buffer); }
/*      */        return;
/*  329 */     } catch (BufferOverflowException bufferOverflowException) {
/*  330 */       int i = this.buffer.position(); ByteBuffer byteBuffer = this.buffer;
/*  331 */       OutOfSpaceException outOfSpaceException = new OutOfSpaceException(i, byteBuffer.limit());
/*  332 */       outOfSpaceException.initCause(bufferOverflowException);
/*  333 */       throw outOfSpaceException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int encodedLength(CharSequence paramCharSequence) {
/*  348 */     int i, k, n = paramCharSequence.length();
/*  349 */     int m = n;
/*  350 */     int j = 0;
/*      */     
/*      */     while (true) {
/*  353 */       i = m; k = j; if (j < n) { i = m; k = j; if (paramCharSequence.charAt(j) < '') {
/*  354 */           j++; continue;
/*      */         }  }
/*      */        break;
/*      */     }  while (true) {
/*  358 */       j = i; if (k < n) {
/*  359 */         j = paramCharSequence.charAt(k);
/*  360 */         if (j < 2048) {
/*  361 */           i += 127 - j >>> 31; k++;
/*      */         } 
/*  363 */         j = i + encodedLengthGeneral(paramCharSequence, k);
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/*  368 */     if (j >= n)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  373 */       return j; } 
/*      */     paramCharSequence = new StringBuilder();
/*      */     paramCharSequence.append("UTF-8 length does not fit in int: ");
/*      */     paramCharSequence.append(j + 4294967296L);
/*  377 */     throw new IllegalArgumentException(paramCharSequence.toString()); } private static int encodedLengthGeneral(CharSequence paramCharSequence, int paramInt) { int j = paramCharSequence.length();
/*      */     int i;
/*  379 */     for (i = 0; paramInt < j; paramInt = k + 1) {
/*  380 */       int k; char c = paramCharSequence.charAt(paramInt);
/*  381 */       if (c < 'ࠀ') {
/*  382 */         i += 127 - c >>> 31; k = paramInt;
/*      */       } else {
/*  384 */         int m = i + 2;
/*      */         
/*  386 */         k = paramInt; i = m; if ('?' <= c) { k = paramInt; i = m; if (c <= '?') {
/*      */             
/*  388 */             i = Character.codePointAt(paramCharSequence, paramInt);
/*  389 */             if (i >= 65536)
/*      */             
/*      */             { 
/*  392 */               k = paramInt + 1; i = m; } else { paramCharSequence = new StringBuilder(); paramCharSequence.append("Unpaired surrogate at index "); paramCharSequence.append(paramInt); throw new IllegalArgumentException(paramCharSequence.toString()); } 
/*      */           }  }
/*      */       
/*      */       } 
/*  396 */     }  return i; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void encode(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) {
/*  416 */     if (!paramByteBuffer.isReadOnly()) {
/*      */       BufferOverflowException bufferOverflowException;
/*  418 */       if (paramByteBuffer.hasArray()) {
/*      */         
/*      */         try {
/*  421 */           byte[] arrayOfByte = paramByteBuffer.array();
/*  422 */           int j = paramByteBuffer.arrayOffset(), i = paramByteBuffer.position();
/*  423 */           int k = paramByteBuffer.remaining(); i = encode(paramCharSequence, arrayOfByte, j + i, k);
/*  424 */           paramByteBuffer.position(i - paramByteBuffer.arrayOffset());
/*  425 */         } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*  426 */           bufferOverflowException = new BufferOverflowException();
/*  427 */           bufferOverflowException.initCause(arrayIndexOutOfBoundsException);
/*  428 */           throw bufferOverflowException;
/*      */         } 
/*      */       } else {
/*  431 */         encodeDirect((CharSequence)arrayIndexOutOfBoundsException, (ByteBuffer)bufferOverflowException);
/*      */       } 
/*      */       return;
/*      */     } 
/*      */     throw new ReadOnlyBufferException();
/*  436 */   } private static void encodeDirect(CharSequence paramCharSequence, ByteBuffer paramByteBuffer) { int i = paramCharSequence.length();
/*  437 */     for (byte b = 0; b < i; b++) {
/*  438 */       char c = paramCharSequence.charAt(b);
/*  439 */       if (c < '') {
/*  440 */         paramByteBuffer.put((byte)c);
/*  441 */       } else if (c < 'ࠀ') {
/*  442 */         paramByteBuffer.put((byte)(0x3C0 | c >>> 6));
/*  443 */         paramByteBuffer.put((byte)(0x80 | 0x3F & c));
/*  444 */       } else if (c < '?' || '?' < c) {
/*      */         
/*  446 */         paramByteBuffer.put((byte)(0x1E0 | c >>> 12));
/*  447 */         paramByteBuffer.put((byte)(c >>> 6 & 0x3F | 0x80));
/*  448 */         paramByteBuffer.put((byte)(0x80 | 0x3F & c));
/*      */       } else {
/*      */         
/*  451 */         int j = b; if (b + 1 != paramCharSequence.length()) { b++;
/*  452 */           char c1 = paramCharSequence.charAt(b); j = b; if (Character.isSurrogatePair(c, c1))
/*      */           
/*      */           { 
/*  455 */             j = Character.toCodePoint(c, c1);
/*  456 */             paramByteBuffer.put((byte)(0xF0 | j >>> 18));
/*  457 */             paramByteBuffer.put((byte)(j >>> 12 & 0x3F | 0x80));
/*  458 */             paramByteBuffer.put((byte)(j >>> 6 & 0x3F | 0x80));
/*  459 */             paramByteBuffer.put((byte)(0x80 | 0x3F & j)); }
/*      */           else { paramCharSequence = new StringBuilder(); paramCharSequence.append("Unpaired surrogate at index "); paramCharSequence.append(j - 1); throw new IllegalArgumentException(paramCharSequence.toString()); }
/*      */            }
/*      */         else { paramCharSequence = new StringBuilder(); paramCharSequence.append("Unpaired surrogate at index "); paramCharSequence.append(j - 1); throw new IllegalArgumentException(paramCharSequence.toString()); }
/*      */       
/*      */       } 
/*  465 */     }  } private static int encode(CharSequence paramCharSequence, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) { int j = paramCharSequence.length();
/*      */     
/*  467 */     int i = 0;
/*  468 */     int k = paramInt1 + paramInt2; paramInt2 = i;
/*      */ 
/*      */     
/*  471 */     while (paramInt2 < j && paramInt2 + paramInt1 < k) { i = paramCharSequence.charAt(paramInt2); if (i < 128) {
/*  472 */         paramArrayOfbyte[paramInt1 + paramInt2] = (byte)i; paramInt2++;
/*      */       }  }
/*  474 */      if (paramInt2 == j) {
/*  475 */       return paramInt1 + j;
/*      */     }
/*  477 */     i = paramInt1 + paramInt2; paramInt1 = paramInt2; paramInt2 = i;
/*  478 */     for (; paramInt1 < j; paramInt1++) {
/*  479 */       char c = paramCharSequence.charAt(paramInt1);
/*  480 */       if (c < '' && paramInt2 < k)
/*  481 */       { i = paramInt2 + 1; paramArrayOfbyte[paramInt2] = (byte)c; paramInt2 = i; }
/*  482 */       else if (c < 'ࠀ' && paramInt2 <= k - 2)
/*  483 */       { i = paramInt2 + 1; paramArrayOfbyte[paramInt2] = (byte)(0x3C0 | c >>> 6);
/*  484 */         paramInt2 = i + 1; paramArrayOfbyte[i] = (byte)(0x3F & c | 0x80); }
/*  485 */       else if ((c < '?' || '?' < c) && paramInt2 <= k - 3)
/*      */       
/*  487 */       { i = paramInt2 + 1; paramArrayOfbyte[paramInt2] = (byte)(0x1E0 | c >>> 12);
/*  488 */         int m = i + 1; paramArrayOfbyte[i] = (byte)(c >>> 6 & 0x3F | 0x80);
/*  489 */         paramInt2 = m + 1; paramArrayOfbyte[m] = (byte)(0x3F & c | 0x80); }
/*  490 */       else if (paramInt2 <= k - 4)
/*      */       
/*      */       { 
/*  493 */         i = paramInt1; if (paramInt1 + 1 != paramCharSequence.length()) { paramInt1++;
/*  494 */           char c1 = paramCharSequence.charAt(paramInt1); i = paramInt1; if (Character.isSurrogatePair(c, c1))
/*      */           
/*      */           { 
/*  497 */             i = Character.toCodePoint(c, c1);
/*  498 */             int m = paramInt2 + 1; paramArrayOfbyte[paramInt2] = (byte)(0xF0 | i >>> 18);
/*  499 */             paramInt2 = m + 1; paramArrayOfbyte[m] = (byte)(i >>> 12 & 0x3F | 0x80);
/*  500 */             m = paramInt2 + 1; paramArrayOfbyte[paramInt2] = (byte)(i >>> 6 & 0x3F | 0x80);
/*  501 */             paramInt2 = m + 1; paramArrayOfbyte[m] = (byte)(0x3F & i | 0x80); } else { paramCharSequence = new StringBuilder(); paramCharSequence.append("Unpaired surrogate at index "); paramCharSequence.append(i - 1); throw new IllegalArgumentException(paramCharSequence.toString()); }  } else { paramCharSequence = new StringBuilder(); paramCharSequence.append("Unpaired surrogate at index "); paramCharSequence.append(i - 1); throw new IllegalArgumentException(paramCharSequence.toString()); }
/*      */          }
/*  503 */       else { paramCharSequence = new StringBuilder(); paramCharSequence.append("Failed writing "); paramCharSequence.append(c); paramCharSequence.append(" at index "); paramCharSequence.append(paramInt2); throw new ArrayIndexOutOfBoundsException(paramCharSequence.toString()); }
/*      */     
/*      */     } 
/*  506 */     return paramInt2; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeGroupNoTag(MessageNano paramMessageNano) throws IOException {
/*  514 */     paramMessageNano.writeTo(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeMessageNoTag(MessageNano paramMessageNano) throws IOException {
/*  519 */     writeRawVarint32(paramMessageNano.getCachedSize());
/*  520 */     paramMessageNano.writeTo(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeBytesNoTag(byte[] paramArrayOfbyte) throws IOException {
/*  525 */     writeRawVarint32(paramArrayOfbyte.length);
/*  526 */     writeRawBytes(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeBytesNoTag(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  532 */     writeRawVarint32(paramInt2);
/*  533 */     writeRawBytes(paramArrayOfbyte, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeUInt32NoTag(int paramInt) throws IOException {
/*  538 */     writeRawVarint32(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEnumNoTag(int paramInt) throws IOException {
/*  546 */     writeRawVarint32(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeSFixed32NoTag(int paramInt) throws IOException {
/*  551 */     writeRawLittleEndian32(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeSFixed64NoTag(long paramLong) throws IOException {
/*  556 */     writeRawLittleEndian64(paramLong);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeSInt32NoTag(int paramInt) throws IOException {
/*  561 */     writeRawVarint32(encodeZigZag32(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeSInt64NoTag(long paramLong) throws IOException {
/*  566 */     writeRawVarint64(encodeZigZag64(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeDoubleSize(int paramInt, double paramDouble) {
/*  577 */     return computeTagSize(paramInt) + computeDoubleSizeNoTag(paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeFloatSize(int paramInt, float paramFloat) {
/*  585 */     return computeTagSize(paramInt) + computeFloatSizeNoTag(paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeUInt64Size(int paramInt, long paramLong) {
/*  593 */     return computeTagSize(paramInt) + computeUInt64SizeNoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeInt64Size(int paramInt, long paramLong) {
/*  601 */     return computeTagSize(paramInt) + computeInt64SizeNoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeInt32Size(int paramInt1, int paramInt2) {
/*  609 */     return computeTagSize(paramInt1) + computeInt32SizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeFixed64Size(int paramInt, long paramLong) {
/*  618 */     return computeTagSize(paramInt) + computeFixed64SizeNoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeFixed32Size(int paramInt1, int paramInt2) {
/*  627 */     return computeTagSize(paramInt1) + computeFixed32SizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeBoolSize(int paramInt, boolean paramBoolean) {
/*  636 */     return computeTagSize(paramInt) + computeBoolSizeNoTag(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeStringSize(int paramInt, String paramString) {
/*  645 */     return computeTagSize(paramInt) + computeStringSizeNoTag(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeGroupSize(int paramInt, MessageNano paramMessageNano) {
/*  654 */     return computeTagSize(paramInt) * 2 + computeGroupSizeNoTag(paramMessageNano);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeMessageSize(int paramInt, MessageNano paramMessageNano) {
/*  663 */     return computeTagSize(paramInt) + computeMessageSizeNoTag(paramMessageNano);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeBytesSize(int paramInt, byte[] paramArrayOfbyte) {
/*  672 */     return computeTagSize(paramInt) + computeBytesSizeNoTag(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeBytesSize(int paramInt1, int paramInt2) {
/*  681 */     return computeTagSize(paramInt1) + computeBytesSizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeUInt32Size(int paramInt1, int paramInt2) {
/*  689 */     return computeTagSize(paramInt1) + computeUInt32SizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeEnumSize(int paramInt1, int paramInt2) {
/*  698 */     return computeTagSize(paramInt1) + computeEnumSizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSFixed32Size(int paramInt1, int paramInt2) {
/*  707 */     return computeTagSize(paramInt1) + computeSFixed32SizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSFixed64Size(int paramInt, long paramLong) {
/*  716 */     return computeTagSize(paramInt) + computeSFixed64SizeNoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSInt32Size(int paramInt1, int paramInt2) {
/*  724 */     return computeTagSize(paramInt1) + computeSInt32SizeNoTag(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSInt64Size(int paramInt, long paramLong) {
/*  732 */     return computeTagSize(paramInt) + computeSInt64SizeNoTag(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeDoubleSizeNoTag(double paramDouble) {
/*  766 */     return 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeFloatSizeNoTag(float paramFloat) {
/*  774 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeUInt64SizeNoTag(long paramLong) {
/*  782 */     return computeRawVarint64Size(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeInt64SizeNoTag(long paramLong) {
/*  790 */     return computeRawVarint64Size(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeInt32SizeNoTag(int paramInt) {
/*  798 */     if (paramInt >= 0) {
/*  799 */       return computeRawVarint32Size(paramInt);
/*      */     }
/*      */     
/*  802 */     return 10;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeFixed64SizeNoTag(long paramLong) {
/*  811 */     return 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeFixed32SizeNoTag(int paramInt) {
/*  819 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeBoolSizeNoTag(boolean paramBoolean) {
/*  827 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeStringSizeNoTag(String paramString) {
/*  835 */     int i = encodedLength(paramString);
/*  836 */     return computeRawVarint32Size(i) + i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeGroupSizeNoTag(MessageNano paramMessageNano) {
/*  844 */     return paramMessageNano.getSerializedSize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeMessageSizeNoTag(MessageNano paramMessageNano) {
/*  852 */     int i = paramMessageNano.getSerializedSize();
/*  853 */     return computeRawVarint32Size(i) + i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeBytesSizeNoTag(byte[] paramArrayOfbyte) {
/*  861 */     return computeRawVarint32Size(paramArrayOfbyte.length) + paramArrayOfbyte.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeBytesSizeNoTag(int paramInt) {
/*  869 */     return computeRawVarint32Size(paramInt) + paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeUInt32SizeNoTag(int paramInt) {
/*  877 */     return computeRawVarint32Size(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeEnumSizeNoTag(int paramInt) {
/*  885 */     return computeRawVarint32Size(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSFixed32SizeNoTag(int paramInt) {
/*  893 */     return 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSFixed64SizeNoTag(long paramLong) {
/*  901 */     return 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSInt32SizeNoTag(int paramInt) {
/*  909 */     return computeRawVarint32Size(encodeZigZag32(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeSInt64SizeNoTag(long paramLong) {
/*  917 */     return computeRawVarint64Size(encodeZigZag64(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int spaceLeft() {
/*  927 */     return this.buffer.remaining();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkNoSpaceLeft() {
/*  938 */     if (spaceLeft() == 0)
/*  939 */       return;  throw new IllegalStateException("Did not write as much data as expected.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int position() {
/*  948 */     return this.buffer.position();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  958 */     this.buffer.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class OutOfSpaceException
/*      */     extends IOException
/*      */   {
/*      */     private static final long serialVersionUID = -6947486886997889499L;
/*      */ 
/*      */     
/*      */     OutOfSpaceException(int param1Int1, int param1Int2) {
/*  970 */       super(stringBuilder.toString());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeRawByte(byte paramByte) throws IOException {
/*  977 */     if (this.buffer.hasRemaining()) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  982 */       this.buffer.put(paramByte);
/*      */       return;
/*      */     } 
/*      */     throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
/*      */   } public void writeRawByte(int paramInt) throws IOException {
/*  987 */     writeRawByte((byte)paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeRawBytes(byte[] paramArrayOfbyte) throws IOException {
/*  992 */     writeRawBytes(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeRawBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  998 */     if (this.buffer.remaining() >= paramInt2) {
/*  999 */       this.buffer.put(paramArrayOfbyte, paramInt1, paramInt2);
/*      */       return;
/*      */     } 
/* 1002 */     throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeTag(int paramInt1, int paramInt2) throws IOException {
/* 1009 */     writeRawVarint32(WireFormatNano.makeTag(paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */   
/*      */   public static int computeTagSize(int paramInt) {
/* 1014 */     return computeRawVarint32Size(WireFormatNano.makeTag(paramInt, 0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeRawVarint32(int paramInt) throws IOException {
/*      */     while (true) {
/* 1023 */       if ((paramInt & 0xFFFFFF80) == 0) {
/* 1024 */         writeRawByte(paramInt);
/*      */         return;
/*      */       } 
/* 1027 */       writeRawByte(paramInt & 0x7F | 0x80);
/* 1028 */       paramInt >>>= 7;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeRawVarint32Size(int paramInt) {
/* 1039 */     if ((paramInt & 0xFFFFFF80) == 0) return 1; 
/* 1040 */     if ((paramInt & 0xFFFFC000) == 0) return 2; 
/* 1041 */     if ((0xFFE00000 & paramInt) == 0) return 3; 
/* 1042 */     if ((0xF0000000 & paramInt) == 0) return 4; 
/* 1043 */     return 5;
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeRawVarint64(long paramLong) throws IOException {
/*      */     while (true) {
/* 1049 */       if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) {
/* 1050 */         writeRawByte((int)paramLong);
/*      */         return;
/*      */       } 
/* 1053 */       writeRawByte((int)paramLong & 0x7F | 0x80);
/* 1054 */       paramLong >>>= 7L;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static int computeRawVarint64Size(long paramLong) {
/* 1061 */     if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L) return 1; 
/* 1062 */     if ((0xFFFFFFFFFFFFC000L & paramLong) == 0L) return 2; 
/* 1063 */     if ((0xFFFFFFFFFFE00000L & paramLong) == 0L) return 3; 
/* 1064 */     if ((0xFFFFFFFFF0000000L & paramLong) == 0L) return 4; 
/* 1065 */     if ((0xFFFFFFF800000000L & paramLong) == 0L) return 5; 
/* 1066 */     if ((0xFFFFFC0000000000L & paramLong) == 0L) return 6; 
/* 1067 */     if ((0xFFFE000000000000L & paramLong) == 0L) return 7; 
/* 1068 */     if ((0xFF00000000000000L & paramLong) == 0L) return 8; 
/* 1069 */     if ((Long.MIN_VALUE & paramLong) == 0L) return 9; 
/* 1070 */     return 10;
/*      */   }
/*      */ 
/*      */   
/*      */   public void writeRawLittleEndian32(int paramInt) throws IOException {
/* 1075 */     if (this.buffer.remaining() >= 4) {
/*      */ 
/*      */       
/* 1078 */       this.buffer.putInt(paramInt);
/*      */       return;
/*      */     } 
/*      */     throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
/*      */   }
/*      */   
/*      */   public void writeRawLittleEndian64(long paramLong) throws IOException {
/* 1085 */     if (this.buffer.remaining() >= 8) {
/*      */ 
/*      */       
/* 1088 */       this.buffer.putLong(paramLong);
/*      */       return;
/*      */     } 
/*      */     throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int encodeZigZag32(int paramInt) {
/* 1105 */     return paramInt << 1 ^ paramInt >> 31;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long encodeZigZag64(long paramLong) {
/* 1120 */     return paramLong << 1L ^ paramLong >> 63L;
/*      */   }
/*      */   
/*      */   static int computeFieldSize(int paramInt1, int paramInt2, Object paramObject) {
/* 1124 */     switch (paramInt2)
/*      */     
/*      */     { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1162 */         paramObject = new StringBuilder(); paramObject.append("Unknown type: "); paramObject.append(paramInt2); throw new IllegalArgumentException(paramObject.toString());case 18: return computeSInt64Size(paramInt1, ((Long)paramObject).longValue());case 17: return computeSInt32Size(paramInt1, ((Integer)paramObject).intValue());case 16: return computeSFixed64Size(paramInt1, ((Long)paramObject).longValue());case 15: return computeSFixed32Size(paramInt1, ((Integer)paramObject).intValue());case 14: return computeEnumSize(paramInt1, ((Integer)paramObject).intValue());case 13: return computeUInt32Size(paramInt1, ((Integer)paramObject).intValue());case 12: return computeBytesSize(paramInt1, (byte[])paramObject);case 11: return computeMessageSize(paramInt1, (MessageNano)paramObject);case 10: return computeGroupSize(paramInt1, (MessageNano)paramObject);case 9: return computeStringSize(paramInt1, (String)paramObject);case 8: return computeBoolSize(paramInt1, ((Boolean)paramObject).booleanValue());case 7: return computeFixed32Size(paramInt1, ((Integer)paramObject).intValue());
/*      */       case 6: return computeFixed64Size(paramInt1, ((Long)paramObject).longValue());
/*      */       case 5: return computeInt32Size(paramInt1, ((Integer)paramObject).intValue());
/*      */       case 4: return computeUInt64Size(paramInt1, ((Long)paramObject).longValue());
/*      */       case 3: return computeInt64Size(paramInt1, ((Long)paramObject).longValue());
/*      */       case 2: return computeFloatSize(paramInt1, ((Float)paramObject).floatValue());
/* 1168 */       case 1: break; }  return computeDoubleSize(paramInt1, ((Double)paramObject).doubleValue()); } void writeField(int paramInt1, int paramInt2, Object paramObject) throws IOException { switch (paramInt2) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1242 */         paramObject = new StringBuilder(); paramObject.append("Unknown type: "); paramObject.append(paramInt2); throw new IOException(paramObject.toString());
/*      */       case 18:
/*      */         paramObject = paramObject;
/*      */         writeSInt64(paramInt1, paramObject.longValue());
/*      */         return;
/*      */       case 17:
/*      */         paramObject = paramObject;
/*      */         writeSInt32(paramInt1, paramObject.intValue());
/*      */         return;
/*      */       case 16:
/*      */         paramObject = paramObject;
/*      */         writeSFixed64(paramInt1, paramObject.longValue());
/*      */         return;
/*      */       case 15:
/*      */         paramObject = paramObject;
/*      */         writeSFixed32(paramInt1, paramObject.intValue());
/*      */         return;
/*      */       case 14:
/*      */         paramObject = paramObject;
/*      */         writeEnum(paramInt1, paramObject.intValue());
/*      */         return;
/*      */       case 13:
/*      */         paramObject = paramObject;
/*      */         writeUInt32(paramInt1, paramObject.intValue());
/*      */         return;
/*      */       case 12:
/*      */         paramObject = paramObject;
/*      */         writeBytes(paramInt1, (byte[])paramObject);
/*      */         return;
/*      */       case 11:
/*      */         paramObject = paramObject;
/*      */         writeMessage(paramInt1, (MessageNano)paramObject);
/*      */         return;
/*      */       case 10:
/*      */         paramObject = paramObject;
/*      */         writeGroup(paramInt1, (MessageNano)paramObject);
/*      */         return;
/*      */       case 9:
/*      */         paramObject = paramObject;
/*      */         writeString(paramInt1, (String)paramObject);
/*      */         return;
/*      */       case 8:
/*      */         paramObject = paramObject;
/*      */         writeBool(paramInt1, paramObject.booleanValue());
/*      */         return;
/*      */       case 7:
/*      */         paramObject = paramObject;
/*      */         writeFixed32(paramInt1, paramObject.intValue());
/*      */         return;
/*      */       case 6:
/*      */         paramObject = paramObject;
/*      */         writeFixed64(paramInt1, paramObject.longValue());
/*      */         return;
/*      */       case 5:
/*      */         paramObject = paramObject;
/*      */         writeInt32(paramInt1, paramObject.intValue());
/*      */         return;
/*      */       case 4:
/*      */         paramObject = paramObject;
/*      */         writeUInt64(paramInt1, paramObject.longValue());
/*      */         return;
/*      */       case 3:
/*      */         paramObject = paramObject;
/*      */         writeInt64(paramInt1, paramObject.longValue());
/*      */         return;
/*      */       case 2:
/*      */         paramObject = paramObject;
/*      */         writeFloat(paramInt1, paramObject.floatValue());
/*      */         return;
/*      */       case 1:
/*      */         break;
/*      */     } 
/*      */     paramObject = paramObject;
/*      */     writeDouble(paramInt1, paramObject.doubleValue()); }
/*      */ 
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\CodedOutputByteBufferNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */