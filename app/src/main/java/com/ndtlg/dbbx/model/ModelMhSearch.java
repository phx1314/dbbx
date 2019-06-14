package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelMhSearch implements Serializable {


    /**
     * status : 100
     * action : 20003
     * msg : 获取模糊搜索列表成功！
     * data : {"columns":[{"id":"12","title":"泰山重疾险9","desc":"","price":"168.00","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","collect":"0","category_name1":"团体保险","category_name2":"员工"},{"id":"11","title":"泰山重疾险8","desc":"","price":"144.00","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","collect":"0","category_name1":"团体保险","category_name2":"员工"},{"id":"10","title":"泰山重疾险7","desc":"","price":"159.00","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","collect":"0","category_name1":"团体保险","category_name2":"雇主责任"},{"id":"9","title":"泰山重疾险6","desc":"","price":"365.00","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","collect":"0","category_name1":"团体保险","category_name2":"雇主责任"},{"id":"8","title":"泰山重疾险5","desc":"","price":"452.00","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","collect":"0","category_name1":"财产保险","category_name2":"家财"},{"id":"7","title":"泰山重疾险4","desc":"","price":"258.00","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","collect":"0","category_name1":"财产保险","category_name2":"家财"},{"id":"6","title":"泰山重疾险3","desc":"","price":"156.00","path":"/Uploads/Images/2019-01-06/5c3210ef71703.png","collect":"0","category_name1":"财产保险","category_name2":"车险"},{"id":"5","title":"泰山重疾险2","desc":"","price":"27.00","path":"/Uploads/Images/2019-01-06/5c3210bd36434.png","collect":"0","category_name1":"财产保险","category_name2":"车险"},{"id":"4","title":"泰山重疾险1","desc":"","price":"65.00","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","collect":"0","category_name1":"人身保险","category_name2":"健康"},{"id":"1","title":"泰山重疾险","desc":"泰山重疾险简介","price":"12.00","path":"/Uploads/Images/2019-01-06/5c320f4729a85.png","collect":"0","category_name1":"人身保险","category_name2":"少儿"}],"search":["泰山重疾","泰山"]}
     */

    public int status;
    public String action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        public List<ModelTj.DataBean.ColumnsBean> columns;
        public List<String> search;


    }
}
