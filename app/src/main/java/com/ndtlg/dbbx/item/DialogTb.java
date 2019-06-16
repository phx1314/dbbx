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
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.model.ModelDbDetail;


public class DialogTb extends BaseItem {
    public TextView mTextView_title;
    public TextView mTextView_gb;
    public Dialog item;
    public TextView mTextView_gw;
    public TextView mTextView_phone;
    public ModelDbDetail mModelDbDetail;

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
        mTextView_gw = (TextView) findViewById(R.id.mTextView_gw);
        mTextView_phone = (TextView) findViewById(R.id.mTextView_phone);

        mTextView_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.dismiss();
            }
        });
        mTextView_gw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(mModelDbDetail.data.other.url);
                    intent.setData(content_url);
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        mTextView_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    Uri data = Uri.parse("tel:" + mModelDbDetail.data.other.tel);
                    intent.setData(data);
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void set(Dialog item, ModelDbDetail mModelDbDetail) {
        this.item = item;
        this.mModelDbDetail = mModelDbDetail;
        mTextView_gw.setText(mModelDbDetail.data.other.url);
        mTextView_phone.setText(mModelDbDetail.data.other.tel + "");

    }


}