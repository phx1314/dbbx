package com.ndtlg.dbbx.model;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelUser implements Serializable {


    /**
     * status : 100
     * action : 30001
     * msg : 获取用户信息成功！
     * data : {"rows":{"nickname":"不大点事","headimage":"http://127.0.0.1/Public/Static/images/head.png","mobile":""}}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * rows : {"nickname":"不大点事","headimage":"http://127.0.0.1/Public/Static/images/head.png","mobile":""}
         */

        public RowsBean rows;

        public static class RowsBean {
            /**
             * nickname : 不大点事
             * headimage : http://127.0.0.1/Public/Static/images/head.png
             * mobile :
             */

            public String nickname;
            public String headimage;
            public String mobile;
            public String mode;
            public String collect;
            public String browse;
        }
    }
}
