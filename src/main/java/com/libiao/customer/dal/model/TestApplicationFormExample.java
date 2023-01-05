package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestApplicationFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestApplicationFormExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            List<java.sql.Date> dateList = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQuotationNumIsNull() {
            addCriterion("quotation_num is null");
            return (Criteria) this;
        }

        public Criteria andQuotationNumIsNotNull() {
            addCriterion("quotation_num is not null");
            return (Criteria) this;
        }

        public Criteria andQuotationNumEqualTo(String value) {
            addCriterion("quotation_num =", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotEqualTo(String value) {
            addCriterion("quotation_num <>", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumGreaterThan(String value) {
            addCriterion("quotation_num >", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumGreaterThanOrEqualTo(String value) {
            addCriterion("quotation_num >=", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumLessThan(String value) {
            addCriterion("quotation_num <", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumLessThanOrEqualTo(String value) {
            addCriterion("quotation_num <=", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumLike(String value) {
            addCriterion("quotation_num like", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotLike(String value) {
            addCriterion("quotation_num not like", value, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumIn(List<String> values) {
            addCriterion("quotation_num in", values, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotIn(List<String> values) {
            addCriterion("quotation_num not in", values, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumBetween(String value1, String value2) {
            addCriterion("quotation_num between", value1, value2, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andQuotationNumNotBetween(String value1, String value2) {
            addCriterion("quotation_num not between", value1, value2, "quotationNum");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andApplicationNumIsNull() {
            addCriterion("application_num is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNumIsNotNull() {
            addCriterion("application_num is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNumEqualTo(String value) {
            addCriterion("application_num =", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumNotEqualTo(String value) {
            addCriterion("application_num <>", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumGreaterThan(String value) {
            addCriterion("application_num >", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumGreaterThanOrEqualTo(String value) {
            addCriterion("application_num >=", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumLessThan(String value) {
            addCriterion("application_num <", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumLessThanOrEqualTo(String value) {
            addCriterion("application_num <=", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumLike(String value) {
            addCriterion("application_num like", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumNotLike(String value) {
            addCriterion("application_num not like", value, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumIn(List<String> values) {
            addCriterion("application_num in", values, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumNotIn(List<String> values) {
            addCriterion("application_num not in", values, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumBetween(String value1, String value2) {
            addCriterion("application_num between", value1, value2, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNumNotBetween(String value1, String value2) {
            addCriterion("application_num not between", value1, value2, "applicationNum");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNull() {
            addCriterion("application_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNotNull() {
            addCriterion("application_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameEqualTo(String value) {
            addCriterion("application_name =", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotEqualTo(String value) {
            addCriterion("application_name <>", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThan(String value) {
            addCriterion("application_name >", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThanOrEqualTo(String value) {
            addCriterion("application_name >=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThan(String value) {
            addCriterion("application_name <", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThanOrEqualTo(String value) {
            addCriterion("application_name <=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLike(String value) {
            addCriterion("application_name like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotLike(String value) {
            addCriterion("application_name not like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIn(List<String> values) {
            addCriterion("application_name in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotIn(List<String> values) {
            addCriterion("application_name not in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameBetween(String value1, String value2) {
            addCriterion("application_name between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotBetween(String value1, String value2) {
            addCriterion("application_name not between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNull() {
            addCriterion("application_date is null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIsNotNull() {
            addCriterion("application_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationDateEqualTo(Date value) {
            addCriterionForJDBCDate("application_date =", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("application_date <>", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("application_date >", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("application_date >=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThan(Date value) {
            addCriterionForJDBCDate("application_date <", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("application_date <=", value, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateIn(List<Date> values) {
            addCriterionForJDBCDate("application_date in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("application_date not in", values, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("application_date between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andApplicationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("application_date not between", value1, value2, "applicationDate");
            return (Criteria) this;
        }

        public Criteria andSampleStatusIsNull() {
            addCriterion("sample_status is null");
            return (Criteria) this;
        }

        public Criteria andSampleStatusIsNotNull() {
            addCriterion("sample_status is not null");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEqualTo(Byte value) {
            addCriterion("sample_status =", value, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusNotEqualTo(Byte value) {
            addCriterion("sample_status <>", value, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusGreaterThan(Byte value) {
            addCriterion("sample_status >", value, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("sample_status >=", value, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusLessThan(Byte value) {
            addCriterion("sample_status <", value, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusLessThanOrEqualTo(Byte value) {
            addCriterion("sample_status <=", value, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusIn(List<Byte> values) {
            addCriterion("sample_status in", values, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusNotIn(List<Byte> values) {
            addCriterion("sample_status not in", values, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusBetween(Byte value1, Byte value2) {
            addCriterion("sample_status between", value1, value2, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("sample_status not between", value1, value2, "sampleStatus");
            return (Criteria) this;
        }

        public Criteria andSampleDateIsNull() {
            addCriterion("sample_date is null");
            return (Criteria) this;
        }

        public Criteria andSampleDateIsNotNull() {
            addCriterion("sample_date is not null");
            return (Criteria) this;
        }

        public Criteria andSampleDateEqualTo(Date value) {
            addCriterionForJDBCDate("sample_date =", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sample_date <>", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("sample_date >", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sample_date >=", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateLessThan(Date value) {
            addCriterionForJDBCDate("sample_date <", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sample_date <=", value, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateIn(List<Date> values) {
            addCriterionForJDBCDate("sample_date in", values, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sample_date not in", values, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sample_date between", value1, value2, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andSampleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sample_date not between", value1, value2, "sampleDate");
            return (Criteria) this;
        }

        public Criteria andReportAddrIsNull() {
            addCriterion("report_addr is null");
            return (Criteria) this;
        }

        public Criteria andReportAddrIsNotNull() {
            addCriterion("report_addr is not null");
            return (Criteria) this;
        }

        public Criteria andReportAddrEqualTo(String value) {
            addCriterion("report_addr =", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotEqualTo(String value) {
            addCriterion("report_addr <>", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrGreaterThan(String value) {
            addCriterion("report_addr >", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrGreaterThanOrEqualTo(String value) {
            addCriterion("report_addr >=", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrLessThan(String value) {
            addCriterion("report_addr <", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrLessThanOrEqualTo(String value) {
            addCriterion("report_addr <=", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrLike(String value) {
            addCriterion("report_addr like", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotLike(String value) {
            addCriterion("report_addr not like", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrIn(List<String> values) {
            addCriterion("report_addr in", values, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotIn(List<String> values) {
            addCriterion("report_addr not in", values, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrBetween(String value1, String value2) {
            addCriterion("report_addr between", value1, value2, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotBetween(String value1, String value2) {
            addCriterion("report_addr not between", value1, value2, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNull() {
            addCriterion("plan_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanDateIsNotNull() {
            addCriterion("plan_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanDateEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date =", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date <>", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_date >", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date >=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThan(Date value) {
            addCriterionForJDBCDate("plan_date <", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_date <=", value, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateIn(List<Date> values) {
            addCriterionForJDBCDate("plan_date in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_date not in", values, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_date between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andPlanDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_date not between", value1, value2, "planDate");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNull() {
            addCriterion("contract_status is null");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNotNull() {
            addCriterion("contract_status is not null");
            return (Criteria) this;
        }

        public Criteria andContractStatusEqualTo(Byte value) {
            addCriterion("contract_status =", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotEqualTo(Byte value) {
            addCriterion("contract_status <>", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThan(Byte value) {
            addCriterion("contract_status >", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("contract_status >=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThan(Byte value) {
            addCriterion("contract_status <", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThanOrEqualTo(Byte value) {
            addCriterion("contract_status <=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusIn(List<Byte> values) {
            addCriterion("contract_status in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotIn(List<Byte> values) {
            addCriterion("contract_status not in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusBetween(Byte value1, Byte value2) {
            addCriterion("contract_status between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("contract_status not between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNull() {
            addCriterion("review_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewIdIsNotNull() {
            addCriterion("review_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewIdEqualTo(Long value) {
            addCriterion("review_id =", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotEqualTo(Long value) {
            addCriterion("review_id <>", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThan(Long value) {
            addCriterion("review_id >", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdGreaterThanOrEqualTo(Long value) {
            addCriterion("review_id >=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThan(Long value) {
            addCriterion("review_id <", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdLessThanOrEqualTo(Long value) {
            addCriterion("review_id <=", value, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdIn(List<Long> values) {
            addCriterion("review_id in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotIn(List<Long> values) {
            addCriterion("review_id not in", values, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdBetween(Long value1, Long value2) {
            addCriterion("review_id between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewIdNotBetween(Long value1, Long value2) {
            addCriterion("review_id not between", value1, value2, "reviewId");
            return (Criteria) this;
        }

        public Criteria andReviewNameIsNull() {
            addCriterion("review_name is null");
            return (Criteria) this;
        }

        public Criteria andReviewNameIsNotNull() {
            addCriterion("review_name is not null");
            return (Criteria) this;
        }

        public Criteria andReviewNameEqualTo(String value) {
            addCriterion("review_name =", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotEqualTo(String value) {
            addCriterion("review_name <>", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameGreaterThan(String value) {
            addCriterion("review_name >", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameGreaterThanOrEqualTo(String value) {
            addCriterion("review_name >=", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameLessThan(String value) {
            addCriterion("review_name <", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameLessThanOrEqualTo(String value) {
            addCriterion("review_name <=", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameLike(String value) {
            addCriterion("review_name like", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotLike(String value) {
            addCriterion("review_name not like", value, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameIn(List<String> values) {
            addCriterion("review_name in", values, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotIn(List<String> values) {
            addCriterion("review_name not in", values, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameBetween(String value1, String value2) {
            addCriterion("review_name between", value1, value2, "reviewName");
            return (Criteria) this;
        }

        public Criteria andReviewNameNotBetween(String value1, String value2) {
            addCriterion("review_name not between", value1, value2, "reviewName");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Long value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Long value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Long value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Long value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Long value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Long> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Long> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Long value1, Long value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Long value1, Long value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIsNull() {
            addCriterion("apply_person is null");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIsNotNull() {
            addCriterion("apply_person is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPersonEqualTo(String value) {
            addCriterion("apply_person =", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonNotEqualTo(String value) {
            addCriterion("apply_person <>", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonGreaterThan(String value) {
            addCriterion("apply_person >", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("apply_person >=", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonLessThan(String value) {
            addCriterion("apply_person <", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonLessThanOrEqualTo(String value) {
            addCriterion("apply_person <=", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonLike(String value) {
            addCriterion("apply_person like", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonNotLike(String value) {
            addCriterion("apply_person not like", value, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIn(List<String> values) {
            addCriterion("apply_person in", values, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonNotIn(List<String> values) {
            addCriterion("apply_person not in", values, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonBetween(String value1, String value2) {
            addCriterion("apply_person between", value1, value2, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonNotBetween(String value1, String value2) {
            addCriterion("apply_person not between", value1, value2, "applyPerson");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdIsNull() {
            addCriterion("apply_person_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdIsNotNull() {
            addCriterion("apply_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdEqualTo(Long value) {
            addCriterion("apply_person_id =", value, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdNotEqualTo(Long value) {
            addCriterion("apply_person_id <>", value, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdGreaterThan(Long value) {
            addCriterion("apply_person_id >", value, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_person_id >=", value, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdLessThan(Long value) {
            addCriterion("apply_person_id <", value, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_person_id <=", value, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdIn(List<Long> values) {
            addCriterion("apply_person_id in", values, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdNotIn(List<Long> values) {
            addCriterion("apply_person_id not in", values, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdBetween(Long value1, Long value2) {
            addCriterion("apply_person_id between", value1, value2, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andApplyPersonIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_person_id not between", value1, value2, "applyPersonId");
            return (Criteria) this;
        }

        public Criteria andComAddrCnIsNull() {
            addCriterion("com_addr_cn is null");
            return (Criteria) this;
        }

        public Criteria andComAddrCnIsNotNull() {
            addCriterion("com_addr_cn is not null");
            return (Criteria) this;
        }

        public Criteria andComAddrCnEqualTo(String value) {
            addCriterion("com_addr_cn =", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotEqualTo(String value) {
            addCriterion("com_addr_cn <>", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnGreaterThan(String value) {
            addCriterion("com_addr_cn >", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnGreaterThanOrEqualTo(String value) {
            addCriterion("com_addr_cn >=", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnLessThan(String value) {
            addCriterion("com_addr_cn <", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnLessThanOrEqualTo(String value) {
            addCriterion("com_addr_cn <=", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnLike(String value) {
            addCriterion("com_addr_cn like", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotLike(String value) {
            addCriterion("com_addr_cn not like", value, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnIn(List<String> values) {
            addCriterion("com_addr_cn in", values, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotIn(List<String> values) {
            addCriterion("com_addr_cn not in", values, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnBetween(String value1, String value2) {
            addCriterion("com_addr_cn between", value1, value2, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrCnNotBetween(String value1, String value2) {
            addCriterion("com_addr_cn not between", value1, value2, "comAddrCn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnIsNull() {
            addCriterion("com_addr_en is null");
            return (Criteria) this;
        }

        public Criteria andComAddrEnIsNotNull() {
            addCriterion("com_addr_en is not null");
            return (Criteria) this;
        }

        public Criteria andComAddrEnEqualTo(String value) {
            addCriterion("com_addr_en =", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotEqualTo(String value) {
            addCriterion("com_addr_en <>", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnGreaterThan(String value) {
            addCriterion("com_addr_en >", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnGreaterThanOrEqualTo(String value) {
            addCriterion("com_addr_en >=", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnLessThan(String value) {
            addCriterion("com_addr_en <", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnLessThanOrEqualTo(String value) {
            addCriterion("com_addr_en <=", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnLike(String value) {
            addCriterion("com_addr_en like", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotLike(String value) {
            addCriterion("com_addr_en not like", value, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnIn(List<String> values) {
            addCriterion("com_addr_en in", values, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotIn(List<String> values) {
            addCriterion("com_addr_en not in", values, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnBetween(String value1, String value2) {
            addCriterion("com_addr_en between", value1, value2, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andComAddrEnNotBetween(String value1, String value2) {
            addCriterion("com_addr_en not between", value1, value2, "comAddrEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnIsNull() {
            addCriterion("report_title_cn is null");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnIsNotNull() {
            addCriterion("report_title_cn is not null");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnEqualTo(String value) {
            addCriterion("report_title_cn =", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnNotEqualTo(String value) {
            addCriterion("report_title_cn <>", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnGreaterThan(String value) {
            addCriterion("report_title_cn >", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnGreaterThanOrEqualTo(String value) {
            addCriterion("report_title_cn >=", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnLessThan(String value) {
            addCriterion("report_title_cn <", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnLessThanOrEqualTo(String value) {
            addCriterion("report_title_cn <=", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnLike(String value) {
            addCriterion("report_title_cn like", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnNotLike(String value) {
            addCriterion("report_title_cn not like", value, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnIn(List<String> values) {
            addCriterion("report_title_cn in", values, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnNotIn(List<String> values) {
            addCriterion("report_title_cn not in", values, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnBetween(String value1, String value2) {
            addCriterion("report_title_cn between", value1, value2, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleCnNotBetween(String value1, String value2) {
            addCriterion("report_title_cn not between", value1, value2, "reportTitleCn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnIsNull() {
            addCriterion("report_title_en is null");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnIsNotNull() {
            addCriterion("report_title_en is not null");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnEqualTo(String value) {
            addCriterion("report_title_en =", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnNotEqualTo(String value) {
            addCriterion("report_title_en <>", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnGreaterThan(String value) {
            addCriterion("report_title_en >", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnGreaterThanOrEqualTo(String value) {
            addCriterion("report_title_en >=", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnLessThan(String value) {
            addCriterion("report_title_en <", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnLessThanOrEqualTo(String value) {
            addCriterion("report_title_en <=", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnLike(String value) {
            addCriterion("report_title_en like", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnNotLike(String value) {
            addCriterion("report_title_en not like", value, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnIn(List<String> values) {
            addCriterion("report_title_en in", values, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnNotIn(List<String> values) {
            addCriterion("report_title_en not in", values, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnBetween(String value1, String value2) {
            addCriterion("report_title_en between", value1, value2, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportTitleEnNotBetween(String value1, String value2) {
            addCriterion("report_title_en not between", value1, value2, "reportTitleEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnIsNull() {
            addCriterion("report_address_cn is null");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnIsNotNull() {
            addCriterion("report_address_cn is not null");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnEqualTo(String value) {
            addCriterion("report_address_cn =", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnNotEqualTo(String value) {
            addCriterion("report_address_cn <>", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnGreaterThan(String value) {
            addCriterion("report_address_cn >", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnGreaterThanOrEqualTo(String value) {
            addCriterion("report_address_cn >=", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnLessThan(String value) {
            addCriterion("report_address_cn <", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnLessThanOrEqualTo(String value) {
            addCriterion("report_address_cn <=", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnLike(String value) {
            addCriterion("report_address_cn like", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnNotLike(String value) {
            addCriterion("report_address_cn not like", value, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnIn(List<String> values) {
            addCriterion("report_address_cn in", values, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnNotIn(List<String> values) {
            addCriterion("report_address_cn not in", values, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnBetween(String value1, String value2) {
            addCriterion("report_address_cn between", value1, value2, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressCnNotBetween(String value1, String value2) {
            addCriterion("report_address_cn not between", value1, value2, "reportAddressCn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnIsNull() {
            addCriterion("report_address_en is null");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnIsNotNull() {
            addCriterion("report_address_en is not null");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnEqualTo(String value) {
            addCriterion("report_address_en =", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnNotEqualTo(String value) {
            addCriterion("report_address_en <>", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnGreaterThan(String value) {
            addCriterion("report_address_en >", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnGreaterThanOrEqualTo(String value) {
            addCriterion("report_address_en >=", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnLessThan(String value) {
            addCriterion("report_address_en <", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnLessThanOrEqualTo(String value) {
            addCriterion("report_address_en <=", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnLike(String value) {
            addCriterion("report_address_en like", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnNotLike(String value) {
            addCriterion("report_address_en not like", value, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnIn(List<String> values) {
            addCriterion("report_address_en in", values, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnNotIn(List<String> values) {
            addCriterion("report_address_en not in", values, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnBetween(String value1, String value2) {
            addCriterion("report_address_en between", value1, value2, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andReportAddressEnNotBetween(String value1, String value2) {
            addCriterion("report_address_en not between", value1, value2, "reportAddressEn");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andCredentialIsNull() {
            addCriterion("credential is null");
            return (Criteria) this;
        }

        public Criteria andCredentialIsNotNull() {
            addCriterion("credential is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialEqualTo(Integer value) {
            addCriterion("credential =", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotEqualTo(Integer value) {
            addCriterion("credential <>", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialGreaterThan(Integer value) {
            addCriterion("credential >", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialGreaterThanOrEqualTo(Integer value) {
            addCriterion("credential >=", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialLessThan(Integer value) {
            addCriterion("credential <", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialLessThanOrEqualTo(Integer value) {
            addCriterion("credential <=", value, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialIn(List<Integer> values) {
            addCriterion("credential in", values, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotIn(List<Integer> values) {
            addCriterion("credential not in", values, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialBetween(Integer value1, Integer value2) {
            addCriterion("credential between", value1, value2, "credential");
            return (Criteria) this;
        }

        public Criteria andCredentialNotBetween(Integer value1, Integer value2) {
            addCriterion("credential not between", value1, value2, "credential");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnIsNull() {
            addCriterion("sample_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnIsNotNull() {
            addCriterion("sample_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnEqualTo(String value) {
            addCriterion("sample_name_cn =", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnNotEqualTo(String value) {
            addCriterion("sample_name_cn <>", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnGreaterThan(String value) {
            addCriterion("sample_name_cn >", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("sample_name_cn >=", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnLessThan(String value) {
            addCriterion("sample_name_cn <", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnLessThanOrEqualTo(String value) {
            addCriterion("sample_name_cn <=", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnLike(String value) {
            addCriterion("sample_name_cn like", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnNotLike(String value) {
            addCriterion("sample_name_cn not like", value, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnIn(List<String> values) {
            addCriterion("sample_name_cn in", values, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnNotIn(List<String> values) {
            addCriterion("sample_name_cn not in", values, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnBetween(String value1, String value2) {
            addCriterion("sample_name_cn between", value1, value2, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameCnNotBetween(String value1, String value2) {
            addCriterion("sample_name_cn not between", value1, value2, "sampleNameCn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnIsNull() {
            addCriterion("sample_name_en is null");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnIsNotNull() {
            addCriterion("sample_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnEqualTo(String value) {
            addCriterion("sample_name_en =", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnNotEqualTo(String value) {
            addCriterion("sample_name_en <>", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnGreaterThan(String value) {
            addCriterion("sample_name_en >", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("sample_name_en >=", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnLessThan(String value) {
            addCriterion("sample_name_en <", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnLessThanOrEqualTo(String value) {
            addCriterion("sample_name_en <=", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnLike(String value) {
            addCriterion("sample_name_en like", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnNotLike(String value) {
            addCriterion("sample_name_en not like", value, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnIn(List<String> values) {
            addCriterion("sample_name_en in", values, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnNotIn(List<String> values) {
            addCriterion("sample_name_en not in", values, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnBetween(String value1, String value2) {
            addCriterion("sample_name_en between", value1, value2, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleNameEnNotBetween(String value1, String value2) {
            addCriterion("sample_name_en not between", value1, value2, "sampleNameEn");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityIsNull() {
            addCriterion("sample_quantity is null");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityIsNotNull() {
            addCriterion("sample_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityEqualTo(String value) {
            addCriterion("sample_quantity =", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityNotEqualTo(String value) {
            addCriterion("sample_quantity <>", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityGreaterThan(String value) {
            addCriterion("sample_quantity >", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("sample_quantity >=", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityLessThan(String value) {
            addCriterion("sample_quantity <", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityLessThanOrEqualTo(String value) {
            addCriterion("sample_quantity <=", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityLike(String value) {
            addCriterion("sample_quantity like", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityNotLike(String value) {
            addCriterion("sample_quantity not like", value, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityIn(List<String> values) {
            addCriterion("sample_quantity in", values, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityNotIn(List<String> values) {
            addCriterion("sample_quantity not in", values, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityBetween(String value1, String value2) {
            addCriterion("sample_quantity between", value1, value2, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleQuantityNotBetween(String value1, String value2) {
            addCriterion("sample_quantity not between", value1, value2, "sampleQuantity");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnIsNull() {
            addCriterion("sample_model_cn is null");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnIsNotNull() {
            addCriterion("sample_model_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnEqualTo(String value) {
            addCriterion("sample_model_cn =", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnNotEqualTo(String value) {
            addCriterion("sample_model_cn <>", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnGreaterThan(String value) {
            addCriterion("sample_model_cn >", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnGreaterThanOrEqualTo(String value) {
            addCriterion("sample_model_cn >=", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnLessThan(String value) {
            addCriterion("sample_model_cn <", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnLessThanOrEqualTo(String value) {
            addCriterion("sample_model_cn <=", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnLike(String value) {
            addCriterion("sample_model_cn like", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnNotLike(String value) {
            addCriterion("sample_model_cn not like", value, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnIn(List<String> values) {
            addCriterion("sample_model_cn in", values, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnNotIn(List<String> values) {
            addCriterion("sample_model_cn not in", values, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnBetween(String value1, String value2) {
            addCriterion("sample_model_cn between", value1, value2, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelCnNotBetween(String value1, String value2) {
            addCriterion("sample_model_cn not between", value1, value2, "sampleModelCn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnIsNull() {
            addCriterion("sample_model_en is null");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnIsNotNull() {
            addCriterion("sample_model_en is not null");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnEqualTo(String value) {
            addCriterion("sample_model_en =", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnNotEqualTo(String value) {
            addCriterion("sample_model_en <>", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnGreaterThan(String value) {
            addCriterion("sample_model_en >", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnGreaterThanOrEqualTo(String value) {
            addCriterion("sample_model_en >=", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnLessThan(String value) {
            addCriterion("sample_model_en <", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnLessThanOrEqualTo(String value) {
            addCriterion("sample_model_en <=", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnLike(String value) {
            addCriterion("sample_model_en like", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnNotLike(String value) {
            addCriterion("sample_model_en not like", value, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnIn(List<String> values) {
            addCriterion("sample_model_en in", values, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnNotIn(List<String> values) {
            addCriterion("sample_model_en not in", values, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnBetween(String value1, String value2) {
            addCriterion("sample_model_en between", value1, value2, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleModelEnNotBetween(String value1, String value2) {
            addCriterion("sample_model_en not between", value1, value2, "sampleModelEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnIsNull() {
            addCriterion("sample_status_cn is null");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnIsNotNull() {
            addCriterion("sample_status_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnEqualTo(String value) {
            addCriterion("sample_status_cn =", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnNotEqualTo(String value) {
            addCriterion("sample_status_cn <>", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnGreaterThan(String value) {
            addCriterion("sample_status_cn >", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnGreaterThanOrEqualTo(String value) {
            addCriterion("sample_status_cn >=", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnLessThan(String value) {
            addCriterion("sample_status_cn <", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnLessThanOrEqualTo(String value) {
            addCriterion("sample_status_cn <=", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnLike(String value) {
            addCriterion("sample_status_cn like", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnNotLike(String value) {
            addCriterion("sample_status_cn not like", value, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnIn(List<String> values) {
            addCriterion("sample_status_cn in", values, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnNotIn(List<String> values) {
            addCriterion("sample_status_cn not in", values, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnBetween(String value1, String value2) {
            addCriterion("sample_status_cn between", value1, value2, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusCnNotBetween(String value1, String value2) {
            addCriterion("sample_status_cn not between", value1, value2, "sampleStatusCn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnIsNull() {
            addCriterion("sample_status_en is null");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnIsNotNull() {
            addCriterion("sample_status_en is not null");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnEqualTo(String value) {
            addCriterion("sample_status_en =", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnNotEqualTo(String value) {
            addCriterion("sample_status_en <>", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnGreaterThan(String value) {
            addCriterion("sample_status_en >", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnGreaterThanOrEqualTo(String value) {
            addCriterion("sample_status_en >=", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnLessThan(String value) {
            addCriterion("sample_status_en <", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnLessThanOrEqualTo(String value) {
            addCriterion("sample_status_en <=", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnLike(String value) {
            addCriterion("sample_status_en like", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnNotLike(String value) {
            addCriterion("sample_status_en not like", value, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnIn(List<String> values) {
            addCriterion("sample_status_en in", values, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnNotIn(List<String> values) {
            addCriterion("sample_status_en not in", values, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnBetween(String value1, String value2) {
            addCriterion("sample_status_en between", value1, value2, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andSampleStatusEnNotBetween(String value1, String value2) {
            addCriterion("sample_status_en not between", value1, value2, "sampleStatusEn");
            return (Criteria) this;
        }

        public Criteria andBrandCnIsNull() {
            addCriterion("brand_cn is null");
            return (Criteria) this;
        }

        public Criteria andBrandCnIsNotNull() {
            addCriterion("brand_cn is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCnEqualTo(String value) {
            addCriterion("brand_cn =", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnNotEqualTo(String value) {
            addCriterion("brand_cn <>", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnGreaterThan(String value) {
            addCriterion("brand_cn >", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnGreaterThanOrEqualTo(String value) {
            addCriterion("brand_cn >=", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnLessThan(String value) {
            addCriterion("brand_cn <", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnLessThanOrEqualTo(String value) {
            addCriterion("brand_cn <=", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnLike(String value) {
            addCriterion("brand_cn like", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnNotLike(String value) {
            addCriterion("brand_cn not like", value, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnIn(List<String> values) {
            addCriterion("brand_cn in", values, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnNotIn(List<String> values) {
            addCriterion("brand_cn not in", values, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnBetween(String value1, String value2) {
            addCriterion("brand_cn between", value1, value2, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandCnNotBetween(String value1, String value2) {
            addCriterion("brand_cn not between", value1, value2, "brandCn");
            return (Criteria) this;
        }

        public Criteria andBrandEnIsNull() {
            addCriterion("brand_en is null");
            return (Criteria) this;
        }

        public Criteria andBrandEnIsNotNull() {
            addCriterion("brand_en is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEnEqualTo(String value) {
            addCriterion("brand_en =", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnNotEqualTo(String value) {
            addCriterion("brand_en <>", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnGreaterThan(String value) {
            addCriterion("brand_en >", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnGreaterThanOrEqualTo(String value) {
            addCriterion("brand_en >=", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnLessThan(String value) {
            addCriterion("brand_en <", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnLessThanOrEqualTo(String value) {
            addCriterion("brand_en <=", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnLike(String value) {
            addCriterion("brand_en like", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnNotLike(String value) {
            addCriterion("brand_en not like", value, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnIn(List<String> values) {
            addCriterion("brand_en in", values, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnNotIn(List<String> values) {
            addCriterion("brand_en not in", values, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnBetween(String value1, String value2) {
            addCriterion("brand_en between", value1, value2, "brandEn");
            return (Criteria) this;
        }

        public Criteria andBrandEnNotBetween(String value1, String value2) {
            addCriterion("brand_en not between", value1, value2, "brandEn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnIsNull() {
            addCriterion("lot_no_cn is null");
            return (Criteria) this;
        }

        public Criteria andLotNoCnIsNotNull() {
            addCriterion("lot_no_cn is not null");
            return (Criteria) this;
        }

        public Criteria andLotNoCnEqualTo(String value) {
            addCriterion("lot_no_cn =", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnNotEqualTo(String value) {
            addCriterion("lot_no_cn <>", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnGreaterThan(String value) {
            addCriterion("lot_no_cn >", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnGreaterThanOrEqualTo(String value) {
            addCriterion("lot_no_cn >=", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnLessThan(String value) {
            addCriterion("lot_no_cn <", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnLessThanOrEqualTo(String value) {
            addCriterion("lot_no_cn <=", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnLike(String value) {
            addCriterion("lot_no_cn like", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnNotLike(String value) {
            addCriterion("lot_no_cn not like", value, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnIn(List<String> values) {
            addCriterion("lot_no_cn in", values, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnNotIn(List<String> values) {
            addCriterion("lot_no_cn not in", values, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnBetween(String value1, String value2) {
            addCriterion("lot_no_cn between", value1, value2, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoCnNotBetween(String value1, String value2) {
            addCriterion("lot_no_cn not between", value1, value2, "lotNoCn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnIsNull() {
            addCriterion("lot_no_en is null");
            return (Criteria) this;
        }

        public Criteria andLotNoEnIsNotNull() {
            addCriterion("lot_no_en is not null");
            return (Criteria) this;
        }

        public Criteria andLotNoEnEqualTo(String value) {
            addCriterion("lot_no_en =", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnNotEqualTo(String value) {
            addCriterion("lot_no_en <>", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnGreaterThan(String value) {
            addCriterion("lot_no_en >", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnGreaterThanOrEqualTo(String value) {
            addCriterion("lot_no_en >=", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnLessThan(String value) {
            addCriterion("lot_no_en <", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnLessThanOrEqualTo(String value) {
            addCriterion("lot_no_en <=", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnLike(String value) {
            addCriterion("lot_no_en like", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnNotLike(String value) {
            addCriterion("lot_no_en not like", value, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnIn(List<String> values) {
            addCriterion("lot_no_en in", values, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnNotIn(List<String> values) {
            addCriterion("lot_no_en not in", values, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnBetween(String value1, String value2) {
            addCriterion("lot_no_en between", value1, value2, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andLotNoEnNotBetween(String value1, String value2) {
            addCriterion("lot_no_en not between", value1, value2, "lotNoEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnIsNull() {
            addCriterion("specification_cn is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnIsNotNull() {
            addCriterion("specification_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnEqualTo(String value) {
            addCriterion("specification_cn =", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnNotEqualTo(String value) {
            addCriterion("specification_cn <>", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnGreaterThan(String value) {
            addCriterion("specification_cn >", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnGreaterThanOrEqualTo(String value) {
            addCriterion("specification_cn >=", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnLessThan(String value) {
            addCriterion("specification_cn <", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnLessThanOrEqualTo(String value) {
            addCriterion("specification_cn <=", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnLike(String value) {
            addCriterion("specification_cn like", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnNotLike(String value) {
            addCriterion("specification_cn not like", value, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnIn(List<String> values) {
            addCriterion("specification_cn in", values, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnNotIn(List<String> values) {
            addCriterion("specification_cn not in", values, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnBetween(String value1, String value2) {
            addCriterion("specification_cn between", value1, value2, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationCnNotBetween(String value1, String value2) {
            addCriterion("specification_cn not between", value1, value2, "specificationCn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnIsNull() {
            addCriterion("specification_en is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnIsNotNull() {
            addCriterion("specification_en is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnEqualTo(String value) {
            addCriterion("specification_en =", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnNotEqualTo(String value) {
            addCriterion("specification_en <>", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnGreaterThan(String value) {
            addCriterion("specification_en >", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnGreaterThanOrEqualTo(String value) {
            addCriterion("specification_en >=", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnLessThan(String value) {
            addCriterion("specification_en <", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnLessThanOrEqualTo(String value) {
            addCriterion("specification_en <=", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnLike(String value) {
            addCriterion("specification_en like", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnNotLike(String value) {
            addCriterion("specification_en not like", value, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnIn(List<String> values) {
            addCriterion("specification_en in", values, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnNotIn(List<String> values) {
            addCriterion("specification_en not in", values, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnBetween(String value1, String value2) {
            addCriterion("specification_en between", value1, value2, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSpecificationEnNotBetween(String value1, String value2) {
            addCriterion("specification_en not between", value1, value2, "specificationEn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnIsNull() {
            addCriterion("supplier_cn is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCnIsNotNull() {
            addCriterion("supplier_cn is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCnEqualTo(String value) {
            addCriterion("supplier_cn =", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnNotEqualTo(String value) {
            addCriterion("supplier_cn <>", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnGreaterThan(String value) {
            addCriterion("supplier_cn >", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_cn >=", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnLessThan(String value) {
            addCriterion("supplier_cn <", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnLessThanOrEqualTo(String value) {
            addCriterion("supplier_cn <=", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnLike(String value) {
            addCriterion("supplier_cn like", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnNotLike(String value) {
            addCriterion("supplier_cn not like", value, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnIn(List<String> values) {
            addCriterion("supplier_cn in", values, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnNotIn(List<String> values) {
            addCriterion("supplier_cn not in", values, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnBetween(String value1, String value2) {
            addCriterion("supplier_cn between", value1, value2, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierCnNotBetween(String value1, String value2) {
            addCriterion("supplier_cn not between", value1, value2, "supplierCn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnIsNull() {
            addCriterion("supplier_en is null");
            return (Criteria) this;
        }

        public Criteria andSupplierEnIsNotNull() {
            addCriterion("supplier_en is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEnEqualTo(String value) {
            addCriterion("supplier_en =", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnNotEqualTo(String value) {
            addCriterion("supplier_en <>", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnGreaterThan(String value) {
            addCriterion("supplier_en >", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_en >=", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnLessThan(String value) {
            addCriterion("supplier_en <", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnLessThanOrEqualTo(String value) {
            addCriterion("supplier_en <=", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnLike(String value) {
            addCriterion("supplier_en like", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnNotLike(String value) {
            addCriterion("supplier_en not like", value, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnIn(List<String> values) {
            addCriterion("supplier_en in", values, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnNotIn(List<String> values) {
            addCriterion("supplier_en not in", values, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnBetween(String value1, String value2) {
            addCriterion("supplier_en between", value1, value2, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andSupplierEnNotBetween(String value1, String value2) {
            addCriterion("supplier_en not between", value1, value2, "supplierEn");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andBuyerCnIsNull() {
            addCriterion("buyer_cn is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCnIsNotNull() {
            addCriterion("buyer_cn is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCnEqualTo(String value) {
            addCriterion("buyer_cn =", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnNotEqualTo(String value) {
            addCriterion("buyer_cn <>", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnGreaterThan(String value) {
            addCriterion("buyer_cn >", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_cn >=", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnLessThan(String value) {
            addCriterion("buyer_cn <", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnLessThanOrEqualTo(String value) {
            addCriterion("buyer_cn <=", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnLike(String value) {
            addCriterion("buyer_cn like", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnNotLike(String value) {
            addCriterion("buyer_cn not like", value, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnIn(List<String> values) {
            addCriterion("buyer_cn in", values, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnNotIn(List<String> values) {
            addCriterion("buyer_cn not in", values, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnBetween(String value1, String value2) {
            addCriterion("buyer_cn between", value1, value2, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerCnNotBetween(String value1, String value2) {
            addCriterion("buyer_cn not between", value1, value2, "buyerCn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnIsNull() {
            addCriterion("buyer_en is null");
            return (Criteria) this;
        }

        public Criteria andBuyerEnIsNotNull() {
            addCriterion("buyer_en is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerEnEqualTo(String value) {
            addCriterion("buyer_en =", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnNotEqualTo(String value) {
            addCriterion("buyer_en <>", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnGreaterThan(String value) {
            addCriterion("buyer_en >", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_en >=", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnLessThan(String value) {
            addCriterion("buyer_en <", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnLessThanOrEqualTo(String value) {
            addCriterion("buyer_en <=", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnLike(String value) {
            addCriterion("buyer_en like", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnNotLike(String value) {
            addCriterion("buyer_en not like", value, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnIn(List<String> values) {
            addCriterion("buyer_en in", values, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnNotIn(List<String> values) {
            addCriterion("buyer_en not in", values, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnBetween(String value1, String value2) {
            addCriterion("buyer_en between", value1, value2, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andBuyerEnNotBetween(String value1, String value2) {
            addCriterion("buyer_en not between", value1, value2, "buyerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnIsNull() {
            addCriterion("manufacturer_cn is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnIsNotNull() {
            addCriterion("manufacturer_cn is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnEqualTo(String value) {
            addCriterion("manufacturer_cn =", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnNotEqualTo(String value) {
            addCriterion("manufacturer_cn <>", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnGreaterThan(String value) {
            addCriterion("manufacturer_cn >", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_cn >=", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnLessThan(String value) {
            addCriterion("manufacturer_cn <", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_cn <=", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnLike(String value) {
            addCriterion("manufacturer_cn like", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnNotLike(String value) {
            addCriterion("manufacturer_cn not like", value, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnIn(List<String> values) {
            addCriterion("manufacturer_cn in", values, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnNotIn(List<String> values) {
            addCriterion("manufacturer_cn not in", values, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnBetween(String value1, String value2) {
            addCriterion("manufacturer_cn between", value1, value2, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerCnNotBetween(String value1, String value2) {
            addCriterion("manufacturer_cn not between", value1, value2, "manufacturerCn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnIsNull() {
            addCriterion("manufacturer_en is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnIsNotNull() {
            addCriterion("manufacturer_en is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnEqualTo(String value) {
            addCriterion("manufacturer_en =", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnNotEqualTo(String value) {
            addCriterion("manufacturer_en <>", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnGreaterThan(String value) {
            addCriterion("manufacturer_en >", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer_en >=", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnLessThan(String value) {
            addCriterion("manufacturer_en <", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnLessThanOrEqualTo(String value) {
            addCriterion("manufacturer_en <=", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnLike(String value) {
            addCriterion("manufacturer_en like", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnNotLike(String value) {
            addCriterion("manufacturer_en not like", value, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnIn(List<String> values) {
            addCriterion("manufacturer_en in", values, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnNotIn(List<String> values) {
            addCriterion("manufacturer_en not in", values, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnBetween(String value1, String value2) {
            addCriterion("manufacturer_en between", value1, value2, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andManufacturerEnNotBetween(String value1, String value2) {
            addCriterion("manufacturer_en not between", value1, value2, "manufacturerEn");
            return (Criteria) this;
        }

        public Criteria andExportedToIsNull() {
            addCriterion("exported_to is null");
            return (Criteria) this;
        }

        public Criteria andExportedToIsNotNull() {
            addCriterion("exported_to is not null");
            return (Criteria) this;
        }

        public Criteria andExportedToEqualTo(String value) {
            addCriterion("exported_to =", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToNotEqualTo(String value) {
            addCriterion("exported_to <>", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToGreaterThan(String value) {
            addCriterion("exported_to >", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToGreaterThanOrEqualTo(String value) {
            addCriterion("exported_to >=", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToLessThan(String value) {
            addCriterion("exported_to <", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToLessThanOrEqualTo(String value) {
            addCriterion("exported_to <=", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToLike(String value) {
            addCriterion("exported_to like", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToNotLike(String value) {
            addCriterion("exported_to not like", value, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToIn(List<String> values) {
            addCriterion("exported_to in", values, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToNotIn(List<String> values) {
            addCriterion("exported_to not in", values, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToBetween(String value1, String value2) {
            addCriterion("exported_to between", value1, value2, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andExportedToNotBetween(String value1, String value2) {
            addCriterion("exported_to not between", value1, value2, "exportedTo");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIsNull() {
            addCriterion("origin_country is null");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIsNotNull() {
            addCriterion("origin_country is not null");
            return (Criteria) this;
        }

        public Criteria andOriginCountryEqualTo(String value) {
            addCriterion("origin_country =", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotEqualTo(String value) {
            addCriterion("origin_country <>", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryGreaterThan(String value) {
            addCriterion("origin_country >", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryGreaterThanOrEqualTo(String value) {
            addCriterion("origin_country >=", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLessThan(String value) {
            addCriterion("origin_country <", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLessThanOrEqualTo(String value) {
            addCriterion("origin_country <=", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLike(String value) {
            addCriterion("origin_country like", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotLike(String value) {
            addCriterion("origin_country not like", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIn(List<String> values) {
            addCriterion("origin_country in", values, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotIn(List<String> values) {
            addCriterion("origin_country not in", values, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryBetween(String value1, String value2) {
            addCriterion("origin_country between", value1, value2, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotBetween(String value1, String value2) {
            addCriterion("origin_country not between", value1, value2, "originCountry");
            return (Criteria) this;
        }

        public Criteria andSampleDealIsNull() {
            addCriterion("sample_deal is null");
            return (Criteria) this;
        }

        public Criteria andSampleDealIsNotNull() {
            addCriterion("sample_deal is not null");
            return (Criteria) this;
        }

        public Criteria andSampleDealEqualTo(Byte value) {
            addCriterion("sample_deal =", value, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealNotEqualTo(Byte value) {
            addCriterion("sample_deal <>", value, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealGreaterThan(Byte value) {
            addCriterion("sample_deal >", value, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealGreaterThanOrEqualTo(Byte value) {
            addCriterion("sample_deal >=", value, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealLessThan(Byte value) {
            addCriterion("sample_deal <", value, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealLessThanOrEqualTo(Byte value) {
            addCriterion("sample_deal <=", value, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealIn(List<Byte> values) {
            addCriterion("sample_deal in", values, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealNotIn(List<Byte> values) {
            addCriterion("sample_deal not in", values, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealBetween(Byte value1, Byte value2) {
            addCriterion("sample_deal between", value1, value2, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andSampleDealNotBetween(Byte value1, Byte value2) {
            addCriterion("sample_deal not between", value1, value2, "sampleDeal");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNull() {
            addCriterion("review_time is null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNotNull() {
            addCriterion("review_time is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeEqualTo(Date value) {
            addCriterion("review_time =", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotEqualTo(Date value) {
            addCriterion("review_time <>", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThan(Date value) {
            addCriterion("review_time >", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("review_time >=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThan(Date value) {
            addCriterion("review_time <", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("review_time <=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIn(List<Date> values) {
            addCriterion("review_time in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotIn(List<Date> values) {
            addCriterion("review_time not in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeBetween(Date value1, Date value2) {
            addCriterion("review_time between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("review_time not between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkIsNull() {
            addCriterion("review_remark is null");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkIsNotNull() {
            addCriterion("review_remark is not null");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkEqualTo(String value) {
            addCriterion("review_remark =", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkNotEqualTo(String value) {
            addCriterion("review_remark <>", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkGreaterThan(String value) {
            addCriterion("review_remark >", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("review_remark >=", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkLessThan(String value) {
            addCriterion("review_remark <", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkLessThanOrEqualTo(String value) {
            addCriterion("review_remark <=", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkLike(String value) {
            addCriterion("review_remark like", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkNotLike(String value) {
            addCriterion("review_remark not like", value, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkIn(List<String> values) {
            addCriterion("review_remark in", values, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkNotIn(List<String> values) {
            addCriterion("review_remark not in", values, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkBetween(String value1, String value2) {
            addCriterion("review_remark between", value1, value2, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andReviewRemarkNotBetween(String value1, String value2) {
            addCriterion("review_remark not between", value1, value2, "reviewRemark");
            return (Criteria) this;
        }

        public Criteria andServiceIsNull() {
            addCriterion("service is null");
            return (Criteria) this;
        }

        public Criteria andServiceIsNotNull() {
            addCriterion("service is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEqualTo(Byte value) {
            addCriterion("service =", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotEqualTo(Byte value) {
            addCriterion("service <>", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThan(Byte value) {
            addCriterion("service >", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThanOrEqualTo(Byte value) {
            addCriterion("service >=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThan(Byte value) {
            addCriterion("service <", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThanOrEqualTo(Byte value) {
            addCriterion("service <=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceIn(List<Byte> values) {
            addCriterion("service in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotIn(List<Byte> values) {
            addCriterion("service not in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceBetween(Byte value1, Byte value2) {
            addCriterion("service between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotBetween(Byte value1, Byte value2) {
            addCriterion("service not between", value1, value2, "service");
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