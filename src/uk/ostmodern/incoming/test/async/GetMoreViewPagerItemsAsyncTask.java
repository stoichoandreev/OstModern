package uk.ostmodern.incoming.test.async;

import android.os.AsyncTask;
import uk.ostmodern.incoming.test.enums.ViewPagerNewItemDirection;
import uk.ostmodern.incoming.test.interfaces.OnNewPagerItemListener;
import uk.ostmodern.incoming.test.models.ViewPagerFragmentDataModel;

/**
 * Created by sniper on 12/30/14.
 */
public class GetMoreViewPagerItemsAsyncTask extends AsyncTask<String, String, Boolean> {
    protected ViewPagerFragmentDataModel viewPagerNewModel;
    protected OnNewPagerItemListener listener;
    private ViewPagerNewItemDirection position;


    public GetMoreViewPagerItemsAsyncTask(){}
    public GetMoreViewPagerItemsAsyncTask(OnNewPagerItemListener listener,ViewPagerNewItemDirection position){
        this.listener = listener;
        this.position = position;
    }


    @Override
    protected void onPreExecute() {//can block UI here
        super.onPreExecute();
    }
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            if(position == ViewPagerNewItemDirection.PREV) {
                viewPagerNewModel = new ViewPagerFragmentDataModel("new page at begin ", "Begin Begin NEW NEW NEW NEW ");
            }else if(position == ViewPagerNewItemDirection.NEXT){
                viewPagerNewModel = new ViewPagerFragmentDataModel("new page at end", "End End NEW NEW NEW NEW ");
            }
            return true;

        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {

        if (listener != null) {
            if (result) {
                listener.onNewItemArrive(viewPagerNewModel, position);
            } else if(viewPagerNewModel != null){
                listener.onDoesNotHaveNewItem();
            }
        }
    }
}