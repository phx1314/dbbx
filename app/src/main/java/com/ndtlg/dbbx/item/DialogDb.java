//
//  DialogDb
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
import com.ndtlg.dbbx.model.ModelData;


public class DialogDb extends BaseItem {
    public TextView mTextView_title;
    public TextView mTextView_content;
    public TextView mTextView_gb;
    public Dialog item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dialog_db, null);
        convertView.setTag(new DialogDb(convertView));
        return convertView;
    }

    public DialogDb(View view) {
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
        mTextView_gb = (TextView) contentview.findViewById(R.id.mTextView_gb);
        mTextView_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
            }
        });

    }

    public void set(Dialog item, ModelData mModelData) {
        this.item = item;
        mTextView_title.setText(mModelData.name);
    }


}