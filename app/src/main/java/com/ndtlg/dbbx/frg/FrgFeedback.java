//
//  FrgFeedback
//
//  Created by DELL on 2019-01-08 09:19:05
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.bean.BeanAddYj;


public class FrgFeedback extends BaseFrg {

    public EditText et_content;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_feedback);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        et_content = (EditText) findViewById(R.id.et_content);


    }

    public void loaddata() {

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("60004")) {
            Helper.toast("添加成功", getContext());
            finish();
        }
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("意见反馈");
        mHeadlayout.setRText("提交");
        mHeadlayout.setRightOnclicker(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_content.getText().toString().trim())) {
                    Helper.toast("请输入", getContext());
                    return;
                }
                loadJsonUrl("60004", new Gson().toJson(new BeanAddYj(et_content.getText().toString().trim())));
            }
        });
    }
}