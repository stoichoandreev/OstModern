package uk.ostmodern.incoming.test.models;

import android.content.Context;
import uk.ostmodern.incoming.test.fragments.OstModernBaseFragment;

public class ViewPagerItem {

    private String mTitle;
    private OstModernBaseFragment mFragment;

    public ViewPagerItem(){};
    public ViewPagerItem(String title, OstModernBaseFragment fragment){
        this.mTitle = title;
        this.mFragment = fragment;
    };

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(Context context, int titleResource) {
        this.mTitle = context.getString(titleResource);
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public OstModernBaseFragment getFragment() {
        return mFragment;
    }

    public void setFragment(OstModernBaseFragment fragment) {
        this.mFragment = fragment;
    }

}
