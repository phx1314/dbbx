//
//  CardDb
//
//  Created by DELL on 2018-12-28 15:55:57
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.card;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.mdx.framework.widget.pagerecycleview.ada.Card;
import com.ndtlg.dbbx.item.DbCard;
import com.ndtlg.dbbx.model.ModelData;

public class CardDb extends Card<String> {
    public String item;
    public Object mFreeRecyclerView;
    public ModelData mModelData;

    public CardDb(Context context, Object mFreeRecyclerView, ModelData mModelData) {
        this.type = context.getResources().getIdentifier("id_db", "string", context.getPackageName());
        this.mFreeRecyclerView = mFreeRecyclerView;
        this.mModelData = mModelData;
    }


    @Override
    public void bind(RecyclerView.ViewHolder viewHolder, int posion) {
        DbCard item = (DbCard) viewHolder;
        item.set(mFreeRecyclerView, mModelData);
    }


}


