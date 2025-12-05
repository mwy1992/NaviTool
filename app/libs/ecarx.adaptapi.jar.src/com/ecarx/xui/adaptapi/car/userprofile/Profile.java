/*     */ package com.ecarx.xui.adaptapi.car.userprofile;
/*     */ 
/*     */ import android.util.Log;
/*     */ import ecarx.car.hardware.vehicle.PATypes;
/*     */ import java.lang.reflect.Field;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Arrays;
/*     */ import java.util.OptionalInt;
/*     */ import java.util.stream.IntStream;
/*     */ import java.util.stream.Stream;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Profile
/*     */   implements IProfile
/*     */ {
/*     */   public static final int CAR_FUNC_AMBIENCE_LIGHT_DRIVE_MODE = 251658752;
/*     */   public static final int CAR_FUNC_AMBIENCE_LIGHT_MOOD_LIGHT_COLOR = 251662080;
/*     */   public static final int CAR_FUNC_AMBIENCE_LIGHT_MUSIC_MODE = 251659264;
/*     */   public static final int CAR_FUNC_AMBIENCE_LIGHT_WEATHER_MODE = 251659008;
/*     */   public static final int CAR_FUNC_AUTO_REAR_WIPER = 251658496;
/*     */   public static final int CAR_FUNC_FACE_ID_BIND = 251660032;
/*     */   public static final int CAR_FUNC_FACE_ID_UNBIND = 251659776;
/*     */   public static final int CAR_FUNC_HUD_MODE = 251660288;
/*     */   public static final int CAR_FUNC_PAS_3D_SURROUND = 251661056;
/*     */   public static final int CAR_FUNC_PAS_GUIDE = 251660544;
/*     */   public static final int CAR_FUNC_PAS_LOOKING_DOWN = 251661312;
/*     */   public static final int CAR_FUNC_PAS_OBSTACLE_DETECTION = 251660800;
/*     */   public static final int CAR_FUNC_PAS_TRANSPARENT_MODEL = 251661824;
/*     */   public static final int CAR_FUNC_PAS_TURN_ROUND = 251661568;
/*     */   public static final int CAR_FUNC_UNIT_VOLUME = 251659520;
/*     */   private static final int CAR_MODULE_CUSTOM = 251658240;
/*     */   private static final String TAG = "Profile_API";
/*     */   private final UserProfile.ProfileFunction[] mFunctions;
/*     */   private final PATypes.PA_PSET_ProfileCloudData mProfileData;
/*     */   
/*     */   public Profile(UserProfile paramUserProfile, PATypes.PA_PSET_ProfileCloudData paramPA_PSET_ProfileCloudData) {
/*  64 */     this.mProfileData = paramPA_PSET_ProfileCloudData;
/*  65 */     this.mFunctions = paramUserProfile.getClass().<UserProfile.ProfileFunction>getAnnotationsByType(UserProfile.ProfileFunction.class);
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
/*     */   public int getProfileFuncValue(int paramInt1, int paramInt2) {
/*  83 */     Stream<UserProfile.ProfileFunction> stream2 = Arrays.stream(this.mFunctions); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/*  84 */     Stream<UserProfile.ProfileFunction> stream1 = stream2.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$Profile$VTXXQ5Gb1XSzI8NMU35rbSSAcYw -$$Lambda$Profile$VTXXQ5Gb1XSzI8NMU35rbSSAcYw = -$$Lambda$Profile$VTXXQ5Gb1XSzI8NMU35rbSSAcYw.INSTANCE;
/*  85 */     stream1 = stream1.filter(-$$Lambda$Profile$VTXXQ5Gb1XSzI8NMU35rbSSAcYw); -$$Lambda$Profile$353OGQn0hOQot-axXQQpCe08mLc -$$Lambda$Profile$353OGQn0hOQot-axXQQpCe08mLc = new -$$Lambda$Profile$353OGQn0hOQot-axXQQpCe08mLc(paramInt1, paramInt2);
/*  86 */     stream1 = stream1.filter(-$$Lambda$Profile$353OGQn0hOQot-axXQQpCe08mLc); -$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA -$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA = -$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA.INSTANCE;
/*     */     
/*  88 */     Stream<?> stream = stream1.map(-$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA); -$$Lambda$Profile$xg7DXjvkAbx2uJ7R6gVWrDgb1pg -$$Lambda$Profile$xg7DXjvkAbx2uJ7R6gVWrDgb1pg = new -$$Lambda$Profile$xg7DXjvkAbx2uJ7R6gVWrDgb1pg(this);
/*  89 */     stream = stream.flatMap(-$$Lambda$Profile$xg7DXjvkAbx2uJ7R6gVWrDgb1pg); -$$Lambda$Profile$UYJNKOOWzuwEWVl1EYvN8sRmBvw -$$Lambda$Profile$UYJNKOOWzuwEWVl1EYvN8sRmBvw = -$$Lambda$Profile$UYJNKOOWzuwEWVl1EYvN8sRmBvw.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     IntStream intStream = stream.mapToInt(-$$Lambda$Profile$UYJNKOOWzuwEWVl1EYvN8sRmBvw);
/* 100 */     OptionalInt optionalInt = intStream.findFirst();
/* 101 */     return optionalInt.orElse(0);
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
/*     */   public float getProfileFuncValueFloat(int paramInt1, int paramInt2) {
/* 116 */     Stream<UserProfile.ProfileFunction> stream3 = Arrays.stream(this.mFunctions); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/* 117 */     Stream<UserProfile.ProfileFunction> stream1 = stream3.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$Profile$fkE1g9K6A7PiS89DFft4Q1Fa6yM -$$Lambda$Profile$fkE1g9K6A7PiS89DFft4Q1Fa6yM = -$$Lambda$Profile$fkE1g9K6A7PiS89DFft4Q1Fa6yM.INSTANCE;
/* 118 */     Stream<UserProfile.ProfileFunction> stream2 = stream1.filter(-$$Lambda$Profile$fkE1g9K6A7PiS89DFft4Q1Fa6yM); -$$Lambda$Profile$6haxj_wKXhh5QRRLjw3nZNeqMhA -$$Lambda$Profile$6haxj_wKXhh5QRRLjw3nZNeqMhA = new -$$Lambda$Profile$6haxj_wKXhh5QRRLjw3nZNeqMhA(paramInt1, paramInt2);
/* 119 */     stream2 = stream2.filter(-$$Lambda$Profile$6haxj_wKXhh5QRRLjw3nZNeqMhA); -$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA -$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA = -$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA.INSTANCE;
/*     */     
/* 121 */     stream2 = stream2.map(-$$Lambda$9YHdkrow-gvHWqq3B7DOd6t8uLA); -$$Lambda$Profile$tEeaxEiOyzt1jqkD_n4h-laykBo -$$Lambda$Profile$tEeaxEiOyzt1jqkD_n4h-laykBo = new -$$Lambda$Profile$tEeaxEiOyzt1jqkD_n4h-laykBo(this);
/* 122 */     Stream<?> stream = stream2.flatMap(-$$Lambda$Profile$tEeaxEiOyzt1jqkD_n4h-laykBo); -$$Lambda$Profile$CFmawERW9NcnBJAXI_wmb03HZUM -$$Lambda$Profile$CFmawERW9NcnBJAXI_wmb03HZUM = -$$Lambda$Profile$CFmawERW9NcnBJAXI_wmb03HZUM.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     IntStream intStream = stream.mapToInt(-$$Lambda$Profile$CFmawERW9NcnBJAXI_wmb03HZUM);
/* 134 */     OptionalInt optionalInt = intStream.findFirst();
/* 135 */     return optionalInt.orElse(0);
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
/*     */   public boolean containsProfileFuncId(int paramInt1, int paramInt2) {
/* 150 */     Stream<UserProfile.ProfileFunction> stream3 = Arrays.stream(this.mFunctions); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/* 151 */     Stream<UserProfile.ProfileFunction> stream1 = stream3.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$Profile$RI740Ml7cQO5U8nNQmoywIGUr6U -$$Lambda$Profile$RI740Ml7cQO5U8nNQmoywIGUr6U = -$$Lambda$Profile$RI740Ml7cQO5U8nNQmoywIGUr6U.INSTANCE;
/* 152 */     Stream<UserProfile.ProfileFunction> stream2 = stream1.filter(-$$Lambda$Profile$RI740Ml7cQO5U8nNQmoywIGUr6U); -$$Lambda$Profile$eGvT1B6-k-uCogEYfJ8_RHkOqdI -$$Lambda$Profile$eGvT1B6-k-uCogEYfJ8_RHkOqdI = new -$$Lambda$Profile$eGvT1B6-k-uCogEYfJ8_RHkOqdI(paramInt1, paramInt2);
/* 153 */     return stream2.anyMatch(-$$Lambda$Profile$eGvT1B6-k-uCogEYfJ8_RHkOqdI);
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
/*     */   public int[] getContainsProfileFuncIds() {
/* 168 */     Stream<UserProfile.ProfileFunction> stream1 = Arrays.stream(this.mFunctions); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/* 169 */     Stream<UserProfile.ProfileFunction> stream2 = stream1.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$Profile$KUi1iF6p_bJOP7A3YNoedJx4G7U -$$Lambda$Profile$KUi1iF6p_bJOP7A3YNoedJx4G7U = -$$Lambda$Profile$KUi1iF6p_bJOP7A3YNoedJx4G7U.INSTANCE;
/* 170 */     stream2 = stream2.filter(-$$Lambda$Profile$KUi1iF6p_bJOP7A3YNoedJx4G7U); -$$Lambda$Profile$GTAyuuEPSme7ywsVidnzL4-YHIo -$$Lambda$Profile$GTAyuuEPSme7ywsVidnzL4-YHIo = -$$Lambda$Profile$GTAyuuEPSme7ywsVidnzL4-YHIo.INSTANCE;
/* 171 */     IntStream intStream = stream2.mapToInt(-$$Lambda$Profile$GTAyuuEPSme7ywsVidnzL4-YHIo);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     return intStream.distinct().toArray();
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
/*     */   public int[] getProfileSupportedZones(int paramInt) {
/* 190 */     Stream<UserProfile.ProfileFunction> stream = Arrays.stream(this.mFunctions); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/* 191 */     stream = stream.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$Profile$H-JB7CIUaHoPd1t4XfwZnC8woDw -$$Lambda$Profile$H-JB7CIUaHoPd1t4XfwZnC8woDw = -$$Lambda$Profile$H-JB7CIUaHoPd1t4XfwZnC8woDw.INSTANCE;
/* 192 */     stream = stream.filter(-$$Lambda$Profile$H-JB7CIUaHoPd1t4XfwZnC8woDw); -$$Lambda$Profile$vZnxn09N0D01gsCPNbL6jx_TBLE -$$Lambda$Profile$vZnxn09N0D01gsCPNbL6jx_TBLE = new -$$Lambda$Profile$vZnxn09N0D01gsCPNbL6jx_TBLE(paramInt);
/* 193 */     stream = stream.filter(-$$Lambda$Profile$vZnxn09N0D01gsCPNbL6jx_TBLE); -$$Lambda$KTtxw46mBdPaTuhqzvrdtOf0iwU -$$Lambda$KTtxw46mBdPaTuhqzvrdtOf0iwU = -$$Lambda$KTtxw46mBdPaTuhqzvrdtOf0iwU.INSTANCE;
/* 194 */     IntStream intStream = stream.mapToInt(-$$Lambda$KTtxw46mBdPaTuhqzvrdtOf0iwU);
/* 195 */     return intStream.toArray();
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
/*     */   public String toJOSNString() {
/* 214 */     JSONObject jSONObject = new JSONObject();
/* 215 */     Stream<UserProfile.ProfileFunction> stream2 = Arrays.stream(this.mFunctions); -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4 = -$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4.INSTANCE;
/* 216 */     Stream<UserProfile.ProfileFunction> stream3 = stream2.filter(-$$Lambda$R8KIpRS4esTymPJiS6KIECILsK4); -$$Lambda$Profile$8B279E2CjHh3sEhUALX1lWedeVE -$$Lambda$Profile$8B279E2CjHh3sEhUALX1lWedeVE = -$$Lambda$Profile$8B279E2CjHh3sEhUALX1lWedeVE.INSTANCE;
/* 217 */     Stream<UserProfile.ProfileFunction> stream1 = stream3.filter(-$$Lambda$Profile$8B279E2CjHh3sEhUALX1lWedeVE); -$$Lambda$Profile$SI4aeCmljteZOu3dg3tvSGIF46o -$$Lambda$Profile$SI4aeCmljteZOu3dg3tvSGIF46o = new -$$Lambda$Profile$SI4aeCmljteZOu3dg3tvSGIF46o(this, jSONObject);
/* 218 */     stream1.forEach(-$$Lambda$Profile$SI4aeCmljteZOu3dg3tvSGIF46o);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     Log.i("Profile_API", jSONObject.toString());
/* 229 */     return jSONObject.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getUserPreferenceIdCreated(int paramInt) {
/* 240 */     return new int[0];
/*     */   }
/*     */   
/*     */   private String createJsonKey(int paramInt1, int paramInt2) {
/* 244 */     if (paramInt2 == Integer.MIN_VALUE) {
/* 245 */       return String.valueOf(paramInt1);
/*     */     }
/* 247 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramInt1); stringBuilder.append("|"); stringBuilder.append(paramInt2); return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private int reflectFiled(String paramString) {
/* 251 */     if (this.mProfileData == null) {
/* 252 */       Log.i("Profile_API", "ProfileData is null");
/* 253 */       return 0;
/*     */     } 
/* 255 */     Class<?> clazz = this.mProfileData.getClass();
/*     */     try {
/* 257 */       Field field = clazz.getDeclaredField(paramString);
/* 258 */       field.setAccessible(true);
/* 259 */       return field.getInt(this.mProfileData);
/* 260 */     } catch (NoSuchFieldException|IllegalAccessException noSuchFieldException) {
/* 261 */       noSuchFieldException.printStackTrace();
/*     */       
/* 263 */       return 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\ca\\userprofile\Profile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */