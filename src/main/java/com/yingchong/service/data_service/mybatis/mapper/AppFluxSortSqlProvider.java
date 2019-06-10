package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.AppFluxSort;
import com.yingchong.service.data_service.mybatis.model.AppFluxSortExample;
import com.yingchong.service.data_service.mybatis.model.AppFluxSortExample.Criteria;
import com.yingchong.service.data_service.mybatis.model.AppFluxSortExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class AppFluxSortSqlProvider {

    public String countByExample(AppFluxSortExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("app_flux_sort");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(AppFluxSortExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("app_flux_sort");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(AppFluxSort record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("app_flux_sort");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAppName() != null) {
            sql.VALUES("app_name", "#{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getFlux() != null) {
            sql.VALUES("flux", "#{flux,jdbcType=DOUBLE}");
        }
        
        if (record.getFluxPercentage() != null) {
            sql.VALUES("flux_percentage", "#{fluxPercentage,jdbcType=VARCHAR}");
        }
        
        if (record.getFluxDate() != null) {
            sql.VALUES("flux_date", "#{fluxDate,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AppFluxSortExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("app_name");
        sql.SELECT("flux");
        sql.SELECT("flux_percentage");
        sql.SELECT("flux_date");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("app_flux_sort");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        AppFluxSort record = (AppFluxSort) parameter.get("record");
        AppFluxSortExample example = (AppFluxSortExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("app_flux_sort");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getAppName() != null) {
            sql.SET("app_name = #{record.appName,jdbcType=VARCHAR}");
        }
        
        if (record.getFlux() != null) {
            sql.SET("flux = #{record.flux,jdbcType=DOUBLE}");
        }
        
        if (record.getFluxPercentage() != null) {
            sql.SET("flux_percentage = #{record.fluxPercentage,jdbcType=VARCHAR}");
        }
        
        if (record.getFluxDate() != null) {
            sql.SET("flux_date = #{record.fluxDate,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("app_flux_sort");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("app_name = #{record.appName,jdbcType=VARCHAR}");
        sql.SET("flux = #{record.flux,jdbcType=DOUBLE}");
        sql.SET("flux_percentage = #{record.fluxPercentage,jdbcType=VARCHAR}");
        sql.SET("flux_date = #{record.fluxDate,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        AppFluxSortExample example = (AppFluxSortExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AppFluxSort record) {
        SQL sql = new SQL();
        sql.UPDATE("app_flux_sort");
        
        if (record.getAppName() != null) {
            sql.SET("app_name = #{appName,jdbcType=VARCHAR}");
        }
        
        if (record.getFlux() != null) {
            sql.SET("flux = #{flux,jdbcType=DOUBLE}");
        }
        
        if (record.getFluxPercentage() != null) {
            sql.SET("flux_percentage = #{fluxPercentage,jdbcType=VARCHAR}");
        }
        
        if (record.getFluxDate() != null) {
            sql.SET("flux_date = #{fluxDate,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AppFluxSortExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}