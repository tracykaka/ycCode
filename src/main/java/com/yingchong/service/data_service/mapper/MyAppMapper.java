package com.yingchong.service.data_service.mapper;


import com.yingchong.service.data_service.BizBean.biz_app.BizAppBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyAppMapper {

    @Select("select serv,sum(up_flux+down_flux)/1024/1024/1024 flux from ${tableName} GROUP BY serv ORDER BY flux desc LIMIT 5")
    List<BizAppBean> selectApp(@Param("tableName") String tableName);

}
