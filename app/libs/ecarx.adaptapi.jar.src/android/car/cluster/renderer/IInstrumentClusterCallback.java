/*     */ package android.car.cluster.renderer;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.Bundle;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IInstrumentClusterCallback extends IInterface {
/*     */   void setClusterActivityLaunchOptions(String paramString, Bundle paramBundle) throws RemoteException;
/*     */   
/*     */   void setClusterActivityState(String paramString, Bundle paramBundle) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IInstrumentClusterCallback {
/*     */     private static final String DESCRIPTOR = "android.car.cluster.renderer.IInstrumentClusterCallback";
/*     */     static final int TRANSACTION_setClusterActivityLaunchOptions = 1;
/*     */     static final int TRANSACTION_setClusterActivityState = 2;
/*     */     
/*     */     public Stub() {
/*  21 */       attachInterface(this, "android.car.cluster.renderer.IInstrumentClusterCallback");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IInstrumentClusterCallback asInterface(IBinder param1IBinder) {
/*  29 */       if (param1IBinder == null) {
/*  30 */         return null;
/*     */       }
/*  32 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.cluster.renderer.IInstrumentClusterCallback");
/*  33 */       if (iInterface != null && iInterface instanceof IInstrumentClusterCallback) {
/*  34 */         return (IInstrumentClusterCallback)iInterface;
/*     */       }
/*  36 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  40 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  45 */       if (param1Int1 != 1598968902) { String str1, str2 = null; Parcel parcel = null; switch (param1Int1) {
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
/*  86 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.cluster.renderer.IInstrumentClusterCallback"); str2 = param1Parcel1.readString(); if (param1Parcel1.readInt() != 0) { Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel; }
/*     */              setClusterActivityState(str2, (Bundle)param1Parcel1); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  param1Parcel1.enforceInterface("android.car.cluster.renderer.IInstrumentClusterCallback"); String str3 = param1Parcel1.readString(); if (param1Parcel1.readInt() != 0) { Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); }
/*     */         else { str1 = str2; }
/*     */          setClusterActivityLaunchOptions(str3, (Bundle)str1); param1Parcel2.writeNoException(); return true; }
/*  95 */        param1Parcel2.writeString("android.car.cluster.renderer.IInstrumentClusterCallback"); return true; } private static class Proxy implements IInstrumentClusterCallback { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  99 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 103 */         return "android.car.cluster.renderer.IInstrumentClusterCallback";
/*     */       }
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
/*     */       public void setClusterActivityLaunchOptions(String param2String, Bundle param2Bundle) throws RemoteException {
/* 118 */         Parcel parcel1 = Parcel.obtain();
/* 119 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 121 */           parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterCallback");
/* 122 */           parcel1.writeString(param2String);
/* 123 */           if (param2Bundle != null) {
/* 124 */             parcel1.writeInt(1);
/* 125 */             param2Bundle.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 128 */             parcel1.writeInt(0);
/*     */           } 
/* 130 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 131 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 134 */           parcel2.recycle();
/* 135 */           parcel1.recycle();
/*     */         } 
/*     */       }
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
/*     */       public void setClusterActivityState(String param2String, Bundle param2Bundle) throws RemoteException
/*     */       {
/* 152 */         Parcel parcel1 = Parcel.obtain();
/* 153 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/* 155 */         try { parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterCallback");
/* 156 */           parcel1.writeString(param2String);
/* 157 */           if (param2Bundle != null) {
/* 158 */             parcel1.writeInt(1);
/* 159 */             param2Bundle.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 162 */             parcel1.writeInt(0);
/*     */           } 
/* 164 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 165 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 168 */         { parcel2.recycle();
/* 169 */           parcel1.recycle(); }  } } } private static class Proxy implements IInstrumentClusterCallback { public void setClusterActivityState(String param1String, Bundle param1Bundle) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterCallback"); parcel1.writeString(param1String); if (param1Bundle != null) { parcel1.writeInt(1); param1Bundle.writeToParcel(parcel1, 0); } else { parcel1.writeInt(0); }  this.mRemote.transact(2, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
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
/*     */       return "android.car.cluster.renderer.IInstrumentClusterCallback";
/*     */     }
/*     */     
/*     */     public void setClusterActivityLaunchOptions(String param1String, Bundle param1Bundle) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.cluster.renderer.IInstrumentClusterCallback");
/*     */         parcel1.writeString(param1String);
/*     */         if (param1Bundle != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1Bundle.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\cluster\renderer\IInstrumentClusterCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */