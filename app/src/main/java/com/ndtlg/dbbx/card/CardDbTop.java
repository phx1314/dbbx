//
//  CardDbTop
//
//  Created by DELL on 2018-12-28 15:55:57
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.mdx.framework.widget.pagerecycleview.ada.Card;
import com.ndtlg.dbbx.item.DbTopCard;
import com.ndtlg.dbbx.model.ModelDbDetail;

public class CardDbTop extends Card<String> {
    public String item;
    public Object mFreeRecyclerView;
    public ModelDbDetail mModelDbDetail;

    public CardDbTop(Context context, Object mFreeRecyclerView, ModelDbDetail mModelDbDetail) {
        this.type = context.getResources().getIdentifier("id_dbtop", "string", context.getPackageName());
        this.mFreeRecyclerView = mFreeRecyclerView;
        this.mModelDbDetail = mModelDbDetail;
    }


    @Override
    public void bind(RecyclerView.ViewHolder viewHolder, int posion) {
        DbTopCard item = (DbTopCard) viewHolder;
        item.set(mFreeRecyclerView, mModelDbDetail);
    }


}


