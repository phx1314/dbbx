package com.ndtlg.dbbx.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2017/6/19.
 */

public class ModelData implements Serializable {


    public String name;
    public String tips;
    public boolean isAllSame=true;

    public List<String> values = new ArrayList<>();

    public ModelData(String name,String tips) {
        this.name = name;
        this.tips = tips;
    }
}
