/*     */ package com.ecarx.xui.adaptapi.dvr;
/*     */ 
/*     */ import android.graphics.Bitmap;
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ public class DvrFile
/*     */   implements IDvrFile
/*     */ {
/*     */   private File mFile;
/*     */   private boolean mFinalDvrFile;
/*     */   private boolean mFirstDvrFile;
/*     */   private String mId;
/*     */   private boolean mLocked;
/*     */   private boolean mSelected;
/*     */   private Bitmap mThumbnail;
/*     */   private int mType;
/*     */   
/*     */   public DvrFile(String paramString, Bitmap paramBitmap, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt) {
/*  20 */     this.mId = paramString;
/*  21 */     this.mThumbnail = paramBitmap;
/*  22 */     this.mFile = paramFile;
/*  23 */     this.mSelected = paramBoolean1;
/*  24 */     this.mLocked = paramBoolean2;
/*  25 */     this.mFirstDvrFile = paramBoolean3;
/*  26 */     this.mFinalDvrFile = paramBoolean4;
/*  27 */     this.mType = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  36 */     return this.mId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Bitmap getThumbnail() {
/*  45 */     return this.mThumbnail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getFile() {
/*  54 */     return this.mFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSelected() {
/*  62 */     return this.mSelected;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLocked() {
/*  71 */     return this.mLocked;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFristDvrFile() {
/*  79 */     return this.mFirstDvrFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFinalDvrFile() {
/*  87 */     return this.mFinalDvrFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/*  96 */     return this.mType;
/*     */   }
/*     */   
/*     */   public void setId(String paramString) {
/* 100 */     this.mId = paramString;
/*     */   }
/*     */   
/*     */   public void setThumbnail(Bitmap paramBitmap) {
/* 104 */     this.mThumbnail = paramBitmap;
/*     */   }
/*     */   
/*     */   public void setFile(File paramFile) {
/* 108 */     this.mFile = paramFile;
/*     */   }
/*     */   
/*     */   public void setSelected(boolean paramBoolean) {
/* 112 */     this.mSelected = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setLocked(boolean paramBoolean) {
/* 116 */     this.mLocked = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setFirstDvrFile(boolean paramBoolean) {
/* 120 */     this.mFirstDvrFile = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setFinalDvrFile(boolean paramBoolean) {
/* 124 */     this.mFinalDvrFile = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setType(int paramInt) {
/* 128 */     this.mType = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\DvrFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */