//
//  AdaDbSon
//
//  Created by DELL on 2018-12-28 15:28:19
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.ndtlg.dbbx.item.DbSon;

public class AdaDbSon extends MAdapter<String>{

   public AdaDbSon(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DbSon.getView(getContext(), parent);;
        }
        DbSon mDbSon=(DbSon) convertView.getTag();
        mDbSon.set(item);
        return convertView;
    }
}
