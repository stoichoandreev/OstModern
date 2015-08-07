package uk.ostmodern.incoming.test.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import uk.ostmodern.incoming.test.R;

import java.util.HashMap;
import java.util.Map;

public class OstModernCustomEditText extends EditText {

	public static Map<String, Typeface> typefaceCache = new HashMap<String, Typeface>();

	public OstModernCustomEditText(Context context) {
		super(context);
	}

	public OstModernCustomEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public OstModernCustomEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		if (!isInEditMode()) {
			setTypeface(attrs, this);
		}
	}

	public static void setTypeface(AttributeSet attrs, EditText editText) {
		Context context = editText.getContext();

		TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.OstModernCustomEditText);
		String typefaceName = values.getString(R.styleable.OstModernCustomEditText_edit_text_typeface);
		if (typefaceCache.containsKey(typefaceName)) {
			editText.setTypeface(typefaceCache.get(typefaceName));
		} else {
			Typeface typeface;
			try {
				typeface = Typeface.createFromAsset(editText.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + typefaceName);
			} catch (Exception e) {
				//set default font
				Log.e(context.getString(R.string.app_name), String.format("font not found", typefaceName));
				typeface = Typeface.createFromAsset(editText.getContext().getAssets(), context.getString(R.string.assets_fonts_folder) + context.getResources().getString(R.string.default_font_name));
//				return;
			}

			typefaceCache.put(typefaceName, typeface);
			editText.setTypeface(typeface);
		}

		values.recycle();
	}
}