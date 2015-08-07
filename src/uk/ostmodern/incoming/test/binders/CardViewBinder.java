package uk.ostmodern.incoming.test.binders;


import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.adapters.DataBindAdapter;
import uk.ostmodern.incoming.test.custom.CircleUserLevel;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;
import uk.ostmodern.incoming.test.interfaces.OnCardViewListener;
import uk.ostmodern.incoming.test.models.CardViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sniper
 * // Source https://github.com/yqritc/RecyclerView-MultipleViewTypesAdapter
 */
public class CardViewBinder extends DataBinder<CardViewBinder.ViewHolder> implements View.OnClickListener {
    private List<CardViewModel> mDataSet = new ArrayList<CardViewModel>();
    private OnCardViewListener listener;
    public CardViewBinder(DataBindAdapter dataBindAdapter,OnCardViewListener listener) {
        super(dataBindAdapter);
        this.listener = listener;
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.single_card_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        final ViewHolder hold = holder;
        CardViewModel model = mDataSet.get(position);
        holder.setTitle.setText(model.getTitle());
        holder.builder.setLength(0);//clear
        holder.builder.append(getContext().getResources().getString(R.string.available_on));
        holder.builder.append(model.getPublishDate());
        holder.publishDate.setText(holder.builder.toString());
        holder.summary.setText(model.getSummary());
//        holder.postBarLikes.setText(Integer.toString(viewPagerNewModel.getLikesNumber()));
//        holder.postBarComments.setText(Integer.toString(viewPagerNewModel.getCommentsNumber()));
//        holder.postBarShares.setText(Integer.toString(viewPagerNewModel.getSharesNumber()));
//        holder.postBarUploads.setText(Integer.toString(viewPagerNewModel.getUploadsNumber()));
        holder.setCashedCountImage.setUserLevel(model.getCashedFilmCount(), true);
        holder.hasPriceMenu.setImageDrawable((model.isHasPrice()) ? getContext().getResources().getDrawable(R.drawable.paid) : getContext().getResources().getDrawable(R.drawable.free));
        holder.disabledView.setVisibility((model.isActive()) ? View.GONE : View.VISIBLE);
        ImageLoader.getInstance().displayImage(model.getImage(), holder.setImage, OstModernBaseActivity.imageOptions, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                hold.progressBarLarge.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                hold.progressBarLarge.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                hold.progressBarLarge.setVisibility(View.GONE);
            }
        });
//        ImageLoader.getInstance().displayImage(model.getImage(), holder.setImage, OstModernBaseActivity.imageOptions);
        if(model.isActive()){
            holder.setCashedCountImage.setOnClickListener(this);
            holder.cardViewLayout.setTag(position);
            holder.cardViewLayout.setOnClickListener(this);
        }else{
            holder.disabledView.setOnClickListener(this);
        }

        holder.setCashedCountImage.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void addAll(List<CardViewModel> dataSet) {
        mDataSet.addAll(dataSet);
        notifyBinderDataSetChanged();
    }

    public void clear() {
        mDataSet.clear();
        notifyBinderDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_view_layout:
                int position = Integer.parseInt(v.getTag().toString());
                listener.onItemSelected(position);
                break;
            case R.id.disable_view_layout:
                Toast.makeText(getContext(),"This view is disabled because is not active",Toast.LENGTH_SHORT).show();
                break;
            case R.id.set_cashed_count_image:
                break;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ProgressBar progressBarLarge;
        private OstModernCustomTextView setTitle;
        private CircleUserLevel setCashedCountImage;
        private ImageView hasPriceMenu;
        private OstModernCustomTextView publishDate;
        private OstModernCustomTextView summary;
        private ImageView setImage;
        private RelativeLayout disabledView;
        private RelativeLayout cardViewLayout;
        private StringBuilder builder;

        public ViewHolder(View view) {
            super(view);

            progressBarLarge = (ProgressBar)view.findViewById(R.id.progress_bar_large);
            setTitle = (OstModernCustomTextView) view.findViewById(R.id.set_title);
            setCashedCountImage = (CircleUserLevel) view.findViewById(R.id.set_cashed_count_image);
            hasPriceMenu = (ImageView) view.findViewById(R.id.has_price_menu);
            publishDate = (OstModernCustomTextView) view.findViewById(R.id.publish_date);
            summary = (OstModernCustomTextView) view.findViewById(R.id.summary);
            setImage = (ImageView) view.findViewById(R.id.set_image);
            setImage = (ImageView) view.findViewById(R.id.set_image);
            disabledView = (RelativeLayout) view.findViewById(R.id.disable_view_layout);
            cardViewLayout = (RelativeLayout) view.findViewById(R.id.card_view_layout);
            builder = new StringBuilder();
        }
    }
}
