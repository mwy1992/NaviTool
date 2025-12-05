/*    */ package android.car.diagnostic;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public interface ICarDiagnosticEventListener extends IInterface {
/*    */   void onDiagnosticEvents(List<CarDiagnosticEvent> paramList) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ICarDiagnosticEventListener { private static final String DESCRIPTOR = "android.car.diagnostic.ICarDiagnosticEventListener";
/*    */     static final int TRANSACTION_onDiagnosticEvents = 1;
/*    */     
/*    */     public Stub() {
/* 18 */       attachInterface(this, "android.car.diagnostic.ICarDiagnosticEventListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarDiagnosticEventListener asInterface(IBinder param1IBinder) {
/* 26 */       if (param1IBinder == null) {
/* 27 */         return null;
/*    */       }
/* 29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.diagnostic.ICarDiagnosticEventListener");
/* 30 */       if (iInterface != null && iInterface instanceof ICarDiagnosticEventListener) {
/* 31 */         return (ICarDiagnosticEventListener)iInterface;
/*    */       }
/* 33 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 37 */       return (IBinder)this;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
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
/* 59 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("android.car.diagnostic.ICarDiagnosticEventListener");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.diagnostic.ICarDiagnosticEventListener");
/*    */       ArrayList<CarDiagnosticEvent> arrayList = param1Parcel1.createTypedArrayList(CarDiagnosticEvent.CREATOR);
/*    */       onDiagnosticEvents(arrayList);
/*    */       return true;
/*    */     } private static class Proxy implements ICarDiagnosticEventListener { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 68 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 72 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 76 */         return "android.car.diagnostic.ICarDiagnosticEventListener";
/*    */       }
/*    */       
/*    */       public void onDiagnosticEvents(List<CarDiagnosticEvent> param2List) throws RemoteException {
/* 80 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 82 */         try { parcel.writeInterfaceToken("android.car.diagnostic.ICarDiagnosticEventListener");
/* 83 */           parcel.writeTypedList(param2List);
/* 84 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 87 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarDiagnosticEventListener { public void onDiagnosticEvents(List<CarDiagnosticEvent> param1List) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.diagnostic.ICarDiagnosticEventListener"); parcel.writeTypedList(param1List); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.diagnostic.ICarDiagnosticEventListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\diagnostic\ICarDiagnosticEventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */