package uk.ostmodern.incoming.test.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.adapters.ViewPagerAdapter;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.handlers.ViewPagerHandler;
import uk.ostmodern.incoming.test.models.CardViewModel;
import uk.ostmodern.incoming.test.models.ViewPagerItem;
import uk.ostmodern.incoming.test.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class DetailsFragment extends OstModernBaseFragment implements uk.ostmodern.incoming.test.interfaces.ViewPager {

    private int currentPage;
    private ViewPager mViewPager;
    private ViewPagerHandler viewPagerHandler;
    private ViewPagerAdapter adapter;

    private List<CardViewModel> allData;
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager
            .OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

    };


    public DetailsFragment(){}
    public static DetailsFragment newInstance(Bundle bundle) {
        DetailsFragment f = new DetailsFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPage = getArguments().getInt(Preferences.SELECTED_SET_ITEM , 0);
//        TODO before use view pager we must collect all data
        allData = Utils.createUsefulSetModels(mActivity.getDataHolder().getSets().getAllSets(),mActivity.getDataHolder().getImagesDictionary());
        viewPagerHandler = new ViewPagerHandler(mActivity);
        collectViewPagerData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.details_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);

        if (viewPagerHandler.getViewPagerItems() != null && viewPagerHandler.getViewPagerItems().size() > 0) {
            mViewPager = (ViewPager) getRootView().findViewById(R.id.viewpager);
//            adapter = new ViewPagerAdapter(getSupport(),Preferences.VIEW_PAGER_ITEMS_NUMBER, viewPagerHandler.getViewPagerItems());
            adapter = new ViewPagerAdapter(getChildFragmentManager(), viewPagerHandler.getViewPagerItems());
            mViewPager.setAdapter(adapter);

            int defaultViewPagerItemSelectedPosition = defaultViewPagerPageSelectedPosition();
            if (defaultViewPagerItemSelectedPosition >= 0 && defaultViewPagerItemSelectedPosition < viewPagerHandler.getViewPagerItems().size()) {
                mViewPager.setCurrentItem(defaultViewPagerItemSelectedPosition);
            }

            mViewPager.setOnPageChangeListener(mOnPageChangeListener);

//            replaceTitle(mViewPagerItems.get(defaultViewPagerItemSelectedPosition).getTitle());
        }

        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return null;
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return currentPage;
    }
    private void replaceTitle(String title) {
//        if (replaceActionBarTitleByViewPagerPageTitle()) {
//            ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(title);
//        }
    }

    private void collectViewPagerData() {
        List<ViewPagerItem> newItems = new ArrayList<ViewPagerItem>(allData.size());
        for(int i = 0; i < allData.size();i++){
            Bundle bundle = new Bundle();
            bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL,allData.get(i));
            newItems.add(new ViewPagerItem(allData.get(i).getTitle(), ViewPagerBaseFragment.newInstance(bundle)));
        }
        viewPagerHandler.setViewPagerItems(newItems);

    }

}
