//
//  AdaPdetailTop
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
import com.ndtlg.dbbx.item.PdetailTop;
import com.ndtlg.dbbx.model.ModelPdetail;

import java.util.List;

public class AdaPdetailTop extends MAdapter<ModelPdetail.DataBean.FieldsBean>{

   public AdaPdetailTop(Context context, List<ModelPdetail.DataBean.FieldsBean> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelPdetail.DataBean.FieldsBean item = get(position);
        if (convertView == null) {
            convertView = PdetailTop.getView(getContext(), parent);;
        }
        PdetailTop mPdetailTop=(PdetailTop) convertView.getTag();
        mPdetailTop.set(item);
        return convertView;
    }
}
