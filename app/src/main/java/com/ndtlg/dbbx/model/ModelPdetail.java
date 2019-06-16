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
     * data : {"rows":{"id":"84","cid1":"3","cid2":"23","title":"个人百万综合意外保险","desc":"","price":"0.00","collect":"0","insure_condition":"[\"6-65岁\",\"\",\"1月-1年\",\"30-80万\",\"1份\",\"趸交\",\"\",\"\",\"\"]","accident_protection":"[\"10-50万\",\"\",\"按伤残等级比例赔付\",\"\",\"\",\"\",\"\",\"\",\"30-80万\",\"10-50万\",\"10-50万\",\"10-50万\",\"\",\"1-5万\",\"\",\"60-250元\\/天\",\"\",\"\",\"\",\"\"]","remarks":"身故残疾节假日双倍赔付","relief":null,"show_link":null,"buy_link":null,"contact_number":null,"path":"http://insurance.inrnui.com/Uploads/Images/2019-01-05/5c3046e0316d9.jpg","category_name1":"团体保险","category_name2":"员工"},"fields":[{"name":"投保年龄","tips":"说明一","value":"6-65岁"},{"name":"可续保至","tips":"说明二","value":""},{"name":"保障时长","tips":"说明三","value":"1月-1年"},{"name":"保障额度","tips":"说明四","value":"30-80万"},{"name":"购买份数","tips":null,"value":"1份"},{"name":"交费方式","tips":null,"value":"趸交"},{"name":"缴费期","tips":null,"value":""},{"name":"等待期","tips":"说明5","value":""},{"name":"犹豫期","tips":null,"value":""},{"name":"身故保险金","tips":null,"value":"10-50万"},{"name":"病故保险金","tips":null,"value":""},{"name":"残疾保险金","tips":null,"value":"按伤残等级比例赔付"},{"name":"医疗运送","tips":null,"value":""},{"name":"住院医疗（报销）","tips":null,"value":""},{"name":"医疗补偿","tips":null,"value":""},{"name":"陪护金","tips":null,"value":""},{"name":"特殊赔付","tips":null,"value":""},{"name":"飞机意外","tips":null,"value":"30-80万"},{"name":"火车意外","tips":null,"value":"10-50万"},{"name":"轮船意外","tips":null,"value":"10-50万"},{"name":"汽车意外","tips":null,"value":"10-50万"},{"name":"其他交通意外","tips":null,"value":""},{"name":"意外医疗（报销）","tips":null,"value":"1-5万"},{"name":"急性病医疗（报销）","tips":null,"value":""},{"name":"津贴","tips":null,"value":"60-250元/天"},{"name":"津贴天数","tips":null,"value":""},{"name":"个人过失责任","tips":null,"value":""},{"name":"随身行李","tips":null,"value":""},{"name":"盗抢","tips":null,"value":""}]}
     */

    public int status;
    public int action;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * rows : {"id":"84","cid1":"3","cid2":"23","title":"个人百万综合意外保险","desc":"","price":"0.00","collect":"0","insure_condition":"[\"6-65岁\",\"\",\"1月-1年\",\"30-80万\",\"1份\",\"趸交\",\"\",\"\",\"\"]","accident_protection":"[\"10-50万\",\"\",\"按伤残等级比例赔付\",\"\",\"\",\"\",\"\",\"\",\"30-80万\",\"10-50万\",\"10-50万\",\"10-50万\",\"\",\"1-5万\",\"\",\"60-250元\\/天\",\"\",\"\",\"\",\"\"]","remarks":"身故残疾节假日双倍赔付","relief":null,"show_link":null,"buy_link":null,"contact_number":null,"path":"http://insurance.inrnui.com/Uploads/Images/2019-01-05/5c3046e0316d9.jpg","category_name1":"团体保险","category_name2":"员工"}
         * fields : [{"name":"投保年龄","tips":"说明一","value":"6-65岁"},{"name":"可续保至","tips":"说明二","value":""},{"name":"保障时长","tips":"说明三","value":"1月-1年"},{"name":"保障额度","tips":"说明四","value":"30-80万"},{"name":"购买份数","tips":null,"value":"1份"},{"name":"交费方式","tips":null,"value":"趸交"},{"name":"缴费期","tips":null,"value":""},{"name":"等待期","tips":"说明5","value":""},{"name":"犹豫期","tips":null,"value":""},{"name":"身故保险金","tips":null,"value":"10-50万"},{"name":"病故保险金","tips":null,"value":""},{"name":"残疾保险金","tips":null,"value":"按伤残等级比例赔付"},{"name":"医疗运送","tips":null,"value":""},{"name":"住院医疗（报销）","tips":null,"value":""},{"name":"医疗补偿","tips":null,"value":""},{"name":"陪护金","tips":null,"value":""},{"name":"特殊赔付","tips":null,"value":""},{"name":"飞机意外","tips":null,"value":"30-80万"},{"name":"火车意外","tips":null,"value":"10-50万"},{"name":"轮船意外","tips":null,"value":"10-50万"},{"name":"汽车意外","tips":null,"value":"10-50万"},{"name":"其他交通意外","tips":null,"value":""},{"name":"意外医疗（报销）","tips":null,"value":"1-5万"},{"name":"急性病医疗（报销）","tips":null,"value":""},{"name":"津贴","tips":null,"value":"60-250元/天"},{"name":"津贴天数","tips":null,"value":""},{"name":"个人过失责任","tips":null,"value":""},{"name":"随身行李","tips":null,"value":""},{"name":"盗抢","tips":null,"value":""}]
         */

        public RowsBean rows;
        public List<FieldsBean> fields;

        public static class RowsBean {
            /**
             * id : 84
             * cid1 : 3
             * cid2 : 23
             * title : 个人百万综合意外保险
             * desc :
             * price : 0.00
             * collect : 0
             * insure_condition : ["6-65岁","","1月-1年","30-80万","1份","趸交","","",""]
             * accident_protection : ["10-50万","","按伤残等级比例赔付","","","","","","30-80万","10-50万","10-50万","10-50万","","1-5万","","60-250元\/天","","","",""]
             * remarks : 身故残疾节假日双倍赔付
             * relief : null
             * show_link : null
             * buy_link : null
             * contact_number : null
             * path : http://insurance.inrnui.com/Uploads/Images/2019-01-05/5c3046e0316d9.jpg
             * category_name1 : 团体保险
             * category_name2 : 员工
             */

            public String id;
            public String cid1;
            public String cid2;
            public String title;
            public String desc;
            public String price;
            public String collect;
            public String insure_condition;
            public String accident_protection;
            public String remarks;
            public Object relief;
            public Object show_link;
            public Object buy_link;
            public Object contact_number;
            public String path;
            public String category_name1;
            public String category_name2;
        }

        public static class FieldsBean {
            /**
             * name : 投保年龄
             * tips : 说明一
             * value : 6-65岁
             */

            public String name;
            public String tips;
            public String value;
        }
    }
}
