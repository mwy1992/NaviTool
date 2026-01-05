# 高德 AIDL 接口集成文件

为了通过 AIDL 与高德地图车机版通信，您需要将以下文件添加到您的 Android 工程中。请严格保持包名一致。

## 1. AIDL 文件

请在 `src/main/aidl/com/autonavi/amapauto/protocol/connector/` 目录下创建以下 AIDL 文件。

### `IProtocolAidlInterface.aidl`

```java
package com.autonavi.amapauto.protocol.connector;

import com.autonavi.amapauto.protocol.connector.IProtocolCallBackInterface;
import com.autonavi.amapauto.protocol.model.base.ProtocolModel;

interface IProtocolAidlInterface {
    // 发送带有回调的协议数据
    int f(in ProtocolModel model);
    
    // 验证/握手？
    int v(String str);
    
    // 获取/同步数据？
    ProtocolModel c(in ProtocolModel model);
    
    // 注册回调 (void a(t50 p0) in obfuscated code)
    // 注意：混淆代码中 t50 可能对应另一个 AIDL，这里简化处理，
    // 重点关注 b 和 a 方法用于注册回调
    
    // 注册回调 (包名, 回调接口)
    void b(String packageName, IProtocolCallBackInterface callback);
    
    // 另一种注册/发送方式
    void a(String str, IProtocolCallBackInterface callback);
    
    // 鉴权/握手 (ProtocolAidlControl.authentication 调用此方法)
    boolean r(String apiKey);
}
```

### `IProtocolCallBackInterface.aidl`

```java
package com.autonavi.amapauto.protocol.connector;

import com.autonavi.amapauto.protocol.model.base.ProtocolModel;
import com.autonavi.amapauto.protocol.model.service.ProtocolErrorModel;

interface IProtocolCallBackInterface {
    // 接收普通协议数据
    void a(in ProtocolModel model);
    
    // 接收错误信息
    void a(in ProtocolErrorModel errorModel);
    
    // 接收另一种协议数据 (e 方法)
    void e(in ProtocolModel model);
    
    // 接收 JSON 字符串消息 (m 方法)
    void m(String json);
    
    // 接收 JSON 结果 (z 方法)
    void z(String jsonResult);
}
```

## 2. Java 模型类

请在 `src/main/java/com/autonavi/amapauto/protocol/model/` 对应子包下创建以下类。AIDL 传递对象需要实现 Parcelable。

### `base/ProtocolBaseModel.java`

```java
package com.autonavi.amapauto.protocol.model.base;

import android.os.Parcel;
import android.os.Parcelable;

public class ProtocolBaseModel implements Parcelable {
    public int protocolID;
    public long timeStamp;
    public int callbackId;
    public String protocolVersion;
    public String packageName;
    public String var1;
    public String clientPackageName; // 注意：部分版本可能不需要写入 Parcel，视反编译具体逻辑而定

    public ProtocolBaseModel() {
        this.protocolID = 0;
        this.timeStamp = 0L;
        this.callbackId = 0;
        this.packageName = "";
        this.var1 = "";
        this.clientPackageName = "";
    }

    protected ProtocolBaseModel(Parcel in) {
        this.protocolID = in.readInt();
        this.timeStamp = in.readLong();
        this.callbackId = in.readInt();
        this.protocolVersion = in.readString();
        this.packageName = in.readString();
        this.var1 = in.readString();
    }

    public static final Creator<ProtocolBaseModel> CREATOR = new Creator<ProtocolBaseModel>() {
        @Override
        public ProtocolBaseModel createFromParcel(Parcel in) {
            return new ProtocolBaseModel(in);
        }

        @Override
        public ProtocolBaseModel[] newArray(int size) {
            return new ProtocolBaseModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.protocolID);
        dest.writeLong(this.timeStamp);
        dest.writeInt(this.callbackId);
        dest.writeString(this.protocolVersion);
        dest.writeString(this.packageName);
        dest.writeString(this.var1);
    }
    
    // Getters and Setters...
    public int getProtocolID() { return protocolID; }
    public void setProtocolID(int protocolID) { this.protocolID = protocolID; }
    public int getCallbackId() { return callbackId; }
    public void setCallbackId(int callbackId) { this.callbackId = callbackId; }
}
```

