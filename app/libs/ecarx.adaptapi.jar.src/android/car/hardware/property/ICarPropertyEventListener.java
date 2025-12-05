/*    */ package android.car.hardware.property;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICarPropertyEventListener
/*    */   extends IInterface {
/*    */   void onEvent(List<CarPropertyEvent> paramList) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ICarPropertyEventListener {
/*    */     private static final String DESCRIPTOR = "android.car.hardware.property.ICarPropertyEventListener";
/*    */     static final int TRANSACTION_onEvent = 1;
/*    */     
/*    */     public Stub() {
/* 20 */       attachInterface(this, "android.car.hardware.property.ICarPropertyEventListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarPropertyEventListener asInterface(IBinder param1IBinder) {
/* 28 */       if (param1IBinder == null) {
/* 29 */         return null;
/*    */       }
/* 31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.hardware.property.ICarPropertyEventListener");
/* 32 */       if (iInterface != null && iInterface instanceof ICarPropertyEventListener) {
/* 33 */         return (ICarPropertyEventListener)iInterface;
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
/*    */         param1Parcel2.writeString("android.car.hardware.property.ICarPropertyEventListener");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.hardware.property.ICarPropertyEventListener");
/*    */       ArrayList<CarPropertyEvent> arrayList = param1Parcel1.createTypedArrayList(CarPropertyEvent.CREATOR);
/*    */       onEvent(arrayList);
/*    */       return true;
/*    */     } private static class Proxy implements ICarPropertyEventListener { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 70 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 74 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 78 */         return "android.car.hardware.property.ICarPropertyEventListener";
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void onEvent(List<CarPropertyEvent> param2List) throws RemoteException
/*    */       {
/* 86 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 88 */         try { parcel.writeInterfaceToken("android.car.hardware.property.ICarPropertyEventListener");
/* 89 */           parcel.writeTypedList(param2List);
/* 90 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 93 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarPropertyEventListener { public void onEvent(List<CarPropertyEvent> param1List) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.hardware.property.ICarPropertyEventListener"); parcel.writeTypedList(param1List); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.hardware.property.ICarPropertyEventListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\property\ICarPropertyEventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */