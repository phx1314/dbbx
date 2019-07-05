//
//  Sc
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
import android.widget.ImageView;
import android.widget.TextView;

import com.ab.http.HttpUtil;
import com.ab.util.HttpResponseListener;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.config.BaseConfig;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaSc;
import com.ndtlg.dbbx.bean.BeanDb;
import com.ndtlg.dbbx.bean.BeanSc;
import com.ndtlg.dbbx.model.ModelTj;


public class Sc extends BaseItem {
    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_xh;
    public TextView mTextView_age;
    public TextView mTextView_qx;
    public TextView mTextView_price;
    public ImageView mImageView_del;
    public TextView mTextView_db;
    public AdaSc mAdaSc;
    public ModelTj.DataBean.ColumnsBean item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_sc, null);
        convertView.setTag(new Sc(convertView));
        return convertView;
    }

    public Sc(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mMImageView = (MImageView) contentview.findViewById(R.id.mMImageView);
        mTextView_title = (TextView) contentview.findViewById(R.id.mTextView_title);
        mTextView_xh = (TextView) contentview.findViewById(R.id.mTextView_xh);
        mTextView_age = (TextView) contentview.findViewById(R.id.mTextView_age);
        mTextView_qx = (TextView) contentview.findViewById(R.id.mTextView_qx);
        mTextView_price = (TextView) contentview.findViewById(R.id.mTextView_price);
        mImageView_del = (ImageView) contentview.findViewById(R.id.mImageView_del);
        mTextView_db = (TextView) findViewById(R.id.mTextView_db);
        mTextView_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanDb mBeanDb = new BeanDb();
                mBeanDb.id = Integer.valueOf(item.id);
                mBeanDb.status =  item.is_contrast.equals("0") ? 1 : 0;
                HttpUtil.loadJsonUrl(context, BaseConfig.getUri(), new Gson().toJson(mBeanDb), new HttpResponseListener(context, Sc.this, "20011", true));
                item.is_contrast = mBeanDb.status + "";
            }
        });
        mImageView_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanSc mBeanSc = new BeanSc();
                mBeanSc.id = Integer.valueOf(item.id);
                mBeanSc.status = 0;
                HttpUtil.loadJsonUrl(context, BaseConfig.getUri(), new Gson().toJson(mBeanSc), new HttpResponseListener(context, Sc.this, "20012", true));
            }
        });
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20011")) {
            Helper.toast("加入对比成功！", context);
            Frame.HANDLES.sentAll("FrgCart", 1, null);
            mAdaSc.notifyDataSetChanged();
        } else if (methodName.equals("20012")) {
            Helper.toast("删除成功！", context);
            mAdaSc.remove(item);
            Frame.HANDLES.sentAll("FrgWd", 0, null);
            Frame.HANDLES.sentAll("FrgTj", 1, null);
        }
    }

    public void set(AdaSc mAdaSc, ModelTj.DataBean.ColumnsBean item) {
        this.mAdaSc = mAdaSc;
        this.item = item;
        mMImageView.setObj("http://insurance.inrnui.com" + item.path);
        mTextView_title.setText(item.title);
        mTextView_xh.setText(item.category_name2);
        mTextView_age.setText("简介：" + item.desc);
//        mTextView_qx.setText();
        mTextView_price.setText(item.price);
        if (item.is_contrast.equals("0")) {
            mTextView_db.setText("+  对比");
            mTextView_db.setTextColor(context.getResources().getColor(R.color.A));
        } else {
            mTextView_db.setText("已加入对比");
            mTextView_db.setTextColor(context.getResources().getColor(R.color.gray));
        }
    }


}