package com.autonavi.amapauto.protocol.model.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amapauto.protocol.model.base.ProtocolBaseModel;

public class ReqGetVehicleStateModel extends ProtocolBaseModel {
    // Protocol ID 80041
    public int type = 0;

    public ReqGetVehicleStateModel() {
        setProtocolID(80041);
    }

    public ReqGetVehicleStateModel(int type) {
        setProtocolID(80041);
        this.type = type;
    }

    protected ReqGetVehicleStateModel(Parcel in) {
        super(in);
        this.type = in.readInt();
    }

    public static final Creator<ReqGetVehicleStateModel> CREATOR = new Creator<ReqGetVehicleStateModel>() {
        @Override
        public ReqGetVehicleStateModel createFromParcel(Parcel in) {
            return new ReqGetVehicleStateModel(in);
        }

        @Override
        public ReqGetVehicleStateModel[] newArray(int size) {
            return new ReqGetVehicleStateModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.type);
    }
}
