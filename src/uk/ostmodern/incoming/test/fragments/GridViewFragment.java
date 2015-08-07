package uk.ostmodern.incoming.test.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.adapters.OstGridAdapter;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.models.CardViewModel;
import uk.ostmodern.incoming.test.utils.Utils;

import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class GridViewFragment extends OstModernBaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener,AbsListView.OnScrollListener{

    private List<CardViewModel> setsList;
    private OstGridAdapter adapter;
    private int listLastIndexPosition;
    private GridView gridView;

    public GridViewFragment(){}
    public static GridViewFragment newInstance(Bundle bundle) {
        GridViewFragment f = new GridViewFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setsList = Utils.createUsefulSetModels(mActivity.getDataHolder().getSets().getAllSets(),mActivity.getDataHolder().getImagesDictionary());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.grid_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);
        gridView = (GridView)getRootView().findViewById(R.id.grid_view);

        adapter = new OstGridAdapter(mActivity, gridView.getId(), setsList);

        gridView.setAdapter(adapter);
        gridView.setSelection(listLastIndexPosition);
        gridView.setOnItemClickListener(this);
        gridView.setOnScrollListener(this);
        //        Build fluid Layout
        ViewTreeObserver vto =  gridView.getViewTreeObserver();
        if(vto.isAlive()){
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        adapter.setImageHeight(gridView.getWidth() / gridView.getNumColumns());
                        gridView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        adapter.setImageHeight(gridView.getColumnWidth());
                        gridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
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
                fragment = GridViewFragment.newInstance(null);

                break;
        }
        if(fragment != null){
            mActivity.addFragment(fragment,true);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(setsList.get(position).isActive()) {
            Bundle bundle = new Bundle();
            bundle.putInt(Preferences.SELECTED_SET_ITEM, position);
            OstModernBaseFragment fragment = DetailsFragment.newInstance(bundle);
            mActivity.addFragment(fragment, true);
        }else{
            Toast.makeText(mActivity, "This view is disabled because is not active", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        listLastIndexPosition = firstVisibleItem;
    }
}
