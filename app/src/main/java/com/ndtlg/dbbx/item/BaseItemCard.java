//
//  BaseItem
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.mdx.framework.widget.pagerecycleview.viewhold.MViewHold;
import com.mdx.framework.widget.pagerecycleview.viewhold.ViewHodeParam;

public class BaseItemCard extends MViewHold implements OnClickListener {
    protected Context context;
    public BaseItemCard(View itemView) {
        super(itemView);
    }

    protected View contentview;

    public BaseItemCard(View itemView, ViewHodeParam viewHodeParm) {
        super(itemView, viewHodeParm);
    }


    @Override
    public void onClick(View v) {

    }

    public View findViewById(int id) {
        return this.itemView.findViewById(id);
    }
}

