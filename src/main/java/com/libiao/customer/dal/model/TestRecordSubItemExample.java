package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class TestRecordSubItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestRecordSubItemExample() {
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

        public Criteria andOriRecordIdIsNull() {
            addCriterion("ori_record_id is null");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdIsNotNull() {
            addCriterion("ori_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdEqualTo(Long value) {
            addCriterion("ori_record_id =", value, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdNotEqualTo(Long value) {
            addCriterion("ori_record_id <>", value, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdGreaterThan(Long value) {
            addCriterion("ori_record_id >", value, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ori_record_id >=", value, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdLessThan(Long value) {
            addCriterion("ori_record_id <", value, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("ori_record_id <=", value, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdIn(List<Long> values) {
            addCriterion("ori_record_id in", values, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdNotIn(List<Long> values) {
            addCriterion("ori_record_id not in", values, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdBetween(Long value1, Long value2) {
            addCriterion("ori_record_id between", value1, value2, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andOriRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("ori_record_id not between", value1, value2, "oriRecordId");
            return (Criteria) this;
        }

        public Criteria andSubTestItemIsNull() {
            addCriterion("sub_test_item is null");
            return (Criteria) this;
        }

        public Criteria andSubTestItemIsNotNull() {
            addCriterion("sub_test_item is not null");
            return (Criteria) this;
        }

        public Criteria andSubTestItemEqualTo(String value) {
            addCriterion("sub_test_item =", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemNotEqualTo(String value) {
            addCriterion("sub_test_item <>", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemGreaterThan(String value) {
            addCriterion("sub_test_item >", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemGreaterThanOrEqualTo(String value) {
            addCriterion("sub_test_item >=", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemLessThan(String value) {
            addCriterion("sub_test_item <", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemLessThanOrEqualTo(String value) {
            addCriterion("sub_test_item <=", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemLike(String value) {
            addCriterion("sub_test_item like", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemNotLike(String value) {
            addCriterion("sub_test_item not like", value, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemIn(List<String> values) {
            addCriterion("sub_test_item in", values, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemNotIn(List<String> values) {
            addCriterion("sub_test_item not in", values, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemBetween(String value1, String value2) {
            addCriterion("sub_test_item between", value1, value2, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andSubTestItemNotBetween(String value1, String value2) {
            addCriterion("sub_test_item not between", value1, value2, "subTestItem");
            return (Criteria) this;
        }

        public Criteria andCasIsNull() {
            addCriterion("cas is null");
            return (Criteria) this;
        }

        public Criteria andCasIsNotNull() {
            addCriterion("cas is not null");
            return (Criteria) this;
        }

        public Criteria andCasEqualTo(String value) {
            addCriterion("cas =", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasNotEqualTo(String value) {
            addCriterion("cas <>", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasGreaterThan(String value) {
            addCriterion("cas >", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasGreaterThanOrEqualTo(String value) {
            addCriterion("cas >=", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasLessThan(String value) {
            addCriterion("cas <", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasLessThanOrEqualTo(String value) {
            addCriterion("cas <=", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasLike(String value) {
            addCriterion("cas like", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasNotLike(String value) {
            addCriterion("cas not like", value, "cas");
            return (Criteria) this;
        }

        public Criteria andCasIn(List<String> values) {
            addCriterion("cas in", values, "cas");
            return (Criteria) this;
        }

        public Criteria andCasNotIn(List<String> values) {
            addCriterion("cas not in", values, "cas");
            return (Criteria) this;
        }

        public Criteria andCasBetween(String value1, String value2) {
            addCriterion("cas between", value1, value2, "cas");
            return (Criteria) this;
        }

        public Criteria andCasNotBetween(String value1, String value2) {
            addCriterion("cas not between", value1, value2, "cas");
            return (Criteria) this;
        }

        public Criteria andLimitValueIsNull() {
            addCriterion("limit_value is null");
            return (Criteria) this;
        }

        public Criteria andLimitValueIsNotNull() {
            addCriterion("limit_value is not null");
            return (Criteria) this;
        }

        public Criteria andLimitValueEqualTo(String value) {
            addCriterion("limit_value =", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueNotEqualTo(String value) {
            addCriterion("limit_value <>", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueGreaterThan(String value) {
            addCriterion("limit_value >", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueGreaterThanOrEqualTo(String value) {
            addCriterion("limit_value >=", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueLessThan(String value) {
            addCriterion("limit_value <", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueLessThanOrEqualTo(String value) {
            addCriterion("limit_value <=", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueLike(String value) {
            addCriterion("limit_value like", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueNotLike(String value) {
            addCriterion("limit_value not like", value, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueIn(List<String> values) {
            addCriterion("limit_value in", values, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueNotIn(List<String> values) {
            addCriterion("limit_value not in", values, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueBetween(String value1, String value2) {
            addCriterion("limit_value between", value1, value2, "limitValue");
            return (Criteria) this;
        }

        public Criteria andLimitValueNotBetween(String value1, String value2) {
            addCriterion("limit_value not between", value1, value2, "limitValue");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andAvgValueIsNull() {
            addCriterion("avg_value is null");
            return (Criteria) this;
        }

        public Criteria andAvgValueIsNotNull() {
            addCriterion("avg_value is not null");
            return (Criteria) this;
        }

        public Criteria andAvgValueEqualTo(String value) {
            addCriterion("avg_value =", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueNotEqualTo(String value) {
            addCriterion("avg_value <>", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueGreaterThan(String value) {
            addCriterion("avg_value >", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueGreaterThanOrEqualTo(String value) {
            addCriterion("avg_value >=", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueLessThan(String value) {
            addCriterion("avg_value <", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueLessThanOrEqualTo(String value) {
            addCriterion("avg_value <=", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueLike(String value) {
            addCriterion("avg_value like", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueNotLike(String value) {
            addCriterion("avg_value not like", value, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueIn(List<String> values) {
            addCriterion("avg_value in", values, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueNotIn(List<String> values) {
            addCriterion("avg_value not in", values, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueBetween(String value1, String value2) {
            addCriterion("avg_value between", value1, value2, "avgValue");
            return (Criteria) this;
        }

        public Criteria andAvgValueNotBetween(String value1, String value2) {
            addCriterion("avg_value not between", value1, value2, "avgValue");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNull() {
            addCriterion("test_result is null");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNotNull() {
            addCriterion("test_result is not null");
            return (Criteria) this;
        }

        public Criteria andTestResultEqualTo(String value) {
            addCriterion("test_result =", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotEqualTo(String value) {
            addCriterion("test_result <>", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThan(String value) {
            addCriterion("test_result >", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThanOrEqualTo(String value) {
            addCriterion("test_result >=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThan(String value) {
            addCriterion("test_result <", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThanOrEqualTo(String value) {
            addCriterion("test_result <=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLike(String value) {
            addCriterion("test_result like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotLike(String value) {
            addCriterion("test_result not like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultIn(List<String> values) {
            addCriterion("test_result in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotIn(List<String> values) {
            addCriterion("test_result not in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultBetween(String value1, String value2) {
            addCriterion("test_result between", value1, value2, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotBetween(String value1, String value2) {
            addCriterion("test_result not between", value1, value2, "testResult");
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