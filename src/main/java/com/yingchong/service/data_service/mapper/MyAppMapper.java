package com.yingchong.service.data_service.mapper;


import com.yingchong.service.data_service.BizBean.biz_app.BizAppBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyAppMapper {

    @Select("select a.serv appName,a.flux flux,FORMAT(a.flux/b.flux1*100,2) fluxPercentage from (select serv,sum(up_flux+down_flux)/1024/1024/1024 flux from ${tableName} GROUP BY serv ORDER BY flux ) a join (select sum(up_flux+down_flux)/1024/1024/1024 flux1 from ${tableName}) b")
    List<BizAppBean> selectApp(@Param("tableName") String tableName);

    //@Select("select app_name appName,flux Flux,flux_percentage FluxPercentage from app_flux_sort where flux_date >= #{startTime} and flux_date <= #{endTime}")
    @Select("select a.flux flux,a.app_name appName,a.flux/(select SUM(flux) from app_flux_sort where flux_date >= #{startTime} and flux_date <= #{endTime})*100 fluxPercentage from (select SUM(flux) flux,app_name app_name from app_flux_sort where flux_date >= #{startTime} and flux_date <= #{endTime} GROUP BY app_name) a\n")
    List<BizAppBean> selectappSort(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );

}
