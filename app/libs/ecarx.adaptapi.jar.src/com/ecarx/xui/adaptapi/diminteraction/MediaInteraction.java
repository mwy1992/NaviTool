/*    */ package com.ecarx.xui.adaptapi.diminteraction;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.os.Bundle;
/*    */ import com.ecarx.xui.adaptapi.AbsCarSignal;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MediaInteraction
/*    */   extends AbsCarSignal
/*    */   implements IMediaInteraction
/*    */ {
/*    */   private static final String TAG = "MediaInteraction";
/*    */   
/*    */   protected MediaInteraction(Context paramContext) {
/* 17 */     super(paramContext);
/*    */   }
/*    */   
/*    */   public void updateMediaSourceTypeList(int[] paramArrayOfint) {}
/*    */   
/*    */   public void updateCurrentSourceType(int paramInt) {}
/*    */   
/*    */   public void updatePlaylist(int paramInt, List<IMediaInteraction.IMedia> paramList) {}
/*    */   
/*    */   public void updatePlaybackInfo(IMediaInteraction.IPlaybackInfo paramIPlaybackInfo) {}
/*    */   
/*    */   public void updateCurrentProgress(long paramLong) {}
/*    */   
/*    */   public void updateMediaMuteState(int paramInt) {}
/*    */   
/*    */   public void setMediaInteractionCallback(IMediaInteraction.IMediaInteractionCallback paramIMediaInteractionCallback) {}
/*    */   
/*    */   public void unsetMediaInteractionCallback(IMediaInteraction.IMediaInteractionCallback paramIMediaInteractionCallback) {}
/*    */   
/*    */   public void updateExtensionInfo(Bundle paramBundle) {}
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\MediaInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */