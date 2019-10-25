package com.ndtlg.dbbx.model;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelDb implements Serializable {


    /**
     * status : 100
     * action : 20011
     * msg : 加入对比成功！
     * data : {"id":"72"}
     */

    public int status;
    public int action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * id : 72
         */

        public String id;
    }
}
