//
//  FrgSelect
//
//  Created by DELL on 2019-01-22 11:06:22
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.os.Bundle;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaPub;
import com.ndtlg.dbbx.bean.BeanTj;
import com.ndtlg.dbbx.model.ModelTj;


public class FrgSelect extends BaseFrg {

    public AbPullListView mListView;
    public int cid1;
    public int cid2;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_select);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                Frame.HANDLES.sentAll("FrgDb", 2, obj);
                this.finish();
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mListView = (AbPullListView) findViewById(R.id.mListView);


    }

    public void loaddata() {
        BeanTj mBeanTj = new BeanTj();
        mBeanTj.cid1 = cid1;
        mBeanTj.cid2 = cid2;
        mListView.setJsonApiLoadParams("", mBeanTj);
        mListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelTj mModelTj = (ModelTj) F.json2Model(content, ModelTj.class);
                return new AdaPub(getContext(), mModelTj.data.columns, "FrgSelect");
            }
        });
    }


    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("请选择");
    }
}