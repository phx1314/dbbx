package com.ndtlg.dbbx.bean;

import android.text.TextUtils;

import com.framewidget.model.BeanListBase;

/**
 * Created by DELL on 2017/6/19.
 */

public class BeanTj extends BeanListBase {
    public int cid1;
    public int cid2;
    public int action = 20001;
    public int uid = TextUtils.isEmpty(com.ndtlg.dbbx.F.uid)?0:Integer.valueOf(com.ndtlg.dbbx.F.uid) ;
}
