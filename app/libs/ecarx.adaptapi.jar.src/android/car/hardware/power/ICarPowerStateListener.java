/*    */ package android.car.hardware.power;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarPowerStateListener
/*    */   extends IInterface {
/*    */   void onStateChanged(int paramInt1, int paramInt2) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder implements ICarPowerStateListener {
/*    */     private static final String DESCRIPTOR = "android.car.hardware.power.ICarPowerStateListener";
/*    */     static final int TRANSACTION_onStateChanged = 1;
/*    */     
/*    */     public Stub() {
/* 19 */       attachInterface(this, "android.car.hardware.power.ICarPowerStateListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarPowerStateListener asInterface(IBinder param1IBinder) {
/* 27 */       if (param1IBinder == null) {
/* 28 */         return null;
/*    */       }
/* 30 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.hardware.power.ICarPowerStateListener");
/* 31 */       if (iInterface != null && iInterface instanceof ICarPowerStateListener) {
/* 32 */         return (ICarPowerStateListener)iInterface;
/*    */       }
/* 34 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 38 */       return (IBinder)this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*    */     {
/* 43 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
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
/*    */ 
/*    */           
/* 62 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("android.car.hardware.power.ICarPowerStateListener");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.hardware.power.ICarPowerStateListener");
/*    */       param1Int1 = param1Parcel1.readInt();
/*    */       param1Int2 = param1Parcel1.readInt();
/*    */       onStateChanged(param1Int1, param1Int2);
/*    */       return true; } private static class Proxy implements ICarPowerStateListener { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 71 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 75 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 79 */         return "android.car.hardware.power.ICarPowerStateListener";
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public void onStateChanged(int param2Int1, int param2Int2) throws RemoteException
/*    */       {
/* 86 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 88 */         try { parcel.writeInterfaceToken("android.car.hardware.power.ICarPowerStateListener");
/* 89 */           parcel.writeInt(param2Int1);
/* 90 */           parcel.writeInt(param2Int2);
/* 91 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 94 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarPowerStateListener { public void onStateChanged(int param1Int1, int param1Int2) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.hardware.power.ICarPowerStateListener"); parcel.writeInt(param1Int1); parcel.writeInt(param1Int2); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.hardware.power.ICarPowerStateListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\power\ICarPowerStateListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */