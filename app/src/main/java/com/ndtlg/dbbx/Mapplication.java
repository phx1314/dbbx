package com.ndtlg.dbbx;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.mdx.framework.Frame;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by bob on 2015/1/30.
 */
public class Mapplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Frame.init(getApplicationContext());
        F.init();
    }

    {
//        com.framewidget.F.ICON_SHARE = R.drawable.icon_ek;
//        com.framewidget.F.WEIXINKEY = Constants.APP_ID;

        com.framewidget.F.APPNAME = "";
        com.framewidget.F.WEIXINID = "wxeaebe823f7d4f9d1";
        com.framewidget.F.WEIXINSEC = "df361218354c5024517f0088e8ef0c6e";
        com.framewidget.F.QQID = "1107999603";
        com.framewidget.F.QQSEC = "6LgAL1MyH1fkNSJz";
//        com.framewidget.F.SINAID = "2667591999";
//        com.framewidget.F.SiNASEC = "c796fc5dea7664b79878b9c50f7a25b3";
        com.framewidget.F.SINAID = "2437806690";
        com.framewidget.F.SiNASEC = "f3d00bfb3d2bf7a6e7145fc61e52b6d5";
        // 微信 wx12342956d1cab4f9,a5ae111de7d9ea137e88a5e02c07c94d
        PlatformConfig.setWeixin(com.framewidget.F.WEIXINID,
                com.framewidget.F.WEIXINSEC);
        // 新浪微博
        PlatformConfig.setSinaWeibo(com.framewidget.F.SINAID,
                com.framewidget.F.SiNASEC);
        PlatformConfig.setQQZone(com.framewidget.F.QQID,
                com.framewidget.F.QQSEC);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
