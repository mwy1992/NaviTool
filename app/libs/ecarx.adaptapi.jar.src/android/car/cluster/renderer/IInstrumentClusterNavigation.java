/*     */ package android.car.cluster.renderer;
/*     */ 
/*     */ import android.car.navigation.CarNavigationInstrumentCluster;
/*     */ import android.os.Bundle;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IInstrumentClusterNavigation extends IInterface {
/*     */   CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException;
/*     */   
/*     */   void onEvent(int paramInt, Bundle paramBundle) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IInstrumentClusterNavigation { private static final String DESCRIPTOR = "android.car.cluster.renderer.IInstrumentClusterNavigation";
/*     */     static final int TRANSACTION_getInstrumentClusterInfo = 2;
/*     */     static final int TRANSACTION_onEvent = 1;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.cluster.renderer.IInstrumentClusterNavigation");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IInstrumentClusterNavigation asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.cluster.renderer.IInstrumentClusterNavigation");
/*  32 */       if (iInterface != null && iInterface instanceof IInstrumentClusterNavigation) {
/*  33 */         return (IInstrumentClusterNavigation)iInterface;
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
/*  44 */       if (param1Int1 != 1598968902) { CarNavigationInstrumentCluster carNavigationInstrumentCluster; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  83 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.cluster.renderer.IInstrumentClusterNavigation"); carNavigationInstrumentCluster = getInstrumentClusterInfo(); param1Parcel2.writeNoException(); if (carNavigationInstrumentCluster != null) { param1Parcel2.writeInt(1); carNavigationInstrumentCluster.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }
/*     */              return true;
/*     */           case 1:
/*     */             break;
/*     */         }  carNavigationInstrumentCluster.enforceInterface("android.car.cluster.renderer.IInstrumentClusterNavigation"); param1Int1 = carNavigationInstrumentCluster.readInt(); if (carNavigationInstrumentCluster.readInt() != 0) { Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)carNavigationInstrumentCluster); }
/*     */         else { carNavigationInstrumentCluster = null; }
/*     */          onEvent(param1Int1, (Bundle)carNavigationInstrumentCluster); param1Parcel2.writeNoException(); return true; }
/*  92 */        param1Parcel2.writeString("android.car.cluster.renderer.IInstrumentClusterNavigation"); return true; } private static class Proxy implements IInstrumentClusterNavigation { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  96 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 100 */         return "android.car.cluster.renderer.IInstrumentClusterNavigation";
/*     */       }
/*     */       
/*     */       public void onEvent(int param2Int, Bundle param2Bundle) throws RemoteException {
/* 104 */         Parcel parcel2 = Parcel.obtain();
/* 105 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 107 */           parcel2.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterNavigation");
/* 108 */           parcel2.writeInt(param2Int);
/* 109 */           if (param2Bundle != null) {
/* 110 */             parcel2.writeInt(1);
/* 111 */             param2Bundle.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 114 */             parcel2.writeInt(0);
/*     */           } 
/* 116 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 117 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 120 */           parcel1.recycle();
/* 121 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException {
/* 126 */         Parcel parcel1 = Parcel.obtain();
/* 127 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try { CarNavigationInstrumentCluster carNavigationInstrumentCluster;
/* 130 */           parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterNavigation");
/* 131 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 132 */           parcel2.readException();
/* 133 */           if (parcel2.readInt() != 0) {
/* 134 */             carNavigationInstrumentCluster = (CarNavigationInstrumentCluster)CarNavigationInstrumentCluster.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 137 */             carNavigationInstrumentCluster = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 144 */           return carNavigationInstrumentCluster; } finally { parcel2.recycle(); parcel1.recycle(); }  } } } private static class Proxy implements IInstrumentClusterNavigation { private IBinder mRemote; public CarNavigationInstrumentCluster getInstrumentClusterInfo() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { CarNavigationInstrumentCluster carNavigationInstrumentCluster; parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterNavigation"); this.mRemote.transact(2, parcel1, parcel2, 0); parcel2.readException(); if (parcel2.readInt() != 0) { carNavigationInstrumentCluster = (CarNavigationInstrumentCluster)CarNavigationInstrumentCluster.CREATOR.createFromParcel(parcel2); } else { carNavigationInstrumentCluster = null; }  return carNavigationInstrumentCluster; }
/*     */       finally
/*     */       { parcel2.recycle();
/*     */         parcel1.recycle(); }
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
/*     */       return "android.car.cluster.renderer.IInstrumentClusterNavigation";
/*     */     }
/*     */     
/*     */     public void onEvent(int param1Int, Bundle param1Bundle) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterNavigation");
/*     */         parcel2.writeInt(param1Int);
/*     */         if (param1Bundle != null) {
/*     */           parcel2.writeInt(1);
/*     */           param1Bundle.writeToParcel(parcel2, 0);
/*     */         } else {
/*     */           parcel2.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\IInstrumentClusterNavigation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */