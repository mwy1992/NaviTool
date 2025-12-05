/*     */ package android.car.cluster.renderer;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ import android.view.KeyEvent;
/*     */ 
/*     */ public interface IInstrumentCluster extends IInterface {
/*     */   IInstrumentClusterNavigation getNavigationService() throws RemoteException;
/*     */   
/*     */   void onKeyEvent(KeyEvent paramKeyEvent) throws RemoteException;
/*     */   
/*     */   void setNavigationContextOwner(int paramInt1, int paramInt2) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IInstrumentCluster { private static final String DESCRIPTOR = "android.car.cluster.renderer.IInstrumentCluster";
/*     */     static final int TRANSACTION_getNavigationService = 1;
/*     */     static final int TRANSACTION_onKeyEvent = 3;
/*     */     static final int TRANSACTION_setNavigationContextOwner = 2;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.cluster.renderer.IInstrumentCluster");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IInstrumentCluster asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.cluster.renderer.IInstrumentCluster");
/*  32 */       if (iInterface != null && iInterface instanceof IInstrumentCluster) {
/*  33 */         return (IInstrumentCluster)iInterface;
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
/*  44 */       if (param1Int1 != 1598968902) { IBinder iBinder; Parcel parcel1 = null, parcel2 = null; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  84 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.cluster.renderer.IInstrumentCluster"); if (param1Parcel1.readInt() != 0) { KeyEvent keyEvent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel2; }  onKeyEvent((KeyEvent)param1Parcel1); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.cluster.renderer.IInstrumentCluster"); param1Int2 = param1Parcel1.readInt(); param1Int1 = param1Parcel1.readInt(); setNavigationContextOwner(param1Int2, param1Int1); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("android.car.cluster.renderer.IInstrumentCluster"); IInstrumentClusterNavigation iInstrumentClusterNavigation = getNavigationService(); param1Parcel2.writeNoException(); param1Parcel1 = parcel1; if (iInstrumentClusterNavigation != null)
/*     */           iBinder = iInstrumentClusterNavigation.asBinder();  param1Parcel2.writeStrongBinder(iBinder); return true; }
/*  93 */        param1Parcel2.writeString("android.car.cluster.renderer.IInstrumentCluster"); return true; } private static class Proxy implements IInstrumentCluster { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  97 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 101 */         return "android.car.cluster.renderer.IInstrumentCluster";
/*     */       }
/*     */ 
/*     */       
/*     */       public IInstrumentClusterNavigation getNavigationService() throws RemoteException {
/* 106 */         Parcel parcel1 = Parcel.obtain();
/* 107 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 110 */           parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentCluster");
/* 111 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 112 */           parcel2.readException();
/* 113 */           return IInstrumentClusterNavigation.Stub.asInterface(parcel2.readStrongBinder());
/*     */         } finally {
/*     */           
/* 116 */           parcel2.recycle();
/* 117 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void setNavigationContextOwner(int param2Int1, int param2Int2) throws RemoteException {
/* 124 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/* 126 */           parcel.writeInterfaceToken("android.car.cluster.renderer.IInstrumentCluster");
/* 127 */           parcel.writeInt(param2Int1);
/* 128 */           parcel.writeInt(param2Int2);
/* 129 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/* 132 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onKeyEvent(KeyEvent param2KeyEvent) throws RemoteException
/*     */       {
/* 138 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 140 */         try { parcel.writeInterfaceToken("android.car.cluster.renderer.IInstrumentCluster");
/* 141 */           if (param2KeyEvent != null) {
/* 142 */             parcel.writeInt(1);
/* 143 */             param2KeyEvent.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/* 146 */             parcel.writeInt(0);
/*     */           } 
/* 148 */           this.mRemote.transact(3, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 151 */         { parcel.recycle(); }  } } } private static class Proxy implements IInstrumentCluster { private IBinder mRemote; public void onKeyEvent(KeyEvent param1KeyEvent) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.cluster.renderer.IInstrumentCluster"); if (param1KeyEvent != null) { parcel.writeInt(1); param1KeyEvent.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(3, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.cluster.renderer.IInstrumentCluster";
/*     */     }
/*     */     
/*     */     public IInstrumentClusterNavigation getNavigationService() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentCluster");
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return IInstrumentClusterNavigation.Stub.asInterface(parcel2.readStrongBinder());
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setNavigationContextOwner(int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.cluster.renderer.IInstrumentCluster");
/*     */         parcel.writeInt(param1Int1);
/*     */         parcel.writeInt(param1Int2);
/*     */         this.mRemote.transact(2, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\IInstrumentCluster.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */