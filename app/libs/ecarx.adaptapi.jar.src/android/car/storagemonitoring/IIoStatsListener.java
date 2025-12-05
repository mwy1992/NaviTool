/*     */ package android.car.storagemonitoring;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IIoStatsListener extends IInterface {
/*     */   void onSnapshot(IoStats paramIoStats) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IIoStatsListener { private static final String DESCRIPTOR = "android.car.storagemonitoring.IIoStatsListener";
/*     */     static final int TRANSACTION_onSnapshot = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.storagemonitoring.IIoStatsListener");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IIoStatsListener asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.storagemonitoring.IIoStatsListener");
/*  28 */       if (iInterface != null && iInterface instanceof IIoStatsListener) {
/*  29 */         return (IIoStatsListener)iInterface;
/*     */       }
/*  31 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  35 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  40 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
/*     */         {
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
/*  62 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.storagemonitoring.IIoStatsListener"); return true; }
/*     */       
/*     */       param1Parcel1.enforceInterface("android.car.storagemonitoring.IIoStatsListener");
/*     */       if (param1Parcel1.readInt() != 0) {
/*     */         IoStats ioStats = (IoStats)IoStats.CREATOR.createFromParcel(param1Parcel1);
/*     */       } else {
/*     */         param1Parcel1 = null;
/*     */       } 
/*     */       onSnapshot((IoStats)param1Parcel1);
/*  71 */       return true; } private static class Proxy implements IIoStatsListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  75 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  79 */         return "android.car.storagemonitoring.IIoStatsListener";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onSnapshot(IoStats param2IoStats) throws RemoteException
/*     */       {
/*  88 */         Parcel parcel = Parcel.obtain();
/*     */         
/*  90 */         try { parcel.writeInterfaceToken("android.car.storagemonitoring.IIoStatsListener");
/*  91 */           if (param2IoStats != null) {
/*  92 */             parcel.writeInt(1);
/*  93 */             param2IoStats.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/*  96 */             parcel.writeInt(0);
/*     */           } 
/*  98 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 101 */         { parcel.recycle(); }  } } } private static class Proxy implements IIoStatsListener { public void onSnapshot(IoStats param1IoStats) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.storagemonitoring.IIoStatsListener"); if (param1IoStats != null) { parcel.writeInt(1); param1IoStats.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.storagemonitoring.IIoStatsListener";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\IIoStatsListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */