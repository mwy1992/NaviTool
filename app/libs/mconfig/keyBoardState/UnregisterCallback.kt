package ru.monjaro.mconfig

/**
 * Created by Shakiba E Nur on 18,May,2023
 */

import android.app.Activity
import android.os.Build
import android.view.ViewTreeObserver

import java.lang.ref.WeakReference

/**
 * Created by Shakiba E Nur on 18,May,2023
 */

class UnregisterCallback internal constructor(
    activity: Activity,
    globalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener
) : UnregisterEvent{

    private val activityWeakReference: WeakReference<Activity> = WeakReference(activity)

    private val onGlobalLayoutListenerWeakReference: WeakReference<ViewTreeObserver.OnGlobalLayoutListener> =
        WeakReference(globalLayoutListener)

    override fun unregister() {
        val activity = activityWeakReference.get()
        val globalLayoutListener = onGlobalLayoutListenerWeakReference.get()

        if (null != activity && null != globalLayoutListener) {
            val activityRoot = KeyboardStateEvent.getActivityRoot(activity)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                activityRoot.viewTreeObserver
                    .removeOnGlobalLayoutListener(globalLayoutListener)
            } else {
                @Suppress("DEPRECATION")
                activityRoot.viewTreeObserver
                    .removeGlobalOnLayoutListener(globalLayoutListener)
            }
        }

        activityWeakReference.clear()
        onGlobalLayoutListenerWeakReference.clear()
    }
}