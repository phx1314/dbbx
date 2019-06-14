//
//  PdetailBottom
//
//  Created by DELL on 2018-12-28 13:52:33
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
import android.widget.LinearLayout;
import android.widget.TextView;



public class PdetailBottom extends BaseItem{
    public LinearLayout mLinearLayout;
    public TextView mTextView_left;
    public TextView mTextView_content;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_pdetail_bottom,null);
	     convertView.setTag( new PdetailBottom(convertView));
	     return convertView;
	}

	public PdetailBottom(View view){
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
        mTextView_content=(TextView)contentview.findViewById(R.id.mTextView_content);


    }

    public void set(String item){

    }
    
    

}