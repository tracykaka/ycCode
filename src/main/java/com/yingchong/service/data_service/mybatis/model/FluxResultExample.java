package com.yingchong.service.data_service.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FluxResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FluxResultExample() {
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

        public Criteria andUploadIsNull() {
            addCriterion("upload is null");
            return (Criteria) this;
        }

        public Criteria andUploadIsNotNull() {
            addCriterion("upload is not null");
            return (Criteria) this;
        }

        public Criteria andUploadEqualTo(Double value) {
            addCriterion("upload =", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotEqualTo(Double value) {
            addCriterion("upload <>", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadGreaterThan(Double value) {
            addCriterion("upload >", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadGreaterThanOrEqualTo(Double value) {
            addCriterion("upload >=", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadLessThan(Double value) {
            addCriterion("upload <", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadLessThanOrEqualTo(Double value) {
            addCriterion("upload <=", value, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadIn(List<Double> values) {
            addCriterion("upload in", values, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotIn(List<Double> values) {
            addCriterion("upload not in", values, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadBetween(Double value1, Double value2) {
            addCriterion("upload between", value1, value2, "upload");
            return (Criteria) this;
        }

        public Criteria andUploadNotBetween(Double value1, Double value2) {
            addCriterion("upload not between", value1, value2, "upload");
            return (Criteria) this;
        }

        public Criteria andDownloadIsNull() {
            addCriterion("download is null");
            return (Criteria) this;
        }

        public Criteria andDownloadIsNotNull() {
            addCriterion("download is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadEqualTo(Double value) {
            addCriterion("download =", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotEqualTo(Double value) {
            addCriterion("download <>", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadGreaterThan(Double value) {
            addCriterion("download >", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadGreaterThanOrEqualTo(Double value) {
            addCriterion("download >=", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadLessThan(Double value) {
            addCriterion("download <", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadLessThanOrEqualTo(Double value) {
            addCriterion("download <=", value, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadIn(List<Double> values) {
            addCriterion("download in", values, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotIn(List<Double> values) {
            addCriterion("download not in", values, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadBetween(Double value1, Double value2) {
            addCriterion("download between", value1, value2, "download");
            return (Criteria) this;
        }

        public Criteria andDownloadNotBetween(Double value1, Double value2) {
            addCriterion("download not between", value1, value2, "download");
            return (Criteria) this;
        }

        public Criteria andFluxDateIsNull() {
            addCriterion("flux_date is null");
            return (Criteria) this;
        }

        public Criteria andFluxDateIsNotNull() {
            addCriterion("flux_date is not null");
            return (Criteria) this;
        }

        public Criteria andFluxDateEqualTo(Date value) {
            addCriterionForJDBCDate("flux_date =", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("flux_date <>", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateGreaterThan(Date value) {
            addCriterionForJDBCDate("flux_date >", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("flux_date >=", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateLessThan(Date value) {
            addCriterionForJDBCDate("flux_date <", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("flux_date <=", value, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateIn(List<Date> values) {
            addCriterionForJDBCDate("flux_date in", values, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("flux_date not in", values, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("flux_date between", value1, value2, "fluxDate");
            return (Criteria) this;
        }

        public Criteria andFluxDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("flux_date not between", value1, value2, "fluxDate");
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