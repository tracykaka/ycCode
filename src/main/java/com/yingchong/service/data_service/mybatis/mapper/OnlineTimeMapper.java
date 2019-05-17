package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.OnlineTime;
import com.yingchong.service.data_service.mybatis.model.OnlineTimeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OnlineTimeMapper {
    @SelectProvider(type=OnlineTimeSqlProvider.class, method="countByExample")
    long countByExample(OnlineTimeExample example);

    @DeleteProvider(type=OnlineTimeSqlProvider.class, method="deleteByExample")
    int deleteByExample(OnlineTimeExample example);

    @Delete({
        "delete from online_time",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into online_time (id, online_time, ",
        "result_date, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{onlineTime,jdbcType=BIGINT}, ",
        "#{resultDate,jdbcType=DATE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(OnlineTime record);

    @InsertProvider(type=OnlineTimeSqlProvider.class, method="insertSelective")
    int insertSelective(OnlineTime record);

    @SelectProvider(type=OnlineTimeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="online_time", property="onlineTime", jdbcType=JdbcType.BIGINT),
        @Result(column="result_date", property="resultDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OnlineTime> selectByExample(OnlineTimeExample example);

    @Select({
        "select",
        "id, online_time, result_date, create_time, update_time",
        "from online_time",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="online_time", property="onlineTime", jdbcType=JdbcType.BIGINT),
        @Result(column="result_date", property="resultDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    OnlineTime selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OnlineTimeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OnlineTime record, @Param("example") OnlineTimeExample example);

    @UpdateProvider(type=OnlineTimeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OnlineTime record, @Param("example") OnlineTimeExample example);

    @UpdateProvider(type=OnlineTimeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OnlineTime record);

    @Update({
        "update online_time",
        "set online_time = #{onlineTime,jdbcType=BIGINT},",
          "result_date = #{resultDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OnlineTime record);
}