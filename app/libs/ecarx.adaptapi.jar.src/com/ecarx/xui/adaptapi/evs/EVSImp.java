/*     */ package com.ecarx.xui.adaptapi.evs;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.os.ServiceManager;
/*     */ import android.os.SystemProperties;
/*     */ import android.util.Log;
/*     */ import com.android.evs.IEvsCameraService;
/*     */ import com.android.evs.IEvsCameraServiceCallback;
/*     */ import java.util.Iterator;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EVSImp
/*     */   extends EVS
/*     */ {
/*     */   private static final String TAG = "EVS adaptAPI";
/*     */   private IEvsCameraServiceCallback callback;
/*     */   private Context mContext;
/*     */   private EvsCamera mEvsCamera;
/*     */   private final CopyOnWriteArrayList<EVS.IEvsCameraStatusObserver> mEvsCameraStatusObservers;
/*     */   IEvsCameraService mIECS;
/*     */   
/*     */   public static EVS create(Context paramContext) {
/*  43 */     return new EVSImp(paramContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EVSImp(Context paramContext) {
/* 183 */     this.callback = (IEvsCameraServiceCallback)new IEvsCameraServiceCallback.Stub()
/*     */       {
/*     */         public void updateAVMState(int param1Int) {
/* 186 */           Log.d("EVS adaptAPI", "Remote EVS server call updateAVMState was called by binder");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 199 */           Intent intent = new Intent("com.tencent.mm.action.vehicle.AVM");
/*     */           
/* 201 */           Iterator<EVS.IEvsCameraStatusObserver> iterator = EVSImp.this.mEvsCameraStatusObservers.iterator();
/* 202 */           while (iterator.hasNext()) {
/* 203 */             EVS.IEvsCameraStatusObserver iEvsCameraStatusObserver = iterator.next();
/* 204 */             switch (param1Int) {
/*     */               default:
/*     */                 continue;
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               case 1:
/* 212 */                 Log.d("EVS adaptAPI", "Note APP camera opened, and sendBroadcast 0");
/* 213 */                 intent.putExtra("avm_state", 0);
/* 214 */                 EVSImp.this.mContext.sendBroadcast(intent);
/* 215 */                 iEvsCameraStatusObserver.onEvsCameraOpened(1);
/*     */                 continue;
/*     */               case 0:
/*     */                 break;
/*     */             } 
/*     */             Log.d("EVS adaptAPI", "Note APP camera closed, and sendBroadcast 1");
/*     */             intent.putExtra("avm_state", 1);
/*     */             EVSImp.this.mContext.sendBroadcast(intent);
/*     */             iEvsCameraStatusObserver.onEvsCameraClosed(1);
/*     */           } 
/*     */         }
/*     */         
/*     */         final EVSImp this$0;
/*     */       };
/*     */     this.mContext = paramContext;
/*     */     this.mEvsCameraStatusObservers = new CopyOnWriteArrayList<>();
/*     */     this.mEvsCamera = new EvsCamera(paramContext);
/*     */     IBinder iBinder = ServiceManager.getService("EvsCameraService");
/*     */     if (iBinder == null) {
/*     */       Log.d("EVS adaptAPI", "Get EVS server binder is null");
/*     */     } else {
/*     */       Log.d("EVS adaptAPI", "Get EVS server binder is ok");
/*     */     } 
/*     */     this.mIECS = IEvsCameraService.Stub.asInterface(iBinder);
/*     */     if (this.mIECS != null)
/*     */       try {
/*     */         Log.d("EVS adaptAPI", "By binder call EVS server registerEvsCameraServiceCallback");
/*     */         this.mIECS.registerEvsCameraServiceCallback(this.callback);
/*     */       } catch (RemoteException remoteException) {
/*     */         remoteException.printStackTrace();
/*     */       }  
/*     */   }
/*     */   
/*     */   public IEvsCamera getEvsCamera() {
/*     */     return this.mEvsCamera;
/*     */   }
/*     */   
/*     */   public boolean attachEvsCameraStatusObserver(EVS.IEvsCameraStatusObserver paramIEvsCameraStatusObserver) {
/*     */     Log.d("EVS adaptAPI", "attachEvsCameraStatusObserver func was called");
/*     */     if (!this.mEvsCameraStatusObservers.contains(paramIEvsCameraStatusObserver)) {
/*     */       Log.d("EVS adaptAPI", "Add observer");
/*     */       this.mEvsCameraStatusObservers.add(paramIEvsCameraStatusObserver);
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean detachEvsCameraStatusObserver(EVS.IEvsCameraStatusObserver paramIEvsCameraStatusObserver) {
/*     */     Log.d("EVS adaptAPI", "detachEvsCameraStatusObserver func was called");
/*     */     this.mEvsCameraStatusObservers.remove(paramIEvsCameraStatusObserver);
/*     */     return true;
/*     */   }
/*     */   
/*     */   public boolean isCameraOpened(int paramInt) {
/*     */     String str;
/*     */     boolean bool1 = false, bool2 = false;
/*     */     switch (paramInt) {
/*     */       case 2:
/*     */         str = SystemProperties.get("vendor.sys.pason", "");
/*     */         switch (Integer.parseInt(str)) {
/*     */           default:
/*     */             bool1 = bool2;
/*     */             break;
/*     */           case 1:
/*     */             bool1 = true;
/*     */             break;
/*     */           case 0:
/*     */             break;
/*     */         } 
/*     */         bool1 = false;
/*     */         break;
/*     */     } 
/*     */     return bool1;
/*     */   }
/*     */   
/*     */   public boolean evsCameraCloseNotify(int paramInt) {
/*     */     String str;
/*     */     boolean bool1 = false, bool2 = false;
/*     */     switch (paramInt) {
/*     */       case 2:
/*     */         str = SystemProperties.get("vendor.sys.pason", "");
/*     */         switch (Integer.parseInt(str)) {
/*     */           default:
/*     */             bool1 = bool2;
/*     */             break;
/*     */           case 1:
/*     */             bool1 = true;
/*     */             break;
/*     */           case 0:
/*     */             break;
/*     */         } 
/*     */         bool1 = false;
/*     */         break;
/*     */     } 
/*     */     return bool1;
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\evs\EVSImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */