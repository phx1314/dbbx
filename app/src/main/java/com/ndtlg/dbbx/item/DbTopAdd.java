//
//  DbTopAdd
//
//  Created by DELL on 2018-12-28 15:28:19
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
import android.widget.ImageView;



public class DbTopAdd extends BaseItem{
    public ImageView mImageView_add;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_db_top_add,null);
	     convertView.setTag( new DbTopAdd(convertView));
	     return convertView;
	}

	public DbTopAdd(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mImageView_add=(ImageView)contentview.findViewById(R.id.mImageView_add);


    }

    public void set(String item){

    }
    
    

}