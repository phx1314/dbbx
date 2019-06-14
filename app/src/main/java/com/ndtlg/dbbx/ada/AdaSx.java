//
//  AdaSx
//
//  Created by DELL on 2018-12-28 13:52:32
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dbbx.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.ndtlg.dbbx.item.Sx;

public class AdaSx extends MAdapter<String>{

   public AdaSx(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = Sx.getView(getContext(), parent);;
        }
        Sx mSx=(Sx) convertView.getTag();
        mSx.set(item);
        return convertView;
    }
}
