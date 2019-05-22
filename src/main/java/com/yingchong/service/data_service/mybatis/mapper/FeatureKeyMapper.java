package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.FeatureKey;
import com.yingchong.service.data_service.mybatis.model.FeatureKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository

public interface FeatureKeyMapper {
    @SelectProvider(type=FeatureKeySqlProvider.class, method="countByExample")
    long countByExample(FeatureKeyExample example);

    @DeleteProvider(type=FeatureKeySqlProvider.class, method="deleteByExample")
    int deleteByExample(FeatureKeyExample example);

    @Delete({
        "delete from feature_key",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into feature_key (id, key_word, ",
        "religion_name, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{keyWord,jdbcType=VARCHAR}, ",
        "#{religionName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(FeatureKey record);

    @InsertProvider(type=FeatureKeySqlProvider.class, method="insertSelective")
    int insertSelective(FeatureKey record);

    @SelectProvider(type=FeatureKeySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="key_word", property="keyWord", jdbcType=JdbcType.VARCHAR),
        @Result(column="religion_name", property="religionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FeatureKey> selectByExample(FeatureKeyExample example);

    @Select({
        "select",
        "id, key_word, religion_name, create_time, update_time",
        "from feature_key",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="key_word", property="keyWord", jdbcType=JdbcType.VARCHAR),
        @Result(column="religion_name", property="religionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    FeatureKey selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FeatureKeySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FeatureKey record, @Param("example") FeatureKeyExample example);

    @UpdateProvider(type=FeatureKeySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FeatureKey record, @Param("example") FeatureKeyExample example);

    @UpdateProvider(type=FeatureKeySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FeatureKey record);

    @Update({
        "update feature_key",
        "set key_word = #{keyWord,jdbcType=VARCHAR},",
          "religion_name = #{religionName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FeatureKey record);
}