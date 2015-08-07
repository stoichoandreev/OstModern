package uk.ostmodern.incoming.test.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.adapters.ViewPagerAdapter;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.enums.ViewPagerNewItemDirection;
import uk.ostmodern.incoming.test.handlers.ViewPagerHandler;
import uk.ostmodern.incoming.test.interfaces.OnNewPagerItemListener;
import uk.ostmodern.incoming.test.models.ViewPagerFragmentDataModel;
import uk.ostmodern.incoming.test.models.ViewPagerItem;
import uk.ostmodern.incoming.test.utils.OstViewPagerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class DetailsFragmentTest extends OstModernBaseFragment implements uk.ostmodern.incoming.test.interfaces.ViewPager,OnNewPagerItemListener {
    /*
    *
    * THE IDEA IF THIS PAGER FRAGMENT IS TO HOLD ALWAYS 7 ITEMS IN IT (OR LESS NUMBER). IF YOU SCROLL IN PREV DIRECTION OR IN NEXT DIRECTION,
    * PAGER CHANGE IT DATA SET AND INVALIDATE, BUT MUST KEEP POSITION OF CURRENT ITEM, TO STAY STATIC WHEN INVALIDATE
    * THE PAGER DATA SET IS CAME FROM ALL DATA SET ITEMS, AND WE JUST SELECT WRIGHT 8 ITEMS
    *
     */
    private int [] startingViewPagerPositions;
    private int currentPage;
    private ViewPager mViewPager;
    private ViewPagerHandler viewPagerHandler;
//    private List<ViewPagerItem> mViewPagerItems;
    private ViewPagerAdapter adapter;

    private List<ViewPagerFragmentDataModel> allData;
//    private List<ViewPagerFragmentDataModel> viewPagerData;
    private final android.support.v4.view.ViewPager.OnPageChangeListener mOnPageChangeListener = new android.support.v4.view.ViewPager
            .OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            float alpha = 1 - (float) Math.max(0, 1 - positionOffset) / 1;
//            mViewPager.getChildAt(position).setAlpha(alpha);
        }

        @Override
        public void onPageSelected(int position) {
            if(position > currentPage){
                onNextPage(position);
            }else if(position < currentPage){
                onPrevPage(position);
            }
            currentPage = position;
//            replaceTitle(mViewPagerItems.get(position).getTitle());
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

    };


    public DetailsFragmentTest(){}
    public static DetailsFragmentTest newInstance(Bundle bundle) {
        DetailsFragmentTest f = new DetailsFragmentTest();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPage = 12;
//        TODO before use view pager we must collect all data
        collectAllData();
        startingViewPagerPositions = OstViewPagerUtils.getStartingPositions(currentPage, allData.size());
        viewPagerHandler = new ViewPagerHandler(mActivity);
//        mViewPagerItems = viewPagerHandler.getViewPagerItems();
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
////        This will create starting view pager fragment.
////        For example we will generate selected item fragment and 3 items in front and 3 items in back of selected item
//        ViewPagerHandler pagerHandler = new ViewPagerHandler(mActivity,allData.size());
//        int size = allData.size();
//        for(int i = 0; i < size;i++){
//            Bundle bundle = new Bundle();
//            bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL,allData.get(i));
//            pagerHandler.addPage(allData.get(i).getTitle(), ViewPagerBaseFragment.newInstance(bundle));
//        }
//
//        return pagerHandler;
        return null;
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return OstViewPagerUtils.getDefaultPositions(currentPage, allData.size());
    }
    private void replaceTitle(String title) {
//        if (replaceActionBarTitleByViewPagerPageTitle()) {
//            ((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(title);
//        }
    }

    public void onNextPage(int position) {
        if((currentPage+1) < allData.size()){
            currentPage++;
            startingViewPagerPositions = OstViewPagerUtils.getStartingPositions(currentPage, allData.size());
            collectViewPagerData();
            adapter.setData(viewPagerHandler.getViewPagerItems());
            mViewPager.invalidate();
        }
//        if((viewPagerData.size() >= (position + 2)) && viewPagerData.get((position+2)) == null) {
//            mViewPager.setCurrentItem(position);
//            new GetMoreViewPagerItemsAsyncTask(this, ViewPagerNewItemDirection.PREV).execute();
//        }
    }

    public void onPrevPage(int position) {
        if((currentPage-1) >= 0){
            currentPage--;
            startingViewPagerPositions = OstViewPagerUtils.getStartingPositions(currentPage, allData.size());
            collectViewPagerData();
            adapter.setData(viewPagerHandler.getViewPagerItems());
            mViewPager.invalidate();
        }
//        if((position - 2) >= 0 && viewPagerData.get((position-2)) == null) {
//            mViewPager.setCurrentItem(position);
//            new GetMoreViewPagerItemsAsyncTask(this, ViewPagerNewItemDirection.NEXT).execute();
//        }
    }
    private void collectAllData(){
        allData = new ArrayList<ViewPagerFragmentDataModel>();
        allData.add(new ViewPagerFragmentDataModel("page 1","First text items"));
        allData.add(new ViewPagerFragmentDataModel("page 2","Second text items"));
        allData.add(new ViewPagerFragmentDataModel("page 3","dsfsdfdsfds text items"));
        allData.add(new ViewPagerFragmentDataModel("page 4","Sec asagg gg s ggs g g gsggd gg sgg g dada daond text items"));
        allData.add(new ViewPagerFragmentDataModel("page 5","ada dadad  da da d text items"));
        allData.add(new ViewPagerFragmentDataModel("page 6","add ad das  addsa ytjuyju gdgdf gdgffd g gg dgfgf  gg dfgg text items"));
        allData.add(new ViewPagerFragmentDataModel("page 7","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 8","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 9","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 10","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 11","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 12","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 13","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
        allData.add(new ViewPagerFragmentDataModel("page 14","dassa daadsad  dad asd dad  a d adasd sa d  dsd dda yy  jyy sdf fsdfasf fsfsd fssdfsdf fsfsd text items"));
    }
    private void collectViewPagerData() {
//        viewPagerData = new ArrayList<ViewPagerFragmentDataModel>(allData.size());
//        for(int i=0;i < allData.size();i++){
//            if(currentPage == i){
//                for(int j = 0; j < startingViewPagerPositions.length;j++){
//                    int calculatedItemPosition =  currentPage + startingViewPagerPositions[j];
//                    viewPagerData.add(calculatedItemPosition,allData.get(calculatedItemPosition));
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL,viewPagerData.get(calculatedItemPosition));
//                    viewPagerHandler.addNewPageAtPosition(calculatedItemPosition, viewPagerData.get(calculatedItemPosition).getTitle(), ViewPagerBaseFragment.newInstance(bundle));
//                    i++;
//                }
//                break;
//            }else{
//                viewPagerData.add(null);
////                Bundle bundle = new Bundle();
////                bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL,viewPagerData.get(i));
//                viewPagerHandler.addNewPageAtPosition(i, null, null);
//            }
//
//        }
        List<ViewPagerItem> newItems = new ArrayList<ViewPagerItem>(startingViewPagerPositions.length);
        for(int j = 0; j < startingViewPagerPositions.length;j++){
//            int calculatedItemPosition =  currentPage + startingViewPagerPositions[j];
            Bundle bundle = new Bundle();
            bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL,allData.get(startingViewPagerPositions[j]));
            newItems.add(new ViewPagerItem(allData.get(startingViewPagerPositions[j]).getTitle(), ViewPagerBaseFragment.newInstance(bundle)));
//            Bundle bundle = new Bundle();
//            bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL,viewPagerHandler.getViewPagerItems().get(startingViewPagerPositions[j]));
//            viewPagerHandler.addNewPageAtPosition(calculatedItemPosition, viewPagerHandler.getViewPagerItems().get(calculatedItemPosition).getTitle(), ViewPagerBaseFragment.newInstance(bundle));
        }
        viewPagerHandler.setViewPagerItems(newItems);

    }

    @Override
    public void onNewItemArrive(ViewPagerFragmentDataModel newItem,ViewPagerNewItemDirection direction) {
        int position = 0;
//        if(direction == ViewPagerNewItemDirection.PREV) {
//            position = (currentPage - 2);
//        }else if(direction == ViewPagerNewItemDirection.NEXT){
//            position = (currentPage + 2);
//        }
//
//        viewPagerData.add(position, newItem);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL, viewPagerData.get(position));
//        viewPagerHandler.addNewPageAtPosition(position,viewPagerData.get(position).getTitle(), ViewPagerBaseFragment.newInstance(bundle));
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDoesNotHaveNewItem() {

    }
}
