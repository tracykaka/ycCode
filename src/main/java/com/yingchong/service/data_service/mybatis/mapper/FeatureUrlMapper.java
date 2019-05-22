package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.FeatureUrl;
import com.yingchong.service.data_service.mybatis.model.FeatureUrlExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FeatureUrlMapper {
    @SelectProvider(type=FeatureUrlSqlProvider.class, method="countByExample")
    long countByExample(FeatureUrlExample example);

    @DeleteProvider(type=FeatureUrlSqlProvider.class, method="deleteByExample")
    int deleteByExample(FeatureUrlExample example);

    @Delete({
        "delete from feature_url",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into feature_url (id, url, ",
        "web_name, entity, ",
        "web_type, religion_name, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{url,jdbcType=VARCHAR}, ",
        "#{webName,jdbcType=VARCHAR}, #{entity,jdbcType=VARCHAR}, ",
        "#{webType,jdbcType=VARCHAR}, #{religionName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(FeatureUrl record);

    @InsertProvider(type=FeatureUrlSqlProvider.class, method="insertSelective")
    int insertSelective(FeatureUrl record);

    @SelectProvider(type=FeatureUrlSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_name", property="webName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entity", property="entity", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_type", property="webType", jdbcType=JdbcType.VARCHAR),
        @Result(column="religion_name", property="religionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FeatureUrl> selectByExample(FeatureUrlExample example);

    @Select({
        "select",
        "id, url, web_name, entity, web_type, religion_name, create_time, update_time",
        "from feature_url",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_name", property="webName", jdbcType=JdbcType.VARCHAR),
        @Result(column="entity", property="entity", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_type", property="webType", jdbcType=JdbcType.VARCHAR),
        @Result(column="religion_name", property="religionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    FeatureUrl selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FeatureUrlSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FeatureUrl record, @Param("example") FeatureUrlExample example);

    @UpdateProvider(type=FeatureUrlSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FeatureUrl record, @Param("example") FeatureUrlExample example);

    @UpdateProvider(type=FeatureUrlSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FeatureUrl record);

    @Update({
        "update feature_url",
        "set url = #{url,jdbcType=VARCHAR},",
          "web_name = #{webName,jdbcType=VARCHAR},",
          "entity = #{entity,jdbcType=VARCHAR},",
          "web_type = #{webType,jdbcType=VARCHAR},",
          "religion_name = #{religionName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FeatureUrl record);
}