/*    */ package android.car.drivingstate;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarUxRestrictionsChangeListener
/*    */   extends IInterface {
/*    */   void onUxRestrictionsChanged(CarUxRestrictions paramCarUxRestrictions) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ICarUxRestrictionsChangeListener {
/*    */     private static final String DESCRIPTOR = "android.car.drivingstate.ICarUxRestrictionsChangeListener";
/*    */     static final int TRANSACTION_onUxRestrictionsChanged = 1;
/*    */     
/*    */     public Stub() {
/* 18 */       attachInterface(this, "android.car.drivingstate.ICarUxRestrictionsChangeListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarUxRestrictionsChangeListener asInterface(IBinder param1IBinder) {
/* 26 */       if (param1IBinder == null) {
/* 27 */         return null;
/*    */       }
/* 29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.drivingstate.ICarUxRestrictionsChangeListener");
/* 30 */       if (iInterface != null && iInterface instanceof ICarUxRestrictionsChangeListener) {
/* 31 */         return (ICarUxRestrictionsChangeListener)iInterface;
/*    */       }
/* 33 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 37 */       return (IBinder)this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*    */     {
/* 42 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
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
/* 64 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.drivingstate.ICarUxRestrictionsChangeListener"); return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.drivingstate.ICarUxRestrictionsChangeListener");
/*    */       if (param1Parcel1.readInt() != 0) {
/*    */         CarUxRestrictions carUxRestrictions = (CarUxRestrictions)CarUxRestrictions.CREATOR.createFromParcel(param1Parcel1);
/*    */       } else {
/*    */         param1Parcel1 = null;
/*    */       } 
/*    */       onUxRestrictionsChanged((CarUxRestrictions)param1Parcel1);
/* 73 */       return true; } private static class Proxy implements ICarUxRestrictionsChangeListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*    */ 
/*    */       
/*    */       public IBinder asBinder() {
/* 77 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 81 */         return "android.car.drivingstate.ICarUxRestrictionsChangeListener";
/*    */       }
/*    */       
/*    */       public void onUxRestrictionsChanged(CarUxRestrictions param2CarUxRestrictions) throws RemoteException {
/* 85 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 87 */         try { parcel.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsChangeListener");
/* 88 */           if (param2CarUxRestrictions != null) {
/* 89 */             parcel.writeInt(1);
/* 90 */             param2CarUxRestrictions.writeToParcel(parcel, 0);
/*    */           } else {
/*    */             
/* 93 */             parcel.writeInt(0);
/*    */           } 
/* 95 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 98 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarUxRestrictionsChangeListener { public void onUxRestrictionsChanged(CarUxRestrictions param1CarUxRestrictions) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.drivingstate.ICarUxRestrictionsChangeListener"); if (param1CarUxRestrictions != null) { parcel.writeInt(1); param1CarUxRestrictions.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.drivingstate.ICarUxRestrictionsChangeListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\drivingstate\ICarUxRestrictionsChangeListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */