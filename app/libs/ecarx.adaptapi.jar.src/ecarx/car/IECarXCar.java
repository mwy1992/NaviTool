/*     */ package ecarx.car;
/*     */ 
/*     */ public interface IECarXCar extends IInterface {
/*     */   int getCarConnectionType() throws RemoteException;
/*     */   
/*     */   IBinder getCarService(String paramString) throws RemoteException;
/*     */   
/*     */   void setCarServiceHelper(IBinder paramIBinder) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IECarXCar { private static final String DESCRIPTOR = "ecarx.car.IECarXCar";
/*     */     static final int TRANSACTION_getCarConnectionType = 3;
/*     */     static final int TRANSACTION_getCarService = 2;
/*     */     static final int TRANSACTION_setCarServiceHelper = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "ecarx.car.IECarXCar");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IECarXCar asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IECarXCar");
/*  28 */       if (iInterface != null && iInterface instanceof IECarXCar) {
/*  29 */         return (IECarXCar)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { String str; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  75 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IECarXCar"); param1Int1 = getCarConnectionType(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IECarXCar"); str = param1Parcel1.readString(); iBinder = getCarService(str); param1Parcel2.writeNoException(); param1Parcel2.writeStrongBinder(iBinder); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  iBinder.enforceInterface("ecarx.car.IECarXCar"); IBinder iBinder = iBinder.readStrongBinder(); setCarServiceHelper(iBinder); return true; }
/*     */        param1Parcel2.writeString("ecarx.car.IECarXCar");
/*  84 */       return true; } private static class Proxy implements IECarXCar { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  88 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  92 */         return "ecarx.car.IECarXCar";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setCarServiceHelper(IBinder param2IBinder) throws RemoteException {
/* 101 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 103 */           parcel.writeInterfaceToken("ecarx.car.IECarXCar");
/* 104 */           parcel.writeStrongBinder(param2IBinder);
/* 105 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 108 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public IBinder getCarService(String param2String) throws RemoteException {
/* 113 */         Parcel parcel2 = Parcel.obtain();
/* 114 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 117 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCar");
/* 118 */           parcel2.writeString(param2String);
/* 119 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 120 */           parcel1.readException();
/* 121 */           return parcel1.readStrongBinder();
/*     */         } finally {
/*     */           
/* 124 */           parcel1.recycle();
/* 125 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getCarConnectionType() throws RemoteException
/*     */       {
/* 131 */         Parcel parcel1 = Parcel.obtain();
/* 132 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 135 */         try { parcel1.writeInterfaceToken("ecarx.car.IECarXCar");
/* 136 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 137 */           parcel2.readException();
/* 138 */           return parcel2.readInt(); }
/*     */         finally
/*     */         
/* 141 */         { parcel2.recycle();
/* 142 */           parcel1.recycle(); }  } } } private static class Proxy implements IECarXCar { private IBinder mRemote; public int getCarConnectionType() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IECarXCar"); this.mRemote.transact(3, parcel1, parcel2, 0); parcel2.readException(); return parcel2.readInt(); } finally { parcel2.recycle(); parcel1.recycle(); }
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
/*     */       return "ecarx.car.IECarXCar";
/*     */     }
/*     */     
/*     */     public void setCarServiceHelper(IBinder param1IBinder) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("ecarx.car.IECarXCar");
/*     */         parcel.writeStrongBinder(param1IBinder);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public IBinder getCarService(String param1String) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IECarXCar");
/*     */         parcel2.writeString(param1String);
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.readStrongBinder();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IECarXCar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */