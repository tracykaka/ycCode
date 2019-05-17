package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.FluxResult;
import com.yingchong.service.data_service.mybatis.model.FluxResultExample;
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

public interface FluxResultMapper {
    @SelectProvider(type=FluxResultSqlProvider.class, method="countByExample")
    long countByExample(FluxResultExample example);

    @DeleteProvider(type=FluxResultSqlProvider.class, method="deleteByExample")
    int deleteByExample(FluxResultExample example);

    @Delete({
        "delete from flux_result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into flux_result (id, upload, ",
        "download, flux_date, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{upload,jdbcType=DOUBLE}, ",
        "#{download,jdbcType=DOUBLE}, #{fluxDate,jdbcType=DATE}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(FluxResult record);

    @InsertProvider(type=FluxResultSqlProvider.class, method="insertSelective")
    int insertSelective(FluxResult record);

    @SelectProvider(type=FluxResultSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="upload", property="upload", jdbcType=JdbcType.DOUBLE),
        @Result(column="download", property="download", jdbcType=JdbcType.DOUBLE),
        @Result(column="flux_date", property="fluxDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FluxResult> selectByExample(FluxResultExample example);

    @Select({
        "select",
        "id, upload, download, flux_date, create_time, update_time",
        "from flux_result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="upload", property="upload", jdbcType=JdbcType.DOUBLE),
        @Result(column="download", property="download", jdbcType=JdbcType.DOUBLE),
        @Result(column="flux_date", property="fluxDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    FluxResult selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FluxResultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FluxResult record, @Param("example") FluxResultExample example);

    @UpdateProvider(type=FluxResultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FluxResult record, @Param("example") FluxResultExample example);

    @UpdateProvider(type=FluxResultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FluxResult record);

    @Update({
        "update flux_result",
        "set upload = #{upload,jdbcType=DOUBLE},",
          "download = #{download,jdbcType=DOUBLE},",
          "flux_date = #{fluxDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FluxResult record);
}