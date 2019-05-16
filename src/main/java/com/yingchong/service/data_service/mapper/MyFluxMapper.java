package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyFluxMapper {


    @Select("select sum(up_flux)/1024/1024/1024 uploadFlux, sum(down_flux)/1024/1024/1024 downFlux from ${tableName}")
    List<BizDataBean> selectFlux(@Param("tableName") String tableName);
}
