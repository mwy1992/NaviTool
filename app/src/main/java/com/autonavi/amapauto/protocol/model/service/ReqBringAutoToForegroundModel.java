package com.autonavi.amapauto.protocol.model.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amapauto.protocol.model.base.ProtocolBaseModel;

public class ReqBringAutoToForegroundModel extends ProtocolBaseModel {
    // Protocol ID 80005
    public int type = 0; // Usually 0 or doesn't matter for simple toggle

    public ReqBringAutoToForegroundModel() {
        setProtocolID(80005);
    }

    protected ReqBringAutoToForegroundModel(Parcel in) {
        super(in);
        this.type = in.readInt();
    }

    public static final Creator<ReqBringAutoToForegroundModel> CREATOR = new Creator<ReqBringAutoToForegroundModel>() {
        @Override
        public ReqBringAutoToForegroundModel createFromParcel(Parcel in) {
            return new ReqBringAutoToForegroundModel(in);
        }

        @Override
        public ReqBringAutoToForegroundModel[] newArray(int size) {
            return new ReqBringAutoToForegroundModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.type);
    }
}
