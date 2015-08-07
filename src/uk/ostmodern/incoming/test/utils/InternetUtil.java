package uk.ostmodern.incoming.test.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sniper on 3/7/15.
 */
public class InternetUtil {
    public static boolean hasInternet(Context context) {
        boolean isOnline = false;
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            if (conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
                isOnline = true;
            } else if (conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
                isOnline = false;
            }
        } catch (NullPointerException e) {
            isOnline = false;
        }

        return isOnline;
    }
}
