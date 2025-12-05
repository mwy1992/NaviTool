package ru.monjaro.mconfig

/**
 * Created by Shakiba E Nur on 18,May,2023
 */
fun interface UnregisterEvent {

    /**
     * unregisters the [ViewTreeObserver.OnGlobalLayoutListener] and there by does not provide any more callback to the [KeyboardVisibilityEventListener]
     */
    fun unregister()
}