package org.robnetwork.kriissssmusic.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import org.robnetwork.kriissssmusic.R;

/**
 * Created by Guillaume Salmon on 03/10/2017.
 */

public class NotificationHelper {
    private static final String TAG = NetworkHelper.class.getSimpleName();

    private static final int NOTIFICATION_ID = 2048;

    public static void createNotification(Context context) {
        Notification notification = new NotificationCompat.Builder(context)
                .setOngoing(true)
                .setCustomBigContentView(new RemoteViews(context.getPackageName(), R.layout.notification))
                .setSmallIcon(android.R.drawable.ic_media_play)
                .build();

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        try {
            manager.notify(NOTIFICATION_ID, notification);
        } catch (SecurityException se) {
            Log.e(TAG, "Failed to notify " + se.toString());
        }
    }

    public static void dismissNotification(Context context) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(NOTIFICATION_ID);
    }
}
