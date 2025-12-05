/*     */ package ecarx.car.hardware.property;public interface IECarXCarProperty extends IInterface { ECarXCarPropertyValue getProperty(int paramInt1, int paramInt2) throws RemoteException;
/*     */   List<CarPropertyConfig> getPropertyList() throws RemoteException;
/*     */   void registerListener(IECarXCarPropertyEventListener paramIECarXCarPropertyEventListener, SignalFilter paramSignalFilter) throws RemoteException;
/*     */   void registerSignals(SignalFilter paramSignalFilter) throws RemoteException;
/*     */   void setProperty(ECarXCarPropertyValue paramECarXCarPropertyValue) throws RemoteException;
/*     */   void unregisterListener(IECarXCarPropertyEventListener paramIECarXCarPropertyEventListener, SignalFilter paramSignalFilter) throws RemoteException;
/*     */   void unregisterSignals(SignalFilter paramSignalFilter) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements IECarXCarProperty { private static final String DESCRIPTOR = "ecarx.car.hardware.property.IECarXCarProperty";
/*     */     static final int TRANSACTION_getProperty = 4;
/*     */     static final int TRANSACTION_getPropertyList = 3;
/*     */     static final int TRANSACTION_registerListener = 1;
/*     */     static final int TRANSACTION_registerSignals = 6;
/*     */     static final int TRANSACTION_setProperty = 5;
/*     */     static final int TRANSACTION_unregisterListener = 2;
/*     */     static final int TRANSACTION_unregisterSignals = 7;
/*     */     
/*     */     public Stub() {
/*  18 */       attachInterface(this, "ecarx.car.hardware.property.IECarXCarProperty");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IECarXCarProperty asInterface(IBinder param1IBinder) {
/*  26 */       if (param1IBinder == null) {
/*  27 */         return null;
/*     */       }
/*  29 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.hardware.property.IECarXCarProperty");
/*  30 */       if (iInterface != null && iInterface instanceof IECarXCarProperty) {
/*  31 */         return (IECarXCarProperty)iInterface;
/*     */       }
/*  33 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  37 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  42 */       if (param1Int1 != 1598968902) { ECarXCarPropertyValue eCarXCarPropertyValue; List<CarPropertyConfig> list; IECarXCarPropertyEventListener iECarXCarPropertyEventListener1; Parcel parcel3 = null, parcel2 = null; List list1 = null; IECarXCarPropertyEventListener iECarXCarPropertyEventListener2 = null; Parcel parcel1 = null; switch (param1Int1)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 151 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 7: param1Parcel1.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); if (param1Parcel1.readInt() != 0) { SignalFilter signalFilter = (SignalFilter)SignalFilter.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel1; }  unregisterSignals((SignalFilter)param1Parcel1); param1Parcel2.writeNoException(); return true;
/*     */           case 6: param1Parcel1.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); if (param1Parcel1.readInt() != 0) { SignalFilter signalFilter = (SignalFilter)SignalFilter.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel3; }  registerSignals((SignalFilter)param1Parcel1); param1Parcel2.writeNoException(); return true;
/*     */           case 5: param1Parcel1.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); if (param1Parcel1.readInt() != 0) { ECarXCarPropertyValue eCarXCarPropertyValue1 = (ECarXCarPropertyValue)ECarXCarPropertyValue.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel2; }  setProperty((ECarXCarPropertyValue)param1Parcel1); param1Parcel2.writeNoException(); return true;
/*     */           case 4: param1Parcel1.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); param1Int1 = param1Parcel1.readInt(); param1Int2 = param1Parcel1.readInt(); eCarXCarPropertyValue = getProperty(param1Int1, param1Int2); param1Parcel2.writeNoException(); if (eCarXCarPropertyValue != null) { param1Parcel2.writeInt(1); eCarXCarPropertyValue.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 3: eCarXCarPropertyValue.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); list = getPropertyList(); param1Parcel2.writeNoException(); param1Parcel2.writeTypedList(list); return true;
/*     */           case 2:
/*     */             list.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); iECarXCarPropertyEventListener2 = IECarXCarPropertyEventListener.Stub.asInterface(list.readStrongBinder()); if (list.readInt() != 0) { SignalFilter signalFilter = (SignalFilter)SignalFilter.CREATOR.createFromParcel((Parcel)list); } else { list = list1; }  unregisterListener(iECarXCarPropertyEventListener2, (SignalFilter)list); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/* 160 */             break; }  list.enforceInterface("ecarx.car.hardware.property.IECarXCarProperty"); IECarXCarPropertyEventListener iECarXCarPropertyEventListener3 = IECarXCarPropertyEventListener.Stub.asInterface(list.readStrongBinder()); if (list.readInt() != 0) { SignalFilter signalFilter = (SignalFilter)SignalFilter.CREATOR.createFromParcel((Parcel)list); } else { iECarXCarPropertyEventListener1 = iECarXCarPropertyEventListener2; }  registerListener(iECarXCarPropertyEventListener3, (SignalFilter)iECarXCarPropertyEventListener1); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("ecarx.car.hardware.property.IECarXCarProperty"); return true; } private static class Proxy implements IECarXCarProperty { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 164 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 168 */         return "ecarx.car.hardware.property.IECarXCarProperty";
/*     */       }
/*     */       
/*     */       public void registerListener(IECarXCarPropertyEventListener param2IECarXCarPropertyEventListener, SignalFilter param2SignalFilter) throws RemoteException {
/* 172 */         Parcel parcel2 = Parcel.obtain();
/* 173 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 175 */           parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 176 */           if (param2IECarXCarPropertyEventListener != null) { IBinder iBinder = param2IECarXCarPropertyEventListener.asBinder(); } else { param2IECarXCarPropertyEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2IECarXCarPropertyEventListener);
/* 177 */           if (param2SignalFilter != null) {
/* 178 */             parcel2.writeInt(1);
/* 179 */             param2SignalFilter.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 182 */             parcel2.writeInt(0);
/*     */           } 
/* 184 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 185 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 188 */           parcel1.recycle();
/* 189 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterListener(IECarXCarPropertyEventListener param2IECarXCarPropertyEventListener, SignalFilter param2SignalFilter) throws RemoteException {
/* 194 */         Parcel parcel2 = Parcel.obtain();
/* 195 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 197 */           parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 198 */           if (param2IECarXCarPropertyEventListener != null) { IBinder iBinder = param2IECarXCarPropertyEventListener.asBinder(); } else { param2IECarXCarPropertyEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2IECarXCarPropertyEventListener);
/* 199 */           if (param2SignalFilter != null) {
/* 200 */             parcel2.writeInt(1);
/* 201 */             param2SignalFilter.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 204 */             parcel2.writeInt(0);
/*     */           } 
/* 206 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 207 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 210 */           parcel1.recycle();
/* 211 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public List<CarPropertyConfig> getPropertyList() throws RemoteException {
/* 216 */         Parcel parcel2 = Parcel.obtain();
/* 217 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 220 */           parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 221 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 222 */           parcel1.readException();
/* 223 */           return parcel1.createTypedArrayList(CarPropertyConfig.CREATOR);
/*     */         } finally {
/*     */           
/* 226 */           parcel1.recycle();
/* 227 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public ECarXCarPropertyValue getProperty(int param2Int1, int param2Int2) throws RemoteException
/*     */       {
/* 233 */         Parcel parcel1 = Parcel.obtain();
/* 234 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/*     */           ECarXCarPropertyValue eCarXCarPropertyValue;
/* 237 */           parcel1.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 238 */           parcel1.writeInt(param2Int1);
/* 239 */           parcel1.writeInt(param2Int2);
/* 240 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 241 */           parcel2.readException();
/* 242 */           if (parcel2.readInt() != 0) {
/* 243 */             eCarXCarPropertyValue = (ECarXCarPropertyValue)ECarXCarPropertyValue.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 246 */             eCarXCarPropertyValue = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 253 */           return eCarXCarPropertyValue;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 257 */         }  } public void setProperty(ECarXCarPropertyValue param2ECarXCarPropertyValue) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 258 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 260 */           parcel1.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 261 */           if (param2ECarXCarPropertyValue != null) {
/* 262 */             parcel1.writeInt(1);
/* 263 */             param2ECarXCarPropertyValue.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 266 */             parcel1.writeInt(0);
/*     */           } 
/* 268 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 269 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 272 */           parcel2.recycle();
/* 273 */           parcel1.recycle();
/*     */         }  }
/*     */ 
/*     */       
/*     */       public void registerSignals(SignalFilter param2SignalFilter) throws RemoteException {
/* 278 */         Parcel parcel1 = Parcel.obtain();
/* 279 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 281 */           parcel1.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 282 */           if (param2SignalFilter != null) {
/* 283 */             parcel1.writeInt(1);
/* 284 */             param2SignalFilter.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 287 */             parcel1.writeInt(0);
/*     */           } 
/* 289 */           this.mRemote.transact(6, parcel1, parcel2, 0);
/* 290 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 293 */           parcel2.recycle();
/* 294 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterSignals(SignalFilter param2SignalFilter) throws RemoteException {
/* 299 */         Parcel parcel2 = Parcel.obtain();
/* 300 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/* 302 */         try { parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/* 303 */           if (param2SignalFilter != null) {
/* 304 */             parcel2.writeInt(1);
/* 305 */             param2SignalFilter.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 308 */             parcel2.writeInt(0);
/*     */           } 
/* 310 */           this.mRemote.transact(7, parcel2, parcel1, 0);
/* 311 */           parcel1.readException();
/*     */           return; }
/*     */         finally
/* 314 */         { parcel1.recycle();
/* 315 */           parcel2.recycle(); }  } } } private static class Proxy implements IECarXCarProperty { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "ecarx.car.hardware.property.IECarXCarProperty"; } public void registerListener(IECarXCarPropertyEventListener param1IECarXCarPropertyEventListener, SignalFilter param1SignalFilter) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty"); if (param1IECarXCarPropertyEventListener != null) { IBinder iBinder = param1IECarXCarPropertyEventListener.asBinder(); } else { param1IECarXCarPropertyEventListener = null; }  parcel2.writeStrongBinder((IBinder)param1IECarXCarPropertyEventListener); if (param1SignalFilter != null) { parcel2.writeInt(1); param1SignalFilter.writeToParcel(parcel2, 0); } else { parcel2.writeInt(0); }  this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public void unregisterSignals(SignalFilter param1SignalFilter) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty"); if (param1SignalFilter != null) { parcel2.writeInt(1); param1SignalFilter.writeToParcel(parcel2, 0); } else { parcel2.writeInt(0); }  this.mRemote.transact(7, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void unregisterListener(IECarXCarPropertyEventListener param1IECarXCarPropertyEventListener, SignalFilter param1SignalFilter) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/*     */         if (param1IECarXCarPropertyEventListener != null) {
/*     */           IBinder iBinder = param1IECarXCarPropertyEventListener.asBinder();
/*     */         } else {
/*     */           param1IECarXCarPropertyEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IECarXCarPropertyEventListener);
/*     */         if (param1SignalFilter != null) {
/*     */           parcel2.writeInt(1);
/*     */           param1SignalFilter.writeToParcel(parcel2, 0);
/*     */         } else {
/*     */           parcel2.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public List<CarPropertyConfig> getPropertyList() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/*     */         this.mRemote.transact(3, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.createTypedArrayList(CarPropertyConfig.CREATOR);
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public ECarXCarPropertyValue getProperty(int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         ECarXCarPropertyValue eCarXCarPropertyValue;
/*     */         parcel1.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/*     */         parcel1.writeInt(param1Int1);
/*     */         parcel1.writeInt(param1Int2);
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           eCarXCarPropertyValue = (ECarXCarPropertyValue)ECarXCarPropertyValue.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           eCarXCarPropertyValue = null;
/*     */         } 
/*     */         return eCarXCarPropertyValue;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setProperty(ECarXCarPropertyValue param1ECarXCarPropertyValue) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/*     */         if (param1ECarXCarPropertyValue != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1ECarXCarPropertyValue.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerSignals(SignalFilter param1SignalFilter) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.hardware.property.IECarXCarProperty");
/*     */         if (param1SignalFilter != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1SignalFilter.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(6, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\property\IECarXCarProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */