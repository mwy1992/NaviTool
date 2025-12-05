/*     */ package android.car.storagemonitoring;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.StringJoiner;
/*     */ import org.json.JSONArray;
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
/*     */ @SystemApi
/*     */ public class IoStats
/*     */   implements Parcelable
/*     */ {
/*  39 */   public static final Parcelable.Creator<IoStats> CREATOR = new Parcelable.Creator<IoStats>()
/*     */     {
/*     */       public IoStats createFromParcel(Parcel param1Parcel) {
/*  42 */         return new IoStats(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public IoStats[] newArray(int param1Int) {
/*  47 */         return new IoStats[param1Int];
/*     */       }
/*     */     };
/*     */   
/*     */   private final List<IoStatsEntry> mStats;
/*     */   private final long mUptimeTimestamp;
/*     */   
/*     */   public IoStats(List<IoStatsEntry> paramList, long paramLong) {
/*  55 */     this.mStats = paramList;
/*  56 */     this.mUptimeTimestamp = paramLong;
/*     */   }
/*     */   
/*     */   public IoStats(Parcel paramParcel) {
/*  60 */     this.mStats = paramParcel.createTypedArrayList(IoStatsEntry.CREATOR);
/*  61 */     this.mUptimeTimestamp = paramParcel.readLong();
/*     */   }
/*     */   
/*     */   public IoStats(JSONObject paramJSONObject) throws JSONException {
/*  65 */     this.mUptimeTimestamp = paramJSONObject.getInt("uptime");
/*  66 */     JSONArray jSONArray = paramJSONObject.getJSONArray("stats");
/*  67 */     this.mStats = new ArrayList<>();
/*  68 */     for (byte b = 0; b < jSONArray.length(); b++) {
/*  69 */       this.mStats.add(new IoStatsEntry(jSONArray.getJSONObject(b)));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  75 */     paramParcel.writeTypedList(this.mStats);
/*  76 */     paramParcel.writeLong(this.mUptimeTimestamp);
/*     */   }
/*     */   
/*     */   public void writeToJson(JsonWriter paramJsonWriter) throws IOException {
/*  80 */     paramJsonWriter.beginObject();
/*  81 */     paramJsonWriter.name("uptime").value(this.mUptimeTimestamp);
/*  82 */     paramJsonWriter.name("stats").beginArray();
/*  83 */     for (IoStatsEntry ioStatsEntry : this.mStats) {
/*  84 */       ioStatsEntry.writeToJson(paramJsonWriter);
/*     */     }
/*  86 */     paramJsonWriter.endArray();
/*  87 */     paramJsonWriter.endObject();
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  92 */     return 0;
/*     */   }
/*     */   
/*     */   public long getTimestamp() {
/*  96 */     return this.mUptimeTimestamp;
/*     */   }
/*     */   
/*     */   public List<IoStatsEntry> getStats() {
/* 100 */     return this.mStats;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return Objects.hash(new Object[] { this.mStats, Long.valueOf(this.mUptimeTimestamp) });
/*     */   }
/*     */   
/*     */   public IoStatsEntry getUserIdStats(int paramInt) {
/* 109 */     for (IoStatsEntry ioStatsEntry : getStats()) {
/* 110 */       if (ioStatsEntry.uid == paramInt) {
/* 111 */         return ioStatsEntry;
/*     */       }
/*     */     } 
/*     */     
/* 115 */     return null;
/*     */   }
/*     */   
/*     */   public IoStatsEntry.Metrics getForegroundTotals() {
/* 119 */     long l5 = 0L;
/* 120 */     long l4 = 0L;
/* 121 */     long l3 = 0L;
/* 122 */     long l2 = 0L;
/* 123 */     long l1 = 0L;
/*     */     
/* 125 */     for (IoStatsEntry ioStatsEntry : getStats()) {
/* 126 */       l5 += ioStatsEntry.foreground.bytesRead;
/* 127 */       l4 += ioStatsEntry.foreground.bytesWritten;
/* 128 */       l3 += ioStatsEntry.foreground.bytesReadFromStorage;
/* 129 */       l2 += ioStatsEntry.foreground.bytesWrittenToStorage;
/* 130 */       l1 += ioStatsEntry.foreground.fsyncCalls;
/*     */     } 
/*     */     
/* 133 */     return new IoStatsEntry.Metrics(l5, l4, l3, l2, l1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IoStatsEntry.Metrics getBackgroundTotals() {
/* 141 */     long l5 = 0L;
/* 142 */     long l4 = 0L;
/* 143 */     long l3 = 0L;
/* 144 */     long l2 = 0L;
/* 145 */     long l1 = 0L;
/*     */     
/* 147 */     for (IoStatsEntry ioStatsEntry : getStats()) {
/* 148 */       l5 += ioStatsEntry.background.bytesRead;
/* 149 */       l4 += ioStatsEntry.background.bytesWritten;
/* 150 */       l3 += ioStatsEntry.background.bytesReadFromStorage;
/* 151 */       l2 += ioStatsEntry.background.bytesWrittenToStorage;
/* 152 */       l1 += ioStatsEntry.background.fsyncCalls;
/*     */     } 
/*     */     
/* 155 */     return new IoStatsEntry.Metrics(l5, l4, l3, l2, l1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IoStatsEntry.Metrics getTotals() {
/* 163 */     IoStatsEntry.Metrics metrics1 = getForegroundTotals();
/* 164 */     IoStatsEntry.Metrics metrics2 = getBackgroundTotals();
/*     */     
/* 166 */     long l5 = metrics1.bytesRead, l3 = metrics2.bytesRead, l6 = metrics1.bytesWritten, l8 = metrics2.bytesWritten, l4 = metrics1.bytesReadFromStorage, l1 = metrics2.bytesReadFromStorage, l9 = metrics1.bytesWrittenToStorage, l2 = metrics2.bytesWrittenToStorage, l7 = metrics1.fsyncCalls; return new IoStatsEntry.Metrics(l3 + l5, l8 + l6, l1 + l4, l2 + l9, metrics2.fsyncCalls + l7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 175 */     boolean bool = paramObject instanceof IoStats; boolean bool1 = false; if (bool) {
/* 176 */       paramObject = paramObject;
/* 177 */       bool = bool1; if (paramObject.getTimestamp() == getTimestamp()) {
/* 178 */         bool = bool1; if (paramObject.getStats().equals(getStats())) bool = true; 
/*     */       }  return bool;
/* 180 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringJoiner stringJoiner = new StringJoiner(", ");
/* 186 */     for (IoStatsEntry ioStatsEntry : getStats()) {
/* 187 */       stringJoiner.add(ioStatsEntry.toString());
/*     */     }
/* 189 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("timestamp = "); stringBuilder.append(getTimestamp()); stringBuilder.append(", stats = "); stringBuilder.append(stringJoiner.toString()); return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\IoStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */