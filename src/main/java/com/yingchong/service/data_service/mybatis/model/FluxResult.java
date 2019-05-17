package com.yingchong.service.data_service.mybatis.model;

import java.util.Date;

public class FluxResult {
    private Integer id;

    private Double upload;

    private Double download;

    private Date fluxDate;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUpload() {
        return upload;
    }

    public void setUpload(Double upload) {
        this.upload = upload;
    }

    public Double getDownload() {
        return download;
    }

    public void setDownload(Double download) {
        this.download = download;
    }

    public Date getFluxDate() {
        return fluxDate;
    }

    public void setFluxDate(Date fluxDate) {
        this.fluxDate = fluxDate;
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