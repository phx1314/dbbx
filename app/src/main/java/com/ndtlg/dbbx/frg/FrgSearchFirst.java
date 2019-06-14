//
//  FrgSearchFirst
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaSearchFirst;
import com.ndtlg.dbbx.bean.BeanSearch;
import com.ndtlg.dbbx.item.SearchFirstTop;
import com.ndtlg.dbbx.model.ModelSearch;

import java.util.ArrayList;
import java.util.List;


public class FrgSearchFirst extends BaseFrg {

    public TextView mTextView_cancel;
    public ListView mListView;
    public EditText mEditText;
    public View view_top;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_search_first);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                List<String> data_history = new Gson().fromJson(F.getJson("history"), new TypeToken<List<String>>() {
                }.getType());
                if (data_history == null)
                    data_history = new ArrayList<>();
                mListView.setAdapter(new AdaSearchFirst(getContext(), data_history));
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView_cancel = (TextView) findViewById(R.id.mTextView_cancel);
        mListView = (ListView) findViewById(R.id.mListView);
        mEditText = (EditText) findViewById(R.id.mEditText);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_GO) {
                    Helper.startActivity(getContext(), FrgSearch.class, NoTitleAct.class, "key", mEditText.getText().toString());
                    return true;
                }
                return false;
            }
        });
        view_top = SearchFirstTop.getView(getContext(), null);
        mListView.addHeaderView(view_top);
        mTextView_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrgSearchFirst.this.finish();
            }
        });
    }

    public void loaddata() {
        BeanSearch mBeanSearch = new BeanSearch();
        loadJsonUrl("60001", new Gson().toJson(mBeanSearch));
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("60001")) {
            ModelSearch mModelSearch = (ModelSearch) F.json2Model(content, ModelSearch.class);
            ((SearchFirstTop) view_top.getTag()).set(mModelSearch);
//            mListView.setAdapter(new AdaSearchFirst(getContext(), mModelSearch.data.history));
            List<String> data_history = new Gson().fromJson(F.getJson("history"), new TypeToken<List<String>>() {
            }.getType());
            if (data_history == null)
                data_history = new ArrayList<>();
            mListView.setAdapter(new AdaSearchFirst(getContext(), data_history));
        }
    }

}