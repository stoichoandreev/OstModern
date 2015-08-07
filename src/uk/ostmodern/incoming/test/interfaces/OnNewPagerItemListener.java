package uk.ostmodern.incoming.test.interfaces;

import uk.ostmodern.incoming.test.enums.ViewPagerNewItemDirection;
import uk.ostmodern.incoming.test.models.ViewPagerFragmentDataModel;

/**
 * Created by sniper on 7/26/15.
 */
public interface OnNewPagerItemListener {
    public void onNewItemArrive(ViewPagerFragmentDataModel newItem , ViewPagerNewItemDirection direction);
    public void onDoesNotHaveNewItem();
}
