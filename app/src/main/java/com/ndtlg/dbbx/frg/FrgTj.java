//
//  FrgTj
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaPub;
import com.ndtlg.dbbx.bean.BeanTj;
import com.ndtlg.dbbx.item.Radiobutton1;
import com.ndtlg.dbbx.item.Radiobutton2;
import com.ndtlg.dbbx.model.ModelTj;


public class FrgTj extends BaseFrg {

    public ImageButton mImageButton_sx;
    public RadioGroup mRadioGroup;
    public RadioGroup mRadioGroup2;
    public AbPullListView mListView;
    public ModelTj mModelTj;
    public EditText mEditText;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_tj);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mModelTj = (ModelTj) obj;
                for (int i = 0; i < mModelTj.data.category.size(); i++) {
                    RadioButton mRadioButton = (RadioButton) Radiobutton1.getView(getContext(), null);
                    mRadioButton.setText(mModelTj.data.category.get(i).title);
                    mRadioButton.setId(i);
                    RadioGroup.LayoutParams mLayoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.MATCH_PARENT);
                    mLayoutParams.setMargins((int) getResources().getDimension(R.dimen.j25dp), 0, 0, 0);
                    mRadioButton.setLayoutParams(mLayoutParams);
                    mRadioGroup.addView(mRadioButton);
                }
                mRadioGroup.check(0);
                break;
            case 1:
                mListView.pullLoad();
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mImageButton_sx = (ImageButton) findViewById(R.id.mImageButton_sx);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mRadioGroup2 = (RadioGroup) findViewById(R.id.mRadioGroup2);
        mListView = (AbPullListView) findViewById(R.id.mListView);
        mEditText = (EditText) findViewById(R.id.mEditText);
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgSearchFirst.class, NoTitleAct.class);
            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mRadioGroup2.removeAllViews();
                for (int i = 0; i < mModelTj.data.category.get(checkedId).child.size(); i++) {
                    RadioButton mRadioButton = (RadioButton) Radiobutton2.getView(getContext(), null);
                    mRadioButton.setText(mModelTj.data.category.get(checkedId).child.get(i).title);
                    mRadioButton.setId(i);
                    RadioGroup.LayoutParams mLayoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    mLayoutParams.setMargins((int) getResources().getDimension(R.dimen.j10dp), 0, 0, 0);
                    mRadioButton.setLayoutParams(mLayoutParams);
                    mRadioGroup2.addView(mRadioButton);
                }
                mRadioGroup2.check(0);
            }
        });
        mRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                BeanTj mBeanTj = new BeanTj();
                mBeanTj.cid1 = Integer.valueOf(mModelTj.data.category.get(mRadioGroup.getCheckedRadioButtonId()).id);
                mBeanTj.cid2 = Integer.valueOf(mModelTj.data.category.get(mRadioGroup.getCheckedRadioButtonId()).child.get(mRadioGroup2.getCheckedRadioButtonId()).id);
                mListView.setJsonApiLoadParams("", mBeanTj);
            }
        });
    }

    public void loaddata() {
        mListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                ModelTj mModelTj = (ModelTj) F.json2Model(content, ModelTj.class);
                return new AdaPub(getContext(), mModelTj.data.columns);
            }
        });
    }


}