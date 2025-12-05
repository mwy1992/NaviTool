/*     */ package android.car.drivingstate;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarDrivingState extends IInterface {
/*     */   CarDrivingStateEvent getCurrentDrivingState() throws RemoteException;
/*     */   
/*     */   void registerDrivingStateChangeListener(ICarDrivingStateChangeListener paramICarDrivingStateChangeListener) throws RemoteException;
/*     */   
/*     */   void unregisterDrivingStateChangeListener(ICarDrivingStateChangeListener paramICarDrivingStateChangeListener) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarDrivingState { private static final String DESCRIPTOR = "android.car.drivingstate.ICarDrivingState";
/*     */     static final int TRANSACTION_getCurrentDrivingState = 3;
/*     */     static final int TRANSACTION_registerDrivingStateChangeListener = 1;
/*     */     static final int TRANSACTION_unregisterDrivingStateChangeListener = 2;
/*     */     
/*     */     public Stub() {
/*  22 */       attachInterface(this, "android.car.drivingstate.ICarDrivingState");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarDrivingState asInterface(IBinder param1IBinder) {
/*  30 */       if (param1IBinder == null) {
/*  31 */         return null;
/*     */       }
/*  33 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.drivingstate.ICarDrivingState");
/*  34 */       if (iInterface != null && iInterface instanceof ICarDrivingState) {
/*  35 */         return (ICarDrivingState)iInterface;
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
/*  46 */       if (param1Int1 != 1598968902) { CarDrivingStateEvent carDrivingStateEvent; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */             param1Parcel1.enforceInterface("android.car.drivingstate.ICarDrivingState"); carDrivingStateEvent = getCurrentDrivingState(); param1Parcel2.writeNoException(); if (carDrivingStateEvent != null) { param1Parcel2.writeInt(1); carDrivingStateEvent.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }
/*     */              return true;
/*     */           case 2:
/*     */             carDrivingStateEvent.enforceInterface("android.car.drivingstate.ICarDrivingState"); iCarDrivingStateChangeListener = ICarDrivingStateChangeListener.Stub.asInterface(carDrivingStateEvent.readStrongBinder()); unregisterDrivingStateChangeListener(iCarDrivingStateChangeListener); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  iCarDrivingStateChangeListener.enforceInterface("android.car.drivingstate.ICarDrivingState"); ICarDrivingStateChangeListener iCarDrivingStateChangeListener = ICarDrivingStateChangeListener.Stub.asInterface(iCarDrivingStateChangeListener.readStrongBinder()); registerDrivingStateChangeListener(iCarDrivingStateChangeListener); param1Parcel2.writeNoException(); return true; }
/*  96 */        param1Parcel2.writeString("android.car.drivingstate.ICarDrivingState"); return true; } private static class Proxy implements ICarDrivingState { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 100 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 104 */         return "android.car.drivingstate.ICarDrivingState";
/*     */       }
/*     */       
/*     */       public void registerDrivingStateChangeListener(ICarDrivingStateChangeListener param2ICarDrivingStateChangeListener) throws RemoteException {
/* 108 */         Parcel parcel1 = Parcel.obtain();
/* 109 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 111 */           parcel1.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
/* 112 */           if (param2ICarDrivingStateChangeListener != null) { IBinder iBinder = param2ICarDrivingStateChangeListener.asBinder(); } else { param2ICarDrivingStateChangeListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarDrivingStateChangeListener);
/* 113 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 114 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 117 */           parcel2.recycle();
/* 118 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterDrivingStateChangeListener(ICarDrivingStateChangeListener param2ICarDrivingStateChangeListener) throws RemoteException {
/* 123 */         Parcel parcel1 = Parcel.obtain();
/* 124 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 126 */           parcel1.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
/* 127 */           if (param2ICarDrivingStateChangeListener != null) { IBinder iBinder = param2ICarDrivingStateChangeListener.asBinder(); } else { param2ICarDrivingStateChangeListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarDrivingStateChangeListener);
/* 128 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 129 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 132 */           parcel2.recycle();
/* 133 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public CarDrivingStateEvent getCurrentDrivingState() throws RemoteException {
/* 138 */         Parcel parcel2 = Parcel.obtain();
/* 139 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try { CarDrivingStateEvent carDrivingStateEvent;
/* 142 */           parcel2.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
/* 143 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 144 */           parcel1.readException();
/* 145 */           if (parcel1.readInt() != 0) {
/* 146 */             carDrivingStateEvent = (CarDrivingStateEvent)CarDrivingStateEvent.CREATOR.createFromParcel(parcel1);
/*     */           } else {
/*     */             
/* 149 */             carDrivingStateEvent = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 156 */           return carDrivingStateEvent; } finally { parcel1.recycle(); parcel2.recycle(); }  } } } private static class Proxy implements ICarDrivingState { private IBinder mRemote; public CarDrivingStateEvent getCurrentDrivingState() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { CarDrivingStateEvent carDrivingStateEvent; parcel2.writeInterfaceToken("android.car.drivingstate.ICarDrivingState"); this.mRemote.transact(3, parcel2, parcel1, 0); parcel1.readException(); if (parcel1.readInt() != 0) { carDrivingStateEvent = (CarDrivingStateEvent)CarDrivingStateEvent.CREATOR.createFromParcel(parcel1); } else { carDrivingStateEvent = null; }  return carDrivingStateEvent; }
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
/*     */       return "android.car.drivingstate.ICarDrivingState";
/*     */     }
/*     */     
/*     */     public void registerDrivingStateChangeListener(ICarDrivingStateChangeListener param1ICarDrivingStateChangeListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
/*     */         if (param1ICarDrivingStateChangeListener != null) {
/*     */           IBinder iBinder = param1ICarDrivingStateChangeListener.asBinder();
/*     */         } else {
/*     */           param1ICarDrivingStateChangeListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarDrivingStateChangeListener);
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterDrivingStateChangeListener(ICarDrivingStateChangeListener param1ICarDrivingStateChangeListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.drivingstate.ICarDrivingState");
/*     */         if (param1ICarDrivingStateChangeListener != null) {
/*     */           IBinder iBinder = param1ICarDrivingStateChangeListener.asBinder();
/*     */         } else {
/*     */           param1ICarDrivingStateChangeListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarDrivingStateChangeListener);
/*     */         this.mRemote.transact(2, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\ICarDrivingState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */