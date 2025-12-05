/*     */ package android.car.drivingstate;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarUxRestrictionsManager extends IInterface {
/*     */   CarUxRestrictions getCurrentUxRestrictions() throws RemoteException;
/*     */   
/*     */   void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener paramICarUxRestrictionsChangeListener) throws RemoteException;
/*     */   
/*     */   void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener paramICarUxRestrictionsChangeListener) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarUxRestrictionsManager { private static final String DESCRIPTOR = "android.car.drivingstate.ICarUxRestrictionsManager";
/*     */     static final int TRANSACTION_getCurrentUxRestrictions = 3;
/*     */     static final int TRANSACTION_registerUxRestrictionsChangeListener = 1;
/*     */     static final int TRANSACTION_unregisterUxRestrictionsChangeListener = 2;
/*     */     
/*     */     public Stub() {
/*  22 */       attachInterface(this, "android.car.drivingstate.ICarUxRestrictionsManager");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarUxRestrictionsManager asInterface(IBinder param1IBinder) {
/*  30 */       if (param1IBinder == null) {
/*  31 */         return null;
/*     */       }
/*  33 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.drivingstate.ICarUxRestrictionsManager");
/*  34 */       if (iInterface != null && iInterface instanceof ICarUxRestrictionsManager) {
/*  35 */         return (ICarUxRestrictionsManager)iInterface;
/*     */       }
/*  37 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  41 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  46 */       if (param1Int1 != 1598968902) { CarUxRestrictions carUxRestrictions; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  87 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.drivingstate.ICarUxRestrictionsManager"); carUxRestrictions = getCurrentUxRestrictions(); param1Parcel2.writeNoException(); if (carUxRestrictions != null) { param1Parcel2.writeInt(1); carUxRestrictions.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }
/*     */              return true;
/*     */           case 2:
/*     */             carUxRestrictions.enforceInterface("android.car.drivingstate.ICarUxRestrictionsManager"); iCarUxRestrictionsChangeListener = ICarUxRestrictionsChangeListener.Stub.asInterface(carUxRestrictions.readStrongBinder()); unregisterUxRestrictionsChangeListener(iCarUxRestrictionsChangeListener); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  iCarUxRestrictionsChangeListener.enforceInterface("android.car.drivingstate.ICarUxRestrictionsManager"); ICarUxRestrictionsChangeListener iCarUxRestrictionsChangeListener = ICarUxRestrictionsChangeListener.Stub.asInterface(iCarUxRestrictionsChangeListener.readStrongBinder()); registerUxRestrictionsChangeListener(iCarUxRestrictionsChangeListener); param1Parcel2.writeNoException(); return true; }
/*  96 */        param1Parcel2.writeString("android.car.drivingstate.ICarUxRestrictionsManager"); return true; } private static class Proxy implements ICarUxRestrictionsManager { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 100 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 104 */         return "android.car.drivingstate.ICarUxRestrictionsManager";
/*     */       }
/*     */       
/*     */       public void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener param2ICarUxRestrictionsChangeListener) throws RemoteException {
/* 108 */         Parcel parcel2 = Parcel.obtain();
/* 109 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 111 */           parcel2.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
/* 112 */           if (param2ICarUxRestrictionsChangeListener != null) { IBinder iBinder = param2ICarUxRestrictionsChangeListener.asBinder(); } else { param2ICarUxRestrictionsChangeListener = null; }  parcel2.writeStrongBinder((IBinder)param2ICarUxRestrictionsChangeListener);
/* 113 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 114 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 117 */           parcel1.recycle();
/* 118 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener param2ICarUxRestrictionsChangeListener) throws RemoteException {
/* 123 */         Parcel parcel2 = Parcel.obtain();
/* 124 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 126 */           parcel2.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
/* 127 */           if (param2ICarUxRestrictionsChangeListener != null) { IBinder iBinder = param2ICarUxRestrictionsChangeListener.asBinder(); } else { param2ICarUxRestrictionsChangeListener = null; }  parcel2.writeStrongBinder((IBinder)param2ICarUxRestrictionsChangeListener);
/* 128 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 129 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 132 */           parcel1.recycle();
/* 133 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public CarUxRestrictions getCurrentUxRestrictions() throws RemoteException {
/* 138 */         Parcel parcel2 = Parcel.obtain();
/* 139 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try { CarUxRestrictions carUxRestrictions;
/* 142 */           parcel2.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
/* 143 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 144 */           parcel1.readException();
/* 145 */           if (parcel1.readInt() != 0) {
/* 146 */             carUxRestrictions = (CarUxRestrictions)CarUxRestrictions.CREATOR.createFromParcel(parcel1);
/*     */           } else {
/*     */             
/* 149 */             carUxRestrictions = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 156 */           return carUxRestrictions; } finally { parcel1.recycle(); parcel2.recycle(); }  } } } private static class Proxy implements ICarUxRestrictionsManager { private IBinder mRemote; public CarUxRestrictions getCurrentUxRestrictions() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { CarUxRestrictions carUxRestrictions; parcel2.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager"); this.mRemote.transact(3, parcel2, parcel1, 0); parcel1.readException(); if (parcel1.readInt() != 0) { carUxRestrictions = (CarUxRestrictions)CarUxRestrictions.CREATOR.createFromParcel(parcel1); } else { carUxRestrictions = null; }  return carUxRestrictions; }
/*     */       finally
/*     */       { parcel1.recycle();
/*     */         parcel2.recycle(); }
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
/*     */       return "android.car.drivingstate.ICarUxRestrictionsManager";
/*     */     }
/*     */     
/*     */     public void registerUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener param1ICarUxRestrictionsChangeListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
/*     */         if (param1ICarUxRestrictionsChangeListener != null) {
/*     */           IBinder iBinder = param1ICarUxRestrictionsChangeListener.asBinder();
/*     */         } else {
/*     */           param1ICarUxRestrictionsChangeListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarUxRestrictionsChangeListener);
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterUxRestrictionsChangeListener(ICarUxRestrictionsChangeListener param1ICarUxRestrictionsChangeListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsManager");
/*     */         if (param1ICarUxRestrictionsChangeListener != null) {
/*     */           IBinder iBinder = param1ICarUxRestrictionsChangeListener.asBinder();
/*     */         } else {
/*     */           param1ICarUxRestrictionsChangeListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarUxRestrictionsChangeListener);
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\ICarUxRestrictionsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */