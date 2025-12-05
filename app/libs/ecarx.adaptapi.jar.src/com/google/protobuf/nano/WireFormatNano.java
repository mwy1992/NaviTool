/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ public final class WireFormatNano
/*     */ {
/*     */   public static final boolean[] EMPTY_BOOLEAN_ARRAY;
/*     */   public static final byte[] EMPTY_BYTES;
/*     */   public static final byte[][] EMPTY_BYTES_ARRAY;
/*     */   public static final double[] EMPTY_DOUBLE_ARRAY;
/*     */   public static final float[] EMPTY_FLOAT_ARRAY;
/*     */   
/*     */   static int getTagWireType(int paramInt) {
/*  62 */     return paramInt & 0x7;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTagFieldNumber(int paramInt) {
/*  67 */     return paramInt >>> 3;
/*     */   }
/*     */ 
/*     */   
/*     */   static int makeTag(int paramInt1, int paramInt2) {
/*  72 */     return paramInt1 << 3 | paramInt2;
/*     */   }
/*     */   
/*  75 */   public static final int[] EMPTY_INT_ARRAY = new int[0];
/*  76 */   public static final long[] EMPTY_LONG_ARRAY = new long[0]; static {
/*  77 */     EMPTY_FLOAT_ARRAY = new float[0];
/*  78 */     EMPTY_DOUBLE_ARRAY = new double[0];
/*  79 */     EMPTY_BOOLEAN_ARRAY = new boolean[0];
/*  80 */     EMPTY_STRING_ARRAY = new String[0];
/*  81 */     EMPTY_BYTES_ARRAY = new byte[0][];
/*  82 */     EMPTY_BYTES = new byte[0];
/*     */   }
/*     */   public static final String[] EMPTY_STRING_ARRAY;
/*     */   static final int TAG_TYPE_BITS = 3;
/*     */   static final int TAG_TYPE_MASK = 7;
/*     */   static final int WIRETYPE_END_GROUP = 4;
/*     */   static final int WIRETYPE_FIXED32 = 5;
/*     */   static final int WIRETYPE_FIXED64 = 1;
/*     */   static final int WIRETYPE_LENGTH_DELIMITED = 2;
/*     */   static final int WIRETYPE_START_GROUP = 3;
/*     */   static final int WIRETYPE_VARINT = 0;
/*     */   
/*     */   public static boolean parseUnknownField(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt) throws IOException {
/*  95 */     return paramCodedInputByteBufferNano.skipField(paramInt);
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
/*     */   public static final int getRepeatedFieldArrayLength(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt) throws IOException {
/* 113 */     byte b = 1;
/* 114 */     int i = paramCodedInputByteBufferNano.getPosition();
/* 115 */     paramCodedInputByteBufferNano.skipField(paramInt);
/* 116 */     while (paramCodedInputByteBufferNano.readTag() == paramInt) {
/* 117 */       paramCodedInputByteBufferNano.skipField(paramInt);
/* 118 */       b++;
/*     */     } 
/* 120 */     paramCodedInputByteBufferNano.rewindToPosition(i);
/* 121 */     return b;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\WireFormatNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */