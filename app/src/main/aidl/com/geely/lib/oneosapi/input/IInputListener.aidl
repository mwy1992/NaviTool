package com.geely.lib.oneosapi.input;

interface IInputListener {
    /** Transaction 1 */
    void onKeyEvent(int keyCode, int event, int softKeyFunction);
    /** Transaction 2 */
    void onShortClick(int keyCode, int softKeyFunction);
    /** Transaction 3 */
    void onLongPressTriggered(int keyCode, int softKeyFunction);
    /** Transaction 4 */
    void onHoldingPressStopped(int keyCode, int softKeyFunction);
    /** Transaction 5 */
    void onLongPress(int keyCode, int softKeyFunction);
    /** Transaction 6 */
    void onDoubleClick(int keyCode, int softKeyFunction);
}
