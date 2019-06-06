package com.yingchong.service.data_service.mapper;

import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionDetailInfo;
import com.yingchong.service.data_service.BizBean.biz_religion.BizReligionPercent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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

    @Select("SELECT religion_name religionName,count(religion_name) visitTime,times_date timesDate " +
            "from religion_times " +
            "where times_date >= #{startTime} and times_date <= #{endTime} and religion_name=#{religionName}  " +
            "GROUP BY times_date order by times_date")
    List<BizReligionPercent> selectReligionTrend(
            @Param("religionName") String religionName,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );

    @Select("select religion_name religionName,url url,web_title title,terminal_type terminal,visite_time date,host_ip srcIP,domain_name domain,dns DNS, terminal_detail terminalDetail,\n" +
            "det_ip tarIP,host_port srcPort ,protocol protocol,mac_address MAC,count(*) visitTimes from religion_times " +
            "where religion_name =#{religionName} and times_date >= #{startDate} and times_date <= #{endDate} " +
            "GROUP BY url order by visitTimes desc ")
    List<BizReligionDetailInfo> selectReligionDetail(
            @Param("religionName") String religionName,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );

    @Select("select religion_name religionName,url url,web_title title,terminal_type terminal,visite_time visitTime,host_ip srcIP,domain_name domain,dns DNS, terminal_detail terminalDetail,\n" +
            "det_ip tarIP,host_port srcPort ,protocol protocol,mac_address MAC,count(*) visitTimes from religion_times\n" +
            "where times_date >= #{startDate} and times_date <= #{endDate} " +
            "GROUP BY url order by visitTimes desc ")
    List<BizReligionDetailInfo> selectReligionUrlRank(
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );


    @SelectProvider(type = MyReligionTimeProvider.class, method = "selectPeopleVisitTimes")
    List<BizReligionDetailInfo> selectPeopleVisitTimes(
            @Param("user") String user,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );


    @Select("select religion_name religionName,url url,web_title title,terminal_type terminal,visite_time visitTime,host_ip srcIP,domain_name domain,dns DNS, terminal_detail terminalDetail,\n" +
            "det_ip tarIP,host_port srcPort ,protocol protocol,mac_address MAC from religion_times\n" +
            "where times_date >= #{startDate} and times_date <= #{endDate} and host_ip = #{user}\n" +
            "order by visitTime desc ;")
    List<BizReligionDetailInfo> peopleVisitTimesDetail(
            @Param("user") String user,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );
}
