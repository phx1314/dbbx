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
     * data : {"rows":{"nickname":"呵呵","headimage":"http://thirdqq.qlogo.cn/g?b=oidb&k=kGyapb48WLpTlaVtI9LpLA&s=40","mobile":"","mode":"QQ登录","collect":"3","browse":"2"},"url":"http://www.baidu.com"}
     */

    public int status;
    public int action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * rows : {"nickname":"呵呵","headimage":"http://thirdqq.qlogo.cn/g?b=oidb&k=kGyapb48WLpTlaVtI9LpLA&s=40","mobile":"","mode":"QQ登录","collect":"3","browse":"2"}
         * url : http://www.baidu.com
         */

        public RowsBean rows;
        public String url;

        public static class RowsBean {
            /**
             * nickname : 呵呵
             * headimage : http://thirdqq.qlogo.cn/g?b=oidb&k=kGyapb48WLpTlaVtI9LpLA&s=40
             * mobile :
             * mode : QQ登录
             * collect : 3
             * browse : 2
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
