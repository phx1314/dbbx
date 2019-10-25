package com.framewidget.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

/**
 * Created by DELL on 2019/7/16.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
    //处理EditText抢焦点的问题
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused){
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }

    }
}

