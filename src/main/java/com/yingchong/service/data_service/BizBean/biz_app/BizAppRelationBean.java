package com.yingchong.service.data_service.BizBean.biz_app;

public class BizAppRelationBean {

    private String actionName, relationItemName;

    private Integer orderNum;

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getRelationItemName() {
        return relationItemName;
    }

    public void setRelationItemName(String relationItemName) {
        this.relationItemName = relationItemName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BizAppRelationBean) {
            return ((BizAppRelationBean) obj).getRelationItemName().equals(this.relationItemName);
        }
        return false;
    }
}
