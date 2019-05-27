package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionPercent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyReligionTimeMapper {

    @Select("SELECT religion_name religionName,count(religion_name) visitTime,count(religion_name)/(SELECT count(*)from religion_times) percentage from religion_times\n" +
            "where times_date >= #{startTime} and times_date <= #{endTime} " +
            "GROUP BY religion_name")
    List<BizReligionPercent> selectReligionPercent(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );

    @Select("SELECT religion_name,count(religion_name) visit_times,count(religion_name)/(SELECT count(*)from religion_times) percent ,times_date timesDate " +
            "from religion_times where create_time >= #{startTime} and create_time <= #{endTime}  " +
            "GROUP BY religion_name , times_date")
    List<BizReligionPercent> selectReligionTread(
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );
}
