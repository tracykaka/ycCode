package com.yingchong.service.data_service.BizBean.biz_action;

import java.util.Date;

public class BizActionBean {
    private Integer recordId;
    private Integer devId;
    private String group;
    private String user;
    private String hostIp,hostIpBin,dstIp,dstIpBin,ipVersion,site,tmType,serv,app;
    private Integer srcPort,servPort;
    private String netAction;
    private Date recordTime;
    private String result;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostIpBin() {
        return hostIpBin;
    }

    public void setHostIpBin(String hostIpBin) {
        this.hostIpBin = hostIpBin;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
    }

    public String getDstIpBin() {
        return dstIpBin;
    }

    public void setDstIpBin(String dstIpBin) {
        this.dstIpBin = dstIpBin;
    }

    public String getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(String ipVersion) {
        this.ipVersion = ipVersion;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTmType() {
        return tmType;
    }

    public void setTmType(String tmType) {
        this.tmType = tmType;
    }

    public String getServ() {
        return serv;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Integer getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(Integer srcPort) {
        this.srcPort = srcPort;
    }

    public Integer getServPort() {
        return servPort;
    }

    public void setServPort(Integer servPort) {
        this.servPort = servPort;
    }

    public String getNetAction() {
        return netAction;
    }

    public void setNetAction(String netAction) {
        this.netAction = netAction;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
