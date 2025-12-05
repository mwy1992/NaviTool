/*     */ package android.car;public interface IAppFocus extends IInterface { void abandonAppFocus(IAppFocusOwnershipCallback paramIAppFocusOwnershipCallback, int paramInt) throws RemoteException;
/*     */   int[] getActiveAppTypes() throws RemoteException;
/*     */   boolean isOwningFocus(IAppFocusOwnershipCallback paramIAppFocusOwnershipCallback, int paramInt) throws RemoteException;
/*     */   void registerFocusListener(IAppFocusListener paramIAppFocusListener, int paramInt) throws RemoteException;
/*     */   int requestAppFocus(IAppFocusOwnershipCallback paramIAppFocusOwnershipCallback, int paramInt) throws RemoteException;
/*     */   void unregisterFocusListener(IAppFocusListener paramIAppFocusListener, int paramInt) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements IAppFocus { private static final String DESCRIPTOR = "android.car.IAppFocus";
/*     */     static final int TRANSACTION_abandonAppFocus = 6;
/*     */     static final int TRANSACTION_getActiveAppTypes = 3;
/*     */     static final int TRANSACTION_isOwningFocus = 4;
/*     */     static final int TRANSACTION_registerFocusListener = 1;
/*     */     static final int TRANSACTION_requestAppFocus = 5;
/*     */     static final int TRANSACTION_unregisterFocusListener = 2;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.IAppFocus");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IAppFocus asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.IAppFocus");
/*  28 */       if (iInterface != null && iInterface instanceof IAppFocus) {
/*  29 */         return (IAppFocus)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool; int[] arrayOfInt; IAppFocusOwnershipCallback iAppFocusOwnershipCallback; switch (param1Int1)
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
/* 114 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 6: param1Parcel1.enforceInterface("android.car.IAppFocus"); iAppFocusOwnershipCallback = IAppFocusOwnershipCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); param1Int1 = param1Parcel1.readInt(); abandonAppFocus(iAppFocusOwnershipCallback, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 5: param1Parcel1.enforceInterface("android.car.IAppFocus"); iAppFocusOwnershipCallback = IAppFocusOwnershipCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); param1Int1 = param1Parcel1.readInt(); param1Int1 = requestAppFocus(iAppFocusOwnershipCallback, param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 4: param1Parcel1.enforceInterface("android.car.IAppFocus"); iAppFocusOwnershipCallback = IAppFocusOwnershipCallback.Stub.asInterface(param1Parcel1.readStrongBinder()); param1Int1 = param1Parcel1.readInt(); bool = isOwningFocus(iAppFocusOwnershipCallback, param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("android.car.IAppFocus"); arrayOfInt = getActiveAppTypes(); param1Parcel2.writeNoException(); param1Parcel2.writeIntArray(arrayOfInt); return true;
/*     */           case 2:
/*     */             arrayOfInt.enforceInterface("android.car.IAppFocus"); iAppFocusListener = IAppFocusListener.Stub.asInterface(arrayOfInt.readStrongBinder()); i = arrayOfInt.readInt(); unregisterFocusListener(iAppFocusListener, i); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/* 123 */             break; }  arrayOfInt.enforceInterface("android.car.IAppFocus"); IAppFocusListener iAppFocusListener = IAppFocusListener.Stub.asInterface(arrayOfInt.readStrongBinder()); int i = arrayOfInt.readInt(); registerFocusListener(iAppFocusListener, i); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.IAppFocus"); return true; } private static class Proxy implements IAppFocus { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 127 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 131 */         return "android.car.IAppFocus";
/*     */       }
/*     */       
/*     */       public void registerFocusListener(IAppFocusListener param2IAppFocusListener, int param2Int) throws RemoteException {
/* 135 */         Parcel parcel2 = Parcel.obtain();
/* 136 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 138 */           parcel2.writeInterfaceToken("android.car.IAppFocus");
/* 139 */           if (param2IAppFocusListener != null) { IBinder iBinder = param2IAppFocusListener.asBinder(); } else { param2IAppFocusListener = null; }  parcel2.writeStrongBinder((IBinder)param2IAppFocusListener);
/* 140 */           parcel2.writeInt(param2Int);
/* 141 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 142 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 145 */           parcel1.recycle();
/* 146 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterFocusListener(IAppFocusListener param2IAppFocusListener, int param2Int) throws RemoteException {
/* 151 */         Parcel parcel1 = Parcel.obtain();
/* 152 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 154 */           parcel1.writeInterfaceToken("android.car.IAppFocus");
/* 155 */           if (param2IAppFocusListener != null) { IBinder iBinder = param2IAppFocusListener.asBinder(); } else { param2IAppFocusListener = null; }  parcel1.writeStrongBinder((IBinder)param2IAppFocusListener);
/* 156 */           parcel1.writeInt(param2Int);
/* 157 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 158 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 161 */           parcel2.recycle();
/* 162 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int[] getActiveAppTypes() throws RemoteException {
/* 167 */         Parcel parcel1 = Parcel.obtain();
/* 168 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 171 */           parcel1.writeInterfaceToken("android.car.IAppFocus");
/* 172 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 173 */           parcel2.readException();
/* 174 */           return parcel2.createIntArray();
/*     */         } finally {
/*     */           
/* 177 */           parcel2.recycle();
/* 178 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isOwningFocus(IAppFocusOwnershipCallback param2IAppFocusOwnershipCallback, int param2Int) throws RemoteException
/*     */       {
/* 185 */         Parcel parcel1 = Parcel.obtain();
/* 186 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 189 */           parcel1.writeInterfaceToken("android.car.IAppFocus");
/* 190 */           if (param2IAppFocusOwnershipCallback != null) { IBinder iBinder1 = param2IAppFocusOwnershipCallback.asBinder(); } else { param2IAppFocusOwnershipCallback = null; }  parcel1.writeStrongBinder((IBinder)param2IAppFocusOwnershipCallback);
/* 191 */           parcel1.writeInt(param2Int);
/* 192 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(4, parcel1, parcel2, 0);
/* 193 */           parcel2.readException();
/* 194 */           param2Int = parcel2.readInt(); if (param2Int != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 200 */           return bool;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 204 */         }  } public int requestAppFocus(IAppFocusOwnershipCallback param2IAppFocusOwnershipCallback, int param2Int) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 205 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 208 */           parcel1.writeInterfaceToken("android.car.IAppFocus");
/* 209 */           if (param2IAppFocusOwnershipCallback != null) { IBinder iBinder = param2IAppFocusOwnershipCallback.asBinder(); } else { param2IAppFocusOwnershipCallback = null; }  parcel1.writeStrongBinder((IBinder)param2IAppFocusOwnershipCallback);
/* 210 */           parcel1.writeInt(param2Int);
/* 211 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 212 */           parcel2.readException();
/* 213 */           param2Int = parcel2.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 219 */           return param2Int;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         }  }
/* 224 */       public void abandonAppFocus(IAppFocusOwnershipCallback param2IAppFocusOwnershipCallback, int param2Int) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 225 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/* 227 */         try { parcel2.writeInterfaceToken("android.car.IAppFocus");
/* 228 */           if (param2IAppFocusOwnershipCallback != null) { IBinder iBinder = param2IAppFocusOwnershipCallback.asBinder(); } else { param2IAppFocusOwnershipCallback = null; }  parcel2.writeStrongBinder((IBinder)param2IAppFocusOwnershipCallback);
/* 229 */           parcel2.writeInt(param2Int);
/* 230 */           this.mRemote.transact(6, parcel2, parcel1, 0);
/* 231 */           parcel1.readException();
/*     */           return; }
/*     */         finally
/* 234 */         { parcel1.recycle();
/* 235 */           parcel2.recycle(); }  } } } private static class Proxy implements IAppFocus { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.IAppFocus"; } public void abandonAppFocus(IAppFocusOwnershipCallback param1IAppFocusOwnershipCallback, int param1Int) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.IAppFocus"); if (param1IAppFocusOwnershipCallback != null) { IBinder iBinder = param1IAppFocusOwnershipCallback.asBinder(); } else { param1IAppFocusOwnershipCallback = null; }  parcel2.writeStrongBinder((IBinder)param1IAppFocusOwnershipCallback); parcel2.writeInt(param1Int); this.mRemote.transact(6, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void registerFocusListener(IAppFocusListener param1IAppFocusListener, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.IAppFocus");
/*     */         if (param1IAppFocusListener != null) {
/*     */           IBinder iBinder = param1IAppFocusListener.asBinder();
/*     */         } else {
/*     */           param1IAppFocusListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IAppFocusListener);
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterFocusListener(IAppFocusListener param1IAppFocusListener, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.IAppFocus");
/*     */         if (param1IAppFocusListener != null) {
/*     */           IBinder iBinder = param1IAppFocusListener.asBinder();
/*     */         } else {
/*     */           param1IAppFocusListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IAppFocusListener);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(2, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int[] getActiveAppTypes() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.IAppFocus");
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.createIntArray();
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isOwningFocus(IAppFocusOwnershipCallback param1IAppFocusOwnershipCallback, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.IAppFocus");
/*     */         if (param1IAppFocusOwnershipCallback != null) {
/*     */           IBinder iBinder1 = param1IAppFocusOwnershipCallback.asBinder();
/*     */         } else {
/*     */           param1IAppFocusOwnershipCallback = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IAppFocusOwnershipCallback);
/*     */         parcel1.writeInt(param1Int);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         param1Int = parcel2.readInt();
/*     */         if (param1Int != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int requestAppFocus(IAppFocusOwnershipCallback param1IAppFocusOwnershipCallback, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.IAppFocus");
/*     */         if (param1IAppFocusOwnershipCallback != null) {
/*     */           IBinder iBinder = param1IAppFocusOwnershipCallback.asBinder();
/*     */         } else {
/*     */           param1IAppFocusOwnershipCallback = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IAppFocusOwnershipCallback);
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         param1Int = parcel2.readInt();
/*     */         return param1Int;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\IAppFocus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */