//
//  Db
//
//  Created by DELL on 2018-12-28 15:55:57
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.view.CallBackOnly;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.model.ModelData;
import com.ndtlg.dbbx.view.AnimateScrollView;


public class DbCard extends BaseItemCard {
    public TextView mTextView_title;
    public AnimateScrollView scrollView;
    public LinearLayout mLinearLayout_content;
    public TextView mTextView;
    public ModelData mModelData;

    @SuppressLint("InflateParams")
    public static DbCard getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_db, parent, false);
        return new DbCard(convertView, context);

    }

    public DbCard(View itemView, Context context) {
        super(itemView);
        this.context = context;
        initView();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView_title = (TextView) findViewById(R.id.mTextView_title);
        scrollView = (AnimateScrollView) findViewById(R.id.scrollView);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);
        mTextView = (TextView) findViewById(R.id.mTextView);
        mTextView_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view1 = DialogDb.getView(context, null);
                com.framewidget.F.showCenterDialog(context, view1, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DialogDb) view1.getTag()).set(mDialog,mModelData);
                    }
                });
            }
        });

    }

    public void set(Object mFreeRecyclerView, ModelData mModelData) {
        this.mModelData = mModelData;
        scrollView.setTag(mFreeRecyclerView);
        mTextView_title.setText(mModelData.name);
        mLinearLayout_content.removeAllViews();
        for (String str : mModelData.values) {
            View view = DbSon.getView(context, null);
            ((DbSon) view.getTag()).set(str);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            mLinearLayout_content.addView(view, layoutParams);
        }
        View view = DbSon.getView(context, null);
        ((DbSon) view.getTag()).set("");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mLinearLayout_content.addView(view, layoutParams);
    }


}