package com.geely.lib.oneosapi.input;

interface IInputListener {
    /** Transaction 1 */
    void onKeyEvent(int keyCode, int event, int keyController);
    /** Transaction 2 */
    void onShortClick(int keyCode, int keyController);
    /** Transaction 3 */
    void onHoldingPressStarted(int keyCode, int keyController);
    /** Transaction 4 */
    void onHoldingPressStopped(int keyCode, int keyController);
    /** Transaction 5 */
    void onLongPressTriggered(int keyCode, int keyController);
    /** Transaction 6 */
    void onDoubleClick(int keyCode, int keyController);
}
