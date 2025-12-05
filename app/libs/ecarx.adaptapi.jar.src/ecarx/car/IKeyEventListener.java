/*     */ package ecarx.car;
/*     */ 
/*     */ import android.os.IBinder;
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public interface IKeyEventListener extends IInterface {
/*     */   boolean onKeyPressed(int paramInt) throws RemoteException;
/*     */   
/*     */   boolean onKeyReleased(int paramInt) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IKeyEventListener { private static final String DESCRIPTOR = "ecarx.car.IKeyEventListener";
/*     */     static final int TRANSACTION_onKeyPressed = 1;
/*     */     static final int TRANSACTION_onKeyReleased = 2;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "ecarx.car.IKeyEventListener");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IKeyEventListener asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IKeyEventListener");
/*  28 */       if (iInterface != null && iInterface instanceof IKeyEventListener) {
/*  29 */         return (IKeyEventListener)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool2; switch (param1Int1) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           default:
/*  69 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IKeyEventListener"); param1Int1 = param1Parcel1.readInt(); bool2 = onKeyReleased(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool2); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("ecarx.car.IKeyEventListener"); int i = param1Parcel1.readInt(); boolean bool1 = onKeyPressed(i); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool1);
/*     */         return true; }
/*     */       
/*     */       param1Parcel2.writeString("ecarx.car.IKeyEventListener");
/*  78 */       return true; } private static class Proxy implements IKeyEventListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  82 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  86 */         return "ecarx.car.IKeyEventListener";
/*     */       }
/*     */       
/*     */       public boolean onKeyPressed(int param2Int) throws RemoteException {
/*  90 */         Parcel parcel1 = Parcel.obtain();
/*  91 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/*  94 */           parcel1.writeInterfaceToken("ecarx.car.IKeyEventListener");
/*  95 */           parcel1.writeInt(param2Int);
/*  96 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(1, parcel1, parcel2, 0);
/*  97 */           parcel2.readException();
/*  98 */           param2Int = parcel2.readInt(); if (param2Int != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 104 */           return bool;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 108 */         }  } public boolean onKeyReleased(int param2Int) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 109 */         Parcel parcel1 = Parcel.obtain();
/*     */ 
/*     */         
/* 112 */         try { parcel2.writeInterfaceToken("ecarx.car.IKeyEventListener");
/* 113 */           parcel2.writeInt(param2Int);
/* 114 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel2, parcel1, 0);
/* 115 */           parcel1.readException();
/* 116 */           param2Int = parcel1.readInt(); if (param2Int != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 122 */           return bool; } finally { parcel1.recycle(); parcel2.recycle(); }  } } } private static class Proxy implements IKeyEventListener { public boolean onKeyReleased(int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IKeyEventListener"); parcel2.writeInt(param1Int); IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel2, parcel1, 0); parcel1.readException(); param1Int = parcel1.readInt(); if (param1Int != 0) bool = true;  return bool; }
/*     */       finally
/*     */       { parcel1.recycle();
/*     */         parcel2.recycle(); }
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
/*     */       return "ecarx.car.IKeyEventListener";
/*     */     }
/*     */     
/*     */     public boolean onKeyPressed(int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IKeyEventListener");
/*     */         parcel1.writeInt(param1Int);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         param1Int = parcel2.readInt();
/*     */         if (param1Int != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IKeyEventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */