/*    */ package android.car;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarProjectionCallback
/*    */   extends IInterface {
/*    */   void onVoiceAssistantRequest(boolean paramBoolean) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub extends Binder implements ICarProjectionCallback {
/*    */     private static final String DESCRIPTOR = "android.car.ICarProjectionCallback";
/*    */     static final int TRANSACTION_onVoiceAssistantRequest = 1;
/*    */     
/*    */     public Stub() {
/* 18 */       attachInterface(this, "android.car.ICarProjectionCallback");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarProjectionCallback asInterface(IBinder param1IBinder) {
/* 26 */       if (param1IBinder == null) {
/* 27 */         return null;
/*    */       }
/* 29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.ICarProjectionCallback");
/* 30 */       if (iInterface != null && iInterface instanceof ICarProjectionCallback) {
/* 31 */         return (ICarProjectionCallback)iInterface;
/*    */       }
/* 33 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 37 */       return (IBinder)this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/*    */       boolean bool;
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
/* 59 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.ICarProjectionCallback"); return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.ICarProjectionCallback");
/*    */       if (param1Parcel1.readInt() != 0) {
/*    */         bool = true;
/*    */       } else {
/*    */         bool = false;
/*    */       } 
/*    */       onVoiceAssistantRequest(bool);
/* 68 */       return true; } private static class Proxy implements ICarProjectionCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*    */ 
/*    */       
/*    */       public IBinder asBinder() {
/* 72 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 76 */         return "android.car.ICarProjectionCallback";
/*    */       }
/*    */       
/*    */       public void onVoiceAssistantRequest(boolean param2Boolean) throws RemoteException {
/* 80 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 82 */         try { parcel.writeInterfaceToken("android.car.ICarProjectionCallback");
/* 83 */           parcel.writeInt(param2Boolean);
/* 84 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 87 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarProjectionCallback { public void onVoiceAssistantRequest(boolean param1Boolean) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.ICarProjectionCallback"); parcel.writeInt(param1Boolean); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.ICarProjectionCallback";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\ICarProjectionCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */