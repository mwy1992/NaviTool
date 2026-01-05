package com.autonavi.amapauto.protocol.model.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.amapauto.protocol.model.base.ProtocolBaseModel;

public class RspTrafficLightsCountdownInfoModel extends ProtocolBaseModel {
    // Protocol ID 80189
    // Based on broadcast extras: trafficLightStatus, redLightCountDownSeconds, etc.
    public int trafficLightStatus;
    public int redLightCountDownSeconds;
    public int greenLightLastSecond;
    public int dir;
    public int waitRound;

    public RspTrafficLightsCountdownInfoModel() {
        setProtocolID(80189);
    }

    protected RspTrafficLightsCountdownInfoModel(Parcel in) {
        super(in);
        this.trafficLightStatus = in.readInt();
        this.redLightCountDownSeconds = in.readInt();
        this.greenLightLastSecond = in.readInt();
        this.dir = in.readInt();
        this.waitRound = in.readInt();
    }

    public static final Creator<RspTrafficLightsCountdownInfoModel> CREATOR = new Creator<RspTrafficLightsCountdownInfoModel>() {
        @Override
        public RspTrafficLightsCountdownInfoModel createFromParcel(Parcel in) {
            return new RspTrafficLightsCountdownInfoModel(in);
        }

        @Override
        public RspTrafficLightsCountdownInfoModel[] newArray(int size) {
            return new RspTrafficLightsCountdownInfoModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.trafficLightStatus);
        dest.writeInt(this.redLightCountDownSeconds);
        dest.writeInt(this.greenLightLastSecond);
        dest.writeInt(this.dir);
        dest.writeInt(this.waitRound);
    }

    @Override
    public String toString() {
        return "RspTrafficLightsCountdownInfoModel{" +
                "status=" + trafficLightStatus +
                ", red=" + redLightCountDownSeconds +
                ", green=" + greenLightLastSecond +
                ", dir=" + dir +
                ", wait=" + waitRound +
                '}';
    }
}
