//
//  AdaSearchPopSon
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dbbx.item.SearchPopSon;

import java.util.List;

public class AdaSearchPopSon extends MAdapter<String>{

   public AdaSearchPopSon(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final String item = get(position);
        if (convertView == null) {
            convertView = SearchPopSon.getView(getContext(), parent);;
        }
        SearchPopSon mSearchPopSon=(SearchPopSon) convertView.getTag();
        mSearchPopSon.set(item);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frame.HANDLES.sentAll("FrgSearch",0,item);
            }
        });
        return convertView;
    }
}
