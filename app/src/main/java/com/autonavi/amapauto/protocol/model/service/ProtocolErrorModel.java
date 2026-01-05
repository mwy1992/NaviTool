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
        super(in); // Reading Base part
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
        super.writeToParcel(dest, flags); // Writing Base part
        dest.writeInt(this.resultCode);
        dest.writeString(this.errorMessage);
    }
}
