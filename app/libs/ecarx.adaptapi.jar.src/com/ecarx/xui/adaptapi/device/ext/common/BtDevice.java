/*     */ package com.ecarx.xui.adaptapi.device.ext.common;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
/*     */ public class BtDevice
/*     */   implements Parcelable
/*     */ {
/*  48 */   private int supportProfile = 0;
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
/*  59 */   private int category = 0;
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
/*  74 */   private int bondState = 0;
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
/*  87 */   private int connectState = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BtDevice(String paramString) {
/*  98 */     this.address = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/* 108 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String paramString) {
/* 117 */     this.address = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 126 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 135 */     this.name = paramString;
/*     */   }
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
/*     */   public int getSupportProfile() {
/* 160 */     return this.supportProfile;
/*     */   }
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
/*     */   public void setSupportProfile(int paramInt) {
/* 186 */     this.supportProfile = paramInt;
/*     */   }
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
/*     */   public int getCategory() {
/* 200 */     return this.category;
/*     */   }
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
/*     */   public void setCategory(int paramInt) {
/* 214 */     this.category = paramInt;
/*     */   }
/*     */   
/*     */   public int getBondState() {
/* 218 */     return this.bondState;
/*     */   }
/*     */   
/*     */   public void setBondState(int paramInt) {
/* 222 */     this.bondState = paramInt;
/*     */   }
/*     */   
/*     */   public int getConnectState() {
/* 226 */     return this.connectState;
/*     */   }
/*     */   
/*     */   public void setConnectState(int paramInt) {
/* 230 */     this.connectState = paramInt;
/*     */   }
/*     */   
/* 233 */   public static final Parcelable.Creator<BtDevice> CREATOR = new Parcelable.Creator<BtDevice>()
/*     */     {
/*     */       public BtDevice[] newArray(int param1Int) {
/* 236 */         return new BtDevice[param1Int];
/*     */       }
/*     */ 
/*     */       
/*     */       public BtDevice createFromParcel(Parcel param1Parcel) {
/* 241 */         BtDevice btDevice = new BtDevice();
/* 242 */         BtDevice.access$002(btDevice, param1Parcel.readString());
/* 243 */         BtDevice.access$102(btDevice, param1Parcel.readString());
/* 244 */         BtDevice.access$202(btDevice, param1Parcel.readInt());
/* 245 */         BtDevice.access$302(btDevice, param1Parcel.readInt());
/* 246 */         BtDevice.access$402(btDevice, param1Parcel.readInt());
/* 247 */         BtDevice.access$502(btDevice, param1Parcel.readInt());
/* 248 */         return btDevice;
/*     */       }
/*     */     };
/*     */   private static final String TAG = "BtDevice";
/*     */   
/*     */   public int describeContents() {
/* 254 */     return 0;
/*     */   }
/*     */   private String address; private String name;
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/* 259 */     paramParcel.writeString(this.address);
/* 260 */     paramParcel.writeString(this.name);
/* 261 */     paramParcel.writeInt(this.supportProfile);
/* 262 */     paramParcel.writeInt(this.category);
/* 263 */     paramParcel.writeInt(this.bondState);
/* 264 */     paramParcel.writeInt(this.connectState);
/*     */   }
/*     */   
/*     */   public BtDevice() {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\common\BtDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */