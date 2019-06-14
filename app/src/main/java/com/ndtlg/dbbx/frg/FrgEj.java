//
//  FrgEj
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.widget.ActionBar;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaPub;
import com.ndtlg.dbbx.bean.BeanTj;
import com.ndtlg.dbbx.item.Radiobutton2;
import com.ndtlg.dbbx.model.ModelTj;


public class FrgEj extends BaseFrg {

    public RadioGroup mRadioGroup;
    public AbPullListView mListView;
    public ModelTj.DataBean.CategoryBean mCategoryBean;

    @Override
    protected void create(Bundle savedInstanceState) {
        mCategoryBean = (ModelTj.DataBean.CategoryBean) getActivity().getIntent().getSerializableExtra("mCategoryBean");
        setContentView(R.layout.frg_ej);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mListView = (AbPullListView) findViewById(R.id.mListView);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                BeanTj mBeanTj = new BeanTj();
                mBeanTj.cid1 = Integer.valueOf(mCategoryBean.id);
                mBeanTj.cid2 = Integer.valueOf(mCategoryBean.child.get(checkedId).id);
                mListView.setJsonApiLoadParams("", mBeanTj);
            }
        });

    }

    public void loaddata() {
        for (int i = 0; i < mCategoryBean.child.size(); i++) {
            RadioButton mRadioButton = (RadioButton) Radiobutton2.getView(getContext(), null);
            mRadioButton.setText(mCategoryBean.child.get(i).title);
            mRadioButton.setId(i);
            RadioGroup.LayoutParams mLayoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            mLayoutParams.setMargins((int) getResources().getDimension(R.dimen.j10dp), 0, 0, 0);
            mRadioButton.setLayoutParams(mLayoutParams);
            mRadioGroup.addView(mRadioButton);
        }
        mRadioGroup.check(0);

        mListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelTj mModelTj = (ModelTj) F.json2Model(content, ModelTj.class);
                return new AdaPub(getContext(), mModelTj.data.columns);
            }
        });
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle(mCategoryBean.title);
    }
}