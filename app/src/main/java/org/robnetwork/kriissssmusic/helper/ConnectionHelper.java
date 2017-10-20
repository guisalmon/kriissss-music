package org.robnetwork.kriissssmusic.helper;

import android.content.Context;
import android.net.wifi.WifiManager;

public class ConnectionHelper {
    private static final String MAC_BOX_2_4HZ = "18:d6:c7:f9:d8:d8";
    private static final String MAC_BOX_5HZ = "18:d6:c7:f9:d8:d7";

    public static boolean isConnectedToHomeWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
        return wifiManager != null && wifiManager.getConnectionInfo().getBSSID() != null
                && (wifiManager.getConnectionInfo().getBSSID().equals(MAC_BOX_2_4HZ)
                || wifiManager.getConnectionInfo().getBSSID().equals(MAC_BOX_5HZ));
    }
}
