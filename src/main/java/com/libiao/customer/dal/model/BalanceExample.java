package com.libiao.customer.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BalanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BalanceExample() {
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

        public Criteria andUnsettledAmtIsNull() {
            addCriterion("unsettled_amt is null");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtIsNotNull() {
            addCriterion("unsettled_amt is not null");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtEqualTo(Long value) {
            addCriterion("unsettled_amt =", value, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtNotEqualTo(Long value) {
            addCriterion("unsettled_amt <>", value, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtGreaterThan(Long value) {
            addCriterion("unsettled_amt >", value, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("unsettled_amt >=", value, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtLessThan(Long value) {
            addCriterion("unsettled_amt <", value, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtLessThanOrEqualTo(Long value) {
            addCriterion("unsettled_amt <=", value, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtIn(List<Long> values) {
            addCriterion("unsettled_amt in", values, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtNotIn(List<Long> values) {
            addCriterion("unsettled_amt not in", values, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtBetween(Long value1, Long value2) {
            addCriterion("unsettled_amt between", value1, value2, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andUnsettledAmtNotBetween(Long value1, Long value2) {
            addCriterion("unsettled_amt not between", value1, value2, "unsettledAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtIsNull() {
            addCriterion("balance_amt is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtIsNotNull() {
            addCriterion("balance_amt is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtEqualTo(Long value) {
            addCriterion("balance_amt =", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtNotEqualTo(Long value) {
            addCriterion("balance_amt <>", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtGreaterThan(Long value) {
            addCriterion("balance_amt >", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("balance_amt >=", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtLessThan(Long value) {
            addCriterion("balance_amt <", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtLessThanOrEqualTo(Long value) {
            addCriterion("balance_amt <=", value, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtIn(List<Long> values) {
            addCriterion("balance_amt in", values, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtNotIn(List<Long> values) {
            addCriterion("balance_amt not in", values, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtBetween(Long value1, Long value2) {
            addCriterion("balance_amt between", value1, value2, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andBalanceAmtNotBetween(Long value1, Long value2) {
            addCriterion("balance_amt not between", value1, value2, "balanceAmt");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIsNull() {
            addCriterion("credit_limit is null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIsNotNull() {
            addCriterion("credit_limit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditLimitEqualTo(Long value) {
            addCriterion("credit_limit =", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotEqualTo(Long value) {
            addCriterion("credit_limit <>", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThan(Long value) {
            addCriterion("credit_limit >", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("credit_limit >=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThan(Long value) {
            addCriterion("credit_limit <", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitLessThanOrEqualTo(Long value) {
            addCriterion("credit_limit <=", value, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitIn(List<Long> values) {
            addCriterion("credit_limit in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotIn(List<Long> values) {
            addCriterion("credit_limit not in", values, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitBetween(Long value1, Long value2) {
            addCriterion("credit_limit between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andCreditLimitNotBetween(Long value1, Long value2) {
            addCriterion("credit_limit not between", value1, value2, "creditLimit");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionIsNull() {
            addCriterion("unsettle_commission is null");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionIsNotNull() {
            addCriterion("unsettle_commission is not null");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionEqualTo(Long value) {
            addCriterion("unsettle_commission =", value, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionNotEqualTo(Long value) {
            addCriterion("unsettle_commission <>", value, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionGreaterThan(Long value) {
            addCriterion("unsettle_commission >", value, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionGreaterThanOrEqualTo(Long value) {
            addCriterion("unsettle_commission >=", value, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionLessThan(Long value) {
            addCriterion("unsettle_commission <", value, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionLessThanOrEqualTo(Long value) {
            addCriterion("unsettle_commission <=", value, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionIn(List<Long> values) {
            addCriterion("unsettle_commission in", values, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionNotIn(List<Long> values) {
            addCriterion("unsettle_commission not in", values, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionBetween(Long value1, Long value2) {
            addCriterion("unsettle_commission between", value1, value2, "unsettleCommission");
            return (Criteria) this;
        }

        public Criteria andUnsettleCommissionNotBetween(Long value1, Long value2) {
            addCriterion("unsettle_commission not between", value1, value2, "unsettleCommission");
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

        public Criteria andChangeTimeIsNull() {
            addCriterion("change_time is null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIsNotNull() {
            addCriterion("change_time is not null");
            return (Criteria) this;
        }

        public Criteria andChangeTimeEqualTo(Date value) {
            addCriterion("change_time =", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotEqualTo(Date value) {
            addCriterion("change_time <>", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThan(Date value) {
            addCriterion("change_time >", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("change_time >=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThan(Date value) {
            addCriterion("change_time <", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("change_time <=", value, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeIn(List<Date> values) {
            addCriterion("change_time in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotIn(List<Date> values) {
            addCriterion("change_time not in", values, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeBetween(Date value1, Date value2) {
            addCriterion("change_time between", value1, value2, "changeTime");
            return (Criteria) this;
        }

        public Criteria andChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("change_time not between", value1, value2, "changeTime");
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