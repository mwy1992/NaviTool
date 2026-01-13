package com.autonavi.amapauto.protocol.model.service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * [FIX] Missing Class Definition
 * Restored to resolve ClassNotFoundException during Amap AIDL communication.
 */
public class RspGpsStatusNotifyModel implements Parcelable {
    public int status;
    public int satelliteCount;

    public RspGpsStatusNotifyModel() {
    }

    protected RspGpsStatusNotifyModel(Parcel in) {
        status = in.readInt();
        satelliteCount = in.readInt();
    }

    public static final Creator<RspGpsStatusNotifyModel> CREATOR = new Creator<RspGpsStatusNotifyModel>() {
        @Override
        public RspGpsStatusNotifyModel createFromParcel(Parcel in) {
            return new RspGpsStatusNotifyModel(in);
        }

        @Override
        public RspGpsStatusNotifyModel[] newArray(int size) {
            return new RspGpsStatusNotifyModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeInt(satelliteCount);
    }
}
