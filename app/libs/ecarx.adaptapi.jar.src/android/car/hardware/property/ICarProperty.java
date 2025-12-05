/*     */ package android.car.hardware.property;public interface ICarProperty extends IInterface { CarPropertyValue getProperty(int paramInt1, int paramInt2) throws RemoteException;
/*     */   List<CarPropertyConfig> getPropertyList() throws RemoteException;
/*     */   
/*     */   void registerListener(int paramInt, float paramFloat, ICarPropertyEventListener paramICarPropertyEventListener) throws RemoteException;
/*     */   
/*     */   void setProperty(CarPropertyValue paramCarPropertyValue) throws RemoteException;
/*     */   
/*     */   void unregisterListener(int paramInt, ICarPropertyEventListener paramICarPropertyEventListener) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub extends Binder implements ICarProperty { private static final String DESCRIPTOR = "android.car.hardware.property.ICarProperty";
/*     */     static final int TRANSACTION_getProperty = 4;
/*     */     static final int TRANSACTION_getPropertyList = 3;
/*     */     static final int TRANSACTION_registerListener = 1;
/*     */     static final int TRANSACTION_setProperty = 5;
/*     */     static final int TRANSACTION_unregisterListener = 2;
/*     */     
/*     */     public Stub() {
/*  18 */       attachInterface(this, "android.car.hardware.property.ICarProperty");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarProperty asInterface(IBinder param1IBinder) {
/*  26 */       if (param1IBinder == null) {
/*  27 */         return null;
/*     */       }
/*  29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.hardware.property.ICarProperty");
/*  30 */       if (iInterface != null && iInterface instanceof ICarProperty) {
/*  31 */         return (ICarProperty)iInterface;
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
/*  42 */       if (param1Int1 != 1598968902) { CarPropertyValue carPropertyValue; List<CarPropertyConfig> list; switch (param1Int1)
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
/*     */           default:
/* 115 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 5: param1Parcel1.enforceInterface("android.car.hardware.property.ICarProperty"); if (param1Parcel1.readInt() != 0) { CarPropertyValue carPropertyValue1 = (CarPropertyValue)CarPropertyValue.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = null; }  setProperty((CarPropertyValue)param1Parcel1); param1Parcel2.writeNoException(); return true;
/*     */           case 4:
/*     */             param1Parcel1.enforceInterface("android.car.hardware.property.ICarProperty"); param1Int2 = param1Parcel1.readInt(); param1Int1 = param1Parcel1.readInt(); carPropertyValue = getProperty(param1Int2, param1Int1); param1Parcel2.writeNoException(); if (carPropertyValue != null) { param1Parcel2.writeInt(1); carPropertyValue.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 3:
/*     */             carPropertyValue.enforceInterface("android.car.hardware.property.ICarProperty"); list = getPropertyList(); param1Parcel2.writeNoException(); param1Parcel2.writeTypedList(list); return true;
/*     */           case 2:
/*     */             list.enforceInterface("android.car.hardware.property.ICarProperty"); param1Int1 = list.readInt(); iCarPropertyEventListener = ICarPropertyEventListener.Stub.asInterface(list.readStrongBinder()); unregisterListener(param1Int1, iCarPropertyEventListener); param1Parcel2.writeNoException(); return true;
/*     */           case 1:
/* 124 */             break; }  iCarPropertyEventListener.enforceInterface("android.car.hardware.property.ICarProperty"); param1Int1 = iCarPropertyEventListener.readInt(); float f = iCarPropertyEventListener.readFloat(); ICarPropertyEventListener iCarPropertyEventListener = ICarPropertyEventListener.Stub.asInterface(iCarPropertyEventListener.readStrongBinder()); registerListener(param1Int1, f, iCarPropertyEventListener); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.hardware.property.ICarProperty"); return true; } private static class Proxy implements ICarProperty { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 128 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 132 */         return "android.car.hardware.property.ICarProperty";
/*     */       }
/*     */       
/*     */       public void registerListener(int param2Int, float param2Float, ICarPropertyEventListener param2ICarPropertyEventListener) throws RemoteException {
/* 136 */         Parcel parcel2 = Parcel.obtain();
/* 137 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 139 */           parcel2.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/* 140 */           parcel2.writeInt(param2Int);
/* 141 */           parcel2.writeFloat(param2Float);
/* 142 */           if (param2ICarPropertyEventListener != null) { IBinder iBinder = param2ICarPropertyEventListener.asBinder(); } else { param2ICarPropertyEventListener = null; }  parcel2.writeStrongBinder((IBinder)param2ICarPropertyEventListener);
/* 143 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 144 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 147 */           parcel1.recycle();
/* 148 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public void unregisterListener(int param2Int, ICarPropertyEventListener param2ICarPropertyEventListener) throws RemoteException {
/* 153 */         Parcel parcel1 = Parcel.obtain();
/* 154 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 156 */           parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/* 157 */           parcel1.writeInt(param2Int);
/* 158 */           if (param2ICarPropertyEventListener != null) { IBinder iBinder = param2ICarPropertyEventListener.asBinder(); } else { param2ICarPropertyEventListener = null; }  parcel1.writeStrongBinder((IBinder)param2ICarPropertyEventListener);
/* 159 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 160 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 163 */           parcel2.recycle();
/* 164 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public List<CarPropertyConfig> getPropertyList() throws RemoteException {
/* 169 */         Parcel parcel1 = Parcel.obtain();
/* 170 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 173 */           parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/* 174 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 175 */           parcel2.readException();
/* 176 */           return parcel2.createTypedArrayList(CarPropertyConfig.CREATOR);
/*     */         } finally {
/*     */           
/* 179 */           parcel2.recycle();
/* 180 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public CarPropertyValue getProperty(int param2Int1, int param2Int2) throws RemoteException
/*     */       {
/* 186 */         Parcel parcel1 = Parcel.obtain();
/* 187 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/*     */           CarPropertyValue carPropertyValue;
/* 190 */           parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/* 191 */           parcel1.writeInt(param2Int1);
/* 192 */           parcel1.writeInt(param2Int2);
/* 193 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 194 */           parcel2.readException();
/* 195 */           if (parcel2.readInt() != 0) {
/* 196 */             carPropertyValue = (CarPropertyValue)CarPropertyValue.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 199 */             carPropertyValue = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 206 */           return carPropertyValue;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 210 */         }  } public void setProperty(CarPropertyValue param2CarPropertyValue) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 211 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/* 213 */         try { parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/* 214 */           if (param2CarPropertyValue != null) {
/* 215 */             parcel1.writeInt(1);
/* 216 */             param2CarPropertyValue.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 219 */             parcel1.writeInt(0);
/*     */           } 
/* 221 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 222 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 225 */         { parcel2.recycle();
/* 226 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarProperty { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.hardware.property.ICarProperty"; } public void setProperty(CarPropertyValue param1CarPropertyValue) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty"); if (param1CarPropertyValue != null) { parcel1.writeInt(1); param1CarPropertyValue.writeToParcel(parcel1, 0); } else { parcel1.writeInt(0); }  this.mRemote.transact(5, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void registerListener(int param1Int, float param1Float, ICarPropertyEventListener param1ICarPropertyEventListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/*     */         parcel2.writeInt(param1Int);
/*     */         parcel2.writeFloat(param1Float);
/*     */         if (param1ICarPropertyEventListener != null) {
/*     */           IBinder iBinder = param1ICarPropertyEventListener.asBinder();
/*     */         } else {
/*     */           param1ICarPropertyEventListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1ICarPropertyEventListener);
/*     */         this.mRemote.transact(1, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterListener(int param1Int, ICarPropertyEventListener param1ICarPropertyEventListener) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/*     */         parcel1.writeInt(param1Int);
/*     */         if (param1ICarPropertyEventListener != null) {
/*     */           IBinder iBinder = param1ICarPropertyEventListener.asBinder();
/*     */         } else {
/*     */           param1ICarPropertyEventListener = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1ICarPropertyEventListener);
/*     */         this.mRemote.transact(2, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public List<CarPropertyConfig> getPropertyList() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.createTypedArrayList(CarPropertyConfig.CREATOR);
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public CarPropertyValue getProperty(int param1Int1, int param1Int2) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         CarPropertyValue carPropertyValue;
/*     */         parcel1.writeInterfaceToken("android.car.hardware.property.ICarProperty");
/*     */         parcel1.writeInt(param1Int1);
/*     */         parcel1.writeInt(param1Int2);
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           carPropertyValue = (CarPropertyValue)CarPropertyValue.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           carPropertyValue = null;
/*     */         } 
/*     */         return carPropertyValue;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\hardware\property\ICarProperty.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */