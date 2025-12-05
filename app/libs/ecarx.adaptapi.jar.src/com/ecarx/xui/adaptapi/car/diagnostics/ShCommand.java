/*    */ package com.ecarx.xui.adaptapi.car.diagnostics;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import android.util.Log;
/*    */ import java.util.Scanner;
/*    */ import libcore.io.IoUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShCommand
/*    */   implements IShCommand
/*    */ {
/*    */   private static final String TAG = "ShCommand";
/*    */   private Thread mCommandThread;
/*    */   
/*    */   public void executeCommand(int paramInt, String paramString, IShCommand.ICommandCallback paramICommandCallback) {
/*    */     String str;
/* 27 */     StringBuilder stringBuilder = null;
/*    */     
/* 29 */     if (paramInt == 1) {
/* 30 */       stringBuilder = new StringBuilder(); stringBuilder.append("top "); stringBuilder.append(paramString); str = stringBuilder.toString();
/* 31 */     } else if (paramInt == 2) {
/* 32 */       stringBuilder = new StringBuilder(); stringBuilder.append("cat "); stringBuilder.append(paramString); str = stringBuilder.toString();
/*    */     } 
/*    */     
/* 35 */     stopCommand();
/*    */     
/* 37 */     if (!TextUtils.isEmpty(str)) {
/* 38 */       this.mCommandThread = new Thread(new CommandRunnable(str, paramICommandCallback));
/* 39 */       this.mCommandThread.start();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void stopCommand() {
/* 48 */     if (this.mCommandThread != null)
/*    */       try {
/* 50 */         this.mCommandThread.interrupt();
/* 51 */         this.mCommandThread.join();
/* 52 */       } catch (InterruptedException interruptedException) {
/* 53 */         interruptedException.printStackTrace();
/*    */       }  
/*    */   }
/*    */   
/*    */   private static class CommandRunnable
/*    */     implements Runnable {
/*    */     private final IShCommand.ICommandCallback mCallback;
/*    */     private final String mFullCommand;
/*    */     
/*    */     public CommandRunnable(String param1String, IShCommand.ICommandCallback param1ICommandCallback) {
/* 63 */       this.mFullCommand = param1String;
/* 64 */       this.mCallback = param1ICommandCallback;
/*    */     }
/*    */ 
/*    */     
/*    */     public void run() {
/* 69 */       Scanner scanner4 = null, scanner3 = null;
/*    */       
/* 71 */       Scanner scanner1 = scanner3, scanner2 = scanner4; try { ProcessBuilder processBuilder = new ProcessBuilder(); scanner1 = scanner3; scanner2 = scanner4; this(new String[] { this.mFullCommand }); scanner1 = scanner3; scanner2 = scanner4; Process process = processBuilder.start();
/* 72 */         scanner1 = scanner3; scanner2 = scanner4; Scanner scanner = new Scanner(); scanner1 = scanner3; scanner2 = scanner4; this(process.getInputStream()); scanner3 = scanner;
/*    */         while (true) {
/* 74 */           scanner1 = scanner3; scanner2 = scanner3; if (scanner3.hasNextLine()) {
/* 75 */             scanner1 = scanner3; scanner2 = scanner3; if (this.mCallback != null) {
/* 76 */               scanner1 = scanner3; scanner2 = scanner3; this.mCallback.onCommandOutput(scanner3.nextLine());
/*    */             } 
/*    */             continue;
/*    */           } 
/*    */           break;
/*    */         } 
/* 82 */         IoUtils.closeQuietly(scanner3);
/* 83 */         if (this.mCallback != null)
/*    */           try {
/* 85 */             this.mCallback.onCommandEnd();
/* 86 */           } catch (Exception exception) {}  }
/*    */       catch (Exception exception)
/*    */       { scanner1 = scanner2;
/*    */         Log.w("ShCommand", Log.getStackTraceString(exception));
/*    */         IoUtils.closeQuietly(scanner2);
/*    */         if (this.mCallback != null)
/*    */           this.mCallback.onCommandEnd();  }
/*    */       finally {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\diagnostics\ShCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */