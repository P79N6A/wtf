package cn.tc.ulife.platform.server.shop.model;


import cn.tc.ulife.platform.util.UtilToString;

import java.util.List;

/**
 * Created by wy on 2015/10/28 0028.
 */
public class MessageModel {

    private String type;

    //ios，安卓两种
    private String appKey;

    //服务器端验证秘钥（两个）
    private String appMasterSecret;

    /**
     * 发送时间
     */
    private String timestamp;

    /**
     * 过期时间
     */
    private String expireTime;

    /**
     * 发送消息头
     */
    private String tittle;

    /**
     * 消息内容
     */
    private String text;

    /**
     * 设备标识码（单个发送时必须）
     */
    private String deviceTokens;

    /**
     * 点击跳转url
     */
    private String url;

    /**
     * 通知栏提示文字
     */
    private String ticker;


    /**
     * 消息描述
     */
    private String description;


    /**
     * 自定义参数类型:
     * activity          //线下活动详情
     * commodity        //商品详情
     * order           //订单列表
     */
    private String customArg;

    private String typeId;

    private List<FilterModel> filterModels;

    public List<FilterModel> getFilterModels() {
        return filterModels;
    }

    public void setFilterModels(List<FilterModel> filterModels) {
        this.filterModels = filterModels;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getCustomArg() {
        return customArg;
    }

    public void setCustomArg(String customArg) {
        this.customArg = customArg;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppMasterSecret() {
        return appMasterSecret;
    }

    public void setAppMasterSecret(String appMasterSecret) {
        this.appMasterSecret = appMasterSecret;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }


    public String getDeviceTokens() {
        return deviceTokens;
    }

    public void setDeviceTokens(String deviceTokens) {
        this.deviceTokens = deviceTokens;
    }


    @Override
    public String toString() {
        return UtilToString.getString(this);
    }
}
