//
//  BaseFrg
//
//  Created by DELL on 2018-12-24 13:13:13
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.view.View;

import com.ab.http.HttpUtil;
import com.ab.util.HttpResponseListener;
import com.ab.util.HttpResponseListenerSon;
import com.framewidget.view.Headlayout;
import com.mdx.framework.activity.MFragment;
import com.mdx.framework.config.BaseConfig;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.R;

public abstract class BaseFrg extends MFragment implements View.OnClickListener, HttpResponseListenerSon {
    public Headlayout mHeadlayout;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onFailure(int statusCode, String content, Throwable error) {

    }

    @Override
    public void onSuccess(String methodName, String content) {
    }

    public void loadJson(String methodName, String methodNameBiaoShi, String json) {
        HttpUtil.loadJsonUrl(getContext(), BaseConfig.getUri(), json, new HttpResponseListener(getContext(), this, methodNameBiaoShi, true));
    }

    public void loadJsonNoshow(String methodName, String methodNameBiaoShi, String json) {
        HttpUtil.loadJsonUrl(getContext(), BaseConfig.getUri(), json, new HttpResponseListener(getContext(), this, methodNameBiaoShi, false));
    }

    public void loadJsonUrl(String methodName, String json) {
        HttpUtil.loadJsonUrl(getContext(), BaseConfig.getUri(), json, new HttpResponseListener(getContext(), this, methodName, true));
    }

    public void loadJsonUrlNoshow(String methodName, String json) {
        HttpUtil.loadJsonUrl(getContext(), BaseConfig.getUri(), json, new HttpResponseListener(getContext(), this, methodName, false));
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        mHeadlayout = new Headlayout(context);
        mHeadlayout.setLeftBackground(R.drawable.bt_fanhui_n);
        mHeadlayout.setGoBack(getActivity());
        actionBar.addView(mHeadlayout);
    }
}
