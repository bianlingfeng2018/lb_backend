package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientBillIncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientBillIncomeExample() {
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

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andOprationTypeIsNull() {
            addCriterion("opration_type is null");
            return (Criteria) this;
        }

        public Criteria andOprationTypeIsNotNull() {
            addCriterion("opration_type is not null");
            return (Criteria) this;
        }

        public Criteria andOprationTypeEqualTo(String value) {
            addCriterion("opration_type =", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeNotEqualTo(String value) {
            addCriterion("opration_type <>", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeGreaterThan(String value) {
            addCriterion("opration_type >", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("opration_type >=", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeLessThan(String value) {
            addCriterion("opration_type <", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeLessThanOrEqualTo(String value) {
            addCriterion("opration_type <=", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeLike(String value) {
            addCriterion("opration_type like", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeNotLike(String value) {
            addCriterion("opration_type not like", value, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeIn(List<String> values) {
            addCriterion("opration_type in", values, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeNotIn(List<String> values) {
            addCriterion("opration_type not in", values, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeBetween(String value1, String value2) {
            addCriterion("opration_type between", value1, value2, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOprationTypeNotBetween(String value1, String value2) {
            addCriterion("opration_type not between", value1, value2, "oprationType");
            return (Criteria) this;
        }

        public Criteria andOriginAmountIsNull() {
            addCriterion("origin_amount is null");
            return (Criteria) this;
        }

        public Criteria andOriginAmountIsNotNull() {
            addCriterion("origin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOriginAmountEqualTo(Long value) {
            addCriterion("origin_amount =", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountNotEqualTo(Long value) {
            addCriterion("origin_amount <>", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountGreaterThan(Long value) {
            addCriterion("origin_amount >", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("origin_amount >=", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountLessThan(Long value) {
            addCriterion("origin_amount <", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountLessThanOrEqualTo(Long value) {
            addCriterion("origin_amount <=", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountIn(List<Long> values) {
            addCriterion("origin_amount in", values, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountNotIn(List<Long> values) {
            addCriterion("origin_amount not in", values, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountBetween(Long value1, Long value2) {
            addCriterion("origin_amount between", value1, value2, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountNotBetween(Long value1, Long value2) {
            addCriterion("origin_amount not between", value1, value2, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountIsNull() {
            addCriterion("operation_amount is null");
            return (Criteria) this;
        }

        public Criteria andOperationAmountIsNotNull() {
            addCriterion("operation_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOperationAmountEqualTo(Long value) {
            addCriterion("operation_amount =", value, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountNotEqualTo(Long value) {
            addCriterion("operation_amount <>", value, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountGreaterThan(Long value) {
            addCriterion("operation_amount >", value, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_amount >=", value, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountLessThan(Long value) {
            addCriterion("operation_amount <", value, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountLessThanOrEqualTo(Long value) {
            addCriterion("operation_amount <=", value, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountIn(List<Long> values) {
            addCriterion("operation_amount in", values, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountNotIn(List<Long> values) {
            addCriterion("operation_amount not in", values, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountBetween(Long value1, Long value2) {
            addCriterion("operation_amount between", value1, value2, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andOperationAmountNotBetween(Long value1, Long value2) {
            addCriterion("operation_amount not between", value1, value2, "operationAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountIsNull() {
            addCriterion("final_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinalAmountIsNotNull() {
            addCriterion("final_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinalAmountEqualTo(Long value) {
            addCriterion("final_amount =", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotEqualTo(Long value) {
            addCriterion("final_amount <>", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountGreaterThan(Long value) {
            addCriterion("final_amount >", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("final_amount >=", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountLessThan(Long value) {
            addCriterion("final_amount <", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountLessThanOrEqualTo(Long value) {
            addCriterion("final_amount <=", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountIn(List<Long> values) {
            addCriterion("final_amount in", values, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotIn(List<Long> values) {
            addCriterion("final_amount not in", values, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountBetween(Long value1, Long value2) {
            addCriterion("final_amount between", value1, value2, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotBetween(Long value1, Long value2) {
            addCriterion("final_amount not between", value1, value2, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperUserIsNull() {
            addCriterion("oper_user is null");
            return (Criteria) this;
        }

        public Criteria andOperUserIsNotNull() {
            addCriterion("oper_user is not null");
            return (Criteria) this;
        }

        public Criteria andOperUserEqualTo(String value) {
            addCriterion("oper_user =", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotEqualTo(String value) {
            addCriterion("oper_user <>", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserGreaterThan(String value) {
            addCriterion("oper_user >", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserGreaterThanOrEqualTo(String value) {
            addCriterion("oper_user >=", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserLessThan(String value) {
            addCriterion("oper_user <", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserLessThanOrEqualTo(String value) {
            addCriterion("oper_user <=", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserLike(String value) {
            addCriterion("oper_user like", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotLike(String value) {
            addCriterion("oper_user not like", value, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserIn(List<String> values) {
            addCriterion("oper_user in", values, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotIn(List<String> values) {
            addCriterion("oper_user not in", values, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserBetween(String value1, String value2) {
            addCriterion("oper_user between", value1, value2, "operUser");
            return (Criteria) this;
        }

        public Criteria andOperUserNotBetween(String value1, String value2) {
            addCriterion("oper_user not between", value1, value2, "operUser");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
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