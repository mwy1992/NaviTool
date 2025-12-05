/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Extension<M extends ExtendableMessageNano<M>, T>
/*     */ {
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
/*     */   protected final Class<T> clazz;
/*     */   protected final boolean repeated;
/*     */   public final int tag;
/*     */   protected final int type;
/*     */   
/*     */   @Deprecated
/*     */   public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int paramInt1, Class<T> paramClass, int paramInt2) {
/*  87 */     return new Extension<>(paramInt1, paramClass, paramInt2, false);
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
/*     */   public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T> createMessageTyped(int paramInt, Class<T> paramClass, long paramLong) {
/* 103 */     return new Extension<>(paramInt, paramClass, (int)paramLong, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <M extends ExtendableMessageNano<M>, T extends MessageNano> Extension<M, T[]> createRepeatedMessageTyped(int paramInt, Class<T[]> paramClass, long paramLong) {
/* 114 */     return new Extension<>(paramInt, paramClass, (int)paramLong, true);
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
/*     */   public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createPrimitiveTyped(int paramInt, Class<T> paramClass, long paramLong) {
/* 126 */     return new PrimitiveExtension<>(paramInt, paramClass, (int)paramLong, false, 0, 0);
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
/*     */   public static <M extends ExtendableMessageNano<M>, T> Extension<M, T> createRepeatedPrimitiveTyped(int paramInt, Class<T> paramClass, long paramLong1, long paramLong2, long paramLong3) {
/* 139 */     return new PrimitiveExtension<>(paramInt, paramClass, (int)paramLong1, true, (int)paramLong2, (int)paramLong3);
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
/*     */   private Extension(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean) {
/* 168 */     this.type = paramInt1;
/* 169 */     this.clazz = paramClass;
/* 170 */     this.tag = paramInt2;
/* 171 */     this.repeated = paramBoolean;
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
/*     */   final T getValueFrom(List<UnknownFieldData> paramList) {
/* 183 */     if (paramList == null) {
/* 184 */       return null;
/*     */     }
/* 186 */     if (this.repeated) { paramList = (List<UnknownFieldData>)getRepeatedValueFrom(paramList); } else { paramList = (List<UnknownFieldData>)getSingularValueFrom(paramList); }  return (T)paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   private T getRepeatedValueFrom(List<UnknownFieldData> paramList) {
/* 191 */     ArrayList<Object> arrayList = new ArrayList(); byte b; boolean bool;
/* 192 */     for (bool = false, b = 0; b < paramList.size(); b++) {
/* 193 */       UnknownFieldData unknownFieldData = paramList.get(b);
/* 194 */       if (unknownFieldData.bytes.length != 0) {
/* 195 */         readDataInto(unknownFieldData, arrayList);
/*     */       }
/*     */     } 
/*     */     
/* 199 */     int i = arrayList.size();
/* 200 */     if (i == 0) {
/* 201 */       return null;
/*     */     }
/* 203 */     paramList = (List<UnknownFieldData>)this.clazz.cast(Array.newInstance(this.clazz.getComponentType(), i));
/* 204 */     for (b = bool; b < i; b++) {
/* 205 */       Array.set(paramList, b, arrayList.get(b));
/*     */     }
/* 207 */     return (T)paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private T getSingularValueFrom(List<UnknownFieldData> paramList) {
/* 213 */     if (paramList.isEmpty()) {
/* 214 */       return null;
/*     */     }
/* 216 */     UnknownFieldData unknownFieldData = paramList.get(paramList.size() - 1);
/* 217 */     return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
/*     */   }
/*     */   
/*     */   protected Object readData(CodedInputByteBufferNano paramCodedInputByteBufferNano) {
/*     */     Class<T> clazz;
/* 222 */     if (this.repeated) { clazz = (Class)this.clazz.getComponentType(); } else { clazz = this.clazz; }
/*     */      
/* 224 */     try { IllegalArgumentException illegalArgumentException; StringBuilder stringBuilder; switch (this.type)
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 234 */           illegalArgumentException = new IllegalArgumentException(); stringBuilder = new StringBuilder(); this(); stringBuilder.append("Unknown type "); stringBuilder.append(this.type); this(stringBuilder.toString()); throw illegalArgumentException;
/*     */         case 11: messageNano = (MessageNano)clazz.newInstance(); illegalArgumentException.readMessage(messageNano); return messageNano;
/* 236 */         case 10: break; }  MessageNano messageNano = (MessageNano)clazz.newInstance(); illegalArgumentException.readGroup(messageNano, WireFormatNano.getTagFieldNumber(this.tag)); return messageNano; } catch (InstantiationException instantiationException)
/* 237 */     { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Error creating instance of class "); stringBuilder.append(clazz); throw new IllegalArgumentException(stringBuilder.toString(), instantiationException); }
/*     */     
/* 239 */     catch (IllegalAccessException illegalAccessException)
/* 240 */     { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Error creating instance of class "); stringBuilder.append(clazz); throw new IllegalArgumentException(stringBuilder.toString(), illegalAccessException); }
/*     */     
/* 242 */     catch (IOException iOException)
/* 243 */     { throw new IllegalArgumentException("Error reading extension field", iOException); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void readDataInto(UnknownFieldData paramUnknownFieldData, List<Object> paramList) {
/* 249 */     paramList.add(readData(CodedInputByteBufferNano.newInstance(paramUnknownFieldData.bytes)));
/*     */   }
/*     */   
/*     */   void writeTo(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano) throws IOException {
/* 253 */     if (this.repeated) {
/* 254 */       writeRepeatedData(paramObject, paramCodedOutputByteBufferNano);
/*     */     } else {
/* 256 */       writeSingularData(paramObject, paramCodedOutputByteBufferNano);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void writeSingularData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano) {
/*     */     
/*     */     try { StringBuilder stringBuilder;
/* 263 */       paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
/* 264 */       switch (this.type)
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 277 */           paramObject = new IllegalArgumentException(); stringBuilder = new StringBuilder(); this(); stringBuilder.append("Unknown type "); stringBuilder.append(this.type); super(stringBuilder.toString()); throw paramObject;
/*     */         case 11: paramObject = paramObject; stringBuilder.writeMessageNoTag((MessageNano)paramObject); return;
/* 279 */         case 10: break; }  paramObject = paramObject; int i = WireFormatNano.getTagFieldNumber(this.tag); stringBuilder.writeGroupNoTag((MessageNano)paramObject); stringBuilder.writeTag(i, 4); return; } catch (IOException iOException)
/*     */     
/* 281 */     { throw new IllegalStateException(iOException); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeRepeatedData(Object paramObject, CodedOutputByteBufferNano paramCodedOutputByteBufferNano) {
/* 287 */     int i = Array.getLength(paramObject);
/* 288 */     for (byte b = 0; b < i; b++) {
/* 289 */       Object object = Array.get(paramObject, b);
/* 290 */       if (object != null) {
/* 291 */         writeSingularData(object, paramCodedOutputByteBufferNano);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   int computeSerializedSize(Object paramObject) {
/* 297 */     if (this.repeated) {
/* 298 */       return computeRepeatedSerializedSize(paramObject);
/*     */     }
/* 300 */     return computeSingularSerializedSize(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int computeRepeatedSerializedSize(Object paramObject) {
/* 306 */     int i = 0;
/* 307 */     int j = Array.getLength(paramObject);
/* 308 */     for (byte b = 0; b < j; b++, i = k) {
/* 309 */       Object object = Array.get(paramObject, b);
/* 310 */       int k = i; if (object != null) {
/* 311 */         k = i + computeSingularSerializedSize(Array.get(paramObject, b));
/*     */       }
/*     */     } 
/* 314 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int computeSingularSerializedSize(Object paramObject) {
/* 319 */     int i = WireFormatNano.getTagFieldNumber(this.tag);
/* 320 */     switch (this.type) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 328 */         paramObject = new StringBuilder(); paramObject.append("Unknown type "); paramObject.append(this.type); throw new IllegalArgumentException(paramObject.toString());
/*     */       case 11:
/*     */         paramObject = paramObject;
/*     */         return CodedOutputByteBufferNano.computeMessageSize(i, (MessageNano)paramObject);
/*     */       case 10:
/*     */         break;
/*     */     } 
/*     */     paramObject = paramObject;
/*     */     return CodedOutputByteBufferNano.computeGroupSize(i, (MessageNano)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class PrimitiveExtension<M extends ExtendableMessageNano<M>, T>
/*     */     extends Extension<M, T>
/*     */   {
/*     */     private final int nonPackedTag;
/*     */ 
/*     */     
/*     */     private final int packedTag;
/*     */ 
/*     */ 
/*     */     
/*     */     public PrimitiveExtension(int param1Int1, Class<T> param1Class, int param1Int2, boolean param1Boolean, int param1Int3, int param1Int4) {
/* 352 */       super(param1Int1, param1Class, param1Int2, param1Boolean);
/* 353 */       this.nonPackedTag = param1Int3;
/* 354 */       this.packedTag = param1Int4;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Object readData(CodedInputByteBufferNano param1CodedInputByteBufferNano) {
/*     */       try {
/* 360 */         return param1CodedInputByteBufferNano.readPrimitiveField(this.type);
/* 361 */       } catch (IOException iOException) {
/* 362 */         throw new IllegalArgumentException("Error reading extension field", iOException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void readDataInto(UnknownFieldData param1UnknownFieldData, List<Object> param1List) {
/* 370 */       if (param1UnknownFieldData.tag == this.nonPackedTag) {
/* 371 */         param1List.add(readData(CodedInputByteBufferNano.newInstance(param1UnknownFieldData.bytes)));
/*     */       } else {
/* 373 */         byte[] arrayOfByte = param1UnknownFieldData.bytes;
/* 374 */         CodedInputByteBufferNano codedInputByteBufferNano = CodedInputByteBufferNano.newInstance(arrayOfByte);
/*     */         try {
/* 376 */           codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
/*     */ 
/*     */ 
/*     */           
/* 380 */           while (!codedInputByteBufferNano.isAtEnd())
/* 381 */             param1List.add(readData(codedInputByteBufferNano)); 
/*     */           return;
/*     */         } catch (IOException iOException) {
/*     */           throw new IllegalArgumentException("Error reading extension field", iOException);
/*     */         } 
/*     */       }  } protected final void writeSingularData(Object param1Object, CodedOutputByteBufferNano param1CodedOutputByteBufferNano) {
/*     */       
/*     */       try { StringBuilder stringBuilder;
/* 389 */         param1CodedOutputByteBufferNano.writeRawVarint32(this.tag);
/* 390 */         switch (this.type)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/* 456 */             param1Object = new IllegalArgumentException(); stringBuilder = new StringBuilder(); this(); stringBuilder.append("Unknown type "); stringBuilder.append(this.type); super(stringBuilder.toString()); throw param1Object;case 18: param1Object = param1Object; stringBuilder.writeSInt64NoTag(param1Object.longValue()); return;case 17: param1Object = param1Object; stringBuilder.writeSInt32NoTag(param1Object.intValue()); return;case 16: param1Object = param1Object; stringBuilder.writeSFixed64NoTag(param1Object.longValue()); return;case 15: param1Object = param1Object; stringBuilder.writeSFixed32NoTag(param1Object.intValue()); return;case 14: param1Object = param1Object; stringBuilder.writeEnumNoTag(param1Object.intValue()); return;case 13: param1Object = param1Object; stringBuilder.writeUInt32NoTag(param1Object.intValue()); return;case 12: param1Object = param1Object; stringBuilder.writeBytesNoTag((byte[])param1Object); return;case 9: param1Object = param1Object; stringBuilder.writeStringNoTag((String)param1Object); return;case 8: param1Object = param1Object; stringBuilder.writeBoolNoTag(param1Object.booleanValue()); return;case 7: param1Object = param1Object; stringBuilder.writeFixed32NoTag(param1Object.intValue()); return;case 6: param1Object = param1Object; stringBuilder.writeFixed64NoTag(param1Object.longValue()); return;case 5: param1Object = param1Object; stringBuilder.writeInt32NoTag(param1Object.intValue()); return;case 4: param1Object = param1Object; stringBuilder.writeUInt64NoTag(param1Object.longValue()); return;case 3: param1Object = param1Object; stringBuilder.writeInt64NoTag(param1Object.longValue()); return;
/*     */           case 2: param1Object = param1Object; stringBuilder.writeFloatNoTag(param1Object.floatValue()); return;
/* 458 */           case 1: break; }  param1Object = param1Object; stringBuilder.writeDoubleNoTag(param1Object.doubleValue()); return; } catch (IOException iOException)
/*     */       
/* 460 */       { throw new IllegalStateException(iOException); }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeRepeatedData(Object param1Object, CodedOutputByteBufferNano param1CodedOutputByteBufferNano) {
/* 466 */       if (this.tag == this.nonPackedTag)
/*     */       
/* 468 */       { super.writeRepeatedData(param1Object, param1CodedOutputByteBufferNano); }
/* 469 */       else { if (this.tag == this.packedTag) {
/*     */ 
/*     */           
/* 472 */           int j = Array.getLength(param1Object);
/* 473 */           int i = computePackedDataSize(param1Object);
/*     */           
/*     */           try { IllegalArgumentException illegalArgumentException;
/* 476 */             param1CodedOutputByteBufferNano.writeRawVarint32(this.tag);
/* 477 */             param1CodedOutputByteBufferNano.writeRawVarint32(i);
/* 478 */             int k = this.type; boolean bool10 = false, bool2 = false, bool6 = false, bool4 = false, bool8 = false, bool7 = false, bool5 = false; i = 0; boolean bool13 = false, bool11 = false, bool9 = false, bool1 = false, bool3 = false, bool12 = false; switch (k) { default: switch (k)
/*     */                 
/*     */                 { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   default:
/* 550 */                     illegalArgumentException = new IllegalArgumentException(); param1Object = new StringBuilder(); super(); param1Object.append("Unpackable type "); param1Object.append(this.type); this(param1Object.toString()); throw illegalArgumentException;case 18: for (i = bool12; i < j; i++) illegalArgumentException.writeSInt64NoTag(Array.getLong(param1Object, i));  return;case 17: for (i = bool10; i < j; i++) illegalArgumentException.writeSInt32NoTag(Array.getInt(param1Object, i));  return;case 16: for (i = bool2; i < j; i++) illegalArgumentException.writeSFixed64NoTag(Array.getLong(param1Object, i));  return;case 15: for (i = bool6; i < j; i++) illegalArgumentException.writeSFixed32NoTag(Array.getInt(param1Object, i));  return;case 14: for (i = bool4; i < j; i++) illegalArgumentException.writeEnumNoTag(Array.getInt(param1Object, i));  return;case 13: break; }  for (i = bool8; i < j; i++) illegalArgumentException.writeUInt32NoTag(Array.getInt(param1Object, i));  return;case 8: for (i = bool7; i < j; i++) illegalArgumentException.writeBoolNoTag(Array.getBoolean(param1Object, i));  return;case 7: for (i = bool5; i < j; i++) illegalArgumentException.writeFixed32NoTag(Array.getInt(param1Object, i));  return;case 6: for (; i < j; i++) illegalArgumentException.writeFixed64NoTag(Array.getLong(param1Object, i));  return;case 5: for (i = bool13; i < j; i++) illegalArgumentException.writeInt32NoTag(Array.getInt(param1Object, i));  return;case 4: for (i = bool11; i < j; i++) illegalArgumentException.writeUInt64NoTag(Array.getLong(param1Object, i));  return;case 3: for (i = bool9; i < j; i++) illegalArgumentException.writeInt64NoTag(Array.getLong(param1Object, i));  return;case 2: for (i = bool1; i < j; i++)
/*     */                   illegalArgumentException.writeFloatNoTag(Array.getFloat(param1Object, i));  return;case 1: break; }  for (i = bool3; i < j; i++)
/* 552 */               illegalArgumentException.writeDoubleNoTag(Array.getDouble(param1Object, i));  return; } catch (IOException iOException)
/*     */           
/* 554 */           { throw new IllegalStateException(iOException); }
/*     */         
/*     */         } 
/* 557 */         param1Object = new StringBuilder(); param1Object.append("Unexpected repeated extension tag "); param1Object.append(this.tag); param1Object.append(", unequal to both non-packed variant "); param1Object.append(this.nonPackedTag); param1Object.append(" and packed variant "); param1Object.append(this.packedTag); throw new IllegalArgumentException(param1Object.toString()); }
/*     */     
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private int computePackedDataSize(Object param1Object) {
/* 564 */       boolean bool1 = false, bool3 = false, bool2 = false; int i = 0; boolean bool4 = false; int k = 0; byte b2 = 0;
/* 565 */       int j = Array.getLength(param1Object);
/* 566 */       int m = this.type; boolean bool9 = false, bool8 = false; byte b1 = 0; boolean bool5 = false, bool6 = false, bool7 = false; byte b3 = 0; switch (m) { default: switch (m)
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             default:
/* 624 */               param1Object = new StringBuilder(); param1Object.append("Unexpected non-packable type "); param1Object.append(this.type); throw new IllegalArgumentException(param1Object.toString());
/*     */             case 18: for (b1 = b3, i = b2; b1 < j; i += CodedOutputByteBufferNano.computeSInt64SizeNoTag(l), b1++)
/* 626 */                 long l = Array.getLong(param1Object, b1);  return i;case 17: for (b1 = bool9, i = bool1; b1 < j; i += CodedOutputByteBufferNano.computeSInt32SizeNoTag(k), b1++) k = Array.getInt(param1Object, b1);  return i;case 14: for (b1 = bool8, i = bool3; b1 < j; i += CodedOutputByteBufferNano.computeEnumSizeNoTag(k), b1++) k = Array.getInt(param1Object, b1);  return i;case 13: for (i = bool2; b1 < j; i += CodedOutputByteBufferNano.computeUInt32SizeNoTag(k), b1++) k = Array.getInt(param1Object, b1);  return i;case 15: i = j * 4; return i;case 16: break; }  break;case 8: i = j; return i;case 5: for (b1 = bool5; b1 < j; i += CodedOutputByteBufferNano.computeInt32SizeNoTag(k), b1++) k = Array.getInt(param1Object, b1);  return i;case 4: for (b1 = bool6, i = bool4; b1 < j; i += CodedOutputByteBufferNano.computeUInt64SizeNoTag(l), b1++) long l = Array.getLong(param1Object, b1);  return i;case 3: for (b1 = bool7, i = k; b1 < j; i += CodedOutputByteBufferNano.computeInt64SizeNoTag(l), b1++) long l = Array.getLong(param1Object, b1);  return i;case 2: case 7: case 1: case 6: break; }  i = j * 8; return i;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int computeRepeatedSerializedSize(Object param1Object) {
/* 631 */       if (this.tag == this.nonPackedTag)
/*     */       {
/* 633 */         return super.computeRepeatedSerializedSize(param1Object); } 
/* 634 */       if (this.tag == this.packedTag) {
/*     */         
/* 636 */         int i = computePackedDataSize(param1Object);
/*     */         
/* 638 */         int j = CodedOutputByteBufferNano.computeRawVarint32Size(i);
/* 639 */         return CodedOutputByteBufferNano.computeRawVarint32Size(this.tag) + j + i;
/*     */       } 
/* 641 */       param1Object = new StringBuilder(); param1Object.append("Unexpected repeated extension tag "); param1Object.append(this.tag); param1Object.append(", unequal to both non-packed variant "); param1Object.append(this.nonPackedTag); param1Object.append(" and packed variant "); param1Object.append(this.packedTag); throw new IllegalArgumentException(param1Object.toString());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final int computeSingularSerializedSize(Object param1Object) {
/*     */       int i;
/*     */       long l;
/* 649 */       int j = WireFormatNano.getTagFieldNumber(this.tag);
/* 650 */       switch (this.type) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 702 */           param1Object = new StringBuilder(); param1Object.append("Unknown type "); param1Object.append(this.type); throw new IllegalArgumentException(param1Object.toString());
/*     */         case 18:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeSInt64Size(j, param1Object.longValue());
/*     */         case 17:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeSInt32Size(j, param1Object.intValue());
/*     */         case 16:
/*     */           param1Object = param1Object;
/*     */           l = param1Object.longValue();
/*     */           return CodedOutputByteBufferNano.computeSFixed64Size(j, l);
/*     */         case 15:
/*     */           param1Object = param1Object;
/*     */           i = param1Object.intValue();
/*     */           return CodedOutputByteBufferNano.computeSFixed32Size(j, i);
/*     */         case 14:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeEnumSize(j, param1Object.intValue());
/*     */         case 13:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeUInt32Size(j, param1Object.intValue());
/*     */         case 12:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeBytesSize(j, (byte[])param1Object);
/*     */         case 9:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeStringSize(j, (String)param1Object);
/*     */         case 8:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeBoolSize(j, param1Object.booleanValue());
/*     */         case 7:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeFixed32Size(j, param1Object.intValue());
/*     */         case 6:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeFixed64Size(j, param1Object.longValue());
/*     */         case 5:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeInt32Size(j, param1Object.intValue());
/*     */         case 4:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeUInt64Size(j, param1Object.longValue());
/*     */         case 3:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeInt64Size(j, param1Object.longValue());
/*     */         case 2:
/*     */           param1Object = param1Object;
/*     */           return CodedOutputByteBufferNano.computeFloatSize(j, param1Object.floatValue());
/*     */         case 1:
/*     */           break;
/*     */       } 
/*     */       param1Object = param1Object;
/*     */       return CodedOutputByteBufferNano.computeDoubleSize(j, param1Object.doubleValue());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\Extension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */