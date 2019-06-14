package com.ndtlg.dbbx.bean;

import android.text.TextUtils;

import com.framewidget.model.BeanListBase;

/**
 * Created by DELL on 2017/6/19.
 */

public class BeanZjList extends BeanListBase {
    public int uid  = TextUtils.isEmpty(com.ndtlg.dbbx.F.uid)?0:Integer.valueOf(com.ndtlg.dbbx.F.uid) ;
    public int action = 30010;
}
