package uk.ostmodern.incoming.test.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.adapters.RecyclerViewAdapter;
import uk.ostmodern.incoming.test.adapters.SimpleSectionedRecyclerViewAdapter;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.interfaces.OnCardViewListener;
import uk.ostmodern.incoming.test.models.CardViewModel;
import uk.ostmodern.incoming.test.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class CardViewFragment extends OstModernBaseFragment implements OnCardViewListener {
    private RecyclerViewAdapter adapter;
    private List<CardViewModel> allItems;
    private RecyclerView recyclerView;

    public CardViewFragment(){}
    public static CardViewFragment newInstance(Bundle bundle) {
        CardViewFragment f = new CardViewFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allItems = Utils.createUsefulSetModels(mActivity.getDataHolder().getSets().getAllSets(),mActivity.getDataHolder().getImagesDictionary());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setLayoutRecourse(R.layout.card_view_fragment_layout);
        super.onCreateView(inflater, container, savedInstanceState);
        recyclerView = (RecyclerView)getRootView().findViewById(R.id.card_recycler_view);

        //Your RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));

        //Your RecyclerView.Adapter
        adapter = new RecyclerViewAdapter(this);
        adapter.setUserPostCardData(allItems);

        //This is the code to provide a sectioned list
        List<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        //Sections
//        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"Section 1"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(1,"Section - Action Sets"));
//        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(5,"Section 2"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(12,"Section - Old Move Sets"));

        //Add your adapter to the sectionAdapter
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(mActivity,R.layout.recycle_view_header_layout,R.id.header,adapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        recyclerView.setAdapter(mSectionedAdapter);

        return getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onItemSelected(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Preferences.SELECTED_SET_ITEM, position);
        OstModernBaseFragment fragment = DetailsFragment.newInstance(bundle);
        mActivity.addFragment(fragment,true);
    }
}
