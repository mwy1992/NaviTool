/*     */ package com.ecarx.xui.adaptapi.dvr.forp;
/*     */ 
/*     */ import android.net.Uri;
/*     */ import com.ecarx.xui.adaptapi.VendorDefinition;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DvrForPFile
/*     */   implements IDvrFile
/*     */ {
/*     */   private int mApplicationType;
/*     */   private long mDeleteTime;
/*     */   private long mDuration;
/*     */   private int mFileType;
/*     */   private Uri mFileUri;
/*     */   private int mHeight;
/*     */   private String mId;
/*     */   private boolean mIsDeleted;
/*     */   private boolean mIsDvrFileLocked;
/*     */   private double mLatitude;
/*     */   private double mLongitude;
/*     */   private String mMD5;
/*     */   private String mName;
/*     */   private long mSize;
/*     */   private Uri mThumbnail;
/*     */   private long mTicktime;
/*     */   private int mWidth;
/*     */   
/*     */   public DvrForPFile(int paramInt1, int paramInt2, String paramString) {
/*  37 */     this(null, paramInt1, paramInt2, paramString, 0L, 0, 0, null, 0.0D, 0.0D, 0L, null, null, 0L, true, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DvrForPFile(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong1, int paramInt3, int paramInt4, String paramString3, double paramDouble1, double paramDouble2, long paramLong2, Uri paramUri1, Uri paramUri2, long paramLong3, boolean paramBoolean, long paramLong4) {
/*  45 */     this.mId = paramString1;
/*  46 */     this.mFileType = paramInt1;
/*  47 */     this.mApplicationType = paramInt2;
/*  48 */     this.mName = paramString2;
/*  49 */     this.mSize = paramLong1;
/*  50 */     this.mWidth = paramInt3;
/*  51 */     this.mHeight = paramInt4;
/*  52 */     this.mMD5 = paramString3;
/*  53 */     this.mLongitude = paramDouble1;
/*  54 */     this.mLatitude = paramDouble2;
/*  55 */     this.mTicktime = paramLong2;
/*  56 */     this.mFileUri = paramUri1;
/*  57 */     this.mThumbnail = paramUri2;
/*  58 */     this.mDuration = paramLong3;
/*  59 */     this.mIsDeleted = paramBoolean;
/*  60 */     this.mDeleteTime = paramLong4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/*  71 */     return this.mFileType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getApplicationType() {
/*  80 */     return this.mApplicationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  90 */     return this.mName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 100 */     return this.mSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 110 */     return this.mWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 120 */     return this.mHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMd5() {
/* 130 */     return this.mMD5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLongitude() {
/* 140 */     return this.mLongitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLatitude() {
/* 150 */     return this.mLatitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTicktime() {
/* 160 */     return this.mTicktime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Uri getFileUri() {
/* 170 */     return this.mFileUri;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Uri getThumbnail() {
/* 180 */     return this.mThumbnail;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDuration() {
/* 191 */     return this.mDuration;
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
/*     */   public boolean isDeleted() {
/* 203 */     return this.mIsDeleted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getDeleteTime() {
/* 214 */     return this.mDeleteTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 219 */     null = true; if (this == paramObject) return true; 
/* 220 */     if (paramObject == null || getClass() != paramObject.getClass()) return false; 
/* 221 */     paramObject = paramObject;
/* 222 */     if (this.mFileType == ((DvrForPFile)paramObject).mFileType && this.mApplicationType == ((DvrForPFile)paramObject).mApplicationType && this.mSize == ((DvrForPFile)paramObject).mSize && this.mWidth == ((DvrForPFile)paramObject).mWidth && this.mHeight == ((DvrForPFile)paramObject).mHeight) { double d1 = ((DvrForPFile)paramObject).mLongitude, d2 = this.mLongitude;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       if (Double.compare(d1, d2) == 0) { d2 = ((DvrForPFile)paramObject).mLatitude; d1 = this.mLatitude;
/* 228 */         if (Double.compare(d2, d1) == 0 && this.mTicktime == ((DvrForPFile)paramObject).mTicktime && this.mDuration == ((DvrForPFile)paramObject).mDuration && this.mIsDeleted == ((DvrForPFile)paramObject).mIsDeleted && this.mDeleteTime == ((DvrForPFile)paramObject).mDeleteTime && this.mIsDvrFileLocked == ((DvrForPFile)paramObject).mIsDvrFileLocked) { String str1 = this.mId, str2 = ((DvrForPFile)paramObject).mId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 234 */           if (Objects.equals(str1, str2)) { str1 = this.mName; str2 = ((DvrForPFile)paramObject).mName;
/* 235 */             if (Objects.equals(str1, str2)) { str1 = this.mMD5; str2 = ((DvrForPFile)paramObject).mMD5;
/* 236 */               if (Objects.equals(str1, str2)) { Uri uri1 = this.mFileUri, uri2 = ((DvrForPFile)paramObject).mFileUri;
/* 237 */                 if (Objects.equals(uri1, uri2)) { uri1 = this.mThumbnail; paramObject = ((DvrForPFile)paramObject).mThumbnail;
/* 238 */                   if (Objects.equals(uri1, paramObject))
/*     */                     return null;  }  }  }  }
/*     */            }
/*     */          }
/*     */        }
/* 243 */      return false; } public int hashCode() { int i = this.mFileType, k = this.mApplicationType; String str2 = this.mId, str1 = this.mName; long l3 = this.mSize; int m = this.mWidth, j = this.mHeight; String str3 = this.mMD5; double d2 = this.mLongitude;
/* 244 */     double d1 = this.mLatitude; long l1 = this.mTicktime; Uri uri2 = this.mFileUri, uri1 = this.mThumbnail; long l4 = this.mDuration; boolean bool2 = this.mIsDeleted; long l2 = this.mDeleteTime;
/* 245 */     boolean bool1 = this.mIsDvrFileLocked;
/*     */     return Objects.hash(new Object[] { 
/*     */           Integer.valueOf(i), Integer.valueOf(k), str2, str1, Long.valueOf(l3), Integer.valueOf(m), Integer.valueOf(j), str3, Double.valueOf(d2), Double.valueOf(d1), 
/*     */           Long.valueOf(l1), uri2, uri1, Long.valueOf(l4), Boolean.valueOf(bool2), Long.valueOf(l2), Boolean.valueOf(bool1) }); }
/*     */    public String toString() {
/* 250 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DvrForPFile{mName='"); stringBuilder.append(this.mName); stringBuilder.append('\''); stringBuilder.append('}'); return stringBuilder.toString();
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
/*     */   @VendorDefinition(author = "@ECARX", date = "2020-12-11", project = "ALL", requirement = "")
/*     */   public boolean isDvrFileLocked() {
/* 266 */     return this.mIsDvrFileLocked;
/*     */   }
/*     */   
/*     */   public String getId() {
/* 270 */     return this.mId;
/*     */   }
/*     */   
/*     */   public void setId(String paramString) {
/* 274 */     this.mId = paramString;
/*     */   }
/*     */   
/*     */   public void setFileType(int paramInt) {
/* 278 */     this.mFileType = paramInt;
/*     */   }
/*     */   
/*     */   public void setIsDeleted(boolean paramBoolean) {
/* 282 */     this.mIsDeleted = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setDeleteTime(long paramLong) {
/* 286 */     this.mDeleteTime = paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\forp\DvrForPFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */