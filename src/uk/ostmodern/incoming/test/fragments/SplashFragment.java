package uk.ostmodern.incoming.test.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.custom.PathView;
import uk.ostmodern.incoming.test.custom.TypeWriter;


/**
 * Created by sniper on 2015.
 */
public class SplashFragment extends OstModernBaseFragment {

    private PathView logo;
    private RelativeLayout splashPathContainer;
    private RelativeLayout splashTextContainer;

    public SplashFragment(){}
    public static SplashFragment newInstance(Bundle bundle) {
        SplashFragment f = new SplashFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.splash_layout);
        super.onCreateView(inflater, container, savedInstanceState);
        splashPathContainer = (RelativeLayout) getRootView().findViewById(R.id.splash_path_container);
        splashTextContainer = (RelativeLayout) getRootView().findViewById(R.id.splash_text_container);

        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initFragmentUI() {
        super.initFragmentUI();
        logo = new PathView(mActivity);
        splashPathContainer.addView(logo);
        logo.setEventListener(new PathView.PathViewAnimationListener() {
            @Override
            public void onPathViewAnimationStart() {
            }

            @Override
            public void onPathViewAnimationFinish() {
                TypeWriter writer = new TypeWriter(mActivity);
                writer.setGravity((Gravity.TOP | Gravity.CENTER_HORIZONTAL));
//        //Add a character every 180ms
                writer.setCharacterDelay(180);
                try {
                    writer.setTextSize(getResources().getDimension(R.dimen.writer_text_size));
                    writer.animateText(mActivity.getResources().getString(R.string.animated_splash_text));
                }catch (IllegalStateException ex){
                    //exception if activity has been detached this fragment in case of back
                    mActivity.finish();
                }
                splashTextContainer.addView(writer);
            }

            @Override
            public void onPathViewAnimationCancel() {
            }

            @Override
            public void onPathViewAnimationRepeat() {
            }
        });
    }
}
