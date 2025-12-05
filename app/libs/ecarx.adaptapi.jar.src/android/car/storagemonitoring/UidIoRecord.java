/*    */ package android.car.storagemonitoring;
/*    */ 
/*    */ import android.annotation.SystemApi;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SystemApi
/*    */ public final class UidIoRecord
/*    */ {
/*    */   public final long background_fsync;
/*    */   public final long background_rchar;
/*    */   public final long background_read_bytes;
/*    */   public final long background_wchar;
/*    */   public final long background_write_bytes;
/*    */   public final long foreground_fsync;
/*    */   public final long foreground_rchar;
/*    */   public final long foreground_read_bytes;
/*    */   public final long foreground_wchar;
/*    */   public final long foreground_write_bytes;
/*    */   public final int uid;
/*    */   
/*    */   public UidIoRecord(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10) {
/* 53 */     this.uid = paramInt;
/*    */     
/* 55 */     this.foreground_rchar = paramLong1;
/* 56 */     this.foreground_wchar = paramLong2;
/* 57 */     this.foreground_read_bytes = paramLong3;
/* 58 */     this.foreground_write_bytes = paramLong4;
/* 59 */     this.foreground_fsync = paramLong5;
/*    */     
/* 61 */     this.background_rchar = paramLong6;
/* 62 */     this.background_wchar = paramLong7;
/* 63 */     this.background_read_bytes = paramLong8;
/* 64 */     this.background_write_bytes = paramLong9;
/* 65 */     this.background_fsync = paramLong10;
/*    */   }
/*    */ 
/*    */   
/*    */   public UidIoRecord delta(IoStatsEntry paramIoStatsEntry) {
/* 70 */     if (this.uid == paramIoStatsEntry.uid)
/*    */     {
/*    */ 
/*    */       
/* 74 */       return new UidIoRecord(this.uid, this.foreground_rchar - paramIoStatsEntry.foreground.bytesRead, this.foreground_wchar - paramIoStatsEntry.foreground.bytesWritten, this.foreground_read_bytes - paramIoStatsEntry.foreground.bytesReadFromStorage, this.foreground_write_bytes - paramIoStatsEntry.foreground.bytesWrittenToStorage, this.foreground_fsync - paramIoStatsEntry.foreground.fsyncCalls, this.background_rchar - paramIoStatsEntry.background.bytesRead, this.background_wchar - paramIoStatsEntry.background.bytesWritten, this.background_read_bytes - paramIoStatsEntry.background.bytesReadFromStorage, this.background_write_bytes - paramIoStatsEntry.background.bytesWrittenToStorage, this.background_fsync - paramIoStatsEntry.background.fsyncCalls);
/*    */     }
/*    */     throw new IllegalArgumentException("cannot calculate delta between different user IDs");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public UidIoRecord delta(UidIoRecord paramUidIoRecord) {
/* 89 */     if (this.uid == paramUidIoRecord.uid)
/*    */     {
/*    */ 
/*    */       
/* 93 */       return new UidIoRecord(this.uid, this.foreground_rchar - paramUidIoRecord.foreground_rchar, this.foreground_wchar - paramUidIoRecord.foreground_wchar, this.foreground_read_bytes - paramUidIoRecord.foreground_read_bytes, this.foreground_write_bytes - paramUidIoRecord.foreground_write_bytes, this.foreground_fsync - paramUidIoRecord.foreground_fsync, this.background_rchar - paramUidIoRecord.background_rchar, this.background_wchar - paramUidIoRecord.background_wchar, this.background_read_bytes - paramUidIoRecord.background_read_bytes, this.background_write_bytes - paramUidIoRecord.background_write_bytes, this.background_fsync - paramUidIoRecord.background_fsync);
/*    */     }
/*    */     throw new IllegalArgumentException("cannot calculate delta between different user IDs");
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\UidIoRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */