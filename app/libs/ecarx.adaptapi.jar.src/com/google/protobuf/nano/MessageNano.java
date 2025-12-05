/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MessageNano
/*     */ {
/*  42 */   protected volatile int cachedSize = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCachedSize() {
/*  52 */     if (this.cachedSize < 0)
/*     */     {
/*  54 */       getSerializedSize();
/*     */     }
/*  56 */     return this.cachedSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSerializedSize() {
/*  65 */     int i = computeSerializedSize();
/*  66 */     this.cachedSize = i;
/*  67 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int computeSerializedSize() {
/*  76 */     return 0;
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
/*     */   public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final byte[] toByteArray(MessageNano paramMessageNano) {
/* 100 */     byte[] arrayOfByte = new byte[paramMessageNano.getSerializedSize()];
/* 101 */     toByteArray(paramMessageNano, arrayOfByte, 0, arrayOfByte.length);
/* 102 */     return arrayOfByte;
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
/*     */   public static final void toByteArray(MessageNano paramMessageNano, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/* 116 */       CodedOutputByteBufferNano codedOutputByteBufferNano = CodedOutputByteBufferNano.newInstance(paramArrayOfbyte, paramInt1, paramInt2);
/* 117 */       paramMessageNano.writeTo(codedOutputByteBufferNano);
/* 118 */       codedOutputByteBufferNano.checkNoSpaceLeft(); return;
/* 119 */     } catch (IOException iOException) {
/* 120 */       throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final <T extends MessageNano> T mergeFrom(T paramT, byte[] paramArrayOfbyte) throws InvalidProtocolBufferNanoException {
/* 131 */     return mergeFrom(paramT, paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final <T extends MessageNano> T mergeFrom(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws InvalidProtocolBufferNanoException {
/*     */     try {
/* 142 */       CodedInputByteBufferNano codedInputByteBufferNano = CodedInputByteBufferNano.newInstance(paramArrayOfbyte, paramInt1, paramInt2);
/* 143 */       paramT.mergeFrom(codedInputByteBufferNano);
/* 144 */       codedInputByteBufferNano.checkLastTagWas(0);
/* 145 */       return paramT;
/* 146 */     } catch (InvalidProtocolBufferNanoException invalidProtocolBufferNanoException) {
/* 147 */       throw invalidProtocolBufferNanoException;
/* 148 */     } catch (IOException iOException) {
/* 149 */       throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final boolean messageNanoEquals(MessageNano paramMessageNano1, MessageNano paramMessageNano2) {
/* 159 */     if (paramMessageNano1 == paramMessageNano2) {
/* 160 */       return true;
/*     */     }
/* 162 */     if (paramMessageNano1 == null || paramMessageNano2 == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     if (paramMessageNano1.getClass() != paramMessageNano2.getClass()) {
/* 166 */       return false;
/*     */     }
/* 168 */     int i = paramMessageNano1.getSerializedSize();
/* 169 */     if (paramMessageNano2.getSerializedSize() != i) {
/* 170 */       return false;
/*     */     }
/* 172 */     byte[] arrayOfByte2 = new byte[i];
/* 173 */     byte[] arrayOfByte1 = new byte[i];
/* 174 */     toByteArray(paramMessageNano1, arrayOfByte2, 0, i);
/* 175 */     toByteArray(paramMessageNano2, arrayOfByte1, 0, i);
/* 176 */     return Arrays.equals(arrayOfByte2, arrayOfByte1);
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
/*     */   public String toString() {
/* 188 */     return MessageNanoPrinter.print(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageNano clone() throws CloneNotSupportedException {
/* 196 */     return (MessageNano)super.clone();
/*     */   }
/*     */   
/*     */   public abstract MessageNano mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano) throws IOException;
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\MessageNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */