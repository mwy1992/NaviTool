/*     */ package android.car.vms;
/*     */ 
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
/*     */ 
/*     */ public final class VmsSubscriptionState
/*     */   implements Parcelable
/*     */ {
/*     */   public VmsSubscriptionState(int paramInt, Set<VmsLayer> paramSet, Set<VmsAssociatedLayer> paramSet1) {
/*  46 */     this.mSequenceNumber = paramInt;
/*  47 */     this.mLayers = Collections.unmodifiableSet(paramSet);
/*  48 */     this.mSubscribedLayersFromPublishers = Collections.unmodifiableSet(paramSet1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSequenceNumber() {
/*  56 */     return this.mSequenceNumber;
/*     */   }
/*     */   
/*     */   public Set<VmsLayer> getLayers() {
/*  60 */     return this.mLayers;
/*     */   }
/*     */   
/*     */   public Set<VmsAssociatedLayer> getAssociatedLayers() {
/*  64 */     return this.mSubscribedLayersFromPublishers;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  69 */     StringBuilder stringBuilder = new StringBuilder();
/*  70 */     stringBuilder.append("sequence number="); stringBuilder.append(this.mSequenceNumber);
/*  71 */     stringBuilder.append("; layers={");
/*  72 */     for (VmsLayer vmsLayer : this.mLayers) {
/*  73 */       stringBuilder.append(vmsLayer); stringBuilder.append(",");
/*     */     } 
/*  75 */     stringBuilder.append("}");
/*  76 */     stringBuilder.append("; associatedLayers={");
/*  77 */     for (VmsAssociatedLayer vmsAssociatedLayer : this.mSubscribedLayersFromPublishers) {
/*  78 */       stringBuilder.append(vmsAssociatedLayer); stringBuilder.append(",");
/*     */     } 
/*  80 */     stringBuilder.append("}");
/*  81 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*  84 */   public static final Parcelable.Creator<VmsSubscriptionState> CREATOR = new Parcelable.Creator<VmsSubscriptionState>()
/*     */     {
/*     */       public VmsSubscriptionState createFromParcel(Parcel param1Parcel) {
/*  87 */         return new VmsSubscriptionState(param1Parcel);
/*     */       }
/*     */       
/*     */       public VmsSubscriptionState[] newArray(int param1Int) {
/*  91 */         return new VmsSubscriptionState[param1Int];
/*     */       }
/*     */     };
/*     */   private final Set<VmsLayer> mLayers;
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  97 */     paramParcel.writeInt(this.mSequenceNumber);
/*  98 */     paramParcel.writeParcelableList(new ArrayList<>(this.mLayers), paramInt);
/*  99 */     paramParcel.writeParcelableList(new ArrayList<>(this.mSubscribedLayersFromPublishers), paramInt);
/*     */   }
/*     */   private final int mSequenceNumber; private final Set<VmsAssociatedLayer> mSubscribedLayersFromPublishers;
/*     */   
/*     */   public boolean equals(Object<VmsAssociatedLayer> paramObject) {
/* 104 */     boolean bool = paramObject instanceof VmsSubscriptionState; boolean bool1 = false; if (!bool) {
/* 105 */       return false;
/*     */     }
/* 107 */     paramObject = paramObject;
/* 108 */     bool = bool1; if (Objects.equals(Integer.valueOf(((VmsSubscriptionState)paramObject).mSequenceNumber), Integer.valueOf(this.mSequenceNumber))) { Set<VmsLayer> set2 = ((VmsSubscriptionState)paramObject).mLayers, set1 = this.mLayers;
/* 109 */       bool = bool1; if (set2.equals(set1)) { paramObject = (Object<VmsAssociatedLayer>)((VmsSubscriptionState)paramObject).mSubscribedLayersFromPublishers; Set<VmsAssociatedLayer> set = this.mSubscribedLayersFromPublishers;
/* 110 */         bool = bool1; if (paramObject.equals(set)) bool = true;  }
/*     */        }
/*     */     
/*     */     return bool;
/*     */   } public int hashCode() {
/* 115 */     return Objects.hash(new Object[] { Integer.valueOf(this.mSequenceNumber), this.mLayers, this.mSubscribedLayersFromPublishers });
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/* 120 */     return 0;
/*     */   }
/*     */   
/*     */   private VmsSubscriptionState(Parcel paramParcel) {
/* 124 */     this.mSequenceNumber = paramParcel.readInt();
/*     */     
/* 126 */     ArrayList<? extends VmsLayer> arrayList = new ArrayList();
/* 127 */     paramParcel.readParcelableList(arrayList, VmsLayer.class.getClassLoader());
/* 128 */     this.mLayers = Collections.unmodifiableSet(new HashSet<>(arrayList));
/*     */     
/* 130 */     arrayList = new ArrayList<>();
/* 131 */     paramParcel.readParcelableList(arrayList, VmsAssociatedLayer.class.getClassLoader());
/* 132 */     HashSet<VmsLayer> hashSet = new HashSet<>(arrayList);
/* 133 */     this.mSubscribedLayersFromPublishers = Collections.unmodifiableSet(hashSet);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsSubscriptionState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */