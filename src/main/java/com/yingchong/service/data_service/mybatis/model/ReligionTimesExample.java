package com.yingchong.service.data_service.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReligionTimesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReligionTimesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReligionNameIsNull() {
            addCriterion("religion_name is null");
            return (Criteria) this;
        }

        public Criteria andReligionNameIsNotNull() {
            addCriterion("religion_name is not null");
            return (Criteria) this;
        }

        public Criteria andReligionNameEqualTo(String value) {
            addCriterion("religion_name =", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameNotEqualTo(String value) {
            addCriterion("religion_name <>", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameGreaterThan(String value) {
            addCriterion("religion_name >", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameGreaterThanOrEqualTo(String value) {
            addCriterion("religion_name >=", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameLessThan(String value) {
            addCriterion("religion_name <", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameLessThanOrEqualTo(String value) {
            addCriterion("religion_name <=", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameLike(String value) {
            addCriterion("religion_name like", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameNotLike(String value) {
            addCriterion("religion_name not like", value, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameIn(List<String> values) {
            addCriterion("religion_name in", values, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameNotIn(List<String> values) {
            addCriterion("religion_name not in", values, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameBetween(String value1, String value2) {
            addCriterion("religion_name between", value1, value2, "religionName");
            return (Criteria) this;
        }

        public Criteria andReligionNameNotBetween(String value1, String value2) {
            addCriterion("religion_name not between", value1, value2, "religionName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andDomainNameIsNull() {
            addCriterion("domain_name is null");
            return (Criteria) this;
        }

        public Criteria andDomainNameIsNotNull() {
            addCriterion("domain_name is not null");
            return (Criteria) this;
        }

        public Criteria andDomainNameEqualTo(String value) {
            addCriterion("domain_name =", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotEqualTo(String value) {
            addCriterion("domain_name <>", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameGreaterThan(String value) {
            addCriterion("domain_name >", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameGreaterThanOrEqualTo(String value) {
            addCriterion("domain_name >=", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLessThan(String value) {
            addCriterion("domain_name <", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLessThanOrEqualTo(String value) {
            addCriterion("domain_name <=", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLike(String value) {
            addCriterion("domain_name like", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotLike(String value) {
            addCriterion("domain_name not like", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameIn(List<String> values) {
            addCriterion("domain_name in", values, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotIn(List<String> values) {
            addCriterion("domain_name not in", values, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameBetween(String value1, String value2) {
            addCriterion("domain_name between", value1, value2, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotBetween(String value1, String value2) {
            addCriterion("domain_name not between", value1, value2, "domainName");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNull() {
            addCriterion("web_name is null");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNotNull() {
            addCriterion("web_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebNameEqualTo(String value) {
            addCriterion("web_name =", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotEqualTo(String value) {
            addCriterion("web_name <>", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThan(String value) {
            addCriterion("web_name >", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_name >=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThan(String value) {
            addCriterion("web_name <", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThanOrEqualTo(String value) {
            addCriterion("web_name <=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLike(String value) {
            addCriterion("web_name like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotLike(String value) {
            addCriterion("web_name not like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameIn(List<String> values) {
            addCriterion("web_name in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotIn(List<String> values) {
            addCriterion("web_name not in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameBetween(String value1, String value2) {
            addCriterion("web_name between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotBetween(String value1, String value2) {
            addCriterion("web_name not between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andHostIpIsNull() {
            addCriterion("host_ip is null");
            return (Criteria) this;
        }

        public Criteria andHostIpIsNotNull() {
            addCriterion("host_ip is not null");
            return (Criteria) this;
        }

        public Criteria andHostIpEqualTo(String value) {
            addCriterion("host_ip =", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotEqualTo(String value) {
            addCriterion("host_ip <>", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpGreaterThan(String value) {
            addCriterion("host_ip >", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpGreaterThanOrEqualTo(String value) {
            addCriterion("host_ip >=", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpLessThan(String value) {
            addCriterion("host_ip <", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpLessThanOrEqualTo(String value) {
            addCriterion("host_ip <=", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpLike(String value) {
            addCriterion("host_ip like", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotLike(String value) {
            addCriterion("host_ip not like", value, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpIn(List<String> values) {
            addCriterion("host_ip in", values, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotIn(List<String> values) {
            addCriterion("host_ip not in", values, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpBetween(String value1, String value2) {
            addCriterion("host_ip between", value1, value2, "hostIp");
            return (Criteria) this;
        }

        public Criteria andHostIpNotBetween(String value1, String value2) {
            addCriterion("host_ip not between", value1, value2, "hostIp");
            return (Criteria) this;
        }

        public Criteria andDetIpIsNull() {
            addCriterion("det_ip is null");
            return (Criteria) this;
        }

        public Criteria andDetIpIsNotNull() {
            addCriterion("det_ip is not null");
            return (Criteria) this;
        }

        public Criteria andDetIpEqualTo(String value) {
            addCriterion("det_ip =", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpNotEqualTo(String value) {
            addCriterion("det_ip <>", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpGreaterThan(String value) {
            addCriterion("det_ip >", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpGreaterThanOrEqualTo(String value) {
            addCriterion("det_ip >=", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpLessThan(String value) {
            addCriterion("det_ip <", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpLessThanOrEqualTo(String value) {
            addCriterion("det_ip <=", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpLike(String value) {
            addCriterion("det_ip like", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpNotLike(String value) {
            addCriterion("det_ip not like", value, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpIn(List<String> values) {
            addCriterion("det_ip in", values, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpNotIn(List<String> values) {
            addCriterion("det_ip not in", values, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpBetween(String value1, String value2) {
            addCriterion("det_ip between", value1, value2, "detIp");
            return (Criteria) this;
        }

        public Criteria andDetIpNotBetween(String value1, String value2) {
            addCriterion("det_ip not between", value1, value2, "detIp");
            return (Criteria) this;
        }

        public Criteria andWebTitleIsNull() {
            addCriterion("web_title is null");
            return (Criteria) this;
        }

        public Criteria andWebTitleIsNotNull() {
            addCriterion("web_title is not null");
            return (Criteria) this;
        }

        public Criteria andWebTitleEqualTo(String value) {
            addCriterion("web_title =", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleNotEqualTo(String value) {
            addCriterion("web_title <>", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleGreaterThan(String value) {
            addCriterion("web_title >", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleGreaterThanOrEqualTo(String value) {
            addCriterion("web_title >=", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleLessThan(String value) {
            addCriterion("web_title <", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleLessThanOrEqualTo(String value) {
            addCriterion("web_title <=", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleLike(String value) {
            addCriterion("web_title like", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleNotLike(String value) {
            addCriterion("web_title not like", value, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleIn(List<String> values) {
            addCriterion("web_title in", values, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleNotIn(List<String> values) {
            addCriterion("web_title not in", values, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleBetween(String value1, String value2) {
            addCriterion("web_title between", value1, value2, "webTitle");
            return (Criteria) this;
        }

        public Criteria andWebTitleNotBetween(String value1, String value2) {
            addCriterion("web_title not between", value1, value2, "webTitle");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIsNull() {
            addCriterion("terminal_type is null");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIsNotNull() {
            addCriterion("terminal_type is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeEqualTo(String value) {
            addCriterion("terminal_type =", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotEqualTo(String value) {
            addCriterion("terminal_type <>", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeGreaterThan(String value) {
            addCriterion("terminal_type >", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_type >=", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLessThan(String value) {
            addCriterion("terminal_type <", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLessThanOrEqualTo(String value) {
            addCriterion("terminal_type <=", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLike(String value) {
            addCriterion("terminal_type like", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotLike(String value) {
            addCriterion("terminal_type not like", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIn(List<String> values) {
            addCriterion("terminal_type in", values, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotIn(List<String> values) {
            addCriterion("terminal_type not in", values, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeBetween(String value1, String value2) {
            addCriterion("terminal_type between", value1, value2, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotBetween(String value1, String value2) {
            addCriterion("terminal_type not between", value1, value2, "terminalType");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeIsNull() {
            addCriterion("visite_time is null");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeIsNotNull() {
            addCriterion("visite_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeEqualTo(Date value) {
            addCriterion("visite_time =", value, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeNotEqualTo(Date value) {
            addCriterion("visite_time <>", value, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeGreaterThan(Date value) {
            addCriterion("visite_time >", value, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("visite_time >=", value, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeLessThan(Date value) {
            addCriterion("visite_time <", value, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeLessThanOrEqualTo(Date value) {
            addCriterion("visite_time <=", value, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeIn(List<Date> values) {
            addCriterion("visite_time in", values, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeNotIn(List<Date> values) {
            addCriterion("visite_time not in", values, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeBetween(Date value1, Date value2) {
            addCriterion("visite_time between", value1, value2, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andVisiteTimeNotBetween(Date value1, Date value2) {
            addCriterion("visite_time not between", value1, value2, "visiteTime");
            return (Criteria) this;
        }

        public Criteria andDnsIsNull() {
            addCriterion("dns is null");
            return (Criteria) this;
        }

        public Criteria andDnsIsNotNull() {
            addCriterion("dns is not null");
            return (Criteria) this;
        }

        public Criteria andDnsEqualTo(String value) {
            addCriterion("dns =", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotEqualTo(String value) {
            addCriterion("dns <>", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThan(String value) {
            addCriterion("dns >", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThanOrEqualTo(String value) {
            addCriterion("dns >=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThan(String value) {
            addCriterion("dns <", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThanOrEqualTo(String value) {
            addCriterion("dns <=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLike(String value) {
            addCriterion("dns like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotLike(String value) {
            addCriterion("dns not like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsIn(List<String> values) {
            addCriterion("dns in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotIn(List<String> values) {
            addCriterion("dns not in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsBetween(String value1, String value2) {
            addCriterion("dns between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotBetween(String value1, String value2) {
            addCriterion("dns not between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailIsNull() {
            addCriterion("terminal_detail is null");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailIsNotNull() {
            addCriterion("terminal_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailEqualTo(String value) {
            addCriterion("terminal_detail =", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailNotEqualTo(String value) {
            addCriterion("terminal_detail <>", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailGreaterThan(String value) {
            addCriterion("terminal_detail >", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_detail >=", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailLessThan(String value) {
            addCriterion("terminal_detail <", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailLessThanOrEqualTo(String value) {
            addCriterion("terminal_detail <=", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailLike(String value) {
            addCriterion("terminal_detail like", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailNotLike(String value) {
            addCriterion("terminal_detail not like", value, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailIn(List<String> values) {
            addCriterion("terminal_detail in", values, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailNotIn(List<String> values) {
            addCriterion("terminal_detail not in", values, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailBetween(String value1, String value2) {
            addCriterion("terminal_detail between", value1, value2, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andTerminalDetailNotBetween(String value1, String value2) {
            addCriterion("terminal_detail not between", value1, value2, "terminalDetail");
            return (Criteria) this;
        }

        public Criteria andHostPortIsNull() {
            addCriterion("host_port is null");
            return (Criteria) this;
        }

        public Criteria andHostPortIsNotNull() {
            addCriterion("host_port is not null");
            return (Criteria) this;
        }

        public Criteria andHostPortEqualTo(Integer value) {
            addCriterion("host_port =", value, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortNotEqualTo(Integer value) {
            addCriterion("host_port <>", value, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortGreaterThan(Integer value) {
            addCriterion("host_port >", value, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("host_port >=", value, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortLessThan(Integer value) {
            addCriterion("host_port <", value, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortLessThanOrEqualTo(Integer value) {
            addCriterion("host_port <=", value, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortIn(List<Integer> values) {
            addCriterion("host_port in", values, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortNotIn(List<Integer> values) {
            addCriterion("host_port not in", values, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortBetween(Integer value1, Integer value2) {
            addCriterion("host_port between", value1, value2, "hostPort");
            return (Criteria) this;
        }

        public Criteria andHostPortNotBetween(Integer value1, Integer value2) {
            addCriterion("host_port not between", value1, value2, "hostPort");
            return (Criteria) this;
        }

        public Criteria andProtocolIsNull() {
            addCriterion("protocol is null");
            return (Criteria) this;
        }

        public Criteria andProtocolIsNotNull() {
            addCriterion("protocol is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolEqualTo(String value) {
            addCriterion("protocol =", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotEqualTo(String value) {
            addCriterion("protocol <>", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolGreaterThan(String value) {
            addCriterion("protocol >", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("protocol >=", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLessThan(String value) {
            addCriterion("protocol <", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLessThanOrEqualTo(String value) {
            addCriterion("protocol <=", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLike(String value) {
            addCriterion("protocol like", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotLike(String value) {
            addCriterion("protocol not like", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolIn(List<String> values) {
            addCriterion("protocol in", values, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotIn(List<String> values) {
            addCriterion("protocol not in", values, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolBetween(String value1, String value2) {
            addCriterion("protocol between", value1, value2, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotBetween(String value1, String value2) {
            addCriterion("protocol not between", value1, value2, "protocol");
            return (Criteria) this;
        }

        public Criteria andMacAddressIsNull() {
            addCriterion("mac_address is null");
            return (Criteria) this;
        }

        public Criteria andMacAddressIsNotNull() {
            addCriterion("mac_address is not null");
            return (Criteria) this;
        }

        public Criteria andMacAddressEqualTo(String value) {
            addCriterion("mac_address =", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotEqualTo(String value) {
            addCriterion("mac_address <>", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressGreaterThan(String value) {
            addCriterion("mac_address >", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mac_address >=", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLessThan(String value) {
            addCriterion("mac_address <", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLessThanOrEqualTo(String value) {
            addCriterion("mac_address <=", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLike(String value) {
            addCriterion("mac_address like", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotLike(String value) {
            addCriterion("mac_address not like", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressIn(List<String> values) {
            addCriterion("mac_address in", values, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotIn(List<String> values) {
            addCriterion("mac_address not in", values, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressBetween(String value1, String value2) {
            addCriterion("mac_address between", value1, value2, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotBetween(String value1, String value2) {
            addCriterion("mac_address not between", value1, value2, "macAddress");
            return (Criteria) this;
        }

        public Criteria andTimesDateIsNull() {
            addCriterion("times_date is null");
            return (Criteria) this;
        }

        public Criteria andTimesDateIsNotNull() {
            addCriterion("times_date is not null");
            return (Criteria) this;
        }

        public Criteria andTimesDateEqualTo(Date value) {
            addCriterionForJDBCDate("times_date =", value, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("times_date <>", value, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateGreaterThan(Date value) {
            addCriterionForJDBCDate("times_date >", value, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("times_date >=", value, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateLessThan(Date value) {
            addCriterionForJDBCDate("times_date <", value, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("times_date <=", value, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateIn(List<Date> values) {
            addCriterionForJDBCDate("times_date in", values, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("times_date not in", values, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("times_date between", value1, value2, "timesDate");
            return (Criteria) this;
        }

        public Criteria andTimesDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("times_date not between", value1, value2, "timesDate");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}