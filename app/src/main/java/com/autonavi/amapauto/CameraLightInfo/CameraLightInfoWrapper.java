package com.autonavi.amapauto.CameraLightInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 巡航红绿灯信息包装器 (来自原生高德9.1 Hook广播)
 * 包名必须与原生高德一致才能正确反序列化
 */
public class CameraLightInfoWrapper implements Parcelable {
    public List<CameraLightInfo> a; // 红绿灯信息列表

    public CameraLightInfoWrapper() {
        a = new ArrayList<>();
    }

    protected CameraLightInfoWrapper(Parcel in) {
        int size = in.readInt();
        a = new ArrayList<>();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                // The native side uses a custom serializer (ue.smali) effectively writing:
                // [Int: Manual Length] [Int: Standard ByteArray Length] [Bytes...]
                // We need to skip the two length headers to align with the actual object data.
                int manualLen = in.readInt();
                int standardLen = in.readInt(); // This is likely redundantly written by writeByteArray

                // Read the actual object data
                CameraLightInfo info = new CameraLightInfo(in);
                a.add(info);
            }
        }
    }

    public static final Creator<CameraLightInfoWrapper> CREATOR = new Creator<CameraLightInfoWrapper>() {
        @Override
        public CameraLightInfoWrapper createFromParcel(Parcel in) {
            return new CameraLightInfoWrapper(in);
        }

        @Override
        public CameraLightInfoWrapper[] newArray(int size) {
            return new CameraLightInfoWrapper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(a);
    }

    @Override
    public String toString() {
        return "CameraLightInfoWrapper{cameraInfos=" + a + '}';
    }
}
