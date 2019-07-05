//
//  FrgSearch
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaPub;
import com.ndtlg.dbbx.ada.AdaSearchPopSon;
import com.ndtlg.dbbx.bean.BeanMhSearch;
import com.ndtlg.dbbx.model.ModelMhSearch;

import java.util.ArrayList;
import java.util.List;


public class FrgSearch extends BaseFrg {

    public ImageButton mImageButton_back;
    public ImageButton mImageButton_sx;
    public AbPullListView mAbPullListView;
    public EditText mEditText;
    public Handler mHandler = new Handler();
    public Runnable mRun;
    public static String key;
    public ListView mListView;
    public List<String> data_history;

    @Override
    protected void create(Bundle savedInstanceState) {
        key = getActivity().getIntent().getStringExtra("key");
        data_history = new Gson().fromJson(F.getJson("history"), new TypeToken<List<String>>() {
        }.getType());
        if (data_history == null)
            data_history = new ArrayList<>();
        setContentView(R.layout.frg_search);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mEditText.setText(obj.toString());
                key = mEditText.getText().toString();
                mListView.setVisibility(View.GONE);
                saveHistory();
                mAbPullListView.setJsonApiLoadParams("", new BeanMhSearch(mEditText.getText().toString()));
                break;
        }
    }

    private void saveHistory() {
        mEditText.setSelection(mEditText.getText().length());
        if (!data_history.contains(key)&&!TextUtils.isEmpty(mEditText.getText().toString())) {
            data_history.add(key);
            F.saveJson("history", new Gson().toJson(data_history));
            Frame.HANDLES.sentAll("FrgSearchFirst", 0, null);
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mImageButton_back = (ImageButton) findViewById(R.id.mImageButton_back);
        mImageButton_sx = (ImageButton) findViewById(R.id.mImageButton_sx);
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);
        mEditText = (EditText) findViewById(R.id.mEditText);
        mListView = (ListView) findViewById(R.id.mListView);
        mRun = new Runnable() {
            @Override
            public void run() {
                loadJsonUrlNoshow("20003", new Gson().toJson(new BeanMhSearch(mEditText.getText().toString())));
            }
        };
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_GO) {
                    key = mEditText.getText().toString();
                    saveHistory();
                    mAbPullListView.setJsonApiLoadParams("", new BeanMhSearch(mEditText.getText().toString()));
                    return true;
                }
                return false;
            }
        });
    }

    public void loaddata() {
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(mEditText.getText().toString()))
                    mHandler.postDelayed(mRun, 500);
            }
        });
        mImageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrgSearch.this.finish();
            }
        });
        mEditText.setText(key);
        saveHistory();
        mAbPullListView.setJsonApiLoadParams("", new BeanMhSearch(mEditText.getText().toString()));
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelMhSearch mModelTj = (ModelMhSearch) F.json2Model(content, ModelMhSearch.class);
                return new AdaPub(getContext(), mModelTj.data.columns, "FrgSearch");
            }
        });

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20003")) {
            ModelMhSearch mModelMhSearch = (ModelMhSearch) F.json2Model(content, ModelMhSearch.class);
            if (mModelMhSearch.data.search != null && mModelMhSearch.data.search.size() > 0) {
                mListView.setVisibility(View.VISIBLE);
                mListView.setAdapter(new AdaSearchPopSon(getContext(), mModelMhSearch.data.search));
            } else {
                mListView.setVisibility(View.GONE);
            }
        }
    }
}