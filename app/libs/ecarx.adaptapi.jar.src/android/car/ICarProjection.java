/*     */ package android.car;
/*     */ 
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public interface ICarProjection extends IInterface {
/*     */   void registerProjectionListener(ICarProjectionCallback paramICarProjectionCallback, int paramInt) throws RemoteException;
/*     */   
/*     */   void registerProjectionRunner(Intent paramIntent) throws RemoteException;
/*     */   
/*     */   void unregisterProjectionListener(ICarProjectionCallback paramICarProjectionCallback) throws RemoteException;
/*     */   
/*     */   void unregisterProjectionRunner(Intent paramIntent) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarProjection { private static final String DESCRIPTOR = "android.car.ICarProjection";
/*     */     static final int TRANSACTION_registerProjectionListener = 3;
/*     */     static final int TRANSACTION_registerProjectionRunner = 1;
/*     */     static final int TRANSACTION_unregisterProjectionListener = 4;
/*     */     static final int TRANSACTION_unregisterProjectionRunner = 2;
/*     */     
/*     */     public Stub() {
/*  21 */       attachInterface(this, "android.car.ICarProjection");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarProjection asInterface(IBinder param1IBinder) {
/*  29 */       if (param1IBinder == null) {
/*  30 */         return null;
/*     */       }
/*  32 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.ICarProjection");
/*  33 */       if (iInterface != null && iInterface instanceof ICarProjection) {
/*  34 */         return (ICarProjection)iInterface;
/*     */       }
/*  36 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  40 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  45 */       if (param1Int1 != 1598968902) { ICarProjectionCallback iCarProjectionCallback1, iCarProjectionCallback2 = null, iCarProjectionCallback3 = null; switch (param1Int1)
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
/*     */           default:
/* 102 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.ICarProjection"); iCarProjectionCallback1 = ICarProjectionCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); unregisterProjectionListener(iCarProjectionCallback1); param1Parcel2.writeNoException(); return true;
/*     */           case 3:
/*     */             iCarProjectionCallback1.enforceInterface("android.car.ICarProjection"); iCarProjectionCallback2 = ICarProjectionCallback.Stub.asInterface(iCarProjectionCallback1.readStrongBinder()); param1Int1 = iCarProjectionCallback1.readInt(); registerProjectionListener(iCarProjectionCallback2, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 2:
/*     */             iCarProjectionCallback1.enforceInterface("android.car.ICarProjection"); if (iCarProjectionCallback1.readInt() != 0) { Intent intent = (Intent)Intent.CREATOR.createFromParcel((Parcel)iCarProjectionCallback1); } else { iCarProjectionCallback1 = iCarProjectionCallback3; }  unregisterProjectionRunner((Intent)iCarProjectionCallback1); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break; }  iCarProjectionCallback1.enforceInterface("android.car.ICarProjection"); if (iCarProjectionCallback1.readInt() != 0) { Intent intent = (Intent)Intent.CREATOR.createFromParcel((Parcel)iCarProjectionCallback1); } else { iCarProjectionCallback1 = iCarProjectionCallback2; }  registerProjectionRunner((Intent)iCarProjectionCallback1); param1Parcel2.writeNoException(); return true; }
/* 111 */        param1Parcel2.writeString("android.car.ICarProjection"); return true; } private static class Proxy implements ICarProjection { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 115 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 119 */         return "android.car.ICarProjection";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void registerProjectionRunner(Intent param2Intent) throws RemoteException {
/* 127 */         Parcel parcel1 = Parcel.obtain();
/* 128 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 130 */           parcel1.writeInterfaceToken("android.car.ICarProjection");
/* 131 */           if (param2Intent != null) {
/* 132 */             parcel1.writeInt(1);
/* 133 */             param2Intent.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 136 */             parcel1.writeInt(0);
/*     */           } 
/* 138 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 139 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 142 */           parcel2.recycle();
/* 143 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void unregisterProjectionRunner(Intent param2Intent) throws RemoteException {
/* 152 */         Parcel parcel2 = Parcel.obtain();
/* 153 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 155 */           parcel2.writeInterfaceToken("android.car.ICarProjection");
/* 156 */           if (param2Intent != null) {
/* 157 */             parcel2.writeInt(1);
/* 158 */             param2Intent.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 161 */             parcel2.writeInt(0);
/*     */           } 
/* 163 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 164 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 167 */           parcel1.recycle();
/* 168 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void registerProjectionListener(ICarProjectionCallback param2ICarProjectionCallback, int param2Int) throws RemoteException {
/* 177 */         Parcel parcel1 = Parcel.obtain();
/* 178 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 180 */           parcel1.writeInterfaceToken("android.car.ICarProjection");
/* 181 */           if (param2ICarProjectionCallback != null) { IBinder iBinder = param2ICarProjectionCallback.asBinder(); } else { param2ICarProjectionCallback = null; }  parcel1.writeStrongBinder((IBinder)param2ICarProjectionCallback);
/* 182 */           parcel1.writeInt(param2Int);
/* 183 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 184 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 187 */           parcel2.recycle();
/* 188 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void unregisterProjectionListener(ICarProjectionCallback param2ICarProjectionCallback) throws RemoteException
/*     */       {
/* 196 */         Parcel parcel1 = Parcel.obtain();
/* 197 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/* 199 */         try { parcel1.writeInterfaceToken("android.car.ICarProjection");
/* 200 */           if (param2ICarProjectionCallback != null) { IBinder iBinder = param2ICarProjectionCallback.asBinder(); } else { param2ICarProjectionCallback = null; }  parcel1.writeStrongBinder((IBinder)param2ICarProjectionCallback);
/* 201 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 202 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 205 */         { parcel2.recycle();
/* 206 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarProjection { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public void unregisterProjectionListener(ICarProjectionCallback param1ICarProjectionCallback) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.ICarProjection"); if (param1ICarProjectionCallback != null) { IBinder iBinder = param1ICarProjectionCallback.asBinder(); } else { param1ICarProjectionCallback = null; }  parcel1.writeStrongBinder((IBinder)param1ICarProjectionCallback); this.mRemote.transact(4, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.ICarProjection";
/*     */     }
/*     */     
/*     */     public void registerProjectionRunner(Intent param1Intent) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.ICarProjection");
/*     */         if (param1Intent != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1Intent.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterProjectionRunner(Intent param1Intent) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.ICarProjection");
/*     */         if (param1Intent != null) {
/*     */           parcel2.writeInt(1);
/*     */           param1Intent.writeToParcel(parcel2, 0);
/*     */         } else {
/*     */           parcel2.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerProjectionListener(ICarProjectionCallback param1ICarProjectionCallback, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.ICarProjection");
/*     */         if (param1ICarProjectionCallback != null) {
/*     */           IBinder iBinder = param1ICarProjectionCallback.asBinder();
/*     */         } else {
/*     */           param1ICarProjectionCallback = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarProjectionCallback);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\ICarProjection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */