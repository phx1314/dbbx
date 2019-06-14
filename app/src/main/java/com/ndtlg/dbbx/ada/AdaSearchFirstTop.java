//
//  AdaSearchFirstTop
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dbbx.item.SearchFirstTop;

import java.util.List;

public class AdaSearchFirstTop extends MAdapter<String>{

   public AdaSearchFirstTop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = SearchFirstTop.getView(getContext(), parent);;
        }
        SearchFirstTop mSearchFirstTop=(SearchFirstTop) convertView.getTag();
//        mSearchFirstTop.set(item);
        return convertView;
    }
}
