package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.ActionType;
import com.yingchong.service.data_service.mybatis.model.ActionTypeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActionTypeMapper {
    @SelectProvider(type=ActionTypeSqlProvider.class, method="countByExample")
    long countByExample(ActionTypeExample example);

    @DeleteProvider(type=ActionTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(ActionTypeExample example);

    @Delete({
        "delete from action_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into action_type (id, action_name, ",
        "action_count, action_date, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{actionName,jdbcType=VARCHAR}, ",
        "#{actionCount,jdbcType=INTEGER}, #{actionDate,jdbcType=DATE}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ActionType record);

    @InsertProvider(type=ActionTypeSqlProvider.class, method="insertSelective")
    int insertSelective(ActionType record);

    @SelectProvider(type=ActionTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="action_count", property="actionCount", jdbcType=JdbcType.INTEGER),
        @Result(column="action_date", property="actionDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ActionType> selectByExample(ActionTypeExample example);

    @Select({
        "select",
        "id, action_name, action_count, action_date, create_time, update_time",
        "from action_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="action_count", property="actionCount", jdbcType=JdbcType.INTEGER),
        @Result(column="action_date", property="actionDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ActionType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ActionTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ActionType record, @Param("example") ActionTypeExample example);

    @UpdateProvider(type=ActionTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ActionType record, @Param("example") ActionTypeExample example);

    @UpdateProvider(type=ActionTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ActionType record);

    @Update({
        "update action_type",
        "set action_name = #{actionName,jdbcType=VARCHAR},",
          "action_count = #{actionCount,jdbcType=INTEGER},",
          "action_date = #{actionDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ActionType record);
}