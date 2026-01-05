package com.autonavi.amapauto.protocol.connector;

import com.autonavi.amapauto.protocol.model.base.ProtocolModel;
import com.autonavi.amapauto.protocol.model.service.ProtocolErrorModel;

interface IProtocolCallBackInterface {
    // ID 1: a(ProtocolModel)
    void onReceiveProtocolModel(in ProtocolModel model);
    
    // ID 2: a(ProtocolErrorModel)
    void onReceiveErrorModel(in ProtocolErrorModel errorModel);
    
    // ID 3: e(ProtocolModel)
    void onReceiveProtocolModelE(in ProtocolModel model);
    
    // ID 4: m(String)
    void onReceiveJson(String json);
    
    // ID 5: z(String)
    void onReceiveJsonResult(String jsonResult);
}
