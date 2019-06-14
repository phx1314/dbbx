//
//  SearchPopSon
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
import android.widget.TextView;

import com.ndtlg.dbbx.R;



public class SearchPopSon extends BaseItem{
    public TextView mTextView;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_search_pop_son,null);
	     convertView.setTag( new SearchPopSon(convertView));
	     return convertView;
	}

	public SearchPopSon(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mTextView=(TextView)contentview.findViewById(R.id.mTextView);


    }

    public void set(String item){
		mTextView.setText(item);
    }
    
    

}