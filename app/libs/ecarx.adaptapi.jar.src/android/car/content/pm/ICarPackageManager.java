/*     */ package android.car.content.pm;public interface ICarPackageManager extends IInterface { boolean isActivityBackedBySafeActivity(ComponentName paramComponentName) throws RemoteException;
/*     */   boolean isActivityDistractionOptimized(String paramString1, String paramString2) throws RemoteException;
/*     */   boolean isServiceDistractionOptimized(String paramString1, String paramString2) throws RemoteException;
/*     */   void restartTask(int paramInt) throws RemoteException;
/*     */   void setAppBlockingPolicy(String paramString, CarAppBlockingPolicy paramCarAppBlockingPolicy, int paramInt) throws RemoteException;
/*     */   void setEnableActivityBlocking(boolean paramBoolean) throws RemoteException;
/*     */   public static abstract class Stub extends Binder implements ICarPackageManager { private static final String DESCRIPTOR = "android.car.content.pm.ICarPackageManager";
/*     */     static final int TRANSACTION_isActivityBackedBySafeActivity = 4;
/*     */     static final int TRANSACTION_isActivityDistractionOptimized = 2;
/*     */     static final int TRANSACTION_isServiceDistractionOptimized = 3;
/*     */     static final int TRANSACTION_restartTask = 6;
/*     */     static final int TRANSACTION_setAppBlockingPolicy = 1;
/*     */     static final int TRANSACTION_setEnableActivityBlocking = 5;
/*     */     
/*     */     public Stub() {
/*  16 */       attachInterface(this, "android.car.content.pm.ICarPackageManager");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarPackageManager asInterface(IBinder param1IBinder) {
/*  24 */       if (param1IBinder == null) {
/*  25 */         return null;
/*     */       }
/*  27 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.content.pm.ICarPackageManager");
/*  28 */       if (iInterface != null && iInterface instanceof ICarPackageManager) {
/*  29 */         return (ICarPackageManager)iInterface;
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
/*  40 */       if (param1Int1 != 1598968902) { boolean bool; String str1; boolean bool1; CarAppBlockingPolicy carAppBlockingPolicy; String str2 = null; Parcel parcel = null; switch (param1Int1)
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
/*     */           default:
/* 124 */             return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
/*     */           case 6: param1Parcel1.enforceInterface("android.car.content.pm.ICarPackageManager"); param1Int1 = param1Parcel1.readInt(); restartTask(param1Int1); param1Parcel2.writeNoException(); return true;
/*     */           case 5: param1Parcel1.enforceInterface("android.car.content.pm.ICarPackageManager"); if (param1Parcel1.readInt() != 0) { bool1 = true; } else { bool1 = false; }  setEnableActivityBlocking(bool1); param1Parcel2.writeNoException(); return true;
/*     */           case 4: param1Parcel1.enforceInterface("android.car.content.pm.ICarPackageManager"); if (param1Parcel1.readInt() != 0) { ComponentName componentName = (ComponentName)ComponentName.CREATOR.createFromParcel(param1Parcel1); } else { param1Parcel1 = parcel; }  bool = isActivityBackedBySafeActivity((ComponentName)param1Parcel1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 3: param1Parcel1.enforceInterface("android.car.content.pm.ICarPackageManager"); str2 = param1Parcel1.readString(); str1 = param1Parcel1.readString(); bool = isServiceDistractionOptimized(str2, str1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 2:
/*     */             str1.enforceInterface("android.car.content.pm.ICarPackageManager"); str2 = str1.readString(); str1 = str1.readString(); bool = isActivityDistractionOptimized(str2, str1); param1Parcel2.writeNoException(); param1Parcel2.writeInt(bool); return true;
/*     */           case 1:
/*     */             break; }  str1.enforceInterface("android.car.content.pm.ICarPackageManager"); String str3 = str1.readString(); if (str1.readInt() != 0)
/* 133 */           carAppBlockingPolicy = (CarAppBlockingPolicy)CarAppBlockingPolicy.CREATOR.createFromParcel((Parcel)str1);  int i = str1.readInt(); setAppBlockingPolicy(str3, carAppBlockingPolicy, i); param1Parcel2.writeNoException(); return true; }  param1Parcel2.writeString("android.car.content.pm.ICarPackageManager"); return true; } private static class Proxy implements ICarPackageManager { Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */       
/*     */       private IBinder mRemote;
/*     */       public IBinder asBinder() {
/* 137 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/* 141 */         return "android.car.content.pm.ICarPackageManager";
/*     */       }
/*     */       
/*     */       public void setAppBlockingPolicy(String param2String, CarAppBlockingPolicy param2CarAppBlockingPolicy, int param2Int) throws RemoteException {
/* 145 */         Parcel parcel1 = Parcel.obtain();
/* 146 */         Parcel parcel2 = Parcel.obtain();
/*     */         try {
/* 148 */           parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/* 149 */           parcel1.writeString(param2String);
/* 150 */           if (param2CarAppBlockingPolicy != null) {
/* 151 */             parcel1.writeInt(1);
/* 152 */             param2CarAppBlockingPolicy.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 155 */             parcel1.writeInt(0);
/*     */           } 
/* 157 */           parcel1.writeInt(param2Int);
/* 158 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 159 */           parcel2.readException();
/*     */           return;
/*     */         } finally {
/* 162 */           parcel2.recycle();
/* 163 */           parcel1.recycle();
/*     */         } 
/*     */       }
/*     */       
/*     */       public boolean isActivityDistractionOptimized(String param2String1, String param2String2) throws RemoteException {
/* 168 */         Parcel parcel2 = Parcel.obtain();
/* 169 */         Parcel parcel1 = Parcel.obtain();
/*     */         
/*     */         try {
/* 172 */           parcel2.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/* 173 */           parcel2.writeString(param2String1);
/* 174 */           parcel2.writeString(param2String2);
/* 175 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(2, parcel2, parcel1, 0);
/* 176 */           parcel1.readException();
/* 177 */           int i = parcel1.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 183 */           return bool;
/*     */         } finally {
/*     */           parcel1.recycle();
/*     */           parcel2.recycle();
/* 187 */         }  } public boolean isServiceDistractionOptimized(String param2String1, String param2String2) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 188 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 191 */           parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/* 192 */           parcel1.writeString(param2String1);
/* 193 */           parcel1.writeString(param2String2);
/* 194 */           IBinder iBinder = this.mRemote; boolean bool = false; iBinder.transact(3, parcel1, parcel2, 0);
/* 195 */           parcel2.readException();
/* 196 */           int i = parcel2.readInt(); if (i != 0) bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 202 */           return bool;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 206 */         }  } public boolean isActivityBackedBySafeActivity(ComponentName param2ComponentName) throws RemoteException { Parcel parcel1 = Parcel.obtain();
/* 207 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try {
/* 210 */           parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/* 211 */           boolean bool = true; if (param2ComponentName != null) {
/* 212 */             parcel1.writeInt(1);
/* 213 */             param2ComponentName.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/* 216 */             parcel1.writeInt(0);
/*     */           } 
/* 218 */           this.mRemote.transact(4, parcel1, parcel2, 0);
/* 219 */           parcel2.readException();
/* 220 */           int i = parcel2.readInt(); if (i == 0) bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 226 */           return bool;
/*     */         } finally {
/*     */           parcel2.recycle();
/*     */           parcel1.recycle();
/* 230 */         }  } public void setEnableActivityBlocking(boolean param2Boolean) throws RemoteException { Parcel parcel2 = Parcel.obtain();
/* 231 */         Parcel parcel1 = Parcel.obtain();
/*     */         try {
/* 233 */           parcel2.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/* 234 */           parcel2.writeInt(param2Boolean);
/* 235 */           this.mRemote.transact(5, parcel2, parcel1, 0);
/* 236 */           parcel1.readException();
/*     */           return;
/*     */         } finally {
/* 239 */           parcel1.recycle();
/* 240 */           parcel2.recycle();
/*     */         }  }
/*     */ 
/*     */       
/*     */       public void restartTask(int param2Int) throws RemoteException {
/* 245 */         Parcel parcel1 = Parcel.obtain();
/* 246 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/* 248 */         try { parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/* 249 */           parcel1.writeInt(param2Int);
/* 250 */           this.mRemote.transact(6, parcel1, parcel2, 0);
/* 251 */           parcel2.readException();
/*     */           return; }
/*     */         finally
/* 254 */         { parcel2.recycle();
/* 255 */           parcel1.recycle(); }  } } } private static class Proxy implements ICarPackageManager { private IBinder mRemote; Proxy(IBinder param1IBinder) { this.mRemote = param1IBinder; } public IBinder asBinder() { return this.mRemote; } public String getInterfaceDescriptor() { return "android.car.content.pm.ICarPackageManager"; } public void restartTask(int param1Int) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager"); parcel1.writeInt(param1Int); this.mRemote.transact(6, parcel1, parcel2, 0); parcel2.readException(); return; } finally { parcel2.recycle(); parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     public void setAppBlockingPolicy(String param1String, CarAppBlockingPolicy param1CarAppBlockingPolicy, int param1Int) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/*     */         parcel1.writeString(param1String);
/*     */         if (param1CarAppBlockingPolicy != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1CarAppBlockingPolicy.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         parcel1.writeInt(param1Int);
/*     */         this.mRemote.transact(1, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isActivityDistractionOptimized(String param1String1, String param1String2) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/*     */         parcel2.writeString(param1String1);
/*     */         parcel2.writeString(param1String2);
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
/*     */     public boolean isServiceDistractionOptimized(String param1String1, String param1String2) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/*     */         parcel1.writeString(param1String1);
/*     */         parcel1.writeString(param1String2);
/*     */         IBinder iBinder = this.mRemote;
/*     */         boolean bool = false;
/*     */         iBinder.transact(3, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         int i = parcel2.readInt();
/*     */         if (i != 0)
/*     */           bool = true; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isActivityBackedBySafeActivity(ComponentName param1ComponentName) throws RemoteException {
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       try {
/*     */         parcel1.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/*     */         boolean bool = true;
/*     */         if (param1ComponentName != null) {
/*     */           parcel1.writeInt(1);
/*     */           param1ComponentName.writeToParcel(parcel1, 0);
/*     */         } else {
/*     */           parcel1.writeInt(0);
/*     */         } 
/*     */         this.mRemote.transact(4, parcel1, parcel2, 0);
/*     */         parcel2.readException();
/*     */         int i = parcel2.readInt();
/*     */         if (i == 0)
/*     */           bool = false; 
/*     */         return bool;
/*     */       } finally {
/*     */         parcel2.recycle();
/*     */         parcel1.recycle();
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setEnableActivityBlocking(boolean param1Boolean) throws RemoteException {
/*     */       Parcel parcel2 = Parcel.obtain();
/*     */       Parcel parcel1 = Parcel.obtain();
/*     */       try {
/*     */         parcel2.writeInterfaceToken("android.car.content.pm.ICarPackageManager");
/*     */         parcel2.writeInt(param1Boolean);
/*     */         this.mRemote.transact(5, parcel2, parcel1, 0);
/*     */         parcel1.readException();
/*     */         return;
/*     */       } finally {
/*     */         parcel1.recycle();
/*     */         parcel2.recycle();
/*     */       } 
/*     */     } }
/*     */    }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\content\pm\ICarPackageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */