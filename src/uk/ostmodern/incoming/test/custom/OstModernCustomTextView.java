package uk.ostmodern.incoming.test.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import uk.ostmodern.incoming.test.R;

import java.util.HashMap;
import java.util.Map;

public class OstModernCustomTextView extends TextView {

	public static Map<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

	public OstModernCustomTextView(Context context) {

		super(context);
	}

	public OstModernCustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public OstModernCustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public static void setTypeface(AttributeSet attrs, TextView textView) {
		Context context = textView.getContext();

		if(textView.getText() != null && textView.getText().toString().matches("\\<.*?>")) textView.setText(Html.fromHtml(textView.getText().toString()));

		TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.OstModernCustomTextView);
		String typefaceName = values.getString(R.styleable.OstModernCustomTextView_text_view_typeface);
		if (typefaceCache.containsKey(typefaceName)) {
			textView.setTypeface(typefaceCache.get(typefaceName));
		} else {
			Typeface typeface;
			try {
				typeface = Typeface.createFromAsset(textView.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + typefaceName);
			} catch (Exception e) {
				//set default font
				Log.v(context.getString(R.string.app_name), String.format("font not found", typefaceName));
				typeface = Typeface.createFromAsset(textView.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + context.getResources().getString(R.string.default_font_name));
//				return;
			}

			typefaceCache.put(typefaceName, typeface);
			textView.setTypeface(typeface);
		}
		values.recycle();
	}

	public void setText(CharSequence text,boolean withHtml) {
		super.setText(Html.fromHtml(text.toString()));
	}
}