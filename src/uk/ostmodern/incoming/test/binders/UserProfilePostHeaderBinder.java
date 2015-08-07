package uk.ostmodern.incoming.test.binders;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.adapters.DataBindAdapter;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;

/**
 * Created by yqritc on 2015/03/20.
 */
public class UserProfilePostHeaderBinder extends DataBinder<UserProfilePostHeaderBinder.ViewHolder> {

    public UserProfilePostHeaderBinder(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycle_view_header_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
//        holder.userName.setText(R.drawable.bird);
//        Picasso.with(holder.mImageView.getCont())
//                .load(R.drawable.bird)
//                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        OstModernCustomTextView header;

        public ViewHolder(View view) {
            super(view);
            header = (OstModernCustomTextView) view.findViewById(R.id.header);
        }
    }
}
