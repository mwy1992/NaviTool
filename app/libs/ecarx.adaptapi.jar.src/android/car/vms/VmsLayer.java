/*     */ package android.car.vms;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
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
/*     */ public final class VmsLayer
/*     */   implements Parcelable
/*     */ {
/*     */   public VmsLayer(int paramInt1, int paramInt2, int paramInt3) {
/*  43 */     this.mType = paramInt1;
/*  44 */     this.mSubtype = paramInt2;
/*  45 */     this.mVersion = paramInt3;
/*     */   }
/*     */   
/*     */   public int getType() {
/*  49 */     return this.mType;
/*     */   }
/*     */   
/*     */   public int getSubtype() {
/*  53 */     return this.mSubtype;
/*     */   }
/*     */   
/*     */   public int getVersion() {
/*  57 */     return this.mVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  68 */     boolean bool = paramObject instanceof VmsLayer; boolean bool1 = false; if (!bool) {
/*  69 */       return false;
/*     */     }
/*  71 */     paramObject = paramObject;
/*  72 */     bool = bool1; if (Objects.equals(Integer.valueOf(((VmsLayer)paramObject).mType), Integer.valueOf(this.mType))) { int i = ((VmsLayer)paramObject).mSubtype;
/*  73 */       bool = bool1; if (Objects.equals(Integer.valueOf(i), Integer.valueOf(this.mSubtype))) { i = ((VmsLayer)paramObject).mVersion;
/*  74 */         bool = bool1; if (Objects.equals(Integer.valueOf(i), Integer.valueOf(this.mVersion))) bool = true;
/*     */          }
/*     */        }
/*     */     
/*     */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  84 */     return Objects.hash(new Object[] { Integer.valueOf(this.mType), Integer.valueOf(this.mSubtype), Integer.valueOf(this.mVersion) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("VmsLayer{ Type: "); stringBuilder.append(this.mType); stringBuilder.append(", Sub type: "); stringBuilder.append(this.mSubtype); stringBuilder.append(", Version: "); stringBuilder.append(this.mVersion); stringBuilder.append("}"); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  94 */   public static final Parcelable.Creator<VmsLayer> CREATOR = new Parcelable.Creator<VmsLayer>()
/*     */     {
/*     */       public VmsLayer createFromParcel(Parcel param1Parcel) {
/*  97 */         return new VmsLayer(param1Parcel);
/*     */       }
/*     */       
/*     */       public VmsLayer[] newArray(int param1Int) {
/* 101 */         return new VmsLayer[param1Int];
/*     */       }
/*     */     };
/*     */   private int mSubtype;
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 107 */     paramParcel.writeInt(this.mType);
/* 108 */     paramParcel.writeInt(this.mSubtype);
/* 109 */     paramParcel.writeInt(this.mVersion);
/*     */   }
/*     */   private int mType; private int mVersion;
/*     */   
/*     */   public int describeContents() {
/* 114 */     return 0;
/*     */   }
/*     */   
/*     */   private VmsLayer(Parcel paramParcel) {
/* 118 */     readFromParcel(paramParcel);
/*     */   }
/*     */   
/*     */   private void readFromParcel(Parcel paramParcel) {
/* 122 */     this.mType = paramParcel.readInt();
/* 123 */     this.mSubtype = paramParcel.readInt();
/* 124 */     this.mVersion = paramParcel.readInt();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */