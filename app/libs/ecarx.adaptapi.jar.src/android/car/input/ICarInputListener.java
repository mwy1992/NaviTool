/*     */ package android.car.input;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ import android.view.KeyEvent;
/*     */ 
/*     */ public interface ICarInputListener
/*     */   extends IInterface {
/*     */   void onKeyEvent(KeyEvent paramKeyEvent, int paramInt) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub
/*     */     extends Binder implements ICarInputListener {
/*     */     private static final String DESCRIPTOR = "android.car.input.ICarInputListener";
/*     */     static final int TRANSACTION_onKeyEvent = 2;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.input.ICarInputListener");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarInputListener asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.input.ICarInputListener");
/*  32 */       if (iInterface != null && iInterface instanceof ICarInputListener) {
/*  33 */         return (ICarInputListener)iInterface;
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
/*  44 */       if (param1Int1 != 2) { if (param1Int1 != 1598968902)
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
/*     */           
/*  68 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.input.ICarInputListener"); return true; }
/*     */        param1Parcel1.enforceInterface("android.car.input.ICarInputListener");
/*     */       if (param1Parcel1.readInt() != 0) {
/*     */         KeyEvent keyEvent = (KeyEvent)KeyEvent.CREATOR.createFromParcel(param1Parcel1);
/*     */       } else {
/*     */         param1Parcel2 = null;
/*     */       } 
/*     */       param1Int1 = param1Parcel1.readInt();
/*     */       onKeyEvent((KeyEvent)param1Parcel2, param1Int1);
/*  77 */       return true; } private static class Proxy implements ICarInputListener { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  81 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  85 */         return "android.car.input.ICarInputListener";
/*     */       }
/*     */       
/*     */       public void onKeyEvent(KeyEvent param2KeyEvent, int param2Int) throws RemoteException
/*     */       {
/*  90 */         Parcel parcel = Parcel.obtain();
/*     */         
/*  92 */         try { parcel.writeInterfaceToken("android.car.input.ICarInputListener");
/*  93 */           if (param2KeyEvent != null) {
/*  94 */             parcel.writeInt(1);
/*  95 */             param2KeyEvent.writeToParcel(parcel, 0);
/*     */           } else {
/*     */             
/*  98 */             parcel.writeInt(0);
/*     */           } 
/* 100 */           parcel.writeInt(param2Int);
/* 101 */           this.mRemote.transact(2, parcel, null, 1);
/*     */           return; }
/*     */         finally
/* 104 */         { parcel.recycle(); }  } } } private static class Proxy implements ICarInputListener { public void onKeyEvent(KeyEvent param1KeyEvent, int param1Int) throws RemoteException { Parcel parcel = Parcel.obtain(); try { parcel.writeInterfaceToken("android.car.input.ICarInputListener"); if (param1KeyEvent != null) { parcel.writeInt(1); param1KeyEvent.writeToParcel(parcel, 0); } else { parcel.writeInt(0); }  parcel.writeInt(param1Int); this.mRemote.transact(2, parcel, null, 1); return; } finally { parcel.recycle(); }
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
/*     */       return "android.car.input.ICarInputListener";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\input\ICarInputListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */