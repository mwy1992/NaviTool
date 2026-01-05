package com.autonavi.amapauto.protocol.model.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ProtocolModel<T extends ProtocolBaseModel> implements Parcelable {
    private static final String TAG = "ProtocolModel";
    public T data;

    public ProtocolModel() {
    }

    protected ProtocolModel(Parcel in) {
        String className = in.readString();
        // Simplified reconstruction: we just read the parcelable if classname is
        // present
        // In real SDK, it uses reflection to load the class.
        // For our client receiving data, we might need to load classes if we want to
        // deserialize fully.
        // But mainly we send 'ProtocolModel' wrapping a base model.
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
