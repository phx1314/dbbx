//
//  AdaPub
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.Frame;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dbbx.frg.FrgPdetail;
import com.ndtlg.dbbx.item.Pub;
import com.ndtlg.dbbx.model.ModelTj;

import java.util.List;

public class AdaPub extends MAdapter<ModelTj.DataBean.ColumnsBean> {
    public String from;

    public AdaPub(Context context, List<ModelTj.DataBean.ColumnsBean> list) {
        super(context, list);
    }

    public AdaPub(Context context, List<ModelTj.DataBean.ColumnsBean> list, String from) {
        super(context, list);
        this.from = from;
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final ModelTj.DataBean.ColumnsBean item = get(position);
        if (convertView == null) {
            convertView = Pub.getView(getContext(), parent);
        }
        Pub mPub = (Pub) convertView.getTag();
        mPub.set(this, item, from);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(from) && from.equals("FrgSelect")) {
                    Frame.HANDLES.sentAll("FrgSelect", 0, item.contrast_id);
                } else {
                    Helper.startActivity(getContext(), FrgPdetail.class, TitleAct.class, "id", item.id);
                }
            }
        });
        return convertView;
    }
}
