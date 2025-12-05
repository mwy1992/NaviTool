/*    */ package android.car.content.pm;
/*    */ 
/*    */ import android.os.Binder;
/*    */ import android.os.IBinder;
/*    */ import android.os.IInterface;
/*    */ import android.os.Parcel;
/*    */ import android.os.RemoteException;
/*    */ 
/*    */ public interface ICarAppBlockingPolicy
/*    */   extends IInterface {
/*    */   void setAppBlockingPolicySetter(ICarAppBlockingPolicySetter paramICarAppBlockingPolicySetter) throws RemoteException;
/*    */   
/*    */   public static abstract class Stub
/*    */     extends Binder implements ICarAppBlockingPolicy {
/*    */     private static final String DESCRIPTOR = "android.car.content.pm.ICarAppBlockingPolicy";
/*    */     static final int TRANSACTION_setAppBlockingPolicySetter = 1;
/*    */     
/*    */     public Stub() {
/* 19 */       attachInterface(this, "android.car.content.pm.ICarAppBlockingPolicy");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public static ICarAppBlockingPolicy asInterface(IBinder param1IBinder) {
/* 27 */       if (param1IBinder == null) {
/* 28 */         return null;
/*    */       }
/* 30 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.content.pm.ICarAppBlockingPolicy");
/* 31 */       if (iInterface != null && iInterface instanceof ICarAppBlockingPolicy) {
/* 32 */         return (ICarAppBlockingPolicy)iInterface;
/*    */       }
/* 34 */       return new Proxy(param1IBinder);
/*    */     }
/*    */     
/*    */     public IBinder asBinder() {
/* 38 */       return (IBinder)this;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
/* 43 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
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
/* 60 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); } 
/*    */         param1Parcel2.writeString("android.car.content.pm.ICarAppBlockingPolicy");
/*    */         return true; }
/*    */       
/*    */       param1Parcel1.enforceInterface("android.car.content.pm.ICarAppBlockingPolicy");
/*    */       ICarAppBlockingPolicySetter iCarAppBlockingPolicySetter = ICarAppBlockingPolicySetter.Stub.asInterface(param1Parcel1.readStrongBinder());
/*    */       setAppBlockingPolicySetter(iCarAppBlockingPolicySetter);
/*    */       return true;
/*    */     } private static class Proxy implements ICarAppBlockingPolicy { private IBinder mRemote; Proxy(IBinder param2IBinder) {
/* 69 */         this.mRemote = param2IBinder;
/*    */       }
/*    */       
/*    */       public IBinder asBinder() {
/* 73 */         return this.mRemote;
/*    */       }
/*    */       
/*    */       public String getInterfaceDescriptor() {
/* 77 */         return "android.car.content.pm.ICarAppBlockingPolicy";
/*    */       }
/*    */       
/*    */       public void setAppBlockingPolicySetter(ICarAppBlockingPolicySetter param2ICarAppBlockingPolicySetter) throws RemoteException {
/* 81 */         Parcel parcel = Parcel.obtain();
/*    */         
/* 83 */         try { parcel.writeInterfaceToken("android.car.content.pm.ICarAppBlockingPolicy");
/* 84 */           if (param2ICarAppBlockingPolicySetter != null) { IBinder iBinder = param2ICarAppBlockingPolicySetter.asBinder(); } else { param2ICarAppBlockingPolicySetter = null; }  parcel.writeStrongBinder((IBinder)param2ICarAppBlockingPolicySetter);
/* 85 */           this.mRemote.transact(1, parcel, null, 1);
/*    */           return; }
/*    */         finally
/* 88 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarAppBlockingPolicy { public void setAppBlockingPolicySetter(ICarAppBlockingPolicySetter param1ICarAppBlockingPolicySetter) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.content.pm.ICarAppBlockingPolicy"); if (param1ICarAppBlockingPolicySetter != null) { IBinder iBinder = param1ICarAppBlockingPolicySetter.asBinder(); } else { param1ICarAppBlockingPolicySetter = null; }  parcel.writeStrongBinder((IBinder)param1ICarAppBlockingPolicySetter); this.mRemote.transact(1, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*    */       return "android.car.content.pm.ICarAppBlockingPolicy";
/*    */     } }
/*    */ 
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\ICarAppBlockingPolicy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */