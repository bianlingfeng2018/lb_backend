package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class TestApplicationItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestApplicationItemExample() {
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

        public Criteria andAppSampleIdIsNull() {
            addCriterion("app_sample_id is null");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdIsNotNull() {
            addCriterion("app_sample_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdEqualTo(Long value) {
            addCriterion("app_sample_id =", value, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdNotEqualTo(Long value) {
            addCriterion("app_sample_id <>", value, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdGreaterThan(Long value) {
            addCriterion("app_sample_id >", value, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("app_sample_id >=", value, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdLessThan(Long value) {
            addCriterion("app_sample_id <", value, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdLessThanOrEqualTo(Long value) {
            addCriterion("app_sample_id <=", value, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdIn(List<Long> values) {
            addCriterion("app_sample_id in", values, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdNotIn(List<Long> values) {
            addCriterion("app_sample_id not in", values, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdBetween(Long value1, Long value2) {
            addCriterion("app_sample_id between", value1, value2, "appSampleId");
            return (Criteria) this;
        }

        public Criteria andAppSampleIdNotBetween(Long value1, Long value2) {
            addCriterion("app_sample_id not between", value1, value2, "appSampleId");
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

        public Criteria andTestItemIdIsNull() {
            addCriterion("test_item_id is null");
            return (Criteria) this;
        }

        public Criteria andTestItemIdIsNotNull() {
            addCriterion("test_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemIdEqualTo(Integer value) {
            addCriterion("test_item_id =", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdNotEqualTo(Integer value) {
            addCriterion("test_item_id <>", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdGreaterThan(Integer value) {
            addCriterion("test_item_id >", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_item_id >=", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdLessThan(Integer value) {
            addCriterion("test_item_id <", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_item_id <=", value, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdIn(List<Integer> values) {
            addCriterion("test_item_id in", values, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdNotIn(List<Integer> values) {
            addCriterion("test_item_id not in", values, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdBetween(Integer value1, Integer value2) {
            addCriterion("test_item_id between", value1, value2, "testItemId");
            return (Criteria) this;
        }

        public Criteria andTestItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_item_id not between", value1, value2, "testItemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andTestMethodIsNull() {
            addCriterion("test_method is null");
            return (Criteria) this;
        }

        public Criteria andTestMethodIsNotNull() {
            addCriterion("test_method is not null");
            return (Criteria) this;
        }

        public Criteria andTestMethodEqualTo(String value) {
            addCriterion("test_method =", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotEqualTo(String value) {
            addCriterion("test_method <>", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodGreaterThan(String value) {
            addCriterion("test_method >", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodGreaterThanOrEqualTo(String value) {
            addCriterion("test_method >=", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodLessThan(String value) {
            addCriterion("test_method <", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodLessThanOrEqualTo(String value) {
            addCriterion("test_method <=", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodLike(String value) {
            addCriterion("test_method like", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotLike(String value) {
            addCriterion("test_method not like", value, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodIn(List<String> values) {
            addCriterion("test_method in", values, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotIn(List<String> values) {
            addCriterion("test_method not in", values, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodBetween(String value1, String value2) {
            addCriterion("test_method between", value1, value2, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestMethodNotBetween(String value1, String value2) {
            addCriterion("test_method not between", value1, value2, "testMethod");
            return (Criteria) this;
        }

        public Criteria andTestCaseIsNull() {
            addCriterion("test_case is null");
            return (Criteria) this;
        }

        public Criteria andTestCaseIsNotNull() {
            addCriterion("test_case is not null");
            return (Criteria) this;
        }

        public Criteria andTestCaseEqualTo(String value) {
            addCriterion("test_case =", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotEqualTo(String value) {
            addCriterion("test_case <>", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseGreaterThan(String value) {
            addCriterion("test_case >", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseGreaterThanOrEqualTo(String value) {
            addCriterion("test_case >=", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseLessThan(String value) {
            addCriterion("test_case <", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseLessThanOrEqualTo(String value) {
            addCriterion("test_case <=", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseLike(String value) {
            addCriterion("test_case like", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotLike(String value) {
            addCriterion("test_case not like", value, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseIn(List<String> values) {
            addCriterion("test_case in", values, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotIn(List<String> values) {
            addCriterion("test_case not in", values, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseBetween(String value1, String value2) {
            addCriterion("test_case between", value1, value2, "testCase");
            return (Criteria) this;
        }

        public Criteria andTestCaseNotBetween(String value1, String value2) {
            addCriterion("test_case not between", value1, value2, "testCase");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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