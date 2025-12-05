/*     */ package android.car.vms;public interface IVmsSubscriberService extends IInterface { void addVmsSubscriber(IVmsSubscriberClient paramIVmsSubscriberClient, VmsLayer paramVmsLayer) throws RemoteException;
/*     */   void addVmsSubscriberPassive(IVmsSubscriberClient paramIVmsSubscriberClient) throws RemoteException;
/*     */   void addVmsSubscriberToNotifications(IVmsSubscriberClient paramIVmsSubscriberClient) throws RemoteException;
/*     */   void addVmsSubscriberToPublisher(IVmsSubscriberClient paramIVmsSubscriberClient, VmsLayer paramVmsLayer, int paramInt) throws RemoteException;
/*     */   VmsAvailableLayers getAvailableLayers() throws RemoteException;
/*     */   byte[] getPublisherInfo(int paramInt) throws RemoteException;
/*     */   void removeVmsSubscriber(IVmsSubscriberClient paramIVmsSubscriberClient, VmsLayer paramVmsLayer) throws RemoteException;
/*     */   void removeVmsSubscriberPassive(IVmsSubscriberClient paramIVmsSubscriberClient) throws RemoteException;
/*     */   void removeVmsSubscriberToNotifications(IVmsSubscriberClient paramIVmsSubscriberClient) throws RemoteException;
/*     */   void removeVmsSubscriberToPublisher(IVmsSubscriberClient paramIVmsSubscriberClient, VmsLayer paramVmsLayer, int paramInt) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements IVmsSubscriberService { private static final String DESCRIPTOR = "android.car.vms.IVmsSubscriberService"; static final int TRANSACTION_addVmsSubscriber = 2; static final int TRANSACTION_addVmsSubscriberPassive = 3; static final int TRANSACTION_addVmsSubscriberToNotifications = 1; static final int TRANSACTION_addVmsSubscriberToPublisher = 4; static final int TRANSACTION_getAvailableLayers = 9; static final int TRANSACTION_getPublisherInfo = 10;
/*     */     static final int TRANSACTION_removeVmsSubscriber = 6;
/*     */     static final int TRANSACTION_removeVmsSubscriberPassive = 7;
/*     */     static final int TRANSACTION_removeVmsSubscriberToNotifications = 5;
/*     */     static final int TRANSACTION_removeVmsSubscriberToPublisher = 8;
/*     */     
/*     */     public Stub() {
/*  18 */       attachInterface(this, "android.car.vms.IVmsSubscriberService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IVmsSubscriberService asInterface(IBinder param1IBinder) {
/*  26 */       if (param1IBinder == null) {
/*  27 */         return null;
/*     */       }
/*  29 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.vms.IVmsSubscriberService");
/*  30 */       if (iInterface != null && iInterface instanceof IVmsSubscriberService) {
/*  31 */         return (IVmsSubscriberService)iInterface;
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
/*  42 */       if (param1Int1 != 1598968902) { byte[] arrayOfByte; VmsAvailableLayers vmsAvailableLayers; IVmsSubscriberClient iVmsSubscriberClient2; VmsLayer vmsLayer1; IVmsSubscriberClient iVmsSubscriberClient3, iVmsSubscriberClient4; VmsLayer vmsLayer2 = null, vmsLayer4 = null; IVmsSubscriberClient iVmsSubscriberClient5 = null; VmsLayer vmsLayer3 = null; switch (param1Int1)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 179 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);case 10: param1Parcel1.enforceInterface("android.car.vms.IVmsSubscriberService"); param1Int1 = param1Parcel1.readInt(); arrayOfByte = getPublisherInfo(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeByteArray(arrayOfByte); return true;
/*     */           case 9: arrayOfByte.enforceInterface("android.car.vms.IVmsSubscriberService"); vmsAvailableLayers = getAvailableLayers(); param1Parcel2.writeNoException(); if (vmsAvailableLayers != null) { param1Parcel2.writeInt(1); vmsAvailableLayers.writeToParcel(param1Parcel2, 1); } else { param1Parcel2.writeInt(0); }  return true;
/*     */           case 8: vmsAvailableLayers.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient5 = IVmsSubscriberClient.Stub.asInterface(vmsAvailableLayers.readStrongBinder()); if (vmsAvailableLayers.readInt() != 0) { vmsLayer2 = (VmsLayer)VmsLayer.CREATOR.createFromParcel((Parcel)vmsAvailableLayers); } else { vmsLayer2 = vmsLayer3; }  param1Int1 = vmsAvailableLayers.readInt(); removeVmsSubscriberToPublisher(iVmsSubscriberClient5, vmsLayer2, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 7: vmsAvailableLayers.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient2 = IVmsSubscriberClient.Stub.asInterface(vmsAvailableLayers.readStrongBinder()); removeVmsSubscriberPassive(iVmsSubscriberClient2); param1Parcel2.writeNoException(); return true;
/*     */           case 6: iVmsSubscriberClient2.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient4 = IVmsSubscriberClient.Stub.asInterface(iVmsSubscriberClient2.readStrongBinder()); if (iVmsSubscriberClient2.readInt() != 0) { vmsLayer1 = (VmsLayer)VmsLayer.CREATOR.createFromParcel((Parcel)iVmsSubscriberClient2); } else { vmsLayer1 = vmsLayer2; }  removeVmsSubscriber(iVmsSubscriberClient4, vmsLayer1); param1Parcel2.writeNoException(); return true;
/*     */           case 5: vmsLayer1.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient1 = IVmsSubscriberClient.Stub.asInterface(vmsLayer1.readStrongBinder()); removeVmsSubscriberToNotifications(iVmsSubscriberClient1); param1Parcel2.writeNoException(); return true;
/*     */           case 4: iVmsSubscriberClient1.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient4 = IVmsSubscriberClient.Stub.asInterface(iVmsSubscriberClient1.readStrongBinder()); if (iVmsSubscriberClient1.readInt() != 0) { vmsLayer2 = (VmsLayer)VmsLayer.CREATOR.createFromParcel((Parcel)iVmsSubscriberClient1); } else { vmsLayer2 = vmsLayer4; }  param1Int1 = iVmsSubscriberClient1.readInt(); addVmsSubscriberToPublisher(iVmsSubscriberClient4, vmsLayer2, param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 3: iVmsSubscriberClient1.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient1 = IVmsSubscriberClient.Stub.asInterface(iVmsSubscriberClient1.readStrongBinder()); addVmsSubscriberPassive(iVmsSubscriberClient1); param1Parcel2.writeNoException(); return true;
/*     */           case 2: iVmsSubscriberClient1.enforceInterface("android.car.vms.IVmsSubscriberService"); iVmsSubscriberClient3 = IVmsSubscriberClient.Stub.asInterface(iVmsSubscriberClient1.readStrongBinder()); if (iVmsSubscriberClient1.readInt() != 0) { VmsLayer vmsLayer = (VmsLayer)VmsLayer.CREATOR.createFromParcel((Parcel)iVmsSubscriberClient1); } else { iVmsSubscriberClient1 = iVmsSubscriberClient5; }  addVmsSubscriber(iVmsSubscriberClient3, (VmsLayer)iVmsSubscriberClient1); param1Parcel2.writeNoException(); return true;
/* 188 */           case 1: break; }  iVmsSubscriberClient1.enforceInterface("android.car.vms.IVmsSubscriberService"); IVmsSubscriberClient iVmsSubscriberClient1 = IVmsSubscriberClient.Stub.asInterface(iVmsSubscriberClient1.readStrongBinder()); addVmsSubscriberToNotifications(iVmsSubscriberClient1); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.vms.IVmsSubscriberService"); return true; } private static class Proxy implements IVmsSubscriberService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 192 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 196 */         return "android.car.vms.IVmsSubscriberService";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void addVmsSubscriberToNotifications(IVmsSubscriberClient param2IVmsSubscriberClient) throws RemoteException {
/* 205 */         Parcel parcel2 = Parcel.obtain();
/* 206 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 208 */           parcel2.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 209 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel2.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 210 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 211 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 214 */           parcel1.recycle();
/* 215 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void addVmsSubscriber(IVmsSubscriberClient param2IVmsSubscriberClient, VmsLayer param2VmsLayer) throws RemoteException {
/* 223 */         Parcel parcel1 = Parcel.obtain();
/* 224 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 226 */           parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 227 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel1.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 228 */           if (param2VmsLayer != null) {
/* 229 */             parcel1.writeInt(1);
/* 230 */             param2VmsLayer.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 233 */             parcel1.writeInt(0);
/*     */           } 
/* 235 */           this.mRemote.transact(2, parcel1, parcel2, 0);
/* 236 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 239 */           parcel2.recycle();
/* 240 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void addVmsSubscriberPassive(IVmsSubscriberClient param2IVmsSubscriberClient) throws RemoteException {
/* 250 */         Parcel parcel1 = Parcel.obtain();
/* 251 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 253 */           parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 254 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel1.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 255 */           this.mRemote.transact(3, parcel1, parcel2, 0);
/* 256 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 259 */           parcel2.recycle();
/* 260 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void addVmsSubscriberToPublisher(IVmsSubscriberClient param2IVmsSubscriberClient, VmsLayer param2VmsLayer, int param2Int) throws RemoteException {
/* 268 */         Parcel parcel2 = Parcel.obtain();
/* 269 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 271 */           parcel2.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 272 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel2.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 273 */           if (param2VmsLayer != null) {
/* 274 */             parcel2.writeInt(1);
/* 275 */             param2VmsLayer.writeToParcel(parcel2, 0);
/*     */           } else {
/*     */             
/* 278 */             parcel2.writeInt(0);
/*     */           } 
/* 280 */           parcel2.writeInt(param2Int);
/* 281 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 282 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 285 */           parcel1.recycle();
/* 286 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void removeVmsSubscriberToNotifications(IVmsSubscriberClient param2IVmsSubscriberClient) throws RemoteException {
/* 296 */         Parcel parcel1 = Parcel.obtain();
/* 297 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 299 */           parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 300 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel1.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 301 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 302 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 305 */           parcel2.recycle();
/* 306 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void removeVmsSubscriber(IVmsSubscriberClient param2IVmsSubscriberClient, VmsLayer param2VmsLayer) throws RemoteException {
/* 314 */         Parcel parcel1 = Parcel.obtain();
/* 315 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 317 */           parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 318 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel1.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 319 */           if (param2VmsLayer != null) {
/* 320 */             parcel1.writeInt(1);
/* 321 */             param2VmsLayer.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 324 */             parcel1.writeInt(0);
/*     */           } 
/* 326 */           this.mRemote.transact(6, parcel1, parcel2, 0);
/* 327 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 330 */           parcel2.recycle();
/* 331 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void removeVmsSubscriberPassive(IVmsSubscriberClient param2IVmsSubscriberClient) throws RemoteException {
/* 341 */         Parcel parcel2 = Parcel.obtain();
/* 342 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 344 */           parcel2.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 345 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel2.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 346 */           this.mRemote.transact(7, parcel2, parcel1, 0);
/* 347 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 350 */           parcel1.recycle();
/* 351 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void removeVmsSubscriberToPublisher(IVmsSubscriberClient param2IVmsSubscriberClient, VmsLayer param2VmsLayer, int param2Int) throws RemoteException {
/* 359 */         Parcel parcel1 = Parcel.obtain();
/* 360 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 362 */           parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 363 */           if (param2IVmsSubscriberClient != null) { IBinder iBinder = param2IVmsSubscriberClient.asBinder(); } else { param2IVmsSubscriberClient = null; }  parcel1.writeStrongBinder((IBinder)param2IVmsSubscriberClient);
/* 364 */           if (param2VmsLayer != null) {
/* 365 */             parcel1.writeInt(1);
/* 366 */             param2VmsLayer.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 369 */             parcel1.writeInt(0);
/*     */           } 
/* 371 */           parcel1.writeInt(param2Int);
/* 372 */           this.mRemote.transact(8, parcel1, parcel2, 0);
/* 373 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 376 */           parcel2.recycle();
/* 377 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public VmsAvailableLayers getAvailableLayers() throws RemoteException {
/* 385 */         Parcel parcel1 = Parcel.obtain();
/* 386 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/*     */           VmsAvailableLayers vmsAvailableLayers;
/* 389 */           parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 390 */           this.mRemote.transact(9, parcel1, parcel2, 0);
/* 391 */           parcel2.readException();
/* 392 */           if (parcel2.readInt() != 0) {
/* 393 */             vmsAvailableLayers = (VmsAvailableLayers)VmsAvailableLayers.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 396 */             vmsAvailableLayers = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 403 */           return vmsAvailableLayers;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/* 410 */       public byte[] getPublisherInfo(int param2Int) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 411 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 414 */         try { parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/* 415 */           parcel1.writeInt(param2Int);
/* 416 */           this.mRemote.transact(10, parcel1, parcel2, 0);
/* 417 */           parcel2.readException();
/* 418 */           return parcel2.createByteArray(); }
/*     */         finally
/*     */         
/* 421 */         { parcel2.recycle();
/* 422 */           parcel1.recycle(); }  } } } private static class Proxy implements IVmsSubscriberService { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.vms.IVmsSubscriberService"; } public void addVmsSubscriberToNotifications(IVmsSubscriberClient param1IVmsSubscriberClient) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("android.car.vms.IVmsSubscriberService"); if (param1IVmsSubscriberClient != null) { IBinder iBinder = param1IVmsSubscriberClient.asBinder(); } else { param1IVmsSubscriberClient = null; }  parcel2.writeStrongBinder((IBinder)param1IVmsSubscriberClient); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public void addVmsSubscriber(IVmsSubscriberClient param1IVmsSubscriberClient, VmsLayer param1VmsLayer) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService"); if (param1IVmsSubscriberClient != null) { IBinder iBinder = param1IVmsSubscriberClient.asBinder(); } else { param1IVmsSubscriberClient = null; }  parcel1.writeStrongBinder((IBinder)param1IVmsSubscriberClient); if (param1VmsLayer != null) { parcel1.writeInt(1); param1VmsLayer.writeToParcel(parcel1, 0); } else { parcel1.writeInt(0); }  this.mRemote.transact(2, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }  } public byte[] getPublisherInfo(int param1Int) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService"); parcel1.writeInt(param1Int); this.mRemote.transact(10, parcel1, parcel2, 0); parcel2.readException(); return parcel2.createByteArray(); } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void addVmsSubscriberPassive(IVmsSubscriberClient param1IVmsSubscriberClient) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         if (param1IVmsSubscriberClient != null) {
/*     */           IBinder iBinder = param1IVmsSubscriberClient.asBinder();
/*     */         } else {
/*     */           param1IVmsSubscriberClient = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IVmsSubscriberClient);
/*     */         this.mRemote.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void addVmsSubscriberToPublisher(IVmsSubscriberClient param1IVmsSubscriberClient, VmsLayer param1VmsLayer, int param1Int) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         if (param1IVmsSubscriberClient != null) {
/*     */           IBinder iBinder = param1IVmsSubscriberClient.asBinder();
/*     */         } else {
/*     */           param1IVmsSubscriberClient = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IVmsSubscriberClient);
/*     */         if (param1VmsLayer != null) {
/*     */           parcel2.writeInt(1);
/*     */           param1VmsLayer.writeToParcel(parcel2, 0);
/*     */         } else {
/*     */           parcel2.writeInt(0);
/*     */         } 
/*     */         parcel2.writeInt(param1Int);
/*     */         this.mRemote.transact(4, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void removeVmsSubscriberToNotifications(IVmsSubscriberClient param1IVmsSubscriberClient) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         if (param1IVmsSubscriberClient != null) {
/*     */           IBinder iBinder = param1IVmsSubscriberClient.asBinder();
/*     */         } else {
/*     */           param1IVmsSubscriberClient = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IVmsSubscriberClient);
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void removeVmsSubscriber(IVmsSubscriberClient param1IVmsSubscriberClient, VmsLayer param1VmsLayer) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         if (param1IVmsSubscriberClient != null) {
/*     */           IBinder iBinder = param1IVmsSubscriberClient.asBinder();
/*     */         } else {
/*     */           param1IVmsSubscriberClient = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IVmsSubscriberClient);
/*     */         if (param1VmsLayer != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1VmsLayer.writeToParcel(parcel1, 0);
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
/*     */     }
/*     */     
/*     */     public void removeVmsSubscriberPassive(IVmsSubscriberClient param1IVmsSubscriberClient) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         if (param1IVmsSubscriberClient != null) {
/*     */           IBinder iBinder = param1IVmsSubscriberClient.asBinder();
/*     */         } else {
/*     */           param1IVmsSubscriberClient = null;
/*     */         } 
/*     */         parcel2.writeStrongBinder((IBinder)param1IVmsSubscriberClient);
/*     */         this.mRemote.transact(7, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void removeVmsSubscriberToPublisher(IVmsSubscriberClient param1IVmsSubscriberClient, VmsLayer param1VmsLayer, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         if (param1IVmsSubscriberClient != null) {
/*     */           IBinder iBinder = param1IVmsSubscriberClient.asBinder();
/*     */         } else {
/*     */           param1IVmsSubscriberClient = null;
/*     */         } 
/*     */         parcel1.writeStrongBinder((IBinder)param1IVmsSubscriberClient);
/*     */         if (param1VmsLayer != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1VmsLayer.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(8, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public VmsAvailableLayers getAvailableLayers() throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         VmsAvailableLayers vmsAvailableLayers;
/*     */         parcel1.writeInterfaceToken("android.car.vms.IVmsSubscriberService");
/*     */         this.mRemote.transact(9, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         if (parcel2.readInt() != 0) {
/*     */           vmsAvailableLayers = (VmsAvailableLayers)VmsAvailableLayers.CREATOR.createFromParcel(parcel2);
/*     */         } else {
/*     */           vmsAvailableLayers = null;
/*     */         } 
/*     */         return vmsAvailableLayers;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\vms\IVmsSubscriberService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */