/*     */ package ecarx.car;
/*     */ 
/*     */ import android.os.Bundle;
/*     */ import android.os.Parcel;
/*     */ 
/*     */ public interface IECarXCarInfo extends IInterface {
/*     */   Bundle getBasicInfo() throws RemoteException;
/*     */   
/*     */   String getStringInfo(String paramString) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements IECarXCarInfo { private static final String DESCRIPTOR = "ecarx.car.IECarXCarInfo";
/*     */     static final int TRANSACTION_getBasicInfo = 1;
/*     */     static final int TRANSACTION_getStringInfo = 2;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "ecarx.car.IECarXCarInfo");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IECarXCarInfo asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IECarXCarInfo");
/*  28 */       if (iInterface != null && iInterface instanceof IECarXCarInfo) {
/*  29 */         return (IECarXCarInfo)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { String str; switch (param1Int1) {
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
/*  73 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IECarXCarInfo"); str = param1Parcel1.readString(); str = getStringInfo(str); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 1:
/*     */             break;
/*     */         }  str.enforceInterface("ecarx.car.IECarXCarInfo"); Bundle bundle = getBasicInfo(); param1Parcel2.writeNoException(); if (bundle != null) { param1Parcel2.writeInt(1); bundle.writeToParcel(param1Parcel2, 1); }
/*     */         else
/*     */         { param1Parcel2.writeInt(0); }
/*     */          return true; }
/*  82 */        param1Parcel2.writeString("ecarx.car.IECarXCarInfo"); return true; } private static class Proxy implements IECarXCarInfo { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/*  86 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  90 */         return "ecarx.car.IECarXCarInfo";
/*     */       }
/*     */       
/*     */       public Bundle getBasicInfo() throws RemoteException {
/*  94 */         Parcel parcel2 = Parcel.obtain();
/*  95 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/*     */           Bundle bundle;
/*  98 */           parcel2.writeInterfaceToken("ecarx.car.IECarXCarInfo");
/*  99 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 100 */           parcel1.readException();
/* 101 */           if (parcel1.readInt() != 0) {
/* 102 */             bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
/*     */           } else {
/*     */             
/* 105 */             bundle = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 112 */           return bundle;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 116 */         }  } public String getStringInfo(String param2String) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 117 */         Parcel parcel1 = Parcel.obtain();
/*     */ 
/*     */         
/* 120 */         try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarInfo");
/* 121 */           parcel2.writeString(param2String);
/* 122 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 123 */           parcel1.readException();
/* 124 */           param2String = parcel1.readString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 130 */           return param2String; } finally { parcel1.recycle(); parcel2.recycle(); }  } } } private static class Proxy implements IECarXCarInfo { private IBinder mRemote; public String getStringInfo(String param1String) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IECarXCarInfo"); parcel2.writeString(param1String); this.mRemote.transact(2, parcel2, parcel1, 0); parcel1.readException(); param1String = parcel1.readString(); return param1String; }
/*     */       finally
/*     */       { parcel1.recycle();
/*     */         parcel2.recycle(); }
/*     */        }
/*     */ 
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
/*     */       return "ecarx.car.IECarXCarInfo";
/*     */     }
/*     */     
/*     */     public Bundle getBasicInfo() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         Bundle bundle;
/*     */         parcel2.writeInterfaceToken("ecarx.car.IECarXCarInfo");
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         if (parcel1.readInt() != 0) {
/*     */           bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
/*     */         } else {
/*     */           bundle = null;
/*     */         } 
/*     */         return bundle;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IECarXCarInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */