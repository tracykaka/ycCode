package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.ActionRelation;
import com.yingchong.service.data_service.mybatis.model.ActionRelationExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRelationMapper {
    @SelectProvider(type=ActionRelationSqlProvider.class, method="countByExample")
    long countByExample(ActionRelationExample example);

    @DeleteProvider(type=ActionRelationSqlProvider.class, method="deleteByExample")
    int deleteByExample(ActionRelationExample example);

    @Delete({
        "delete from action_relation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into action_relation (id, action_name, ",
        "relation_id, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{actionName,jdbcType=VARCHAR}, ",
        "#{relationId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ActionRelation record);

    @InsertProvider(type=ActionRelationSqlProvider.class, method="insertSelective")
    int insertSelective(ActionRelation record);

    @SelectProvider(type=ActionRelationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="relation_id", property="relationId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ActionRelation> selectByExample(ActionRelationExample example);

    @Select({
        "select",
        "id, action_name, relation_id, create_time, update_time",
        "from action_relation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action_name", property="actionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="relation_id", property="relationId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ActionRelation selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ActionRelationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ActionRelation record, @Param("example") ActionRelationExample example);

    @UpdateProvider(type=ActionRelationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ActionRelation record, @Param("example") ActionRelationExample example);

    @UpdateProvider(type=ActionRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ActionRelation record);

    @Update({
        "update action_relation",
        "set action_name = #{actionName,jdbcType=VARCHAR},",
          "relation_id = #{relationId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ActionRelation record);
}