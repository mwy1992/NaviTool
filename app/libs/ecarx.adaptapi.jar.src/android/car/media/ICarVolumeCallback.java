/*     */ package android.car.media;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarVolumeCallback extends IInterface {
/*     */   void onGroupVolumeChanged(int paramInt1, int paramInt2) throws RemoteException;
/*     */   
/*     */   void onMasterMuteChanged(int paramInt) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarVolumeCallback {
/*     */     private static final String DESCRIPTOR = "android.car.media.ICarVolumeCallback";
/*     */     static final int TRANSACTION_onGroupVolumeChanged = 1;
/*     */     static final int TRANSACTION_onMasterMuteChanged = 2;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.media.ICarVolumeCallback");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarVolumeCallback asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.media.ICarVolumeCallback");
/*  32 */       if (iInterface != null && iInterface instanceof ICarVolumeCallback) {
/*  33 */         return (ICarVolumeCallback)iInterface;
/*     */       }
/*  35 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  39 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  44 */       if (param1Int1 != 1598968902) { switch (param1Int1) {
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
/*     */           default:
/*  71 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.media.ICarVolumeCallback"); param1Int1 = param1Parcel1.readInt(); onMasterMuteChanged(param1Int1); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("android.car.media.ICarVolumeCallback"); param1Int2 = param1Parcel1.readInt(); param1Int1 = param1Parcel1.readInt(); onGroupVolumeChanged(param1Int2, param1Int1);
/*     */         return true; }
/*     */       
/*     */       param1Parcel2.writeString("android.car.media.ICarVolumeCallback");
/*  80 */       return true; } private static class Proxy implements ICarVolumeCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  84 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  88 */         return "android.car.media.ICarVolumeCallback";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGroupVolumeChanged(int param2Int1, int param2Int2) throws RemoteException {
/*  97 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/*  99 */           parcel.writeInterfaceToken("android.car.media.ICarVolumeCallback");
/* 100 */           parcel.writeInt(param2Int1);
/* 101 */           parcel.writeInt(param2Int2);
/* 102 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 105 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onMasterMuteChanged(int param2Int) throws RemoteException
/*     */       {
/* 115 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 117 */         try { parcel.writeInterfaceToken("android.car.media.ICarVolumeCallback");
/* 118 */           parcel.writeInt(param2Int);
/* 119 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 122 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarVolumeCallback { public void onMasterMuteChanged(int param1Int) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.media.ICarVolumeCallback"); parcel.writeInt(param1Int); this.mRemote.transact(2, parcel, null, 1); return; } finally { parcel.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     private IBinder mRemote;
/*     */     
/*     */     Proxy(IBinder param1IBinder) {
/*     */       this.mRemote = param1IBinder;
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*     */       return this.mRemote;
/*     */     }
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.media.ICarVolumeCallback";
/*     */     }
/*     */     
/*     */     public void onGroupVolumeChanged(int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.media.ICarVolumeCallback");
/*     */         parcel.writeInt(param1Int1);
/*     */         parcel.writeInt(param1Int2);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\media\ICarVolumeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */