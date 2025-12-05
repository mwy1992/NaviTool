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
