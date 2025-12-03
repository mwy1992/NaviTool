package com.geely.lib.oneosapi.input;

import com.geely.lib.oneosapi.input.IInputListener;

interface IInputManager {
    /** Transaction 1 - Placeholder */
    void method1();
    /** Transaction 2 - Placeholder */
    void method2();
    /** Transaction 3 */
    void registerListener(IInputListener listener, String packageName, in int[] keyCodes);
    /** Transaction 4 */
    void unregisterListener(IInputListener listener, String packageName);
    /** Transaction 5 */
    int getSomething();
}
