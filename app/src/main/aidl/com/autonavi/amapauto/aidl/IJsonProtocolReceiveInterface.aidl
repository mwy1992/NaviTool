package com.autonavi.amapauto.aidl;

interface IJsonProtocolReceiveInterface {
    void received(String message);
    String receivedSync(String message);
}
