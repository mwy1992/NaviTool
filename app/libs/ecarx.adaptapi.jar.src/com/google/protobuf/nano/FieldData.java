/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FieldData
/*     */   implements Cloneable
/*     */ {
/*     */   private Extension<?, ?> cachedExtension;
/*     */   private List<UnknownFieldData> unknownFieldData;
/*     */   private Object value;
/*     */   
/*     */   <T> FieldData(Extension<?, T> paramExtension, T paramT) {
/*  49 */     this.cachedExtension = paramExtension;
/*  50 */     this.value = paramT;
/*     */   }
/*     */   
/*     */   FieldData() {
/*  54 */     this.unknownFieldData = new ArrayList<>();
/*     */   }
/*     */   
/*     */   void addUnknownField(UnknownFieldData paramUnknownFieldData) {
/*  58 */     this.unknownFieldData.add(paramUnknownFieldData);
/*     */   }
/*     */   
/*     */   UnknownFieldData getUnknownField(int paramInt) {
/*  62 */     if (this.unknownFieldData == null) {
/*  63 */       return null;
/*     */     }
/*  65 */     if (paramInt < this.unknownFieldData.size()) {
/*  66 */       return this.unknownFieldData.get(paramInt);
/*     */     }
/*  68 */     return null;
/*     */   }
/*     */   
/*     */   int getUnknownFieldSize() {
/*  72 */     if (this.unknownFieldData == null) {
/*  73 */       return 0;
/*     */     }
/*  75 */     return this.unknownFieldData.size();
/*     */   }
/*     */   
/*     */   <T> T getValue(Extension<?, T> paramExtension) {
/*  79 */     if (this.value != null) {
/*  80 */       if (this.cachedExtension != paramExtension) {
/*  81 */         throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
/*     */       }
/*     */     } else {
/*     */       
/*  85 */       this.cachedExtension = paramExtension;
/*  86 */       this.value = paramExtension.getValueFrom(this.unknownFieldData);
/*  87 */       this.unknownFieldData = null;
/*     */     } 
/*  89 */     return (T)this.value;
/*     */   }
/*     */   
/*     */   <T> void setValue(Extension<?, T> paramExtension, T paramT) {
/*  93 */     this.cachedExtension = paramExtension;
/*  94 */     this.value = paramT;
/*  95 */     this.unknownFieldData = null;
/*     */   }
/*     */   
/*     */   int computeSerializedSize() {
/*  99 */     int j, i = 0;
/* 100 */     if (this.value != null) {
/* 101 */       j = this.cachedExtension.computeSerializedSize(this.value);
/*     */     } else {
/* 103 */       Iterator<UnknownFieldData> iterator = this.unknownFieldData.iterator(); while (true) { j = i; if (iterator.hasNext()) { UnknownFieldData unknownFieldData = iterator.next();
/* 104 */           i += unknownFieldData.computeSerializedSize(); continue; }
/*     */          break; }
/*     */     
/* 107 */     }  return j;
/*     */   }
/*     */   
/*     */   void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano) throws IOException {
/* 111 */     if (this.value != null) {
/* 112 */       this.cachedExtension.writeTo(this.value, paramCodedOutputByteBufferNano);
/*     */     } else {
/* 114 */       for (UnknownFieldData unknownFieldData : this.unknownFieldData) {
/* 115 */         unknownFieldData.writeTo(paramCodedOutputByteBufferNano);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 122 */     if (paramObject == this) {
/* 123 */       return true;
/*     */     }
/* 125 */     if (!(paramObject instanceof FieldData)) {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     paramObject = paramObject;
/* 130 */     if (this.value != null && ((FieldData)paramObject).value != null) {
/*     */ 
/*     */ 
/*     */       
/* 134 */       if (this.cachedExtension != ((FieldData)paramObject).cachedExtension) {
/* 135 */         return false;
/*     */       }
/* 137 */       if (!this.cachedExtension.clazz.isArray())
/*     */       {
/* 139 */         return this.value.equals(((FieldData)paramObject).value);
/*     */       }
/* 141 */       if (this.value instanceof byte[])
/* 142 */         return Arrays.equals((byte[])this.value, (byte[])((FieldData)paramObject).value); 
/* 143 */       if (this.value instanceof int[])
/* 144 */         return Arrays.equals((int[])this.value, (int[])((FieldData)paramObject).value); 
/* 145 */       if (this.value instanceof long[])
/* 146 */         return Arrays.equals((long[])this.value, (long[])((FieldData)paramObject).value); 
/* 147 */       if (this.value instanceof float[])
/* 148 */         return Arrays.equals((float[])this.value, (float[])((FieldData)paramObject).value); 
/* 149 */       if (this.value instanceof double[])
/* 150 */         return Arrays.equals((double[])this.value, (double[])((FieldData)paramObject).value); 
/* 151 */       if (this.value instanceof boolean[]) {
/* 152 */         return Arrays.equals((boolean[])this.value, (boolean[])((FieldData)paramObject).value);
/*     */       }
/* 154 */       return Arrays.deepEquals((Object[])this.value, (Object[])((FieldData)paramObject).value);
/*     */     } 
/*     */     
/* 157 */     if (this.unknownFieldData != null && ((FieldData)paramObject).unknownFieldData != null)
/*     */     {
/* 159 */       return this.unknownFieldData.equals(((FieldData)paramObject).unknownFieldData);
/*     */     }
/*     */     
/*     */     try {
/* 163 */       return Arrays.equals(toByteArray(), paramObject.toByteArray());
/* 164 */     } catch (IOException iOException) {
/*     */       
/* 166 */       throw new IllegalStateException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*     */     try {
/* 175 */       int i = Arrays.hashCode(toByteArray());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       return 31 * 17 + i;
/*     */     } catch (IOException iOException) {
/*     */       throw new IllegalStateException(iOException);
/*     */     }  } private byte[] toByteArray() throws IOException {
/* 184 */     byte[] arrayOfByte = new byte[computeSerializedSize()];
/* 185 */     CodedOutputByteBufferNano codedOutputByteBufferNano = CodedOutputByteBufferNano.newInstance(arrayOfByte);
/* 186 */     writeTo(codedOutputByteBufferNano);
/* 187 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public final FieldData clone() {
/* 192 */     FieldData fieldData = new FieldData();
/*     */     try {
/* 194 */       fieldData.cachedExtension = this.cachedExtension;
/* 195 */       if (this.unknownFieldData == null) {
/* 196 */         fieldData.unknownFieldData = null;
/*     */       } else {
/* 198 */         fieldData.unknownFieldData.addAll(this.unknownFieldData);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 204 */       if (this.value != null)
/*     */       {
/* 206 */         if (this.value instanceof MessageNano)
/* 207 */         { fieldData.value = ((MessageNano)this.value).clone(); }
/* 208 */         else if (this.value instanceof byte[])
/* 209 */         { fieldData.value = ((byte[])this.value).clone(); }
/* 210 */         else { boolean bool = this.value instanceof byte[][]; byte b1 = 0, b2 = 0; if (bool) {
/* 211 */             byte[][] arrayOfByte1 = (byte[][])this.value;
/* 212 */             byte[][] arrayOfByte2 = new byte[arrayOfByte1.length][];
/* 213 */             fieldData.value = arrayOfByte2;
/* 214 */             for (b1 = b2; b1 < arrayOfByte1.length; b1++) {
/* 215 */               arrayOfByte2[b1] = (byte[])arrayOfByte1[b1].clone();
/*     */             }
/* 217 */           } else if (this.value instanceof boolean[]) {
/* 218 */             fieldData.value = ((boolean[])this.value).clone();
/* 219 */           } else if (this.value instanceof int[]) {
/* 220 */             fieldData.value = ((int[])this.value).clone();
/* 221 */           } else if (this.value instanceof long[]) {
/* 222 */             fieldData.value = ((long[])this.value).clone();
/* 223 */           } else if (this.value instanceof float[]) {
/* 224 */             fieldData.value = ((float[])this.value).clone();
/* 225 */           } else if (this.value instanceof double[]) {
/* 226 */             fieldData.value = ((double[])this.value).clone();
/* 227 */           } else if (this.value instanceof MessageNano[]) {
/* 228 */             MessageNano[] arrayOfMessageNano2 = (MessageNano[])this.value;
/* 229 */             MessageNano[] arrayOfMessageNano1 = new MessageNano[arrayOfMessageNano2.length];
/* 230 */             fieldData.value = arrayOfMessageNano1;
/* 231 */             for (; b1 < arrayOfMessageNano2.length; b1++)
/* 232 */               arrayOfMessageNano1[b1] = arrayOfMessageNano2[b1].clone(); 
/*     */           }  }
/*     */          } 
/* 235 */       return fieldData;
/* 236 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 237 */       throw new AssertionError(cloneNotSupportedException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\FieldData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */