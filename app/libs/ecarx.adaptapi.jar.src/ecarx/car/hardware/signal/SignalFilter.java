/*     */ package ecarx.car.hardware.signal;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.util.Log;
/*     */ import ecarx.car.hardware.property.PropertyIdString;
/*     */ import java.util.Iterator;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignalFilter
/*     */   implements Parcelable
/*     */ {
/*  17 */   public static final Parcelable.Creator<SignalFilter> CREATOR = new Parcelable.Creator<SignalFilter>()
/*     */     {
/*     */       public SignalFilter createFromParcel(Parcel param1Parcel)
/*     */       {
/*  21 */         return new SignalFilter(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public SignalFilter[] newArray(int param1Int) {
/*  26 */         return new SignalFilter[param1Int];
/*     */       }
/*     */     };
/*     */   
/*  30 */   private ConcurrentHashMap<Integer, Integer> mSignalMap = new ConcurrentHashMap<>();
/*  31 */   private CopyOnWriteArrayList<Integer> mSignalList = new CopyOnWriteArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SignalFilter(Parcel paramParcel) {
/*  37 */     paramParcel.readList(this.mSignalList, Integer.class.getClassLoader());
/*  38 */     for (Iterator<Integer> iterator = this.mSignalList.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/*  39 */       this.mSignalMap.put(Integer.valueOf(i), Integer.valueOf(i)); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  45 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  50 */     paramParcel.writeList(this.mSignalList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Integer paramInteger) {
/*  59 */     if (paramInteger == null) {
/*  60 */       Log.w("SignalFilter", "add parameter null object");
/*  61 */     } else if (!contains(paramInteger)) {
/*  62 */       this.mSignalMap.put(paramInteger, paramInteger);
/*  63 */       this.mSignalList.add(paramInteger);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Integer paramInteger) {
/*  74 */     return this.mSignalMap.containsKey(paramInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Integer paramInteger) {
/*  83 */     this.mSignalMap.remove(paramInteger);
/*  84 */     this.mSignalList.remove(paramInteger);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFilterCount() {
/*  93 */     return this.mSignalList.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Integer getSignal(int paramInt) {
/* 102 */     return this.mSignalList.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 109 */     this.mSignalMap.clear();
/* 110 */     this.mSignalList.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder stringBuilder = new StringBuilder("SignalFilter ");
/*     */     
/* 117 */     for (Integer integer : this.mSignalMap.keySet()) {
/* 118 */       stringBuilder.append(" "); stringBuilder.append((String)PropertyIdString.idToStringMap.get(integer));
/*     */     } 
/*     */     
/* 121 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public SignalFilter() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\signal\SignalFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */