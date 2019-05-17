package com.yingchong.service.data_service.mybatis.model;

import java.util.Date;

public class AppFluxSort {
    private Integer id;

    private String appName;

    private String flux;

    private Date fluxData;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getFlux() {
        return flux;
    }

    public void setFlux(String flux) {
        this.flux = flux;
    }

    public Date getFluxData() {
        return fluxData;
    }

    public void setFluxData(Date fluxData) {
        this.fluxData = fluxData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}