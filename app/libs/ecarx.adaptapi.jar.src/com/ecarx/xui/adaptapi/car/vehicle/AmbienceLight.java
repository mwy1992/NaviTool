/*      */ package com.ecarx.xui.adaptapi.car.vehicle;
/*      */ 
/*      */ import android.content.Context;
/*      */ import android.util.Log;
/*      */ import com.ecarx.xui.adaptapi.FunctionStatus;
/*      */ import com.ecarx.xui.adaptapi.car.AbsCarFunction;
/*      */ import com.ecarx.xui.adaptapi.car.IVehicleFunction;
/*      */ import com.ecarx.xui.adaptapi.car.Pairs;
/*      */ import com.ecarx.xui.adaptapi.car.VehicleFunction;
/*      */ import com.ecarx.xui.adaptapi.car.VehicleType;
/*      */ import ecarx.car.hardware.annotation.ApiResult;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarAmbliManager;
/*      */ import ecarx.car.hardware.vehicle.ECarXCarSetManager;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Objects;
/*      */ import java.util.function.Function;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AmbienceLight
/*      */   extends AbsCarFunction
/*      */   implements IAmbienceLight
/*      */ {
/*   35 */   private static final int[] COMMON_ON_OFF = new int[] { 1, 0 }; private static final int DEFAULT = 0; private static final String TAG = "AmbienceLight2_API";
/*      */   private static final int[] ex11Value;
/*   37 */   private static final int[] kx11Value = new int[72]; private ECarXCarAmbliManager mAmbliManager; static {
/*   38 */     ex11Value = new int[64];
/*      */ 
/*      */     
/*   41 */     kx11Value[0] = 21759;
/*   42 */     kx11Value[1] = 1135615;
/*   43 */     kx11Value[2] = 4281087;
/*   44 */     kx11Value[3] = 5919231;
/*   45 */     kx11Value[4] = 7229695;
/*   46 */     kx11Value[5] = 8343295;
/*   47 */     kx11Value[6] = 9326079;
/*   48 */     kx11Value[7] = 10308863;
/*   49 */     kx11Value[8] = 11160319;
/*   50 */     kx11Value[9] = 12077311;
/*   51 */     kx11Value[10] = 12928767;
/*   52 */     kx11Value[11] = 13714687;
/*   53 */     kx11Value[12] = 15548159;
/*   54 */     kx11Value[13] = 16724980;
/*   55 */     kx11Value[14] = 16720859;
/*   56 */     kx11Value[15] = 16714692;
/*   57 */     kx11Value[16] = 16711856;
/*   58 */     kx11Value[17] = 16711836;
/*   59 */     kx11Value[18] = 16711818;
/*   60 */     kx11Value[19] = 16711799;
/*   61 */     kx11Value[20] = 16711779;
/*   62 */     kx11Value[21] = 16711757;
/*   63 */     kx11Value[22] = 16711729;
/*   64 */     kx11Value[23] = 16711680;
/*   65 */     kx11Value[24] = 16711680;
/*   66 */     kx11Value[25] = 16718848;
/*   67 */     kx11Value[26] = 16727552;
/*   68 */     kx11Value[27] = 16733440;
/*   69 */     kx11Value[28] = 16738560;
/*   70 */     kx11Value[29] = 16743680;
/*   71 */     kx11Value[30] = 16747776;
/*   72 */     kx11Value[31] = 16751365;
/*   73 */     kx11Value[32] = 16754698;
/*   74 */     kx11Value[33] = 16757775;
/*   75 */     kx11Value[34] = 16760851;
/*   76 */     kx11Value[35] = 16764183;
/*   77 */     kx11Value[36] = 16767515;
/*   78 */     kx11Value[37] = 16770846;
/*   79 */     kx11Value[38] = 16774178;
/*   80 */     kx11Value[39] = 16514853;
/*   81 */     kx11Value[40] = 15466278;
/*   82 */     kx11Value[41] = 14417703;
/*   83 */     kx11Value[42] = 13369128;
/*   84 */     kx11Value[43] = 12189481;
/*   85 */     kx11Value[44] = 10878762;
/*   86 */     kx11Value[45] = 9371434;
/*   87 */     kx11Value[46] = 7470891;
/*   88 */     kx11Value[47] = 4587308;
/*   89 */     kx11Value[48] = 65324;
/*   90 */     kx11Value[49] = 65325;
/*   91 */     kx11Value[50] = 65326;
/*   92 */     kx11Value[51] = 65326;
/*   93 */     kx11Value[52] = 65327;
/*   94 */     kx11Value[53] = 65382;
/*   95 */     kx11Value[54] = 65416;
/*   96 */     kx11Value[55] = 65444;
/*   97 */     kx11Value[56] = 65468;
/*   98 */     kx11Value[57] = 65492;
/*   99 */     kx11Value[58] = 65514;
/*  100 */     kx11Value[59] = 65279;
/*  101 */     kx11Value[60] = 60159;
/*  102 */     kx11Value[61] = 55551;
/*  103 */     kx11Value[62] = 51455;
/*  104 */     kx11Value[63] = 47871;
/*  105 */     kx11Value[64] = 44543;
/*  106 */     kx11Value[65] = 41471;
/*  107 */     kx11Value[66] = 38399;
/*  108 */     kx11Value[67] = 35583;
/*  109 */     kx11Value[68] = 32767;
/*  110 */     kx11Value[69] = 29951;
/*  111 */     kx11Value[70] = 27391;
/*  112 */     kx11Value[71] = 24575;
/*      */     
/*  114 */     ex11Value[0] = 3079941;
/*  115 */     ex11Value[1] = 3211026;
/*  116 */     ex11Value[2] = 3342113;
/*  117 */     ex11Value[3] = 3473203;
/*  118 */     ex11Value[4] = 3669832;
/*  119 */     ex11Value[5] = 3866465;
/*  120 */     ex11Value[6] = 4915144;
/*  121 */     ex11Value[7] = 5040639;
/*  122 */     ex11Value[8] = 16712193;
/*  123 */     ex11Value[9] = 16723714;
/*  124 */     ex11Value[10] = 16735491;
/*  125 */     ex11Value[11] = 16743683;
/*  126 */     ex11Value[12] = 16753668;
/*  127 */     ex11Value[13] = 15073029;
/*  128 */     ex11Value[14] = 7995141;
/*  129 */     ex11Value[15] = 5308165;
/*  130 */     ex11Value[16] = 10086911;
/*  131 */     ex11Value[17] = 16050687;
/*  132 */     ex11Value[18] = 16754872;
/*  133 */     ex11Value[19] = 16743302;
/*  134 */     ex11Value[20] = 16735332;
/*  135 */     ex11Value[21] = 16729419;
/*  136 */     ex11Value[22] = 16725562;
/*  137 */     ex11Value[23] = 16722732;
/*  138 */     ex11Value[24] = 16720160;
/*  139 */     ex11Value[25] = 16717589;
/*  140 */     ex11Value[26] = 16716045;
/*  141 */     ex11Value[27] = 16714502;
/*  142 */     ex11Value[28] = 5766932;
/*  143 */     ex11Value[29] = 6094630;
/*  144 */     ex11Value[30] = 6553402;
/*  145 */     ex11Value[31] = 7077716;
/*  146 */     ex11Value[32] = 7995255;
/*  147 */     ex11Value[33] = 8585114;
/*  148 */     ex11Value[34] = 9699278;
/*  149 */     ex11Value[35] = 16720652;
/*  150 */     ex11Value[36] = 16730636;
/*  151 */     ex11Value[37] = 16732181;
/*  152 */     ex11Value[38] = 16739345;
/*  153 */     ex11Value[39] = 16748819;
/*  154 */     ex11Value[40] = 16775703;
/*  155 */     ex11Value[41] = 8650518;
/*  156 */     ex11Value[42] = 14942152;
/*  157 */     ex11Value[43] = 16763802;
/*  158 */     ex11Value[44] = 16750703;
/*  159 */     ex11Value[45] = 16741713;
/*  160 */     ex11Value[46] = 16735036;
/*  161 */     ex11Value[47] = 16730155;
/*  162 */     ex11Value[48] = 16726303;
/*  163 */     ex11Value[49] = 16723220;
/*  164 */     ex11Value[50] = 10354499;
/*  165 */     ex11Value[51] = 13172624;
/*  166 */     ex11Value[52] = 16735519;
/*  167 */     ex11Value[53] = 16742185;
/*  168 */     ex11Value[54] = 12058417;
/*  169 */     ex11Value[55] = 16768115;
/*  170 */     ex11Value[56] = 16755026;
/*  171 */     ex11Value[57] = 16747579;
/*  172 */     ex11Value[58] = 16718339;
/*  173 */     ex11Value[59] = 4259727;
/*  174 */     ex11Value[60] = 16766981;
/*  175 */     ex11Value[61] = 10944262;
/*  176 */     ex11Value[62] = 14090019;
/*  177 */     ex11Value[63] = 16728581;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected AmbienceLight(Context paramContext) {
/*  183 */     super(paramContext, 704643072);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onCarSignalConnected(ECarXCarSetManager paramECarXCarSetManager) {
/*  188 */     this.mAmbliManager = paramECarXCarSetManager.getECarXCarAmbliManager();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void buildFunctions() {
/*  194 */     Pairs pairs1 = Pairs.of(Integer.valueOf(0), Integer.valueOf(0));
/*  195 */     Pairs pairs3 = pairs1.add(Integer.valueOf(1), Integer.valueOf(1));
/*  196 */     pairs1 = pairs3.reverse();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  208 */     IVehicleFunction iVehicleFunction13 = VehicleFunction.intFunction(537526784);
/*  209 */     IVehicleFunction.IZone iZone23 = iVehicleFunction13.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$AmbienceLight$uIkwFqvr0-txLFSjKF6cVahS8Yo -$$Lambda$AmbienceLight$uIkwFqvr0-txLFSjKF6cVahS8Yo = new -$$Lambda$AmbienceLight$uIkwFqvr0-txLFSjKF6cVahS8Yo(this);
/*  210 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild8 = iZone23.supportedFunctionValue(-$$Lambda$AmbienceLight$uIkwFqvr0-txLFSjKF6cVahS8Yo, new int[] { 33818, 33819, 33820, 33822, 33821 });
/*  211 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus15 = iStatusTaskBuild8.useStatusSignals(new int[] { 33818, 33951 }); -$$Lambda$AmbienceLight$QHjwKTURcbo7D-82oVKejfi9OGY -$$Lambda$AmbienceLight$QHjwKTURcbo7D-82oVKejfi9OGY = new -$$Lambda$AmbienceLight$QHjwKTURcbo7D-82oVKejfi9OGY(this);
/*      */     
/*  213 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild30 = iMultiSignalStatus15.onStatusSignalChanged(-$$Lambda$AmbienceLight$QHjwKTURcbo7D-82oVKejfi9OGY); -$$Lambda$AmbienceLight$dqyGUtbUgmcLaGoIlemqudxMDkI -$$Lambda$AmbienceLight$dqyGUtbUgmcLaGoIlemqudxMDkI = new -$$Lambda$AmbienceLight$dqyGUtbUgmcLaGoIlemqudxMDkI(this);
/*  214 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild27 = iValueTaskBuild30.onSetFunctionValue(-$$Lambda$AmbienceLight$dqyGUtbUgmcLaGoIlemqudxMDkI);
/*  215 */     IVehicleFunction.IMultiSignalValue iMultiSignalValue = iValueTaskBuild27.useValueSignals(new int[] { 33816 }); -$$Lambda$AmbienceLight$9jghElKQ4vwt-S-wHCOXfRyYNVA -$$Lambda$AmbienceLight$9jghElKQ4vwt-S-wHCOXfRyYNVA = new -$$Lambda$AmbienceLight$9jghElKQ4vwt-S-wHCOXfRyYNVA(this);
/*  216 */     IVehicleFunction.IFilterCallback iFilterCallback25 = iMultiSignalValue.onValueSignalChanged(-$$Lambda$AmbienceLight$9jghElKQ4vwt-S-wHCOXfRyYNVA); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ7 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*  217 */     iFilterCallback25.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  224 */     IVehicleFunction iVehicleFunction17 = VehicleFunction.intFunction(537527296); int[] arrayOfInt5 = COMMON_ON_OFF;
/*  225 */     IVehicleFunction iVehicleFunction12 = iVehicleFunction17.supportedFunctionValue(arrayOfInt5);
/*  226 */     IVehicleFunction.IZone iZone22 = iVehicleFunction12.createZone(new int[] { Integer.MIN_VALUE });
/*  227 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus24 = iZone22.useStatusSignals(new int[] { 33838, 33951 }); -$$Lambda$AmbienceLight$Ol5Ky5vTEYB1YnvVoAjm6XvSQKU -$$Lambda$AmbienceLight$Ol5Ky5vTEYB1YnvVoAjm6XvSQKU = new -$$Lambda$AmbienceLight$Ol5Ky5vTEYB1YnvVoAjm6XvSQKU(this);
/*      */     
/*  229 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild26 = iMultiSignalStatus24.onStatusSignalChanged(-$$Lambda$AmbienceLight$Ol5Ky5vTEYB1YnvVoAjm6XvSQKU); ECarXCarAmbliManager eCarXCarAmbliManager24 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager24); -$$Lambda$UM3p-pB6NUOXT68tXVR08L1Jr04 -$$Lambda$UM3p-pB6NUOXT68tXVR08L1Jr04 = new -$$Lambda$UM3p-pB6NUOXT68tXVR08L1Jr04(eCarXCarAmbliManager24);
/*  230 */     iValueTaskBuild26 = iValueTaskBuild26.onSetFunctionValue(-$$Lambda$UM3p-pB6NUOXT68tXVR08L1Jr04, pairs3);
/*      */     
/*  232 */     IVehicleFunction.IFilterCallback iFilterCallback17 = iValueTaskBuild26.useValuePAByIntBase(33838, pairs1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ13 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  234 */     iFilterCallback17.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ13);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  246 */     IVehicleFunction iVehicleFunction11 = VehicleFunction.intFunction(537528320); int[] arrayOfInt12 = COMMON_ON_OFF;
/*  247 */     iVehicleFunction11 = iVehicleFunction11.supportedFunctionValue(arrayOfInt12);
/*      */     
/*  249 */     IVehicleFunction.IZone iZone21 = iVehicleFunction11.createZone(new int[] { 537526528 });
/*  250 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus14 = iZone21.useStatusSignals(new int[] { 33826, 33951 }); -$$Lambda$AmbienceLight$HJF56RMrSG8xOuo3BWoKeNbUa_A -$$Lambda$AmbienceLight$HJF56RMrSG8xOuo3BWoKeNbUa_A = new -$$Lambda$AmbienceLight$HJF56RMrSG8xOuo3BWoKeNbUa_A(this);
/*      */     
/*  252 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild25 = iMultiSignalStatus14.onStatusSignalChanged(-$$Lambda$AmbienceLight$HJF56RMrSG8xOuo3BWoKeNbUa_A); ECarXCarAmbliManager eCarXCarAmbliManager23 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager23); -$$Lambda$11dcygQbdm-xobInEPZuXaTK--g -$$Lambda$11dcygQbdm-xobInEPZuXaTK--g = new -$$Lambda$11dcygQbdm-xobInEPZuXaTK--g(eCarXCarAmbliManager23);
/*  253 */     iValueTaskBuild25 = iValueTaskBuild25.onSetFunctionValue(-$$Lambda$11dcygQbdm-xobInEPZuXaTK--g, pairs3);
/*  254 */     IVehicleFunction.IFilterCallback iFilterCallback16 = iValueTaskBuild25.useValuePAByIntBase(33826, pairs1);
/*      */ 
/*      */     
/*  257 */     IVehicleFunction.IZone iZone20 = iFilterCallback16.createZone(new int[] { 537526529 });
/*  258 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus13 = iZone20.useStatusSignals(new int[] { 33829, 33951 }); -$$Lambda$AmbienceLight$A-LVqEjGDGHaVUiL1I1PxBepLDE -$$Lambda$AmbienceLight$A-LVqEjGDGHaVUiL1I1PxBepLDE = new -$$Lambda$AmbienceLight$A-LVqEjGDGHaVUiL1I1PxBepLDE(this);
/*      */     
/*  260 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild24 = iMultiSignalStatus13.onStatusSignalChanged(-$$Lambda$AmbienceLight$A-LVqEjGDGHaVUiL1I1PxBepLDE); ECarXCarAmbliManager eCarXCarAmbliManager22 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager22); -$$Lambda$5WaweAyBde0eAqXr0N5B0Cx3fKQ -$$Lambda$5WaweAyBde0eAqXr0N5B0Cx3fKQ = new -$$Lambda$5WaweAyBde0eAqXr0N5B0Cx3fKQ(eCarXCarAmbliManager22);
/*  261 */     iValueTaskBuild24 = iValueTaskBuild24.onSetFunctionValue(-$$Lambda$5WaweAyBde0eAqXr0N5B0Cx3fKQ, pairs3);
/*  262 */     IVehicleFunction.IFilterCallback iFilterCallback15 = iValueTaskBuild24.useValuePAByIntBase(33829, pairs1);
/*      */ 
/*      */     
/*  265 */     IVehicleFunction.IZone iZone19 = iFilterCallback15.createZone(new int[] { 537526530 });
/*  266 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus23 = iZone19.useStatusSignals(new int[] { 33832, 33951 }); -$$Lambda$AmbienceLight$piCYCMldmSDJiEYFYV9RRYNGrIQ -$$Lambda$AmbienceLight$piCYCMldmSDJiEYFYV9RRYNGrIQ = new -$$Lambda$AmbienceLight$piCYCMldmSDJiEYFYV9RRYNGrIQ(this);
/*      */     
/*  268 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild23 = iMultiSignalStatus23.onStatusSignalChanged(-$$Lambda$AmbienceLight$piCYCMldmSDJiEYFYV9RRYNGrIQ); ECarXCarAmbliManager eCarXCarAmbliManager21 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager21); -$$Lambda$Yq00IruaOcQHRvSo9S4E6hrjcHk -$$Lambda$Yq00IruaOcQHRvSo9S4E6hrjcHk = new -$$Lambda$Yq00IruaOcQHRvSo9S4E6hrjcHk(eCarXCarAmbliManager21);
/*  269 */     iValueTaskBuild23 = iValueTaskBuild23.onSetFunctionValue(-$$Lambda$Yq00IruaOcQHRvSo9S4E6hrjcHk, pairs3);
/*  270 */     IVehicleFunction.IFilterCallback iFilterCallback14 = iValueTaskBuild23.useValuePAByIntBase(33832, pairs1);
/*      */ 
/*      */     
/*  273 */     IVehicleFunction.IZone iZone18 = iFilterCallback14.createZone(new int[] { 537526531 });
/*  274 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus12 = iZone18.useStatusSignals(new int[] { 33835, 33951 }); -$$Lambda$AmbienceLight$hwdwUSrGxJD3EirVYP9xkhvw2Ck -$$Lambda$AmbienceLight$hwdwUSrGxJD3EirVYP9xkhvw2Ck = new -$$Lambda$AmbienceLight$hwdwUSrGxJD3EirVYP9xkhvw2Ck(this);
/*      */     
/*  276 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild22 = iMultiSignalStatus12.onStatusSignalChanged(-$$Lambda$AmbienceLight$hwdwUSrGxJD3EirVYP9xkhvw2Ck); ECarXCarAmbliManager eCarXCarAmbliManager20 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager20); -$$Lambda$INdJORlTobJe_PL5TtLbPMdfEx0 -$$Lambda$INdJORlTobJe_PL5TtLbPMdfEx0 = new -$$Lambda$INdJORlTobJe_PL5TtLbPMdfEx0(eCarXCarAmbliManager20);
/*  277 */     iValueTaskBuild22 = iValueTaskBuild22.onSetFunctionValue(-$$Lambda$INdJORlTobJe_PL5TtLbPMdfEx0, pairs3);
/*  278 */     IVehicleFunction.IFilterCallback iFilterCallback13 = iValueTaskBuild22.useValuePAByIntBase(33835, pairs1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ12 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  280 */     iFilterCallback13.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ12);
/*      */ 
/*      */     
/*  283 */     IVehicleFunction iVehicleFunction10 = VehicleFunction.intFunction(537528576); VehicleType vehicleType10 = VehicleType.KX11;
/*      */     
/*  285 */     IVehicleFunction.IZone iZone17 = iVehicleFunction10.createZone(vehicleType10, new int[] { Integer.MIN_VALUE }); int[] arrayOfInt11 = kx11Value;
/*  286 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild7 = iZone17.supportedFunctionValue(arrayOfInt11);
/*  287 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus11 = iStatusTaskBuild7.useStatusSignals(new int[] { 33831, 33951 }); -$$Lambda$AmbienceLight$PtBdaSWl3NmLdJHbtk9R_OdjaDU -$$Lambda$AmbienceLight$PtBdaSWl3NmLdJHbtk9R_OdjaDU = new -$$Lambda$AmbienceLight$PtBdaSWl3NmLdJHbtk9R_OdjaDU(this);
/*      */     
/*  289 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild21 = iMultiSignalStatus11.onStatusSignalChanged(-$$Lambda$AmbienceLight$PtBdaSWl3NmLdJHbtk9R_OdjaDU); ECarXCarAmbliManager eCarXCarAmbliManager19 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager19); -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc3 = new -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc(eCarXCarAmbliManager19);
/*  290 */     iValueTaskBuild21 = iValueTaskBuild21.onSetFunctionValue(-$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc3); -$$Lambda$AmbienceLight$1Cd2702BIa2yyL9eo6Z3xRL2gnc -$$Lambda$AmbienceLight$1Cd2702BIa2yyL9eo6Z3xRL2gnc = -$$Lambda$AmbienceLight$1Cd2702BIa2yyL9eo6Z3xRL2gnc.INSTANCE;
/*  291 */     IVehicleFunction.IFilterCallback iFilterCallback12 = iValueTaskBuild21.useValuePAByIntBase(33831, -$$Lambda$AmbienceLight$1Cd2702BIa2yyL9eo6Z3xRL2gnc); VehicleType vehicleType9 = VehicleType.EX11;
/*      */ 
/*      */     
/*  294 */     IVehicleFunction.IZone iZone25 = iFilterCallback12.createZone(vehicleType9, new int[] { 537526528 }); int[] arrayOfInt4 = ex11Value;
/*  295 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild6 = iZone25.supportedFunctionValue(arrayOfInt4);
/*  296 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus22 = iStatusTaskBuild6.useStatusSignals(new int[] { 33828, 33951 }); -$$Lambda$AmbienceLight$petRPy58_FVLoyxiqdc2gisbsRQ -$$Lambda$AmbienceLight$petRPy58_FVLoyxiqdc2gisbsRQ = new -$$Lambda$AmbienceLight$petRPy58_FVLoyxiqdc2gisbsRQ(this);
/*      */     
/*  298 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild20 = iMultiSignalStatus22.onStatusSignalChanged(-$$Lambda$AmbienceLight$petRPy58_FVLoyxiqdc2gisbsRQ); ECarXCarAmbliManager eCarXCarAmbliManager18 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager18); -$$Lambda$phgaY7ZLnzNw7ucTQjVdhW9NOSg -$$Lambda$phgaY7ZLnzNw7ucTQjVdhW9NOSg = new -$$Lambda$phgaY7ZLnzNw7ucTQjVdhW9NOSg(eCarXCarAmbliManager18);
/*  299 */     iValueTaskBuild20 = iValueTaskBuild20.onSetFunctionValue(-$$Lambda$phgaY7ZLnzNw7ucTQjVdhW9NOSg); -$$Lambda$AmbienceLight$6lsfMskjU2A22UwlMymLFATgx0o -$$Lambda$AmbienceLight$6lsfMskjU2A22UwlMymLFATgx0o = -$$Lambda$AmbienceLight$6lsfMskjU2A22UwlMymLFATgx0o.INSTANCE;
/*  300 */     IVehicleFunction.IFilterCallback iFilterCallback24 = iValueTaskBuild20.useValuePAByIntBase(33828, -$$Lambda$AmbienceLight$6lsfMskjU2A22UwlMymLFATgx0o); VehicleType vehicleType6 = VehicleType.EX11;
/*      */ 
/*      */     
/*  303 */     IVehicleFunction.IZone iZone24 = iFilterCallback24.createZone(vehicleType6, new int[] { 537526529 }); int[] arrayOfInt3 = ex11Value;
/*  304 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild5 = iZone24.supportedFunctionValue(arrayOfInt3);
/*  305 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus21 = iStatusTaskBuild5.useStatusSignals(new int[] { 33831, 33951 }); -$$Lambda$AmbienceLight$ywjiZ9YEqBP0fvjBz-If6QTibRc -$$Lambda$AmbienceLight$ywjiZ9YEqBP0fvjBz-If6QTibRc = new -$$Lambda$AmbienceLight$ywjiZ9YEqBP0fvjBz-If6QTibRc(this);
/*      */     
/*  307 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild19 = iMultiSignalStatus21.onStatusSignalChanged(-$$Lambda$AmbienceLight$ywjiZ9YEqBP0fvjBz-If6QTibRc); ECarXCarAmbliManager eCarXCarAmbliManager17 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager17); -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc2 = new -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc(eCarXCarAmbliManager17);
/*  308 */     iValueTaskBuild19 = iValueTaskBuild19.onSetFunctionValue(-$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc2); -$$Lambda$AmbienceLight$2N6Aql1gS-ZGqiUvEOlHoG_2RvM -$$Lambda$AmbienceLight$2N6Aql1gS-ZGqiUvEOlHoG_2RvM = -$$Lambda$AmbienceLight$2N6Aql1gS-ZGqiUvEOlHoG_2RvM.INSTANCE;
/*  309 */     IVehicleFunction.IFilterCallback iFilterCallback11 = iValueTaskBuild19.useValuePAByIntBase(33831, -$$Lambda$AmbienceLight$2N6Aql1gS-ZGqiUvEOlHoG_2RvM); VehicleType vehicleType8 = VehicleType.EX11;
/*      */ 
/*      */     
/*  312 */     IVehicleFunction.IZone iZone16 = iFilterCallback11.createZone(vehicleType8, new int[] { 537526530 }); int[] arrayOfInt10 = ex11Value;
/*  313 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild4 = iZone16.supportedFunctionValue(arrayOfInt10);
/*  314 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus20 = iStatusTaskBuild4.useStatusSignals(new int[] { 33834, 33951 }); -$$Lambda$AmbienceLight$Vd38MNG6QraU-jeeiEgbCKl0tNI -$$Lambda$AmbienceLight$Vd38MNG6QraU-jeeiEgbCKl0tNI = new -$$Lambda$AmbienceLight$Vd38MNG6QraU-jeeiEgbCKl0tNI(this);
/*      */     
/*  316 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild18 = iMultiSignalStatus20.onStatusSignalChanged(-$$Lambda$AmbienceLight$Vd38MNG6QraU-jeeiEgbCKl0tNI); ECarXCarAmbliManager eCarXCarAmbliManager16 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager16); -$$Lambda$6YJssBKGeAYqry95ObM2B5_16z4 -$$Lambda$6YJssBKGeAYqry95ObM2B5_16z4 = new -$$Lambda$6YJssBKGeAYqry95ObM2B5_16z4(eCarXCarAmbliManager16);
/*  317 */     iValueTaskBuild18 = iValueTaskBuild18.onSetFunctionValue(-$$Lambda$6YJssBKGeAYqry95ObM2B5_16z4); -$$Lambda$AmbienceLight$pzsaZr-ZVt0k_bW6MwJ8vCiYQe8 -$$Lambda$AmbienceLight$pzsaZr-ZVt0k_bW6MwJ8vCiYQe8 = -$$Lambda$AmbienceLight$pzsaZr-ZVt0k_bW6MwJ8vCiYQe8.INSTANCE;
/*  318 */     IVehicleFunction.IFilterCallback iFilterCallback23 = iValueTaskBuild18.useValuePAByIntBase(33834, -$$Lambda$AmbienceLight$pzsaZr-ZVt0k_bW6MwJ8vCiYQe8); VehicleType vehicleType5 = VehicleType.EX11;
/*      */ 
/*      */     
/*  321 */     IVehicleFunction.IZone iZone15 = iFilterCallback23.createZone(vehicleType5, new int[] { 537526531 }); int[] arrayOfInt9 = ex11Value;
/*  322 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild3 = iZone15.supportedFunctionValue(arrayOfInt9);
/*  323 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus19 = iStatusTaskBuild3.useStatusSignals(new int[] { 33837, 33951 }); -$$Lambda$AmbienceLight$Uy4Ebtnit7ByiuOq0_OoC0idAUM -$$Lambda$AmbienceLight$Uy4Ebtnit7ByiuOq0_OoC0idAUM = new -$$Lambda$AmbienceLight$Uy4Ebtnit7ByiuOq0_OoC0idAUM(this);
/*      */     
/*  325 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild17 = iMultiSignalStatus19.onStatusSignalChanged(-$$Lambda$AmbienceLight$Uy4Ebtnit7ByiuOq0_OoC0idAUM); ECarXCarAmbliManager eCarXCarAmbliManager15 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager15); -$$Lambda$HbcFvH58Z8F2i-D4WJlb1NhqaAs -$$Lambda$HbcFvH58Z8F2i-D4WJlb1NhqaAs = new -$$Lambda$HbcFvH58Z8F2i-D4WJlb1NhqaAs(eCarXCarAmbliManager15);
/*  326 */     iValueTaskBuild17 = iValueTaskBuild17.onSetFunctionValue(-$$Lambda$HbcFvH58Z8F2i-D4WJlb1NhqaAs); -$$Lambda$AmbienceLight$w4HgLbIt7n-_eDdYrAncWmZncws -$$Lambda$AmbienceLight$w4HgLbIt7n-_eDdYrAncWmZncws = -$$Lambda$AmbienceLight$w4HgLbIt7n-_eDdYrAncWmZncws.INSTANCE;
/*  327 */     IVehicleFunction.IFilterCallback iFilterCallback10 = iValueTaskBuild17.useValuePAByIntBase(33837, -$$Lambda$AmbienceLight$w4HgLbIt7n-_eDdYrAncWmZncws); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ11 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  329 */     iFilterCallback10.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ11);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  368 */     IVehicleFunction iVehicleFunction9 = VehicleFunction.intFunction(537529088);
/*  369 */     iVehicleFunction9 = iVehicleFunction9.supportedFunctionValue(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33 });
/*  370 */     IVehicleFunction.IZone iZone14 = iVehicleFunction9.createZone(new int[] { Integer.MIN_VALUE });
/*  371 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild16 = iZone14.useStatusPAByIntBase(33847); ECarXCarAmbliManager eCarXCarAmbliManager14 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager14); -$$Lambda$noZ-TDYYQ2W9GbyuiWxzdAwjAYE -$$Lambda$noZ-TDYYQ2W9GbyuiWxzdAwjAYE = new -$$Lambda$noZ-TDYYQ2W9GbyuiWxzdAwjAYE(eCarXCarAmbliManager14);
/*  372 */     iValueTaskBuild16 = iValueTaskBuild16.onSetFunctionValue(-$$Lambda$noZ-TDYYQ2W9GbyuiWxzdAwjAYE); -$$Lambda$AmbienceLight$jiX6w6UKYFeddRYPEgfrePYhh0I -$$Lambda$AmbienceLight$jiX6w6UKYFeddRYPEgfrePYhh0I = -$$Lambda$AmbienceLight$jiX6w6UKYFeddRYPEgfrePYhh0I.INSTANCE;
/*  373 */     IVehicleFunction.IFilterCallback iFilterCallback22 = iValueTaskBuild16.useValuePAByIntBase(33847, -$$Lambda$AmbienceLight$jiX6w6UKYFeddRYPEgfrePYhh0I); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ6 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  375 */     iFilterCallback22.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ6);
/*      */ 
/*      */     
/*  378 */     IVehicleFunction iVehicleFunction16 = VehicleFunction.customFunction(704708864); VehicleType vehicleType4 = VehicleType.KX11;
/*  379 */     IVehicleFunction.IZone iZone13 = iVehicleFunction16.createZone(vehicleType4, new int[] { Integer.MIN_VALUE });
/*  380 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus10 = iZone13.useStatusSignals(new int[] { 33830, 33951 }); -$$Lambda$AmbienceLight$3po5dJmog37rs64ytf8ag-Vsbbs -$$Lambda$AmbienceLight$3po5dJmog37rs64ytf8ag-Vsbbs = new -$$Lambda$AmbienceLight$3po5dJmog37rs64ytf8ag-Vsbbs(this);
/*      */     
/*  382 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild15 = iMultiSignalStatus10.onStatusSignalChanged(-$$Lambda$AmbienceLight$3po5dJmog37rs64ytf8ag-Vsbbs); ECarXCarAmbliManager eCarXCarAmbliManager13 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager13); -$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE -$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE2 = new -$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE(eCarXCarAmbliManager13); -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU3 = -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*  383 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild29 = iValueTaskBuild15.onSetFunctionValue(-$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE2, -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU3); -$$Lambda$AmbienceLight$Rhyw0XX-EW2L7oQsQLkPBCQOPMA -$$Lambda$AmbienceLight$Rhyw0XX-EW2L7oQsQLkPBCQOPMA = -$$Lambda$AmbienceLight$Rhyw0XX-EW2L7oQsQLkPBCQOPMA.INSTANCE;
/*  384 */     IVehicleFunction.IFilterCallback iFilterCallback21 = iValueTaskBuild29.useValuePAByIntBase(33830, -$$Lambda$AmbienceLight$Rhyw0XX-EW2L7oQsQLkPBCQOPMA); VehicleType vehicleType3 = VehicleType.EX11;
/*      */ 
/*      */     
/*  387 */     IVehicleFunction.IZone iZone12 = iFilterCallback21.createZone(vehicleType3, new int[] { 537526528 });
/*  388 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus9 = iZone12.useStatusSignals(new int[] { 33827, 33951 }); -$$Lambda$AmbienceLight$3wK9f3PNiZmENgro0m40CjpJ4Gw -$$Lambda$AmbienceLight$3wK9f3PNiZmENgro0m40CjpJ4Gw = new -$$Lambda$AmbienceLight$3wK9f3PNiZmENgro0m40CjpJ4Gw(this);
/*      */     
/*  390 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild14 = iMultiSignalStatus9.onStatusSignalChanged(-$$Lambda$AmbienceLight$3wK9f3PNiZmENgro0m40CjpJ4Gw); ECarXCarAmbliManager eCarXCarAmbliManager12 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager12); -$$Lambda$5vA-X0uoT7tuKuDZ0cyTtPY8xe4 -$$Lambda$5vA-X0uoT7tuKuDZ0cyTtPY8xe4 = new -$$Lambda$5vA-X0uoT7tuKuDZ0cyTtPY8xe4(eCarXCarAmbliManager12); -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU5 = -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*  391 */     iValueTaskBuild14 = iValueTaskBuild14.onSetFunctionValue(-$$Lambda$5vA-X0uoT7tuKuDZ0cyTtPY8xe4, -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU5); -$$Lambda$AmbienceLight$glPkhQ_Y24U0n97mR3ZNh2nqsYo -$$Lambda$AmbienceLight$glPkhQ_Y24U0n97mR3ZNh2nqsYo = -$$Lambda$AmbienceLight$glPkhQ_Y24U0n97mR3ZNh2nqsYo.INSTANCE;
/*  392 */     IVehicleFunction.IFilterCallback iFilterCallback20 = iValueTaskBuild14.useValuePAByIntBase(33827, -$$Lambda$AmbienceLight$glPkhQ_Y24U0n97mR3ZNh2nqsYo); VehicleType vehicleType2 = VehicleType.EX11;
/*      */ 
/*      */     
/*  395 */     IVehicleFunction.IZone iZone11 = iFilterCallback20.createZone(vehicleType2, new int[] { 537526529 });
/*  396 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus8 = iZone11.useStatusSignals(new int[] { 33830, 33951 }); -$$Lambda$AmbienceLight$163jsd8_hzq8U2g0Om4msSQPyBI -$$Lambda$AmbienceLight$163jsd8_hzq8U2g0Om4msSQPyBI = new -$$Lambda$AmbienceLight$163jsd8_hzq8U2g0Om4msSQPyBI(this);
/*      */     
/*  398 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild13 = iMultiSignalStatus8.onStatusSignalChanged(-$$Lambda$AmbienceLight$163jsd8_hzq8U2g0Om4msSQPyBI); ECarXCarAmbliManager eCarXCarAmbliManager11 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager11); -$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE -$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE1 = new -$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE(eCarXCarAmbliManager11); -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU2 = -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*  399 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild28 = iValueTaskBuild13.onSetFunctionValue(-$$Lambda$wKDRh2oiqczczKO-oZnm7y8MSIE1, -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU2); -$$Lambda$AmbienceLight$77ut38mJszyZtLzwppwUB2rPzVE -$$Lambda$AmbienceLight$77ut38mJszyZtLzwppwUB2rPzVE = -$$Lambda$AmbienceLight$77ut38mJszyZtLzwppwUB2rPzVE.INSTANCE;
/*  400 */     IVehicleFunction.IFilterCallback iFilterCallback19 = iValueTaskBuild28.useValuePAByIntBase(33830, -$$Lambda$AmbienceLight$77ut38mJszyZtLzwppwUB2rPzVE); VehicleType vehicleType1 = VehicleType.EX11;
/*      */ 
/*      */     
/*  403 */     IVehicleFunction.IZone iZone10 = iFilterCallback19.createZone(vehicleType1, new int[] { 537526530 });
/*  404 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus7 = iZone10.useStatusSignals(new int[] { 33833, 33951 }); -$$Lambda$AmbienceLight$AAGZvJZ-GF1HePd4x2q-NtFAH4Q -$$Lambda$AmbienceLight$AAGZvJZ-GF1HePd4x2q-NtFAH4Q = new -$$Lambda$AmbienceLight$AAGZvJZ-GF1HePd4x2q-NtFAH4Q(this);
/*      */     
/*  406 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild12 = iMultiSignalStatus7.onStatusSignalChanged(-$$Lambda$AmbienceLight$AAGZvJZ-GF1HePd4x2q-NtFAH4Q); ECarXCarAmbliManager eCarXCarAmbliManager10 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager10); -$$Lambda$M77vGKA229fzmur4wiULFioxC-c -$$Lambda$M77vGKA229fzmur4wiULFioxC-c = new -$$Lambda$M77vGKA229fzmur4wiULFioxC-c(eCarXCarAmbliManager10); -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU4 = -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*  407 */     iValueTaskBuild12 = iValueTaskBuild12.onSetFunctionValue(-$$Lambda$M77vGKA229fzmur4wiULFioxC-c, -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU4); -$$Lambda$AmbienceLight$XT-Dpq681LXzttoHyl8IcfckEmU -$$Lambda$AmbienceLight$XT-Dpq681LXzttoHyl8IcfckEmU = -$$Lambda$AmbienceLight$XT-Dpq681LXzttoHyl8IcfckEmU.INSTANCE;
/*  408 */     IVehicleFunction.IFilterCallback iFilterCallback9 = iValueTaskBuild12.useValuePAByIntBase(33833, -$$Lambda$AmbienceLight$XT-Dpq681LXzttoHyl8IcfckEmU); VehicleType vehicleType7 = VehicleType.EX11;
/*      */ 
/*      */     
/*  411 */     IVehicleFunction.IZone iZone9 = iFilterCallback9.createZone(vehicleType7, new int[] { 537526531 });
/*  412 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus18 = iZone9.useStatusSignals(new int[] { 33836, 33951 }); -$$Lambda$AmbienceLight$MSjfUQBprAvvpw7914MViRuVftk -$$Lambda$AmbienceLight$MSjfUQBprAvvpw7914MViRuVftk = new -$$Lambda$AmbienceLight$MSjfUQBprAvvpw7914MViRuVftk(this);
/*      */     
/*  414 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild11 = iMultiSignalStatus18.onStatusSignalChanged(-$$Lambda$AmbienceLight$MSjfUQBprAvvpw7914MViRuVftk); ECarXCarAmbliManager eCarXCarAmbliManager9 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager9); -$$Lambda$leigO1MM5-3_sGOtzcxhWGH88zU -$$Lambda$leigO1MM5-3_sGOtzcxhWGH88zU = new -$$Lambda$leigO1MM5-3_sGOtzcxhWGH88zU(eCarXCarAmbliManager9); -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU1 = -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU.INSTANCE;
/*  415 */     iValueTaskBuild11 = iValueTaskBuild11.onSetFunctionValue(-$$Lambda$leigO1MM5-3_sGOtzcxhWGH88zU, -$$Lambda$AmbienceLight$Cdx7vHInof1EQrtz2WxT4MQ7JiU1); -$$Lambda$AmbienceLight$viTCSWMFQjJvU_j7heY9d5rbrFI -$$Lambda$AmbienceLight$viTCSWMFQjJvU_j7heY9d5rbrFI = -$$Lambda$AmbienceLight$viTCSWMFQjJvU_j7heY9d5rbrFI.INSTANCE;
/*  416 */     IVehicleFunction.IFilterCallback iFilterCallback8 = iValueTaskBuild11.useValuePAByIntBase(33836, -$$Lambda$AmbienceLight$viTCSWMFQjJvU_j7heY9d5rbrFI); -$$Lambda$AmbienceLight$YjNVoI3lZew1TcYGEGgXrF4vvDo -$$Lambda$AmbienceLight$YjNVoI3lZew1TcYGEGgXrF4vvDo = new -$$Lambda$AmbienceLight$YjNVoI3lZew1TcYGEGgXrF4vvDo(this);
/*      */ 
/*      */ 
/*      */     
/*  420 */     iFilterCallback8.addTo(-$$Lambda$AmbienceLight$YjNVoI3lZew1TcYGEGgXrF4vvDo);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  426 */     IVehicleFunction iVehicleFunction8 = VehicleFunction.intFunction(704709376); int[] arrayOfInt8 = kx11Value;
/*  427 */     iVehicleFunction8 = iVehicleFunction8.supportedFunctionValue(arrayOfInt8);
/*  428 */     IVehicleFunction.IZone iZone8 = iVehicleFunction8.createZone(new int[] { Integer.MIN_VALUE });
/*  429 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus6 = iZone8.useStatusSignals(new int[] { 33831, 33951 }); -$$Lambda$AmbienceLight$qD3TVzNlIbpgDx0-ijhrzWDGd1M -$$Lambda$AmbienceLight$qD3TVzNlIbpgDx0-ijhrzWDGd1M = new -$$Lambda$AmbienceLight$qD3TVzNlIbpgDx0-ijhrzWDGd1M(this);
/*      */     
/*  431 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild10 = iMultiSignalStatus6.onStatusSignalChanged(-$$Lambda$AmbienceLight$qD3TVzNlIbpgDx0-ijhrzWDGd1M); ECarXCarAmbliManager eCarXCarAmbliManager8 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager8); -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc1 = new -$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc(eCarXCarAmbliManager8);
/*  432 */     iValueTaskBuild10 = iValueTaskBuild10.onSetFunctionValue(-$$Lambda$uvD5P9Z74il3h2qHzuSNfRg1PPc1); -$$Lambda$AmbienceLight$tIA2oU06LCOqvzpF65Z2-wvSmvU -$$Lambda$AmbienceLight$tIA2oU06LCOqvzpF65Z2-wvSmvU = -$$Lambda$AmbienceLight$tIA2oU06LCOqvzpF65Z2-wvSmvU.INSTANCE;
/*  433 */     IVehicleFunction.IFilterCallback iFilterCallback7 = iValueTaskBuild10.useValuePAByIntBase(33831, -$$Lambda$AmbienceLight$tIA2oU06LCOqvzpF65Z2-wvSmvU); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ10 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  435 */     iFilterCallback7.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ10);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  459 */     IVehicleFunction iVehicleFunction15 = VehicleFunction.intFunction(704971008); int[] arrayOfInt2 = COMMON_ON_OFF;
/*  460 */     IVehicleFunction iVehicleFunction7 = iVehicleFunction15.supportedFunctionValue(arrayOfInt2);
/*  461 */     IVehicleFunction.IZone iZone7 = iVehicleFunction7.createZone(new int[] { Integer.MIN_VALUE });
/*  462 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus17 = iZone7.useStatusSignals(new int[] { 33849, 33951 }); -$$Lambda$AmbienceLight$vxL0NKxOEdqZjWcY22gqBLV0zJ0 -$$Lambda$AmbienceLight$vxL0NKxOEdqZjWcY22gqBLV0zJ0 = new -$$Lambda$AmbienceLight$vxL0NKxOEdqZjWcY22gqBLV0zJ0(this);
/*      */     
/*  464 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild9 = iMultiSignalStatus17.onStatusSignalChanged(-$$Lambda$AmbienceLight$vxL0NKxOEdqZjWcY22gqBLV0zJ0); ECarXCarAmbliManager eCarXCarAmbliManager7 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager7); -$$Lambda$mMt0Zx867fb0jvboybpAt47mnJs -$$Lambda$mMt0Zx867fb0jvboybpAt47mnJs = new -$$Lambda$mMt0Zx867fb0jvboybpAt47mnJs(eCarXCarAmbliManager7);
/*  465 */     iValueTaskBuild9 = iValueTaskBuild9.onSetFunctionValue(-$$Lambda$mMt0Zx867fb0jvboybpAt47mnJs, pairs3);
/*  466 */     IVehicleFunction.IFilterCallback iFilterCallback6 = iValueTaskBuild9.useValuePAByIntBase(33849, pairs1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ9 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  468 */     iFilterCallback6.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ9);
/*      */ 
/*      */     
/*  471 */     IVehicleFunction iVehicleFunction6 = VehicleFunction.intFunction(704971264); int[] arrayOfInt7 = COMMON_ON_OFF;
/*  472 */     iVehicleFunction6 = iVehicleFunction6.supportedFunctionValue(arrayOfInt7);
/*  473 */     IVehicleFunction.IZone iZone6 = iVehicleFunction6.createZone(new int[] { Integer.MIN_VALUE });
/*  474 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus16 = iZone6.useStatusSignals(new int[] { 33850, 33951 }); -$$Lambda$AmbienceLight$Q733KsPVDWyGdFDbhDzLe3wg9_A -$$Lambda$AmbienceLight$Q733KsPVDWyGdFDbhDzLe3wg9_A = new -$$Lambda$AmbienceLight$Q733KsPVDWyGdFDbhDzLe3wg9_A(this);
/*      */     
/*  476 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild8 = iMultiSignalStatus16.onStatusSignalChanged(-$$Lambda$AmbienceLight$Q733KsPVDWyGdFDbhDzLe3wg9_A); ECarXCarAmbliManager eCarXCarAmbliManager6 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager6); -$$Lambda$g6iqWXHutVMJFSZDQErN0MVX4ig -$$Lambda$g6iqWXHutVMJFSZDQErN0MVX4ig = new -$$Lambda$g6iqWXHutVMJFSZDQErN0MVX4ig(eCarXCarAmbliManager6);
/*  477 */     iValueTaskBuild8 = iValueTaskBuild8.onSetFunctionValue(-$$Lambda$g6iqWXHutVMJFSZDQErN0MVX4ig, pairs3);
/*  478 */     IVehicleFunction.IFilterCallback iFilterCallback5 = iValueTaskBuild8.useValuePAByIntBase(33850, pairs1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ8 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  480 */     iFilterCallback5.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ8);
/*      */ 
/*      */     
/*  483 */     IVehicleFunction iVehicleFunction14 = VehicleFunction.intFunction(704971520); int[] arrayOfInt1 = COMMON_ON_OFF;
/*  484 */     IVehicleFunction iVehicleFunction5 = iVehicleFunction14.supportedFunctionValue(arrayOfInt1);
/*  485 */     IVehicleFunction.IZone iZone5 = iVehicleFunction5.createZone(new int[] { Integer.MIN_VALUE });
/*  486 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus5 = iZone5.useStatusSignals(new int[] { 33839, 33951 }); -$$Lambda$AmbienceLight$4TLtQpGci4edvCMW7wdLpNAOKho -$$Lambda$AmbienceLight$4TLtQpGci4edvCMW7wdLpNAOKho = new -$$Lambda$AmbienceLight$4TLtQpGci4edvCMW7wdLpNAOKho(this);
/*      */     
/*  488 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild7 = iMultiSignalStatus5.onStatusSignalChanged(-$$Lambda$AmbienceLight$4TLtQpGci4edvCMW7wdLpNAOKho); ECarXCarAmbliManager eCarXCarAmbliManager5 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager5); -$$Lambda$OXWuAAcTW2etpul2bhT_YTqGGNA -$$Lambda$OXWuAAcTW2etpul2bhT_YTqGGNA = new -$$Lambda$OXWuAAcTW2etpul2bhT_YTqGGNA(eCarXCarAmbliManager5);
/*  489 */     iValueTaskBuild7 = iValueTaskBuild7.onSetFunctionValue(-$$Lambda$OXWuAAcTW2etpul2bhT_YTqGGNA, pairs3);
/*      */     
/*  491 */     IVehicleFunction.IFilterCallback iFilterCallback18 = iValueTaskBuild7.useValuePAByIntBase(33839, pairs1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ5 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  493 */     iFilterCallback18.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ5);
/*      */ 
/*      */     
/*  496 */     IVehicleFunction iVehicleFunction4 = VehicleFunction.intFunction(704971776); int[] arrayOfInt6 = COMMON_ON_OFF;
/*  497 */     iVehicleFunction4 = iVehicleFunction4.supportedFunctionValue(arrayOfInt6);
/*  498 */     IVehicleFunction.IZone iZone4 = iVehicleFunction4.createZone(new int[] { Integer.MIN_VALUE });
/*  499 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus4 = iZone4.useStatusSignals(new int[] { 33840, 33951 }); -$$Lambda$AmbienceLight$G7vNZaAMMWBEyTkZLQ5lALBKg_c -$$Lambda$AmbienceLight$G7vNZaAMMWBEyTkZLQ5lALBKg_c = new -$$Lambda$AmbienceLight$G7vNZaAMMWBEyTkZLQ5lALBKg_c(this);
/*      */     
/*  501 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild6 = iMultiSignalStatus4.onStatusSignalChanged(-$$Lambda$AmbienceLight$G7vNZaAMMWBEyTkZLQ5lALBKg_c); ECarXCarAmbliManager eCarXCarAmbliManager4 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager4); -$$Lambda$DiBY2oWm5aQ-lKYz8v0L7Fa6Eaw -$$Lambda$DiBY2oWm5aQ-lKYz8v0L7Fa6Eaw = new -$$Lambda$DiBY2oWm5aQ-lKYz8v0L7Fa6Eaw(eCarXCarAmbliManager4);
/*  502 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild5 = iValueTaskBuild6.onSetFunctionValue(-$$Lambda$DiBY2oWm5aQ-lKYz8v0L7Fa6Eaw, pairs3);
/*      */     
/*  504 */     IVehicleFunction.IFilterCallback iFilterCallback3 = iValueTaskBuild5.useValuePAByIntBase(33840, pairs1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ4 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*      */     
/*  506 */     iFilterCallback3.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  537 */     IVehicleFunction iVehicleFunction3 = VehicleFunction.intFunction(705102336);
/*  538 */     IVehicleFunction.IZone iZone3 = iVehicleFunction3.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A -$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A1 = new -$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A(this);
/*  539 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild2 = iZone3.supportedFunctionValue(-$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A1, new int[] { 29329 });
/*      */     
/*  541 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus3 = iStatusTaskBuild2.useStatusSignals(new int[] { 33824, 33951 }); -$$Lambda$AmbienceLight$piTSFR--sHclWp39wu7qXAXYvZM -$$Lambda$AmbienceLight$piTSFR--sHclWp39wu7qXAXYvZM = new -$$Lambda$AmbienceLight$piTSFR--sHclWp39wu7qXAXYvZM(this);
/*      */     
/*  543 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild3 = iMultiSignalStatus3.onStatusSignalChanged(-$$Lambda$AmbienceLight$piTSFR--sHclWp39wu7qXAXYvZM); ECarXCarAmbliManager eCarXCarAmbliManager3 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager3); -$$Lambda$2fXaOJajrHav27CajfDnI1cRTjM -$$Lambda$2fXaOJajrHav27CajfDnI1cRTjM = new -$$Lambda$2fXaOJajrHav27CajfDnI1cRTjM(eCarXCarAmbliManager3);
/*  544 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild4 = iValueTaskBuild3.onSetFunctionValue(-$$Lambda$2fXaOJajrHav27CajfDnI1cRTjM);
/*      */     
/*  546 */     Function<?, ?> function1 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback2 = iValueTaskBuild4.useValuePAByIntBase(33824, function1); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ3 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*  547 */     iFilterCallback2.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ3);
/*      */ 
/*      */     
/*  550 */     IVehicleFunction iVehicleFunction2 = VehicleFunction.intFunction(705102592);
/*  551 */     IVehicleFunction.IZone iZone2 = iVehicleFunction2.createZone(new int[] { Integer.MIN_VALUE }); -$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A -$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A2 = new -$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A(this);
/*  552 */     IVehicleFunction.IStatusTaskBuild iStatusTaskBuild1 = iZone2.supportedFunctionValue(-$$Lambda$AmbienceLight$Vh4TVfe-FSX2XWg6bujvdizpZ7A2, new int[] { 29329 });
/*      */     
/*  554 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus2 = iStatusTaskBuild1.useStatusSignals(new int[] { 33825, 33951 }); -$$Lambda$AmbienceLight$_iZNpDaomfVwW-OmrR-IYRpPC_8 -$$Lambda$AmbienceLight$_iZNpDaomfVwW-OmrR-IYRpPC_8 = new -$$Lambda$AmbienceLight$_iZNpDaomfVwW-OmrR-IYRpPC_8(this);
/*      */     
/*  556 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild2 = iMultiSignalStatus2.onStatusSignalChanged(-$$Lambda$AmbienceLight$_iZNpDaomfVwW-OmrR-IYRpPC_8); ECarXCarAmbliManager eCarXCarAmbliManager2 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager2); -$$Lambda$1EPdaIxKyTgt9qC1w-b2nQ1olw4 -$$Lambda$1EPdaIxKyTgt9qC1w-b2nQ1olw4 = new -$$Lambda$1EPdaIxKyTgt9qC1w-b2nQ1olw4(eCarXCarAmbliManager2);
/*  557 */     iValueTaskBuild2 = iValueTaskBuild2.onSetFunctionValue(-$$Lambda$1EPdaIxKyTgt9qC1w-b2nQ1olw4);
/*      */     
/*  559 */     Function<?, ?> function2 = Function.identity(); IVehicleFunction.IFilterCallback iFilterCallback4 = iValueTaskBuild2.useValuePAByIntBase(33825, function2); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ1 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*  560 */     iFilterCallback4.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  572 */     IVehicleFunction iVehicleFunction1 = VehicleFunction.intFunction(705167616);
/*  573 */     iVehicleFunction1 = iVehicleFunction1.supportedFunctionValue(new int[] { 705167617, 705167618, 705167619 });
/*      */ 
/*      */ 
/*      */     
/*  577 */     IVehicleFunction.IZone iZone1 = iVehicleFunction1.createZone(new int[] { Integer.MIN_VALUE });
/*  578 */     IVehicleFunction.IMultiSignalStatus iMultiSignalStatus1 = iZone1.useStatusSignals(new int[] { 33822, 33951 }); -$$Lambda$AmbienceLight$0Mwbh598r41S74ORU3bJLvpdOkI -$$Lambda$AmbienceLight$0Mwbh598r41S74ORU3bJLvpdOkI = new -$$Lambda$AmbienceLight$0Mwbh598r41S74ORU3bJLvpdOkI(this);
/*      */     
/*  580 */     IVehicleFunction.IValueTaskBuild iValueTaskBuild1 = iMultiSignalStatus1.onStatusSignalChanged(-$$Lambda$AmbienceLight$0Mwbh598r41S74ORU3bJLvpdOkI); ECarXCarAmbliManager eCarXCarAmbliManager1 = this.mAmbliManager; Objects.requireNonNull(eCarXCarAmbliManager1); -$$Lambda$599SNV3tgBhikZ48VZSeHCjR00Y -$$Lambda$599SNV3tgBhikZ48VZSeHCjR00Y = new -$$Lambda$599SNV3tgBhikZ48VZSeHCjR00Y(eCarXCarAmbliManager1);
/*      */     
/*  582 */     Pairs pairs4 = Pairs.of(Integer.valueOf(705167617), Integer.valueOf(0));
/*  583 */     pairs4 = pairs4.add(Integer.valueOf(705167618), Integer.valueOf(2));
/*      */     
/*  585 */     pairs4 = pairs4.add(Integer.valueOf(705167619), Integer.valueOf(1));
/*      */     iValueTaskBuild1 = iValueTaskBuild1.onSetFunctionValue(-$$Lambda$599SNV3tgBhikZ48VZSeHCjR00Y, pairs4);
/*  587 */     Pairs pairs2 = Pairs.of(Integer.valueOf(0), Integer.valueOf(705167617));
/*  588 */     pairs2 = pairs2.add(Integer.valueOf(2), Integer.valueOf(705167618));
/*      */     
/*  590 */     pairs2 = pairs2.add(Integer.valueOf(1), Integer.valueOf(705167619)); IVehicleFunction.IFilterCallback iFilterCallback1 = iValueTaskBuild1.useValuePAByIntBase(33822, pairs2); -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ2 = new -$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ(this);
/*  591 */     iFilterCallback1.addTo(-$$Lambda$AmbienceLight$RLriB-bID-vQYXz9-DpmLaQmySQ2);
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
/*      */   private ApiResult setAmbLiMod(int paramInt) {
/*  605 */     ApiResult apiResult = ApiResult.FAILED;
/*      */     
/*  607 */     if (paramInt == 0) {
/*  608 */       this.mAmbliManager.CB_AmbLiAll(0);
/*      */     } else {
/*  610 */       this.mAmbliManager.CB_AmbLiAll(1);
/*      */     } 
/*  612 */     if (paramInt != 0 && paramInt != 537526792) switch (paramInt)
/*      */       
/*      */       { 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         default:
/*  630 */           return apiResult;
/*      */         case 537526786:
/*      */         case 537526787:
/*      */         case 537526788:
/*  634 */           break; }   apiResult = this.mAmbliManager.CB_AmbLiModSetting(converToAmbliMode(paramInt)); } private int converToAmbliMode(int paramInt) { boolean bool = false;
/*  635 */     if (paramInt != 0) { if (paramInt != 537526792) { switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  654 */             return paramInt;case 537526788: paramInt = 3; return paramInt;case 537526787: paramInt = 1; return paramInt;case 537526786: break; }  paramInt = 2; } else { paramInt = 4; }  } else { paramInt = 0; }  return paramInt; }
/*      */ 
/*      */   
/*      */   private int converFromAmbliMode(int paramInt) {
/*  658 */     boolean bool = false;
/*  659 */     switch (paramInt) { default: paramInt = bool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  678 */         return paramInt;case 4: paramInt = 537526792; return paramInt;case 3: paramInt = 537526788; return paramInt;case 2: paramInt = 537526786; return paramInt;case 1: paramInt = 537526787; return paramInt;case 0: break; }  paramInt = 0; return paramInt;
/*      */   }
/*      */   
/*      */   private int getAmbLiMod() {
/*  682 */     int i = getConvertIntData(33816, new -$$Lambda$AmbienceLight$Wldtq-N3xRWzs7X9q06L3VLVfbI(this), 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  691 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("getAmbLiMod "); stringBuilder.append(i); Log.d("AmbienceLight2_API", stringBuilder.toString());
/*  692 */     return i;
/*      */   }
/*      */   
/*      */   private boolean isKX11() {
/*      */     boolean bool;
/*  697 */     int i = getSignalValue(29329);
/*  698 */     if (i == 162) { bool = true; } else { bool = false; }  return bool;
/*      */   }
/*      */   
/*      */   private int[] getKx11OrEx11Value() {
/*      */     int[] arrayOfInt;
/*  703 */     if (isKX11()) {
/*  704 */       arrayOfInt = kx11Value;
/*      */     } else {
/*  706 */       arrayOfInt = ex11Value;
/*      */     } 
/*  708 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int[] getAmbienceLightModeSupportedValue() {
/*  713 */     ArrayList<Integer> arrayList = new ArrayList();
/*  714 */     arrayList.add(Integer.valueOf(0));
/*  715 */     if (getFunctionStatus(33818) != FunctionStatus.notavailable)
/*      */     {
/*  717 */       arrayList.add(Integer.valueOf(537526787));
/*      */     }
/*  719 */     if (getFunctionStatus(33819) != FunctionStatus.notavailable)
/*      */     {
/*  721 */       arrayList.add(Integer.valueOf(537526786));
/*      */     }
/*  723 */     if (getFunctionStatus(33820) != FunctionStatus.notavailable)
/*      */     {
/*  725 */       arrayList.add(Integer.valueOf(537526788));
/*      */     }
/*      */ 
/*      */     
/*  729 */     if (getFunctionStatus(33822) != FunctionStatus.notavailable)
/*      */     {
/*  731 */       arrayList.add(Integer.valueOf(537526790));
/*      */     }
/*  733 */     if (getFunctionStatus(33821) != FunctionStatus.notavailable)
/*      */     {
/*  735 */       arrayList.add(Integer.valueOf(537526792));
/*      */     }
/*  737 */     return arrayList.stream().mapToInt(-$$Lambda$AmbienceLight$gfCssnBJI7TKfXb_Jmv7raVYNkY.INSTANCE).toArray();
/*      */   }
/*      */   
/*      */   boolean isKingMode() {
/*  741 */     boolean bool = false; if (getIntValue(33951, 0) == 11) bool = true;  return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightMainColorStatus() {
/*  752 */     FunctionStatus functionStatus = getFunctionStatus(33818);
/*      */     
/*  754 */     if (functionStatus == FunctionStatus.active && 
/*  755 */       isKingMode()) {
/*  756 */       return FunctionStatus.notactive;
/*      */     }
/*  758 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightTopZonesStatus() {
/*  768 */     FunctionStatus functionStatus = getFunctionStatus(33838);
/*      */     
/*  770 */     if (functionStatus == FunctionStatus.active && 
/*  771 */       isKingMode()) {
/*  772 */       return FunctionStatus.notactive;
/*      */     }
/*  774 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getZoneAllLightInteractiveEffectStatus() {
/*  784 */     FunctionStatus functionStatus = getFunctionStatus(33826);
/*      */     
/*  786 */     if (functionStatus == FunctionStatus.active && 
/*  787 */       isKingMode()) {
/*  788 */       return FunctionStatus.notactive;
/*      */     }
/*  790 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getZoneFrontLightInteractiveEffectStatus() {
/*  800 */     FunctionStatus functionStatus = getFunctionStatus(33829);
/*      */     
/*  802 */     if (functionStatus == FunctionStatus.active && 
/*  803 */       isKingMode()) {
/*  804 */       return FunctionStatus.notactive;
/*      */     }
/*  806 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getZoneHeadRestLightInteractiveEffectStatus() {
/*  816 */     FunctionStatus functionStatus = getFunctionStatus(33832);
/*      */     
/*  818 */     if (functionStatus == FunctionStatus.active && 
/*  819 */       isKingMode()) {
/*  820 */       return FunctionStatus.notactive;
/*      */     }
/*  822 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getZoneRearLightInteractiveEffectStatus() {
/*  832 */     FunctionStatus functionStatus = getFunctionStatus(33835);
/*      */     
/*  834 */     if (functionStatus == FunctionStatus.active && 
/*  835 */       isKingMode()) {
/*  836 */       return FunctionStatus.notactive;
/*      */     }
/*  838 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getKX11ColorSetStatus() {
/*  848 */     FunctionStatus functionStatus = getFunctionStatus(33831);
/*      */     
/*  850 */     if (functionStatus == FunctionStatus.active && 
/*  851 */       isKingMode()) {
/*  852 */       return FunctionStatus.notactive;
/*      */     }
/*  854 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneAllColorSetStatus() {
/*  864 */     FunctionStatus functionStatus = getFunctionStatus(33828);
/*      */     
/*  866 */     if (functionStatus == FunctionStatus.active && 
/*  867 */       isKingMode()) {
/*  868 */       return FunctionStatus.notactive;
/*      */     }
/*  870 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneFrontColorSetStatus() {
/*  880 */     FunctionStatus functionStatus = getFunctionStatus(33831);
/*      */     
/*  882 */     if (functionStatus == FunctionStatus.active && 
/*  883 */       isKingMode()) {
/*  884 */       return FunctionStatus.notactive;
/*      */     }
/*  886 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneHeadRestColorSetStatus() {
/*  896 */     FunctionStatus functionStatus = getFunctionStatus(33834);
/*      */     
/*  898 */     if (functionStatus == FunctionStatus.active && 
/*  899 */       isKingMode()) {
/*  900 */       return FunctionStatus.notactive;
/*      */     }
/*  902 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneRearRestColorSetStatus() {
/*  912 */     FunctionStatus functionStatus = getFunctionStatus(33837);
/*      */     
/*  914 */     if (functionStatus == FunctionStatus.active && 
/*  915 */       isKingMode()) {
/*  916 */       return FunctionStatus.notactive;
/*      */     }
/*  918 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getKX11LightIntensitySetStatus() {
/*  929 */     FunctionStatus functionStatus = getFunctionStatus(33830);
/*      */     
/*  931 */     if (functionStatus == FunctionStatus.active && 
/*  932 */       isKingMode()) {
/*  933 */       return FunctionStatus.notactive;
/*      */     }
/*  935 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneAllLightIntensitySetStatus() {
/*  945 */     FunctionStatus functionStatus = getFunctionStatus(33827);
/*      */     
/*  947 */     if (functionStatus == FunctionStatus.active && 
/*  948 */       isKingMode()) {
/*  949 */       return FunctionStatus.notactive;
/*      */     }
/*  951 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneFrontLightIntensitySetStatus() {
/*  962 */     FunctionStatus functionStatus = getFunctionStatus(33830);
/*      */     
/*  964 */     if (functionStatus == FunctionStatus.active && 
/*  965 */       isKingMode()) {
/*  966 */       return FunctionStatus.notactive;
/*      */     }
/*  968 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneHeadRestLightIntensitySetStatus() {
/*  978 */     FunctionStatus functionStatus = getFunctionStatus(33833);
/*      */     
/*  980 */     if (functionStatus == FunctionStatus.active && 
/*  981 */       isKingMode()) {
/*  982 */       return FunctionStatus.notactive;
/*      */     }
/*  984 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEX11ZoneRearLightIntensitySetStatus() {
/*  994 */     FunctionStatus functionStatus = getFunctionStatus(33836);
/*      */     
/*  996 */     if (functionStatus == FunctionStatus.active && 
/*  997 */       isKingMode()) {
/*  998 */       return FunctionStatus.notactive;
/*      */     }
/* 1000 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getBreathModeColorStatus() {
/* 1010 */     FunctionStatus functionStatus = getFunctionStatus(33831);
/*      */     
/* 1012 */     if (functionStatus == FunctionStatus.active && 
/* 1013 */       isKingMode()) {
/* 1014 */       return FunctionStatus.notactive;
/*      */     }
/* 1016 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightWelcomeShowStatus() {
/* 1026 */     FunctionStatus functionStatus = getFunctionStatus(33849);
/*      */     
/* 1028 */     if (functionStatus == FunctionStatus.active && 
/* 1029 */       isKingMode()) {
/* 1030 */       return FunctionStatus.notactive;
/*      */     }
/* 1032 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightGoodByeShowStatus() {
/* 1042 */     FunctionStatus functionStatus = getFunctionStatus(33850);
/*      */     
/* 1044 */     if (functionStatus == FunctionStatus.active && 
/* 1045 */       isKingMode()) {
/* 1046 */       return FunctionStatus.notactive;
/*      */     }
/* 1048 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightMilReminderStatus() {
/* 1058 */     FunctionStatus functionStatus = getFunctionStatus(33839);
/*      */     
/* 1060 */     if (functionStatus == FunctionStatus.active && 
/* 1061 */       isKingMode()) {
/* 1062 */       return FunctionStatus.notactive;
/*      */     }
/* 1064 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightCallReminderStatus() {
/* 1074 */     FunctionStatus functionStatus = getFunctionStatus(33840);
/*      */     
/* 1076 */     if (functionStatus == FunctionStatus.active && 
/* 1077 */       isKingMode()) {
/* 1078 */       return FunctionStatus.notactive;
/*      */     }
/* 1080 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getStartColorStatus() {
/* 1090 */     FunctionStatus functionStatus = getFunctionStatus(33824);
/*      */     
/* 1092 */     if (functionStatus == FunctionStatus.active && 
/* 1093 */       isKingMode()) {
/* 1094 */       return FunctionStatus.notactive;
/*      */     }
/* 1096 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getEndColorStatus() {
/* 1106 */     FunctionStatus functionStatus = getFunctionStatus(33825);
/*      */     
/* 1108 */     if (functionStatus == FunctionStatus.active && 
/* 1109 */       isKingMode()) {
/* 1110 */       return FunctionStatus.notactive;
/*      */     }
/* 1112 */     return functionStatus;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FunctionStatus getLightEffectSetStatus() {
/* 1122 */     FunctionStatus functionStatus = getFunctionStatus(33822);
/*      */     
/* 1124 */     if (functionStatus == FunctionStatus.active && 
/* 1125 */       isKingMode()) {
/* 1126 */       return FunctionStatus.notactive;
/*      */     }
/* 1128 */     return functionStatus;
/*      */   }
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\car\vehicle\AmbienceLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */