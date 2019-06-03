package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.mybatis.model.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MyUserMapper {

    @SelectProvider(type = MyUserProvider.class, method = "queryUser")
    List<User> queryUser(Map<String, Object> param);
}
