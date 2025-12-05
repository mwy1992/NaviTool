/*    */ package android.car.trust;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarTrustAgentEnrolmentCallback
/*    */   extends IInterface {
/*    */   void onEnrolmentDataReceived(byte[] paramArrayOfbyte) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder
/*    */     implements ICarTrustAgentEnrolmentCallback {
/*    */     private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentEnrolmentCallback";
/*    */     static final int TRANSACTION_onEnrolmentDataReceived = 1;
/*    */     
/*    */     public Stub() {
/* 20 */       attachInterface(this, "android.car.trust.ICarTrustAgentEnrolmentCallback");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarTrustAgentEnrolmentCallback asInterface(IBinder param1IBinder) {
/* 28 */       if (param1IBinder == null) {
/* 29 */         return null;
/*    */       }
/* 31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.trust.ICarTrustAgentEnrolmentCallback");
/* 32 */       if (iInterface != null && iInterface instanceof ICarTrustAgentEnrolmentCallback) {
/* 33 */         return (ICarTrustAgentEnrolmentCallback)iInterface;
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
/*    */         param1Parcel2.writeString("android.car.trust.ICarTrustAgentEnrolmentCallback");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentEnrolmentCallback");
/*    */       byte[] arrayOfByte = param1Parcel1.createByteArray();
/*    */       onEnrolmentDataReceived(arrayOfByte);
/*    */       return true;
/*    */     } private static class Proxy implements ICarTrustAgentEnrolmentCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 70 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 74 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 78 */         return "android.car.trust.ICarTrustAgentEnrolmentCallback";
/*    */       }
/*    */       
/*    */       public void onEnrolmentDataReceived(byte[] param2ArrayOfbyte) throws RemoteException
/*    */       {
/* 83 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 85 */         try { parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentEnrolmentCallback");
/* 86 */           parcel.writeByteArray(param2ArrayOfbyte);
/* 87 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 90 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarTrustAgentEnrolmentCallback { public void onEnrolmentDataReceived(byte[] param1ArrayOfbyte) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.trust.ICarTrustAgentEnrolmentCallback"); parcel.writeByteArray(param1ArrayOfbyte); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.trust.ICarTrustAgentEnrolmentCallback";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\trust\ICarTrustAgentEnrolmentCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */