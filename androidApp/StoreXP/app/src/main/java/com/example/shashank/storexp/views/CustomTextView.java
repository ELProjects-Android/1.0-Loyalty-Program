package com.example.shashank.storexp.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by root on 9/6/15.
 */
public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);

        applyCustomFont(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = getTypeface().getStyle();

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
    /*
     information about the TextView textStyle:
     http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
      */

        switch (textStyle) {
            case 1: // bold
                return FontCache.getTypeface("font/Brandon_Grotesque_Bold.ttf", context);

            case 2: // italic
                return FontCache.getTypeface("font/Brandon_Grotesque_Light_Italic.ttf", context);

            case 0: // regular
            default:
                return FontCache.getTypeface("font/Brandon_Grotesque_Regular.ttf", context);
        }
    }
}