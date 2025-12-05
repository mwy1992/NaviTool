/*    */ package com.ecarx.xui.adaptapi.dvr;
/*    */ 
/*    */ import android.graphics.Bitmap;
/*    */ import java.io.File;
/*    */ 
/*    */ public class DvrVideoFile
/*    */   extends DvrFile
/*    */   implements IDvrVideoFile {
/*    */   public DvrVideoFile(String paramString, int paramInt) {
/* 10 */     this(paramString, null, null, false, false, false, false, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public DvrVideoFile(String paramString, Bitmap paramBitmap, File paramFile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt) {
/* 15 */     super(paramString, paramBitmap, paramFile, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDuration() {
/* 24 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\DvrVideoFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */