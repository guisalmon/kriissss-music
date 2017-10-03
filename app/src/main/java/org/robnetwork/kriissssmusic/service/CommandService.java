package org.robnetwork.kriissssmusic.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import org.robnetwork.kriissssmusic.helper.NetworkHelper;
import org.robnetwork.kriissssmusic.helper.NotificationHelper;

/**
 * Created by Guillaume Salmon on 23/09/2017.
 */

public class CommandService extends Service {
    private static final String EXTRA_ID = "sourceId";

    public static Intent getIntent(Context context, int sourceId) {
        Intent intent = new Intent(context, CommandService.class);
        intent.putExtra(EXTRA_ID, sourceId);
        return intent;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.hasExtra(EXTRA_ID)) {
            int id = intent.getIntExtra(EXTRA_ID, 0);
            @NetworkHelper.SoundSource String idSource = getExtraId(id);
            if(idSource.equals(NetworkHelper.ID_UNSET)) {
                NotificationHelper.dismissNotification(getApplicationContext());
            } else {
                NetworkHelper.start(getApplicationContext());
                NetworkHelper.setSoundSource(getExtraId(id));
            }
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        NotificationHelper.dismissNotification(getApplicationContext());
    }

    private @NetworkHelper.SoundSource String getExtraId(int id) {
        switch (id) {
            case 1: return NetworkHelper.ID_ROOM;
            case 2: return NetworkHelper.ID_KRISS;
            case 3: return NetworkHelper.ID_BOX;
            case 4: return NetworkHelper.ID_TV;
            case 5: return NetworkHelper.ID_CYKE;
            default: return NetworkHelper.ID_UNSET;
        }
    }
}
