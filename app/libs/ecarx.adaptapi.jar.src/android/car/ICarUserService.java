/*    */ package android.car;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarUserService extends IInterface {
/*    */   ICarBluetoothUserService getBluetoothUserService() throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ICarUserService { private static final String DESCRIPTOR = "android.car.ICarUserService";
/*    */     static final int TRANSACTION_getBluetoothUserService = 1;
/*    */     
/*    */     public Stub() {
/* 16 */       attachInterface(this, "android.car.ICarUserService");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarUserService asInterface(IBinder param1IBinder) {
/* 24 */       if (param1IBinder == null) {
/* 25 */         return null;
/*    */       }
/* 27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.ICarUserService");
/* 28 */       if (iInterface != null && iInterface instanceof ICarUserService) {
/* 29 */         return (ICarUserService)iInterface;
/*    */       }
/* 31 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 35 */       return (IBinder)this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*    */     {
/* 40 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 57 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.ICarUserService"); return true; }
/*    */        param1Parcel1.enforceInterface("android.car.ICarUserService"); ICarBluetoothUserService iCarBluetoothUserService = getBluetoothUserService();
/*    */       param1Parcel2.writeNoException();
/*    */       if (iCarBluetoothUserService != null) {
/*    */         IBinder iBinder = iCarBluetoothUserService.asBinder();
/*    */       } else {
/*    */         iCarBluetoothUserService = null;
/*    */       } 
/*    */       param1Parcel2.writeStrongBinder((IBinder)iCarBluetoothUserService);
/* 66 */       return true; } private static class Proxy implements ICarUserService { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*    */ 
/*    */       
/*    */       public IBinder asBinder() {
/* 70 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 74 */         return "android.car.ICarUserService";
/*    */       }
/*    */       
/*    */       public ICarBluetoothUserService getBluetoothUserService() throws RemoteException {
/* 78 */         Parcel parcel2 = Parcel.obtain();
/* 79 */         Parcel parcel1 = Parcel.obtain();
/*    */ 
/*    */         
/* 82 */         try { parcel2.writeInterfaceToken("android.car.ICarUserService");
/* 83 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 84 */           parcel1.readException();
/* 85 */           return ICarBluetoothUserService.Stub.asInterface(parcel1.readStrongBinder()); }
/*    */         finally
/*    */         
/* 88 */         { parcel1.recycle();
/* 89 */           parcel2.recycle(); }  } } } private static class Proxy implements ICarUserService { public ICarBluetoothUserService getBluetoothUserService() throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.ICarUserService"); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return ICarBluetoothUserService.Stub.asInterface(parcel1.readStrongBinder()); } finally { parcel1.recycle(); parcel2.recycle(); }
/*    */        }
/*    */ 
/*    */     
/*    */     private IBinder mRemote;
/*    */     
/*    */     Proxy(IBinder param1IBinder) {
/*    */       this.mRemote = param1IBinder;
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/*    */       return this.mRemote;
/*    */     }
/*    */     
/*    */     public String getInterfaceDescriptor() {
/*    */       return "android.car.ICarUserService";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\ICarUserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */