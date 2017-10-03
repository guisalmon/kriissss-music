package org.robnetwork.kriissssmusic.helper;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import org.robnetwork.kriissssmusic.R;
import org.robnetwork.kriissssmusic.service.CommandService;

/**
 * Created by Guillaume Salmon on 03/10/2017.
 */

public class NotificationHelper {
    private static final String TAG = NetworkHelper.class.getSimpleName();

    private static final int NOTIFICATION_ID = 2048;

    public static void createNotification(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification);
        remoteViews.setOnClickPendingIntent(R.id.kriss, PendingIntent.getService(context, 2,
                CommandService.getIntent(context, 2), PendingIntent.FLAG_UPDATE_CURRENT));
        remoteViews.setOnClickPendingIntent(R.id.room, PendingIntent.getService(context, 1,
                CommandService.getIntent(context, 1), PendingIntent.FLAG_CANCEL_CURRENT));
        remoteViews.setOnClickPendingIntent(R.id.box, PendingIntent.getService(context, 3,
                CommandService.getIntent(context, 3), PendingIntent.FLAG_CANCEL_CURRENT));
        remoteViews.setOnClickPendingIntent(R.id.cancel, PendingIntent.getService(context, 6,
                CommandService.getIntent(context, 0), PendingIntent.FLAG_CANCEL_CURRENT));
        remoteViews.setOnClickPendingIntent(R.id.cyke, PendingIntent.getService(context, 5,
                CommandService.getIntent(context, 5), PendingIntent.FLAG_CANCEL_CURRENT));
        remoteViews.setOnClickPendingIntent(R.id.tv, PendingIntent.getService(context, 4,
                CommandService.getIntent(context, 4), PendingIntent.FLAG_CANCEL_CURRENT));

        Notification notification = new NotificationCompat.Builder(context)
                .setOngoing(true)
                .setCustomBigContentView(remoteViews)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setPriority(Notification.PRIORITY_MAX)
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
