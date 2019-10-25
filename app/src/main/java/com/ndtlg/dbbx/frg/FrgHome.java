//
//  FrgHome
//
//  Created by DELL on 2018-12-24 13:13:13
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.framewidget.newMenu.SlidingFragment;
import com.ndtlg.dbbx.R;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;


public class FrgHome extends BaseFrg {
    //    http://api.inrnui.com/index.php/16
    public LinearLayout mLinearLayout_content;
    public SlidingFragment mSlidingFragment;
    public android.support.v4.app.FragmentManager fragmentManager;
    public int position;

    @Override
    protected void create(Bundle savedInstanceState) {

        position = getActivity().getIntent().getIntExtra("position", 0);
        setContentView(R.layout.frg_home);
        initView();
        loaddata();
        PgyUpdateManager.register(getActivity(),
                new UpdateManagerListener() {
                    @Override
                    public void onUpdateAvailable(final String result) {
                        try { // 将新版本信息封装到AppBean中
                            final AppBean appBean = getAppBeanFromString(result);
                            new AlertDialog.Builder(getContext())
                                    .setTitle("版本更新")
                                    .setMessage("检查到新版本，是否更新").setCancelable(false)
                                    .setNegativeButton(
                                            "确定",
                                            new DialogInterface.OnClickListener() {

                                                @Override
                                                public void onClick(
                                                        DialogInterface dialog,
                                                        int which) {
                                                    startDownloadTask(
                                                            getActivity(),
                                                            appBean.getDownloadURL());
                                                }
                                            }).show();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onNoUpdateAvailable() {
                    }
                });
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
        mSlidingFragment.setFistShow(position);
    }


}