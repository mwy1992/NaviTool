/*     */ package android.car.vms;
/*     */ 
/*     */ 
/*     */ public interface IVmsPublisherService extends IInterface {
/*     */   int getPublisherId(byte[] paramArrayOfbyte) throws RemoteException;
/*     */   
/*     */   VmsSubscriptionState getSubscriptions() throws RemoteException;
/*     */   
/*     */   void publish(IBinder paramIBinder, VmsLayer paramVmsLayer, int paramInt, byte[] paramArrayOfbyte) throws RemoteException;
/*     */   
/*     */   void setLayersOffering(IBinder paramIBinder, VmsLayersOffering paramVmsLayersOffering) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IVmsPublisherService { private static final String DESCRIPTOR = "android.car.vms.IVmsPublisherService";
/*     */     static final int TRANSACTION_getPublisherId = 4;
/*     */     static final int TRANSACTION_getSubscriptions = 2;
/*     */     static final int TRANSACTION_publish = 1;
/*     */     static final int TRANSACTION_setLayersOffering = 3;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.vms.IVmsPublisherService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IVmsPublisherService asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.vms.IVmsPublisherService");
/*  32 */       if (iInterface != null && iInterface instanceof IVmsPublisherService) {
/*  33 */         return (IVmsPublisherService)iInterface;
/*     */       }
/*  35 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  39 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/*     */       IBinder iBinder;
/*  44 */       if (param1Int1 != 1598968902) { byte[] arrayOfByte2; VmsSubscriptionState vmsSubscriptionState; IBinder iBinder2 = null; byte[] arrayOfByte3 = null; switch (param1Int1)
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
/* 111 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.vms.IVmsPublisherService"); arrayOfByte2 = param1Parcel1.createByteArray(); param1Int1 = getPublisherId(arrayOfByte2); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 3:
/*     */             arrayOfByte2.enforceInterface("android.car.vms.IVmsPublisherService"); iBinder = arrayOfByte2.readStrongBinder(); if (arrayOfByte2.readInt() != 0) { VmsLayersOffering vmsLayersOffering = (VmsLayersOffering)VmsLayersOffering.CREATOR.createFromParcel((Parcel)arrayOfByte2); } else { arrayOfByte2 = arrayOfByte3; }  setLayersOffering(iBinder, (VmsLayersOffering)arrayOfByte2); return true;
/*     */           case 2:
/*     */             arrayOfByte2.enforceInterface("android.car.vms.IVmsPublisherService"); vmsSubscriptionState = getSubscriptions(); iBinder.writeNoException(); if (vmsSubscriptionState != null) { iBinder.writeInt(1); vmsSubscriptionState.writeToParcel((Parcel)iBinder, 1); } else { iBinder.writeInt(0); }  return true;
/*     */           case 1:
/*     */             break; }  vmsSubscriptionState.enforceInterface("android.car.vms.IVmsPublisherService"); IBinder iBinder1 = vmsSubscriptionState.readStrongBinder(); if (vmsSubscriptionState.readInt() != 0) { VmsLayer vmsLayer = (VmsLayer)VmsLayer.CREATOR.createFromParcel((Parcel)vmsSubscriptionState); } else { iBinder = iBinder2; }  param1Int1 = vmsSubscriptionState.readInt(); byte[] arrayOfByte1 = vmsSubscriptionState.createByteArray(); publish(iBinder1, (VmsLayer)iBinder, param1Int1, arrayOfByte1); return true; }
/* 120 */        iBinder.writeString("android.car.vms.IVmsPublisherService"); return true; } private static class Proxy implements IVmsPublisherService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 124 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 128 */         return "android.car.vms.IVmsPublisherService";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void publish(IBinder param2IBinder, VmsLayer param2VmsLayer, int param2Int, byte[] param2ArrayOfbyte) throws RemoteException {
/* 135 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 137 */           parcel.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/* 138 */           parcel.writeStrongBinder(param2IBinder);
/* 139 */           if (param2VmsLayer != null) {
/* 140 */             parcel.writeInt(1);
/* 141 */             param2VmsLayer.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 144 */             parcel.writeInt(0);
/*     */           } 
/* 146 */           parcel.writeInt(param2Int);
/* 147 */           parcel.writeByteArray(param2ArrayOfbyte);
/* 148 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 151 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public VmsSubscriptionState getSubscriptions() throws RemoteException {
/* 159 */         Parcel parcel2 = Parcel.obtain();
/* 160 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/*     */           VmsSubscriptionState vmsSubscriptionState;
/* 163 */           parcel2.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/* 164 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 165 */           parcel1.readException();
/* 166 */           if (parcel1.readInt() != 0) {
/* 167 */             vmsSubscriptionState = (VmsSubscriptionState)VmsSubscriptionState.CREATOR.createFromParcel(parcel1);
/*     */           } else {
/*     */             
/* 170 */             vmsSubscriptionState = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 177 */           return vmsSubscriptionState;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       public void setLayersOffering(IBinder param2IBinder, VmsLayersOffering param2VmsLayersOffering) throws RemoteException {
/* 184 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 186 */           parcel.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/* 187 */           parcel.writeStrongBinder(param2IBinder);
/* 188 */           if (param2VmsLayersOffering != null) {
/* 189 */             parcel.writeInt(1);
/* 190 */             param2VmsLayersOffering.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 193 */             parcel.writeInt(0);
/*     */           } 
/* 195 */           this.mRemote.transact(3, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 198 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getPublisherId(byte[] param2ArrayOfbyte) throws RemoteException {
/* 203 */         Parcel parcel1 = Parcel.obtain();
/* 204 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 207 */         try { parcel1.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/* 208 */           parcel1.writeByteArray(param2ArrayOfbyte);
/* 209 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 210 */           parcel2.readException();
/* 211 */           return parcel2.readInt(); }
/*     */         finally
/*     */         
/* 214 */         { parcel2.recycle();
/* 215 */           parcel1.recycle(); }  } } } private static class Proxy implements IVmsPublisherService { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public int getPublisherId(byte[] param1ArrayOfbyte) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.vms.IVmsPublisherService"); parcel1.writeByteArray(param1ArrayOfbyte); this.mRemote.transact(4, parcel1, parcel2, 0); parcel2.readException(); return parcel2.readInt(); } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.vms.IVmsPublisherService";
/*     */     }
/*     */     
/*     */     public void publish(IBinder param1IBinder, VmsLayer param1VmsLayer, int param1Int, byte[] param1ArrayOfbyte) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/*     */         parcel.writeStrongBinder(param1IBinder);
/*     */         if (param1VmsLayer != null) {
/*     */           parcel.writeInt(1);
/*     */           param1VmsLayer.writeToParcel(parcel, 0);
/*     */         } else {
/*     */           parcel.writeInt(0);
/*     */         } 
/*     */         parcel.writeInt(param1Int);
/*     */         parcel.writeByteArray(param1ArrayOfbyte);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public VmsSubscriptionState getSubscriptions() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         VmsSubscriptionState vmsSubscriptionState;
/*     */         parcel2.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         if (parcel1.readInt() != 0) {
/*     */           vmsSubscriptionState = (VmsSubscriptionState)VmsSubscriptionState.CREATOR.createFromParcel(parcel1);
/*     */         } else {
/*     */           vmsSubscriptionState = null;
/*     */         } 
/*     */         return vmsSubscriptionState;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setLayersOffering(IBinder param1IBinder, VmsLayersOffering param1VmsLayersOffering) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.vms.IVmsPublisherService");
/*     */         parcel.writeStrongBinder(param1IBinder);
/*     */         if (param1VmsLayersOffering != null) {
/*     */           parcel.writeInt(1);
/*     */           param1VmsLayersOffering.writeToParcel(parcel, 0);
/*     */         } else {
/*     */           parcel.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(3, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\IVmsPublisherService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */