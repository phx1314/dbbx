package com.ndtlg.dbbx.bean;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class BeanPdetail implements Serializable {
    public int action = 20002;
    public int id;

    public BeanPdetail(int id) {
        this.id = id;
    }
}
