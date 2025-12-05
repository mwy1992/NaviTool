/*     */ package android.car.vms;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IVmsSubscriberClient extends IInterface {
/*     */   void onLayersAvailabilityChanged(VmsAvailableLayers paramVmsAvailableLayers) throws RemoteException;
/*     */   
/*     */   void onVmsMessageReceived(VmsLayer paramVmsLayer, byte[] paramArrayOfbyte) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IVmsSubscriberClient { private static final String DESCRIPTOR = "android.car.vms.IVmsSubscriberClient";
/*     */     static final int TRANSACTION_onLayersAvailabilityChanged = 2;
/*     */     static final int TRANSACTION_onVmsMessageReceived = 1;
/*     */     
/*     */     public Stub() {
/*  18 */       attachInterface(this, "android.car.vms.IVmsSubscriberClient");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IVmsSubscriberClient asInterface(IBinder param1IBinder) {
/*  26 */       if (param1IBinder == null) {
/*  27 */         return null;
/*     */       }
/*  29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.vms.IVmsSubscriberClient");
/*  30 */       if (iInterface != null && iInterface instanceof IVmsSubscriberClient) {
/*  31 */         return (IVmsSubscriberClient)iInterface;
/*     */       }
/*  33 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  37 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  42 */       if (param1Int1 != 1598968902) { Parcel parcel1 = null, parcel2 = null; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  79 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.vms.IVmsSubscriberClient"); if (param1Parcel1.readInt() != 0) { VmsAvailableLayers vmsAvailableLayers = (VmsAvailableLayers)VmsAvailableLayers.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel2; }
/*     */              onLayersAvailabilityChanged((VmsAvailableLayers)param1Parcel1); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("android.car.vms.IVmsSubscriberClient"); if (param1Parcel1.readInt() != 0) { VmsLayer vmsLayer = (VmsLayer)VmsLayer.CREATOR.createFromParcel(param1Parcel1); }
/*     */         else { param1Parcel2 = parcel1; }
/*     */          byte[] arrayOfByte = param1Parcel1.createByteArray(); onVmsMessageReceived((VmsLayer)param1Parcel2, arrayOfByte); return true; }
/*  88 */        param1Parcel2.writeString("android.car.vms.IVmsSubscriberClient"); return true; } private static class Proxy implements IVmsSubscriberClient { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  92 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  96 */         return "android.car.vms.IVmsSubscriberClient";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onVmsMessageReceived(VmsLayer param2VmsLayer, byte[] param2ArrayOfbyte) throws RemoteException {
/* 103 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 105 */           parcel.writeInterfaceToken("android.car.vms.IVmsSubscriberClient");
/* 106 */           if (param2VmsLayer != null) {
/* 107 */             parcel.writeInt(1);
/* 108 */             param2VmsLayer.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 111 */             parcel.writeInt(0);
/*     */           } 
/* 113 */           parcel.writeByteArray(param2ArrayOfbyte);
/* 114 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 117 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onLayersAvailabilityChanged(VmsAvailableLayers param2VmsAvailableLayers) throws RemoteException {
/* 122 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 124 */         try { parcel.writeInterfaceToken("android.car.vms.IVmsSubscriberClient");
/* 125 */           if (param2VmsAvailableLayers != null) {
/* 126 */             parcel.writeInt(1);
/* 127 */             param2VmsAvailableLayers.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 130 */             parcel.writeInt(0);
/*     */           } 
/* 132 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 135 */         { parcel.recycle(); }  } } } private static class Proxy implements IVmsSubscriberClient { private IBinder mRemote; public void onLayersAvailabilityChanged(VmsAvailableLayers param1VmsAvailableLayers) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.vms.IVmsSubscriberClient"); if (param1VmsAvailableLayers != null) { parcel.writeInt(1); param1VmsAvailableLayers.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(2, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.vms.IVmsSubscriberClient";
/*     */     }
/*     */     
/*     */     public void onVmsMessageReceived(VmsLayer param1VmsLayer, byte[] param1ArrayOfbyte) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.vms.IVmsSubscriberClient");
/*     */         if (param1VmsLayer != null) {
/*     */           parcel.writeInt(1);
/*     */           param1VmsLayer.writeToParcel(parcel, 0);
/*     */         } else {
/*     */           parcel.writeInt(0);
/*     */         } 
/*     */         parcel.writeByteArray(param1ArrayOfbyte);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\IVmsSubscriberClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */