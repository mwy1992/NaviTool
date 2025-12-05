/*     */ package android.car.vms;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
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
/*     */ public final class VmsAvailableLayers
/*     */   implements Parcelable
/*     */ {
/*     */   public VmsAvailableLayers(Set<VmsAssociatedLayer> paramSet, int paramInt) {
/*  47 */     this.mSeq = paramInt;
/*     */     
/*  49 */     this.mAssociatedLayers = Collections.unmodifiableSet(paramSet);
/*     */   }
/*     */   
/*     */   public int getSequence() {
/*  53 */     return this.mSeq;
/*     */   }
/*     */   
/*     */   public Set<VmsAssociatedLayer> getAssociatedLayers() {
/*  57 */     return this.mAssociatedLayers;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  62 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("VmsAvailableLayers{ seq: "); stringBuilder.append(this.mSeq); stringBuilder.append(", AssociatedLayers: "); stringBuilder.append(this.mAssociatedLayers); stringBuilder.append("}"); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   public static final Parcelable.Creator<VmsAvailableLayers> CREATOR = new Parcelable.Creator<VmsAvailableLayers>()
/*     */     {
/*     */       public VmsAvailableLayers createFromParcel(Parcel param1Parcel) {
/*  74 */         return new VmsAvailableLayers(param1Parcel);
/*     */       }
/*     */       
/*     */       public VmsAvailableLayers[] newArray(int param1Int) {
/*  78 */         return new VmsAvailableLayers[param1Int];
/*     */       }
/*     */     };
/*     */   private final Set<VmsAssociatedLayer> mAssociatedLayers;
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  84 */     paramParcel.writeInt(this.mSeq);
/*  85 */     paramParcel.writeParcelableList(new ArrayList<>(this.mAssociatedLayers), paramInt);
/*     */   }
/*     */   private final int mSeq;
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  90 */     boolean bool = paramObject instanceof VmsAvailableLayers; boolean bool1 = false; if (!bool) {
/*  91 */       return false;
/*     */     }
/*  93 */     paramObject = paramObject;
/*  94 */     bool = bool1; if (Objects.equals(((VmsAvailableLayers)paramObject).mAssociatedLayers, this.mAssociatedLayers)) { bool = bool1; if (((VmsAvailableLayers)paramObject).mSeq == this.mSeq) bool = true;  }  return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 100 */     return 0;
/*     */   }
/*     */   
/*     */   private VmsAvailableLayers(Parcel paramParcel) {
/* 104 */     this.mSeq = paramParcel.readInt();
/*     */     
/* 106 */     ArrayList<? extends VmsAssociatedLayer> arrayList = new ArrayList();
/* 107 */     paramParcel.readParcelableList(arrayList, VmsAssociatedLayer.class.getClassLoader());
/* 108 */     this.mAssociatedLayers = Collections.unmodifiableSet(new HashSet<>(arrayList));
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsAvailableLayers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */