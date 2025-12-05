/*     */ package android.car;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public interface IAppFocusOwnershipCallback extends IInterface {
/*     */   void onAppFocusOwnershipGranted(int paramInt) throws RemoteException;
/*     */   
/*     */   void onAppFocusOwnershipLost(int paramInt) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IAppFocusOwnershipCallback { private static final String DESCRIPTOR = "android.car.IAppFocusOwnershipCallback";
/*     */     static final int TRANSACTION_onAppFocusOwnershipGranted = 2;
/*     */     static final int TRANSACTION_onAppFocusOwnershipLost = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.IAppFocusOwnershipCallback");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IAppFocusOwnershipCallback asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.IAppFocusOwnershipCallback");
/*  28 */       if (iInterface != null && iInterface instanceof IAppFocusOwnershipCallback) {
/*  29 */         return (IAppFocusOwnershipCallback)iInterface;
/*     */       }
/*  31 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  35 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  40 */       if (param1Int1 != 1598968902) { switch (param1Int1) {
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
/*     */ 
/*     */           
/*     */           default:
/*  65 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.IAppFocusOwnershipCallback"); param1Int1 = param1Parcel1.readInt(); onAppFocusOwnershipGranted(param1Int1); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("android.car.IAppFocusOwnershipCallback"); param1Int1 = param1Parcel1.readInt(); onAppFocusOwnershipLost(param1Int1);
/*     */         return true; }
/*     */       
/*     */       param1Parcel2.writeString("android.car.IAppFocusOwnershipCallback");
/*  74 */       return true; } private static class Proxy implements IAppFocusOwnershipCallback { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  78 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  82 */         return "android.car.IAppFocusOwnershipCallback";
/*     */       }
/*     */       
/*     */       public void onAppFocusOwnershipLost(int param2Int) throws RemoteException {
/*  86 */         Parcel parcel = Parcel.obtain();
/*     */         try {
/*  88 */           parcel.writeInterfaceToken("android.car.IAppFocusOwnershipCallback");
/*  89 */           parcel.writeInt(param2Int);
/*  90 */           this.mRemote.transact(1, parcel, null, 1);
/*     */           return;
/*     */         } finally {
/*  93 */           parcel.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onAppFocusOwnershipGranted(int param2Int) throws RemoteException {
/*  98 */         Parcel parcel = Parcel.obtain();
/*     */         
/* 100 */         try { parcel.writeInterfaceToken("android.car.IAppFocusOwnershipCallback");
/* 101 */           parcel.writeInt(param2Int);
/* 102 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 105 */         { parcel.recycle(); }  } } } private static class Proxy implements IAppFocusOwnershipCallback { public void onAppFocusOwnershipGranted(int param1Int) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.IAppFocusOwnershipCallback"); parcel.writeInt(param1Int); this.mRemote.transact(2, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.IAppFocusOwnershipCallback";
/*     */     }
/*     */     
/*     */     public void onAppFocusOwnershipLost(int param1Int) throws RemoteException {
/*     */       Parcel parcel = Parcel.obtain();
/*     */       try {
/*     */         parcel.writeInterfaceToken("android.car.IAppFocusOwnershipCallback");
/*     */         parcel.writeInt(param1Int);
/*     */         this.mRemote.transact(1, parcel, null, 1);
/*     */         return;
/*     */       } finally {
/*     */         parcel.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\IAppFocusOwnershipCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */