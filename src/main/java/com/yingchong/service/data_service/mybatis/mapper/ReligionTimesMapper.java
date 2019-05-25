package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.ReligionTimes;
import com.yingchong.service.data_service.mybatis.model.ReligionTimesExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReligionTimesMapper {
    @SelectProvider(type=ReligionTimesSqlProvider.class, method="countByExample")
    long countByExample(ReligionTimesExample example);

    @DeleteProvider(type=ReligionTimesSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReligionTimesExample example);

    @Delete({
        "delete from religion_times",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into religion_times (id, religion_name, ",
        "url, domain_name, ",
        "web_name, host_ip, ",
        "det_ip, web_title, ",
        "terminal_type, visite_time, ",
        "dns, terminal_detail, ",
        "host_port, protocol, ",
        "mac_address, times_date, ",
        "update_time, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{religionName,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{domainName,jdbcType=VARCHAR}, ",
        "#{webName,jdbcType=VARCHAR}, #{hostIp,jdbcType=VARCHAR}, ",
        "#{detIp,jdbcType=VARCHAR}, #{webTitle,jdbcType=VARCHAR}, ",
        "#{terminalType,jdbcType=VARCHAR}, #{visiteTime,jdbcType=TIMESTAMP}, ",
        "#{dns,jdbcType=VARCHAR}, #{terminalDetail,jdbcType=VARCHAR}, ",
        "#{hostPort,jdbcType=INTEGER}, #{protocol,jdbcType=VARCHAR}, ",
        "#{macAddress,jdbcType=VARCHAR}, #{timesDate,jdbcType=DATE}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(ReligionTimes record);

    @InsertProvider(type=ReligionTimesSqlProvider.class, method="insertSelective")
    int insertSelective(ReligionTimes record);

    @SelectProvider(type=ReligionTimesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="religion_name", property="religionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="domain_name", property="domainName", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_name", property="webName", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_ip", property="hostIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="det_ip", property="detIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_title", property="webTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="terminal_type", property="terminalType", jdbcType=JdbcType.VARCHAR),
        @Result(column="visite_time", property="visiteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dns", property="dns", jdbcType=JdbcType.VARCHAR),
        @Result(column="terminal_detail", property="terminalDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_port", property="hostPort", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="mac_address", property="macAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="times_date", property="timesDate", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReligionTimes> selectByExample(ReligionTimesExample example);

    @Select({
        "select",
        "id, religion_name, url, domain_name, web_name, host_ip, det_ip, web_title, terminal_type, ",
        "visite_time, dns, terminal_detail, host_port, protocol, mac_address, times_date, ",
        "update_time, create_time",
        "from religion_times",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="religion_name", property="religionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="domain_name", property="domainName", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_name", property="webName", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_ip", property="hostIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="det_ip", property="detIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_title", property="webTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="terminal_type", property="terminalType", jdbcType=JdbcType.VARCHAR),
        @Result(column="visite_time", property="visiteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="dns", property="dns", jdbcType=JdbcType.VARCHAR),
        @Result(column="terminal_detail", property="terminalDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_port", property="hostPort", jdbcType=JdbcType.INTEGER),
        @Result(column="protocol", property="protocol", jdbcType=JdbcType.VARCHAR),
        @Result(column="mac_address", property="macAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="times_date", property="timesDate", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ReligionTimes selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ReligionTimesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReligionTimes record, @Param("example") ReligionTimesExample example);

    @UpdateProvider(type=ReligionTimesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReligionTimes record, @Param("example") ReligionTimesExample example);

    @UpdateProvider(type=ReligionTimesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReligionTimes record);

    @Update({
        "update religion_times",
        "set religion_name = #{religionName,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "domain_name = #{domainName,jdbcType=VARCHAR},",
          "web_name = #{webName,jdbcType=VARCHAR},",
          "host_ip = #{hostIp,jdbcType=VARCHAR},",
          "det_ip = #{detIp,jdbcType=VARCHAR},",
          "web_title = #{webTitle,jdbcType=VARCHAR},",
          "terminal_type = #{terminalType,jdbcType=VARCHAR},",
          "visite_time = #{visiteTime,jdbcType=TIMESTAMP},",
          "dns = #{dns,jdbcType=VARCHAR},",
          "terminal_detail = #{terminalDetail,jdbcType=VARCHAR},",
          "host_port = #{hostPort,jdbcType=INTEGER},",
          "protocol = #{protocol,jdbcType=VARCHAR},",
          "mac_address = #{macAddress,jdbcType=VARCHAR},",
          "times_date = #{timesDate,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReligionTimes record);
}