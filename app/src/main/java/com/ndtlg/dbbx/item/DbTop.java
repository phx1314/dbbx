//
//  DbTop
//
//  Created by DELL on 2018-12-28 15:55:57
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.item;

import com.ndtlg.dbbx.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.view.View;
import android.widget.ToggleButton;
import com.ndtlg.dbbx.view.AnimateScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class DbTop extends BaseItem{
    public ToggleButton mToggleButton;
    public AnimateScrollView scrollView;
    public LinearLayout mLinearLayout_content;
    public TextView mTextView_title;
    public TextView mTextView_content;
    public TextView mTextView_price;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_db_top,null);
	     convertView.setTag( new DbTop(convertView));
	     return convertView;
	}

	public DbTop(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mToggleButton=(ToggleButton)contentview.findViewById(R.id.mToggleButton);
        scrollView=(AnimateScrollView)contentview.findViewById(R.id.scrollView);
        mLinearLayout_content=(LinearLayout)contentview.findViewById(R.id.mLinearLayout_content);
        mTextView_title=(TextView)contentview.findViewById(R.id.mTextView_title);
        mTextView_content=(TextView)contentview.findViewById(R.id.mTextView_content);
        mTextView_price=(TextView)contentview.findViewById(R.id.mTextView_price);


    }

    public void set(String item){

    }
    
    

}