//
//  Sx
//
//  Created by DELL on 2018-12-28 13:52:32
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
import com.framewidget.view.FixGridLayout;



public class Sx extends BaseItem{
    public FixGridLayout mFixGridLayout;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_sx,null);
	     convertView.setTag( new Sx(convertView));
	     return convertView;
	}

	public Sx(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mFixGridLayout=(FixGridLayout)contentview.findViewById(R.id.mFixGridLayout);


    }

    public void set(String item){

    }
    
    

}