package com.autonavi.amapauto.aidl;

import com.autonavi.amapauto.aidl.IJsonProtocolReceiveInterface;

interface IJsonProtocolInterface {
    void request(String requestAuthor, String jsonString);
    void registerReceive(String requestAuthor, IJsonProtocolReceiveInterface receiveInterface);
    void unregisterCallback(String requestAuthor, IJsonProtocolReceiveInterface receiveInterface);
}
