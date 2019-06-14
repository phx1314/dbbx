//
//  SearchFirstTop
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framewidget.view.FixGridLayout;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.model.ModelSearch;


public class SearchFirstTop extends BaseItem {
    public FixGridLayout mFixGridLayout;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_search_first_top, null);
        convertView.setTag(new SearchFirstTop(convertView));
        return convertView;
    }

    public SearchFirstTop(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mFixGridLayout = (FixGridLayout) contentview.findViewById(R.id.mFixGridLayout);

        mFixGridLayout.setDividerLine((int) context.getResources().getDimension(R.dimen.j10dp));
        mFixGridLayout.setDividerCol((int) context.getResources().getDimension(R.dimen.j5dp));
    }

    public void set(ModelSearch item) {
        mFixGridLayout.removeAllViews();
        for (ModelSearch.DataBean.HotBean mHotBean : item.data.hot) {
            View view = SearchFirstTopSon.getView(context, null);
            ((SearchFirstTopSon) view.getTag()).set(mHotBean);
            mFixGridLayout.addView(view);
        }
    }

}