//
//  FrgSet
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.frg.FrgPtDetail;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.cache.DataStoreCacheManage;
import com.mdx.framework.cache.FileStoreCacheManage;
import com.mdx.framework.cache.ImageStoreCacheManage;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.utility.UnitConver;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.bean.BeanAbout;
import com.ndtlg.dbbx.model.ModelAbout;

import static com.ndtlg.dbbx.F.saveJson;
import static com.ndtlg.dbbx.F.uid;


public class FrgSet extends BaseFrg {

    public TextView mTextView_1;
    public TextView mTextView_2;
    public LinearLayout mLinearLayout_qkhc;
    public TextView mTextView_qkhc;
    public TextView mTextView_logout;

    private Runnable mRunnable;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_set);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView_1 = (TextView) findViewById(R.id.mTextView_1);
        mTextView_2 = (TextView) findViewById(R.id.mTextView_2);
        mLinearLayout_qkhc = (LinearLayout) findViewById(R.id.mLinearLayout_qkhc);
        mTextView_qkhc = (TextView) findViewById(R.id.mTextView_qkhc);
        mTextView_logout = (TextView) findViewById(R.id.mTextView_logout);
        mTextView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJsonUrl("60003", new Gson().toJson(new BeanAbout()));
            }
        });
        mTextView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgFeedback.class, TitleAct.class);
            }
        });
        mLinearLayout_qkhc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setMessage("是否清除缓存")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Frame.IMAGECACHE.clean();
                                        Frame.IMAGECACHE.cleanCache();
                                        DataStoreCacheManage.FILEMANAGER
                                                .clear(mRunnable);
                                        FileStoreCacheManage.FILEMANAGER
                                                .clear(mRunnable);
                                        ImageStoreCacheManage.FILEMANAGER
                                                .clear(mRunnable);
                                        dialog.dismiss();
                                    }
                                }).setNegativeButton("取消", null).create().show();
            }
        });
        mTextView_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setMessage("是否退出登录")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        LogOut();
                                    }
                                }).setNegativeButton("取消", null).create().show();
            }
        });

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("60003")) {
            ModelAbout mModelAbout = (ModelAbout) F.json2Model(content, ModelAbout.class);
            Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", mModelAbout.data.showurl, "title", "关于我们");
        }
    }

    public void LogOut() {
        F.uid = "";
        saveJson("uid", "");
        Frame.HANDLES.sentAll("FrgWd", 0, null);
        Frame.HANDLES.sentAll("FrgCart", 2, null);
        mTextView_logout.setVisibility(View.GONE);
        finish();
    }

    public void loaddata() {
        if (!TextUtils.isEmpty(uid)) {
            mTextView_logout.setVisibility(View.VISIBLE);
        } else {
            mTextView_logout.setVisibility(View.GONE);
        }
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mTextView_qkhc.setText(UnitConver
                        .getBytesSize(DataStoreCacheManage.FILEMANAGER.TEMPFILES.tempSize
                                + FileStoreCacheManage.FILEMANAGER.TEMPFILES.tempSize
                                + ImageStoreCacheManage.FILEMANAGER.TEMPFILES.tempSize + Frame.IMAGECACHE.getsize())
                        .toString());
            }
        };
        mTextView_qkhc.setText(UnitConver.getBytesSize(DataStoreCacheManage.FILEMANAGER.TEMPFILES.tempSize
                + FileStoreCacheManage.FILEMANAGER.TEMPFILES.tempSize
                + ImageStoreCacheManage.FILEMANAGER.TEMPFILES.tempSize + Frame.IMAGECACHE.getsize())
                .toString());

    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("设置");
    }
}