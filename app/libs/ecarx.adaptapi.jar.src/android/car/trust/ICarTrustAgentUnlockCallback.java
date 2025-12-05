/*    */ package android.car.trust;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarTrustAgentUnlockCallback
/*    */   extends IInterface {
/*    */   void onUnlockDataReceived(byte[] paramArrayOfbyte, long paramLong) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder
/*    */     implements ICarTrustAgentUnlockCallback {
/*    */     private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentUnlockCallback";
/*    */     static final int TRANSACTION_onUnlockDataReceived = 1;
/*    */     
/*    */     public Stub() {
/* 20 */       attachInterface(this, "android.car.trust.ICarTrustAgentUnlockCallback");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarTrustAgentUnlockCallback asInterface(IBinder param1IBinder) {
/* 28 */       if (param1IBinder == null) {
/* 29 */         return null;
/*    */       }
/* 31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.trust.ICarTrustAgentUnlockCallback");
/* 32 */       if (iInterface != null && iInterface instanceof ICarTrustAgentUnlockCallback) {
/* 33 */         return (ICarTrustAgentUnlockCallback)iInterface;
/*    */       }
/* 35 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 39 */       return (IBinder)this;
/*    */     }
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*    */     {
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
/*    */ 
/*    */           
/* 63 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("android.car.trust.ICarTrustAgentUnlockCallback");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentUnlockCallback");
/*    */       byte[] arrayOfByte = param1Parcel1.createByteArray();
/*    */       long l = param1Parcel1.readLong();
/*    */       onUnlockDataReceived(arrayOfByte, l);
/*    */       return true; } private static class Proxy implements ICarTrustAgentUnlockCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 72 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 76 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 80 */         return "android.car.trust.ICarTrustAgentUnlockCallback";
/*    */       }
/*    */       
/*    */       public void onUnlockDataReceived(byte[] param2ArrayOfbyte, long param2Long) throws RemoteException
/*    */       {
/* 85 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 87 */         try { parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentUnlockCallback");
/* 88 */           parcel.writeByteArray(param2ArrayOfbyte);
/* 89 */           parcel.writeLong(param2Long);
/* 90 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 93 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarTrustAgentUnlockCallback { public void onUnlockDataReceived(byte[] param1ArrayOfbyte, long param1Long) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentUnlockCallback"); parcel.writeByteArray(param1ArrayOfbyte); parcel.writeLong(param1Long); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.trust.ICarTrustAgentUnlockCallback";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\trust\ICarTrustAgentUnlockCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */