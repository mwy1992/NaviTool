/*    */ package android.car.drivingstate;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarDrivingStateChangeListener
/*    */   extends IInterface {
/*    */   void onDrivingStateChanged(CarDrivingStateEvent paramCarDrivingStateEvent) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder implements ICarDrivingStateChangeListener {
/*    */     private static final String DESCRIPTOR = "android.car.drivingstate.ICarDrivingStateChangeListener";
/*    */     static final int TRANSACTION_onDrivingStateChanged = 1;
/*    */     
/*    */     public Stub() {
/* 19 */       attachInterface(this, "android.car.drivingstate.ICarDrivingStateChangeListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarDrivingStateChangeListener asInterface(IBinder param1IBinder) {
/* 27 */       if (param1IBinder == null) {
/* 28 */         return null;
/*    */       }
/* 30 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.drivingstate.ICarDrivingStateChangeListener");
/* 31 */       if (iInterface != null && iInterface instanceof ICarDrivingStateChangeListener) {
/* 32 */         return (ICarDrivingStateChangeListener)iInterface;
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
/*    */ 
/*    */ 
/*    */           
/* 65 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.drivingstate.ICarDrivingStateChangeListener"); return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.drivingstate.ICarDrivingStateChangeListener");
/*    */       if (param1Parcel1.readInt() != 0) {
/*    */         CarDrivingStateEvent carDrivingStateEvent = (CarDrivingStateEvent)CarDrivingStateEvent.CREATOR.createFromParcel(param1Parcel1);
/*    */       } else {
/*    */         param1Parcel1 = null;
/*    */       } 
/*    */       onDrivingStateChanged((CarDrivingStateEvent)param1Parcel1);
/* 74 */       return true; } private static class Proxy implements ICarDrivingStateChangeListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*    */ 
/*    */       
/*    */       public IBinder asBinder() {
/* 78 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 82 */         return "android.car.drivingstate.ICarDrivingStateChangeListener";
/*    */       }
/*    */       
/*    */       public void onDrivingStateChanged(CarDrivingStateEvent param2CarDrivingStateEvent) throws RemoteException {
/* 86 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 88 */         try { parcel.writeInterfaceToken("android.car.drivingstate.ICarDrivingStateChangeListener");
/* 89 */           if (param2CarDrivingStateEvent != null) {
/* 90 */             parcel.writeInt(1);
/* 91 */             param2CarDrivingStateEvent.writeToParcel(parcel, 0);
/*    */           } else {
/*    */             
/* 94 */             parcel.writeInt(0);
/*    */           } 
/* 96 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 99 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarDrivingStateChangeListener { public void onDrivingStateChanged(CarDrivingStateEvent param1CarDrivingStateEvent) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.drivingstate.ICarDrivingStateChangeListener"); if (param1CarDrivingStateEvent != null) { parcel.writeInt(1); param1CarDrivingStateEvent.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.drivingstate.ICarDrivingStateChangeListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\ICarDrivingStateChangeListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */