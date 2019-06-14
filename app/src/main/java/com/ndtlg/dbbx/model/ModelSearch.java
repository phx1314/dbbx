package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelSearch implements Serializable {


    /**
     * status : 100
     * action : 60001
     * msg : 获取列表成功！
     * data : {"hot":[{"id":"1","title":"意外保险"},{"id":"2","title":"医疗报销"},{"id":"3","title":"成人重疾"},{"id":"4","title":"健康"}],"history":[{"id":"1","title":"重疾","num":"0"}]}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        public List<HotBean> hot;
        public List<HistoryBean> history;

        public static class HotBean {
            /**
             * id : 1
             * title : 意外保险
             */

            public String id;
            public String title;
        }

        public static class HistoryBean {
            /**
             * id : 1
             * title : 重疾
             * num : 0
             */

            public String id;
            public String title;
            public String num;
        }
    }
}
