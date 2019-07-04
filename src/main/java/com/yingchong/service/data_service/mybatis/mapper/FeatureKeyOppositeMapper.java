package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.FeatureKeyOpposite;
import com.yingchong.service.data_service.mybatis.model.FeatureKeyOppositeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureKeyOppositeMapper {
    @SelectProvider(type=FeatureKeyOppositeSqlProvider.class, method="countByExample")
    long countByExample(FeatureKeyOppositeExample example);

    @DeleteProvider(type=FeatureKeyOppositeSqlProvider.class, method="deleteByExample")
    int deleteByExample(FeatureKeyOppositeExample example);

    @Delete({
        "delete from feature_key_opposite",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into feature_key_opposite (id, keyword, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{keyword,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(FeatureKeyOpposite record);

    @InsertProvider(type=FeatureKeyOppositeSqlProvider.class, method="insertSelective")
    int insertSelective(FeatureKeyOpposite record);

    @SelectProvider(type=FeatureKeyOppositeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FeatureKeyOpposite> selectByExample(FeatureKeyOppositeExample example);

    @Select({
        "select",
        "id, keyword, create_time, update_time",
        "from feature_key_opposite",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    FeatureKeyOpposite selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FeatureKeyOppositeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FeatureKeyOpposite record, @Param("example") FeatureKeyOppositeExample example);

    @UpdateProvider(type=FeatureKeyOppositeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FeatureKeyOpposite record, @Param("example") FeatureKeyOppositeExample example);

    @UpdateProvider(type=FeatureKeyOppositeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FeatureKeyOpposite record);

    @Update({
        "update feature_key_opposite",
        "set keyword = #{keyword,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FeatureKeyOpposite record);
}