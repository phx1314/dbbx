//
//  AdaRadiobutton2
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

import com.ndtlg.dbbx.item.Radiobutton2;

public class AdaRadiobutton2 extends MAdapter<String>{

   public AdaRadiobutton2(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = Radiobutton2.getView(getContext(), parent);;
        }
        Radiobutton2 mRadiobutton2=(Radiobutton2) convertView.getTag();
        mRadiobutton2.set(item);
        return convertView;
    }
}
