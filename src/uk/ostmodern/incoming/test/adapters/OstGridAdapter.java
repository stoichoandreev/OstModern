package uk.ostmodern.incoming.test.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.activities.OstModernBaseActivity;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;
import uk.ostmodern.incoming.test.models.CardViewModel;

import java.util.List;

/**
 * Created by sniper on 2015.
 */

public class OstGridAdapter extends ArrayAdapter<CardViewModel> {
    private LayoutInflater mInflater;
    private int imageHeight;

    public OstGridAdapter(Context cont, int layoutId, List<CardViewModel> models) {
        super(cont, layoutId, models);
        mInflater = (LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.grid_item_layout, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        CardViewModel model = getItem(position);
        holder.setImage.setId(position);

        if(imageHeight > 0) {
            ViewGroup.LayoutParams imageParams = holder.setImage.getLayoutParams();
            imageParams.height = imageHeight;
            holder.setImage.setLayoutParams(imageParams);
            holder.disableView.setLayoutParams(imageParams);
        }

        holder.setTitle.setText(model.getTitle());
        holder.disableView.setVisibility((model.isActive() ? View.GONE : View.VISIBLE));
        holder.payedOrNotImage.setImageDrawable((model.isHasPrice()) ? getContext().getResources().getDrawable(R.drawable.paid) : getContext().getResources().getDrawable(R.drawable.free));
//        holder.setImage.setImageDrawable(position);
        ImageLoader.getInstance().displayImage(model.getImage(), holder.setImage, OstModernBaseActivity.imageOptions, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                holder.progressBarLarge.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                holder.progressBarLarge.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                holder.progressBarLarge.setVisibility(View.GONE);
            }
        });
//        ImageLoader.getInstance().displayImage(model.getImage(), holder.setImage, OstModernBaseActivity.imageOptions);
//        ImageLoader.getInstance().displayImage(model.getDefaultImage(position), holder.setImage, OstModernBaseActivity.imageOptions);
        return convertView;
    }

    static class ViewHolder {
        private ProgressBar progressBarLarge;
        private ImageView setImage;
        private ImageView payedOrNotImage;
        private OstModernCustomTextView setTitle;
        private RelativeLayout disableView;
        public ViewHolder(View view) {
            progressBarLarge = (ProgressBar)view.findViewById(R.id.progress_bar_large);
            setImage = (ImageView)view.findViewById(R.id.grid_item_image);
            payedOrNotImage = (ImageView)view.findViewById(R.id.grid_pay_or_not_label);
            setTitle = (OstModernCustomTextView)view.findViewById(R.id.grid_item_title);
            disableView = (RelativeLayout)view.findViewById(R.id.disable_view_layout);
        }
    }
    public void setImageHeight(int newHeight){
        imageHeight = newHeight;
        notifyDataSetChanged();
    }
}

