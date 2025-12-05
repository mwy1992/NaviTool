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
/*     */ public abstract class ExtendableMessageNano<M extends ExtendableMessageNano<M>>
/*     */   extends MessageNano
/*     */ {
/*     */   protected FieldArray unknownFieldData;
/*     */   
/*     */   protected int computeSerializedSize() {
/*  49 */     int j = 0, i = 0;
/*  50 */     if (this.unknownFieldData != null) {
/*  51 */       byte b = 0; while (true) { j = i; if (b < this.unknownFieldData.size()) {
/*  52 */           FieldData fieldData = this.unknownFieldData.dataAt(b);
/*  53 */           i += fieldData.computeSerializedSize(); b++; continue;
/*     */         }  break; }
/*     */     
/*  56 */     }  return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano) throws IOException {
/*  61 */     if (this.unknownFieldData == null) {
/*     */       return;
/*     */     }
/*  64 */     for (byte b = 0; b < this.unknownFieldData.size(); b++) {
/*  65 */       FieldData fieldData = this.unknownFieldData.dataAt(b);
/*  66 */       fieldData.writeTo(paramCodedOutputByteBufferNano);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean hasExtension(Extension<M, ?> paramExtension) {
/*  75 */     FieldArray fieldArray = this.unknownFieldData; boolean bool = false; if (fieldArray == null) {
/*  76 */       return false;
/*     */     }
/*  78 */     FieldData fieldData = this.unknownFieldData.get(WireFormatNano.getTagFieldNumber(paramExtension.tag));
/*  79 */     if (fieldData != null) bool = true;  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T getExtension(Extension<M, T> paramExtension) {
/*  86 */     FieldArray fieldArray = this.unknownFieldData; Extension extension = null; if (fieldArray == null) {
/*  87 */       return null;
/*     */     }
/*  89 */     FieldData fieldData = this.unknownFieldData.get(WireFormatNano.getTagFieldNumber(paramExtension.tag));
/*  90 */     if (fieldData == null) { paramExtension = extension; } else { paramExtension = fieldData.getValue((Extension)paramExtension); }  return (T)paramExtension;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> M setExtension(Extension<M, T> paramExtension, T paramT) {
/*  97 */     int i = WireFormatNano.getTagFieldNumber(paramExtension.tag);
/*  98 */     if (paramT == null) {
/*  99 */       if (this.unknownFieldData != null) {
/* 100 */         this.unknownFieldData.remove(i);
/* 101 */         if (this.unknownFieldData.isEmpty()) {
/* 102 */           this.unknownFieldData = null;
/*     */         }
/*     */       } 
/*     */     } else {
/* 106 */       FieldData fieldData = null;
/* 107 */       if (this.unknownFieldData == null) {
/* 108 */         this.unknownFieldData = new FieldArray();
/*     */       } else {
/* 110 */         fieldData = this.unknownFieldData.get(i);
/*     */       } 
/* 112 */       if (fieldData == null) {
/* 113 */         this.unknownFieldData.put(i, new FieldData(paramExtension, paramT));
/*     */       } else {
/* 115 */         fieldData.setValue(paramExtension, paramT);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 121 */     return (M)this;
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
/*     */   protected final boolean storeUnknownField(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt) throws IOException {
/*     */     FieldData fieldData1;
/* 140 */     int k = paramCodedInputByteBufferNano.getPosition();
/* 141 */     if (!paramCodedInputByteBufferNano.skipField(paramInt)) {
/* 142 */       return false;
/*     */     }
/* 144 */     int i = WireFormatNano.getTagFieldNumber(paramInt);
/* 145 */     int j = paramCodedInputByteBufferNano.getPosition();
/* 146 */     byte[] arrayOfByte = paramCodedInputByteBufferNano.getData(k, j - k);
/* 147 */     UnknownFieldData unknownFieldData = new UnknownFieldData(paramInt, arrayOfByte);
/*     */     
/* 149 */     arrayOfByte = null;
/* 150 */     if (this.unknownFieldData == null) {
/* 151 */       this.unknownFieldData = new FieldArray();
/*     */     } else {
/* 153 */       fieldData1 = this.unknownFieldData.get(i);
/*     */     } 
/* 155 */     FieldData fieldData2 = fieldData1; if (fieldData1 == null) {
/* 156 */       fieldData2 = new FieldData();
/* 157 */       this.unknownFieldData.put(i, fieldData2);
/*     */     } 
/* 159 */     fieldData2.addUnknownField(unknownFieldData);
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public M clone() throws CloneNotSupportedException {
/* 165 */     ExtendableMessageNano extendableMessageNano = (ExtendableMessageNano)super.clone();
/* 166 */     InternalNano.cloneUnknownFieldData(this, extendableMessageNano);
/* 167 */     return (M)extendableMessageNano;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\ExtendableMessageNano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */