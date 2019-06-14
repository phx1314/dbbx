//
//  AdaRadiobutton1
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

import com.ndtlg.dbbx.item.Radiobutton1;

public class AdaRadiobutton1 extends MAdapter<String>{

   public AdaRadiobutton1(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = Radiobutton1.getView(getContext(), parent);;
        }
        Radiobutton1 mRadiobutton1=(Radiobutton1) convertView.getTag();
        mRadiobutton1.set(item);
        return convertView;
    }
}
