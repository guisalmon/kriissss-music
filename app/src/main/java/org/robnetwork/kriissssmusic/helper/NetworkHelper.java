package org.robnetwork.kriissssmusic.helper;

import android.content.Context;
import android.support.annotation.StringDef;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkHelper {
    private static final String TAG = NetworkHelper.class.getSimpleName();

    private static final String DOMAIN = "http://pi.lan/";
    private static final String ENDPOINT = endpoint();

    public static final String ID_BOX = "3";
    public static final String ID_TV = "4";
    public static final String ID_CYKE = "5";
    public static final String ID_ROOM = "1";
    public static final String ID_KRISS = "2";
    public static final String ID_UNSET = "0";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ID_BOX, ID_TV, ID_CYKE, ID_ROOM, ID_KRISS, ID_UNSET})
    public @interface SoundSource {
    }

    private RequestQueue mQueue;

    private static NetworkHelper sHelper;

    private static Response.Listener<String> mListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "onResponse : ");
            Log.d(TAG, response);
        }
    };
    private static Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "onError : ");
            Log.e(TAG, error.toString());
        }
    };

    private NetworkHelper(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public static void setSoundSource(@NetworkHelper.SoundSource String id) {
        if (sHelper != null && sHelper.mQueue != null){
            sHelper.mQueue.add(new StringRequest(Request.Method.GET, ENDPOINT + id,
                    mListener, mErrorListener));
        } else {
            Log.w(TAG, "NetworkHelper not started ! ");
        }
    }

    public static @SoundSource String getCurrentSource() {
        Log.w(TAG, "Not implemented yet");
        return ID_UNSET;
    }

    public static void start(Context context) {
        if (sHelper != null) {
            stop();
        }
        sHelper = new NetworkHelper(context);
    }

    public static void stop() {
        if (sHelper != null) {
            if (sHelper.mQueue != null) {
                sHelper.mQueue.cancelAll(TAG);
                sHelper.mQueue.stop();
            }
            sHelper = null;
        }
    }

    private static String endpoint() {
        try {
            return new URL(DOMAIN + "set.php?id=").toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
