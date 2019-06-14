//
//  DbTopSon
//
//  Created by DELL on 2018-12-28 15:28:19
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdx.framework.Frame;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.model.ModelDbDetail;


public class DbTopSon extends BaseItem {
    public TextView mTextView_title;
    public TextView mTextView_content;
    public TextView mTextView_price;
    public ImageView mImageView_close;
    public ModelDbDetail.DataBean.ColumnsBean item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_db_top_son, null);
        convertView.setTag(new DbTopSon(convertView));
        return convertView;
    }

    public DbTopSon(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView_title = (TextView) contentview.findViewById(R.id.mTextView_title);
        mTextView_content = (TextView) contentview.findViewById(R.id.mTextView_content);
        mTextView_price = (TextView) contentview.findViewById(R.id.mTextView_price);
        mImageView_close = (ImageView) findViewById(R.id.mImageView_close);

        mImageView_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frame.HANDLES.sentAll("FrgDb", 1, item.contrast_id);
            }
        });
    }

    public void set(ModelDbDetail.DataBean.ColumnsBean item) {
        this.item = item;
        mTextView_title.setText(item.title);
        mTextView_content.setText(item.desc);
        mTextView_price.setText(item.price);
    }


}