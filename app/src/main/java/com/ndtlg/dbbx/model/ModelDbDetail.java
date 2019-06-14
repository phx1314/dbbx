package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelDbDetail implements Serializable {


    /**
     * status : 100
     * action : 30013
     * msg : 获取对比列表详情成功！
     * data : {"columns":[{"title":"达尔文一号疾重险","price":"81","fields":[{"name":"适用年龄","value":"0-10岁"},{"name":"保障期限","value":"15年"},{"name":"重症种类","value":"严重冠心病"},{"name":"少儿特定重疾保险金","value":"AA"},{"name":"到期领取","value":"BB"},{"name":"0岁男","value":"CC"},{"name":"0岁女","value":"DD"},{"name":"疫苗意外伤害","value":"EE"},{"name":"免疫失效身故保险金","value":"FF"},{"name":"疫苗医疗","value":"GG"},{"name":"儿童个人责任补贴","value":"HH"},{"name":"儿童走失搜寻保险金","value":"II"},{"name":"儿童绑架救助保险金","value":"JJ"}]},{"title":"泰山重疾险","price":"91","fields":[{"name":"适用年龄","value":"0-10岁"},{"name":"保障期限","value":"15年"},{"name":"重症种类","value":"瘫痪"},{"name":"少儿特定重疾保险金","value":"11"},{"name":"到期领取","value":"22"},{"name":"0岁男","value":"33"},{"name":"0岁女","value":"44"},{"name":"疫苗意外伤害","value":"55"},{"name":"免疫失效身故保险金","value":"66"},{"name":"疫苗医疗","value":"77"},{"name":"儿童个人责任补贴","value":"88"},{"name":"儿童走失搜寻保险金","value":"99"},{"name":"儿童绑架救助保险金","value":"00"}]}]}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        public List<ColumnsBean> columns;

        public static class ColumnsBean {
            /**
             * title : 达尔文一号疾重险
             * price : 81
             * fields : [{"name":"适用年龄","value":"0-10岁"},{"name":"保障期限","value":"15年"},{"name":"重症种类","value":"严重冠心病"},{"name":"少儿特定重疾保险金","value":"AA"},{"name":"到期领取","value":"BB"},{"name":"0岁男","value":"CC"},{"name":"0岁女","value":"DD"},{"name":"疫苗意外伤害","value":"EE"},{"name":"免疫失效身故保险金","value":"FF"},{"name":"疫苗医疗","value":"GG"},{"name":"儿童个人责任补贴","value":"HH"},{"name":"儿童走失搜寻保险金","value":"II"},{"name":"儿童绑架救助保险金","value":"JJ"}]
             */

            public String id;
            public String contrast_id;
            public String desc;
            public String title;
            public String price;
            public List<FieldsBean> fields;

            public static class FieldsBean {
                /**
                 * name : 适用年龄
                 * value : 0-10岁
                 */

                public String name;
                public String value;
            }
        }
    }
}
