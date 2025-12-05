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
/*     */ @SystemApi
/*     */ public final class VmsLayerDependency
/*     */   implements Parcelable
/*     */ {
/*     */   public VmsLayerDependency(VmsLayer paramVmsLayer, Set<VmsLayer> paramSet) {
/*  45 */     this.mLayer = paramVmsLayer;
/*  46 */     this.mDependency = Collections.unmodifiableSet(paramSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VmsLayerDependency(VmsLayer paramVmsLayer) {
/*  53 */     this.mLayer = paramVmsLayer;
/*  54 */     this.mDependency = Collections.emptySet();
/*     */   }
/*     */   
/*     */   public VmsLayer getLayer() {
/*  58 */     return this.mLayer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<VmsLayer> getDependencies() {
/*  65 */     return this.mDependency;
/*     */   }
/*     */   
/*  68 */   public static final Parcelable.Creator<VmsLayerDependency> CREATOR = new Parcelable.Creator<VmsLayerDependency>()
/*     */     {
/*     */       public VmsLayerDependency createFromParcel(Parcel param1Parcel) {
/*  71 */         return new VmsLayerDependency(param1Parcel);
/*     */       }
/*     */       
/*     */       public VmsLayerDependency[] newArray(int param1Int) {
/*  75 */         return new VmsLayerDependency[param1Int];
/*     */       }
/*     */     };
/*     */   private final Set<VmsLayer> mDependency;
/*     */   public String toString() {
/*  80 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("VmsLayerDependency{ Layer: "); stringBuilder.append(this.mLayer); stringBuilder.append(" Dependency: "); stringBuilder.append(this.mDependency); stringBuilder.append("}"); return stringBuilder.toString();
/*     */   }
/*     */   private final VmsLayer mLayer;
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  85 */     boolean bool = paramObject instanceof VmsLayerDependency; boolean bool1 = false; if (!bool) {
/*  86 */       return false;
/*     */     }
/*  88 */     paramObject = paramObject;
/*  89 */     bool = bool1; if (Objects.equals(((VmsLayerDependency)paramObject).mLayer, this.mLayer)) { bool = bool1; if (((VmsLayerDependency)paramObject).mDependency.equals(this.mDependency)) bool = true;  }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  94 */     return Objects.hash(new Object[] { this.mLayer, this.mDependency });
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  99 */     paramParcel.writeParcelable(this.mLayer, paramInt);
/* 100 */     paramParcel.writeParcelableList(new ArrayList<>(this.mDependency), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 105 */     return 0;
/*     */   }
/*     */   
/*     */   private VmsLayerDependency(Parcel paramParcel) {
/* 109 */     this.mLayer = (VmsLayer)paramParcel.readParcelable(VmsLayer.class.getClassLoader());
/* 110 */     ArrayList<? extends VmsLayer> arrayList = new ArrayList();
/* 111 */     paramParcel.readParcelableList(arrayList, VmsLayer.class.getClassLoader());
/* 112 */     this.mDependency = Collections.unmodifiableSet(new HashSet<>(arrayList));
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsLayerDependency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */