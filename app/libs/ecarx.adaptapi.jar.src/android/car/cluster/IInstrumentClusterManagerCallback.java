/*     */ package android.car.cluster;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.Bundle;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IInstrumentClusterManagerCallback
/*     */   extends IInterface {
/*     */   void setClusterActivityState(String paramString, Bundle paramBundle) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IInstrumentClusterManagerCallback {
/*     */     private static final String DESCRIPTOR = "android.car.cluster.IInstrumentClusterManagerCallback";
/*     */     static final int TRANSACTION_setClusterActivityState = 1;
/*     */     
/*     */     public Stub() {
/*  19 */       attachInterface(this, "android.car.cluster.IInstrumentClusterManagerCallback");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IInstrumentClusterManagerCallback asInterface(IBinder param1IBinder) {
/*  27 */       if (param1IBinder == null) {
/*  28 */         return null;
/*     */       }
/*  30 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.cluster.IInstrumentClusterManagerCallback");
/*  31 */       if (iInterface != null && iInterface instanceof IInstrumentClusterManagerCallback) {
/*  32 */         return (IInstrumentClusterManagerCallback)iInterface;
/*     */       }
/*  34 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  38 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  43 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
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
/*     */ 
/*     */           
/*  67 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.cluster.IInstrumentClusterManagerCallback"); return true; }
/*     */        param1Parcel1.enforceInterface("android.car.cluster.IInstrumentClusterManagerCallback");
/*     */       String str = param1Parcel1.readString();
/*     */       if (param1Parcel1.readInt() != 0) {
/*     */         Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1);
/*     */       } else {
/*     */         param1Parcel1 = null;
/*     */       } 
/*     */       setClusterActivityState(str, (Bundle)param1Parcel1);
/*  76 */       return true; } private static class Proxy implements IInstrumentClusterManagerCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  80 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  84 */         return "android.car.cluster.IInstrumentClusterManagerCallback";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setClusterActivityState(String param2String, Bundle param2Bundle) throws RemoteException
/*     */       {
/*  97 */         Parcel parcel = Parcel.obtain();
/*     */         
/*  99 */         try { parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerCallback");
/* 100 */           parcel.writeString(param2String);
/* 101 */           if (param2Bundle != null) {
/* 102 */             parcel.writeInt(1);
/* 103 */             param2Bundle.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 106 */             parcel.writeInt(0);
/*     */           } 
/* 108 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 111 */         { parcel.recycle(); }  } } } private static class Proxy implements IInstrumentClusterManagerCallback { public void setClusterActivityState(String param1String, Bundle param1Bundle) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerCallback"); parcel.writeString(param1String); if (param1Bundle != null) { parcel.writeInt(1); param1Bundle.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.cluster.IInstrumentClusterManagerCallback";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\IInstrumentClusterManagerCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */