//
//  FrgPdetail
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.framewidget.frg.FrgPtDetail;
import com.framewidget.view.MListView;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaPdetailTop;
import com.ndtlg.dbbx.bean.BeanAddzj;
import com.ndtlg.dbbx.bean.BeanDb;
import com.ndtlg.dbbx.bean.BeanPdetail;
import com.ndtlg.dbbx.bean.BeanPub;
import com.ndtlg.dbbx.bean.BeanSc;
import com.ndtlg.dbbx.model.ModelAbout;
import com.ndtlg.dbbx.model.ModelPdetail;


public class FrgPdetail extends BaseFrg {

    public ImageButton mImageButton_back;
    public ImageButton mImageButton_fx;
    public TextView mTextView_title;
    public TextView mTextView_qx;
    public TextView mTextView_sc;
    public MListView mMListView1;
    public MListView mMListView2;
    public TextView mTextView_price;
    public String id;
    public com.mdx.framework.widget.MImageView mMImageView_bg;
    public ModelPdetail mModelPdetail;
    public TextView mTextView_db;
    public TextView mTextView_tk;
    public TextView mTextView_jbxx;
    public ModelAbout mModelAbout_1;
    public ModelAbout mModelAbout_2;

    @Override
    protected void create(Bundle savedInstanceState) {
        id = getActivity().getIntent().getStringExtra("id");
        setContentView(R.layout.frg_pdetail);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mImageButton_back = (ImageButton) findViewById(R.id.mImageButton_back);
        mImageButton_fx = (ImageButton) findViewById(R.id.mImageButton_fx);
        mTextView_title = (TextView) findViewById(R.id.mTextView_title);
        mTextView_qx = (TextView) findViewById(R.id.mTextView_qx);
        mTextView_sc = (TextView) findViewById(R.id.mTextView_sc);
        mMListView1 = (MListView) findViewById(R.id.mMListView1);
        mMListView2 = (MListView) findViewById(R.id.mMListView2);
        mTextView_price = (TextView) findViewById(R.id.mTextView_price);
        mMImageView_bg = (com.mdx.framework.widget.MImageView) findViewById(R.id.mMImageView_bg);
        mTextView_db = (TextView) findViewById(R.id.mTextView_db);
        mTextView_tk = (TextView) findViewById(R.id.mTextView_tk);
        mTextView_jbxx = (TextView) findViewById(R.id.mTextView_jbxx);
        mTextView_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanSc mBeanSc = new BeanSc();
                mBeanSc.id = Integer.valueOf(id);
                mBeanSc.status = mModelPdetail.data.rows.collect.equals("0") ? 1 : 0;
                loadJsonUrl("20012", new Gson().toJson(mBeanSc));
            }
        });
        mImageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrgPdetail.this.finish();
            }
        });
        mImageButton_fx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F.shareText("分享", "http://www.baidu.com", getContext());
            }
        });
        mTextView_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanDb mBeanDb = new BeanDb();
                mBeanDb.id = Integer.valueOf(id);
                mBeanDb.status = 1;
                loadJsonUrl("20011", new Gson().toJson(mBeanDb));
            }
        });
        mTextView_tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", mModelAbout_1.data.showurl, "title", "保险条款");
            }
        });
        mTextView_jbxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", mModelAbout_2.data.showurl, "title", "保险公司基本信息");
            }
        });
    }

    public void loaddata() {
        loadJsonUrl("20013", new Gson().toJson(new BeanAddzj(Integer.valueOf(id))));
        loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(Integer.valueOf(id))));
        loadJsonUrl("60005", new Gson().toJson(new BeanPub(60005)));
        loadJsonUrl("60006", new Gson().toJson(new BeanPub(60006)));
//        loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(1)));
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20013")) {
            Frame.HANDLES.sentAll("FrgWd", 0, null);
        } else if (methodName.equals("20002")) {
            mModelPdetail = (ModelPdetail) F.json2Model(content, ModelPdetail.class);
            mMImageView_bg.setObj(mModelPdetail.data.rows.path);
            mTextView_title.setText(mModelPdetail.data.rows.title);
            mTextView_qx.setText(mModelPdetail.data.rows.desc);
            mTextView_price.setText(mModelPdetail.data.rows.price);
            if (mModelPdetail.data.rows.collect.equals("0")) {
                mTextView_sc.setText("收藏");
                mTextView_sc.setTextColor(getResources().getColor(R.color.A));
                mTextView_sc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bt_shoucang_n, 0, 0, 0);
            } else {
                mTextView_sc.setText("已收藏");
                mTextView_sc.setTextColor(getResources().getColor(R.color.gray));
                mTextView_sc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            mMListView1.setAdapter(new AdaPdetailTop(getContext(), mModelPdetail.data.fields));
        } else if (methodName.equals("20012")) {
            loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(Integer.valueOf(id))));
        } else if (methodName.equals("20011")) {
            Helper.toast("加入对比成功！", getContext());
            Frame.HANDLES.sentAll("FrgCart", 1, null);
        } else if (methodName.equals("60005")) {
            mModelAbout_1 = (ModelAbout) F.json2Model(content, ModelAbout.class);

        } else if (methodName.equals("60006")) {
            mModelAbout_2 = (ModelAbout) F.json2Model(content, ModelAbout.class);
        }
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("产品详情");
    }
}