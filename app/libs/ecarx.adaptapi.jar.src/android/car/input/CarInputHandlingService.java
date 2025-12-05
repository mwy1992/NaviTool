/*     */ package android.car.input;
/*     */ 
/*     */ import android.annotation.SystemApi;
/*     */ import android.app.Service;
/*     */ import android.content.Intent;
/*     */ import android.os.Bundle;
/*     */ import android.os.Handler;
/*     */ import android.os.IBinder;
/*     */ import android.os.Message;
/*     */ import android.os.Parcel;
/*     */ import android.os.Parcelable;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import android.view.KeyEvent;
/*     */ import java.io.FileDescriptor;
/*     */ import java.io.PrintWriter;
/*     */ import java.lang.ref.WeakReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SystemApi
/*     */ public abstract class CarInputHandlingService
/*     */   extends Service
/*     */ {
/*     */   private static final boolean DBG = false;
/*     */   public static final int INPUT_CALLBACK_BINDER_CODE = 1;
/*     */   public static final String INPUT_CALLBACK_BINDER_KEY = "callback_binder";
/*     */   private static final String TAG = "CAR.L.INPUT";
/*     */   private final InputFilter[] mHandledKeys;
/*     */   private InputBinder mInputBinder;
/*     */   
/*     */   protected CarInputHandlingService(InputFilter[] paramArrayOfInputFilter) {
/*  65 */     if (paramArrayOfInputFilter != null) {
/*     */ 
/*     */ 
/*     */       
/*  69 */       this.mHandledKeys = new InputFilter[paramArrayOfInputFilter.length];
/*  70 */       System.arraycopy(paramArrayOfInputFilter, 0, this.mHandledKeys, 0, paramArrayOfInputFilter.length);
/*     */       return;
/*     */     } 
/*     */     throw new IllegalArgumentException("handledKeys is null");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IBinder onBind(Intent paramIntent) {
/*  80 */     doCallbackIfPossible(paramIntent.getExtras());
/*     */     
/*  82 */     if (this.mInputBinder == null) {
/*  83 */       this.mInputBinder = new InputBinder();
/*     */     }
/*     */     
/*  86 */     return (IBinder)this.mInputBinder;
/*     */   }
/*     */   
/*     */   private void doCallbackIfPossible(Bundle paramBundle) {
/*  90 */     if (paramBundle == null) {
/*  91 */       Log.i("CAR.L.INPUT", "doCallbackIfPossible: extras are null");
/*     */       return;
/*     */     } 
/*  94 */     IBinder iBinder = paramBundle.getBinder("callback_binder");
/*  95 */     if (iBinder == null) {
/*  96 */       Log.i("CAR.L.INPUT", "doCallbackIfPossible: callback IBinder is null");
/*     */       return;
/*     */     } 
/*  99 */     Parcel parcel = Parcel.obtain();
/* 100 */     parcel.writeTypedArray((Parcelable[])this.mHandledKeys, 0);
/*     */     try {
/* 102 */       iBinder.transact(1, parcel, null, 1);
/* 103 */     } catch (RemoteException remoteException) {
/* 104 */       Log.e("CAR.L.INPUT", "doCallbackIfPossible: callback failed", (Throwable)remoteException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
/* 116 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("**"); stringBuilder.append(getClass().getSimpleName()); stringBuilder.append("**"); paramPrintWriter.println(stringBuilder.toString());
/* 117 */     stringBuilder = new StringBuilder(); stringBuilder.append("input binder: "); stringBuilder.append(this.mInputBinder); paramPrintWriter.println(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   protected abstract void onKeyEvent(KeyEvent paramKeyEvent, int paramInt);
/*     */   
/*     */   private class InputBinder
/*     */     extends ICarInputListener.Stub {
/* 124 */     private final CarInputHandlingService.EventHandler mEventHandler = new CarInputHandlingService.EventHandler(CarInputHandlingService.this);
/*     */     
/*     */     final CarInputHandlingService this$0;
/*     */     
/*     */     public void onKeyEvent(KeyEvent param1KeyEvent, int param1Int) throws RemoteException {
/* 129 */       this.mEventHandler.doKeyEvent(param1KeyEvent, param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class EventHandler extends Handler {
/*     */     private static final int KEY_EVENT = 0;
/*     */     private final WeakReference<CarInputHandlingService> mRefService;
/*     */     
/*     */     EventHandler(CarInputHandlingService param1CarInputHandlingService) {
/* 138 */       this.mRefService = new WeakReference<>(param1CarInputHandlingService);
/*     */     }
/*     */ 
/*     */     
/*     */     public void handleMessage(Message param1Message) {
/* 143 */       CarInputHandlingService carInputHandlingService = this.mRefService.get();
/* 144 */       if (carInputHandlingService == null) {
/*     */         return;
/*     */       }
/*     */       
/* 148 */       if (param1Message.what == 0) {
/* 149 */         carInputHandlingService.onKeyEvent((KeyEvent)param1Message.obj, param1Message.arg1); return;
/*     */       } 
/* 151 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Unexpected message: "); stringBuilder.append(param1Message); throw new IllegalArgumentException(stringBuilder.toString());
/*     */     }
/*     */ 
/*     */     
/*     */     void doKeyEvent(KeyEvent param1KeyEvent, int param1Int) {
/* 156 */       sendMessage(obtainMessage(0, param1Int, 0, param1KeyEvent));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class InputFilter
/*     */     implements Parcelable
/*     */   {
/*     */     public InputFilter(int param1Int1, int param1Int2) {
/* 168 */       this.mKeyCode = param1Int1;
/* 169 */       this.mTargetDisplay = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     InputFilter(Parcel param1Parcel) {
/* 174 */       this.mKeyCode = param1Parcel.readInt();
/* 175 */       this.mTargetDisplay = param1Parcel.readInt();
/*     */     }
/*     */ 
/*     */     
/*     */     public int describeContents() {
/* 180 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void writeToParcel(Parcel param1Parcel, int param1Int) {
/* 185 */       param1Parcel.writeInt(this.mKeyCode);
/* 186 */       param1Parcel.writeInt(this.mTargetDisplay);
/*     */     }
/*     */     
/* 189 */     public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
/*     */         public CarInputHandlingService.InputFilter createFromParcel(Parcel param2Parcel) {
/* 191 */           return new CarInputHandlingService.InputFilter(param2Parcel);
/*     */         }
/*     */         
/*     */         public CarInputHandlingService.InputFilter[] newArray(int param2Int) {
/* 195 */           return new CarInputHandlingService.InputFilter[param2Int]; } }; public final int mKeyCode; public final int mTargetDisplay; } class null implements Parcelable.Creator { public CarInputHandlingService.InputFilter[] newArray(int param1Int) { return new CarInputHandlingService.InputFilter[param1Int]; }
/*     */ 
/*     */     
/*     */     public CarInputHandlingService.InputFilter createFromParcel(Parcel param1Parcel) {
/*     */       return new CarInputHandlingService.InputFilter(param1Parcel);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\input\CarInputHandlingService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */