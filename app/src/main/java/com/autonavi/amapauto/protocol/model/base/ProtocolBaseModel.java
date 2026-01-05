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
    public String clientPackageName;

    public ProtocolBaseModel() {
        this.protocolID = 0;
        this.timeStamp = 0L;
        this.callbackId = 0;
        this.protocolVersion = Integer.toString(getModelVersion());
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
        dest.writeString(Integer.toString(getDataVersion()));
        dest.writeString(this.packageName);
        dest.writeString(this.var1);
    }

    public int getModelVersion() {
        return 0; // Default, subclasses override
    }

    public final int getDataVersion() {
        // Simplified version logic: try parse protocolVersion, else 0
        try {
            return Integer.parseInt(this.protocolVersion);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int getProtocolID() {
        return protocolID;
    }

    public void setProtocolID(int protocolID) {
        this.protocolID = protocolID;
    }

    public int getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(int callbackId) {
        this.callbackId = callbackId;
    }
}
