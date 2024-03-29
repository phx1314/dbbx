//
//  FrgPdetail
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.framewidget.frg.FrgPtDetail;
import com.framewidget.view.MListView;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.IndexAct;
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

import static com.ndtlg.dbbx.F.uid;


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
    public TextView mTextView_count;
    public RelativeLayout mRelativeLayout;
    public ScrollView mScrollView;

    @Override
    protected void create(Bundle savedInstanceState) {
        id = getActivity().getIntent().getStringExtra("id");
        setContentView(R.layout.frg_pdetail);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                if (Integer.valueOf(obj.toString()) < 0) {
                    mTextView_count.setVisibility(View.GONE);
                } else {
                    mTextView_count.setVisibility(View.VISIBLE);
                    mTextView_count.setText(Integer.valueOf(obj.toString()) > 99 ? "99" : obj.toString());
                }
                break;
        }
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
        mTextView_count = (TextView) findViewById(R.id.mTextView_count);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.mRelativeLayout);
        mScrollView = (ScrollView) findViewById(R.id.mScrollView);
        mTextView_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeanSc mBeanSc = new BeanSc();
                mBeanSc.id = Integer.valueOf(id);
                mBeanSc.status = mModelPdetail.data.rows.is_collect.equals("0") ? 1 : 0;
                loadJsonUrl("20012", new Gson().toJson(mBeanSc));
            }
        });
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), Intent.FLAG_ACTIVITY_CLEAR_TOP, FrgHome.class, IndexAct.class, "position", 2);
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
                mBeanDb.status = mModelPdetail.data.rows.is_contrast.equals("0") ? 1 : 0;
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
        if (TextUtils.isEmpty(uid)) {
            Helper.toast("请登录", getContext());
            finish();
            return;
        }
        loadJsonUrl("20013", new Gson().toJson(new BeanAddzj(Integer.valueOf(id))));
        loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(Integer.valueOf(id))));
        loadJsonUrl("60005", new Gson().toJson(new BeanPub(60005)));
        loadJsonUrl("60006", new Gson().toJson(new BeanPub(60006)));
//        loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(1)));
        if (F.count < 0) {
            mTextView_count.setVisibility(View.GONE);
        } else {
            mTextView_count.setVisibility(View.VISIBLE);
            mTextView_count.setText(F.count > 99 ? "99" : F.count + "");
        }
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
            if (mModelPdetail.data.rows.is_collect.equals("0")) {
                mTextView_sc.setText("收藏");
                mTextView_sc.setTextColor(getResources().getColor(R.color.A));
                mTextView_sc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bt_shoucang_n, 0, 0, 0);
            } else {
                mTextView_sc.setText("已收藏");
                mTextView_sc.setTextColor(getResources().getColor(R.color.gray));
                mTextView_sc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (mModelPdetail.data.rows.is_contrast.equals("0")) {
                mTextView_db.setText("加入对比");
                mTextView_db.setBackgroundColor(getResources().getColor(R.color.A));
            } else {
                mTextView_db.setText("取消对比");
                mTextView_db.setBackgroundColor(getResources().getColor(R.color.gray));
            }
            mMListView1.setAdapter(new AdaPdetailTop(getContext(), mModelPdetail.data.fields));
            mScrollView.smoothScrollTo(0, 0);
            Frame.HANDLES.sentAll("FrgWd", 0, null);
        } else if (methodName.equals("20012")) {
            Frame.HANDLES.sentAll("FrgWd", 0, null);
            Frame.HANDLES.sentAll("FrgTj,FrgEj,FrgSelect,FrgSearch", 1, null);
            loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(Integer.valueOf(id))));

        } else if (methodName.equals("20011")) {
            Frame.HANDLES.sentAll("FrgCart,FrgTj,FrgEj,FrgSelect,FrgSearch", 1, null);
            loadJsonUrl("20002", new Gson().toJson(new BeanPdetail(Integer.valueOf(id))));
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