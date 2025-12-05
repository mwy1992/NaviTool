/*    */ package ecarx.car;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ISensorTmperListener extends IInterface {
/*    */   void onSensorTmperChanged(float paramFloat) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ISensorTmperListener { private static final String DESCRIPTOR = "ecarx.car.ISensorTmperListener";
/*    */     static final int TRANSACTION_onSensorTmperChanged = 1;
/*    */     
/*    */     public Stub() {
/* 16 */       attachInterface(this, "ecarx.car.ISensorTmperListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ISensorTmperListener asInterface(IBinder param1IBinder) {
/* 24 */       if (param1IBinder == null) {
/* 25 */         return null;
/*    */       }
/* 27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.ISensorTmperListener");
/* 28 */       if (iInterface != null && iInterface instanceof ISensorTmperListener) {
/* 29 */         return (ISensorTmperListener)iInterface;
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
/*    */           
/* 58 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("ecarx.car.ISensorTmperListener");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("ecarx.car.ISensorTmperListener");
/*    */       float f = param1Parcel1.readFloat();
/*    */       onSensorTmperChanged(f);
/*    */       param1Parcel2.writeNoException();
/*    */       return true; } private static class Proxy implements ISensorTmperListener { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 67 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 71 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 75 */         return "ecarx.car.ISensorTmperListener";
/*    */       }
/*    */       
/*    */       public void onSensorTmperChanged(float param2Float) throws RemoteException {
/* 79 */         Parcel parcel2 = Parcel.obtain();
/* 80 */         Parcel parcel1 = Parcel.obtain();
/*    */         
/* 82 */         try { parcel2.writeInterfaceToken("ecarx.car.ISensorTmperListener");
/* 83 */           parcel2.writeFloat(param2Float);
/* 84 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 85 */           parcel1.readException();
/*    */           return; }
/*    */         finally
/* 88 */         { parcel1.recycle();
/* 89 */           parcel2.recycle(); }  } } } private static class Proxy implements ISensorTmperListener { public void onSensorTmperChanged(float param1Float) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.ISensorTmperListener"); parcel2.writeFloat(param1Float); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }
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
/*    */       return "ecarx.car.ISensorTmperListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\ISensorTmperListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */