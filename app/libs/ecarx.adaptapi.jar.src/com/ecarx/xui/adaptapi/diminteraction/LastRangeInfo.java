/*     */ package com.ecarx.xui.adaptapi.diminteraction;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import com.ecarx.xui.adaptapi.VendorDefinition;
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
/*     */ 
/*     */ 
/*     */ @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
/*     */ public class LastRangeInfo
/*     */   implements Parcelable
/*     */ {
/*     */   public LastRangeInfo(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, String paramString1, String paramString2) {
/*  45 */     this.longitudeE6 = paramDouble1;
/*  46 */     this.latitudeE6 = paramDouble2;
/*  47 */     this.longitudeE61 = paramDouble3;
/*  48 */     this.latitudeE61 = paramDouble4;
/*  49 */     this.name = paramString1;
/*  50 */     this.msgSubTitle = paramString2;
/*     */   }
/*     */   protected LastRangeInfo(Parcel paramParcel) {
/*  53 */     this.longitudeE6 = paramParcel.readDouble();
/*  54 */     this.latitudeE6 = paramParcel.readDouble();
/*  55 */     this.longitudeE61 = paramParcel.readDouble();
/*  56 */     this.latitudeE61 = paramParcel.readDouble();
/*  57 */     this.name = paramParcel.readString();
/*  58 */     this.msgSubTitle = paramParcel.readString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  63 */     paramParcel.writeDouble(this.longitudeE6);
/*  64 */     paramParcel.writeDouble(this.latitudeE6);
/*  65 */     paramParcel.writeDouble(this.longitudeE61);
/*  66 */     paramParcel.writeDouble(this.latitudeE61);
/*  67 */     paramParcel.writeString(this.name);
/*  68 */     paramParcel.writeString(this.msgSubTitle);
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  73 */     return 0;
/*     */   }
/*     */   
/*  76 */   public static final Parcelable.Creator<LastRangeInfo> CREATOR = new Parcelable.Creator<LastRangeInfo>()
/*     */     {
/*     */       public LastRangeInfo createFromParcel(Parcel param1Parcel) {
/*  79 */         return new LastRangeInfo(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public LastRangeInfo[] newArray(int param1Int) {
/*  84 */         return new LastRangeInfo[param1Int];
/*     */       }
/*     */     };
/*     */   private double latitudeE6;
/*     */   private double latitudeE61;
/*     */   private double longitudeE6;
/*     */   
/*     */   public double getLatitudeE6() {
/*  92 */     return this.latitudeE6;
/*     */   }
/*     */   
/*     */   private double longitudeE61;
/*     */   
/*     */   public double getLongitudeE6() {
/*  98 */     return this.longitudeE6;
/*     */   }
/*     */   private String msgSubTitle;
/*     */   private String name;
/*     */   
/*     */   public double getLatitudeE61() {
/* 104 */     return this.latitudeE61;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getLongitudeE61() {
/* 110 */     return this.longitudeE61;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMsgSubTitle() {
/* 116 */     return this.msgSubTitle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 122 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\LastRangeInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */