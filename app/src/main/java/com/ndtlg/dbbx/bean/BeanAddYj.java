package com.ndtlg.dbbx.bean;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class BeanAddYj implements Serializable {
    public int action = 60004;
    public String content;

    public BeanAddYj(String content) {
        this.content = content;
    }
}
