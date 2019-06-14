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
import android.widget.EditText;

import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.R;


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
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("意见反馈");
        mHeadlayout.setRText("提交");
    }
}