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
/*     */ @SystemApi
/*     */ public class LifetimeWriteInfo
/*     */   implements Parcelable
/*     */ {
/*  34 */   public static final Parcelable.Creator<IoStats> CREATOR = new Parcelable.Creator<IoStats>()
/*     */     {
/*     */       public IoStats createFromParcel(Parcel param1Parcel) {
/*  37 */         return new IoStats(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public IoStats[] newArray(int param1Int) {
/*  42 */         return new IoStats[param1Int];
/*     */       }
/*     */     };
/*     */   
/*     */   public final String fstype;
/*     */   public final String partition;
/*     */   public final long writtenBytes;
/*     */   
/*     */   public LifetimeWriteInfo(String paramString1, String paramString2, long paramLong) {
/*  51 */     this.partition = Objects.<String>requireNonNull(paramString1);
/*  52 */     this.fstype = Objects.<String>requireNonNull(paramString2);
/*  53 */     if (paramLong >= 0L) {
/*     */ 
/*     */       
/*  56 */       this.writtenBytes = paramLong;
/*     */       return;
/*     */     } 
/*     */     throw new IllegalArgumentException("writtenBytes must be non-negative"); } public LifetimeWriteInfo(Parcel paramParcel) {
/*  60 */     this.partition = paramParcel.readString();
/*  61 */     this.fstype = paramParcel.readString();
/*  62 */     this.writtenBytes = paramParcel.readLong();
/*     */   }
/*     */   
/*     */   public LifetimeWriteInfo(JSONObject paramJSONObject) throws JSONException {
/*  66 */     this.partition = paramJSONObject.getString("partition");
/*  67 */     this.fstype = paramJSONObject.getString("fstype");
/*  68 */     this.writtenBytes = paramJSONObject.getLong("writtenBytes");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  74 */     paramParcel.writeString(this.partition);
/*  75 */     paramParcel.writeString(this.fstype);
/*  76 */     paramParcel.writeLong(this.writtenBytes);
/*     */   }
/*     */   
/*     */   public void writeToJson(JsonWriter paramJsonWriter) throws IOException {
/*  80 */     paramJsonWriter.beginObject();
/*  81 */     paramJsonWriter.name("partition").value(this.partition);
/*  82 */     paramJsonWriter.name("fstype").value(this.fstype);
/*  83 */     paramJsonWriter.name("writtenBytes").value(this.writtenBytes);
/*  84 */     paramJsonWriter.endObject();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  90 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  95 */     boolean bool = paramObject instanceof LifetimeWriteInfo; boolean bool1 = false; if (bool) {
/*  96 */       LifetimeWriteInfo lifetimeWriteInfo = (LifetimeWriteInfo)paramObject;
/*  97 */       bool = bool1; if (this.partition.equals(lifetimeWriteInfo.partition)) { paramObject = this.fstype; String str = lifetimeWriteInfo.fstype;
/*  98 */         bool = bool1; if (paramObject.equals(str)) { bool = bool1; if (this.writtenBytes == lifetimeWriteInfo.writtenBytes) bool = true;  }
/*     */          }
/*     */        return bool;
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 107 */     String str1 = this.partition, str2 = this.fstype; long l = this.writtenBytes; return String.format("for partition %s of type %s, %d bytes were written", new Object[] { str1, str2, Long.valueOf(l) });
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\LifetimeWriteInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */