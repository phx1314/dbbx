//
//  FrgMain
//
//  Created by DELL on 2018-12-24 14:05:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.bean.BeanTj;
import com.ndtlg.dbbx.model.ModelTj;


public class FrgMain extends BaseFrg {

    public ImageView mImageView1;
    public ImageView mImageView2;
    public ImageView mImageView3;
    public ImageView mImageView4;
    public TextView mTextView_search;
    public ModelTj mModelTj;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_main);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mImageView1 = (ImageView) findViewById(R.id.mImageView1);
        mImageView2 = (ImageView) findViewById(R.id.mImageView2);
        mImageView3 = (ImageView) findViewById(R.id.mImageView3);
        mImageView4 = (ImageView) findViewById(R.id.mImageView4);
        mTextView_search = (TextView) findViewById(R.id.mTextView_search);

        mTextView_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgSearchFirst.class, NoTitleAct.class);
            }
        });
        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    for (ModelTj.DataBean.CategoryBean mCategoryBean : mModelTj.data.category) {
                        if (mCategoryBean.title.equals("财产保险")) {
                            Helper.startActivity(getContext(), FrgEj.class, TitleAct.class, "mCategoryBean", mCategoryBean);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    for (ModelTj.DataBean.CategoryBean mCategoryBean : mModelTj.data.category) {
                        if (mCategoryBean.title.equals("人身保险")) {
                            Helper.startActivity(getContext(), FrgEj.class, TitleAct.class, "mCategoryBean", mCategoryBean);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    for (ModelTj.DataBean.CategoryBean mCategoryBean : mModelTj.data.category) {
                        if (mCategoryBean.title.equals("团体保险")) {
                            Helper.startActivity(getContext(), FrgEj.class, TitleAct.class, "mCategoryBean", mCategoryBean);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void loaddata() {
        loadJsonUrl("20001", new Gson().toJson(new BeanTj()));
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20001")) {
            mModelTj = (ModelTj) F.json2Model(content, ModelTj.class);
            Frame.HANDLES.sentAll("FrgTj", 0, mModelTj);
        }
    }
}