/*     */ package android.car.trust;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarTrustAgentTokenResponseCallback extends IInterface {
/*     */   void onEscrowTokenActiveStateChanged(long paramLong, boolean paramBoolean) throws RemoteException;
/*     */   
/*     */   void onEscrowTokenAdded(byte[] paramArrayOfbyte, long paramLong, int paramInt) throws RemoteException;
/*     */   
/*     */   void onEscrowTokenRemoved(long paramLong, boolean paramBoolean) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarTrustAgentTokenResponseCallback {
/*     */     private static final String DESCRIPTOR = "android.car.trust.ICarTrustAgentTokenResponseCallback";
/*     */     static final int TRANSACTION_onEscrowTokenActiveStateChanged = 3;
/*     */     static final int TRANSACTION_onEscrowTokenAdded = 1;
/*     */     static final int TRANSACTION_onEscrowTokenRemoved = 2;
/*     */     
/*     */     public Stub() {
/*  23 */       attachInterface(this, "android.car.trust.ICarTrustAgentTokenResponseCallback");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarTrustAgentTokenResponseCallback asInterface(IBinder param1IBinder) {
/*  31 */       if (param1IBinder == null) {
/*  32 */         return null;
/*     */       }
/*  34 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.trust.ICarTrustAgentTokenResponseCallback");
/*  35 */       if (iInterface != null && iInterface instanceof ICarTrustAgentTokenResponseCallback) {
/*  36 */         return (ICarTrustAgentTokenResponseCallback)iInterface;
/*     */       }
/*  38 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  42 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  47 */       if (param1Int1 != 1598968902) { byte[] arrayOfByte; boolean bool1 = false, bool2 = false; switch (param1Int1)
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
/*     */ 
/*     */           
/*     */           default:
/*  98 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenResponseCallback"); l = param1Parcel1.readLong(); bool1 = bool2; if (param1Parcel1.readInt() != 0)
/*     */               bool1 = true;  onEscrowTokenActiveStateChanged(l, bool1); param1Parcel2.writeNoException(); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenResponseCallback"); l = param1Parcel1.readLong(); if (param1Parcel1.readInt() != 0)
/*     */               bool1 = true;  onEscrowTokenRemoved(l, bool1); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/*     */             break; }  param1Parcel1.enforceInterface("android.car.trust.ICarTrustAgentTokenResponseCallback"); param1Int1 = param1Parcel1.readInt(); if (param1Int1 < 0) { arrayOfByte = null; } else { arrayOfByte = new byte[param1Int1]; }  long l = param1Parcel1.readLong(); param1Int1 = param1Parcel1.readInt(); onEscrowTokenAdded(arrayOfByte, l, param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeByteArray(arrayOfByte); return true; }
/* 107 */        param1Parcel2.writeString("android.car.trust.ICarTrustAgentTokenResponseCallback"); return true; } private static class Proxy implements ICarTrustAgentTokenResponseCallback { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 111 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 115 */         return "android.car.trust.ICarTrustAgentTokenResponseCallback";
/*     */       }
/*     */ 
/*     */       
/*     */       public void onEscrowTokenAdded(byte[] param2ArrayOfbyte, long param2Long, int param2Int) throws RemoteException {
/* 120 */         Parcel parcel2 = Parcel.obtain();
/* 121 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 123 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
/* 124 */           if (param2ArrayOfbyte == null) {
/* 125 */             parcel2.writeInt(-1);
/*     */           } else {
/*     */             
/* 128 */             parcel2.writeInt(param2ArrayOfbyte.length);
/*     */           } 
/* 130 */           parcel2.writeLong(param2Long);
/* 131 */           parcel2.writeInt(param2Int);
/* 132 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 133 */           parcel1.readException();
/* 134 */           parcel1.readByteArray(param2ArrayOfbyte);
/*     */           return;
/*     */         } finally {
/* 137 */           parcel1.recycle();
/* 138 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void onEscrowTokenRemoved(long param2Long, boolean param2Boolean) throws RemoteException {
/* 144 */         Parcel parcel2 = Parcel.obtain();
/* 145 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 147 */           parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
/* 148 */           parcel2.writeLong(param2Long);
/* 149 */           parcel2.writeInt(param2Boolean);
/* 150 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 151 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 154 */           parcel1.recycle();
/* 155 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void onEscrowTokenActiveStateChanged(long param2Long, boolean param2Boolean) throws RemoteException
/*     */       {
/* 161 */         Parcel parcel2 = Parcel.obtain();
/* 162 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/* 164 */         try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
/* 165 */           parcel2.writeLong(param2Long);
/* 166 */           parcel2.writeInt(param2Boolean);
/* 167 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 168 */           parcel1.readException();
/*     */           return; }
/*     */         finally
/* 171 */         { parcel1.recycle();
/* 172 */           parcel2.recycle(); }  } } } private static class Proxy implements ICarTrustAgentTokenResponseCallback { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public void onEscrowTokenActiveStateChanged(long param1Long, boolean param1Boolean) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback"); parcel2.writeLong(param1Long); parcel2.writeInt(param1Boolean); this.mRemote.transact(3, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.trust.ICarTrustAgentTokenResponseCallback";
/*     */     }
/*     */     
/*     */     public void onEscrowTokenAdded(byte[] param1ArrayOfbyte, long param1Long, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
/*     */         if (param1ArrayOfbyte == null) {
/*     */           parcel2.writeInt(-1);
/*     */         } else {
/*     */           parcel2.writeInt(param1ArrayOfbyte.length);
/*     */         } 
/*     */         parcel2.writeLong(param1Long);
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         parcel1.readByteArray(param1ArrayOfbyte);
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void onEscrowTokenRemoved(long param1Long, boolean param1Boolean) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.trust.ICarTrustAgentTokenResponseCallback");
/*     */         parcel2.writeLong(param1Long);
/*     */         parcel2.writeInt(param1Boolean);
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\trust\ICarTrustAgentTokenResponseCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */