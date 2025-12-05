/*     */ package android.car.media;
/*     */ 
/*     */ import android.media.AudioDevicePort;
/*     */ import android.media.AudioPatch;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import com.android.internal.util.Preconditions;
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
/*     */ public final class CarAudioPatchHandle
/*     */   implements Parcelable
/*     */ {
/*     */   public CarAudioPatchHandle(AudioPatch paramAudioPatch) {
/*     */     boolean bool1;
/*  44 */     int i = (paramAudioPatch.sources()).length; boolean bool2 = true; if (i == 1 && 
/*  45 */       paramAudioPatch.sources()[0].port() instanceof AudioDevicePort) { bool1 = true; } else { bool1 = false; }
/*     */      Preconditions.checkArgument(bool1, "Accepts exactly one device port as source");
/*  47 */     if ((paramAudioPatch.sinks()).length == 1 && 
/*  48 */       paramAudioPatch.sinks()[0].port() instanceof AudioDevicePort) { bool1 = bool2; } else { bool1 = false; }
/*     */     
/*     */     Preconditions.checkArgument(bool1, "Accepts exactly one device port as sink");
/*  51 */     this.mHandleId = paramAudioPatch.id();
/*  52 */     this.mSourceAddress = ((AudioDevicePort)paramAudioPatch.sources()[0].port()).address();
/*  53 */     this.mSinkAddress = ((AudioDevicePort)paramAudioPatch.sinks()[0].port()).address();
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
/*     */   public boolean represents(AudioPatch paramAudioPatch) {
/*  68 */     int i = (paramAudioPatch.sources()).length; boolean bool = true; if (i != 1 || (
/*  69 */       paramAudioPatch.sinks()).length != 1 || 
/*  70 */       paramAudioPatch.id() != this.mHandleId) bool = false; 
/*     */     return bool;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  75 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Patch (mHandleId="); stringBuilder.append(this.mHandleId); stringBuilder.append("): "); stringBuilder.append(this.mSourceAddress); stringBuilder.append(" => "); stringBuilder.append(this.mSinkAddress); return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CarAudioPatchHandle(Parcel paramParcel) {
/*  83 */     this.mHandleId = paramParcel.readInt();
/*  84 */     this.mSourceAddress = paramParcel.readString();
/*  85 */     this.mSinkAddress = paramParcel.readString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToParcel(Parcel paramParcel, int paramInt) {
/*  93 */     paramParcel.writeInt(this.mHandleId);
/*  94 */     paramParcel.writeString(this.mSourceAddress);
/*  95 */     paramParcel.writeString(this.mSinkAddress);
/*     */   }
/*     */   
/*  98 */   public static final Parcelable.Creator<CarAudioPatchHandle> CREATOR = new Parcelable.Creator<CarAudioPatchHandle>()
/*     */     {
/*     */       public CarAudioPatchHandle createFromParcel(Parcel param1Parcel) {
/* 101 */         return new CarAudioPatchHandle(param1Parcel);
/*     */       }
/*     */       
/*     */       public CarAudioPatchHandle[] newArray(int param1Int) {
/* 105 */         return new CarAudioPatchHandle[param1Int];
/*     */       }
/*     */     };
/*     */   private final int mHandleId;
/*     */   
/*     */   public int describeContents() {
/* 111 */     return 0;
/*     */   }
/*     */   
/*     */   private final String mSinkAddress;
/*     */   private final String mSourceAddress;
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\media\CarAudioPatchHandle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */