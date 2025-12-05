/*    */ package android.car.hardware;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICarSensorEventListener
/*    */   extends IInterface {
/*    */   void onSensorChanged(List<CarSensorEvent> paramList) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ICarSensorEventListener {
/*    */     private static final String DESCRIPTOR = "android.car.hardware.ICarSensorEventListener";
/*    */     static final int TRANSACTION_onSensorChanged = 1;
/*    */     
/*    */     public Stub() {
/* 20 */       attachInterface(this, "android.car.hardware.ICarSensorEventListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarSensorEventListener asInterface(IBinder param1IBinder) {
/* 28 */       if (param1IBinder == null) {
/* 29 */         return null;
/*    */       }
/* 31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.hardware.ICarSensorEventListener");
/* 32 */       if (iInterface != null && iInterface instanceof ICarSensorEventListener) {
/* 33 */         return (ICarSensorEventListener)iInterface;
/*    */       }
/* 35 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 39 */       return (IBinder)this;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/* 44 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
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
/* 61 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("android.car.hardware.ICarSensorEventListener");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.hardware.ICarSensorEventListener");
/*    */       ArrayList<CarSensorEvent> arrayList = param1Parcel1.createTypedArrayList(CarSensorEvent.CREATOR);
/*    */       onSensorChanged(arrayList);
/*    */       return true;
/*    */     } private static class Proxy implements ICarSensorEventListener { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 70 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 74 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 78 */         return "android.car.hardware.ICarSensorEventListener";
/*    */       }
/*    */       
/*    */       public void onSensorChanged(List<CarSensorEvent> param2List) throws RemoteException {
/* 82 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 84 */         try { parcel.writeInterfaceToken("android.car.hardware.ICarSensorEventListener");
/* 85 */           parcel.writeTypedList(param2List);
/* 86 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 89 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarSensorEventListener { public void onSensorChanged(List<CarSensorEvent> param1List) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.hardware.ICarSensorEventListener"); parcel.writeTypedList(param1List); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.hardware.ICarSensorEventListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\ICarSensorEventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */