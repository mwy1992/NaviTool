package ru.monjaro.mconfig

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.annotation.SuppressLint
import android.hardware.display.DisplayManager
import android.provider.Settings
import android.util.DisplayMetrics
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast


class PnAccessibilityService : AccessibilityService() {

    private val info = AccessibilityServiceInfo()

    //    private var arrPackages = arrayListOf<String>()
    companion object {
        var topPackageName:String?=null
        var accessibilityStarted = false
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        //TYPE_WINDOW_STATE_CHANGED == 32
         if (AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED == event.eventType
        ) {
             if (event.packageName != null && event.isFullScreen && event.packageName.toString() != "com.ecarx.dimmenu" && event.packageName.toString() != "com.ecarx.hud" && event.packageName.toString() != "com.android.systemui" && !event.packageName.toString().contains("com.google.android.inputmethod")) {
                topPackageName = event.packageName.toString()
//                 Toast.makeText(
//                     applicationContext,
//                     topPackageName,
//                     Toast.LENGTH_SHORT
//                 )
//                     .show()
            }
        }
    }
    override fun onServiceConnected() {
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK
        info.notificationTimeout = 100
        info.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS or AccessibilityServiceInfo.FLAG_RETRIEVE_INTERACTIVE_WINDOWS

        accessibilityStarted = true

        this.serviceInfo = info
        if(!MConfigStartProc.bootStartService) {
            MConfigStartProc.bootStartService = true
            MConfigStartProc.startService(applicationContext, false)
            MConfigStartProc.startInitService(applicationContext)
        }
    }
    override fun onInterrupt() {

    }
}