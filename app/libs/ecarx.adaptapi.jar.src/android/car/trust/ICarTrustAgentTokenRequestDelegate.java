/*     */ package android.car.trust;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarTrustAgentTokenRequestDelegate extends IInterface {
/*     */   void addEscrowToken(byte[] paramArrayOfbyte, int paramInt) throws RemoteException;
/*     */   
/*     */   void isEscrowTokenActive(long paramLong, int paramInt) throws RemoteException;
/*     */   
/*     */   void removeEscrowToken(long paramLong, int paramInt) throws RemoteException;
/*     */   
/*     */   void revokeTrust() throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarTrustAgentTokenRequestDelegate { private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentTokenRequestDelegate";
/*     */     static final int TRANSACTION_addEscrowToken = 2;
/*     */     static final int TRANSACTION_isEscrowTokenActive = 4;
/*     */     static final int TRANSACTION_removeEscrowToken = 3;
/*     */     static final int TRANSACTION_revokeTrust = 1;
/*     */     
/*     */     public Stub() {
/*  25 */       attachInterface(this, "android.car.trust.ICarTrustAgentTokenRequestDelegate");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarTrustAgentTokenRequestDelegate asInterface(IBinder param1IBinder) {
/*  33 */       if (param1IBinder == null) {
/*  34 */         return null;
/*     */       }
/*  36 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/*  37 */       if (iInterface != null && iInterface instanceof ICarTrustAgentTokenRequestDelegate) {
/*  38 */         return (ICarTrustAgentTokenRequestDelegate)iInterface;
/*     */       }
/*  40 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  44 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  49 */       if (param1Int1 != 1598968902) { long l; byte[] arrayOfByte; switch (param1Int1)
/*     */         
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
/*  98 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate"); l = param1Parcel1.readLong(); param1Int1 = param1Parcel1.readInt(); isEscrowTokenActive(l, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate"); l = param1Parcel1.readLong(); param1Int1 = param1Parcel1.readInt(); removeEscrowToken(l, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate"); arrayOfByte = param1Parcel1.createByteArray(); param1Int1 = param1Parcel1.readInt(); addEscrowToken(arrayOfByte, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break; }  param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenRequestDelegate"); revokeTrust(); param1Parcel2.writeNoException(); return true; }
/* 107 */        param1Parcel2.writeString("android.car.trust.ICarTrustAgentTokenRequestDelegate"); return true; } private static class Proxy implements ICarTrustAgentTokenRequestDelegate { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 111 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 115 */         return "android.car.trust.ICarTrustAgentTokenRequestDelegate";
/*     */       }
/*     */ 
/*     */       
/*     */       public void revokeTrust() throws RemoteException {
/* 120 */         Parcel parcel1 = Parcel.obtain();
/* 121 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 123 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/* 124 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 125 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 128 */           parcel2.recycle();
/* 129 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void addEscrowToken(byte[] param2ArrayOfbyte, int param2Int) throws RemoteException {
/* 135 */         Parcel parcel2 = Parcel.obtain();
/* 136 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 138 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/* 139 */           parcel2.writeByteArray(param2ArrayOfbyte);
/* 140 */           parcel2.writeInt(param2Int);
/* 141 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 142 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 145 */           parcel1.recycle();
/* 146 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void removeEscrowToken(long param2Long, int param2Int) throws RemoteException {
/* 152 */         Parcel parcel1 = Parcel.obtain();
/* 153 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 155 */           parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/* 156 */           parcel1.writeLong(param2Long);
/* 157 */           parcel1.writeInt(param2Int);
/* 158 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 159 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 162 */           parcel2.recycle();
/* 163 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void isEscrowTokenActive(long param2Long, int param2Int) throws RemoteException
/*     */       {
/* 169 */         Parcel parcel2 = Parcel.obtain();
/* 170 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/* 172 */         try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/* 173 */           parcel2.writeLong(param2Long);
/* 174 */           parcel2.writeInt(param2Int);
/* 175 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 176 */           parcel1.readException();
/*     */           return; }
/*     */         finally
/* 179 */         { parcel1.recycle();
/* 180 */           parcel2.recycle(); }  } } } private static class Proxy implements ICarTrustAgentTokenRequestDelegate { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public void isEscrowTokenActive(long param1Long, int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate"); parcel2.writeLong(param1Long); parcel2.writeInt(param1Int); this.mRemote.transact(4, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.trust.ICarTrustAgentTokenRequestDelegate";
/*     */     }
/*     */     
/*     */     public void revokeTrust() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void addEscrowToken(byte[] param1ArrayOfbyte, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/*     */         parcel2.writeByteArray(param1ArrayOfbyte);
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void removeEscrowToken(long param1Long, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenRequestDelegate");
/*     */         parcel1.writeLong(param1Long);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\trust\ICarTrustAgentTokenRequestDelegate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */