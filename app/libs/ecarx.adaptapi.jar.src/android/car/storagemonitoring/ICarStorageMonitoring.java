/*     */ package android.car.storagemonitoring;public interface ICarStorageMonitoring extends IInterface { List<IoStatsEntry> getAggregateIoStats() throws RemoteException;
/*     */   List<IoStatsEntry> getBootIoStats() throws RemoteException;
/*     */   List<IoStats> getIoStatsDeltas() throws RemoteException;
/*     */   int getPreEolIndicatorStatus() throws RemoteException;
/*     */   long getShutdownDiskWriteAmount() throws RemoteException;
/*     */   WearEstimate getWearEstimate() throws RemoteException;
/*     */   List<WearEstimateChange> getWearEstimateHistory() throws RemoteException;
/*     */   void registerListener(IIoStatsListener paramIIoStatsListener) throws RemoteException;
/*     */   void unregisterListener(IIoStatsListener paramIIoStatsListener) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements ICarStorageMonitoring { private static final String DESCRIPTOR = "android.car.storagemonitoring.ICarStorageMonitoring"; static final int TRANSACTION_getAggregateIoStats = 6; static final int TRANSACTION_getBootIoStats = 5; static final int TRANSACTION_getIoStatsDeltas = 7; static final int TRANSACTION_getPreEolIndicatorStatus = 2; static final int TRANSACTION_getShutdownDiskWriteAmount = 10; static final int TRANSACTION_getWearEstimate = 3;
/*     */     static final int TRANSACTION_getWearEstimateHistory = 4;
/*     */     static final int TRANSACTION_registerListener = 8;
/*     */     static final int TRANSACTION_unregisterListener = 9;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.storagemonitoring.ICarStorageMonitoring");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarStorageMonitoring asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.storagemonitoring.ICarStorageMonitoring");
/*  28 */       if (iInterface != null && iInterface instanceof ICarStorageMonitoring) {
/*  29 */         return (ICarStorageMonitoring)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { IIoStatsListener iIoStatsListener; List<IoStats> list; WearEstimate wearEstimate; long l; switch (param1Int1)
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
/*     */           default:
/* 129 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 10: param1Parcel1.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); l = getShutdownDiskWriteAmount(); param1Parcel2.writeNoException(); param1Parcel2.writeLong(l); return true;
/*     */           case 9: param1Parcel1.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); iIoStatsListener = IIoStatsListener.Stub.asInterface(param1Parcel1.readStrongBinder()); unregisterListener(iIoStatsListener); param1Parcel2.writeNoException(); return true;
/*     */           case 8: iIoStatsListener.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); iIoStatsListener = IIoStatsListener.Stub.asInterface(iIoStatsListener.readStrongBinder()); registerListener(iIoStatsListener); param1Parcel2.writeNoException(); return true;
/*     */           case 7: iIoStatsListener.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); list = getIoStatsDeltas(); param1Parcel2.writeNoException(); param1Parcel2.writeTypedList(list); return true;
/*     */           case 6: list.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); list = (List)getAggregateIoStats(); param1Parcel2.writeNoException(); param1Parcel2.writeTypedList(list); return true;
/*     */           case 5: list.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); list = (List)getBootIoStats(); param1Parcel2.writeNoException(); param1Parcel2.writeTypedList(list); return true;
/*     */           case 4: list.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); list = (List)getWearEstimateHistory(); param1Parcel2.writeNoException(); param1Parcel2.writeTypedList(list); return true;
/*     */           case 3: list.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); wearEstimate = getWearEstimate(); param1Parcel2.writeNoException(); if (wearEstimate != null) { param1Parcel2.writeInt(1); wearEstimate.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/* 138 */           case 2: break; }  wearEstimate.enforceInterface("android.car.storagemonitoring.ICarStorageMonitoring"); param1Int1 = getPreEolIndicatorStatus(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(param1Int1); return true; }  param1Parcel2.writeString("android.car.storagemonitoring.ICarStorageMonitoring"); return true; } private static class Proxy implements ICarStorageMonitoring { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 142 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 146 */         return "android.car.storagemonitoring.ICarStorageMonitoring";
/*     */       }
/*     */       
/*     */       public int getPreEolIndicatorStatus() throws RemoteException {
/* 150 */         Parcel parcel2 = Parcel.obtain();
/* 151 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 154 */           parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 155 */           this.mRemote.transact(2, parcel2, parcel1, 0);
/* 156 */           parcel1.readException();
/* 157 */           return parcel1.readInt();
/*     */         } finally {
/*     */           
/* 160 */           parcel1.recycle();
/* 161 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public WearEstimate getWearEstimate() throws RemoteException {
/* 170 */         Parcel parcel1 = Parcel.obtain();
/* 171 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/*     */           WearEstimate wearEstimate;
/* 174 */           parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 175 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 176 */           parcel2.readException();
/* 177 */           if (parcel2.readInt() != 0) {
/* 178 */             wearEstimate = (WearEstimate)WearEstimate.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 181 */             wearEstimate = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 188 */           return wearEstimate;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       public List<WearEstimateChange> getWearEstimateHistory() throws RemoteException {
/* 195 */         Parcel parcel1 = Parcel.obtain();
/* 196 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 199 */           parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 200 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 201 */           parcel2.readException();
/* 202 */           return parcel2.createTypedArrayList(WearEstimateChange.CREATOR);
/*     */         } finally {
/*     */           
/* 205 */           parcel2.recycle();
/* 206 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<IoStatsEntry> getBootIoStats() throws RemoteException {
/* 215 */         Parcel parcel1 = Parcel.obtain();
/* 216 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 219 */           parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 220 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 221 */           parcel2.readException();
/* 222 */           return parcel2.createTypedArrayList(IoStatsEntry.CREATOR);
/*     */         } finally {
/*     */           
/* 225 */           parcel2.recycle();
/* 226 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<IoStatsEntry> getAggregateIoStats() throws RemoteException {
/* 235 */         Parcel parcel1 = Parcel.obtain();
/* 236 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 239 */           parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 240 */           this.mRemote.transact(6, parcel1, parcel2, 0);
/* 241 */           parcel2.readException();
/* 242 */           return parcel2.createTypedArrayList(IoStatsEntry.CREATOR);
/*     */         } finally {
/*     */           
/* 245 */           parcel2.recycle();
/* 246 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public List<IoStats> getIoStatsDeltas() throws RemoteException {
/* 255 */         Parcel parcel2 = Parcel.obtain();
/* 256 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 259 */           parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 260 */           this.mRemote.transact(7, parcel2, parcel1, 0);
/* 261 */           parcel1.readException();
/* 262 */           return parcel1.createTypedArrayList(IoStats.CREATOR);
/*     */         } finally {
/*     */           
/* 265 */           parcel1.recycle();
/* 266 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void registerListener(IIoStatsListener param2IIoStatsListener) throws RemoteException {
/* 275 */         Parcel parcel2 = Parcel.obtain();
/* 276 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 278 */           parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 279 */           if (param2IIoStatsListener != null) { IBinder iBinder = param2IIoStatsListener.asBinder(); } else { param2IIoStatsListener = null; }  parcel2.writeStrongBinder((IBinder)param2IIoStatsListener);
/* 280 */           this.mRemote.transact(8, parcel2, parcel1, 0);
/* 281 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 284 */           parcel1.recycle();
/* 285 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void unregisterListener(IIoStatsListener param2IIoStatsListener) throws RemoteException {
/* 293 */         Parcel parcel2 = Parcel.obtain();
/* 294 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 296 */           parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 297 */           if (param2IIoStatsListener != null) { IBinder iBinder = param2IIoStatsListener.asBinder(); } else { param2IIoStatsListener = null; }  parcel2.writeStrongBinder((IBinder)param2IIoStatsListener);
/* 298 */           this.mRemote.transact(9, parcel2, parcel1, 0);
/* 299 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 302 */           parcel1.recycle();
/* 303 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public long getShutdownDiskWriteAmount() throws RemoteException
/*     */       {
/* 311 */         Parcel parcel1 = Parcel.obtain();
/* 312 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 315 */         try { parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/* 316 */           this.mRemote.transact(10, parcel1, parcel2, 0);
/* 317 */           parcel2.readException();
/* 318 */           return parcel2.readLong(); }
/*     */         finally
/*     */         
/* 321 */         { parcel2.recycle();
/* 322 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarStorageMonitoring { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public long getShutdownDiskWriteAmount() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring"); this.mRemote.transact(10, parcel1, parcel2, 0); parcel2.readException(); return parcel2.readLong(); } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.storagemonitoring.ICarStorageMonitoring";
/*     */     }
/*     */     
/*     */     public int getPreEolIndicatorStatus() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         this.mRemote.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.readInt();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public WearEstimate getWearEstimate() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         WearEstimate wearEstimate;
/*     */         parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           wearEstimate = (WearEstimate)WearEstimate.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           wearEstimate = null;
/*     */         } 
/*     */         return wearEstimate;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public List<WearEstimateChange> getWearEstimateHistory() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.createTypedArrayList(WearEstimateChange.CREATOR);
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public List<IoStatsEntry> getBootIoStats() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.createTypedArrayList(IoStatsEntry.CREATOR);
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public List<IoStatsEntry> getAggregateIoStats() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         this.mRemote.transact(6, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return parcel2.createTypedArrayList(IoStatsEntry.CREATOR);
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public List<IoStats> getIoStatsDeltas() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         this.mRemote.transact(7, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.createTypedArrayList(IoStats.CREATOR);
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void registerListener(IIoStatsListener param1IIoStatsListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         if (param1IIoStatsListener != null) {
/*     */           IBinder iBinder = param1IIoStatsListener.asBinder();
/*     */         } else {
/*     */           param1IIoStatsListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IIoStatsListener);
/*     */         this.mRemote.transact(8, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void unregisterListener(IIoStatsListener param1IIoStatsListener) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.storagemonitoring.ICarStorageMonitoring");
/*     */         if (param1IIoStatsListener != null) {
/*     */           IBinder iBinder = param1IIoStatsListener.asBinder();
/*     */         } else {
/*     */           param1IIoStatsListener = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IIoStatsListener);
/*     */         this.mRemote.transact(9, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\storagemonitoring\ICarStorageMonitoring.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */