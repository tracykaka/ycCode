package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_action.BizActionBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyActionMapper {


    @Select(" SELECT record_id recordId,`group` `group`,`user` `user`,site site,serv serv,app app, " +
            " result result,host_ip hostIp,dst_ip dstIp,ip_version ipVersion, " +
            " tm_type tmType ,src_port srcPort,serv_port servPort,net_action netAction,record_time recordTime " +
            " from ${tableName} LIMIT #{start},#{end}")
    List<BizActionBean> selectAction(
            @Param("tableName") String tableName,
            @Param("start") Integer start,
            @Param("end") Integer end
    );

    @Select(" SELECT count(record_id)  from ${tableName}")
    Integer selectCountAction(@Param("tableName") String tableName);

}
