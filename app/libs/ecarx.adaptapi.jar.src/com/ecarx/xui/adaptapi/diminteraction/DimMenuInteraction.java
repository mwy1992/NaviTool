/*     */ package com.ecarx.xui.adaptapi.diminteraction;
/*     */ 
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.util.Log;
/*     */ import ecarx.dimprotocol.DIMProtocolManager;
/*     */ import ecarx.dimprotocol.IDIMProtocolServiceCallback;
/*     */ import ecarx.dimprotocol.INaviFunctionCallback;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DimMenuInteraction
/*     */   implements IDimMenuInteraction
/*     */ {
/*  35 */   private ArrayList<IDimMenuInteraction.IDimMenuInteractionCallback> mDimMenuInteractionCallbackList = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   private int IGN_OFF = 2;
/*  47 */   private int IGN_ON = 1;
/*  48 */   private int mLast_IGNState = this.IGN_ON; private static final byte MSG_TYPE_ACK = 3; private static final byte MSG_TYPE_ERROR = 4;
/*     */   private static final byte MSG_TYPE_NOTIFY = 2;
/*     */   private static final byte MSG_TYPE_REQUEST = 0;
/*     */   private static final byte MSG_TYPE_RESPONSE = 1;
/*     */   private static final String TAG = "DimMenuInteraction";
/*     */   private static final byte THEME_COMFORT = 1;
/*     */   private static final byte THEME_ECO = 2;
/*     */   private static final byte THEME_OFFROAD = 5;
/*     */   private static final byte THEME_SNOW = 4;
/*     */   private static final byte THEME_SPORT = 3;
/*     */   private static final String WALLPAPER_KEY = "wallpaper";
/*     */   private Context mContext;
/*     */   private IDIMProtocolServiceCallback mDIMServiceCallback;
/*     */   private DIMProtocolManager mDimProtocolManager;
/*     */   private INaviFunctionCallback mNaviFunctionCallback;
/*     */   private BroadcastReceiver mReceiver;
/*     */   
/*     */   public void notifyIHUReady() {
/*  66 */     Log.d("DimMenuInteraction", "notifyIHUReady");
/*     */ 
/*     */ 
/*     */     
/*  70 */     this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)1, new byte[] { 1 });
/*     */     
/*  72 */     int i = this.mDimProtocolManager.getWallPaperValue();
/*  73 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("通知当前壁纸:"); stringBuilder.append(i); Log.d("DimMenuInteraction", stringBuilder.toString());
/*     */     
/*  75 */     if (i == 1 || i == 2 || i == 3) {
/*     */       
/*  77 */       byte b = (byte)i;
/*  78 */       this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)19, new byte[] { b });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void requestDimTheme() {
/*  84 */     Log.d("DimMenuInteraction", "requestDimTheme");
/*     */     
/*  86 */     this.mDimProtocolManager.sendMessageToDIM((byte)0, (byte)8, (byte)12, new byte[] { 1 });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDimSwitchThemeCompeted(boolean paramBoolean) {
/*  92 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyDimSwitchThemeCompeted  completed:"); stringBuilder.append(paramBoolean); Log.d("DimMenuInteraction", stringBuilder.toString());
/*  93 */     if (paramBoolean) {
/*     */       
/*  95 */       this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)3, new byte[] { 1 });
/*     */     } else {
/*     */       
/*  98 */       this.mDimProtocolManager.sendMessageToDIM((byte)4, (byte)8, (byte)3, new byte[] { 0 });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean switchNaviMode(int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: monitorenter
/*     */     //   2: new java/lang/StringBuilder
/*     */     //   5: astore_2
/*     */     //   6: aload_2
/*     */     //   7: invokespecial <init> : ()V
/*     */     //   10: aload_2
/*     */     //   11: ldc 'switchNaviMode naviMode:'
/*     */     //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   16: pop
/*     */     //   17: aload_2
/*     */     //   18: iload_1
/*     */     //   19: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   22: pop
/*     */     //   23: ldc 'DimMenuInteraction'
/*     */     //   25: aload_2
/*     */     //   26: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   29: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   32: pop
/*     */     //   33: iload_1
/*     */     //   34: tableswitch default -> 64, 1 -> 181, 2 -> 143, 3 -> 105, 4 -> 67
/*     */     //   64: goto -> 219
/*     */     //   67: ldc 'DimMenuInteraction'
/*     */     //   69: ldc 'switchNaviMode    mode:NAVI_MODE_AR'
/*     */     //   71: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   74: pop
/*     */     //   75: aload_0
/*     */     //   76: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   79: iconst_4
/*     */     //   80: invokevirtual setNaviMode : (I)V
/*     */     //   83: aload_0
/*     */     //   84: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   87: iconst_0
/*     */     //   88: bipush #8
/*     */     //   90: bipush #14
/*     */     //   92: iconst_1
/*     */     //   93: newarray byte
/*     */     //   95: dup
/*     */     //   96: iconst_0
/*     */     //   97: iconst_1
/*     */     //   98: bastore
/*     */     //   99: invokevirtual sendMessageToDIM : (BBB[B)V
/*     */     //   102: goto -> 250
/*     */     //   105: ldc 'DimMenuInteraction'
/*     */     //   107: ldc 'switchNaviMode    mode:NAVI_MODE_FULL'
/*     */     //   109: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   112: pop
/*     */     //   113: aload_0
/*     */     //   114: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   117: iconst_3
/*     */     //   118: invokevirtual setNaviMode : (I)V
/*     */     //   121: aload_0
/*     */     //   122: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   125: iconst_0
/*     */     //   126: bipush #8
/*     */     //   128: bipush #14
/*     */     //   130: iconst_1
/*     */     //   131: newarray byte
/*     */     //   133: dup
/*     */     //   134: iconst_0
/*     */     //   135: iconst_1
/*     */     //   136: bastore
/*     */     //   137: invokevirtual sendMessageToDIM : (BBB[B)V
/*     */     //   140: goto -> 250
/*     */     //   143: ldc 'DimMenuInteraction'
/*     */     //   145: ldc 'switchNaviMode    mode:NAVI_MODE_SIMPLIFY'
/*     */     //   147: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   150: pop
/*     */     //   151: aload_0
/*     */     //   152: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   155: iconst_2
/*     */     //   156: invokevirtual setNaviMode : (I)V
/*     */     //   159: aload_0
/*     */     //   160: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   163: iconst_0
/*     */     //   164: bipush #8
/*     */     //   166: bipush #14
/*     */     //   168: iconst_1
/*     */     //   169: newarray byte
/*     */     //   171: dup
/*     */     //   172: iconst_0
/*     */     //   173: iconst_2
/*     */     //   174: bastore
/*     */     //   175: invokevirtual sendMessageToDIM : (BBB[B)V
/*     */     //   178: goto -> 250
/*     */     //   181: ldc 'DimMenuInteraction'
/*     */     //   183: ldc 'switchNaviMode    mode:NAVI_MODE_OFF'
/*     */     //   185: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   188: pop
/*     */     //   189: aload_0
/*     */     //   190: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   193: iconst_1
/*     */     //   194: invokevirtual setNaviMode : (I)V
/*     */     //   197: aload_0
/*     */     //   198: getfield mDimProtocolManager : Lecarx/dimprotocol/DIMProtocolManager;
/*     */     //   201: iconst_0
/*     */     //   202: bipush #8
/*     */     //   204: bipush #14
/*     */     //   206: iconst_1
/*     */     //   207: newarray byte
/*     */     //   209: dup
/*     */     //   210: iconst_0
/*     */     //   211: iconst_2
/*     */     //   212: bastore
/*     */     //   213: invokevirtual sendMessageToDIM : (BBB[B)V
/*     */     //   216: goto -> 250
/*     */     //   219: new java/lang/StringBuilder
/*     */     //   222: astore_2
/*     */     //   223: aload_2
/*     */     //   224: invokespecial <init> : ()V
/*     */     //   227: aload_2
/*     */     //   228: ldc 'switchNaviMode  ++++ mode:'
/*     */     //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   233: pop
/*     */     //   234: aload_2
/*     */     //   235: iload_1
/*     */     //   236: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*     */     //   239: pop
/*     */     //   240: ldc 'DimMenuInteraction'
/*     */     //   242: aload_2
/*     */     //   243: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   246: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
/*     */     //   249: pop
/*     */     //   250: aload_0
/*     */     //   251: monitorexit
/*     */     //   252: iconst_1
/*     */     //   253: ireturn
/*     */     //   254: astore_2
/*     */     //   255: aload_0
/*     */     //   256: monitorexit
/*     */     //   257: aload_2
/*     */     //   258: athrow
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #110	-> 0
/*     */     //   #112	-> 2
/*     */     //   #115	-> 33
/*     */     //   #141	-> 64
/*     */     //   #123	-> 67
/*     */     //   #124	-> 75
/*     */     //   #125	-> 83
/*     */     //   #126	-> 83
/*     */     //   #127	-> 102
/*     */     //   #117	-> 105
/*     */     //   #118	-> 113
/*     */     //   #119	-> 121
/*     */     //   #120	-> 121
/*     */     //   #121	-> 140
/*     */     //   #135	-> 143
/*     */     //   #136	-> 151
/*     */     //   #137	-> 159
/*     */     //   #138	-> 159
/*     */     //   #139	-> 178
/*     */     //   #129	-> 181
/*     */     //   #130	-> 189
/*     */     //   #131	-> 197
/*     */     //   #132	-> 197
/*     */     //   #133	-> 216
/*     */     //   #141	-> 219
/*     */     //   #144	-> 250
/*     */     //   #145	-> 254
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   2	33	254	finally
/*     */     //   67	75	254	finally
/*     */     //   75	83	254	finally
/*     */     //   83	102	254	finally
/*     */     //   105	113	254	finally
/*     */     //   113	121	254	finally
/*     */     //   121	140	254	finally
/*     */     //   143	151	254	finally
/*     */     //   151	159	254	finally
/*     */     //   159	178	254	finally
/*     */     //   181	189	254	finally
/*     */     //   189	197	254	finally
/*     */     //   197	216	254	finally
/*     */     //   219	250	254	finally
/*     */     //   250	252	254	finally
/*     */     //   255	257	254	finally
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
/*     */   public int getNaviMode() {
/* 154 */     int i = this.mDimProtocolManager.getNaviMode();
/* 155 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getNaviMode:"); stringBuilder.append(i); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 156 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVolume(int paramInt) {
/* 161 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setVolume   volume:"); stringBuilder.append(paramInt); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 162 */     byte b = (byte)paramInt;
/* 163 */     this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)10, new byte[] { b });
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
/*     */   public void setVolume(boolean paramBoolean, int paramInt) {
/* 175 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("setVolume   volume:"); stringBuilder.append(paramInt); stringBuilder.append(" isMute:"); stringBuilder.append(paramBoolean); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 176 */     int i = paramInt; if (paramBoolean) {
/* 177 */       i = paramInt + 100;
/*     */     }
/* 179 */     byte b = (byte)i;
/* 180 */     this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)10, new byte[] { b });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDimEnterControlCenter(int paramInt) {
/* 190 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyDimEnterControlCenter:"); stringBuilder.append(paramInt); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 191 */     byte b = (byte)paramInt;
/* 192 */     this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)18, new byte[] { b });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyDimControlCenterActiveType(int paramInt) {
/* 202 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyDimControlCenterActiveType  activeType:"); stringBuilder.append(paramInt); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 203 */     byte b = (byte)paramInt;
/* 204 */     this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)15, new byte[] { b });
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerDimMenuInteractionCallback(IDimMenuInteraction.IDimMenuInteractionCallback paramIDimMenuInteractionCallback) {
/* 209 */     Log.d("DimMenuInteraction", "registerDimMenuInteractionCallback");
/* 210 */     this.mDIMServiceCallback = (IDIMProtocolServiceCallback)new DIMProtocolServiceCallbackImpl();
/* 211 */     this.mDimMenuInteractionCallbackList.add(paramIDimMenuInteractionCallback);
/* 212 */     this.mDimProtocolManager.registerCallback(this.mDIMServiceCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unregisterDimMenuInteractionCallback(IDimMenuInteraction.IDimMenuInteractionCallback paramIDimMenuInteractionCallback) {
/* 217 */     Log.d("DimMenuInteraction", "unregisterDimMenuInteractionCallback");
/* 218 */     this.mDIMServiceCallback = null;
/* 219 */     this.mDimMenuInteractionCallbackList.remove(paramIDimMenuInteractionCallback);
/*     */   }
/*     */   
/*     */   public void registerNaviFunctionCallback(INaviFunctionCallback paramINaviFunctionCallback) {
/* 223 */     Log.d("DimMenuInteraction", "registerNaviFunctionCallback");
/* 224 */     this.mDimProtocolManager.registerNaviFunctionCallback(paramINaviFunctionCallback);
/*     */   }
/*     */   
/*     */   public void unregisterNaviFunctionCallback(INaviFunctionCallback paramINaviFunctionCallback) {
/* 228 */     Log.d("DimMenuInteraction", "unregisterNaviFunctionCallback");
/* 229 */     this.mDimProtocolManager.unregisterNaviFunctionCallback(paramINaviFunctionCallback);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestDimSwitchTabWindow(int paramInt) {
/* 239 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("requestDimSwitchTabWindow tab:"); stringBuilder.append(paramInt); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 240 */     byte b = (byte)paramInt;
/* 241 */     this.mDimProtocolManager.sendMessageToDIM((byte)0, (byte)8, (byte)4, new byte[] { b });
/*     */   }
/*     */ 
/*     */   
/*     */   public class DIMProtocolServiceCallbackImpl
/*     */     extends IDIMProtocolServiceCallback.Stub
/*     */   {
/*     */     final DimMenuInteraction this$0;
/*     */ 
/*     */     
/*     */     public void onAck(byte param1Byte) {
/* 252 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onAck  opcode:"); stringBuilder.append(param1Byte); Log.d("DimMenuInteraction", stringBuilder.toString());
/*     */     }
/*     */ 
/*     */     
/*     */     public void onError(byte param1Byte) {
/* 257 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("onError  opcode:"); stringBuilder.append(param1Byte); Log.d("DimMenuInteraction", stringBuilder.toString());
/*     */     }
/*     */     
/*     */     public void onFestivalPaperStatusChanged() {}
/*     */     public void onWallPaperStatusChanged(int param1Int) {}
/* 262 */     public void onReceived(byte param1Byte1, int param1Byte2) { boolean bool6 = false; int i = 0; boolean bool5 = false, bool2 = false, bool3 = false, bool1 = false, bool4 = false; if (param1Byte1 != 2) { if (param1Byte1 != 7) { if (param1Byte1 != 11) { if (param1Byte1 != 13) { if (param1Byte1 != 16) { if (param1Byte1 != 21) { switch (param1Byte1)
/*     */                   
/*     */                   { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                     
/*     */                     default:
/* 384 */                       stringBuilder = new StringBuilder(); stringBuilder.append("opcode error. data: "); stringBuilder.append(param1Byte1); Log.d("DimMenuInteraction", stringBuilder.toString()); return;
/*     */                     case 5: stringBuilder = new StringBuilder(); stringBuilder.append("DimProtocolManager sendMessageToDIM, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); DimMenuInteraction.this.mDimProtocolManager.sendMessageToDIM((byte)1, (byte)8, (byte)6, new byte[] { 0 }); return;
/*     */                     case 4: break; }  StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu onTabChanged, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); for (param1Byte1 = bool4; param1Byte1 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte1++)
/*     */                     ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onTabChanged(param1Byte2);  } else { boolean bool = false; if (1 == param1Byte2) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu onVolumeBarStatusChanged 不显示, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); bool = false; } else if (2 == param1Byte2) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu onVolumeBarStatusChanged 显示, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); bool = true; }  for (param1Byte1 = bool6; param1Byte1 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte1++)
/*     */                     ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onVolumeBarStatusChanged(bool);  }  } else { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu onControlCenterStateChanged, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); param1Byte1 = 0; switch (param1Byte2) { case 3: param1Byte1 = 0; break;
/*     */                   case 2: param1Byte1 = 2; break;
/*     */                   case 1: param1Byte1 = 1; break; }  for (param1Byte2 = i; param1Byte2 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte2++)
/*     */                   ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte2)).onControlCenterStateChanged(param1Byte1);  }  } else { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu onThemeChanged, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); for (param1Byte1 = bool5; param1Byte1 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte1++)
/*     */                 ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onThemeChanged(param1Byte2);  }  } else { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimProtocolManager sendMessageToDIM, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); switch (param1Byte2) { default:
/*     */                 stringBuilder = new StringBuilder(); stringBuilder.append("0x0B, requestIHUReady error. data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); return;
/*     */               case 2:
/*     */                 DimMenuInteraction.access$202(DimMenuInteraction.this, DimMenuInteraction.this.IGN_OFF); Log.d("DimMenuInteraction", "requestIHUReady 0x02,通知DIMMenu IGN off."); for (param1Byte1 = bool2; param1Byte1 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte1++)
/*     */                   ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onEngineStatusChanged(true);  return;
/*     */               case 1:
/*     */                 break; }  Log.d("DimMenuInteraction", "requestIHUReady 0x01,mLast_IGNState is IGN_OFF.通知DIMMenu。"); for (param1Byte1 = 0; param1Byte1 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte1++)
/*     */               ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onEngineStatusChanged(false);  int j = DimMenuInteraction.this.mDimProtocolManager.getWallPaperValue(); stringBuilder = new StringBuilder(); stringBuilder.append("通知当前壁纸:"); stringBuilder.append(j); Log.d("DimMenuInteraction", stringBuilder.toString()); if (j == 1 || j == 2 || j == 3) { byte b = (byte)j; DimMenuInteraction.this.mDimProtocolManager.sendMessageToDIM((byte)2, (byte)8, (byte)19, new byte[] { b }); }  DimMenuInteraction.access$202(DimMenuInteraction.this, DimMenuInteraction.this.IGN_ON); }  } else if (param1Byte2 != 0) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("0x07 error.  data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); } else { Log.d("DimMenuInteraction", "不允许进入全屏地图"); for (param1Byte1 = bool3; param1Byte1 < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); param1Byte1++)
/*     */             ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onChangeNaviMode(1);  }  } else { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("DimMenu onThemeChanged, data: "); stringBuilder.append(param1Byte2); Log.d("DimMenuInteraction", stringBuilder.toString()); i = DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); for (param1Byte1 = bool1; param1Byte1 < i; param1Byte1++)
/* 401 */           ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(param1Byte1)).onThemeChanged(param1Byte2);  }  } } public class NaviFunctionCallback extends INaviFunctionCallback.Stub { final DimMenuInteraction this$0; public void onChangeNaviMode(int param1Int) { if (DimMenuInteraction.this.mDimMenuInteractionCallbackList != null) {
/* 402 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("mDimMenuInteractionCallback is not null.  NaviFunctionCallback   onChangeNaviMode:"); stringBuilder.append(param1Int); Log.d("DimMenuInteraction", stringBuilder.toString());
/*     */         
/* 404 */         for (byte b = 0; b < DimMenuInteraction.this.mDimMenuInteractionCallbackList.size(); b++) {
/* 405 */           ((IDimMenuInteraction.IDimMenuInteractionCallback)DimMenuInteraction.this.mDimMenuInteractionCallbackList.get(b)).onChangeNaviMode(param1Int);
/*     */         }
/*     */       } else {
/* 408 */         StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("mDimMenuInteractionCallback is null.  NaviFunctionCallback   onChangeNaviMode:"); stringBuilder.append(param1Int); Log.d("DimMenuInteraction", stringBuilder.toString());
/*     */       }  }
/*     */      }
/*     */   public DimMenuInteraction(Context paramContext) {
/* 412 */     this.mReceiver = new BroadcastReceiver() { final DimMenuInteraction this$0;
/*     */         public void onReceive(Context param1Context, Intent param1Intent) {
/*     */           byte b;
/* 415 */           String str = param1Intent.getAction();
/* 416 */           StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(" Receive Action is "); stringBuilder.append(str); Log.d("DimMenuInteraction", stringBuilder.toString());
/* 417 */           if (str.hashCode() == -1398590059 && str.equals("android.intent.action.MASTER_CLEAR_NOTIFICATION")) { b = 0; } else { b = -1; }  if (b == 0) {
/*     */             
/* 419 */             Log.d("DimMenuInteraction", "Receive ACTION_MASTER_CLEAR_NOTIFICATION  switchNaviMode    mode:NAVI_MODE_OFF");
/* 420 */             DimMenuInteraction.this.switchNaviMode(1);
/*     */           } 
/*     */         } }
/*     */       ;
/*     */     this.mContext = paramContext;
/*     */     this.mDimProtocolManager = DIMProtocolManager.getInstance(paramContext);
/*     */     this.mNaviFunctionCallback = (INaviFunctionCallback)new NaviFunctionCallback();
/*     */     registerNaviFunctionCallback(this.mNaviFunctionCallback);
/*     */     IntentFilter intentFilter = new IntentFilter();
/*     */     intentFilter.addAction("android.intent.action.MASTER_CLEAR_NOTIFICATION");
/*     */     paramContext.registerReceiver(this.mReceiver, intentFilter);
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\diminteraction\DimMenuInteraction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */