/*     */ package ecarx.car;public interface IHardKey extends IInterface { void abandonHardKeyEvent(IKeyEventListener paramIKeyEventListener, int paramInt) throws RemoteException;
/*     */   long getInputSettingDuration(int paramInt) throws RemoteException;
/*     */   int getInputSettingValue(int paramInt) throws RemoteException;
/*     */   void notifyMediaPlayPause() throws RemoteException;
/*     */   void notifyPowerKeySingleTap() throws RemoteException;
/*     */   void requestHardKeyEvent(IKeyEventListener paramIKeyEventListener, int paramInt) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements IHardKey { private static final String DESCRIPTOR = "ecarx.car.IHardKey";
/*     */     static final int TRANSACTION_abandonHardKeyEvent = 2;
/*     */     static final int TRANSACTION_getInputSettingDuration = 5;
/*     */     static final int TRANSACTION_getInputSettingValue = 6;
/*     */     static final int TRANSACTION_notifyMediaPlayPause = 4;
/*     */     static final int TRANSACTION_notifyPowerKeySingleTap = 3;
/*     */     static final int TRANSACTION_requestHardKeyEvent = 1;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "ecarx.car.IHardKey");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IHardKey asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IHardKey");
/*  28 */       if (iInterface != null && iInterface instanceof IHardKey) {
/*  29 */         return (IHardKey)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { long l; switch (param1Int1)
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
/*     */           default:
/* 105 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 6: param1Parcel1.enforceInterface("ecarx.car.IHardKey"); param1Int1 = param1Parcel1.readInt(); param1Int1 = getInputSettingValue(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true;
/*     */           case 5: param1Parcel1.enforceInterface("ecarx.car.IHardKey"); param1Int1 = param1Parcel1.readInt(); l = getInputSettingDuration(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeLong(l); return true;
/*     */           case 4: param1Parcel1.enforceInterface("ecarx.car.IHardKey"); notifyMediaPlayPause(); param1Parcel2.writeNoException(); return true;
/*     */           case 3:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IHardKey"); notifyPowerKeySingleTap(); param1Parcel2.writeNoException(); return true;
/*     */           case 2:
/*     */             param1Parcel1.enforceInterface("ecarx.car.IHardKey"); iKeyEventListener = IKeyEventListener.Stub.asInterface(param1Parcel1.readStrongBinder()); param1Int1 = param1Parcel1.readInt(); abandonHardKeyEvent(iKeyEventListener, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/* 114 */             break; }  param1Parcel1.enforceInterface("ecarx.car.IHardKey"); IKeyEventListener iKeyEventListener = IKeyEventListener.Stub.asInterface(param1Parcel1.readStrongBinder()); param1Int1 = param1Parcel1.readInt(); requestHardKeyEvent(iKeyEventListener, param1Int1); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("ecarx.car.IHardKey"); return true; } private static class Proxy implements IHardKey { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 118 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 122 */         return "ecarx.car.IHardKey";
/*     */       }
/*     */       
/*     */       public void requestHardKeyEvent(IKeyEventListener param2IKeyEventListener, int param2Int) throws RemoteException {
/* 126 */         Parcel parcel2 = Parcel.obtain();
/* 127 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 129 */           parcel2.writeInterfaceToken("ecarx.car.IHardKey");
/* 130 */           if (param2IKeyEventListener != null) { IBinder iBinder = param2IKeyEventListener.asBinder(); } else { param2IKeyEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2IKeyEventListener);
/* 131 */           parcel2.writeInt(param2Int);
/* 132 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 133 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 136 */           parcel1.recycle();
/* 137 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void abandonHardKeyEvent(IKeyEventListener param2IKeyEventListener, int param2Int) throws RemoteException {
/* 142 */         Parcel parcel2 = Parcel.obtain();
/* 143 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 145 */           parcel2.writeInterfaceToken("ecarx.car.IHardKey");
/* 146 */           if (param2IKeyEventListener != null) { IBinder iBinder = param2IKeyEventListener.asBinder(); } else { param2IKeyEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2IKeyEventListener);
/* 147 */           parcel2.writeInt(param2Int);
/* 148 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 149 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 152 */           parcel1.recycle();
/* 153 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void notifyPowerKeySingleTap() throws RemoteException {
/* 158 */         Parcel parcel1 = Parcel.obtain();
/* 159 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 161 */           parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/* 162 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 163 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 166 */           parcel2.recycle();
/* 167 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void notifyMediaPlayPause() throws RemoteException {
/* 172 */         Parcel parcel1 = Parcel.obtain();
/* 173 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 175 */           parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/* 176 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 177 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 180 */           parcel2.recycle();
/* 181 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public long getInputSettingDuration(int param2Int) throws RemoteException {
/* 186 */         Parcel parcel1 = Parcel.obtain();
/* 187 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 190 */           parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/* 191 */           parcel1.writeInt(param2Int);
/* 192 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 193 */           parcel2.readException();
/* 194 */           return parcel2.readLong();
/*     */         } finally {
/*     */           
/* 197 */           parcel2.recycle();
/* 198 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public int getInputSettingValue(int param2Int) throws RemoteException
/*     */       {
/* 204 */         Parcel parcel1 = Parcel.obtain();
/* 205 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 208 */         try { parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/* 209 */           parcel1.writeInt(param2Int);
/* 210 */           this.mRemote.transact(6, parcel1, parcel2, 0);
/* 211 */           parcel2.readException();
/* 212 */           param2Int = parcel2.readInt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 218 */           return param2Int; } finally { parcel2.recycle(); parcel1.recycle(); }  } } } private static class Proxy implements IHardKey { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "ecarx.car.IHardKey"; } public int getInputSettingValue(int param1Int) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IHardKey"); parcel1.writeInt(param1Int); this.mRemote.transact(6, parcel1, parcel2, 0); parcel2.readException(); param1Int = parcel2.readInt(); return param1Int; }
/*     */       finally
/*     */       { parcel2.recycle();
/*     */         parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void requestHardKeyEvent(IKeyEventListener param1IKeyEventListener, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IHardKey");
/*     */         if (param1IKeyEventListener != null) {
/*     */           IBinder iBinder = param1IKeyEventListener.asBinder();
/*     */         } else {
/*     */           param1IKeyEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IKeyEventListener);
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
/*     */     public void abandonHardKeyEvent(IKeyEventListener param1IKeyEventListener, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IHardKey");
/*     */         if (param1IKeyEventListener != null) {
/*     */           IBinder iBinder = param1IKeyEventListener.asBinder();
/*     */         } else {
/*     */           param1IKeyEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IKeyEventListener);
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
/*     */     public void notifyPowerKeySingleTap() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void notifyMediaPlayPause() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public long getInputSettingDuration(int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IHardKey");
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.readLong();
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IHardKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */