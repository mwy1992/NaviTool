/*    */ package android.car;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface IAppFocusListener extends IInterface {
/*    */   void onAppFocusChanged(int paramInt, boolean paramBoolean) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements IAppFocusListener { private static final String DESCRIPTOR = "android.car.IAppFocusListener";
/*    */     static final int TRANSACTION_onAppFocusChanged = 1;
/*    */     
/*    */     public Stub() {
/* 16 */       attachInterface(this, "android.car.IAppFocusListener");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static IAppFocusListener asInterface(IBinder param1IBinder) {
/* 24 */       if (param1IBinder == null) {
/* 25 */         return null;
/*    */       }
/* 27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.IAppFocusListener");
/* 28 */       if (iInterface != null && iInterface instanceof IAppFocusListener) {
/* 29 */         return (IAppFocusListener)iInterface;
/*    */       }
/* 31 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 35 */       return (IBinder)this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/*    */       boolean bool;
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
/*    */           
/* 59 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.IAppFocusListener"); return true; }
/*    */        param1Parcel1.enforceInterface("android.car.IAppFocusListener");
/*    */       param1Int1 = param1Parcel1.readInt();
/*    */       if (param1Parcel1.readInt() != 0) {
/*    */         bool = true;
/*    */       } else {
/*    */         bool = false;
/*    */       } 
/*    */       onAppFocusChanged(param1Int1, bool);
/* 68 */       return true; } private static class Proxy implements IAppFocusListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*    */ 
/*    */       
/*    */       public IBinder asBinder() {
/* 72 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 76 */         return "android.car.IAppFocusListener";
/*    */       }
/*    */       
/*    */       public void onAppFocusChanged(int param2Int, boolean param2Boolean) throws RemoteException {
/* 80 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 82 */         try { parcel.writeInterfaceToken("android.car.IAppFocusListener");
/* 83 */           parcel.writeInt(param2Int);
/* 84 */           parcel.writeInt(param2Boolean);
/* 85 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 88 */         { parcel.recycle(); }  } } } private static class Proxy implements IAppFocusListener { public void onAppFocusChanged(int param1Int, boolean param1Boolean) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.IAppFocusListener"); parcel.writeInt(param1Int); parcel.writeInt(param1Boolean); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.IAppFocusListener";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\IAppFocusListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */