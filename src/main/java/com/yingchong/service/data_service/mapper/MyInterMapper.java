package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_interTime.BizInterBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyInterMapper {

   @Select("select FORMAT((SUM(seconds)/3600/COUNT(DISTINCT user)),2) avgTime from ${tableName}")
    List<BizInterBean> selectInter(@Param("tableName") String tableName);

}
