package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_app.BizAppRelationBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppTypeBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyAppTypeMapper {
    @Select("select count(*) num,app from ${tableName} group by app order by num desc")
    List<BizAppTypeBean> selectApp(@Param("tableName") String tableName);


    @Select("select sum(action_count) num,action_name app from action_type where action_date >= #{startTime} and action_date <= #{endTime} group by app order by num desc ")
    List<BizAppTypeBean> selectAppTypeResult(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );

    @Select("select sum(action_count) num,action_name app,action_date date from action_type where action_date >= #{startTime} and action_date <= #{endTime} group by action_date,app ORDER BY num desc ")
    List<BizAppTypeBean> selectAppTypeTreadResult(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );
    @Select("select sum(action_count) num,action_name app,action_date date \n" +
            "from action_type \n" +
            "where action_date >= #{startTime} and action_date <= #{endTime} and action_name = #{appName} \n" +
            "GROUP BY action_date ORDER BY action_date")
    List<BizAppTypeBean> selectAppTypeTreadResultByAppName(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("appName") String appName
    );


    @Select("SELECT al.type_name actionName,ar.action_name relationItemName,al.order_num orderNum from action_relation ar left join action_list al on al.id = ar.relation_id " +
            "where al.type_name is not null")
    List<BizAppRelationBean> selectAppTypeRelation();


}
