//
//  FrgSc
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaSc;
import com.ndtlg.dbbx.bean.BeanClearSc;
import com.ndtlg.dbbx.bean.BeanScList;
import com.ndtlg.dbbx.model.ModelPlist;


public class FrgSc extends BaseFrg {

    public AbPullListView mAbPullListView;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_sc);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);


    }

    public void loaddata() {
        mAbPullListView.setJsonApiLoadParams("", new BeanScList());
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelPlist mModelDblist = (ModelPlist) F.json2Model(content, ModelPlist.class);
                return new AdaSc(getContext(), mModelDblist.data.columns);
            }
        });
    }
    @Override
    public void onSuccess(String methodName, String content) {
        Helper.toast("操作成功",getContext());
        Frame.HANDLES.sentAll("FrgWd", 0, null);
        mAbPullListView.pullLoad();
    }
    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("收藏夹");
        mHeadlayout.setRText("清空");
        mHeadlayout.setRightOnclicker(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJsonUrl("30031", new Gson().toJson(new BeanClearSc( )));
            }
        });
    }
}