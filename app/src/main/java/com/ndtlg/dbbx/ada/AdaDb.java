//
//  AdaDb
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

import com.ndtlg.dbbx.item.Db;

public class AdaDb extends MAdapter<String>{

   public AdaDb(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = Db.getView(getContext(), parent);;
        }
        Db mDb=(Db) convertView.getTag();
        mDb.set(item);
        return convertView;
    }
}
