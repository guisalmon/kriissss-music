package org.robnetwork.kriissssmusic.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by Guillaume Salmon on 03/10/2017.
 */

public class WifiChangedReceiver extends BroadcastReceiver {
    private static final String TAG = WifiChangedReceiver.class.getSimpleName();

    private static final String MAC_BOX = "14:0c:76:d2:28:74";

    @Override
    public void onReceive(Context context, Intent intent) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo ();
        if (info.getBSSID() != null && info.getBSSID().equals(MAC_BOX)) {
            Log.i(TAG, "Home is where the wifi is ! ");

        }
    }
}
