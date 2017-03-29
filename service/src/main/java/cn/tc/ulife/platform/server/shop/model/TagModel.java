package cn.tc.ulife.platform.server.shop.model;


import cn.tc.ulife.platform.util.UtilToString;

/**
 * Created by wy on 2015/10/30 0030.
 */
public class TagModel {

    private String key;

    private String value;


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
