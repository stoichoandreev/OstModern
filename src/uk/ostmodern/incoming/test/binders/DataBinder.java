package uk.ostmodern.incoming.test.binders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import uk.ostmodern.incoming.test.adapters.DataBindAdapter;

/**
 * Class for binding view and data
 *
 * Created by yqritc on 2015/03/01.
 * // Source https://github.com/yqritc/RecyclerView-MultipleViewTypesAdapter
 *
 */
abstract public class DataBinder<T extends RecyclerView.ViewHolder> {

    private DataBindAdapter mDataBindAdapter;

    public DataBinder(DataBindAdapter dataBindAdapter) {
        mDataBindAdapter = dataBindAdapter;
    }

    abstract public T newViewHolder(ViewGroup parent);

    abstract public void bindViewHolder(T holder, int position);

    abstract public int getItemCount();

    public Context getContext(){return mDataBindAdapter.getAdapterContext();}

    public final void notifyDataSetChanged() {
        mDataBindAdapter.notifyDataSetChanged();
    }

    public final void notifyBinderDataSetChanged() {
        notifyBinderItemRangeChanged(0, getItemCount());
    }

    public final void notifyBinderItemChanged(int position) {
        mDataBindAdapter.notifyBinderItemChanged(this, position);
    }

    public final void notifyBinderItemRangeChanged(int positionStart, int itemCount) {
        mDataBindAdapter.notifyBinderItemRangeChanged(this, positionStart, itemCount);
    }

    public final void notifyBinderItemInserted(int position) {
        mDataBindAdapter.notifyBinderItemInserted(this, position);
    }

    public final void notifyBinderItemMoved(int fromPosition, int toPosition) {
        mDataBindAdapter.notifyBinderItemMoved(this, fromPosition, toPosition);
    }

    public final void notifyBinderItemRangeInserted(int positionStart, int itemCount) {
        mDataBindAdapter.notifyBinderItemRangeInserted(this, positionStart, itemCount);
    }

    public final void notifyBinderItemRemoved(int position) {
        mDataBindAdapter.notifyBinderItemRemoved(this, position);
    }

    public final void notifyBinderItemRangeRemoved(int positionStart, int itemCount) {
        mDataBindAdapter.notifyBinderItemRangeRemoved(this, positionStart, itemCount);
    }
}