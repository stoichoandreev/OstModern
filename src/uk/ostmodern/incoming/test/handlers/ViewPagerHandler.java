package uk.ostmodern.incoming.test.handlers;

import android.content.Context;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.fragments.OstModernBaseFragment;
import uk.ostmodern.incoming.test.models.ViewPagerItem;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHandler {

    private Context mContext;
    private List<ViewPagerItem> pagerItems;

    public ViewPagerHandler(Context context) {
        mContext = context;
        pagerItems = new ArrayList<ViewPagerItem>(Preferences.VIEW_PAGER_HALF_ITEMS);
    }

    public ViewPagerHandler addPage(String title, OstModernBaseFragment fragment) {
        ViewPagerItem item = new ViewPagerItem();
        item.setTitle(title);
        item.setFragment(fragment);
        pagerItems.add(item);
        return this;
    }
    public void setViewPagerItems(List<ViewPagerItem> items){
        pagerItems.clear();
        pagerItems.addAll(items);
    }
    public List<ViewPagerItem> getViewPagerItems() {
        return pagerItems;
    }
}