### `base/ProtocolModel.aidl`

```java
package com.autonavi.amapauto.protocol.model.base;

parcelable ProtocolModel;
```

### `base/ProtocolModel.java`

```java
package com.autonavi.amapauto.protocol.model.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ProtocolModel<T extends ProtocolBaseModel> implements Parcelable {
    private static final String TAG = "ProtocolModel";
    public T data;

    public ProtocolModel() {}

    protected ProtocolModel(Parcel in) {
        String className = in.readString();
        if (!TextUtils.isEmpty(className)) {
            try {
                Class<?> clazz = Class.forName(className);
                data = in.readParcelable(clazz.getClassLoader());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static final Creator<ProtocolModel> CREATOR = new Creator<ProtocolModel>() {
        @Override
        public ProtocolModel createFromParcel(Parcel in) {
            return new ProtocolModel(in);
        }

        @Override
        public ProtocolModel[] newArray(int size) {
            return new ProtocolModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (data != null) {
            dest.writeString(data.getClass().getName());
            dest.writeParcelable(data, flags);
        } else {
            dest.writeString("");
        }
    }
}
```

### `service/ProtocolErrorModel.aidl`

```java
package com.autonavi.amapauto.protocol.model.service;

parcelable ProtocolErrorModel;
```

### `service/ProtocolErrorModel.java`

```java
package com.autonavi.amapauto.protocol.model.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amapauto.protocol.model.base.ProtocolBaseModel;

public class ProtocolErrorModel extends ProtocolBaseModel implements Parcelable {
    public int resultCode;
    public String errorMessage;

    public ProtocolErrorModel(int resultCode) {
        this.resultCode = resultCode;
        this.errorMessage = "";
    }

    protected ProtocolErrorModel(Parcel in) {
        super(in); // 读取 Base 部分
        this.resultCode = in.readInt();
        this.errorMessage = in.readString();
    }

    public static final Creator<ProtocolErrorModel> CREATOR = new Creator<ProtocolErrorModel>() {
        @Override
        public ProtocolErrorModel createFromParcel(Parcel in) {
            return new ProtocolErrorModel(in);
        }

        @Override
        public ProtocolErrorModel[] newArray(int size) {
            return new ProtocolErrorModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags); // 写入 Base 部分
        dest.writeInt(this.resultCode);
        dest.writeString(this.errorMessage);
    }
}
```

## 3. 鉴权配置

在高德的反编译代码中发现，连接服务时会检查客户端的 `AndroidManifest.xml` 元数据。请在您的 `AndroidManifest.xml` 的 `<application>` 标签内添加：

```xml
<meta-data
    android:name="com.autonavi.amapauto.protocol.apikey"
    android:value="AlSimulate" />
```

**关于私钥**:
目前分析来看，代码中使用了 `"AlSimulate"` 字符串作为硬编码的 Key 进行传递 (`r("AlSimulate")`)，并未发现通过 AIDL 传递 RSA/ECC 签名的逻辑。这可能是一种调试模式或 simulate 模式的后门。因此，您不需要私钥，只需正确配置上述 meta-data 并尝试调用 `r("AlSimulate")` 即可。

## 4. 连接示例代码

```java
// 绑定服务
Intent intent = new Intent();
intent.setAction("com.autonavi.amapauto.protocolService");
intent.setPackage("com.autonavi.amapauto");
bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

// ServiceConnection 中
public void onServiceConnected(ComponentName name, IBinder service) {
    IProtocolAidlInterface aidl = IProtocolAidlInterface.Stub.asInterface(service);
    try {
        // 1. 鉴权
        boolean auth = aidl.r("AlSimulate");
        Log.d("NaviTool", "Auth result: " + auth);
        
        // 2. 注册回调
        aidl.b(getPackageName(), new IProtocolCallBackInterface.Stub() {
            @Override
            public void a(ProtocolModel model) throws RemoteException {
                 // 处理回调数据
                 if (model.data != null) {
                     Log.d("NaviTool", "Received: " + model.data.getClass().getName());
                 }
            }
            // ... 实现其他方法
        });
    } catch (RemoteException e) {
        e.printStackTrace();
    }
}
```
