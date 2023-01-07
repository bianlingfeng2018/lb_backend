package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.List;

public class TestSubItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestSubItemExample() {
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

        public Criteria andTestItemIsNull() {
            addCriterion("test_item is null");
            return (Criteria) this;
        }

        public Criteria andTestItemIsNotNull() {
            addCriterion("test_item is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemEqualTo(String value) {
            addCriterion("test_item =", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotEqualTo(String value) {
            addCriterion("test_item <>", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThan(String value) {
            addCriterion("test_item >", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThanOrEqualTo(String value) {
            addCriterion("test_item >=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThan(String value) {
            addCriterion("test_item <", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThanOrEqualTo(String value) {
            addCriterion("test_item <=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLike(String value) {
            addCriterion("test_item like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotLike(String value) {
            addCriterion("test_item not like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemIn(List<String> values) {
            addCriterion("test_item in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotIn(List<String> values) {
            addCriterion("test_item not in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemBetween(String value1, String value2) {
            addCriterion("test_item between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotBetween(String value1, String value2) {
            addCriterion("test_item not between", value1, value2, "testItem");
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