/*     */ package ecarx.car;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarConnectionListener extends IInterface {
/*     */   void onConnected() throws RemoteException;
/*     */   
/*     */   void onDisconnected() throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarConnectionListener { private static final String DESCRIPTOR = "ecarx.car.ICarConnectionListener";
/*     */     static final int TRANSACTION_onConnected = 1;
/*     */     static final int TRANSACTION_onDisconnected = 2;
/*     */     
/*     */     public Stub() {
/*  19 */       attachInterface(this, "ecarx.car.ICarConnectionListener");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarConnectionListener asInterface(IBinder param1IBinder) {
/*  27 */       if (param1IBinder == null) {
/*  28 */         return null;
/*     */       }
/*  30 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.ICarConnectionListener");
/*  31 */       if (iInterface != null && iInterface instanceof ICarConnectionListener) {
/*  32 */         return (ICarConnectionListener)iInterface;
/*     */       }
/*  34 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  38 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  43 */       if (param1Int1 != 1598968902) { switch (param1Int1) {
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
/*  64 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("ecarx.car.ICarConnectionListener"); onDisconnected(); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("ecarx.car.ICarConnectionListener"); onConnected();
/*     */         return true; }
/*     */       
/*     */       param1Parcel2.writeString("ecarx.car.ICarConnectionListener");
/*  73 */       return true; } private static class Proxy implements ICarConnectionListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  77 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  81 */         return "ecarx.car.ICarConnectionListener";
/*     */       }
/*     */       
/*     */       public void onConnected() throws RemoteException {
/*  85 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/*  87 */           parcel.writeInterfaceToken("ecarx.car.ICarConnectionListener");
/*  88 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/*  91 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onDisconnected() throws RemoteException {
/*  96 */         Parcel parcel = Parcel.obtain();
/*     */         
/*  98 */         try { parcel.writeInterfaceToken("ecarx.car.ICarConnectionListener");
/*  99 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 102 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarConnectionListener { public void onDisconnected() throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("ecarx.car.ICarConnectionListener"); this.mRemote.transact(2, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "ecarx.car.ICarConnectionListener";
/*     */     }
/*     */     
/*     */     public void onConnected() throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("ecarx.car.ICarConnectionListener");
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\ICarConnectionListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */