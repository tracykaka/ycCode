package com.yingchong.service.data_service.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MyUserMapper {

    @SelectProvider(type = com.rencai.service.user_service.mapper.MyUserProvider.class, method = "queryUser")
    List<Map<String, Object>> queryUser(Map<String, Object> param);
}
