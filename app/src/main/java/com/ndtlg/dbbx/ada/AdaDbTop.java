//
//  AdaDbTop
//
//  Created by DELL on 2018-12-28 15:55:57
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.ndtlg.dbbx.item.DbTop;

public class AdaDbTop extends MAdapter<String>{

   public AdaDbTop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DbTop.getView(getContext(), parent);;
        }
        DbTop mDbTop=(DbTop) convertView.getTag();
        mDbTop.set(item);
        return convertView;
    }
}
