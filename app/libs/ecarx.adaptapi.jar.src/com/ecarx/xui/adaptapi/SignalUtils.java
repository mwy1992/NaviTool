/*     */ package com.ecarx.xui.adaptapi;
/*     */ 
/*     */ import ecarx.car.hardware.annotation.AvailabilitySts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignalUtils
/*     */ {
/*     */   public static FunctionStatus convertToFunctionStatus(int paramInt) {
/*  28 */     FunctionStatus functionStatus2 = FunctionStatus.notavailable;
/*  29 */     FunctionStatus functionStatus1 = functionStatus2; if (AvailabilitySts.isValid(paramInt))
/*  30 */     { switch (paramInt) { default: functionStatus1 = functionStatus2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  46 */           return functionStatus1;case 4: functionStatus1 = FunctionStatus.error; return functionStatus1;case 3: functionStatus1 = FunctionStatus.notavailable; return functionStatus1;case 2: functionStatus1 = FunctionStatus.notactive; return functionStatus1;case 1: break; }  functionStatus1 = FunctionStatus.active; }  return functionStatus1;
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
/*     */   public static FunctionStatus convertToFunctionStatus(int paramInt, FunctionStatus paramFunctionStatus) {
/*  58 */     FunctionStatus functionStatus = paramFunctionStatus;
/*  59 */     paramFunctionStatus = functionStatus; if (AvailabilitySts.isValid(paramInt))
/*  60 */     { switch (paramInt) { default: paramFunctionStatus = functionStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  76 */           return paramFunctionStatus;case 4: paramFunctionStatus = FunctionStatus.error; return paramFunctionStatus;case 3: paramFunctionStatus = FunctionStatus.notavailable; return paramFunctionStatus;case 2: paramFunctionStatus = FunctionStatus.notactive; return paramFunctionStatus;case 1: break; }  paramFunctionStatus = FunctionStatus.active; }  return paramFunctionStatus;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertOnOff1(int paramInt) {
/*  81 */     char c = 'ÿ';
/*  82 */     if (paramInt == 0) {
/*  83 */       c = Character.MIN_VALUE;
/*  84 */     } else if (paramInt == 1) {
/*  85 */       c = '\001';
/*     */     } 
/*  87 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertOnOff2(int paramInt) {
/*  92 */     char c = 'ÿ';
/*  93 */     if (paramInt == 1) {
/*  94 */       c = Character.MIN_VALUE;
/*  95 */     } else if (paramInt == 0) {
/*  96 */       c = '\001';
/*     */     } 
/*  98 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertYesNo1(int paramInt) {
/* 103 */     char c = 'ÿ';
/* 104 */     if (paramInt == 1) {
/* 105 */       c = Character.MIN_VALUE;
/* 106 */     } else if (paramInt == 0) {
/* 107 */       c = '\001';
/*     */     } 
/* 109 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertYesNo2(int paramInt) {
/* 114 */     char c = 'ÿ';
/* 115 */     if (paramInt == 0) {
/* 116 */       c = Character.MIN_VALUE;
/* 117 */     } else if (paramInt == 1) {
/* 118 */       c = '\001';
/*     */     } 
/* 120 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertLongPresBtn(int paramInt) {
/* 125 */     char c = 'ÿ';
/* 126 */     if (paramInt == 0) {
/* 127 */       c = Character.MIN_VALUE;
/* 128 */     } else if (paramInt == 1) {
/* 129 */       c = '\001';
/*     */     } 
/* 131 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertToOnOff1(int paramInt) {
/* 136 */     char c = 'ÿ';
/* 137 */     if (paramInt == 0) {
/* 138 */       c = Character.MIN_VALUE;
/* 139 */     } else if (paramInt == 1) {
/* 140 */       c = '\001';
/*     */     } 
/* 142 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertNoYes1(int paramInt) {
/* 147 */     char c = 'ÿ';
/* 148 */     if (paramInt == 0) {
/* 149 */       c = Character.MIN_VALUE;
/* 150 */     } else if (paramInt == 1) {
/* 151 */       c = '\001';
/*     */     } 
/* 153 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int convertBooleanType(int paramInt) {
/* 158 */     char c = 'ÿ';
/* 159 */     if (paramInt == 0) {
/* 160 */       c = Character.MIN_VALUE;
/* 161 */     } else if (paramInt == 1) {
/* 162 */       c = '\001';
/*     */     } 
/* 164 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FunctionStatus functionStatusIs(boolean paramBoolean1, boolean paramBoolean2) {
/* 175 */     FunctionStatus functionStatus = FunctionStatus.notavailable;
/* 176 */     if (paramBoolean1)
/* 177 */       if (paramBoolean2) { functionStatus = FunctionStatus.active; } else { functionStatus = FunctionStatus.notactive; }
/*     */        
/* 179 */     return functionStatus;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\SignalUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */