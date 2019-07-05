package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelTj implements Serializable {


    /**
     * status : 100
     * action : 20001
     * msg : 获取推荐列表成功！
     * data : {"columns":[{"id":"3","title":"防盗重大失窃1","price":"155.00","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","collect":"0","category_name1":"财产保险","category_name2":"房屋"},{"id":"2","title":"达尔文一号疾重险","price":"144.00","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","collect":"0","category_name1":"人身保险","category_name2":"意外"},{"id":"1","title":"泰山重疾险","price":"12.00","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","collect":"0","category_name1":"人身保险","category_name2":"健康"}],"category":[{"id":"1","title":"人身保险","sort":"1","pid":"0","child":[{"id":"7","title":"少儿","sort":"0","pid":"1","child":[]},{"id":"8","title":"健康","sort":"0","pid":"1","child":[]},{"id":"9","title":"意外","sort":"0","pid":"1","child":[]},{"id":"10","title":"寿险","sort":"0","pid":"1","child":[]},{"id":"11","title":"旅游","sort":"0","pid":"1","child":[]},{"id":"12","title":"养老","sort":"0","pid":"1","child":[]},{"id":"13","title":"理财","sort":"0","pid":"1","child":[]}]},{"id":"2","title":"财产保险","sort":"2","pid":"0","child":[{"id":"14","title":"车险","sort":"0","pid":"2","child":[]},{"id":"15","title":"房屋","sort":"0","pid":"2","child":[]},{"id":"16","title":"家财","sort":"0","pid":"2","child":[]},{"id":"17","title":"出租","sort":"0","pid":"2","child":[]},{"id":"18","title":"电器","sort":"0","pid":"2","child":[]},{"id":"19","title":"灾害","sort":"0","pid":"2","child":[]},{"id":"20","title":"宠物","sort":"0","pid":"2","child":[]}]},{"id":"3","title":"团体保险","sort":"3","pid":"0","child":[{"id":"21","title":"雇主责任","sort":"0","pid":"3","child":[]},{"id":"22","title":"旅游","sort":"0","pid":"3","child":[]},{"id":"23","title":"员工","sort":"0","pid":"3","child":[]},{"id":"24","title":"财产","sort":"0","pid":"3","child":[]},{"id":"25","title":"经营","sort":"0","pid":"3","child":[]}]}]}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean implements Serializable {
        public List<ColumnsBean> columns;
        public List<CategoryBean> category;

        public static class ColumnsBean implements Serializable {
            /**
             * id : 3
             * title : 防盗重大失窃1
             * price : 155.00
             * path : /Uploads/Images/2019-01-06/5c3210ef71703.png
             * collect : 0
             * category_name1 : 财产保险
             * category_name2 : 房屋
             */

            public String id;
            public String cid1;
            public String cid2;
            public String title;
            public String price;
            public String path;
            public String collect;
            public String category_name1;
            public String category_name2;
            public String desc;
            public String collect_id;
            public String contrast_id;
            public String create_date;
            public String create_time;
            public String update_time;
            public String update_date;
            public boolean isChecked;
        }

        public static class CategoryBean implements Serializable {
            /**
             * id : 1
             * title : 人身保险
             * sort : 1
             * pid : 0
             * child : [{"id":"7","title":"少儿","sort":"0","pid":"1","child":[]},{"id":"8","title":"健康","sort":"0","pid":"1","child":[]},{"id":"9","title":"意外","sort":"0","pid":"1","child":[]},{"id":"10","title":"寿险","sort":"0","pid":"1","child":[]},{"id":"11","title":"旅游","sort":"0","pid":"1","child":[]},{"id":"12","title":"养老","sort":"0","pid":"1","child":[]},{"id":"13","title":"理财","sort":"0","pid":"1","child":[]}]
             */

            public String id;
            public String title;
            public String sort;
            public String pid;
            public List<ChildBean> child;

            public static class ChildBean implements Serializable {
                /**
                 * id : 7
                 * title : 少儿
                 * sort : 0
                 * pid : 1
                 * child : []
                 */

                public String id;
                public String title;
                public String sort;
                public String pid;
                public List<ChildBean> child;
            }
        }
    }
}
