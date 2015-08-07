package uk.ostmodern.incoming.test.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import uk.ostmodern.incoming.test.R;

import java.util.HashMap;
import java.util.Map;

public class OstModernCustomButton extends Button {

	public static Map<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

	public OstModernCustomButton(Context context) {
		super(context);
	}

	public OstModernCustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public OstModernCustomButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public static void setTypeface(AttributeSet attrs, Button button) {
		Context context = button.getContext();

		TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.OstModernCustomButton);
		String typefaceName = values.getString(R.styleable.OstModernCustomButton_button_typeface);

		if (typefaceCache.containsKey(typefaceName)) {
			button.setTypeface(typefaceCache.get(typefaceName));
		} else {
			Typeface typeface;
			try {
				typeface = Typeface.createFromAsset(button.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + typefaceName);
			} catch (Exception e) {
				//set default font
				Log.v(context.getString(R.string.app_name), String.format("font not found", typefaceName));
				typeface = Typeface.createFromAsset(button.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + context.getResources().getString(R.string.default_font_name));
//				return;
			}

			typefaceCache.put(typefaceName, typeface);
			button.setTypeface(typeface);
		}

		values.recycle();
	}
}