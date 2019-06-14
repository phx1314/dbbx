package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelPlist implements Serializable {


    /**
     * status : 100
     * action : 30011
     * msg : 获取收藏列表成功！
     * data : {"columns":[{"id":"3","title":"防盗重大失窃1","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","price":"155.00","contrast_id":0},{"id":"2","title":"达尔文一号疾重险","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","price":"144.00","contrast_id":3},{"id":"1","title":"泰山重疾险","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","price":"12.00","contrast_id":2}],"page":1}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * columns : [{"id":"3","title":"防盗重大失窃1","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","price":"155.00","contrast_id":0},{"id":"2","title":"达尔文一号疾重险","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","price":"144.00","contrast_id":3},{"id":"1","title":"泰山重疾险","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","price":"12.00","contrast_id":2}]
         * page : 1
         */

        public int page;
        public List<ModelTj.DataBean.ColumnsBean> columns;


    }
}
