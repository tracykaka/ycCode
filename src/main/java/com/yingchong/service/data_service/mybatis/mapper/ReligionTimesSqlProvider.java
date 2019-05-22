package com.yingchong.service.data_service.mybatis.mapper;

import com.yingchong.service.data_service.mybatis.model.ReligionTimes;
import com.yingchong.service.data_service.mybatis.model.ReligionTimesExample.Criteria;
import com.yingchong.service.data_service.mybatis.model.ReligionTimesExample.Criterion;
import com.yingchong.service.data_service.mybatis.model.ReligionTimesExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReligionTimesSqlProvider {

    public String countByExample(ReligionTimesExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("religion_times");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReligionTimesExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("religion_times");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReligionTimes record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("religion_times");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getReligionName() != null) {
            sql.VALUES("religion_name", "#{religionName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainName() != null) {
            sql.VALUES("domain_name", "#{domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getWebName() != null) {
            sql.VALUES("web_name", "#{webName,jdbcType=VARCHAR}");
        }
        
        if (record.getHostIp() != null) {
            sql.VALUES("host_ip", "#{hostIp,jdbcType=VARCHAR}");
        }
        
        if (record.getDetIp() != null) {
            sql.VALUES("det_ip", "#{detIp,jdbcType=VARCHAR}");
        }
        
        if (record.getWebTitle() != null) {
            sql.VALUES("web_title", "#{webTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalType() != null) {
            sql.VALUES("terminal_type", "#{terminalType,jdbcType=VARCHAR}");
        }
        
        if (record.getVisiteTime() != null) {
            sql.VALUES("visite_time", "#{visiteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDns() != null) {
            sql.VALUES("dns", "#{dns,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalDetail() != null) {
            sql.VALUES("terminal_detail", "#{terminalDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getHostPort() != null) {
            sql.VALUES("host_port", "#{hostPort,jdbcType=INTEGER}");
        }
        
        if (record.getProtocol() != null) {
            sql.VALUES("protocol", "#{protocol,jdbcType=VARCHAR}");
        }
        
        if (record.getMacAddress() != null) {
            sql.VALUES("mac_address", "#{macAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ReligionTimesExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("religion_name");
        sql.SELECT("url");
        sql.SELECT("domain_name");
        sql.SELECT("web_name");
        sql.SELECT("host_ip");
        sql.SELECT("det_ip");
        sql.SELECT("web_title");
        sql.SELECT("terminal_type");
        sql.SELECT("visite_time");
        sql.SELECT("dns");
        sql.SELECT("terminal_detail");
        sql.SELECT("host_port");
        sql.SELECT("protocol");
        sql.SELECT("mac_address");
        sql.SELECT("update_time");
        sql.SELECT("create_time");
        sql.FROM("religion_times");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReligionTimes record = (ReligionTimes) parameter.get("record");
        ReligionTimesExample example = (ReligionTimesExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("religion_times");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getReligionName() != null) {
            sql.SET("religion_name = #{record.religionName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainName() != null) {
            sql.SET("domain_name = #{record.domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getWebName() != null) {
            sql.SET("web_name = #{record.webName,jdbcType=VARCHAR}");
        }
        
        if (record.getHostIp() != null) {
            sql.SET("host_ip = #{record.hostIp,jdbcType=VARCHAR}");
        }
        
        if (record.getDetIp() != null) {
            sql.SET("det_ip = #{record.detIp,jdbcType=VARCHAR}");
        }
        
        if (record.getWebTitle() != null) {
            sql.SET("web_title = #{record.webTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalType() != null) {
            sql.SET("terminal_type = #{record.terminalType,jdbcType=VARCHAR}");
        }
        
        if (record.getVisiteTime() != null) {
            sql.SET("visite_time = #{record.visiteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDns() != null) {
            sql.SET("dns = #{record.dns,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalDetail() != null) {
            sql.SET("terminal_detail = #{record.terminalDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getHostPort() != null) {
            sql.SET("host_port = #{record.hostPort,jdbcType=INTEGER}");
        }
        
        if (record.getProtocol() != null) {
            sql.SET("protocol = #{record.protocol,jdbcType=VARCHAR}");
        }
        
        if (record.getMacAddress() != null) {
            sql.SET("mac_address = #{record.macAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("religion_times");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("religion_name = #{record.religionName,jdbcType=VARCHAR}");
        sql.SET("url = #{record.url,jdbcType=VARCHAR}");
        sql.SET("domain_name = #{record.domainName,jdbcType=VARCHAR}");
        sql.SET("web_name = #{record.webName,jdbcType=VARCHAR}");
        sql.SET("host_ip = #{record.hostIp,jdbcType=VARCHAR}");
        sql.SET("det_ip = #{record.detIp,jdbcType=VARCHAR}");
        sql.SET("web_title = #{record.webTitle,jdbcType=VARCHAR}");
        sql.SET("terminal_type = #{record.terminalType,jdbcType=VARCHAR}");
        sql.SET("visite_time = #{record.visiteTime,jdbcType=TIMESTAMP}");
        sql.SET("dns = #{record.dns,jdbcType=VARCHAR}");
        sql.SET("terminal_detail = #{record.terminalDetail,jdbcType=VARCHAR}");
        sql.SET("host_port = #{record.hostPort,jdbcType=INTEGER}");
        sql.SET("protocol = #{record.protocol,jdbcType=VARCHAR}");
        sql.SET("mac_address = #{record.macAddress,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        ReligionTimesExample example = (ReligionTimesExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReligionTimes record) {
        SQL sql = new SQL();
        sql.UPDATE("religion_times");
        
        if (record.getReligionName() != null) {
            sql.SET("religion_name = #{religionName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getDomainName() != null) {
            sql.SET("domain_name = #{domainName,jdbcType=VARCHAR}");
        }
        
        if (record.getWebName() != null) {
            sql.SET("web_name = #{webName,jdbcType=VARCHAR}");
        }
        
        if (record.getHostIp() != null) {
            sql.SET("host_ip = #{hostIp,jdbcType=VARCHAR}");
        }
        
        if (record.getDetIp() != null) {
            sql.SET("det_ip = #{detIp,jdbcType=VARCHAR}");
        }
        
        if (record.getWebTitle() != null) {
            sql.SET("web_title = #{webTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalType() != null) {
            sql.SET("terminal_type = #{terminalType,jdbcType=VARCHAR}");
        }
        
        if (record.getVisiteTime() != null) {
            sql.SET("visite_time = #{visiteTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDns() != null) {
            sql.SET("dns = #{dns,jdbcType=VARCHAR}");
        }
        
        if (record.getTerminalDetail() != null) {
            sql.SET("terminal_detail = #{terminalDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getHostPort() != null) {
            sql.SET("host_port = #{hostPort,jdbcType=INTEGER}");
        }
        
        if (record.getProtocol() != null) {
            sql.SET("protocol = #{protocol,jdbcType=VARCHAR}");
        }
        
        if (record.getMacAddress() != null) {
            sql.SET("mac_address = #{macAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReligionTimesExample example, boolean includeExamplePhrase) {
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