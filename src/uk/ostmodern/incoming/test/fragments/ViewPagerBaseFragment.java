package uk.ostmodern.incoming.test.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.nineoldandroids.view.ViewHelper;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.adapters.ItemsListAdapter;
import uk.ostmodern.incoming.test.api.gson_models.ItemsModel;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.custom.ObservableScrollView;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;
import uk.ostmodern.incoming.test.enums.ScrollState;
import uk.ostmodern.incoming.test.interfaces.ObservableScrollViewCallbacks;
import uk.ostmodern.incoming.test.models.CardViewModel;
import uk.ostmodern.incoming.test.utils.ScrollUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class ViewPagerBaseFragment extends OstModernBaseFragment implements View.OnClickListener, ObservableScrollViewCallbacks, AdapterView.OnItemClickListener {

    private ProgressBar progressBarLarge;
    private OstModernCustomTextView largeText;
    private OstModernCustomTextView title;
    private OstModernCustomTextView noItemsView;
    private ImageView mainImage;
    private RelativeLayout disableView;
    private CardViewModel dataModel;
    private ObservableScrollView scrollView;
    private int mParallaxImageHeight;
    private ListView itemsListView;
    private ItemsListAdapter listAdapter;
    private List<ItemsModel> items;
    private int baseColor;
    private float alpha;

    public ViewPagerBaseFragment(){}
    public static ViewPagerBaseFragment newInstance(Bundle bundle) {
        ViewPagerBaseFragment f = new ViewPagerBaseFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseColor = getResources().getColor(R.color.toolbar_color);
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);
        alpha = 1 - (float) Math.max(0, mParallaxImageHeight - 0) / mParallaxImageHeight;
        dataModel = (CardViewModel)getArguments().get(Preferences.VIEW_PAGER_FRAGMENT_DATA_MODEL);
        //get all items like list
        items = new ArrayList<ItemsModel>(Arrays.asList(dataModel.getItems()));
//        we remove dividers because I don't know how to use them (and what for) and because they make problems when parsing episode and episode images
        removeDividersFromItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.view_pager_base_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);
        progressBarLarge = (ProgressBar)getRootView().findViewById(R.id.progress_bar_large);
        largeText = (OstModernCustomTextView)getRootView().findViewById(R.id.view_pager_large_text);
        title = (OstModernCustomTextView)getRootView().findViewById(R.id.view_pager_title);
        noItemsView = (OstModernCustomTextView)getRootView().findViewById(R.id.no_items_view);
        mainImage = (ImageView)getRootView().findViewById(R.id.details_main_image);
        disableView = (RelativeLayout)getRootView().findViewById(R.id.disable_view_layout);
        scrollView = (ObservableScrollView)getRootView().findViewById(R.id.product_details_scrollview);
        itemsListView = (ListView)getRootView().findViewById(R.id.items_list_view);
//        check does we have any items in the set
        if(items != null && items.size() > 0){
            noItemsView.setVisibility(View.GONE);
            listAdapter = new ItemsListAdapter(mActivity,itemsListView.getId(),items);
            itemsListView.setAdapter(listAdapter);

            setListViewHeightBasedOnChildren(itemsListView);
            itemsListView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
            itemsListView.setOnItemClickListener(this);
        }else{
            noItemsView.setVisibility(View.VISIBLE);
        }

        title.setText(dataModel.getTitle());
        if(dataModel.getBody() != null && dataModel.getBody().trim().length() > 1) {
            largeText.setText(Html.fromHtml(dataModel.getBody()));
        }else{
            largeText.setVisibility(View.GONE);
        }
        ImageLoader.getInstance().displayImage(dataModel.getImage(),mainImage, OstModernBaseActivity.imageOptions, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBarLarge.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBarLarge.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBarLarge.setVisibility(View.GONE);
            }
        });
//        ImageLoader.getInstance().displayImage(dataModel.getImage(), mainImage, OstModernBaseActivity.imageOptions);
        disableView.setVisibility((dataModel.isActive()) ? View.GONE : View.VISIBLE);
        scrollView.setScrollViewCallbacks(this);


        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        OstModernBaseFragment fragment = null;
        switch (v.getId()) {
            case R.id.first_button:
                fragment = CardViewFragment.newInstance(null);
                break;
            case R.id.second_button:
                fragment = ViewPagerBaseFragment.newInstance(null);

                break;
        }
        if(fragment != null){
            mActivity.addFragment(fragment,true);
        }
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

        alpha = 1 - (float) Math.max(0, mParallaxImageHeight - scrollY) / mParallaxImageHeight;
        itemsListView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mainImage, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Preferences.SELECTED_ITEM_FROM_SET, items.get(position));
        OstModernBaseFragment fragment = EpisodeFragment.newInstance(bundle);
        mActivity.addFragment(fragment, true);
    }
    private void removeDividersFromItems(){
        for(int i =0;i < items.size();i++){
            if(items.get(i).getContentType().equals("divider")){
                items.remove(i);
            }
        }
    }
}
