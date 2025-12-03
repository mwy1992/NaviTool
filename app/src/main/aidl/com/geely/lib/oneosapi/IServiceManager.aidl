package com.geely.lib.oneosapi;

import android.os.IBinder;

interface IServiceManager {
    void addService(int type, IBinder service);
    IBinder getService(int type);
}
