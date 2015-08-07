package uk.ostmodern.incoming.test.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import uk.ostmodern.incoming.test.models.ViewPagerItem;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<ViewPagerItem> mViewPagerItems;
    private boolean showPartOfNextItemAtBegin;//this will show only part of next item at begin, just user to understand that screen has pager view
    private int slideCount;

    public ViewPagerAdapter(FragmentManager fm, List<ViewPagerItem> viewPagerItems) {
        super(fm);
        this.slideCount = viewPagerItems.size();
        this.mViewPagerItems = viewPagerItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mViewPagerItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return slideCount;
    }

    public void setData(List<ViewPagerItem> viewPagerItems) {
        slideCount = viewPagerItems.size();
        this.mViewPagerItems = viewPagerItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    @Override
    public float getPageWidth(int position) {
        if (showPartOfNextItemAtBegin) {
            showPartOfNextItemAtBegin = false;
            return 0.8f;
        }
        return 1f;
    }
}