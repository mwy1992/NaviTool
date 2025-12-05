/*    */ package com.ecarx.xui.adaptapi.dvr;
/*    */ 
/*    */ import android.graphics.Bitmap;
/*    */ import java.io.File;
/*    */ 
/*    */ public class DvrPhotoFile
/*    */   extends DvrFile
/*    */   implements IDvrPhotoFile {
/*    */   public DvrPhotoFile(String paramString) {
/* 10 */     this(paramString, null, null, false, false, false, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public DvrPhotoFile(String paramString, Bitmap paramBitmap, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 15 */     super(paramString, paramBitmap, paramFile, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, 4);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\DvrPhotoFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */