//
//  FrgWd
//
//  Created by DELL on 2018-12-28 13:52:33
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dbbx.frg;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framewidget.frg.FrgPtDetail;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.activity.TitleAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dbbx.F;
import com.ndtlg.dbbx.R;
import com.ndtlg.dbbx.bean.BeanDl;
import com.ndtlg.dbbx.bean.BeanUser;
import com.ndtlg.dbbx.model.ModelUser;
import com.ndtlg.dbbx.model.Modellogin;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import static com.ndtlg.dbbx.F.saveJson;
import static com.ndtlg.dbbx.F.uid;


public class FrgWd extends BaseFrg {

    public ImageView mImageView_bg;
    public ImageButton mImageButton_share;
    public ImageButton mImageButton_set;
    public LinearLayout mLinearLayout_ydl;
    public MImageView mMImageView;
    public TextView mTextView_name;
    public TextView mTextView_type;
    public LinearLayout mLinearLayout_wdl;
    public TextView mTextView_xl;
    public TextView mTextView_wx;
    public TextView mTextView_qq;
    public TextView mTextView_zj;
    public TextView mTextView_sc;
    public TextView mTextView_1;
    public TextView mTextView_2;
    public TextView mTextView_3;
    public TextView mTextView_4;
    public LinearLayout mLinearLayout_zj;
    public LinearLayout mLinearLayout_sc;
    public ModelUser mModelUser;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_wd);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                loaddata();
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mImageView_bg = (ImageView) findViewById(R.id.mImageView_bg);
        mImageButton_share = (ImageButton) findViewById(R.id.mImageButton_share);
        mImageButton_set = (ImageButton) findViewById(R.id.mImageButton_set);
        mLinearLayout_ydl = (LinearLayout) findViewById(R.id.mLinearLayout_ydl);
        mMImageView = (MImageView) findViewById(R.id.mMImageView);
        mTextView_name = (TextView) findViewById(R.id.mTextView_name);
        mTextView_type = (TextView) findViewById(R.id.mTextView_type);
        mLinearLayout_wdl = (LinearLayout) findViewById(R.id.mLinearLayout_wdl);
        mTextView_xl = (TextView) findViewById(R.id.mTextView_xl);
        mTextView_wx = (TextView) findViewById(R.id.mTextView_wx);
        mTextView_qq = (TextView) findViewById(R.id.mTextView_qq);
        mTextView_zj = (TextView) findViewById(R.id.mTextView_zj);
        mTextView_sc = (TextView) findViewById(R.id.mTextView_sc);
        mTextView_1 = (TextView) findViewById(R.id.mTextView_1);
        mTextView_2 = (TextView) findViewById(R.id.mTextView_2);
        mTextView_3 = (TextView) findViewById(R.id.mTextView_3);
        mTextView_4 = (TextView) findViewById(R.id.mTextView_4);
        mLinearLayout_zj = (LinearLayout) findViewById(R.id.mLinearLayout_zj);
        mLinearLayout_sc = (LinearLayout) findViewById(R.id.mLinearLayout_sc);

        mLinearLayout_zj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(uid)) {
                    Helper.toast("请登录", getContext());
                    return;
                }
                Helper.startActivity(getContext(), FrgZj.class, TitleAct.class);
            }
        });
        mTextView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mModelUser != null)
                    Helper.startActivity(getContext(), FrgPtDetail.class, NoTitleAct.class, "url", mModelUser.data.url, "title", "知识保险库");
            }
        });
        mLinearLayout_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(uid)) {
                    Helper.toast("请登录", getContext());
                    return;
                }
                Helper.startActivity(getContext(), FrgSc.class, TitleAct.class);
            }
        });
        mTextView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frame.HANDLES.sentAll("FrgHome", 0, null);
            }
        });
        mImageButton_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F.shareText("分享", "http://www.baidu.com", getContext());
            }
        });
        mTextView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                F.shareText("分享", "http://www.baidu.com", getContext());
            }
        });
        mImageButton_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.startActivity(getContext(), FrgSet.class, TitleAct.class);
            }
        });
        mTextView_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI.get(getActivity()).doOauthVerify(getActivity(),
                        SHARE_MEDIA.WEIXIN, new UMAuthListener() {
                            @Override
                            public void onError(SHARE_MEDIA arg0, int arg1,
                                                Throwable arg2) {

                            }

                            @Override
                            public void onComplete(SHARE_MEDIA arg0, int arg1,
                                                   Map<String, String> data) {
                                String openId = data.get("openid");
                                String token = data.get("access_token");
                                dl(openId, token, 10000);
                            }

                            @Override
                            public void onCancel(SHARE_MEDIA arg0, int arg1) {

                            }
                        });
            }
        });
        mTextView_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithQQ();
            }
        });
        mTextView_xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithSina();
            }
        });
    }

    /**
     * 第三方登�?--qq
     */
    public void loginWithQQ() {
        UMShareAPI.get(getActivity()).doOauthVerify(getActivity(),
                SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onError(SHARE_MEDIA arg0, int arg1,
                                        Throwable arg2) {
                        Log.i("qq=", "error");
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA arg0, int arg1,
                                           Map<String, String> data) {
                        String opendid = data.get("openid");
                        String token = data.get("access_token");// outInfoe
                        dl(opendid, token, 10001);
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA arg0, int arg1) {
                        Log.i("qq=", "onCancel");
                    }
                });

    }

    /**
     * 第三方登�?--新浪微博
     */
    public void loginWithSina() {

        UMShareAPI.get(getActivity()).doOauthVerify(getActivity(),
                SHARE_MEDIA.SINA, new UMAuthListener() {
                    @Override
                    public void onError(SHARE_MEDIA arg0, int arg1,
                                        Throwable arg2) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA arg0, int arg1,
                                           Map<String, String> data) {
                        String opendid = data.get("uid");
                        String token = data.get("access_token");// outInfoe
                        dl(opendid, token, 10002);
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA arg0, int arg1) {

                    }
                });

    }

    public void loaddata() {
        if (!TextUtils.isEmpty(uid)) {
            loadJsonUrl("userinfo", new Gson().toJson(new BeanUser()));
            mLinearLayout_ydl.setVisibility(View.VISIBLE);
            mLinearLayout_wdl.setVisibility(View.GONE);
        } else {
            mLinearLayout_ydl.setVisibility(View.GONE);
            mLinearLayout_wdl.setVisibility(View.VISIBLE);
            mTextView_sc.setText("0");
            mTextView_zj.setText("0");
        }
    }

    public void dl(String opendid, String token, int action) {
        BeanDl mBeanDl = new BeanDl();
        mBeanDl.action = action;
        mBeanDl.openid = opendid;
        mBeanDl.access_token = token;
        loadJsonUrl("login", new Gson().toJson(mBeanDl));

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals("login")) {
            Modellogin mModellogin = (Modellogin) F.json2Model(content, Modellogin.class);
            uid = mModellogin.data.uid;
            saveJson("uid", mModellogin.data.uid);
            loaddata();
            Frame.HANDLES.sentAll("FrgCart", 1, null);
        } else if (methodName.equals("userinfo")) {
            mModelUser = (ModelUser) F.json2Model(content, ModelUser.class);
            mMImageView.setObj(mModelUser.data.rows.headimage);
            mMImageView.setCircle(true);
            mTextView_name.setText(mModelUser.data.rows.nickname);
            mTextView_type.setText(mModelUser.data.rows.mode);

            mTextView_sc.setText(mModelUser.data.rows.collect);
            mTextView_zj.setText(mModelUser.data.rows.browse);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode,
                data);
    }

}