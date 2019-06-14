//
//  AdaDbTopSon
//
//  Created by DELL on 2018-12-28 15:28:19
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dbbx.item.DbTopSon;

import java.util.List;

public class AdaDbTopSon extends MAdapter<String>{

   public AdaDbTopSon(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DbTopSon.getView(getContext(), parent);;
        }
        DbTopSon mDbTopSon=(DbTopSon) convertView.getTag();
//        mDbTopSon.set(item);
        return convertView;
    }
}
