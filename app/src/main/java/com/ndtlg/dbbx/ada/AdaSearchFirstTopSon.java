//
//  AdaSearchFirstTopSon
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
import com.ndtlg.dbbx.item.SearchFirstTopSon;

import java.util.List;

public class AdaSearchFirstTopSon extends MAdapter<String>{

   public AdaSearchFirstTopSon(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = SearchFirstTopSon.getView(getContext(), parent);;
        }
        SearchFirstTopSon mSearchFirstTopSon=(SearchFirstTopSon) convertView.getTag();
//        mSearchFirstTopSon.set(item);
        return convertView;
    }
}
