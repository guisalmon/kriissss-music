package org.robnetwork.kriissssmusic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Guillaume Salmon on 23/09/2017.
 */

public class CommandService extends Service {
    private static int NOTIFICATION_ID = 42;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY_COMPATIBILITY;
    }
}
