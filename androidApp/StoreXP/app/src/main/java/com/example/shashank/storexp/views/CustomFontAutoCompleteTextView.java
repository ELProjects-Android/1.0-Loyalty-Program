package com.example.shashank.storexp.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/**
 * Created by root on 23/6/15.
 */
public class CustomFontAutoCompleteTextView extends AutoCompleteTextView {


    public CustomFontAutoCompleteTextView(Context context) {
        super(context);

        applyCustomFont(context, null);
    }

    public CustomFontAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public CustomFontAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        applyCustomFont(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomFontAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

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
                return FontCache.getTypeface("font/CaviarDreams_Bold.ttf", context);

            case 2: // italic
                return FontCache.getTypeface("font/CaviarDreams_Italic.ttf", context);

            case 0: // regular
            default:
                return FontCache.getTypeface("font/CaviarDreams.ttf", context);
        }
    }
}
