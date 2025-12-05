/*      */ package ecarx.car.hardware.annotation;
/*      */ 
/*      */ import java.lang.annotation.Retention;
/*      */ import java.lang.annotation.RetentionPolicy;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class TsType
/*      */ {
/*      */   public static final int AdvisorySpeed10 = 130;
/*      */   public static final int AdvisorySpeed100 = 148;
/*      */   public static final int AdvisorySpeed105 = 149;
/*      */   public static final int AdvisorySpeed110 = 150;
/*      */   public static final int AdvisorySpeed115 = 151;
/*      */   public static final int AdvisorySpeed120 = 152;
/*      */   public static final int AdvisorySpeed125 = 153;
/*      */   public static final int AdvisorySpeed130 = 154;
/*      */   public static final int AdvisorySpeed135 = 155;
/*      */   public static final int AdvisorySpeed140 = 156;
/*      */   public static final int AdvisorySpeed145 = 157;
/*      */   public static final int AdvisorySpeed15 = 131;
/*      */   public static final int AdvisorySpeed150 = 158;
/*      */   public static final int AdvisorySpeed155 = 159;
/*      */   public static final int AdvisorySpeed160 = 160;
/*      */   public static final int AdvisorySpeed20 = 132;
/*      */   public static final int AdvisorySpeed25 = 133;
/*      */   public static final int AdvisorySpeed30 = 134;
/*      */   public static final int AdvisorySpeed35 = 135;
/*      */   public static final int AdvisorySpeed40 = 136;
/*      */   public static final int AdvisorySpeed45 = 137;
/*      */   public static final int AdvisorySpeed5 = 129;
/*      */   public static final int AdvisorySpeed50 = 138;
/*      */   public static final int AdvisorySpeed55 = 139;
/*      */   public static final int AdvisorySpeed60 = 140;
/*      */   public static final int AdvisorySpeed65 = 141;
/*      */   public static final int AdvisorySpeed70 = 142;
/*      */   public static final int AdvisorySpeed75 = 143;
/*      */   public static final int AdvisorySpeed80 = 144;
/*      */   public static final int AdvisorySpeed85 = 145;
/*      */   public static final int AdvisorySpeed90 = 146;
/*      */   public static final int AdvisorySpeed95 = 147;
/*      */   public static final int BarrierLevelCrossing = 213;
/*      */   public static final int BicycleStreet = 120;
/*      */   public static final int Chicane = 78;
/*      */   public static final int ChicaneSignUS = 102;
/*      */   public static final int CityEntry = 74;
/*      */   public static final int CityExit = 75;
/*      */   public static final int CurveLeft = 208;
/*      */   public static final int CurveLeftThenRight = 210;
/*      */   public static final int CurveRight = 209;
/*      */   public static final int CurveRightThenLeft = 211;
/*      */   public static final int Empty = 0;
/*      */   public static final int EndOfBicycleStreet = 121;
/*      */   public static final int EndOfExpressway = 69;
/*      */   public static final int EndOfHighway = 71;
/*      */   public static final int EndOfNoPassing = 203;
/*      */   public static final int EndOfNoPassingTrucks = 207;
/*      */   public static final int EndOfResidentialArea = 197;
/*      */   public static final int EndOfRestrictions = 195;
/*      */   public static final int EndOfSpeedLimit10 = 34;
/*      */   public static final int EndOfSpeedLimit100 = 52;
/*      */   public static final int EndOfSpeedLimit105 = 53;
/*      */   public static final int EndOfSpeedLimit110 = 54;
/*      */   public static final int EndOfSpeedLimit115 = 55;
/*      */   public static final int EndOfSpeedLimit120 = 56;
/*      */   public static final int EndOfSpeedLimit125 = 57;
/*      */   public static final int EndOfSpeedLimit130 = 58;
/*      */   public static final int EndOfSpeedLimit135 = 59;
/*      */   public static final int EndOfSpeedLimit140 = 60;
/*      */   public static final int EndOfSpeedLimit145 = 61;
/*      */   public static final int EndOfSpeedLimit15 = 35;
/*      */   public static final int EndOfSpeedLimit150 = 62;
/*      */   public static final int EndOfSpeedLimit155 = 63;
/*      */   public static final int EndOfSpeedLimit160 = 64;
/*      */   public static final int EndOfSpeedLimit20 = 36;
/*      */   public static final int EndOfSpeedLimit25 = 37;
/*      */   public static final int EndOfSpeedLimit30 = 38;
/*      */   public static final int EndOfSpeedLimit35 = 39;
/*      */   public static final int EndOfSpeedLimit40 = 40;
/*      */   public static final int EndOfSpeedLimit45 = 41;
/*      */   public static final int EndOfSpeedLimit5 = 33;
/*      */   public static final int EndOfSpeedLimit50 = 42;
/*      */   public static final int EndOfSpeedLimit55 = 43;
/*      */   public static final int EndOfSpeedLimit60 = 44;
/*      */   public static final int EndOfSpeedLimit65 = 45;
/*      */   public static final int EndOfSpeedLimit70 = 46;
/*      */   public static final int EndOfSpeedLimit75 = 47;
/*      */   public static final int EndOfSpeedLimit80 = 48;
/*      */   public static final int EndOfSpeedLimit85 = 49;
/*      */   public static final int EndOfSpeedLimit90 = 50;
/*      */   public static final int EndOfSpeedLimit95 = 51;
/*      */   public static final int EndOfSpeedLimitKmh = 193;
/*      */   public static final int EndOfSpeedLimitMph = 194;
/*      */   public static final int Expressway = 68;
/*      */   public static final int GiveRightOfWay = 116;
/*      */   public static final int Highway = 70;
/*      */   public static final int Icy = 215;
/*      */   public static final int InvalidatedTrafficSign = 98;
/*      */   public static final int KeepLeft = 107;
/*      */   public static final int KeepRight = 106;
/*      */   public static final int LaneClosure = 79;
/*      */   public static final int LaneClosureSignUS = 103;
/*      */   public static final int Left = 109;
/*      */   public static final int NoEntry = 204;
/*      */   public static final int NoParking1 = 118;
/*      */   public static final int NoParking2 = 119;
/*      */   public static final int NoPassing = 202;
/*      */   public static final int NoPassingTrucks = 206;
/*      */   public static final int NotForThisCountry = 254;
/*      */   public static final int PedestrianCrossing = 205;
/*      */   public static final int Reserved122_122 = 122;
/*      */   public static final int Reserved123_123 = 123;
/*      */   public static final int Reserved124_124 = 124;
/*      */   public static final int Reserved125_125 = 125;
/*      */   public static final int Reserved126_126 = 126;
/*      */   public static final int Reserved127_127 = 127;
/*      */   public static final int Reserved128_128 = 128;
/*      */   public static final int Reserved161_161 = 161;
/*      */   public static final int Reserved162_162 = 162;
/*      */   public static final int Reserved163_163 = 163;
/*      */   public static final int Reserved164_164 = 164;
/*      */   public static final int Reserved165_165 = 165;
/*      */   public static final int Reserved166_166 = 166;
/*      */   public static final int Reserved167_167 = 167;
/*      */   public static final int Reserved168_168 = 168;
/*      */   public static final int Reserved169_169 = 169;
/*      */   public static final int Reserved170_170 = 170;
/*      */   public static final int Reserved171_171 = 171;
/*      */   public static final int Reserved172_172 = 172;
/*      */   public static final int Reserved173_173 = 173;
/*      */   public static final int Reserved174_174 = 174;
/*      */   public static final int Reserved175_175 = 175;
/*      */   public static final int Reserved176_176 = 176;
/*      */   public static final int Reserved177_177 = 177;
/*      */   public static final int Reserved178_178 = 178;
/*      */   public static final int Reserved179_179 = 179;
/*      */   public static final int Reserved180_180 = 180;
/*      */   public static final int Reserved181_181 = 181;
/*      */   public static final int Reserved182_182 = 182;
/*      */   public static final int Reserved183_183 = 183;
/*      */   public static final int Reserved184_184 = 184;
/*      */   public static final int Reserved185_185 = 185;
/*      */   public static final int Reserved186_186 = 186;
/*      */   public static final int Reserved187_187 = 187;
/*      */   public static final int Reserved188_188 = 188;
/*      */   public static final int Reserved189_189 = 189;
/*      */   public static final int Reserved190_190 = 190;
/*      */   public static final int Reserved191_191 = 191;
/*      */   public static final int Reserved192_192 = 192;
/*      */   public static final int Reserved198_198 = 198;
/*      */   public static final int Reserved199_199 = 199;
/*      */   public static final int Reserved200_200 = 200;
/*      */   public static final int Reserved201_201 = 201;
/*      */   public static final int Reserved212_212 = 212;
/*      */   public static final int Reserved216_216 = 216;
/*      */   public static final int Reserved217_217 = 217;
/*      */   public static final int Reserved218_218 = 218;
/*      */   public static final int Reserved219_219 = 219;
/*      */   public static final int Reserved220_220 = 220;
/*      */   public static final int Reserved221_221 = 221;
/*      */   public static final int Reserved222_222 = 222;
/*      */   public static final int Reserved223_223 = 223;
/*      */   public static final int Reserved224_224 = 224;
/*      */   public static final int Reserved225_225 = 225;
/*      */   public static final int Reserved226_226 = 226;
/*      */   public static final int Reserved227_227 = 227;
/*      */   public static final int Reserved228_228 = 228;
/*      */   public static final int Reserved229_229 = 229;
/*      */   public static final int Reserved230_230 = 230;
/*      */   public static final int Reserved231_231 = 231;
/*      */   public static final int Reserved232_232 = 232;
/*      */   public static final int Reserved233_233 = 233;
/*      */   public static final int Reserved234_234 = 234;
/*      */   public static final int Reserved235_235 = 235;
/*      */   public static final int Reserved236_236 = 236;
/*      */   public static final int Reserved237_237 = 237;
/*      */   public static final int Reserved238_238 = 238;
/*      */   public static final int Reserved239_239 = 239;
/*      */   public static final int Reserved240_240 = 240;
/*      */   public static final int Reserved241_241 = 241;
/*      */   public static final int Reserved242_242 = 242;
/*      */   public static final int Reserved243_243 = 243;
/*      */   public static final int Reserved244_244 = 244;
/*      */   public static final int Reserved245_245 = 245;
/*      */   public static final int Reserved246_246 = 246;
/*      */   public static final int Reserved247_247 = 247;
/*      */   public static final int Reserved248_248 = 248;
/*      */   public static final int Reserved249_249 = 249;
/*      */   public static final int Reserved250_250 = 250;
/*      */   public static final int Reserved251_251 = 251;
/*      */   public static final int Reserved252_252 = 252;
/*      */   public static final int Reserved253_253 = 253;
/*      */   public static final int Reserved65_65 = 65;
/*      */   public static final int Reserved66_66 = 66;
/*      */   public static final int Reserved67_67 = 67;
/*      */   public static final int Reserved72_72 = 72;
/*      */   public static final int Reserved73_73 = 73;
/*      */   public static final int ResidentialArea = 196;
/*      */   public static final int Right = 108;
/*      */   public static final int RightOfWay = 117;
/*      */   public static final int RightOrLeft = 114;
/*      */   public static final int Roadwork = 76;
/*      */   public static final int RoadworkUStext = 77;
/*      */   public static final int ShoulderClosed = 105;
/*      */   public static final int ShoulderOpen = 104;
/*      */   public static final int SignNotAvailable = 255;
/*      */   public static final int SpeedLimit10 = 2;
/*      */   public static final int SpeedLimit100 = 20;
/*      */   public static final int SpeedLimit105 = 21;
/*      */   public static final int SpeedLimit110 = 22;
/*      */   public static final int SpeedLimit115 = 23;
/*      */   public static final int SpeedLimit120 = 24;
/*      */   public static final int SpeedLimit125 = 25;
/*      */   public static final int SpeedLimit130 = 26;
/*      */   public static final int SpeedLimit135 = 27;
/*      */   public static final int SpeedLimit140 = 28;
/*      */   public static final int SpeedLimit145 = 29;
/*      */   public static final int SpeedLimit15 = 3;
/*      */   public static final int SpeedLimit150 = 30;
/*      */   public static final int SpeedLimit155 = 31;
/*      */   public static final int SpeedLimit160 = 32;
/*      */   public static final int SpeedLimit20 = 4;
/*      */   public static final int SpeedLimit25 = 5;
/*      */   public static final int SpeedLimit30 = 6;
/*      */   public static final int SpeedLimit35 = 7;
/*      */   public static final int SpeedLimit40 = 8;
/*      */   public static final int SpeedLimit45 = 9;
/*      */   public static final int SpeedLimit5 = 1;
/*      */   public static final int SpeedLimit50 = 10;
/*      */   public static final int SpeedLimit55 = 11;
/*      */   public static final int SpeedLimit60 = 12;
/*      */   public static final int SpeedLimit65 = 13;
/*      */   public static final int SpeedLimit70 = 14;
/*      */   public static final int SpeedLimit75 = 15;
/*      */   public static final int SpeedLimit80 = 16;
/*      */   public static final int SpeedLimit85 = 17;
/*      */   public static final int SpeedLimit90 = 18;
/*      */   public static final int SpeedLimit95 = 19;
/*      */   public static final int StopSignGeneral = 99;
/*      */   public static final int StopSignNway = 100;
/*      */   public static final int StraightOrLeft = 113;
/*      */   public static final int StraightOrRright = 112;
/*      */   public static final int TextwarningSignUS = 101;
/*      */   public static final int TrafficLightGreenLeft = 88;
/*      */   public static final int TrafficLightGreenRight = 85;
/*      */   public static final int TrafficLightGreenStraight = 97;
/*      */   public static final int TrafficLightGreenStraightLeft = 94;
/*      */   public static final int TrafficLightGreenStraightRight = 91;
/*      */   public static final int TrafficLightGreenUniDirectional = 82;
/*      */   public static final int TrafficLightRedLeft = 86;
/*      */   public static final int TrafficLightRedRight = 83;
/*      */   public static final int TrafficLightRedStraight = 95;
/*      */   public static final int TrafficLightRedStraightLeft = 92;
/*      */   public static final int TrafficLightRedStraightRight = 89;
/*      */   public static final int TrafficLightRedUniDirectional = 80;
/*      */   public static final int TrafficLightYellowLeft = 87;
/*      */   public static final int TrafficLightYellowRight = 84;
/*      */   public static final int TrafficLightYellowStraight = 96;
/*      */   public static final int TrafficLightYellowStraightLeft = 93;
/*      */   public static final int TrafficLightYellowStraightRight = 90;
/*      */   public static final int TrafficLightYellowUniDirectional = 81;
/*      */   public static final int TurnLeft = 111;
/*      */   public static final int TurnRight = 110;
/*      */   public static final int UnguardedLevelCrossing = 214;
/*      */   public static final int Uturn = 115;
/*      */   
/*      */   public static String toString(int paramInt) {
/*  274 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("Invalid = "); stringBuilder.append(paramInt); String str = stringBuilder.toString();
/*  275 */     switch (paramInt) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       default:
/* 1045 */         return str;
/*      */       case 255:
/*      */         str = "SignNotAvailable";
/*      */       case 254:
/*      */         str = "NotForThisCountry";
/*      */       case 253:
/*      */         str = "Reserved253_253";
/*      */       case 252:
/*      */         str = "Reserved252_252";
/*      */       case 251:
/*      */         str = "Reserved251_251";
/*      */       case 250:
/*      */         str = "Reserved250_250";
/*      */       case 249:
/*      */         str = "Reserved249_249";
/*      */       case 248:
/*      */         str = "Reserved248_248";
/*      */       case 247:
/*      */         str = "Reserved247_247";
/*      */       case 246:
/*      */         str = "Reserved246_246";
/*      */       case 245:
/*      */         str = "Reserved245_245";
/*      */       case 244:
/*      */         str = "Reserved244_244";
/*      */       case 243:
/*      */         str = "Reserved243_243";
/*      */       case 242:
/*      */         str = "Reserved242_242";
/*      */       case 241:
/*      */         str = "Reserved241_241";
/*      */       case 240:
/*      */         str = "Reserved240_240";
/*      */       case 239:
/*      */         str = "Reserved239_239";
/*      */       case 238:
/*      */         str = "Reserved238_238";
/*      */       case 237:
/*      */         str = "Reserved237_237";
/*      */       case 236:
/*      */         str = "Reserved236_236";
/*      */       case 235:
/*      */         str = "Reserved235_235";
/*      */       case 234:
/*      */         str = "Reserved234_234";
/*      */       case 233:
/*      */         str = "Reserved233_233";
/*      */       case 232:
/*      */         str = "Reserved232_232";
/*      */       case 231:
/*      */         str = "Reserved231_231";
/*      */       case 230:
/*      */         str = "Reserved230_230";
/*      */       case 229:
/*      */         str = "Reserved229_229";
/*      */       case 228:
/*      */         str = "Reserved228_228";
/*      */       case 227:
/*      */         str = "Reserved227_227";
/*      */       case 226:
/*      */         str = "Reserved226_226";
/*      */       case 225:
/*      */         str = "Reserved225_225";
/*      */       case 224:
/*      */         str = "Reserved224_224";
/*      */       case 223:
/*      */         str = "Reserved223_223";
/*      */       case 222:
/*      */         str = "Reserved222_222";
/*      */       case 221:
/*      */         str = "Reserved221_221";
/*      */       case 220:
/*      */         str = "Reserved220_220";
/*      */       case 219:
/*      */         str = "Reserved219_219";
/*      */       case 218:
/*      */         str = "Reserved218_218";
/*      */       case 217:
/*      */         str = "Reserved217_217";
/*      */       case 216:
/*      */         str = "Reserved216_216";
/*      */       case 215:
/*      */         str = "Icy";
/*      */       case 214:
/*      */         str = "UnguardedLevelCrossing";
/*      */       case 213:
/*      */         str = "BarrierLevelCrossing";
/*      */       case 212:
/*      */         str = "Reserved212_212";
/*      */       case 211:
/*      */         str = "CurveRightThenLeft";
/*      */       case 210:
/*      */         str = "CurveLeftThenRight";
/*      */       case 209:
/*      */         str = "CurveRight";
/*      */       case 208:
/*      */         str = "CurveLeft";
/*      */       case 207:
/*      */         str = "EndOfNoPassingTrucks";
/*      */       case 206:
/*      */         str = "NoPassingTrucks";
/*      */       case 205:
/*      */         str = "PedestrianCrossing";
/*      */       case 204:
/*      */         str = "NoEntry";
/*      */       case 203:
/*      */         str = "EndOfNoPassing";
/*      */       case 202:
/*      */         str = "NoPassing";
/*      */       case 201:
/*      */         str = "Reserved201_201";
/*      */       case 200:
/*      */         str = "Reserved200_200";
/*      */       case 199:
/*      */         str = "Reserved199_199";
/*      */       case 198:
/*      */         str = "Reserved198_198";
/*      */       case 197:
/*      */         str = "EndOfResidentialArea";
/*      */       case 196:
/*      */         str = "ResidentialArea";
/*      */       case 195:
/*      */         str = "EndOfRestrictions";
/*      */       case 194:
/*      */         str = "EndOfSpeedLimitMph";
/*      */       case 193:
/*      */         str = "EndOfSpeedLimitKmh";
/*      */       case 192:
/*      */         str = "Reserved192_192";
/*      */       case 191:
/*      */         str = "Reserved191_191";
/*      */       case 190:
/*      */         str = "Reserved190_190";
/*      */       case 189:
/*      */         str = "Reserved189_189";
/*      */       case 188:
/*      */         str = "Reserved188_188";
/*      */       case 187:
/*      */         str = "Reserved187_187";
/*      */       case 186:
/*      */         str = "Reserved186_186";
/*      */       case 185:
/*      */         str = "Reserved185_185";
/*      */       case 184:
/*      */         str = "Reserved184_184";
/*      */       case 183:
/*      */         str = "Reserved183_183";
/*      */       case 182:
/*      */         str = "Reserved182_182";
/*      */       case 181:
/*      */         str = "Reserved181_181";
/*      */       case 180:
/*      */         str = "Reserved180_180";
/*      */       case 179:
/*      */         str = "Reserved179_179";
/*      */       case 178:
/*      */         str = "Reserved178_178";
/*      */       case 177:
/*      */         str = "Reserved177_177";
/*      */       case 176:
/*      */         str = "Reserved176_176";
/*      */       case 175:
/*      */         str = "Reserved175_175";
/*      */       case 174:
/*      */         str = "Reserved174_174";
/*      */       case 173:
/*      */         str = "Reserved173_173";
/*      */       case 172:
/*      */         str = "Reserved172_172";
/*      */       case 171:
/*      */         str = "Reserved171_171";
/*      */       case 170:
/*      */         str = "Reserved170_170";
/*      */       case 169:
/*      */         str = "Reserved169_169";
/*      */       case 168:
/*      */         str = "Reserved168_168";
/*      */       case 167:
/*      */         str = "Reserved167_167";
/*      */       case 166:
/*      */         str = "Reserved166_166";
/*      */       case 165:
/*      */         str = "Reserved165_165";
/*      */       case 164:
/*      */         str = "Reserved164_164";
/*      */       case 163:
/*      */         str = "Reserved163_163";
/*      */       case 162:
/*      */         str = "Reserved162_162";
/*      */       case 161:
/*      */         str = "Reserved161_161";
/*      */       case 160:
/*      */         str = "AdvisorySpeed160";
/*      */       case 159:
/*      */         str = "AdvisorySpeed155";
/*      */       case 158:
/*      */         str = "AdvisorySpeed150";
/*      */       case 157:
/*      */         str = "AdvisorySpeed145";
/*      */       case 156:
/*      */         str = "AdvisorySpeed140";
/*      */       case 155:
/*      */         str = "AdvisorySpeed135";
/*      */       case 154:
/*      */         str = "AdvisorySpeed130";
/*      */       case 153:
/*      */         str = "AdvisorySpeed125";
/*      */       case 152:
/*      */         str = "AdvisorySpeed120";
/*      */       case 151:
/*      */         str = "AdvisorySpeed115";
/*      */       case 150:
/*      */         str = "AdvisorySpeed110";
/*      */       case 149:
/*      */         str = "AdvisorySpeed105";
/*      */       case 148:
/*      */         str = "AdvisorySpeed100";
/*      */       case 147:
/*      */         str = "AdvisorySpeed95";
/*      */       case 146:
/*      */         str = "AdvisorySpeed90";
/*      */       case 145:
/*      */         str = "AdvisorySpeed85";
/*      */       case 144:
/*      */         str = "AdvisorySpeed80";
/*      */       case 143:
/*      */         str = "AdvisorySpeed75";
/*      */       case 142:
/*      */         str = "AdvisorySpeed70";
/*      */       case 141:
/*      */         str = "AdvisorySpeed65";
/*      */       case 140:
/*      */         str = "AdvisorySpeed60";
/*      */       case 139:
/*      */         str = "AdvisorySpeed55";
/*      */       case 138:
/*      */         str = "AdvisorySpeed50";
/*      */       case 137:
/*      */         str = "AdvisorySpeed45";
/*      */       case 136:
/*      */         str = "AdvisorySpeed40";
/*      */       case 135:
/*      */         str = "AdvisorySpeed35";
/*      */       case 134:
/*      */         str = "AdvisorySpeed30";
/*      */       case 133:
/*      */         str = "AdvisorySpeed25";
/*      */       case 132:
/*      */         str = "AdvisorySpeed20";
/*      */       case 131:
/*      */         str = "AdvisorySpeed15";
/*      */       case 130:
/*      */         str = "AdvisorySpeed10";
/*      */       case 129:
/*      */         str = "AdvisorySpeed5";
/*      */       case 128:
/*      */         str = "Reserved128_128";
/*      */       case 127:
/*      */         str = "Reserved127_127";
/*      */       case 126:
/*      */         str = "Reserved126_126";
/*      */       case 125:
/*      */         str = "Reserved125_125";
/*      */       case 124:
/*      */         str = "Reserved124_124";
/*      */       case 123:
/*      */         str = "Reserved123_123";
/*      */       case 122:
/*      */         str = "Reserved122_122";
/*      */       case 121:
/*      */         str = "EndOfBicycleStreet";
/*      */       case 120:
/*      */         str = "BicycleStreet";
/*      */       case 119:
/*      */         str = "NoParking2";
/*      */       case 118:
/*      */         str = "NoParking1";
/*      */       case 117:
/*      */         str = "RightOfWay";
/*      */       case 116:
/*      */         str = "GiveRightOfWay";
/*      */       case 115:
/*      */         str = "Uturn";
/*      */       case 114:
/*      */         str = "RightOrLeft";
/*      */       case 113:
/*      */         str = "StraightOrLeft";
/*      */       case 112:
/*      */         str = "StraightOrRright";
/*      */       case 111:
/*      */         str = "TurnLeft";
/*      */       case 110:
/*      */         str = "TurnRight";
/*      */       case 109:
/*      */         str = "Left";
/*      */       case 108:
/*      */         str = "Right";
/*      */       case 107:
/*      */         str = "KeepLeft";
/*      */       case 106:
/*      */         str = "KeepRight";
/*      */       case 105:
/*      */         str = "ShoulderClosed";
/*      */       case 104:
/*      */         str = "ShoulderOpen";
/*      */       case 103:
/*      */         str = "LaneClosureSignUS";
/*      */       case 102:
/*      */         str = "ChicaneSignUS";
/*      */       case 101:
/*      */         str = "TextwarningSignUS";
/*      */       case 100:
/*      */         str = "StopSignNway";
/*      */       case 99:
/*      */         str = "StopSignGeneral";
/*      */       case 98:
/*      */         str = "InvalidatedTrafficSign";
/*      */       case 97:
/*      */         str = "TrafficLightGreenStraight";
/*      */       case 96:
/*      */         str = "TrafficLightYellowStraight";
/*      */       case 95:
/*      */         str = "TrafficLightRedStraight";
/*      */       case 94:
/*      */         str = "TrafficLightGreenStraightLeft";
/*      */       case 93:
/*      */         str = "TrafficLightYellowStraightLeft";
/*      */       case 92:
/*      */         str = "TrafficLightRedStraightLeft";
/*      */       case 91:
/*      */         str = "TrafficLightGreenStraightRight";
/*      */       case 90:
/*      */         str = "TrafficLightYellowStraightRight";
/*      */       case 89:
/*      */         str = "TrafficLightRedStraightRight";
/*      */       case 88:
/*      */         str = "TrafficLightGreenLeft";
/*      */       case 87:
/*      */         str = "TrafficLightYellowLeft";
/*      */       case 86:
/*      */         str = "TrafficLightRedLeft";
/*      */       case 85:
/*      */         str = "TrafficLightGreenRight";
/*      */       case 84:
/*      */         str = "TrafficLightYellowRight";
/*      */       case 83:
/*      */         str = "TrafficLightRedRight";
/*      */       case 82:
/*      */         str = "TrafficLightGreenUniDirectional";
/*      */       case 81:
/*      */         str = "TrafficLightYellowUniDirectional";
/*      */       case 80:
/*      */         str = "TrafficLightRedUniDirectional";
/*      */       case 79:
/*      */         str = "LaneClosure";
/*      */       case 78:
/*      */         str = "Chicane";
/*      */       case 77:
/*      */         str = "RoadworkUStext";
/*      */       case 76:
/*      */         str = "Roadwork";
/*      */       case 75:
/*      */         str = "CityExit";
/*      */       case 74:
/*      */         str = "CityEntry";
/*      */       case 73:
/*      */         str = "Reserved73_73";
/*      */       case 72:
/*      */         str = "Reserved72_72";
/*      */       case 71:
/*      */         str = "EndOfHighway";
/*      */       case 70:
/*      */         str = "Highway";
/*      */       case 69:
/*      */         str = "EndOfExpressway";
/*      */       case 68:
/*      */         str = "Expressway";
/*      */       case 67:
/*      */         str = "Reserved67_67";
/*      */       case 66:
/*      */         str = "Reserved66_66";
/*      */       case 65:
/*      */         str = "Reserved65_65";
/*      */       case 64:
/*      */         str = "EndOfSpeedLimit160";
/*      */       case 63:
/*      */         str = "EndOfSpeedLimit155";
/*      */       case 62:
/*      */         str = "EndOfSpeedLimit150";
/*      */       case 61:
/*      */         str = "EndOfSpeedLimit145";
/*      */       case 60:
/*      */         str = "EndOfSpeedLimit140";
/*      */       case 59:
/*      */         str = "EndOfSpeedLimit135";
/*      */       case 58:
/*      */         str = "EndOfSpeedLimit130";
/*      */       case 57:
/*      */         str = "EndOfSpeedLimit125";
/*      */       case 56:
/*      */         str = "EndOfSpeedLimit120";
/*      */       case 55:
/*      */         str = "EndOfSpeedLimit115";
/*      */       case 54:
/*      */         str = "EndOfSpeedLimit110";
/*      */       case 53:
/*      */         str = "EndOfSpeedLimit105";
/*      */       case 52:
/*      */         str = "EndOfSpeedLimit100";
/*      */       case 51:
/*      */         str = "EndOfSpeedLimit95";
/*      */       case 50:
/*      */         str = "EndOfSpeedLimit90";
/*      */       case 49:
/*      */         str = "EndOfSpeedLimit85";
/*      */       case 48:
/*      */         str = "EndOfSpeedLimit80";
/*      */       case 47:
/*      */         str = "EndOfSpeedLimit75";
/*      */       case 46:
/*      */         str = "EndOfSpeedLimit70";
/*      */       case 45:
/*      */         str = "EndOfSpeedLimit65";
/*      */       case 44:
/*      */         str = "EndOfSpeedLimit60";
/*      */       case 43:
/*      */         str = "EndOfSpeedLimit55";
/*      */       case 42:
/*      */         str = "EndOfSpeedLimit50";
/*      */       case 41:
/*      */         str = "EndOfSpeedLimit45";
/*      */       case 40:
/*      */         str = "EndOfSpeedLimit40";
/*      */       case 39:
/*      */         str = "EndOfSpeedLimit35";
/*      */       case 38:
/*      */         str = "EndOfSpeedLimit30";
/*      */       case 37:
/*      */         str = "EndOfSpeedLimit25";
/*      */       case 36:
/*      */         str = "EndOfSpeedLimit20";
/*      */       case 35:
/*      */         str = "EndOfSpeedLimit15";
/*      */       case 34:
/*      */         str = "EndOfSpeedLimit10";
/*      */       case 33:
/*      */         str = "EndOfSpeedLimit5";
/*      */       case 32:
/*      */         str = "SpeedLimit160";
/*      */       case 31:
/*      */         str = "SpeedLimit155";
/*      */       case 30:
/*      */         str = "SpeedLimit150";
/*      */       case 29:
/*      */         str = "SpeedLimit145";
/*      */       case 28:
/*      */         str = "SpeedLimit140";
/*      */       case 27:
/*      */         str = "SpeedLimit135";
/*      */       case 26:
/*      */         str = "SpeedLimit130";
/*      */       case 25:
/*      */         str = "SpeedLimit125";
/*      */       case 24:
/*      */         str = "SpeedLimit120";
/*      */       case 23:
/*      */         str = "SpeedLimit115";
/*      */       case 22:
/*      */         str = "SpeedLimit110";
/*      */       case 21:
/*      */         str = "SpeedLimit105";
/*      */       case 20:
/*      */         str = "SpeedLimit100";
/*      */       case 19:
/*      */         str = "SpeedLimit95";
/*      */       case 18:
/*      */         str = "SpeedLimit90";
/*      */       case 17:
/*      */         str = "SpeedLimit85";
/*      */       case 16:
/*      */         str = "SpeedLimit80";
/*      */       case 15:
/*      */         str = "SpeedLimit75";
/*      */       case 14:
/*      */         str = "SpeedLimit70";
/*      */       case 13:
/*      */         str = "SpeedLimit65";
/*      */       case 12:
/*      */         str = "SpeedLimit60";
/*      */       case 11:
/*      */         str = "SpeedLimit55";
/*      */       case 10:
/*      */         str = "SpeedLimit50";
/*      */       case 9:
/*      */         str = "SpeedLimit45";
/*      */       case 8:
/*      */         str = "SpeedLimit40";
/*      */       case 7:
/*      */         str = "SpeedLimit35";
/*      */       case 6:
/*      */         str = "SpeedLimit30";
/*      */       case 5:
/*      */         str = "SpeedLimit25";
/*      */       case 4:
/*      */         str = "SpeedLimit20";
/*      */       case 3:
/*      */         str = "SpeedLimit15";
/*      */       case 2:
/*      */         str = "SpeedLimit10";
/*      */       case 1:
/*      */         str = "SpeedLimit5";
/*      */       case 0:
/*      */         break;
/*      */     } 
/*      */     str = "Empty";
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
/*      */   public static boolean isValid(int paramInt) {
/* 1572 */     boolean bool = false;
/*      */     
/* 1574 */     if (paramInt == 0 || paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 6 || paramInt == 7 || paramInt == 8 || paramInt == 9 || paramInt == 10 || paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 15 || paramInt == 16 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 63 || paramInt == 64 || paramInt == 65 || paramInt == 66 || paramInt == 67 || paramInt == 68 || paramInt == 69 || paramInt == 70 || paramInt == 71 || paramInt == 72 || paramInt == 73 || paramInt == 74 || paramInt == 75 || paramInt == 76 || paramInt == 77 || paramInt == 78 || paramInt == 79 || paramInt == 80 || paramInt == 81 || paramInt == 82 || paramInt == 83 || paramInt == 84 || paramInt == 85 || paramInt == 86 || paramInt == 87 || paramInt == 88 || paramInt == 89 || paramInt == 90 || paramInt == 91 || paramInt == 92 || paramInt == 93 || paramInt == 94 || paramInt == 95 || paramInt == 96 || paramInt == 97 || paramInt == 98 || paramInt == 99 || paramInt == 100 || paramInt == 101 || paramInt == 102 || paramInt == 103 || paramInt == 129 || paramInt == 130 || paramInt == 131 || paramInt == 132 || paramInt == 133 || paramInt == 134 || paramInt == 135 || paramInt == 136 || paramInt == 137 || paramInt == 138 || paramInt == 139 || paramInt == 140 || paramInt == 141 || paramInt == 142 || paramInt == 143 || paramInt == 144 || paramInt == 145 || paramInt == 146 || paramInt == 147 || paramInt == 148 || paramInt == 149 || paramInt == 150 || paramInt == 151 || paramInt == 152 || paramInt == 153 || paramInt == 154 || paramInt == 155 || paramInt == 156 || paramInt == 157 || paramInt == 158 || paramInt == 159 || paramInt == 160 || paramInt == 193 || paramInt == 194 || paramInt == 195 || paramInt == 196 || paramInt == 197 || paramInt == 200 || paramInt == 202 || paramInt == 203 || paramInt == 204 || paramInt == 205 || paramInt == 206 || paramInt == 208 || paramInt == 209 || paramInt == 210 || paramInt == 211 || paramInt == 213 || paramInt == 214 || paramInt == 215 || paramInt == 254 || paramInt == 255 || paramInt == 20 || paramInt == 21 || paramInt == 22 || paramInt == 23 || paramInt == 24 || paramInt == 25 || paramInt == 26 || paramInt == 27 || paramInt == 28 || paramInt == 29 || paramInt == 30 || paramInt == 31 || paramInt == 32 || paramInt == 33 || paramInt == 34 || paramInt == 35 || paramInt == 36 || paramInt == 37 || paramInt == 38 || paramInt == 39 || paramInt == 40 || paramInt == 41 || paramInt == 42 || paramInt == 43 || paramInt == 44 || paramInt == 45 || paramInt == 46 || paramInt == 47 || paramInt == 48 || paramInt == 49 || paramInt == 50 || paramInt == 51 || paramInt == 52 || paramInt == 53 || paramInt == 54 || paramInt == 55 || paramInt == 56 || paramInt == 57 || paramInt == 58 || paramInt == 59 || paramInt == 60 || paramInt == 61 || paramInt == 62 || paramInt == 104 || paramInt == 105 || paramInt == 106 || paramInt == 107 || paramInt == 108 || paramInt == 109 || paramInt == 110 || paramInt == 111 || paramInt == 112 || paramInt == 113 || paramInt == 114 || paramInt == 115 || paramInt == 116 || paramInt == 117 || paramInt == 118 || paramInt == 119 || paramInt == 120 || paramInt == 121 || paramInt == 122 || paramInt == 123 || paramInt == 124 || paramInt == 125 || paramInt == 126 || paramInt == 127 || paramInt == 128 || paramInt == 161 || paramInt == 162 || paramInt == 163 || paramInt == 164 || paramInt == 165 || paramInt == 166 || paramInt == 167 || paramInt == 168 || paramInt == 169 || paramInt == 170 || paramInt == 171 || paramInt == 172 || paramInt == 173 || paramInt == 174 || paramInt == 175 || paramInt == 176 || paramInt == 177 || paramInt == 178 || paramInt == 179 || paramInt == 180 || paramInt == 181 || paramInt == 182 || paramInt == 183 || paramInt == 184 || paramInt == 185 || paramInt == 186 || paramInt == 187 || paramInt == 188 || paramInt == 189 || paramInt == 190 || paramInt == 191 || paramInt == 192 || paramInt == 198 || paramInt == 199 || paramInt == 201 || paramInt == 207 || paramInt == 212 || paramInt == 216 || paramInt == 217 || paramInt == 218 || paramInt == 219 || paramInt == 220 || paramInt == 221 || paramInt == 222 || paramInt == 223 || paramInt == 224 || paramInt == 225 || paramInt == 226 || paramInt == 227 || paramInt == 228 || paramInt == 229 || paramInt == 230 || paramInt == 231 || paramInt == 232 || paramInt == 233 || paramInt == 234 || paramInt == 235 || paramInt == 236 || paramInt == 237 || paramInt == 238 || paramInt == 239 || paramInt == 240 || paramInt == 241 || paramInt == 242 || paramInt == 243 || paramInt == 244 || paramInt == 245 || paramInt == 246 || paramInt == 247 || paramInt == 248 || paramInt == 249 || paramInt == 250 || paramInt == 251 || paramInt == 252 || paramInt == 253)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1830 */       bool = true;
/*      */     }
/*      */     
/* 1833 */     return bool;
/*      */   }
/*      */   
/*      */   @Retention(RetentionPolicy.SOURCE)
/*      */   public static @interface Enum {}
/*      */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\ecarx\car\hardware\annotation\TsType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */