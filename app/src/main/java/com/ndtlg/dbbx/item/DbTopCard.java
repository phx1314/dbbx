//
//  DbTop
//
//  Created by DELL on 2018-12-28 15:55:57
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.mdx.framework.Frame;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.model.ModelDbDetail;
import com.ndtlg.dbbx.view.AnimateScrollView;


public class DbTopCard extends BaseItemCard implements CompoundButton.OnCheckedChangeListener {
    public ToggleButton mToggleButton;
    public AnimateScrollView scrollView;
    public LinearLayout mLinearLayout_content;

    @SuppressLint("InflateParams")
    public static DbTopCard getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_db_top, parent, false);
        return new DbTopCard(convertView, context);

    }

    public DbTopCard(View itemView, Context context) {
        super(itemView);
        this.context = context;
        initView();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mToggleButton = (ToggleButton) findViewById(R.id.mToggleButton);
        scrollView = (AnimateScrollView) findViewById(R.id.scrollView);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);

    }

    public void set(Object mFreeRecyclerView, ModelDbDetail mModelDbDetail) {
        mToggleButton.setOnCheckedChangeListener(null);
        mToggleButton.setChecked(mModelDbDetail.ischecked);
        mToggleButton.setOnCheckedChangeListener(this);
        scrollView.setTag(mFreeRecyclerView);
        mLinearLayout_content.removeAllViews();
        for (ModelDbDetail.DataBean.ColumnsBean mColumnsBean : mModelDbDetail.data.columns) {
            View view = DbTopSon.getView(context, null);
            mLinearLayout_content.addView(view);
            ((DbTopSon) view.getTag()).set(mColumnsBean);
        }
        View view_add = DbTopAdd.getView(context, null);
        mLinearLayout_content.addView(view_add);
        view_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frame.HANDLES.sentAll("FrgDb", 4, null);

            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Frame.HANDLES.sentAll("FrgDb", 0, b);
    }
}