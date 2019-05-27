package com.yingchong.service.data_service.BizBean.biz_religion;

import java.util.Date;

public class BizReligionPercent {

    private String religionName;

    private Integer visitTime=0;

    private Double percentage=0D;

    private Date timesDate;

    public Date getTimesDate() {
        return timesDate;
    }

    public void setTimesDate(Date timesDate) {
        this.timesDate = timesDate;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
