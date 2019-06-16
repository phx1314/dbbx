//
//  FrgHome
//
//  Created by DELL on 2018-12-24 13:13:13
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.framewidget.newMenu.SlidingFragment;
import com.ndtlg.dbbx.R;


public class FrgHome extends BaseFrg {
//    http://api.inrnui.com/index.php/16
    public LinearLayout mLinearLayout_content;
    public SlidingFragment mSlidingFragment;
    public android.support.v4.app.FragmentManager fragmentManager;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_home);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                mSlidingFragment.goWhere(2);
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);


    }

    public void loaddata() {
        mSlidingFragment = new SlidingFragment(this);
        fragmentManager = getActivity().getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(R.id.mLinearLayout_content, mSlidingFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        mSlidingFragment.addContentView(new FrgMain(), "首页",
                R.drawable.btn_checked_1);
        mSlidingFragment.addContentView(new FrgTj(), "产品",
                R.drawable.btn_checked_2);
        mSlidingFragment.addContentView(new FrgCart(), "对比",
                R.drawable.btn_checked_3);
        mSlidingFragment.addContentView(new FrgWd(), "我的",
                R.drawable.btn_checked_4);
        mSlidingFragment.setOffscreenPageLimit(4);
    }


}