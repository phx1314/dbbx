//
//  FrgPdf
//
//  Created by DELL on 2018-10-15 10:00:20
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.framewidget.frg;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.ab.http.AbFileHttpResponseListener;
import com.ab.http.HttpUtil;
import com.framewidget.R;
import com.joanzapata.pdfview.PDFView;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;


public class FrgPdf extends BaseFrg {

    public PDFView pdfView;

    public String url;
    public ProgressDialog mProgressDialog;
    public TextView mTextView;

    @Override
    protected void create(Bundle savedInstanceState) {
        url = getActivity().getIntent().getStringExtra("url");
        setContentView(R.layout.frg_pdf);
        initView();
        try {
            loaddata();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        pdfView = (PDFView) findViewById(R.id.pdfView);
        mTextView = (TextView) findViewById(R.id.mTextView);
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("加载中...");

    }

    public void loaddata() throws Exception {
        HttpUtil.downLoadFile(getContext(), url, new AbFileHttpResponseListener() {
            @Override
            public void onStart() {
                mProgressDialog.show();
            }

            @Override
            public void onFinish() {
                mProgressDialog.dismiss();
                try {
                    if (!(getFile().getAbsolutePath().endsWith(".pdf") || getFile().getAbsolutePath().endsWith(".PDF"))) {
                        Helper.toast("无效文件", getContext());
                        return;
                    }
                    pdfView.fromFile(getFile()).swipeVertical(true)
//                .pages(0, 0, 0, 0, 0, 0) // 默认全部显示，pages属性可以过滤性显示
                            .defaultPage(1)//默认展示第一页
                            .load();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, String content, Throwable error) {
                mProgressDialog.dismiss();
                Helper.toast("pdf不存在", getContext());
            }

            @Override
            public void onProgress(final long bytesWritten, final long totalSize) {
            }
        });
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("PDF预览");
    }
}