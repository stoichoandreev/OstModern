package uk.ostmodern.incoming.test.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import uk.ostmodern.incoming.test.binders.DataBinder;
import uk.ostmodern.incoming.test.binders.CardViewBinder;

/**
 * Adapter class for managing a set of data binders
 *
 */
abstract public class DataBindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return getDataBinder(viewType).newViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int binderPosition = getBinderPosition(position);
        if(viewHolder instanceof CardViewBinder.ViewHolder){
//        }else if(getDataBinder(viewHolder.getItemViewType()) instanceof UserPostCardViewBinder){
//            ((UserPostCardViewBinder)getDataBinder(1)).bindViewHolder((UserPostCardViewBinder.ViewHolder)viewHolder, binderPosition);
            ((CardViewBinder)getDataBinder(viewHolder.getItemViewType() -1 )).bindViewHolder((CardViewBinder.ViewHolder)viewHolder, binderPosition);
//            ((UserPostCardViewBinder)getDataBinder(viewHolder.getItemViewType())).bindViewHolder((UserPostCardViewBinder.ViewHolder)viewHolder, binderPosition);
        }
//        getDataBinder(viewHolder.getItemViewType()).bindViewHolder(viewHolder, binderPosition);
    }

    @Override
    public abstract int getItemCount();

    @Override
    public abstract int getItemViewType(int position);

    public abstract <T extends DataBinder> T getDataBinder(int viewType);

    public abstract int getPosition(DataBinder binder, int binderPosition);

    public abstract int getBinderPosition(int position);

    public void notifyBinderItemChanged(DataBinder binder, int binderPosition) {
        notifyItemChanged(getPosition(binder, binderPosition));
    }

    public abstract void notifyBinderItemRangeChanged(DataBinder binder, int positionStart,
                                                      int itemCount);

    public void notifyBinderItemInserted(DataBinder binder, int binderPosition) {
        notifyItemInserted(getPosition(binder, binderPosition));
    }

    public void notifyBinderItemMoved(DataBinder binder, int fromPosition, int toPosition) {
        notifyItemMoved(getPosition(binder, fromPosition), getPosition(binder, toPosition));
    }

    public abstract void notifyBinderItemRangeInserted(DataBinder binder, int positionStart,
                                                       int itemCount);

    public void notifyBinderItemRemoved(DataBinder binder, int binderPosition) {
        notifyItemRemoved(getPosition(binder, binderPosition));
    }

    public abstract void notifyBinderItemRangeRemoved(DataBinder binder, int positionStart,
                                                      int itemCount);
    public Context getAdapterContext(){return context;}
}
