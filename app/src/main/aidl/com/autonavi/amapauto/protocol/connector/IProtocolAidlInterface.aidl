package com.autonavi.amapauto.protocol.connector;

import com.autonavi.amapauto.protocol.connector.IProtocolCallBackInterface;
import com.autonavi.amapauto.protocol.model.base.ProtocolModel;

interface IProtocolAidlInterface {
    // ID 1
    int f(in ProtocolModel model);
    
    // ID 2
    int v(String str);
    
    // ID 3
    ProtocolModel c(in ProtocolModel model);
    
    // ID 4: original was a(t50) - t50 is another interface but we skip it. 
    // We declare a placeholder to keep IDs aligned.
    void reserved4(); 
    
    // ID 5: b(String, u50)
    void b(String packageName, IProtocolCallBackInterface callback);
    
    // ID 6: a(String, u50)
    void a(String str, IProtocolCallBackInterface callback);
    
    // ID 7: r(String)
    boolean r(String apiKey);
}
