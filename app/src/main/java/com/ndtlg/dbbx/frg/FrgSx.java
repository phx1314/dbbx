//
//  FrgSx
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.frg;
import android.os.Bundle;

import com.ndtlg.dbbx.R;

import android.widget.ListView;



public class FrgSx extends BaseFrg{

    public ListView mListView;


 	@Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_sx);
        initView();
        loaddata();
    }

    private void initView(){
        findVMethod();
    }
    
    private void findVMethod() {
        mListView=(ListView)findViewById(R.id.mListView);


    }
    
    public void loaddata(){

    }
    
   
 
}