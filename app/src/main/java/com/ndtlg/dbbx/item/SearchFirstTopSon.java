//
//  SearchFirstTopSon
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.frg.FrgSearch;
import com.ndtlg.dbbx.model.ModelSearch;


public class SearchFirstTopSon extends BaseItem {
    public TextView mTextView;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_search_first_top_son, null);
        convertView.setTag(new SearchFirstTopSon(convertView));
        return convertView;
    }

    public SearchFirstTopSon(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView = (TextView) contentview.findViewById(R.id.mTextView);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(context, FrgSearch.class, NoTitleAct.class, "key", mTextView.getText().toString());
            }
        });

    }

    public void set(ModelSearch.DataBean.HotBean item) {
        mTextView.setText(item.title);
    }


}