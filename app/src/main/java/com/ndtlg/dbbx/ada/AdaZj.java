//
//  AdaZj
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dbbx.item.Zj;
import com.ndtlg.dbbx.model.ModelTj;

import java.util.List;

public class AdaZj extends MAdapter<ModelTj.DataBean.ColumnsBean> {

    public AdaZj(Context context, List<ModelTj.DataBean.ColumnsBean> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelTj.DataBean.ColumnsBean item = get(position);
        if (convertView == null) {
            convertView = Zj.getView(getContext(), parent);
        }
        Zj mZj = (Zj) convertView.getTag();
        mZj.set(this, item, position);
        return convertView;
    }
}
