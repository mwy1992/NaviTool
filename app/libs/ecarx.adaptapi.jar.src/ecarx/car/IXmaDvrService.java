/*     */ package ecarx.car;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public interface IXmaDvrService extends IInterface {
/*     */   boolean checkActivateDvrVfc(int paramInt) throws RemoteException;
/*     */   
/*     */   int sendSignal(int paramInt1, int paramInt2, int paramInt3) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IXmaDvrService { private static final String DESCRIPTOR = "ecarx.car.IXmaDvrService";
/*     */     static final int TRANSACTION_checkActivateDvrVfc = 2;
/*     */     static final int TRANSACTION_sendSignal = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "ecarx.car.IXmaDvrService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IXmaDvrService asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IXmaDvrService");
/*  28 */       if (iInterface != null && iInterface instanceof IXmaDvrService) {
/*  29 */         return (IXmaDvrService)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool; switch (param1Int1) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  73 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IXmaDvrService"); param1Int1 = param1Parcel1.readInt(); bool = checkActivateDvrVfc(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("ecarx.car.IXmaDvrService"); param1Int2 = param1Parcel1.readInt(); int i = param1Parcel1.readInt(); int j = param1Parcel1.readInt(); i = sendSignal(param1Int2, i, j); param1Parcel2.writeNoException(); param1Parcel2.writeInt(i);
/*     */         return true; }
/*     */       
/*     */       param1Parcel2.writeString("ecarx.car.IXmaDvrService");
/*  82 */       return true; } private static class Proxy implements IXmaDvrService { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  86 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  90 */         return "ecarx.car.IXmaDvrService";
/*     */       }
/*     */       
/*     */       public int sendSignal(int param2Int1, int param2Int2, int param2Int3) throws RemoteException {
/*  94 */         Parcel parcel2 = Parcel.obtain();
/*  95 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/*  98 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrService");
/*  99 */           parcel2.writeInt(param2Int1);
/* 100 */           parcel2.writeInt(param2Int2);
/* 101 */           parcel2.writeInt(param2Int3);
/* 102 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 103 */           parcel1.readException();
/* 104 */           param2Int1 = parcel1.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 110 */           return param2Int1;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean checkActivateDvrVfc(int param2Int) throws RemoteException
/*     */       {
/* 121 */         Parcel parcel1 = Parcel.obtain();
/* 122 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 125 */         try { parcel1.writeInterfaceToken("ecarx.car.IXmaDvrService");
/* 126 */           parcel1.writeInt(param2Int);
/* 127 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel1, parcel2, 0);
/* 128 */           parcel2.readException();
/* 129 */           param2Int = parcel2.readInt(); if (param2Int != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 135 */           return bool; } finally { parcel2.recycle(); parcel1.recycle(); }  } } } private static class Proxy implements IXmaDvrService { public boolean checkActivateDvrVfc(int param1Int) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IXmaDvrService"); parcel1.writeInt(param1Int); IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel1, parcel2, 0); parcel2.readException(); param1Int = parcel2.readInt(); if (param1Int != 0) bool = true;  return bool; }
/*     */       finally
/*     */       { parcel2.recycle();
/*     */         parcel1.recycle(); }
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
/*     */       return "ecarx.car.IXmaDvrService";
/*     */     }
/*     */     
/*     */     public int sendSignal(int param1Int1, int param1Int2, int param1Int3) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IXmaDvrService");
/*     */         parcel2.writeInt(param1Int1);
/*     */         parcel2.writeInt(param1Int2);
/*     */         parcel2.writeInt(param1Int3);
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         param1Int1 = parcel1.readInt();
/*     */         return param1Int1;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IXmaDvrService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */