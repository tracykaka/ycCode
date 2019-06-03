package com.yingchong.service.data_service.BizBean;

import com.yingchong.service.data_service.mybatis.model.User;

import java.util.Date;

public class BizUser {
    private Integer id;

    private String userName;

    private String password;

    private String nickName;

    private String description;

    private String token;

    private Date createTime, loginTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public BizUser() {

    }
    public BizUser(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.nickName = user.getNickName();
        this.description = user.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
