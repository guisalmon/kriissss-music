package org.robnetwork.kriissssmusic.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;

import org.robnetwork.kriissssmusic.helper.ConnectionHelper;
import org.robnetwork.kriissssmusic.helper.NotificationHelper;

public class WifiChangedReceiver extends BroadcastReceiver {
    public static ObservableField<Boolean> isAtHome = new ObservableField<>(false);

    @Override
    public void onReceive(Context context, Intent intent) {
        isAtHome.set(ConnectionHelper.isConnectedToHomeWifi(context));
        if (isAtHome.get())
            NotificationHelper.createNotification(context);
        else NotificationHelper.dismissNotification(context);
    }
}
