package com.ndtlg.dbbx.bean;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class BeanClearZj implements Serializable {
    public int action = 30030;
    public int uid = TextUtils.isEmpty(com.ndtlg.dbbx.F.uid) ? 0 : Integer.valueOf(com.ndtlg.dbbx.F.uid);

    public BeanClearZj( ) {
    }
}
