package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.AppFluxSort;
import com.yingchong.service.data_service.mybatis.model.AppFluxSortExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppFluxSortMapper {
    @SelectProvider(type=AppFluxSortSqlProvider.class, method="countByExample")
    long countByExample(AppFluxSortExample example);

    @DeleteProvider(type=AppFluxSortSqlProvider.class, method="deleteByExample")
    int deleteByExample(AppFluxSortExample example);

    @Delete({
        "delete from app_flux_sort",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into app_flux_sort (id, app_name, ",
        "flux, flux_percentage, ",
        "flux_date, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{appName,jdbcType=VARCHAR}, ",
        "#{flux,jdbcType=DOUBLE}, #{fluxPercentage,jdbcType=VARCHAR}, ",
        "#{fluxDate,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(AppFluxSort record);

    @InsertProvider(type=AppFluxSortSqlProvider.class, method="insertSelective")
    int insertSelective(AppFluxSort record);

    @SelectProvider(type=AppFluxSortSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux", property="flux", jdbcType=JdbcType.DOUBLE),
        @Result(column="flux_percentage", property="fluxPercentage", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux_date", property="fluxDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppFluxSort> selectByExample(AppFluxSortExample example);

    @Select({
        "select",
        "id, app_name, flux, flux_percentage, flux_date, create_time, update_time",
        "from app_flux_sort",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux", property="flux", jdbcType=JdbcType.DOUBLE),
        @Result(column="flux_percentage", property="fluxPercentage", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux_date", property="fluxDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AppFluxSort selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AppFluxSortSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AppFluxSort record, @Param("example") AppFluxSortExample example);

    @UpdateProvider(type=AppFluxSortSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AppFluxSort record, @Param("example") AppFluxSortExample example);

    @UpdateProvider(type=AppFluxSortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppFluxSort record);

    @Update({
        "update app_flux_sort",
        "set app_name = #{appName,jdbcType=VARCHAR},",
          "flux = #{flux,jdbcType=DOUBLE},",
          "flux_percentage = #{fluxPercentage,jdbcType=VARCHAR},",
          "flux_date = #{fluxDate,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppFluxSort record);
}