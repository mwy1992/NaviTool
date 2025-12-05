/*     */ package ecarx.car;public interface IXmaDvrHttpService extends IInterface { String deleteDvrFiles(String paramString) throws RemoteException;
/*     */   boolean enterFileBrowse() throws RemoteException;
/*     */   boolean exitBrowseMode() throws RemoteException;
/*     */   String getAllDvrFiles() throws RemoteException;
/*     */   String moveFiles2EmergencyPartition(String paramString) throws RemoteException;
/*     */   String refreshFileList() throws RemoteException;
/*     */   String refreshFileListNum(int paramInt) throws RemoteException;
/*     */   void setTestTag(boolean paramBoolean) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements IXmaDvrHttpService { private static final String DESCRIPTOR = "ecarx.car.IXmaDvrHttpService"; static final int TRANSACTION_deleteDvrFiles = 5; static final int TRANSACTION_enterFileBrowse = 2; static final int TRANSACTION_exitBrowseMode = 7; static final int TRANSACTION_getAllDvrFiles = 3; static final int TRANSACTION_moveFiles2EmergencyPartition = 6;
/*     */     static final int TRANSACTION_refreshFileList = 4;
/*     */     static final int TRANSACTION_refreshFileListNum = 8;
/*     */     static final int TRANSACTION_setTestTag = 1;
/*     */     
/*     */     public Stub() {
/*  15 */       attachInterface(this, "ecarx.car.IXmaDvrHttpService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IXmaDvrHttpService asInterface(IBinder param1IBinder) {
/*  23 */       if (param1IBinder == null) {
/*  24 */         return null;
/*     */       }
/*  26 */       IInterface iInterface = param1IBinder.queryLocalInterface("ecarx.car.IXmaDvrHttpService");
/*  27 */       if (iInterface != null && iInterface instanceof IXmaDvrHttpService) {
/*  28 */         return (IXmaDvrHttpService)iInterface;
/*     */       }
/*  30 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  34 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  39 */       if (param1Int1 != 1598968902) { boolean bool; String str; boolean bool1; switch (param1Int1)
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
/*     */           default:
/* 119 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 8: param1Parcel1.enforceInterface("ecarx.car.IXmaDvrHttpService"); param1Int1 = param1Parcel1.readInt(); str = refreshFileListNum(param1Int1); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 7: str.enforceInterface("ecarx.car.IXmaDvrHttpService"); bool = exitBrowseMode(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 6: str.enforceInterface("ecarx.car.IXmaDvrHttpService"); str = str.readString(); str = moveFiles2EmergencyPartition(str); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 5: str.enforceInterface("ecarx.car.IXmaDvrHttpService"); str = str.readString(); str = deleteDvrFiles(str); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 4: str.enforceInterface("ecarx.car.IXmaDvrHttpService"); str = refreshFileList(); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 3: str.enforceInterface("ecarx.car.IXmaDvrHttpService"); str = getAllDvrFiles(); param1Parcel2.writeNoException(); param1Parcel2.writeString(str); return true;
/*     */           case 2: str.enforceInterface("ecarx.car.IXmaDvrHttpService"); bool = enterFileBrowse(); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 1:
/* 128 */             break; }  str.enforceInterface("ecarx.car.IXmaDvrHttpService"); if (str.readInt() != 0) { bool1 = true; } else { bool1 = false; }  setTestTag(bool1); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("ecarx.car.IXmaDvrHttpService"); return true; } private static class Proxy implements IXmaDvrHttpService { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 132 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 136 */         return "ecarx.car.IXmaDvrHttpService";
/*     */       }
/*     */       
/*     */       public void setTestTag(boolean param2Boolean) throws RemoteException {
/* 140 */         Parcel parcel2 = Parcel.obtain();
/* 141 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 143 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 144 */           parcel2.writeInt(param2Boolean);
/* 145 */           this.mRemote.transact(1, parcel2, parcel1, 0);
/* 146 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 149 */           parcel1.recycle();
/* 150 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean enterFileBrowse() throws RemoteException {
/* 155 */         Parcel parcel2 = Parcel.obtain();
/* 156 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 159 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 160 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel2, parcel1, 0);
/* 161 */           parcel1.readException();
/* 162 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 168 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 172 */         }  } public String getAllDvrFiles() throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 173 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 176 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 177 */           this.mRemote.transact(3, parcel2, parcel1, 0);
/* 178 */           parcel1.readException();
/* 179 */           return parcel1.readString();
/*     */         } finally {
/*     */           
/* 182 */           parcel1.recycle();
/* 183 */           parcel2.recycle();
/*     */         }  }
/*     */ 
/*     */ 
/*     */       
/*     */       public String refreshFileList() throws RemoteException {
/* 189 */         Parcel parcel2 = Parcel.obtain();
/* 190 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 193 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 194 */           this.mRemote.transact(4, parcel2, parcel1, 0);
/* 195 */           parcel1.readException();
/* 196 */           return parcel1.readString();
/*     */         } finally {
/*     */           
/* 199 */           parcel1.recycle();
/* 200 */           parcel2.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public String deleteDvrFiles(String param2String) throws RemoteException
/*     */       {
/* 206 */         Parcel parcel1 = Parcel.obtain();
/* 207 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 210 */           parcel1.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 211 */           parcel1.writeString(param2String);
/* 212 */           this.mRemote.transact(5, parcel1, parcel2, 0);
/* 213 */           parcel2.readException();
/* 214 */           param2String = parcel2.readString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 220 */           return param2String;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 224 */         }  } public String moveFiles2EmergencyPartition(String param2String) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 225 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 228 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 229 */           parcel2.writeString(param2String);
/* 230 */           this.mRemote.transact(6, parcel2, parcel1, 0);
/* 231 */           parcel1.readException();
/* 232 */           param2String = parcel1.readString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 238 */           return param2String;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 242 */         }  } public boolean exitBrowseMode() throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 243 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 246 */           parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 247 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(7, parcel2, parcel1, 0);
/* 248 */           parcel1.readException();
/* 249 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 255 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 259 */         }  } public String refreshFileListNum(int param2Int) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 260 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/* 263 */         try { parcel1.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/* 264 */           parcel1.writeInt(param2Int);
/* 265 */           this.mRemote.transact(8, parcel1, parcel2, 0);
/* 266 */           parcel2.readException();
/* 267 */           return parcel2.readString(); }
/*     */         finally
/*     */         
/* 270 */         { parcel2.recycle();
/* 271 */           parcel1.recycle(); }  } } } private static class Proxy implements IXmaDvrHttpService { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "ecarx.car.IXmaDvrHttpService"; } public void setTestTag(boolean param1Boolean) throws RemoteException { Parcel parcel2 = Parcel.obtain(); Parcel parcel1 = Parcel.obtain(); try { parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService"); parcel2.writeInt(param1Boolean); this.mRemote.transact(1, parcel2, parcel1, 0); parcel1.readException(); return; } finally { parcel1.recycle(); parcel2.recycle(); }  } public String refreshFileListNum(int param1Int) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("ecarx.car.IXmaDvrHttpService"); parcel1.writeInt(param1Int); this.mRemote.transact(8, parcel1, parcel2, 0); parcel2.readException(); return parcel2.readString(); } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public boolean enterFileBrowse() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(2, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         int i = parcel1.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String getAllDvrFiles() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/*     */         this.mRemote.transact(3, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.readString();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String refreshFileList() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/*     */         this.mRemote.transact(4, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return parcel1.readString();
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String deleteDvrFiles(String param1String) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/*     */         parcel1.writeString(param1String);
/*     */         this.mRemote.transact(5, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         param1String = parcel2.readString();
/*     */         return param1String;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String moveFiles2EmergencyPartition(String param1String) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/*     */         parcel2.writeString(param1String);
/*     */         this.mRemote.transact(6, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         param1String = parcel1.readString();
/*     */         return param1String;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean exitBrowseMode() throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("ecarx.car.IXmaDvrHttpService");
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(7, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         int i = parcel1.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\IXmaDvrHttpService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */