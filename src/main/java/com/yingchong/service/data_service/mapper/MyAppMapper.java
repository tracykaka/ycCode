package com.yingchong.service.data_service.mapper;


import com.yingchong.service.data_service.BizBean.biz_app.BizAppBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyAppMapper {

    @Select("select a.serv appName,a.flux flux,FORMAT(a.flux/b.flux1*100,2) fluxPercentage from (select serv,sum(up_flux+down_flux)/1024/1024/1024 flux from ${tableName} GROUP BY serv ORDER BY flux desc LIMIT 5) a join (select sum(up_flux+down_flux)/1024/1024/1024 flux1 from ${tableName}) b")
    List<BizAppBean> selectApp(@Param("tableName") String tableName);
}
