//
//  FrgLoading
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.mdx.framework.activity.IndexAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dbbx.R;


public class FrgLoading extends BaseFrg {

    public LinearLayout activity_main;
    public MImageView mImageView;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_loading);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        mImageView = (MImageView) findViewById(R.id.mImageView);


    }

    public void loaddata() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Helper.startActivity(getContext(), FrgHome.class, IndexAct.class);
            }
        }, 2000);
    }


}