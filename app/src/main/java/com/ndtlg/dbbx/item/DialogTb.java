//
//  DialogTb
//
//  Created by DELL on 2018-12-28 13:52:32
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
import android.widget.TextView;

import com.ndtlg.dbbx.R;


public class DialogTb extends BaseItem {
    public TextView mTextView_title;
    public TextView mTextView_gb;
    public Dialog item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dialog_tb, null);
        convertView.setTag(new DialogTb(convertView));
        return convertView;
    }

    public DialogTb(View view) {
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
        mTextView_gb = (TextView) contentview.findViewById(R.id.mTextView_gb);

        mTextView_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
            }
        });
    }

    public void set(Dialog item) {
        this.item = item;
    }


}