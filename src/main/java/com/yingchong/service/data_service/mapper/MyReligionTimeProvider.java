package com.yingchong.service.data_service.mapper;

import org.apache.ibatis.annotations.Param;

public class MyReligionTimeProvider {

    public String selectPeopleVisitTimes(
            @Param("user") String user,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    ) {
        if(user != null && !user.isEmpty())
        return "select religion_name religionName,url url,web_title title,terminal_type terminal,visite_time visitTime,host_ip srcIP,domain_name domain,dns DNS, terminal_detail terminalDetail,\n" +
                "det_ip tarIP,host_port srcPort ,protocol protocol,mac_address MAC,count(*) visitTimes from religion_times\n" +
                "where times_date >= #{startDate} and times_date <= #{endDate} and host_ip = #{user} " +
                "GROUP BY host_ip order by visitTimes desc ";
        else
        return "select religion_name religionName,url url,web_title title,terminal_type terminal,visite_time visitTime,host_ip srcIP,domain_name domain,dns DNS, terminal_detail terminalDetail,\n" +
                    "det_ip tarIP,host_port srcPort ,protocol protocol,mac_address MAC,count(*) visitTimes from religion_times\n" +
                    "where times_date >= #{startDate} and times_date <= #{endDate} " +
                    "GROUP BY host_ip order by visitTimes desc ";

    }
}
