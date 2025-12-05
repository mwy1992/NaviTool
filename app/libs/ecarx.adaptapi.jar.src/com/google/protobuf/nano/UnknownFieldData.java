/*    */ package com.google.protobuf.nano;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class UnknownFieldData
/*    */ {
/*    */   final byte[] bytes;
/*    */   final int tag;
/*    */   
/*    */   UnknownFieldData(int paramInt, byte[] paramArrayOfbyte) {
/* 52 */     this.tag = paramInt;
/* 53 */     this.bytes = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */   
/*    */   int computeSerializedSize() {
/* 58 */     int i = CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
/* 59 */     int j = this.bytes.length;
/* 60 */     return 0 + i + j;
/*    */   }
/*    */   
/*    */   void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano) throws IOException {
/* 64 */     paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
/* 65 */     paramCodedOutputByteBufferNano.writeRawBytes(this.bytes);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 70 */     boolean bool = true; if (paramObject == this) {
/* 71 */       return true;
/*    */     }
/* 73 */     if (!(paramObject instanceof UnknownFieldData)) {
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     paramObject = paramObject;
/* 78 */     if (this.tag != ((UnknownFieldData)paramObject).tag || !Arrays.equals(this.bytes, ((UnknownFieldData)paramObject).bytes)) bool = false;  return bool;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 84 */     int i = this.tag;
/* 85 */     int j = Arrays.hashCode(this.bytes);
/* 86 */     return 31 * (31 * 17 + i) + j;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\UnknownFieldData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */