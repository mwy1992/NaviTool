/*     */ package android.car.cluster;
/*     */ 
/*     */ import android.content.Intent;
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public interface IInstrumentClusterManagerService extends IInterface {
/*     */   void registerCallback(IInstrumentClusterManagerCallback paramIInstrumentClusterManagerCallback) throws RemoteException;
/*     */   
/*     */   void startClusterActivity(Intent paramIntent) throws RemoteException;
/*     */   
/*     */   void unregisterCallback(IInstrumentClusterManagerCallback paramIInstrumentClusterManagerCallback) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IInstrumentClusterManagerService { private static final String DESCRIPTOR = "android.car.cluster.IInstrumentClusterManagerService";
/*     */     static final int TRANSACTION_registerCallback = 2;
/*     */     static final int TRANSACTION_startClusterActivity = 1;
/*     */     static final int TRANSACTION_unregisterCallback = 3;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.cluster.IInstrumentClusterManagerService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IInstrumentClusterManagerService asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.cluster.IInstrumentClusterManagerService");
/*  32 */       if (iInterface != null && iInterface instanceof IInstrumentClusterManagerService) {
/*  33 */         return (IInstrumentClusterManagerService)iInterface;
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
/*  44 */       if (param1Int1 != 1598968902) { IInstrumentClusterManagerCallback iInstrumentClusterManagerCallback; switch (param1Int1)
/*     */         
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
/*  82 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.cluster.IInstrumentClusterManagerService"); iInstrumentClusterManagerCallback = IInstrumentClusterManagerCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); unregisterCallback(iInstrumentClusterManagerCallback); return true;
/*     */           case 2:
/*     */             iInstrumentClusterManagerCallback.enforceInterface("android.car.cluster.IInstrumentClusterManagerService"); iInstrumentClusterManagerCallback = IInstrumentClusterManagerCallback.Stub.asInterface(iInstrumentClusterManagerCallback.readStrongBinder()); registerCallback(iInstrumentClusterManagerCallback); return true;
/*     */           case 1:
/*     */             break; }  iInstrumentClusterManagerCallback.enforceInterface("android.car.cluster.IInstrumentClusterManagerService"); if (iInstrumentClusterManagerCallback.readInt() != 0) { Intent intent = (Intent)Intent.CREATOR.createFromParcel((Parcel)iInstrumentClusterManagerCallback); }
/*     */         else { iInstrumentClusterManagerCallback = null; }
/*     */          startClusterActivity((Intent)iInstrumentClusterManagerCallback); return true; }
/*  91 */        param1Parcel2.writeString("android.car.cluster.IInstrumentClusterManagerService"); return true; } private static class Proxy implements IInstrumentClusterManagerService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  95 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  99 */         return "android.car.cluster.IInstrumentClusterManagerService";
/*     */       }
/*     */       
/*     */       public void startClusterActivity(Intent param2Intent) throws RemoteException {
/* 103 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 105 */           parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerService");
/* 106 */           if (param2Intent != null) {
/* 107 */             parcel.writeInt(1);
/* 108 */             param2Intent.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 111 */             parcel.writeInt(0);
/*     */           } 
/* 113 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 116 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void registerCallback(IInstrumentClusterManagerCallback param2IInstrumentClusterManagerCallback) throws RemoteException {
/* 121 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 123 */           parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerService");
/* 124 */           if (param2IInstrumentClusterManagerCallback != null) { IBinder iBinder = param2IInstrumentClusterManagerCallback.asBinder(); } else { param2IInstrumentClusterManagerCallback = null; }  parcel.writeStrongBinder((IBinder)param2IInstrumentClusterManagerCallback);
/* 125 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 128 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterCallback(IInstrumentClusterManagerCallback param2IInstrumentClusterManagerCallback) throws RemoteException {
/* 133 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 135 */         try { parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerService");
/* 136 */           if (param2IInstrumentClusterManagerCallback != null) { IBinder iBinder = param2IInstrumentClusterManagerCallback.asBinder(); } else { param2IInstrumentClusterManagerCallback = null; }  parcel.writeStrongBinder((IBinder)param2IInstrumentClusterManagerCallback);
/* 137 */           this.mRemote.transact(3, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 140 */         { parcel.recycle(); }  } } } private static class Proxy implements IInstrumentClusterManagerService { private IBinder mRemote; public void unregisterCallback(IInstrumentClusterManagerCallback param1IInstrumentClusterManagerCallback) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerService"); if (param1IInstrumentClusterManagerCallback != null) { IBinder iBinder = param1IInstrumentClusterManagerCallback.asBinder(); } else { param1IInstrumentClusterManagerCallback = null; }  parcel.writeStrongBinder((IBinder)param1IInstrumentClusterManagerCallback); this.mRemote.transact(3, parcel, null, 1); return; } finally { parcel.recycle(); }
/*     */        }
/*     */ 
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
/*     */       return "android.car.cluster.IInstrumentClusterManagerService";
/*     */     }
/*     */     
/*     */     public void startClusterActivity(Intent param1Intent) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerService");
/*     */         if (param1Intent != null) {
/*     */           parcel.writeInt(1);
/*     */           param1Intent.writeToParcel(parcel, 0);
/*     */         } else {
/*     */           parcel.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerCallback(IInstrumentClusterManagerCallback param1IInstrumentClusterManagerCallback) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.cluster.IInstrumentClusterManagerService");
/*     */         if (param1IInstrumentClusterManagerCallback != null) {
/*     */           IBinder iBinder = param1IInstrumentClusterManagerCallback.asBinder();
/*     */         } else {
/*     */           param1IInstrumentClusterManagerCallback = null;
/*     */         } 
/*     */         parcel.writeStrongBinder((IBinder)param1IInstrumentClusterManagerCallback);
/*     */         this.mRemote.transact(2, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\IInstrumentClusterManagerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */