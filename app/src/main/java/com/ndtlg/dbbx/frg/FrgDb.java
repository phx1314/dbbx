//
//  FrgDb
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.framewidget.view.CallBackOnly;
import com.google.gson.Gson;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;
import com.mdx.framework.widget.pagerecycleview.ada.Card;
import com.mdx.framework.widget.pagerecycleview.ada.CardAdapter;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.bean.BeanDbDetail;
import com.ndtlg.dbbx.card.CardDb;
import com.ndtlg.dbbx.card.CardDbTop;
import com.ndtlg.dbbx.item.DialogTb;
import com.ndtlg.dbbx.model.ModelData;
import com.ndtlg.dbbx.model.ModelDbDetail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FrgDb extends BaseFrg {


    public com.ndtlg.dbbx.view.FreeRecyclerView mFreeRecyclerView;
    public String ids;
    public List<ModelData> mModelDatas = new ArrayList<>();
    public CardDbTop mCardDbTop;
    public int cid1;
    public int cid2;
    public CardAdapter mCardAdapter;
    public TextView mTextView_tb;

    @Override
    protected void create(Bundle savedInstanceState) {
        ids = getActivity().getIntent().getStringExtra("ids");
        cid1 = getActivity().getIntent().getIntExtra("cid1", 0);
        cid2 = getActivity().getIntent().getIntExtra("cid2", 0);
        setContentView(R.layout.frg_db);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                refreashData((Boolean) obj);
                break;
            case 1:
                String ids_new = "";
                for (String id : ids.split(",")) {
                    if (id.equals(obj.toString())) {
                        continue;
                    }
                    ids_new += id + ",";
                }
                if (TextUtils.isEmpty(ids_new)) {
                    Helper.toast("对比列表不能为空", getContext());
                    return;
                }
                ids = TextUtils.isEmpty(ids_new) ? "" : ids_new.substring(0, ids_new.length() - 1);
                loadJsonUrl("30013", new Gson().toJson(new BeanDbDetail(ids)));
                break;
            case 2:
                if (!Arrays.asList(ids.split(",")).contains(obj)) {
                    ids = ids + "," + obj;
                    loadJsonUrl("30013", new Gson().toJson(new BeanDbDetail(ids)));
                }
                break;
            case 3:
                Helper.startActivity(getContext(), FrgSelect.class, TitleAct.class, "cid1", cid1, "cid2", cid2);
                break;
            case 4:
                finish();
                break;
        }
    }

    public void refreashData(boolean isChecked) {
        List<Card> list = new ArrayList<>();
        list.add(mCardDbTop);
        for (ModelData mModelData : mModelDatas) {
            if (isChecked && mModelData.isAllSame) {
                continue;
            }
            CardDb mCardDb = new CardDb(getContext(), mFreeRecyclerView, mModelData);
            list.add(mCardDb);
        }
        mCardAdapter.clear();
        mCardAdapter.AddAll(list);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCardAdapter.notifyDataSetChanged();
            }
        }, 500);
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {

        mFreeRecyclerView = (com.ndtlg.dbbx.view.FreeRecyclerView) findViewById(R.id.mFreeRecyclerView);
        mTextView_tb = (TextView) findViewById(R.id.mTextView_tb);
        mTextView_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view1 = DialogTb.getView(getContext(), null);
                com.framewidget.F.showCenterDialog(getContext(), view1, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DialogTb) view1.getTag()).set(mDialog);
                    }
                });
            }
        });
    }

    public void loaddata() {
        mFreeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loadJsonUrl("30013", new Gson().toJson(new BeanDbDetail(ids)));


    }


    @Override
    public void onSuccess(String methodName, String content) {
        ModelDbDetail mModelDbDetail = (ModelDbDetail) F.json2Model(content, ModelDbDetail.class);
        List<Card> list = new ArrayList<>();
        mCardDbTop = new CardDbTop(getContext(), mFreeRecyclerView, mModelDbDetail);
        list.add(mCardDbTop);
        mModelDatas.clear();
        for (int i = 0; i < mModelDbDetail.data.columns.size(); i++) {
            for (int j = 0; j < mModelDbDetail.data.columns.get(i).fields.size(); j++) {
                if (i == 0) {
                    ModelData mModelData = new ModelData(mModelDbDetail.data.columns.get(i).fields.get(j).name);
                    mModelData.values.add(mModelDbDetail.data.columns.get(i).fields.get(j).value);
                    mModelDatas.add(mModelData);
                } else {
                    if (!mModelDatas.get(j).values.contains(mModelDbDetail.data.columns.get(i).fields.get(j).value)) {
                        mModelDatas.get(j).isAllSame = false;
                    }
                    mModelDatas.get(j).values.add(mModelDbDetail.data.columns.get(i).fields.get(j).value);
                }
            }
        }
        for (ModelData mModelData : mModelDatas) {
            CardDb mCardDb = new CardDb(getContext(), mFreeRecyclerView, mModelData);
            list.add(mCardDb);
        }
        mCardAdapter = new CardAdapter(getContext(), list);
        mFreeRecyclerView.setAdapter(mCardAdapter);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mCardAdapter.notifyDataSetChanged();
            }
        }, 500);
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setTitle("对比");
    }
}