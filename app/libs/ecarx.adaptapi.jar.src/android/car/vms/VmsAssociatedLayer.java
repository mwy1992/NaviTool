/*    */ package android.car.vms;
/*    */ 
/*    */ import android.os.Parcel;
/*    */ import android.os.Parcelable;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.Objects;
/*    */ import java.util.Set;
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
/*    */ public final class VmsAssociatedLayer
/*    */   implements Parcelable
/*    */ {
/*    */   public VmsAssociatedLayer(VmsLayer paramVmsLayer, Set<Integer> paramSet) {
/* 38 */     this.mLayer = paramVmsLayer;
/* 39 */     this.mPublisherIds = Collections.unmodifiableSet(paramSet);
/*    */   }
/*    */   
/*    */   public VmsLayer getVmsLayer() {
/* 43 */     return this.mLayer;
/*    */   }
/*    */   
/*    */   public Set<Integer> getPublisherIds() {
/* 47 */     return this.mPublisherIds;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("VmsAssociatedLayer{ VmsLayer: "); stringBuilder.append(this.mLayer); stringBuilder.append(", Publishers: "); stringBuilder.append(this.mPublisherIds); stringBuilder.append("}"); return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/* 56 */   public static final Parcelable.Creator<VmsAssociatedLayer> CREATOR = new Parcelable.Creator<VmsAssociatedLayer>()
/*    */     {
/*    */       public VmsAssociatedLayer createFromParcel(Parcel param1Parcel) {
/* 59 */         return new VmsAssociatedLayer(param1Parcel);
/*    */       }
/*    */       
/*    */       public VmsAssociatedLayer[] newArray(int param1Int) {
/* 63 */         return new VmsAssociatedLayer[param1Int];
/*    */       }
/*    */     };
/*    */   private final VmsLayer mLayer;
/*    */   
/*    */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 69 */     paramParcel.writeParcelable(this.mLayer, paramInt);
/* 70 */     paramParcel.writeArray(this.mPublisherIds.toArray());
/*    */   }
/*    */   private final Set<Integer> mPublisherIds;
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 75 */     boolean bool = paramObject instanceof VmsAssociatedLayer; boolean bool1 = false; if (!bool) {
/* 76 */       return false;
/*    */     }
/* 78 */     paramObject = paramObject;
/* 79 */     bool = bool1; if (Objects.equals(((VmsAssociatedLayer)paramObject).mLayer, this.mLayer)) { bool = bool1; if (((VmsAssociatedLayer)paramObject).mPublisherIds.equals(this.mPublisherIds)) bool = true;  }  return bool;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 84 */     return Objects.hash(new Object[] { this.mLayer, this.mPublisherIds });
/*    */   }
/*    */ 
/*    */   
/*    */   public int describeContents() {
/* 89 */     return 0;
/*    */   }
/*    */   
/*    */   private VmsAssociatedLayer(Parcel paramParcel) {
/* 93 */     this.mLayer = (VmsLayer)paramParcel.readParcelable(VmsLayer.class.getClassLoader());
/*    */     
/* 95 */     Object[] arrayOfObject = paramParcel.readArray(Integer.class.getClassLoader());
/* 96 */     Integer[] arrayOfInteger = Arrays.<Integer, Object>copyOf(arrayOfObject, arrayOfObject.length, Integer[].class);
/*    */ 
/*    */     
/* 99 */     HashSet<? extends Integer> hashSet = new HashSet(Arrays.asList((Object[])arrayOfInteger));
/*    */     this.mPublisherIds = Collections.unmodifiableSet(hashSet);
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\VmsAssociatedLayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */