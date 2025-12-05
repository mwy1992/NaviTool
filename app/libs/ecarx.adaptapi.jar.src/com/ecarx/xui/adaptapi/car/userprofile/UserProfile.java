/*      */ package com.ecarx.xui.adaptapi.car.userprofile;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.os.Bundle;
/*      */ import android.os.Handler;
/*      */ import android.text.TextUtils;
/*      */ import android.util.JsonReader;
/*      */ import android.util.Log;
/*      */ import com.ecarx.xui.adaptapi.AbsChainCarSignal;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.annotation.FailSuccess;
/*      */ import ecarx.car.hardware.signal.CarSignalManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarProfileManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarVfcipwakeupManager;
/*      */ import ecarx.car.hardware.vehicle.PATypes;
/*      */ import java.io.StringReader;
/*      */ import java.lang.annotation.ElementType;
/*      */ import java.lang.annotation.Repeatable;
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ import java.lang.annotation.Target;
/*      */ import java.lang.reflect.Field;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.CopyOnWriteArrayList;
/*      */ import java.util.stream.Stream;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @ProfileFunctions({@ProfileFunction(id = 537331712, property = {"vfmiscbyte0"}), @ProfileFunction(id = 738263296, property = {"vfmiscbyte1"}), @ProfileFunction(id = 537920512, property = {"vfmiscbyte2"}), @ProfileFunction(id = 537922048, property = {"vfmiscbyte3"}), @ProfileFunction(id = 537920256, property = {"vfmiscbyte4"}), @ProfileFunction(id = 537528320, property = {"vfmiscbyte6"}), @ProfileFunction(id = 704971008, property = {"vfmiscbyte7"}), @ProfileFunction(id = 704971264, property = {"vfmiscbyte8"}), @ProfileFunction(id = 537134592, property = {"vfmiscbyte9"}), @ProfileFunction(id = 704971520, property = {"vfmiscbyte10"}), @ProfileFunction(id = 704971776, property = {"vfmiscbyte11"}), @ProfileFunction(id = 537526784, property = {"vfmiscbyte12"}), @ProfileFunction(id = 705167616, property = {"vfmiscbyte13"}), @ProfileFunction(id = 537528320, property = {"vfmiscbyte14"}, zone = 537526528), @ProfileFunction(id = 537528576, property = {"vfmiscbyte15", "vfmiscbyte16", "vfmiscbyte17"}, zone = 537526528), @ProfileFunction(id = 704708864, property = {"vfmiscbyte18"}, zone = 537526528), @ProfileFunction(id = 537528320, property = {"vfmiscbyte19"}, zone = 537526529), @ProfileFunction(id = 537528576, property = {"vfmiscbyte20", "vfmiscbyte21", "vfmiscbyte22"}, zone = 537526529), @ProfileFunction(id = 704708864, property = {"vfmiscbyte23"}, zone = 537526529), @ProfileFunction(id = 537528320, property = {"vfmiscbyte24"}, zone = 537526530), @ProfileFunction(id = 537528576, property = {"vfmiscbyte25", "vfmiscbyte26", "vfmiscbyte27"}, zone = 537526530), @ProfileFunction(id = 704708864, property = {"vfmiscbyte28"}, zone = 537526530), @ProfileFunction(id = 537528320, property = {"vfmiscbyte29"}, zone = 537526531), @ProfileFunction(id = 537528576, property = {"vfmiscbyte30", "vfmiscbyte31", "vfmiscbyte32"}, zone = 537526531), @ProfileFunction(id = 704708864, property = {"vfmiscbyte33"}, zone = 537526531), @ProfileFunction(id = 705102080, property = {"vfmiscbyte34"}), @ProfileFunction(id = 705102336, property = {"vfmiscbyte35", "vfmiscbyte36", "vfmiscbyte37"}), @ProfileFunction(id = 705102592, property = {"vfmiscbyte38", "vfmiscbyte39", "vfmiscbyte40"}), @ProfileFunction(customId = 251658752, property = {"vfmiscbyte41"}, zone = 537526529), @ProfileFunction(customId = 251658752, property = {"vfmiscbyte42"}, zone = 537526530), @ProfileFunction(customId = 251658752, property = {"vfmiscbyte43"}, zone = 537526531), @ProfileFunction(customId = 251659008, property = {"vfmiscbyte44"}, zone = 537526529), @ProfileFunction(customId = 251659008, property = {"vfmiscbyte45"}, zone = 537526530), @ProfileFunction(customId = 251659008, property = {"vfmiscbyte46"}, zone = 537526531), @ProfileFunction(id = 537527296, property = {"vfmiscbyte47"}), @ProfileFunction(customId = 251659264, property = {"vfmiscbyte48"}, zone = 537526529), @ProfileFunction(customId = 251659264, property = {"vfmiscbyte49"}, zone = 537526530), @ProfileFunction(customId = 251659264, property = {"vfmiscbyte50"}, zone = 537526531), @ProfileFunction(customId = 251662080, property = {"vfmiscbyte51"}), @ProfileFunction(id = 570622720, property = {"drivemodebyte0"}), @ProfileFunction(id = 570622208, property = {"drivemodebyte1"}), @ProfileFunction(id = 570624512, property = {"drivemodebyte2"}), @ProfileFunction(id = 570624256, property = {"drivemodebyte3"}), @ProfileFunction(id = 570625536, property = {"drivemodebyte4"}), @ProfileFunction(id = 570622464, property = {"drivemodebyte5"}), @ProfileFunction(id = 620888320, property = {"systemsettingbyte0"}), @ProfileFunction(id = 620888576, property = {"systemsettingbyte1"}), @ProfileFunction(id = 620823296, property = {"systemsettingbyte2"}), @ProfileFunction(id = 620822784, property = {"systemsettingbyte3"}), @ProfileFunction(id = 620823808, property = {"systemsettingbyte4"}), @ProfileFunction(customId = 251659520, property = {"systemsettingbyte5"}), @ProfileFunction(id = 620823040, property = {"systemsettingbyte6"}), @ProfileFunction(id = 620823552, property = {"systemsettingbyte7"}), @ProfileFunction(id = 687997184, property = {"systemsettingbyte8"}), @ProfileFunction(customId = 251658496, property = {"climatebyte0"}), @ProfileFunction(id = 538510080, property = {"seatctrlbyte0"}), @ProfileFunction(id = 654443008, property = {"vfhudbyte0"}), @ProfileFunction(customId = 251659776, property = {"profiletransferbyte0"}), @ProfileFunction(id = 538706432, property = {"profiletransferbyte1"}), @ProfileFunction(customId = 251660032, property = {"profiletransferbyte2"}), @ProfileFunction(customId = 251660288, property = {"profiletransferbyte3"}), @ProfileFunction(customId = 251660544, property = {"profiletransferbyte4"}), @ProfileFunction(customId = 251660800, property = {"profiletransferbyte5"}), @ProfileFunction(customId = 251661056, property = {"profiletransferbyte6"}), @ProfileFunction(customId = 251661312, property = {"profiletransferbyte7"}), @ProfileFunction(customId = 251661568, property = {"profiletransferbyte8"}), @ProfileFunction(customId = 251661824, property = {"profiletransferbyte9"}), @ProfileFunction(id = 268764672, property = {"seatheatbyte0"}, zone = 1), @ProfileFunction(id = 268764672, property = {"seatheatbyte1"}, zone = 4), @ProfileFunction(id = 268764672, property = {"seatheatbyte2"}, zone = 16), @ProfileFunction(id = 268764672, property = {"seatheatbyte3"}, zone = 64), @ProfileFunction(id = 268764160, property = {"seatheatbyte4"}, zone = 1), @ProfileFunction(id = 268764160, property = {"seatheatbyte5"}, zone = 4)})
/*      */ public class UserProfile
/*      */   extends AbsChainCarSignal
/*      */   implements IUserProfile
/*      */ {
/*      */   private static final int INVALIDATE_PROFILE = -1;
/*      */   private static final String TAG = "Profile_API";
/*      */   private ECarXCarProfileManager mECarXCarProfileManager;
/*      */   private Handler mHandler;
/*      */   private final CopyOnWriteArrayList<IUserProfile.IUserProfileObserver> mObservers;
/*      */   private ECarXCarVfcipwakeupManager vfcManager;
/*      */   
/*      */   public UserProfile(Context paramContext) {
/*  343 */     super(paramContext);
/*  344 */     this.mObservers = new CopyOnWriteArrayList<>();
/*  345 */     this.mHandler = paramContext.getMainThreadHandler();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  350 */     this.mECarXCarProfileManager = paramECarXCarSetManager.getECarXCarProfileManager();
/*  351 */     this.vfcManager = paramECarXCarSetManager.getECarXCarVfcipwakeupManager();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void buildFilterChains() {
/*  358 */     addSignalChain(new -$$Lambda$UserProfile$dzvAxx4BIGsq2Xgbg5ND5UYlMT4(this), 29151);
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
/*  371 */     addSignalChain(new -$$Lambda$UserProfile$KNYLt0mn74IWhK1bQEg58vuXvLw(this), 29152);
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
/*  395 */     addPATypeChain(new -$$Lambda$UserProfile$VO7pI8ggrw1Lnh9aGr4T8Amcw7U(this), 33870);
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
/*  412 */     AbsChainCarSignal.EndQueueTask endQueueTask1 = whenMsgEnd(33913); -$$Lambda$UserProfile$X7ou3sMe7rpr0o_YkvcSYsx3-f4 -$$Lambda$UserProfile$X7ou3sMe7rpr0o_YkvcSYsx3-f4 = new -$$Lambda$UserProfile$X7ou3sMe7rpr0o_YkvcSYsx3-f4(this);
/*  413 */     AbsChainCarSignal.EndQueueTask endQueueTask2 = endQueueTask1.observerChange(33872, -$$Lambda$UserProfile$X7ou3sMe7rpr0o_YkvcSYsx3-f4); -$$Lambda$UserProfile$e6FmgljM4Tk8HlJ3DnfDhkWd9ag -$$Lambda$UserProfile$e6FmgljM4Tk8HlJ3DnfDhkWd9ag = new -$$Lambda$UserProfile$e6FmgljM4Tk8HlJ3DnfDhkWd9ag(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  423 */     endQueueTask2.observerChange(33871, -$$Lambda$UserProfile$e6FmgljM4Tk8HlJ3DnfDhkWd9ag);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  433 */     addPATypeChain(new -$$Lambda$UserProfile$y3j6qw4zt2-EeOCH53coOQme4-8(this), 33873);
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
/*  451 */     addPATypeChain(new -$$Lambda$UserProfile$PmnA3qhaXUTIX5lJtbVbzRii6eE(this), 33896);
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
/*  473 */     addPATypeChain(new -$$Lambda$UserProfile$Zwla_Cjr0JMdmAvp8JzxLAYsgVc(this), 33899);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  482 */     addSignalChain(new -$$Lambda$UserProfile$VX-4oWlynOfHukX8iYJP03AqmaA(this), 30638);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  490 */     addSignalChain(new -$$Lambda$UserProfile$oJLHnwKnPnC-Lv1660RUg1_8r1o(this), 30637);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  498 */     addSignalChain(new -$$Lambda$UserProfile$rKkbaJ5eMyhYT92YLlsm3pWQFsU(this), 28960);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  505 */     addPAFilter(Integer.valueOf(33888));
/*  506 */     addPAFilter(Integer.valueOf(33889));
/*  507 */     addPAFilter(Integer.valueOf(33890));
/*  508 */     addPAFilter(Integer.valueOf(33891));
/*  509 */     addPAFilter(Integer.valueOf(33892));
/*  510 */     addPAFilter(Integer.valueOf(33893));
/*  511 */     addPAFilter(Integer.valueOf(33898));
/*  512 */     addPAFilter(Integer.valueOf(33880));
/*  513 */     addPAFilter(Integer.valueOf(33900));
/*  514 */     addSignalFilter(Integer.valueOf(28944));
/*  515 */     addSignalFilter(Integer.valueOf(28961));
/*      */   }
/*      */   
/*      */   private boolean notAllow() {
/*  519 */     PATypes.PA_PSET_PChangeAllowed pA_PSET_PChangeAllowed = (PATypes.PA_PSET_PChangeAllowed)getPAData(33880);
/*      */     
/*  521 */     boolean bool2 = true, bool1 = bool2; if (pA_PSET_PChangeAllowed != null)
/*  522 */       if (pA_PSET_PChangeAllowed.getData() != 1) { bool1 = bool2; } else { bool1 = false; }
/*  523 */         if (bool1) {
/*  524 */       Log.d("Profile_API", "profile operation not allow");
/*      */     }
/*  526 */     return bool1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSupportUserProfileCount() {
/*  532 */     return 5;
/*      */   }
/*      */ 
/*      */   
/*      */   public int[] getUserProfileCreated() {
/*  537 */     ArrayList<Integer> arrayList = new ArrayList(13);
/*  538 */     PATypes.PA_PSET_ProfilesInuse pA_PSET_ProfilesInuse = (PATypes.PA_PSET_ProfilesInuse)getPAData(33900);
/*  539 */     if (pA_PSET_ProfilesInuse != null) {
/*  540 */       int[] arrayOfInt = pA_PSET_ProfilesInuse.getData();
/*  541 */       if (arrayOfInt != null) {
/*  542 */         for (byte b = 0; b < arrayOfInt.length; b++) {
/*  543 */           if (arrayOfInt[b] != 0) {
/*  544 */             arrayList.add(Integer.valueOf(b + 1));
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  549 */     return arrayList.stream().mapToInt(-$$Lambda$UserProfile$36G1ghC5y46sG5bUdtWPTTql1hc.INSTANCE).toArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCurrentId() {
/*  559 */     PATypes.PA_PSET_ActiveProfile pA_PSET_ActiveProfile = (PATypes.PA_PSET_ActiveProfile)getPAData(33870);
/*      */     
/*  561 */     if (pA_PSET_ActiveProfile != null) {
/*  562 */       return pA_PSET_ActiveProfile.getData();
/*      */     }
/*  564 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getProfileId(String paramString) {
/*  575 */     byte b = -1;
/*  576 */     if (TextUtils.isEmpty(paramString)) {
/*  577 */       return -1;
/*      */     }
/*  579 */     if (paramString.equals(getUserId(1))) {
/*  580 */       b = 1;
/*  581 */     } else if (paramString.equals(getUserId(2))) {
/*  582 */       b = 2;
/*  583 */     } else if (paramString.equals(getUserId(3))) {
/*  584 */       b = 3;
/*  585 */     } else if (paramString.equals(getUserId(4))) {
/*  586 */       b = 4;
/*  587 */     } else if (paramString.equals(getUserId(5))) {
/*  588 */       b = 5;
/*  589 */     } else if (paramString.equals(getUserId(12))) {
/*  590 */       b = 12;
/*      */     } 
/*  592 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getProfileId: uid="); stringBuilder.append(paramString); stringBuilder.append(" profileId="); stringBuilder.append(b); Log.i("Profile_API", stringBuilder.toString());
/*  593 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getUserId(int paramInt) {
/*      */     int[] arrayOfInt;
/*  604 */     PATypes.PA_PSET_User1 pA_PSET_User1 = null;
/*  605 */     if (paramInt == 1) {
/*  606 */       pA_PSET_User1 = (PATypes.PA_PSET_User1)getPAData(33888);
/*  607 */       arrayOfInt = pA_PSET_User1.getData();
/*  608 */     } else if (paramInt == 2) {
/*  609 */       PATypes.PA_PSET_User2 pA_PSET_User2 = (PATypes.PA_PSET_User2)getPAData(33889);
/*  610 */       arrayOfInt = pA_PSET_User2.getData();
/*  611 */     } else if (paramInt == 3) {
/*  612 */       PATypes.PA_PSET_User3 pA_PSET_User3 = (PATypes.PA_PSET_User3)getPAData(33890);
/*  613 */       arrayOfInt = pA_PSET_User3.getData();
/*  614 */     } else if (paramInt == 4) {
/*  615 */       PATypes.PA_PSET_User4 pA_PSET_User4 = (PATypes.PA_PSET_User4)getPAData(33891);
/*  616 */       arrayOfInt = pA_PSET_User4.getData();
/*  617 */     } else if (paramInt == 5) {
/*  618 */       PATypes.PA_PSET_User5 pA_PSET_User5 = (PATypes.PA_PSET_User5)getPAData(33892);
/*  619 */       arrayOfInt = pA_PSET_User5.getData();
/*  620 */     } else if (paramInt == 12) {
/*  621 */       PATypes.PA_PSET_User6 pA_PSET_User6 = (PATypes.PA_PSET_User6)getPAData(33893);
/*  622 */       arrayOfInt = pA_PSET_User6.getData();
/*      */     } 
/*  624 */     String str2 = null; if (arrayOfInt == null) {
/*  625 */       return null;
/*      */     }
/*  627 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("gid="); stringBuilder.append(Arrays.toString(arrayOfInt)); Log.i("Profile_API", stringBuilder.toString());
/*  628 */     stringBuilder = new StringBuilder(); byte b; int i;
/*  629 */     for (i = arrayOfInt.length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  630 */       stringBuilder.append(Character.valueOf((char)j)); b++; }
/*      */     
/*  632 */     String str1 = stringBuilder.toString().trim();
/*  633 */     stringBuilder = new StringBuilder(); stringBuilder.append("getUserId: ProfileId="); stringBuilder.append(paramInt); stringBuilder.append(" gid="); stringBuilder.append(str1); Log.i("Profile_API", stringBuilder.toString());
/*  634 */     if (str1.isEmpty()) str1 = str2;  return str1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getProfileLoginType(int paramInt) {
/*  645 */     return 0;
/*      */   }
/*      */   
/*      */   private int nextCreateProfile() {
/*  649 */     byte b = -1;
/*  650 */     PATypes.PA_PSET_ProfilesInuse pA_PSET_ProfilesInuse = (PATypes.PA_PSET_ProfilesInuse)getPAData(33900);
/*  651 */     int i = b; if (pA_PSET_ProfilesInuse != null) {
/*  652 */       int[] arrayOfInt = pA_PSET_ProfilesInuse.getData();
/*  653 */       i = b; if (arrayOfInt != null) {
/*  654 */         byte b1 = 0; while (true) { i = b; if (b1 < arrayOfInt.length) {
/*  655 */             if (arrayOfInt[b1] == 0) {
/*  656 */               i = b1 + 1; break;
/*      */             }  b1++; continue;
/*      */           }  break; }
/*      */       
/*      */       } 
/*      */     } 
/*  662 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int addUserProfile() {
/*  672 */     Log.d("Profile_API", "addUserProfile");
/*  673 */     int i = nextCreateProfile();
/*  674 */     onUserProfileActionStatus(1, i, 1);
/*      */     
/*  676 */     if (notAllow()) {
/*  677 */       onUserProfileActionStatus(1, i, 4);
/*      */     } else {
/*      */       
/*  680 */       onUserProfileActionStatus(1, i, 2);
/*      */       
/*  682 */       this.mECarXCarProfileManager.CB_PSET_NewProfile(0);
/*      */     } 
/*  684 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int addUserProfileCopyFrom(int paramInt) {
/*  689 */     int i = nextCreateProfile();
/*  690 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("addUserProfileCopyFrom "); stringBuilder.append(i); Log.d("Profile_API", stringBuilder.toString());
/*  691 */     onUserProfileActionStatus(1, i, 1);
/*      */     
/*  693 */     if (notAllow()) {
/*  694 */       onUserProfileActionStatus(1, i, 4);
/*      */     } else {
/*      */       
/*  697 */       onUserProfileActionStatus(1, i, 2);
/*      */       
/*  699 */       this.mECarXCarProfileManager.CB_PSET_NewProfile(paramInt);
/*      */     } 
/*  701 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeUserProfile(int paramInt) {
/*  712 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("removeUserProfile "); stringBuilder.append(paramInt); Log.d("Profile_API", stringBuilder.toString());
/*  713 */     boolean bool = true; onUserProfileActionStatus(2, paramInt, 1);
/*      */     
/*  715 */     if (notAllow()) {
/*  716 */       onUserProfileActionStatus(2, paramInt, 4);
/*      */       
/*  718 */       return false;
/*      */     } 
/*  720 */     onUserProfileActionStatus(2, paramInt, 2);
/*      */     
/*  722 */     ApiResult apiResult = this.mECarXCarProfileManager.CB_PSET_DeleteProfile(paramInt);
/*  723 */     if (apiResult != ApiResult.SUCCEED) bool = false;  return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean loginUserProfile(int paramInt) {
/*  734 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("loginUserProfile "); stringBuilder.append(paramInt); Log.d("Profile_API", stringBuilder.toString());
/*  735 */     boolean bool = true; onUserProfileActionStatus(3, paramInt, 1);
/*      */     
/*  737 */     if (notAllow()) {
/*  738 */       onUserProfileActionStatus(3, paramInt, 4);
/*      */       
/*  740 */       return false;
/*      */     } 
/*  742 */     onUserProfileActionStatus(3, paramInt, 2);
/*      */     
/*  744 */     ApiResult apiResult = this.mECarXCarProfileManager.CB_PSET_RequestActiveProfile(paramInt);
/*  745 */     if (apiResult != ApiResult.SUCCEED) bool = false;  return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean logoutUserProfile(int paramInt) {
/*  756 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("logoutUserProfile "); stringBuilder.append(paramInt); Log.d("Profile_API", stringBuilder.toString());
/*  757 */     boolean bool = true; onUserProfileActionStatus(4, paramInt, 1);
/*      */     
/*  759 */     if (notAllow()) {
/*  760 */       onUserProfileActionStatus(4, paramInt, 4);
/*      */       
/*  762 */       return false;
/*      */     } 
/*  764 */     if (paramInt != getCurrentId()) {
/*  765 */       onUserProfileActionStatus(4, paramInt, 4);
/*      */       
/*  767 */       return false;
/*      */     } 
/*  769 */     ApiResult apiResult = this.mECarXCarProfileManager.CB_PSET_Logout(paramInt);
/*  770 */     onUserProfileActionStatus(4, paramInt, 2);
/*      */     
/*  772 */     if (apiResult != ApiResult.SUCCEED) bool = false;  return bool;
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
/*      */   public boolean switchUserProfile(int paramInt1, int paramInt2) {
/*  784 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("switchUserProfile "); stringBuilder.append(paramInt2); Log.d("Profile_API", stringBuilder.toString());
/*  785 */     boolean bool = true; onUserProfileActionStatus(3, paramInt2, 1);
/*      */     
/*  787 */     if (notAllow()) {
/*  788 */       onUserProfileActionStatus(3, paramInt2, 4);
/*      */       
/*  790 */       return false;
/*      */     } 
/*  792 */     if (paramInt2 == getCurrentId()) {
/*  793 */       onUserProfileActionStatus(4, paramInt2, 3);
/*      */       
/*  795 */       return true;
/*      */     } 
/*  797 */     onUserProfileActionStatus(3, paramInt2, 2);
/*      */     
/*  799 */     ApiResult apiResult = this.mECarXCarProfileManager.CB_PSET_RequestActiveProfile(paramInt2);
/*  800 */     if (apiResult != ApiResult.SUCCEED) bool = false;  return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public IProfile getUserProfileData(int paramInt) {
/*  811 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getUserProfileData "); stringBuilder.append(paramInt); Log.d("Profile_API", stringBuilder.toString());
/*      */     
/*  813 */     int i = getCurrentId();
/*  814 */     if (i == -1 || paramInt != i) {
/*  815 */       return null;
/*      */     }
/*  817 */     PATypes.PA_PSET_ProfileCloudData pA_PSET_ProfileCloudData = (PATypes.PA_PSET_ProfileCloudData)getPAData(33898);
/*      */     
/*  819 */     return new Profile(this, pA_PSET_ProfileCloudData);
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
/*      */   public boolean applyUserProfileData(int paramInt, IProfile paramIProfile) {
/*  832 */     onUserProfileActionStatus(6, paramInt, 1);
/*      */     
/*  834 */     int i = getCurrentId();
/*  835 */     if (i == -1 || paramInt != i || paramIProfile == null || notAllow()) {
/*  836 */       onUserProfileActionStatus(6, paramInt, 4);
/*      */       
/*  838 */       return false;
/*      */     } 
/*  840 */     onUserProfileActionStatus(6, paramInt, 2);
/*      */     
/*  842 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("applyUserProfileData::"); stringBuilder.append(paramIProfile.toJOSNString()); Log.i("Profile_API", stringBuilder.toString());
/*  843 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  844 */     JsonReader jsonReader = new JsonReader(new StringReader(paramIProfile.toJOSNString()));
/*      */     try {
/*  846 */       jsonReader.beginObject();
/*  847 */       while (jsonReader.hasNext()) {
/*  848 */         String str = jsonReader.nextName();
/*  849 */         hashMap.put(str, jsonReader.nextString());
/*      */       } 
/*  851 */       jsonReader.endObject();
/*  852 */       ProfileFunction[] arrayOfProfileFunction = getClass().<ProfileFunction>getAnnotationsByType(ProfileFunction.class);
/*      */       
/*  854 */       VendorVehicleHalPAProto.Profileclouddata profileclouddata = new VendorVehicleHalPAProto.Profileclouddata(); this();
/*      */       
/*  856 */       Stream<ProfileFunction> stream2 = Arrays.stream(arrayOfProfileFunction); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/*  857 */       stream2 = stream2.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$UserProfile$o9t6Af-6H2p6dQhPy-ZXFMU-M7A -$$Lambda$UserProfile$o9t6Af-6H2p6dQhPy-ZXFMU-M7A = -$$Lambda$UserProfile$o9t6Af-6H2p6dQhPy-ZXFMU-M7A.INSTANCE;
/*  858 */       Stream<ProfileFunction> stream1 = stream2.filter(-$$Lambda$UserProfile$o9t6Af-6H2p6dQhPy-ZXFMU-M7A); -$$Lambda$UserProfile$iumInkelKD5KthX6m5UKMFKih8s -$$Lambda$UserProfile$iumInkelKD5KthX6m5UKMFKih8s = new -$$Lambda$UserProfile$iumInkelKD5KthX6m5UKMFKih8s(); this(this, hashMap, profileclouddata);
/*  859 */       stream1.forEach(-$$Lambda$UserProfile$iumInkelKD5KthX6m5UKMFKih8s);
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
/*  872 */       this.mECarXCarProfileManager.CB_PSET_ProfileCloudData(profileclouddata);
/*  873 */       return true;
/*  874 */     } catch (Exception exception) {
/*  875 */       exception.printStackTrace();
/*  876 */       onUserProfileActionStatus(6, paramInt, 4);
/*      */ 
/*      */ 
/*      */       
/*  880 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean resetUserProfileDataDefault(int paramInt) {
/*  891 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("resetUserProfileDataDefault "); stringBuilder.append(paramInt); Log.d("Profile_API", stringBuilder.toString());
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
/*  905 */     return false;
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
/*      */   public boolean notifyUIDInfoToProfile(int paramInt, String paramString, Bundle paramBundle) {
/*  920 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("notifyUIDInfoToProfile notifyAction="); stringBuilder.append(paramInt); stringBuilder.append(" uid="); stringBuilder.append(paramString); Log.d("Profile_API", stringBuilder.toString());
/*  921 */     boolean bool = false;
/*  922 */     if (paramInt == 17) {
/*  923 */       int j = getCurrentId();
/*  924 */       int i = j; if (paramBundle != null) { i = j; if (paramBundle.containsKey("profileId"))
/*  925 */           i = paramBundle.getInt("profileId", j);  }
/*      */       
/*  927 */       bool = bindProfile(paramString, i);
/*  928 */       if (!bool) {
/*  929 */         onUserProfileActionStatus(paramInt, i, 4);
/*      */       
/*      */       }
/*      */     }
/*  933 */     else if (paramInt == 18) {
/*  934 */       int i = getProfileId(paramString);
/*  935 */       bool = unbindProfile(paramString, i);
/*  936 */       if (!bool) {
/*  937 */         onUserProfileActionStatus(paramInt, i, 4);
/*      */       
/*      */       }
/*      */     }
/*  941 */     else if (paramInt == 19) {
/*  942 */       boolean bool1 = unbindProfileAll();
/*  943 */       bool = bool1; if (!bool1) {
/*  944 */         onUserProfileActionStatus(paramInt, -1, 4); bool = bool1;
/*      */       }
/*      */     
/*      */     }
/*  948 */     else if (paramInt == 33) {
/*  949 */       boolean bool1 = bindFaceID(paramString);
/*  950 */       bool = bool1; if (!bool1) {
/*  951 */         onUserProfileActionStatus(paramInt, -1, 4); bool = bool1;
/*      */       }
/*      */     
/*      */     }
/*  955 */     else if (paramInt == 34) {
/*  956 */       boolean bool1 = unbindFaceID(paramString);
/*  957 */       bool = bool1; if (!bool1) {
/*  958 */         onUserProfileActionStatus(paramInt, -1, 4); bool = bool1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  963 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean saveToPreference(int paramInt) {
/*  974 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean restorePreference() {
/*  984 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean restorePreference(int paramInt) {
/*  995 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean stopRestorePreference() {
/* 1005 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setDefaultPreference(int paramInt) {
/* 1016 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPreferenceId(int paramInt) {
/* 1027 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean switchPreference(int paramInt) {
/* 1038 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean registerPreferenceObserver(IUserProfile.IPreferenceObserver paramIPreferenceObserver) {
/* 1049 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean unregisterPreferenceObserver(IUserProfile.IPreferenceObserver paramIPreferenceObserver) {
/* 1060 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNeedLogin() {
/* 1070 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean registerUserProfileObserver(IUserProfile.IUserProfileObserver paramIUserProfileObserver) {
/* 1081 */     boolean bool = false;
/* 1082 */     if (!this.mObservers.contains(paramIUserProfileObserver)) {
/* 1083 */       bool = this.mObservers.add(paramIUserProfileObserver);
/*      */     }
/* 1085 */     return bool;
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
/*      */   private void onUserProfileActionStatus(int paramInt1, int paramInt2, int paramInt3) {
/* 1098 */     for (IUserProfile.IUserProfileObserver iUserProfileObserver : this.mObservers) {
/*      */       try {
/* 1100 */         iUserProfileObserver.onUserProfileActionStatus(paramInt1, paramInt2, paramInt3);
/* 1101 */       } catch (Exception exception) {
/* 1102 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void onUserProfileAddStatus(int paramInt1, int paramInt2) {
/* 1109 */     for (IUserProfile.IUserProfileObserver iUserProfileObserver : this.mObservers) {
/*      */       try {
/* 1111 */         iUserProfileObserver.onUserProfileAdded(paramInt1);
/* 1112 */         iUserProfileObserver.onUserProfileActionStatus(1, paramInt1, paramInt2);
/* 1113 */       } catch (Exception exception) {
/* 1114 */         exception.printStackTrace();
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
/*      */   private void onUserProfileActionError(int paramInt1, int paramInt2) {
/* 1126 */     for (IUserProfile.IUserProfileObserver iUserProfileObserver : this.mObservers) {
/*      */       try {
/* 1128 */         iUserProfileObserver.onUserProfileActionError(paramInt1, paramInt2);
/* 1129 */       } catch (Exception exception) {
/* 1130 */         exception.printStackTrace();
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
/*      */   public boolean unregisterUserProfileObserver(IUserProfile.IUserProfileObserver paramIUserProfileObserver) {
/* 1143 */     if (this.mObservers.contains(paramIUserProfileObserver)) {
/* 1144 */       return this.mObservers.remove(paramIUserProfileObserver);
/*      */     }
/* 1146 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean saveCurrentUserProfile() {
/* 1155 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getUserProfileAdjusted() {
/* 1164 */     return new int[0];
/*      */   }
/*      */   
/*      */   private int[] parseUID(String paramString) {
/* 1168 */     if (paramString.length() > 16) {
/* 1169 */       StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("the uid "); stringBuilder.append(paramString); stringBuilder.append(", length too longest more than 16"); Log.i("Profile_API", stringBuilder.toString());
/* 1170 */       return null;
/*      */     } 
/* 1172 */     int[] arrayOfInt = new int[16]; int i, j;
/* 1173 */     for (i = 0, j = paramString.length(); i < j; i++) {
/* 1174 */       arrayOfInt[i] = paramString.charAt(i);
/*      */     }
/* 1176 */     for (i = paramString.length(); i < 16; i++) {
/* 1177 */       arrayOfInt[i] = 32;
/*      */     }
/* 1179 */     return arrayOfInt;
/*      */   }
/*      */   
/*      */   private boolean bindProfile(String paramString, int paramInt) {
/* 1183 */     onUserProfileActionStatus(17, paramInt, 1);
/*      */ 
/*      */     
/* 1186 */     if (paramInt == -1 || paramString == null || TextUtils.isEmpty(paramString.trim()) || 
/* 1187 */       notAllow()) {
/* 1188 */       return false;
/*      */     }
/* 1190 */     int[] arrayOfInt = parseUID(paramString);
/* 1191 */     if (arrayOfInt == null) {
/* 1192 */       return false;
/*      */     }
/* 1194 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("bindProfile="); stringBuilder.append(Arrays.toString(arrayOfInt)); Log.i("Profile_API", stringBuilder.toString());
/* 1195 */     onUserProfileActionStatus(17, paramInt, 2);
/*      */ 
/*      */     
/* 1198 */     VendorVehicleHalPAProto.CbPsetGidbindprofile cbPsetGidbindprofile = new VendorVehicleHalPAProto.CbPsetGidbindprofile();
/*      */     
/* 1200 */     cbPsetGidbindprofile.profilebindid = paramInt;
/* 1201 */     cbPsetGidbindprofile.profilegidconnect = 17;
/* 1202 */     cbPsetGidbindprofile.gidinfobyte0 = arrayOfInt[0];
/* 1203 */     cbPsetGidbindprofile.gidinfobyte1 = arrayOfInt[1];
/* 1204 */     cbPsetGidbindprofile.gidinfobyte2 = arrayOfInt[2];
/* 1205 */     cbPsetGidbindprofile.gidinfobyte3 = arrayOfInt[3];
/* 1206 */     cbPsetGidbindprofile.gidinfobyte4 = arrayOfInt[4];
/* 1207 */     cbPsetGidbindprofile.gidinfobyte5 = arrayOfInt[5];
/* 1208 */     cbPsetGidbindprofile.gidinfobyte6 = arrayOfInt[6];
/* 1209 */     cbPsetGidbindprofile.gidinfobyte7 = arrayOfInt[7];
/* 1210 */     cbPsetGidbindprofile.gidinfobyte8 = arrayOfInt[8];
/* 1211 */     cbPsetGidbindprofile.gidinfobyte9 = arrayOfInt[9];
/* 1212 */     cbPsetGidbindprofile.gidinfobyte10 = arrayOfInt[10];
/* 1213 */     cbPsetGidbindprofile.gidinfobyte11 = arrayOfInt[11];
/* 1214 */     cbPsetGidbindprofile.gidinfobyte12 = arrayOfInt[12];
/* 1215 */     cbPsetGidbindprofile.gidinfobyte13 = arrayOfInt[13];
/* 1216 */     cbPsetGidbindprofile.gidinfobyte14 = arrayOfInt[14];
/* 1217 */     cbPsetGidbindprofile.gidinfobyte15 = arrayOfInt[15];
/* 1218 */     this.mECarXCarProfileManager.CB_PSET_GIDBindProfile(cbPsetGidbindprofile);
/* 1219 */     return true;
/*      */   }
/*      */   
/*      */   private boolean unbindProfile(String paramString, int paramInt) {
/* 1223 */     onUserProfileActionStatus(18, paramInt, 1);
/*      */ 
/*      */     
/* 1226 */     if (paramInt == -1 || paramString == null || TextUtils.isEmpty(paramString.trim()) || 
/* 1227 */       notAllow()) {
/* 1228 */       return false;
/*      */     }
/* 1230 */     int[] arrayOfInt = parseUID(paramString);
/* 1231 */     if (arrayOfInt == null) {
/* 1232 */       return false;
/*      */     }
/* 1234 */     onUserProfileActionStatus(18, paramInt, 2);
/*      */ 
/*      */     
/* 1237 */     VendorVehicleHalPAProto.CbPsetGidbindprofile cbPsetGidbindprofile = new VendorVehicleHalPAProto.CbPsetGidbindprofile();
/*      */     
/* 1239 */     cbPsetGidbindprofile.profilebindid = paramInt;
/* 1240 */     cbPsetGidbindprofile.profilegidconnect = 19;
/* 1241 */     cbPsetGidbindprofile.gidinfobyte0 = arrayOfInt[0];
/* 1242 */     cbPsetGidbindprofile.gidinfobyte1 = arrayOfInt[1];
/* 1243 */     cbPsetGidbindprofile.gidinfobyte2 = arrayOfInt[2];
/* 1244 */     cbPsetGidbindprofile.gidinfobyte3 = arrayOfInt[3];
/* 1245 */     cbPsetGidbindprofile.gidinfobyte4 = arrayOfInt[4];
/* 1246 */     cbPsetGidbindprofile.gidinfobyte5 = arrayOfInt[5];
/* 1247 */     cbPsetGidbindprofile.gidinfobyte6 = arrayOfInt[6];
/* 1248 */     cbPsetGidbindprofile.gidinfobyte7 = arrayOfInt[7];
/* 1249 */     cbPsetGidbindprofile.gidinfobyte8 = arrayOfInt[8];
/* 1250 */     cbPsetGidbindprofile.gidinfobyte9 = arrayOfInt[9];
/* 1251 */     cbPsetGidbindprofile.gidinfobyte10 = arrayOfInt[10];
/* 1252 */     cbPsetGidbindprofile.gidinfobyte11 = arrayOfInt[11];
/* 1253 */     cbPsetGidbindprofile.gidinfobyte12 = arrayOfInt[12];
/* 1254 */     cbPsetGidbindprofile.gidinfobyte13 = arrayOfInt[13];
/* 1255 */     cbPsetGidbindprofile.gidinfobyte14 = arrayOfInt[14];
/* 1256 */     cbPsetGidbindprofile.gidinfobyte15 = arrayOfInt[15];
/* 1257 */     this.mECarXCarProfileManager.CB_PSET_GIDBindProfile(cbPsetGidbindprofile);
/* 1258 */     return true;
/*      */   }
/*      */   
/*      */   private boolean unbindProfileAll() {
/* 1262 */     onUserProfileActionStatus(19, -1, 1);
/*      */ 
/*      */     
/* 1265 */     if (notAllow()) {
/* 1266 */       return false;
/*      */     }
/* 1268 */     onUserProfileActionStatus(19, -1, 2);
/*      */ 
/*      */     
/* 1271 */     VendorVehicleHalPAProto.CbPsetGidbindprofile cbPsetGidbindprofile = new VendorVehicleHalPAProto.CbPsetGidbindprofile();
/*      */     
/* 1273 */     cbPsetGidbindprofile.profilebindid = 0;
/* 1274 */     cbPsetGidbindprofile.profilegidconnect = 20;
/* 1275 */     cbPsetGidbindprofile.gidinfobyte0 = 0;
/* 1276 */     cbPsetGidbindprofile.gidinfobyte1 = 0;
/* 1277 */     cbPsetGidbindprofile.gidinfobyte2 = 0;
/* 1278 */     cbPsetGidbindprofile.gidinfobyte3 = 0;
/* 1279 */     cbPsetGidbindprofile.gidinfobyte4 = 0;
/* 1280 */     cbPsetGidbindprofile.gidinfobyte5 = 0;
/* 1281 */     cbPsetGidbindprofile.gidinfobyte6 = 0;
/* 1282 */     cbPsetGidbindprofile.gidinfobyte7 = 0;
/* 1283 */     cbPsetGidbindprofile.gidinfobyte8 = 0;
/* 1284 */     cbPsetGidbindprofile.gidinfobyte9 = 0;
/* 1285 */     cbPsetGidbindprofile.gidinfobyte10 = 0;
/* 1286 */     cbPsetGidbindprofile.gidinfobyte11 = 0;
/* 1287 */     cbPsetGidbindprofile.gidinfobyte12 = 0;
/* 1288 */     cbPsetGidbindprofile.gidinfobyte13 = 0;
/* 1289 */     cbPsetGidbindprofile.gidinfobyte14 = 0;
/* 1290 */     cbPsetGidbindprofile.gidinfobyte15 = 0;
/* 1291 */     this.mECarXCarProfileManager.CB_PSET_GIDBindProfile(cbPsetGidbindprofile);
/* 1292 */     return true;
/*      */   }
/*      */   
/*      */   private boolean bindFaceID(String paramString) {
/* 1296 */     boolean bool = true; onUserProfileActionStatus(33, -1, 1);
/*      */ 
/*      */     
/* 1299 */     if (paramString == null || TextUtils.isEmpty(paramString.trim()) || notAllow()) {
/* 1300 */       return false;
/*      */     }
/* 1302 */     int[] arrayOfInt = parseUID(paramString);
/* 1303 */     if (arrayOfInt == null) {
/* 1304 */       return false;
/*      */     }
/* 1306 */     onUserProfileActionStatus(33, -1, 2);
/*      */ 
/*      */     
/* 1309 */     VendorVehicleHalPAProto.ProtoFaceGid1 protoFaceGid1 = new VendorVehicleHalPAProto.ProtoFaceGid1();
/*      */     
/* 1311 */     protoFaceGid1.faceGid1Byte0 = arrayOfInt[0];
/* 1312 */     protoFaceGid1.faceGid1Byte1 = arrayOfInt[1];
/* 1313 */     protoFaceGid1.faceGid1Byte2 = arrayOfInt[2];
/* 1314 */     protoFaceGid1.faceGid1Byte3 = arrayOfInt[3];
/* 1315 */     protoFaceGid1.faceGid1Byte4 = arrayOfInt[4];
/* 1316 */     protoFaceGid1.faceGid1Byte5 = arrayOfInt[5];
/* 1317 */     protoFaceGid1.faceGid1Byte6 = arrayOfInt[6];
/* 1318 */     protoFaceGid1.faceGid1Byte7 = arrayOfInt[7];
/* 1319 */     VendorVehicleHalPAProto.ProtoFaceGid2 protoFaceGid2 = new VendorVehicleHalPAProto.ProtoFaceGid2();
/*      */     
/* 1321 */     protoFaceGid2.faceGid2Byte0 = arrayOfInt[8];
/* 1322 */     protoFaceGid2.faceGid2Byte1 = arrayOfInt[9];
/* 1323 */     protoFaceGid2.faceGid2Byte2 = arrayOfInt[10];
/* 1324 */     protoFaceGid2.faceGid2Byte3 = arrayOfInt[11];
/* 1325 */     protoFaceGid2.faceGid2Byte4 = arrayOfInt[12];
/* 1326 */     protoFaceGid2.faceGid2Byte5 = arrayOfInt[13];
/* 1327 */     protoFaceGid2.faceGid2Byte6 = arrayOfInt[14];
/* 1328 */     protoFaceGid2.faceGid2Byte7 = arrayOfInt[15];
/* 1329 */     ApiResult apiResult = this.vfcManager.CB_VFC_FaceIdnForHmiCen(1);
/* 1330 */     this.mCarSignalManager.setFaceGid1(protoFaceGid1);
/* 1331 */     this.mCarSignalManager.setFaceGid2(protoFaceGid2);
/* 1332 */     if (this.mHandler != null) {
/* 1333 */       this.mHandler.postDelayed(new Runnable() { final UserProfile this$0;
/*      */             
/*      */             public void run() {
/* 1336 */               UserProfile.this.mCarSignalManager.setFaceSgnInReq(0);
/*      */             }
/*      */           },  100L);
/*      */     }
/* 1340 */     if (apiResult != ApiResult.SUCCEED) bool = false;  return bool;
/*      */   }
/*      */   
/*      */   private boolean unbindFaceID(String paramString) {
/* 1344 */     boolean bool = true; onUserProfileActionStatus(34, -1, 1);
/*      */ 
/*      */     
/* 1347 */     if (paramString == null || TextUtils.isEmpty(paramString.trim()) || notAllow()) {
/* 1348 */       return false;
/*      */     }
/* 1350 */     int[] arrayOfInt = parseUID(paramString);
/* 1351 */     if (arrayOfInt == null) {
/* 1352 */       return false;
/*      */     }
/* 1354 */     onUserProfileActionStatus(34, -1, 2);
/*      */ 
/*      */     
/* 1357 */     VendorVehicleHalPAProto.ProtoCnclFaceReqGid1 protoCnclFaceReqGid1 = new VendorVehicleHalPAProto.ProtoCnclFaceReqGid1();
/*      */     
/* 1359 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte0 = arrayOfInt[0];
/* 1360 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte1 = arrayOfInt[1];
/* 1361 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte2 = arrayOfInt[2];
/* 1362 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte3 = arrayOfInt[3];
/* 1363 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte4 = arrayOfInt[4];
/* 1364 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte5 = arrayOfInt[5];
/* 1365 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte6 = arrayOfInt[6];
/* 1366 */     protoCnclFaceReqGid1.cnclFaceReqGid1Byte7 = arrayOfInt[7];
/* 1367 */     VendorVehicleHalPAProto.ProtoCnclFaceReqGid2 protoCnclFaceReqGid2 = new VendorVehicleHalPAProto.ProtoCnclFaceReqGid2();
/*      */     
/* 1369 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte0 = arrayOfInt[8];
/* 1370 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte1 = arrayOfInt[9];
/* 1371 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte2 = arrayOfInt[10];
/* 1372 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte3 = arrayOfInt[11];
/* 1373 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte4 = arrayOfInt[12];
/* 1374 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte5 = arrayOfInt[13];
/* 1375 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte6 = arrayOfInt[14];
/* 1376 */     protoCnclFaceReqGid2.cnclFaceReqGid2Byte7 = arrayOfInt[15];
/* 1377 */     ApiResult apiResult = this.vfcManager.CB_VFC_FaceIdnForHmiCen(1);
/* 1378 */     this.mCarSignalManager.setCnclFaceReqGid1(protoCnclFaceReqGid1);
/* 1379 */     this.mCarSignalManager.setCnclFaceReqGid2(protoCnclFaceReqGid2);
/* 1380 */     if (this.mHandler != null) {
/* 1381 */       this.mHandler.postDelayed(new Runnable() { final UserProfile this$0;
/*      */             
/*      */             public void run() {
/* 1384 */               UserProfile.this.mCarSignalManager.setCnclFaceReq(1);
/*      */             }
/*      */           },  100L);
/*      */     }
/*      */     
/* 1389 */     if (apiResult != ApiResult.SUCCEED) bool = false;  return bool;
/*      */   }
/*      */   
/*      */   private String createJsonKey(int paramInt1, int paramInt2) {
/* 1393 */     if (paramInt2 == Integer.MIN_VALUE) {
/* 1394 */       return String.valueOf(paramInt1);
/*      */     }
/* 1396 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramInt1); stringBuilder.append("|"); stringBuilder.append(paramInt2); return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setField(VendorVehicleHalPAProto.Profileclouddata paramProfileclouddata, String[] paramArrayOfString, long paramLong) {
/* 1402 */     byte b = 0; try { for (; b < paramArrayOfString.length; b++) {
/* 1403 */         int i = (paramArrayOfString.length - 1 - b) * 8;
/* 1404 */         i = (int)(((255 << i) & paramLong) >> i);
/* 1405 */         Field field = paramProfileclouddata.getClass().getDeclaredField(paramArrayOfString[b]);
/* 1406 */         field.setAccessible(true);
/* 1407 */         field.setInt(paramProfileclouddata, i);
/*      */       }
/*      */        }
/* 1410 */     catch (NoSuchFieldException|IllegalAccessException noSuchFieldException)
/* 1411 */     { noSuchFieldException.printStackTrace(); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onLoadAndStoreEveMemPosnAction(int paramInt) {
/* 1422 */     for (IUserProfile.IUserProfileObserver iUserProfileObserver : this.mObservers) {
/*      */       try {
/* 1424 */         iUserProfileObserver.onLoadAndStoreEveMemPosnAction(paramInt);
/* 1425 */       } catch (Exception exception) {
/* 1426 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onLoadAndStoreMemPosnAction(int paramInt) {
/* 1437 */     for (IUserProfile.IUserProfileObserver iUserProfileObserver : this.mObservers) {
/*      */       try {
/* 1439 */         iUserProfileObserver.onLoadAndStoreMemPosnAction(paramInt);
/* 1440 */       } catch (Exception exception) {
/* 1441 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onFaceDetectedAndRecognizedStatus(int paramInt) {
/* 1452 */     for (IUserProfile.IUserProfileObserver iUserProfileObserver : this.mObservers) {
/*      */       try {
/* 1454 */         iUserProfileObserver.onFaceDetectedAndRecognizedStatus(paramInt);
/* 1455 */       } catch (Exception exception) {
/* 1456 */         exception.printStackTrace();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   @Repeatable(ProfileFunctions.class)
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({ElementType.TYPE})
/*      */   public static @interface ProfileFunction {
/*      */     int customId() default 0;
/*      */     
/*      */     int id() default 0;
/*      */     
/*      */     String[] property();
/*      */     
/*      */     boolean support() default true;
/*      */     
/*      */     int zone() default -2147483648;
/*      */   }
/*      */   
/*      */   @Retention(RetentionPolicy.RUNTIME)
/*      */   @Target({ElementType.TYPE})
/*      */   public static @interface ProfileFunctions {
/*      */     UserProfile.ProfileFunction[] value();
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\UserProfile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */