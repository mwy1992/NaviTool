/*     */ package com.ecarx.xui.adaptapi.car.userprofile;
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
/*     */ @VendorDefinition(author = "@ECARX", date = "2021-09-13", project = "lambda")
/*     */ public class DigitalKeyInfo
/*     */   implements Parcelable
/*     */ {
/*     */   protected DigitalKeyInfo(Parcel paramParcel) {
/*  47 */     this.keyType = paramParcel.readInt();
/*  48 */     this.keyId = paramParcel.readInt();
/*  49 */     this.KeyPairingState = paramParcel.readInt();
/*  50 */     this.creatTimeUTCTi = paramParcel.readLong();
/*  51 */     this.KeyName = paramParcel.readString();
/*  52 */     this.slotID = paramParcel.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  57 */     paramParcel.writeInt(this.keyType);
/*  58 */     paramParcel.writeInt(this.keyId);
/*  59 */     paramParcel.writeInt(this.KeyPairingState);
/*  60 */     paramParcel.writeLong(this.creatTimeUTCTi);
/*  61 */     paramParcel.writeString(this.KeyName);
/*  62 */     paramParcel.writeInt(this.slotID);
/*     */   }
/*     */ 
/*     */   
/*     */   public int describeContents() {
/*  67 */     return 0;
/*     */   }
/*     */   
/*  70 */   public static final Parcelable.Creator<DigitalKeyInfo> CREATOR = new Parcelable.Creator<DigitalKeyInfo>()
/*     */     {
/*     */       public DigitalKeyInfo createFromParcel(Parcel param1Parcel) {
/*  73 */         return new DigitalKeyInfo(param1Parcel);
/*     */       }
/*     */ 
/*     */       
/*     */       public DigitalKeyInfo[] newArray(int param1Int) {
/*  78 */         return new DigitalKeyInfo[param1Int];
/*     */       }
/*     */     };
/*     */   private String KeyName; private int KeyPairingState; private long creatTimeUTCTi;
/*     */   public int getKeyType() {
/*  83 */     return this.keyType;
/*     */   }
/*     */   private int keyId; private int keyType; private int slotID;
/*     */   public void setKeyType(int paramInt) {
/*  87 */     this.keyType = paramInt;
/*     */   }
/*     */   
/*     */   public int getKeyId() {
/*  91 */     return this.keyId;
/*     */   }
/*     */   
/*     */   public void setKeyId(int paramInt) {
/*  95 */     this.keyId = paramInt;
/*     */   }
/*     */   
/*     */   public int getKeyPairingState() {
/*  99 */     return this.KeyPairingState;
/*     */   }
/*     */   
/*     */   public void setKeyPairingState(int paramInt) {
/* 103 */     this.KeyPairingState = paramInt;
/*     */   }
/*     */   
/*     */   public long getCreatTimeUTCTi() {
/* 107 */     return this.creatTimeUTCTi;
/*     */   }
/*     */   
/*     */   public void setCreatTimeUTCTi(long paramLong) {
/* 111 */     this.creatTimeUTCTi = paramLong;
/*     */   }
/*     */   
/*     */   public String getKeyName() {
/* 115 */     return this.KeyName;
/*     */   }
/*     */   
/*     */   public void setKeyName(String paramString) {
/* 119 */     this.KeyName = paramString;
/*     */   }
/*     */   
/*     */   public int getSlotID() {
/* 123 */     return this.slotID;
/*     */   }
/*     */   
/*     */   public void setSlotID(int paramInt) {}
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\DigitalKeyInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */