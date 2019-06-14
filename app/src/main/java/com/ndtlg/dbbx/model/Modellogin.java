package com.ndtlg.dbbx.model;

import java.io.Serializable;

/**
 * Created by DELL on 2017/6/19.
 */

public class Modellogin implements Serializable {


    /**
     * status : 100
     * action : 10001
     * msg : QQ登陆成功！
     * data : {"uid":"2","response":{"nickname":"外包项目","gender":"男","province":"江苏","city":"常州","year":"1990","figureurl":"http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/30","figureurl_1":"http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/50","figureurl_2":"http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/100","figureurl_qq_1":"http://thirdqq.qlogo.cn/qqapp/101543332/09F51D3FD21064513C2BF84CB7328137/40","figureurl_qq_2":"http://thirdqq.qlogo.cn/qqapp/101543332/09F51D3FD21064513C2BF84CB7328137/100","is_yellow_vip":"0","vip":"0","yellow_vip_level":"0","level":"0","is_yellow_year_vip":"0"}}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * uid : 2
         * response : {"nickname":"外包项目","gender":"男","province":"江苏","city":"常州","year":"1990","figureurl":"http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/30","figureurl_1":"http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/50","figureurl_2":"http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/100","figureurl_qq_1":"http://thirdqq.qlogo.cn/qqapp/101543332/09F51D3FD21064513C2BF84CB7328137/40","figureurl_qq_2":"http://thirdqq.qlogo.cn/qqapp/101543332/09F51D3FD21064513C2BF84CB7328137/100","is_yellow_vip":"0","vip":"0","yellow_vip_level":"0","level":"0","is_yellow_year_vip":"0"}
         */

        public String uid;
        public ResponseBean response;

        public static class ResponseBean {
            /**
             * nickname : 外包项目
             * gender : 男
             * province : 江苏
             * city : 常州
             * year : 1990
             * figureurl : http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/30
             * figureurl_1 : http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/50
             * figureurl_2 : http://qzapp.qlogo.cn/qzapp/101543332/09F51D3FD21064513C2BF84CB7328137/100
             * figureurl_qq_1 : http://thirdqq.qlogo.cn/qqapp/101543332/09F51D3FD21064513C2BF84CB7328137/40
             * figureurl_qq_2 : http://thirdqq.qlogo.cn/qqapp/101543332/09F51D3FD21064513C2BF84CB7328137/100
             * is_yellow_vip : 0
             * vip : 0
             * yellow_vip_level : 0
             * level : 0
             * is_yellow_year_vip : 0
             */

            public String nickname;
            public String gender;
            public String province;
            public String city;
            public String year;
            public String figureurl;
            public String figureurl_1;
            public String figureurl_2;
            public String figureurl_qq_1;
            public String figureurl_qq_2;
            public String is_yellow_vip;
            public String vip;
            public String yellow_vip_level;
            public String level;
            public String is_yellow_year_vip;
        }
    }
}
