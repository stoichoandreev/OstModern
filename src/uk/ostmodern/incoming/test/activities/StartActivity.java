package uk.ostmodern.incoming.test.activities;

import android.os.Bundle;
import android.os.Handler;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.enums.ApiRequest;
import uk.ostmodern.incoming.test.fragments.SplashFragment;
import uk.ostmodern.incoming.test.fragments.StartFragment;

public class StartActivity extends OstModernBaseActivity {

    private static int SPLASH_DELAY = 8000; //1000;
    private Handler handler;
    private Runnable applicationRunnable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setLayoutResource(R.layout.main);
        super.onCreate(savedInstanceState);
        handler = new Handler();
        applicationRunnable = getApplicationRunnable();

        startSplashScreen();
    }

    @Override
    protected void applicationHasInternetConnection() {
        super.applicationHasInternetConnection();

//        if(mApplication.isOnline && !mApplication.isApplicationAuthenticate()){
////            Can authenticate app here
//        }
    }
    private void startSplashScreen() {
        addFragment(SplashFragment.newInstance(null), false);
        startApplication();
    }
    private void startFirstScreen() {
        addFragment(StartFragment.newInstance(null), true);
    }
    private Runnable getApplicationRunnable(){
        return new Runnable() {
            @Override
            public void run() {
                startFirstScreen();
            }
        };
    }
    private void startApplication(){
        handler.postDelayed(applicationRunnable, SPLASH_DELAY);
    }

    private void executeApiRequest(ApiRequest apiRequest){
        if(mApplication.isOnline) {
            switch (apiRequest) {
                case SETS:
//                    setAsyncTask = new GetSetsAsyncTask(this, this);
//                    setAsyncTask.execute();
//        if there our request is executed we prevent second execute of the request
                    break;
            }
        }else{
//            Toast.makeText(this, "No internet connection. Request can not be executed", Toast.LENGTH_SHORT).show();
        }
    }
}

