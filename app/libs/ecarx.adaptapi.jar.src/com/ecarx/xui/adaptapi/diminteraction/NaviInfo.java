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
/*     */ @VendorDefinition(author = "@ECARX", date = "2021-06-18", project = "EX11")
/*     */ public class NaviInfo
/*     */   implements Parcelable
/*     */ {
/*     */   public NaviInfo(String paramString, double paramDouble1, double paramDouble2, long paramLong1, long paramLong2) {
/*  43 */     this.name = paramString;
/*  44 */     this.lat = paramDouble1;
/*  45 */     this.lng = paramDouble2;
/*  46 */     this.remainDistance = paramLong1;
/*  47 */     this.remainTime = paramLong2;
/*     */   }
/*     */   protected NaviInfo(Parcel paramParcel) {
/*  50 */     this.name = paramParcel.readString();
/*  51 */     this.lat = paramParcel.readDouble();
/*  52 */     this.lng = paramParcel.readDouble();
/*  53 */     this.remainDistance = paramParcel.readLong();
/*  54 */     this.remainTime = paramParcel.readLong();
/*  55 */     this.extra = paramParcel.readString();
/*     */   }
/*     */   
/*  58 */   public static final Parcelable.Creator<NaviInfo> CREATOR = new Parcelable.Creator<NaviInfo>()
/*     */     {
/*     */       public NaviInfo createFromParcel(Parcel param1Parcel) {
/*  61 */         return new NaviInfo(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public NaviInfo[] newArray(int param1Int) {
/*  66 */         return new NaviInfo[param1Int];
/*     */       }
/*     */     };
/*     */   private String extra; private double lat; private double lng;
/*     */   
/*     */   public int describeContents() {
/*  72 */     return 0;
/*     */   }
/*     */   private String name; private long remainDistance; private long remainTime;
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  77 */     paramParcel.writeString(this.name);
/*  78 */     paramParcel.writeDouble(this.lat);
/*  79 */     paramParcel.writeDouble(this.lng);
/*  80 */     paramParcel.writeLong(this.remainDistance);
/*  81 */     paramParcel.writeLong(this.remainTime);
/*  82 */     paramParcel.writeString(this.extra);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  89 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double gatLatitude() {
/*  95 */     return this.lat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double gatLongitude() {
/* 101 */     return this.lng;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRemainDistance() {
/* 107 */     return this.remainDistance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getRemainTime() {
/* 113 */     return this.remainTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExtra() {
/* 119 */     return this.extra;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\NaviInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */