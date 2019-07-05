//
//  Cart
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ab.http.HttpUtil;
import com.ab.util.HttpResponseListener;
import com.ab.util.HttpResponseListenerSon;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.config.BaseConfig;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.mdx.framework.widget.SwipMoreView;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.ada.AdaCart;
import com.ndtlg.dbbx.bean.BeanDb;
import com.ndtlg.dbbx.model.ModelTj;


public class Cart extends SwipMoreView implements CompoundButton.OnCheckedChangeListener, HttpResponseListenerSon, View.OnClickListener {
    public TextView mTextView_typename;
    public LinearLayout mLinearLayout_delete;
    public Button mButton_delete;
    public LinearLayout mLinearLayout_content;
    public CheckBox mCheckBox;
    public MImageView mMImageView;
    public TextView mTextView_title;
    public TextView mTextView_xh;
    public TextView mTextView_age;
    public TextView mTextView_qx;
    public TextView mTextView_price;
    public ModelTj.DataBean.ColumnsBean item;
    public AdaCart mAdaCart;


    public Cart(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_cart, this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView_typename = (TextView) findViewById(R.id.mTextView_typename);
        mLinearLayout_delete = (LinearLayout) findViewById(R.id.mLinearLayout_delete);
        mButton_delete = (Button) findViewById(R.id.mButton_delete);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);
        mCheckBox = (CheckBox) findViewById(R.id.mCheckBox);
        mMImageView = (MImageView) findViewById(R.id.mMImageView);
        mTextView_title = (TextView) findViewById(R.id.mTextView_title);
        mTextView_xh = (TextView) findViewById(R.id.mTextView_xh);
        mTextView_age = (TextView) findViewById(R.id.mTextView_age);
        mTextView_qx = (TextView) findViewById(R.id.mTextView_qx);
        mTextView_price = (TextView) findViewById(R.id.mTextView_price);

        mButton_delete.setOnClickListener(com.mdx.framework.utility.Helper.delayClickLitener(this));

    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(String category_name2) {
        for (int i = 0; i < mAdaCart.getCount(); i++) {
            if (category_name2.equals(mAdaCart.get(i).category_name1)) {
                return i;
            }
        }
        return -1;
    }

    public void set(ModelTj.DataBean.ColumnsBean item, AdaCart mAdaCart, int position) {
        this.item = item;
        this.mAdaCart = mAdaCart;
        mMImageView.setObj("http://insurance.inrnui.com" + item.path);
        if (position == getPositionForSection(item.category_name1)) {
            mTextView_typename.setVisibility(View.VISIBLE);
        } else {
            mTextView_typename.setVisibility(View.GONE);
        }
        mTextView_typename.setText(item.category_name1);
        mTextView_title.setText(item.title);
        mTextView_xh.setText(item.category_name2);
        mTextView_age.setText("简介："+item.desc);
//        mTextView_qx.setText();
        mTextView_price.setText(item.price);

        mCheckBox.setOnCheckedChangeListener(null);
        mCheckBox.setChecked(item.isChecked);
        mCheckBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(android.view.View v) {
        if (R.id.mButton_delete == v.getId()) {
            BeanDb mBeanDb = new BeanDb();
            mBeanDb.id = Integer.valueOf(item.id);
            mBeanDb.status = 0;
            HttpUtil.loadJsonUrl(getContext(), BaseConfig.getUri(), new Gson().toJson(mBeanDb), new HttpResponseListener(getContext(), this, "20011", true));
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onFailure(int statusCode, String content, Throwable error) {

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("20011")) {
            Helper.toast("删除成功！", getContext());
            mAdaCart.remove(item);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        item.isChecked = isChecked;
        mAdaCart.notifyDataSetChanged();
        Frame.HANDLES.sentAll("FrgCart", 0, null);
    }

    @Override
    public boolean swipLeftAble() {
        return true;
    }

    @Override
    public boolean swipRightAble() {
        return false;
    }

    @Override
    public View swipView() {
        return mLinearLayout_content;
    }

    @Override
    public View moreView() {
        return mLinearLayout_delete;
    }
}