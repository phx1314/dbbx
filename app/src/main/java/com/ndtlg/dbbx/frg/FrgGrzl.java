//
//  FrgGrzl
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.frg;
import android.os.Bundle;

import com.ndtlg.dbbx.R;

import com.mdx.framework.widget.MImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class FrgGrzl extends BaseFrg{

    public MImageView mMImageView_tou;
    public LinearLayout mLinearLayout_nicheng;
    public TextView mTextView_name;


 	@Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_grzl);
        initView();
        loaddata();
    }

    private void initView(){
        findVMethod();
    }
    
    private void findVMethod() {
        mMImageView_tou=(MImageView)findViewById(R.id.mMImageView_tou);
        mLinearLayout_nicheng=(LinearLayout)findViewById(R.id.mLinearLayout_nicheng);
        mTextView_name=(TextView)findViewById(R.id.mTextView_name);


    }
    
    public void loaddata(){

    }
    
   
 
}