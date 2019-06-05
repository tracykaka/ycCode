package com.yingchong.service.data_service.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yingchong.service.data_service.BizBean.BizUser;
import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.mapper.MyUserMapper;
import com.yingchong.service.data_service.mybatis.mapper.UserMapper;
import com.yingchong.service.data_service.mybatis.model.User;
import com.yingchong.service.data_service.mybatis.model.UserExample;
import com.yingchong.service.data_service.utils.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyUserMapper myUserMapper;


    public ResponseBean<BizUser> login(String userName, String password, HttpSession session) {
        ResponseBean<BizUser> responseBean = new ResponseBean<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null) {
            User user = users.get(0);
            if (MD5.encode(password).equals(user.getPassword())) {//登录成功
                String token = MD5.uuid();
                session.setAttribute(token,user.getId());
                BizUser bizUser = new BizUser(user);
                bizUser.setToken(token);
                user.setLoginTime(new Date());
                responseBean.setData(bizUser);
                userMapper.updateByPrimaryKey(user);
            }else {
                responseBean.setCodeAndMsg("500","用户名密码不匹配");
            }
        }
        return responseBean;
    }

    public ResponseBean<Void> logout(String token,HttpSession session) {
        session.removeAttribute(token);
        return new ResponseBean<>();
    }

    /**
     * 添加用户
     * @param userName
     * @param password
     * @param nickName
     * @param description
     * @return
     */
    public ResponseBean<User> addAdminUser(
            String userName,String password,String nickName,String description
    ) {
        ResponseBean<User> responseBean = new ResponseBean<>();
        try {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(MD5.encode(password));
            user.setDescription(new String(description.getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1));
            user.setNickName(new String(nickName.getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1));
            //user.setLoginTime();
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insert(user);
            responseBean.setData(user);
        } catch (Exception e) {
            responseBean.setCodeAndMsg("500","增加用户失败");
        }
        return responseBean;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public ResponseBean<Void> delAdminUser(Integer userId) {
        ResponseBean<Void> responseBean = new ResponseBean<>();
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i == 1) {
            return responseBean;
        }
        responseBean.setCodeAndMsg("500","删除失败");
        return responseBean;
    }

    public ResponseBean<Void> updateAdminUser() {

        return null;
    }

    /**
     * 根据用户 id 查找用户新
     * @param userId
     * @return
     */
    public ResponseBean<User> getAdminUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setDescription(new String(user.getDescription().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        user.setNickName(new String(user.getNickName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        return new ResponseBean<>(user);
    }

    /**
     * 分页查询列表
     * @param userName
     * @param startDate
     * @param endDate
     * @param description
     * @param page
     * @param pageSize
     * @return
     */
    public ResponseBean<PageInfo<User>> userList(
            String userName,String startDate,String endDate,
            String description,
            Integer page,Integer pageSize
    ) {
        Map<String,Object> selectParam = new HashMap<>();
        selectParam.put("userName",userName);
        selectParam.put("startDate",startDate);
        selectParam.put("endDate",endDate);
        selectParam.put("description",description);
        PageHelper.startPage(page, pageSize);
        List<User> userInfos = myUserMapper.queryUser(selectParam);
        for (User userInfo : userInfos) {
            //userInfo.setNickName(CodeUtils.convertCharset(userInfo.getNickName()));
            //userInfo.setDescription(CodeUtils.convertCharset(userInfo.getDescription()));
            userInfo.setNickName(new String(userInfo.getNickName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            userInfo.setDescription(new String(userInfo.getDescription().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        }
        PageInfo<User> date = new PageInfo<>(userInfos);
        ResponseBean<PageInfo<User>> responseBean = new ResponseBean<>();
        //responseBean.setCodeAndMsg(ErrorCode.OK.value(), ErrorCode.OK.msg());
        responseBean.setData(date);
        return responseBean;
    }

}
