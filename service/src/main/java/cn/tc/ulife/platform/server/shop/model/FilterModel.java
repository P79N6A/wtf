package cn.tc.ulife.platform.server.shop.model;


import cn.tc.ulife.platform.util.UtilToString;

import java.util.List;

/**
 * Created by wy on 2015/10/29 0029.
 */
public class FilterModel {


    private String key;


    private String value;

    /**
     * 连接字符
     */
    private String connector;

    private String logic;

    private List<TagModel> tagModels;


    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public List<TagModel> getTagModels() {
        return tagModels;
    }

    public void setTagModels(List<TagModel> tagModels) {
        this.tagModels = tagModels;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }


    //    private String

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
