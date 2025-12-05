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
/*     */ public final class CodedInputByteBufferNano
/*     */ {
/*     */   private static final int DEFAULT_RECURSION_LIMIT = 64;
/*     */   private static final int DEFAULT_SIZE_LIMIT = 67108864;
/*     */   private final byte[] buffer;
/*     */   private int bufferPos;
/*     */   private int bufferSize;
/*     */   private int bufferSizeAfterLimit;
/*     */   private int bufferStart;
/*     */   
/*     */   public static CodedInputByteBufferNano newInstance(byte[] paramArrayOfbyte) {
/*  52 */     return newInstance(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CodedInputByteBufferNano newInstance(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  60 */     return new CodedInputByteBufferNano(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readTag() throws IOException {
/*  71 */     if (isAtEnd()) {
/*  72 */       this.lastTag = 0;
/*  73 */       return 0;
/*     */     } 
/*     */     
/*  76 */     this.lastTag = readRawVarint32();
/*  77 */     if (this.lastTag != 0)
/*     */     {
/*     */ 
/*     */       
/*  81 */       return this.lastTag;
/*     */     }
/*     */     throw InvalidProtocolBufferNanoException.invalidTag();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkLastTagWas(int paramInt) throws InvalidProtocolBufferNanoException {
/*  94 */     if (this.lastTag == paramInt)
/*  95 */       return;  throw InvalidProtocolBufferNanoException.invalidEndTag();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean skipField(int paramInt) throws IOException {
/* 106 */     switch (WireFormatNano.getTagWireType(paramInt))
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
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 128 */         throw InvalidProtocolBufferNanoException.invalidWireType();
/*     */       case 5: readRawLittleEndian32(); return true;
/*     */       case 4: return false;
/*     */       case 3:
/*     */         skipMessage(); paramInt = WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(paramInt), 4); checkLastTagWas(paramInt); return true;
/*     */       case 2:
/*     */         skipRawBytes(readRawVarint32()); return true;
/*     */       case 1:
/*     */         readRawLittleEndian64(); return true;
/*     */       case 0:
/* 138 */         break; }  readInt32(); return true; } public void skipMessage() throws IOException { int i; do { i = readTag(); }
/* 139 */     while (i != 0 && skipField(i)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double readDouble() throws IOException {
/* 149 */     return Double.longBitsToDouble(readRawLittleEndian64());
/*     */   }
/*     */ 
/*     */   
/*     */   public float readFloat() throws IOException {
/* 154 */     return Float.intBitsToFloat(readRawLittleEndian32());
/*     */   }
/*     */ 
/*     */   
/*     */   public long readUInt64() throws IOException {
/* 159 */     return readRawVarint64();
/*     */   }
/*     */ 
/*     */   
/*     */   public long readInt64() throws IOException {
/* 164 */     return readRawVarint64();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt32() throws IOException {
/* 169 */     return readRawVarint32();
/*     */   }
/*     */ 
/*     */   
/*     */   public long readFixed64() throws IOException {
/* 174 */     return readRawLittleEndian64();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readFixed32() throws IOException {
/* 179 */     return readRawLittleEndian32();
/*     */   }
/*     */   
/*     */   public boolean readBool() throws IOException {
/*     */     boolean bool;
/* 184 */     if (readRawVarint32() != 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public String readString() throws IOException {
/* 189 */     int i = readRawVarint32();
/* 190 */     if (i <= this.bufferSize - this.bufferPos && i > 0) {
/*     */ 
/*     */       
/* 193 */       String str = new String(this.buffer, this.bufferPos, i, InternalNano.UTF_8);
/* 194 */       this.bufferPos += i;
/* 195 */       return str;
/*     */     } 
/*     */     
/* 198 */     return new String(readRawBytes(i), InternalNano.UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readGroup(MessageNano paramMessageNano, int paramInt) throws IOException {
/* 205 */     if (this.recursionDepth < this.recursionLimit) {
/*     */ 
/*     */       
/* 208 */       this.recursionDepth++;
/* 209 */       paramMessageNano.mergeFrom(this);
/*     */       
/* 211 */       paramInt = WireFormatNano.makeTag(paramInt, 4); checkLastTagWas(paramInt);
/* 212 */       this.recursionDepth--;
/*     */       return;
/*     */     } 
/*     */     throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
/*     */   } public void readMessage(MessageNano paramMessageNano) throws IOException {
/* 217 */     int i = readRawVarint32();
/* 218 */     if (this.recursionDepth < this.recursionLimit) {
/*     */ 
/*     */       
/* 221 */       i = pushLimit(i);
/* 222 */       this.recursionDepth++;
/* 223 */       paramMessageNano.mergeFrom(this);
/* 224 */       checkLastTagWas(0);
/* 225 */       this.recursionDepth--;
/* 226 */       popLimit(i);
/*     */       return;
/*     */     } 
/*     */     throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
/*     */   } public byte[] readBytes() throws IOException {
/* 231 */     int i = readRawVarint32();
/* 232 */     if (i <= this.bufferSize - this.bufferPos && i > 0) {
/*     */ 
/*     */       
/* 235 */       byte[] arrayOfByte = new byte[i];
/* 236 */       System.arraycopy(this.buffer, this.bufferPos, arrayOfByte, 0, i);
/* 237 */       this.bufferPos += i;
/* 238 */       return arrayOfByte;
/* 239 */     }  if (i == 0) {
/* 240 */       return WireFormatNano.EMPTY_BYTES;
/*     */     }
/*     */     
/* 243 */     return readRawBytes(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readUInt32() throws IOException {
/* 249 */     return readRawVarint32();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readEnum() throws IOException {
/* 257 */     return readRawVarint32();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readSFixed32() throws IOException {
/* 262 */     return readRawLittleEndian32();
/*     */   }
/*     */ 
/*     */   
/*     */   public long readSFixed64() throws IOException {
/* 267 */     return readRawLittleEndian64();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readSInt32() throws IOException {
/* 272 */     return decodeZigZag32(readRawVarint32());
/*     */   }
/*     */ 
/*     */   
/*     */   public long readSInt64() throws IOException {
/* 277 */     return decodeZigZag64(readRawVarint64());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int readRawVarint32() throws IOException {
/* 287 */     int i = readRawByte();
/* 288 */     if (i >= 0) {
/* 289 */       return i;
/*     */     }
/* 291 */     int j = i & 0x7F;
/* 292 */     i = readRawByte(); if (i >= 0) {
/* 293 */       i = j | i << 7;
/*     */     } else {
/* 295 */       j |= (i & 0x7F) << 7;
/* 296 */       i = readRawByte(); if (i >= 0) {
/* 297 */         i = j | i << 14;
/*     */       } else {
/* 299 */         i = j | (i & 0x7F) << 14;
/* 300 */         j = readRawByte(); if (j >= 0) {
/* 301 */           i |= j << 21;
/*     */         } else {
/*     */           
/* 304 */           byte b = readRawByte(); j = i | (j & 0x7F) << 21 | b << 28;
/* 305 */           i = j; if (b < 0) {
/*     */             
/* 307 */             for (i = 0; i < 5; i++) {
/* 308 */               if (readRawByte() >= 0) {
/* 309 */                 return j;
/*     */               }
/*     */             } 
/* 312 */             throw InvalidProtocolBufferNanoException.malformedVarint();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 317 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long readRawVarint64() throws IOException {
/* 322 */     byte b = 0;
/* 323 */     long l = 0L;
/* 324 */     while (b < 64) {
/* 325 */       byte b1 = readRawByte();
/* 326 */       l |= (b1 & Byte.MAX_VALUE) << b;
/* 327 */       if ((b1 & 0x80) == 0) {
/* 328 */         return l;
/*     */       }
/* 330 */       b += 7;
/*     */     } 
/* 332 */     throw InvalidProtocolBufferNanoException.malformedVarint();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readRawLittleEndian32() throws IOException {
/* 337 */     byte b1 = readRawByte();
/* 338 */     byte b3 = readRawByte();
/* 339 */     byte b2 = readRawByte();
/* 340 */     byte b4 = readRawByte();
/* 341 */     return b1 & 0xFF | (b3 & 0xFF) << 8 | (b2 & 0xFF) << 16 | (b4 & 0xFF) << 24;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readRawLittleEndian64() throws IOException {
/* 349 */     byte b6 = readRawByte();
/* 350 */     byte b1 = readRawByte();
/* 351 */     byte b7 = readRawByte();
/* 352 */     byte b4 = readRawByte();
/* 353 */     byte b5 = readRawByte();
/* 354 */     byte b3 = readRawByte();
/* 355 */     byte b2 = readRawByte();
/* 356 */     byte b8 = readRawByte();
/* 357 */     return b6 & 0xFFL | (b1 & 0xFFL) << 8L | (b7 & 0xFFL) << 16L | (b4 & 0xFFL) << 24L | (b5 & 0xFFL) << 32L | (b3 & 0xFFL) << 40L | (b2 & 0xFFL) << 48L | (0xFFL & b8) << 56L;
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
/*     */   public static int decodeZigZag32(int paramInt) {
/* 378 */     return paramInt >>> 1 ^ -(paramInt & 0x1);
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
/*     */   public static long decodeZigZag64(long paramLong) {
/* 392 */     return paramLong >>> 1L ^ -(0x1L & paramLong);
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
/* 405 */   private int currentLimit = Integer.MAX_VALUE;
/*     */   
/*     */   private int lastTag;
/*     */   private int recursionDepth;
/* 409 */   private int recursionLimit = 64;
/*     */ 
/*     */   
/* 412 */   private int sizeLimit = 67108864;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CodedInputByteBufferNano(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 418 */     this.buffer = paramArrayOfbyte;
/* 419 */     this.bufferStart = paramInt1;
/* 420 */     this.bufferSize = paramInt1 + paramInt2;
/* 421 */     this.bufferPos = paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int setRecursionLimit(int paramInt) {
/* 432 */     if (paramInt >= 0) {
/*     */ 
/*     */ 
/*     */       
/* 436 */       int i = this.recursionLimit;
/* 437 */       this.recursionLimit = paramInt;
/* 438 */       return i;
/*     */     } 
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("Recursion limit cannot be negative: ");
/*     */     stringBuilder.append(paramInt);
/*     */     throw new IllegalArgumentException(stringBuilder.toString());
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
/*     */   public int setSizeLimit(int paramInt) {
/* 457 */     if (paramInt >= 0) {
/*     */ 
/*     */ 
/*     */       
/* 461 */       int i = this.sizeLimit;
/* 462 */       this.sizeLimit = paramInt;
/* 463 */       return i;
/*     */     } 
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("Size limit cannot be negative: ");
/*     */     stringBuilder.append(paramInt);
/*     */     throw new IllegalArgumentException(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetSizeCounter() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int pushLimit(int paramInt) throws InvalidProtocolBufferNanoException {
/* 479 */     if (paramInt >= 0) {
/*     */ 
/*     */       
/* 482 */       int i = paramInt + this.bufferPos;
/* 483 */       paramInt = this.currentLimit;
/* 484 */       if (i <= paramInt) {
/*     */ 
/*     */         
/* 487 */         this.currentLimit = i;
/*     */         
/* 489 */         recomputeBufferSizeAfterLimit();
/*     */         
/* 491 */         return paramInt;
/*     */       } 
/*     */       throw InvalidProtocolBufferNanoException.truncatedMessage();
/*     */     } 
/* 495 */     throw InvalidProtocolBufferNanoException.negativeSize(); } private void recomputeBufferSizeAfterLimit() { this.bufferSize += this.bufferSizeAfterLimit;
/* 496 */     int i = this.bufferSize;
/* 497 */     if (i > this.currentLimit) {
/*     */       
/* 499 */       this.bufferSizeAfterLimit = i - this.currentLimit;
/* 500 */       this.bufferSize -= this.bufferSizeAfterLimit;
/*     */     } else {
/* 502 */       this.bufferSizeAfterLimit = 0;
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void popLimit(int paramInt) {
/* 512 */     this.currentLimit = paramInt;
/* 513 */     recomputeBufferSizeAfterLimit();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBytesUntilLimit() {
/* 521 */     if (this.currentLimit == Integer.MAX_VALUE) {
/* 522 */       return -1;
/*     */     }
/*     */     
/* 525 */     int i = this.bufferPos;
/* 526 */     return this.currentLimit - i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAtEnd() {
/*     */     boolean bool;
/* 535 */     if (this.bufferPos == this.bufferSize) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPosition() {
/* 542 */     return this.bufferPos - this.bufferStart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAbsolutePosition() {
/* 549 */     return this.bufferPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBuffer() {
/* 556 */     return this.buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getData(int paramInt1, int paramInt2) {
/* 567 */     if (paramInt2 == 0) {
/* 568 */       return WireFormatNano.EMPTY_BYTES;
/*     */     }
/* 570 */     byte[] arrayOfByte = new byte[paramInt2];
/* 571 */     int i = this.bufferStart;
/* 572 */     System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
/* 573 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rewindToPosition(int paramInt) {
/* 580 */     if (paramInt <= this.bufferPos - this.bufferStart) {
/*     */ 
/*     */ 
/*     */       
/* 584 */       if (paramInt >= 0) {
/*     */ 
/*     */         
/* 587 */         this.bufferPos = this.bufferStart + paramInt; return;
/*     */       }  StringBuilder stringBuilder1 = new StringBuilder(); stringBuilder1.append("Bad position ");
/*     */       stringBuilder1.append(paramInt);
/*     */       throw new IllegalArgumentException(stringBuilder1.toString());
/*     */     } 
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     stringBuilder.append("Position ");
/*     */     stringBuilder.append(paramInt);
/*     */     stringBuilder.append(" is beyond current ");
/*     */     stringBuilder.append(this.bufferPos - this.bufferStart);
/* 597 */     throw new IllegalArgumentException(stringBuilder.toString()); } public byte readRawByte() throws IOException { if (this.bufferPos != this.bufferSize) {
/*     */ 
/*     */       
/* 600 */       byte[] arrayOfByte = this.buffer; int i = this.bufferPos; this.bufferPos = i + 1; return arrayOfByte[i];
/*     */     } 
/*     */     throw InvalidProtocolBufferNanoException.truncatedMessage(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] readRawBytes(int paramInt) throws IOException {
/* 610 */     if (paramInt >= 0) {
/*     */ 
/*     */ 
/*     */       
/* 614 */       if (this.bufferPos + paramInt <= this.currentLimit) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 621 */         if (paramInt <= this.bufferSize - this.bufferPos) {
/*     */           
/* 623 */           byte[] arrayOfByte = new byte[paramInt];
/* 624 */           System.arraycopy(this.buffer, this.bufferPos, arrayOfByte, 0, paramInt);
/* 625 */           this.bufferPos += paramInt;
/* 626 */           return arrayOfByte;
/*     */         } 
/* 628 */         throw InvalidProtocolBufferNanoException.truncatedMessage();
/*     */       } 
/*     */       skipRawBytes(this.currentLimit - this.bufferPos);
/*     */       throw InvalidProtocolBufferNanoException.truncatedMessage();
/*     */     } 
/*     */     throw InvalidProtocolBufferNanoException.negativeSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void skipRawBytes(int paramInt) throws IOException {
/* 639 */     if (paramInt >= 0) {
/*     */ 
/*     */ 
/*     */       
/* 643 */       if (this.bufferPos + paramInt <= this.currentLimit) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 650 */         if (paramInt <= this.bufferSize - this.bufferPos) {
/*     */           
/* 652 */           this.bufferPos += paramInt; return;
/*     */         } 
/* 654 */         throw InvalidProtocolBufferNanoException.truncatedMessage();
/*     */       } 
/*     */       skipRawBytes(this.currentLimit - this.bufferPos);
/*     */       throw InvalidProtocolBufferNanoException.truncatedMessage();
/*     */     } 
/*     */     throw InvalidProtocolBufferNanoException.negativeSize(); } Object readPrimitiveField(int paramInt) throws IOException { StringBuilder stringBuilder;
/* 660 */     switch (paramInt) {
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
/*     */       default:
/* 694 */         stringBuilder = new StringBuilder(); stringBuilder.append("Unknown type "); stringBuilder.append(paramInt); throw new IllegalArgumentException(stringBuilder.toString());
/*     */       case 18:
/*     */         return Long.valueOf(readSInt64());
/*     */       case 17:
/*     */         return Integer.valueOf(readSInt32());
/*     */       case 16:
/*     */         return Long.valueOf(readSFixed64());
/*     */       case 15:
/*     */         return Integer.valueOf(readSFixed32());
/*     */       case 14:
/*     */         return Integer.valueOf(readEnum());
/*     */       case 13:
/*     */         return Integer.valueOf(readUInt32());
/*     */       case 12:
/*     */         return readBytes();
/*     */       case 9:
/*     */         return readString();
/*     */       case 8:
/*     */         return Boolean.valueOf(readBool());
/*     */       case 7:
/*     */         return Integer.valueOf(readFixed32());
/*     */       case 6:
/*     */         return Long.valueOf(readFixed64());
/*     */       case 5:
/*     */         return Integer.valueOf(readInt32());
/*     */       case 4:
/*     */         return Long.valueOf(readUInt64());
/*     */       case 3:
/*     */         return Long.valueOf(readInt64());
/*     */       case 2:
/*     */         return Float.valueOf(readFloat());
/*     */       case 1:
/*     */         break;
/*     */     } 
/*     */     return Double.valueOf(readDouble()); }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\CodedInputByteBufferNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */