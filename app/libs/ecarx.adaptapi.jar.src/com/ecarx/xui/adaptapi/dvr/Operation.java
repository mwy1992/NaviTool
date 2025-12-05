/*      */ package com.ecarx.xui.adaptapi.dvr;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.text.TextUtils;
/*      */ import android.util.Log;
/*      */ import ecarx.car.hardware.ECarXCarPropertyValue;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.CopyOnWriteArrayList;
/*      */ import vendor.ecarx.xma.pa.nano.VendorVehicleHalPAProto;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Operation
/*      */   extends AbsDvrSignal
/*      */   implements IOperation
/*      */ {
/*      */   private static final String TAG = "DVR_Operation";
/*      */   private ArrayList<IDvrFile> mCurrPageFiles;
/*      */   
/*      */   private enum OperationCallbackID
/*      */   {
/*   31 */     onBackToHomeStatus, onCaptureStatus, onChangeModeStatus, onDeleteAllFilesStatus, onDeleteFilesStatus, onLockFileStatus, onMoveVideosToEmergencyVideoPartitionStatus,
/*   32 */     onSdcardFormattingStatus, onSwitchPageStatus, onUnlockFileStatus;
/*      */     private static final OperationCallbackID[] $VALUES;
/*      */     
/*      */     static {
/*   36 */       onDeleteFilesStatus = new OperationCallbackID("onDeleteFilesStatus", 5);
/*   37 */       onDeleteAllFilesStatus = new OperationCallbackID("onDeleteAllFilesStatus", 6);
/*   38 */       onSwitchPageStatus = new OperationCallbackID("onSwitchPageStatus", 7);
/*   39 */       onLockFileStatus = new OperationCallbackID("onLockFileStatus", 8);
/*   40 */       onUnlockFileStatus = new OperationCallbackID("onUnlockFileStatus", 9);
/*      */       $VALUES = new OperationCallbackID[] { onChangeModeStatus, onSdcardFormattingStatus, onBackToHomeStatus, onCaptureStatus, onMoveVideosToEmergencyVideoPartitionStatus, onDeleteFilesStatus, onDeleteAllFilesStatus, onSwitchPageStatus, onLockFileStatus, onUnlockFileStatus };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   54 */   private int[] mFileSelectedIndex = new int[9]; private final CopyOnWriteArrayList<IOperation.IOperationCallback> mIOperationCallbacks; private int mNrOfVideoCurrPage;
/*      */   private int mPlayingStatus;
/*      */   
/*      */   public Operation(Context paramContext) {
/*   58 */     super(paramContext);
/*      */     
/*   60 */     this.mIOperationCallbacks = new CopyOnWriteArrayList<>();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void initSignalFilter() {
/*   66 */     addSignalFilter(Integer.valueOf(29041));
/*      */     
/*   68 */     addSignalFilter(Integer.valueOf(29020));
/*      */     
/*   70 */     addSignalFilter(Integer.valueOf(29040));
/*      */     
/*   72 */     addSignalFilter(Integer.valueOf(29037));
/*      */     
/*   74 */     addSignalFilter(Integer.valueOf(29036));
/*      */     
/*   76 */     addSignalFilter(Integer.valueOf(28984));
/*      */     
/*   78 */     addSignalFilter(Integer.valueOf(29014));
/*      */     
/*   80 */     addSignalFilter(Integer.valueOf(28983));
/*      */     
/*   82 */     addSignalFilter(Integer.valueOf(29039));
/*      */     
/*   84 */     addSignalFilter(Integer.valueOf(29113));
/*   85 */     addSignalFilter(Integer.valueOf(29114));
/*   86 */     addSignalFilter(Integer.valueOf(29115));
/*   87 */     addSignalFilter(Integer.valueOf(29116));
/*   88 */     addSignalFilter(Integer.valueOf(29117));
/*   89 */     addSignalFilter(Integer.valueOf(29118));
/*   90 */     addSignalFilter(Integer.valueOf(29119));
/*   91 */     addSignalFilter(Integer.valueOf(29120));
/*   92 */     addSignalFilter(Integer.valueOf(29121));
/*      */     
/*   94 */     addSignalFilter(Integer.valueOf(28946));
/*      */     
/*   96 */     addSignalFilter(Integer.valueOf(28956));
/*      */     
/*   98 */     addSignalFilter(Integer.valueOf(28959));
/*      */     
/*  100 */     addSignalFilter(Integer.valueOf(29022));
/*      */     
/*  102 */     addSignalFilter(Integer.valueOf(28958));
/*      */     
/*  104 */     addSignalFilter(Integer.valueOf(28957));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onChangeEvent(ECarXCarPropertyValue paramECarXCarPropertyValue)
/*      */   {
/*  114 */     int i = paramECarXCarPropertyValue.getPropertyId(); if (i != 28946 && i != 28956) if (i != 29014) { if (i != 29020) { switch (i) { default: switch (i) { default: switch (i) { default: switch (i)
/*      */                       
/*      */                       { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                         
/*      */                         default:
/*  175 */                           Log.w("DVR_Operation", "onChangeEvent Unrecognized signal!"); break;
/*      */                         case 29113: case 29114: case 29115:
/*      */                         case 29116:
/*      */                         case 29117:
/*      */                         case 29118:
/*      */                         case 29119:
/*      */                         case 29120:
/*      */                         case 29121:
/*      */                           break; }  onLockStsOfPrsntRecOfVehSurrndgsVinRec(); break;
/*      */                     case 29041:
/*      */                       onSdcardFormattingStatus(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); break;
/*      */                     case 29040:
/*      */                       onMode(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); break;
/*      */                     case 29039:
/*      */                       break; }  return;
/*      */                 case 29037:
/*      */                   onVehSurrndgsVinRecCmdRespTbl(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); return;
/*      */                 case 29036:
/*      */                   break; }  onVehSurrndgsVinRecCmdRes(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); return;
/*      */             case 28984:
/*      */               onBrowsingPageChanged(); return;
/*      */             case 28983:
/*  197 */               break; }  this.mCurrPageFiles = null; onBrowsingFiles(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); this.mNrOfVideoCurrPage = ((Integer)getValue(paramECarXCarPropertyValue)).intValue(); } else { onSdcardStatus(((Integer)getValue(paramECarXCarPropertyValue)).intValue()); }  } else { onBrowsingPageChanged(); }   } public boolean isCameraOnline() { boolean bool; if (getCurrentMode() != 8192) { bool = true; } else { bool = false; }  return bool; }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onErrorEvent(int paramInt1, int paramInt2) {}
/*      */ 
/*      */   
/*      */   public int getCurrentMode() {
/*  205 */     int i = 1;
/*      */     
/*      */     try {
/*  208 */       int j = this.mCarSignalManager.getVehSurrndgsVisnRecSts();
/*  209 */       i = j = convertDvrMode(j);
/*  210 */     } catch (Exception exception) {
/*  211 */       exception.printStackTrace();
/*      */     } 
/*      */     
/*  214 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean changeMode(int paramInt) {
/*  225 */     boolean bool = true;
/*      */     try {
/*  227 */       paramInt = convertVehSurrndgsVinRecCmdRespTbl(paramInt);
/*      */       
/*  229 */       sendSignal(28709, paramInt);
/*  230 */       resetFileSelectedIndex();
/*  231 */     } catch (Exception exception) {
/*  232 */       bool = false;
/*  233 */       exception.printStackTrace();
/*      */     } 
/*  235 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSdcardStatus() {
/*  243 */     int i = 1;
/*      */     
/*      */     try {
/*  246 */       int j = this.mCarSignalManager.getSurrndgsVisnRecTFSts();
/*  247 */       i = j = convertSdcardStatus(j);
/*  248 */     } catch (Exception exception) {
/*  249 */       exception.printStackTrace();
/*      */     } 
/*      */     
/*  252 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean formatSdcard() {
/*  266 */     boolean bool = true;
/*      */     
/*      */     try {
/*  269 */       sendSignal(28711, 1);
/*  270 */     } catch (Exception exception) {
/*  271 */       bool = false;
/*  272 */       exception.printStackTrace();
/*      */     } 
/*  274 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean backToHome() {
/*  296 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean capture() {
/*  308 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  312 */       sendSignal(28709, 9);
/*      */     }
/*  314 */     catch (Exception exception) {
/*  315 */       bool = false;
/*  316 */       exception.printStackTrace();
/*      */     } 
/*  318 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectFile(IDvrFile paramIDvrFile) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ifnull -> 119
/*      */     //   4: aload_1
/*      */     //   5: invokeinterface getId : ()Ljava/lang/String;
/*      */     //   10: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
/*      */     //   13: ifne -> 119
/*      */     //   16: aload_1
/*      */     //   17: invokeinterface getId : ()Ljava/lang/String;
/*      */     //   22: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   25: iconst_1
/*      */     //   26: isub
/*      */     //   27: istore_3
/*      */     //   28: aload_0
/*      */     //   29: getfield mFileSelectedIndex : [I
/*      */     //   32: astore #5
/*      */     //   34: aload_0
/*      */     //   35: getfield mFileSelectedIndex : [I
/*      */     //   38: iload_3
/*      */     //   39: iaload
/*      */     //   40: iconst_1
/*      */     //   41: if_icmpne -> 49
/*      */     //   44: iconst_0
/*      */     //   45: istore_2
/*      */     //   46: goto -> 51
/*      */     //   49: iconst_1
/*      */     //   50: istore_2
/*      */     //   51: aload #5
/*      */     //   53: iload_3
/*      */     //   54: iload_2
/*      */     //   55: iastore
/*      */     //   56: aload_0
/*      */     //   57: aload_0
/*      */     //   58: getfield mFileSelectedIndex : [I
/*      */     //   61: invokespecial encodingCurrentSeldFilesReq : ([I)Lvendor/ecarx/xma/pa/nano/VendorVehicleHalPAProto$ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec;
/*      */     //   64: astore #5
/*      */     //   66: aload_0
/*      */     //   67: sipush #28716
/*      */     //   70: invokevirtual checkActivateDvrVfc : (I)Z
/*      */     //   73: pop
/*      */     //   74: aload_0
/*      */     //   75: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   78: aload #5
/*      */     //   80: invokevirtual setAskLockStsOfPrsntRecOfVehSurrndgsVinRec : (Lvendor/ecarx/xma/pa/nano/VendorVehicleHalPAProto$ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec;)V
/*      */     //   83: aload_0
/*      */     //   84: getfield mFileSelectedIndex : [I
/*      */     //   87: iload_3
/*      */     //   88: iaload
/*      */     //   89: iconst_1
/*      */     //   90: if_icmpne -> 104
/*      */     //   93: aload_1
/*      */     //   94: checkcast com/ecarx/xui/adaptapi/dvr/DvrFile
/*      */     //   97: iconst_0
/*      */     //   98: invokevirtual setSelected : (Z)V
/*      */     //   101: goto -> 112
/*      */     //   104: aload_1
/*      */     //   105: checkcast com/ecarx/xui/adaptapi/dvr/DvrFile
/*      */     //   108: iconst_1
/*      */     //   109: invokevirtual setSelected : (Z)V
/*      */     //   112: goto -> 128
/*      */     //   115: astore_1
/*      */     //   116: goto -> 134
/*      */     //   119: ldc 'DVR_Operation'
/*      */     //   121: ldc_w 'Selected file is illegal'
/*      */     //   124: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
/*      */     //   127: pop
/*      */     //   128: iconst_1
/*      */     //   129: istore #4
/*      */     //   131: goto -> 141
/*      */     //   134: iconst_0
/*      */     //   135: istore #4
/*      */     //   137: aload_1
/*      */     //   138: invokevirtual printStackTrace : ()V
/*      */     //   141: iload #4
/*      */     //   143: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #326	-> 0
/*      */     //   #328	-> 0
/*      */     //   #330	-> 16
/*      */     //   #331	-> 28
/*      */     //   #332	-> 34
/*      */     //   #333	-> 44
/*      */     //   #334	-> 56
/*      */     //   #337	-> 66
/*      */     //   #340	-> 74
/*      */     //   #341	-> 83
/*      */     //   #342	-> 93
/*      */     //   #344	-> 104
/*      */     //   #346	-> 112
/*      */     //   #350	-> 115
/*      */     //   #347	-> 119
/*      */     //   #348	-> 128
/*      */     //   #353	-> 128
/*      */     //   #350	-> 134
/*      */     //   #351	-> 134
/*      */     //   #352	-> 137
/*      */     //   #354	-> 141
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   4	16	115	java/lang/Exception
/*      */     //   16	28	115	java/lang/Exception
/*      */     //   28	34	115	java/lang/Exception
/*      */     //   34	44	115	java/lang/Exception
/*      */     //   56	66	115	java/lang/Exception
/*      */     //   66	74	115	java/lang/Exception
/*      */     //   74	83	115	java/lang/Exception
/*      */     //   83	93	115	java/lang/Exception
/*      */     //   93	101	115	java/lang/Exception
/*      */     //   104	112	115	java/lang/Exception
/*      */     //   119	128	115	java/lang/Exception
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean selectAllFiles() {
/*  362 */     boolean bool = true;
/*      */     try {
/*  364 */       if (this.mNrOfVideoCurrPage > 0 && this.mCurrPageFiles != null)
/*      */       {
/*  366 */         for (byte b = 0; b < this.mNrOfVideoCurrPage; b++) {
/*  367 */           this.mFileSelectedIndex[b] = 0;
/*      */         }
/*  369 */         VendorVehicleHalPAProto.ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec = encodingCurrentSeldFilesReq(this.mFileSelectedIndex);
/*      */ 
/*      */         
/*  372 */         checkActivateDvrVfc(28716);
/*      */ 
/*      */         
/*  375 */         this.mCarSignalManager.setAskLockStsOfPrsntRecOfVehSurrndgsVinRec(protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec);
/*      */         
/*  377 */         for (IDvrFile iDvrFile : this.mCurrPageFiles) {
/*  378 */           ((DvrFile)iDvrFile).setSelected(true);
/*      */         }
/*      */       }
/*      */     
/*  382 */     } catch (Exception exception) {
/*  383 */       bool = false;
/*  384 */       exception.printStackTrace();
/*      */     } 
/*  386 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean deleteFiles(List<IDvrFile> paramList) {
/*  399 */     boolean bool = true;
/*      */     try {
/*  401 */       sendSignal(28709, 11);
/*      */     }
/*  403 */     catch (Exception exception) {
/*  404 */       bool = false;
/*  405 */       exception.printStackTrace();
/*      */     } 
/*  407 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean deleteAllFiles() {
/*  419 */     boolean bool = true;
/*      */     try {
/*  421 */       if (this.mCurrPageFiles.size() != 0) {
/*  422 */         selectAllFiles();
/*  423 */         sendSignal(28709, 11);
/*      */       }
/*      */     
/*      */     }
/*  427 */     catch (Exception exception) {
/*  428 */       bool = false;
/*  429 */       exception.printStackTrace();
/*      */     } 
/*  431 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean deleteAllFilesWithType(int paramInt) {
/*  442 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean moveVideosToEmergencyVideoPartition(List<IDvrVideoFile> paramList) {
/*  453 */     boolean bool3 = false, bool2 = false;
/*      */     
/*  455 */     boolean bool1 = bool3; if (paramList != null) { boolean bool = bool2; bool1 = bool3; try { if (paramList.size() > 0) {
/*      */ 
/*      */ 
/*      */           
/*  459 */           bool = bool2; sendSignal(28709, 10);
/*      */ 
/*      */           
/*  462 */           bool2 = true; bool3 = true;
/*  463 */           bool = bool3; Iterator<IDvrVideoFile> iterator = paramList.iterator(); while (true) { bool = bool3; bool1 = bool2; if (iterator.hasNext()) { bool = bool3; IDvrVideoFile iDvrVideoFile = iterator.next();
/*  464 */               bool = bool3; ((DvrVideoFile)iDvrVideoFile).setSelected(true); continue; }  break; }
/*      */         
/*      */         }  }
/*  467 */       catch (Exception exception)
/*  468 */       { exception.printStackTrace(); bool1 = bool; }
/*      */        }
/*  470 */      return bool1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean naviUp() {
/*  480 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean naviDown() {
/*  490 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean naviLeft() {
/*  500 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean naviRight() {
/*  510 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean play(IDvrFile paramIDvrFile) {
/*  520 */     boolean bool = true;
/*      */     
/*  522 */     if (paramIDvrFile != null) try { if (!TextUtils.isEmpty(paramIDvrFile.getId())) {
/*  523 */           int[] arrayOfInt = new int[9];
/*  524 */           for (byte b = 0; b < this.mNrOfVideoCurrPage; b++) {
/*  525 */             arrayOfInt[b] = 1;
/*      */           }
/*  527 */           arrayOfInt[Integer.parseInt(paramIDvrFile.getId()) - 1] = 0;
/*      */           
/*  529 */           VendorVehicleHalPAProto.ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec = encodingCurrentSeldFilesReq(arrayOfInt);
/*      */ 
/*      */           
/*  532 */           checkActivateDvrVfc(28716);
/*      */ 
/*      */           
/*  535 */           this.mCarSignalManager.setAskLockStsOfPrsntRecOfVehSurrndgsVinRec(protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec);
/*      */ 
/*      */ 
/*      */           
/*  539 */           sendSignal(28709, 13);
/*      */         }
/*      */          }
/*  542 */       catch (Exception exception)
/*  543 */       { bool = false;
/*  544 */         exception.printStackTrace(); }
/*      */        
/*  546 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPlayingStatus() {
/*  557 */     int i = 0;
/*      */     
/*      */     try {
/*  560 */       int j = this.mCarSignalManager.getVehSurrndgsVisnRecSts();
/*  561 */       i = j = convertPlayStatus(j);
/*  562 */     } catch (Exception exception) {
/*  563 */       exception.printStackTrace();
/*      */     } 
/*      */     
/*  566 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean play() {
/*  576 */     boolean bool = true;
/*      */     
/*      */     try {
/*  579 */       sendSignal(28709, 13);
/*      */     }
/*  581 */     catch (Exception exception) {
/*  582 */       bool = false;
/*  583 */       exception.printStackTrace();
/*      */     } 
/*  585 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean replay() {
/*  595 */     boolean bool = true;
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  600 */       sendSignal(28682, 0);
/*  601 */       sendSignal(28709, 13);
/*      */     }
/*  603 */     catch (Exception exception) {
/*  604 */       bool = false;
/*  605 */       exception.printStackTrace();
/*      */     } 
/*  607 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean pause() {
/*  617 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  621 */       sendSignal(28709, 14);
/*      */     }
/*  623 */     catch (Exception exception) {
/*  624 */       bool = false;
/*  625 */       exception.printStackTrace();
/*      */     } 
/*  627 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean playNext() {
/*  637 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  641 */       sendSignal(28709, 16);
/*      */     }
/*  643 */     catch (Exception exception) {
/*  644 */       bool = false;
/*  645 */       exception.printStackTrace();
/*      */     } 
/*  647 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean playPrevious() {
/*  657 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  661 */       sendSignal(28709, 15);
/*      */     }
/*  663 */     catch (Exception exception) {
/*  664 */       bool = false;
/*  665 */       exception.printStackTrace();
/*      */     } 
/*  667 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean exitPlay() {
/*  677 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  681 */       sendSignal(28709, 17);
/*      */     }
/*  683 */     catch (Exception exception) {
/*  684 */       bool = false;
/*  685 */       exception.printStackTrace();
/*      */     } 
/*  687 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPageCount() {
/*  695 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean browsePreviousPage() {
/*  705 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  709 */       sendSignal(28709, 19);
/*      */     }
/*  711 */     catch (Exception exception) {
/*  712 */       bool = false;
/*  713 */       exception.printStackTrace();
/*      */     } 
/*  715 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean browseNextPage() {
/*  725 */     boolean bool = true;
/*      */ 
/*      */     
/*      */     try {
/*  729 */       sendSignal(28709, 18);
/*      */     }
/*  731 */     catch (Exception exception) {
/*  732 */       bool = false;
/*  733 */       exception.printStackTrace();
/*      */     } 
/*  735 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean browsePage(int paramInt) {
/*  746 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean browseFirstPage() {
/*  756 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean browseLastPage() {
/*  766 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean lockFile(IDvrFile paramIDvrFile) {
/*  777 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean unlockFile(IDvrFile paramIDvrFile) {
/*  788 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rotatePhoto(IDvrPhotoFile paramIDvrPhotoFile, int paramInt) {
/*  798 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rotatePhoto(int paramInt) {
/*  806 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCallback(IOperation.IOperationCallback paramIOperationCallback) {
/*  814 */     if (!this.mIOperationCallbacks.contains(paramIOperationCallback)) {
/*  815 */       this.mIOperationCallbacks.add(paramIOperationCallback);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetCallback(IOperation.IOperationCallback paramIOperationCallback) {
/*  826 */     this.mIOperationCallbacks.remove(paramIOperationCallback);
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertDvrMode(int paramInt) {
/*  831 */     boolean bool = true;
/*      */     
/*  833 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  878 */         return paramInt;case 15: paramInt = 8192; return paramInt;case 11: paramInt = 2048; return paramInt;case 10: paramInt = 1024; return paramInt;case 9: paramInt = 512; return paramInt;case 8: paramInt = bool; return paramInt;case 7: paramInt = 128; return paramInt;case 6: paramInt = 64; return paramInt;case 5: paramInt = bool; return paramInt;case 3: paramInt = 16; return paramInt;case 2: paramInt = 4; return paramInt;case 1: paramInt = 2; return paramInt;case 0: break; }  paramInt = 1; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertPlayStatus(int paramInt) {
/*  883 */     byte b = 0;
/*      */     
/*  885 */     if (paramInt == 10) {
/*  886 */       b = 1;
/*  887 */     } else if (paramInt == 11) {
/*  888 */       b = 2;
/*      */     } 
/*      */     
/*  891 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertVehSurrndgsVinRecCmdRespTbl(int paramInt) {
/*  896 */     boolean bool = false;
/*      */     
/*  898 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  948 */         return paramInt;case 131072: paramInt = bool; return paramInt;case 65536: paramInt = bool; return paramInt;case 32768: paramInt = bool; return paramInt;case 16384: paramInt = 20; return paramInt;case 8192: paramInt = bool; return paramInt;case 4096: paramInt = bool; return paramInt;case 2048: paramInt = 14; return paramInt;case 1024: paramInt = 13; return paramInt;case 512: paramInt = 7; return paramInt;case 256: paramInt = bool; return paramInt;case 128: paramInt = 5; return paramInt;case 64: paramInt = 4; return paramInt;case 32: paramInt = bool; return paramInt;case 16: paramInt = 3; return paramInt;case 8: paramInt = 3; return paramInt;case 4: paramInt = 2; return paramInt;case 2: paramInt = 1; return paramInt;case 1: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int convertSdcardStatus(int paramInt) {
/*  953 */     byte b = 1;
/*      */     
/*  955 */     if (paramInt == 0) {
/*  956 */       b = 1;
/*  957 */     } else if (paramInt == 1) {
/*  958 */       b = 2;
/*  959 */     } else if (paramInt == 2) {
/*  960 */       b = 3;
/*  961 */     } else if (paramInt == 3) {
/*  962 */       b = 4;
/*  963 */     } else if (paramInt == 7) {
/*  964 */       b = 5;
/*  965 */     } else if (paramInt == 8) {
/*  966 */       b = 6;
/*  967 */     } else if (paramInt == 9) {
/*  968 */       b = 7;
/*  969 */     } else if (paramInt == 4) {
/*  970 */       b = 3;
/*  971 */     } else if (paramInt == 5) {
/*  972 */       b = 3;
/*      */     } 
/*      */     
/*  975 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int convertOperationStatus(int paramInt) {
/*  981 */     boolean bool = false;
/*  982 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1002 */         return paramInt;case 5: paramInt = 0; return paramInt;case 4: paramInt = 0; return paramInt;case 3: paramInt = 4; return paramInt;case 2: paramInt = 2; return paramInt;case 1: paramInt = 1; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private VendorVehicleHalPAProto.ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec encodingCurrentSeldFilesReq(int[] paramArrayOfint) {
/* 1007 */     VendorVehicleHalPAProto.ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec = new VendorVehicleHalPAProto.ProtoAskLockStsOfPrsntRecOfVehSurrndgsVinRec();
/*      */ 
/*      */     
/* 1010 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo1SeldSts = paramArrayOfint[0];
/*      */     
/* 1012 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo2SeldSts = paramArrayOfint[1];
/*      */     
/* 1014 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo3SeldSts = paramArrayOfint[2];
/*      */     
/* 1016 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo4SeldSts = paramArrayOfint[3];
/*      */     
/* 1018 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo5SeldSts = paramArrayOfint[4];
/*      */     
/* 1020 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo6SeldSts = paramArrayOfint[5];
/*      */     
/* 1022 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo7SeldSts = paramArrayOfint[6];
/*      */     
/* 1024 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo8SeldSts = paramArrayOfint[7];
/*      */     
/* 1026 */     protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec.askLockStsOfPrsntRecOfVehSurrndgsVinRecVideo9SeldSts = paramArrayOfint[8];
/*      */ 
/*      */     
/* 1029 */     return protoAskLockStsOfPrsntRecOfVehSurrndgsVinRec;
/*      */   }
/*      */   
/*      */   private void onLockStsOfPrsntRecOfVehSurrndgsVinRec() {
/*      */     try {
/* 1034 */       if (this.mCarSignalManager.getVehSurrndgsVinRecCmdRespTbl() == 20) {
/*      */         
/* 1036 */         ArrayList<Integer> arrayList = new ArrayList(); this();
/*      */         
/* 1038 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto1SelectSts()));
/* 1039 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto2SelectSts()));
/* 1040 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto3SelectSts()));
/* 1041 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto4SelectSts()));
/* 1042 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto5SelectSts()));
/* 1043 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto6SelectSts()));
/* 1044 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto7SelectSts()));
/* 1045 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto8SelectSts()));
/* 1046 */         arrayList.add(Integer.valueOf(this.mCarSignalManager.getPhoto9SelectSts()));
/*      */         
/* 1048 */         for (byte b = 0; b < this.mCurrPageFiles.size(); b++)
/* 1049 */         { DvrFile dvrFile = (DvrFile)this.mCurrPageFiles.get(b);
/* 1050 */           int i = ((Integer)arrayList.get(b)).intValue(); boolean bool = true; if (i != 1)
/*      */             bool = false;  dvrFile.setSelected(bool); } 
/*      */       } 
/* 1053 */     } catch (Exception exception) {
/* 1054 */       exception.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void onSdcardFormattingStatus(int paramInt) {
/* 1060 */     byte b = 0;
/* 1061 */     if (paramInt == 2) {
/* 1062 */       b = 1;
/* 1063 */     } else if (paramInt == 3) {
/* 1064 */       b = 2;
/* 1065 */     } else if (paramInt == 1) {
/* 1066 */       b = 3;
/*      */     } 
/*      */     
/* 1069 */     for (IOperation.IOperationCallback iOperationCallback : this.mIOperationCallbacks) {
/*      */       try {
/* 1071 */         iOperationCallback.onSdcardFormattingStatus(b);
/* 1072 */       } catch (Exception exception) {
/* 1073 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void onSdcardStatus(int paramInt) {
/* 1079 */     paramInt = convertSdcardStatus(paramInt);
/*      */     
/* 1081 */     for (IOperation.IOperationCallback iOperationCallback : this.mIOperationCallbacks) {
/*      */       try {
/* 1083 */         iOperationCallback.onSdcardStatus(paramInt);
/* 1084 */       } catch (Exception exception) {
/* 1085 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void onMode(int paramInt) {
/* 1091 */     int i = convertDvrMode(paramInt);
/*      */     
/* 1093 */     for (IOperation.IOperationCallback iOperationCallback : this.mIOperationCallbacks) {
/*      */       try {
/* 1095 */         iOperationCallback.onMode(i);
/*      */         
/* 1097 */         paramInt = getPlayingStatus();
/* 1098 */         if (this.mPlayingStatus != paramInt) {
/* 1099 */           this.mPlayingStatus = paramInt;
/* 1100 */           iOperationCallback.onPlayStatus(null, this.mPlayingStatus);
/*      */         } 
/* 1102 */       } catch (Exception exception) {
/* 1103 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onVehSurrndgsVinRecCmdRespTbl(int paramInt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onVehSurrndgsVinRecCmdRes(int paramInt) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: iload_1
/*      */     //   2: invokespecial convertOperationStatus : (I)I
/*      */     //   5: istore #4
/*      */     //   7: iconst_0
/*      */     //   8: istore_3
/*      */     //   9: aload_0
/*      */     //   10: getfield mCarSignalManager : Lecarx/car/hardware/signal/CarSignalManager;
/*      */     //   13: invokevirtual getVehSurrndgsVinRecCmdRespTbl : ()I
/*      */     //   16: istore_2
/*      */     //   17: goto -> 29
/*      */     //   20: astore #5
/*      */     //   22: aload #5
/*      */     //   24: invokevirtual printStackTrace : ()V
/*      */     //   27: iload_3
/*      */     //   28: istore_2
/*      */     //   29: iload_2
/*      */     //   30: ifeq -> 226
/*      */     //   33: iload_1
/*      */     //   34: ifeq -> 226
/*      */     //   37: aload_0
/*      */     //   38: getfield mIOperationCallbacks : Ljava/util/concurrent/CopyOnWriteArrayList;
/*      */     //   41: invokevirtual iterator : ()Ljava/util/Iterator;
/*      */     //   44: astore #5
/*      */     //   46: aload #5
/*      */     //   48: invokeinterface hasNext : ()Z
/*      */     //   53: ifeq -> 226
/*      */     //   56: aload #5
/*      */     //   58: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   63: checkcast com/ecarx/xui/adaptapi/dvr/IOperation$IOperationCallback
/*      */     //   66: astore #6
/*      */     //   68: iload_2
/*      */     //   69: tableswitch default -> 128, 1 -> 204, 2 -> 204, 3 -> 204, 4 -> 204, 5 -> 204, 6 -> 204, 7 -> 204, 8 -> 204, 9 -> 191, 10 -> 179, 11 -> 167
/*      */     //   128: iload_2
/*      */     //   129: tableswitch default -> 152, 18 -> 155, 19 -> 155
/*      */     //   152: goto -> 213
/*      */     //   155: aload #6
/*      */     //   157: iload #4
/*      */     //   159: invokeinterface onSwitchPageStatus : (I)V
/*      */     //   164: goto -> 213
/*      */     //   167: aload #6
/*      */     //   169: iload #4
/*      */     //   171: invokeinterface onDeleteFilesStatus : (I)V
/*      */     //   176: goto -> 213
/*      */     //   179: aload #6
/*      */     //   181: iload #4
/*      */     //   183: invokeinterface onMoveVideosToEmergencyVideoPartitionStatus : (I)V
/*      */     //   188: goto -> 213
/*      */     //   191: aload #6
/*      */     //   193: iload #4
/*      */     //   195: aconst_null
/*      */     //   196: invokeinterface onCaptureStatus : (ILcom/ecarx/xui/adaptapi/dvr/IDvrPhotoFile;)V
/*      */     //   201: goto -> 213
/*      */     //   204: aload #6
/*      */     //   206: iload #4
/*      */     //   208: invokeinterface onChangeModeStatus : (I)V
/*      */     //   213: goto -> 223
/*      */     //   216: astore #6
/*      */     //   218: aload #6
/*      */     //   220: invokevirtual printStackTrace : ()V
/*      */     //   223: goto -> 46
/*      */     //   226: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1122	-> 0
/*      */     //   #1123	-> 7
/*      */     //   #1126	-> 9
/*      */     //   #1129	-> 17
/*      */     //   #1127	-> 20
/*      */     //   #1128	-> 22
/*      */     //   #1130	-> 29
/*      */     //   #1132	-> 37
/*      */     //   #1134	-> 68
/*      */     //   #1161	-> 155
/*      */     //   #1156	-> 167
/*      */     //   #1158	-> 176
/*      */     //   #1153	-> 179
/*      */     //   #1154	-> 188
/*      */     //   #1150	-> 191
/*      */     //   #1151	-> 201
/*      */     //   #1144	-> 204
/*      */     //   #1145	-> 213
/*      */     //   #1166	-> 213
/*      */     //   #1164	-> 216
/*      */     //   #1165	-> 218
/*      */     //   #1167	-> 223
/*      */     //   #1169	-> 226
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   9	17	20	android/car/CarNotConnectedException
/*      */     //   155	164	216	java/lang/Exception
/*      */     //   167	176	216	java/lang/Exception
/*      */     //   179	188	216	java/lang/Exception
/*      */     //   191	201	216	java/lang/Exception
/*      */     //   204	213	216	java/lang/Exception
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onBrowsingPageChanged() {
/*      */     try {
/* 1173 */       int i = this.mCarSignalManager.getNrOfSld();
/* 1174 */       int j = this.mCarSignalManager.getSldNr();
/* 1175 */       for (IOperation.IOperationCallback iOperationCallback : this.mIOperationCallbacks) {
/*      */         try {
/* 1177 */           iOperationCallback.onBrowsingPageChanged(i, j);
/* 1178 */         } catch (Exception exception) {
/* 1179 */           exception.printStackTrace();
/*      */         } 
/*      */       } 
/* 1182 */     } catch (Exception exception) {
/* 1183 */       exception.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void onBrowsingFiles(int paramInt) {
/* 1188 */     ArrayList<DvrPhotoFile> arrayList = new ArrayList();
/* 1189 */     int i = getCurrentMode();
/*      */     
/* 1191 */     if (paramInt > 0 && paramInt < 10)
/*      */     {
/*      */       
/* 1194 */       for (byte b = 1; b <= paramInt; b++) {
/* 1195 */         DvrPhotoFile dvrPhotoFile; String str = String.valueOf(b);
/* 1196 */         DvrVideoFile dvrVideoFile = null;
/*      */         
/* 1198 */         if (i == 64) {
/* 1199 */           dvrVideoFile = new DvrVideoFile(str, 2);
/* 1200 */         } else if (i == 128) {
/* 1201 */           dvrVideoFile = new DvrVideoFile(str, 1);
/* 1202 */         } else if (i == 512) {
/* 1203 */           dvrPhotoFile = new DvrPhotoFile(str);
/*      */         } 
/*      */         
/* 1206 */         if (dvrPhotoFile != null) {
/* 1207 */           if (b == 1) {
/* 1208 */             dvrPhotoFile.setFirstDvrFile(true);
/* 1209 */           } else if (b == paramInt) {
/* 1210 */             dvrPhotoFile.setFinalDvrFile(true);
/*      */           } 
/* 1212 */           arrayList.add(dvrPhotoFile);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1217 */     this.mCurrPageFiles = (ArrayList)arrayList;
/*      */     
/* 1219 */     for (IOperation.IOperationCallback iOperationCallback : this.mIOperationCallbacks) {
/*      */       try {
/* 1221 */         iOperationCallback.onBrowsingFiles((List)arrayList);
/* 1222 */       } catch (Exception exception) {
/* 1223 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/* 1226 */     resetFileSelectedIndex();
/*      */   }
/*      */   
/*      */   private void resetFileSelectedIndex() {
/* 1230 */     for (byte b = 0; b < this.mFileSelectedIndex.length; b++)
/* 1231 */       this.mFileSelectedIndex[b] = 1; 
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\dvr\Operation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */