//
//  Zj
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
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
import com.ndtlg.dbbx.ada.AdaZj;
import com.ndtlg.dbbx.bean.BeanDb;
import com.ndtlg.dbbx.bean.BeanSc;
import com.ndtlg.dbbx.model.ModelTj;


public class Zj extends BaseItem {
    public TextView mTextView_time;
    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_xh;
    public TextView mTextView_age;
    public TextView mTextView_qx;
    public TextView mTextView_price;
    public ImageView mImageView_k;
    public TextView mTextView_db;
    public TextView mTextView_sc;
    public ModelTj.DataBean.ColumnsBean item;
    public AdaZj mAdaZj;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_zj, null);
        convertView.setTag(new Zj(convertView));
        return convertView;
    }

    public Zj(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView_time = (TextView) contentview.findViewById(R.id.mTextView_time);
        mMImageView = (MImageView) contentview.findViewById(R.id.mMImageView);
        mTextView_title = (TextView) contentview.findViewById(R.id.mTextView_title);
        mTextView_xh = (TextView) contentview.findViewById(R.id.mTextView_xh);
        mTextView_age = (TextView) contentview.findViewById(R.id.mTextView_age);
        mTextView_qx = (TextView) contentview.findViewById(R.id.mTextView_qx);
        mTextView_price = (TextView) contentview.findViewById(R.id.mTextView_price);
        mImageView_k = (ImageView) contentview.findViewById(R.id.mImageView_k);
        mTextView_db = (TextView) findViewById(R.id.mTextView_db);
        mTextView_sc = (TextView) findViewById(R.id.mTextView_sc);

        mTextView_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanDb mBeanDb = new BeanDb();
                mBeanDb.id = Integer.valueOf(item.id);
                mBeanDb.status = 1;
                HttpUtil.loadJsonUrl(context, BaseConfig.getUri(), new Gson().toJson(mBeanDb), new HttpResponseListener(context, Zj.this, "20011", true));
            }
        });
        mTextView_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanSc mBeanSc = new BeanSc();
                mBeanSc.id = Integer.valueOf(item.id);
                mBeanSc.status = TextUtils.isEmpty(item.collect)||item.collect.equals("0") ? 1 : 0;
                HttpUtil.loadJsonUrl(context, BaseConfig.getUri(), new Gson().toJson(mBeanSc), new HttpResponseListener(context, Zj.this, "20012", true));
                item.collect = mBeanSc.status + "";
            }
        });
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(String create_date) {
        for (int i = 0; i < mAdaZj.getCount(); i++) {
            if (create_date.equals(mAdaZj.get(i).create_date)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20011")) {
            Helper.toast("加入对比成功！", context);
            Frame.HANDLES.sentAll("FrgCart", 1, null);
        } else if (methodName.equals("20012")) {
            mAdaZj.notifyDataSetChanged();
            Frame.HANDLES.sentAll("FrgWd", 0, null);
        }
    }

    public void set(AdaZj mAdaZj, ModelTj.DataBean.ColumnsBean item, int position) {
        this.mAdaZj = mAdaZj;
        this.item = item;
        mMImageView.setObj("http://insurance.inrnui.com" + item.path);
        mTextView_title.setText(item.title);
        mTextView_xh.setText(item.category_name2);
        mTextView_time.setText(item.create_date);
        if (position == getPositionForSection(item.create_date)) {
            mTextView_time.setVisibility(View.VISIBLE);
        } else {
            mTextView_time.setVisibility(View.GONE);
        }
//        mTextView_age.setText();
//        mTextView_qx.setText();
        mTextView_price.setText(item.price);

        if (TextUtils.isEmpty(item.collect)||item.collect.equals("0")) {
            mTextView_sc.setText("收藏");
            mTextView_sc.setTextColor(context.getResources().getColor(R.color.A));
            mTextView_sc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bt_shoucang_n, 0, 0, 0);
        } else {
            mTextView_sc.setText("已收藏");
            mTextView_sc.setTextColor(context.getResources().getColor(R.color.gray));
            mTextView_sc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }


}