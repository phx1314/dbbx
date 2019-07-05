//
//  FrgCart
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ab.view.listener.AbOnListListener;
import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaCart;
import com.ndtlg.dbbx.bean.BeanDbList;
import com.ndtlg.dbbx.bean.BeanDeleteAll;
import com.ndtlg.dbbx.model.ModelDblist;
import com.ndtlg.dbbx.model.ModelTj;

import java.util.ArrayList;
import java.util.List;

import static com.ndtlg.dbbx.F.uid;


public class FrgCart extends BaseFrg implements CompoundButton.OnCheckedChangeListener {

    public AbPullListView mListView;
    public CheckBox mCheckBox;
    public TextView mTextView_db;
    public TextView mTextView_delete;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_cart);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                int size = 0;
                for (ModelTj.DataBean.ColumnsBean item : ((AdaCart) mListView.getmAdapter()).getList()) {
                    if (item.isChecked) {
                        size++;
                    }
                }
                mCheckBox.setOnCheckedChangeListener(null);
                mCheckBox.setChecked(size == mListView.getmAdapter().getCount());
                mCheckBox.setOnCheckedChangeListener(this);
                break;
            case 1:
                mListView.setJsonApiLoadParams("", new BeanDbList());
                break;
            case 2:
                mListView.getmAdapter().clear();
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20014")) {
            Helper.toast("删除成功", getContext());
            mListView.pullLoad();
            mCheckBox.setOnCheckedChangeListener(null);
            mCheckBox.setChecked(false);
            mCheckBox.setOnCheckedChangeListener(FrgCart.this);
        }
    }

    private void findVMethod() {
        mListView = (AbPullListView) findViewById(R.id.mListView);
        mCheckBox = (CheckBox) findViewById(R.id.mCheckBox);
        mTextView_db = (TextView) findViewById(R.id.mTextView_db);
        mTextView_delete = (TextView) findViewById(R.id.mTextView_delete);
        mListView.setAbOnListListener(new AbOnListListener() {
            @Override
            public void onRefresh() {
                mCheckBox.setOnCheckedChangeListener(null);
                mCheckBox.setChecked(false);
                mCheckBox.setOnCheckedChangeListener(FrgCart.this);
            }
        });
        mTextView_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ids = "";
                for (ModelTj.DataBean.ColumnsBean item : ((AdaCart) mListView.getmAdapter()).getList()) {
                    if (item.isChecked) {
                        ids += item.id + ",";
                    }
                }
                if (TextUtils.isEmpty(ids)) {
                    Helper.toast("请选择产品", getContext());
                    return;
                }
                loadJsonUrl("20014", new Gson().toJson(new BeanDeleteAll(ids.substring(0, ids.length() - 1))));
            }
        });
        mTextView_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(uid)) {
                    Helper.toast("请先登录", getContext());
                    return;
                }
                String category_name2 = "";
                String ids = "";
                int cid1 = 0;
                int cid2 = 0;
                for (ModelTj.DataBean.ColumnsBean item : ((AdaCart) mListView.getmAdapter()).getList()) {
                    if (item.isChecked) {
                        ids += item.contrast_id + ",";
                        cid1 = Integer.valueOf(item.cid1);
                        cid2 = Integer.valueOf(item.cid2);
//                        if (TextUtils.isEmpty(category_name2)) {
//                            category_name2 = item.category_name2;
//                        } else if (!category_name2.equals(item.category_name2)) {
//                            Helper.toast("请选择同类产品对比", getContext());
//                            return;
//                        }
                    }
                }
                if (TextUtils.isEmpty(ids)) {
                    Helper.toast("请选择对比产品", getContext());
                    return;
                }
                Helper.startActivity(getContext(), FrgDb.class, TitleAct.class, "ids", ids.substring(0, ids.length() - 1), "cid1", cid1, "cid2", cid2);
            }
        });
    }

    public void loaddata() {
        mListView.setPullLoadEnable(false);
        mListView.setJsonApiLoadParams("", new BeanDbList());
        mListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelDblist mModelDblist = (ModelDblist) F.json2Model(content, ModelDblist.class);

                List<ModelTj.DataBean.ColumnsBean> list = new ArrayList<ModelTj.DataBean.ColumnsBean>();
                for (List<ModelTj.DataBean.ColumnsBean> data : mModelDblist.data.columns) {
                    list.addAll(data);
                }
                F.count = list.size();
                Frame.HANDLES.sentAll("FrgPdetail", 0, list.size());
                return new AdaCart(getContext(), list);
            }
        });
        mCheckBox.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        for (ModelTj.DataBean.ColumnsBean item : ((AdaCart) mListView.getmAdapter()).getList()) {
            item.isChecked = isChecked;
        }
        ((AdaCart) mListView.getmAdapter()).notifyDataSetChanged();
    }
}