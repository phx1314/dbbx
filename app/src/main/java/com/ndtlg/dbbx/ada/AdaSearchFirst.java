//
//  AdaSearchFirst
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.frg.FrgSearch;
import com.ndtlg.dbbx.item.SearchFirst;

import java.util.List;

public class AdaSearchFirst extends MAdapter<String> {

    public AdaSearchFirst(Context context, List<String> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final String item = get(position);
        if (convertView == null) {
            convertView = SearchFirst.getView(getContext(), parent);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgSearch.class, NoTitleAct.class, "key", item);
            }
        });
        SearchFirst mSearchFirst = (SearchFirst) convertView.getTag();
        mSearchFirst.set(item);
        return convertView;
    }
}
