package com.ndtlg.dbbx.bean;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class BeanPub implements Serializable {
    public int action = 20012;

    public BeanPub(int action) {
        this.action = action;
    }
}
