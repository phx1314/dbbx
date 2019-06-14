//
//  Db
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
import android.widget.TextView;
import com.ndtlg.dbbx.view.AnimateScrollView;
import android.widget.LinearLayout;



public class Db extends BaseItem{
    public TextView mTextView_title;
    public AnimateScrollView scrollView;
    public LinearLayout mLinearLayout_content;
    public TextView mTextView;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_db,null);
	     convertView.setTag( new Db(convertView));
	     return convertView;
	}

	public Db(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mTextView_title=(TextView)contentview.findViewById(R.id.mTextView_title);
        scrollView=(AnimateScrollView)contentview.findViewById(R.id.scrollView);
        mLinearLayout_content=(LinearLayout)contentview.findViewById(R.id.mLinearLayout_content);
        mTextView=(TextView)contentview.findViewById(R.id.mTextView);


    }

    public void set(String item){

    }
    
    

}