package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.AppFluxSort;
import com.yingchong.service.data_service.mybatis.model.AppFluxSortExample;
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
        "flux, flux_data, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{appName,jdbcType=VARCHAR}, ",
        "#{flux,jdbcType=VARCHAR}, #{fluxData,jdbcType=DATE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(AppFluxSort record);

    @InsertProvider(type=AppFluxSortSqlProvider.class, method="insertSelective")
    int insertSelective(AppFluxSort record);

    @SelectProvider(type=AppFluxSortSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux", property="flux", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux_data", property="fluxData", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppFluxSort> selectByExample(AppFluxSortExample example);

    @Select({
        "select",
        "id, app_name, flux, flux_data, create_time, update_time",
        "from app_flux_sort",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux", property="flux", jdbcType=JdbcType.VARCHAR),
        @Result(column="flux_data", property="fluxData", jdbcType=JdbcType.DATE),
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
          "flux = #{flux,jdbcType=VARCHAR},",
          "flux_data = #{fluxData,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppFluxSort record);
}