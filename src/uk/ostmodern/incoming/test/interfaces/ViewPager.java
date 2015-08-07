package uk.ostmodern.incoming.test.interfaces;


import uk.ostmodern.incoming.test.handlers.ViewPagerHandler;

public interface ViewPager {

    public abstract ViewPagerHandler getViewPagerHandler();

    public abstract int defaultViewPagerPageSelectedPosition();

}
