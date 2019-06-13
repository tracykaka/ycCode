package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.ActionList;
import com.yingchong.service.data_service.mybatis.model.ActionListExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionListMapper {
    @SelectProvider(type=ActionListSqlProvider.class, method="countByExample")
    long countByExample(ActionListExample example);

    @DeleteProvider(type=ActionListSqlProvider.class, method="deleteByExample")
    int deleteByExample(ActionListExample example);

    @Delete({
        "delete from action_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into action_list (id, type_name, ",
        "order_num, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{typeName,jdbcType=VARCHAR}, ",
        "#{orderNum,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ActionList record);

    @InsertProvider(type=ActionListSqlProvider.class, method="insertSelective")
    int insertSelective(ActionList record);

    @SelectProvider(type=ActionListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_num", property="orderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ActionList> selectByExample(ActionListExample example);

    @Select({
        "select",
        "id, type_name, order_num, create_time, update_time",
        "from action_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_num", property="orderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ActionList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ActionListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ActionList record, @Param("example") ActionListExample example);

    @UpdateProvider(type=ActionListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ActionList record, @Param("example") ActionListExample example);

    @UpdateProvider(type=ActionListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ActionList record);

    @Update({
        "update action_list",
        "set type_name = #{typeName,jdbcType=VARCHAR},",
          "order_num = #{orderNum,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ActionList record);
}