/*     */ package android.car.settings;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public interface ICarConfigurationManager
/*     */   extends IInterface {
/*     */   SpeedBumpConfiguration getSpeedBumpConfiguration() throws RemoteException;
/*     */   
/*     */   public static abstract class Stub
/*     */     extends Binder
/*     */     implements ICarConfigurationManager {
/*     */     private static final String DESCRIPTOR = "android.car.settings.ICarConfigurationManager";
/*     */     static final int TRANSACTION_getSpeedBumpConfiguration = 1;
/*     */     
/*     */     public Stub() {
/*  20 */       attachInterface(this, "android.car.settings.ICarConfigurationManager");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ICarConfigurationManager asInterface(IBinder param1IBinder) {
/*  28 */       if (param1IBinder == null) {
/*  29 */         return null;
/*     */       }
/*  31 */       IInterface iInterface = param1IBinder.queryLocalInterface("android.car.settings.ICarConfigurationManager");
/*  32 */       if (iInterface != null && iInterface instanceof ICarConfigurationManager) {
/*  33 */         return (ICarConfigurationManager)iInterface;
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
/*  67 */           return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2); }  param1Parcel2.writeString("android.car.settings.ICarConfigurationManager"); return true; }
/*     */        param1Parcel1.enforceInterface("android.car.settings.ICarConfigurationManager"); SpeedBumpConfiguration speedBumpConfiguration = getSpeedBumpConfiguration();
/*     */       param1Parcel2.writeNoException();
/*     */       if (speedBumpConfiguration != null) {
/*     */         param1Parcel2.writeInt(1);
/*     */         speedBumpConfiguration.writeToParcel(param1Parcel2, 1);
/*     */       } else {
/*     */         param1Parcel2.writeInt(0);
/*     */       } 
/*  76 */       return true; } private static class Proxy implements ICarConfigurationManager { private IBinder mRemote; Proxy(IBinder param2IBinder) { this.mRemote = param2IBinder; }
/*     */ 
/*     */       
/*     */       public IBinder asBinder() {
/*  80 */         return this.mRemote;
/*     */       }
/*     */       
/*     */       public String getInterfaceDescriptor() {
/*  84 */         return "android.car.settings.ICarConfigurationManager";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public SpeedBumpConfiguration getSpeedBumpConfiguration() throws RemoteException
/*     */       {
/*  92 */         Parcel parcel1 = Parcel.obtain();
/*  93 */         Parcel parcel2 = Parcel.obtain();
/*     */         
/*     */         try { SpeedBumpConfiguration speedBumpConfiguration;
/*  96 */           parcel1.writeInterfaceToken("android.car.settings.ICarConfigurationManager");
/*  97 */           this.mRemote.transact(1, parcel1, parcel2, 0);
/*  98 */           parcel2.readException();
/*  99 */           if (parcel2.readInt() != 0) {
/* 100 */             speedBumpConfiguration = (SpeedBumpConfiguration)SpeedBumpConfiguration.CREATOR.createFromParcel(parcel2);
/*     */           } else {
/*     */             
/* 103 */             speedBumpConfiguration = null;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 110 */           return speedBumpConfiguration; } finally { parcel2.recycle(); parcel1.recycle(); }  } } } private static class Proxy implements ICarConfigurationManager { public SpeedBumpConfiguration getSpeedBumpConfiguration() throws RemoteException { Parcel parcel1 = Parcel.obtain(); Parcel parcel2 = Parcel.obtain(); try { SpeedBumpConfiguration speedBumpConfiguration; parcel1.writeInterfaceToken("android.car.settings.ICarConfigurationManager"); this.mRemote.transact(1, parcel1, parcel2, 0); parcel2.readException(); if (parcel2.readInt() != 0) { speedBumpConfiguration = (SpeedBumpConfiguration)SpeedBumpConfiguration.CREATOR.createFromParcel(parcel2); } else { speedBumpConfiguration = null; }  return speedBumpConfiguration; }
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
/*     */       return "android.car.settings.ICarConfigurationManager";
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\settings\ICarConfigurationManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */