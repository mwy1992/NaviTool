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
/*     */ @SystemApi
/*     */ public final class VmsLayersOffering
/*     */   implements Parcelable
/*     */ {
/*     */   public VmsLayersOffering(Set<VmsLayerDependency> paramSet, int paramInt) {
/*  43 */     this.mDependencies = Collections.unmodifiableSet(paramSet);
/*  44 */     this.mPublisherId = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<VmsLayerDependency> getDependencies() {
/*  51 */     return this.mDependencies;
/*     */   }
/*     */   
/*     */   public int getPublisherId() {
/*  55 */     return this.mPublisherId;
/*     */   }
/*     */   
/*  58 */   public static final Parcelable.Creator<VmsLayersOffering> CREATOR = new Parcelable.Creator<VmsLayersOffering>()
/*     */     {
/*     */       public VmsLayersOffering createFromParcel(Parcel param1Parcel) {
/*  61 */         return new VmsLayersOffering(param1Parcel);
/*     */       }
/*     */       
/*     */       public VmsLayersOffering[] newArray(int param1Int) {
/*  65 */         return new VmsLayersOffering[param1Int];
/*     */       }
/*     */     };
/*     */   private final Set<VmsLayerDependency> mDependencies;
/*     */   
/*     */   public String toString() {
/*  71 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("VmsLayersOffering{ Publisher: "); stringBuilder.append(this.mPublisherId); stringBuilder.append(" Dependencies: "); stringBuilder.append(this.mDependencies); stringBuilder.append("}"); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final int mPublisherId;
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  81 */     paramParcel.writeParcelableList(new ArrayList<>(this.mDependencies), paramInt);
/*  82 */     paramParcel.writeInt(this.mPublisherId);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  87 */     boolean bool = paramObject instanceof VmsLayersOffering; boolean bool1 = false; if (!bool) {
/*  88 */       return false;
/*     */     }
/*  90 */     paramObject = paramObject;
/*  91 */     bool = bool1; if (Objects.equals(Integer.valueOf(((VmsLayersOffering)paramObject).mPublisherId), Integer.valueOf(this.mPublisherId))) { bool = bool1; if (((VmsLayersOffering)paramObject).mDependencies.equals(this.mDependencies)) bool = true;  }  return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return Objects.hash(new Object[] { Integer.valueOf(this.mPublisherId), this.mDependencies });
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 101 */     return 0;
/*     */   }
/*     */   
/*     */   private VmsLayersOffering(Parcel paramParcel) {
/* 105 */     ArrayList<? extends VmsLayerDependency> arrayList = new ArrayList();
/* 106 */     paramParcel.readParcelableList(arrayList, VmsLayerDependency.class.getClassLoader());
/* 107 */     this.mDependencies = Collections.unmodifiableSet(new HashSet<>(arrayList));
/* 108 */     this.mPublisherId = paramParcel.readInt();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsLayersOffering.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */