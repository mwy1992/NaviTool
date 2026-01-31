package com.autonavi.amapauto.CameraLightInfo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 巡航红绿灯信息 (来自原生高德9.1 Hook广播)
 * 包名必须与原生高德一致才能正确反序列化
 */
public class CameraLightInfo implements Parcelable {
    public int a; // waitNum - 等待轮次
    public int c; // direction - 方向 (0=直行, 1=左转, 2=右转, 3=掉头)
    public int d; // status - 状态 (0=未知, 1=红灯, 2=绿灯, 3=黄灯)
    public int e; // countDown - 倒计时秒数
    public int f; // showType - 显示类型

    public CameraLightInfo() {
    }

    protected CameraLightInfo(Parcel in) {
        a = in.readInt();
        c = in.readInt();
        d = in.readInt();
        e = in.readInt();
        f = in.readInt();
    }

    public static final Creator<CameraLightInfo> CREATOR = new Creator<CameraLightInfo>() {
        @Override
        public CameraLightInfo createFromParcel(Parcel in) {
            return new CameraLightInfo(in);
        }

        @Override
        public CameraLightInfo[] newArray(int size) {
            return new CameraLightInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(a);
        dest.writeInt(c);
        dest.writeInt(d);
        dest.writeInt(e);
        dest.writeInt(f);
    }

    @Override
    public String toString() {
        return "CameraLightInfo{" +
                "waitNum=" + a +
                ", direction=" + c +
                ", status=" + d +
                ", countDown=" + e +
                ", showType=" + f +
                '}';
    }
}
