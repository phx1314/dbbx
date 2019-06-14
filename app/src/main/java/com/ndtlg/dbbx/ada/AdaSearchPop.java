//
//  AdaSearchPop
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.ndtlg.dbbx.item.SearchPop;

public class AdaSearchPop extends MAdapter<String>{

   public AdaSearchPop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = SearchPop.getView(getContext(), parent);;
        }
        SearchPop mSearchPop=(SearchPop) convertView.getTag();
        mSearchPop.set(item);
        return convertView;
    }
}
