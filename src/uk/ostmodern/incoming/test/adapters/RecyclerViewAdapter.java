package uk.ostmodern.incoming.test.adapters;

// Source https://github.com/yqritc/RecyclerView-MultipleViewTypesAdapter

import uk.ostmodern.incoming.test.binders.CardViewBinder;
import uk.ostmodern.incoming.test.interfaces.OnCardViewListener;
import uk.ostmodern.incoming.test.models.CardViewModel;

import java.util.List;

public class RecyclerViewAdapter extends EnumListBindAdapter<RecyclerViewAdapter.PostAdapterViewType> {

    enum PostAdapterViewType {
        POST_TYPE
//        USER_PROFILE_TYPE, POST_TYPE
//        USER_PROFILE_TYPE, POST_HEADER_TYPE, POST_TYPE
    }
//    public RecyclerViewAdapter() {
//        addAllBinder(new UserProfileImageBinder(this),
////                new UserProfilePostHeaderBinder(this),
//                new CardViewBinder(this));
//    }
    public RecyclerViewAdapter(OnCardViewListener listener) {
        addAllBinder(
                new CardViewBinder(this,listener));
    }

    public void setUserPostCardData(List<CardViewModel> dataSet) {
        ((CardViewBinder) getDataBinder(PostAdapterViewType.POST_TYPE)).addAll(dataSet);
    }
}
