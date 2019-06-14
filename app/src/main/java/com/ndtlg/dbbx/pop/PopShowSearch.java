package com.ndtlg.dbbx.pop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaSearchPopSon;

import java.util.List;


public class PopShowSearch implements OnClickListener {

    public ListView mListView;
    public Context context;
    private View view;
    private PopupWindow popwindow;
    private View popview;

    public PopShowSearch(Context context, View view, List<String> list) {
        super();
        this.view = view;
        this.context = context;
        LayoutInflater flater = LayoutInflater.from(context);
        popview = flater.inflate(R.layout.item_search_pop, null);
        popwindow = new PopupWindow(popview, LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        mListView = (ListView) popview
                .findViewById(R.id.mListView);
        popwindow.setBackgroundDrawable(new BitmapDrawable(context
                .getResources()));
        popwindow.setTouchable(true);
        popwindow.setOutsideTouchable(true);
        popwindow.setFocusable(true);
        mListView.setAdapter(new AdaSearchPopSon(context, list));
    }


    @SuppressLint("NewApi")
    public void show() {
        popwindow.showAsDropDown(view, 0, 0);
    }

    public void hide() {
        popwindow.dismiss();
    }

    public boolean isShow() {
        return popwindow.isShowing();
    }

    @Override
    public void onClick(View arg0) {
        hide();

    }

}
