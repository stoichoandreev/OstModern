package uk.ostmodern.incoming.test;

import android.app.Application;

/**
 * Created by sniper on 2015.
 */
public class OstModernIncomeApplication extends Application{

    public boolean isOnline;
//    private SharedPreferences pref;

    @Override
    public void onCreate() {
        super.onCreate();
//        pref = getSharedPreferences(Preferences.SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }
}
