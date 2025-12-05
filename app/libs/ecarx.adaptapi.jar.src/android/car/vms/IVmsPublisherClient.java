/*     */ package android.car.vms;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IVmsPublisherClient extends IInterface {
/*     */   void onVmsSubscriptionChange(VmsSubscriptionState paramVmsSubscriptionState) throws RemoteException;
/*     */   
/*     */   void setVmsPublisherService(IBinder paramIBinder, IVmsPublisherService paramIVmsPublisherService) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IVmsPublisherClient { private static final String DESCRIPTOR = "android.car.vms.IVmsPublisherClient";
/*     */     static final int TRANSACTION_onVmsSubscriptionChange = 2;
/*     */     static final int TRANSACTION_setVmsPublisherService = 1;
/*     */     
/*     */     public Stub() {
/*  18 */       attachInterface(this, "android.car.vms.IVmsPublisherClient");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IVmsPublisherClient asInterface(IBinder param1IBinder) {
/*  26 */       if (param1IBinder == null) {
/*  27 */         return null;
/*     */       }
/*  29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.vms.IVmsPublisherClient");
/*  30 */       if (iInterface != null && iInterface instanceof IVmsPublisherClient) {
/*  31 */         return (IVmsPublisherClient)iInterface;
/*     */       }
/*  33 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  37 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/*     */       IBinder iBinder;
/*  42 */       if (param1Int1 != 1598968902) { switch (param1Int1) {
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
/*  74 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.vms.IVmsPublisherClient"); if (param1Parcel1.readInt() != 0) { VmsSubscriptionState vmsSubscriptionState = (VmsSubscriptionState)VmsSubscriptionState.CREATOR.createFromParcel(param1Parcel1); }
/*     */             else
/*     */             { param1Parcel1 = null; }
/*     */              onVmsSubscriptionChange((VmsSubscriptionState)param1Parcel1); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("android.car.vms.IVmsPublisherClient"); iBinder = param1Parcel1.readStrongBinder(); IVmsPublisherService iVmsPublisherService = IVmsPublisherService.Stub.asInterface(param1Parcel1.readStrongBinder()); setVmsPublisherService(iBinder, iVmsPublisherService); return true; }
/*  83 */        iBinder.writeString("android.car.vms.IVmsPublisherClient"); return true; } private static class Proxy implements IVmsPublisherClient { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  87 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  91 */         return "android.car.vms.IVmsPublisherClient";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setVmsPublisherService(IBinder param2IBinder, IVmsPublisherService param2IVmsPublisherService) throws RemoteException {
/* 100 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 102 */           parcel.writeInterfaceToken("android.car.vms.IVmsPublisherClient");
/* 103 */           parcel.writeStrongBinder(param2IBinder);
/* 104 */           if (param2IVmsPublisherService != null) { param2IBinder = param2IVmsPublisherService.asBinder(); } else { param2IBinder = null; }  parcel.writeStrongBinder(param2IBinder);
/* 105 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 108 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onVmsSubscriptionChange(VmsSubscriptionState param2VmsSubscriptionState) throws RemoteException
/*     */       {
/* 119 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 121 */         try { parcel.writeInterfaceToken("android.car.vms.IVmsPublisherClient");
/* 122 */           if (param2VmsSubscriptionState != null) {
/* 123 */             parcel.writeInt(1);
/* 124 */             param2VmsSubscriptionState.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 127 */             parcel.writeInt(0);
/*     */           } 
/* 129 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 132 */         { parcel.recycle(); }  } } } private static class Proxy implements IVmsPublisherClient { public void onVmsSubscriptionChange(VmsSubscriptionState param1VmsSubscriptionState) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.vms.IVmsPublisherClient"); if (param1VmsSubscriptionState != null) { parcel.writeInt(1); param1VmsSubscriptionState.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(2, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.vms.IVmsPublisherClient";
/*     */     }
/*     */     
/*     */     public void setVmsPublisherService(IBinder param1IBinder, IVmsPublisherService param1IVmsPublisherService) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.vms.IVmsPublisherClient");
/*     */         parcel.writeStrongBinder(param1IBinder);
/*     */         if (param1IVmsPublisherService != null) {
/*     */           param1IBinder = param1IVmsPublisherService.asBinder();
/*     */         } else {
/*     */           param1IBinder = null;
/*     */         } 
/*     */         parcel.writeStrongBinder(param1IBinder);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\IVmsPublisherClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */