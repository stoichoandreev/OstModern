package uk.ostmodern.incoming.test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.api.gson_models.ItemsModel;
import uk.ostmodern.incoming.test.custom.OstModernCustomTextView;

import java.util.List;

/**
 * Created by sniper on 8/11/15.
 */

public class ItemsListAdapter extends ArrayAdapter<ItemsModel> {

    private LayoutInflater mInflater;
    private List<ItemsModel> originalData;

    public ItemsListAdapter(Context cont, int layoutId, List<ItemsModel> models) {
        super(cont, layoutId, models);

        this.originalData = models;

        mInflater = (LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return originalData.size();
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.single_item_layout, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemsModel model = originalData.get(position);
        holder.itemTitle.setText(model.getContentType());
        holder.publishDate.setText(Integer.toString(model.getPosition()));
//        ImageLoader.getInstance().displayImage(model.getContentUrl(), holder.itemImage, StartActivity.imageOptions, new SimpleImageLoadingListener() {
//            @Override
//            public void onLoadingStarted(String imageUri, View view) {
//                holder.progressBarSmall.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//                holder.progressBarSmall.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                holder.progressBarSmall.setVisibility(View.GONE);
//            }
//        });
        return convertView;
    }

    static class ViewHolder {
        private OstModernCustomTextView itemTitle;
        private OstModernCustomTextView publishDate;
//        private ProgressBar progressBarSmall;
//        private ImageView itemImage;

        public ViewHolder(View view) {
            itemTitle = (OstModernCustomTextView)view.findViewById(R.id.item_title);
            publishDate = (OstModernCustomTextView)view.findViewById(R.id.item_publish_date);
//            progressBarSmall = (ProgressBar)view.findViewById(R.id.progress_bar_small);
//            itemImage = (ImageView)view.findViewById(R.id.item_image);
        }
    }
}

