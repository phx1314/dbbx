//
//  PdetailTop
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.model.ModelPdetail;



public class PdetailTop extends BaseItem{
    public LinearLayout mLinearLayout;
    public TextView mTextView_left;
    public EditText mEditText;
    public TextView mTextView_content;


    @SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_pdetail_top,null);
	     convertView.setTag( new PdetailTop(convertView));
	     return convertView;
	}

	public PdetailTop(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mLinearLayout=(LinearLayout)contentview.findViewById(R.id.mLinearLayout);
        mTextView_left=(TextView)contentview.findViewById(R.id.mTextView_left);
        mEditText=(EditText)contentview.findViewById(R.id.mEditText);
        mTextView_content = (TextView) findViewById(R.id.mTextView_content);


    }

    public void set(ModelPdetail.DataBean.FieldsBean item){
        mTextView_left.setText(item.title);
        mTextView_content.setText(item.value);
    }
    
    

}