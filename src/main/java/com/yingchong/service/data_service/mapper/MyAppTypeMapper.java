package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_app.BizAppTypeBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyAppTypeMapper {
    @Select("select count(*) num,app from ${tableName} group by app order by num desc")
    List<BizAppTypeBean> selectApp(@Param("tableName") String tableName);


    @Select("select sum(action_count) num,action_name app from action_type where action_date >= #{startTime} and action_date <= #{endTime} group by app order by num desc limit 0,10 ")
    List<BizAppTypeBean> selectAppTypeResult(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );

    @Select("select sum(action_count) num,action_name app,action_date from action_type where action_date >= #{startTime} and action_date <= #{endTime} group by action_date,app ORDER BY num desc ")
    List<BizAppTypeBean> selectAppTypeTreadResult(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );
}
