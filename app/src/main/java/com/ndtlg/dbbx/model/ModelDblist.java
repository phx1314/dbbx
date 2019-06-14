package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelDblist implements Serializable {


    /**
     * status : 100
     * action : 30012
     * msg : 获取对比列表成功！
     * data : {"columns":[[{"id":"2","cid1":"1","cid2":"7","title":"达尔文一号疾重险","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","price":"144.00","category_name1":"人身保险","category_name2":"少儿"},{"id":"1","cid1":"1","cid2":"7","title":"泰山重疾险","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","price":"12.00","category_name1":"人身保险","category_name2":"少儿"}],[{"id":"3","cid1":"1","cid2":"8","title":"防盗重大失窃1","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","price":"155.00","category_name1":"人身保险","category_name2":"健康"},{"id":"4","cid1":"1","cid2":"8","title":"泰山重疾险1","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","price":"65.00","category_name1":"人身保险","category_name2":"健康"}],[{"id":"5","cid1":"2","cid2":"14","title":"泰山重疾险2","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","price":"27.00","category_name1":"财产保险","category_name2":"车险"},{"id":"6","cid1":"2","cid2":"14","title":"泰山重疾险3","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","price":"156.00","category_name1":"财产保险","category_name2":"车险"}]]}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        public List<List<ModelTj.DataBean.ColumnsBean>> columns;
    }
}
