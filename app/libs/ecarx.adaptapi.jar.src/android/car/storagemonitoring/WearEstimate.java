/*     */ package android.car.storagemonitoring;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.JsonReader;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public class WearEstimate
/*     */   implements Parcelable
/*     */ {
/*     */   public static final Parcelable.Creator<WearEstimate> CREATOR;
/*     */   public static final int UNKNOWN = -1;
/*  45 */   public static final WearEstimate UNKNOWN_ESTIMATE = new WearEstimate(-1, -1); public final int typeA;
/*     */   static {
/*  47 */     CREATOR = new Parcelable.Creator<WearEstimate>()
/*     */       {
/*     */         public WearEstimate createFromParcel(Parcel param1Parcel) {
/*  50 */           return new WearEstimate(param1Parcel);
/*     */         }
/*     */         
/*     */         public WearEstimate[] newArray(int param1Int) {
/*  54 */           return new WearEstimate[param1Int];
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int typeB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int validateWearValue(int paramInt) {
/*  71 */     if (paramInt == -1) return paramInt; 
/*  72 */     if (paramInt >= 0 && paramInt <= 100) return paramInt; 
/*  73 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramInt); stringBuilder.append(" is not a valid wear estimate"); throw new IllegalArgumentException(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public WearEstimate(int paramInt1, int paramInt2) {
/*  77 */     this.typeA = validateWearValue(paramInt1);
/*  78 */     this.typeB = validateWearValue(paramInt2);
/*     */   }
/*     */   
/*     */   public WearEstimate(Parcel paramParcel) {
/*  82 */     this.typeA = validateWearValue(paramParcel.readInt());
/*  83 */     this.typeB = validateWearValue(paramParcel.readInt());
/*     */   }
/*     */   
/*     */   public WearEstimate(JsonReader paramJsonReader) throws IOException {
/*  87 */     int j = -1;
/*  88 */     int i = -1;
/*  89 */     paramJsonReader.beginObject();
/*  90 */     while (paramJsonReader.hasNext()) {
/*  91 */       switch (paramJsonReader.nextName()) {
/*     */         default:
/*     */           continue;
/*     */         
/*     */         case "wearEstimateTypeB":
/*  96 */           i = validateWearValue(paramJsonReader.nextInt()); continue;
/*     */         case "wearEstimateTypeA":
/*     */           break;
/*     */       }  j = validateWearValue(paramJsonReader.nextInt());
/* 100 */     }  paramJsonReader.endObject();
/* 101 */     this.typeA = j;
/* 102 */     this.typeB = i;
/*     */   }
/*     */ 
/*     */   
/*     */   public WearEstimate(JSONObject paramJSONObject) throws JSONException {
/* 107 */     this.typeA = paramJSONObject.getInt("wearEstimateTypeA");
/* 108 */     this.typeB = paramJSONObject.getInt("wearEstimateTypeB");
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 113 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 118 */     paramParcel.writeInt(this.typeA);
/* 119 */     paramParcel.writeInt(this.typeB);
/*     */   }
/*     */   
/*     */   public void writeToJson(JsonWriter paramJsonWriter) throws IOException {
/* 123 */     paramJsonWriter.beginObject();
/* 124 */     paramJsonWriter.name("wearEstimateTypeA").value(this.typeA);
/* 125 */     paramJsonWriter.name("wearEstimateTypeB").value(this.typeB);
/* 126 */     paramJsonWriter.endObject();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 131 */     boolean bool = paramObject instanceof WearEstimate; boolean bool1 = false; if (bool) {
/* 132 */       paramObject = paramObject;
/* 133 */       bool = bool1; if (((WearEstimate)paramObject).typeA == this.typeA) { bool = bool1; if (((WearEstimate)paramObject).typeB == this.typeB) bool = true;  }  return bool;
/*     */     } 
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 140 */     return Objects.hash(new Object[] { Integer.valueOf(this.typeA), Integer.valueOf(this.typeB) });
/*     */   }
/*     */   
/*     */   private static final String wearValueToString(int paramInt) {
/* 144 */     if (paramInt == -1) return "unknown"; 
/* 145 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramInt); stringBuilder.append("%"); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("type A: "); stringBuilder.append(wearValueToString(this.typeA)); stringBuilder.append(", type B: "); stringBuilder.append(wearValueToString(this.typeB)); return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\WearEstimate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */