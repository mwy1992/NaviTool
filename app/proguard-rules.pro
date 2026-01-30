# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\mwy19\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# Keep OneOS AIDL interfaces
-keep class com.geely.lib.oneosapi.** { *; }
-keep interface com.geely.lib.oneosapi.** { *; }
-keep class com.geely.service.oneosapi.** { *; }

# Keep Ecarx interfaces
-keep class com.ecarx.** { *; }
-keep interface com.ecarx.** { *; }
-keep class ecarx.** { *; }
-keep interface ecarx.** { *; }

# Keep App Components (Activities, Services, Receivers are usually kept by default aapt rules, but explicit is safe)
-keep class cn.navitool.MainActivity { *; }
-keep class cn.navitool.KeepAliveAccessibilityService { *; }
-keep class cn.navitool.BootReceiver { *; }
-keep class cn.navitool.BootLogService { *; }

# Keep AppLaunchManager and its inner classes (used for JSON serialization/deserialization if any, or reflection)
-keep class cn.navitool.AppLaunchManager { *; }
-keep class cn.navitool.AppLaunchManager$** { *; }

# Keep DebugLogger
-keep class cn.navitool.DebugLogger { *; }

# Suppress warnings for missing classes from compileOnly dependencies (ECARX & Android Hidden APIs)
-dontwarn android.annotation.SystemApi
-dontwarn android.app.IActivityManager
-dontwarn android.bluetooth.BluetoothContact
-dontwarn android.content.IContentProvider
-dontwarn android.content.IInputDispatcherService**
-dontwarn android.hardware.display.DisplayManagerGlobal
-dontwarn android.media.AudioFocusInfo
-dontwarn android.media.audiopolicy.**
-dontwarn android.net.wifi.**
-dontwarn android.os.**
-dontwarn android.view.**
-dontwarn com.android.internal.annotations.GuardedBy
-dontwarn com.ecarx.car.audio.manager.**
-dontwarn com.geely.permission.**
-dontwarn libcore.io.IoUtils
-dontwarn android.car.**
-dontwarn com.ecarx.**
-dontwarn ecarx.**
-dontwarn ecarx.adaptapi.**
-ignorewarnings


# ------------------------------------------------------------
# [ADDED 2026-01-30] Comprehensive Rules for Navitool
# ------------------------------------------------------------

# 1. Custom Views (Used in XML Layouts)
-keep class cn.navitool.view.** { *; }

# 2. AIDL Interfaces (AMap & Geely)
-keep class com.autonavi.amapauto.aidl.** { *; }
-keep interface com.autonavi.amapauto.aidl.** { *; }
-keep class com.geely.map.** { *; }
-keep interface com.geely.map.** { *; }

# 3. Data Models (Prevent obfuscation of fields used in JSON parsing)
-keep class cn.navitool.model.** { *; }

# 4. Interfaces
-keep class cn.navitool.interfaces.** { *; }

# 5. Managers & Controllers (Keep public methods for stability)
-keep class cn.navitool.managers.** {
    public <methods>;
    public <init>(...);
}
-keep class cn.navitool.theme.** {
    public <methods>;
    public <init>(...);
}

# 6. Third Parties
# ADB Lib
-keep class com.tananaev.adblib.** { *; }

# Gson (if used implicitly)
#-keep class com.google.gson.** { *; }
