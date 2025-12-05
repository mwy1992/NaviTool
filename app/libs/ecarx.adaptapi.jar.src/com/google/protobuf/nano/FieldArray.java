/*     */ package com.google.protobuf.nano;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FieldArray
/*     */   implements Cloneable
/*     */ {
/*  44 */   private static final FieldData DELETED = new FieldData();
/*     */   
/*     */   private FieldData[] mData;
/*     */   
/*     */   private int[] mFieldNumbers;
/*     */   
/*     */   private boolean mGarbage = false;
/*     */   
/*     */   private int mSize;
/*     */   
/*     */   FieldArray() {
/*  55 */     this(10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldArray(int paramInt) {
/*  64 */     paramInt = idealIntArraySize(paramInt);
/*  65 */     this.mFieldNumbers = new int[paramInt];
/*  66 */     this.mData = new FieldData[paramInt];
/*  67 */     this.mSize = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldData get(int paramInt) {
/*  75 */     paramInt = binarySearch(paramInt);
/*     */     
/*  77 */     if (paramInt < 0 || this.mData[paramInt] == DELETED) {
/*  78 */       return null;
/*     */     }
/*  80 */     return this.mData[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(int paramInt) {
/*  88 */     paramInt = binarySearch(paramInt);
/*     */     
/*  90 */     if (paramInt >= 0 && this.mData[paramInt] != DELETED) {
/*  91 */       this.mData[paramInt] = DELETED;
/*  92 */       this.mGarbage = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void gc() {
/*  97 */     int k = this.mSize;
/*     */     
/*  99 */     int[] arrayOfInt = this.mFieldNumbers;
/* 100 */     FieldData[] arrayOfFieldData = this.mData;
/*     */     int i, j;
/* 102 */     for (i = 0, j = 0; j < k; j++, i = m) {
/* 103 */       FieldData fieldData = arrayOfFieldData[j];
/*     */       
/* 105 */       int m = i; if (fieldData != DELETED) {
/* 106 */         if (j != i) {
/* 107 */           arrayOfInt[i] = arrayOfInt[j];
/* 108 */           arrayOfFieldData[i] = fieldData;
/* 109 */           arrayOfFieldData[j] = null;
/*     */         } 
/*     */         
/* 112 */         m = i + 1;
/*     */       } 
/*     */     } 
/*     */     
/* 116 */     this.mGarbage = false;
/* 117 */     this.mSize = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void put(int paramInt, FieldData paramFieldData) {
/* 125 */     int i = binarySearch(paramInt);
/*     */     
/* 127 */     if (i >= 0) {
/* 128 */       this.mData[i] = paramFieldData;
/*     */     } else {
/* 130 */       int j = i ^ 0xFFFFFFFF;
/*     */       
/* 132 */       if (j < this.mSize && this.mData[j] == DELETED) {
/* 133 */         this.mFieldNumbers[j] = paramInt;
/* 134 */         this.mData[j] = paramFieldData;
/*     */         
/*     */         return;
/*     */       } 
/* 138 */       i = j; if (this.mGarbage) { i = j; if (this.mSize >= this.mFieldNumbers.length) {
/* 139 */           gc();
/*     */ 
/*     */           
/* 142 */           i = binarySearch(paramInt) ^ 0xFFFFFFFF;
/*     */         }  }
/*     */       
/* 145 */       if (this.mSize >= this.mFieldNumbers.length) {
/* 146 */         j = idealIntArraySize(this.mSize + 1);
/*     */         
/* 148 */         int[] arrayOfInt = new int[j];
/* 149 */         FieldData[] arrayOfFieldData = new FieldData[j];
/*     */         
/* 151 */         System.arraycopy(this.mFieldNumbers, 0, arrayOfInt, 0, this.mFieldNumbers.length);
/* 152 */         System.arraycopy(this.mData, 0, arrayOfFieldData, 0, this.mData.length);
/*     */         
/* 154 */         this.mFieldNumbers = arrayOfInt;
/* 155 */         this.mData = arrayOfFieldData;
/*     */       } 
/*     */       
/* 158 */       if (this.mSize - i != 0) {
/* 159 */         System.arraycopy(this.mFieldNumbers, i, this.mFieldNumbers, i + 1, this.mSize - i);
/* 160 */         System.arraycopy(this.mData, i, this.mData, i + 1, this.mSize - i);
/*     */       } 
/*     */       
/* 163 */       this.mFieldNumbers[i] = paramInt;
/* 164 */       this.mData[i] = paramFieldData;
/* 165 */       this.mSize++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int size() {
/* 174 */     if (this.mGarbage) {
/* 175 */       gc();
/*     */     }
/*     */     
/* 178 */     return this.mSize;
/*     */   }
/*     */   public boolean isEmpty() {
/*     */     boolean bool;
/* 182 */     if (size() == 0) { bool = true; } else { bool = false; }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FieldData dataAt(int paramInt) {
/* 191 */     if (this.mGarbage) {
/* 192 */       gc();
/*     */     }
/*     */     
/* 195 */     return this.mData[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 200 */     null = true; if (paramObject == this) {
/* 201 */       return true;
/*     */     }
/* 203 */     if (!(paramObject instanceof FieldArray)) {
/* 204 */       return false;
/*     */     }
/*     */     
/* 207 */     FieldArray fieldArray = (FieldArray)paramObject;
/* 208 */     if (size() != fieldArray.size()) {
/* 209 */       return false;
/*     */     }
/* 211 */     if (arrayEquals(this.mFieldNumbers, fieldArray.mFieldNumbers, this.mSize)) { paramObject = this.mData; FieldData[] arrayOfFieldData = fieldArray.mData; int i = this.mSize;
/* 212 */       if (arrayEquals((FieldData[])paramObject, arrayOfFieldData, i))
/*     */         return null;  }
/*     */     
/*     */     return false;
/*     */   } public int hashCode() {
/* 217 */     if (this.mGarbage) {
/* 218 */       gc();
/*     */     }
/* 220 */     int i = 17;
/* 221 */     for (byte b = 0; b < this.mSize; b++) {
/* 222 */       int j = this.mFieldNumbers[b];
/* 223 */       i = this.mData[b].hashCode() + 31 * (31 * i + j);
/*     */     } 
/* 225 */     return i;
/*     */   }
/*     */   
/*     */   private int idealIntArraySize(int paramInt) {
/* 229 */     return idealByteArraySize(paramInt * 4) / 4;
/*     */   }
/*     */   
/*     */   private int idealByteArraySize(int paramInt) {
/* 233 */     for (byte b = 4; b < 32; b++) {
/* 234 */       if (paramInt <= (1 << b) - 12)
/* 235 */         return (1 << b) - 12; 
/*     */     } 
/* 237 */     return paramInt;
/*     */   }
/*     */   
/*     */   private int binarySearch(int paramInt) {
/* 241 */     int j = 0;
/* 242 */     int i = this.mSize - 1;
/*     */     
/* 244 */     while (j <= i) {
/* 245 */       int k = j + i >>> 1;
/* 246 */       int m = this.mFieldNumbers[k];
/*     */       
/* 248 */       if (m < paramInt) {
/* 249 */         j = k + 1; continue;
/* 250 */       }  if (m > paramInt) {
/* 251 */         i = k - 1; continue;
/*     */       } 
/* 253 */       return k;
/*     */     } 
/*     */     
/* 256 */     return j ^ 0xFFFFFFFF;
/*     */   }
/*     */   
/*     */   private boolean arrayEquals(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 260 */     for (byte b = 0; b < paramInt; b++) {
/* 261 */       if (paramArrayOfint1[b] != paramArrayOfint2[b]) {
/* 262 */         return false;
/*     */       }
/*     */     } 
/* 265 */     return true;
/*     */   }
/*     */   
/*     */   private boolean arrayEquals(FieldData[] paramArrayOfFieldData1, FieldData[] paramArrayOfFieldData2, int paramInt) {
/* 269 */     for (byte b = 0; b < paramInt; b++) {
/* 270 */       if (!paramArrayOfFieldData1[b].equals(paramArrayOfFieldData2[b])) {
/* 271 */         return false;
/*     */       }
/*     */     } 
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final FieldArray clone() {
/* 280 */     int i = size();
/* 281 */     FieldArray fieldArray = new FieldArray(i);
/* 282 */     int[] arrayOfInt2 = this.mFieldNumbers, arrayOfInt1 = fieldArray.mFieldNumbers; byte b = 0; System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, i);
/* 283 */     for (; b < i; b++) {
/* 284 */       if (this.mData[b] != null) {
/* 285 */         fieldArray.mData[b] = this.mData[b].clone();
/*     */       }
/*     */     } 
/* 288 */     fieldArray.mSize = i;
/* 289 */     return fieldArray;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\google\protobuf\nano\FieldArray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */