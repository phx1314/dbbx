//
//  BaseItem
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.ab.util.HttpResponseListenerSon;

public class BaseItem implements OnClickListener , HttpResponseListenerSon {
	protected Context context;
	protected View contentview;

	@Override
	public void onClick(View v) {

	}

	public View findViewById(int id) {
         return this.contentview.findViewById(id);
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

	}
}

