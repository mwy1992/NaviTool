/*     */ package android.car.storagemonitoring;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.Objects;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public final class IoStatsEntry
/*     */   implements Parcelable
/*     */ {
/*  38 */   public static final Parcelable.Creator<IoStatsEntry> CREATOR = new Parcelable.Creator<IoStatsEntry>()
/*     */     {
/*     */       public IoStatsEntry createFromParcel(Parcel param1Parcel) {
/*  41 */         return new IoStatsEntry(param1Parcel);
/*     */       }
/*     */       
/*     */       public IoStatsEntry[] newArray(int param1Int) {
/*  45 */         return new IoStatsEntry[param1Int];
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Metrics background;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Metrics foreground;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long runtimeMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int uid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IoStatsEntry(int paramInt, long paramLong, Metrics paramMetrics1, Metrics paramMetrics2) {
/*  78 */     this.uid = paramInt;
/*  79 */     this.runtimeMillis = paramLong;
/*  80 */     this.foreground = Objects.<Metrics>requireNonNull(paramMetrics1);
/*  81 */     this.background = Objects.<Metrics>requireNonNull(paramMetrics2);
/*     */   }
/*     */   
/*     */   public IoStatsEntry(Parcel paramParcel) {
/*  85 */     this.uid = paramParcel.readInt();
/*  86 */     this.runtimeMillis = paramParcel.readLong();
/*  87 */     this.foreground = (Metrics)paramParcel.readParcelable(Metrics.class.getClassLoader());
/*  88 */     this.background = (Metrics)paramParcel.readParcelable(Metrics.class.getClassLoader());
/*     */   }
/*     */   
/*     */   public IoStatsEntry(UidIoRecord paramUidIoRecord, long paramLong) {
/*  92 */     this.uid = paramUidIoRecord.uid;
/*  93 */     this.runtimeMillis = paramLong;
/*  94 */     this.foreground = new Metrics(paramUidIoRecord.foreground_rchar, paramUidIoRecord.foreground_wchar, paramUidIoRecord.foreground_read_bytes, paramUidIoRecord.foreground_write_bytes, paramUidIoRecord.foreground_fsync);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     this.background = new Metrics(paramUidIoRecord.background_rchar, paramUidIoRecord.background_wchar, paramUidIoRecord.background_read_bytes, paramUidIoRecord.background_write_bytes, paramUidIoRecord.background_fsync);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 108 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 113 */     paramParcel.writeInt(this.uid);
/* 114 */     paramParcel.writeLong(this.runtimeMillis);
/* 115 */     paramParcel.writeParcelable(this.foreground, paramInt);
/* 116 */     paramParcel.writeParcelable(this.background, paramInt);
/*     */   }
/*     */   
/*     */   public void writeToJson(JsonWriter paramJsonWriter) throws IOException {
/* 120 */     paramJsonWriter.beginObject();
/* 121 */     paramJsonWriter.name("uid").value(this.uid);
/* 122 */     paramJsonWriter.name("runtimeMillis").value(this.runtimeMillis);
/* 123 */     paramJsonWriter.name("foreground"); this.foreground.writeToJson(paramJsonWriter);
/* 124 */     paramJsonWriter.name("background"); this.background.writeToJson(paramJsonWriter);
/* 125 */     paramJsonWriter.endObject();
/*     */   }
/*     */   
/*     */   public IoStatsEntry(JSONObject paramJSONObject) throws JSONException {
/* 129 */     this.uid = paramJSONObject.getInt("uid");
/* 130 */     this.runtimeMillis = paramJSONObject.getLong("runtimeMillis");
/* 131 */     this.foreground = new Metrics(paramJSONObject.getJSONObject("foreground"));
/* 132 */     this.background = new Metrics(paramJSONObject.getJSONObject("background"));
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
/*     */   public IoStatsEntry delta(IoStatsEntry paramIoStatsEntry) {
/* 145 */     if (this.uid == paramIoStatsEntry.uid) {
/*     */ 
/*     */       
/* 148 */       int i = this.uid; long l1 = this.runtimeMillis, l2 = paramIoStatsEntry.runtimeMillis; Metrics metrics2 = this.foreground, metrics1 = paramIoStatsEntry.foreground; return 
/*     */         
/* 150 */         new IoStatsEntry(i, l1 - l2, metrics2.delta(metrics1), this.background.delta(paramIoStatsEntry.background));
/*     */     } 
/*     */     throw new IllegalArgumentException("cannot calculate delta between different user IDs");
/*     */   }
/*     */   public boolean equals(Object paramObject) {
/* 155 */     boolean bool = paramObject instanceof IoStatsEntry; boolean bool1 = false; if (bool) {
/* 156 */       paramObject = paramObject;
/*     */       
/* 158 */       bool = bool1; if (this.uid == ((IoStatsEntry)paramObject).uid) { bool = bool1; if (this.runtimeMillis == ((IoStatsEntry)paramObject).runtimeMillis) { Metrics metrics2 = this.foreground, metrics1 = ((IoStatsEntry)paramObject).foreground;
/*     */           
/* 160 */           bool = bool1; if (metrics2.equals(metrics1)) { metrics1 = this.background; paramObject = ((IoStatsEntry)paramObject).background;
/* 161 */             bool = bool1; if (metrics1.equals(paramObject)) bool = true;  }  }
/*     */          }
/*     */        return bool;
/* 164 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 169 */     return Objects.hash(new Object[] { Integer.valueOf(this.uid), Long.valueOf(this.runtimeMillis), this.foreground, this.background });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     int i = this.uid;
/* 175 */     long l = this.runtimeMillis; Metrics metrics1 = this.foreground, metrics2 = this.background;
/*     */     return String.format("uid = %d, runtime = %d, foreground = %s, background = %s", new Object[] { Integer.valueOf(i), Long.valueOf(l), metrics1, metrics2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean representsSameMetrics(UidIoRecord paramUidIoRecord) {
/*     */     boolean bool;
/* 185 */     if (paramUidIoRecord.uid == this.uid && paramUidIoRecord.foreground_rchar == this.foreground.bytesRead && paramUidIoRecord.foreground_wchar == this.foreground.bytesWritten && paramUidIoRecord.foreground_read_bytes == this.foreground.bytesReadFromStorage && paramUidIoRecord.foreground_write_bytes == this.foreground.bytesWrittenToStorage && paramUidIoRecord.foreground_fsync == this.foreground.fsyncCalls && paramUidIoRecord.background_rchar == this.background.bytesRead && paramUidIoRecord.background_wchar == this.background.bytesWritten && paramUidIoRecord.background_read_bytes == this.background.bytesReadFromStorage && paramUidIoRecord.background_write_bytes == this.background.bytesWrittenToStorage && paramUidIoRecord.background_fsync == this.background.fsyncCalls) { bool = true; } else { bool = false; }  return bool;
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
/*     */   public static final class Metrics
/*     */     implements Parcelable
/*     */   {
/* 203 */     public static final Parcelable.Creator<Metrics> CREATOR = new Parcelable.Creator<Metrics>()
/*     */       {
/*     */         public IoStatsEntry.Metrics createFromParcel(Parcel param2Parcel) {
/* 206 */           return new IoStatsEntry.Metrics(param2Parcel);
/*     */         }
/*     */         
/*     */         public IoStatsEntry.Metrics[] newArray(int param2Int) {
/* 210 */           return new IoStatsEntry.Metrics[param2Int];
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final long bytesRead;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final long bytesReadFromStorage;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final long bytesWritten;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final long bytesWrittenToStorage;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final long fsyncCalls;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Metrics(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5) {
/* 245 */       this.bytesRead = param1Long1;
/* 246 */       this.bytesWritten = param1Long2;
/* 247 */       this.bytesReadFromStorage = param1Long3;
/* 248 */       this.bytesWrittenToStorage = param1Long4;
/* 249 */       this.fsyncCalls = param1Long5;
/*     */     }
/*     */ 
/*     */     
/*     */     public int describeContents() {
/* 254 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeToParcel(Parcel param1Parcel, int param1Int) {
/* 259 */       param1Parcel.writeLong(this.bytesRead);
/* 260 */       param1Parcel.writeLong(this.bytesWritten);
/* 261 */       param1Parcel.writeLong(this.bytesReadFromStorage);
/* 262 */       param1Parcel.writeLong(this.bytesWrittenToStorage);
/* 263 */       param1Parcel.writeLong(this.fsyncCalls);
/*     */     }
/*     */     
/*     */     public void writeToJson(JsonWriter param1JsonWriter) throws IOException {
/* 267 */       param1JsonWriter.beginObject();
/* 268 */       param1JsonWriter.name("bytesRead").value(this.bytesRead);
/* 269 */       param1JsonWriter.name("bytesWritten").value(this.bytesWritten);
/* 270 */       param1JsonWriter.name("bytesReadFromStorage").value(this.bytesReadFromStorage);
/* 271 */       param1JsonWriter.name("bytesWrittenToStorage").value(this.bytesWrittenToStorage);
/* 272 */       param1JsonWriter.name("fsyncCalls").value(this.fsyncCalls);
/* 273 */       param1JsonWriter.endObject();
/*     */     }
/*     */     
/*     */     public Metrics(Parcel param1Parcel) {
/* 277 */       this.bytesRead = param1Parcel.readLong();
/* 278 */       this.bytesWritten = param1Parcel.readLong();
/* 279 */       this.bytesReadFromStorage = param1Parcel.readLong();
/* 280 */       this.bytesWrittenToStorage = param1Parcel.readLong();
/* 281 */       this.fsyncCalls = param1Parcel.readLong();
/*     */     }
/*     */     
/*     */     public Metrics(JSONObject param1JSONObject) throws JSONException {
/* 285 */       this.bytesRead = param1JSONObject.getLong("bytesRead");
/* 286 */       this.bytesWritten = param1JSONObject.getLong("bytesWritten");
/* 287 */       this.bytesReadFromStorage = param1JSONObject.getLong("bytesReadFromStorage");
/* 288 */       this.bytesWrittenToStorage = param1JSONObject.getLong("bytesWrittenToStorage");
/* 289 */       this.fsyncCalls = param1JSONObject.getLong("fsyncCalls");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Metrics delta(Metrics param1Metrics) {
/* 302 */       return new Metrics(this.bytesRead - param1Metrics.bytesRead, this.bytesWritten - param1Metrics.bytesWritten, this.bytesReadFromStorage - param1Metrics.bytesReadFromStorage, this.bytesWrittenToStorage - param1Metrics.bytesWrittenToStorage, this.fsyncCalls - param1Metrics.fsyncCalls);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 311 */       boolean bool = param1Object instanceof Metrics; boolean bool1 = false; if (bool) {
/* 312 */         param1Object = param1Object;
/*     */         
/* 314 */         bool = bool1; if (this.bytesRead == ((Metrics)param1Object).bytesRead) { bool = bool1; if (this.bytesWritten == ((Metrics)param1Object).bytesWritten) { bool = bool1; if (this.bytesReadFromStorage == ((Metrics)param1Object).bytesReadFromStorage) { bool = bool1; if (this.bytesWrittenToStorage == ((Metrics)param1Object).bytesWrittenToStorage) { bool = bool1; if (this.fsyncCalls == ((Metrics)param1Object).fsyncCalls) bool = true;  }  }  }  }  return bool;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 320 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 325 */       long l2 = this.bytesRead, l5 = this.bytesWritten, l1 = this.bytesReadFromStorage, l3 = this.bytesWrittenToStorage;
/* 326 */       long l4 = this.fsyncCalls;
/*     */       return Objects.hash(new Object[] { Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4) });
/*     */     }
/*     */     
/*     */     public String toString() {
/* 331 */       long l2 = this.bytesRead;
/* 332 */       long l3 = this.bytesWritten, l4 = this.bytesReadFromStorage, l1 = this.bytesWrittenToStorage, l5 = this.fsyncCalls;
/*     */       return String.format("bytesRead=%d, bytesWritten=%d, bytesReadFromStorage=%d, bytesWrittenToStorage=%d, fsyncCalls=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l1), Long.valueOf(l5) });
/*     */     }
/*     */   }
/*     */   
/*     */   class null implements Parcelable.Creator<Metrics> {
/*     */     public IoStatsEntry.Metrics createFromParcel(Parcel param1Parcel) {
/*     */       return new IoStatsEntry.Metrics(param1Parcel);
/*     */     }
/*     */     
/*     */     public IoStatsEntry.Metrics[] newArray(int param1Int) {
/*     */       return new IoStatsEntry.Metrics[param1Int];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\IoStatsEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */