/*     */ package android.car;
/*     */ 
/*     */ import android.hardware.usb.UsbDevice;
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface IUsbAoapSupportCheckService
/*     */   extends IInterface {
/*     */   boolean isDeviceSupported(UsbDevice paramUsbDevice) throws RemoteException;
/*     */   
/*     */   public static abstract class Stub
/*     */     extends Binder implements IUsbAoapSupportCheckService {
/*     */     private static final String DESCRIPTOR = "android.car.IUsbAoapSupportCheckService";
/*     */     static final int TRANSACTION_isDeviceSupported = 1;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.IUsbAoapSupportCheckService");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static IUsbAoapSupportCheckService asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.IUsbAoapSupportCheckService");
/*  32 */       if (iInterface != null && iInterface instanceof IUsbAoapSupportCheckService) {
/*  33 */         return (IUsbAoapSupportCheckService)iInterface;
/*     */       }
/*  35 */       return new Proxy(param1IBinder);
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*  39 */       return (IBinder)this;
/*     */     }
/*     */     
/*     */     public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException
/*     */     {
/*  44 */       if (param1Int1 != 1) { if (param1Int1 != 1598968902)
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
/*  68 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.IUsbAoapSupportCheckService"); return true; }
/*     */        param1Parcel1.enforceInterface("android.car.IUsbAoapSupportCheckService"); if (param1Parcel1.readInt() != 0) {
/*     */         UsbDevice usbDevice = (UsbDevice)UsbDevice.CREATOR.createFromParcel(param1Parcel1);
/*     */       } else {
/*     */         param1Parcel1 = null;
/*     */       } 
/*     */       boolean bool = isDeviceSupported((UsbDevice)param1Parcel1);
/*     */       param1Parcel2.writeNoException();
/*     */       param1Parcel2.writeInt(bool);
/*  77 */       return true; } private static class Proxy implements IUsbAoapSupportCheckService { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  81 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  85 */         return "android.car.IUsbAoapSupportCheckService";
/*     */       }
/*     */       
/*     */       public boolean isDeviceSupported(UsbDevice param2UsbDevice) throws RemoteException {
/*  89 */         Parcel parcel1 = Parcel.obtain();
/*  90 */         Parcel parcel2 = Parcel.obtain();
/*     */ 
/*     */         
/*  93 */         try { parcel1.writeInterfaceToken("android.car.IUsbAoapSupportCheckService");
/*  94 */           boolean bool = true; if (param2UsbDevice != null) {
/*  95 */             parcel1.writeInt(1);
/*  96 */             param2UsbDevice.writeToParcel(parcel1, 0);
/*     */           } else {
/*     */             
/*  99 */             parcel1.writeInt(0);
/*     */           } 
/* 101 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/* 102 */           parcel2.readException();
/* 103 */           int i = parcel2.readInt(); if (i == 0) bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 109 */           return bool; } finally { parcel2.recycle(); parcel1.recycle(); }  } } } private static class Proxy implements IUsbAoapSupportCheckService { public boolean isDeviceSupported(UsbDevice param1UsbDevice) throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { parcel1.writeInterfaceToken("android.car.IUsbAoapSupportCheckService"); boolean bool = true; if (param1UsbDevice != null) { parcel1.writeInt(1); param1UsbDevice.writeToParcel(parcel1, 0); } else { parcel1.writeInt(0); }  this.mRemote.transact(1, parcel1, parcel2, 0); parcel2.readException(); int i = parcel2.readInt(); if (i == 0) bool = false;  return bool; }
/*     */       finally
/*     */       { parcel2.recycle();
/*     */         parcel1.recycle(); }
/*     */        }
/*     */ 
/*     */     
/*     */     private IBinder mRemote;
/*     */     
/*     */     Proxy(IBinder param1IBinder) {
/*     */       this.mRemote = param1IBinder;
/*     */     }
/*     */     
/*     */     public IBinder asBinder() {
/*     */       return this.mRemote;
/*     */     }
/*     */     
/*     */     public String getInterfaceDescriptor() {
/*     */       return "android.car.IUsbAoapSupportCheckService";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\IUsbAoapSupportCheckService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */