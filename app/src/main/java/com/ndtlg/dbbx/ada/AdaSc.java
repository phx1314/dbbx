//
//  AdaSc
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dbbx.item.Sc;
import com.ndtlg.dbbx.model.ModelTj;

import java.util.List;

public class AdaSc extends MAdapter<ModelTj.DataBean.ColumnsBean>{

   public AdaSc(Context context, List<ModelTj.DataBean.ColumnsBean> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelTj.DataBean.ColumnsBean item = get(position);
        if (convertView == null) {
            convertView = Sc.getView(getContext(), parent);;
        }
        Sc mSc=(Sc) convertView.getTag();
        mSc.set(this,item);
        return convertView;
    }
}
