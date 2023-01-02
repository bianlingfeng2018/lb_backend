package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestWorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestWorkOrderExample() {
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

        public Criteria andWorkOrderNumIsNull() {
            addCriterion("work_order_num is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIsNotNull() {
            addCriterion("work_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumEqualTo(String value) {
            addCriterion("work_order_num =", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotEqualTo(String value) {
            addCriterion("work_order_num <>", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumGreaterThan(String value) {
            addCriterion("work_order_num >", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("work_order_num >=", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLessThan(String value) {
            addCriterion("work_order_num <", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLessThanOrEqualTo(String value) {
            addCriterion("work_order_num <=", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumLike(String value) {
            addCriterion("work_order_num like", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotLike(String value) {
            addCriterion("work_order_num not like", value, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumIn(List<String> values) {
            addCriterion("work_order_num in", values, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotIn(List<String> values) {
            addCriterion("work_order_num not in", values, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumBetween(String value1, String value2) {
            addCriterion("work_order_num between", value1, value2, "workOrderNum");
            return (Criteria) this;
        }

        public Criteria andWorkOrderNumNotBetween(String value1, String value2) {
            addCriterion("work_order_num not between", value1, value2, "workOrderNum");
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

        public Criteria andOrderDateIsNull() {
            addCriterion("order_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("order_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(Date value) {
            addCriterion("order_date =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(Date value) {
            addCriterion("order_date <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(Date value) {
            addCriterion("order_date >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(Date value) {
            addCriterion("order_date >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(Date value) {
            addCriterion("order_date <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(Date value) {
            addCriterion("order_date <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<Date> values) {
            addCriterion("order_date in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<Date> values) {
            addCriterion("order_date not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(Date value1, Date value2) {
            addCriterion("order_date between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(Date value1, Date value2) {
            addCriterion("order_date not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateIsNull() {
            addCriterion("output_date is null");
            return (Criteria) this;
        }

        public Criteria andOutputDateIsNotNull() {
            addCriterion("output_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutputDateEqualTo(Date value) {
            addCriterion("output_date =", value, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateNotEqualTo(Date value) {
            addCriterion("output_date <>", value, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateGreaterThan(Date value) {
            addCriterion("output_date >", value, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateGreaterThanOrEqualTo(Date value) {
            addCriterion("output_date >=", value, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateLessThan(Date value) {
            addCriterion("output_date <", value, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateLessThanOrEqualTo(Date value) {
            addCriterion("output_date <=", value, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateIn(List<Date> values) {
            addCriterion("output_date in", values, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateNotIn(List<Date> values) {
            addCriterion("output_date not in", values, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateBetween(Date value1, Date value2) {
            addCriterion("output_date between", value1, value2, "outputDate");
            return (Criteria) this;
        }

        public Criteria andOutputDateNotBetween(Date value1, Date value2) {
            addCriterion("output_date not between", value1, value2, "outputDate");
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

        public Criteria andTestComIdIsNull() {
            addCriterion("test_com_id is null");
            return (Criteria) this;
        }

        public Criteria andTestComIdIsNotNull() {
            addCriterion("test_com_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestComIdEqualTo(Integer value) {
            addCriterion("test_com_id =", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdNotEqualTo(Integer value) {
            addCriterion("test_com_id <>", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdGreaterThan(Integer value) {
            addCriterion("test_com_id >", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_com_id >=", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdLessThan(Integer value) {
            addCriterion("test_com_id <", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_com_id <=", value, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdIn(List<Integer> values) {
            addCriterion("test_com_id in", values, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdNotIn(List<Integer> values) {
            addCriterion("test_com_id not in", values, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdBetween(Integer value1, Integer value2) {
            addCriterion("test_com_id between", value1, value2, "testComId");
            return (Criteria) this;
        }

        public Criteria andTestComIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_com_id not between", value1, value2, "testComId");
            return (Criteria) this;
        }

        public Criteria andComNameIsNull() {
            addCriterion("com_name is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("com_name is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("com_name =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("com_name <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("com_name >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("com_name >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("com_name <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("com_name <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("com_name like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("com_name not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("com_name in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("com_name not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("com_name between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("com_name not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andSubContractIsNull() {
            addCriterion("sub_contract is null");
            return (Criteria) this;
        }

        public Criteria andSubContractIsNotNull() {
            addCriterion("sub_contract is not null");
            return (Criteria) this;
        }

        public Criteria andSubContractEqualTo(Byte value) {
            addCriterion("sub_contract =", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractNotEqualTo(Byte value) {
            addCriterion("sub_contract <>", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractGreaterThan(Byte value) {
            addCriterion("sub_contract >", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractGreaterThanOrEqualTo(Byte value) {
            addCriterion("sub_contract >=", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractLessThan(Byte value) {
            addCriterion("sub_contract <", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractLessThanOrEqualTo(Byte value) {
            addCriterion("sub_contract <=", value, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractIn(List<Byte> values) {
            addCriterion("sub_contract in", values, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractNotIn(List<Byte> values) {
            addCriterion("sub_contract not in", values, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractBetween(Byte value1, Byte value2) {
            addCriterion("sub_contract between", value1, value2, "subContract");
            return (Criteria) this;
        }

        public Criteria andSubContractNotBetween(Byte value1, Byte value2) {
            addCriterion("sub_contract not between", value1, value2, "subContract");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
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

        public Criteria andConfirmIdIsNull() {
            addCriterion("confirm_id is null");
            return (Criteria) this;
        }

        public Criteria andConfirmIdIsNotNull() {
            addCriterion("confirm_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmIdEqualTo(Long value) {
            addCriterion("confirm_id =", value, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdNotEqualTo(Long value) {
            addCriterion("confirm_id <>", value, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdGreaterThan(Long value) {
            addCriterion("confirm_id >", value, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("confirm_id >=", value, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdLessThan(Long value) {
            addCriterion("confirm_id <", value, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdLessThanOrEqualTo(Long value) {
            addCriterion("confirm_id <=", value, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdIn(List<Long> values) {
            addCriterion("confirm_id in", values, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdNotIn(List<Long> values) {
            addCriterion("confirm_id not in", values, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdBetween(Long value1, Long value2) {
            addCriterion("confirm_id between", value1, value2, "confirmId");
            return (Criteria) this;
        }

        public Criteria andConfirmIdNotBetween(Long value1, Long value2) {
            addCriterion("confirm_id not between", value1, value2, "confirmId");
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