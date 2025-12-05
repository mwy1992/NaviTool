/*     */ package android.car.content.pm;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarAppBlockingPolicySetter
/*     */   extends IInterface {
/*     */   void setAppBlockingPolicy(CarAppBlockingPolicy paramCarAppBlockingPolicy) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub
/*     */     extends Binder
/*     */     implements ICarAppBlockingPolicySetter {
/*     */     private static final String DESCRIPTOR = "android.car.content.pm.ICarAppBlockingPolicySetter";
/*     */     static final int TRANSACTION_setAppBlockingPolicy = 1;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.content.pm.ICarAppBlockingPolicySetter");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarAppBlockingPolicySetter asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.content.pm.ICarAppBlockingPolicySetter");
/*  32 */       if (iInterface != null && iInterface instanceof ICarAppBlockingPolicySetter) {
/*  33 */         return (ICarAppBlockingPolicySetter)iInterface;
/*     */       }
/*  35 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  39 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  44 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
/*     */         {
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
/*     */ 
/*     */           
/*  67 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.content.pm.ICarAppBlockingPolicySetter"); return true; }
/*     */        param1Parcel1.enforceInterface("android.car.content.pm.ICarAppBlockingPolicySetter");
/*     */       if (param1Parcel1.readInt() != 0) {
/*     */         CarAppBlockingPolicy carAppBlockingPolicy = (CarAppBlockingPolicy)CarAppBlockingPolicy.CREATOR.createFromParcel(param1Parcel1);
/*     */       } else {
/*     */         param1Parcel1 = null;
/*     */       } 
/*     */       setAppBlockingPolicy((CarAppBlockingPolicy)param1Parcel1);
/*     */       param1Parcel2.writeNoException();
/*  76 */       return true; } private static class Proxy implements ICarAppBlockingPolicySetter { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  80 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  84 */         return "android.car.content.pm.ICarAppBlockingPolicySetter";
/*     */       }
/*     */       
/*     */       public void setAppBlockingPolicy(CarAppBlockingPolicy param2CarAppBlockingPolicy) throws RemoteException {
/*  88 */         Parcel parcel1 = Parcel.obtain();
/*  89 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*  91 */         try { parcel1.writeInterfaceToken("android.car.content.pm.ICarAppBlockingPolicySetter");
/*  92 */           if (param2CarAppBlockingPolicy != null) {
/*  93 */             parcel1.writeInt(1);
/*  94 */             param2CarAppBlockingPolicy.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/*  97 */             parcel1.writeInt(0);
/*     */           } 
/*  99 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 100 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 103 */         { parcel2.recycle();
/* 104 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarAppBlockingPolicySetter { public void setAppBlockingPolicy(CarAppBlockingPolicy param1CarAppBlockingPolicy) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.content.pm.ICarAppBlockingPolicySetter"); if (param1CarAppBlockingPolicy != null) { parcel1.writeInt(1); param1CarAppBlockingPolicy.writeToParcel(parcel1, 0); } else { parcel1.writeInt(0); }  this.mRemote.transact(1, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
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
/*     */       return "android.car.content.pm.ICarAppBlockingPolicySetter";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\ICarAppBlockingPolicySetter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */