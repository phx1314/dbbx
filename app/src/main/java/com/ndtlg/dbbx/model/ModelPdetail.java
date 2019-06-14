package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelPdetail implements Serializable {


    /**
     * status : 100
     * action : 20002
     * msg : 获取产品详情成功！
     * data : {"rows":{"id":"1","cid1":"1","cid2":"7","title":"泰山重疾险","desc":"泰山重疾险简介","price":"121.00","collect":"0","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","category_name1":"人身保险","category_name2":"少儿"},"fields":[{"title":"少儿特定重疾保险金","value":"11"},{"title":"到期领取","value":"22"},{"title":"0岁男","value":"33"},{"title":"0岁女","value":"44"},{"title":"疫苗意外伤害","value":"55"},{"title":"免疫失效身故保险金","value":"66"},{"title":"疫苗医疗","value":"77"},{"title":"儿童个人责任补贴","value":"88"},{"title":"儿童走失搜寻保险金","value":"99"},{"title":"儿童绑架救助保险金","value":"00"}]}
     */

    public int status;
    public int action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * rows : {"id":"1","cid1":"1","cid2":"7","title":"泰山重疾险","desc":"泰山重疾险简介","price":"121.00","collect":"0","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","category_name1":"人身保险","category_name2":"少儿"}
         * fields : [{"title":"少儿特定重疾保险金","value":"11"},{"title":"到期领取","value":"22"},{"title":"0岁男","value":"33"},{"title":"0岁女","value":"44"},{"title":"疫苗意外伤害","value":"55"},{"title":"免疫失效身故保险金","value":"66"},{"title":"疫苗医疗","value":"77"},{"title":"儿童个人责任补贴","value":"88"},{"title":"儿童走失搜寻保险金","value":"99"},{"title":"儿童绑架救助保险金","value":"00"}]
         */

        public RowsBean rows;
        public List<FieldsBean> fields;

        public static class RowsBean {
            /**
             * id : 1
             * cid1 : 1
             * cid2 : 7
             * title : 泰山重疾险
             * desc : 泰山重疾险简介
             * price : 121.00
             * collect : 0
             * path : /Uploads/Images/2019-01-06/5c320f4729a85.png
             * category_name1 : 人身保险
             * category_name2 : 少儿
             */

            public String id;
            public String cid1;
            public String cid2;
            public String title;
            public String desc;
            public String price;
            public String collect;
            public String path;
            public String category_name1;
            public String category_name2;
        }

        public static class FieldsBean {
            /**
             * title : 少儿特定重疾保险金
             * value : 11
             */

            public String title;
            public String value;
        }
    }
}
